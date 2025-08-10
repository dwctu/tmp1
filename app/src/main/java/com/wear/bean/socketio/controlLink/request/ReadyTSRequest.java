package com.wear.bean.socketio.controlLink.request;

import com.wear.bean.socketio.chatBase.BaseAckRequestBean;

/* loaded from: classes3.dex */
public class ReadyTSRequest extends BaseAckRequestBean {
    private String ackId;
    private String linkId;

    public ReadyTSRequest(String str, String str2) {
        this.ackId = str;
        this.linkId = str2;
    }

    @Override // com.wear.bean.socketio.chatBase.BaseAckRequestBean
    public String getAckId() {
        return this.ackId;
    }

    @Override // com.wear.bean.socketio.chatBase.BaseAckRequestBean, dc.pf2
    public String getAction() {
        return "q_ready_ts";
    }

    public String getLinkId() {
        return this.linkId;
    }

    @Override // com.wear.bean.socketio.chatBase.BaseAckRequestBean
    public void setAckId(String str) {
        this.ackId = str;
    }

    public void setLinkId(String str) {
        this.linkId = str;
    }

    public ReadyTSRequest() {
    }
}
