package com.xtremeprog.sdk.ble;

/* loaded from: classes4.dex */
public interface IBleRequestHandler {
    boolean characteristicNotification(String str, BleGattCharacteristic bleGattCharacteristic);

    boolean connect(String str);

    boolean readCharacteristic(String str, BleGattCharacteristic bleGattCharacteristic);

    boolean writeCharacteristic(String str, BleGattCharacteristic bleGattCharacteristic, String str2);
}
