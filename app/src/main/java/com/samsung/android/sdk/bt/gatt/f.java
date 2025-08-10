package com.samsung.android.sdk.bt.gatt;

import android.bluetooth.BluetoothDevice;
import android.os.ParcelUuid;
import com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class f extends IBluetoothGattServerCallback.Stub {
    private /* synthetic */ BluetoothGattServer a;

    public f(BluetoothGattServer bluetoothGattServer) {
        this.a = bluetoothGattServer;
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback
    public final void onCharacteristicReadRequest(String str, int i, int i2, boolean z, int i3, int i4, ParcelUuid parcelUuid, int i5, ParcelUuid parcelUuid2) {
        BluetoothGattCharacteristic characteristic;
        UUID uuid = parcelUuid.getUuid();
        UUID uuid2 = parcelUuid2.getUuid();
        String str2 = "onCharacteristicReadRequest() - service=" + uuid + ", characteristic=" + uuid2;
        BluetoothDevice remoteDevice = this.a.c.getRemoteDevice(str);
        BluetoothGattService bluetoothGattServiceA = this.a.a(uuid, i4, i3);
        if (bluetoothGattServiceA == null || (characteristic = bluetoothGattServiceA.getCharacteristic(uuid2)) == null || this.a.e == null) {
            return;
        }
        this.a.e.onCharacteristicReadRequest(remoteDevice, i, i2, characteristic);
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback
    public final void onCharacteristicWriteRequest(String str, int i, int i2, int i3, boolean z, boolean z2, int i4, int i5, ParcelUuid parcelUuid, int i6, ParcelUuid parcelUuid2, byte[] bArr) {
        BluetoothGattCharacteristic characteristic;
        UUID uuid = parcelUuid.getUuid();
        UUID uuid2 = parcelUuid2.getUuid();
        String str2 = "onCharacteristicWriteRequest() - service=" + uuid + ", characteristic=" + uuid2;
        BluetoothDevice remoteDevice = this.a.c.getRemoteDevice(str);
        BluetoothGattService bluetoothGattServiceA = this.a.a(uuid, i5, i4);
        if (bluetoothGattServiceA == null || (characteristic = bluetoothGattServiceA.getCharacteristic(uuid2)) == null || this.a.e == null) {
            return;
        }
        this.a.e.onCharacteristicWriteRequest(remoteDevice, i, characteristic, z, z2, i2, bArr);
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback
    public final void onDescriptorReadRequest(String str, int i, int i2, boolean z, int i3, int i4, ParcelUuid parcelUuid, int i5, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattDescriptor descriptor;
        UUID uuid = parcelUuid.getUuid();
        UUID uuid2 = parcelUuid2.getUuid();
        UUID uuid3 = parcelUuid3.getUuid();
        String str2 = "onCharacteristicReadRequest() - service=" + uuid + ", characteristic=" + uuid2 + "descriptor=" + uuid3;
        BluetoothDevice remoteDevice = this.a.c.getRemoteDevice(str);
        BluetoothGattService bluetoothGattServiceA = this.a.a(uuid, i4, i3);
        if (bluetoothGattServiceA == null || (characteristic = bluetoothGattServiceA.getCharacteristic(uuid2)) == null || (descriptor = characteristic.getDescriptor(uuid3)) == null || this.a.e == null) {
            return;
        }
        this.a.e.onDescriptorReadRequest(remoteDevice, i, i2, descriptor);
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback
    public final void onDescriptorWriteRequest(String str, int i, int i2, int i3, boolean z, boolean z2, int i4, int i5, ParcelUuid parcelUuid, int i6, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattDescriptor descriptor;
        UUID uuid = parcelUuid.getUuid();
        UUID uuid2 = parcelUuid2.getUuid();
        UUID uuid3 = parcelUuid3.getUuid();
        String str2 = "onDescriptorWriteRequest() - service=" + uuid + ", characteristic=" + uuid2 + "descriptor=" + uuid3;
        BluetoothDevice remoteDevice = this.a.c.getRemoteDevice(str);
        BluetoothGattService bluetoothGattServiceA = this.a.a(uuid, i5, i4);
        if (bluetoothGattServiceA == null || (characteristic = bluetoothGattServiceA.getCharacteristic(uuid2)) == null || (descriptor = characteristic.getDescriptor(uuid3)) == null || this.a.e == null) {
            return;
        }
        this.a.e.onDescriptorWriteRequest(remoteDevice, i, descriptor, z, z2, i2, bArr);
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback
    public final void onExecuteWrite(String str, int i, boolean z) {
        String str2 = "onExecuteWrite() - device=" + str + ", transId=" + i + "execWrite=" + z;
        BluetoothDevice remoteDevice = this.a.c.getRemoteDevice(str);
        if (remoteDevice == null || this.a.e == null) {
            return;
        }
        this.a.e.onExecuteWrite(remoteDevice, i, z);
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback
    public final void onScanResult(String str, int i, byte[] bArr) {
        String str2 = "onScanResult() - Device=" + str + " RSSI=" + i;
        if (this.a.e != null) {
            this.a.e.onScanResult(this.a.c.getRemoteDevice(str), i, bArr);
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback
    public final void onServerConnectionState(byte b, byte b2, boolean z, String str) {
        String str2 = "onServerConnectionState() - status=" + ((int) b) + " serverIf=" + ((int) b2) + " device=" + str;
        if (this.a.e != null) {
            this.a.e.onConnectionStateChange(this.a.c.getRemoteDevice(str), b, z ? 2 : 0);
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback
    public final void onServerRegistered(byte b, byte b2) {
        String str = "onServerRegistered() - status=" + ((int) b) + " serverIf=" + ((int) b2);
        this.a.f = b2;
        if (this.a.e != null) {
            this.a.e.onAppRegistered(b);
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback
    public final void onServiceAdded(byte b, int i, int i2, ParcelUuid parcelUuid) {
        UUID uuid = parcelUuid.getUuid();
        String str = "onServiceAdded() - service=" + uuid + "status=" + ((int) b);
        BluetoothGattService bluetoothGattServiceA = this.a.a(uuid, i2, i);
        if (bluetoothGattServiceA == null || this.a.e == null) {
            return;
        }
        this.a.e.onServiceAdded(b, bluetoothGattServiceA);
    }
}
