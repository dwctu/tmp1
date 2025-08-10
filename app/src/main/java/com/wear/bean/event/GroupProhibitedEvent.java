package com.wear.bean.event;

/* loaded from: classes3.dex */
public class GroupProhibitedEvent {
    private String roomId;
    private String status;

    public GroupProhibitedEvent(String str, String str2) {
        this.roomId = str;
        this.status = str2;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
