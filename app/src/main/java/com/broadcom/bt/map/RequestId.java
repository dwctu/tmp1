package com.broadcom.bt.map;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class RequestId implements Parcelable {
    public static final Parcelable.Creator<RequestId> CREATOR = new Parcelable.Creator<RequestId>() { // from class: com.broadcom.bt.map.RequestId.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RequestId createFromParcel(Parcel parcel) {
            return new RequestId(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RequestId[] newArray(int i) {
            return new RequestId[i];
        }
    };
    public int mEventId;
    public String mRequestData;
    public int mSessionId;

    public RequestId(int i, int i2) {
        this.mSessionId = i;
        this.mEventId = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof RequestId)) {
            return false;
        }
        RequestId requestId = (RequestId) obj;
        if (this.mSessionId == requestId.mSessionId && this.mEventId == requestId.mEventId) {
            String str = this.mRequestData;
            String str2 = requestId.mRequestData;
            if (str == str2) {
                return true;
            }
            if (str != null && str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.mSessionId + this.mEventId;
        String str = this.mRequestData;
        return i + (str == null ? 0 : str.hashCode());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mSessionId);
        parcel.writeInt(this.mEventId);
        if (this.mRequestData == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(this.mRequestData);
        }
    }

    public RequestId(Parcel parcel) {
        this.mSessionId = parcel.readInt();
        this.mEventId = parcel.readInt();
        if (parcel.readInt() == 1) {
            this.mRequestData = parcel.readString();
        }
    }
}
