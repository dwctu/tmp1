package com.wear.bean.me;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OnlineStatusHeadBean.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/wear/bean/me/OnlineStatusHeadBean;", "", "text", "", "icon", "", "isSelected", "", "(Ljava/lang/String;IZ)V", "getIcon", "()I", "()Z", "setSelected", "(Z)V", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class OnlineStatusHeadBean {
    private final int icon;
    private boolean isSelected;

    @NotNull
    private final String text;

    public OnlineStatusHeadBean(@NotNull String text, int i, boolean z) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.icon = i;
        this.isSelected = z;
    }

    public static /* synthetic */ OnlineStatusHeadBean copy$default(OnlineStatusHeadBean onlineStatusHeadBean, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = onlineStatusHeadBean.text;
        }
        if ((i2 & 2) != 0) {
            i = onlineStatusHeadBean.icon;
        }
        if ((i2 & 4) != 0) {
            z = onlineStatusHeadBean.isSelected;
        }
        return onlineStatusHeadBean.copy(str, i, z);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component2, reason: from getter */
    public final int getIcon() {
        return this.icon;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    @NotNull
    public final OnlineStatusHeadBean copy(@NotNull String text, int icon, boolean isSelected) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new OnlineStatusHeadBean(text, icon, isSelected);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnlineStatusHeadBean)) {
            return false;
        }
        OnlineStatusHeadBean onlineStatusHeadBean = (OnlineStatusHeadBean) other;
        return Intrinsics.areEqual(this.text, onlineStatusHeadBean.text) && this.icon == onlineStatusHeadBean.icon && this.isSelected == onlineStatusHeadBean.isSelected;
    }

    public final int getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((this.text.hashCode() * 31) + this.icon) * 31;
        boolean z = this.isSelected;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    @NotNull
    public String toString() {
        return "OnlineStatusHeadBean(text=" + this.text + ", icon=" + this.icon + ", isSelected=" + this.isSelected + ')';
    }

    public /* synthetic */ OnlineStatusHeadBean(String str, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 4) != 0 ? false : z);
    }
}
