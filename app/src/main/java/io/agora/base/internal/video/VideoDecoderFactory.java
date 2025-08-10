package io.agora.base.internal.video;

import androidx.annotation.Nullable;
import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public interface VideoDecoderFactory {
    @Nullable
    VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo);

    @Nullable
    @CalledByNative
    VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo, boolean z);

    @Nullable
    @Deprecated
    VideoDecoder createDecoder(String str);

    @CalledByNative
    VideoCodecInfo[] getSupportedCodecs();
}
