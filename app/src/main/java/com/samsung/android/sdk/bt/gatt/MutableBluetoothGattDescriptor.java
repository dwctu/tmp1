package com.samsung.android.sdk.bt.gatt;

import java.util.UUID;

/* loaded from: classes3.dex */
public class MutableBluetoothGattDescriptor extends BluetoothGattDescriptor {
    public MutableBluetoothGattDescriptor(UUID uuid, int i) {
        super(null, uuid, i);
    }

    public final void a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.mCharacteristic = bluetoothGattCharacteristic;
    }
}
