package com.wear.bean.event;

import com.wear.protocol.controlLink.ControlLinkCommunMessage;
import java.util.List;

/* loaded from: classes3.dex */
public class UpdateMessageEvent {
    private List<ControlLinkCommunMessage> messages;

    public UpdateMessageEvent(List<ControlLinkCommunMessage> list) {
        this.messages = list;
    }

    public List<ControlLinkCommunMessage> getMessages() {
        return this.messages;
    }

    public void setMessages(List<ControlLinkCommunMessage> list) {
        this.messages = list;
    }
}
