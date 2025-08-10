package com.wear.bean.socketio.controlLink.request;

import com.wear.bean.socketio.chatBase.BaseAckRequestBean;

/* loaded from: classes3.dex */
public class CancelOccupyCountDownRequest extends BaseAckRequestBean {
    private String linkId;

    public CancelOccupyCountDownRequest(String str, String str2) {
        setAckId(str);
        this.linkId = str2;
    }

    @Override // com.wear.bean.socketio.chatBase.BaseAckRequestBean, dc.pf2
    public String getAction() {
        return "q_cancel_occupy_countdown_ts";
    }

    public String getLinkId() {
        return this.linkId;
    }

    public void setLinkId(String str) {
        this.linkId = str;
    }
}
