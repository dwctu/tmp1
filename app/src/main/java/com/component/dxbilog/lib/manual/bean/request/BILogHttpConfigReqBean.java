package com.component.dxbilog.lib.manual.bean.request;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogHttpConfigReqBean.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/component/dxbilog/lib/manual/bean/request/BILogHttpConfigReqBean;", "", "()V", "appType", "", "getAppType", "()Ljava/lang/String;", "setAppType", "(Ljava/lang/String;)V", "platform", "getPlatform", "setPlatform", "version", "", "getVersion", "()Ljava/lang/Integer;", "setVersion", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BILogHttpConfigReqBean {

    @Nullable
    private String appType;

    @Nullable
    private String platform;

    @Nullable
    private Integer version;

    @Nullable
    public final String getAppType() {
        return this.appType;
    }

    @Nullable
    public final String getPlatform() {
        return this.platform;
    }

    @Nullable
    public final Integer getVersion() {
        return this.version;
    }

    public final void setAppType(@Nullable String str) {
        this.appType = str;
    }

    public final void setPlatform(@Nullable String str) {
        this.platform = str;
    }

    public final void setVersion(@Nullable Integer num) {
        this.version = num;
    }
}
