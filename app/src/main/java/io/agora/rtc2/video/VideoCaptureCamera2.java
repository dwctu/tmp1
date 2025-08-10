package io.agora.rtc2.video;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.Face;
import android.hardware.camera2.params.MeteringRectangle;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Range;
import android.util.SparseIntArray;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import io.agora.base.TextureBuffer;
import io.agora.base.VideoFrame;
import io.agora.base.internal.ContextUtils;
import io.agora.base.internal.Logging;
import io.agora.base.internal.ThreadUtils;
import io.agora.base.internal.video.EglBase;
import io.agora.base.internal.video.ISurfaceTextureHelper;
import io.agora.base.internal.video.SurfaceTextureHelper;
import io.agora.rtc2.video.VideoCapture;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

@TargetApi(23)
/* loaded from: classes4.dex */
public class VideoCaptureCamera2 extends VideoCaptureCamera {
    private static final String[] AE_TARGET_FPS_RANGE_BUGGY_DEVICE_LIST = {"Pixel 3", "Pixel 3 XL", "SDM845"};
    public static final int ANDROID_CAMERA_HARDWARE_LEVEL_3 = 5;
    public static final int ANDROID_CAMERA_HARDWARE_LEVEL_EXTERNAL = 2;
    public static final int ANDROID_CAMERA_HARDWARE_LEVEL_FULL = 4;
    public static final int ANDROID_CAMERA_HARDWARE_LEVEL_LEGACY = 1;
    public static final int ANDROID_CAMERA_HARDWARE_LEVEL_LIMITED = 3;
    public static final SparseIntArray ANDROID_CAMERA_HARDWARE_LEVEL_MAP;
    public static final int ANDROID_CAMERA_HARDWARE_NOT_SUPPORT = Integer.MIN_VALUE;
    private static final SparseIntArray COLOR_TEMPERATURES_MAP;
    private static final float DEFAULT_VALUE = -1.0f;
    private static int IMAGE_FORMAT = 35;
    private static final String TAG = "VideoCaptureCamera2";
    private static final float ZOOM_UNSUPPORTED_DEFAULT_VALUE = 1.0f;
    private static final long kNanosecondsPer100Microsecond = 100000;
    private static final double kNanosecondsPerSecond = 1.0E9d;
    private Range<Integer> mAeFpsRange;
    private CameraCaptureSession.CaptureCallback mAfCaptureCallback;
    private MeteringRectangle mAreaOfInterest;

    @Nullable
    private CameraDevice mCameraDevice;
    private int mCameraState;
    private final Object mCameraStateLock;
    private Handler mCameraThreadHandler;
    private final CameraCaptureSession.CaptureCallback mCaptureCallback;
    private int mColorTemperature;
    private Rect mCropRect;
    private float mCurrentFocusDistance;
    private int mExposureCompensation;
    private int mExposureMode;
    private int mFaceDetectMode;
    private boolean mFaceDetectSupported;
    private int mFillLightMode;
    private int mFocusMode;
    private ImageReader mImageReader;
    private final Object mImageReaderLock;
    private int mIso;
    private long mLastExposureTimeNs;
    private float mLastZoomRatio;
    private float mMaxZoom;
    private CaptureRequest.Builder mPreviewRequestBuilder;

    @Nullable
    private CameraCaptureSession mPreviewSession;
    private boolean mRedEyeReduction;
    private Rect mSensorRect;

    @Nullable
    private Surface mSurface;
    private ThreadUtils.ThreadChecker mThreadChecker;
    private boolean mTorch;
    private ConditionVariable mWaitForDeviceClosedConditionVariable;
    private int mWhiteBalanceMode;

    public static class CameraIdListTask implements Runnable {
        public static String[] cameraIdList;
        public final CountDownLatch countDown = new CountDownLatch(1);

        public String[] getCameraIdList() {
            new Thread(this).start();
            if (!ThreadUtils.awaitUninterruptibly(this.countDown, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS)) {
                Logging.e(VideoCaptureCamera2.TAG, "checkBackgroundSafe timeout");
            }
            return cameraIdList;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraManager cameraManager;
            try {
                try {
                    try {
                        try {
                        } catch (SecurityException e) {
                            Logging.e(VideoCaptureCamera2.TAG, "getNumberOfCameras: getCameraIdList(): " + e.getMessage());
                        } catch (Exception e2) {
                            Logging.e(VideoCaptureCamera2.TAG, "getNumberOfCameras: getCameraIdList(): " + e2.getMessage());
                        }
                    } catch (CameraAccessException e3) {
                        Logging.e(VideoCaptureCamera2.TAG, "getNumberOfCameras: getCameraIdList(): " + e3.getMessage());
                    } catch (AssertionError e4) {
                        Logging.e(VideoCaptureCamera2.TAG, "getNumberOfCameras: getCameraIdList(): " + e4.getMessage());
                    }
                } catch (IllegalArgumentException e5) {
                    Logging.e(VideoCaptureCamera2.TAG, "getSystemService(Context.CAMERA_SERVICE): " + e5.getMessage());
                }
                if (ContextUtils.getApplicationContext() != null && (cameraManager = (CameraManager) ContextUtils.getApplicationContext().getSystemService("camera")) != null) {
                    cameraIdList = cameraManager.getCameraIdList();
                }
            } finally {
                this.countDown.countDown();
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CameraState {
        public static final int CONFIGURING = 1;
        public static final int EVICTED = 3;
        public static final int OPENING = 0;
        public static final int STARTED = 2;
        public static final int STOPPED = 4;
    }

    public class CrPreviewReaderListener implements ImageReader.OnImageAvailableListener {
        private CrPreviewReaderListener() {
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader imageReader) {
            String str;
            String str2;
            String str3;
            String str4;
            VideoCaptureCamera2.this.mThreadChecker.checkIsOnValidThread();
            synchronized (VideoCaptureCamera2.this.mImageReaderLock) {
                Image image = null;
                try {
                    try {
                    } catch (IllegalArgumentException e) {
                        Logging.e(VideoCaptureCamera2.TAG, "acquireLatestImage():" + e.getMessage());
                        if (0 != 0) {
                            try {
                                image.close();
                            } catch (IllegalArgumentException e2) {
                                str3 = VideoCaptureCamera2.TAG;
                                str4 = "Image Close():" + e2.getMessage();
                                Logging.e(str3, str4);
                                return;
                            } catch (IllegalStateException e3) {
                                str = VideoCaptureCamera2.TAG;
                                str2 = "Image Close():" + e3.getMessage();
                                Logging.e(str, str2);
                                return;
                            }
                        }
                    } catch (IllegalStateException e4) {
                        Logging.e(VideoCaptureCamera2.TAG, "acquireLatestImage():" + e4.getMessage());
                        if (0 != 0) {
                            try {
                                image.close();
                            } catch (IllegalArgumentException e5) {
                                str3 = VideoCaptureCamera2.TAG;
                                str4 = "Image Close():" + e5.getMessage();
                                Logging.e(str3, str4);
                                return;
                            } catch (IllegalStateException e6) {
                                str = VideoCaptureCamera2.TAG;
                                str2 = "Image Close():" + e6.getMessage();
                                Logging.e(str, str2);
                                return;
                            }
                        }
                    }
                    if (VideoCaptureCamera2.this.mImageReader == null) {
                        return;
                    }
                    Image imageAcquireLatestImage = imageReader.acquireLatestImage();
                    if (imageAcquireLatestImage == null) {
                        VideoCaptureCamera2.this.onFrameDropped(9);
                        if (imageAcquireLatestImage != null) {
                            try {
                                imageAcquireLatestImage.close();
                            } catch (IllegalArgumentException e7) {
                                Logging.e(VideoCaptureCamera2.TAG, "Image Close():" + e7.getMessage());
                            } catch (IllegalStateException e8) {
                                Logging.e(VideoCaptureCamera2.TAG, "Image Close():" + e8.getMessage());
                            }
                        }
                        return;
                    }
                    if (imageAcquireLatestImage.getFormat() != 35 || imageAcquireLatestImage.getPlanes().length != 3) {
                        Logging.e(VideoCaptureCamera2.TAG, "Unexpected image format: " + imageAcquireLatestImage.getFormat() + " or #planes: " + imageAcquireLatestImage.getPlanes().length);
                        throw new IllegalStateException();
                    }
                    if (imageReader.getWidth() != imageAcquireLatestImage.getWidth() || imageReader.getHeight() != imageAcquireLatestImage.getHeight()) {
                        Logging.e(VideoCaptureCamera2.TAG, "ImageReader size (" + imageReader.getWidth() + "x" + imageReader.getHeight() + ") did not match Image size (" + imageAcquireLatestImage.getWidth() + "x" + imageAcquireLatestImage.getHeight() + ")");
                        throw new IllegalStateException();
                    }
                    VideoCaptureCamera2.this.onI420FrameAvailable(imageAcquireLatestImage.getPlanes()[0].getBuffer(), imageAcquireLatestImage.getPlanes()[0].getRowStride(), imageAcquireLatestImage.getPlanes()[1].getBuffer(), imageAcquireLatestImage.getPlanes()[2].getBuffer(), imageAcquireLatestImage.getPlanes()[1].getRowStride(), imageAcquireLatestImage.getPlanes()[1].getPixelStride(), imageAcquireLatestImage.getWidth(), imageAcquireLatestImage.getHeight(), VideoCaptureCamera2.this.getCameraRotation(), imageAcquireLatestImage.getTimestamp());
                    if (imageAcquireLatestImage != null) {
                        try {
                            imageAcquireLatestImage.close();
                        } catch (IllegalArgumentException e9) {
                            str3 = VideoCaptureCamera2.TAG;
                            str4 = "Image Close():" + e9.getMessage();
                            Logging.e(str3, str4);
                            return;
                        } catch (IllegalStateException e10) {
                            str = VideoCaptureCamera2.TAG;
                            str2 = "Image Close():" + e10.getMessage();
                            Logging.e(str, str2);
                            return;
                        }
                    }
                    return;
                } catch (Throwable th) {
                    if (0 == 0) {
                        throw th;
                    }
                    try {
                        image.close();
                        throw th;
                    } catch (IllegalArgumentException e11) {
                        Logging.e(VideoCaptureCamera2.TAG, "Image Close():" + e11.getMessage());
                        throw th;
                    } catch (IllegalStateException e12) {
                        Logging.e(VideoCaptureCamera2.TAG, "Image Close():" + e12.getMessage());
                        throw th;
                    }
                }
            }
        }
    }

    public class CrPreviewSessionListener extends CameraCaptureSession.StateCallback {
        private CrPreviewSessionListener() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(CameraCaptureSession cameraCaptureSession) {
            VideoCaptureCamera2.this.mThreadChecker.checkIsOnValidThread();
            Logging.d(VideoCaptureCamera2.TAG, "CrPreviewSessionListener.onClosed");
            VideoCaptureCamera2.this.mPreviewSession = null;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            VideoCaptureCamera2.this.mThreadChecker.checkIsOnValidThread();
            Logging.d(VideoCaptureCamera2.TAG, "CrPreviewSessionListener.onConfigureFailed");
            VideoCaptureCamera2.this.changeCameraStateAndNotify(4);
            VideoCaptureCamera2.this.mPreviewSession = null;
            VideoCaptureCamera2.this.onError(101, "Camera session configuration error");
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) throws CameraAccessException {
            VideoCaptureCamera2.this.mThreadChecker.checkIsOnValidThread();
            Logging.d(VideoCaptureCamera2.TAG, "CrPreviewSessionListener.onConfigured");
            VideoCaptureCamera2.this.mPreviewSession = cameraCaptureSession;
            try {
                if (VideoCaptureCamera2.this.mPreviewRequestBuilder != null) {
                    VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
                    videoCaptureCamera2.requestFaceDetection(videoCaptureCamera2.mPreviewRequestBuilder, VideoCaptureCamera2.this.mFaceDetectMode);
                    VideoCaptureCamera2.this.mPreviewSession.setRepeatingRequest(VideoCaptureCamera2.this.mPreviewRequestBuilder.build(), VideoCaptureCamera2.this.mCaptureCallback, VideoCaptureCamera2.this.mCameraThreadHandler);
                }
                VideoCaptureCamera2.this.changeCameraStateAndNotify(2);
                VideoCaptureCamera2.this.onStarted();
            } catch (CameraAccessException e) {
                Logging.e(VideoCaptureCamera2.TAG, "setRepeatingRequest: " + e.getMessage());
                VideoCaptureCamera2.this.onError(102, "Fail to setup capture session");
            } catch (IllegalArgumentException e2) {
                Logging.e(VideoCaptureCamera2.TAG, "setRepeatingRequest: " + e2.getMessage());
                VideoCaptureCamera2.this.onError(102, "Fail to setup capture session");
            } catch (IllegalStateException e3) {
                Logging.e(VideoCaptureCamera2.TAG, "setRepeatingRequest: " + e3.getMessage());
                VideoCaptureCamera2.this.onError(102, "Fail to setup capture session");
            } catch (SecurityException e4) {
                Logging.e(VideoCaptureCamera2.TAG, "setRepeatingRequest: " + e4.getMessage());
                VideoCaptureCamera2.this.onError(102, "Fail to setup capture session");
            }
        }
    }

    public class CrStateListener extends CameraDevice.StateCallback {
        public CrStateListener() {
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice cameraDevice) {
            Logging.d(VideoCaptureCamera2.TAG, "cameraDevice closed");
            if (VideoCaptureCamera2.this.mPreviewSession != null) {
                VideoCaptureCamera2.this.mPreviewSession = null;
            }
            VideoCaptureCamera2.this.mWaitForDeviceClosedConditionVariable.open();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            VideoCaptureCamera2.this.mThreadChecker.checkIsOnValidThread();
            Logging.e(VideoCaptureCamera2.TAG, "cameraDevice was closed unexpectedly");
            if (VideoCaptureCamera2.this.mCameraState != 4) {
                if (VideoCaptureCamera2.this.mCameraDevice != null) {
                    try {
                        VideoCaptureCamera2.this.mCameraDevice.close();
                    } catch (IllegalStateException e) {
                        Logging.e(VideoCaptureCamera2.TAG, "cameraDevice close error", e);
                    }
                    VideoCaptureCamera2.this.mCameraDevice = null;
                }
                VideoCaptureCamera2.this.onError(6, "Camera disconnected");
                VideoCaptureCamera2.this.changeCameraStateAndNotify(3);
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i) {
            VideoCaptureCamera2.this.mThreadChecker.checkIsOnValidThread();
            Logging.e(VideoCaptureCamera2.TAG, "cameraDevice encountered an error, code: " + i);
            int i2 = 3;
            if (VideoCaptureCamera2.this.mCameraState == 3) {
                return;
            }
            if (VideoCaptureCamera2.this.mCameraDevice != null) {
                try {
                    VideoCaptureCamera2.this.mCameraDevice.close();
                } catch (IllegalStateException e) {
                    Logging.e(VideoCaptureCamera2.TAG, "cameraDevice close error", e);
                }
                VideoCaptureCamera2.this.mCameraDevice = null;
            }
            VideoCaptureCamera2.this.changeCameraStateAndNotify(4);
            String str = "Camera In Use";
            if (i == 1) {
                i2 = 1;
            } else if (i == 2) {
                i2 = 2;
            } else if (i == 3) {
                str = "Camera disabled";
            } else if (i == 4) {
                str = "Camera device error";
                i2 = 4;
            } else if (i != 5) {
                i2 = 901;
                str = "Camera runtime erro";
            } else {
                str = "Camera service error";
                i2 = 5;
            }
            VideoCaptureCamera2.this.onError(i2, str);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) {
            VideoCaptureCamera2.this.mThreadChecker.checkIsOnValidThread();
            Logging.d(VideoCaptureCamera2.TAG, "CameraDevice.StateCallback onOpened");
            synchronized (VideoCaptureCamera2.this.mCameraStateLock) {
                if (VideoCaptureCamera2.this.mCameraState == 4) {
                    try {
                        Logging.w(VideoCaptureCamera2.TAG, "cameraDevice state error,  should manual close!");
                        cameraDevice.close();
                    } catch (IllegalStateException e) {
                        Logging.e(VideoCaptureCamera2.TAG, "cameraDevice close error", e);
                    }
                    return;
                }
                VideoCaptureCamera2.this.mCameraDevice = cameraDevice;
                VideoCaptureCamera2.this.mWaitForDeviceClosedConditionVariable.close();
                VideoCaptureCamera2.this.changeCameraStateAndNotify(1);
                VideoCaptureCamera2.this.createPreviewObjectsAndStartPreviewOrFailWith(100);
            }
        }
    }

    public class StopCaptureTask implements Runnable {
        private StopCaptureTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCaptureCamera2.this.mThreadChecker.checkIsOnValidThread();
            if (VideoCaptureCamera2.this.mCameraDevice == null) {
                return;
            }
            try {
                VideoCaptureCamera2.this.mCameraDevice.close();
            } catch (IllegalStateException e) {
                Logging.e(VideoCaptureCamera2.TAG, "cameraDevice close error", e);
            }
            VideoCaptureCamera2.this.changeCameraStateAndNotify(4);
            VideoCaptureCamera2.this.mCropRect = new Rect();
        }
    }

    public class TextureVideoSinkListener implements SurfaceTextureHelper.IVideoCapture {
        private TextureVideoSinkListener() {
        }

        @Override // io.agora.base.internal.video.VideoSink
        public void onFrame(VideoFrame videoFrame) {
            VideoFrame videoFrame2 = new VideoFrame(VideoCapture.createTextureBufferWithModifiedTransformMatrix((TextureBuffer) videoFrame.getBuffer(), !r2.mInvertDeviceOrientationReadings, -VideoCaptureCamera2.this.mCameraNativeOrientation), VideoCaptureCamera2.this.getCameraRotation(), videoFrame.getTimestampNs());
            VideoCaptureCamera2.this.attachPerFrameMetaInfos(videoFrame2);
            VideoCaptureCamera2.this.onFrameCaptured(videoFrame2);
            videoFrame2.release();
        }

        @Override // io.agora.base.internal.video.SurfaceTextureHelper.IVideoCapture
        public void onFrameDropped(int i) {
            VideoCaptureCamera2.super.onFrameDropped(i);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        COLOR_TEMPERATURES_MAP = sparseIntArray;
        sparseIntArray.append(2850, 2);
        sparseIntArray.append(2950, 4);
        sparseIntArray.append(4250, 3);
        sparseIntArray.append(4600, 7);
        sparseIntArray.append(5000, 5);
        sparseIntArray.append(PlaybackException.ERROR_CODE_DRM_UNSPECIFIED, 6);
        sparseIntArray.append(AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        ANDROID_CAMERA_HARDWARE_LEVEL_MAP = sparseIntArray2;
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            sparseIntArray2.append(2, 1);
            sparseIntArray2.append(0, 3);
            sparseIntArray2.append(1, 4);
        }
        if (i >= 28) {
            sparseIntArray2.append(4, 2);
        }
        if (i >= 24) {
            sparseIntArray2.append(3, 5);
        }
    }

    public VideoCaptureCamera2(int i, long j, boolean z, boolean z2, int i2, EglBase.Context context) throws CameraAccessException {
        super(i, j, z, z2, i2, context);
        this.mCaptureCallback = new CameraCaptureSession.CaptureCallback() { // from class: io.agora.rtc2.video.VideoCaptureCamera2.1
            private long mLastFocusedTs;

            private void addRegionsToCaptureRequestBuilder(CaptureRequest.Builder builder, MeteringRectangle[] meteringRectangleArr) {
                builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                builder.set(CaptureRequest.CONTROL_AE_REGIONS, meteringRectangleArr);
                builder.set(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr);
                builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
                builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
                builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
            }

            private void notifyCameraFocusAreaChanged(Rect rect, Rect rect2) {
                RectF rectF = new RectF(rect2);
                int iWidth = rect.width();
                int iHeight = rect.height();
                VideoCaptureFormat videoCaptureFormat = VideoCaptureCamera2.this.mCaptureFormat;
                RectF rectFSensorToNormalized = CoordinatesTransform.sensorToNormalized(rectF, iWidth, iHeight, videoCaptureFormat.mWidth, videoCaptureFormat.mHeight, true);
                int width = VideoCaptureCamera2.this.mRenderView.getWidth();
                int height = VideoCaptureCamera2.this.mRenderView.getHeight();
                int width2 = VideoCaptureCamera2.this.mCaptureFormat.getWidth();
                int height2 = VideoCaptureCamera2.this.mCaptureFormat.getHeight();
                VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
                int i3 = videoCaptureCamera2.mId;
                RectF rectFNormalizedToView = CoordinatesTransform.normalizedToView(rectFSensorToNormalized, width, height, width2, height2, i3 == 1, (i3 != 1 ? -1 : 1) * videoCaptureCamera2.getCameraRotation(), VideoCaptureCamera2.this.mRenderMode);
                if (rectFNormalizedToView == null) {
                    Logging.w(VideoCaptureCamera2.TAG, "Failed to translate coordinate from normalized to view!!");
                    return;
                }
                Rect rect3 = new Rect();
                rectFNormalizedToView.round(rect3);
                VideoCaptureCamera2.this.notifyCameraFocusAreaChanged(rect3);
            }

            private void notifyFaceDetection(Rect rect, Face[] faceArr) {
                int i3;
                double dPow;
                ArrayList<RectF> arrayList = new ArrayList<>();
                ArrayList<Double> arrayList2 = new ArrayList<>();
                int length = faceArr.length;
                int i4 = 0;
                while (i4 < length) {
                    RectF rectF = new RectF(faceArr[i4].getBounds());
                    int iWidth = rect.width();
                    int iHeight = rect.height();
                    VideoCaptureFormat videoCaptureFormat = VideoCaptureCamera2.this.mCaptureFormat;
                    RectF rectFSensorToNormalized = CoordinatesTransform.sensorToNormalized(rectF, iWidth, iHeight, videoCaptureFormat.mWidth, videoCaptureFormat.mHeight, true);
                    if (rectFSensorToNormalized == null) {
                        i3 = i4;
                    } else {
                        if (VideoCaptureCamera2.this.mId == 1) {
                            i3 = i4;
                            dPow = Math.pow(rectFSensorToNormalized.width(), -0.958d) * 11.237d;
                        } else {
                            i3 = i4;
                            dPow = 14.719d * Math.pow(rectFSensorToNormalized.height(), -0.971d);
                        }
                        arrayList2.add(Double.valueOf(dPow));
                        int width = VideoCaptureCamera2.this.mRenderView.getWidth();
                        int height = VideoCaptureCamera2.this.mRenderView.getHeight();
                        VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
                        VideoCaptureFormat videoCaptureFormat2 = videoCaptureCamera2.mCaptureFormat;
                        int i5 = videoCaptureFormat2.mWidth;
                        int i6 = videoCaptureFormat2.mHeight;
                        int i7 = videoCaptureCamera2.mId;
                        RectF rectFNormalizedToView = CoordinatesTransform.normalizedToView(rectFSensorToNormalized, width, height, i5, i6, i7 == 1, (i7 == 1 ? 1 : -1) * videoCaptureCamera2.getCameraRotation(), VideoCaptureCamera2.this.mRenderMode);
                        if (rectFNormalizedToView == null) {
                            arrayList2.remove(arrayList2.size() - 1);
                        } else {
                            arrayList.add(rectFNormalizedToView);
                        }
                    }
                    i4 = i3 + 1;
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                VideoCaptureCamera2 videoCaptureCamera22 = VideoCaptureCamera2.this;
                VideoCaptureFormat videoCaptureFormat3 = videoCaptureCamera22.mCaptureFormat;
                videoCaptureCamera22.notifyFaceDetection(videoCaptureFormat3.mWidth, videoCaptureFormat3.mHeight, arrayList, arrayList2);
            }

            private void process(CaptureResult captureResult) throws CameraAccessException {
                Face[] faceArr = (Face[]) captureResult.get(CaptureResult.STATISTICS_FACES);
                if (faceArr == null || faceArr.length <= 0) {
                    return;
                }
                if (System.currentTimeMillis() - this.mLastFocusedTs < 3000) {
                    if (faceArr[0].getScore() > 20) {
                        notifyCameraFocusAreaChanged((Rect) captureResult.get(CaptureResult.SCALER_CROP_REGION), faceArr[0].getBounds());
                        return;
                    }
                    return;
                }
                if (faceArr[0].getScore() <= 50) {
                    return;
                }
                Rect rectClampFace = VideoCaptureCamera2.this.clampFace(faceArr[0].getBounds());
                if (rectClampFace.width() <= 0 || rectClampFace.height() <= 0) {
                    return;
                }
                addRegionsToCaptureRequestBuilder(VideoCaptureCamera2.this.mPreviewRequestBuilder, new MeteringRectangle[]{new MeteringRectangle(rectClampFace, 1000)});
                if (VideoCaptureCamera2.this.mCameraState != 2) {
                    return;
                }
                try {
                    Rect rect = (Rect) captureResult.get(CaptureResult.SCALER_CROP_REGION);
                    Logging.d(VideoCaptureCamera2.TAG, "cropRegion = " + rect);
                    Logging.d(VideoCaptureCamera2.TAG, "capture size wxh = " + VideoCaptureCamera2.this.mCaptureFormat.getWidth() + " x " + VideoCaptureCamera2.this.mCaptureFormat.getHeight());
                    notifyCameraFocusAreaChanged(rect, rectClampFace);
                    VideoCaptureCamera2.this.mPreviewSession.capture(VideoCaptureCamera2.this.mPreviewRequestBuilder.build(), VideoCaptureCamera2.this.mCaptureCallback, null);
                    VideoCaptureCamera2.this.createCaptureRequest();
                    this.mLastFocusedTs = System.currentTimeMillis();
                } catch (Exception e) {
                    Logging.e(VideoCaptureCamera2.TAG, "capture: " + e);
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) throws CameraAccessException {
                Long l = (Long) totalCaptureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
                if (l != null) {
                    VideoCaptureCamera2.this.mLastExposureTimeNs = l.longValue();
                }
                VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
                if (videoCaptureCamera2.mEnableAutoFaceFocus && videoCaptureCamera2.isAutoFaceFocusSupported()) {
                    process(totalCaptureResult);
                }
                if (VideoCaptureCamera2.this.mEnableFaceDetection) {
                    notifyFaceDetection((Rect) totalCaptureResult.get(CaptureResult.SCALER_CROP_REGION), (Face[]) totalCaptureResult.get(CaptureResult.STATISTICS_FACES));
                }
            }
        };
        this.mAfCaptureCallback = new CameraCaptureSession.CaptureCallback() { // from class: io.agora.rtc2.video.VideoCaptureCamera2.2
            private void process(CaptureResult captureResult) throws CameraAccessException {
                Integer num = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
                if (num == null) {
                    return;
                }
                if (4 == num.intValue() || 5 == num.intValue()) {
                    VideoCaptureCamera2.this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                    VideoCaptureCamera2.this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, 3);
                    VideoCaptureCamera2.this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, 1);
                    try {
                        VideoCaptureCamera2.this.mPreviewSession.setRepeatingRequest(VideoCaptureCamera2.this.mPreviewRequestBuilder.build(), VideoCaptureCamera2.this.mCaptureCallback, VideoCaptureCamera2.this.mCameraThreadHandler);
                    } catch (CameraAccessException e) {
                        Logging.e(VideoCaptureCamera2.TAG, "setRepeatingRequest failed, error message : " + e.getMessage());
                    } catch (IllegalArgumentException e2) {
                        Logging.e(VideoCaptureCamera2.TAG, "setRepeatingRequest failed, error message : " + e2.getMessage());
                    } catch (IllegalStateException e3) {
                        Logging.e(VideoCaptureCamera2.TAG, "setRepeatingRequest failed, error message : " + e3.getMessage());
                    } catch (SecurityException e4) {
                        Logging.e(VideoCaptureCamera2.TAG, "setRepeatingRequest failed, error message : " + e4.getMessage());
                    }
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) throws CameraAccessException {
                process(totalCaptureResult);
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) throws CameraAccessException {
                process(captureResult);
            }
        };
        this.mCameraStateLock = new Object();
        this.mImageReaderLock = new Object();
        this.mWaitForDeviceClosedConditionVariable = new ConditionVariable();
        this.mCameraState = 4;
        this.mMaxZoom = 1.0f;
        this.mCropRect = new Rect();
        this.mFocusMode = 4;
        this.mCurrentFocusDistance = 1.0f;
        this.mExposureMode = 4;
        this.mWhiteBalanceMode = 4;
        this.mColorTemperature = -1;
        this.mFillLightMode = 1;
        this.mLastZoomRatio = -1.0f;
        this.mSensorRect = null;
        this.mFaceDetectSupported = false;
        HandlerThread handlerThread = new HandlerThread("VideoCaptureCamera2_CameraThread");
        handlerThread.start();
        this.mCameraThreadHandler = new Handler(handlerThread.getLooper());
        this.mThreadChecker = new ThreadUtils.ThreadChecker(handlerThread);
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(i);
        if (cameraCharacteristics != null) {
            this.mMaxZoom = getMaxZoom(cameraCharacteristics);
        }
        int i3 = this.mSkipControl;
        if (i3 == 1) {
            this.mExposureMode = 1;
        }
        if (i3 == 2) {
            this.mFocusMode = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeCameraStateAndNotify(int i) {
        Logging.d(TAG, "changeCameraStateAndNotify() " + i);
        synchronized (this.mCameraStateLock) {
            this.mCameraState = i;
            this.mCameraStateLock.notifyAll();
        }
    }

    private void configureCommonCaptureSettings(CaptureRequest.Builder builder) throws CameraAccessException {
        this.mThreadChecker.checkIsOnValidThread();
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mId);
        int i = this.mFocusMode;
        if (i == 4) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
            builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
        } else if (i == 2) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 0);
            builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
            builder.set(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(1.0f / this.mCurrentFocusDistance));
        }
        int i2 = this.mExposureMode;
        if (i2 == 1 || i2 == 2) {
            builder.set(CaptureRequest.CONTROL_AE_MODE, 0);
            long j = this.mLastExposureTimeNs;
            if (j != 0) {
                builder.set(CaptureRequest.SENSOR_EXPOSURE_TIME, Long.valueOf(j / 100000));
            } else if (cameraCharacteristics != null) {
                Range range = (Range) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_EXPOSURE_TIME_RANGE);
                builder.set(CaptureRequest.SENSOR_EXPOSURE_TIME, Long.valueOf((((Long) range.getLower()).longValue() + ((((Long) range.getUpper()).longValue() + ((Long) range.getLower()).longValue()) / 2)) / 100000));
            }
        } else {
            builder.set(CaptureRequest.CONTROL_MODE, 1);
            builder.set(CaptureRequest.CONTROL_AE_MODE, 1);
            if (!shouldSkipSettingAeTargetFpsRange()) {
                builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, this.mAeFpsRange);
            }
        }
        if (this.mTorch) {
            builder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(this.mExposureMode == 4 ? 1 : 0));
            builder.set(CaptureRequest.FLASH_MODE, 2);
        } else {
            int i3 = this.mFillLightMode;
            if (i3 == 1) {
                builder.set(CaptureRequest.FLASH_MODE, 0);
            } else if (i3 == 2) {
                builder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(this.mRedEyeReduction ? 4 : 2));
            } else if (i3 == 3) {
                builder.set(CaptureRequest.CONTROL_AE_MODE, 3);
                builder.set(CaptureRequest.FLASH_MODE, 1);
            }
            builder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 0);
        }
        builder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(this.mExposureCompensation));
        int i4 = this.mWhiteBalanceMode;
        if (i4 == 4) {
            builder.set(CaptureRequest.CONTROL_AWB_LOCK, Boolean.FALSE);
            builder.set(CaptureRequest.CONTROL_AWB_MODE, 1);
        } else if (i4 == 1) {
            builder.set(CaptureRequest.CONTROL_AWB_LOCK, Boolean.FALSE);
            builder.set(CaptureRequest.CONTROL_AWB_MODE, 0);
        } else if (i4 == 2) {
            builder.set(CaptureRequest.CONTROL_AWB_LOCK, Boolean.TRUE);
        }
        int i5 = this.mColorTemperature;
        if (i5 > 0) {
            int closestWhiteBalance = cameraCharacteristics != null ? getClosestWhiteBalance(i5, (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES)) : -1;
            Logging.d(TAG, String.format(Locale.US, " Color temperature (%d ==> %d)", Integer.valueOf(this.mColorTemperature), Integer.valueOf(closestWhiteBalance)));
            if (closestWhiteBalance != -1) {
                builder.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(closestWhiteBalance));
            }
        }
        MeteringRectangle meteringRectangle = this.mAreaOfInterest;
        if (meteringRectangle != null) {
            MeteringRectangle[] meteringRectangleArr = {meteringRectangle};
            Logging.d(TAG, String.format(Locale.US, "Area of interest %s", meteringRectangle.toString()));
            builder.set(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr);
            builder.set(CaptureRequest.CONTROL_AE_REGIONS, meteringRectangleArr);
            builder.set(CaptureRequest.CONTROL_AWB_REGIONS, meteringRectangleArr);
        }
        if (!this.mCropRect.isEmpty()) {
            builder.set(CaptureRequest.SCALER_CROP_REGION, this.mCropRect);
        }
        int i6 = this.mIso;
        if (i6 > 0) {
            builder.set(CaptureRequest.SENSOR_SENSITIVITY, Integer.valueOf(i6));
        }
    }

    @Deprecated
    private boolean createBufferPreviewObjectsAndStartPreview() {
        this.mThreadChecker.checkIsOnValidThread();
        if (this.mCameraDevice == null) {
            return false;
        }
        synchronized (this.mImageReaderLock) {
            this.mImageReader = ImageReader.newInstance(this.mCaptureFormat.getWidth(), this.mCaptureFormat.getHeight(), this.mCaptureFormat.getPixelFormat(), 2);
            try {
                this.mImageReader.setOnImageAvailableListener(new CrPreviewReaderListener(), this.mCameraThreadHandler);
            } catch (IllegalArgumentException e) {
                Logging.e(TAG, "setOnImageAvailableListener error", e);
            }
        }
        return createPreviewObjectsAndStartPreview(this.mImageReader.getSurface());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int createCaptureRequest() throws CameraAccessException {
        try {
            this.mPreviewSession.setRepeatingRequest(this.mPreviewRequestBuilder.build(), this.mCaptureCallback, null);
            return 0;
        } catch (CameraAccessException e) {
            Logging.e(TAG, "setRepeatingRequest: ", e);
            return -1;
        } catch (IllegalArgumentException e2) {
            Logging.e(TAG, "setRepeatingRequest: ", e2);
            return -2;
        } catch (IllegalStateException e3) {
            Logging.e(TAG, "capture:" + e3);
            return -4;
        } catch (SecurityException e4) {
            Logging.e(TAG, "setRepeatingRequest: ", e4);
            return -3;
        }
    }

    private boolean createPreviewObjectsAndStartPreview(Surface surface) throws CameraAccessException {
        try {
            CaptureRequest.Builder builderCreateCaptureRequest = this.mCameraDevice.createCaptureRequest(1);
            this.mPreviewRequestBuilder = builderCreateCaptureRequest;
            if (builderCreateCaptureRequest == null) {
                Logging.e(TAG, "mPreviewRequestBuilder error");
                return false;
            }
            builderCreateCaptureRequest.addTarget(surface);
            this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_MODE, 1);
            this.mPreviewRequestBuilder.set(CaptureRequest.NOISE_REDUCTION_MODE, 1);
            this.mPreviewRequestBuilder.set(CaptureRequest.EDGE_MODE, 1);
            configureCommonCaptureSettings(this.mPreviewRequestBuilder);
            if (this.mEnableFaceDetection) {
                this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_MODE, 2);
                this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_SCENE_MODE, 1);
            }
            requestFaceDetection(this.mPreviewRequestBuilder, this.mFaceDetectMode);
            try {
                this.mCameraDevice.createCaptureSession(Arrays.asList(surface), new CrPreviewSessionListener(), null);
                return true;
            } catch (CameraAccessException e) {
                Logging.e(TAG, "createCaptureSession: " + e.getMessage());
                return false;
            } catch (IllegalArgumentException e2) {
                Logging.e(TAG, "createCaptureSession: " + e2.getMessage());
                return false;
            } catch (SecurityException e3) {
                Logging.e(TAG, "createCaptureSession: " + e3.getMessage());
                return false;
            }
        } catch (CameraAccessException e4) {
            Logging.e(TAG, "createCaptureRequest: " + e4.getMessage());
            return false;
        } catch (IllegalArgumentException e5) {
            Logging.e(TAG, "createCaptureRequest: " + e5.getMessage());
            return false;
        } catch (SecurityException e6) {
            Logging.e(TAG, "createCaptureRequest: " + e6.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createPreviewObjectsAndStartPreviewOrFailWith(int i) {
        this.mThreadChecker.checkIsOnValidThread();
        if (this.mCaptureToTexture) {
            if (createTexturePreviewObjectsAndStartPreview()) {
                return;
            }
        } else if (createBufferPreviewObjectsAndStartPreview()) {
            return;
        }
        changeCameraStateAndNotify(4);
        onError(i, "Error starting or restarting preview");
    }

    private boolean createTexturePreviewObjectsAndStartPreview() {
        ISurfaceTextureHelper iSurfaceTextureHelper;
        this.mThreadChecker.checkIsOnValidThread();
        if (this.mCameraDevice != null && (iSurfaceTextureHelper = this.mSurfaceTextureHelper) != null) {
            try {
                iSurfaceTextureHelper.setTextureSize(this.mCaptureFormat.getWidth(), this.mCaptureFormat.getHeight());
                this.mSurface = new Surface(this.mSurfaceTextureHelper.getSurfaceTexture());
                this.mSurfaceTextureHelper.startListening(new TextureVideoSinkListener());
                return createPreviewObjectsAndStartPreview(this.mSurface);
            } catch (IllegalArgumentException e) {
                Logging.e(TAG, "setTextureSize:", e);
            }
        }
        return false;
    }

    private Rect cropRegionForZoom(float f) {
        int iWidth = this.mSensorRect.width() / 2;
        int iHeight = this.mSensorRect.height() / 2;
        int iWidth2 = (int) ((this.mSensorRect.width() * 0.5f) / f);
        int iHeight2 = (int) ((this.mSensorRect.height() * 0.5f) / f);
        return new Rect(iWidth - iWidth2, iHeight - iHeight2, iWidth + iWidth2, iHeight + iHeight2);
    }

    private static int findInIntArray(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (i == iArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static int getCamera2SupportedLevel(int i) {
        CameraCharacteristics cameraCharacteristics;
        if (Build.VERSION.SDK_INT >= 21 && (cameraCharacteristics = getCameraCharacteristics(i)) != null) {
            return ((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue();
        }
        return Integer.MIN_VALUE;
    }

    @Nullable
    private static CameraCharacteristics getCameraCharacteristics(int i) throws CameraAccessException {
        CameraManager cameraManager;
        if (ContextUtils.getApplicationContext() == null || (cameraManager = (CameraManager) ContextUtils.getApplicationContext().getSystemService("camera")) == null) {
            return null;
        }
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            if (i < cameraIdList.length) {
                return cameraManager.getCameraCharacteristics(cameraIdList[i]);
            }
            Logging.e(TAG, "Invalid camera Id: " + i);
            return null;
        } catch (CameraAccessException e) {
            Logging.e(TAG, "getCameraCharacteristics: " + e.getMessage());
            return null;
        } catch (AssertionError e2) {
            Logging.e(TAG, "getCameraCharacteristics: " + e2.getMessage());
            return null;
        } catch (IllegalArgumentException e3) {
            Logging.e(TAG, "getCameraCharacteristics: " + e3.getMessage());
            return null;
        } catch (Exception e4) {
            Logging.e(TAG, "getNumberOfCameras: got exception: " + e4);
            return null;
        }
    }

    public static int getCaptureApiType(int i) throws CameraAccessException {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(i);
        if (cameraCharacteristics == null) {
            return 11;
        }
        int iIntValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue();
        if (iIntValue == 2) {
            return 7;
        }
        int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        int length = iArr.length;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            if (iArr[i2] == 0) {
                z = true;
                break;
            }
            i2++;
        }
        if (!z) {
            return 11;
        }
        if (iIntValue != 0) {
            return iIntValue != 1 ? 7 : 8;
        }
        return 9;
    }

    private static int getClosestWhiteBalance(int i, int[] iArr) {
        int iAbs;
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        int iValueAt = -1;
        while (true) {
            SparseIntArray sparseIntArray = COLOR_TEMPERATURES_MAP;
            if (i3 >= sparseIntArray.size()) {
                return iValueAt;
            }
            if (findInIntArray(iArr, sparseIntArray.valueAt(i3)) != -1 && (iAbs = Math.abs(i - sparseIntArray.keyAt(i3))) < i2) {
                iValueAt = sparseIntArray.valueAt(i3);
                i2 = iAbs;
            }
            i3++;
        }
    }

    @Nullable
    public static String getDeviceId(int i) {
        String[] cameraIdList = new CameraIdListTask().getCameraIdList();
        if (cameraIdList != null && i < cameraIdList.length) {
            return cameraIdList[i];
        }
        Logging.e(TAG, "Invalid camera index: " + i);
        return null;
    }

    @Nullable
    public static List<VideoCaptureFormat> getDeviceSupportedFormats(int i) throws CameraAccessException {
        Logging.d(TAG, "getDeviceSupportedFormats() " + i);
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(i);
        if (cameraCharacteristics == null) {
            return null;
        }
        return getFormatsFromParemeters(cameraCharacteristics, IMAGE_FORMAT);
    }

    public static int getFacingMode(int i) throws CameraAccessException {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(i);
        if (cameraCharacteristics == null) {
            return 0;
        }
        int iIntValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue();
        if (iIntValue != 0) {
            return iIntValue != 1 ? 0 : 2;
        }
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005e A[Catch: Exception -> 0x007f, TryCatch #0 {Exception -> 0x007f, blocks: (B:11:0x001d, B:13:0x002d, B:16:0x0034, B:19:0x003b, B:21:0x003f, B:26:0x0054, B:29:0x0060, B:30:0x0068, B:28:0x005e), top: B:36:0x001d }] */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<io.agora.rtc2.video.VideoCaptureFormat> getFormatsFromParemeters(@androidx.annotation.NonNull android.hardware.camera2.CameraCharacteristics r19, int r20) {
        /*
            r0 = r19
            android.hardware.camera2.CameraCharacteristics$Key r1 = android.hardware.camera2.CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES
            java.lang.Object r1 = r0.get(r1)
            int[] r1 = (int[]) r1
            int r2 = r1.length
            r4 = 0
        Lc:
            r5 = 1
            if (r4 >= r2) goto L17
            r6 = r1[r4]
            if (r6 != r5) goto L14
            goto L18
        L14:
            int r4 = r4 + 1
            goto Lc
        L17:
            r5 = 0
        L18:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.hardware.camera2.CameraCharacteristics$Key r2 = android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP     // Catch: java.lang.Exception -> L7f
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Exception -> L7f
            android.hardware.camera2.params.StreamConfigurationMap r0 = (android.hardware.camera2.params.StreamConfigurationMap) r0     // Catch: java.lang.Exception -> L7f
            int[] r2 = r0.getOutputFormats()     // Catch: java.lang.Exception -> L7f
            int r4 = r2.length     // Catch: java.lang.Exception -> L7f
            r6 = 0
        L2b:
            if (r6 >= r4) goto L87
            r7 = r2[r6]     // Catch: java.lang.Exception -> L7f
            r8 = r20
            if (r7 == r8) goto L34
            goto L7c
        L34:
            android.util.Size[] r9 = r0.getOutputSizes(r7)     // Catch: java.lang.Exception -> L7f
            if (r9 != 0) goto L3b
            goto L7c
        L3b:
            int r10 = r9.length     // Catch: java.lang.Exception -> L7f
            r11 = 0
        L3d:
            if (r11 >= r10) goto L7c
            r12 = r9[r11]     // Catch: java.lang.Exception -> L7f
            int r13 = r12.getWidth()     // Catch: java.lang.Exception -> L7f
            int r14 = r12.getHeight()     // Catch: java.lang.Exception -> L7f
            boolean r13 = io.agora.rtc2.video.VideoCaptureCamera.shouldExcludeSize(r13, r14)     // Catch: java.lang.Exception -> L7f
            if (r13 == 0) goto L50
            goto L79
        L50:
            r13 = 30
            if (r5 == 0) goto L5e
            long r14 = r0.getOutputMinFrameDuration(r7, r12)     // Catch: java.lang.Exception -> L7f
            r16 = 0
            int r18 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r18 != 0) goto L60
        L5e:
            double r13 = (double) r13     // Catch: java.lang.Exception -> L7f
            goto L68
        L60:
            r16 = 4741671816366391296(0x41cdcd6500000000, double:1.0E9)
            double r13 = (double) r14     // Catch: java.lang.Exception -> L7f
            double r13 = r16 / r13
        L68:
            io.agora.rtc2.video.VideoCaptureFormat r15 = new io.agora.rtc2.video.VideoCaptureFormat     // Catch: java.lang.Exception -> L7f
            int r3 = r12.getWidth()     // Catch: java.lang.Exception -> L7f
            int r12 = r12.getHeight()     // Catch: java.lang.Exception -> L7f
            int r13 = (int) r13     // Catch: java.lang.Exception -> L7f
            r15.<init>(r3, r12, r13, r7)     // Catch: java.lang.Exception -> L7f
            r1.add(r15)     // Catch: java.lang.Exception -> L7f
        L79:
            int r11 = r11 + 1
            goto L3d
        L7c:
            int r6 = r6 + 1
            goto L2b
        L7f:
            r0 = move-exception
            java.lang.String r2 = io.agora.rtc2.video.VideoCaptureCamera2.TAG
            java.lang.String r3 = "Unable to catch device supported video formats: "
            io.agora.base.internal.Logging.e(r2, r3, r0)
        L87:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc2.video.VideoCaptureCamera2.getFormatsFromParemeters(android.hardware.camera2.CameraCharacteristics, int):java.util.List");
    }

    @Nullable
    public static String getName(int i) throws CameraAccessException {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(i);
        if (cameraCharacteristics == null) {
            return null;
        }
        int iIntValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue();
        StringBuilder sb = new StringBuilder();
        sb.append("camera2 ");
        sb.append(i);
        sb.append(", facing ");
        sb.append(iIntValue == 0 ? "front" : "back");
        return sb.toString();
    }

    public static int getNumberOfCameras() {
        CameraIdListTask cameraIdListTask = new CameraIdListTask();
        if (cameraIdListTask.getCameraIdList() == null) {
            return 0;
        }
        return cameraIdListTask.getCameraIdList().length;
    }

    public static boolean isLegacyDevice(int i) throws CameraAccessException {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(i);
        return cameraCharacteristics != null && ((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue() == 2;
    }

    private boolean isSupportedStability(int i, int[] iArr) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestFaceDetection(CaptureRequest.Builder builder, int i) {
        if (builder == null) {
            Logging.e(TAG, "face detect requestBuilder error");
            return;
        }
        if (!this.mFaceDetectSupported) {
            Logging.w(TAG, "face detect not supported");
            return;
        }
        if (this.mPreviewSession == null) {
            Logging.w(TAG, "face detect not ready");
            return;
        }
        if (this.mEnableAutoFaceFocus || this.mEnableFaceDetection) {
            if (i != 0 && !this.mIsFaceDetectionStarted) {
                this.mIsFaceDetectionStarted = true;
                builder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, Integer.valueOf(i));
            } else if (i == 0) {
                this.mIsFaceDetectionStarted = false;
                this.mPreviewRequestBuilder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, 0);
                this.mPerFrameFaceDetectionInfoQueue.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAutoFaceFocusInternal(boolean z) throws CameraAccessException {
        CaptureRequest.Builder builder;
        if (this.mEnableAutoFaceFocus == z) {
            Logging.w(TAG, "face detect no change");
            return;
        }
        this.mEnableAutoFaceFocus = z;
        if (!this.mFaceDetectSupported) {
            Logging.w(TAG, "face detect not supported");
            return;
        }
        if (this.mPreviewSession == null) {
            Logging.w(TAG, "face detect not ready");
            return;
        }
        if (this.mCameraThreadHandler == null || (builder = this.mPreviewRequestBuilder) == null) {
            return;
        }
        if (z) {
            if (!this.mIsFaceDetectionStarted) {
                this.mIsFaceDetectionStarted = true;
                builder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, Integer.valueOf(this.mFaceDetectMode));
            }
        } else if (this.mEnableFaceDetection) {
            Logging.w(TAG, "face detect did not turn off due to faceDistance on");
            return;
        } else {
            this.mIsFaceDetectionStarted = false;
            builder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, 0);
            this.mPerFrameFaceDetectionInfoQueue.clear();
        }
        CameraCaptureSession cameraCaptureSession = this.mPreviewSession;
        if (cameraCaptureSession != null) {
            try {
                cameraCaptureSession.setRepeatingRequest(this.mPreviewRequestBuilder.build(), this.mCaptureCallback, this.mCameraThreadHandler);
            } catch (CameraAccessException e) {
                ThrowableExtension.printStackTrace(e);
            } catch (IllegalArgumentException e2) {
                ThrowableExtension.printStackTrace(e2);
            } catch (IllegalStateException e3) {
                ThrowableExtension.printStackTrace(e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFaceDetectionInternal(boolean z) throws CameraAccessException {
        CaptureRequest.Builder builder;
        if (this.mEnableFaceDetection == z) {
            Logging.w(TAG, "face detect no change");
            return;
        }
        this.mEnableFaceDetection = z;
        if (!this.mFaceDetectSupported) {
            Logging.w(TAG, "face detect not supported");
            return;
        }
        if (this.mPreviewSession == null) {
            Logging.w(TAG, "face detect not ready");
            return;
        }
        if (this.mCameraThreadHandler == null || (builder = this.mPreviewRequestBuilder) == null) {
            return;
        }
        if (z) {
            if (!this.mIsFaceDetectionStarted) {
                this.mIsFaceDetectionStarted = true;
                builder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, Integer.valueOf(this.mFaceDetectMode));
            }
        } else if (this.mEnableAutoFaceFocus) {
            Logging.w(TAG, "face detect did not turn off due to autoFocus on");
            return;
        } else {
            this.mIsFaceDetectionStarted = false;
            builder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, 0);
            this.mPerFrameFaceDetectionInfoQueue.clear();
        }
        CameraCaptureSession cameraCaptureSession = this.mPreviewSession;
        if (cameraCaptureSession != null) {
            try {
                cameraCaptureSession.setRepeatingRequest(this.mPreviewRequestBuilder.build(), this.mCaptureCallback, this.mCameraThreadHandler);
            } catch (CameraAccessException e) {
                ThrowableExtension.printStackTrace(e);
            } catch (IllegalArgumentException e2) {
                ThrowableExtension.printStackTrace(e2);
            } catch (IllegalStateException e3) {
                ThrowableExtension.printStackTrace(e3);
            }
        }
    }

    private static boolean shouldSkipSettingAeTargetFpsRange() {
        for (String str : AE_TARGET_FPS_RANGE_BUGGY_DEVICE_LIST) {
            if (Build.MODEL.contains(str)) {
                return true;
            }
        }
        return false;
    }

    private int toCamera2VideoStabilityMode(int i) {
        if (i < 0 || i > 1) {
            return 0;
        }
        return i;
    }

    @Override // io.agora.rtc2.video.IVideoCapture
    public boolean allocate(@NonNull VideoCaptureFormat videoCaptureFormat) throws CameraAccessException {
        String str = TAG;
        Logging.d(str, String.format(Locale.US, "allocate: requested (%d x %d) @%dfps", Integer.valueOf(videoCaptureFormat.getWidth()), Integer.valueOf(videoCaptureFormat.getHeight()), Integer.valueOf(videoCaptureFormat.getFramerate())));
        synchronized (this.mCameraStateLock) {
            int i = this.mCameraState;
            if (i != 0 && i != 1) {
                CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mId);
                if (cameraCharacteristics == null) {
                    Logging.e(str, "failed to getCameraCharacteristics.");
                    return false;
                }
                List<VideoCaptureFormat> formatsFromParemeters = getFormatsFromParemeters(cameraCharacteristics, IMAGE_FORMAT);
                Logging.d(str, "format list: " + Arrays.toString(formatsFromParemeters.toArray()));
                VideoCaptureFormat videoCaptureFormatFindBestMatchedCapability = VideoCapture.FindBestMatchedCapability(formatsFromParemeters, videoCaptureFormat);
                this.mCaptureFormat = videoCaptureFormatFindBestMatchedCapability;
                if (videoCaptureFormatFindBestMatchedCapability == null) {
                    Logging.e(str, "failed to match capability");
                    return false;
                }
                List<Range> listAsList = Arrays.asList((Object[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES));
                Logging.d(str, "fpsRanges: " + Arrays.toString(listAsList.toArray()));
                if (listAsList.isEmpty()) {
                    Logging.e(str, "No supported framerate ranges.");
                    return false;
                }
                ArrayList arrayList = new ArrayList(listAsList.size());
                int i2 = ((Integer) ((Range) listAsList.get(0)).getUpper()).intValue() > 1000 ? 1 : 1000;
                for (Range range : listAsList) {
                    arrayList.add(new VideoCapture.FramerateRange(((Integer) range.getLower()).intValue() * i2, ((Integer) range.getUpper()).intValue() * i2));
                }
                VideoCapture.FramerateRange framerateRangeFindBestFrameRateRange = VideoCaptureCamera.findBestFrameRateRange(arrayList, this.mCaptureFormat.getFramerate() * 1000, this.mPQFirst);
                if (framerateRangeFindBestFrameRateRange == null) {
                    Logging.e(TAG, "No matched framerate ranges.");
                    return false;
                }
                this.mAeFpsRange = new Range<>(Integer.valueOf(framerateRangeFindBestFrameRateRange.min / i2), Integer.valueOf(framerateRangeFindBestFrameRateRange.max / i2));
                Logging.d(TAG, String.format(Locale.US, "allocate: matched (%d x %d) @[%d - %d]", Integer.valueOf(this.mCaptureFormat.mWidth), Integer.valueOf(this.mCaptureFormat.mHeight), this.mAeFpsRange.getLower(), this.mAeFpsRange.getUpper()));
                this.mCameraNativeOrientation = ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
                this.mInvertDeviceOrientationReadings = ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 1;
                int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.STATISTICS_INFO_AVAILABLE_FACE_DETECT_MODES);
                Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.STATISTICS_INFO_MAX_FACE_COUNT);
                if (iArr != null && iArr.length > 1 && num != null && num.intValue() > 0) {
                    this.mFaceDetectSupported = true;
                    int i3 = 0;
                    for (int i4 : iArr) {
                        i3 += i4;
                    }
                    if (i3 % 2 != 0) {
                        this.mFaceDetectMode = 1;
                    } else {
                        this.mFaceDetectMode = 2;
                    }
                }
                Logging.d(TAG, "allocate() face detection: " + this.mFaceDetectMode + " " + num + " " + this.mFaceDetectSupported);
                return true;
            }
            Logging.e(str, "allocate() invoked while Camera is busy opening/configuring.");
            return false;
        }
    }

    public Rect clampFace(Rect rect) {
        int iClamp = CoordinatesTransform.clamp(rect.left, 0, rect.right);
        int iClamp2 = CoordinatesTransform.clamp(rect.top, 0, rect.bottom);
        int i = rect.right;
        int iClamp3 = CoordinatesTransform.clamp(i, 0, i);
        int i2 = rect.bottom;
        return new Rect(iClamp, iClamp2, iClamp3, CoordinatesTransform.clamp(i2, 0, i2));
    }

    @Override // io.agora.rtc2.video.IVideoCapture
    public void deallocate() {
        Logging.d(TAG, "deallocate()");
    }

    public void finalize() {
        Handler handler = this.mCameraThreadHandler;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.mCameraThreadHandler = null;
        }
    }

    @VisibleForTesting
    public Handler getCameraThreadHandler() {
        return this.mCameraThreadHandler;
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public float getMaxZoom() {
        CameraCharacteristics cameraCharacteristics;
        if (this.mMaxZoom <= 1.0f && (cameraCharacteristics = getCameraCharacteristics(this.mId)) != null) {
            this.mMaxZoom = getMaxZoom(cameraCharacteristics);
        }
        return this.mMaxZoom;
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public boolean isAutoFaceFocusSupported() throws CameraAccessException {
        if (!isFocusSupported()) {
            return false;
        }
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mId);
        if (cameraCharacteristics == null) {
            Logging.w(TAG, "warning cameraCharacteristics is null");
            return false;
        }
        Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.STATISTICS_INFO_MAX_FACE_COUNT);
        return num != null && num.intValue() > 0;
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public boolean isExposureSupported() throws CameraAccessException {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mId);
        if (cameraCharacteristics == null) {
            Logging.w(TAG, "warning cameraCharacteristics is null");
            return false;
        }
        int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
        if (iArr != null) {
            for (int i = 0; i < iArr.length; i++) {
                Logging.d(TAG, "isExposureSupported AE mode = " + iArr[i]);
                if (1 == i) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public boolean isFaceDetectSupported() throws CameraAccessException {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mId);
        if (cameraCharacteristics == null) {
            Logging.w(TAG, "warning cameraCharacteristics is null");
            return false;
        }
        Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.STATISTICS_INFO_MAX_FACE_COUNT);
        int iIntValue = num == null ? 0 : num.intValue();
        Logging.d(TAG, "face dedect, numDetectedFaces: " + iIntValue);
        return iIntValue > 0;
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public boolean isFocusSupported() throws CameraAccessException {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mId);
        if (cameraCharacteristics == null) {
            Logging.w(TAG, "warning cameraCharacteristics is null");
            return false;
        }
        int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if (iArr != null) {
            for (int i = 0; i < iArr.length; i++) {
                if (1 == i) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public boolean isTorchSupported() throws CameraAccessException {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mId);
        if (cameraCharacteristics == null) {
            Logging.w(TAG, "warning cameraCharacteristics is null");
            return false;
        }
        Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public boolean isZoomSupported() throws CameraAccessException {
        if (this.mMaxZoom > 1.0f) {
            return true;
        }
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mId);
        if (cameraCharacteristics != null) {
            this.mMaxZoom = getMaxZoom(cameraCharacteristics);
        }
        return this.mMaxZoom > 1.0f;
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public boolean needFallback() {
        return true;
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public int setAutoFaceFocus(final boolean z) {
        this.mCameraThreadHandler.post(new Runnable() { // from class: io.agora.rtc2.video.VideoCaptureCamera2.5
            @Override // java.lang.Runnable
            public void run() throws CameraAccessException {
                VideoCaptureCamera2.this.setAutoFaceFocusInternal(z);
            }
        });
        return 0;
    }

    @VisibleForTesting
    public void setCameraThreadHandler() {
        HandlerThread handlerThread = new HandlerThread("VideoCaptureCamera2_CameraThread");
        handlerThread.start();
        this.mCameraThreadHandler = new Handler(handlerThread.getLooper());
        this.mThreadChecker = new ThreadUtils.ThreadChecker(handlerThread);
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public int setExposure(float f, float f2) throws CameraAccessException {
        char c;
        String str = TAG;
        Logging.d(str, "setExposure called camera api2");
        if (f < 0.0f || f > this.mRenderView.getWidth() || f2 < 0.0f || f2 > this.mRenderView.getHeight()) {
            Logging.e(str, "set exposure unreasonable inputs");
            return -1;
        }
        CaptureRequest.Builder builder = this.mPreviewRequestBuilder;
        if (builder == null) {
            Logging.w(str, "setExposure mPreviewBuilder is null");
            return -1;
        }
        Rect rect = (Rect) builder.get(CaptureRequest.SCALER_CROP_REGION);
        if (rect == null) {
            return -1;
        }
        RectF rectF = new RectF(f, f2, f, f2);
        int width = this.mRenderView.getWidth();
        int height = this.mRenderView.getHeight();
        VideoCaptureFormat videoCaptureFormat = this.mCaptureFormat;
        int i = videoCaptureFormat.mWidth;
        int i2 = videoCaptureFormat.mHeight;
        int i3 = this.mId;
        RectF rectFViewToNormalized = CoordinatesTransform.viewToNormalized(rectF, width, height, i, i2, i3 == 1, getCameraRotation() * (i3 == 1 ? 1 : -1), this.mRenderMode);
        if (rectFViewToNormalized == null) {
            Logging.d(str, "setExposure coordinate " + f + " - " + f2 + " out of image bounds!!");
            return -1;
        }
        float f3 = rectFViewToNormalized.left;
        float f4 = rectFViewToNormalized.top;
        RectF rectF2 = new RectF();
        rectF2.left = CoordinatesTransform.clamp(f3 - 0.05f, 0.0f, 1.0f);
        rectF2.right = CoordinatesTransform.clamp(f3 + 0.05f, 0.0f, 1.0f);
        rectF2.top = CoordinatesTransform.clamp(f4 - 0.05f, 0.0f, 1.0f);
        rectF2.bottom = CoordinatesTransform.clamp(f4 + 0.05f, 0.0f, 1.0f);
        VideoCaptureFormat videoCaptureFormat2 = this.mCaptureFormat;
        RectF rectFNormalizedToSensor = CoordinatesTransform.normalizedToSensor(rectF2, videoCaptureFormat2.mWidth, videoCaptureFormat2.mHeight, rect.width(), rect.height(), (this.mId == 1 ? 1 : -1) * getCameraRotation(), true);
        if (rectFNormalizedToSensor == null) {
            Logging.w(str, "Failed to translate input coordinate");
            return -1;
        }
        Rect rect2 = new Rect();
        if (rectFNormalizedToSensor.width() == 0.0f || rectFNormalizedToSensor.height() == 0.0f) {
            c = 0;
            rect2 = new Rect(0, 0, 0, 0);
        } else {
            rectFNormalizedToSensor.round(rect2);
            c = 0;
        }
        CaptureRequest.Builder builder2 = this.mPreviewRequestBuilder;
        CaptureRequest.Key key = CaptureRequest.CONTROL_AE_REGIONS;
        MeteringRectangle[] meteringRectangleArr = new MeteringRectangle[1];
        meteringRectangleArr[c] = new MeteringRectangle(rect2, 1000);
        builder2.set(key, meteringRectangleArr);
        this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
        CameraCaptureSession cameraCaptureSession = this.mPreviewSession;
        if (cameraCaptureSession != null) {
            try {
                cameraCaptureSession.setRepeatingRequest(this.mPreviewRequestBuilder.build(), null, null);
            } catch (CameraAccessException e) {
                ThrowableExtension.printStackTrace(e);
                return -1;
            } catch (IllegalArgumentException e2) {
                ThrowableExtension.printStackTrace(e2);
                return -1;
            } catch (IllegalStateException e3) {
                ThrowableExtension.printStackTrace(e3);
                return -1;
            }
        }
        RectF rectF3 = new RectF(rect2.left, rect2.top, rect2.right, rect2.bottom);
        int iWidth = rect.width();
        int iHeight = rect.height();
        VideoCaptureFormat videoCaptureFormat3 = this.mCaptureFormat;
        RectF rectFSensorToNormalized = CoordinatesTransform.sensorToNormalized(rectF3, iWidth, iHeight, videoCaptureFormat3.mWidth, videoCaptureFormat3.mHeight, true);
        int width2 = this.mRenderView.getWidth();
        int height2 = this.mRenderView.getHeight();
        int width3 = this.mCaptureFormat.getWidth();
        int height3 = this.mCaptureFormat.getHeight();
        int i4 = this.mId;
        RectF rectFNormalizedToView = CoordinatesTransform.normalizedToView(rectFSensorToNormalized, width2, height2, width3, height3, i4 == 1, (i4 == 1 ? 1 : -1) * getCameraRotation(), this.mRenderMode);
        if (rectFNormalizedToView == null) {
            Logging.w(str, "Failed to translate coordinate from normalized to view!!");
            return -1;
        }
        rectFNormalizedToView.round(rect2);
        notifyCameraExposureAreaChanged(rect2);
        return 0;
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public int setFaceDetection(final boolean z) {
        this.mCameraThreadHandler.post(new Runnable() { // from class: io.agora.rtc2.video.VideoCaptureCamera2.6
            @Override // java.lang.Runnable
            public void run() throws CameraAccessException {
                VideoCaptureCamera2.this.setFaceDetectionInternal(z);
            }
        });
        return 0;
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public int setFocus(float f, float f2) throws CameraAccessException {
        String str = TAG;
        Logging.d(str, "setFocus " + f + " - " + f2);
        if (f < 0.0f || f > this.mRenderView.getWidth() || f2 < 0.0f || f2 > this.mRenderView.getHeight()) {
            Logging.e(str, "set focus unreasonable inputs");
            return -1;
        }
        CaptureRequest.Builder builder = this.mPreviewRequestBuilder;
        if (builder == null) {
            Logging.d(str, "setFocus mPreviewRequestBuilder is null");
            return -1;
        }
        Rect rect = (Rect) builder.get(CaptureRequest.SCALER_CROP_REGION);
        if (rect == null) {
            return -1;
        }
        int iWidth = rect.width();
        int iHeight = rect.height();
        RectF rectF = new RectF(f, f2, f, f2);
        int width = this.mRenderView.getWidth();
        int height = this.mRenderView.getHeight();
        VideoCaptureFormat videoCaptureFormat = this.mCaptureFormat;
        int i = videoCaptureFormat.mWidth;
        int i2 = videoCaptureFormat.mHeight;
        int i3 = this.mId;
        RectF rectFViewToNormalized = CoordinatesTransform.viewToNormalized(rectF, width, height, i, i2, i3 == 1, (i3 == 1 ? 1 : -1) * getCameraRotation(), this.mRenderMode);
        if (rectFViewToNormalized == null) {
            Logging.d(str, "setFocus coordinate " + f + " - " + f2 + " out of image bounds!!");
            return -1;
        }
        float f3 = rectFViewToNormalized.left;
        float f4 = rectFViewToNormalized.top;
        RectF rectF2 = new RectF();
        rectF2.left = CoordinatesTransform.clamp(f3 - 0.05f, 0.0f, 1.0f);
        rectF2.right = CoordinatesTransform.clamp(f3 + 0.05f, 0.0f, 1.0f);
        rectF2.top = CoordinatesTransform.clamp(f4 - 0.05f, 0.0f, 1.0f);
        rectF2.bottom = CoordinatesTransform.clamp(f4 + 0.05f, 0.0f, 1.0f);
        VideoCaptureFormat videoCaptureFormat2 = this.mCaptureFormat;
        RectF rectFNormalizedToSensor = CoordinatesTransform.normalizedToSensor(rectF2, videoCaptureFormat2.mWidth, videoCaptureFormat2.mHeight, iWidth, iHeight, (this.mId == 1 ? 1 : -1) * getCameraRotation(), true);
        if (rectFNormalizedToSensor == null) {
            Logging.w(str, "Failed to translate input coordinate");
            return -1;
        }
        Rect rect2 = new Rect();
        if (rectFNormalizedToSensor.width() == 0.0f || rectFNormalizedToSensor.height() == 0.0f) {
            rect2 = new Rect(0, 0, 0, 0);
        } else {
            rectFNormalizedToSensor.round(rect2);
        }
        this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{new MeteringRectangle(rect2, 1000)});
        this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{new MeteringRectangle(rect2, 1000)});
        this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, 1);
        this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
        this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
        if (this.mCameraThreadHandler != null) {
            CameraCaptureSession cameraCaptureSession = this.mPreviewSession;
            if (cameraCaptureSession != null) {
                try {
                    cameraCaptureSession.setRepeatingRequest(this.mPreviewRequestBuilder.build(), this.mAfCaptureCallback, this.mCameraThreadHandler);
                } catch (CameraAccessException e) {
                    ThrowableExtension.printStackTrace(e);
                    return -1;
                } catch (IllegalArgumentException e2) {
                    ThrowableExtension.printStackTrace(e2);
                    return -1;
                } catch (IllegalStateException e3) {
                    ThrowableExtension.printStackTrace(e3);
                    return -1;
                }
            }
            VideoCaptureFormat videoCaptureFormat3 = this.mCaptureFormat;
            RectF rectFSensorToNormalized = CoordinatesTransform.sensorToNormalized(rectFNormalizedToSensor, iWidth, iHeight, videoCaptureFormat3.mWidth, videoCaptureFormat3.mHeight, true);
            int width2 = this.mRenderView.getWidth();
            int height2 = this.mRenderView.getHeight();
            int width3 = this.mCaptureFormat.getWidth();
            int height3 = this.mCaptureFormat.getHeight();
            int i4 = this.mId;
            RectF rectFNormalizedToView = CoordinatesTransform.normalizedToView(rectFSensorToNormalized, width2, height2, width3, height3, i4 == 1, (i4 == 1 ? 1 : -1) * getCameraRotation(), this.mRenderMode);
            if (rectFNormalizedToView == null) {
                Logging.w(str, "Failed to translate coordinate from normalized to view!!");
                return -1;
            }
            rectFNormalizedToView.round(rect2);
            notifyCameraFocusAreaChanged(rect2);
        }
        return 0;
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public int setTorchMode(boolean z) throws CameraAccessException {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mId);
        if (cameraCharacteristics == null) {
            Logging.w(TAG, "warning cameraCharacteristics is null");
            return -1;
        }
        if (this.mPreviewRequestBuilder == null) {
            Logging.w(TAG, "warning mPreviewRequestBuilder is null");
            return -1;
        }
        Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        if (bool == null ? false : bool.booleanValue()) {
            if (z) {
                this.mPreviewRequestBuilder.set(CaptureRequest.FLASH_MODE, 2);
            } else {
                this.mPreviewRequestBuilder.set(CaptureRequest.FLASH_MODE, 0);
            }
            CameraCaptureSession cameraCaptureSession = this.mPreviewSession;
            if (cameraCaptureSession != null) {
                try {
                    cameraCaptureSession.setRepeatingRequest(this.mPreviewRequestBuilder.build(), null, this.mCameraThreadHandler);
                    this.mTorch = z;
                    return 0;
                } catch (CameraAccessException e) {
                    ThrowableExtension.printStackTrace(e);
                } catch (IllegalArgumentException e2) {
                    ThrowableExtension.printStackTrace(e2);
                } catch (IllegalStateException e3) {
                    ThrowableExtension.printStackTrace(e3);
                }
            }
        } else {
            Logging.w(TAG, "flash is not supported");
        }
        return -1;
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public int setVideoStabilityMode(int i) throws CameraAccessException {
        if (this.mPreviewRequestBuilder == null) {
            Logging.d(TAG, "setVideoStabilityMode mPreviewRequestBuilder return.");
            return -1;
        }
        int camera2VideoStabilityMode = toCamera2VideoStabilityMode(i);
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mId);
        if (cameraCharacteristics == null) {
            return -1;
        }
        if (isSupportedStability(camera2VideoStabilityMode, (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES)) && this.mPreviewSession != null) {
            this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, Integer.valueOf(camera2VideoStabilityMode));
            try {
                Logging.d(TAG, "setVideoStabilityMode = " + i);
                this.mPreviewSession.setRepeatingRequest(this.mPreviewRequestBuilder.build(), this.mCaptureCallback, null);
                return 0;
            } catch (CameraAccessException e) {
                ThrowableExtension.printStackTrace(e);
            } catch (IllegalArgumentException e2) {
                ThrowableExtension.printStackTrace(e2);
            } catch (IllegalStateException e3) {
                ThrowableExtension.printStackTrace(e3);
            }
        }
        Logging.e(TAG, "not supported VideoStability Mode = " + i);
        return -1;
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public int setZoom(float f) throws CameraAccessException {
        String str = TAG;
        Logging.d(str, "setCameraZoom api2 called zoomValue =" + f);
        if (this.mPreviewRequestBuilder == null) {
            Logging.d(str, "setZoom mPreviewRequestBuilder is null");
            return -1;
        }
        if (this.mSensorRect == null) {
            CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mId);
            if (cameraCharacteristics == null) {
                Logging.w(str, "warning cameraCharacteristics is null");
                return -1;
            }
            this.mSensorRect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            this.mMaxZoom = getMaxZoom(cameraCharacteristics);
        }
        if (Math.abs(this.mMaxZoom - 1.0f) < 0.001f) {
            Logging.w(str, "Camera " + this.mId + " does not support camera zoom");
            return -1;
        }
        if (!(f >= 1.0f && f <= this.mMaxZoom && f != this.mLastZoomRatio)) {
            return -2;
        }
        this.mPreviewRequestBuilder.set(CaptureRequest.SCALER_CROP_REGION, cropRegionForZoom(f));
        this.mLastZoomRatio = f;
        CameraCaptureSession cameraCaptureSession = this.mPreviewSession;
        if (cameraCaptureSession != null) {
            try {
                cameraCaptureSession.setRepeatingRequest(this.mPreviewRequestBuilder.build(), this.mCaptureCallback, this.mCameraThreadHandler);
            } catch (CameraAccessException e) {
                ThrowableExtension.printStackTrace(e);
                return -3;
            } catch (IllegalArgumentException e2) {
                ThrowableExtension.printStackTrace(e2);
                return -4;
            } catch (IllegalStateException e3) {
                ThrowableExtension.printStackTrace(e3);
                return -4;
            }
        }
        return 0;
    }

    @Override // io.agora.rtc2.video.IVideoCapture
    public boolean startCaptureMaybeAsync() {
        String str = TAG;
        Logging.d(str, "startCaptureMaybeAsync() ");
        changeCameraStateAndNotify(0);
        if (ContextUtils.getApplicationContext() == null || this.mProxyThreadHandler == null) {
            Logging.w(str, "context or proxyThread unavailable");
            return false;
        }
        final CameraManager cameraManager = (CameraManager) ContextUtils.getApplicationContext().getSystemService("camera");
        if (cameraManager == null) {
            return false;
        }
        final CrStateListener crStateListener = new CrStateListener();
        notifyInjector(crStateListener);
        try {
            Boolean bool = (Boolean) ThreadUtils.invokeAtFrontUninterruptibly(this.mProxyThreadHandler, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, new Callable<Boolean>() { // from class: io.agora.rtc2.video.VideoCaptureCamera2.3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Boolean call() throws Exception {
                    try {
                        String[] cameraIdList = cameraManager.getCameraIdList();
                        VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
                        int i = videoCaptureCamera2.mId;
                        if (i < cameraIdList.length) {
                            cameraManager.openCamera(cameraIdList[i], crStateListener, videoCaptureCamera2.mCameraThreadHandler);
                            return Boolean.TRUE;
                        }
                        Logging.e(VideoCaptureCamera2.TAG, "Invalid camera Id: " + VideoCaptureCamera2.this.mId);
                        return Boolean.FALSE;
                    } catch (CameraAccessException e) {
                        Logging.e(VideoCaptureCamera2.TAG, "allocate: manager.openCamera: " + e.getMessage());
                        return Boolean.FALSE;
                    } catch (IllegalArgumentException e2) {
                        Logging.e(VideoCaptureCamera2.TAG, "allocate: manager.openCamera: " + e2.getMessage());
                        return Boolean.FALSE;
                    } catch (SecurityException e3) {
                        Logging.e(VideoCaptureCamera2.TAG, "allocate: manager.openCamera: " + e3.getMessage());
                        return Boolean.FALSE;
                    } catch (Exception e4) {
                        Logging.e(VideoCaptureCamera2.TAG, "allocate: manager.openCamera: " + e4.getMessage());
                        return Boolean.FALSE;
                    }
                }
            });
            if (bool != null && bool.booleanValue()) {
                return bool.booleanValue();
            }
            changeCameraStateAndNotify(4);
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // io.agora.rtc2.video.IVideoCapture
    public void stopCaptureAndBlockUntilStopped() {
        String str = TAG;
        Logging.d(str, "stopCaptureAndBlockUntilStopped()");
        Handler handler = this.mProxyThreadHandler;
        if (handler == null) {
            Logging.w(str, "proxyThread unavailable");
            return;
        }
        try {
            ThreadUtils.invokeAtFrontUninterruptibly(handler, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, new Callable<Void>() { // from class: io.agora.rtc2.video.VideoCaptureCamera2.4
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    synchronized (VideoCaptureCamera2.this.mCameraStateLock) {
                        while (VideoCaptureCamera2.this.mCameraState != 2 && VideoCaptureCamera2.this.mCameraState != 4 && VideoCaptureCamera2.this.mCameraState != 3) {
                            try {
                                VideoCaptureCamera2.this.mCameraStateLock.wait();
                            } catch (InterruptedException e) {
                                Logging.e(VideoCaptureCamera2.TAG, "CaptureStartedEvent: " + e.getMessage());
                            }
                        }
                        if (VideoCaptureCamera2.this.mCameraState == 4) {
                            ISurfaceTextureHelper iSurfaceTextureHelper = VideoCaptureCamera2.this.mSurfaceTextureHelper;
                            if (iSurfaceTextureHelper != null) {
                                iSurfaceTextureHelper.stopListening();
                                VideoCaptureCamera2.this.mSurfaceTextureHelper.dispose();
                                VideoCaptureCamera2.this.mSurfaceTextureHelper = null;
                            }
                            return null;
                        }
                        VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
                        videoCaptureCamera2.requestFaceDetection(videoCaptureCamera2.mPreviewRequestBuilder, 0);
                        ISurfaceTextureHelper iSurfaceTextureHelper2 = VideoCaptureCamera2.this.mSurfaceTextureHelper;
                        if (iSurfaceTextureHelper2 != null) {
                            iSurfaceTextureHelper2.stopListening();
                            VideoCaptureCamera2.this.mSurfaceTextureHelper.dispose();
                            VideoCaptureCamera2.this.mSurfaceTextureHelper = null;
                        }
                        VideoCaptureCamera2.this.mCameraThreadHandler.post(new StopCaptureTask());
                        VideoCaptureCamera2.this.mWaitForDeviceClosedConditionVariable.block();
                        Logging.d(VideoCaptureCamera2.TAG, "releaseCamera done!");
                        return null;
                    }
                }
            });
        } catch (Exception e) {
            Logging.e(TAG, "stopCaptureAndBlockUntilStopped fail: " + e.getMessage());
        }
        synchronized (this.mImageReaderLock) {
            ImageReader imageReader = this.mImageReader;
            if (imageReader != null) {
                try {
                    try {
                        imageReader.setOnImageAvailableListener(null, null);
                        this.mImageReader.close();
                    } catch (IllegalArgumentException e2) {
                        Logging.e(TAG, "ImageReader Close():" + e2.getMessage());
                    }
                } catch (IllegalStateException e3) {
                    Logging.e(TAG, "ImageReader Close():" + e3.getMessage());
                }
                this.mImageReader = null;
            }
        }
        Handler handler2 = this.mCameraThreadHandler;
        if (handler2 != null) {
            handler2.getLooper().quitSafely();
            this.mCameraThreadHandler = null;
        }
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
        this.mIsFaceDetectionStarted = false;
        this.mPerFrameFaceDetectionInfoQueue.clear();
    }

    private static float getMaxZoom(CameraCharacteristics cameraCharacteristics) {
        if (cameraCharacteristics == null) {
            Logging.w(TAG, "warning cameraCharacteristics is null");
            return -1.0f;
        }
        Float f = (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (f == null) {
            Logging.w(TAG, "warning get max zoom return null");
            return -1.0f;
        }
        return f.floatValue();
    }
}
