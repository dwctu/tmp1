package io.agora.base.internal;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import io.agora.base.VideoFrame;
import io.agora.base.internal.video.EglBase;
import io.agora.base.internal.video.EglRenderer;
import io.agora.base.internal.video.RendererCommon;
import io.agora.rtc2.video.VideoCaptureFormat;

/* loaded from: classes4.dex */
public class SurfaceEglRenderer extends EglRenderer implements SurfaceHolder.Callback {
    private static final String TAG = "SurfaceEglRenderer";
    private int frameRotation;
    private boolean isRenderingPaused;
    private final Object layoutLock;
    private int rotatedFrameHeight;
    private int rotatedFrameWidth;

    public SurfaceEglRenderer(String str) {
        super(str);
        this.layoutLock = new Object();
        this.isRenderingPaused = false;
    }

    private void logD(String str) {
        Logging.d(TAG, this.name + ": " + str);
    }

    private void updateFrameDimensionsAndReportEvents(VideoFrame videoFrame) {
        synchronized (this.layoutLock) {
            if (this.isRenderingPaused) {
                return;
            }
            if (this.rotatedFrameWidth != videoFrame.getRotatedWidth() || this.rotatedFrameHeight != videoFrame.getRotatedHeight() || this.frameRotation != videoFrame.getRotation()) {
                logD("Reporting frame resolution changed to " + videoFrame.getBuffer().getWidth() + "x" + videoFrame.getBuffer().getHeight() + " with rotation " + videoFrame.getRotation());
                RendererCommon.RendererEvents rendererEvents = this.rendererEvents;
                if (rendererEvents != null) {
                    rendererEvents.onFrameResolutionChanged(videoFrame.getBuffer().getWidth(), videoFrame.getBuffer().getHeight(), videoFrame.getRotation());
                }
                this.rotatedFrameWidth = videoFrame.getRotatedWidth();
                this.rotatedFrameHeight = videoFrame.getRotatedHeight();
                this.frameRotation = videoFrame.getRotation();
            }
        }
    }

    @Override // io.agora.base.internal.video.EglRenderer
    public void disableFpsReduction() {
        synchronized (this.layoutLock) {
            this.isRenderingPaused = false;
        }
        super.disableFpsReduction();
    }

    public void init(EglBase.Context context, RendererCommon.RendererEvents rendererEvents, int[] iArr, RendererCommon.GlDrawer glDrawer, boolean z) {
        this.rendererEvents = rendererEvents;
        synchronized (this.layoutLock) {
            this.isFirstFrameRendered = false;
            this.rotatedFrameWidth = 0;
            this.rotatedFrameHeight = 0;
            this.frameRotation = 0;
        }
        super.init(context, iArr, glDrawer, z);
    }

    @Override // io.agora.base.internal.video.EglRenderer, io.agora.base.internal.video.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        updateFrameDimensionsAndReportEvents(videoFrame);
        super.onFrame(videoFrame);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        logD("onTextureSurfaceAvailable: surfaceTexture: " + surfaceTexture + " width: " + i + VideoCaptureFormat.keyHeight + i2);
        ThreadUtils.checkIsOnMainThread();
        createEglSurface(surfaceTexture);
    }

    public void onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        logD("onSurfaceTextureDestroyed: surfaceTexture: " + surfaceTexture);
        ThreadUtils.checkIsOnMainThread();
        releaseEglSurface();
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        ThreadUtils.checkIsOnMainThread();
        logD("onSurfaceTextureSizeChanged: surfaceTexture: " + surfaceTexture + " size: " + i + "x" + i2);
        notifySurfaceSizeChanged();
    }

    @Override // io.agora.base.internal.video.EglRenderer
    public void pauseVideo() {
        synchronized (this.layoutLock) {
            this.isRenderingPaused = true;
        }
        super.pauseVideo();
    }

    @Override // io.agora.base.internal.video.EglRenderer
    public void setFpsReduction(float f) {
        synchronized (this.layoutLock) {
            this.isRenderingPaused = f == 0.0f;
        }
        super.setFpsReduction(f);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        ThreadUtils.checkIsOnMainThread();
        logD("surfaceChanged: format: " + i + " size: " + i2 + "x" + i3);
        notifySurfaceSizeChanged();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        logD("surfaceCreated: SurfaceHolder: " + surfaceHolder);
        ThreadUtils.checkIsOnMainThread();
        createEglSurface(surfaceHolder.getSurface());
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        logD("surfaceDestroyed: SurfaceHolder: " + surfaceHolder);
        ThreadUtils.checkIsOnMainThread();
        releaseEglSurface();
    }

    @Override // io.agora.base.internal.video.EglRenderer
    public void init(EglBase.Context context, int[] iArr, RendererCommon.GlDrawer glDrawer, boolean z) {
        init(context, null, iArr, glDrawer, z);
    }
}
