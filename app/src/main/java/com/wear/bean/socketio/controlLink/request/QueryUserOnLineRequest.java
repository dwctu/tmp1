package com.wear.bean.socketio.controlLink.request;

import com.wear.bean.socketio.chatBase.BaseAckRequestBean;

/* loaded from: classes3.dex */
public class QueryUserOnLineRequest extends BaseAckRequestBean {
    private String ackId;
    private String linkId;
    private String userId;

    public QueryUserOnLineRequest(String str, String str2, String str3) {
        this.ackId = str;
        this.userId = str2;
        this.linkId = str3;
    }

    @Override // com.wear.bean.socketio.chatBase.BaseAckRequestBean
    public String getAckId() {
        return this.ackId;
    }

    @Override // com.wear.bean.socketio.chatBase.BaseAckRequestBean, dc.pf2
    public String getAction() {
        return "query_user_on_line_info_ts";
    }

    public String getLinkId() {
        return this.linkId;
    }

    public String getUserId() {
        return this.userId;
    }

    @Override // com.wear.bean.socketio.chatBase.BaseAckRequestBean
    public void setAckId(String str) {
        this.ackId = str;
    }

    public void setLinkId(String str) {
        this.linkId = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public QueryUserOnLineRequest() {
    }
}
