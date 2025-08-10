package com.wear.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.wear.bean.handlerbean.IContactInfo;

/* loaded from: classes3.dex */
public class BlockFriend implements Parcelable, IContactInfo {
    public static final Parcelable.Creator<BlockFriend> CREATOR = new Parcelable.Creator<BlockFriend>() { // from class: com.wear.bean.BlockFriend.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BlockFriend createFromParcel(Parcel parcel) {
            return new BlockFriend(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BlockFriend[] newArray(int i) {
            return new BlockFriend[i];
        }
    };
    public String avatar;
    public boolean isChoose;
    public boolean isFriends;
    public String jid;
    public String name;
    public String remarkName;

    public BlockFriend(String str) {
        this.name = "";
        this.remarkName = "";
        this.avatar = "";
        this.isChoose = false;
        this.isFriends = false;
        this.jid = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.wear.bean.handlerbean.IContactInfo
    public String getAvatar() {
        return this.avatar;
    }

    public String getJid() {
        return this.jid;
    }

    public String getName() {
        return this.name;
    }

    public String getRemarkName() {
        return this.remarkName;
    }

    @Override // com.wear.bean.handlerbean.IContactInfo
    public String getShowName() {
        return getName();
    }

    public boolean isChoose() {
        return this.isChoose;
    }

    public boolean isFriends() {
        return this.isFriends;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setChoose(boolean z) {
        this.isChoose = z;
    }

    public void setFriends(boolean z) {
        this.isFriends = z;
    }

    public void setName(String str) {
        this.name = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.jid);
        parcel.writeString(this.name);
        parcel.writeString(this.remarkName);
        parcel.writeString(this.avatar);
        parcel.writeByte(this.isChoose ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isFriends ? (byte) 1 : (byte) 0);
    }

    public BlockFriend(String str, String str2, String str3, String str4, boolean z) {
        this.name = "";
        this.remarkName = "";
        this.avatar = "";
        this.isChoose = false;
        this.isFriends = false;
        this.jid = str;
        this.name = str2;
        this.remarkName = str3;
        this.avatar = str4;
        this.isFriends = z;
    }

    public BlockFriend(Parcel parcel) {
        this.name = "";
        this.remarkName = "";
        this.avatar = "";
        this.isChoose = false;
        this.isFriends = false;
        this.jid = parcel.readString();
        this.name = parcel.readString();
        this.remarkName = parcel.readString();
        this.avatar = parcel.readString();
        this.isChoose = parcel.readByte() != 0;
        this.isFriends = parcel.readByte() != 0;
    }
}
