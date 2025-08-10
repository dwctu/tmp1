package io.agora.base.internal.video;

import android.opengl.GLES20;
import io.agora.base.VideoFrame;
import io.agora.base.internal.CalledByNative;
import io.agora.base.internal.ThreadUtils;
import io.agora.base.internal.video.GlGenericDrawer;

/* loaded from: classes4.dex */
public class YuvConverter {
    private static final boolean DEBUG = false;
    private static final String FRAGMENT_SHADER = "uniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 1.5 * xUnit).rgb);\n}\n";
    private static boolean enableConvertPerLog = false;
    private static boolean enablePboOpt = true;
    private long convertTimeCounter;
    private long convertTimeInNS;
    private final GlGenericDrawer drawer;
    private final GPUPBOUtil gpupboUtil;
    private final GlTextureFrameBuffer i420TextureFrameBuffer;
    private final ShaderCallbacks shaderCallbacks;
    private final ThreadUtils.ThreadChecker threadChecker;

    public static class ShaderCallbacks implements GlGenericDrawer.ShaderCallbacks {
        private float[] coeffs;
        private int coeffsLoc;
        private VideoFrame.ColorSpace colorSpace;
        private float stepSize;
        private int xUnitLoc;
        private static final float[] Y_COEFFS_BIT601_LIMIT = {0.256788f, 0.504129f, 0.0979059f, 0.0627451f};
        private static final float[] U_COEFFS_BIT601_LIMIT = {-0.148223f, -0.290993f, 0.439216f, 0.501961f};
        private static final float[] V_COEFFS_BIT601_LIMIT = {0.439216f, -0.367788f, -0.0714274f, 0.501961f};
        private static final float[] Y_COEFFS_BIT601_FULL = {0.299f, 0.587f, 0.114f, 0.0f};
        private static final float[] U_COEFFS_BIT601_FULL = {-0.168736f, -0.331264f, 0.5f, 0.5f};
        private static final float[] V_COEFFS_BIT601_FULL = {0.5f, -0.418688f, -0.0813124f, 0.5f};
        private static final float[] Y_COEFFS_BIT709_LIMIT = {0.183f, 0.614f, 0.062f, 0.0627451f};
        private static final float[] U_COEFFS_BIT709_LIMIT = {-0.101f, -0.339f, 0.439f, 0.5f};
        private static final float[] V_COEFFS_BIT709_LIMIT = {0.439f, -0.399f, -0.04f, 0.5f};
        private static final float[] Y_COEFFS_BIT709_FULL = {0.2126f, 0.7154f, 0.072f, 0.0f};
        private static final float[] U_COEFFS_BIT709_FULL = {-0.1145f, -0.3855f, 0.5f, 0.5f};
        private static final float[] V_COEFFS_BIT709_FULL = {0.5f, -0.4543f, -0.0457f, 0.5f};

        private ShaderCallbacks() {
            this.colorSpace = new WrappedNativeColorSpace(VideoFrame.ColorSpace.Range.Full.getRange(), VideoFrame.ColorSpace.Matrix.SMPTE170M.getMatrix(), VideoFrame.ColorSpace.Transfer.SMPTE170M.getTransfer(), VideoFrame.ColorSpace.Primary.kSMPTE170M.getPrimary());
        }

        @Override // io.agora.base.internal.video.GlGenericDrawer.ShaderCallbacks
        public void onNewShader(GlShader glShader) {
            this.xUnitLoc = glShader.getUniformLocation("xUnit");
            this.coeffsLoc = glShader.getUniformLocation("coeffs");
        }

        @Override // io.agora.base.internal.video.GlGenericDrawer.ShaderCallbacks
        public void onPrepareShader(GlShader glShader, float[] fArr, int i, int i2, int i3, int i4) {
            GLES20.glUniform4fv(this.coeffsLoc, 1, this.coeffs, 0);
            int i5 = this.xUnitLoc;
            float f = this.stepSize;
            float f2 = i;
            GLES20.glUniform2f(i5, (fArr[0] * f) / f2, (f * fArr[1]) / f2);
        }

        public void setColorSpace(VideoFrame.ColorSpace colorSpace) {
            if (colorSpace != null) {
                this.colorSpace = colorSpace;
            }
        }

        public void setPlaneU() {
            this.stepSize = 2.0f;
            if (this.colorSpace.getRange() == VideoFrame.ColorSpace.Range.Full) {
                this.coeffs = this.colorSpace.getMatrix() == VideoFrame.ColorSpace.Matrix.BT709 ? U_COEFFS_BIT709_FULL : U_COEFFS_BIT601_FULL;
            } else {
                this.coeffs = this.colorSpace.getMatrix() == VideoFrame.ColorSpace.Matrix.BT709 ? U_COEFFS_BIT709_LIMIT : U_COEFFS_BIT601_LIMIT;
            }
        }

        public void setPlaneV() {
            this.stepSize = 2.0f;
            if (this.colorSpace.getRange() == VideoFrame.ColorSpace.Range.Full) {
                this.coeffs = this.colorSpace.getMatrix() == VideoFrame.ColorSpace.Matrix.BT709 ? V_COEFFS_BIT709_FULL : V_COEFFS_BIT601_FULL;
            } else {
                this.coeffs = this.colorSpace.getMatrix() == VideoFrame.ColorSpace.Matrix.BT709 ? V_COEFFS_BIT709_LIMIT : V_COEFFS_BIT601_LIMIT;
            }
        }

        public void setPlaneY() {
            this.stepSize = 1.0f;
            if (this.colorSpace.getRange() == VideoFrame.ColorSpace.Range.Full) {
                this.coeffs = this.colorSpace.getMatrix() == VideoFrame.ColorSpace.Matrix.BT709 ? Y_COEFFS_BIT709_FULL : Y_COEFFS_BIT601_FULL;
            } else {
                this.coeffs = this.colorSpace.getMatrix() == VideoFrame.ColorSpace.Matrix.BT709 ? Y_COEFFS_BIT709_LIMIT : Y_COEFFS_BIT601_LIMIT;
            }
        }
    }

    public YuvConverter() {
        ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();
        this.threadChecker = threadChecker;
        this.i420TextureFrameBuffer = new GlTextureFrameBuffer(6408);
        ShaderCallbacks shaderCallbacks = new ShaderCallbacks();
        this.shaderCallbacks = shaderCallbacks;
        this.drawer = new GlGenericDrawer(FRAGMENT_SHADER, shaderCallbacks);
        this.gpupboUtil = new GPUPBOUtil();
        this.convertTimeInNS = 0L;
        this.convertTimeCounter = 0L;
        threadChecker.detachThread();
    }

    @CalledByNative
    public static void setEnableConvertPerLog(boolean z) {
        enableConvertPerLog = z;
    }

    @CalledByNative
    public static void setEnablePboOpt(boolean z) {
        enablePboOpt = z;
    }

    public VideoFrame.I420Buffer convert(VideoFrame.TextureBuffer textureBuffer) {
        return convert(textureBuffer, null);
    }

    public void release() {
        this.threadChecker.checkIsOnValidThread();
        this.drawer.release();
        this.i420TextureFrameBuffer.release();
        this.gpupboUtil.release();
        this.threadChecker.detachThread();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.agora.base.VideoFrame.I420Buffer convert(io.agora.base.VideoFrame.TextureBuffer r24, @androidx.annotation.Nullable io.agora.base.VideoFrame.ColorSpace r25) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.base.internal.video.YuvConverter.convert(io.agora.base.VideoFrame$TextureBuffer, io.agora.base.VideoFrame$ColorSpace):io.agora.base.VideoFrame$I420Buffer");
    }
}
