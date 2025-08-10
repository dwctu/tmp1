package org.jivesoftware.smackx.disco.bean.response;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes5.dex */
public class ResponseRoomQrcodeInfo extends BaseResponse {
    private DataBean data;

    public static class DataBean implements Parcelable {
        public static final Parcelable.Creator<DataBean> CREATOR = new Parcelable.Creator<DataBean>() { // from class: org.jivesoftware.smackx.disco.bean.response.ResponseRoomQrcodeInfo.DataBean.1
            @Override // android.os.Parcelable.Creator
            public DataBean createFromParcel(Parcel parcel) {
                return new DataBean(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public DataBean[] newArray(int i) {
                return new DataBean[i];
            }
        };
        private String mergeUrl;
        private String roomId;
        private String roomName;
        private int total;
        private String url;

        public DataBean() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getMergeUrl() {
            return this.mergeUrl;
        }

        public String getRoomId() {
            return this.roomId;
        }

        public String getRoomName() {
            return this.roomName;
        }

        public int getTotal() {
            return this.total;
        }

        public String getUrl() {
            return this.url;
        }

        public void setMergeUrl(String str) {
            this.mergeUrl = str;
        }

        public void setRoomId(String str) {
            this.roomId = str;
        }

        public void setRoomName(String str) {
            this.roomName = str;
        }

        public void setTotal(int i) {
            this.total = i;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.roomName);
            parcel.writeString(this.roomId);
            parcel.writeInt(this.total);
            parcel.writeString(this.url);
            parcel.writeString(this.mergeUrl);
        }

        public DataBean(Parcel parcel) {
            this.roomName = parcel.readString();
            this.roomId = parcel.readString();
            this.total = parcel.readInt();
            this.url = parcel.readString();
            this.mergeUrl = parcel.readString();
        }
    }

    public DataBean getData() {
        return this.data;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }
}
