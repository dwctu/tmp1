package io.agora.musiccontentcenter.internal;

import io.agora.musiccontentcenter.IAgoraMusicPlayer;
import io.agora.rtc2.internal.MediaPlayerImpl;
import io.agora.rtc2.internal.RtcEngineImpl;

/* loaded from: classes4.dex */
public class AgoraMusicPlayerImpl extends MediaPlayerImpl implements IAgoraMusicPlayer {
    private long mNativeHandle;

    public AgoraMusicPlayerImpl(RtcEngineImpl rtcEngineImpl, long j, int i) {
        super(rtcEngineImpl, i);
        this.mNativeHandle = 0L;
        this.mNativeHandle = j;
    }

    private static native int nativeDestroy(long j);

    private static native String nativeGetPlaySrc(long j);

    private native int nativeOpen(long j, long j2, long j3);

    private native int nativeOpenWithUrl(long j, String str, long j2);

    private static native int nativeStop(long j);

    @Override // io.agora.rtc2.internal.MediaPlayerImpl, io.agora.mediaplayer.IMediaPlayer
    public int destroy() {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeDestroy(j);
        }
        return super.destroy();
    }

    @Override // io.agora.rtc2.internal.MediaPlayerImpl, io.agora.mediaplayer.IMediaPlayer
    public String getPlaySrc() {
        long j = this.mNativeHandle;
        return j != 0 ? nativeGetPlaySrc(j) : super.getPlaySrc();
    }

    @Override // io.agora.musiccontentcenter.IAgoraMusicPlayer
    public int open(long j, long j2) {
        long j3 = this.mNativeHandle;
        if (j3 == 0) {
            return -7;
        }
        return nativeOpen(j3, j, j2);
    }

    @Override // io.agora.rtc2.internal.MediaPlayerImpl, io.agora.mediaplayer.IMediaPlayer
    public int open(String str, long j) {
        long j2 = this.mNativeHandle;
        if (j2 == 0) {
            return -7;
        }
        return nativeOpenWithUrl(j2, str, j);
    }

    @Override // io.agora.rtc2.internal.MediaPlayerImpl, io.agora.mediaplayer.IMediaPlayer
    public int stop() {
        long j = this.mNativeHandle;
        return j != 0 ? nativeStop(j) : super.stop();
    }
}
