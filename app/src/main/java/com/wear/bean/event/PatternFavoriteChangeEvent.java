package com.wear.bean.event;

/* loaded from: classes3.dex */
public class PatternFavoriteChangeEvent {
    private boolean fail;
    private boolean isFavorite;
    private boolean isStart;
    private String patternId;

    public PatternFavoriteChangeEvent(boolean z, String str, String str2) {
        this.fail = false;
        this.isStart = false;
        this.isFavorite = z;
        this.patternId = str;
        this.fail = false;
        this.isStart = false;
    }

    public boolean getIsFavorite() {
        return this.isFavorite;
    }

    public String getPatternId() {
        return this.patternId;
    }

    public boolean isFail() {
        return this.fail;
    }

    public boolean isStart() {
        return this.isStart;
    }

    public void setFail(boolean z) {
        this.fail = z;
    }

    public void setIsFavorite(boolean z) {
        this.isFavorite = z;
    }

    public void setPatternId(String str) {
        this.patternId = str;
    }

    public void setStart(boolean z) {
        this.isStart = z;
    }

    public PatternFavoriteChangeEvent(boolean z, String str) {
        this.fail = false;
        this.isStart = false;
        this.fail = z;
        this.patternId = str;
        this.isStart = false;
    }

    public PatternFavoriteChangeEvent(String str) {
        this.fail = false;
        this.isStart = false;
        this.isStart = true;
        this.patternId = str;
    }
}
