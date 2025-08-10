package com.wear.bean.chat;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: RouletteUser.kt */
@DatabaseTable(tableName = "tb_user_roulette")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/wear/bean/chat/RouletteUser;", "", "()V", "friendId", "", "getFriendId", "()Ljava/lang/String;", "setFriendId", "(Ljava/lang/String;)V", "isOfflineBefore", "", "()Z", "setOfflineBefore", "(Z)V", "publicKey", "getPublicKey", "setPublicKey", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RouletteUser {

    @DatabaseField(columnName = "friend_id", id = true)
    @Nullable
    private String friendId;

    @DatabaseField(columnName = "can_insert_reconnect_msg")
    private boolean isOfflineBefore = true;

    @DatabaseField(columnName = "public_key")
    @Nullable
    private String publicKey;

    @Nullable
    public final String getFriendId() {
        return this.friendId;
    }

    @Nullable
    public final String getPublicKey() {
        return this.publicKey;
    }

    /* renamed from: isOfflineBefore, reason: from getter */
    public final boolean getIsOfflineBefore() {
        return this.isOfflineBefore;
    }

    public final void setFriendId(@Nullable String str) {
        this.friendId = str;
    }

    public final void setOfflineBefore(boolean z) {
        this.isOfflineBefore = z;
    }

    public final void setPublicKey(@Nullable String str) {
        this.publicKey = str;
    }
}
