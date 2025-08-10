package com.wear.bean.event;

/* loaded from: classes3.dex */
public class PatternDownloadEvent {
    public String patternId;
    public String toyTag;

    public PatternDownloadEvent(String str, String str2) {
        this.patternId = str;
        this.toyTag = str2;
    }

    public String getPatternId() {
        return this.patternId;
    }

    public String getToyTag() {
        return this.toyTag;
    }

    public void setPatternId(String str) {
        this.patternId = str;
    }

    public void setToyTag(String str) {
        this.toyTag = str;
    }
}
