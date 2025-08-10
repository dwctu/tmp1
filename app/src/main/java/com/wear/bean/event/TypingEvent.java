package com.wear.bean.event;

import com.wear.protocol.CommunMessage;

/* loaded from: classes3.dex */
public class TypingEvent {
    private CommunMessage communMessage;

    public TypingEvent() {
    }

    public CommunMessage getCommunMessage() {
        return this.communMessage;
    }

    public void setCommunMessage(CommunMessage communMessage) {
        this.communMessage = communMessage;
    }

    public TypingEvent(CommunMessage communMessage) {
        this.communMessage = communMessage;
    }
}
