package com.component.dxtoy.update.bean;

import com.epicgames.unreal.psoservices.PSOProgramService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyDegradeReqBean.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/component/dxtoy/update/bean/ToyDegradeReqBean;", "", PSOProgramService.VS_Key, "", "degradeVer", "(Ljava/lang/String;Ljava/lang/String;)V", "getDegradeVer", "()Ljava/lang/String;", "getV", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ToyDegradeReqBean {

    @NotNull
    private final String degradeVer;

    @NotNull
    private final String v;

    public ToyDegradeReqBean(@NotNull String v, @NotNull String degradeVer) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(degradeVer, "degradeVer");
        this.v = v;
        this.degradeVer = degradeVer;
    }

    public static /* synthetic */ ToyDegradeReqBean copy$default(ToyDegradeReqBean toyDegradeReqBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = toyDegradeReqBean.v;
        }
        if ((i & 2) != 0) {
            str2 = toyDegradeReqBean.degradeVer;
        }
        return toyDegradeReqBean.copy(str, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getV() {
        return this.v;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getDegradeVer() {
        return this.degradeVer;
    }

    @NotNull
    public final ToyDegradeReqBean copy(@NotNull String v, @NotNull String degradeVer) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(degradeVer, "degradeVer");
        return new ToyDegradeReqBean(v, degradeVer);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToyDegradeReqBean)) {
            return false;
        }
        ToyDegradeReqBean toyDegradeReqBean = (ToyDegradeReqBean) other;
        return Intrinsics.areEqual(this.v, toyDegradeReqBean.v) && Intrinsics.areEqual(this.degradeVer, toyDegradeReqBean.degradeVer);
    }

    @NotNull
    public final String getDegradeVer() {
        return this.degradeVer;
    }

    @NotNull
    public final String getV() {
        return this.v;
    }

    public int hashCode() {
        return (this.v.hashCode() * 31) + this.degradeVer.hashCode();
    }

    @NotNull
    public String toString() {
        return "ToyDegradeReqBean(v=" + this.v + ", degradeVer=" + this.degradeVer + ')';
    }
}
