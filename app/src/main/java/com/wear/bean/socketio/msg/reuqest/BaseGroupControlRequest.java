package com.wear.bean.socketio.msg.reuqest;

import com.alibaba.fastjson.annotation.JSONField;
import com.wear.bean.socketio.BaseRequestBean;
import dc.rf2;

/* loaded from: classes3.dex */
public abstract class BaseGroupControlRequest extends BaseRequestBean implements rf2 {
    public String ackId;
    public String roomId;

    public String getAckId() {
        return this.ackId;
    }

    @Override // com.wear.bean.socketio.BaseRequestBean, dc.pf2
    @JSONField(serialize = false)
    public abstract /* synthetic */ String getAction();

    @Override // dc.rf2
    public String getBeanAckId() {
        return getAckId();
    }

    public String getRoomId() {
        return this.roomId;
    }

    public void setAckId(String str) {
        this.ackId = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }
}
