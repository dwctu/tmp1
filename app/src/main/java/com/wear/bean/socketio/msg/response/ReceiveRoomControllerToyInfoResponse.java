package com.wear.bean.socketio.msg.response;

/* loaded from: classes3.dex */
public class ReceiveRoomControllerToyInfoResponse {
    private String jid;
    private String roomId;
    private String toyJson;

    public String getJid() {
        return this.jid;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public String getToyJson() {
        return this.toyJson;
    }

    public void setJid(String str) {
        this.jid = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setToyJson(String str) {
        this.toyJson = str;
    }
}
