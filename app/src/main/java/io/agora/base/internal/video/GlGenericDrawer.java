package io.agora.base.internal.video;

import android.opengl.GLES20;
import androidx.annotation.Nullable;
import io.agora.base.VideoFrame;
import io.agora.base.internal.video.RendererCommon;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* loaded from: classes4.dex */
public class GlGenericDrawer implements RendererCommon.GlDrawer {
    private static final String DEFAULT_VERTEX_SHADER_STRING = "varying vec2 tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\nuniform mat4 tex_mat;\nvoid main() {\n  gl_Position = in_pos;\n  tc = (tex_mat * in_tc).xy;\n}\n";
    private static final String INPUT_TEXTURE_COORDINATE_NAME = "in_tc";
    private static final String INPUT_VERTEX_COORDINATE_NAME = "in_pos";
    private static final String TEXTURE_MATRIX_NAME = "tex_mat";

    @Nullable
    private GlShader currentShader;

    @Nullable
    private ShaderType currentShaderType;
    private final String genericFragmentSource;
    private int inPosLocation;
    private int inTcLocation;
    private final ShaderCallbacks shaderCallbacks;
    private int texMatrixLocation;
    private FloatBuffer textureCropCoord;
    private final String vertexShader;
    private static float[] g_color601_full = {1.0f, 1.0f, 1.0f, 0.0f, -0.344136f, 1.772f, 1.402f, -0.714136f, 0.0f};
    private static float[] g_color601_limit = {1.164384f, 1.164384f, 1.164384f, 0.0f, -0.391762f, 2.017232f, 1.596027f, -0.812968f, 0.0f};
    private static float[] g_color709_full = {1.0f, 1.0f, 1.0f, 0.0f, -0.187324f, 1.8556f, 1.5748f, -0.468124f, 0.0f};
    private static float[] g_color709_limit = {1.164384f, 1.164384f, 1.164384f, 0.0f, -0.213249f, 2.112402f, 1.792741f, -0.532909f, 0.0f};
    private static float[] g_color2020_full = {1.0f, 1.0f, 1.0f, 0.0f, -0.164553f, 1.8814f, 1.4746f, -0.571353f, 0.0f};
    private static float[] g_color2020_limit = {1.164384f, 1.164384f, 1.164384f, 0.0f, -0.187326f, 2.141772f, 1.678674f, -0.650424f, 0.0f};
    private static final FloatBuffer FULL_RECTANGLE_BUFFER = GlUtil.createFloatBuffer(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
    private static final FloatBuffer FULL_RECTANGLE_TEXTURE_BUFFER = GlUtil.createFloatBuffer(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});

    /* renamed from: io.agora.base.internal.video.GlGenericDrawer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$io$agora$base$VideoFrame$ColorSpace$Matrix;

        static {
            int[] iArr = new int[VideoFrame.ColorSpace.Matrix.values().length];
            $SwitchMap$io$agora$base$VideoFrame$ColorSpace$Matrix = iArr;
            try {
                iArr[VideoFrame.ColorSpace.Matrix.SMPTE170M.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$agora$base$VideoFrame$ColorSpace$Matrix[VideoFrame.ColorSpace.Matrix.BT470BG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$agora$base$VideoFrame$ColorSpace$Matrix[VideoFrame.ColorSpace.Matrix.BT709.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$agora$base$VideoFrame$ColorSpace$Matrix[VideoFrame.ColorSpace.Matrix.BT2020_NCL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$agora$base$VideoFrame$ColorSpace$Matrix[VideoFrame.ColorSpace.Matrix.BT2020_CL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$agora$base$VideoFrame$ColorSpace$Matrix[VideoFrame.ColorSpace.Matrix.Unspecified.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public interface ShaderCallbacks {
        void onNewShader(GlShader glShader);

        void onPrepareShader(GlShader glShader, float[] fArr, int i, int i2, int i3, int i4);
    }

    public enum ShaderType {
        OES,
        RGB,
        YUV
    }

    public GlGenericDrawer(String str, ShaderCallbacks shaderCallbacks) {
        this(DEFAULT_VERTEX_SHADER_STRING, str, shaderCallbacks);
    }

    public static String createFragmentShaderString(String str, ShaderType shaderType, VideoFrame.ColorSpace colorSpace) {
        StringBuilder sb = new StringBuilder();
        ShaderType shaderType2 = ShaderType.OES;
        if (shaderType == shaderType2) {
            sb.append("#extension GL_OES_EGL_image_external : require\n");
        }
        sb.append("precision mediump float;\n");
        sb.append("varying vec2 tc;\n");
        if (shaderType == ShaderType.YUV) {
            sb.append("uniform mat3 colorMatrix;\n");
            sb.append("uniform sampler2D y_tex;\n");
            sb.append("uniform sampler2D u_tex;\n");
            sb.append("uniform sampler2D v_tex;\n");
            sb.append("highp vec3 yuv,rgb;\n");
            sb.append("vec4 sample(vec2 p) {\n");
            if (colorSpace == null || colorSpace.getRange() != VideoFrame.ColorSpace.Range.Full) {
                sb.append("  yuv[0] = clamp(texture2D(y_tex, p).r, 0.0, 1.0) - 0.0627;\n");
            } else {
                sb.append("  yuv[0] = clamp(texture2D(y_tex, p).r, 0.0, 1.0);\n");
            }
            sb.append("  yuv[1] = clamp(texture2D(u_tex, p).r - 0.5, -0.5, 0.5);\n");
            sb.append("  yuv[2] = clamp(texture2D(v_tex, p).r - 0.5, -0.5, 0.5);\n");
            sb.append("  rgb = colorMatrix * yuv;\n");
            sb.append("  return vec4(rgb, 1.0);\n");
            sb.append("}\n");
            sb.append(str);
        } else {
            String str2 = shaderType == shaderType2 ? "samplerExternalOES" : "sampler2D";
            sb.append("uniform ");
            sb.append(str2);
            sb.append(" tex;\n");
            sb.append(str.replace("sample(", "texture2D(tex, "));
        }
        return sb.toString();
    }

    private void prepareShader(ShaderType shaderType, float[] fArr, int i, int i2, int i3, int i4) {
        prepareShader(shaderType, fArr, i, i2, i3, i4, null);
    }

    public GlShader createShader(ShaderType shaderType, VideoFrame.ColorSpace colorSpace) {
        return new GlShader(this.vertexShader, createFragmentShaderString(this.genericFragmentSource, shaderType, colorSpace));
    }

    @Override // io.agora.base.internal.video.RendererCommon.GlDrawer
    public void drawOes(int i, float[] fArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        prepareShader(ShaderType.OES, fArr, i2, i3, i6, i7);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i);
        GLES20.glViewport(i4, i5, i6, i7);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindTexture(36197, 0);
    }

    @Override // io.agora.base.internal.video.RendererCommon.GlDrawer
    public void drawRgb(int i, float[] fArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        prepareShader(ShaderType.RGB, fArr, i2, i3, i6, i7);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glViewport(i4, i5, i6, i7);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindTexture(3553, 0);
    }

    @Override // io.agora.base.internal.video.RendererCommon.GlDrawer
    public void drawYuv(int[] iArr, float[] fArr, int i, int i2, int i3, int i4, int i5, int i6) {
        drawYuv(iArr, fArr, i, i2, i3, i4, i5, i6, null);
    }

    @Override // io.agora.base.internal.video.RendererCommon.GlDrawer
    public void release() {
        GlShader glShader = this.currentShader;
        if (glShader != null) {
            glShader.release();
            this.currentShader = null;
            this.currentShaderType = null;
        }
    }

    @Override // io.agora.base.internal.video.RendererCommon.GlDrawer
    public void setTextureCropCoord(FloatBuffer floatBuffer) {
        if (floatBuffer != null) {
            this.textureCropCoord = floatBuffer;
        }
    }

    public GlGenericDrawer(String str, String str2, ShaderCallbacks shaderCallbacks) {
        this.vertexShader = str;
        this.genericFragmentSource = str2;
        this.shaderCallbacks = shaderCallbacks;
    }

    private void prepareShader(ShaderType shaderType, float[] fArr, int i, int i2, int i3, int i4, VideoFrame.ColorSpace colorSpace) {
        GlShader glShader;
        FloatBuffer floatBufferWrap;
        if (shaderType.equals(this.currentShaderType)) {
            glShader = this.currentShader;
        } else {
            this.currentShaderType = shaderType;
            GlShader glShader2 = this.currentShader;
            if (glShader2 != null) {
                glShader2.release();
            }
            GlShader glShaderCreateShader = createShader(shaderType, colorSpace);
            this.currentShader = glShaderCreateShader;
            glShaderCreateShader.useProgram();
            if (shaderType == ShaderType.YUV) {
                GLES20.glUniform1i(glShaderCreateShader.getUniformLocation("y_tex"), 0);
                GLES20.glUniform1i(glShaderCreateShader.getUniformLocation("u_tex"), 1);
                GLES20.glUniform1i(glShaderCreateShader.getUniformLocation("v_tex"), 2);
                if (colorSpace != null) {
                    VideoFrame.ColorSpace.Range range = colorSpace.getRange();
                    switch (AnonymousClass1.$SwitchMap$io$agora$base$VideoFrame$ColorSpace$Matrix[colorSpace.getMatrix().ordinal()]) {
                        case 1:
                        case 2:
                            if (range != VideoFrame.ColorSpace.Range.Full) {
                                floatBufferWrap = FloatBuffer.wrap(g_color601_limit);
                                break;
                            } else {
                                floatBufferWrap = FloatBuffer.wrap(g_color601_full);
                                break;
                            }
                        case 3:
                            if (range != VideoFrame.ColorSpace.Range.Full) {
                                floatBufferWrap = FloatBuffer.wrap(g_color709_limit);
                                break;
                            } else {
                                floatBufferWrap = FloatBuffer.wrap(g_color709_full);
                                break;
                            }
                        case 4:
                        case 5:
                            if (range != VideoFrame.ColorSpace.Range.Full) {
                                floatBufferWrap = FloatBuffer.wrap(g_color2020_limit);
                                break;
                            } else {
                                floatBufferWrap = FloatBuffer.wrap(g_color2020_full);
                                break;
                            }
                        case 6:
                            floatBufferWrap = FloatBuffer.wrap(g_color601_limit);
                            break;
                        default:
                            if (range != VideoFrame.ColorSpace.Range.Full) {
                                floatBufferWrap = FloatBuffer.wrap(g_color709_limit);
                                break;
                            } else {
                                floatBufferWrap = FloatBuffer.wrap(g_color709_full);
                                break;
                            }
                    }
                } else {
                    floatBufferWrap = FloatBuffer.wrap(g_color601_limit);
                }
                GLES20.glUniformMatrix3fv(glShaderCreateShader.getUniformLocation("colorMatrix"), 1, false, floatBufferWrap);
            } else {
                GLES20.glUniform1i(glShaderCreateShader.getUniformLocation("tex"), 0);
            }
            GlUtil.checkNoGLES2Error("Create shader");
            this.shaderCallbacks.onNewShader(glShaderCreateShader);
            this.texMatrixLocation = glShaderCreateShader.getUniformLocation(TEXTURE_MATRIX_NAME);
            this.inPosLocation = glShaderCreateShader.getAttribLocation(INPUT_VERTEX_COORDINATE_NAME);
            this.inTcLocation = glShaderCreateShader.getAttribLocation(INPUT_TEXTURE_COORDINATE_NAME);
            glShader = glShaderCreateShader;
        }
        glShader.useProgram();
        GLES20.glEnableVertexAttribArray(this.inPosLocation);
        GLES20.glVertexAttribPointer(this.inPosLocation, 2, 5126, false, 0, (Buffer) FULL_RECTANGLE_BUFFER);
        GLES20.glEnableVertexAttribArray(this.inTcLocation);
        FloatBuffer floatBuffer = this.textureCropCoord;
        if (floatBuffer != null) {
            GLES20.glVertexAttribPointer(this.inTcLocation, 2, 5126, false, 0, (Buffer) floatBuffer);
        } else {
            GLES20.glVertexAttribPointer(this.inTcLocation, 2, 5126, false, 0, (Buffer) FULL_RECTANGLE_TEXTURE_BUFFER);
        }
        GLES20.glUniformMatrix4fv(this.texMatrixLocation, 1, false, fArr, 0);
        this.shaderCallbacks.onPrepareShader(glShader, fArr, i, i2, i3, i4);
        GlUtil.checkNoGLES2Error("Prepare shader");
    }

    @Override // io.agora.base.internal.video.RendererCommon.GlDrawer
    public void drawYuv(int[] iArr, float[] fArr, int i, int i2, int i3, int i4, int i5, int i6, VideoFrame.ColorSpace colorSpace) {
        prepareShader(ShaderType.YUV, fArr, i, i2, i5, i6, colorSpace);
        for (int i7 = 0; i7 < 3; i7++) {
            GLES20.glActiveTexture(33984 + i7);
            GLES20.glBindTexture(3553, iArr[i7]);
        }
        GLES20.glViewport(i3, i4, i5, i6);
        GLES20.glDrawArrays(5, 0, 4);
        for (int i8 = 0; i8 < 3; i8++) {
            GLES20.glActiveTexture(i8 + 33984);
            GLES20.glBindTexture(3553, 0);
        }
    }

    public GlGenericDrawer(String str, String str2, FloatBuffer floatBuffer, ShaderCallbacks shaderCallbacks) {
        this.vertexShader = str;
        this.genericFragmentSource = str2;
        this.textureCropCoord = floatBuffer;
        this.shaderCallbacks = shaderCallbacks;
    }
}
