package com.wear.bean.socketio.videoPattern;

import dc.rf2;

/* loaded from: classes3.dex */
public class SuccessDownloadPatternDTORequest implements rf2 {
    private String ackId;

    public String getAckId() {
        return this.ackId;
    }

    @Override // dc.pf2
    public String getAction() {
        return "SuccessDownloadPatternDTO";
    }

    @Override // dc.rf2
    public String getBeanAckId() {
        return getAckId();
    }

    public void setAckId(String str) {
        this.ackId = str;
    }
}
