package com.wear.bean.socketio.videoPattern;

import com.wear.bean.socketio.msg.ApiClassAnnotation;
import dc.rf2;

@ApiClassAnnotation(cls = String.class)
/* loaded from: classes3.dex */
public class ErrorSyncPatternDTORequest implements rf2 {
    private String ackId;
    private String code;
    private String msg;

    public String getAckId() {
        return this.ackId;
    }

    @Override // dc.pf2
    public String getAction() {
        return "ErrorSyncPatternDTO";
    }

    @Override // dc.rf2
    public String getBeanAckId() {
        return getAckId();
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setAckId(String str) {
        this.ackId = str;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
