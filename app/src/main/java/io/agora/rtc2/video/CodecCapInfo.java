package io.agora.rtc2.video;

import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public class CodecCapInfo {
    public int codecCapMask;
    public int codecType;

    @CalledByNative
    public CodecCapInfo(int i, int i2) {
        this.codecType = i;
        this.codecCapMask = i2;
    }

    @CalledByNative
    public void SetCodecCapMask(int i) {
        this.codecCapMask = i;
    }

    @CalledByNative
    public void SetCodecType(int i) {
        this.codecType = i;
    }
}
