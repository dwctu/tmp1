package com.wear.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MutliSelectWrapperBean.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/wear/bean/MutliSelectWrapperBean;", "", "functionName", "", "isSupport", "", "(Ljava/lang/String;Z)V", "getFunctionName", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MutliSelectWrapperBean {

    @NotNull
    private final String functionName;
    private final boolean isSupport;

    public MutliSelectWrapperBean(@NotNull String functionName, boolean z) {
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        this.functionName = functionName;
        this.isSupport = z;
    }

    public static /* synthetic */ MutliSelectWrapperBean copy$default(MutliSelectWrapperBean mutliSelectWrapperBean, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mutliSelectWrapperBean.functionName;
        }
        if ((i & 2) != 0) {
            z = mutliSelectWrapperBean.isSupport;
        }
        return mutliSelectWrapperBean.copy(str, z);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getFunctionName() {
        return this.functionName;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsSupport() {
        return this.isSupport;
    }

    @NotNull
    public final MutliSelectWrapperBean copy(@NotNull String functionName, boolean isSupport) {
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        return new MutliSelectWrapperBean(functionName, isSupport);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MutliSelectWrapperBean)) {
            return false;
        }
        MutliSelectWrapperBean mutliSelectWrapperBean = (MutliSelectWrapperBean) other;
        return Intrinsics.areEqual(this.functionName, mutliSelectWrapperBean.functionName) && this.isSupport == mutliSelectWrapperBean.isSupport;
    }

    @NotNull
    public final String getFunctionName() {
        return this.functionName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = this.functionName.hashCode() * 31;
        boolean z = this.isSupport;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public final boolean isSupport() {
        return this.isSupport;
    }

    @NotNull
    public String toString() {
        return "MutliSelectWrapperBean(functionName=" + this.functionName + ", isSupport=" + this.isSupport + ')';
    }
}
