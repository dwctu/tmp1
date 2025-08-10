package io.agora.rtc2.internal;

import android.graphics.Matrix;
import android.opengl.GLES20;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.agora.base.TextureBufferHelper;
import io.agora.base.VideoFrame;
import io.agora.base.internal.CalledByNative;
import io.agora.base.internal.video.EglBase;
import io.agora.base.internal.video.GlRectDrawer;
import io.agora.base.internal.video.GlTextureFrameBuffer;
import io.agora.base.internal.video.GlUtil;
import io.agora.base.internal.video.VideoFrameDrawer;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public class TextureConverter {
    private static final String TAG = "TextureConverter";

    @Nullable
    private GlTextureFrameBuffer textureFrameBuffer;
    private EglBase.Context eglContext = null;
    private TextureBufferHelper textureBufferHelper = null;
    private final GlRectDrawer textureDrawer = new GlRectDrawer();
    private final VideoFrameDrawer frameDrawer = new VideoFrameDrawer();
    private final Matrix drawMatrix = new Matrix();

    @CalledByNative
    public TextureConverter() {
        io.agora.base.internal.Logging.d(TAG, "constructor()");
    }

    private boolean configEglEnv(@NonNull EglBase.Context context) {
        TextureBufferHelper textureBufferHelperCreate = TextureBufferHelper.create("AgConvertor", context);
        this.textureBufferHelper = textureBufferHelperCreate;
        if (textureBufferHelperCreate == null) {
            io.agora.base.internal.Logging.e(TAG, "Failed to create texture buffer helper.");
            return false;
        }
        this.eglContext = context;
        return true;
    }

    private boolean reconfigEglEnv(EglBase.Context context) {
        if (context == null) {
            return false;
        }
        if (context.equals(this.eglContext)) {
            return true;
        }
        io.agora.base.internal.Logging.d(TAG, "reconfigEglEnv(()");
        releaseEglEnv();
        return configEglEnv(context);
    }

    private void releaseEglEnv() {
        TextureBufferHelper textureBufferHelper = this.textureBufferHelper;
        if (textureBufferHelper != null) {
            if (this.textureFrameBuffer != null) {
                textureBufferHelper.invoke(new Callable<Object>() { // from class: io.agora.rtc2.internal.TextureConverter.2
                    @Override // java.util.concurrent.Callable
                    public Object call() throws Exception {
                        if (TextureConverter.this.textureFrameBuffer != null) {
                            TextureConverter.this.textureFrameBuffer.release();
                        }
                        TextureConverter.this.textureFrameBuffer = null;
                        return null;
                    }
                });
            }
            this.textureBufferHelper.dispose();
            this.textureBufferHelper = null;
        }
        this.eglContext = null;
    }

    @CalledByNative
    public VideoFrame convert(final VideoFrame videoFrame) {
        if (videoFrame == null || videoFrame.getBuffer() == null || !(videoFrame.getBuffer() instanceof VideoFrame.TextureBuffer)) {
            return null;
        }
        if (reconfigEglEnv(((VideoFrame.TextureBuffer) videoFrame.getBuffer()).getEglBaseContext())) {
            return (VideoFrame) this.textureBufferHelper.invoke(new Callable<VideoFrame>() { // from class: io.agora.rtc2.internal.TextureConverter.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public VideoFrame call() throws Exception {
                    if (TextureConverter.this.textureBufferHelper.isTextureInUse()) {
                        io.agora.base.internal.Logging.e(TextureConverter.TAG, "failed to convert, texture in use");
                        return null;
                    }
                    if (TextureConverter.this.textureFrameBuffer == null) {
                        TextureConverter.this.textureFrameBuffer = new GlTextureFrameBuffer(6408);
                    }
                    int rotatedWidth = videoFrame.getRotatedWidth();
                    int rotatedHeight = videoFrame.getRotatedHeight();
                    TextureConverter.this.textureFrameBuffer.setSize(rotatedWidth, rotatedHeight);
                    GLES20.glBindFramebuffer(36160, TextureConverter.this.textureFrameBuffer.getFrameBufferId());
                    GlUtil.checkNoGLES2Error("VideoFrameRotator.glBindFramebuffer");
                    GLES20.glClear(16384);
                    TextureConverter.this.frameDrawer.drawFrame(videoFrame, TextureConverter.this.textureDrawer, TextureConverter.this.drawMatrix);
                    GlUtil.checkNoGLES2Error("VideoFrameRotator.drawFrame");
                    GLES20.glBindFramebuffer(36160, 0);
                    GLES20.glFlush();
                    return new VideoFrame(TextureConverter.this.textureBufferHelper.wrapTextureBuffer(rotatedWidth, rotatedHeight, VideoFrame.TextureBuffer.Type.RGB, TextureConverter.this.textureFrameBuffer.getTextureId(), new Matrix()), 0, videoFrame.getTimestampNs());
                }
            });
        }
        io.agora.base.internal.Logging.e(TAG, "failed to reconfig egl env");
        return null;
    }

    @CalledByNative
    public void dispose() {
        io.agora.base.internal.Logging.d(TAG, "dispose()");
        releaseEglEnv();
    }
}
