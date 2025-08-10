package org.webrtc;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import androidx.annotation.Nullable;
import dc.pg4;
import java.util.ArrayList;
import org.webrtc.EglBase;

/* loaded from: classes5.dex */
public class MediaCodecVideoDecoderFactory implements VideoDecoderFactory {
    private static final String TAG = "MediaCodecVideoDecoderFactory";

    @Nullable
    private final Predicate<MediaCodecInfo> codecAllowedPredicate;

    @Nullable
    private final EglBase.Context sharedContext;

    public MediaCodecVideoDecoderFactory(@Nullable EglBase.Context context, @Nullable Predicate<MediaCodecInfo> predicate) {
        this.sharedContext = context;
        this.codecAllowedPredicate = predicate;
    }

    @Nullable
    private MediaCodecInfo findCodecForType(VideoCodecType videoCodecType) {
        MediaCodecInfo codecInfoAt;
        if (Build.VERSION.SDK_INT < 19) {
            return null;
        }
        for (int i = 0; i < MediaCodecList.getCodecCount(); i++) {
            try {
                codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            } catch (IllegalArgumentException e) {
                Logging.e(TAG, "Cannot retrieve decoder codec info", e);
                codecInfoAt = null;
            }
            if (codecInfoAt != null && !codecInfoAt.isEncoder() && isSupportedCodec(codecInfoAt, videoCodecType)) {
                return codecInfoAt;
            }
        }
        return null;
    }

    private boolean isCodecAllowed(MediaCodecInfo mediaCodecInfo) {
        Predicate<MediaCodecInfo> predicate = this.codecAllowedPredicate;
        if (predicate == null) {
            return true;
        }
        return predicate.test(mediaCodecInfo);
    }

    private boolean isH264HighProfileSupported(MediaCodecInfo mediaCodecInfo) {
        String name = mediaCodecInfo.getName();
        int i = Build.VERSION.SDK_INT;
        if (i < 21 || !name.startsWith("OMX.qcom.")) {
            return i >= 23 && name.startsWith("OMX.Exynos.");
        }
        return true;
    }

    private boolean isSupportedCodec(MediaCodecInfo mediaCodecInfo, VideoCodecType videoCodecType) {
        mediaCodecInfo.getName();
        if (MediaCodecUtils.codecSupportsType(mediaCodecInfo, videoCodecType) && MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, mediaCodecInfo.getCapabilitiesForType(videoCodecType.mimeType())) != null) {
            return isCodecAllowed(mediaCodecInfo);
        }
        return false;
    }

    @Override // org.webrtc.VideoDecoderFactory
    public /* synthetic */ VideoDecoder createDecoder(String str) {
        return pg4.$default$createDecoder(this, str);
    }

    @Override // org.webrtc.VideoDecoderFactory
    @Nullable
    public VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo) {
        VideoCodecType videoCodecTypeValueOf = VideoCodecType.valueOf(videoCodecInfo.getName());
        MediaCodecInfo mediaCodecInfoFindCodecForType = findCodecForType(videoCodecTypeValueOf);
        if (mediaCodecInfoFindCodecForType == null) {
            return null;
        }
        return new AndroidVideoDecoder(new MediaCodecWrapperFactoryImpl(), mediaCodecInfoFindCodecForType.getName(), videoCodecTypeValueOf, MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, mediaCodecInfoFindCodecForType.getCapabilitiesForType(videoCodecTypeValueOf.mimeType())).intValue(), this.sharedContext);
    }

    @Override // org.webrtc.VideoDecoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        ArrayList arrayList = new ArrayList();
        VideoCodecType[] videoCodecTypeArr = {VideoCodecType.VP8, VideoCodecType.VP9, VideoCodecType.H264};
        for (int i = 0; i < 3; i++) {
            VideoCodecType videoCodecType = videoCodecTypeArr[i];
            MediaCodecInfo mediaCodecInfoFindCodecForType = findCodecForType(videoCodecType);
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
}
