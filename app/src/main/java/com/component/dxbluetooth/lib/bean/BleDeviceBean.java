package com.component.dxbluetooth.lib.bean;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BleDeviceBean.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\u0018\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001aJ\u0018\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001aJ\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\t\u0010!\u001a\u00020\u0012HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006("}, d2 = {"Lcom/component/dxbluetooth/lib/bean/BleDeviceBean;", "Landroid/os/Parcelable;", "mac", "", "serviceList", "", "Landroid/bluetooth/BluetoothGattService;", "(Ljava/lang/String;Ljava/util/List;)V", "getMac", "()Ljava/lang/String;", "getServiceList", "()Ljava/util/List;", "setServiceList", "(Ljava/util/List;)V", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "getAvailableCharacteristicList", "Landroid/bluetooth/BluetoothGattCharacteristic;", "serviceUUID", "Ljava/util/UUID;", "getCharacteristic", "characteristicUUID", "getCharacteristicList", "getServcie", "uuid", "getServcieList", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", DownloaderServiceMarshaller.PARAMS_FLAGS, "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class BleDeviceBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<BleDeviceBean> CREATOR = new Creator();

    @NotNull
    private final String mac;

    @NotNull
    private List<? extends BluetoothGattService> serviceList;

    /* compiled from: BleDeviceBean.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BleDeviceBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BleDeviceBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(parcel.readParcelable(BleDeviceBean.class.getClassLoader()));
            }
            return new BleDeviceBean(string, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BleDeviceBean[] newArray(int i) {
            return new BleDeviceBean[i];
        }
    }

    public BleDeviceBean(@NotNull String mac, @NotNull List<? extends BluetoothGattService> serviceList) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(serviceList, "serviceList");
        this.mac = mac;
        this.serviceList = serviceList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BleDeviceBean copy$default(BleDeviceBean bleDeviceBean, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bleDeviceBean.mac;
        }
        if ((i & 2) != 0) {
            list = bleDeviceBean.serviceList;
        }
        return bleDeviceBean.copy(str, list);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getMac() {
        return this.mac;
    }

    @NotNull
    public final List<BluetoothGattService> component2() {
        return this.serviceList;
    }

    @NotNull
    public final BleDeviceBean copy(@NotNull String mac, @NotNull List<? extends BluetoothGattService> serviceList) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(serviceList, "serviceList");
        return new BleDeviceBean(mac, serviceList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BleDeviceBean)) {
            return false;
        }
        BleDeviceBean bleDeviceBean = (BleDeviceBean) other;
        return Intrinsics.areEqual(this.mac, bleDeviceBean.mac) && Intrinsics.areEqual(this.serviceList, bleDeviceBean.serviceList);
    }

    @Nullable
    public final List<BluetoothGattCharacteristic> getAvailableCharacteristicList(@Nullable UUID serviceUUID) {
        List<BluetoothGattCharacteristic> characteristicList = getCharacteristicList(serviceUUID);
        if (characteristicList == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristicList) {
            if (bluetoothGattCharacteristic.getProperties() != 0) {
                arrayList.add(bluetoothGattCharacteristic);
            }
        }
        return arrayList;
    }

    @Nullable
    public final BluetoothGattCharacteristic getCharacteristic(@Nullable UUID serviceUUID, @Nullable UUID characteristicUUID) {
        BluetoothGattService servcie;
        if (serviceUUID == null || characteristicUUID == null || (servcie = getServcie(serviceUUID)) == null) {
            return null;
        }
        return servcie.getCharacteristic(characteristicUUID);
    }

    @Nullable
    public final List<BluetoothGattCharacteristic> getCharacteristicList(@Nullable UUID serviceUUID) {
        if (serviceUUID != null) {
            BluetoothGattService servcie = getServcie(serviceUUID);
            if (servcie != null) {
                return servcie.getCharacteristics();
            }
            return null;
        }
        List<BluetoothGattService> servcieList = getServcieList();
        ArrayList arrayList = new ArrayList();
        Iterator<BluetoothGattService> it = servcieList.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getCharacteristics());
        }
        return arrayList;
    }

    @NotNull
    public final String getMac() {
        return this.mac;
    }

    @Nullable
    public final BluetoothGattService getServcie(@Nullable UUID uuid) {
        if (uuid == null) {
            return null;
        }
        for (BluetoothGattService bluetoothGattService : this.serviceList) {
            if (Intrinsics.areEqual(bluetoothGattService.getUuid(), uuid)) {
                return bluetoothGattService;
            }
        }
        return null;
    }

    @NotNull
    public final List<BluetoothGattService> getServcieList() {
        return this.serviceList;
    }

    @NotNull
    public final List<BluetoothGattService> getServiceList() {
        return this.serviceList;
    }

    public int hashCode() {
        return (this.mac.hashCode() * 31) + this.serviceList.hashCode();
    }

    public final void setServiceList(@NotNull List<? extends BluetoothGattService> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.serviceList = list;
    }

    @NotNull
    public String toString() {
        return "BleDeviceBean(mac=" + this.mac + ", serviceList=" + this.serviceList + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.mac);
        List<? extends BluetoothGattService> list = this.serviceList;
        parcel.writeInt(list.size());
        Iterator<? extends BluetoothGattService> it = list.iterator();
        while (it.hasNext()) {
            parcel.writeParcelable(it.next(), flags);
        }
    }
}
