package com.samsung.android.sdk.bt.gatt;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelUuid;

/* loaded from: classes3.dex */
public final class i implements IBluetoothGattServerCallback {
    private IBinder a;

    public i(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback
    public final void onCharacteristicReadRequest(String str, int i, int i2, boolean z, int i3, int i4, ParcelUuid parcelUuid, int i5, ParcelUuid parcelUuid2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            parcelObtain.writeInt(z ? 1 : 0);
            parcelObtain.writeInt(i3);
            parcelObtain.writeInt(i4);
            if (parcelUuid != null) {
                parcelObtain.writeInt(1);
                parcelUuid.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            parcelObtain.writeInt(i5);
            if (parcelUuid2 != null) {
                parcelObtain.writeInt(1);
                parcelUuid2.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            this.a.transact(5, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback
    public final void onCharacteristicWriteRequest(String str, int i, int i2, int i3, boolean z, boolean z2, int i4, int i5, ParcelUuid parcelUuid, int i6, ParcelUuid parcelUuid2, byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            parcelObtain.writeInt(i3);
            parcelObtain.writeInt(z ? 1 : 0);
            parcelObtain.writeInt(z2 ? 1 : 0);
            parcelObtain.writeInt(i4);
            parcelObtain.writeInt(i5);
            if (parcelUuid != null) {
                parcelObtain.writeInt(1);
                parcelUuid.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            parcelObtain.writeInt(i6);
            if (parcelUuid2 != null) {
                parcelObtain.writeInt(1);
                parcelUuid2.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            parcelObtain.writeByteArray(bArr);
            this.a.transact(7, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback
    public final void onDescriptorReadRequest(String str, int i, int i2, boolean z, int i3, int i4, ParcelUuid parcelUuid, int i5, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            parcelObtain.writeInt(z ? 1 : 0);
            parcelObtain.writeInt(i3);
            parcelObtain.writeInt(i4);
            if (parcelUuid != null) {
                parcelObtain.writeInt(1);
                parcelUuid.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            parcelObtain.writeInt(i5);
            if (parcelUuid2 != null) {
                parcelObtain.writeInt(1);
                parcelUuid2.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            if (parcelUuid3 != null) {
                parcelObtain.writeInt(1);
                parcelUuid3.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            this.a.transact(6, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback
    public final void onDescriptorWriteRequest(String str, int i, int i2, int i3, boolean z, boolean z2, int i4, int i5, ParcelUuid parcelUuid, int i6, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr) throws Throwable {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            parcelObtain.writeInt(i3);
            parcelObtain.writeInt(z ? 1 : 0);
            parcelObtain.writeInt(z2 ? 1 : 0);
            parcelObtain.writeInt(i4);
            parcelObtain.writeInt(i5);
            if (parcelUuid != null) {
                parcelObtain.writeInt(1);
                parcelUuid.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            parcelObtain.writeInt(i6);
            if (parcelUuid2 != null) {
                parcelObtain.writeInt(1);
                parcelUuid2.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            if (parcelUuid3 != null) {
                parcelObtain.writeInt(1);
                parcelUuid3.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            parcelObtain.writeByteArray(bArr);
            try {
                this.a.transact(8, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                parcelObtain2.recycle();
                parcelObtain.recycle();
            } catch (Throwable th) {
                th = th;
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback
    public final void onExecuteWrite(String str, int i, boolean z) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(z ? 1 : 0);
            this.a.transact(9, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback
    public final void onScanResult(String str, int i, byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i);
            parcelObtain.writeByteArray(bArr);
            this.a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback
    public final void onServerConnectionState(byte b, byte b2, boolean z, String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback");
            parcelObtain.writeByte(b);
            parcelObtain.writeByte(b2);
            parcelObtain.writeInt(z ? 1 : 0);
            parcelObtain.writeString(str);
            this.a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback
    public final void onServerRegistered(byte b, byte b2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback");
            parcelObtain.writeByte(b);
            parcelObtain.writeByte(b2);
            this.a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback
    public final void onServiceAdded(byte b, int i, int i2, ParcelUuid parcelUuid) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback");
            parcelObtain.writeByte(b);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            if (parcelUuid != null) {
                parcelObtain.writeInt(1);
                parcelUuid.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            this.a.transact(4, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
