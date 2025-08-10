package com.component.dxtoy.core.toy.bean;

import java.io.Serializable;
import kotlin.Metadata;

/* compiled from: ToyConfigInfoBean.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/component/dxtoy/core/toy/bean/RangeBean;", "Ljava/io/Serializable;", "()V", "maxv", "", "getMaxv", "()I", "setMaxv", "(I)V", "minv", "getMinv", "setMinv", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public class RangeBean implements Serializable {
    private int maxv;
    private int minv;

    public final int getMaxv() {
        return this.maxv;
    }

    public final int getMinv() {
        return this.minv;
    }

    public final void setMaxv(int i) {
        this.maxv = i;
    }

    public final void setMinv(int i) {
        this.minv = i;
    }
}
