package com.wear.bean.socketio.controlLink.response;

/* loaded from: classes3.dex */
public class ReadyTCResponse {
    private String ackId;
    private String linkId;
    private int linkStatus;

    public String getAckId() {
        return this.ackId;
    }

    public String getLinkId() {
        return this.linkId;
    }

    public int getLinkStatus() {
        return this.linkStatus;
    }

    public void setAckId(String str) {
        this.ackId = str;
    }

    public void setLinkId(String str) {
        this.linkId = str;
    }

    public void setLinkStatus(int i) {
        this.linkStatus = i;
    }
}
