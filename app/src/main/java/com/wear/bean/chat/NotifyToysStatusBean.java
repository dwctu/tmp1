package com.wear.bean.chat;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NotifyClientonLineBean.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/wear/bean/chat/NotifyToysStatusBean;", "", "appAccountCode", "", "roomId", "toys", "", "Lcom/wear/bean/chat/ToyInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAppAccountCode", "()Ljava/lang/String;", "getRoomId", "getToys", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class NotifyToysStatusBean {

    @Nullable
    private final String appAccountCode;

    @Nullable
    private final String roomId;

    @Nullable
    private final List<ToyInfo> toys;

    public NotifyToysStatusBean() {
        this(null, null, null, 7, null);
    }

    public NotifyToysStatusBean(@Nullable String str, @Nullable String str2, @Nullable List<ToyInfo> list) {
        this.appAccountCode = str;
        this.roomId = str2;
        this.toys = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NotifyToysStatusBean copy$default(NotifyToysStatusBean notifyToysStatusBean, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = notifyToysStatusBean.appAccountCode;
        }
        if ((i & 2) != 0) {
            str2 = notifyToysStatusBean.roomId;
        }
        if ((i & 4) != 0) {
            list = notifyToysStatusBean.toys;
        }
        return notifyToysStatusBean.copy(str, str2, list);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getAppAccountCode() {
        return this.appAccountCode;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    @Nullable
    public final List<ToyInfo> component3() {
        return this.toys;
    }

    @NotNull
    public final NotifyToysStatusBean copy(@Nullable String appAccountCode, @Nullable String roomId, @Nullable List<ToyInfo> toys) {
        return new NotifyToysStatusBean(appAccountCode, roomId, toys);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotifyToysStatusBean)) {
            return false;
        }
        NotifyToysStatusBean notifyToysStatusBean = (NotifyToysStatusBean) other;
        return Intrinsics.areEqual(this.appAccountCode, notifyToysStatusBean.appAccountCode) && Intrinsics.areEqual(this.roomId, notifyToysStatusBean.roomId) && Intrinsics.areEqual(this.toys, notifyToysStatusBean.toys);
    }

    @Nullable
    public final String getAppAccountCode() {
        return this.appAccountCode;
    }

    @Nullable
    public final String getRoomId() {
        return this.roomId;
    }

    @Nullable
    public final List<ToyInfo> getToys() {
        return this.toys;
    }

    public int hashCode() {
        String str = this.appAccountCode;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.roomId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<ToyInfo> list = this.toys;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "NotifyToysStatusBean(appAccountCode=" + this.appAccountCode + ", roomId=" + this.roomId + ", toys=" + this.toys + ')';
    }

    public /* synthetic */ NotifyToysStatusBean(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list);
    }
}
