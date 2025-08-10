package io.agora.musiccontentcenter;

import io.agora.musiccontentcenter.internal.MusicContentCenterImpl;
import io.agora.rtc2.RtcEngine;

/* loaded from: classes4.dex */
public abstract class IAgoraMusicContentCenter {
    private static IAgoraMusicContentCenter mInstance;

    public class MusicCacheStatusType {
        public static final int MUSIC_CACHE_STATUS_TYPE_CACHED = 0;
        public static final int MUSIC_CACHE_STATUS_TYPE_CACHING = 1;

        private MusicCacheStatusType() {
        }
    }

    public class MusicContentCenterStatusCode {
        public static final int MUSIC_CONTENT_CENTER_STATUS_ERR = 1;
        public static final int MUSIC_CONTENT_CENTER_STATUS_ERR_GATEWAY = 2;
        public static final int MUSIC_CONTENT_CENTER_STATUS_ERR_INTERNAL_DATA_PARSE = 4;
        public static final int MUSIC_CONTENT_CENTER_STATUS_ERR_MUSIC_DECRYPTION = 6;
        public static final int MUSIC_CONTENT_CENTER_STATUS_ERR_MUSIC_LOADING = 5;
        public static final int MUSIC_CONTENT_CENTER_STATUS_ERR_PERMISSION_AND_RESOURCE = 3;
        public static final int MUSIC_CONTENT_CENTER_STATUS_OK = 0;

        private MusicContentCenterStatusCode() {
        }
    }

    public class PreloadStatusCode {
        public static final int PRELOAD_STATUS_COMPLETED = 0;
        public static final int PRELOAD_STATUS_FAILED = 1;
        public static final int PRELOAD_STATUS_PRELOADING = 2;
        public static final int PRELOAD_STATUS_REMOVED = 3;

        private PreloadStatusCode() {
        }
    }

    public static synchronized IAgoraMusicContentCenter create(RtcEngine rtcEngine) {
        if (mInstance == null) {
            mInstance = new MusicContentCenterImpl(rtcEngine);
        }
        return mInstance;
    }

    public static synchronized void destroy() {
        IAgoraMusicContentCenter iAgoraMusicContentCenter = mInstance;
        if (iAgoraMusicContentCenter == null) {
            return;
        }
        iAgoraMusicContentCenter.release();
        mInstance = null;
    }

    public abstract IAgoraMusicPlayer createMusicPlayer();

    public abstract MusicCacheInfo[] getCaches();

    public abstract String getLyric(long j, int i);

    public abstract String getMusicCharts();

    public String getMusicCollectionByMusicChartId(int i, int i2, int i3) {
        return getMusicCollectionByMusicChartId(i, i2, i3, null);
    }

    public abstract String getMusicCollectionByMusicChartId(int i, int i2, int i3, String str);

    public abstract int initialize(MusicContentCenterConfiguration musicContentCenterConfiguration);

    public abstract int isPreloaded(long j);

    public abstract int preload(long j, String str);

    public abstract int registerEventHandler(IMusicContentCenterEventHandler iMusicContentCenterEventHandler);

    public abstract void release();

    public abstract int removeCache(long j);

    public abstract int renewToken(String str);

    public String searchMusic(String str, int i, int i2) {
        return searchMusic(str, i, i2, null);
    }

    public abstract String searchMusic(String str, int i, int i2, String str2);

    public abstract int unregisterEventHandler();
}
