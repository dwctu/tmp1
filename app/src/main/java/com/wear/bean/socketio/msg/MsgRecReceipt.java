package com.wear.bean.socketio.msg;

import dc.pf2;

/* loaded from: classes3.dex */
public class MsgRecReceipt implements pf2 {
    public boolean processed;
    public String receiveId;
    public String requestType;
    public long serverTime;

    @Override // dc.pf2
    public String getAction() {
        return "MsgRecReceipt";
    }
}
