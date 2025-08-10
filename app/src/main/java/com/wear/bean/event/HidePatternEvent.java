package com.wear.bean.event;

/* loaded from: classes3.dex */
public class HidePatternEvent {
    private String patternId;

    public HidePatternEvent(String str) {
        this.patternId = str;
    }

    public String getPatternId() {
        return this.patternId;
    }

    public void setPatternId(String str) {
        this.patternId = str;
    }
}
