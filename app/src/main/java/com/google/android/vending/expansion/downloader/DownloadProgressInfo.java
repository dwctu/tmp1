package com.google.android.vending.expansion.downloader;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class DownloadProgressInfo implements Parcelable {
    public static final Parcelable.Creator<DownloadProgressInfo> CREATOR = new Parcelable.Creator<DownloadProgressInfo>() { // from class: com.google.android.vending.expansion.downloader.DownloadProgressInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DownloadProgressInfo createFromParcel(Parcel parcel) {
            return new DownloadProgressInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DownloadProgressInfo[] newArray(int i) {
            return new DownloadProgressInfo[i];
        }
    };
    public float mCurrentSpeed;
    public long mOverallProgress;
    public long mOverallTotal;
    public long mTimeRemaining;

    public DownloadProgressInfo(Parcel parcel) {
        this.mOverallTotal = parcel.readLong();
        this.mOverallProgress = parcel.readLong();
        this.mTimeRemaining = parcel.readLong();
        this.mCurrentSpeed = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mOverallTotal);
        parcel.writeLong(this.mOverallProgress);
        parcel.writeLong(this.mTimeRemaining);
        parcel.writeFloat(this.mCurrentSpeed);
    }

    public DownloadProgressInfo(long j, long j2, long j3, float f) {
        this.mOverallTotal = j;
        this.mOverallProgress = j2;
        this.mTimeRemaining = j3;
        this.mCurrentSpeed = f;
    }
}
