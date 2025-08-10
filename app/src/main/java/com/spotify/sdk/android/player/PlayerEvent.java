package com.spotify.sdk.android.player;

/* loaded from: classes3.dex */
public enum PlayerEvent {
    UNKNOWN(-1),
    kSpPlaybackNotifyPlay(0),
    kSpPlaybackNotifyPause(1),
    kSpPlaybackNotifyTrackChanged(2),
    kSpPlaybackNotifyNext(3),
    kSpPlaybackNotifyPrev(4),
    kSpPlaybackNotifyShuffleOn(5),
    kSpPlaybackNotifyShuffleOff(6),
    kSpPlaybackNotifyRepeatOn(7),
    kSpPlaybackNotifyRepeatOff(8),
    kSpPlaybackNotifyBecameActive(9),
    kSpPlaybackNotifyBecameInactive(10),
    kSpPlaybackNotifyLostPermission(11),
    kSpPlaybackEventAudioFlush(12),
    kSpPlaybackNotifyAudioDeliveryDone(13),
    kSpPlaybackNotifyContextChanged(14),
    kSpPlaybackNotifyTrackDelivered(15),
    kSpPlaybackNotifyMetadataChanged(16);

    private final int nativeCode;

    PlayerEvent(int i) {
        this.nativeCode = i;
    }

    public static PlayerEvent fromNativeEvent(int i) {
        for (PlayerEvent playerEvent : values()) {
            if (playerEvent.nativeCode == i) {
                return playerEvent;
            }
        }
        return UNKNOWN;
    }
}
