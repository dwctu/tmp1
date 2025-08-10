package com.wear.bean.event;

import com.wear.protocol.CommunMessage;

/* loaded from: classes3.dex */
public class GroupMessageEvent {
    public CommunMessage message;

    public GroupMessageEvent(CommunMessage communMessage) {
        this.message = communMessage;
    }
}
