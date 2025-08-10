package com.wear.bean.event;

import com.wear.protocol.CommunMessage;

/* loaded from: classes3.dex */
public class PatternOrAlarmSaveEvent {
    public CommunMessage communMessage;
    public String roomId;
    public int type;

    public PatternOrAlarmSaveEvent(CommunMessage communMessage, int i, String str) {
        this.communMessage = communMessage;
        this.type = i;
        this.roomId = str;
    }

    public CommunMessage getCommunMessage() {
        return this.communMessage;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public int getType() {
        return this.type;
    }

    public void setCommunMessage(CommunMessage communMessage) {
        this.communMessage = communMessage;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setType(int i) {
        this.type = i;
    }
}
