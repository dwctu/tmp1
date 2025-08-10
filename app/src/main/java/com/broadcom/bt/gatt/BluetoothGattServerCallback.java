package com.broadcom.bt.gatt;

import android.bluetooth.BluetoothDevice;

/* loaded from: classes.dex */
public abstract class BluetoothGattServerCallback {
    public void onAppRegistered(int i) {
    }

    public void onCharacteristicReadRequest(BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
    }

    public void onCharacteristicWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, boolean z2, int i2, byte[] bArr) {
    }

    public void onConnectionStateChange(BluetoothDevice bluetoothDevice, int i, int i2) {
    }

    public void onDescriptorReadRequest(BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattDescriptor bluetoothGattDescriptor) {
    }

    public void onDescriptorWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattDescriptor bluetoothGattDescriptor, boolean z, boolean z2, int i2, byte[] bArr) {
    }

    public void onExecuteWrite(BluetoothDevice bluetoothDevice, int i, boolean z) {
    }

    public void onScanResult(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
    }

    public void onServiceAdded(int i, BluetoothGattService bluetoothGattService) {
    }
}
