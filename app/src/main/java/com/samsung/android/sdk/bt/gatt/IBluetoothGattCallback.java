package com.samsung.android.sdk.bt.gatt;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelUuid;

/* loaded from: classes3.dex */
public interface IBluetoothGattCallback extends IInterface {

    public abstract class Stub extends Binder implements IBluetoothGattCallback {
        public Stub() {
            attachInterface(this, "com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
        }

        public static IBluetoothGattCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IBluetoothGattCallback)) ? new h(iBinder) : (IBluetoothGattCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
                    onClientRegistered(parcel.readByte(), parcel.readByte());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
                    onClientConnectionState(parcel.readByte(), parcel.readByte(), parcel.readInt() != 0, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
                    onScanResult(parcel.readString(), parcel.readInt(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
                    onGetService(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
                    onGetIncludedService(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
                    onGetCharacteristic(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
                    onGetDescriptor(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
                    onSearchComplete(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
                    onCharacteristicRead(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
                    onCharacteristicWrite(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
                    onExecuteWrite(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
                    onDescriptorRead(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
                    onDescriptorWrite(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
                    onNotify(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback");
                    onReadRemoteRssi(parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onCharacteristicRead(String str, int i, int i2, int i3, ParcelUuid parcelUuid, int i4, ParcelUuid parcelUuid2, byte[] bArr);

    void onCharacteristicWrite(String str, int i, int i2, int i3, ParcelUuid parcelUuid, int i4, ParcelUuid parcelUuid2);

    void onClientConnectionState(byte b, byte b2, boolean z, String str);

    void onClientRegistered(byte b, byte b2);

    void onDescriptorRead(String str, int i, int i2, int i3, ParcelUuid parcelUuid, int i4, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr);

    void onDescriptorWrite(String str, int i, int i2, int i3, ParcelUuid parcelUuid, int i4, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3);

    void onExecuteWrite(String str, int i);

    void onGetCharacteristic(String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, int i4);

    void onGetDescriptor(String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3);

    void onGetIncludedService(String str, int i, int i2, ParcelUuid parcelUuid, int i3, int i4, ParcelUuid parcelUuid2);

    void onGetService(String str, int i, int i2, ParcelUuid parcelUuid);

    void onNotify(String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, byte[] bArr);

    void onReadRemoteRssi(String str, int i, int i2);

    void onScanResult(String str, int i, byte[] bArr);

    void onSearchComplete(String str, int i);
}
