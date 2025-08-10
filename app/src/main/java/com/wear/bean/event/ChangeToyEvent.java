package com.wear.bean.event;

/* loaded from: classes3.dex */
public class ChangeToyEvent {
    private String address;
    private boolean isAdd;

    public ChangeToyEvent(String str, boolean z) {
        this.address = str;
        this.isAdd = z;
    }

    public String getAddress() {
        return this.address;
    }

    public boolean isAdd() {
        return this.isAdd;
    }

    public void setAdd(boolean z) {
        this.isAdd = z;
    }

    public void setAddress(String str) {
        this.address = str;
    }
}
