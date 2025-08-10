package com.wear.bean.chat;

import androidx.browser.customtabs.CustomTabsCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NotifyClientonLineBean.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J:\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\bHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/wear/bean/chat/NotifyClientonLineBean;", "", CustomTabsCallback.ONLINE_EXTRAS_KEY, "", "toys", "", "Lcom/wear/bean/chat/ToyInfo;", "userAccountCode", "", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;)V", "getOnline", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getToys", "()Ljava/util/List;", "getUserAccountCode", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;)Lcom/wear/bean/chat/NotifyClientonLineBean;", "equals", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class NotifyClientonLineBean {

    @Nullable
    private final Boolean online;

    @Nullable
    private final List<ToyInfo> toys;

    @Nullable
    private final String userAccountCode;

    public NotifyClientonLineBean() {
        this(null, null, null, 7, null);
    }

    public NotifyClientonLineBean(@Nullable Boolean bool, @Nullable List<ToyInfo> list, @Nullable String str) {
        this.online = bool;
        this.toys = list;
        this.userAccountCode = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NotifyClientonLineBean copy$default(NotifyClientonLineBean notifyClientonLineBean, Boolean bool, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = notifyClientonLineBean.online;
        }
        if ((i & 2) != 0) {
            list = notifyClientonLineBean.toys;
        }
        if ((i & 4) != 0) {
            str = notifyClientonLineBean.userAccountCode;
        }
        return notifyClientonLineBean.copy(bool, list, str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Boolean getOnline() {
        return this.online;
    }

    @Nullable
    public final List<ToyInfo> component2() {
        return this.toys;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getUserAccountCode() {
        return this.userAccountCode;
    }

    @NotNull
    public final NotifyClientonLineBean copy(@Nullable Boolean online, @Nullable List<ToyInfo> toys, @Nullable String userAccountCode) {
        return new NotifyClientonLineBean(online, toys, userAccountCode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotifyClientonLineBean)) {
            return false;
        }
        NotifyClientonLineBean notifyClientonLineBean = (NotifyClientonLineBean) other;
        return Intrinsics.areEqual(this.online, notifyClientonLineBean.online) && Intrinsics.areEqual(this.toys, notifyClientonLineBean.toys) && Intrinsics.areEqual(this.userAccountCode, notifyClientonLineBean.userAccountCode);
    }

    @Nullable
    public final Boolean getOnline() {
        return this.online;
    }

    @Nullable
    public final List<ToyInfo> getToys() {
        return this.toys;
    }

    @Nullable
    public final String getUserAccountCode() {
        return this.userAccountCode;
    }

    public int hashCode() {
        Boolean bool = this.online;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        List<ToyInfo> list = this.toys;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.userAccountCode;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "NotifyClientonLineBean(online=" + this.online + ", toys=" + this.toys + ", userAccountCode=" + this.userAccountCode + ')';
    }

    public /* synthetic */ NotifyClientonLineBean(Boolean bool, List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : str);
    }
}
