package io.agora.base.internal.video;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import androidx.annotation.Nullable;
import io.agora.base.internal.CalledByNative;
import io.agora.base.internal.Logging;
import io.agora.base.internal.ThreadUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes4.dex */
public class VideoEncoderUtils {
    public static final int FINDCODEC_TIMEOUT = 3000;
    private static final String TAG = "HardwareVideoEncoderUtils";
    private static final HashMap<VideoCodecType, MediaCodecInfo> codecByTypeCache = new HashMap<>();
    public static final List<String> H264_HW_EXCEPTION_MODELS = Arrays.asList("Lenovo S90-u", "CHM-CL00", "CHM-TL00H", "CHM-UL00", "E6533", "HUAWEI CRR-UL00", "HUAWEI MT7-TL00", "HONOR H30-L01", "CHE-TL00H", "CHE-TL00", "Che2-TL00", "Che2-TL00M", "HTC D820mt", "HUAWEI P7-L10", "HUAWEI P7-L07", "M5s", "SAMSUNG-SGH-I337", "Nexus 7", "Nexus 4", "P6-C00", "HM 2A", "XT105", "XT109", "XT1060");
    private static final List<String> H265_HW_EXCEPTION_HARDWARES = Arrays.asList("mt6771", "mt6762");

    /* renamed from: io.agora.base.internal.video.VideoEncoderUtils$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$io$agora$base$internal$video$VideoCodecType;

        static {
            int[] iArr = new int[VideoCodecType.values().length];
            $SwitchMap$io$agora$base$internal$video$VideoCodecType = iArr;
            try {
                iArr[VideoCodecType.VP8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$agora$base$internal$video$VideoCodecType[VideoCodecType.VP9.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$agora$base$internal$video$VideoCodecType[VideoCodecType.H264.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$agora$base$internal$video$VideoCodecType[VideoCodecType.H265.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$agora$base$internal$video$VideoCodecType[VideoCodecType.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Nullable
    public static MediaCodecInfo findCodecForType(final VideoCodecType videoCodecType, final boolean z) {
        if (Build.VERSION.SDK_INT < 19) {
            return null;
        }
        HashMap<VideoCodecType, MediaCodecInfo> map = codecByTypeCache;
        if (map.containsKey(videoCodecType)) {
            return map.get(videoCodecType);
        }
        final MediaCodecInfo[] mediaCodecInfoArr = new MediaCodecInfo[1];
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() { // from class: io.agora.base.internal.video.VideoEncoderUtils.1
            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                while (true) {
                    if (i >= MediaCodecList.getCodecCount()) {
                        break;
                    }
                    MediaCodecInfo codecInfoAt = null;
                    try {
                        codecInfoAt = MediaCodecList.getCodecInfoAt(i);
                    } catch (IllegalArgumentException e) {
                        Logging.e(VideoEncoderUtils.TAG, "Cannot retrieve encoder codec info", e);
                    }
                    if (codecInfoAt != null && codecInfoAt.isEncoder() && VideoEncoderUtils.isSupportedCodec(codecInfoAt, videoCodecType, z)) {
                        Logging.d(VideoEncoderUtils.TAG, "found available encodec: " + codecInfoAt.getName());
                        mediaCodecInfoArr[0] = codecInfoAt;
                        break;
                    }
                    i++;
                }
                VideoEncoderUtils.codecByTypeCache.put(videoCodecType, mediaCodecInfoArr[0]);
                countDownLatch.countDown();
            }
        }).start();
        if (!ThreadUtils.awaitUninterruptibly(countDownLatch, 3000L)) {
            Logging.e(TAG, "findCodecForType timeout");
        }
        return mediaCodecInfoArr[0];
    }

    public static boolean isHardwareSupportedInCurrentSdk(MediaCodecInfo mediaCodecInfo, VideoCodecType videoCodecType) {
        int i = AnonymousClass2.$SwitchMap$io$agora$base$internal$video$VideoCodecType[videoCodecType.ordinal()];
        if (i == 1) {
            return isHardwareSupportedInCurrentSdkVp8(mediaCodecInfo);
        }
        if (i == 2) {
            return isHardwareSupportedInCurrentSdkVp9(mediaCodecInfo);
        }
        if (i == 3) {
            return isHardwareSupportedInCurrentSdkH264(mediaCodecInfo);
        }
        if (i == 4) {
            return isHardwareSupportedInCurrentSdkH265();
        }
        if (i != 5) {
            return false;
        }
        Logging.e(TAG, "UNKNOWN is not excepted!!!");
        return false;
    }

    public static boolean isHardwareSupportedInCurrentSdkH264(MediaCodecInfo mediaCodecInfo) {
        if (H264_HW_EXCEPTION_MODELS.contains(Build.MODEL)) {
            return false;
        }
        return mediaCodecInfo.getName().startsWith("OMX.qcom.") ? Build.VERSION.SDK_INT >= 19 : Build.VERSION.SDK_INT >= 21;
    }

    public static boolean isHardwareSupportedInCurrentSdkH265() {
        List<String> list = H265_HW_EXCEPTION_HARDWARES;
        String str = Build.HARDWARE;
        if (!list.contains(str)) {
            return Build.VERSION.SDK_INT >= 21;
        }
        Logging.w(TAG, "Hardware: " + str + " has black listed H.265 encoder.");
        return false;
    }

    public static boolean isHardwareSupportedInCurrentSdkVp8(MediaCodecInfo mediaCodecInfo) {
        String name = mediaCodecInfo.getName();
        return (name.startsWith("OMX.qcom.") && Build.VERSION.SDK_INT >= 19) || (name.startsWith("OMX.Exynos.") && Build.VERSION.SDK_INT >= 23) || (name.startsWith("OMX.Intel.") && Build.VERSION.SDK_INT >= 21);
    }

    public static boolean isHardwareSupportedInCurrentSdkVp9(MediaCodecInfo mediaCodecInfo) {
        String name = mediaCodecInfo.getName();
        return (name.startsWith("OMX.qcom.") || name.startsWith("OMX.Exynos.")) && Build.VERSION.SDK_INT >= 24;
    }

    public static boolean isHardwareTextureSupportedInCurrentSdk(MediaCodecInfo mediaCodecInfo, VideoCodecType videoCodecType) {
        int i = AnonymousClass2.$SwitchMap$io$agora$base$internal$video$VideoCodecType[videoCodecType.ordinal()];
        if (i == 1) {
            return isHardwareSupportedInCurrentSdkVp8(mediaCodecInfo);
        }
        if (i == 2) {
            return isHardwareSupportedInCurrentSdkVp9(mediaCodecInfo);
        }
        if (i == 3) {
            if (H264_HW_EXCEPTION_MODELS.contains(Build.MODEL)) {
                return false;
            }
            return mediaCodecInfo.getName().startsWith(MediaCodecUtils.HISI_K3_PREFIX) ? Build.VERSION.SDK_INT > 19 : Build.VERSION.SDK_INT >= 19;
        }
        if (i == 4) {
            return isHardwareSupportedInCurrentSdkH265();
        }
        if (i != 5) {
            return false;
        }
        Logging.e(TAG, "UNKNOWN is not excepted!!!");
        return false;
    }

    @CalledByNative
    public static boolean isSupportHwEncoderByType(String str) {
        return VideoCodecType.contains(str) && !(findCodecForType(VideoCodecType.valueOf(str), false) == null && findCodecForType(VideoCodecType.valueOf(str), true) == null);
    }

    public static boolean isSupportedCodec(MediaCodecInfo mediaCodecInfo, VideoCodecType videoCodecType, boolean z) {
        if (!MediaCodecUtils.codecSupportsType(mediaCodecInfo, videoCodecType)) {
            Logging.w(TAG, "not support codec type:" + videoCodecType);
            return false;
        }
        try {
            if (MediaCodecUtils.selectColorFormat(MediaCodecUtils.encoderColorFormats(mediaCodecInfo.getName()), mediaCodecInfo.getCapabilitiesForType(videoCodecType.mimeType())) == null) {
                Logging.e(TAG, "no match color format");
                return false;
            }
            if (MediaCodecUtils.checkInvalidEncoder(mediaCodecInfo.getName())) {
                return false;
            }
            return z ? isHardwareTextureSupportedInCurrentSdk(mediaCodecInfo, videoCodecType) : isHardwareSupportedInCurrentSdk(mediaCodecInfo, videoCodecType);
        } catch (Exception unused) {
            Logging.w(TAG, "fail to selectColorFormat, not support mimeType:" + videoCodecType.mimeType());
            return false;
        }
    }
}
