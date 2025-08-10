package io.agora.musiccontentcenter;

import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public class MusicContentCenterConfiguration {
    public String appId;
    public IMusicContentCenterEventHandler eventHandler;
    public int maxCacheSize;
    public long mccUid;
    public String token;

    public MusicContentCenterConfiguration() {
        this.appId = null;
        this.token = null;
        this.mccUid = 0L;
        this.maxCacheSize = 10;
        this.eventHandler = null;
    }

    public MusicContentCenterConfiguration(String str, String str2, long j, int i, IMusicContentCenterEventHandler iMusicContentCenterEventHandler) {
        this.appId = str;
        this.token = str2;
        this.mccUid = j;
        this.maxCacheSize = i;
        this.eventHandler = iMusicContentCenterEventHandler;
    }

    @CalledByNative
    public String getAppId() {
        return this.appId;
    }

    @CalledByNative
    public IMusicContentCenterEventHandler getEventHandler() {
        return this.eventHandler;
    }

    @CalledByNative
    public int getMaxCacheSize() {
        return this.maxCacheSize;
    }

    @CalledByNative
    public long getMccUid() {
        return this.mccUid;
    }

    @CalledByNative
    public String getToken() {
        return this.token;
    }
}
