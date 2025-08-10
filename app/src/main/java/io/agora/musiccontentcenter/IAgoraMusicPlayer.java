package io.agora.musiccontentcenter;

import io.agora.mediaplayer.IMediaPlayer;

/* loaded from: classes4.dex */
public interface IAgoraMusicPlayer extends IMediaPlayer {
    @Override // io.agora.mediaplayer.IMediaPlayer
    int destroy();

    @Override // io.agora.mediaplayer.IMediaPlayer
    String getPlaySrc();

    int open(long j, long j2);

    @Override // io.agora.mediaplayer.IMediaPlayer
    int open(String str, long j);

    @Override // io.agora.mediaplayer.IMediaPlayer
    int stop();
}
