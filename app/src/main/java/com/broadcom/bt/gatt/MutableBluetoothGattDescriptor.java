package com.broadcom.bt.gatt;

import java.util.UUID;

/* loaded from: classes.dex */
public class MutableBluetoothGattDescriptor extends BluetoothGattDescriptor {
    public MutableBluetoothGattDescriptor(UUID uuid, int i) {
        super(null, uuid, i);
    }

    public void setCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.mCharacteristic = bluetoothGattCharacteristic;
    }
}
