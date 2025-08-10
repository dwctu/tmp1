package io.agora.base.internal.video;

import io.agora.base.VideoFrame;

/* loaded from: classes4.dex */
public interface CapturerObserver {
    void onCapturerStarted(boolean z);

    void onCapturerStopped();

    void onFrameCaptured(VideoFrame videoFrame);
}
