package com.wear.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class OpenAppBean implements Parcelable {
    public static final Parcelable.Creator<OpenAppBean> CREATOR = new Parcelable.Creator<OpenAppBean>() { // from class: com.wear.bean.OpenAppBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OpenAppBean createFromParcel(Parcel parcel) {
            return new OpenAppBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OpenAppBean[] newArray(int i) {
            return new OpenAppBean[i];
        }
    };
    public String data;
    public String datingId;
    public String receiverName;
    public String selfId;
    public String sponsorName;
    public int type;
    public String userId;

    public OpenAppBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.userId);
        parcel.writeString(this.selfId);
        parcel.writeString(this.receiverName);
        parcel.writeString(this.datingId);
        parcel.writeString(this.sponsorName);
        parcel.writeString(this.data);
    }

    public OpenAppBean(Parcel parcel) {
        this.type = parcel.readInt();
        this.userId = parcel.readString();
        this.selfId = parcel.readString();
        this.receiverName = parcel.readString();
        this.datingId = parcel.readString();
        this.sponsorName = parcel.readString();
        this.data = parcel.readString();
    }
}
