package io.agora.rtc2.video;

import android.content.Intent;
import android.os.Build;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import io.agora.base.internal.CalledByNative;
import io.agora.base.internal.ContextUtils;
import io.agora.base.internal.Logging;
import io.agora.base.internal.video.EglBase;
import io.agora.rtc2.video.VideoCaptureCameraFallbackWrapper;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class VideoCaptureFactory {
    private static final String TAG = "VideoCaptureFactory";
    private static final List<String> TEXTURE_EXCEPTION_MODELS = Arrays.asList("LG-H848", "Pixel 4a", "SM-A7000", "MI MAX");

    public @interface CAMERA_MODULE_SELECTED {
        public static final int ANDROID_CAMERA1 = 0;
        public static final int ANDROID_CAMERA2 = 1;
        public static final int ANDROID_CAMERA_AUTO = -1;
    }

    public static class ChromiumCameraInfo {
        private static int sNumberOfSystemCameras = -1;

        /* JADX INFO: Access modifiers changed from: private */
        public static int getNumberOfCameras() {
            if (sNumberOfSystemCameras == -1) {
                if (ContextUtils.getApplicationContext() == null) {
                    return sNumberOfSystemCameras;
                }
                if (Build.VERSION.SDK_INT < 23 && ContextUtils.getApplicationContext().getPackageManager().checkPermission("android.permission.CAMERA", ContextUtils.getApplicationContext().getPackageName()) != 0) {
                    sNumberOfSystemCameras = 0;
                    Logging.w(VideoCaptureFactory.TAG, "Missing android.permission.CAMERA permission, no system camera available.");
                } else if (VideoCaptureFactory.isLReleaseOrLater()) {
                    sNumberOfSystemCameras = VideoCaptureCamera2.getNumberOfCameras();
                } else {
                    sNumberOfSystemCameras = VideoCaptureCamera1.getNumberOfCameras();
                }
            }
            return sNumberOfSystemCameras;
        }
    }

    @CalledByNative
    public static IVideoCapture createCameraCapture(int i, long j, boolean z, boolean z2, int i2, EglBase.Context context, int i3, int i4) {
        boolean z3;
        Logging.w(TAG, "createVideoCapture() " + i + ", captureToTexture: " + z + ", camera_selected_level: " + i4 + ", pqFirst: " + z2 + ", skipControl: " + i2);
        List<String> list = TEXTURE_EXCEPTION_MODELS;
        String str = Build.MODEL;
        if (list.contains(str)) {
            Logging.w(TAG, "Not support for " + str);
            z3 = false;
        } else {
            z3 = z;
        }
        if (isLegacyOrDeprecatedDevice(i) || i3 == 0 || isLessSelectedLevel(i, i4)) {
            return new VideoCaptureCamera1(i, j, z3, z2, i2, context);
        }
        boolean z4 = z3;
        return createFallbackWrapper(new VideoCaptureCamera2(i, j, z4, z2, i2, context), i, j, z4, z2, i2, context);
    }

    public static IVideoCaptureCamera createFallbackWrapper(IVideoCaptureCamera iVideoCaptureCamera, final int i, final long j, final boolean z, final boolean z2, final int i2, final EglBase.Context context) {
        return new VideoCaptureCameraFallbackWrapper(iVideoCaptureCamera, new VideoCaptureCameraFallbackWrapper.OnCameraFallbackListener() { // from class: io.agora.rtc2.video.VideoCaptureFactory.1
            @Override // io.agora.rtc2.video.VideoCaptureCameraFallbackWrapper.OnCameraFallbackListener
            public IVideoCaptureCamera createFallbackCamera() {
                return new VideoCaptureCamera1(i, j, z, z2, i2, context);
            }
        });
    }

    @CalledByNative
    public static VideoCapture createScreenCapture(long j, EglBase.Context context, Intent intent) {
        return new VideoCaptureScreen(j, context, intent);
    }

    @CalledByNative
    public static int getCaptureApiType(int i) {
        return isLegacyOrDeprecatedDevice(i) ? VideoCaptureCamera1.getCaptureApiType(i) : VideoCaptureCamera2.getCaptureApiType(i);
    }

    @Nullable
    @CalledByNative
    public static String getDeviceId(int i) {
        return isLegacyOrDeprecatedDevice(i) ? VideoCaptureCamera1.getDeviceId(i) : VideoCaptureCamera2.getDeviceId(i);
    }

    @Nullable
    @CalledByNative
    public static String getDeviceName(int i) {
        return isLegacyOrDeprecatedDevice(i) ? VideoCaptureCamera1.getName(i) : VideoCaptureCamera2.getName(i);
    }

    @Nullable
    @CalledByNative
    public static List<VideoCaptureFormat> getDeviceSupportedFormats(int i) {
        return isLegacyOrDeprecatedDevice(i) ? VideoCaptureCamera1.getDeviceSupportedFormats(i) : VideoCaptureCamera2.getDeviceSupportedFormats(i);
    }

    @CalledByNative
    public static int getFacingMode(int i) {
        return isLegacyOrDeprecatedDevice(i) ? VideoCaptureCamera1.getFacingMode(i) : VideoCaptureCamera2.getFacingMode(i);
    }

    @CalledByNative
    public static int getNumberOfCameras() {
        return ChromiumCameraInfo.getNumberOfCameras();
    }

    public static boolean isInCamera2BlackList() {
        String str = Build.DEVICE;
        if ("ocean".equalsIgnoreCase(str) && "oe106".equalsIgnoreCase(Build.MODEL)) {
            return true;
        }
        if ("trident".equalsIgnoreCase(str) && "de106".equalsIgnoreCase(Build.MODEL)) {
            return true;
        }
        if (("shark".equalsIgnoreCase(str) && "skr-a0".equalsIgnoreCase(Build.MODEL)) || "hnnem-h".equalsIgnoreCase(str)) {
            return true;
        }
        if ((!"on7xelte".equals(str) || !"SM-G610F".equals(Build.MODEL)) && !"m2c".equals(str)) {
            String str2 = Build.MODEL;
            if (!"M578CA".equals(str2)) {
                String str3 = Build.MANUFACTURER;
                return ("samsung".equalsIgnoreCase(str3) && str2 != null && (str2.contains("SM-G930") || str2.contains("SM-G935") || str2.contains("SM-G950") || str2.contains("SM-G955") || "SC-02H".equals(str2) || "SCV33".equals(str2) || "SC-02J".equals(str2) || "SCV36".equals(str2) || "SM-G892A".equals(str2) || "SM-G892U".equals(str2) || "SC-03J".equals(str2) || "SCV35".equals(str2))) || "oneplus".equalsIgnoreCase(str3) || "PCAM00".equalsIgnoreCase(str2) || "h8296".equalsIgnoreCase(str2);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isLReleaseOrLater() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @CalledByNative
    public static boolean isLegacyOrDeprecatedDevice(int i) {
        return !isLReleaseOrLater() || VideoCaptureCamera2.isLegacyDevice(i) || isInCamera2BlackList();
    }

    public static boolean isLessSelectedLevel(int i, int i2) {
        int camera2SupportedLevel = VideoCaptureCamera2.getCamera2SupportedLevel(i);
        if (camera2SupportedLevel == Integer.MIN_VALUE) {
            return true;
        }
        SparseIntArray sparseIntArray = VideoCaptureCamera2.ANDROID_CAMERA_HARDWARE_LEVEL_MAP;
        return sparseIntArray.get(camera2SupportedLevel) <= sparseIntArray.get(i2, 1);
    }
}
