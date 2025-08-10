package com.wear.bean.socketio.msg.response;

/* loaded from: classes3.dex */
public class PlayerAcceptRoomSyncResponse extends BaseGroupControlResponse {
    private String jid;
    private String roomId;

    public String getJid() {
        return this.jid;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public void setJid(String str) {
        this.jid = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }
}
