package com.wear.bean.event;

/* loaded from: classes3.dex */
public class ControlLinkDownTimeEvent {
    private String id;
    private int time;

    public ControlLinkDownTimeEvent(String str, int i) {
        this.id = str;
        this.time = i;
    }

    public String getId() {
        return this.id;
    }

    public int getTime() {
        return this.time;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setTime(int i) {
        this.time = i;
    }
}
