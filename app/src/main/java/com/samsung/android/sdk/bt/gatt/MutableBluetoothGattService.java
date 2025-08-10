package com.samsung.android.sdk.bt.gatt;

import java.util.UUID;

/* loaded from: classes3.dex */
public class MutableBluetoothGattService extends BluetoothGattService {
    public MutableBluetoothGattService(UUID uuid, int i) {
        super(uuid, i);
    }

    public boolean addCharacteristic(MutableBluetoothGattCharacteristic mutableBluetoothGattCharacteristic) {
        if (mutableBluetoothGattCharacteristic == null) {
            return false;
        }
        this.mCharacteristics.add(mutableBluetoothGattCharacteristic);
        mutableBluetoothGattCharacteristic.a(this);
        return true;
    }

    public boolean addService(BluetoothGattService bluetoothGattService) {
        if (bluetoothGattService == null) {
            return false;
        }
        this.mIncludedServices.add(bluetoothGattService);
        return true;
    }

    public void setHandles(int i) {
        this.mHandles = i;
    }

    public void setInstanceId(int i) {
        this.mInstanceId = i;
    }
}
