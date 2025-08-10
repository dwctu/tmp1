package io.agora.rtc2.video;

import android.view.View;
import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public interface IVideoCaptureCamera extends IVideoCapture {
    @CalledByNative
    float getMaxZoom();

    @CalledByNative
    boolean isAutoFaceFocusSupported();

    @CalledByNative
    boolean isExposureSupported();

    @CalledByNative
    boolean isFaceDetectSupported();

    @CalledByNative
    boolean isFocusSupported();

    @CalledByNative
    boolean isTorchSupported();

    @CalledByNative
    boolean isZoomSupported();

    boolean needFallback();

    @CalledByNative
    int setAutoFaceFocus(boolean z);

    @CalledByNative
    int setExposure(float f, float f2);

    @CalledByNative
    int setFaceDetection(boolean z);

    @CalledByNative
    int setFocus(float f, float f2);

    @CalledByNative
    void setPreviewInfo(View view, boolean z, int i);

    @CalledByNative
    int setTorchMode(boolean z);

    @CalledByNative
    int setVideoStabilityMode(int i);

    @CalledByNative
    int setZoom(float f);
}
