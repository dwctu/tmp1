package com.samsung.android.sdk.bt.gatt;

import java.util.UUID;

/* loaded from: classes3.dex */
public class MutableBluetoothGattCharacteristic extends BluetoothGattCharacteristic {
    public MutableBluetoothGattCharacteristic(UUID uuid, int i, int i2) {
        super(null, uuid, 0, i, i2);
    }

    public final void a(BluetoothGattService bluetoothGattService) {
        this.mService = bluetoothGattService;
    }

    public void addDescriptor(MutableBluetoothGattDescriptor mutableBluetoothGattDescriptor) {
        if (mutableBluetoothGattDescriptor == null) {
            return;
        }
        this.mDescriptors.add(mutableBluetoothGattDescriptor);
        mutableBluetoothGattDescriptor.a(this);
    }

    public void setKeySize(int i) {
        this.mKeySize = i;
    }
}
