package com.samsung.android.sdk.bt.gatt;

import android.bluetooth.BluetoothDevice;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelUuid;
import java.util.List;

/* loaded from: classes3.dex */
public final class g implements IBluetoothGatt {
    private IBinder a;

    public g(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void addCharacteristic(byte b, ParcelUuid parcelUuid, int i, int i2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
            if (parcelUuid != null) {
                parcelObtain.writeInt(1);
                parcelUuid.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            this.a.transact(25, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void addDescriptor(byte b, ParcelUuid parcelUuid, int i) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
            if (parcelUuid != null) {
                parcelObtain.writeInt(1);
                parcelUuid.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            parcelObtain.writeInt(i);
            this.a.transact(26, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void addIncludedService(byte b, int i, int i2, ParcelUuid parcelUuid) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            if (parcelUuid != null) {
                parcelObtain.writeInt(1);
                parcelUuid.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            this.a.transact(24, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void beginReliableWrite(byte b, String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
            parcelObtain.writeString(str);
            this.a.transact(16, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void beginServiceDeclaration(byte b, int i, int i2, int i3, ParcelUuid parcelUuid) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            parcelObtain.writeInt(i3);
            if (parcelUuid != null) {
                parcelObtain.writeInt(1);
                parcelUuid.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            this.a.transact(23, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void clearServices(byte b) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
            this.a.transact(29, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void clientConnect(byte b, String str, boolean z) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
            parcelObtain.writeString(str);
            parcelObtain.writeInt(z ? 1 : 0);
            this.a.transact(7, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void clientDisconnect(byte b, String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
            parcelObtain.writeString(str);
            this.a.transact(8, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void discoverServices(byte b, String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
            parcelObtain.writeString(str);
            this.a.transact(10, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void endReliableWrite(byte b, String str, boolean z) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
            parcelObtain.writeString(str);
            parcelObtain.writeInt(z ? 1 : 0);
            this.a.transact(17, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void endServiceDeclaration(byte b) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
            this.a.transact(27, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final List getDevicesMatchingConnectionStates(int[] iArr) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeIntArray(iArr);
            this.a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.createTypedArrayList(BluetoothDevice.CREATOR);
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void readCharacteristic(byte b, String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, byte b2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
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
            parcelObtain.writeByte(b2);
            this.a.transact(11, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void readDescriptor(byte b, String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte b2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
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
            parcelObtain.writeByte(b2);
            this.a.transact(13, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void readRemoteRssi(byte b, String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
            parcelObtain.writeString(str);
            this.a.transact(18, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void refreshDevice(byte b, String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
            parcelObtain.writeString(str);
            this.a.transact(9, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void registerClient(ParcelUuid parcelUuid, IBluetoothGattCallback iBluetoothGattCallback) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            if (parcelUuid != null) {
                parcelObtain.writeInt(1);
                parcelUuid.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            parcelObtain.writeStrongBinder(iBluetoothGattCallback != null ? iBluetoothGattCallback.asBinder() : null);
            this.a.transact(5, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void registerForNotification(byte b, String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, boolean z) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            int i4 = 1;
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
            if (!z) {
                i4 = 0;
            }
            parcelObtain.writeInt(i4);
            this.a.transact(15, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void registerServer(ParcelUuid parcelUuid, IBluetoothGattServerCallback iBluetoothGattServerCallback) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            if (parcelUuid != null) {
                parcelObtain.writeInt(1);
                parcelUuid.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            parcelObtain.writeStrongBinder(iBluetoothGattServerCallback != null ? iBluetoothGattServerCallback.asBinder() : null);
            this.a.transact(19, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void removeService(byte b, int i, int i2, ParcelUuid parcelUuid) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            if (parcelUuid != null) {
                parcelObtain.writeInt(1);
                parcelUuid.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            this.a.transact(28, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void sendNotification(byte b, String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, boolean z, byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            int i4 = 1;
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
            if (!z) {
                i4 = 0;
            }
            parcelObtain.writeInt(i4);
            parcelObtain.writeByteArray(bArr);
            this.a.transact(31, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void sendResponse(byte b, String str, int i, int i2, int i3, byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            parcelObtain.writeInt(i3);
            parcelObtain.writeByteArray(bArr);
            this.a.transact(30, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void serverConnect(byte b, String str, boolean z) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
            parcelObtain.writeString(str);
            parcelObtain.writeInt(z ? 1 : 0);
            this.a.transact(21, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void serverDisconnect(byte b, String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
            parcelObtain.writeString(str);
            this.a.transact(22, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void startBroadcast(int i, int i2, int i3, byte b, byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            parcelObtain.writeInt(i3);
            parcelObtain.writeByte(b);
            parcelObtain.writeByteArray(bArr);
            this.a.transact(32, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final boolean startScan(byte b, boolean z) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
            parcelObtain.writeInt(z ? 1 : 0);
            this.a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final boolean startScanWithUuids(byte b, boolean z, ParcelUuid[] parcelUuidArr) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
            parcelObtain.writeInt(z ? 1 : 0);
            parcelObtain.writeTypedArray(parcelUuidArr, 0);
            this.a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void stopBroadcast() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            this.a.transact(33, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void stopScan(byte b, boolean z) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
            parcelObtain.writeInt(z ? 1 : 0);
            this.a.transact(4, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void unregisterClient(byte b) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
            this.a.transact(6, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void unregisterServer(byte b) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
            this.a.transact(20, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void writeCharacteristic(byte b, String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, int i4, byte b2, byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
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
            parcelObtain.writeByte(b2);
            parcelObtain.writeByteArray(bArr);
            this.a.transact(12, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.samsung.android.sdk.bt.gatt.IBluetoothGatt
    public final void writeDescriptor(byte b, String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, int i4, byte b2, byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            parcelObtain.writeByte(b);
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
            parcelObtain.writeInt(i4);
            parcelObtain.writeByte(b2);
            parcelObtain.writeByteArray(bArr);
            this.a.transact(14, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
