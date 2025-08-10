package com.wear.bean.socketio.starAndvibrate.request;

import com.wear.bean.socketio.AckBaseRequest;

/* loaded from: classes3.dex */
public class JoinSyncVibeActivityTsRequest extends AckBaseRequest {
    private String id;
    private int joinType;

    @Override // com.wear.bean.socketio.AckBaseRequest, com.wear.bean.socketio.BaseRequestBean, dc.pf2
    public String getAction() {
        return "joinSyncVibeActivity_ts";
    }

    @Override // com.wear.bean.socketio.AckBaseRequest, dc.rf2
    public String getBeanAckId() {
        return this.ackId;
    }

    public String getId() {
        return this.id;
    }

    public int getJoinType() {
        return this.joinType;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setJoinType(int i) {
        this.joinType = i;
    }
}
