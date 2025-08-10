package com.wear.bean;

/* loaded from: classes3.dex */
public class FrozenData {
    private String appRecoverAccountCode;
    private long deleteTimestamp;
    private boolean frozen;
    private long frozenTimestamp;

    public String getAppRecoverAccountCode() {
        return this.appRecoverAccountCode;
    }

    public long getDeleteTimestamp() {
        return this.deleteTimestamp;
    }

    public long getFrozenTimestamp() {
        return this.frozenTimestamp;
    }

    public boolean isFrozen() {
        return this.frozen;
    }

    public void setAppRecoverAccountCode(String str) {
        this.appRecoverAccountCode = str;
    }

    public void setDeleteTimestamp(long j) {
        this.deleteTimestamp = j;
    }

    public void setFrozen(boolean z) {
        this.frozen = z;
    }

    public void setFrozenTimestamp(long j) {
        this.frozenTimestamp = j;
    }
}
