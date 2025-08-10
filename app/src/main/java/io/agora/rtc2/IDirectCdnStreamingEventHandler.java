package io.agora.rtc2;

import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public interface IDirectCdnStreamingEventHandler {
    @CalledByNative
    void onDirectCdnStreamingStateChanged(DirectCdnStreamingState directCdnStreamingState, DirectCdnStreamingError directCdnStreamingError, String str);

    @CalledByNative
    void onDirectCdnStreamingStats(DirectCdnStreamingStats directCdnStreamingStats);
}
