package com.broadcom.bt.gatt;

import java.util.UUID;

/* loaded from: classes.dex */
public class MutableBluetoothGattCharacteristic extends BluetoothGattCharacteristic {
    public MutableBluetoothGattCharacteristic(UUID uuid, int i, int i2) {
        super(null, uuid, 0, i, i2);
    }

    public void addDescriptor(MutableBluetoothGattDescriptor mutableBluetoothGattDescriptor) {
        this.mDescriptors.add(mutableBluetoothGattDescriptor);
        mutableBluetoothGattDescriptor.setCharacteristic(this);
    }

    public void setKeySize(int i) {
        this.mKeySize = i;
    }

    public void setService(BluetoothGattService bluetoothGattService) {
        this.mService = bluetoothGattService;
    }
}
