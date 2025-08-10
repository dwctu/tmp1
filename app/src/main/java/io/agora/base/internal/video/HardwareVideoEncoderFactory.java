package io.agora.base.internal.video;

import android.media.MediaCodecInfo;
import android.os.Build;
import androidx.annotation.Nullable;
import io.agora.base.internal.Logging;
import io.agora.base.internal.video.EglBase;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class HardwareVideoEncoderFactory implements VideoEncoderFactory {
    private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_L_MS = 15000;
    private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_M_MS = 20000;
    private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_N_MS = 15000;
    private static final String TAG = "HardwareVideoEncoderFactory";
    private final boolean enableH264HighProfile;
    private final boolean enableIntelVp8Encoder;

    @Nullable
    private final EglBase.Context sharedContext;

    /* renamed from: io.agora.base.internal.video.HardwareVideoEncoderFactory$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
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

    public HardwareVideoEncoderFactory(EglBase.Context context, boolean z, boolean z2) {
        this.sharedContext = context;
        this.enableIntelVp8Encoder = z;
        this.enableH264HighProfile = z2;
    }

    private BitrateAdjuster createBitrateAdjuster(VideoCodecType videoCodecType, String str) {
        return str.startsWith("OMX.Exynos.") ? videoCodecType == VideoCodecType.VP8 ? new DynamicBitrateAdjuster() : (videoCodecType == VideoCodecType.H264 || videoCodecType == VideoCodecType.H265) ? new FactorBitrateAdjuster(FactorBitrateAdjuster.FACTOR_LEVEL1) : new FramerateBitrateAdjuster() : ((videoCodecType == VideoCodecType.H264 || videoCodecType == VideoCodecType.H265) && (str.startsWith("OMX.qcom.") || str.startsWith(MediaCodecUtils.MTK_PREFIX) || str.startsWith(MediaCodecUtils.HISI_PREFIX))) ? new FactorBitrateAdjuster(FactorBitrateAdjuster.FACTOR_LEVEL1) : new BaseBitrateAdjuster();
    }

    private int getForcedKeyFrameIntervalMs(VideoCodecType videoCodecType, String str) {
        if (videoCodecType != VideoCodecType.VP8 || !str.startsWith("OMX.qcom.")) {
            return 0;
        }
        int i = Build.VERSION.SDK_INT;
        if (i != 21 && i != 22) {
            if (i == 23) {
                return 20000;
            }
            if (i <= 23) {
                return 0;
            }
        }
        return 15000;
    }

    private int getKeyFrameIntervalSec(VideoCodecType videoCodecType) {
        int i = AnonymousClass1.$SwitchMap$io$agora$base$internal$video$VideoCodecType[videoCodecType.ordinal()];
        if (i == 1 || i == 2) {
            return 100;
        }
        if (i == 3 || i == 4) {
            return 20;
        }
        if (i == 5) {
            Logging.e(TAG, "UNKNOWN is not excepted but h264");
            return 20;
        }
        throw new IllegalArgumentException("Unsupported VideoCodecType " + videoCodecType);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean isH264HighProfileSupported(android.media.MediaCodecInfo r7) {
        /*
            r6 = this;
            java.lang.String r0 = r7.getName()
            java.lang.String r1 = "OMX.qcom."
            boolean r0 = r0.startsWith(r1)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L3c
            java.lang.String r0 = r7.getName()
            java.lang.String r3 = "OMX.hisi."
            boolean r0 = r0.startsWith(r3)
            if (r0 != 0) goto L3c
            java.lang.String r0 = r7.getName()
            java.lang.String r3 = "OMX.Exynos."
            boolean r0 = r0.startsWith(r3)
            if (r0 != 0) goto L3c
            java.lang.String r0 = r7.getName()
            java.lang.String r3 = "OMX.MTK."
            boolean r0 = r0.startsWith(r3)
            if (r0 == 0) goto L33
            goto L3c
        L33:
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r0 < r3) goto L44
            r0 = 0
            r3 = 1
            goto L46
        L3c:
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 21
            if (r0 < r3) goto L44
            r0 = 1
            goto L45
        L44:
            r0 = 0
        L45:
            r3 = 0
        L46:
            boolean r4 = r6.enableH264HighProfile
            if (r4 == 0) goto L77
            if (r0 != 0) goto L4e
            if (r3 == 0) goto L77
        L4e:
            r0 = 0
            io.agora.base.internal.video.VideoCodecType r3 = io.agora.base.internal.video.VideoCodecType.H264     // Catch: java.lang.IllegalArgumentException -> L5a
            java.lang.String r3 = r3.mimeType()     // Catch: java.lang.IllegalArgumentException -> L5a
            android.media.MediaCodecInfo$CodecCapabilities r0 = r7.getCapabilitiesForType(r3)     // Catch: java.lang.IllegalArgumentException -> L5a
            goto L62
        L5a:
            r7 = move-exception
            java.lang.String r3 = "HardwareVideoEncoderFactory"
            java.lang.String r4 = "getCapabilitiesForType:"
            io.agora.base.internal.Logging.e(r3, r4, r7)
        L62:
            if (r0 != 0) goto L65
            return r2
        L65:
            android.media.MediaCodecInfo$CodecProfileLevel[] r7 = r0.profileLevels
            int r0 = r7.length
            r3 = 0
        L69:
            if (r3 >= r0) goto L77
            r4 = r7[r3]
            int r4 = r4.profile
            r5 = 8
            if (r4 != r5) goto L74
            return r1
        L74:
            int r3 = r3 + 1
            goto L69
        L77:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.base.internal.video.HardwareVideoEncoderFactory.isH264HighProfileSupported(android.media.MediaCodecInfo):boolean");
    }

    @Override // io.agora.base.internal.video.VideoEncoderFactory
    @Nullable
    public VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo, boolean z, boolean z2) {
        return createEncoder(videoCodecInfo, z);
    }

    @Override // io.agora.base.internal.video.VideoEncoderFactory
    public VideoCodecInfo[] getSupportedCodecs(boolean z) {
        ArrayList arrayList = new ArrayList();
        VideoCodecType[] videoCodecTypeArr = {VideoCodecType.VP8, VideoCodecType.VP9, VideoCodecType.H264, VideoCodecType.H265};
        for (int i = 0; i < 4; i++) {
            VideoCodecType videoCodecType = videoCodecTypeArr[i];
            MediaCodecInfo mediaCodecInfoFindCodecForType = VideoEncoderUtils.findCodecForType(videoCodecType, z);
            if (mediaCodecInfoFindCodecForType != null) {
                String strName = videoCodecType.name();
                if (videoCodecType == VideoCodecType.H264 && isH264HighProfileSupported(mediaCodecInfoFindCodecForType)) {
                    arrayList.add(new VideoCodecInfo(strName, MediaCodecUtils.getCodecProperties(videoCodecType, true)));
                }
                arrayList.add(new VideoCodecInfo(strName, MediaCodecUtils.getCodecProperties(videoCodecType, false)));
            }
        }
        return (VideoCodecInfo[]) arrayList.toArray(new VideoCodecInfo[arrayList.size()]);
    }

    @Override // io.agora.base.internal.video.VideoEncoderFactory
    @Nullable
    public VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo, boolean z) {
        VideoCodecType videoCodecTypeValueOf;
        MediaCodecInfo mediaCodecInfoFindCodecForType;
        Integer num;
        Integer numSelectColorFormat;
        if (!VideoCodecType.contains(videoCodecInfo.name) || (mediaCodecInfoFindCodecForType = VideoEncoderUtils.findCodecForType((videoCodecTypeValueOf = VideoCodecType.valueOf(videoCodecInfo.name)), z)) == null) {
            return null;
        }
        String name = mediaCodecInfoFindCodecForType.getName();
        String strMimeType = videoCodecTypeValueOf.mimeType();
        int iSelectColorFormat = 0;
        try {
            iSelectColorFormat = MediaCodecUtils.selectColorFormat(MediaCodecUtils.TEXTURE_COLOR_FORMATS, mediaCodecInfoFindCodecForType.getCapabilitiesForType(strMimeType));
            numSelectColorFormat = MediaCodecUtils.selectColorFormat(MediaCodecUtils.encoderColorFormats(mediaCodecInfoFindCodecForType.getName()), mediaCodecInfoFindCodecForType.getCapabilitiesForType(strMimeType));
            num = iSelectColorFormat;
        } catch (IllegalArgumentException e) {
            Logging.e(TAG, "getCapabilitiesForType:", e);
            num = iSelectColorFormat;
            numSelectColorFormat = 0;
        }
        if (videoCodecTypeValueOf == VideoCodecType.H264) {
            H264Utils.isSameH264Profile(videoCodecInfo.params, MediaCodecUtils.getCodecProperties(videoCodecTypeValueOf, true));
            H264Utils.isSameH264Profile(videoCodecInfo.params, MediaCodecUtils.getCodecProperties(videoCodecTypeValueOf, false));
            videoCodecInfo.params.put(VideoCodecInfo.H264_IS_HIGH_PROFILE_SUPPORTED, String.valueOf(isH264HighProfileSupported(mediaCodecInfoFindCodecForType)));
        }
        return new HardwareVideoEncoder(new MediaCodecWrapperFactoryImpl(), name, videoCodecTypeValueOf, num, numSelectColorFormat, videoCodecInfo.params, getKeyFrameIntervalSec(videoCodecTypeValueOf), getForcedKeyFrameIntervalMs(videoCodecTypeValueOf, name), createBitrateAdjuster(videoCodecTypeValueOf, name), this.sharedContext);
    }

    @Deprecated
    public HardwareVideoEncoderFactory(boolean z, boolean z2) {
        this(null, z, z2);
    }
}
