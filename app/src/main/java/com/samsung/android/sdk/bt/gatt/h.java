package com.samsung.android.sdk.bt.gatt;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelUuid;

/* loaded from: classes3.dex */
public final class h implements IBluetoothGattCallback {
    private IBinder a;

    public h(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onCharacteristicRead(String str, int i, int i2, int i3, ParcelUuid parcelUuid, int i4, ParcelUuid parcelUuid2, byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            parcelObtain.writeInt(i3);
            if (parcelUuid != null) {
                parcelObtain.writeInt(1);
                parcelUuid.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            parcelObtain.writeInt(i4);
            if (parcelUuid2 != null) {
                parcelObtain.writeInt(1);
                parcelUuid2.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            parcelObtain.writeByteArray(bArr);
            this.a.transact(9, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onCharacteristicWrite(String str, int i, int i2, int i3, ParcelUuid parcelUuid, int i4, ParcelUuid parcelUuid2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            parcelObtain.writeInt(i3);
            if (parcelUuid != null) {
                parcelObtain.writeInt(1);
                parcelUuid.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            parcelObtain.writeInt(i4);
            if (parcelUuid2 != null) {
                parcelObtain.writeInt(1);
                parcelUuid2.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            this.a.transact(10, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onClientConnectionState(byte b, byte b2, boolean z, String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
            parcelObtain.writeByte(b);
            parcelObtain.writeByte(b2);
            parcelObtain.writeInt(z ? 1 : 0);
            parcelObtain.writeString(str);
            this.a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onClientRegistered(byte b, byte b2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
            parcelObtain.writeByte(b);
            parcelObtain.writeByte(b2);
            this.a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onDescriptorRead(String str, int i, int i2, int i3, ParcelUuid parcelUuid, int i4, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            parcelObtain.writeInt(i3);
            if (parcelUuid != null) {
                parcelObtain.writeInt(1);
                parcelUuid.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            parcelObtain.writeInt(i4);
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
            this.a.transact(12, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onDescriptorWrite(String str, int i, int i2, int i3, ParcelUuid parcelUuid, int i4, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            parcelObtain.writeInt(i3);
            if (parcelUuid != null) {
                parcelObtain.writeInt(1);
                parcelUuid.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            parcelObtain.writeInt(i4);
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
            this.a.transact(13, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onExecuteWrite(String str, int i) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i);
            this.a.transact(11, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onGetCharacteristic(String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, int i4) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            if (parcelUuid != null) {
                parcelObtain.writeInt(1);
                parcelUuid.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            parcelObtain.writeInt(i3);
            if (parcelUuid2 != null) {
                parcelObtain.writeInt(1);
                parcelUuid2.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            parcelObtain.writeInt(i4);
            this.a.transact(6, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onGetDescriptor(String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            if (parcelUuid != null) {
                parcelObtain.writeInt(1);
                parcelUuid.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            parcelObtain.writeInt(i3);
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
            this.a.transact(7, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onGetIncludedService(String str, int i, int i2, ParcelUuid parcelUuid, int i3, int i4, ParcelUuid parcelUuid2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            if (parcelUuid != null) {
                parcelObtain.writeInt(1);
                parcelUuid.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            parcelObtain.writeInt(i3);
            parcelObtain.writeInt(i4);
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

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onGetService(String str, int i, int i2, ParcelUuid parcelUuid) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
            parcelObtain.writeString(str);
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

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onNotify(String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            if (parcelUuid != null) {
                parcelObtain.writeInt(1);
                parcelUuid.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            parcelObtain.writeInt(i3);
            if (parcelUuid2 != null) {
                parcelObtain.writeInt(1);
                parcelUuid2.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            parcelObtain.writeByteArray(bArr);
            this.a.transact(14, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onReadRemoteRssi(String str, int i, int i2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            this.a.transact(15, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onScanResult(String str, int i, byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i);
            parcelObtain.writeByteArray(bArr);
            this.a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback
    public final void onSearchComplete(String str, int i) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i);
            this.a.transact(8, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
