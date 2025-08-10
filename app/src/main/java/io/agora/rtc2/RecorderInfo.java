package io.agora.rtc2;

import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public class RecorderInfo {
    public int durationMs;
    public String fileName;
    public int fileSize;

    @CalledByNative
    public RecorderInfo(String str, int i, int i2) {
        this.fileName = str;
        this.durationMs = i;
        this.fileSize = i2;
    }
}
