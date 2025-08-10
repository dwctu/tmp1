package com.wear.bean.socketio.msg.response;

/* loaded from: classes3.dex */
public class ClearExitPlayerResponse {
    private String jid;
    private String roomId;
    private int status;

    public String getJid() {
        return this.jid;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public int getStatus() {
        return this.status;
    }

    public void setJid(String str) {
        this.jid = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
