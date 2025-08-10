package com.wear.bean.event;

/* loaded from: classes3.dex */
public class OpenLockEvent {
    private boolean isCheck;

    public OpenLockEvent(boolean z) {
        this.isCheck = z;
    }

    public boolean isCheck() {
        return this.isCheck;
    }

    public void setCheck(boolean z) {
        this.isCheck = z;
    }
}
