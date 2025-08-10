package io.agora.base.internal.video;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import androidx.annotation.Nullable;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import io.agora.base.internal.CalledByNative;
import io.agora.base.internal.Logging;
import io.agora.base.internal.ThreadUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes4.dex */
public class VideoDecoderUtils {
    public static final int FINDCODEC_TIMEOUT = 3000;
    private static final String TAG = "HardwareVideoDecoderUtils";
    private static final List<String> H264_HWDEC_EXCEPTION_MODELS = Arrays.asList("ASUS_T00J");
    private static final HashMap<VideoCodecType, MediaCodecInfo> codecByTypeCache = new HashMap<>();

    /* renamed from: io.agora.base.internal.video.VideoDecoderUtils$2, reason: invalid class name */
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
        }
    }

    @Nullable
    public static MediaCodecInfo findCodecForType(final VideoCodecType videoCodecType) {
        if (Build.VERSION.SDK_INT < 19) {
            return null;
        }
        HashMap<VideoCodecType, MediaCodecInfo> map = codecByTypeCache;
        if (map.containsKey(videoCodecType)) {
            return map.get(videoCodecType);
        }
        final MediaCodecInfo[] mediaCodecInfoArr = new MediaCodecInfo[1];
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() { // from class: io.agora.base.internal.video.VideoDecoderUtils.1
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
                        Logging.e(VideoDecoderUtils.TAG, "Cannot retrieve encoder codec info", e);
                    }
                    if (codecInfoAt != null && !codecInfoAt.isEncoder() && VideoDecoderUtils.isSupportedCodec(codecInfoAt, videoCodecType)) {
                        Logging.d(VideoDecoderUtils.TAG, "found available decodec: " + codecInfoAt.getName());
                        mediaCodecInfoArr[0] = codecInfoAt;
                        break;
                    }
                    i++;
                }
                VideoDecoderUtils.codecByTypeCache.put(videoCodecType, mediaCodecInfoArr[0]);
                countDownLatch.countDown();
            }
        }).start();
        if (!ThreadUtils.awaitUninterruptibly(countDownLatch, 3000L)) {
            Logging.e(TAG, "findCodecForType timeout");
        }
        return mediaCodecInfoArr[0];
    }

    public static boolean isHardwareSupported(MediaCodecInfo mediaCodecInfo, VideoCodecType videoCodecType) {
        String name = mediaCodecInfo.getName();
        int i = AnonymousClass2.$SwitchMap$io$agora$base$internal$video$VideoCodecType[videoCodecType.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i == 4 && Build.VERSION.SDK_INT >= 21 : !H264_HWDEC_EXCEPTION_MODELS.contains(Build.MODEL) : name.startsWith("OMX.qcom.") || name.startsWith("OMX.Exynos.") : name.startsWith("OMX.qcom.") || name.startsWith("OMX.Intel.") || name.startsWith("OMX.Exynos.") || name.startsWith("OMX.Nvidia.");
    }

    @CalledByNative
    public static boolean isSupportHwDecoderByType(String str) {
        return VideoCodecType.contains(str) && findCodecForType(VideoCodecType.valueOf(str)) != null;
    }

    @CalledByNative
    public static boolean isSupportHwDecoderByTypeAndProfile(String str, String str2) {
        MediaCodecInfo mediaCodecInfoFindCodecForType;
        Logging.w(TAG, "isSupportHwDecoderByTypeAndProfile " + str + SignatureImpl.INNER_SEP + str2);
        if (!VideoCodecType.contains(str) || (mediaCodecInfoFindCodecForType = findCodecForType(VideoCodecType.valueOf(str))) == null) {
            return false;
        }
        try {
            if (VideoCodecProfile.contains(str2)) {
                return isSupportedProfile(mediaCodecInfoFindCodecForType.getCapabilitiesForType(VideoCodecType.valueOf(str).mimeType()), VideoCodecProfile.valueOf(str2));
            }
            return false;
        } catch (IllegalArgumentException e) {
            ThrowableExtension.printStackTrace(e);
            return false;
        }
    }

    public static boolean isSupportedCodec(MediaCodecInfo mediaCodecInfo, VideoCodecType videoCodecType) {
        if (!MediaCodecUtils.codecSupportsType(mediaCodecInfo, videoCodecType)) {
            return false;
        }
        try {
            if (MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, mediaCodecInfo.getCapabilitiesForType(videoCodecType.mimeType())) != null) {
                return isHardwareSupported(mediaCodecInfo, videoCodecType);
            }
            Logging.w(TAG, "selectColorFormat is null");
            return false;
        } catch (IllegalArgumentException e) {
            ThrowableExtension.printStackTrace(e);
            return false;
        }
    }

    public static boolean isSupportedProfile(MediaCodecInfo.CodecCapabilities codecCapabilities, VideoCodecProfile videoCodecProfile) {
        if (codecCapabilities != null) {
            for (int i = 0; i < codecCapabilities.profileLevels.length; i++) {
                Logging.d(TAG, "device decoder profile:" + codecCapabilities.profileLevels[i].profile);
                if (codecCapabilities.profileLevels[i].profile == videoCodecProfile.profile()) {
                    Logging.d(TAG, "match decoder profile:" + codecCapabilities.profileLevels[i].profile);
                    return true;
                }
            }
        }
        return false;
    }
}
