package com.wear.bean.socketio.controlLink.request;

/* loaded from: classes3.dex */
public class ReactivateControlLinkRequest {
    private String longTimeControlLinkId;

    public ReactivateControlLinkRequest(String str) {
        this.longTimeControlLinkId = str;
    }

    public String getLongTimeControlLinkId() {
        return this.longTimeControlLinkId;
    }

    public void setLongTimeControlLinkId(String str) {
        this.longTimeControlLinkId = str;
    }
}
