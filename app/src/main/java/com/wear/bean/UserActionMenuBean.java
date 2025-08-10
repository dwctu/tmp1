package com.wear.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserActionMenuBean.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0001(B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J7\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\n¨\u0006)"}, d2 = {"Lcom/wear/bean/UserActionMenuBean;", "Landroid/os/Parcelable;", "email", "", "nickname", "avatar", "friendType", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAvatar", "()Ljava/lang/String;", "getEmail", "getFriendType", "()I", "isLeaveGroup", "", "()Z", "setLeaveGroup", "(Z)V", "isMuteNotification", "setMuteNotification", "isTop", "setTop", "getNickname", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", DownloaderServiceMarshaller.PARAMS_FLAGS, "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UserActionMenuBean implements Parcelable {
    public static final int TYPE_FRIEND = 0;
    public static final int TYPE_GROUP = 1;
    public static final int TYPE_OFFICIAL = 2;

    @Nullable
    private final String avatar;

    @Nullable
    private final String email;
    private final int friendType;
    private boolean isLeaveGroup;
    private boolean isMuteNotification;
    private boolean isTop;

    @Nullable
    private final String nickname;

    @NotNull
    public static final Parcelable.Creator<UserActionMenuBean> CREATOR = new Creator();

    /* compiled from: UserActionMenuBean.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UserActionMenuBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserActionMenuBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UserActionMenuBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserActionMenuBean[] newArray(int i) {
            return new UserActionMenuBean[i];
        }
    }

    public UserActionMenuBean(@Nullable String str, @Nullable String str2, @Nullable String str3, int i) {
        this.email = str;
        this.nickname = str2;
        this.avatar = str3;
        this.friendType = i;
    }

    public static /* synthetic */ UserActionMenuBean copy$default(UserActionMenuBean userActionMenuBean, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = userActionMenuBean.email;
        }
        if ((i2 & 2) != 0) {
            str2 = userActionMenuBean.nickname;
        }
        if ((i2 & 4) != 0) {
            str3 = userActionMenuBean.avatar;
        }
        if ((i2 & 8) != 0) {
            i = userActionMenuBean.friendType;
        }
        return userActionMenuBean.copy(str, str2, str3, i);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: component4, reason: from getter */
    public final int getFriendType() {
        return this.friendType;
    }

    @NotNull
    public final UserActionMenuBean copy(@Nullable String email, @Nullable String nickname, @Nullable String avatar, int friendType) {
        return new UserActionMenuBean(email, nickname, avatar, friendType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserActionMenuBean)) {
            return false;
        }
        UserActionMenuBean userActionMenuBean = (UserActionMenuBean) other;
        return Intrinsics.areEqual(this.email, userActionMenuBean.email) && Intrinsics.areEqual(this.nickname, userActionMenuBean.nickname) && Intrinsics.areEqual(this.avatar, userActionMenuBean.avatar) && this.friendType == userActionMenuBean.friendType;
    }

    @Nullable
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getEmail() {
        return this.email;
    }

    public final int getFriendType() {
        return this.friendType;
    }

    @Nullable
    public final String getNickname() {
        return this.nickname;
    }

    public int hashCode() {
        String str = this.email;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.nickname;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.avatar;
        return ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.friendType;
    }

    /* renamed from: isLeaveGroup, reason: from getter */
    public final boolean getIsLeaveGroup() {
        return this.isLeaveGroup;
    }

    /* renamed from: isMuteNotification, reason: from getter */
    public final boolean getIsMuteNotification() {
        return this.isMuteNotification;
    }

    /* renamed from: isTop, reason: from getter */
    public final boolean getIsTop() {
        return this.isTop;
    }

    public final void setLeaveGroup(boolean z) {
        this.isLeaveGroup = z;
    }

    public final void setMuteNotification(boolean z) {
        this.isMuteNotification = z;
    }

    public final void setTop(boolean z) {
        this.isTop = z;
    }

    @NotNull
    public String toString() {
        return "UserActionMenuBean(email=" + this.email + ", nickname=" + this.nickname + ", avatar=" + this.avatar + ", friendType=" + this.friendType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.email);
        parcel.writeString(this.nickname);
        parcel.writeString(this.avatar);
        parcel.writeInt(this.friendType);
    }
}
