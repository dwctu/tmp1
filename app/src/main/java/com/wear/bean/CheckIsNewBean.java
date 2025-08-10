package com.wear.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class CheckIsNewBean implements Parcelable {
    public static final Parcelable.Creator<CheckIsNewBean> CREATOR = new Parcelable.Creator<CheckIsNewBean>() { // from class: com.wear.bean.CheckIsNewBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CheckIsNewBean createFromParcel(Parcel parcel) {
            return new CheckIsNewBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CheckIsNewBean[] newArray(int i) {
            return new CheckIsNewBean[i];
        }
    };
    private int privacyUpd;
    private String privacyUrl;
    private int termsUpd;
    private String termsUrl;

    public CheckIsNewBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPrivacyUpd() {
        return this.privacyUpd;
    }

    public String getPrivacyUrl() {
        return this.privacyUrl;
    }

    public int getTermsUpd() {
        return this.termsUpd;
    }

    public String getTermsUrl() {
        return this.termsUrl;
    }

    public void setPrivacyUpd(int i) {
        this.privacyUpd = i;
    }

    public void setPrivacyUrl(String str) {
        this.privacyUrl = str;
    }

    public void setTermsUpd(int i) {
        this.termsUpd = i;
    }

    public void setTermsUrl(String str) {
        this.termsUrl = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.privacyUrl);
        parcel.writeString(this.termsUrl);
        parcel.writeInt(this.privacyUpd);
        parcel.writeInt(this.termsUpd);
    }

    public CheckIsNewBean(Parcel parcel) {
        this.privacyUrl = parcel.readString();
        this.termsUrl = parcel.readString();
        this.privacyUpd = parcel.readInt();
        this.termsUpd = parcel.readInt();
    }
}
