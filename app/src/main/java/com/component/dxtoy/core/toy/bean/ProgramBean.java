package com.component.dxtoy.core.toy.bean;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyConfigInfoBean.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/component/dxtoy/core/toy/bean/ProgramBean;", "Lcom/component/dxtoy/core/toy/bean/RangeBean;", "()V", "fast", "", "getFast", "()Z", "setFast", "(Z)V", "l", "", "getL", "()Ljava/lang/String;", "setL", "(Ljava/lang/String;)V", "p", "getP", "setP", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ProgramBean extends RangeBean {
    private boolean fast;

    @Nullable
    private String l;

    @Nullable
    private String p;

    public final boolean getFast() {
        return this.fast;
    }

    @Nullable
    public final String getL() {
        return this.l;
    }

    @Nullable
    public final String getP() {
        return this.p;
    }

    public final void setFast(boolean z) {
        this.fast = z;
    }

    public final void setL(@Nullable String str) {
        this.l = str;
    }

    public final void setP(@Nullable String str) {
        this.p = str;
    }
}
