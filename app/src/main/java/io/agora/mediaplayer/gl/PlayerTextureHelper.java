package io.agora.mediaplayer.gl;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.Nullable;
import io.agora.base.TextureBuffer;
import io.agora.base.VideoFrame;
import io.agora.base.internal.ThreadUtils;
import io.agora.base.internal.video.EglBase;
import io.agora.base.internal.video.EglBase14;
import io.agora.base.internal.video.GlUtil;
import io.agora.base.internal.video.RendererCommon;
import io.agora.base.internal.video.TextureBufferPool;
import io.agora.base.internal.video.YuvConverter;
import io.agora.mediaplayer.IPlayerTextureHelper;
import io.agora.rtc2.internal.Logging;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Callable;

@TargetApi(18)
/* loaded from: classes4.dex */
public class PlayerTextureHelper implements IPlayerTextureHelper, SurfaceTexture.OnFrameAvailableListener {
    public static final float[] IDENTITY_MATRIX;
    public static final int MAX_BUFFER_CNT = 12;
    private static final String TAG = "PlayerTextureHelper";
    private final Queue<VideoFrame> decodedTextureBuffers;
    private final EglBase eglBase;
    private final Handler handler;
    private boolean hasPendingTexture;
    private boolean isQuitting;
    private final Object newFrameLock;
    private final int oesTextureId;
    private Surface renderSurface;
    public final Runnable setListenerRunnable;
    private final EglBase.Context sharedContext;
    private final SurfaceTexture surfaceTexture;
    private final TextureBufferPool textureBufferPool;
    private int textureHeight;
    private int textureWidth;
    private final YuvConverter yuvConverter;

    static {
        float[] fArr = new float[16];
        IDENTITY_MATRIX = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    private PlayerTextureHelper(EglBase.Context context, Handler handler) {
        this.renderSurface = null;
        YuvConverter yuvConverter = new YuvConverter();
        this.yuvConverter = yuvConverter;
        this.hasPendingTexture = false;
        this.isQuitting = false;
        this.newFrameLock = new Object();
        this.decodedTextureBuffers = new LinkedList();
        this.setListenerRunnable = new Runnable() { // from class: io.agora.mediaplayer.gl.PlayerTextureHelper.2
            @Override // java.lang.Runnable
            public void run() {
                if (PlayerTextureHelper.this.hasPendingTexture) {
                    PlayerTextureHelper.this.updateTexImage();
                    PlayerTextureHelper.this.hasPendingTexture = false;
                }
            }
        };
        if (handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("SurfaceTextureHelperTest must be created on the handler thread");
        }
        Logging.i(TAG, "PlayerTextureHelper new " + this);
        this.handler = handler;
        EglBase14 eglBase14 = new EglBase14((EglBase14.Context) context, EglBase.CONFIG_PIXEL_BUFFER);
        this.eglBase = eglBase14;
        try {
            eglBase14.createDummyPbufferSurface();
            eglBase14.makeCurrent();
            this.textureBufferPool = TextureBufferPool.createWithinGlThread("PlayerTextureBufferPool", 12, 6407, handler, eglBase14, yuvConverter);
            this.sharedContext = context == null ? eglBase14.getEglBaseContext() : context;
            int iGenerateTexture = GlUtil.generateTexture(36197);
            this.oesTextureId = iGenerateTexture;
            SurfaceTexture surfaceTexture = new SurfaceTexture(iGenerateTexture);
            this.surfaceTexture = surfaceTexture;
            setOnFrameAvailableListener(surfaceTexture, this, handler);
            setDefaultTextureSize(640, 360);
            startListening();
        } catch (RuntimeException e) {
            this.eglBase.release();
            handler.getLooper().quit();
            throw e;
        }
    }

    @Nullable
    public static PlayerTextureHelper create() {
        final EglBase.Context context = null;
        if (!isEgl14Supported()) {
            Logging.i(TAG, "device not support Egl14");
            return null;
        }
        final String str = "player-texture-thread" + System.currentTimeMillis();
        Logging.i(TAG, "PlayerTextureHelper create " + str);
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        final Handler handler = new Handler(handlerThread.getLooper());
        try {
            return (PlayerTextureHelper) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<PlayerTextureHelper>() { // from class: io.agora.mediaplayer.gl.PlayerTextureHelper.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                @Nullable
                public PlayerTextureHelper call() {
                    try {
                        return new PlayerTextureHelper(context, handler);
                    } catch (RuntimeException e) {
                        Logging.e(PlayerTextureHelper.TAG, str + " create failure", e);
                        return null;
                    }
                }
            });
        } catch (Exception e) {
            Logging.e(TAG, str + " create failure", e);
            return null;
        }
    }

    private SurfaceTexture getSurfaceTexture() {
        return this.surfaceTexture;
    }

    private static boolean isEgl14Supported() {
        return EglBase14.isEGL14SupportedImpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        if (this.handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Wrong thread.");
        }
        if (!this.isQuitting) {
            throw new IllegalStateException("Unexpected release.");
        }
        this.yuvConverter.release();
        GLES20.glDeleteTextures(1, new int[]{this.oesTextureId}, 0);
        this.textureBufferPool.dispose();
        this.surfaceTexture.release();
        this.eglBase.release();
        resetTextureBufferQueue();
        this.handler.getLooper().quit();
        Logging.i(TAG, "release player texture helper " + this);
    }

    private void setDefaultTextureSize(final int i, final int i2) {
        if (i <= 0) {
            throw new IllegalArgumentException("Texture width must be positive, but was " + i);
        }
        if (i2 > 0) {
            this.surfaceTexture.setDefaultBufferSize(i, i2);
            this.handler.post(new Runnable() { // from class: io.agora.mediaplayer.gl.PlayerTextureHelper.4
                @Override // java.lang.Runnable
                public void run() {
                    PlayerTextureHelper.this.textureWidth = i;
                    PlayerTextureHelper.this.textureHeight = i2;
                }
            });
        } else {
            throw new IllegalArgumentException("Texture height must be positive, but was " + i2);
        }
    }

    @TargetApi(21)
    private static void setOnFrameAvailableListener(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, Handler handler) {
        if (Build.VERSION.SDK_INT >= 21) {
            surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener, handler);
        } else {
            surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
        }
    }

    private void startListening() {
        this.handler.post(this.setListenerRunnable);
    }

    private void stopListening() {
        Logging.d(TAG, "stopListening()");
        this.handler.removeCallbacks(this.setListenerRunnable);
    }

    private void tryDeliverTextureFrame() {
        String str;
        if (this.handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Wrong thread.");
        }
        if (this.isQuitting || !this.hasPendingTexture) {
            return;
        }
        this.hasPendingTexture = false;
        updateTexImage();
        if (this.textureWidth == 0 || this.textureHeight == 0) {
            str = "Texture size has not been set.";
        } else {
            float[] fArr = new float[16];
            this.surfaceTexture.getTransformMatrix(fArr);
            TextureBuffer textureBuffer = new TextureBuffer(this.sharedContext, this.textureWidth, this.textureHeight, VideoFrame.TextureBuffer.Type.OES, this.oesTextureId, RendererCommon.convertMatrixToAndroidGraphicsMatrix(fArr), this.handler, this.yuvConverter, (Runnable) null);
            VideoFrame.TextureBuffer textureBufferTextureCopy = textureCopy(textureBuffer);
            textureBuffer.release();
            if (textureBufferTextureCopy != null) {
                VideoFrame videoFrame = new VideoFrame(textureBufferTextureCopy, 0, this.surfaceTexture.getTimestamp());
                synchronized (this.newFrameLock) {
                    this.decodedTextureBuffers.offer(videoFrame);
                    this.newFrameLock.notifyAll();
                }
                return;
            }
            str = "java oesTextureId:" + this.oesTextureId + " context:" + this.sharedContext.getNativeEglContext() + " java pts:" + this.surfaceTexture.getTimestamp();
        }
        Logging.e(str);
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

    @Override // io.agora.mediaplayer.IPlayerTextureHelper
    public void dispose() {
        stopListening();
        try {
            ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new Runnable() { // from class: io.agora.mediaplayer.gl.PlayerTextureHelper.5
                @Override // java.lang.Runnable
                public void run() {
                    PlayerTextureHelper.this.isQuitting = true;
                    PlayerTextureHelper.this.release();
                }
            });
        } catch (Exception e) {
            Logging.e(TAG, "dispose faile: ", e);
        }
    }

    @Override // io.agora.mediaplayer.IPlayerTextureHelper
    public VideoFrame getAvailableTextureInfo(int i) {
        VideoFrame videoFramePoll;
        synchronized (this.newFrameLock) {
            while (this.decodedTextureBuffers.isEmpty()) {
                try {
                    this.newFrameLock.wait(i);
                    break;
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
            videoFramePoll = this.decodedTextureBuffers.poll();
        }
        return videoFramePoll;
    }

    @Override // io.agora.mediaplayer.IPlayerTextureHelper
    public long getEglContextHandler() {
        return this.sharedContext.getNativeEglContext();
    }

    @Override // io.agora.mediaplayer.IPlayerTextureHelper
    public VideoFrame getFakeTextureInfo() {
        Logging.i("getFakeTextureInfo");
        return new VideoFrame(new TextureBuffer(this.sharedContext, 640, 360, VideoFrame.TextureBuffer.Type.RGB, 0, RendererCommon.convertMatrixToAndroidGraphicsMatrix(IDENTITY_MATRIX), this.handler, this.yuvConverter, (Runnable) null), 0, 0L);
    }

    @Override // io.agora.mediaplayer.IPlayerTextureHelper
    public Surface getRenderGlSurface() {
        if (this.renderSurface == null) {
            this.renderSurface = new Surface(getSurfaceTexture());
        }
        Logging.i(TAG, "getRenderGlSurface " + this + " renderSurface:" + this.renderSurface);
        return this.renderSurface;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.hasPendingTexture = true;
        tryDeliverTextureFrame();
    }

    @Override // io.agora.mediaplayer.IPlayerTextureHelper
    public void releaseRenderedTextureInfo(VideoFrame videoFrame) {
        if (videoFrame != null) {
            videoFrame.release();
        }
    }

    @Override // io.agora.mediaplayer.IPlayerTextureHelper
    public void resetTextureBufferQueue() {
        synchronized (this.newFrameLock) {
            Logging.i(TAG, "resetTextureBufferQueue " + this.decodedTextureBuffers.size());
            Iterator<VideoFrame> it = this.decodedTextureBuffers.iterator();
            while (it.hasNext()) {
                it.next().release();
            }
            this.decodedTextureBuffers.clear();
        }
    }

    @Override // io.agora.mediaplayer.IPlayerTextureHelper
    public void setTextureSize(final int i, final int i2) {
        Handler handler = this.handler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: io.agora.mediaplayer.gl.PlayerTextureHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    PlayerTextureHelper.this.textureWidth = i;
                    PlayerTextureHelper.this.textureHeight = i2;
                }
            });
        }
    }

    @Nullable
    public VideoFrame.TextureBuffer textureCopy(final VideoFrame.TextureBuffer textureBuffer) {
        if (textureBuffer.getTextureId() != this.oesTextureId) {
            throw new IllegalStateException("textureCopy called with unexpected textureId");
        }
        try {
            return (VideoFrame.TextureBuffer) ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new Callable<VideoFrame.TextureBuffer>() { // from class: io.agora.mediaplayer.gl.PlayerTextureHelper.6
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public VideoFrame.TextureBuffer call() {
                    return PlayerTextureHelper.this.textureBufferPool.textureCopy(textureBuffer, new Runnable() { // from class: io.agora.mediaplayer.gl.PlayerTextureHelper.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Logging.i(PlayerTextureHelper.TAG, "textureBufferPool release");
                        }
                    });
                }
            });
        } catch (Exception e) {
            Logging.i(TAG, "textureBufferPool release faile: " + e.getMessage());
            return null;
        }
    }
}
