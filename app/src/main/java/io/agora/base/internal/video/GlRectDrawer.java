package io.agora.base.internal.video;

import io.agora.base.VideoFrame;
import io.agora.base.internal.video.GlGenericDrawer;
import java.nio.FloatBuffer;

/* loaded from: classes4.dex */
public class GlRectDrawer extends GlGenericDrawer {
    private static final String FRAGMENT_SHADER = "void main() {\n  gl_FragColor = sample(tc);\n}\n";

    public static class ShaderCallbacks implements GlGenericDrawer.ShaderCallbacks {
        private ShaderCallbacks() {
        }

        @Override // io.agora.base.internal.video.GlGenericDrawer.ShaderCallbacks
        public void onNewShader(GlShader glShader) {
        }

        @Override // io.agora.base.internal.video.GlGenericDrawer.ShaderCallbacks
        public void onPrepareShader(GlShader glShader, float[] fArr, int i, int i2, int i3, int i4) {
        }
    }

    public GlRectDrawer() {
        super(FRAGMENT_SHADER, new ShaderCallbacks());
    }

    @Override // io.agora.base.internal.video.GlGenericDrawer, io.agora.base.internal.video.RendererCommon.GlDrawer
    public /* bridge */ /* synthetic */ void drawOes(int i, float[] fArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        super.drawOes(i, fArr, i2, i3, i4, i5, i6, i7);
    }

    @Override // io.agora.base.internal.video.GlGenericDrawer, io.agora.base.internal.video.RendererCommon.GlDrawer
    public /* bridge */ /* synthetic */ void drawRgb(int i, float[] fArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        super.drawRgb(i, fArr, i2, i3, i4, i5, i6, i7);
    }

    @Override // io.agora.base.internal.video.GlGenericDrawer, io.agora.base.internal.video.RendererCommon.GlDrawer
    public /* bridge */ /* synthetic */ void drawYuv(int[] iArr, float[] fArr, int i, int i2, int i3, int i4, int i5, int i6) {
        super.drawYuv(iArr, fArr, i, i2, i3, i4, i5, i6);
    }

    @Override // io.agora.base.internal.video.GlGenericDrawer, io.agora.base.internal.video.RendererCommon.GlDrawer
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    @Override // io.agora.base.internal.video.GlGenericDrawer, io.agora.base.internal.video.RendererCommon.GlDrawer
    public /* bridge */ /* synthetic */ void setTextureCropCoord(FloatBuffer floatBuffer) {
        super.setTextureCropCoord(floatBuffer);
    }

    @Override // io.agora.base.internal.video.GlGenericDrawer, io.agora.base.internal.video.RendererCommon.GlDrawer
    public /* bridge */ /* synthetic */ void drawYuv(int[] iArr, float[] fArr, int i, int i2, int i3, int i4, int i5, int i6, VideoFrame.ColorSpace colorSpace) {
        super.drawYuv(iArr, fArr, i, i2, i3, i4, i5, i6, colorSpace);
    }
}
