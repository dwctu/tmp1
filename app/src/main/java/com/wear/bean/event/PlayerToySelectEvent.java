package com.wear.bean.event;

/* loaded from: classes3.dex */
public class PlayerToySelectEvent {
    private boolean connected;
    private boolean isHide;
    private String toyId;
    private String toyName;

    public PlayerToySelectEvent(String str, String str2, boolean z) {
        this.toyId = str;
        this.toyName = str2;
        this.connected = z;
        this.isHide = false;
    }

    public String getToyId() {
        return this.toyId;
    }

    public String getToyName() {
        return this.toyName;
    }

    public boolean isConnected() {
        return this.connected;
    }

    public boolean isHide() {
        return this.isHide;
    }

    public void setConnected(boolean z) {
        this.connected = z;
    }

    public void setHide(boolean z) {
        this.isHide = z;
    }

    public void setToyId(String str) {
        this.toyId = str;
    }

    public void setToyName(String str) {
        this.toyName = str;
    }

    public PlayerToySelectEvent(boolean z) {
        this.isHide = z;
    }
}
