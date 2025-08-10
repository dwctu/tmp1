package com.wear.bean.me;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OnlineStatusFriendListResponse.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001R\u001b\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/wear/bean/me/OnlineStatusFriendListResponse;", "", "list", "", "", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class OnlineStatusFriendListResponse {

    @Nullable
    private final List<String> list;

    public OnlineStatusFriendListResponse(@Nullable List<String> list) {
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OnlineStatusFriendListResponse copy$default(OnlineStatusFriendListResponse onlineStatusFriendListResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = onlineStatusFriendListResponse.list;
        }
        return onlineStatusFriendListResponse.copy(list);
    }

    @Nullable
    public final List<String> component1() {
        return this.list;
    }

    @NotNull
    public final OnlineStatusFriendListResponse copy(@Nullable List<String> list) {
        return new OnlineStatusFriendListResponse(list);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof OnlineStatusFriendListResponse) && Intrinsics.areEqual(this.list, ((OnlineStatusFriendListResponse) other).list);
    }

    @Nullable
    public final List<String> getList() {
        return this.list;
    }

    public int hashCode() {
        List<String> list = this.list;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        return "OnlineStatusFriendListResponse(list=" + this.list + ')';
    }
}
