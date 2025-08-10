package com.spotify.sdk.android.player;

import android.os.Parcel;
import android.os.Parcelable;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = new Parcelable.Creator<Metadata>() { // from class: com.spotify.sdk.android.player.Metadata.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Metadata createFromParcel(Parcel parcel) {
            return new Metadata(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Metadata[] newArray(int i) {
            return new Metadata[i];
        }
    };
    public final String contextName;
    public final String contextUri;
    public final Track currentTrack;
    public final Track nextTrack;
    public final Track prevTrack;

    public Metadata(String str, String str2, Track track, Track track2, Track track3) {
        this.contextName = str;
        this.contextUri = str2;
        this.prevTrack = track;
        this.currentTrack = track2;
        this.nextTrack = track3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Metadata metadata = (Metadata) obj;
        String str = this.contextName;
        if (str == null ? metadata.contextName != null : !str.equals(metadata.contextName)) {
            return false;
        }
        String str2 = this.contextUri;
        if (str2 == null ? metadata.contextUri != null : !str2.equals(metadata.contextUri)) {
            return false;
        }
        Track track = this.prevTrack;
        if (track == null ? metadata.prevTrack != null : !track.equals(metadata.prevTrack)) {
            return false;
        }
        Track track2 = this.currentTrack;
        if (track2 == null ? metadata.currentTrack != null : !track2.equals(metadata.currentTrack)) {
            return false;
        }
        Track track3 = this.nextTrack;
        Track track4 = metadata.nextTrack;
        return track3 != null ? track3.equals(track4) : track4 == null;
    }

    public int hashCode() {
        String str = this.contextName;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.contextUri;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Track track = this.prevTrack;
        int iHashCode3 = (iHashCode2 + (track != null ? track.hashCode() : 0)) * 31;
        Track track2 = this.currentTrack;
        int iHashCode4 = (iHashCode3 + (track2 != null ? track2.hashCode() : 0)) * 31;
        Track track3 = this.nextTrack;
        return iHashCode4 + (track3 != null ? track3.hashCode() : 0);
    }

    public String toString() {
        return "Metadata{contentName=" + this.contextName + ", contentUri=" + this.contextUri + ", prevTrack=" + this.prevTrack + ", currentTrack=" + this.currentTrack + ", nextTrack=" + this.nextTrack + MessageFormatter.DELIM_STOP;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.contextName);
        parcel.writeString(this.contextUri);
        parcel.writeParcelable(this.prevTrack, i);
        parcel.writeParcelable(this.currentTrack, i);
        parcel.writeParcelable(this.nextTrack, i);
    }

    public Metadata(Parcel parcel) {
        this.contextName = parcel.readString();
        this.contextUri = parcel.readString();
        this.prevTrack = (Track) parcel.readParcelable(Track.class.getClassLoader());
        this.currentTrack = (Track) parcel.readParcelable(Track.class.getClassLoader());
        this.nextTrack = (Track) parcel.readParcelable(Track.class.getClassLoader());
    }

    public static class Track implements Parcelable {
        public static final Parcelable.Creator<Track> CREATOR = new Parcelable.Creator<Track>() { // from class: com.spotify.sdk.android.player.Metadata.Track.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Track createFromParcel(Parcel parcel) {
                return new Track(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Track[] newArray(int i) {
                return new Track[i];
            }
        };
        public final String albumCoverWebUrl;
        public final String albumName;
        public final String albumUri;
        public final String artistName;
        public final String artistUri;
        public final long durationMs;
        public final long indexInContext;
        public final String name;
        public final String uri;

        public Track(String str, String str2, String str3, String str4, String str5, String str6, long j, long j2, String str7) {
            this.name = str;
            this.uri = str2;
            this.artistName = str3;
            this.artistUri = str4;
            this.albumName = str5;
            this.albumUri = str6;
            this.durationMs = j;
            this.indexInContext = j2;
            this.albumCoverWebUrl = str7;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Track track = (Track) obj;
            if (this.durationMs != track.durationMs || this.indexInContext != track.indexInContext) {
                return false;
            }
            String str = this.name;
            if (str == null ? track.name != null : !str.equals(track.name)) {
                return false;
            }
            String str2 = this.uri;
            if (str2 == null ? track.uri != null : !str2.equals(track.uri)) {
                return false;
            }
            String str3 = this.artistName;
            if (str3 == null ? track.artistName != null : !str3.equals(track.artistName)) {
                return false;
            }
            String str4 = this.artistUri;
            if (str4 == null ? track.artistUri != null : !str4.equals(track.artistUri)) {
                return false;
            }
            String str5 = this.albumName;
            if (str5 == null ? track.albumName != null : !str5.equals(track.albumName)) {
                return false;
            }
            String str6 = this.albumUri;
            if (str6 == null ? track.albumUri != null : !str6.equals(track.albumUri)) {
                return false;
            }
            String str7 = this.albumCoverWebUrl;
            String str8 = track.albumCoverWebUrl;
            return str7 != null ? str7.equals(str8) : str8 == null;
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.uri;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.artistName;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.artistUri;
            int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.albumName;
            int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.albumUri;
            int iHashCode6 = (iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
            long j = this.durationMs;
            int i = (iHashCode6 + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.indexInContext;
            int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            String str7 = this.albumCoverWebUrl;
            return i2 + (str7 != null ? str7.hashCode() : 0);
        }

        public String toString() {
            return "Track{name='" + this.name + "', uri='" + this.uri + "', artistName='" + this.artistName + "', artistUri='" + this.artistUri + "', albumName='" + this.albumName + "', albumUri='" + this.albumUri + "', durationMs=" + this.durationMs + ", indexInContext=" + this.indexInContext + ", albumCoverWebUrl=" + this.albumCoverWebUrl + MessageFormatter.DELIM_STOP;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.name);
            parcel.writeString(this.uri);
            parcel.writeString(this.artistName);
            parcel.writeString(this.artistUri);
            parcel.writeString(this.albumName);
            parcel.writeString(this.albumUri);
            parcel.writeLong(this.durationMs);
            parcel.writeLong(this.indexInContext);
            parcel.writeString(this.albumCoverWebUrl);
        }

        public Track(Parcel parcel) {
            this.name = parcel.readString();
            this.uri = parcel.readString();
            this.artistName = parcel.readString();
            this.artistUri = parcel.readString();
            this.albumName = parcel.readString();
            this.albumUri = parcel.readString();
            this.durationMs = parcel.readLong();
            this.indexInContext = parcel.readLong();
            this.albumCoverWebUrl = parcel.readString();
        }
    }
}
