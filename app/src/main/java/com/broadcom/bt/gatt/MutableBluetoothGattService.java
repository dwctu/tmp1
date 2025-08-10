package com.broadcom.bt.gatt;

import java.util.UUID;

/* loaded from: classes.dex */
public class MutableBluetoothGattService extends BluetoothGattService {
    public MutableBluetoothGattService(UUID uuid, int i) {
        super(uuid, i);
    }

    public boolean addCharacteristic(MutableBluetoothGattCharacteristic mutableBluetoothGattCharacteristic) {
        this.mCharacteristics.add(mutableBluetoothGattCharacteristic);
        mutableBluetoothGattCharacteristic.setService(this);
        return true;
    }

    public boolean addService(BluetoothGattService bluetoothGattService) {
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
