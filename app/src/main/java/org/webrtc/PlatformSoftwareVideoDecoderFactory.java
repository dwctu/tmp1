package org.webrtc;

import android.media.MediaCodecInfo;
import androidx.annotation.Nullable;
import dc.ng4;
import java.util.Arrays;
import org.webrtc.EglBase;

/* loaded from: classes5.dex */
public class PlatformSoftwareVideoDecoderFactory extends MediaCodecVideoDecoderFactory {
    private static final Predicate<MediaCodecInfo> defaultAllowedPredicate = new Predicate<MediaCodecInfo>() { // from class: org.webrtc.PlatformSoftwareVideoDecoderFactory.1
        private String[] prefixWhitelist;

        {
            String[] strArr = MediaCodecUtils.SOFTWARE_IMPLEMENTATION_PREFIXES;
            this.prefixWhitelist = (String[]) Arrays.copyOf(strArr, strArr.length);
        }

        @Override // org.webrtc.Predicate
        public /* synthetic */ Predicate<MediaCodecInfo> and(Predicate<? super MediaCodecInfo> predicate) {
            return ng4.$default$and(this, predicate);
        }

        @Override // org.webrtc.Predicate
        public /* synthetic */ Predicate<MediaCodecInfo> negate() {
            return ng4.$default$negate(this);
        }

        @Override // org.webrtc.Predicate
        public /* synthetic */ Predicate<MediaCodecInfo> or(Predicate<? super MediaCodecInfo> predicate) {
            return ng4.$default$or(this, predicate);
        }

        @Override // org.webrtc.Predicate
        public boolean test(MediaCodecInfo mediaCodecInfo) {
            String name = mediaCodecInfo.getName();
            for (String str : this.prefixWhitelist) {
                if (name.startsWith(str)) {
                    return true;
                }
            }
            return false;
        }
    };

    public PlatformSoftwareVideoDecoderFactory(@Nullable EglBase.Context context) {
        super(context, defaultAllowedPredicate);
    }

    @Override // org.webrtc.MediaCodecVideoDecoderFactory, org.webrtc.VideoDecoderFactory
    @Nullable
    public /* bridge */ /* synthetic */ VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo) {
        return super.createDecoder(videoCodecInfo);
    }

    @Override // org.webrtc.MediaCodecVideoDecoderFactory, org.webrtc.VideoDecoderFactory
    public /* bridge */ /* synthetic */ VideoCodecInfo[] getSupportedCodecs() {
        return super.getSupportedCodecs();
    }
}
