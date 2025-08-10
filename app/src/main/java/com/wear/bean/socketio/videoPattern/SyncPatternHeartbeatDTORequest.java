package com.wear.bean.socketio.videoPattern;

import com.wear.bean.socketio.msg.ApiClassAnnotation;
import dc.rf2;

@ApiClassAnnotation(cls = String.class)
/* loaded from: classes3.dex */
public class SyncPatternHeartbeatDTORequest implements rf2 {
    private String ackId;

    public String getAckId() {
        return this.ackId;
    }

    @Override // dc.pf2
    public String getAction() {
        return "SyncPatternHeartbeatDTO";
    }

    @Override // dc.rf2
    public String getBeanAckId() {
        return getAckId();
    }

    public void setAckId(String str) {
        this.ackId = str;
    }
}
