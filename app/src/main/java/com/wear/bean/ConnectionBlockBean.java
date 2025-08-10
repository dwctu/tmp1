package com.wear.bean;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import dc.tq;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConnectionBean.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\u0006\u0010\u001b\u001a\u00020\u001cJC\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0011HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000b¨\u0006#"}, d2 = {"Lcom/wear/bean/ConnectionBlockBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", TtmlNode.ATTR_ID, "", "name", "remarks", "avatar", "isFriend", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getAvatar", "()Ljava/lang/String;", "getId", "()Z", "setFriend", "(Z)V", "itemType", "", "getItemType", "()I", "getName", "getRemarks", "component1", "component2", "component3", "component4", "component5", "convertBlockFriend", "Lcom/wear/bean/BlockFriend;", "copy", "equals", "other", "", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ConnectionBlockBean implements tq {

    @Nullable
    private final String avatar;

    @Nullable
    private final String id;
    private boolean isFriend;

    @Nullable
    private final String name;

    @Nullable
    private final String remarks;

    public ConnectionBlockBean(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, boolean z) {
        this.id = str;
        this.name = str2;
        this.remarks = str3;
        this.avatar = str4;
        this.isFriend = z;
    }

    public static /* synthetic */ ConnectionBlockBean copy$default(ConnectionBlockBean connectionBlockBean, String str, String str2, String str3, String str4, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = connectionBlockBean.id;
        }
        if ((i & 2) != 0) {
            str2 = connectionBlockBean.name;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = connectionBlockBean.remarks;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = connectionBlockBean.avatar;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            z = connectionBlockBean.isFriend;
        }
        return connectionBlockBean.copy(str, str5, str6, str7, z);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getRemarks() {
        return this.remarks;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsFriend() {
        return this.isFriend;
    }

    @NotNull
    public final BlockFriend convertBlockFriend() {
        return new BlockFriend(this.id, this.name, this.remarks, this.avatar, this.isFriend);
    }

    @NotNull
    public final ConnectionBlockBean copy(@Nullable String id, @Nullable String name, @Nullable String remarks, @Nullable String avatar, boolean isFriend) {
        return new ConnectionBlockBean(id, name, remarks, avatar, isFriend);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectionBlockBean)) {
            return false;
        }
        ConnectionBlockBean connectionBlockBean = (ConnectionBlockBean) other;
        return Intrinsics.areEqual(this.id, connectionBlockBean.id) && Intrinsics.areEqual(this.name, connectionBlockBean.name) && Intrinsics.areEqual(this.remarks, connectionBlockBean.remarks) && Intrinsics.areEqual(this.avatar, connectionBlockBean.avatar) && this.isFriend == connectionBlockBean.isFriend;
    }

    @Nullable
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Override // dc.tq
    public int getItemType() {
        return 1;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getRemarks() {
        return this.remarks;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.remarks;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.avatar;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        boolean z = this.isFriend;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode4 + i;
    }

    public final boolean isFriend() {
        return this.isFriend;
    }

    public final void setFriend(boolean z) {
        this.isFriend = z;
    }

    @NotNull
    public String toString() {
        return "ConnectionBlockBean(id=" + this.id + ", name=" + this.name + ", remarks=" + this.remarks + ", avatar=" + this.avatar + ", isFriend=" + this.isFriend + ')';
    }
}
