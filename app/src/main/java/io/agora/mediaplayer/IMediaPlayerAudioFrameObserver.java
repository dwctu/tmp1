package io.agora.mediaplayer;

import io.agora.base.AudioFrame;
import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public interface IMediaPlayerAudioFrameObserver {
    @CalledByNative
    AudioFrame onFrame(AudioFrame audioFrame);
}
