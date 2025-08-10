package com.wear.bean.socketio.msg;

import dc.pf2;

/* loaded from: classes3.dex */
public class XmppMsg implements pf2 {
    private String data;
    private String frJid;
    private String id;
    private boolean receipt;
    public String requestId;
    public boolean requestReceipt;
    public String requestType;
    private String toJid;
    private String type;

    @Override // dc.pf2
    public String getAction() {
        return "xmpp";
    }

    public String getData() {
        return this.data;
    }

    public String getFrJid() {
        return this.frJid;
    }

    public String getId() {
        return this.id;
    }

    public String getToJid() {
        return this.toJid;
    }

    public String getType() {
        return this.type;
    }

    public boolean isReceipt() {
        return this.receipt;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setFrJid(String str) {
        this.frJid = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setReceipt(boolean z) {
        this.receipt = z;
    }

    public void setToJid(String str) {
        this.toJid = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
