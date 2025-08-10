package com.component.dxbilog.lib.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import dc.me0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogUserConfig.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0013HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/component/dxbilog/lib/bean/BILogUserConfig;", "Landroid/os/Parcelable;", "accountCode", "", "disableUser", "", "(Ljava/lang/String;Z)V", "getAccountCode", "()Ljava/lang/String;", "setAccountCode", "(Ljava/lang/String;)V", "getDisableUser", "()Z", "setDisableUser", "(Z)V", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", DownloaderServiceMarshaller.PARAMS_FLAGS, "Companion", "dxRouter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class BILogUserConfig implements Parcelable {

    @NotNull
    private static final String SP_BILOG_USER_CONFIG = "sp_bilog_user_config";

    @NotNull
    private String accountCode;
    private boolean disableUser;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<BILogUserConfig> CREATOR = new Creator();

    /* compiled from: BILogUserConfig.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/component/dxbilog/lib/bean/BILogUserConfig$Companion;", "", "()V", "SP_BILOG_USER_CONFIG", "", "load", "Lcom/component/dxbilog/lib/bean/BILogUserConfig;", "accountCode", "save", "", "config", "dxRouter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final BILogUserConfig load(@Nullable String accountCode) {
            return (BILogUserConfig) me0.d(Intrinsics.stringPlus(BILogUserConfig.SP_BILOG_USER_CONFIG, accountCode), BILogUserConfig.class);
        }

        public final void save(@NotNull BILogUserConfig config) {
            Intrinsics.checkNotNullParameter(config, "config");
            me0.i(Intrinsics.stringPlus(BILogUserConfig.SP_BILOG_USER_CONFIG, config.getAccountCode()), config);
        }
    }

    /* compiled from: BILogUserConfig.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BILogUserConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BILogUserConfig createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BILogUserConfig(parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BILogUserConfig[] newArray(int i) {
            return new BILogUserConfig[i];
        }
    }

    public BILogUserConfig() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public BILogUserConfig(@NotNull String accountCode, boolean z) {
        Intrinsics.checkNotNullParameter(accountCode, "accountCode");
        this.accountCode = accountCode;
        this.disableUser = z;
    }

    public static /* synthetic */ BILogUserConfig copy$default(BILogUserConfig bILogUserConfig, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bILogUserConfig.accountCode;
        }
        if ((i & 2) != 0) {
            z = bILogUserConfig.disableUser;
        }
        return bILogUserConfig.copy(str, z);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAccountCode() {
        return this.accountCode;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getDisableUser() {
        return this.disableUser;
    }

    @NotNull
    public final BILogUserConfig copy(@NotNull String accountCode, boolean disableUser) {
        Intrinsics.checkNotNullParameter(accountCode, "accountCode");
        return new BILogUserConfig(accountCode, disableUser);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BILogUserConfig)) {
            return false;
        }
        BILogUserConfig bILogUserConfig = (BILogUserConfig) other;
        return Intrinsics.areEqual(this.accountCode, bILogUserConfig.accountCode) && this.disableUser == bILogUserConfig.disableUser;
    }

    @NotNull
    public final String getAccountCode() {
        return this.accountCode;
    }

    public final boolean getDisableUser() {
        return this.disableUser;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = this.accountCode.hashCode() * 31;
        boolean z = this.disableUser;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public final void setAccountCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accountCode = str;
    }

    public final void setDisableUser(boolean z) {
        this.disableUser = z;
    }

    @NotNull
    public String toString() {
        return "BILogUserConfig(accountCode=" + this.accountCode + ", disableUser=" + this.disableUser + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.accountCode);
        parcel.writeInt(this.disableUser ? 1 : 0);
    }

    public /* synthetic */ BILogUserConfig(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z);
    }
}
