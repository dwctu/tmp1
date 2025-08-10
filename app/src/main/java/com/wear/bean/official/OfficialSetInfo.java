package com.wear.bean.official;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OfficialSetInfo.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/wear/bean/official/OfficialSetInfo;", "", "officialMsgMuteNotification", "", "stickyToTop", "(ZZ)V", "getOfficialMsgMuteNotification", "()Z", "setOfficialMsgMuteNotification", "(Z)V", "getStickyToTop", "setStickyToTop", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class OfficialSetInfo {
    private boolean officialMsgMuteNotification;
    private boolean stickyToTop;

    /* JADX WARN: Illegal instructions before constructor call */
    public OfficialSetInfo() {
        boolean z = false;
        this(z, z, 3, null);
    }

    public OfficialSetInfo(boolean z, boolean z2) {
        this.officialMsgMuteNotification = z;
        this.stickyToTop = z2;
    }

    public static /* synthetic */ OfficialSetInfo copy$default(OfficialSetInfo officialSetInfo, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = officialSetInfo.officialMsgMuteNotification;
        }
        if ((i & 2) != 0) {
            z2 = officialSetInfo.stickyToTop;
        }
        return officialSetInfo.copy(z, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getOfficialMsgMuteNotification() {
        return this.officialMsgMuteNotification;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getStickyToTop() {
        return this.stickyToTop;
    }

    @NotNull
    public final OfficialSetInfo copy(boolean officialMsgMuteNotification, boolean stickyToTop) {
        return new OfficialSetInfo(officialMsgMuteNotification, stickyToTop);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfficialSetInfo)) {
            return false;
        }
        OfficialSetInfo officialSetInfo = (OfficialSetInfo) other;
        return this.officialMsgMuteNotification == officialSetInfo.officialMsgMuteNotification && this.stickyToTop == officialSetInfo.stickyToTop;
    }

    public final boolean getOfficialMsgMuteNotification() {
        return this.officialMsgMuteNotification;
    }

    public final boolean getStickyToTop() {
        return this.stickyToTop;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.officialMsgMuteNotification;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.stickyToTop;
        return i + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final void setOfficialMsgMuteNotification(boolean z) {
        this.officialMsgMuteNotification = z;
    }

    public final void setStickyToTop(boolean z) {
        this.stickyToTop = z;
    }

    @NotNull
    public String toString() {
        return "OfficialSetInfo(officialMsgMuteNotification=" + this.officialMsgMuteNotification + ", stickyToTop=" + this.stickyToTop + ')';
    }

    public /* synthetic */ OfficialSetInfo(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }
}
