package com.component.dxbilog.lib.bean;

import kotlin.Metadata;

/* compiled from: BILogConfig.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0005\"\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007R\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0005\"\u0004\b\u000f\u0010\u0007R\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0005\"\u0004\b\u0011\u0010\u0007R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/component/dxbilog/lib/bean/BILogConfig;", "", "()V", "isAppStatusChanged", "", "()Z", "setAppStatusChanged", "(Z)V", "isAppTest", "setAppTest", "isAutoTrackAll", "setAutoTrackAll", "isAutoTrackClick", "setAutoTrackClick", "isAutoTrackPage", "setAutoTrackPage", "isManualAll", "setManualAll", "isOutputLog", "setOutputLog", "dxRouter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BILogConfig {
    private boolean isAppStatusChanged;
    private boolean isOutputLog;
    private boolean isAutoTrackAll = true;
    private boolean isAutoTrackPage = true;
    private boolean isAutoTrackClick = true;
    private boolean isManualAll = true;
    private boolean isAppTest = true;

    /* renamed from: isAppStatusChanged, reason: from getter */
    public final boolean getIsAppStatusChanged() {
        return this.isAppStatusChanged;
    }

    /* renamed from: isAppTest, reason: from getter */
    public final boolean getIsAppTest() {
        return this.isAppTest;
    }

    /* renamed from: isAutoTrackAll, reason: from getter */
    public final boolean getIsAutoTrackAll() {
        return this.isAutoTrackAll;
    }

    /* renamed from: isAutoTrackClick, reason: from getter */
    public final boolean getIsAutoTrackClick() {
        return this.isAutoTrackClick;
    }

    /* renamed from: isAutoTrackPage, reason: from getter */
    public final boolean getIsAutoTrackPage() {
        return this.isAutoTrackPage;
    }

    /* renamed from: isManualAll, reason: from getter */
    public final boolean getIsManualAll() {
        return this.isManualAll;
    }

    /* renamed from: isOutputLog, reason: from getter */
    public final boolean getIsOutputLog() {
        return this.isOutputLog;
    }

    public final void setAppStatusChanged(boolean z) {
        this.isAppStatusChanged = z;
    }

    public final void setAppTest(boolean z) {
        this.isAppTest = z;
    }

    public final void setAutoTrackAll(boolean z) {
        this.isAutoTrackAll = z;
    }

    public final void setAutoTrackClick(boolean z) {
        this.isAutoTrackClick = z;
    }

    public final void setAutoTrackPage(boolean z) {
        this.isAutoTrackPage = z;
    }

    public final void setManualAll(boolean z) {
        this.isManualAll = z;
    }

    public final void setOutputLog(boolean z) {
        this.isOutputLog = z;
    }
}
