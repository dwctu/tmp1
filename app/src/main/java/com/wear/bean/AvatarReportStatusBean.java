package com.wear.bean;

/* loaded from: classes3.dex */
public class AvatarReportStatusBean {
    public boolean restrict = false;
    public long endRestrictTimestamp = 0;

    public long getEndRestrictTimestamp() {
        return this.endRestrictTimestamp;
    }

    public boolean isRestrict() {
        return this.restrict;
    }

    public void setEndRestrictTimestamp(long j) {
        this.endRestrictTimestamp = j;
    }

    public void setRestrict(boolean z) {
        this.restrict = z;
    }
}
