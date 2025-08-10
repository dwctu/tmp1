package com.component.dxtoy.core.toy.bean;

import com.wear.bean.SyncWsProtocol;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyConfigInfoBean.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/component/dxtoy/core/toy/bean/SupportMultiply;", "Lcom/component/dxtoy/core/toy/bean/RangeBean;", "()V", SyncWsProtocol.CONTROL_ORDER_TOY_TYPE_KEY, "", "getOrder", "()Ljava/lang/String;", "setOrder", "(Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SupportMultiply extends RangeBean {

    @Nullable
    private String order;

    @Nullable
    public final String getOrder() {
        return this.order;
    }

    public final void setOrder(@Nullable String str) {
        this.order = str;
    }
}
