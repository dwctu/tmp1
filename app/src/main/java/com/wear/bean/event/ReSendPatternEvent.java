package com.wear.bean.event;

import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityPattern;

/* loaded from: classes3.dex */
public class ReSendPatternEvent {
    private EntityPattern entity;
    private CommunMessage message;

    public EntityPattern getEntity() {
        return this.entity;
    }

    public CommunMessage getMessage() {
        return this.message;
    }

    public void setEntity(EntityPattern entityPattern) {
        this.entity = entityPattern;
    }

    public void setMessage(CommunMessage communMessage) {
        this.message = communMessage;
    }
}
