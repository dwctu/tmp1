package com.spotify.sdk.android.player;

/* loaded from: classes3.dex */
public enum PlaybackBitrate {
    BITRATE_LOW(0),
    BITRATE_NORMAL(1),
    BITRATE_HIGH(2);

    private final int mType;

    PlaybackBitrate(int i) {
        this.mType = i;
    }

    public int getValue() {
        return this.mType;
    }
}
