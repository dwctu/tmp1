package com.wear.bean;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RouletteItemSelectBean.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/wear/bean/RouletteItemSelectBean;", "", "text", "", NotificationCompat.CATEGORY_SERVICE, "isSelected", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "setSelected", "(Z)V", "getService", "()Ljava/lang/String;", "getText", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RouletteItemSelectBean {
    private boolean isSelected;

    @NotNull
    private final String service;

    @NotNull
    private final String text;

    public RouletteItemSelectBean(@NotNull String text, @NotNull String service, boolean z) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(service, "service");
        this.text = text;
        this.service = service;
        this.isSelected = z;
    }

    public static /* synthetic */ RouletteItemSelectBean copy$default(RouletteItemSelectBean rouletteItemSelectBean, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rouletteItemSelectBean.text;
        }
        if ((i & 2) != 0) {
            str2 = rouletteItemSelectBean.service;
        }
        if ((i & 4) != 0) {
            z = rouletteItemSelectBean.isSelected;
        }
        return rouletteItemSelectBean.copy(str, str2, z);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getService() {
        return this.service;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    @NotNull
    public final RouletteItemSelectBean copy(@NotNull String text, @NotNull String service, boolean isSelected) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(service, "service");
        return new RouletteItemSelectBean(text, service, isSelected);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RouletteItemSelectBean)) {
            return false;
        }
        RouletteItemSelectBean rouletteItemSelectBean = (RouletteItemSelectBean) other;
        return Intrinsics.areEqual(this.text, rouletteItemSelectBean.text) && Intrinsics.areEqual(this.service, rouletteItemSelectBean.service) && this.isSelected == rouletteItemSelectBean.isSelected;
    }

    @NotNull
    public final String getService() {
        return this.service;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((this.text.hashCode() * 31) + this.service.hashCode()) * 31;
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
        return "RouletteItemSelectBean(text=" + this.text + ", service=" + this.service + ", isSelected=" + this.isSelected + ')';
    }
}
