package com.wear.bean.socketio.msg.reuqest;

/* loaded from: classes3.dex */
public class ChangeRoomControllerRequest extends BaseGroupControlRequest {
    private String jid;

    @Override // com.wear.bean.socketio.msg.reuqest.BaseGroupControlRequest, com.wear.bean.socketio.BaseRequestBean, dc.pf2
    public String getAction() {
        return "changeRoomController";
    }

    public String getJid() {
        return this.jid;
    }

    public void setJid(String str) {
        this.jid = str;
    }
}
