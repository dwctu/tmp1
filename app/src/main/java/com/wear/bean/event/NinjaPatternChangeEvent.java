package com.wear.bean.event;

import com.wear.util.WearUtils;

/* loaded from: classes3.dex */
public class NinjaPatternChangeEvent {
    private int changeStatus;
    private String nowMode;
    private String patternAuthor;
    private String patternName;
    private boolean playOrPause;

    public NinjaPatternChangeEvent(String str, String str2, String str3, boolean z) {
        this.changeStatus = 0;
        this.changeStatus = 0;
        this.patternName = str;
        this.patternAuthor = str2;
        this.nowMode = str3;
        this.playOrPause = z;
    }

    public int getChangeStatus() {
        return this.changeStatus;
    }

    public int getNowMode() {
        if (WearUtils.e1(this.nowMode)) {
            return 0;
        }
        if (this.nowMode.equals("repeat")) {
            return 2;
        }
        return this.nowMode.equals("random") ? 1 : 0;
    }

    public String getPatternAuthor() {
        return this.patternAuthor;
    }

    public String getPatternName() {
        return this.patternName;
    }

    public boolean isPlayOrPause() {
        return this.playOrPause;
    }

    public void setChangeStatus(int i) {
        this.changeStatus = i;
    }

    public void setNowMode(String str) {
        this.nowMode = str;
    }

    public void setPatternAuthor(String str) {
        this.patternAuthor = str;
    }

    public void setPatternName(String str) {
        this.patternName = str;
    }

    public void setPlayOrPause(boolean z) {
        this.playOrPause = z;
    }

    public NinjaPatternChangeEvent(boolean z) {
        this.changeStatus = 0;
        this.changeStatus = 1;
        this.playOrPause = z;
    }

    public NinjaPatternChangeEvent(String str) {
        this.changeStatus = 0;
        this.changeStatus = 2;
        this.nowMode = str;
    }
}
