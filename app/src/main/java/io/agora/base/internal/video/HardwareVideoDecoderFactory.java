package io.agora.base.internal.video;

import android.media.MediaCodecInfo;
import android.os.Build;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import io.agora.base.internal.Logging;
import io.agora.base.internal.video.EglBase;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes4.dex */
public class HardwareVideoDecoderFactory implements VideoDecoderFactory {
    private static final String TAG = "HardwareVideoDecoderFactory";

    @Nullable
    private final EglBase.Context sharedContext;

    @Nullable
    private final Surface surface;

    @Deprecated
    public HardwareVideoDecoderFactory() {
        this.sharedContext = null;
        this.surface = null;
    }

    private boolean isH264HighProfileSupported(MediaCodecInfo mediaCodecInfo) {
        String name = mediaCodecInfo.getName();
        int i = Build.VERSION.SDK_INT;
        if (i < 21 || !name.startsWith("OMX.qcom.")) {
            return i >= 23 && name.startsWith("OMX.Exynos.");
        }
        return true;
    }

    @Override // io.agora.base.internal.video.VideoDecoderFactory
    @Nullable
    public VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo) {
        VideoCodecType videoCodecTypeValueOf;
        MediaCodecInfo mediaCodecInfoFindCodecForType;
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        EglBase.Context context;
        int[] iArr;
        if (!VideoCodecType.contains(videoCodecInfo.getName()) || (mediaCodecInfoFindCodecForType = VideoDecoderUtils.findCodecForType((videoCodecTypeValueOf = VideoCodecType.valueOf(videoCodecInfo.getName())))) == null) {
            return null;
        }
        try {
            capabilitiesForType = mediaCodecInfoFindCodecForType.getCapabilitiesForType(videoCodecTypeValueOf.mimeType());
        } catch (IllegalArgumentException e) {
            ThrowableExtension.printStackTrace(e);
            capabilitiesForType = null;
        }
        if (capabilitiesForType != null && (iArr = capabilitiesForType.colorFormats) != null) {
            for (int i : iArr) {
                Logging.d(TAG, "supportedColorFormat : " + i);
            }
        }
        EglBase.Context context2 = this.sharedContext;
        Surface surface = this.surface;
        Map<String, String> map = videoCodecInfo.params;
        if (map != null && map.containsKey("av_dec_output_byte_frame")) {
            Logging.w(TAG, "force decode to byte frame");
            context2 = null;
        }
        if (surface != null) {
            Logging.w(TAG, "force direct surface");
            context = null;
        } else {
            context = context2;
        }
        return new HardwareVideoDecoder(new MediaCodecWrapperFactoryImpl(), mediaCodecInfoFindCodecForType.getName(), videoCodecTypeValueOf, videoCodecInfo.params, MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, capabilitiesForType).intValue(), context, surface);
    }

    @Override // io.agora.base.internal.video.VideoDecoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        ArrayList arrayList = new ArrayList();
        VideoCodecType[] videoCodecTypeArr = {VideoCodecType.VP8, VideoCodecType.VP9, VideoCodecType.H264, VideoCodecType.H265};
        for (int i = 0; i < 4; i++) {
            VideoCodecType videoCodecType = videoCodecTypeArr[i];
            MediaCodecInfo mediaCodecInfoFindCodecForType = VideoDecoderUtils.findCodecForType(videoCodecType);
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

    public HardwareVideoDecoderFactory(EglBase.Context context) {
        this.sharedContext = context;
        this.surface = null;
    }

    public HardwareVideoDecoderFactory(Surface surface) {
        this.surface = surface;
        this.sharedContext = null;
    }

    @Override // io.agora.base.internal.video.VideoDecoderFactory
    @Nullable
    public VideoDecoder createDecoder(String str) {
        throw new UnsupportedOperationException("Deprecated and not implemented.");
    }

    @Override // io.agora.base.internal.video.VideoDecoderFactory
    @Nullable
    public VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo, boolean z) {
        return createDecoder(videoCodecInfo);
    }
}
