package com.wear.bean.socketio.controlLink.response;

/* loaded from: classes3.dex */
public class CommandResponse {
    public String data;
    public String linkId;
    public String toId;
    public String type;

    public String getData() {
        return this.data;
    }

    public String getLinkId() {
        return this.linkId;
    }

    public String getToId() {
        return this.toId;
    }

    public String getType() {
        return this.type;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setLinkId(String str) {
        this.linkId = str;
    }

    public void setToId(String str) {
        this.toId = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
