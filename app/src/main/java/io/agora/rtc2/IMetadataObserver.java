package io.agora.rtc2;

import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public interface IMetadataObserver {
    public static final int UNKNOWN_METADATA = -1;
    public static final int VIDEO_METADATA = 0;

    @CalledByNative
    int getMaxMetadataSize();

    @CalledByNative
    void onMetadataReceived(byte[] bArr, int i, long j);

    @CalledByNative
    byte[] onReadyToSendMetadata(long j, int i);
}
