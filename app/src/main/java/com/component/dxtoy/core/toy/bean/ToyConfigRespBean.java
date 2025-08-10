package com.component.dxtoy.core.toy.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyConfigRespBean.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/component/dxtoy/core/toy/bean/ToyConfigRespBean;", "", "dv", "", "data", "Lcom/component/dxtoy/core/toy/bean/ToyConfigBean;", "(Ljava/lang/Integer;Lcom/component/dxtoy/core/toy/bean/ToyConfigBean;)V", "getData", "()Lcom/component/dxtoy/core/toy/bean/ToyConfigBean;", "getDv", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Lcom/component/dxtoy/core/toy/bean/ToyConfigBean;)Lcom/component/dxtoy/core/toy/bean/ToyConfigRespBean;", "equals", "", "other", "hashCode", "toString", "", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ToyConfigRespBean {

    @Nullable
    private final ToyConfigBean data;

    @Nullable
    private final Integer dv;

    public ToyConfigRespBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public ToyConfigRespBean(@Nullable Integer num, @Nullable ToyConfigBean toyConfigBean) {
        this.dv = num;
        this.data = toyConfigBean;
    }

    public static /* synthetic */ ToyConfigRespBean copy$default(ToyConfigRespBean toyConfigRespBean, Integer num, ToyConfigBean toyConfigBean, int i, Object obj) {
        if ((i & 1) != 0) {
            num = toyConfigRespBean.dv;
        }
        if ((i & 2) != 0) {
            toyConfigBean = toyConfigRespBean.data;
        }
        return toyConfigRespBean.copy(num, toyConfigBean);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getDv() {
        return this.dv;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final ToyConfigBean getData() {
        return this.data;
    }

    @NotNull
    public final ToyConfigRespBean copy(@Nullable Integer dv, @Nullable ToyConfigBean data) {
        return new ToyConfigRespBean(dv, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToyConfigRespBean)) {
            return false;
        }
        ToyConfigRespBean toyConfigRespBean = (ToyConfigRespBean) other;
        return Intrinsics.areEqual(this.dv, toyConfigRespBean.dv) && Intrinsics.areEqual(this.data, toyConfigRespBean.data);
    }

    @Nullable
    public final ToyConfigBean getData() {
        return this.data;
    }

    @Nullable
    public final Integer getDv() {
        return this.dv;
    }

    public int hashCode() {
        Integer num = this.dv;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        ToyConfigBean toyConfigBean = this.data;
        return iHashCode + (toyConfigBean != null ? toyConfigBean.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ToyConfigRespBean(dv=" + this.dv + ", data=" + this.data + ')';
    }

    public /* synthetic */ ToyConfigRespBean(Integer num, ToyConfigBean toyConfigBean, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1 : num, (i & 2) != 0 ? null : toyConfigBean);
    }
}
