package com.wear.bean.socketio.timestamp;

import com.wear.bean.socketio.chatBase.BaseAckRequestBean;

/* loaded from: classes3.dex */
public class TimestampRequest extends BaseAckRequestBean {
    @Override // com.wear.bean.socketio.chatBase.BaseAckRequestBean, dc.pf2
    public String getAction() {
        return "global_server_timestamp_ts";
    }
}
