package io.agora.base;

import android.graphics.Matrix;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.Nullable;
import io.agora.base.VideoFrame;
import io.agora.base.internal.Logging;
import io.agora.base.internal.ThreadUtils;
import io.agora.base.internal.video.EglBase;
import io.agora.base.internal.video.EglBase10;
import io.agora.base.internal.video.EglBase14;
import io.agora.base.internal.video.GlRectDrawer;
import io.agora.base.internal.video.GlTextureFrameBuffer;
import io.agora.base.internal.video.RendererCommon;
import io.agora.base.internal.video.YuvConverter;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public class TextureBufferHelper {
    private static final String TAG = "TextureBufferHelper";
    private final EglBase eglBase;
    private final Handler handler;
    private boolean isQuitting;
    private int numOfTextureInUse;
    private GlRectDrawer textureDrawer;
    private GlTextureFrameBuffer textureFrameBuffer;
    private final YuvConverter yuvConverter;

    private TextureBufferHelper(EglBase.Context context, Handler handler) {
        this.yuvConverter = new YuvConverter();
        this.numOfTextureInUse = 0;
        this.isQuitting = false;
        if (handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("TextureBufferHelper must be created on the handler thread");
        }
        this.handler = handler;
        EglBase eglBase14 = (EglBase14.isEGL14Supported() && (context == null || (context instanceof EglBase14.Context))) ? new EglBase14((EglBase14.Context) context, EglBase.CONFIG_PIXEL_BUFFER) : new EglBase10((EglBase10.Context) context, EglBase.CONFIG_PIXEL_BUFFER);
        this.eglBase = eglBase14;
        try {
            eglBase14.createDummyPbufferSurface();
            eglBase14.makeCurrent();
        } catch (RuntimeException e) {
            this.eglBase.release();
            handler.getLooper().quit();
            throw e;
        }
    }

    public static /* synthetic */ int access$210(TextureBufferHelper textureBufferHelper) {
        int i = textureBufferHelper.numOfTextureInUse;
        textureBufferHelper.numOfTextureInUse = i - 1;
        return i;
    }

    @Nullable
    public static TextureBufferHelper create(final String str, final EglBase.Context context) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        final Handler handler = new Handler(handlerThread.getLooper());
        try {
            return (TextureBufferHelper) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<TextureBufferHelper>() { // from class: io.agora.base.TextureBufferHelper.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public TextureBufferHelper call() {
                    try {
                        return new TextureBufferHelper(context, handler);
                    } catch (RuntimeException e) {
                        Logging.e(TextureBufferHelper.TAG, str + " create failure", e);
                        return null;
                    }
                }
            });
        } catch (Exception e) {
            Logging.e(TAG, str + " create failure", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        if (this.handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Wrong thread.");
        }
        if (isTextureInUse() || !this.isQuitting) {
            throw new IllegalStateException("Unexpected release.");
        }
        Logging.d(TAG, "release()");
        GlRectDrawer glRectDrawer = this.textureDrawer;
        if (glRectDrawer != null) {
            glRectDrawer.release();
            this.textureDrawer = null;
        }
        GlTextureFrameBuffer glTextureFrameBuffer = this.textureFrameBuffer;
        if (glTextureFrameBuffer != null) {
            glTextureFrameBuffer.release();
            this.textureFrameBuffer = null;
        }
        this.yuvConverter.release();
        this.eglBase.release();
        this.handler.getLooper().quit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void returnTextureFrame() {
        this.handler.post(new Runnable() { // from class: io.agora.base.TextureBufferHelper.3
            @Override // java.lang.Runnable
            public void run() {
                TextureBufferHelper.access$210(TextureBufferHelper.this);
                if (TextureBufferHelper.this.isQuitting) {
                    TextureBufferHelper.this.release();
                }
            }
        });
    }

    public int convertToRGBA(TextureBuffer textureBuffer, int i) {
        if (textureBuffer == null) {
            return 0;
        }
        if (textureBuffer.getType() == VideoFrame.TextureBuffer.Type.RGB) {
            return textureBuffer.getTextureId();
        }
        if (this.textureDrawer == null) {
            this.textureDrawer = new GlRectDrawer();
        }
        if (this.textureFrameBuffer == null) {
            this.textureFrameBuffer = new GlTextureFrameBuffer(6408);
        }
        int i2 = i % 180;
        int width = i2 == 0 ? textureBuffer.getWidth() : textureBuffer.getHeight();
        int height = i2 == 0 ? textureBuffer.getHeight() : textureBuffer.getWidth();
        this.textureFrameBuffer.setSize(width, height);
        GLES20.glBindFramebuffer(36160, this.textureFrameBuffer.getFrameBufferId());
        GLES20.glClear(16384);
        Matrix matrix = new Matrix();
        matrix.preTranslate(0.5f, 0.5f);
        matrix.preRotate(i);
        matrix.preTranslate(-0.5f, -0.5f);
        matrix.postConcat(textureBuffer.getTransformMatrix());
        this.textureDrawer.drawOes(textureBuffer.getTextureId(), RendererCommon.convertMatrixFromAndroidGraphicsMatrix(matrix), width, height, 0, 0, width, height);
        GLES20.glBindFramebuffer(36160, 0);
        return this.textureFrameBuffer.getTextureId();
    }

    public void dispose() {
        Logging.d(TAG, "dispose()");
        try {
            ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new Runnable() { // from class: io.agora.base.TextureBufferHelper.4
                @Override // java.lang.Runnable
                public void run() {
                    TextureBufferHelper.this.isQuitting = true;
                    if (TextureBufferHelper.this.isTextureInUse()) {
                        return;
                    }
                    TextureBufferHelper.this.release();
                }
            });
        } catch (Exception e) {
            Logging.d(TAG, "dispose fail: " + e.getMessage());
        }
    }

    public EglBase getEglBase() {
        return this.eglBase;
    }

    public Handler getHandler() {
        return this.handler;
    }

    public <V> V invoke(Callable<V> callable) {
        return (V) ThreadUtils.invokeAtFrontUninterruptibly(this.handler, callable);
    }

    public boolean isTextureInUse() {
        return this.numOfTextureInUse > 0;
    }

    public VideoFrame.TextureBuffer wrapTextureBuffer(int i, int i2, VideoFrame.TextureBuffer.Type type, int i3, Matrix matrix) {
        this.numOfTextureInUse++;
        return new TextureBuffer(this.eglBase.getEglBaseContext(), i, i2, type, i3, matrix, this.handler, this.yuvConverter, new Runnable() { // from class: io.agora.base.TextureBufferHelper.2
            @Override // java.lang.Runnable
            public void run() {
                TextureBufferHelper.this.returnTextureFrame();
            }
        });
    }
}
