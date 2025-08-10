package com.wear.bean.migrate;

/* loaded from: classes3.dex */
public class MigrateMsgsTsBean {
    private int index;
    private boolean result;
    private int transferedCount;

    public MigrateMsgsTsBean() {
    }

    public int getIndex() {
        return this.index;
    }

    public int getTransferedCount() {
        return this.transferedCount;
    }

    public boolean isResult() {
        return this.result;
    }

    public MigrateMsgsTsBean(int i, boolean z, int i2) {
        this.index = i;
        this.result = z;
        this.transferedCount = i2;
    }
}
