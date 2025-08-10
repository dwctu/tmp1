package com.component.dxbluetooth.lib.bean.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BleSearchConfigBean.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rHÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/component/dxbluetooth/lib/bean/config/BleSearchConfigBean;", "Landroid/os/Parcelable;", "timeout", "", "(Ljava/lang/Long;)V", "getTimeout", "()Ljava/lang/Long;", "setTimeout", "Ljava/lang/Long;", "component1", "copy", "(Ljava/lang/Long;)Lcom/component/dxbluetooth/lib/bean/config/BleSearchConfigBean;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", DownloaderServiceMarshaller.PARAMS_FLAGS, "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class BleSearchConfigBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<BleSearchConfigBean> CREATOR = new Creator();

    @Nullable
    private Long timeout;

    /* compiled from: BleSearchConfigBean.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BleSearchConfigBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BleSearchConfigBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BleSearchConfigBean(parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BleSearchConfigBean[] newArray(int i) {
            return new BleSearchConfigBean[i];
        }
    }

    public BleSearchConfigBean() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public BleSearchConfigBean(@Nullable Long l) {
        this.timeout = l;
    }

    public static /* synthetic */ BleSearchConfigBean copy$default(BleSearchConfigBean bleSearchConfigBean, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = bleSearchConfigBean.timeout;
        }
        return bleSearchConfigBean.copy(l);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getTimeout() {
        return this.timeout;
    }

    @NotNull
    public final BleSearchConfigBean copy(@Nullable Long timeout) {
        return new BleSearchConfigBean(timeout);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof BleSearchConfigBean) && Intrinsics.areEqual(this.timeout, ((BleSearchConfigBean) other).timeout);
    }

    @Nullable
    public final Long getTimeout() {
        return this.timeout;
    }

    public int hashCode() {
        Long l = this.timeout;
        if (l == null) {
            return 0;
        }
        return l.hashCode();
    }

    public final void setTimeout(@Nullable Long l) {
        this.timeout = l;
    }

    @NotNull
    public String toString() {
        return "BleSearchConfigBean(timeout=" + this.timeout + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Long l = this.timeout;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
    }

    public /* synthetic */ BleSearchConfigBean(Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l);
    }
}
