package com.wear.bean.socketio.msg.response;

/* loaded from: classes3.dex */
public class BaseGroupControlResponse {
    public Integer status;

    public boolean suc() {
        Integer num = this.status;
        return num == null || num.intValue() == 1;
    }
}
