package dc;

import androidx.annotation.Nullable;
import org.webrtc.CalledByNative;
import org.webrtc.VideoCodecInfo;
import org.webrtc.VideoDecoder;
import org.webrtc.VideoDecoderFactory;

/* compiled from: VideoDecoderFactory.java */
/* loaded from: classes5.dex */
public final /* synthetic */ class pg4 {
    @Nullable
    @Deprecated
    public static VideoDecoder $default$createDecoder(VideoDecoderFactory _this, String str) {
        throw new UnsupportedOperationException("Deprecated and not implemented.");
    }

    @CalledByNative
    public static VideoCodecInfo[] $default$getSupportedCodecs(VideoDecoderFactory videoDecoderFactory) {
        return new VideoCodecInfo[0];
    }
}
