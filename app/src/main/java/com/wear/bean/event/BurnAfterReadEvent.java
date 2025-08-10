package com.wear.bean.event;

import com.wear.protocol.CommunMessage;

/* loaded from: classes3.dex */
public class BurnAfterReadEvent {
    private CommunMessage message;

    public BurnAfterReadEvent(CommunMessage communMessage) {
        this.message = communMessage;
    }

    public CommunMessage getMessage() {
        return this.message;
    }

    public void setMessage(CommunMessage communMessage) {
        this.message = communMessage;
    }
}
