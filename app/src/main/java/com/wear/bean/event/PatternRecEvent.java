package com.wear.bean.event;

import com.wear.protocol.CommunMessage;

/* loaded from: classes3.dex */
public class PatternRecEvent {
    public CommunMessage patternNoticeMessage;
    public boolean play;
    public CommunMessage userMessage;

    public PatternRecEvent(CommunMessage communMessage, boolean z, CommunMessage communMessage2) {
        this.userMessage = communMessage;
        this.play = z;
        this.patternNoticeMessage = communMessage2;
    }
}
