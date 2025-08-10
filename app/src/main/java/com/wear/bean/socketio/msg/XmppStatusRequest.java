package com.wear.bean.socketio.msg;

import dc.pf2;

/* loaded from: classes3.dex */
public class XmppStatusRequest implements pf2 {
    public String toJid;

    @Override // dc.pf2
    public String getAction() {
        return "xmppStatus";
    }
}
