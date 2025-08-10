package com.wear.bean.socketio.controlLink.request;

import com.wear.bean.socketio.chatBase.BaseAckRequestBean;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class SendCommandRequest extends BaseAckRequestBean {
    public String linkId;
    public String toyCommandJson;
    public boolean userTouch;

    public SendCommandRequest() {
    }

    @Override // com.wear.bean.socketio.chatBase.BaseAckRequestBean, dc.pf2
    public String getAction() {
        return "q_command_link_ts";
    }

    public String getLinkId() {
        return this.linkId;
    }

    public String getToyCommandJson() {
        return this.toyCommandJson;
    }

    public boolean isUserTouch() {
        return this.userTouch;
    }

    public void setLinkId(String str) {
        this.linkId = str;
    }

    public void setToyCommandJson(String str) {
        this.toyCommandJson = str;
    }

    public void setUserTouch(boolean z) {
        this.userTouch = z;
    }

    public String toString() {
        return "SendCommandRequest{toyCommandJson='" + this.toyCommandJson + "', linkId='" + this.linkId + '\'' + MessageFormatter.DELIM_STOP;
    }

    public SendCommandRequest(String str, String str2, boolean z) {
        this.toyCommandJson = str;
        this.linkId = str2;
        this.userTouch = z;
    }
}
