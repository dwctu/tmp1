package com.samsung.android.sdk.bt.gatt;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelUuid;

/* loaded from: classes3.dex */
public interface IBluetoothGattServerCallback extends IInterface {

    public abstract class Stub extends Binder implements IBluetoothGattServerCallback {
        public Stub() {
            attachInterface(this, "com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback");
        }

        public static IBluetoothGattServerCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IBluetoothGattServerCallback)) ? new i(iBinder) : (IBluetoothGattServerCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString("com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback");
                    onServerRegistered(parcel.readByte(), parcel.readByte());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback");
                    onScanResult(parcel.readString(), parcel.readInt(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback");
                    onServerConnectionState(parcel.readByte(), parcel.readByte(), parcel.readInt() != 0, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback");
                    onServiceAdded(parcel.readByte(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback");
                    onCharacteristicReadRequest(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback");
                    onDescriptorReadRequest(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback");
                    onCharacteristicWriteRequest(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback");
                    onDescriptorWriteRequest(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback");
                    onExecuteWrite(parcel.readString(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onCharacteristicReadRequest(String str, int i, int i2, boolean z, int i3, int i4, ParcelUuid parcelUuid, int i5, ParcelUuid parcelUuid2);

    void onCharacteristicWriteRequest(String str, int i, int i2, int i3, boolean z, boolean z2, int i4, int i5, ParcelUuid parcelUuid, int i6, ParcelUuid parcelUuid2, byte[] bArr);

    void onDescriptorReadRequest(String str, int i, int i2, boolean z, int i3, int i4, ParcelUuid parcelUuid, int i5, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3);

    void onDescriptorWriteRequest(String str, int i, int i2, int i3, boolean z, boolean z2, int i4, int i5, ParcelUuid parcelUuid, int i6, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr);

    void onExecuteWrite(String str, int i, boolean z);

    void onScanResult(String str, int i, byte[] bArr);

    void onServerConnectionState(byte b, byte b2, boolean z, String str);

    void onServerRegistered(byte b, byte b2);

    void onServiceAdded(byte b, int i, int i2, ParcelUuid parcelUuid);
}
