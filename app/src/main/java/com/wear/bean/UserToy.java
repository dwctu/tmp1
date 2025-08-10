package com.wear.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import dc.tq;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FindMatchUserBean.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J&\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010 J\t\u0010!\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\"\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0011HÖ\u0001J\t\u0010&\u001a\u00020\u0004HÖ\u0001J\u0019\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\n\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\t¨\u0006,"}, d2 = {"Lcom/wear/bean/UserToy;", "Landroid/os/Parcelable;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "deviceType", "", "status", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "getDeviceType", "()Ljava/lang/String;", "isMore", "isMore$annotations", "()V", "()Z", "setMore", "(Z)V", "itemType", "", "getItemType", "()I", "getStatus", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "toyFirstName", "", "getToyFirstName", "()C", "toyName", "getToyName", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/wear/bean/UserToy;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", DownloaderServiceMarshaller.PARAMS_FLAGS, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UserToy implements Parcelable, tq {

    @NotNull
    public static final Parcelable.Creator<UserToy> CREATOR = new Creator();

    @Nullable
    private final String deviceType;
    private boolean isMore;

    @Nullable
    private final Boolean status;

    /* compiled from: FindMatchUserBean.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UserToy> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserToy createFromParcel(@NotNull Parcel parcel) {
            Boolean boolValueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new UserToy(string, boolValueOf);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserToy[] newArray(int i) {
            return new UserToy[i];
        }
    }

    public UserToy() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public UserToy(@Nullable String str, @Nullable Boolean bool) {
        this.deviceType = str;
        this.status = bool;
    }

    public static /* synthetic */ UserToy copy$default(UserToy userToy, String str, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userToy.deviceType;
        }
        if ((i & 2) != 0) {
            bool = userToy.status;
        }
        return userToy.copy(str, bool);
    }

    public static /* synthetic */ void isMore$annotations() {
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getDeviceType() {
        return this.deviceType;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Boolean getStatus() {
        return this.status;
    }

    @NotNull
    public final UserToy copy(@Nullable String deviceType, @Nullable Boolean status) {
        return new UserToy(deviceType, status);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserToy)) {
            return false;
        }
        UserToy userToy = (UserToy) other;
        return Intrinsics.areEqual(this.deviceType, userToy.deviceType) && Intrinsics.areEqual(this.status, userToy.status);
    }

    @Nullable
    public final String getDeviceType() {
        return this.deviceType;
    }

    @Override // dc.tq
    public int getItemType() {
        return this.isMore ? 1 : 0;
    }

    @Nullable
    public final Boolean getStatus() {
        return this.status;
    }

    public final char getToyFirstName() {
        return getToyName().charAt(0);
    }

    @NotNull
    public final String getToyName() {
        String lowerCase;
        List listSplit$default;
        String str;
        String str2 = this.deviceType;
        if (str2 == null || (listSplit$default = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{SignatureImpl.INNER_SEP}, false, 0, 6, (Object) null)) == null || (str = (String) listSplit$default.get(0)) == null) {
            lowerCase = null;
        } else {
            lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        }
        String str3 = Toy.NAME_MAP.get(Toy.generateType(lowerCase));
        return str3 == null ? "Unknown" : str3;
    }

    public int hashCode() {
        String str = this.deviceType;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.status;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    /* renamed from: isMore, reason: from getter */
    public final boolean getIsMore() {
        return this.isMore;
    }

    public final void setMore(boolean z) {
        this.isMore = z;
    }

    @NotNull
    public String toString() {
        return "UserToy(deviceType=" + this.deviceType + ", status=" + this.status + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        int iBooleanValue;
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.deviceType);
        Boolean bool = this.status;
        if (bool == null) {
            iBooleanValue = 0;
        } else {
            parcel.writeInt(1);
            iBooleanValue = bool.booleanValue();
        }
        parcel.writeInt(iBooleanValue);
    }

    public /* synthetic */ UserToy(String str, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? Boolean.FALSE : bool);
    }
}
