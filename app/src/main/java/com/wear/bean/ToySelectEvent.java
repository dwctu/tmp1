package com.wear.bean;

/* loaded from: classes3.dex */
public class ToySelectEvent {
    private String address;
    private boolean isSelect;

    public ToySelectEvent(String str, boolean z) {
        this.address = str;
        this.isSelect = z;
    }

    public String getAddress() {
        return this.address;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setSelect(boolean z) {
        this.isSelect = z;
    }
}
