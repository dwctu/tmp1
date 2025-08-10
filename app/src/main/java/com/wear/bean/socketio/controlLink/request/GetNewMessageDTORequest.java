package com.wear.bean.socketio.controlLink.request;

import com.wear.bean.socketio.chatBase.BaseAckRequestBean;

/* loaded from: classes3.dex */
public class GetNewMessageDTORequest extends BaseAckRequestBean {
    private String msgId;

    public GetNewMessageDTORequest(String str, String str2) {
        setAckId(str);
        this.msgId = str2;
    }

    @Override // com.wear.bean.socketio.chatBase.BaseAckRequestBean, dc.pf2
    public String getAction() {
        return "q_get_user_new_msg_list_ts";
    }

    public String getMsgId() {
        return this.msgId;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }
}
