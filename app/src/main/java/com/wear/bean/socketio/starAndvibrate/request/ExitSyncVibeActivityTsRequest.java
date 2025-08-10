package com.wear.bean.socketio.starAndvibrate.request;

import com.wear.bean.socketio.AckBaseRequest;

/* loaded from: classes3.dex */
public class ExitSyncVibeActivityTsRequest extends AckBaseRequest {
    private String id;

    @Override // com.wear.bean.socketio.AckBaseRequest, com.wear.bean.socketio.BaseRequestBean, dc.pf2
    public String getAction() {
        return "exitSyncVibeActivity_ts";
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }
}
