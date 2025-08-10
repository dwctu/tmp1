package io.agora.base.internal.video;

import androidx.annotation.Nullable;
import io.agora.base.internal.Logging;
import io.agora.base.internal.video.EglBase;
import java.util.Arrays;
import java.util.LinkedHashSet;

/* loaded from: classes4.dex */
public class DefaultVideoDecoderFactory implements VideoDecoderFactory {
    private static final String TAG = "DefaultVideoDecoderFactory";
    private final VideoDecoderFactory hardwareVideoDecoderFactory;
    private final VideoDecoderFactory softwareVideoDecoderFactory = new SoftwareVideoDecoderFactory();

    public DefaultVideoDecoderFactory(EglBase.Context context) {
        this.hardwareVideoDecoderFactory = new HardwareVideoDecoderFactory(context);
    }

    @Override // io.agora.base.internal.video.VideoDecoderFactory
    @Nullable
    public VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo) {
        VideoDecoder videoDecoderCreateDecoder = this.softwareVideoDecoderFactory.createDecoder(videoCodecInfo);
        VideoDecoder videoDecoderCreateDecoder2 = this.hardwareVideoDecoderFactory.createDecoder(videoCodecInfo);
        if (videoDecoderCreateDecoder2 != null && videoDecoderCreateDecoder != null) {
            return new VideoDecoderFallback(videoDecoderCreateDecoder, videoDecoderCreateDecoder2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("using decoder:");
        sb.append(videoDecoderCreateDecoder2 != null ? "hardware" : "software");
        Logging.d(TAG, sb.toString());
        return videoDecoderCreateDecoder2 != null ? videoDecoderCreateDecoder2 : videoDecoderCreateDecoder;
    }

    @Override // io.agora.base.internal.video.VideoDecoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(Arrays.asList(this.softwareVideoDecoderFactory.getSupportedCodecs()));
        linkedHashSet.addAll(Arrays.asList(this.hardwareVideoDecoderFactory.getSupportedCodecs()));
        return (VideoCodecInfo[]) linkedHashSet.toArray(new VideoCodecInfo[linkedHashSet.size()]);
    }

    public DefaultVideoDecoderFactory(VideoDecoderFactory videoDecoderFactory) {
        this.hardwareVideoDecoderFactory = videoDecoderFactory;
    }

    @Override // io.agora.base.internal.video.VideoDecoderFactory
    @Nullable
    public VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo, boolean z) {
        if (!z) {
            return this.softwareVideoDecoderFactory.createDecoder(videoCodecInfo);
        }
        return createDecoder(videoCodecInfo);
    }

    @Override // io.agora.base.internal.video.VideoDecoderFactory
    @Nullable
    public VideoDecoder createDecoder(String str) {
        throw new UnsupportedOperationException("Deprecated and not implemented.");
    }
}
