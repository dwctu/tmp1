package com.wear.bean.socketio.chatBase;

import com.alibaba.fastjson.annotation.JSONField;
import com.wear.bean.socketio.msg.ApiClassAnnotation;
import dc.rf2;

@ApiClassAnnotation(cls = String.class)
/* loaded from: classes3.dex */
public abstract class BaseAckRequestBean implements rf2 {
    private String ackId;

    public String getAckId() {
        return this.ackId;
    }

    @Override // dc.pf2
    @JSONField(serialize = false)
    public abstract /* synthetic */ String getAction();

    @Override // dc.rf2
    public String getBeanAckId() {
        return getAckId();
    }

    public void setAckId(String str) {
        this.ackId = str;
    }
}
