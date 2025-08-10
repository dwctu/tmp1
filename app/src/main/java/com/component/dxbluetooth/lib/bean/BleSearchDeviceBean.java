package com.component.dxbluetooth.lib.bean;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BleSearchDeviceBean.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020\u001fH\u0007J\b\u0010!\u001a\u00020\u0005H\u0016J\t\u0010\"\u001a\u00020\u001fHÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006("}, d2 = {"Lcom/component/dxbluetooth/lib/bean/BleSearchDeviceBean;", "Landroid/os/Parcelable;", "device", "Landroid/bluetooth/BluetoothDevice;", "rssi", "", "scanRecord", "", "(Landroid/bluetooth/BluetoothDevice;I[B)V", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "setDevice", "(Landroid/bluetooth/BluetoothDevice;)V", "getRssi", "()I", "setRssi", "(I)V", "getScanRecord", "()[B", "setScanRecord", "([B)V", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "getMac", "", "getName", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", DownloaderServiceMarshaller.PARAMS_FLAGS, "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class BleSearchDeviceBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<BleSearchDeviceBean> CREATOR = new Creator();

    @NotNull
    private BluetoothDevice device;
    private int rssi;

    @Nullable
    private byte[] scanRecord;

    /* compiled from: BleSearchDeviceBean.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BleSearchDeviceBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BleSearchDeviceBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BleSearchDeviceBean((BluetoothDevice) parcel.readParcelable(BleSearchDeviceBean.class.getClassLoader()), parcel.readInt(), parcel.createByteArray());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BleSearchDeviceBean[] newArray(int i) {
            return new BleSearchDeviceBean[i];
        }
    }

    public BleSearchDeviceBean(@NotNull BluetoothDevice device, int i, @Nullable byte[] bArr) {
        Intrinsics.checkNotNullParameter(device, "device");
        this.device = device;
        this.rssi = i;
        this.scanRecord = bArr;
    }

    public static /* synthetic */ BleSearchDeviceBean copy$default(BleSearchDeviceBean bleSearchDeviceBean, BluetoothDevice bluetoothDevice, int i, byte[] bArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bluetoothDevice = bleSearchDeviceBean.device;
        }
        if ((i2 & 2) != 0) {
            i = bleSearchDeviceBean.rssi;
        }
        if ((i2 & 4) != 0) {
            bArr = bleSearchDeviceBean.scanRecord;
        }
        return bleSearchDeviceBean.copy(bluetoothDevice, i, bArr);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final BluetoothDevice getDevice() {
        return this.device;
    }

    /* renamed from: component2, reason: from getter */
    public final int getRssi() {
        return this.rssi;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final byte[] getScanRecord() {
        return this.scanRecord;
    }

    @NotNull
    public final BleSearchDeviceBean copy(@NotNull BluetoothDevice device, int rssi, @Nullable byte[] scanRecord) {
        Intrinsics.checkNotNullParameter(device, "device");
        return new BleSearchDeviceBean(device, rssi, scanRecord);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BleSearchDeviceBean)) {
            return false;
        }
        BleSearchDeviceBean bleSearchDeviceBean = (BleSearchDeviceBean) other;
        return Intrinsics.areEqual(this.device, bleSearchDeviceBean.device) && this.rssi == bleSearchDeviceBean.rssi && Intrinsics.areEqual(this.scanRecord, bleSearchDeviceBean.scanRecord);
    }

    @NotNull
    public final BluetoothDevice getDevice() {
        return this.device;
    }

    @NotNull
    public final String getMac() {
        String address = this.device.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "device.address");
        return address;
    }

    @SuppressLint({"MissingPermission"})
    @NotNull
    public final String getName() {
        String name = this.device.getName();
        return name == null ? "" : name;
    }

    public final int getRssi() {
        return this.rssi;
    }

    @Nullable
    public final byte[] getScanRecord() {
        return this.scanRecord;
    }

    public int hashCode() {
        BluetoothDevice bluetoothDevice = this.device;
        int iHashCode = (((bluetoothDevice == null ? 0 : bluetoothDevice.hashCode()) * 31) + this.rssi) * 31;
        byte[] bArr = this.scanRecord;
        return iHashCode + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }

    public final void setDevice(@NotNull BluetoothDevice bluetoothDevice) {
        Intrinsics.checkNotNullParameter(bluetoothDevice, "<set-?>");
        this.device = bluetoothDevice;
    }

    public final void setRssi(int i) {
        this.rssi = i;
    }

    public final void setScanRecord(@Nullable byte[] bArr) {
        this.scanRecord = bArr;
    }

    @NotNull
    public String toString() {
        return "BleSearchDeviceBean(device=" + this.device + ", rssi=" + this.rssi + ", scanRecord=" + Arrays.toString(this.scanRecord) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.device, flags);
        parcel.writeInt(this.rssi);
        parcel.writeByteArray(this.scanRecord);
    }

    public /* synthetic */ BleSearchDeviceBean(BluetoothDevice bluetoothDevice, int i, byte[] bArr, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bluetoothDevice, (i2 & 2) != 0 ? 0 : i, bArr);
    }
}
