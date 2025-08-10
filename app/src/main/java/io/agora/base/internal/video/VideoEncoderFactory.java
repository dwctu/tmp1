package io.agora.base.internal.video;

import androidx.annotation.Nullable;
import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public interface VideoEncoderFactory {
    @Nullable
    VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo, boolean z);

    @Nullable
    @CalledByNative
    VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo, boolean z, boolean z2);

    @CalledByNative
    VideoCodecInfo[] getSupportedCodecs(boolean z);
}
