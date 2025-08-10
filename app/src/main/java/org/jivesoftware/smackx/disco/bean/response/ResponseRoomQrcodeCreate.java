package org.jivesoftware.smackx.disco.bean.response;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes5.dex */
public class ResponseRoomQrcodeCreate extends BaseResponse {
    private DataBean data;

    public static class DataBean implements Parcelable {
        public static final Parcelable.Creator<DataBean> CREATOR = new Parcelable.Creator<DataBean>() { // from class: org.jivesoftware.smackx.disco.bean.response.ResponseRoomQrcodeCreate.DataBean.1
            @Override // android.os.Parcelable.Creator
            public DataBean createFromParcel(Parcel parcel) {
                return new DataBean(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public DataBean[] newArray(int i) {
                return new DataBean[i];
            }
        };
        private String codeKey;
        private int days;
        private long endtime;
        private int type;

        public DataBean() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getCodeKey() {
            return this.codeKey;
        }

        public int getDays() {
            return this.days;
        }

        public long getEndtime() {
            return this.endtime;
        }

        public int getType() {
            return this.type;
        }

        public void setCodeKey(String str) {
            this.codeKey = str;
        }

        public void setDays(int i) {
            this.days = i;
        }

        public void setEndtime(long j) {
            this.endtime = j;
        }

        public void setType(int i) {
            this.type = i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.codeKey);
            parcel.writeInt(this.type);
            parcel.writeLong(this.endtime);
            parcel.writeInt(this.days);
        }

        public DataBean(Parcel parcel) {
            this.codeKey = parcel.readString();
            this.type = parcel.readInt();
            this.endtime = parcel.readLong();
            this.days = parcel.readInt();
        }
    }

    public DataBean getData() {
        return this.data;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }
}
