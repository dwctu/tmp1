package com.wear.bean.migrate;

/* loaded from: classes3.dex */
public class MigrateReadyTsBean {
    private boolean isAccept;
    private int transferedCount;

    public MigrateReadyTsBean(boolean z, int i) {
        this.isAccept = z;
        this.transferedCount = i;
    }

    public int getTransferedCount() {
        return this.transferedCount;
    }

    public boolean isAccept() {
        return this.isAccept;
    }
}
