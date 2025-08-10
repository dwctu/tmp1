package com.wear.bean.event;

import com.wear.protocol.controlLink.ControlLinkCommunMessage;

/* loaded from: classes3.dex */
public class SendMessageEvent {
    private ControlLinkCommunMessage message;

    public SendMessageEvent(ControlLinkCommunMessage controlLinkCommunMessage) {
        this.message = controlLinkCommunMessage;
    }

    public ControlLinkCommunMessage getMessage() {
        return this.message;
    }

    public void setMessage(ControlLinkCommunMessage controlLinkCommunMessage) {
        this.message = controlLinkCommunMessage;
    }
}
