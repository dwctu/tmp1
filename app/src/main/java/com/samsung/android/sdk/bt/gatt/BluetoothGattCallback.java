package com.samsung.android.sdk.bt.gatt;

import android.bluetooth.BluetoothDevice;

/* loaded from: classes3.dex */
public abstract class BluetoothGattCallback {
    public void onAppRegistered(int i) {
    }

    public void onCharacteristicChanged(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
    }

    public void onCharacteristicRead(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
    }

    public void onCharacteristicWrite(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
    }

    public void onConnectionStateChange(BluetoothDevice bluetoothDevice, int i, int i2) {
    }

    public void onDescriptorRead(BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
    }

    public void onDescriptorWrite(BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
    }

    public void onReadRemoteRssi(BluetoothDevice bluetoothDevice, int i, int i2) {
    }

    public void onReliableWriteCompleted(BluetoothDevice bluetoothDevice, int i) {
    }

    public void onScanResult(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
    }

    public void onServicesDiscovered(BluetoothDevice bluetoothDevice, int i) {
    }
}
