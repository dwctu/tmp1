package com.wear.bean.event;

import com.wear.protocol.CommunMessage;

/* loaded from: classes3.dex */
public class SystemEvent {
    public int flag;
    public CommunMessage message;

    public SystemEvent(int i, CommunMessage communMessage) {
        this.flag = i;
        this.message = communMessage;
    }
}
