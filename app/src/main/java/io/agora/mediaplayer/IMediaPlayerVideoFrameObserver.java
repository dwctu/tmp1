package io.agora.mediaplayer;

import io.agora.base.VideoFrame;
import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public interface IMediaPlayerVideoFrameObserver {
    @CalledByNative
    void onFrame(VideoFrame videoFrame);
}
