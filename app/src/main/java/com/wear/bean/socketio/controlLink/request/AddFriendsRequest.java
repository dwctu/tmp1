package com.wear.bean.socketio.controlLink.request;

import com.wear.bean.socketio.chatBase.BaseChatRequest;

/* loaded from: classes3.dex */
public class AddFriendsRequest extends BaseChatRequest {
    private String linkId;

    @Override // com.wear.bean.socketio.chatBase.BaseChatRequest, com.wear.bean.socketio.BaseRequestBean, dc.pf2
    public String getAction() {
        return "cl_add_friend_req_ts";
    }

    public String getLinkId() {
        return this.linkId;
    }

    public void setLinkId(String str) {
        this.linkId = str;
    }
}
