package com.samsung.android.sdk.bt.gatt;

import android.bluetooth.BluetoothDevice;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes3.dex */
public class BluetoothGattService {
    public static final int SERVICE_TYPE_PRIMARY = 0;
    public static final int SERVICE_TYPE_SECONDARY = 1;
    public List mCharacteristics;
    public BluetoothDevice mDevice;
    public int mHandles;
    public List mIncludedServices;
    public int mInstanceId;
    public int mServiceType;
    public UUID mUuid;

    public BluetoothGattService(BluetoothDevice bluetoothDevice, UUID uuid, int i, int i2) {
        this.mHandles = 0;
        this.mDevice = bluetoothDevice;
        this.mUuid = uuid;
        this.mInstanceId = i;
        this.mServiceType = i2;
        this.mCharacteristics = new ArrayList();
        this.mIncludedServices = new ArrayList();
    }

    public BluetoothGattService(UUID uuid, int i) {
        this.mHandles = 0;
        this.mDevice = null;
        this.mUuid = uuid;
        this.mInstanceId = 0;
        this.mServiceType = i;
        this.mCharacteristics = new ArrayList();
        this.mIncludedServices = new ArrayList();
    }

    public final BluetoothDevice a() {
        return this.mDevice;
    }

    public final BluetoothGattCharacteristic a(UUID uuid, int i) {
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : this.mCharacteristics) {
            if (uuid.equals(bluetoothGattCharacteristic.getUuid()) && this.mInstanceId == i) {
                return bluetoothGattCharacteristic;
            }
        }
        return null;
    }

    public final void a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.mCharacteristics.add(bluetoothGattCharacteristic);
    }

    public final void a(BluetoothGattService bluetoothGattService) {
        this.mIncludedServices.add(bluetoothGattService);
    }

    public final int b() {
        return this.mHandles;
    }

    public BluetoothGattCharacteristic getCharacteristic(UUID uuid) {
        if (uuid == null) {
            return null;
        }
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : this.mCharacteristics) {
            if (uuid.equals(bluetoothGattCharacteristic.getUuid())) {
                return bluetoothGattCharacteristic;
            }
        }
        return null;
    }

    public List getCharacteristics() {
        return this.mCharacteristics;
    }

    public List getIncludedServices() {
        return this.mIncludedServices;
    }

    public int getInstanceId() {
        return this.mInstanceId;
    }

    public int getType() {
        return this.mServiceType;
    }

    public UUID getUuid() {
        return this.mUuid;
    }
}
