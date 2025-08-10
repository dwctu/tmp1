package com.component.dxbilog.lib.manual.bean.request;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogUserConfigReqBean.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/component/dxbilog/lib/manual/bean/request/BILogUserConfigReqBean;", "", "()V", "accountCode", "", "getAccountCode", "()Ljava/lang/String;", "setAccountCode", "(Ljava/lang/String;)V", "appType", "getAppType", "setAppType", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BILogUserConfigReqBean {

    @Nullable
    private String accountCode;

    @Nullable
    private String appType;

    @Nullable
    public final String getAccountCode() {
        return this.accountCode;
    }

    @Nullable
    public final String getAppType() {
        return this.appType;
    }

    public final void setAccountCode(@Nullable String str) {
        this.accountCode = str;
    }

    public final void setAppType(@Nullable String str) {
        this.appType = str;
    }
}
