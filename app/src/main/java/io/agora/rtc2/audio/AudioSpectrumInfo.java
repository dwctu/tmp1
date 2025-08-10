package io.agora.rtc2.audio;

import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public class AudioSpectrumInfo {
    private float[] audioSpectrumData;
    private int dataLength;

    @CalledByNative
    public AudioSpectrumInfo(float[] fArr, int i) {
        this.audioSpectrumData = fArr;
        this.dataLength = i;
    }

    public float[] getAudioSpectrumData() {
        return this.audioSpectrumData;
    }

    public int getDataLength() {
        return this.dataLength;
    }
}
