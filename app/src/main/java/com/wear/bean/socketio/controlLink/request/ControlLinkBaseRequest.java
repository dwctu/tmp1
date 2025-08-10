package com.wear.bean.socketio.controlLink.request;

import com.wear.bean.socketio.chatBase.BaseAckRequestBean;

/* loaded from: classes3.dex */
public class ControlLinkBaseRequest extends BaseAckRequestBean {
    private String linkId;

    public ControlLinkBaseRequest(String str) {
        this.linkId = str;
    }

    @Override // com.wear.bean.socketio.chatBase.BaseAckRequestBean, dc.pf2
    public String getAction() {
        return "q_end_control_link_ts";
    }

    public String getLinkId() {
        return this.linkId;
    }

    public void setLinkId(String str) {
        this.linkId = str;
    }

    public ControlLinkBaseRequest() {
    }
}
