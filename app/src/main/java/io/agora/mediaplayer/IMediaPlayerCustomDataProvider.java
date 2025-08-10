package io.agora.mediaplayer;

import io.agora.base.internal.CalledByNative;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public interface IMediaPlayerCustomDataProvider {
    @CalledByNative
    int onReadData(ByteBuffer byteBuffer, int i);

    @CalledByNative
    long onSeek(long j, int i);
}
