package com.component.dxbluetooth.lib.bean.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import dc.g;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BleConnectConfigBean.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0001'B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006("}, d2 = {"Lcom/component/dxbluetooth/lib/bean/config/BleConnectConfigBean;", "Landroid/os/Parcelable;", "connectRetryCount", "", "serviceDiscoverRetryCount", "connectTimeout", "", "serviceDiscoverTimeout", "(IIJJ)V", "getConnectRetryCount", "()I", "setConnectRetryCount", "(I)V", "getConnectTimeout", "()J", "setConnectTimeout", "(J)V", "getServiceDiscoverRetryCount", "setServiceDiscoverRetryCount", "getServiceDiscoverTimeout", "setServiceDiscoverTimeout", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", DownloaderServiceMarshaller.PARAMS_FLAGS, "Companion", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class BleConnectConfigBean implements Parcelable {
    public static final int DEFAULT_CONNECT_RETRY = 2;
    public static final long DEFAULT_CONNECT_TIMEOUT = 3000;
    public static final int DEFAULT_SERVICE_DISCOVER_RETRY = 2;
    public static final long DEFAULT_SERVICE_DISCOVER_TIMEOUT = 3000;
    private int connectRetryCount;
    private long connectTimeout;
    private int serviceDiscoverRetryCount;
    private long serviceDiscoverTimeout;

    @NotNull
    public static final Parcelable.Creator<BleConnectConfigBean> CREATOR = new Creator();

    /* compiled from: BleConnectConfigBean.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BleConnectConfigBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BleConnectConfigBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BleConnectConfigBean(parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BleConnectConfigBean[] newArray(int i) {
            return new BleConnectConfigBean[i];
        }
    }

    public BleConnectConfigBean() {
        this(0, 0, 0L, 0L, 15, null);
    }

    public BleConnectConfigBean(int i, int i2, long j, long j2) {
        this.connectRetryCount = i;
        this.serviceDiscoverRetryCount = i2;
        this.connectTimeout = j;
        this.serviceDiscoverTimeout = j2;
    }

    public static /* synthetic */ BleConnectConfigBean copy$default(BleConnectConfigBean bleConnectConfigBean, int i, int i2, long j, long j2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bleConnectConfigBean.connectRetryCount;
        }
        if ((i3 & 2) != 0) {
            i2 = bleConnectConfigBean.serviceDiscoverRetryCount;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            j = bleConnectConfigBean.connectTimeout;
        }
        long j3 = j;
        if ((i3 & 8) != 0) {
            j2 = bleConnectConfigBean.serviceDiscoverTimeout;
        }
        return bleConnectConfigBean.copy(i, i4, j3, j2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getConnectRetryCount() {
        return this.connectRetryCount;
    }

    /* renamed from: component2, reason: from getter */
    public final int getServiceDiscoverRetryCount() {
        return this.serviceDiscoverRetryCount;
    }

    /* renamed from: component3, reason: from getter */
    public final long getConnectTimeout() {
        return this.connectTimeout;
    }

    /* renamed from: component4, reason: from getter */
    public final long getServiceDiscoverTimeout() {
        return this.serviceDiscoverTimeout;
    }

    @NotNull
    public final BleConnectConfigBean copy(int connectRetryCount, int serviceDiscoverRetryCount, long connectTimeout, long serviceDiscoverTimeout) {
        return new BleConnectConfigBean(connectRetryCount, serviceDiscoverRetryCount, connectTimeout, serviceDiscoverTimeout);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BleConnectConfigBean)) {
            return false;
        }
        BleConnectConfigBean bleConnectConfigBean = (BleConnectConfigBean) other;
        return this.connectRetryCount == bleConnectConfigBean.connectRetryCount && this.serviceDiscoverRetryCount == bleConnectConfigBean.serviceDiscoverRetryCount && this.connectTimeout == bleConnectConfigBean.connectTimeout && this.serviceDiscoverTimeout == bleConnectConfigBean.serviceDiscoverTimeout;
    }

    public final int getConnectRetryCount() {
        return this.connectRetryCount;
    }

    public final long getConnectTimeout() {
        return this.connectTimeout;
    }

    public final int getServiceDiscoverRetryCount() {
        return this.serviceDiscoverRetryCount;
    }

    public final long getServiceDiscoverTimeout() {
        return this.serviceDiscoverTimeout;
    }

    public int hashCode() {
        return (((((this.connectRetryCount * 31) + this.serviceDiscoverRetryCount) * 31) + g.a(this.connectTimeout)) * 31) + g.a(this.serviceDiscoverTimeout);
    }

    public final void setConnectRetryCount(int i) {
        this.connectRetryCount = i;
    }

    public final void setConnectTimeout(long j) {
        this.connectTimeout = j;
    }

    public final void setServiceDiscoverRetryCount(int i) {
        this.serviceDiscoverRetryCount = i;
    }

    public final void setServiceDiscoverTimeout(long j) {
        this.serviceDiscoverTimeout = j;
    }

    @NotNull
    public String toString() {
        return "BleConnectConfigBean(connectRetryCount=" + this.connectRetryCount + ", serviceDiscoverRetryCount=" + this.serviceDiscoverRetryCount + ", connectTimeout=" + this.connectTimeout + ", serviceDiscoverTimeout=" + this.serviceDiscoverTimeout + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.connectRetryCount);
        parcel.writeInt(this.serviceDiscoverRetryCount);
        parcel.writeLong(this.connectTimeout);
        parcel.writeLong(this.serviceDiscoverTimeout);
    }

    public /* synthetic */ BleConnectConfigBean(int i, int i2, long j, long j2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 2 : i, (i3 & 2) == 0 ? i2 : 2, (i3 & 4) != 0 ? 3000L : j, (i3 & 8) != 0 ? 3000L : j2);
    }
}
