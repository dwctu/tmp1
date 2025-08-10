package io.agora.base.internal.video;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.agora.base.TextureBuffer;
import io.agora.base.VideoFrame;
import io.agora.base.internal.Logging;
import io.agora.base.internal.ThreadUtils;
import io.agora.base.internal.video.EglBase;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public class SurfaceTextureHelper implements ISurfaceTextureHelper {
    private static final int ANDROID_API_TEXTURE_IN_USE = 10;
    private static final int DEFAULT_MAX_BUFFER_COUNT = 4;
    private static final String TAG = "SurfaceTextureHelper";
    private final EglBase eglBase;
    private int frameRotation;
    private final Handler handler;
    private boolean hasPendingTexture;
    private volatile boolean isOesTextureInUse;
    private boolean isQuitting;

    @Nullable
    private VideoSink listener;
    private final String name;
    private final int oesTextureId;

    @Nullable
    private VideoSink pendingListener;
    public final Runnable setListenerRunnable;

    @NonNull
    private final EglBase.Context sharedContext;
    private final SurfaceTexture surfaceTexture;
    private final TextureBufferPool textureBufferPool;
    private int textureHeight;
    private int textureWidth;
    private final YuvConverter yuvConverter;

    /* renamed from: io.agora.base.internal.video.SurfaceTextureHelper$9, reason: invalid class name */
    public class AnonymousClass9 implements Callable<VideoFrame.TextureBuffer> {
        public final /* synthetic */ VideoFrame.TextureBuffer val$textureBuffer;

        public AnonymousClass9(VideoFrame.TextureBuffer textureBuffer) {
            this.val$textureBuffer = textureBuffer;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public VideoFrame.TextureBuffer call() throws Exception {
            return SurfaceTextureHelper.this.textureBufferPool.textureCopy(this.val$textureBuffer, new Runnable() { // from class: io.agora.base.internal.video.SurfaceTextureHelper.9.1
                @Override // java.lang.Runnable
                public void run() {
                    SurfaceTextureHelper.this.handler.post(new Runnable() { // from class: io.agora.base.internal.video.SurfaceTextureHelper.9.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!SurfaceTextureHelper.this.isQuitting || SurfaceTextureHelper.this.isOesTextureInUse || SurfaceTextureHelper.this.textureBufferPool.anyTextureInUse()) {
                                return;
                            }
                            SurfaceTextureHelper.this.release();
                        }
                    });
                }
            });
        }
    }

    public interface IVideoCapture extends VideoSink {
        void onFrameDropped(int i);
    }

    @Nullable
    public static SurfaceTextureHelper create(String str, EglBase.Context context) {
        return create(str, context, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        if (this.handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Wrong thread.");
        }
        if (this.isOesTextureInUse || this.textureBufferPool.anyTextureInUse() || !this.isQuitting) {
            throw new IllegalStateException("Unexpected release.");
        }
        this.yuvConverter.release();
        this.textureBufferPool.dispose();
        GLES20.glDeleteTextures(1, new int[]{this.oesTextureId}, 0);
        this.surfaceTexture.release();
        this.eglBase.release();
        this.handler.getLooper().quit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void returnTextureFrame() {
        this.handler.post(new Runnable() { // from class: io.agora.base.internal.video.SurfaceTextureHelper.7
            @Override // java.lang.Runnable
            public void run() {
                SurfaceTextureHelper.this.isOesTextureInUse = false;
                if (!SurfaceTextureHelper.this.isQuitting) {
                    SurfaceTextureHelper.this.tryDeliverTextureFrame();
                } else {
                    if (SurfaceTextureHelper.this.textureBufferPool.anyTextureInUse()) {
                        return;
                    }
                    SurfaceTextureHelper.this.release();
                }
            }
        });
    }

    @TargetApi(21)
    private static void setOnFrameAvailableListener(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, Handler handler) {
        if (Build.VERSION.SDK_INT >= 21) {
            surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener, handler);
        } else {
            surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryDeliverTextureFrame() {
        int i;
        if (this.handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Wrong thread.");
        }
        if (this.isQuitting || !this.hasPendingTexture || this.listener == null) {
            return;
        }
        if (this.isOesTextureInUse) {
            VideoSink videoSink = this.listener;
            if (videoSink instanceof IVideoCapture) {
                ((IVideoCapture) videoSink).onFrameDropped(10);
                return;
            }
            return;
        }
        this.isOesTextureInUse = true;
        this.hasPendingTexture = false;
        updateTexImage();
        float[] fArr = new float[16];
        this.surfaceTexture.getTransformMatrix(fArr);
        long timestamp = this.surfaceTexture.getTimestamp();
        int i2 = this.textureWidth;
        if (i2 == 0 || (i = this.textureHeight) == 0) {
            throw new RuntimeException("Texture size has not been set.");
        }
        VideoFrame videoFrame = new VideoFrame(new TextureBuffer(this.sharedContext, i2, i, VideoFrame.TextureBuffer.Type.OES, this.oesTextureId, RendererCommon.convertMatrixToAndroidGraphicsMatrix(fArr), this.handler, this.yuvConverter, new Runnable() { // from class: io.agora.base.internal.video.SurfaceTextureHelper.10
            @Override // java.lang.Runnable
            public void run() {
                SurfaceTextureHelper.this.returnTextureFrame();
            }
        }), this.frameRotation, timestamp);
        this.listener.onFrame(videoFrame);
        videoFrame.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTexImage() {
        try {
            synchronized (EglBase.lock) {
                this.surfaceTexture.updateTexImage();
            }
        } catch (Exception e) {
            Logging.e(TAG, "failed to updateTexImage. " + e.getMessage());
        }
    }

    @Override // io.agora.base.internal.video.ISurfaceTextureHelper
    public void dispose() {
        Logging.d(TAG, "dispose()");
        ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new Runnable() { // from class: io.agora.base.internal.video.SurfaceTextureHelper.8
            @Override // java.lang.Runnable
            public void run() {
                SurfaceTextureHelper.this.isQuitting = true;
                if (!SurfaceTextureHelper.this.isOesTextureInUse && !SurfaceTextureHelper.this.textureBufferPool.anyTextureInUse()) {
                    SurfaceTextureHelper.this.release();
                    return;
                }
                Logging.d(SurfaceTextureHelper.TAG, SurfaceTextureHelper.this.name + " not release yet, this: " + SurfaceTextureHelper.this + " isOesTextureInUse: " + SurfaceTextureHelper.this.isOesTextureInUse);
            }
        });
    }

    @Override // io.agora.base.internal.video.ISurfaceTextureHelper
    public Handler getHandler() {
        return this.handler;
    }

    @Override // io.agora.base.internal.video.ISurfaceTextureHelper
    public SurfaceTexture getSurfaceTexture() {
        return this.surfaceTexture;
    }

    @Override // io.agora.base.internal.video.ISurfaceTextureHelper
    public boolean isOesTextureInUse() {
        return this.isOesTextureInUse;
    }

    @Override // io.agora.base.internal.video.ISurfaceTextureHelper
    public void setFrameRotation(final int i) {
        this.handler.post(new Runnable() { // from class: io.agora.base.internal.video.SurfaceTextureHelper.6
            @Override // java.lang.Runnable
            public void run() {
                SurfaceTextureHelper.this.frameRotation = i;
            }
        });
    }

    @Override // io.agora.base.internal.video.ISurfaceTextureHelper
    public void setTextureSize(final int i, final int i2) {
        if (i <= 0) {
            throw new IllegalArgumentException("Texture width must be positive, but was " + i);
        }
        if (i2 > 0) {
            this.surfaceTexture.setDefaultBufferSize(i, i2);
            this.handler.post(new Runnable() { // from class: io.agora.base.internal.video.SurfaceTextureHelper.5
                @Override // java.lang.Runnable
                public void run() {
                    SurfaceTextureHelper.this.textureWidth = i;
                    SurfaceTextureHelper.this.textureHeight = i2;
                }
            });
        } else {
            throw new IllegalArgumentException("Texture height must be positive, but was " + i2);
        }
    }

    @Override // io.agora.base.internal.video.ISurfaceTextureHelper
    public void startListening(VideoSink videoSink) {
        if (this.listener != null || this.pendingListener != null) {
            throw new IllegalStateException("SurfaceTextureHelper listener has already been set.");
        }
        this.pendingListener = videoSink;
        this.handler.post(this.setListenerRunnable);
    }

    @Override // io.agora.base.internal.video.ISurfaceTextureHelper
    public void stopListening() {
        Logging.d(TAG, "stopListening()");
        this.handler.removeCallbacks(this.setListenerRunnable);
        ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new Runnable() { // from class: io.agora.base.internal.video.SurfaceTextureHelper.4
            @Override // java.lang.Runnable
            public void run() {
                SurfaceTextureHelper.this.listener = null;
                SurfaceTextureHelper.this.pendingListener = null;
            }
        });
    }

    @Nullable
    public VideoFrame.TextureBuffer textureCopy(VideoFrame.TextureBuffer textureBuffer) {
        if (textureBuffer.getTextureId() == this.oesTextureId) {
            return (VideoFrame.TextureBuffer) ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new AnonymousClass9(textureBuffer));
        }
        Logging.w(TAG, "textureCopy: " + this.name + " IllegalStateException.");
        throw new IllegalStateException("textureCopy called with unexpected textureId");
    }

    @Deprecated
    public VideoFrame.I420Buffer textureToYuv(VideoFrame.TextureBuffer textureBuffer) {
        return textureBuffer.toI420();
    }

    private SurfaceTextureHelper(String str, EglBase.Context context, Handler handler, int i) {
        YuvConverter yuvConverter = new YuvConverter();
        this.yuvConverter = yuvConverter;
        this.hasPendingTexture = false;
        this.isOesTextureInUse = false;
        this.isQuitting = false;
        this.setListenerRunnable = new Runnable() { // from class: io.agora.base.internal.video.SurfaceTextureHelper.2
            @Override // java.lang.Runnable
            public void run() {
                Logging.d(SurfaceTextureHelper.TAG, "Setting listener to " + SurfaceTextureHelper.this.pendingListener);
                SurfaceTextureHelper surfaceTextureHelper = SurfaceTextureHelper.this;
                surfaceTextureHelper.listener = surfaceTextureHelper.pendingListener;
                SurfaceTextureHelper.this.pendingListener = null;
                if (SurfaceTextureHelper.this.hasPendingTexture) {
                    SurfaceTextureHelper.this.updateTexImage();
                    SurfaceTextureHelper.this.hasPendingTexture = false;
                }
            }
        };
        if (handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("SurfaceTextureHelper must be created on the handler thread");
        }
        this.name = str;
        this.handler = handler;
        EglBase eglBaseCreate = EglBaseFactory.create(context, EglBase.CONFIG_PIXEL_BUFFER);
        this.eglBase = eglBaseCreate;
        try {
            eglBaseCreate.createDummyPbufferSurface();
            eglBaseCreate.makeCurrent();
            this.sharedContext = context == null ? eglBaseCreate.getEglBaseContext() : context;
            this.textureBufferPool = TextureBufferPool.createWithinGlThread(str, i, 6407, handler, eglBaseCreate, yuvConverter);
            int iGenerateTexture = GlUtil.generateTexture(36197);
            this.oesTextureId = iGenerateTexture;
            SurfaceTexture surfaceTexture = new SurfaceTexture(iGenerateTexture);
            this.surfaceTexture = surfaceTexture;
            setOnFrameAvailableListener(surfaceTexture, new SurfaceTexture.OnFrameAvailableListener() { // from class: io.agora.base.internal.video.SurfaceTextureHelper.3
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                    SurfaceTextureHelper.this.hasPendingTexture = true;
                    SurfaceTextureHelper.this.tryDeliverTextureFrame();
                }
            }, handler);
        } catch (RuntimeException e) {
            this.eglBase.release();
            handler.getLooper().quit();
            throw e;
        }
    }

    @Nullable
    public static SurfaceTextureHelper create(final String str, final EglBase.Context context, final int i) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        final Handler handler = new Handler(handlerThread.getLooper());
        try {
            return (SurfaceTextureHelper) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<SurfaceTextureHelper>() { // from class: io.agora.base.internal.video.SurfaceTextureHelper.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                @Nullable
                public SurfaceTextureHelper call() {
                    try {
                        return new SurfaceTextureHelper(str, context, handler, i);
                    } catch (RuntimeException e) {
                        Logging.e(SurfaceTextureHelper.TAG, str + " create failure", e);
                        return null;
                    }
                }
            });
        } catch (Exception e) {
            Logging.e(TAG, str + " create failure", e);
            return null;
        }
    }
}
