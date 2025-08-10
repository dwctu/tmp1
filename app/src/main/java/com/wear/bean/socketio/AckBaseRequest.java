package com.wear.bean.socketio;

import com.alibaba.fastjson.annotation.JSONField;
import dc.rf2;

/* loaded from: classes3.dex */
public abstract class AckBaseRequest extends BaseRequestBean implements rf2 {
    public String ackId;

    public String getAckId() {
        return this.ackId;
    }

    @Override // com.wear.bean.socketio.BaseRequestBean, dc.pf2
    @JSONField(serialize = false)
    public abstract /* synthetic */ String getAction();

    @Override // dc.rf2
    public String getBeanAckId() {
        return this.ackId;
    }

    public void setAckId(String str) {
        this.ackId = str;
    }
}
