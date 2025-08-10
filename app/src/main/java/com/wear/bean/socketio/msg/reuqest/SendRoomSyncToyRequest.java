package com.wear.bean.socketio.msg.reuqest;

import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class SendRoomSyncToyRequest extends BaseGroupControlRequest {
    private String order;
    private int version = 4;

    @Override // com.wear.bean.socketio.msg.reuqest.BaseGroupControlRequest, com.wear.bean.socketio.BaseRequestBean, dc.pf2
    public String getAction() {
        return "sendRoomSyncToy";
    }

    public String getOrder() {
        return this.order;
    }

    public int getVersion() {
        return this.version;
    }

    public void setOrder(String str) {
        this.order = str;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public String toString() {
        return "SendRoomSyncToyRequest{version=" + this.version + ", order='" + this.order + '\'' + MessageFormatter.DELIM_STOP;
    }
}
