package io.agora.rtc2.video;

import android.annotation.TargetApi;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import io.agora.base.NV21Buffer;
import io.agora.base.TextureBuffer;
import io.agora.base.VideoFrame;
import io.agora.base.internal.Logging;
import io.agora.base.internal.ThreadUtils;
import io.agora.base.internal.video.EglBase;
import io.agora.base.internal.video.ISurfaceTextureHelper;
import io.agora.base.internal.video.SurfaceTextureHelper;
import io.agora.rtc2.video.VideoCapture;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(15)
/* loaded from: classes4.dex */
public class VideoCaptureCamera1 extends VideoCaptureCamera {
    private static final SparseArray<String> COLOR_TEMPERATURES_MAP;
    private static final boolean DEBUG = false;
    private static final int GL_TEXTURE_EXTERNAL_OES = 36197;
    private static int IMAGE_FORMAT = 0;
    private static final int NUM_CAPTURE_BUFFERS = 3;
    private static final String TAG = "VideoCaptureCamera1";
    private Camera.Area mAreaOfInterest;

    @Nullable
    private Camera mCamera;
    private int mExpectedFrameSize;
    private boolean mIsRunning;
    private final Object mObjectLock;
    private ReentrantLock mPreviewBufferLock;
    private Camera.Parameters mPreviewParameters;

    public static class BuggyDeviceHack {
        private static final String[] COLORSPACE_BUGGY_DEVICE_LIST = {"SAMSUNG-SGH-I747", "ODROID-U2", "XT1092", "XT1095", "XT1096", "XT1097"};

        private BuggyDeviceHack() {
        }

        public static int getImageFormat() {
            return isBuggyDevice() ? 17 : 842094169;
        }

        public static boolean isBuggyDevice() {
            for (String str : COLORSPACE_BUGGY_DEVICE_LIST) {
                if (str.contentEquals(Build.MODEL)) {
                    return true;
                }
            }
            return false;
        }
    }

    public class CrErrorCallback implements Camera.ErrorCallback {
        public CrErrorCallback() {
        }

        @Override // android.hardware.Camera.ErrorCallback
        public void onError(int i, Camera camera) {
            if (i == 2 || i == 100 || i == 1) {
                VideoCaptureCamera1.this.deallocate();
                int i2 = 901;
                if (i == 2) {
                    i2 = 6;
                } else if (i == 100) {
                    i2 = 5;
                }
                VideoCaptureCamera1.this.onError(i2, "Camera ErrorCallback id: " + i);
            }
        }
    }

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        COLOR_TEMPERATURES_MAP = sparseArray;
        sparseArray.append(2850, "incandescent");
        sparseArray.append(2950, "warm-fluorescent");
        sparseArray.append(4250, "fluorescent");
        sparseArray.append(4600, "twilight");
        sparseArray.append(5500, "daylight");
        sparseArray.append(PlaybackException.ERROR_CODE_DRM_UNSPECIFIED, "cloudy-daylight");
        sparseArray.append(AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND, "shade");
        IMAGE_FORMAT = 17;
    }

    public VideoCaptureCamera1(int i, long j, boolean z, boolean z2, int i2, EglBase.Context context) {
        super(i, j, z, z2, i2, context);
        this.mPreviewBufferLock = new ReentrantLock();
        this.mObjectLock = new Object();
    }

    @Nullable
    private static Camera.CameraInfo getCameraInfo(int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        try {
            Camera.getCameraInfo(i, cameraInfo);
            return cameraInfo;
        } catch (RuntimeException e) {
            Logging.e(TAG, "getCameraInfo: Camera.getCameraInfo: " + e.getMessage());
            return null;
        }
    }

    public static int getCaptureApiType(int i) {
        return getCameraInfo(i) == null ? 11 : 6;
    }

    @Nullable
    private String getClosestWhiteBalance(int i, List<String> list) {
        int iAbs;
        int i2 = Integer.MAX_VALUE;
        String strValueAt = null;
        int i3 = 0;
        while (true) {
            SparseArray<String> sparseArray = COLOR_TEMPERATURES_MAP;
            if (i3 >= sparseArray.size()) {
                return strValueAt;
            }
            if (list.contains(sparseArray.valueAt(i3)) && (iAbs = Math.abs(i - sparseArray.keyAt(i3))) < i2) {
                strValueAt = sparseArray.valueAt(i3);
                i2 = iAbs;
            }
            i3++;
        }
    }

    @Nullable
    public static String getDeviceId(int i) {
        return Integer.toString(i);
    }

    @Nullable
    public static List<VideoCaptureFormat> getDeviceSupportedFormats(int i) {
        Logging.d(TAG, "getDeviceSupportedFormats() " + i);
        Camera.Parameters parameters = null;
        try {
            Camera cameraOpen = Camera.open(i);
            if (cameraOpen == null) {
                return null;
            }
            try {
                parameters = cameraOpen.getParameters();
            } catch (RuntimeException e) {
                Logging.e(TAG, "Failed to get camera parameters " + i, e);
            }
            List<VideoCaptureFormat> formatsFromParemeters = getFormatsFromParemeters(parameters, IMAGE_FORMAT);
            try {
                cameraOpen.release();
            } catch (Exception e2) {
                Logging.e(TAG, "Failed to release camera: " + i, e2);
            }
            return formatsFromParemeters;
        } catch (RuntimeException e3) {
            Logging.e(TAG, "Camera.open: " + e3.getMessage());
            return null;
        }
    }

    public static int getFacingMode(int i) {
        Camera.CameraInfo cameraInfo = getCameraInfo(i);
        if (cameraInfo == null) {
            return 0;
        }
        int i2 = cameraInfo.facing;
        if (i2 != 0) {
            return i2 != 1 ? 0 : 1;
        }
        return 2;
    }

    @NonNull
    private static List<VideoCaptureFormat> getFormatsFromParemeters(@Nullable Camera.Parameters parameters, int i) {
        String str = TAG;
        Logging.d(str, "getFormatsFromParemeters() ");
        ArrayList arrayList = new ArrayList();
        if (parameters == null) {
            return arrayList;
        }
        List<Integer> supportedPreviewFormats = parameters.getSupportedPreviewFormats();
        if (supportedPreviewFormats == null || supportedPreviewFormats.isEmpty()) {
            Logging.d(str, "failed to getFormatsFromParemeters, preview formats null or empty");
            return arrayList;
        }
        Iterator<Integer> it = supportedPreviewFormats.iterator();
        while (it.hasNext()) {
            if (it.next().intValue() == i) {
                List<int[]> arrayList2 = null;
                try {
                    arrayList2 = parameters.getSupportedPreviewFpsRange();
                } catch (StringIndexOutOfBoundsException e) {
                    Logging.e(TAG, "Camera.Parameters.getSupportedPreviewFpsRange: " + e.getMessage());
                }
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                }
                if (arrayList2.size() == 0) {
                    arrayList2.add(new int[]{0, 0});
                }
                int i2 = 0;
                Iterator<int[]> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    int i3 = (it2.next()[1] + 999) / 1000;
                    if (i2 < i3) {
                        i2 = i3;
                    }
                }
                List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                if (supportedPreviewSizes != null && !supportedPreviewSizes.isEmpty()) {
                    for (Camera.Size size : supportedPreviewSizes) {
                        if (!VideoCaptureCamera.shouldExcludeSize(size.width, size.height)) {
                            arrayList.add(new VideoCaptureFormat(size.width, size.height, i2, 17));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public static String getName(int i) {
        Camera.CameraInfo cameraInfo = getCameraInfo(i);
        if (cameraInfo == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("camera ");
        sb.append(i);
        sb.append(", facing ");
        sb.append(cameraInfo.facing == 1 ? "front" : "back");
        return sb.toString();
    }

    public static int getNumberOfCameras() {
        try {
            return Camera.getNumberOfCameras();
        } catch (Exception e) {
            Logging.e(TAG, "getNumberOfCameras: " + e.toString());
            return 0;
        }
    }

    private List<Integer> getZoomRatios() {
        if (this.mCamera == null) {
            return null;
        }
        Camera.Parameters cameraParameters = getCameraParameters();
        if (isZoomSupported(cameraParameters)) {
            return cameraParameters.getZoomRatios();
        }
        return null;
    }

    private static boolean isSupported(String str, List<String> list) {
        return list != null && list.indexOf(str) >= 0;
    }

    private void listenForBytebufferFrames() {
        this.mCamera.setPreviewCallbackWithBuffer(new Camera.PreviewCallback() { // from class: io.agora.rtc2.video.VideoCaptureCamera1.11
            @Override // android.hardware.Camera.PreviewCallback
            public void onPreviewFrame(final byte[] bArr, final Camera camera) {
                VideoCaptureCamera1.this.mPreviewBufferLock.lock();
                if (!VideoCaptureCamera1.this.mIsRunning) {
                    VideoCaptureCamera1.this.mPreviewBufferLock.unlock();
                    return;
                }
                if (bArr.length != VideoCaptureCamera1.this.mExpectedFrameSize) {
                    VideoCaptureCamera1.this.onFrameDropped(8);
                    VideoCaptureCamera1.this.mPreviewBufferLock.unlock();
                    if (camera != null) {
                        camera.addCallbackBuffer(bArr);
                        return;
                    }
                    return;
                }
                VideoFrame videoFrame = new VideoFrame(new NV21Buffer(bArr, VideoCaptureCamera1.this.mCaptureFormat.getWidth(), VideoCaptureCamera1.this.mCaptureFormat.getHeight(), new Runnable() { // from class: io.agora.rtc2.video.VideoCaptureCamera1.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoCaptureCamera1.this.mPreviewBufferLock.lock();
                        if (!VideoCaptureCamera1.this.mIsRunning) {
                            VideoCaptureCamera1.this.mPreviewBufferLock.unlock();
                            return;
                        }
                        VideoCaptureCamera1.this.mPreviewBufferLock.unlock();
                        if (camera != null) {
                            VideoCaptureCamera1.this.mCamera.addCallbackBuffer(bArr);
                        }
                    }
                }), VideoCaptureCamera1.this.getCameraRotation(), TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime()));
                VideoCaptureCamera1.this.attachPerFrameMetaInfos(videoFrame);
                VideoCaptureCamera1.this.onFrameCaptured(videoFrame);
                videoFrame.release();
                VideoCaptureCamera1.this.mPreviewBufferLock.unlock();
            }
        });
    }

    private void listenForTextureFrames() {
        ISurfaceTextureHelper iSurfaceTextureHelper = this.mSurfaceTextureHelper;
        if (iSurfaceTextureHelper == null) {
            return;
        }
        iSurfaceTextureHelper.startListening(new SurfaceTextureHelper.IVideoCapture() { // from class: io.agora.rtc2.video.VideoCaptureCamera1.10
            @Override // io.agora.base.internal.video.VideoSink
            public void onFrame(VideoFrame videoFrame) {
                VideoCaptureCamera1.this.mPreviewBufferLock.lock();
                try {
                    if (VideoCaptureCamera1.this.mIsRunning) {
                        VideoFrame videoFrame2 = new VideoFrame(VideoCapture.createTextureBufferWithModifiedTransformMatrix((TextureBuffer) videoFrame.getBuffer(), !VideoCaptureCamera1.this.mInvertDeviceOrientationReadings, 0), VideoCaptureCamera1.this.getCameraRotation(), videoFrame.getTimestampNs());
                        VideoCaptureCamera1.this.attachPerFrameMetaInfos(videoFrame2);
                        VideoCaptureCamera1.this.onFrameCaptured(videoFrame2);
                        videoFrame2.release();
                    }
                } finally {
                    VideoCaptureCamera1.this.mPreviewBufferLock.unlock();
                }
            }

            @Override // io.agora.base.internal.video.SurfaceTextureHelper.IVideoCapture
            public void onFrameDropped(int i) {
                VideoCaptureCamera1.super.onFrameDropped(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFaceDetection(Camera.Face[] faceArr) {
        double d;
        double dPow;
        ArrayList<RectF> arrayList = new ArrayList<>();
        ArrayList<Double> arrayList2 = new ArrayList<>();
        int i = this.mId;
        Camera.Parameters cameraParameters = getCameraParameters();
        this.mPreviewParameters = cameraParameters;
        if (cameraParameters == null || cameraParameters.getPreviewSize() == null) {
            return;
        }
        for (Camera.Face face : faceArr) {
            RectF rectFCameraToNormalized = CoordinatesTransform.cameraToNormalized(new RectF(face.rect));
            if (rectFCameraToNormalized != null) {
                if (this.mId == 1) {
                    d = 11.237d;
                    dPow = Math.pow(rectFCameraToNormalized.width(), -0.958d);
                } else {
                    d = 14.719d;
                    dPow = Math.pow(rectFCameraToNormalized.height(), -0.971d);
                }
                arrayList2.add(Double.valueOf(dPow * d));
                int width = this.mRenderView.getWidth();
                int height = this.mRenderView.getHeight();
                int i2 = this.mPreviewParameters.getPreviewSize().width;
                int i3 = this.mPreviewParameters.getPreviewSize().height;
                int i4 = this.mId;
                RectF rectFNormalizedToView = CoordinatesTransform.normalizedToView(rectFCameraToNormalized, width, height, i2, i3, i4 == 1, (i4 == 1 ? 1 : -1) * getCameraRotation(), this.mRenderMode);
                if (rectFNormalizedToView == null) {
                    arrayList2.remove(arrayList2.size() - 1);
                } else {
                    arrayList.add(rectFNormalizedToView);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        notifyFaceDetection(this.mCaptureFormat.getWidth(), this.mCaptureFormat.getHeight(), arrayList, arrayList2);
    }

    private void onFaceDetectionRequestChanged() {
        if (this.mEnableAutoFaceFocus && isAutoFaceFocusSupported()) {
            Logging.d(TAG, "startFaceDetection for auto focus enabled");
            Camera.FaceDetectionListener faceDetectionListener = new Camera.FaceDetectionListener() { // from class: io.agora.rtc2.video.VideoCaptureCamera1.3
                private long mLastFocusedTs;

                @Override // android.hardware.Camera.FaceDetectionListener
                public void onFaceDetection(Camera.Face[] faceArr, Camera camera) {
                    VideoCaptureCamera1 videoCaptureCamera1 = VideoCaptureCamera1.this;
                    if (videoCaptureCamera1.mEnableFaceDetection) {
                        videoCaptureCamera1.notifyFaceDetection(faceArr);
                    }
                    if (faceArr == null || faceArr.length == 0 || camera == null || !VideoCaptureCamera1.this.mEnableAutoFaceFocus) {
                        return;
                    }
                    if (System.currentTimeMillis() - this.mLastFocusedTs < 3000) {
                        if (faceArr[0].score > 20) {
                            VideoCaptureCamera1.this.notifyCameraFocusAreaChanged(faceArr[0].rect);
                            return;
                        }
                        return;
                    }
                    if (faceArr[0].score <= 50) {
                        Logging.d(VideoCaptureCamera1.TAG, "face score = " + faceArr[0].score);
                        return;
                    }
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(new Camera.Area(faceArr[0].rect, 1000));
                        if (camera.getParameters().getMaxNumFocusAreas() > 0) {
                            camera.getParameters().setFocusAreas(arrayList);
                        }
                        if (camera.getParameters().getMaxNumMeteringAreas() > 0) {
                            camera.getParameters().setMeteringAreas(arrayList);
                        }
                        VideoCaptureCamera1.this.notifyCameraFocusAreaChanged(faceArr[0].rect);
                        camera.autoFocus(new Camera.AutoFocusCallback() { // from class: io.agora.rtc2.video.VideoCaptureCamera1.3.1
                            @Override // android.hardware.Camera.AutoFocusCallback
                            public void onAutoFocus(boolean z, Camera camera2) {
                                Logging.d(VideoCaptureCamera1.TAG, "auto face focus called api1 every 3 seconds");
                                if (camera2 != null) {
                                    try {
                                        camera2.cancelAutoFocus();
                                    } catch (Exception e) {
                                        Logging.w(VideoCaptureCamera1.TAG, "Exception in cancelAutoFocus: " + Log.getStackTraceString(e));
                                    }
                                }
                            }
                        });
                        this.mLastFocusedTs = System.currentTimeMillis();
                    } catch (RuntimeException e) {
                        Logging.w(VideoCaptureCamera1.TAG, "Exception in onFaceDetection callback: " + Log.getStackTraceString(e));
                    }
                }
            };
            if (isFaceDetectSupported()) {
                safetyStarFaceDetection(faceDetectionListener);
                return;
            }
            return;
        }
        if (!this.mEnableFaceDetection || !isFaceDetectSupported()) {
            safetyStopFaceDetection();
            return;
        }
        Camera.FaceDetectionListener faceDetectionListener2 = new Camera.FaceDetectionListener() { // from class: io.agora.rtc2.video.VideoCaptureCamera1.4
            @Override // android.hardware.Camera.FaceDetectionListener
            public void onFaceDetection(Camera.Face[] faceArr, Camera camera) {
                VideoCaptureCamera1 videoCaptureCamera1 = VideoCaptureCamera1.this;
                if (videoCaptureCamera1.mEnableFaceDetection) {
                    videoCaptureCamera1.notifyFaceDetection(faceArr);
                }
            }
        };
        Logging.d(TAG, "startFaceDetection for face dectect enabled");
        safetyStarFaceDetection(faceDetectionListener2);
    }

    private void releaseCamera() {
        Handler handler = this.mProxyThreadHandler;
        if (handler == null) {
            Logging.w(TAG, "proxyThread unavailable");
            return;
        }
        try {
            ThreadUtils.invokeAtFrontUninterruptibly(handler, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, new Callable<Void>() { // from class: io.agora.rtc2.video.VideoCaptureCamera1.9
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    try {
                        if (VideoCaptureCamera1.this.mCamera != null) {
                            VideoCaptureCamera1.this.mCamera.release();
                            VideoCaptureCamera1.this.mCamera = null;
                            Logging.d(VideoCaptureCamera1.TAG, "releaseCamera done!");
                        }
                    } catch (Exception e) {
                        Logging.e(VideoCaptureCamera1.TAG, "releaseCamera: failed to release camera, " + e.getMessage());
                    }
                    return null;
                }
            });
        } catch (Exception e) {
            Logging.e(TAG, "releaseCamera: failed to release camera, " + e.getMessage());
        }
    }

    private void safetyStarFaceDetection(Camera.FaceDetectionListener faceDetectionListener) {
        Logging.d(TAG, "facedetect: " + this.mEnableFaceDetection);
        try {
            Camera camera = this.mCamera;
            if (camera != null) {
                if (this.mIsFaceDetectionStarted) {
                    camera.stopFaceDetection();
                }
                this.mCamera.setFaceDetectionListener(faceDetectionListener);
                this.mCamera.startFaceDetection();
                this.mIsFaceDetectionStarted = true;
            }
        } catch (Exception e) {
            Logging.e(TAG, "Failed to stop face detection", e);
            Camera camera2 = this.mCamera;
            if (camera2 != null) {
                camera2.stopFaceDetection();
                this.mCamera.setFaceDetectionListener(null);
                this.mIsFaceDetectionStarted = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void safetyStopFaceDetection() {
        Camera camera;
        Logging.d(TAG, "stopFaceDetection()");
        try {
            try {
                if (this.mIsFaceDetectionStarted) {
                    Camera camera2 = this.mCamera;
                    if (camera2 != null) {
                        camera2.stopFaceDetection();
                    }
                    this.mIsFaceDetectionStarted = false;
                    this.mPerFrameFaceDetectionInfoQueue.clear();
                }
                camera = this.mCamera;
                if (camera == null) {
                    return;
                }
            } catch (RuntimeException e) {
                Logging.e(TAG, "Failed to stop face detection", e);
                camera = this.mCamera;
                if (camera == null) {
                    return;
                }
            }
            camera.setFaceDetectionListener(null);
        } catch (Throwable th) {
            Camera camera3 = this.mCamera;
            if (camera3 != null) {
                camera3.setFaceDetectionListener(null);
            }
            throw th;
        }
    }

    private void setPreviewFrameRateModeFPS(Camera.Parameters parameters, int i) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.size() == 0) {
            Logging.w(TAG, "allocate: camera don't supported fps first.");
            parameters.setPreviewFrameRate(i);
            return;
        }
        int i2 = supportedPreviewFpsRange.get(0)[0] > 1000 ? 1 : 1000;
        ArrayList arrayList = new ArrayList(supportedPreviewFpsRange.size());
        for (int[] iArr : supportedPreviewFpsRange) {
            arrayList.add(new VideoCapture.FramerateRange(iArr[0] * i2, iArr[1] * i2));
        }
        VideoCapture.FramerateRange framerateRangeFindBestFrameRateRange = VideoCaptureCamera.findBestFrameRateRange(arrayList, i * 1000, false);
        if (framerateRangeFindBestFrameRateRange != null) {
            parameters.setPreviewFpsRange(framerateRangeFindBestFrameRateRange.min / i2, framerateRangeFindBestFrameRateRange.max / i2);
            Logging.d(TAG, String.format(Locale.US, "allocate: matched (%d x %d) @[%d - %d], fps first", Integer.valueOf(this.mCaptureFormat.mWidth), Integer.valueOf(this.mCaptureFormat.mHeight), Integer.valueOf(framerateRangeFindBestFrameRateRange.min / i2), Integer.valueOf(framerateRangeFindBestFrameRateRange.max / i2)));
        }
    }

    private void setPreviewFrameRateModePQ(Camera.Parameters parameters, int i) {
        List<Integer> supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
        if (supportedPreviewFrameRates == null || supportedPreviewFrameRates.size() == 0) {
            Logging.w(TAG, "allocate: camera don't supported PQ first.");
            setPreviewFrameRateModeFPS(parameters, i);
            return;
        }
        int iAbs = Math.abs(supportedPreviewFrameRates.get(0).intValue() - i);
        int iIntValue = supportedPreviewFrameRates.get(0).intValue();
        for (Integer num : supportedPreviewFrameRates) {
            int iAbs2 = Math.abs(num.intValue() - i);
            if (iAbs2 < iAbs) {
                iIntValue = num.intValue();
                iAbs = iAbs2;
            }
        }
        parameters.setPreviewFrameRate(iIntValue);
        Logging.d(TAG, String.format(Locale.US, "allocate: matched (%d x %d) @%d -set- @%d, PQ first", Integer.valueOf(this.mCaptureFormat.mWidth), Integer.valueOf(this.mCaptureFormat.mHeight), Integer.valueOf(i), Integer.valueOf(iIntValue)));
    }

    @Override // io.agora.rtc2.video.IVideoCapture
    public boolean allocate(@NonNull VideoCaptureFormat videoCaptureFormat) throws IOException {
        String str = TAG;
        Locale locale = Locale.US;
        Logging.d(str, String.format(locale, "allocate: requested (%d x %d) @%dfps", Integer.valueOf(videoCaptureFormat.getWidth()), Integer.valueOf(videoCaptureFormat.getHeight()), Integer.valueOf(videoCaptureFormat.getFramerate())));
        if (this.mSurfaceTextureHelper == null) {
            Logging.e(str, "surfaceTextureHelper null");
            return false;
        }
        if (this.mProxyThreadHandler == null) {
            Logging.w(str, "proxyThread unavailable");
            return false;
        }
        Camera.CameraInfo cameraInfo = getCameraInfo(this.mId);
        if (cameraInfo == null) {
            Logging.e(str, "failed to get camera info for " + this.mId);
            releaseCamera();
            return false;
        }
        try {
            Boolean bool = (Boolean) ThreadUtils.invokeAtFrontUninterruptibly(this.mProxyThreadHandler, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, new Callable<Boolean>() { // from class: io.agora.rtc2.video.VideoCaptureCamera1.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Boolean call() throws Exception {
                    try {
                        VideoCaptureCamera1 videoCaptureCamera1 = VideoCaptureCamera1.this;
                        videoCaptureCamera1.mCamera = Camera.open(videoCaptureCamera1.mId);
                        return Boolean.TRUE;
                    } catch (RuntimeException e) {
                        Logging.e(VideoCaptureCamera1.TAG, "allocate: Camera.open: " + e.getMessage());
                        return Boolean.FALSE;
                    }
                }
            });
            if (bool != null && bool.booleanValue()) {
                this.mCameraNativeOrientation = cameraInfo.orientation;
                this.mInvertDeviceOrientationReadings = cameraInfo.facing == 0;
                Logging.d(str, String.format(locale, "allocate: Rotation dev=%d, cam=%d, facing back? %s", Integer.valueOf(getDeviceRotation()), Integer.valueOf(this.mCameraNativeOrientation), Boolean.valueOf(this.mInvertDeviceOrientationReadings)));
                Camera.Parameters parameters = null;
                try {
                    parameters = this.mCamera.getParameters();
                } catch (RuntimeException e) {
                    Logging.e(TAG, "failed to get camera parameters for " + this.mId, e);
                }
                if (parameters == null) {
                    Logging.e(TAG, "failed to get camera parameters");
                    releaseCamera();
                    return false;
                }
                VideoCaptureFormat videoCaptureFormatFindBestMatchedCapability = VideoCapture.FindBestMatchedCapability(getFormatsFromParemeters(parameters, IMAGE_FORMAT), videoCaptureFormat);
                this.mCaptureFormat = videoCaptureFormatFindBestMatchedCapability;
                if (videoCaptureFormatFindBestMatchedCapability == null) {
                    Logging.e(TAG, "failed to match capability");
                    releaseCamera();
                    return false;
                }
                int i = videoCaptureFormatFindBestMatchedCapability.mFramerate;
                if (this.mPQFirst) {
                    setPreviewFrameRateModePQ(parameters, i);
                } else {
                    setPreviewFrameRateModeFPS(parameters, i);
                }
                if (this.mSkipControl == 1 || !parameters.getSupportedFocusModes().contains("continuous-video")) {
                    Logging.d(TAG, "Continuous focus mode not supported.");
                } else {
                    parameters.setFocusMode("continuous-video");
                }
                VideoCaptureFormat videoCaptureFormat2 = this.mCaptureFormat;
                parameters.setPreviewSize(videoCaptureFormat2.mWidth, videoCaptureFormat2.mHeight);
                parameters.setPreviewFormat(this.mCaptureFormat.mPixelFormat);
                try {
                    this.mCamera.setParameters(parameters);
                    try {
                        ISurfaceTextureHelper iSurfaceTextureHelper = this.mSurfaceTextureHelper;
                        VideoCaptureFormat videoCaptureFormat3 = this.mCaptureFormat;
                        iSurfaceTextureHelper.setTextureSize(videoCaptureFormat3.mWidth, videoCaptureFormat3.mHeight);
                        this.mCamera.setPreviewTexture(this.mSurfaceTextureHelper.getSurfaceTexture());
                        CrErrorCallback crErrorCallback = new CrErrorCallback();
                        notifyInjector(crErrorCallback);
                        this.mCamera.setErrorCallback(crErrorCallback);
                        if (!this.mCaptureToTexture) {
                            VideoCaptureFormat videoCaptureFormat4 = this.mCaptureFormat;
                            this.mExpectedFrameSize = ((videoCaptureFormat4.mWidth * videoCaptureFormat4.mHeight) * ImageFormat.getBitsPerPixel(videoCaptureFormat4.mPixelFormat)) / 8;
                            for (int i2 = 0; i2 < 3; i2++) {
                                this.mCamera.addCallbackBuffer(new byte[this.mExpectedFrameSize]);
                            }
                        }
                        this.mCamera.setDisplayOrientation(0);
                        return true;
                    } catch (IOException e2) {
                        Logging.e(TAG, "allocate: " + e2.getMessage());
                        releaseCamera();
                        return false;
                    } catch (Exception e3) {
                        Logging.e(TAG, "allocate: " + e3.getMessage());
                        releaseCamera();
                        return false;
                    }
                } catch (Exception e4) {
                    Logging.e(TAG, "setParameters: " + e4.getMessage());
                    releaseCamera();
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // io.agora.rtc2.video.IVideoCapture
    public void deallocate() {
        String str = TAG;
        Logging.d(str, "deallocate()");
        stopCaptureAndBlockUntilStopped();
        Handler handler = this.mProxyThreadHandler;
        if (handler == null) {
            Logging.w(str, "proxyThread unavailable");
        } else {
            handler.post(new Runnable() { // from class: io.agora.rtc2.video.VideoCaptureCamera1.8
                @Override // java.lang.Runnable
                public void run() throws IOException {
                    try {
                        if (VideoCaptureCamera1.this.mCamera != null) {
                            VideoCaptureCamera1.this.mCamera.setPreviewTexture(null);
                        }
                    } catch (Exception e) {
                        Logging.e(VideoCaptureCamera1.TAG, "deallocate: failed to setPreviewTexture " + e.getMessage());
                    }
                    VideoCaptureCamera1.this.mCaptureFormat = null;
                }
            });
            releaseCamera();
        }
    }

    public Camera.Parameters getCameraParameters() {
        try {
            return this.mCamera.getParameters();
        } catch (RuntimeException e) {
            Logging.e(TAG, "getCameraParameters: Camera.getParameters: ", e);
            if (this.mCamera == null) {
                return null;
            }
            safetyStopFaceDetection();
            releaseCamera();
            return null;
        }
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public float getMaxZoom() {
        if (this.mCamera == null) {
            return -1.0f;
        }
        Camera.Parameters cameraParameters = getCameraParameters();
        int maxZoom = isZoomSupported(cameraParameters) ? cameraParameters.getMaxZoom() : 0;
        List<Integer> zoomRatios = getZoomRatios();
        if (zoomRatios == null || zoomRatios.size() <= maxZoom) {
            return -1.0f;
        }
        return zoomRatios.get(maxZoom).intValue() / 100.0f;
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public boolean isAutoFaceFocusSupported() {
        Camera.Parameters cameraParameters;
        return this.mCamera != null && (cameraParameters = getCameraParameters()) != null && cameraParameters.getMaxNumDetectedFaces() > 0 && cameraParameters.getMaxNumFocusAreas() > 0 && isSupported(TtmlNode.TEXT_EMPHASIS_AUTO, cameraParameters.getSupportedFocusModes());
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public boolean isExposureSupported() {
        Camera.Parameters cameraParameters;
        return (this.mCamera == null || (cameraParameters = getCameraParameters()) == null || cameraParameters.getMaxNumMeteringAreas() <= 0) ? false : true;
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public boolean isFaceDetectSupported() {
        Camera.Parameters cameraParameters;
        if (this.mCamera == null || (cameraParameters = getCameraParameters()) == null) {
            return false;
        }
        Logging.d(TAG, "face dedect, numDetectedFaces: " + cameraParameters.getMaxNumDetectedFaces());
        return cameraParameters.getMaxNumDetectedFaces() > 0;
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public boolean isFocusSupported() {
        Camera.Parameters cameraParameters;
        return this.mCamera != null && (cameraParameters = getCameraParameters()) != null && cameraParameters.getMaxNumFocusAreas() > 0 && isSupported(TtmlNode.TEXT_EMPHASIS_AUTO, cameraParameters.getSupportedFocusModes());
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public boolean isTorchSupported() {
        Camera.Parameters cameraParameters;
        if (this.mCamera == null || (cameraParameters = getCameraParameters()) == null) {
            return false;
        }
        return isSupported("torch", cameraParameters.getSupportedFlashModes());
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public boolean isZoomSupported() {
        if (this.mCamera != null) {
            return isZoomSupported(getCameraParameters());
        }
        return false;
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public boolean needFallback() {
        return false;
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public int setAutoFaceFocus(boolean z) {
        if (this.mEnableAutoFaceFocus == z) {
            return 0;
        }
        this.mEnableAutoFaceFocus = z;
        onFaceDetectionRequestChanged();
        return 0;
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public int setExposure(float f, float f2) {
        String str = TAG;
        Logging.v(str, "setExposure called camera api1 x = " + f + " y = " + f2);
        if (this.mCamera == null) {
            Logging.d(str, "setExposure fucking null mCamera");
            return -1;
        }
        if (f < 0.0f || f > this.mRenderView.getWidth() || f2 < 0.0f || f2 > this.mRenderView.getHeight()) {
            Logging.d(str, "setExposure unreasonable inputs!");
            return -1;
        }
        Camera.Parameters cameraParameters = getCameraParameters();
        this.mPreviewParameters = cameraParameters;
        if (cameraParameters == null || cameraParameters.getPreviewSize() == null) {
            return -1;
        }
        RectF rectF = new RectF(f, f2, f, f2);
        int width = this.mRenderView.getWidth();
        int height = this.mRenderView.getHeight();
        int i = this.mPreviewParameters.getPreviewSize().width;
        int i2 = this.mPreviewParameters.getPreviewSize().height;
        int i3 = this.mId;
        RectF rectFViewToNormalized = CoordinatesTransform.viewToNormalized(rectF, width, height, i, i2, i3 == 1, getCameraRotation() * (i3 == 1 ? 1 : -1), this.mRenderMode);
        if (rectFViewToNormalized == null) {
            Logging.w(str, "Failed to translate input coordinate");
            return -1;
        }
        Rect rectCalculateFocusArea = CoordinatesTransform.calculateFocusArea(rectFViewToNormalized.left, rectFViewToNormalized.top, 1.5f);
        RectF rectFCameraToNormalized = CoordinatesTransform.cameraToNormalized(new RectF(rectCalculateFocusArea));
        VideoCaptureFormat videoCaptureFormat = this.mCaptureFormat;
        int i4 = videoCaptureFormat.mWidth;
        int i5 = videoCaptureFormat.mHeight;
        RectF rectFNormalizedToSensor = CoordinatesTransform.normalizedToSensor(rectFCameraToNormalized, i4, i5, i4, i5, 0, false);
        if (rectFNormalizedToSensor == null) {
            Logging.e(str, "Failed to translate input coordinate");
            return -1;
        }
        rectFNormalizedToSensor.round(rectCalculateFocusArea);
        if (this.mCamera != null) {
            Camera.Parameters cameraParameters2 = getCameraParameters();
            if (cameraParameters2 == null) {
                Logging.d(str, "getCameraParameters null");
                return -1;
            }
            if (cameraParameters2.getMaxNumMeteringAreas() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Camera.Area(rectCalculateFocusArea, 800));
                cameraParameters2.setMeteringAreas(arrayList);
            } else {
                Logging.d(str, "metering areas not supported");
            }
            try {
                this.mCamera.setParameters(cameraParameters2);
                this.mCamera.startPreview();
            } catch (Exception e) {
                Logging.d(TAG, "setExposure failed, " + e);
                return -1;
            }
        }
        Rect rect = new Rect();
        RectF rectF2 = new RectF(rectCalculateFocusArea);
        int width2 = this.mCaptureFormat.getWidth();
        int height2 = this.mCaptureFormat.getHeight();
        VideoCaptureFormat videoCaptureFormat2 = this.mCaptureFormat;
        RectF rectFSensorToNormalized = CoordinatesTransform.sensorToNormalized(rectF2, width2, height2, videoCaptureFormat2.mWidth, videoCaptureFormat2.mHeight, false);
        int width3 = this.mRenderView.getWidth();
        int height3 = this.mRenderView.getHeight();
        int width4 = this.mCaptureFormat.getWidth();
        int height4 = this.mCaptureFormat.getHeight();
        int i6 = this.mId;
        RectF rectFNormalizedToView = CoordinatesTransform.normalizedToView(rectFSensorToNormalized, width3, height3, width4, height4, i6 == 1, (i6 != 1 ? -1 : 1) * getCameraRotation(), this.mRenderMode);
        if (rectFNormalizedToView == null) {
            Logging.w(str, "failed to translate coordinate from normalized to view!");
            return -1;
        }
        rectFNormalizedToView.round(rect);
        notifyCameraExposureAreaChanged(rect);
        return 0;
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public int setFaceDetection(boolean z) {
        if (this.mEnableFaceDetection == z) {
            return 0;
        }
        this.mEnableFaceDetection = z;
        onFaceDetectionRequestChanged();
        return 0;
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public int setFocus(float f, float f2) {
        String str = TAG;
        Logging.d(str, "setFocus called camera api1");
        if (this.mCamera == null) {
            return -1;
        }
        if (f < 0.0f || f > this.mRenderView.getWidth() || f2 < 0.0f || f2 > this.mRenderView.getHeight()) {
            Logging.e(str, "set focus unreasonable inputs");
            return -1;
        }
        Camera.Parameters cameraParameters = getCameraParameters();
        this.mPreviewParameters = cameraParameters;
        if (cameraParameters != null && cameraParameters.getPreviewSize() != null) {
            RectF rectF = new RectF(f, f2, f, f2);
            int width = this.mRenderView.getWidth();
            int height = this.mRenderView.getHeight();
            int i = this.mPreviewParameters.getPreviewSize().width;
            int i2 = this.mPreviewParameters.getPreviewSize().height;
            int i3 = this.mId;
            RectF rectFViewToNormalized = CoordinatesTransform.viewToNormalized(rectF, width, height, i, i2, i3 == 1, getCameraRotation() * (i3 == 1 ? 1 : -1), this.mRenderMode);
            if (rectFViewToNormalized == null) {
                Logging.e(str, "Failed to translate input coordinate");
                return -1;
            }
            float f3 = rectFViewToNormalized.left;
            float f4 = rectFViewToNormalized.top;
            Rect rectCalculateFocusArea = CoordinatesTransform.calculateFocusArea(f3, f4, 1.0f);
            Rect rectCalculateFocusArea2 = CoordinatesTransform.calculateFocusArea(f3, f4, 1.5f);
            RectF rectFNormalizedToSensor = CoordinatesTransform.normalizedToSensor(CoordinatesTransform.cameraToNormalized(new RectF(rectCalculateFocusArea2)), this.mPreviewParameters.getPreviewSize().width, this.mPreviewParameters.getPreviewSize().height, this.mPreviewParameters.getPreviewSize().width, this.mPreviewParameters.getPreviewSize().height, 0, false);
            if (rectFNormalizedToSensor == null) {
                Logging.e(str, "Failed to translate input coordinate");
                return -1;
            }
            rectFNormalizedToSensor.round(rectCalculateFocusArea2);
            String str2 = "mCamera.autoFocus focusRect: " + rectCalculateFocusArea + ", meteringRect: " + rectCalculateFocusArea2;
            try {
                this.mCamera.cancelAutoFocus();
            } catch (RuntimeException e) {
                Logging.w(TAG, "Failed to cancle AutoFocus" + e);
            }
            Camera.Parameters cameraParameters2 = getCameraParameters();
            if (cameraParameters2 == null) {
                return -1;
            }
            if (cameraParameters2.getMaxNumFocusAreas() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Camera.Area(rectCalculateFocusArea, 800));
                cameraParameters2.setFocusAreas(arrayList);
            } else {
                Logging.w(TAG, "focus areas not supported");
            }
            if (cameraParameters2.getMaxNumMeteringAreas() > 0) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(new Camera.Area(rectCalculateFocusArea2, 800));
                cameraParameters2.setMeteringAreas(arrayList2);
            } else {
                Logging.w(TAG, "metering areas not supported");
            }
            final String focusMode = cameraParameters2.getFocusMode();
            if (isSupported("macro", cameraParameters2.getSupportedFocusModes())) {
                cameraParameters2.setFocusMode("macro");
                synchronized (this.mObjectLock) {
                    try {
                        this.mCamera.setParameters(cameraParameters2);
                    } catch (Exception e2) {
                        Logging.w(TAG, "mCamera.setParameters Exception: " + e2);
                    }
                }
            } else {
                Logging.w("focus", "FOCUS_MODE_MACRO is not supported");
            }
            try {
                this.mCamera.autoFocus(new Camera.AutoFocusCallback() { // from class: io.agora.rtc2.video.VideoCaptureCamera1.7
                    @Override // android.hardware.Camera.AutoFocusCallback
                    public void onAutoFocus(boolean z, Camera camera) {
                        if (VideoCaptureCamera1.this.mCamera == null) {
                            return;
                        }
                        Camera.Parameters parameters = camera.getParameters();
                        parameters.setFocusMode(focusMode);
                        synchronized (VideoCaptureCamera1.this.mObjectLock) {
                            try {
                                camera.setParameters(parameters);
                            } catch (Exception e3) {
                                Logging.w(VideoCaptureCamera1.TAG, "mCamera setParameters Exception: " + e3);
                            }
                        }
                    }
                });
                Rect rect = new Rect();
                RectF rectF2 = new RectF(rectCalculateFocusArea2);
                int width2 = this.mCaptureFormat.getWidth();
                int height2 = this.mCaptureFormat.getHeight();
                VideoCaptureFormat videoCaptureFormat = this.mCaptureFormat;
                RectF rectFSensorToNormalized = CoordinatesTransform.sensorToNormalized(rectF2, width2, height2, videoCaptureFormat.mWidth, videoCaptureFormat.mHeight, false);
                int width3 = this.mRenderView.getWidth();
                int height3 = this.mRenderView.getHeight();
                int width4 = this.mCaptureFormat.getWidth();
                int height4 = this.mCaptureFormat.getHeight();
                int i4 = this.mId;
                RectF rectFNormalizedToView = CoordinatesTransform.normalizedToView(rectFSensorToNormalized, width3, height3, width4, height4, i4 == 1, (i4 == 1 ? 1 : -1) * getCameraRotation(), this.mRenderMode);
                if (rectFNormalizedToView == null) {
                    Logging.w(TAG, "failed to translate coordinate from normalized to view!");
                    return -1;
                }
                rectFNormalizedToView.round(rect);
                notifyCameraExposureAreaChanged(rect);
                RectF rectFCameraToNormalized = CoordinatesTransform.cameraToNormalized(new RectF(rectCalculateFocusArea));
                int width5 = this.mRenderView.getWidth();
                int height5 = this.mRenderView.getHeight();
                int width6 = this.mCaptureFormat.getWidth();
                int height6 = this.mCaptureFormat.getHeight();
                int i5 = this.mId;
                RectF rectFNormalizedToView2 = CoordinatesTransform.normalizedToView(rectFCameraToNormalized, width5, height5, width6, height6, i5 == 1, (i5 != 1 ? -1 : 1) * getCameraRotation(), this.mRenderMode);
                if (rectFNormalizedToView2 == null) {
                    Logging.w(TAG, "failed to translate coordinate from normalized to view!");
                    return -1;
                }
                rectFNormalizedToView2.round(rect);
                notifyCameraFocusAreaChanged(rect);
                return 0;
            } catch (Exception e3) {
                Logging.w(TAG, "mCamera.autoFocus Exception: " + e3);
            }
        }
        return -1;
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public int setTorchMode(boolean z) {
        Camera.Parameters cameraParameters;
        if (this.mCamera == null || (cameraParameters = getCameraParameters()) == null) {
            return -2;
        }
        List<String> supportedFlashModes = cameraParameters.getSupportedFlashModes();
        if (supportedFlashModes != null) {
            if (supportedFlashModes.contains("torch")) {
                if (z) {
                    cameraParameters.setFlashMode("torch");
                } else {
                    cameraParameters.setFlashMode("off");
                }
                try {
                    this.mCamera.setParameters(cameraParameters);
                    return 0;
                } catch (Exception e) {
                    String str = TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("setTorchMode failed, mode: ");
                    sb.append(z ? "torch" : "off");
                    sb.append(", ");
                    sb.append(e);
                    Logging.w(str, sb.toString());
                }
            }
        }
        return -1;
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public int setVideoStabilityMode(int i) {
        Camera.Parameters cameraParameters;
        String str = TAG;
        Logging.w(str, "setVideoStabilityMode: " + i);
        if (this.mCamera == null || (cameraParameters = getCameraParameters()) == null) {
            return -1;
        }
        if (!cameraParameters.isVideoStabilizationSupported()) {
            Logging.e(str, "not supported VideoStability Mode = " + i);
            return -1;
        }
        if (i == 1) {
            cameraParameters.setVideoStabilization(true);
        } else if (i == 0) {
            cameraParameters.setVideoStabilization(false);
        }
        try {
            this.mCamera.setParameters(cameraParameters);
            return 0;
        } catch (Exception e) {
            Logging.w(TAG, "setVideoStabilityMode failed, mode: " + i + ", " + e);
            return -1;
        }
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public int setZoom(float f) {
        if (f >= 0.0f && this.mCamera != null) {
            int i = (int) ((f * 100.0f) + 0.5f);
            List<Integer> zoomRatios = getZoomRatios();
            if (zoomRatios == null) {
                return -1;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= zoomRatios.size()) {
                    i2 = 0;
                    break;
                }
                if (i <= zoomRatios.get(i2).intValue()) {
                    break;
                }
                i2++;
            }
            Camera.Parameters cameraParameters = getCameraParameters();
            if (!isZoomSupported(cameraParameters)) {
                return -1;
            }
            if (i2 > cameraParameters.getMaxZoom()) {
                Logging.w(TAG, "zoom value is larger than maxZoom value");
                return -1;
            }
            cameraParameters.setZoom(i2);
            try {
                this.mCamera.setParameters(cameraParameters);
                return 0;
            } catch (Exception e) {
                Logging.w(TAG, "setParameters failed, zoomLevel: " + i2 + ", " + e);
            }
        }
        return -1;
    }

    @Override // io.agora.rtc2.video.IVideoCapture
    public boolean startCaptureMaybeAsync() {
        String str = TAG;
        Logging.d(str, "startCaptureMaybeAsync()");
        if (this.mCamera == null) {
            Logging.e(str, "startCaptureAsync: mCamera is null");
            return false;
        }
        if (this.mProxyThreadHandler == null) {
            Logging.w(str, "proxyThread unavailable");
            return false;
        }
        this.mPreviewBufferLock.lock();
        try {
            if (this.mIsRunning) {
                return true;
            }
            this.mPreviewBufferLock.unlock();
            if (this.mCaptureToTexture) {
                listenForTextureFrames();
            } else {
                listenForBytebufferFrames();
            }
            try {
                Boolean bool = (Boolean) ThreadUtils.invokeAtFrontUninterruptibly(this.mProxyThreadHandler, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, new Callable<Boolean>() { // from class: io.agora.rtc2.video.VideoCaptureCamera1.2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public Boolean call() throws Exception {
                        try {
                            VideoCaptureCamera1.this.mCamera.startPreview();
                            Logging.d(VideoCaptureCamera1.TAG, "startCaptureMaybeAsync done.");
                            return Boolean.TRUE;
                        } catch (Exception e) {
                            Logging.e(VideoCaptureCamera1.TAG, "startCaptureAsync: Camera.startPreview: " + e.getMessage());
                            return Boolean.FALSE;
                        }
                    }
                });
                if (bool != null && bool.booleanValue()) {
                    onFaceDetectionRequestChanged();
                    this.mPreviewBufferLock.lock();
                    try {
                        onStarted();
                        this.mIsRunning = true;
                        return true;
                    } finally {
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        } finally {
        }
    }

    @Override // io.agora.rtc2.video.IVideoCapture
    public void stopCaptureAndBlockUntilStopped() {
        String str = TAG;
        Logging.d(str, "stopCaptureAndBlockUntilStopped()");
        if (this.mProxyThreadHandler == null) {
            Logging.w(str, "proxyThread unavailable");
            return;
        }
        this.mPreviewBufferLock.lock();
        try {
            if (this.mIsRunning) {
                this.mIsRunning = false;
                this.mPreviewBufferLock.unlock();
                this.mProxyThreadHandler.post(new Runnable() { // from class: io.agora.rtc2.video.VideoCaptureCamera1.5
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoCaptureCamera1.this.safetyStopFaceDetection();
                    }
                });
                try {
                    ThreadUtils.invokeAtFrontUninterruptibly(this.mProxyThreadHandler, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, new Callable<Void>() { // from class: io.agora.rtc2.video.VideoCaptureCamera1.6
                        @Override // java.util.concurrent.Callable
                        public Void call() throws Exception {
                            VideoCaptureCamera1 videoCaptureCamera1 = VideoCaptureCamera1.this;
                            if (videoCaptureCamera1.mCaptureToTexture) {
                                ISurfaceTextureHelper iSurfaceTextureHelper = videoCaptureCamera1.mSurfaceTextureHelper;
                                if (iSurfaceTextureHelper != null) {
                                    iSurfaceTextureHelper.stopListening();
                                    VideoCaptureCamera1.this.mSurfaceTextureHelper.dispose();
                                    VideoCaptureCamera1.this.mSurfaceTextureHelper = null;
                                }
                            } else {
                                videoCaptureCamera1.mCamera.setPreviewCallbackWithBuffer(null);
                            }
                            try {
                                VideoCaptureCamera1.this.mCamera.stopPreview();
                                Logging.d(VideoCaptureCamera1.TAG, "stopPreview done!");
                            } catch (Exception e) {
                                Logging.e(VideoCaptureCamera1.TAG, "stopPreview got exception:" + e.toString());
                            }
                            return null;
                        }
                    });
                } catch (Exception e) {
                    Logging.e(TAG, "stopPreview got exception:" + e.toString());
                }
            }
        } finally {
            this.mPreviewBufferLock.unlock();
        }
    }

    private boolean isZoomSupported(Camera.Parameters parameters) {
        if (parameters != null) {
            if (parameters.isZoomSupported()) {
                return true;
            }
            Logging.w(TAG, "camera zoom is not supported!");
        }
        return false;
    }
}
