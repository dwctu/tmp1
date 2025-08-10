package com.component.dxtoy.core.toy.bean;

import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyConfigInfoBean.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/component/dxtoy/core/toy/bean/NotSupport;", "Ljava/io/Serializable;", "()V", "at", "", "getAt", "()Ljava/lang/String;", "setAt", "(Ljava/lang/String;)V", "maxv", "getMaxv", "setMaxv", "minv", "getMinv", "setMinv", "pf", "getPf", "setPf", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class NotSupport implements Serializable {

    @Nullable
    private String at;

    @Nullable
    private String maxv;

    @Nullable
    private String minv;

    @Nullable
    private String pf;

    @Nullable
    public final String getAt() {
        return this.at;
    }

    @Nullable
    public final String getMaxv() {
        return this.maxv;
    }

    @Nullable
    public final String getMinv() {
        return this.minv;
    }

    @Nullable
    public final String getPf() {
        return this.pf;
    }

    public final void setAt(@Nullable String str) {
        this.at = str;
    }

    public final void setMaxv(@Nullable String str) {
        this.maxv = str;
    }

    public final void setMinv(@Nullable String str) {
        this.minv = str;
    }

    public final void setPf(@Nullable String str) {
        this.pf = str;
    }
}
