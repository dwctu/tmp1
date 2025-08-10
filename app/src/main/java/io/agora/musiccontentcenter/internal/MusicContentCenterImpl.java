package io.agora.musiccontentcenter.internal;

import io.agora.musiccontentcenter.IAgoraMusicContentCenter;
import io.agora.musiccontentcenter.IAgoraMusicPlayer;
import io.agora.musiccontentcenter.IMusicContentCenterEventHandler;
import io.agora.musiccontentcenter.MusicCacheInfo;
import io.agora.musiccontentcenter.MusicContentCenterConfiguration;
import io.agora.rtc2.RtcEngine;
import io.agora.rtc2.internal.RtcEngineImpl;

/* loaded from: classes4.dex */
public class MusicContentCenterImpl extends IAgoraMusicContentCenter {
    private long mNativeHandle;
    private final RtcEngineImpl mRtcEngine;

    public MusicContentCenterImpl(RtcEngine rtcEngine) {
        this.mNativeHandle = 0L;
        this.mNativeHandle = nativeObjectInit(rtcEngine.getNativeHandle());
        if (!(rtcEngine instanceof RtcEngineImpl)) {
            this.mRtcEngine = null;
            return;
        }
        RtcEngineImpl rtcEngineImpl = (RtcEngineImpl) rtcEngine;
        this.mRtcEngine = rtcEngineImpl;
        rtcEngineImpl.loadExtensionProvider("agora_drm_loader_extension");
    }

    private native MusicPlayerProperty nativeCreateMusicPlayer(long j);

    private static native int nativeDestroy(long j);

    private native MusicCacheInfo[] nativeGetCaches(long j);

    private native String nativeGetLyric(long j, long j2, int i);

    private native String nativeGetMusicCharts(long j);

    private native String nativeGetMusicCollectionByMusicChartId(long j, int i, int i2, int i3, String str);

    private native int nativeInitialize(long j, Object obj);

    private native int nativeIsPreloaded(long j, long j2);

    private native long nativeObjectInit(long j);

    private native int nativePreload(long j, long j2, String str);

    private native int nativeRegisterEventHandler(long j, Object obj);

    private native int nativeRemoveCache(long j, long j2);

    private native int nativeRenewToken(long j, String str);

    private native String nativeSearchMusic(long j, String str, int i, int i2, String str2);

    private native int nativeUnregisterEventHandler(long j);

    @Override // io.agora.musiccontentcenter.IAgoraMusicContentCenter
    public IAgoraMusicPlayer createMusicPlayer() {
        MusicPlayerProperty musicPlayerPropertyNativeCreateMusicPlayer = nativeCreateMusicPlayer(this.mNativeHandle);
        if (musicPlayerPropertyNativeCreateMusicPlayer.handler != 0) {
            return new AgoraMusicPlayerImpl(this.mRtcEngine, musicPlayerPropertyNativeCreateMusicPlayer.handler, musicPlayerPropertyNativeCreateMusicPlayer.id);
        }
        return null;
    }

    @Override // io.agora.musiccontentcenter.IAgoraMusicContentCenter
    public MusicCacheInfo[] getCaches() {
        return nativeGetCaches(this.mNativeHandle);
    }

    @Override // io.agora.musiccontentcenter.IAgoraMusicContentCenter
    public String getLyric(long j, int i) {
        return nativeGetLyric(this.mNativeHandle, j, i);
    }

    @Override // io.agora.musiccontentcenter.IAgoraMusicContentCenter
    public String getMusicCharts() {
        return nativeGetMusicCharts(this.mNativeHandle);
    }

    @Override // io.agora.musiccontentcenter.IAgoraMusicContentCenter
    public String getMusicCollectionByMusicChartId(int i, int i2, int i3, String str) {
        return nativeGetMusicCollectionByMusicChartId(this.mNativeHandle, i, i2, i3, str);
    }

    @Override // io.agora.musiccontentcenter.IAgoraMusicContentCenter
    public int initialize(MusicContentCenterConfiguration musicContentCenterConfiguration) {
        return nativeInitialize(this.mNativeHandle, musicContentCenterConfiguration);
    }

    @Override // io.agora.musiccontentcenter.IAgoraMusicContentCenter
    public int isPreloaded(long j) {
        return nativeIsPreloaded(this.mNativeHandle, j);
    }

    @Override // io.agora.musiccontentcenter.IAgoraMusicContentCenter
    public int preload(long j, String str) {
        return nativePreload(this.mNativeHandle, j, str);
    }

    @Override // io.agora.musiccontentcenter.IAgoraMusicContentCenter
    public int registerEventHandler(IMusicContentCenterEventHandler iMusicContentCenterEventHandler) {
        return nativeRegisterEventHandler(this.mNativeHandle, iMusicContentCenterEventHandler);
    }

    @Override // io.agora.musiccontentcenter.IAgoraMusicContentCenter
    public void release() {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeDestroy(j);
            this.mNativeHandle = 0L;
        }
    }

    @Override // io.agora.musiccontentcenter.IAgoraMusicContentCenter
    public int removeCache(long j) {
        return nativeRemoveCache(this.mNativeHandle, j);
    }

    @Override // io.agora.musiccontentcenter.IAgoraMusicContentCenter
    public int renewToken(String str) {
        return nativeRenewToken(this.mNativeHandle, str);
    }

    @Override // io.agora.musiccontentcenter.IAgoraMusicContentCenter
    public String searchMusic(String str, int i, int i2, String str2) {
        return nativeSearchMusic(this.mNativeHandle, str, i, i2, str2);
    }

    @Override // io.agora.musiccontentcenter.IAgoraMusicContentCenter
    public int unregisterEventHandler() {
        return nativeUnregisterEventHandler(this.mNativeHandle);
    }
}
