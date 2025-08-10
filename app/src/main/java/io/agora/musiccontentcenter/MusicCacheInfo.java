package io.agora.musiccontentcenter;

import io.agora.base.internal.CalledByNative;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes4.dex */
public class MusicCacheInfo {
    public long songCode;
    public int status;

    public MusicCacheInfo() {
    }

    @CalledByNative
    public MusicCacheInfo(long j, int i) {
        this.songCode = j;
        this.status = i;
    }

    @CalledByNative
    public long getSongCode() {
        return this.songCode;
    }

    @CalledByNative
    public int getStatus() {
        return this.status;
    }

    public String toString() {
        return "MusicCacheInfo{songCode=" + this.songCode + ", status=" + this.status + MessageFormatter.DELIM_STOP;
    }
}
