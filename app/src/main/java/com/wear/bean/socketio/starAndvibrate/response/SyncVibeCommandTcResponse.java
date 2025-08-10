package com.wear.bean.socketio.starAndvibrate.response;

/* loaded from: classes3.dex */
public class SyncVibeCommandTcResponse {
    private int data;
    private String syncVibeActivityId;
    private String t;
    private String type;

    public int getData() {
        return this.data;
    }

    public String getSyncVibeActivityId() {
        return this.syncVibeActivityId;
    }

    public String getT() {
        return this.t;
    }

    public String getType() {
        return this.type;
    }

    public void setData(int i) {
        this.data = i;
    }

    public void setSyncVibeActivityId(String str) {
        this.syncVibeActivityId = str;
    }

    public void setT(String str) {
        this.t = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
