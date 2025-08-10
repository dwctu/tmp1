package com.wear.bean.event;

/* loaded from: classes3.dex */
public class PlayerCloseEvent {
    private int errorCode;

    public PlayerCloseEvent(int i) {
        this.errorCode = i;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }
}
