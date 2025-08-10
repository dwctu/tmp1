package com.wear.bean.me;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OnlineStatusFriendCheckParam.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ.\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/wear/bean/me/OnlineStatusFriendCheckParam;", "", "friend", "", "type", "", "open", "", "(Ljava/lang/String;ILjava/lang/Boolean;)V", "getFriend", "()Ljava/lang/String;", "setFriend", "(Ljava/lang/String;)V", "getOpen", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getType", "()I", "component1", "component2", "component3", "copy", "(Ljava/lang/String;ILjava/lang/Boolean;)Lcom/wear/bean/me/OnlineStatusFriendCheckParam;", "equals", "other", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class OnlineStatusFriendCheckParam {

    @NotNull
    private String friend;

    @Nullable
    private final Boolean open;
    private final int type;

    public OnlineStatusFriendCheckParam(@NotNull String friend, int i, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(friend, "friend");
        this.friend = friend;
        this.type = i;
        this.open = bool;
    }

    public static /* synthetic */ OnlineStatusFriendCheckParam copy$default(OnlineStatusFriendCheckParam onlineStatusFriendCheckParam, String str, int i, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = onlineStatusFriendCheckParam.friend;
        }
        if ((i2 & 2) != 0) {
            i = onlineStatusFriendCheckParam.type;
        }
        if ((i2 & 4) != 0) {
            bool = onlineStatusFriendCheckParam.open;
        }
        return onlineStatusFriendCheckParam.copy(str, i, bool);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getFriend() {
        return this.friend;
    }

    /* renamed from: component2, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Boolean getOpen() {
        return this.open;
    }

    @NotNull
    public final OnlineStatusFriendCheckParam copy(@NotNull String friend, int type, @Nullable Boolean open) {
        Intrinsics.checkNotNullParameter(friend, "friend");
        return new OnlineStatusFriendCheckParam(friend, type, open);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnlineStatusFriendCheckParam)) {
            return false;
        }
        OnlineStatusFriendCheckParam onlineStatusFriendCheckParam = (OnlineStatusFriendCheckParam) other;
        return Intrinsics.areEqual(this.friend, onlineStatusFriendCheckParam.friend) && this.type == onlineStatusFriendCheckParam.type && Intrinsics.areEqual(this.open, onlineStatusFriendCheckParam.open);
    }

    @NotNull
    public final String getFriend() {
        return this.friend;
    }

    @Nullable
    public final Boolean getOpen() {
        return this.open;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = ((this.friend.hashCode() * 31) + this.type) * 31;
        Boolean bool = this.open;
        return iHashCode + (bool == null ? 0 : bool.hashCode());
    }

    public final void setFriend(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.friend = str;
    }

    @NotNull
    public String toString() {
        return "OnlineStatusFriendCheckParam(friend=" + this.friend + ", type=" + this.type + ", open=" + this.open + ')';
    }

    public /* synthetic */ OnlineStatusFriendCheckParam(String str, int i, Boolean bool, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 4) != 0 ? null : bool);
    }
}
