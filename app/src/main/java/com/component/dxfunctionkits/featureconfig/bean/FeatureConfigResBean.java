package com.component.dxfunctionkits.featureconfig.bean;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeatureConfigResBean.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ)\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0007HÆ\u0003JD\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032(\b\u0002\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0007HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R1\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/component/dxfunctionkits/featureconfig/bean/FeatureConfigResBean;", "", "dataVer", "", "data", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(Ljava/lang/Integer;Ljava/util/HashMap;)V", "getData", "()Ljava/util/HashMap;", "getDataVer", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/util/HashMap;)Lcom/component/dxfunctionkits/featureconfig/bean/FeatureConfigResBean;", "equals", "", "other", "hashCode", "toString", "featureConfig_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class FeatureConfigResBean {

    @Nullable
    private final HashMap<String, Integer> data;

    @Nullable
    private final Integer dataVer;

    public FeatureConfigResBean(@Nullable Integer num, @Nullable HashMap<String, Integer> map) {
        this.dataVer = num;
        this.data = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeatureConfigResBean copy$default(FeatureConfigResBean featureConfigResBean, Integer num, HashMap map, int i, Object obj) {
        if ((i & 1) != 0) {
            num = featureConfigResBean.dataVer;
        }
        if ((i & 2) != 0) {
            map = featureConfigResBean.data;
        }
        return featureConfigResBean.copy(num, map);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getDataVer() {
        return this.dataVer;
    }

    @Nullable
    public final HashMap<String, Integer> component2() {
        return this.data;
    }

    @NotNull
    public final FeatureConfigResBean copy(@Nullable Integer dataVer, @Nullable HashMap<String, Integer> data) {
        return new FeatureConfigResBean(dataVer, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeatureConfigResBean)) {
            return false;
        }
        FeatureConfigResBean featureConfigResBean = (FeatureConfigResBean) other;
        return Intrinsics.areEqual(this.dataVer, featureConfigResBean.dataVer) && Intrinsics.areEqual(this.data, featureConfigResBean.data);
    }

    @Nullable
    public final HashMap<String, Integer> getData() {
        return this.data;
    }

    @Nullable
    public final Integer getDataVer() {
        return this.dataVer;
    }

    public int hashCode() {
        Integer num = this.dataVer;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        HashMap<String, Integer> map = this.data;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "FeatureConfigResBean(dataVer=" + this.dataVer + ", data=" + this.data + ')';
    }
}
