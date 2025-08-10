package com.spotify.sdk.android.player;

import android.os.Parcel;
import android.os.Parcelable;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class PlaybackState implements Parcelable {
    public static final Parcelable.Creator<PlaybackState> CREATOR = new Parcelable.Creator<PlaybackState>() { // from class: com.spotify.sdk.android.player.PlaybackState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PlaybackState createFromParcel(Parcel parcel) {
            return new PlaybackState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PlaybackState[] newArray(int i) {
            return new PlaybackState[i];
        }
    };
    public final boolean isActiveDevice;
    public final boolean isPlaying;
    public final boolean isRepeating;
    public final boolean isShuffling;
    public final long positionMs;

    public PlaybackState(boolean z, boolean z2, boolean z3, boolean z4, long j) {
        this.isPlaying = z;
        this.isRepeating = z2;
        this.isShuffling = z3;
        this.isActiveDevice = z4;
        this.positionMs = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState{isPlaying=" + this.isPlaying + ", isRepeating=" + this.isRepeating + ", isShuffling=" + this.isShuffling + ", isActiveDevice=" + this.isActiveDevice + ", positionMs=" + this.positionMs + MessageFormatter.DELIM_STOP;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.isPlaying ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isRepeating ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isShuffling ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isActiveDevice ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.positionMs);
    }

    public PlaybackState(Parcel parcel) {
        this.isPlaying = parcel.readByte() != 0;
        this.isRepeating = parcel.readByte() != 0;
        this.isShuffling = parcel.readByte() != 0;
        this.isActiveDevice = parcel.readByte() != 0;
        this.positionMs = parcel.readLong();
    }
}
