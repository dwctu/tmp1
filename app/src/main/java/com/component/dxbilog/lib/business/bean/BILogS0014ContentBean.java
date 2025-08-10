package com.component.dxbilog.lib.business.bean;

import kotlin.Metadata;

/* compiled from: BILogS0014ContentBean.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0005\"\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/component/dxbilog/lib/business/bean/BILogS0014ContentBean;", "", "()V", "isEmulator", "", "()Z", "setEmulator", "(Z)V", "isHook", "setHook", "isRoot", "setRoot", "isUpload", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BILogS0014ContentBean {
    private boolean isEmulator;
    private boolean isHook;
    private boolean isRoot;

    /* renamed from: isEmulator, reason: from getter */
    public final boolean getIsEmulator() {
        return this.isEmulator;
    }

    /* renamed from: isHook, reason: from getter */
    public final boolean getIsHook() {
        return this.isHook;
    }

    /* renamed from: isRoot, reason: from getter */
    public final boolean getIsRoot() {
        return this.isRoot;
    }

    public final boolean isUpload() {
        return this.isEmulator || this.isRoot || this.isHook;
    }

    public final void setEmulator(boolean z) {
        this.isEmulator = z;
    }

    public final void setHook(boolean z) {
        this.isHook = z;
    }

    public final void setRoot(boolean z) {
        this.isRoot = z;
    }
}
