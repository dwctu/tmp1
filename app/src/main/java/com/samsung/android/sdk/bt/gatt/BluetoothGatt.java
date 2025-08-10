package com.samsung.android.sdk.bt.gatt;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.IBluetoothManager;
import android.bluetooth.IBluetoothStateChangeCallback;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.ParcelUuid;
import android.os.RemoteException;
import android.os.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class BluetoothGatt implements BluetoothProfile {
    public static final int GATT_ALREADY_OPEN = -115;
    public static final int GATT_ERROR = -123;
    public static final int GATT_INSUFFICIENT_AUTHENTICATION = 5;
    public static final int GATT_INSUFFICIENT_ENCRYPTION = 15;
    public static final int GATT_INTERNAL_ERROR = -127;
    public static final int GATT_INVALID_ATTRIBUTE_LENGTH = 13;
    public static final int GATT_INVALID_OFFSET = 7;
    public static final int GATT_NO_RESOURCES = -128;
    public static final int GATT_READ_NOT_PERMITTED = 2;
    public static final int GATT_REQUEST_NOT_SUPPORTED = 6;
    public static final int GATT_SUCCESS = 0;
    public static final int GATT_WRITE_NOT_PERMITTED = 3;
    private Context a;
    private BluetoothProfile.ServiceListener b;
    private BluetoothAdapter c;
    private IBluetoothGatt d;
    private BluetoothGattCallback e;
    private byte f;
    private boolean g = false;
    private List h;
    private final IBluetoothStateChangeCallback i;
    private ServiceConnection j;
    private final IBluetoothGattCallback k;

    public BluetoothGatt(Context context, BluetoothProfile.ServiceListener serviceListener) {
        a aVar = new a(this);
        this.i = aVar;
        this.j = new b(this);
        this.k = new c(this);
        this.a = context;
        this.b = serviceListener;
        this.c = BluetoothAdapter.getDefaultAdapter();
        this.h = new ArrayList();
        IBinder service = ServiceManager.getService("bluetooth_manager");
        if (service != null) {
            try {
                IBluetoothManager.Stub.asInterface(service).registerStateChangeCallback(aVar);
            } catch (RemoteException unused) {
            }
        }
        if (this.c.isEnabled()) {
            context.bindService(new Intent(IBluetoothGatt.class.getName()), this.j, 0);
        }
    }

    public final BluetoothGattService a(BluetoothDevice bluetoothDevice, UUID uuid, int i, int i2) {
        for (BluetoothGattService bluetoothGattService : this.h) {
            if (bluetoothGattService.a().equals(bluetoothDevice) && bluetoothGattService.getType() == i2 && bluetoothGattService.getInstanceId() == i && bluetoothGattService.getUuid().equals(uuid)) {
                return bluetoothGattService;
            }
        }
        return null;
    }

    public final void a() {
        unregisterApp();
        this.b = null;
        IBinder service = ServiceManager.getService("bluetooth_manager");
        if (service != null) {
            try {
                IBluetoothManager.Stub.asInterface(service).unregisterStateChangeCallback(this.i);
            } catch (RemoteException unused) {
            }
        }
        synchronized (this.j) {
            if (this.d != null) {
                try {
                    this.d = null;
                    this.a.unbindService(this.j);
                } catch (Exception unused2) {
                }
            }
        }
    }

    public final void abortReliableWrite(BluetoothDevice bluetoothDevice) {
        byte b;
        if (bluetoothDevice == null) {
            return;
        }
        String str = "abortReliableWrite() - device: " + bluetoothDevice.getAddress();
        IBluetoothGatt iBluetoothGatt = this.d;
        if (iBluetoothGatt == null || (b = this.f) == 0) {
            return;
        }
        try {
            iBluetoothGatt.endReliableWrite(b, bluetoothDevice.getAddress(), false);
        } catch (RemoteException unused) {
        }
    }

    public final boolean beginReliableWrite(BluetoothDevice bluetoothDevice) {
        byte b;
        if (bluetoothDevice == null) {
            return false;
        }
        String str = "beginReliableWrite() - device: " + bluetoothDevice.getAddress();
        IBluetoothGatt iBluetoothGatt = this.d;
        if (iBluetoothGatt != null && (b = this.f) != 0) {
            try {
                iBluetoothGatt.beginReliableWrite(b, bluetoothDevice.getAddress());
                return true;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    public final void cancelConnection(BluetoothDevice bluetoothDevice) {
        byte b;
        if (bluetoothDevice == null) {
            return;
        }
        String str = "cancelOpen() - device: " + bluetoothDevice.getAddress();
        IBluetoothGatt iBluetoothGatt = this.d;
        if (iBluetoothGatt == null || (b = this.f) == 0) {
            return;
        }
        try {
            iBluetoothGatt.clientDisconnect(b, bluetoothDevice.getAddress());
        } catch (RemoteException unused) {
        }
    }

    public final boolean connect(BluetoothDevice bluetoothDevice, boolean z) {
        if (bluetoothDevice == null) {
            return false;
        }
        String str = "connect() - device: " + bluetoothDevice.getAddress() + ", auto: " + z;
        if (this.d != null && this.f != 0) {
            if (getConnectionState(bluetoothDevice) == 2) {
                String str2 = "device: " + bluetoothDevice.getAddress() + " already connected";
                return false;
            }
            try {
                this.d.clientConnect(this.f, bluetoothDevice.getAddress(), !z);
                return true;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    public final boolean discoverServices(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return false;
        }
        String str = "discoverServices() - device: " + bluetoothDevice.getAddress();
        if (this.d != null && this.f != 0) {
            this.h.clear();
            try {
                this.d.discoverServices(this.f, bluetoothDevice.getAddress());
                return true;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    public final boolean executeReliableWrite(BluetoothDevice bluetoothDevice) {
        byte b;
        if (bluetoothDevice == null) {
            return false;
        }
        String str = "executeReliableWrite() - device: " + bluetoothDevice.getAddress();
        IBluetoothGatt iBluetoothGatt = this.d;
        if (iBluetoothGatt != null && (b = this.f) != 0) {
            try {
                iBluetoothGatt.endReliableWrite(b, bluetoothDevice.getAddress(), true);
                return true;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    @Override // android.bluetooth.BluetoothProfile
    public final List getConnectedDevices() {
        ArrayList arrayList = new ArrayList();
        IBluetoothGatt iBluetoothGatt = this.d;
        if (iBluetoothGatt == null) {
            return arrayList;
        }
        try {
            return iBluetoothGatt.getDevicesMatchingConnectionStates(new int[]{2});
        } catch (RemoteException unused) {
            return arrayList;
        }
    }

    @Override // android.bluetooth.BluetoothProfile
    public final int getConnectionState(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null || this.d == null) {
            return 0;
        }
        Iterator it = getConnectedDevices().iterator();
        while (it.hasNext()) {
            if (bluetoothDevice.equals((BluetoothDevice) it.next())) {
                return 2;
            }
        }
        return 0;
    }

    @Override // android.bluetooth.BluetoothProfile
    public final List getDevicesMatchingConnectionStates(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        IBluetoothGatt iBluetoothGatt = this.d;
        if (iBluetoothGatt == null || iArr == null) {
            return arrayList;
        }
        try {
            return iBluetoothGatt.getDevicesMatchingConnectionStates(iArr);
        } catch (RemoteException unused) {
            return arrayList;
        }
    }

    public final BluetoothGattService getService(BluetoothDevice bluetoothDevice, UUID uuid) {
        if (bluetoothDevice == null) {
            return null;
        }
        for (BluetoothGattService bluetoothGattService : this.h) {
            if (bluetoothGattService.a().equals(bluetoothDevice) && bluetoothGattService.getUuid().equals(uuid)) {
                return bluetoothGattService;
            }
        }
        return null;
    }

    public final List getServices(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (BluetoothGattService bluetoothGattService : this.h) {
            if (bluetoothGattService.a().equals(bluetoothDevice)) {
                arrayList.add(bluetoothGattService);
            }
        }
        return arrayList;
    }

    public final boolean isBLEDevice(BluetoothDevice bluetoothDevice) {
        return bluetoothDevice != null && bluetoothDevice.getDeviceType() == 2;
    }

    public final boolean readCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGattService service;
        BluetoothDevice bluetoothDeviceA;
        if (bluetoothGattCharacteristic == null || (bluetoothGattCharacteristic.getProperties() & 2) == 0) {
            return false;
        }
        String str = "readCharacteristic() - uuid: " + bluetoothGattCharacteristic.getUuid();
        if (this.d == null || this.f == 0 || (service = bluetoothGattCharacteristic.getService()) == null || (bluetoothDeviceA = service.a()) == null) {
            return false;
        }
        try {
            this.d.readCharacteristic(this.f, bluetoothDeviceA.getAddress(), service.getType(), service.getInstanceId(), new ParcelUuid(service.getUuid()), bluetoothGattCharacteristic.getInstanceId(), new ParcelUuid(bluetoothGattCharacteristic.getUuid()), (byte) 0);
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }

    public final boolean readDescriptor(BluetoothGattDescriptor bluetoothGattDescriptor) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattService service;
        BluetoothDevice bluetoothDeviceA;
        if (bluetoothGattDescriptor == null) {
            return false;
        }
        String str = "readDescriptor() - uuid: " + bluetoothGattDescriptor.getUuid();
        if (this.d == null || this.f == 0 || (characteristic = bluetoothGattDescriptor.getCharacteristic()) == null || (service = characteristic.getService()) == null || (bluetoothDeviceA = service.a()) == null) {
            return false;
        }
        try {
            this.d.readDescriptor(this.f, bluetoothDeviceA.getAddress(), service.getType(), service.getInstanceId(), new ParcelUuid(service.getUuid()), characteristic.getInstanceId(), new ParcelUuid(characteristic.getUuid()), new ParcelUuid(bluetoothGattDescriptor.getUuid()), (byte) 0);
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }

    public final boolean readRemoteRssi(BluetoothDevice bluetoothDevice) {
        byte b;
        if (bluetoothDevice == null) {
            return false;
        }
        String str = "readRssi() - device: " + bluetoothDevice.getAddress();
        IBluetoothGatt iBluetoothGatt = this.d;
        if (iBluetoothGatt != null && (b = this.f) != 0) {
            try {
                iBluetoothGatt.readRemoteRssi(b, bluetoothDevice.getAddress());
                return true;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    public final boolean registerApp(BluetoothGattCallback bluetoothGattCallback) {
        if (bluetoothGattCallback == null || this.d == null) {
            return false;
        }
        this.e = bluetoothGattCallback;
        UUID uuidRandomUUID = UUID.randomUUID();
        String str = "registerApp() - UUID=" + uuidRandomUUID;
        try {
            this.d.registerClient(new ParcelUuid(uuidRandomUUID), this.k);
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }

    public final boolean removeBond(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return false;
        }
        cancelConnection(bluetoothDevice);
        return bluetoothDevice.removeBond();
    }

    public final boolean setCharacteristicNotification(BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        BluetoothGattService service;
        BluetoothDevice bluetoothDeviceA;
        if (bluetoothGattCharacteristic == null) {
            return false;
        }
        String str = "setCharacteristicNotification() - uuid: " + bluetoothGattCharacteristic.getUuid() + " enable: " + z;
        if (this.d == null || this.f == 0 || (service = bluetoothGattCharacteristic.getService()) == null || (bluetoothDeviceA = service.a()) == null) {
            return false;
        }
        try {
            this.d.registerForNotification(this.f, bluetoothDeviceA.getAddress(), service.getType(), service.getInstanceId(), new ParcelUuid(service.getUuid()), bluetoothGattCharacteristic.getInstanceId(), new ParcelUuid(bluetoothGattCharacteristic.getUuid()), z);
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }

    public final boolean startScan() {
        byte b;
        IBluetoothGatt iBluetoothGatt = this.d;
        if (iBluetoothGatt != null && (b = this.f) != 0) {
            try {
                return iBluetoothGatt.startScan(b, false);
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    public final boolean startScan(UUID[] uuidArr) {
        if (uuidArr != null && this.d != null && this.f != 0) {
            try {
                int length = uuidArr.length;
                ParcelUuid[] parcelUuidArr = new ParcelUuid[length];
                for (int i = 0; i != length; i++) {
                    parcelUuidArr[i] = new ParcelUuid(uuidArr[i]);
                }
                return this.d.startScanWithUuids(this.f, false, parcelUuidArr);
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    public final void stopScan() {
        byte b;
        IBluetoothGatt iBluetoothGatt = this.d;
        if (iBluetoothGatt == null || (b = this.f) == 0) {
            return;
        }
        try {
            iBluetoothGatt.stopScan(b, false);
        } catch (RemoteException unused) {
        }
    }

    public final void unregisterApp() {
        byte b;
        String str = "unregisterApp() - mClientIf=" + ((int) this.f);
        IBluetoothGatt iBluetoothGatt = this.d;
        if (iBluetoothGatt == null || (b = this.f) == 0) {
            return;
        }
        try {
            this.e = null;
            iBluetoothGatt.unregisterClient(b);
            this.f = (byte) 0;
        } catch (RemoteException unused) {
        }
    }

    public final boolean writeCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGattService service;
        BluetoothDevice bluetoothDeviceA;
        if (((bluetoothGattCharacteristic.getProperties() & 8) == 0 && (bluetoothGattCharacteristic.getProperties() & 4) == 0) || bluetoothGattCharacteristic == null) {
            return false;
        }
        String str = "writeCharacteristic() - uuid: " + bluetoothGattCharacteristic.getUuid();
        if (this.d == null || this.f == 0 || (service = bluetoothGattCharacteristic.getService()) == null || (bluetoothDeviceA = service.a()) == null || bluetoothGattCharacteristic.getValue() == null) {
            return false;
        }
        try {
            this.d.writeCharacteristic(this.f, bluetoothDeviceA.getAddress(), service.getType(), service.getInstanceId(), new ParcelUuid(service.getUuid()), bluetoothGattCharacteristic.getInstanceId(), new ParcelUuid(bluetoothGattCharacteristic.getUuid()), bluetoothGattCharacteristic.getWriteType(), (byte) 0, bluetoothGattCharacteristic.getValue());
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }

    public final boolean writeDescriptor(BluetoothGattDescriptor bluetoothGattDescriptor) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattService service;
        BluetoothDevice bluetoothDeviceA;
        if (bluetoothGattDescriptor == null) {
            return false;
        }
        String str = "writeDescriptor() - uuid: " + bluetoothGattDescriptor.getUuid();
        if (this.d == null || this.f == 0 || (characteristic = bluetoothGattDescriptor.getCharacteristic()) == null || (service = characteristic.getService()) == null || (bluetoothDeviceA = service.a()) == null || bluetoothGattDescriptor.getValue() == null) {
            return false;
        }
        try {
            this.d.writeDescriptor(this.f, bluetoothDeviceA.getAddress(), service.getType(), service.getInstanceId(), new ParcelUuid(service.getUuid()), characteristic.getInstanceId(), new ParcelUuid(characteristic.getUuid()), new ParcelUuid(bluetoothGattDescriptor.getUuid()), characteristic.getWriteType(), (byte) 0, bluetoothGattDescriptor.getValue());
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }
}
