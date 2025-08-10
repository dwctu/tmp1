package com.broadcom.bt.map;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.broadcom.bt.util.io.IOUtils;

/* loaded from: classes.dex */
public class PersonInfo implements Parcelable {
    public static final Parcelable.Creator<PersonInfo> CREATOR = new Parcelable.Creator<PersonInfo>() { // from class: com.broadcom.bt.map.PersonInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PersonInfo createFromParcel(Parcel parcel) {
            return new PersonInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PersonInfo[] newArray(int i) {
            return new PersonInfo[i];
        }
    };
    public String mDisplayName;
    public String mFamilyName;
    public String mGivenName;
    public String mMiddleName;

    public PersonInfo(Parcel parcel) {
        if (parcel.readByte() == 1) {
            this.mDisplayName = parcel.readString();
        }
        if (parcel.readByte() == 1) {
            this.mGivenName = parcel.readString();
        }
        if (parcel.readByte() == 1) {
            this.mMiddleName = parcel.readString();
        }
        if (parcel.readByte() == 1) {
            this.mFamilyName = parcel.readString();
        }
    }

    public static String getDisplayName(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(str4);
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void dumpState(StringBuilder sb, String str) {
        sb.append(str);
        sb.append("displayName  = ");
        String str2 = this.mDisplayName;
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(str);
        sb.append("givenName = ");
        String str3 = this.mGivenName;
        if (str3 == null) {
            str3 = "";
        }
        sb.append(str3);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(str);
        sb.append("middleName = ");
        String str4 = this.mMiddleName;
        if (str4 == null) {
            str4 = "";
        }
        sb.append(str4);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(str);
        sb.append("familyName = ");
        String str5 = this.mFamilyName;
        sb.append(str5 != null ? str5 : "");
    }

    public String toVcardField_FN() {
        return toVcardField_FN(this.mDisplayName, this.mGivenName, this.mMiddleName, this.mFamilyName);
    }

    public String toVcardField_N() {
        return toVcardField_N(this.mDisplayName, this.mGivenName, this.mMiddleName, this.mFamilyName);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.mDisplayName == null ? (byte) 0 : (byte) 1);
        String str = this.mDisplayName;
        if (str != null) {
            parcel.writeString(str);
        }
        parcel.writeByte(this.mGivenName == null ? (byte) 0 : (byte) 1);
        String str2 = this.mGivenName;
        if (str2 != null) {
            parcel.writeString(str2);
        }
        parcel.writeByte(this.mMiddleName == null ? (byte) 0 : (byte) 1);
        String str3 = this.mMiddleName;
        if (str3 != null) {
            parcel.writeString(str3);
        }
        parcel.writeByte(this.mFamilyName != null ? (byte) 1 : (byte) 0);
        String str4 = this.mFamilyName;
        if (str4 != null) {
            parcel.writeString(str4);
        }
    }

    public static String toVcardField_FN(String str, String str2, String str3, String str4) {
        String displayName = getDisplayName(str, str2, str3, str4);
        return displayName == null ? "" : displayName;
    }

    public static String toVcardField_N(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str4)) {
            sb.append(str4);
        }
        if (!TextUtils.isEmpty(str2)) {
            if (sb.length() > 0) {
                sb.append(";");
            }
            sb.append(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            if (sb.length() > 0) {
                sb.append(";");
            }
            sb.append(str3);
        }
        return sb.length() > 0 ? sb.toString() : "";
    }

    public PersonInfo() {
    }

    public String getDisplayName() {
        return getDisplayName(this.mDisplayName, this.mGivenName, this.mMiddleName, this.mFamilyName);
    }
}
