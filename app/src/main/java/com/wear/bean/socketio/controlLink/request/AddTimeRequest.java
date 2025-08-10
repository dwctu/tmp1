package com.wear.bean.socketio.controlLink.request;

import com.wear.bean.socketio.chatBase.BaseChatRequest;

/* loaded from: classes3.dex */
public class AddTimeRequest extends BaseChatRequest {
    private String linkId;
    private int time;

    public AddTimeRequest(String str, int i) {
        this.linkId = str;
        this.time = i;
    }

    @Override // com.wear.bean.socketio.chatBase.BaseChatRequest, com.wear.bean.socketio.BaseRequestBean, dc.pf2
    public String getAction() {
        return "cl_add_control_link_play_time_ts";
    }

    public String getLinkId() {
        return this.linkId;
    }

    public int getTime() {
        return this.time;
    }

    public void setLinkId(String str) {
        this.linkId = str;
    }

    public void setTime(int i) {
        this.time = i;
    }
}
