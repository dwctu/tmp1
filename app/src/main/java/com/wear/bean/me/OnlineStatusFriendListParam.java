package com.wear.bean.me;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OnlineStatusFriendListParam.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u001b\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/wear/bean/me/OnlineStatusFriendListParam;", "", "friends", "", "", "type", "", "(Ljava/util/List;I)V", "getFriends", "()Ljava/util/List;", "getType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class OnlineStatusFriendListParam {

    @Nullable
    private final List<String> friends;
    private final int type;

    public OnlineStatusFriendListParam(@Nullable List<String> list, int i) {
        this.friends = list;
        this.type = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OnlineStatusFriendListParam copy$default(OnlineStatusFriendListParam onlineStatusFriendListParam, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = onlineStatusFriendListParam.friends;
        }
        if ((i2 & 2) != 0) {
            i = onlineStatusFriendListParam.type;
        }
        return onlineStatusFriendListParam.copy(list, i);
    }

    @Nullable
    public final List<String> component1() {
        return this.friends;
    }

    /* renamed from: component2, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    public final OnlineStatusFriendListParam copy(@Nullable List<String> friends, int type) {
        return new OnlineStatusFriendListParam(friends, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnlineStatusFriendListParam)) {
            return false;
        }
        OnlineStatusFriendListParam onlineStatusFriendListParam = (OnlineStatusFriendListParam) other;
        return Intrinsics.areEqual(this.friends, onlineStatusFriendListParam.friends) && this.type == onlineStatusFriendListParam.type;
    }

    @Nullable
    public final List<String> getFriends() {
        return this.friends;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        List<String> list = this.friends;
        return ((list == null ? 0 : list.hashCode()) * 31) + this.type;
    }

    @NotNull
    public String toString() {
        return "OnlineStatusFriendListParam(friends=" + this.friends + ", type=" + this.type + ')';
    }
}
