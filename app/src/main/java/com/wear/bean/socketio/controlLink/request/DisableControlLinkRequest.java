package com.wear.bean.socketio.controlLink.request;

/* loaded from: classes3.dex */
public class DisableControlLinkRequest {
    private String longTimeControlLinkId;

    public DisableControlLinkRequest(String str) {
        this.longTimeControlLinkId = str;
    }

    public String getLongTimeControlLinkId() {
        return this.longTimeControlLinkId;
    }

    public void setLongTimeControlLinkId(String str) {
        this.longTimeControlLinkId = str;
    }
}
