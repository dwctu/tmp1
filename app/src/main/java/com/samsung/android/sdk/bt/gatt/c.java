package com.samsung.android.sdk.bt.gatt;

import android.bluetooth.BluetoothDevice;
import android.os.ParcelUuid;
import android.os.RemoteException;
import com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback;

/* loaded from: classes3.dex */
public final class c extends IBluetoothGattCallback.Stub {
    private /* synthetic */ BluetoothGatt a;

    public c(BluetoothGatt bluetoothGatt) {
        this.a = bluetoothGatt;
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onCharacteristicRead(String str, int i, int i2, int i3, ParcelUuid parcelUuid, int i4, ParcelUuid parcelUuid2, byte[] bArr) {
        BluetoothGattCharacteristic bluetoothGattCharacteristicA;
        String str2 = "onCharacteristicRead() - Device=" + str + " UUID=" + parcelUuid2 + " Status=" + i;
        if (i == 5 && !this.a.g) {
            try {
                this.a.g = true;
                this.a.d.readCharacteristic(this.a.f, str, i2, i3, parcelUuid, i4, parcelUuid2, (byte) 2);
                return;
            } catch (RemoteException unused) {
            }
        }
        this.a.g = false;
        BluetoothGattService bluetoothGattServiceA = this.a.a(this.a.c.getRemoteDevice(str), parcelUuid.getUuid(), i3, i2);
        if (bluetoothGattServiceA == null || (bluetoothGattCharacteristicA = bluetoothGattServiceA.a(parcelUuid2.getUuid(), i4)) == null) {
            return;
        }
        if (i == 0) {
            bluetoothGattCharacteristicA.setValue(bArr);
        }
        if (this.a.e != null) {
            this.a.e.onCharacteristicRead(bluetoothGattCharacteristicA, i);
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onCharacteristicWrite(String str, int i, int i2, int i3, ParcelUuid parcelUuid, int i4, ParcelUuid parcelUuid2) {
        BluetoothGattCharacteristic bluetoothGattCharacteristicA;
        String str2 = "onCharacteristicWrite() - Device=" + str + " UUID=" + parcelUuid2 + " Status=" + i;
        BluetoothGattService bluetoothGattServiceA = this.a.a(this.a.c.getRemoteDevice(str), parcelUuid.getUuid(), i3, i2);
        if (bluetoothGattServiceA == null || (bluetoothGattCharacteristicA = bluetoothGattServiceA.a(parcelUuid2.getUuid(), i4)) == null) {
            return;
        }
        if (i == 5 && !this.a.g) {
            try {
                this.a.g = true;
                this.a.d.writeCharacteristic(this.a.f, str, i2, i3, parcelUuid, i4, parcelUuid2, bluetoothGattCharacteristicA.getWriteType(), (byte) 2, bluetoothGattCharacteristicA.getValue());
                return;
            } catch (RemoteException unused) {
            }
        }
        this.a.g = false;
        if (this.a.e != null) {
            this.a.e.onCharacteristicWrite(bluetoothGattCharacteristicA, i);
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onClientConnectionState(byte b, byte b2, boolean z, String str) {
        String str2 = "onClientConnectionState() - status=" + ((int) b) + " clientIf=" + ((int) b2) + " device=" + str;
        if (this.a.e != null) {
            this.a.e.onConnectionStateChange(this.a.c.getRemoteDevice(str), b, z ? 2 : 0);
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onClientRegistered(byte b, byte b2) {
        String str = "onClientRegistered() - status=" + ((int) b) + " clientIf=" + ((int) b2);
        this.a.f = b2;
        if (this.a.e != null) {
            this.a.e.onAppRegistered(b);
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onDescriptorRead(String str, int i, int i2, int i3, ParcelUuid parcelUuid, int i4, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr) {
        BluetoothGattCharacteristic bluetoothGattCharacteristicA;
        BluetoothGattDescriptor descriptor;
        String str2 = "onDescriptorRead() - Device=" + str + " UUID=" + parcelUuid2;
        BluetoothGattService bluetoothGattServiceA = this.a.a(this.a.c.getRemoteDevice(str), parcelUuid.getUuid(), i3, i2);
        if (bluetoothGattServiceA == null || (bluetoothGattCharacteristicA = bluetoothGattServiceA.a(parcelUuid2.getUuid(), i4)) == null || (descriptor = bluetoothGattCharacteristicA.getDescriptor(parcelUuid3.getUuid())) == null) {
            return;
        }
        if (i == 0) {
            descriptor.setValue(bArr);
        }
        if (i == 5 && !this.a.g) {
            try {
                this.a.g = true;
                this.a.d.readDescriptor(this.a.f, str, i2, i3, parcelUuid, i4, parcelUuid2, parcelUuid3, (byte) 2);
            } catch (RemoteException unused) {
            }
        }
        this.a.g = true;
        if (this.a.e != null) {
            this.a.e.onDescriptorRead(descriptor, i);
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onDescriptorWrite(String str, int i, int i2, int i3, ParcelUuid parcelUuid, int i4, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3) {
        BluetoothGattCharacteristic bluetoothGattCharacteristicA;
        BluetoothGattDescriptor descriptor;
        String str2 = "onDescriptorWrite() - Device=" + str + " UUID=" + parcelUuid2;
        BluetoothGattService bluetoothGattServiceA = this.a.a(this.a.c.getRemoteDevice(str), parcelUuid.getUuid(), i3, i2);
        if (bluetoothGattServiceA == null || (bluetoothGattCharacteristicA = bluetoothGattServiceA.a(parcelUuid2.getUuid(), i4)) == null || (descriptor = bluetoothGattCharacteristicA.getDescriptor(parcelUuid3.getUuid())) == null) {
            return;
        }
        if (i == 5 && !this.a.g) {
            try {
                this.a.g = true;
                this.a.d.writeDescriptor(this.a.f, str, i2, i3, parcelUuid, i4, parcelUuid2, parcelUuid3, bluetoothGattCharacteristicA.getWriteType(), (byte) 2, descriptor.getValue());
            } catch (RemoteException unused) {
            }
        }
        this.a.g = false;
        if (this.a.e != null) {
            this.a.e.onDescriptorWrite(descriptor, i);
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onExecuteWrite(String str, int i) {
        String str2 = "onExecuteWrite() - Device=" + str + " status=" + i;
        BluetoothDevice remoteDevice = this.a.c.getRemoteDevice(str);
        if (this.a.e != null) {
            this.a.e.onReliableWriteCompleted(remoteDevice, i);
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onGetCharacteristic(String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, int i4) {
        String str2 = "onGetCharacteristic() - Device=" + str + " UUID=" + parcelUuid2;
        BluetoothGattService bluetoothGattServiceA = this.a.a(this.a.c.getRemoteDevice(str), parcelUuid.getUuid(), i2, i);
        if (bluetoothGattServiceA != null) {
            bluetoothGattServiceA.a(new BluetoothGattCharacteristic(bluetoothGattServiceA, parcelUuid2.getUuid(), i3, i4, 0));
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onGetDescriptor(String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3) {
        BluetoothGattCharacteristic characteristic;
        String str2 = "onGetDescriptor() - Device=" + str + " UUID=" + parcelUuid3;
        BluetoothGattService bluetoothGattServiceA = this.a.a(this.a.c.getRemoteDevice(str), parcelUuid.getUuid(), i2, i);
        if (bluetoothGattServiceA == null || (characteristic = bluetoothGattServiceA.getCharacteristic(parcelUuid2.getUuid())) == null) {
            return;
        }
        characteristic.a(new BluetoothGattDescriptor(characteristic, parcelUuid3.getUuid(), 0));
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onGetIncludedService(String str, int i, int i2, ParcelUuid parcelUuid, int i3, int i4, ParcelUuid parcelUuid2) {
        String str2 = "onGetIncludedService() - Device=" + str + " UUID=" + parcelUuid + " Included=" + parcelUuid2;
        BluetoothDevice remoteDevice = this.a.c.getRemoteDevice(str);
        BluetoothGattService bluetoothGattServiceA = this.a.a(remoteDevice, parcelUuid.getUuid(), i2, i);
        BluetoothGattService bluetoothGattServiceA2 = this.a.a(remoteDevice, parcelUuid2.getUuid(), i4, i3);
        if (bluetoothGattServiceA == null || bluetoothGattServiceA2 == null) {
            return;
        }
        bluetoothGattServiceA.a(bluetoothGattServiceA2);
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onGetService(String str, int i, int i2, ParcelUuid parcelUuid) {
        String str2 = "onGetService() - Device=" + str + " UUID=" + parcelUuid;
        this.a.h.add(new BluetoothGattService(this.a.c.getRemoteDevice(str), parcelUuid.getUuid(), i2, i));
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onNotify(String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, byte[] bArr) {
        BluetoothGattCharacteristic bluetoothGattCharacteristicA;
        String str2 = "onNotify() - Device=" + str + " UUID=" + parcelUuid2;
        BluetoothGattService bluetoothGattServiceA = this.a.a(this.a.c.getRemoteDevice(str), parcelUuid.getUuid(), i2, i);
        if (bluetoothGattServiceA == null || (bluetoothGattCharacteristicA = bluetoothGattServiceA.a(parcelUuid2.getUuid(), i3)) == null) {
            return;
        }
        bluetoothGattCharacteristicA.setValue(bArr);
        if (this.a.e != null) {
            this.a.e.onCharacteristicChanged(bluetoothGattCharacteristicA);
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onReadRemoteRssi(String str, int i, int i2) {
        String str2 = "onReadRemoteRssi() - Device=" + str + " rssi=" + i + " status=" + i2;
        BluetoothDevice remoteDevice = this.a.c.getRemoteDevice(str);
        if (this.a.e != null) {
            this.a.e.onReadRemoteRssi(remoteDevice, i, i2);
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onScanResult(String str, int i, byte[] bArr) {
        String str2 = "onScanResult() - Device=" + str + " RSSI=" + i;
        if (this.a.e != null) {
            this.a.e.onScanResult(this.a.c.getRemoteDevice(str), i, bArr);
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onSearchComplete(String str, int i) {
        String str2 = "onSearchComplete() = Device=" + str + " Status=" + i;
        if (this.a.e != null) {
            this.a.e.onServicesDiscovered(this.a.c.getRemoteDevice(str), i);
        }
    }
}
