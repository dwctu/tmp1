package com.component.dxtoy.core.toy.bean;

import com.google.gson.reflect.TypeToken;
import dc.xd0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyConfigRespBean.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/component/dxtoy/core/toy/bean/ToyConfigBean;", "", "info", "", "(Ljava/lang/String;)V", "configList", "", "Lcom/component/dxtoy/core/toy/bean/ToyConfigInfoBean;", "getConfigList", "()Ljava/util/List;", "setConfigList", "(Ljava/util/List;)V", "getInfo", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ToyConfigBean {

    @Nullable
    private List<ToyConfigInfoBean> configList;

    @Nullable
    private final String info;

    public ToyConfigBean() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ToyConfigBean(@Nullable String str) {
        this.info = str;
    }

    public static /* synthetic */ ToyConfigBean copy$default(ToyConfigBean toyConfigBean, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = toyConfigBean.info;
        }
        return toyConfigBean.copy(str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getInfo() {
        return this.info;
    }

    @NotNull
    public final ToyConfigBean copy(@Nullable String info) {
        return new ToyConfigBean(info);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ToyConfigBean) && Intrinsics.areEqual(this.info, ((ToyConfigBean) other).info);
    }

    @Nullable
    public final List<ToyConfigInfoBean> getConfigList() {
        List<ToyConfigInfoBean> list = this.configList;
        if (list == null || list.isEmpty()) {
            String str = this.info;
            if (!(str == null || str.length() == 0)) {
                this.configList = (List) xd0.e(this.info, new TypeToken<List<? extends ToyConfigInfoBean>>() { // from class: com.component.dxtoy.core.toy.bean.ToyConfigBean$configList$type$1
                }.getType());
            }
        }
        return this.configList;
    }

    @Nullable
    public final String getInfo() {
        return this.info;
    }

    public int hashCode() {
        String str = this.info;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final void setConfigList(@Nullable List<ToyConfigInfoBean> list) {
        this.configList = list;
    }

    @NotNull
    public String toString() {
        return "ToyConfigBean(info=" + this.info + ')';
    }

    public /* synthetic */ ToyConfigBean(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }
}
