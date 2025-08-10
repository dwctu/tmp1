package com.wear.bean;

import dc.tq;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConnectionBean.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003JC\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006!"}, d2 = {"Lcom/wear/bean/ConnectionUserBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "email", "", "name", "avatar", "desc", "onlineStatus", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAvatar", "()Ljava/lang/String;", "getDesc", "getEmail", "isOfficialAccount", "", "()Z", "itemType", "getItemType", "()I", "getName", "getOnlineStatus", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ConnectionUserBean implements tq {

    @Nullable
    private final String avatar;

    @Nullable
    private final String desc;

    @Nullable
    private final String email;

    @Nullable
    private final String name;
    private final int onlineStatus;

    public ConnectionUserBean(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i) {
        this.email = str;
        this.name = str2;
        this.avatar = str3;
        this.desc = str4;
        this.onlineStatus = i;
    }

    public static /* synthetic */ ConnectionUserBean copy$default(ConnectionUserBean connectionUserBean, String str, String str2, String str3, String str4, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = connectionUserBean.email;
        }
        if ((i2 & 2) != 0) {
            str2 = connectionUserBean.name;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = connectionUserBean.avatar;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = connectionUserBean.desc;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            i = connectionUserBean.onlineStatus;
        }
        return connectionUserBean.copy(str, str5, str6, str7, i);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: component5, reason: from getter */
    public final int getOnlineStatus() {
        return this.onlineStatus;
    }

    @NotNull
    public final ConnectionUserBean copy(@Nullable String email, @Nullable String name, @Nullable String avatar, @Nullable String desc, int onlineStatus) {
        return new ConnectionUserBean(email, name, avatar, desc, onlineStatus);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectionUserBean)) {
            return false;
        }
        ConnectionUserBean connectionUserBean = (ConnectionUserBean) other;
        return Intrinsics.areEqual(this.email, connectionUserBean.email) && Intrinsics.areEqual(this.name, connectionUserBean.name) && Intrinsics.areEqual(this.avatar, connectionUserBean.avatar) && Intrinsics.areEqual(this.desc, connectionUserBean.desc) && this.onlineStatus == connectionUserBean.onlineStatus;
    }

    @Nullable
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    @Nullable
    public final String getEmail() {
        return this.email;
    }

    @Override // dc.tq
    public int getItemType() {
        return 1;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public final int getOnlineStatus() {
        return this.onlineStatus;
    }

    public int hashCode() {
        String str = this.email;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.avatar;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.desc;
        return ((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.onlineStatus;
    }

    public final boolean isOfficialAccount() {
        return Intrinsics.areEqual(this.email, "lovenseRemoteOfficial");
    }

    @NotNull
    public String toString() {
        return "ConnectionUserBean(email=" + this.email + ", name=" + this.name + ", avatar=" + this.avatar + ", desc=" + this.desc + ", onlineStatus=" + this.onlineStatus + ')';
    }
}
