package io.agora.rtc2.audio;

import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public class AgoraRhythmPlayerConfig {
    public int beatsPerMeasure = 4;
    public int beatsPerMinute = 60;

    @CalledByNative
    public int getBeatsPerMeasure() {
        return this.beatsPerMeasure;
    }

    @CalledByNative
    public int getBeatsPerMinute() {
        return this.beatsPerMinute;
    }
}
