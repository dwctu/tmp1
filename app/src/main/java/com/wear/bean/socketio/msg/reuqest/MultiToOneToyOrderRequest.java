package com.wear.bean.socketio.msg.reuqest;

import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class MultiToOneToyOrderRequest extends BaseGroupControlRequest {
    private String order;

    @Override // com.wear.bean.socketio.msg.reuqest.BaseGroupControlRequest, com.wear.bean.socketio.BaseRequestBean, dc.pf2
    public String getAction() {
        return "MULTI_TO_ONE_TOY_ORDER";
    }

    public String getOrder() {
        return this.order;
    }

    public void setOrder(String str) {
        this.order = str;
    }

    public String toString() {
        return "MultiToOneToyOrderRequest{order='" + this.order + '\'' + MessageFormatter.DELIM_STOP;
    }
}
