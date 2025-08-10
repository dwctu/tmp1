package com.component.dxtoy.update.bean;

import com.epicgames.unreal.psoservices.PSOProgramService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyUpdateReqBean.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/component/dxtoy/update/bean/ToyUpdateReqBean;", "", PSOProgramService.VS_Key, "", "(Ljava/lang/String;)V", "getV", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ToyUpdateReqBean {

    @NotNull
    private final String v;

    public ToyUpdateReqBean(@NotNull String v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.v = v;
    }

    public static /* synthetic */ ToyUpdateReqBean copy$default(ToyUpdateReqBean toyUpdateReqBean, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = toyUpdateReqBean.v;
        }
        return toyUpdateReqBean.copy(str);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getV() {
        return this.v;
    }

    @NotNull
    public final ToyUpdateReqBean copy(@NotNull String v) {
        Intrinsics.checkNotNullParameter(v, "v");
        return new ToyUpdateReqBean(v);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ToyUpdateReqBean) && Intrinsics.areEqual(this.v, ((ToyUpdateReqBean) other).v);
    }

    @NotNull
    public final String getV() {
        return this.v;
    }

    public int hashCode() {
        return this.v.hashCode();
    }

    @NotNull
    public String toString() {
        return "ToyUpdateReqBean(v=" + this.v + ')';
    }
}
