package com.wear.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UIDemoShadowBean.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/wear/bean/UIDemoShadowBean;", "", "name", "", "resIds", "", "(Ljava/lang/String;I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getResIds", "()I", "setResIds", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UIDemoShadowBean {

    @NotNull
    private String name;
    private int resIds;

    public UIDemoShadowBean(@NotNull String name, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.resIds = i;
    }

    public static /* synthetic */ UIDemoShadowBean copy$default(UIDemoShadowBean uIDemoShadowBean, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = uIDemoShadowBean.name;
        }
        if ((i2 & 2) != 0) {
            i = uIDemoShadowBean.resIds;
        }
        return uIDemoShadowBean.copy(str, i);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final int getResIds() {
        return this.resIds;
    }

    @NotNull
    public final UIDemoShadowBean copy(@NotNull String name, int resIds) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new UIDemoShadowBean(name, resIds);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UIDemoShadowBean)) {
            return false;
        }
        UIDemoShadowBean uIDemoShadowBean = (UIDemoShadowBean) other;
        return Intrinsics.areEqual(this.name, uIDemoShadowBean.name) && this.resIds == uIDemoShadowBean.resIds;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getResIds() {
        return this.resIds;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.resIds;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setResIds(int i) {
        this.resIds = i;
    }

    @NotNull
    public String toString() {
        return "UIDemoShadowBean(name=" + this.name + ", resIds=" + this.resIds + ')';
    }
}
