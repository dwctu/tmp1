package io.agora.rtc2.internal;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.agora.base.VideoFrame;
import io.agora.base.internal.CalledByNative;
import io.agora.base.internal.ContextUtils;
import io.agora.base.internal.SurfaceEglRenderer;
import io.agora.base.internal.ThreadUtils;
import io.agora.base.internal.video.EglBase;
import io.agora.base.internal.video.GlRectDrawer;
import io.agora.base.internal.video.RendererCommon;
import io.agora.base.internal.video.VideoSink;
import java.util.Random;

/* loaded from: classes4.dex */
public abstract class SurfaceEglRendererHelper implements VideoSink, RendererCommon.RendererEvents, View.OnLayoutChangeListener {
    private static final int DEFAULT_DISPLAY_REFRESH_RATE = 60;
    private static final long NANOS_PER_SECOND = 1000000000;
    private static final String TAG = "SurfaceEglRendererHelper";
    public volatile boolean disposed;

    @NonNull
    public SurfaceEglRenderer eglRenderer;
    private final Handler handler;
    public long nativeVideoRendererAndroid;
    public volatile Rect rect;
    public final String resourceName;
    private EglBase.Context sharedContext;

    @NonNull
    public final View view;
    private int viewHeight;
    private int viewWidth;
    public final Object nativeLock = new Object();
    public final Object eglRenderLock = new Object();
    public RenderConfig renderConfig = new RenderConfig();
    private long vsyncDurationNs = 0;

    @Nullable
    private DefaultDisplayListener displayListener = null;

    @RequiresApi(17)
    public final class DefaultDisplayListener implements DisplayManager.DisplayListener {
        private final DisplayManager displayManager;

        public DefaultDisplayListener(DisplayManager displayManager) {
            this.displayManager = displayManager;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            if (i == 0) {
                SurfaceEglRendererHelper.this.updateDefaultDisplayRefreshRateParams();
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }

        public void register() {
            this.displayManager.registerDisplayListener(this, SurfaceEglRendererHelper.this.handler);
        }

        public void unregister() {
            this.displayManager.unregisterDisplayListener(this);
        }
    }

    public @interface RenderModeType {
        public static final int RENDER_MODE_ADAPTIVE = 3;
        public static final int RENDER_MODE_FIT = 2;
        public static final int RENDER_MODE_HIDDEN = 1;
    }

    public static class SurfaceViewEglRenderHelper extends SurfaceEglRendererHelper implements SurfaceHolder.Callback {
        private final SurfaceHolder holder;

        @NonNull
        private final SurfaceView renderView;

        public SurfaceViewEglRenderHelper(long j, @NonNull SurfaceView surfaceView) {
            super(j, surfaceView);
            this.renderView = surfaceView;
            this.holder = surfaceView.getHolder();
        }

        @Override // io.agora.rtc2.internal.SurfaceEglRendererHelper
        public void checkAndSetExistSurface() {
            ThreadUtils.checkIsOnMainThread();
            synchronized (this.eglRenderLock) {
                if (this.disposed) {
                    return;
                }
                Surface surface = this.holder.getSurface();
                if (surface != null && surface.isValid()) {
                    surfaceCreated(this.holder);
                    surfaceChanged(this.holder, 0, this.renderView.getWidth(), this.renderView.getHeight());
                    this.eglRenderer.surfaceCreated(this.holder);
                }
            }
        }

        @Override // io.agora.rtc2.internal.SurfaceEglRendererHelper
        public void dispose() {
            super.dispose();
            if (this.disposed) {
                return;
            }
            synchronized (this.eglRenderLock) {
                this.disposed = true;
                logD("dispose()");
                this.holder.removeCallback(this);
                this.holder.removeCallback(this.eglRenderer);
                this.eglRenderer.release();
            }
            synchronized (this.nativeLock) {
                this.nativeVideoRendererAndroid = 0L;
            }
        }

        @Override // io.agora.rtc2.internal.SurfaceEglRendererHelper
        public boolean initImpl(EglBase.Context context, RenderConfig renderConfig) {
            if (this.holder == null) {
                io.agora.base.internal.Logging.e(SurfaceEglRendererHelper.TAG, "error! holder is null");
                return false;
            }
            if (!super.initImpl(context, renderConfig)) {
                return false;
            }
            this.holder.addCallback(this);
            this.holder.addCallback(this.eglRenderer);
            return true;
        }

        @Override // io.agora.rtc2.internal.SurfaceEglRendererHelper
        public void reInit(EglBase.Context context) {
            logD("reInit()");
            synchronized (this.eglRenderLock) {
                if (this.disposed) {
                    return;
                }
                this.holder.removeCallback(this.eglRenderer);
                this.eglRenderer.release();
                SurfaceEglRenderer surfaceEglRenderer = new SurfaceEglRenderer(this.resourceName);
                this.eglRenderer = surfaceEglRenderer;
                surfaceEglRenderer.isRenderOnSurfaceView(true);
                initImpl(context, this.renderConfig);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            logD("surfaceChanged():" + i2 + " height:" + i3 + " format:" + i);
            synchronized (this.nativeLock) {
                long j = this.nativeVideoRendererAndroid;
                if (j != 0) {
                    nativeNotifySurfaceSizeChanged(j, i2, i3);
                }
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            logD("surfaceCreated()");
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            logD("surfaceDestroyed()");
        }
    }

    public static class TextureViewEglRenderHelper extends SurfaceEglRendererHelper implements TextureView.SurfaceTextureListener {

        @NonNull
        private final TextureView renderView;

        public TextureViewEglRenderHelper(long j, @NonNull TextureView textureView) {
            super(j, textureView);
            this.renderView = textureView;
        }

        @Override // io.agora.rtc2.internal.SurfaceEglRendererHelper
        public void checkAndSetExistSurface() {
            ThreadUtils.checkIsOnMainThread();
            synchronized (this.eglRenderLock) {
                if (this.disposed) {
                    return;
                }
                SurfaceTexture surfaceTexture = this.renderView.getSurfaceTexture();
                if (surfaceTexture != null) {
                    onSurfaceTextureAvailable(surfaceTexture, 0, 0);
                    onSurfaceTextureSizeChanged(surfaceTexture, this.renderView.getWidth(), this.renderView.getHeight());
                }
            }
        }

        @Override // io.agora.rtc2.internal.SurfaceEglRendererHelper
        public void dispose() {
            super.dispose();
            if (this.disposed) {
                return;
            }
            synchronized (this.eglRenderLock) {
                this.disposed = true;
                logD("dispose()");
                this.renderView.setSurfaceTextureListener(null);
                this.eglRenderer.release();
            }
            synchronized (this.nativeLock) {
                this.nativeVideoRendererAndroid = 0L;
            }
        }

        @Override // io.agora.rtc2.internal.SurfaceEglRendererHelper
        public boolean initImpl(EglBase.Context context, RenderConfig renderConfig) {
            if (!super.initImpl(context, renderConfig)) {
                return false;
            }
            this.renderView.setSurfaceTextureListener(this);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            logD("onSurfaceTextureAvailable = " + surfaceTexture);
            ThreadUtils.checkIsOnMainThread();
            this.eglRenderer.onSurfaceTextureAvailable(surfaceTexture, i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            logD("onSurfaceTextureSizeChanged = " + surfaceTexture);
            this.eglRenderer.onSurfaceTextureDestroyed(surfaceTexture);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            logD("onSurfaceTextureSizeChanged = " + surfaceTexture);
            this.eglRenderer.onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
            synchronized (this.nativeLock) {
                long j = this.nativeVideoRendererAndroid;
                if (j != 0) {
                    nativeNotifySurfaceSizeChanged(j, i, i2);
                }
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // io.agora.rtc2.internal.SurfaceEglRendererHelper
        public void reInit(EglBase.Context context) {
            logD("reInit()");
            synchronized (this.eglRenderLock) {
                if (this.disposed) {
                    return;
                }
                this.renderView.setSurfaceTextureListener(null);
                this.eglRenderer.release();
                SurfaceEglRenderer surfaceEglRenderer = new SurfaceEglRenderer(this.resourceName);
                this.eglRenderer = surfaceEglRenderer;
                surfaceEglRenderer.isRenderOnSurfaceView(false);
                initImpl(context, this.renderConfig);
            }
        }
    }

    public SurfaceEglRendererHelper(long j, @NonNull View view) {
        this.nativeVideoRendererAndroid = j;
        this.view = view;
        String resourceName = getResourceName(view);
        this.resourceName = resourceName;
        this.eglRenderer = new SurfaceEglRenderer(resourceName);
        this.handler = new Handler(Looper.getMainLooper());
        this.disposed = false;
        this.viewWidth = view.getWidth();
        this.viewHeight = view.getHeight();
        view.addOnLayoutChangeListener(this);
        registerDisplayListener();
    }

    private String getResourceName(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "" + Math.abs(new Random().nextInt());
        }
    }

    private int getViewHeight() {
        if (this.viewHeight == 0) {
            this.viewHeight = this.view.getHeight();
        }
        return this.viewHeight;
    }

    private int getViewWidth() {
        if (this.viewWidth == 0) {
            this.viewWidth = this.view.getWidth();
        }
        return this.viewWidth;
    }

    @RequiresApi(17)
    private DefaultDisplayListener maybeBuildDefaultDisplayListenerV17(Context context) {
        DisplayManager displayManager;
        if (ContextUtils.getApplicationContext() == null || (displayManager = (DisplayManager) ContextUtils.getApplicationContext().getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION)) == null) {
            return null;
        }
        return new DefaultDisplayListener(displayManager);
    }

    @CalledByNative
    public static SurfaceEglRendererHelper newInstance(long j, View view) {
        if (view instanceof SurfaceView) {
            return new SurfaceViewEglRenderHelper(j, (SurfaceView) view);
        }
        if (view instanceof TextureView) {
            return new TextureViewEglRenderHelper(j, (TextureView) view);
        }
        return null;
    }

    private static boolean objectsEquals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void postOrRun(Runnable runnable) {
        if (Thread.currentThread() == this.handler.getLooper().getThread()) {
            runnable.run();
        } else {
            this.handler.post(runnable);
        }
    }

    private void registerDisplayListener() {
        logD("registerDisplayListener");
        if ((ContextUtils.getApplicationContext() != null ? (WindowManager) ContextUtils.getApplicationContext().getSystemService("window") : null) == null || ContextUtils.getApplicationContext() == null) {
            this.displayListener = null;
        } else {
            this.displayListener = Build.VERSION.SDK_INT >= 17 ? maybeBuildDefaultDisplayListenerV17(ContextUtils.getApplicationContext()) : null;
        }
        DefaultDisplayListener defaultDisplayListener = this.displayListener;
        if (defaultDisplayListener == null || Build.VERSION.SDK_INT < 17) {
            return;
        }
        defaultDisplayListener.register();
    }

    private void unregisterDisplayListener() {
        DefaultDisplayListener defaultDisplayListener = this.displayListener;
        if (defaultDisplayListener == null || Build.VERSION.SDK_INT < 17) {
            return;
        }
        defaultDisplayListener.unregister();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDefaultDisplayRefreshRateParams() {
        if (ContextUtils.getApplicationContext() == null) {
            this.vsyncDurationNs = 0L;
            return;
        }
        WindowManager windowManager = (WindowManager) ContextUtils.getApplicationContext().getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            if (defaultDisplay != null) {
                double refreshRate = defaultDisplay.getRefreshRate();
                if (refreshRate == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    refreshRate = 60.0d;
                }
                this.vsyncDurationNs = (long) (1.0E9d / refreshRate);
            } else {
                logD("Unable to query display refresh rate, set to default 60 fps");
                this.vsyncDurationNs = 16666666L;
            }
            SurfaceEglRenderer surfaceEglRenderer = this.eglRenderer;
            if (surfaceEglRenderer != null) {
                surfaceEglRenderer.updateVsyncDuration(this.vsyncDurationNs);
            }
        }
    }

    public abstract void checkAndSetExistSurface();

    @CalledByNative
    public void dispose() {
        this.view.removeOnLayoutChangeListener(this);
        unregisterDisplayListener();
    }

    @CalledByNative
    public int getFrameDrawn() {
        return this.eglRenderer.getFrameDrawn();
    }

    @CalledByNative
    public final boolean init(EglBase.Context context, boolean z, int i, boolean z2) {
        try {
            this.renderConfig.setRenderMode(i);
            this.renderConfig.setMirror(z);
            this.renderConfig.setUseVsync(z2);
            return initImpl(context, this.renderConfig);
        } catch (Throwable th) {
            io.agora.base.internal.Logging.w(TAG, " Failed to init eglRender", th);
            return false;
        }
    }

    public boolean initImpl(EglBase.Context context, RenderConfig renderConfig) {
        this.sharedContext = context;
        this.renderConfig.setMirror(renderConfig.isMirror());
        logD("init() [mirror: " + renderConfig.isMirror() + ", renderMode: " + renderConfig.getRenderMode() + "]");
        this.eglRenderer.init(context, this, EglBase.CONFIG_PLAIN, new GlRectDrawer(), renderConfig.isUseVsync());
        this.eglRenderer.setMirror(renderConfig.isMirror());
        setRenderMode(renderConfig.getRenderMode());
        postOrRun(new Runnable() { // from class: io.agora.rtc2.internal.SurfaceEglRendererHelper.1
            @Override // java.lang.Runnable
            public void run() {
                SurfaceEglRendererHelper.this.checkAndSetExistSurface();
            }
        });
        return true;
    }

    public void logD(String str) {
        io.agora.base.internal.Logging.d(TAG, this.resourceName + ": " + str);
    }

    public native void nativeNofityFrameDrawn(long j, long j2);

    public native void nativeNofityFrameDropped(long j);

    public native void nativeNotifyFirstVideoFrame(long j, int i, int i2, int i3);

    public native void nativeNotifySurfaceSizeChanged(long j, int i, int i2);

    @Override // io.agora.base.internal.video.RendererCommon.RendererEvents
    public void onFirstFrameRendered(int i, int i2, int i3) {
        logD("onFirstFrameRendered videoWidth:" + i + " videoHeight:" + i2 + " rotation:" + i3);
        synchronized (this.nativeLock) {
            long j = this.nativeVideoRendererAndroid;
            if (j != 0) {
                nativeNotifyFirstVideoFrame(j, i, i2, i3);
            }
        }
    }

    @Override // io.agora.base.internal.video.VideoSink
    @CalledByNative
    public void onFrame(VideoFrame videoFrame) {
        if (this.disposed) {
            return;
        }
        VideoFrame.Buffer buffer = videoFrame.getBuffer();
        if (buffer instanceof VideoFrame.TextureBuffer) {
            EglBase.Context eglBaseContext = ((VideoFrame.TextureBuffer) buffer).getEglBaseContext();
            if (!objectsEquals(this.sharedContext, eglBaseContext)) {
                reInit(eglBaseContext);
            }
        }
        this.eglRenderer.onFrame(videoFrame);
    }

    @Override // io.agora.base.internal.video.RendererCommon.RendererEvents
    public void onFrameDrawn(long j) {
        synchronized (this.nativeLock) {
            long j2 = this.nativeVideoRendererAndroid;
            if (j2 != 0) {
                nativeNofityFrameDrawn(j2, j);
            }
        }
    }

    @Override // io.agora.base.internal.video.RendererCommon.RendererEvents
    public void onFrameDropped() {
        synchronized (this.nativeLock) {
            long j = this.nativeVideoRendererAndroid;
            if (j != 0) {
                nativeNofityFrameDropped(j);
            }
        }
    }

    @Override // io.agora.base.internal.video.RendererCommon.RendererEvents
    public void onFrameResolutionChanged(int i, int i2, int i3) {
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (view != this.view) {
            return;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (this.viewWidth == width && this.viewHeight == height) {
            return;
        }
        logD("onLayoutChange()");
        this.viewWidth = width;
        this.viewHeight = height;
        updateRenderSettings();
    }

    public abstract void reInit(EglBase.Context context);

    @CalledByNative
    public void setMirror(boolean z) {
        logD("setMirror() [mirror: " + z + "]");
        if (this.disposed) {
            return;
        }
        this.renderConfig.setMirror(z);
        this.eglRenderer.setMirror(z);
    }

    @CalledByNative
    public void setRenderMode(int i) {
        logD("setRenderMode() [renderMode: " + i + "]");
        if (this.disposed) {
            return;
        }
        this.renderConfig.setRenderMode(i);
        updateRenderSettings();
    }

    @CalledByNative
    public void updateCropArea(int i, int i2, int i3, int i4) {
        Rect rect = new Rect(i, i2, i3, i4);
        logD("updateCropArea() [rect: " + rect.toString() + "]");
        if (this.disposed) {
            return;
        }
        this.rect = rect;
        this.eglRenderer.updateCropArea(rect);
    }

    public void updateRenderSettings() {
        synchronized (this.eglRenderLock) {
            if (this.disposed) {
                return;
            }
            int viewWidth = getViewWidth();
            int viewHeight = getViewHeight();
            float f = (viewWidth == 0 || viewHeight == 0) ? 0.0f : viewWidth / viewHeight;
            logD("updateRenderSettings. Layout size: " + viewWidth + "x" + viewHeight);
            if (this.renderConfig.getRenderMode() == 1) {
                this.eglRenderer.setLayoutAspectRatio(f);
                this.eglRenderer.setLayoutScaledFit(false);
            } else if (this.renderConfig.getRenderMode() == 2) {
                this.eglRenderer.setLayoutAspectRatio(f);
                this.eglRenderer.setLayoutScaledFit(true);
            } else {
                this.eglRenderer.setLayoutAspectRatio(0.0f);
                this.eglRenderer.setLayoutScaledFit(false);
            }
        }
    }

    public class RenderConfig {
        private volatile boolean mirror;
        private volatile int renderMode;
        private volatile boolean useVsync;

        public RenderConfig() {
            this.mirror = true;
            this.renderMode = 2;
            this.useVsync = false;
        }

        public int getRenderMode() {
            return this.renderMode;
        }

        public boolean isMirror() {
            return this.mirror;
        }

        public boolean isUseVsync() {
            return this.useVsync;
        }

        public void setMirror(boolean z) {
            this.mirror = z;
        }

        public void setRenderMode(int i) {
            this.renderMode = i;
        }

        public void setUseVsync(boolean z) {
            this.useVsync = z;
        }

        public RenderConfig(boolean z, int i, boolean z2) {
            this.mirror = z;
            this.renderMode = i;
            this.useVsync = z2;
        }
    }
}
