package com.wear.bean.event;

import com.wear.protocol.MessageType;

/* loaded from: classes3.dex */
public class ControlLinkChatControlEnd {
    public String controlTime;
    public MessageType messageType;
    public String userId;

    public ControlLinkChatControlEnd(String str, String str2, MessageType messageType) {
        this.userId = str;
        this.controlTime = str2;
        this.messageType = messageType;
    }

    public String getControlTime() {
        return this.controlTime;
    }

    public MessageType getMessageType() {
        return this.messageType;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setControlTime(String str) {
        this.controlTime = str;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
