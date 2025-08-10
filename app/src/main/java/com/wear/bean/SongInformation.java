package com.wear.bean;

/* loaded from: classes3.dex */
public class SongInformation extends Music {
    public long trackNumber = 0;
    public long discNumber = 0;

    public long getDiscNumber() {
        return this.discNumber;
    }

    public long getTrackNumber() {
        return this.trackNumber;
    }

    public void setDiscNumber(long j) {
        this.discNumber = j;
    }

    public void setTrackNumber(long j) {
        this.trackNumber = j;
    }
}
