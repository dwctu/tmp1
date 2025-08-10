package io.agora.base.internal.video;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.agora.base.VideoFrame;
import io.agora.base.internal.ContextUtils;
import io.agora.base.internal.Logging;
import io.agora.base.internal.ThreadUtils;
import io.agora.base.internal.video.EglBase;
import io.agora.base.internal.video.RendererCommon;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class EglRenderer implements VideoSink {
    private static final boolean DEBUG = false;
    private static long DEFAULT_FRAME_INTERVAL_NANOS = 16666666;
    private static boolean ENABLE_LAST_FRAME = false;
    private static final long LOG_INTERVAL_SEC = 4;
    private static final int MAX_INVOKE_TIME_MS = 1000;
    private static final long NANOS_PER_SECOND = 1000000000;
    private static final String TAG = "EglRenderer";

    @Nullable
    private RendererCommon.GlDrawer drawer;

    @Nullable
    private EglBase eglBase;
    public boolean isFirstFrameRendered;
    private float layoutAspectRatio;
    private boolean layoutScaledFit;
    private long minRenderPeriodNs;
    private boolean mirror;
    public final String name;
    private long nextFrameTimeNs;
    private Rect rect;

    @Nullable
    private Handler renderThreadHandler;
    public RendererCommon.RendererEvents rendererEvents;
    private final Object handlerLock = new Object();
    private final Object surfaceLock = new Object();
    private final ArrayList<FrameListenerAndParams> frameListeners = new ArrayList<>();
    private final Object fpsReductionLock = new Object();
    private boolean eglContextAttached = false;
    private final VideoFrameDrawer frameDrawer = new VideoFrameDrawer();
    private final Matrix drawMatrix = new Matrix();

    @Nullable
    private VideoFrame lastFrame = null;
    private final Object layoutLock = new Object();
    private StatisticsInfo statisticsInfo = new StatisticsInfo();
    private long frameIntervalNanos = 0;
    private boolean switchToStartVsync = false;
    private boolean isVsyncCallbackStared = false;
    private boolean isRenderOnSurfaceView = false;
    private boolean surfaceValid = true;
    private volatile boolean isReleasing = false;
    private volatile boolean textureCoordUpdate = false;
    private final GlTextureFrameBuffer bitmapTextureFramebuffer = new GlTextureFrameBuffer(6408);
    private final Runnable logStatisticsRunnable = new Runnable() { // from class: io.agora.base.internal.video.EglRenderer.1
        @Override // java.lang.Runnable
        public void run() {
            EglRenderer.this.statisticsInfo.logStatistics();
            synchronized (EglRenderer.this.handlerLock) {
                if (EglRenderer.this.renderThreadHandler != null) {
                    EglRenderer.this.renderThreadHandler.removeCallbacks(EglRenderer.this.logStatisticsRunnable);
                    EglRenderer.this.renderThreadHandler.postDelayed(EglRenderer.this.logStatisticsRunnable, TimeUnit.SECONDS.toMillis(4L));
                }
            }
        }
    };
    private final EglSurfaceCreation eglSurfaceCreationRunnable = new EglSurfaceCreation();

    public class EglSurfaceCreation implements Runnable {
        private Object surface;

        private EglSurfaceCreation() {
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            if (this.surface != null && EglRenderer.this.eglBase != null && !EglRenderer.this.eglBase.hasSurface()) {
                Object obj = this.surface;
                if (obj instanceof Surface) {
                    EglRenderer.this.eglBase.createSurface((Surface) this.surface);
                } else {
                    if (!(obj instanceof SurfaceTexture)) {
                        throw new IllegalStateException("Invalid surface: " + this.surface);
                    }
                    EglRenderer.this.eglBase.createSurface((SurfaceTexture) this.surface);
                }
                EglRenderer.this.eglBase.makeCurrent();
                EglRenderer.this.eglContextAttached = true;
                GLES20.glPixelStorei(3317, 1);
            }
        }

        public synchronized void setSurface(Object obj) {
            this.surface = obj;
        }
    }

    public interface FrameListener {
        void onFrame(Bitmap bitmap);
    }

    public static class FrameListenerAndParams {
        public final boolean applyFpsReduction;
        public final RendererCommon.GlDrawer drawer;
        public final FrameListener listener;
        public final float scale;

        public FrameListenerAndParams(FrameListener frameListener, float f, RendererCommon.GlDrawer glDrawer, boolean z) {
            this.listener = frameListener;
            this.scale = f;
            this.drawer = glDrawer;
            this.applyFpsReduction = z;
        }
    }

    public static class HandlerWithFrameSyncControl extends Handler implements Choreographer.FrameCallback {
        private static final int MSG_SEND_CHOREOGRAPHER_QUIT_SIGNAL = 0;
        private static final int MSG_SEND_DROP_FRAME = 1;
        private static final int MSG_SEND_RENDER_FRAME_SIGNAL = 2;
        private static final int QUEUE_BUFFER = 3;
        private final Runnable exceptionCallback;
        private boolean isPreviousFrameDrawn;
        private VsyncStats lastPersionStats;
        private long mLastFrameTimeNanos;
        private final Object queueLock;
        private final Queue<VideoFrameInternal> renderFrames;
        private WeakReference<EglRenderer> weakRenderer;

        public HandlerWithFrameSyncControl(Looper looper, Runnable runnable, EglRenderer eglRenderer) {
            super(looper);
            this.queueLock = new Object();
            this.mLastFrameTimeNanos = 0L;
            this.lastPersionStats = VsyncStats.NORMAL;
            this.exceptionCallback = runnable;
            this.renderFrames = new LinkedList();
            this.weakRenderer = new WeakReference<>(eglRenderer);
            this.mLastFrameTimeNanos = 0L;
            this.isPreviousFrameDrawn = false;
        }

        private void doRenderFrame(long j) {
            VideoFrameInternal videoFrameInternalPoll;
            EglRenderer eglRenderer = this.weakRenderer.get();
            if (eglRenderer == null) {
                Logging.e(EglRenderer.TAG, "handleMessage: weak is null");
                return;
            }
            long j2 = 0;
            if (eglRenderer.frameIntervalNanos == 0) {
                return;
            }
            if (this.mLastFrameTimeNanos == 0) {
                this.mLastFrameTimeNanos = j;
            }
            long j3 = j - this.mLastFrameTimeNanos;
            this.mLastFrameTimeNanos = j;
            if (j3 >= eglRenderer.frameIntervalNanos + (eglRenderer.frameIntervalNanos / 2)) {
                j2 = j3 / eglRenderer.frameIntervalNanos;
                this.lastPersionStats = VsyncStats.DELAY;
            } else {
                this.lastPersionStats = VsyncStats.NORMAL;
            }
            eglRenderer.statisticsInfo.updateEveryVsyncStatistics(this.lastPersionStats, this.isPreviousFrameDrawn, j2, j3);
            this.isPreviousFrameDrawn = false;
            synchronized (this.queueLock) {
                videoFrameInternalPoll = this.renderFrames.poll();
            }
            if (videoFrameInternalPoll == null) {
                return;
            }
            this.isPreviousFrameDrawn = true;
            eglRenderer.renderFrameOnRenderThread(videoFrameInternalPoll, j);
        }

        private void stopChoreographer() {
            synchronized (this.queueLock) {
                Iterator<VideoFrameInternal> it = this.renderFrames.iterator();
                while (it.hasNext()) {
                    it.next().frame.release();
                }
                this.renderFrames.clear();
                Choreographer.getInstance().removeFrameCallback(this);
            }
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Exception e) {
                Logging.e(EglRenderer.TAG, "Exception on EglRenderer thread", e);
                this.exceptionCallback.run();
            }
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            EglRenderer eglRenderer = this.weakRenderer.get();
            if (eglRenderer == null) {
                Logging.e(EglRenderer.TAG, "doFrame: weak is null");
                return;
            }
            boolean unused = eglRenderer.isVsyncCallbackStared;
            eglRenderer.isVsyncCallbackStared = true;
            sendMessage(obtainMessage(2, new Long(j)));
            Choreographer.getInstance().postFrameCallback(this);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            EglRenderer eglRenderer = this.weakRenderer.get();
            if (eglRenderer == null) {
                Logging.e(EglRenderer.TAG, "handleMessage: weak is null");
                return;
            }
            int i = message.what;
            if (i == 0) {
                stopChoreographer();
                return;
            }
            if (i == 1) {
                RendererCommon.RendererEvents rendererEvents = eglRenderer.rendererEvents;
                if (rendererEvents != null) {
                    rendererEvents.onFrameDropped();
                }
                eglRenderer.statisticsInfo.updateFramesDropped();
                return;
            }
            if (i == 2) {
                long jNanoTime = System.nanoTime();
                Object obj = message.obj;
                if (obj != null) {
                    jNanoTime = ((Long) obj).longValue();
                }
                doRenderFrame(jNanoTime);
                return;
            }
            try {
                super.handleMessage(message);
            } catch (Exception e) {
                Logging.e(EglRenderer.TAG, "setRepeatingRequest failed, error message : " + e.getMessage());
            }
        }

        public void sendFrameToRenderThread(long j, VideoFrame videoFrame) {
            synchronized (this.queueLock) {
                videoFrame.retain();
                if (this.renderFrames.size() >= 3) {
                    VideoFrameInternal videoFrameInternalPoll = this.renderFrames.poll();
                    if (videoFrameInternalPoll != null) {
                        videoFrameInternalPoll.frame.release();
                    }
                    sendMessage(obtainMessage(1));
                }
                if (!this.renderFrames.add(new VideoFrameInternal(videoFrame, j))) {
                    Logging.e(EglRenderer.TAG, "offer error ");
                }
                EglRenderer eglRenderer = this.weakRenderer.get();
                if (eglRenderer != null && !eglRenderer.isVsyncCallbackStared) {
                    sendMessage(obtainMessage(2));
                }
            }
        }

        public void sendLastFrameToRenderThread(long j) {
            EglRenderer eglRenderer = this.weakRenderer.get();
            synchronized (this.queueLock) {
                if (EglRenderer.ENABLE_LAST_FRAME && eglRenderer != null) {
                    if (!this.renderFrames.add(new VideoFrameInternal(eglRenderer.lastFrame, j))) {
                        Logging.e(EglRenderer.TAG, "sendLastFrameToRenderThread offer error ");
                    }
                }
            }
        }

        public void sendStopChoreographer() {
            sendMessage(obtainMessage(0));
        }
    }

    public class StatisticsInfo {
        private long statisticsStartTimeNs = 0;
        private long framesReceived = 0;
        private long framesDropped = 0;
        private long framesRendered = 0;
        private long framesDrawTimeNs = 0;
        private long renderTimeNs = 0;
        private long renderSwapBufferTimeNs = 0;
        private int frameDrawn = 0;
        private Object statisticsLock = new Object();
        private long vsyncNum = 0;
        private long vsyncRenderJankCount = 0;

        public StatisticsInfo() {
        }

        private String averageTimeAsString(long j, long j2) {
            if (j2 <= 0) {
                return "NA";
            }
            return TimeUnit.NANOSECONDS.toMicros(j / j2) + " us";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void logStatistics() {
            DecimalFormat decimalFormat = new DecimalFormat("#.0");
            long jNanoTime = System.nanoTime();
            synchronized (this.statisticsLock) {
                long j = jNanoTime - this.statisticsStartTimeNs;
                if (j <= 0) {
                    return;
                }
                long j2 = this.framesRendered;
                TimeUnit timeUnit = TimeUnit.SECONDS;
                float f = j;
                float nanos = (j2 * timeUnit.toNanos(1L)) / f;
                float nanos2 = (this.framesReceived * timeUnit.toNanos(1L)) / f;
                EglRenderer.this.logD("logStatistics Duration: " + TimeUnit.NANOSECONDS.toMillis(j) + " ms. Frames received: " + this.framesReceived + ". Dropped: " + this.framesDropped + ". Rendered: " + this.framesRendered + ". vsync jank:" + this.vsyncRenderJankCount + ". received fps: " + decimalFormat.format(nanos2) + ". Render fps: " + decimalFormat.format(nanos) + ". Average frame draw time: " + averageTimeAsString(this.framesDrawTimeNs, this.framesRendered) + ". Average render time: " + averageTimeAsString(this.renderTimeNs, this.framesRendered) + ". Average swapBuffer time: " + averageTimeAsString(this.renderSwapBufferTimeNs, this.framesRendered) + ".");
                resetStatistics(jNanoTime);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void resetStatistics(long j) {
            synchronized (this.statisticsLock) {
                this.statisticsStartTimeNs = j;
                this.framesReceived = 0L;
                this.framesDropped = 0L;
                this.framesRendered = 0L;
                this.framesDrawTimeNs = 0L;
                this.renderTimeNs = 0L;
                this.renderSwapBufferTimeNs = 0L;
                this.vsyncRenderJankCount = 0L;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateEveryVsyncStatistics(VsyncStats vsyncStats, boolean z, long j, long j2) {
            synchronized (this.statisticsLock) {
                if (vsyncStats != VsyncStats.NORMAL) {
                    if (z) {
                        j--;
                    }
                    this.vsyncRenderJankCount += j;
                } else if (!z) {
                    this.vsyncRenderJankCount++;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateFrameReceived() {
            synchronized (this.statisticsLock) {
                this.framesReceived++;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateFramesDropped() {
            synchronized (this.statisticsLock) {
                this.framesDropped++;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateFramesHasDrawn(long j, long j2, long j3, long j4) {
            synchronized (this.statisticsLock) {
                this.framesRendered++;
                this.framesDrawTimeNs += j - j2;
                this.renderTimeNs += j - j3;
                this.renderSwapBufferTimeNs += j - j4;
                this.frameDrawn++;
            }
        }
    }

    public static class VideoFrameInternal {
        public VideoFrame frame;
        public long frameDrawStartTimeNs;

        public VideoFrameInternal(VideoFrame videoFrame, long j) {
            this.frame = videoFrame;
            this.frameDrawStartTimeNs = j;
        }
    }

    public enum VsyncStats {
        NORMAL,
        DELAY
    }

    public EglRenderer(String str) {
        this.name = str;
    }

    private void checkHDR() {
        VideoRenderUtils.isSupportedHDRByType(2);
        VideoRenderUtils.getDesiredMaxAverageLuminance();
        VideoRenderUtils.getDesiredMaxLuminance();
        VideoRenderUtils.getDesiredMinLuminance();
        VideoRenderUtils.isWideColorGamut();
        VideoRenderUtils.getPreferredWideGamutColorSpaceId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSurfaceOnRenderThread(float f, float f2, float f3, float f4) {
        EglBase eglBase = this.eglBase;
        if (eglBase == null || !eglBase.hasSurface()) {
            return;
        }
        logD("clearSurface");
        GLES20.glClearColor(f, f2, f3, f4);
        GLES20.glClear(16384);
        this.eglBase.swapBuffers();
    }

    private float[] convertRectFromAndroidGraphicsRect(Rect rect, VideoFrame videoFrame) {
        float rotatedHeight;
        float rotatedHeight2;
        float rotatedWidth;
        float f;
        int rotatedWidth2;
        float rotatedWidth3;
        float f2;
        int rotatedWidth4;
        float f3;
        int rotation = videoFrame.getRotation() % 360;
        float f4 = 0.0f;
        float f5 = 1.0f;
        if (rotation == 0) {
            rotatedHeight = 1.0f - (rect.top / videoFrame.getRotatedHeight());
            rotatedHeight2 = 1.0f - (rect.bottom / videoFrame.getRotatedHeight());
            if (this.mirror) {
                rotatedWidth3 = 1.0f - (rect.right / videoFrame.getRotatedWidth());
                f2 = rect.left;
                rotatedWidth4 = videoFrame.getRotatedWidth();
                f5 = 1.0f - (f2 / rotatedWidth4);
                f3 = rotatedHeight2;
                f4 = rotatedWidth3;
            } else {
                rotatedWidth = rect.left / videoFrame.getRotatedWidth();
                f = rect.right;
                rotatedWidth2 = videoFrame.getRotatedWidth();
                float f6 = rotatedWidth;
                f5 = f / rotatedWidth2;
                f3 = rotatedHeight2;
                f4 = f6;
            }
        } else if (rotation == 90) {
            rotatedHeight = 1.0f - (rect.left / videoFrame.getRotatedWidth());
            rotatedHeight2 = 1.0f - (rect.right / videoFrame.getRotatedWidth());
            if (this.mirror) {
                rotatedWidth = rect.top / videoFrame.getRotatedHeight();
                f = rect.bottom;
                rotatedWidth2 = videoFrame.getRotatedHeight();
                float f62 = rotatedWidth;
                f5 = f / rotatedWidth2;
                f3 = rotatedHeight2;
                f4 = f62;
            } else {
                rotatedWidth3 = 1.0f - (rect.bottom / videoFrame.getRotatedHeight());
                f2 = rect.top;
                rotatedWidth4 = videoFrame.getRotatedHeight();
                f5 = 1.0f - (f2 / rotatedWidth4);
                f3 = rotatedHeight2;
                f4 = rotatedWidth3;
            }
        } else if (rotation == 180) {
            rotatedHeight = rect.bottom / videoFrame.getRotatedHeight();
            rotatedHeight2 = rect.top / videoFrame.getRotatedHeight();
            if (this.mirror) {
                rotatedWidth = rect.left / videoFrame.getRotatedWidth();
                f = rect.right;
                rotatedWidth2 = videoFrame.getRotatedWidth();
                float f622 = rotatedWidth;
                f5 = f / rotatedWidth2;
                f3 = rotatedHeight2;
                f4 = f622;
            } else {
                rotatedWidth3 = 1.0f - (rect.right / videoFrame.getRotatedWidth());
                f2 = rect.left;
                rotatedWidth4 = videoFrame.getRotatedWidth();
                f5 = 1.0f - (f2 / rotatedWidth4);
                f3 = rotatedHeight2;
                f4 = rotatedWidth3;
            }
        } else if (rotation != 270) {
            f3 = 0.0f;
            rotatedHeight = 1.0f;
        } else {
            rotatedHeight = rect.right / videoFrame.getRotatedWidth();
            rotatedHeight2 = rect.left / videoFrame.getRotatedWidth();
            if (this.mirror) {
                rotatedWidth3 = 1.0f - (rect.bottom / videoFrame.getRotatedHeight());
                f2 = rect.top;
                rotatedWidth4 = videoFrame.getRotatedHeight();
                f5 = 1.0f - (f2 / rotatedWidth4);
                f3 = rotatedHeight2;
                f4 = rotatedWidth3;
            } else {
                rotatedWidth = rect.top / videoFrame.getRotatedHeight();
                f = rect.bottom;
                rotatedWidth2 = videoFrame.getRotatedHeight();
                float f6222 = rotatedWidth;
                f5 = f / rotatedWidth2;
                f3 = rotatedHeight2;
                f4 = f6222;
            }
        }
        logD("rotation " + (videoFrame.getRotation() % 360) + " mirror " + this.mirror + " left " + f4 + " right " + f5 + " top " + rotatedHeight + " bottom " + f3);
        return new float[]{f4, f3, f5, f3, f4, rotatedHeight, f5, rotatedHeight};
    }

    private void createEglSurfaceInternal(Object obj) {
        this.eglSurfaceCreationRunnable.setSurface(obj);
        synchronized (this.surfaceLock) {
            this.surfaceValid = true;
        }
        postToRenderThread(this.eglSurfaceCreationRunnable);
    }

    public static double getDefaultDisplayRefreshRateParams() {
        WindowManager windowManager;
        Display defaultDisplay;
        return (ContextUtils.getApplicationContext() == null || (windowManager = (WindowManager) ContextUtils.getApplicationContext().getSystemService("window")) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : defaultDisplay.getRefreshRate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logD(String str) {
        Logging.d(TAG, this.name + str);
    }

    private void notifyCallbacks(VideoFrame videoFrame, boolean z) {
        ByteBuffer byteBufferAllocateDirect;
        if (this.frameListeners.isEmpty()) {
            return;
        }
        this.drawMatrix.reset();
        this.drawMatrix.preTranslate(0.5f, 0.5f);
        if (this.mirror) {
            this.drawMatrix.preScale(-1.0f, 1.0f);
        }
        this.drawMatrix.preScale(1.0f, -1.0f);
        this.drawMatrix.preTranslate(-0.5f, -0.5f);
        Iterator<FrameListenerAndParams> it = this.frameListeners.iterator();
        while (it.hasNext()) {
            FrameListenerAndParams next = it.next();
            if (z || !next.applyFpsReduction) {
                it.remove();
                int rotatedWidth = (int) (next.scale * videoFrame.getRotatedWidth());
                int rotatedHeight = (int) (next.scale * videoFrame.getRotatedHeight());
                if (rotatedWidth == 0 || rotatedHeight == 0) {
                    next.listener.onFrame(null);
                } else {
                    this.bitmapTextureFramebuffer.setSize(rotatedWidth, rotatedHeight);
                    GLES20.glBindFramebuffer(36160, this.bitmapTextureFramebuffer.getFrameBufferId());
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.bitmapTextureFramebuffer.getTextureId(), 0);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                    GLES20.glClear(16384);
                    this.frameDrawer.drawFrame(videoFrame, next.drawer, this.drawMatrix, 0, 0, rotatedWidth, rotatedHeight);
                    try {
                        byteBufferAllocateDirect = ByteBuffer.allocateDirect(rotatedWidth * rotatedHeight * 4);
                    } catch (IllegalArgumentException e) {
                        ThrowableExtension.printStackTrace(e);
                        byteBufferAllocateDirect = null;
                    }
                    GLES20.glViewport(0, 0, rotatedWidth, rotatedHeight);
                    GLES20.glReadPixels(0, 0, rotatedWidth, rotatedHeight, 6408, 5121, byteBufferAllocateDirect);
                    GLES20.glBindFramebuffer(36160, 0);
                    GlUtil.checkNoGLES2Error("EglRenderer.notifyCallbacks");
                    try {
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(rotatedWidth, rotatedHeight, Bitmap.Config.ARGB_8888);
                        bitmapCreateBitmap.copyPixelsFromBuffer(byteBufferAllocateDirect);
                        next.listener.onFrame(bitmapCreateBitmap);
                    } catch (IllegalArgumentException e2) {
                        ThrowableExtension.printStackTrace(e2);
                    } catch (IllegalStateException e3) {
                        ThrowableExtension.printStackTrace(e3);
                    }
                }
            }
        }
    }

    private void postToRenderThread(Runnable runnable) {
        synchronized (this.handlerLock) {
            Handler handler = this.renderThreadHandler;
            if (handler != null) {
                handler.post(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0163  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void renderFrameOnRenderThread(io.agora.base.internal.video.EglRenderer.VideoFrameInternal r23, long r24) {
        /*
            Method dump skipped, instructions count: 510
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.base.internal.video.EglRenderer.renderFrameOnRenderThread(io.agora.base.internal.video.EglRenderer$VideoFrameInternal, long):void");
    }

    public void addFrameListener(FrameListener frameListener, float f) {
        addFrameListener(frameListener, f, null, false);
    }

    public void clearImage() {
        clearImage(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void createEglSurface(Surface surface) {
        createEglSurfaceInternal(surface);
    }

    public void disableFpsReduction() {
        setFpsReduction(Float.POSITIVE_INFINITY);
    }

    public int getFrameDrawn() {
        return this.statisticsInfo.frameDrawn;
    }

    public void init(@Nullable final EglBase.Context context, final int[] iArr, RendererCommon.GlDrawer glDrawer, boolean z) {
        synchronized (this.handlerLock) {
            if (this.renderThreadHandler != null) {
                throw new IllegalStateException(this.name + "Already initialized");
            }
            logD("Initializing EglRenderer");
            this.drawer = glDrawer;
            this.isReleasing = false;
            HandlerThread handlerThread = new HandlerThread(this.name + TAG);
            handlerThread.start();
            if (getDefaultDisplayRefreshRateParams() != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                this.frameIntervalNanos = new Double(1.0E9d / getDefaultDisplayRefreshRateParams()).longValue();
            } else {
                this.frameIntervalNanos = DEFAULT_FRAME_INTERVAL_NANOS;
            }
            HandlerWithFrameSyncControl handlerWithFrameSyncControl = new HandlerWithFrameSyncControl(handlerThread.getLooper(), new Runnable() { // from class: io.agora.base.internal.video.EglRenderer.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (EglRenderer.this.surfaceLock) {
                        EglRenderer.this.logD("Initializing EglRenderer set surfaceValid.");
                        EglRenderer.this.surfaceValid = false;
                    }
                }
            }, this);
            this.renderThreadHandler = handlerWithFrameSyncControl;
            ThreadUtils.invokeAtFrontUninterruptibly(handlerWithFrameSyncControl, new Runnable() { // from class: io.agora.base.internal.video.EglRenderer.3
                @Override // java.lang.Runnable
                public void run() {
                    if (context == null) {
                        EglRenderer.this.logD("EglBase10.create context");
                        EglRenderer.this.eglBase = EglBaseFactory.createEgl10(iArr);
                    } else {
                        EglRenderer.this.logD("EglBase.create shared context");
                        EglRenderer.this.eglBase = EglBaseFactory.create(context, iArr);
                    }
                }
            });
            this.switchToStartVsync = z;
            logD("renderThreadHandler useVsync:" + z);
            if (this.switchToStartVsync) {
                this.renderThreadHandler.post(new Runnable() { // from class: io.agora.base.internal.video.EglRenderer.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Choreographer.getInstance().postFrameCallback((Choreographer.FrameCallback) EglRenderer.this.renderThreadHandler);
                            EglRenderer.this.logD("renderThreadHandler Choreographer start");
                        } catch (Exception e) {
                            Logging.e(EglRenderer.TAG, "Exception on Choreographer start and not use vsync to render", e);
                        }
                    }
                });
            } else {
                logD("renderThreadHandler Choreographer disable");
            }
            this.renderThreadHandler.post(this.eglSurfaceCreationRunnable);
            this.statisticsInfo.resetStatistics(System.nanoTime());
            this.renderThreadHandler.postDelayed(this.logStatisticsRunnable, TimeUnit.SECONDS.toMillis(4L));
        }
    }

    public void isRenderOnSurfaceView(boolean z) {
        this.isRenderOnSurfaceView = z;
    }

    public void notifySurfaceSizeChanged() {
        if (ENABLE_LAST_FRAME) {
            synchronized (this.handlerLock) {
                if (this.renderThreadHandler == null) {
                    logD("notifySurfaceSizeChanged ");
                    return;
                }
                if (this.lastFrame != null) {
                    ((HandlerWithFrameSyncControl) this.renderThreadHandler).sendLastFrameToRenderThread(System.nanoTime());
                }
            }
        }
    }

    @Override // io.agora.base.internal.video.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        this.statisticsInfo.updateFrameReceived();
        long jNanoTime = System.nanoTime();
        synchronized (this.surfaceLock) {
            if (!this.surfaceValid) {
                logD("Dropping frame - Not valid surface.");
                return;
            }
            synchronized (this.handlerLock) {
                Handler handler = this.renderThreadHandler;
                if (handler == null) {
                    logD("Dropping frame - Not initialized or already released.");
                } else {
                    ((HandlerWithFrameSyncControl) handler).sendFrameToRenderThread(jNanoTime, videoFrame);
                }
            }
        }
    }

    public void pauseVideo() {
        setFpsReduction(0.0f);
    }

    public void printStackTrace() {
        synchronized (this.handlerLock) {
            Handler handler = this.renderThreadHandler;
            Thread thread = handler == null ? null : handler.getLooper().getThread();
            if (thread != null) {
                StackTraceElement[] stackTrace = thread.getStackTrace();
                if (stackTrace.length > 0) {
                    logD("EglRenderer stack trace:");
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        logD(stackTraceElement.toString());
                    }
                }
            }
        }
    }

    public void release() {
        VideoFrame videoFrame;
        logD("Releasing.");
        this.isReleasing = true;
        synchronized (this.handlerLock) {
            Handler handler = this.renderThreadHandler;
            if (handler == null) {
                logD("Already released");
                return;
            }
            handler.removeCallbacks(this.logStatisticsRunnable);
            try {
                ThreadUtils.invokeAtFrontUninterruptibly(this.renderThreadHandler, 1000L, new Callable<Void>() { // from class: io.agora.base.internal.video.EglRenderer.5
                    @Override // java.util.concurrent.Callable
                    public Void call() throws Exception {
                        EglRenderer.this.logD("release egl and gl resources on render thread");
                        if (!EglRenderer.this.eglContextAttached && EglRenderer.this.eglBase != null && !EglRenderer.this.eglBase.hasSurface()) {
                            EglRenderer.this.logD("egl context not attached, make current to release gl resource");
                            try {
                                EglRenderer.this.eglBase.createDummyPbufferSurface();
                                EglRenderer.this.eglBase.makeCurrent();
                                EglRenderer.this.eglContextAttached = true;
                            } catch (RuntimeException e) {
                                EglRenderer.this.logD("failed to make current: " + e);
                            }
                        }
                        synchronized (EglBase.lock) {
                            GLES20.glUseProgram(0);
                        }
                        if (EglRenderer.this.drawer != null) {
                            EglRenderer.this.drawer.release();
                            EglRenderer.this.drawer = null;
                        }
                        EglRenderer.this.frameDrawer.release();
                        EglRenderer.this.bitmapTextureFramebuffer.release();
                        if (EglRenderer.this.eglBase != null) {
                            EglRenderer.this.logD("eglBase detach and release.");
                            EglRenderer.this.eglBase.detachCurrent();
                            EglRenderer.this.eglContextAttached = false;
                            EglRenderer.this.eglBase.release();
                            EglRenderer.this.eglBase = null;
                        }
                        EglRenderer.this.frameListeners.clear();
                        return null;
                    }
                });
            } catch (Exception e) {
                logD("failed to make current and detach: " + e);
            }
            ((HandlerWithFrameSyncControl) this.renderThreadHandler).sendStopChoreographer();
            this.renderThreadHandler.getLooper().quitSafely();
            this.renderThreadHandler = null;
            this.isVsyncCallbackStared = false;
            if (ENABLE_LAST_FRAME && (videoFrame = this.lastFrame) != null) {
                videoFrame.release();
                this.lastFrame = null;
            }
            logD("Releasing done.");
        }
    }

    public void releaseEglSurface() {
        synchronized (this.surfaceLock) {
            this.surfaceValid = false;
        }
        logD("releaseEglSurface");
        this.eglSurfaceCreationRunnable.setSurface(null);
        synchronized (this.handlerLock) {
            Handler handler = this.renderThreadHandler;
            if (handler != null) {
                try {
                    handler.removeCallbacks(this.eglSurfaceCreationRunnable);
                    logD("invoke releaseEglSurface");
                    ThreadUtils.invokeAtFrontUninterruptibly(this.renderThreadHandler, 1000L, new Callable<Void>() { // from class: io.agora.base.internal.video.EglRenderer.9
                        @Override // java.util.concurrent.Callable
                        public Void call() throws Exception {
                            EglRenderer.this.logD("detach egl context and release egl surface");
                            if (EglRenderer.this.eglContextAttached && EglRenderer.this.eglBase != null) {
                                EglRenderer.this.eglBase.detachCurrent();
                                EglRenderer.this.eglContextAttached = false;
                                EglRenderer.this.eglBase.releaseSurface();
                            }
                            EglRenderer.this.logD("releaseEglSurface in renderThread done.");
                            return null;
                        }
                    });
                } catch (Exception e) {
                    logD("failed to release surface: " + e);
                }
            }
        }
    }

    public void removeFrameListener(final FrameListener frameListener) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        synchronized (this.handlerLock) {
            if (this.renderThreadHandler == null) {
                return;
            }
            if (Thread.currentThread() == this.renderThreadHandler.getLooper().getThread()) {
                throw new RuntimeException("removeFrameListener must not be called on the render thread.");
            }
            postToRenderThread(new Runnable() { // from class: io.agora.base.internal.video.EglRenderer.8
                @Override // java.lang.Runnable
                public void run() {
                    countDownLatch.countDown();
                    Iterator it = EglRenderer.this.frameListeners.iterator();
                    while (it.hasNext()) {
                        if (((FrameListenerAndParams) it.next()).listener == frameListener) {
                            it.remove();
                        }
                    }
                }
            });
            ThreadUtils.awaitUninterruptibly(countDownLatch);
        }
    }

    public void setFpsReduction(float f) {
        logD("setFpsReduction: " + f);
        synchronized (this.fpsReductionLock) {
            long j = this.minRenderPeriodNs;
            if (f <= 0.0f) {
                this.minRenderPeriodNs = Long.MAX_VALUE;
            } else {
                this.minRenderPeriodNs = (long) (TimeUnit.SECONDS.toNanos(1L) / f);
            }
            if (this.minRenderPeriodNs != j) {
                this.nextFrameTimeNs = System.nanoTime();
            }
        }
    }

    public void setLayoutAspectRatio(float f) {
        logD("setLayoutAspectRatio: " + f);
        synchronized (this.layoutLock) {
            this.layoutAspectRatio = f;
        }
    }

    public void setLayoutScaledFit(boolean z) {
        logD("layoutScaledFit: " + z);
        synchronized (this.layoutLock) {
            this.layoutScaledFit = z;
        }
    }

    public void setMirror(boolean z) {
        logD("setMirror: " + z);
        synchronized (this.layoutLock) {
            if (this.mirror != z) {
                this.mirror = z;
                this.textureCoordUpdate = true;
            }
        }
    }

    public void updateCropArea(Rect rect) {
        logD("updateCropArea: " + rect.toString());
        synchronized (this.layoutLock) {
            Rect rect2 = this.rect;
            if (rect2 == null && rect != null) {
                this.rect = rect;
                this.textureCoordUpdate = true;
            } else if (rect2 != null && rect != null && !rect2.equals(rect)) {
                this.rect = rect;
                this.textureCoordUpdate = true;
            }
        }
    }

    public void updateVsyncDuration(final long j) {
        Handler handler = this.renderThreadHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: io.agora.base.internal.video.EglRenderer.6
                @Override // java.lang.Runnable
                public void run() {
                    EglRenderer.this.logD("update vsync duration, old:" + EglRenderer.this.frameIntervalNanos + " new:" + j);
                    EglRenderer.this.frameIntervalNanos = j;
                }
            });
        }
    }

    public void addFrameListener(FrameListener frameListener, float f, RendererCommon.GlDrawer glDrawer) {
        addFrameListener(frameListener, f, glDrawer, false);
    }

    public void clearImage(final float f, final float f2, final float f3, final float f4) {
        synchronized (this.handlerLock) {
            Handler handler = this.renderThreadHandler;
            if (handler == null) {
                return;
            }
            handler.postAtFrontOfQueue(new Runnable() { // from class: io.agora.base.internal.video.EglRenderer.10
                @Override // java.lang.Runnable
                public void run() {
                    EglRenderer.this.clearSurfaceOnRenderThread(f, f2, f3, f4);
                }
            });
        }
    }

    public void createEglSurface(SurfaceTexture surfaceTexture) {
        createEglSurfaceInternal(surfaceTexture);
    }

    public void addFrameListener(final FrameListener frameListener, final float f, @Nullable final RendererCommon.GlDrawer glDrawer, final boolean z) {
        postToRenderThread(new Runnable() { // from class: io.agora.base.internal.video.EglRenderer.7
            @Override // java.lang.Runnable
            public void run() {
                RendererCommon.GlDrawer glDrawer2 = glDrawer;
                if (glDrawer2 == null) {
                    glDrawer2 = EglRenderer.this.drawer;
                }
                EglRenderer.this.frameListeners.add(new FrameListenerAndParams(frameListener, f, glDrawer2, z));
            }
        });
    }
}
