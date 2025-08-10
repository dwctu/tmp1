package com.wear.bean.socketio.msg.response;

/* loaded from: classes3.dex */
public class MasterLineStatusNotifyResponse {
    private boolean onLine;
    private String roomId;

    public String getRoomId() {
        return this.roomId;
    }

    public boolean isOnLine() {
        return this.onLine;
    }

    public void setOnLine(boolean z) {
        this.onLine = z;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }
}
