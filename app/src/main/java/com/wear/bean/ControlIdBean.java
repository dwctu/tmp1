package com.wear.bean;

/* loaded from: classes3.dex */
public class ControlIdBean {
    private Status available;
    private String controlId;
    private boolean isCreate;

    public enum Status {
        request,
        cancel,
        accept,
        reject,
        end
    }

    public Status getAvailable() {
        return this.available;
    }

    public String getControlId() {
        return this.controlId;
    }

    public boolean isCreate() {
        return this.isCreate;
    }

    public void setAvailable(Status status) {
        this.available = status;
    }

    public void setControlId(String str) {
        this.controlId = str;
    }

    public void setCreate(boolean z) {
        this.isCreate = z;
    }
}
