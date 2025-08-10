package com.wear.bean;

import dc.tq;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConnectionBean.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/wear/bean/ConnectionGroupBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "email", "", "name", "avatar", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getEmail", "itemType", "", "getItemType", "()I", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ConnectionGroupBean implements tq {

    @Nullable
    private final String avatar;

    @Nullable
    private final String email;

    @Nullable
    private final String name;

    public ConnectionGroupBean(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.email = str;
        this.name = str2;
        this.avatar = str3;
    }

    public static /* synthetic */ ConnectionGroupBean copy$default(ConnectionGroupBean connectionGroupBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = connectionGroupBean.email;
        }
        if ((i & 2) != 0) {
            str2 = connectionGroupBean.name;
        }
        if ((i & 4) != 0) {
            str3 = connectionGroupBean.avatar;
        }
        return connectionGroupBean.copy(str, str2, str3);
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

    @NotNull
    public final ConnectionGroupBean copy(@Nullable String email, @Nullable String name, @Nullable String avatar) {
        return new ConnectionGroupBean(email, name, avatar);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectionGroupBean)) {
            return false;
        }
        ConnectionGroupBean connectionGroupBean = (ConnectionGroupBean) other;
        return Intrinsics.areEqual(this.email, connectionGroupBean.email) && Intrinsics.areEqual(this.name, connectionGroupBean.name) && Intrinsics.areEqual(this.avatar, connectionGroupBean.avatar);
    }

    @Nullable
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getEmail() {
        return this.email;
    }

    @Override // dc.tq
    public int getItemType() {
        return 2;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.email;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.avatar;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ConnectionGroupBean(email=" + this.email + ", name=" + this.name + ", avatar=" + this.avatar + ')';
    }
}
