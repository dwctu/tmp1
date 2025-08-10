package com.wear.bean.event;

import com.spotify.sdk.android.player.PlaybackState;
import com.spotify.sdk.android.player.PlayerEvent;

/* loaded from: classes3.dex */
public class SpotifyPlayEvent {
    public PlaybackState mPlaybackState;
    public PlayerEvent playerEvent;

    public SpotifyPlayEvent(PlayerEvent playerEvent, PlaybackState playbackState) {
        this.playerEvent = playerEvent;
        this.mPlaybackState = playbackState;
    }
}
