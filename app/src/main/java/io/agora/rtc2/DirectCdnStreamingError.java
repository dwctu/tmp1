package io.agora.rtc2;

import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public enum DirectCdnStreamingError {
    OK(0),
    FAILED(1),
    AUDIO_PUBLICATION(2),
    VIDEO_PUBLICATION(3),
    NET_CONNECT(4),
    BAD_NAME(5);

    private int value;

    DirectCdnStreamingError(int i) {
        this.value = i;
    }

    @CalledByNative
    public static DirectCdnStreamingError fromInt(int i) {
        for (DirectCdnStreamingError directCdnStreamingError : values()) {
            if (directCdnStreamingError.getValue() == i) {
                return directCdnStreamingError;
            }
        }
        return FAILED;
    }

    public int getValue() {
        return this.value;
    }
}
