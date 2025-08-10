package com.wear.bean.socketio.controlLink.request;

import com.wear.bean.socketio.chatBase.BaseAckRequestBean;

/* loaded from: classes3.dex */
public class ReadMsgDTORequest extends BaseAckRequestBean {
    private String msgId;

    public ReadMsgDTORequest(String str, String str2) {
        setAckId(str);
        this.msgId = str2;
    }

    @Override // com.wear.bean.socketio.chatBase.BaseAckRequestBean, dc.pf2
    public String getAction() {
        return "q_deliver_im_msg_ts";
    }

    public String getMsgId() {
        return this.msgId;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }
}
