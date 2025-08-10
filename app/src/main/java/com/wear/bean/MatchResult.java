package com.wear.bean;

/* loaded from: classes3.dex */
public class MatchResult {
    public String defaultText;
    public boolean isReg;
    public String key;

    public MatchResult(String str, String str2, boolean z) {
        this.isReg = false;
        this.key = str;
        this.defaultText = str2;
        this.isReg = z;
    }

    public String getDefaultText() {
        return this.defaultText;
    }

    public String getKey() {
        return this.key;
    }

    public boolean isReg() {
        return this.isReg;
    }

    public void setDefaultText(String str) {
        this.defaultText = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setReg(boolean z) {
        this.isReg = z;
    }
}
