package com.wear.bean.socketio.controlLink.response;

/* loaded from: classes3.dex */
public class CloseControlEvent {
    private String linkId;

    public CloseControlEvent(String str) {
        this.linkId = str;
    }

    public String getLinkId() {
        return this.linkId;
    }

    public void setLinkId(String str) {
        this.linkId = str;
    }
}
