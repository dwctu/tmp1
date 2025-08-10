package com.wear.bean.socketio.display;

import java.util.List;

/* loaded from: classes3.dex */
public class ScanModelControlQrCodeRequestBean {
    private String pcOrMobile;
    private String roomKey;
    private List<ToyInfoBean> toyInfoList;

    public String getPcOrMobile() {
        return this.pcOrMobile;
    }

    public String getRoomKey() {
        return this.roomKey;
    }

    public List<ToyInfoBean> getToyInfoList() {
        return this.toyInfoList;
    }

    public void setPcOrMobile(String str) {
        this.pcOrMobile = str;
    }

    public void setRoomKey(String str) {
        this.roomKey = str;
    }

    public void setToyInfoList(List<ToyInfoBean> list) {
        this.toyInfoList = list;
    }
}
