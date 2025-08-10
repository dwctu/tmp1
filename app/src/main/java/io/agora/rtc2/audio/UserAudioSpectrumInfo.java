package io.agora.rtc2.audio;

import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public class UserAudioSpectrumInfo {
    private AudioSpectrumInfo audioSpectrumInfo;
    private int uid;

    @CalledByNative
    public UserAudioSpectrumInfo(int i, AudioSpectrumInfo audioSpectrumInfo) {
        this.uid = i;
        this.audioSpectrumInfo = audioSpectrumInfo;
    }

    public AudioSpectrumInfo getAudioSpectrumInfo() {
        return this.audioSpectrumInfo;
    }

    public int getUid() {
        return this.uid;
    }
}
