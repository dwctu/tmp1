package com.wear.bean.chat;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NotifyClientonLineBean.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/wear/bean/chat/NotifyClientLineTcBean;", "", "targetAccountCode", "", "appAccountCode", "panelStatus", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppAccountCode", "()Ljava/lang/String;", "getPanelStatus", "getTargetAccountCode", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class NotifyClientLineTcBean {

    @Nullable
    private final String appAccountCode;

    @NotNull
    private final String panelStatus;

    @Nullable
    private final String targetAccountCode;

    public NotifyClientLineTcBean(@Nullable String str, @Nullable String str2, @NotNull String panelStatus) {
        Intrinsics.checkNotNullParameter(panelStatus, "panelStatus");
        this.targetAccountCode = str;
        this.appAccountCode = str2;
        this.panelStatus = panelStatus;
    }

    public static /* synthetic */ NotifyClientLineTcBean copy$default(NotifyClientLineTcBean notifyClientLineTcBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = notifyClientLineTcBean.targetAccountCode;
        }
        if ((i & 2) != 0) {
            str2 = notifyClientLineTcBean.appAccountCode;
        }
        if ((i & 4) != 0) {
            str3 = notifyClientLineTcBean.panelStatus;
        }
        return notifyClientLineTcBean.copy(str, str2, str3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getTargetAccountCode() {
        return this.targetAccountCode;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getAppAccountCode() {
        return this.appAccountCode;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getPanelStatus() {
        return this.panelStatus;
    }

    @NotNull
    public final NotifyClientLineTcBean copy(@Nullable String targetAccountCode, @Nullable String appAccountCode, @NotNull String panelStatus) {
        Intrinsics.checkNotNullParameter(panelStatus, "panelStatus");
        return new NotifyClientLineTcBean(targetAccountCode, appAccountCode, panelStatus);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotifyClientLineTcBean)) {
            return false;
        }
        NotifyClientLineTcBean notifyClientLineTcBean = (NotifyClientLineTcBean) other;
        return Intrinsics.areEqual(this.targetAccountCode, notifyClientLineTcBean.targetAccountCode) && Intrinsics.areEqual(this.appAccountCode, notifyClientLineTcBean.appAccountCode) && Intrinsics.areEqual(this.panelStatus, notifyClientLineTcBean.panelStatus);
    }

    @Nullable
    public final String getAppAccountCode() {
        return this.appAccountCode;
    }

    @NotNull
    public final String getPanelStatus() {
        return this.panelStatus;
    }

    @Nullable
    public final String getTargetAccountCode() {
        return this.targetAccountCode;
    }

    public int hashCode() {
        String str = this.targetAccountCode;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.appAccountCode;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.panelStatus.hashCode();
    }

    @NotNull
    public String toString() {
        return "NotifyClientLineTcBean(targetAccountCode=" + this.targetAccountCode + ", appAccountCode=" + this.appAccountCode + ", panelStatus=" + this.panelStatus + ')';
    }

    public /* synthetic */ NotifyClientLineTcBean(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? "" : str3);
    }
}
