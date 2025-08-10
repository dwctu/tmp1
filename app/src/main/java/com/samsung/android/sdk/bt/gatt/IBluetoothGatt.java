package com.samsung.android.sdk.bt.gatt;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelUuid;
import com.samsung.android.sdk.bt.gatt.IBluetoothGattCallback;
import com.samsung.android.sdk.bt.gatt.IBluetoothGattServerCallback;
import java.util.List;

/* loaded from: classes3.dex */
public interface IBluetoothGatt extends IInterface {

    public abstract class Stub extends Binder implements IBluetoothGatt {
        public Stub() {
            attachInterface(this, "com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
        }

        public static IBluetoothGatt asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IBluetoothGatt)) ? new g(iBinder) : (IBluetoothGatt) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    List devicesMatchingConnectionStates = getDevicesMatchingConnectionStates(parcel.createIntArray());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(devicesMatchingConnectionStates);
                    return true;
                case 2:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    boolean zStartScan = startScan(parcel.readByte(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(zStartScan ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    boolean zStartScanWithUuids = startScanWithUuids(parcel.readByte(), parcel.readInt() != 0, (ParcelUuid[]) parcel.createTypedArray(ParcelUuid.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zStartScanWithUuids ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    stopScan(parcel.readByte(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    registerClient(parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, IBluetoothGattCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    unregisterClient(parcel.readByte());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    clientConnect(parcel.readByte(), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    clientDisconnect(parcel.readByte(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    refreshDevice(parcel.readByte(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    discoverServices(parcel.readByte(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    readCharacteristic(parcel.readByte(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readByte());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    writeCharacteristic(parcel.readByte(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readByte(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    readDescriptor(parcel.readByte(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readByte());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    writeDescriptor(parcel.readByte(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readByte(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    registerForNotification(parcel.readByte(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    beginReliableWrite(parcel.readByte(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    endReliableWrite(parcel.readByte(), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    readRemoteRssi(parcel.readByte(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    registerServer(parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, IBluetoothGattServerCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    unregisterServer(parcel.readByte());
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    serverConnect(parcel.readByte(), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    serverDisconnect(parcel.readByte(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    beginServiceDeclaration(parcel.readByte(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    addIncludedService(parcel.readByte(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    addCharacteristic(parcel.readByte(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    addDescriptor(parcel.readByte(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    endServiceDeclaration(parcel.readByte());
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    removeService(parcel.readByte(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 29:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    clearServices(parcel.readByte());
                    parcel2.writeNoException();
                    return true;
                case 30:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    sendResponse(parcel.readByte(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 31:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    sendNotification(parcel.readByte(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0, parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    startBroadcast(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readByte(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface("com.samsung.android.sdk.bt.gatt.IBluetoothGatt");
                    stopBroadcast();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void addCharacteristic(byte b, ParcelUuid parcelUuid, int i, int i2);

    void addDescriptor(byte b, ParcelUuid parcelUuid, int i);

    void addIncludedService(byte b, int i, int i2, ParcelUuid parcelUuid);

    void beginReliableWrite(byte b, String str);

    void beginServiceDeclaration(byte b, int i, int i2, int i3, ParcelUuid parcelUuid);

    void clearServices(byte b);

    void clientConnect(byte b, String str, boolean z);

    void clientDisconnect(byte b, String str);

    void discoverServices(byte b, String str);

    void endReliableWrite(byte b, String str, boolean z);

    void endServiceDeclaration(byte b);

    List getDevicesMatchingConnectionStates(int[] iArr);

    void readCharacteristic(byte b, String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, byte b2);

    void readDescriptor(byte b, String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte b2);

    void readRemoteRssi(byte b, String str);

    void refreshDevice(byte b, String str);

    void registerClient(ParcelUuid parcelUuid, IBluetoothGattCallback iBluetoothGattCallback);

    void registerForNotification(byte b, String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, boolean z);

    void registerServer(ParcelUuid parcelUuid, IBluetoothGattServerCallback iBluetoothGattServerCallback);

    void removeService(byte b, int i, int i2, ParcelUuid parcelUuid);

    void sendNotification(byte b, String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, boolean z, byte[] bArr);

    void sendResponse(byte b, String str, int i, int i2, int i3, byte[] bArr);

    void serverConnect(byte b, String str, boolean z);

    void serverDisconnect(byte b, String str);

    void startBroadcast(int i, int i2, int i3, byte b, byte[] bArr);

    boolean startScan(byte b, boolean z);

    boolean startScanWithUuids(byte b, boolean z, ParcelUuid[] parcelUuidArr);

    void stopBroadcast();

    void stopScan(byte b, boolean z);

    void unregisterClient(byte b);

    void unregisterServer(byte b);

    void writeCharacteristic(byte b, String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, int i4, byte b2, byte[] bArr);

    void writeDescriptor(byte b, String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, int i4, byte b2, byte[] bArr);
}
