package io.agora.mediaplayer;

import io.agora.base.internal.CalledByNative;
import io.agora.mediaplayer.Constants;
import io.agora.mediaplayer.data.PlayerUpdatedInfo;
import io.agora.mediaplayer.data.SrcInfo;

/* loaded from: classes4.dex */
public interface IMediaPlayerObserver {
    @CalledByNative
    void onAgoraCDNTokenWillExpire();

    @CalledByNative
    void onAudioVolumeIndication(int i);

    @CalledByNative
    void onMetaData(Constants.MediaPlayerMetadataType mediaPlayerMetadataType, byte[] bArr);

    @CalledByNative
    void onPlayBufferUpdated(long j);

    @CalledByNative
    void onPlayerEvent(Constants.MediaPlayerEvent mediaPlayerEvent, long j, String str);

    @CalledByNative
    void onPlayerInfoUpdated(PlayerUpdatedInfo playerUpdatedInfo);

    @CalledByNative
    void onPlayerSrcInfoChanged(SrcInfo srcInfo, SrcInfo srcInfo2);

    @CalledByNative
    void onPlayerStateChanged(Constants.MediaPlayerState mediaPlayerState, Constants.MediaPlayerError mediaPlayerError);

    @CalledByNative
    void onPositionChanged(long j);

    @CalledByNative
    void onPreloadEvent(String str, Constants.MediaPlayerPreloadEvent mediaPlayerPreloadEvent);
}
