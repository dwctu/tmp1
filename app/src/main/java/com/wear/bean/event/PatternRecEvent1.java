package com.wear.bean.event;

import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityPattern;

/* loaded from: classes3.dex */
public class PatternRecEvent1 {
    public EntityPattern patternEntity;
    public boolean play;
    public CommunMessage userMessage;

    public PatternRecEvent1(EntityPattern entityPattern, CommunMessage communMessage, boolean z) {
        this.patternEntity = entityPattern;
        this.userMessage = communMessage;
        this.play = z;
    }
}
