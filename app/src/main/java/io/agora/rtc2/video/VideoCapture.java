package io.agora.rtc2.video;

import android.graphics.Matrix;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.messaging.Constants;
import io.agora.base.TextureBuffer;
import io.agora.base.VideoFrame;
import io.agora.base.VideoFrameMetaInfo;
import io.agora.base.internal.ContextUtils;
import io.agora.base.internal.video.EglBase;
import io.agora.base.internal.video.ISurfaceTextureHelper;
import io.agora.base.internal.video.SurfaceTextureHelper;
import io.agora.rtc2.video.IVideoCapture;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Observable;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes4.dex */
public abstract class VideoCapture implements IVideoCapture {
    public static final boolean DEBUG_MODE = false;
    public static final int ERR_FAILED = 1;
    public static final int ERR_INVALID_ARGUMENT = 2;
    public static final int ERR_NOT_READY = 3;
    public static final int ERR_NOT_SUPPORTED = 4;
    public static final int ERR_OK = 0;
    private static final String VIDEO_CAPTURER_THREAD_NAME = "VideoCapturerThread";
    public int mCameraNativeOrientation;
    public VideoCaptureFormat mCaptureFormat;

    @VisibleForTesting
    private IVideoCapture.Events mEventsCallback;

    @VisibleForTesting
    private Observable mInjector;
    public boolean mInvertDeviceOrientationReadings;
    public final long mNativeVideoCaptureAndroid;
    public boolean mPQFirst;

    @Nullable
    public Handler mProxyThreadHandler;

    @Nullable
    public ISurfaceTextureHelper mSurfaceTextureHelper;

    public @interface AndroidFillLightMode {
        public static final int AUTO = 2;
        public static final int FLASH = 3;
        public static final int NOT_SET = 0;
        public static final int OFF = 1;
    }

    public @interface AndroidImageFormat {
        public static final int NV21 = 17;
        public static final int UNKNOWN = 0;
        public static final int YUV_420_888 = 35;
        public static final int YUY2 = 20;
        public static final int YV12 = 842094169;
    }

    public @interface AndroidMeteringMode {
        public static final int CONTINUOUS = 4;
        public static final int FIXED = 2;
        public static final int NONE = 1;
        public static final int NOT_SET = 0;
        public static final int SINGLE_SHOT = 3;
    }

    public @interface AndroidVideoCaptureError {
        public static final int kCameraErrorCameraDevice = 4;
        public static final int kCameraErrorCameraDisabled = 3;
        public static final int kCameraErrorCameraInUse = 1;
        public static final int kCameraErrorCameraService = 5;
        public static final int kCameraErrorConfigureInitiation = 100;
        public static final int kCameraErrorConfigureRequest = 102;
        public static final int kCameraErrorConfigureSession = 101;
        public static final int kCameraErrorDeviceNotFound = 7;
        public static final int kCameraErrorDisconnected = 6;
        public static final int kCameraErrorMaxCamerasInUse = 2;
        public static final int kCameraErrorNoPermission = 8;
        public static final int kCameraErrorRuntimeUnknown = 901;
        public static final int kVideoCaptureEventNone = 0;
    }

    public @interface AndroidVideoCaptureFrameDropReason {
        public static final int ANDROID_API_1_UNEXPECTED_DATA_LENGTH = 8;
        public static final int ANDROID_API_2_ACQUIRED_IMAGE_IS_NULL = 9;
    }

    public static class FramerateRange {
        public int max;
        public int min;

        public FramerateRange(int i, int i2) {
            this.min = i;
            this.max = i2;
        }

        public String toString() {
            return "{\"min\":" + this.min + ",\"max\":" + this.max + MessageFormatter.DELIM_STOP;
        }
    }

    public @interface VideoCaptureApi {
        public static final int ANDROID_API1 = 6;
        public static final int ANDROID_API2_FULL = 8;
        public static final int ANDROID_API2_LEGACY = 7;
        public static final int ANDROID_API2_LIMITED = 9;
        public static final int LINUX_V4L2_SINGLE_PLANE = 0;
        public static final int MACOSX_AVFOUNDATION = 4;
        public static final int MACOSX_DECKLINK = 5;
        public static final int UNKNOWN = 11;
        public static final int VIRTUAL_DEVICE = 10;
        public static final int WIN_DIRECT_SHOW = 3;
        public static final int WIN_MEDIA_FOUNDATION = 1;
        public static final int WIN_MEDIA_FOUNDATION_SENSOR = 2;
    }

    public @interface VideoCaptureTransportType {
        public static final int MACOSX_USB_OR_BUILT_IN = 0;
        public static final int OTHER_TRANSPORT = 1;
    }

    public @interface VideoFacingMode {
        public static final int MEDIA_VIDEO_FACING_ENVIRONMENT = 2;
        public static final int MEDIA_VIDEO_FACING_NONE = 0;
        public static final int MEDIA_VIDEO_FACING_USER = 1;
        public static final int NUM_MEDIA_VIDEO_FACING_MODES = 3;
    }

    public VideoCapture(long j, EglBase.Context context) {
        this(j, SurfaceTextureHelper.create(VIDEO_CAPTURER_THREAD_NAME, context));
    }

    public static VideoCaptureFormat FindBestMatchedCapability(List<VideoCaptureFormat> list, VideoCaptureFormat videoCaptureFormat) {
        if (list == null || videoCaptureFormat == null) {
            return null;
        }
        return nativeFindBestMatchedCapability(list, videoCaptureFormat);
    }

    public static VideoFrame.TextureBuffer createTextureBufferWithModifiedTransformMatrix(TextureBuffer textureBuffer, boolean z, int i) {
        Matrix matrix = new Matrix();
        matrix.preTranslate(0.5f, 0.5f);
        if (z) {
            matrix.preScale(-1.0f, 1.0f);
        }
        matrix.preRotate(i);
        matrix.preTranslate(-0.5f, -0.5f);
        return textureBuffer.applyTransformMatrix(matrix, textureBuffer.getWidth(), textureBuffer.getHeight());
    }

    private int getRotationByDM() {
        Display display;
        DisplayManager displayManager = ContextUtils.getApplicationContext() != null ? (DisplayManager) ContextUtils.getApplicationContext().getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION) : null;
        if (displayManager == null || (display = displayManager.getDisplay(0)) == null) {
            return -1;
        }
        return display.getRotation();
    }

    private int getRotationByWM() {
        Display defaultDisplay;
        WindowManager windowManager = ContextUtils.getApplicationContext() != null ? (WindowManager) ContextUtils.getApplicationContext().getSystemService("window") : null;
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return 0;
        }
        return defaultDisplay.getRotation();
    }

    public static native VideoCaptureFormat nativeFindBestMatchedCapability(List<VideoCaptureFormat> list, VideoCaptureFormat videoCaptureFormat);

    private native void nativeOnError(long j, int i, String str);

    private native void nativeOnFrameCaptured(long j, int i, int i2, int i3, long j2, VideoFrame.Buffer buffer, VideoFrameMetaInfo videoFrameMetaInfo);

    private native void nativeOnFrameDropped(long j, int i);

    private native void nativeOnI420FrameAvailable(long j, ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i2, int i3, int i4, int i5, int i6, long j2);

    private native void nativeOnStarted(long j);

    public boolean allocate(int i, int i2, int i3) {
        return allocate(new VideoCaptureFormat(i, i2, i3, 0));
    }

    @Override // io.agora.rtc2.video.IVideoCapture
    public void dispose() {
        ISurfaceTextureHelper iSurfaceTextureHelper = this.mSurfaceTextureHelper;
        if (iSurfaceTextureHelper != null) {
            iSurfaceTextureHelper.dispose();
            this.mSurfaceTextureHelper = null;
        }
        Handler handler = this.mProxyThreadHandler;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.mProxyThreadHandler = null;
        }
    }

    public final int getCameraRotation() {
        return (this.mCameraNativeOrientation + (this.mInvertDeviceOrientationReadings ? 360 - getDeviceRotation() : getDeviceRotation())) % 360;
    }

    @Override // io.agora.rtc2.video.IVideoCapture
    public VideoCaptureFormat getCaptureFormat() {
        return this.mCaptureFormat;
    }

    public final int getDeviceRotation() {
        int rotationByWM;
        if (Build.VERSION.SDK_INT < 17 || (rotationByWM = getRotationByDM()) < 0) {
            rotationByWM = getRotationByWM();
        }
        if (rotationByWM == 1) {
            return 90;
        }
        if (rotationByWM == 2) {
            return 180;
        }
        if (rotationByWM != 3) {
            return 0;
        }
        return io.agora.rtc2.Constants.VIDEO_ORIENTATION_270;
    }

    public void notifyInjector(Object obj) {
        Observable observable = this.mInjector;
        if (observable != null) {
            observable.notifyObservers(obj);
        }
    }

    public void onError(int i, String str) {
        IVideoCapture.Events events = this.mEventsCallback;
        if (events != null) {
            events.onError(i, str);
            return;
        }
        long j = this.mNativeVideoCaptureAndroid;
        if (j != 0) {
            nativeOnError(j, i, str);
        }
    }

    public void onFrameCaptured(VideoFrame videoFrame) {
        IVideoCapture.Events events = this.mEventsCallback;
        if (events != null) {
            events.onFrameCaptured(videoFrame);
        } else {
            nativeOnFrameCaptured(this.mNativeVideoCaptureAndroid, videoFrame.getBuffer().getWidth(), videoFrame.getBuffer().getHeight(), videoFrame.getRotation(), videoFrame.getTimestampNs(), videoFrame.getBuffer(), videoFrame.getMetaInfo());
        }
    }

    public void onFrameDropped(int i) {
        IVideoCapture.Events events = this.mEventsCallback;
        if (events != null) {
            events.onFrameDropped(i);
        } else {
            nativeOnFrameDropped(this.mNativeVideoCaptureAndroid, i);
        }
    }

    public void onI420FrameAvailable(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i2, int i3, int i4, int i5, int i6, long j) {
        IVideoCapture.Events events = this.mEventsCallback;
        if (events != null) {
            events.onI420FrameAvailable(byteBuffer, i, byteBuffer2, byteBuffer3, i2, i3, i4, i5, i6, j);
        } else {
            nativeOnI420FrameAvailable(this.mNativeVideoCaptureAndroid, byteBuffer, i, byteBuffer2, byteBuffer3, i2, i3, i4, i5, i6, j);
        }
    }

    public void onStarted() {
        IVideoCapture.Events events = this.mEventsCallback;
        if (events != null) {
            events.onStarted();
        } else {
            nativeOnStarted(this.mNativeVideoCaptureAndroid);
        }
    }

    @Override // io.agora.rtc2.video.IVideoCapture
    @VisibleForTesting
    public void setEventsCallback(IVideoCapture.Events events) {
        this.mEventsCallback = events;
    }

    @VisibleForTesting
    public void setInjector(Observable observable) {
        this.mInjector = observable;
    }

    public VideoCapture(long j, @Nullable ISurfaceTextureHelper iSurfaceTextureHelper) {
        this.mPQFirst = false;
        this.mNativeVideoCaptureAndroid = j;
        this.mSurfaceTextureHelper = iSurfaceTextureHelper;
        HandlerThread handlerThread = new HandlerThread("VideoCaptureCamera_ProxyThread");
        handlerThread.start();
        this.mProxyThreadHandler = new Handler(handlerThread.getLooper());
    }
}
