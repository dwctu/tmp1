package com.wear.bean.me;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OnlineStatusUserBean.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B7\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0013\u0010\u001f\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001a\u00020\u001eH\u0016J\t\u0010#\u001a\u00020\u0006HÖ\u0001J\u0018\u0010$\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u001eH\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\r¨\u0006("}, d2 = {"Lcom/wear/bean/me/OnlineStatusUserBean;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "email", "", "showName", "nickname", "remark", "avatar", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getEmail", "isSelected", "", "()Z", "setSelected", "(Z)V", "getNickname", "getRemark", "getShowName", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", DownloaderServiceMarshaller.PARAMS_FLAGS, "CREATOR", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class OnlineStatusUserBean implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final String avatar;

    @Nullable
    private final String email;
    private boolean isSelected;

    @Nullable
    private final String nickname;

    @Nullable
    private final String remark;

    @Nullable
    private final String showName;

    /* compiled from: OnlineStatusUserBean.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/wear/bean/me/OnlineStatusUserBean$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/wear/bean/me/OnlineStatusUserBean;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/wear/bean/me/OnlineStatusUserBean;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.wear.bean.me.OnlineStatusUserBean$CREATOR, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<OnlineStatusUserBean> {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public OnlineStatusUserBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OnlineStatusUserBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public OnlineStatusUserBean[] newArray(int size) {
            return new OnlineStatusUserBean[size];
        }
    }

    public OnlineStatusUserBean(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.email = str;
        this.showName = str2;
        this.nickname = str3;
        this.remark = str4;
        this.avatar = str5;
    }

    public static /* synthetic */ OnlineStatusUserBean copy$default(OnlineStatusUserBean onlineStatusUserBean, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = onlineStatusUserBean.email;
        }
        if ((i & 2) != 0) {
            str2 = onlineStatusUserBean.showName;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = onlineStatusUserBean.nickname;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = onlineStatusUserBean.remark;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = onlineStatusUserBean.avatar;
        }
        return onlineStatusUserBean.copy(str, str6, str7, str8, str5);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getShowName() {
        return this.showName;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getRemark() {
        return this.remark;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final OnlineStatusUserBean copy(@Nullable String email, @Nullable String showName, @Nullable String nickname, @Nullable String remark, @Nullable String avatar) {
        return new OnlineStatusUserBean(email, showName, nickname, remark, avatar);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(OnlineStatusUserBean.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.wear.bean.me.OnlineStatusUserBean");
        return Intrinsics.areEqual(this.email, ((OnlineStatusUserBean) other).email);
    }

    @Nullable
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getEmail() {
        return this.email;
    }

    @Nullable
    public final String getNickname() {
        return this.nickname;
    }

    @Nullable
    public final String getRemark() {
        return this.remark;
    }

    @Nullable
    public final String getShowName() {
        return this.showName;
    }

    public int hashCode() {
        String str = this.email;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    /* renamed from: isSelected, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    @NotNull
    public String toString() {
        return "OnlineStatusUserBean(email=" + this.email + ", showName=" + this.showName + ", nickname=" + this.nickname + ", remark=" + this.remark + ", avatar=" + this.avatar + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.email);
        parcel.writeString(this.showName);
        parcel.writeString(this.nickname);
        parcel.writeString(this.remark);
        parcel.writeString(this.avatar);
        parcel.writeByte(this.isSelected ? (byte) 1 : (byte) 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OnlineStatusUserBean(@NotNull Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.isSelected = parcel.readByte() != 0;
    }
}
