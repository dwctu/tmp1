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
public class TimerSurfaceTextureHelper implements ISurfaceTextureHelper {
    private static final int ANDROID_API_TEXTURE_IN_USE = 10;
    private static final int DEFAULT_MAX_BUFFER_COUNT = 4;
    private static final String TAG = "TSurfaceTextureHelper";
    private final Handler delayHandler;
    public final Runnable delayNotifyRunnable;
    private final EglBase eglBase;
    private int frameRotation;
    private final Handler handler;
    private boolean hasPendingTexture;
    private volatile boolean isOesTextureInUse;
    private boolean isQuitting;

    @Nullable
    private VideoSink listener;
    private volatile int notifyIntervalInMS;
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
    public final Runnable timerNotifyRunnable;
    private final VideoDecimator videoDecimator;
    private final YuvConverter yuvConverter;

    /* renamed from: io.agora.base.internal.video.TimerSurfaceTextureHelper$6, reason: invalid class name */
    public class AnonymousClass6 implements Callable<VideoFrame.TextureBuffer> {
        public final /* synthetic */ VideoFrame.TextureBuffer val$textureBuffer;

        public AnonymousClass6(VideoFrame.TextureBuffer textureBuffer) {
            this.val$textureBuffer = textureBuffer;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public VideoFrame.TextureBuffer call() {
            return TimerSurfaceTextureHelper.this.textureBufferPool.textureCopy(this.val$textureBuffer, new Runnable() { // from class: io.agora.base.internal.video.TimerSurfaceTextureHelper.6.1
                @Override // java.lang.Runnable
                public void run() {
                    TimerSurfaceTextureHelper.this.handler.post(new Runnable() { // from class: io.agora.base.internal.video.TimerSurfaceTextureHelper.6.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!TimerSurfaceTextureHelper.this.isQuitting || TimerSurfaceTextureHelper.this.isOesTextureInUse || TimerSurfaceTextureHelper.this.textureBufferPool.anyTextureInUse()) {
                                return;
                            }
                            TimerSurfaceTextureHelper.this.release();
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
    public static TimerSurfaceTextureHelper create(String str, EglBase.Context context) {
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
        this.delayHandler.getLooper().quit();
        this.handler.getLooper().quit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void returnTextureFrame() {
        this.handler.post(new Runnable() { // from class: io.agora.base.internal.video.TimerSurfaceTextureHelper.10
            @Override // java.lang.Runnable
            public void run() {
                TimerSurfaceTextureHelper.this.isOesTextureInUse = false;
                if (!TimerSurfaceTextureHelper.this.isQuitting || TimerSurfaceTextureHelper.this.textureBufferPool.anyTextureInUse()) {
                    return;
                }
                TimerSurfaceTextureHelper.this.release();
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
    public boolean tryDeliverTextureFrame() {
        int i;
        if (this.handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Wrong thread.");
        }
        if (this.isQuitting || this.listener == null) {
            return false;
        }
        if (this.isOesTextureInUse) {
            VideoSink videoSink = this.listener;
            if (videoSink instanceof IVideoCapture) {
                ((IVideoCapture) videoSink).onFrameDropped(10);
            }
            Logging.d(TAG, "frame Dropped texture in use. ");
            return true;
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
        VideoFrame videoFrame = new VideoFrame(new TextureBuffer(this.sharedContext, i2, i, VideoFrame.TextureBuffer.Type.OES, this.oesTextureId, RendererCommon.convertMatrixToAndroidGraphicsMatrix(fArr), this.handler, this.yuvConverter, new Runnable() { // from class: io.agora.base.internal.video.TimerSurfaceTextureHelper.12
            @Override // java.lang.Runnable
            public void run() {
                TimerSurfaceTextureHelper.this.returnTextureFrame();
            }
        }), this.frameRotation, timestamp);
        this.listener.onFrame(videoFrame);
        videoFrame.release();
        return true;
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
        try {
            ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new Runnable() { // from class: io.agora.base.internal.video.TimerSurfaceTextureHelper.11
                @Override // java.lang.Runnable
                public void run() {
                    TimerSurfaceTextureHelper.this.isQuitting = true;
                    if (!TimerSurfaceTextureHelper.this.isOesTextureInUse && !TimerSurfaceTextureHelper.this.textureBufferPool.anyTextureInUse()) {
                        TimerSurfaceTextureHelper.this.release();
                        return;
                    }
                    Logging.d(TimerSurfaceTextureHelper.TAG, " not release yet, this: " + this + " isOesTextureInUse: " + TimerSurfaceTextureHelper.this.isOesTextureInUse);
                }
            });
        } catch (Exception e) {
            Logging.d(TAG, "dispose fail: " + e.getMessage());
        }
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

    public void setFrameRate(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("invalid frame rate");
        }
        int i2 = i < 5 ? i : 5;
        if (i >= 15) {
            i2 = 15;
        }
        if (i >= 30) {
            i2 = 30;
        }
        this.notifyIntervalInMS = 1000 / i2;
        VideoDecimator videoDecimator = this.videoDecimator;
        if (videoDecimator != null) {
            videoDecimator.setTargetFramerate(i);
        }
    }

    @Override // io.agora.base.internal.video.ISurfaceTextureHelper
    public void setFrameRotation(final int i) {
        this.handler.post(new Runnable() { // from class: io.agora.base.internal.video.TimerSurfaceTextureHelper.9
            @Override // java.lang.Runnable
            public void run() {
                TimerSurfaceTextureHelper.this.frameRotation = i;
            }
        });
    }

    @Override // io.agora.base.internal.video.ISurfaceTextureHelper
    public void setTextureSize(final int i, final int i2) {
        if (i <= 0) {
            throw new IllegalArgumentException("Texture width must be positive, but was " + i);
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("Texture height must be positive, but was " + i2);
        }
        Logging.d(TAG, "setTextureSize textureWidth: " + i + " textureHeight: " + i2);
        this.surfaceTexture.setDefaultBufferSize(i, i2);
        this.handler.post(new Runnable() { // from class: io.agora.base.internal.video.TimerSurfaceTextureHelper.8
            @Override // java.lang.Runnable
            public void run() {
                TimerSurfaceTextureHelper.this.textureWidth = i;
                TimerSurfaceTextureHelper.this.textureHeight = i2;
            }
        });
    }

    @Override // io.agora.base.internal.video.ISurfaceTextureHelper
    public void startListening(VideoSink videoSink) {
        if (this.listener != null || this.pendingListener != null) {
            throw new IllegalStateException("SurfaceTextureHelper listener has already been set.");
        }
        if (this.notifyIntervalInMS == 0) {
            throw new IllegalStateException("frame rate not set");
        }
        this.pendingListener = videoSink;
        this.handler.post(this.setListenerRunnable);
    }

    @Override // io.agora.base.internal.video.ISurfaceTextureHelper
    public void stopListening() {
        Logging.d(TAG, "stopListening()");
        this.delayHandler.removeCallbacks(this.delayNotifyRunnable);
        this.handler.removeCallbacks(this.setListenerRunnable);
        this.videoDecimator.reset();
        try {
            ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new Runnable() { // from class: io.agora.base.internal.video.TimerSurfaceTextureHelper.7
                @Override // java.lang.Runnable
                public void run() {
                    TimerSurfaceTextureHelper.this.listener = null;
                    TimerSurfaceTextureHelper.this.pendingListener = null;
                }
            });
        } catch (Exception e) {
            Logging.d(TAG, "stopListening faile: " + e.getMessage());
        }
    }

    @Nullable
    public VideoFrame.TextureBuffer textureCopy(VideoFrame.TextureBuffer textureBuffer) {
        if (textureBuffer.getTextureId() != this.oesTextureId) {
            throw new IllegalStateException("textureCopy called with unexpected textureId");
        }
        try {
            return (VideoFrame.TextureBuffer) ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new AnonymousClass6(textureBuffer));
        } catch (Exception e) {
            Logging.d(TAG, "textureCopy  fail: " + e.getMessage());
            return null;
        }
    }

    @Deprecated
    public VideoFrame.I420Buffer textureToYuv(VideoFrame.TextureBuffer textureBuffer) {
        return textureBuffer.toI420();
    }

    private TimerSurfaceTextureHelper(String str, EglBase.Context context, Handler handler, int i) {
        this.notifyIntervalInMS = 0;
        YuvConverter yuvConverter = new YuvConverter();
        this.yuvConverter = yuvConverter;
        this.hasPendingTexture = false;
        this.isOesTextureInUse = false;
        this.isQuitting = false;
        this.setListenerRunnable = new Runnable() { // from class: io.agora.base.internal.video.TimerSurfaceTextureHelper.2
            @Override // java.lang.Runnable
            public void run() {
                Logging.d(TimerSurfaceTextureHelper.TAG, "Setting listener to " + TimerSurfaceTextureHelper.this.pendingListener);
                TimerSurfaceTextureHelper timerSurfaceTextureHelper = TimerSurfaceTextureHelper.this;
                timerSurfaceTextureHelper.listener = timerSurfaceTextureHelper.pendingListener;
                TimerSurfaceTextureHelper.this.pendingListener = null;
                if (TimerSurfaceTextureHelper.this.hasPendingTexture) {
                    TimerSurfaceTextureHelper.this.updateTexImage();
                    TimerSurfaceTextureHelper.this.hasPendingTexture = false;
                }
                TimerSurfaceTextureHelper.this.delayHandler.postDelayed(TimerSurfaceTextureHelper.this.delayNotifyRunnable, r1.notifyIntervalInMS);
            }
        };
        this.timerNotifyRunnable = new Runnable() { // from class: io.agora.base.internal.video.TimerSurfaceTextureHelper.3
            @Override // java.lang.Runnable
            public void run() {
                TimerSurfaceTextureHelper.this.tryDeliverTextureFrame();
            }
        };
        this.delayNotifyRunnable = new Runnable() { // from class: io.agora.base.internal.video.TimerSurfaceTextureHelper.4
            @Override // java.lang.Runnable
            public void run() {
                TimerSurfaceTextureHelper.this.videoDecimator.updateIncomingFramerate();
                if (TimerSurfaceTextureHelper.this.videoDecimator.dropFrame()) {
                    Logging.d(TimerSurfaceTextureHelper.TAG, "videoDecimator  dropFrame.");
                } else {
                    TimerSurfaceTextureHelper.this.handler.post(TimerSurfaceTextureHelper.this.timerNotifyRunnable);
                }
                TimerSurfaceTextureHelper.this.delayHandler.removeCallbacks(TimerSurfaceTextureHelper.this.delayNotifyRunnable);
                TimerSurfaceTextureHelper.this.delayHandler.postDelayed(TimerSurfaceTextureHelper.this.delayNotifyRunnable, r1.notifyIntervalInMS);
            }
        };
        if (handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("SurfaceTextureHelper must be created on the handler thread");
        }
        this.handler = handler;
        HandlerThread handlerThread = new HandlerThread("delayThread");
        handlerThread.start();
        this.delayHandler = new Handler(handlerThread.getLooper());
        EglBase eglBaseCreate = EglBaseFactory.create(context, EglBase.CONFIG_PIXEL_BUFFER);
        this.eglBase = eglBaseCreate;
        try {
            eglBaseCreate.createDummyPbufferSurface();
            eglBaseCreate.makeCurrent();
            this.videoDecimator = new VideoDecimator();
            this.sharedContext = context == null ? eglBaseCreate.getEglBaseContext() : context;
            int iGenerateTexture = GlUtil.generateTexture(36197);
            this.oesTextureId = iGenerateTexture;
            SurfaceTexture surfaceTexture = new SurfaceTexture(iGenerateTexture);
            this.surfaceTexture = surfaceTexture;
            this.textureBufferPool = TextureBufferPool.createWithinGlThread(str, i, 6407, handler, eglBaseCreate, yuvConverter);
            setOnFrameAvailableListener(surfaceTexture, new SurfaceTexture.OnFrameAvailableListener() { // from class: io.agora.base.internal.video.TimerSurfaceTextureHelper.5
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                    TimerSurfaceTextureHelper.this.hasPendingTexture = true;
                    TimerSurfaceTextureHelper.this.delayHandler.post(TimerSurfaceTextureHelper.this.delayNotifyRunnable);
                }
            }, handler);
        } catch (RuntimeException e) {
            this.eglBase.release();
            handler.getLooper().quit();
            this.delayHandler.getLooper().quit();
            throw e;
        }
    }

    @Nullable
    public static TimerSurfaceTextureHelper create(final String str, final EglBase.Context context, final int i) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        final Handler handler = new Handler(handlerThread.getLooper());
        try {
            return (TimerSurfaceTextureHelper) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<TimerSurfaceTextureHelper>() { // from class: io.agora.base.internal.video.TimerSurfaceTextureHelper.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                @Nullable
                public TimerSurfaceTextureHelper call() {
                    try {
                        return new TimerSurfaceTextureHelper(str, context, handler, i);
                    } catch (RuntimeException e) {
                        Logging.e(TimerSurfaceTextureHelper.TAG, str + " create failure", e);
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
