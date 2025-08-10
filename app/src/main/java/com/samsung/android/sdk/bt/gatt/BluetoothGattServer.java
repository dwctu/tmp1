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
public final class BluetoothGattServer implements BluetoothProfile {
    private Context a;
    private BluetoothProfile.ServiceListener b;
    private BluetoothAdapter c;
    private IBluetoothGatt d;
    private BluetoothGattServerCallback e;
    private byte f;
    private List g;
    private final IBluetoothStateChangeCallback h;
    private ServiceConnection i;
    private final IBluetoothGattServerCallback j;

    public BluetoothGattServer(Context context, BluetoothProfile.ServiceListener serviceListener) {
        d dVar = new d(this);
        this.h = dVar;
        this.i = new e(this);
        this.j = new f(this);
        this.a = context;
        this.b = serviceListener;
        this.c = BluetoothAdapter.getDefaultAdapter();
        this.g = new ArrayList();
        IBinder service = ServiceManager.getService("bluetooth_manager");
        if (service != null) {
            try {
                IBluetoothManager.Stub.asInterface(service).registerStateChangeCallback(dVar);
            } catch (RemoteException unused) {
            }
        }
        if (this.c.isEnabled()) {
            context.bindService(new Intent(IBluetoothGatt.class.getName()), this.i, 0);
        }
    }

    public final BluetoothGattService a(UUID uuid, int i, int i2) {
        for (BluetoothGattService bluetoothGattService : this.g) {
            if (bluetoothGattService.getType() == i2 && bluetoothGattService.getInstanceId() == i && bluetoothGattService.getUuid().equals(uuid)) {
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
                IBluetoothManager.Stub.asInterface(service).unregisterStateChangeCallback(this.h);
            } catch (RemoteException unused) {
            }
        }
        synchronized (this.i) {
            if (this.d != null) {
                try {
                    this.d = null;
                    this.a.unbindService(this.i);
                } catch (Exception unused2) {
                }
            }
        }
    }

    public final boolean addService(BluetoothGattService bluetoothGattService) {
        if (bluetoothGattService == null) {
            return false;
        }
        String str = "addService() - service: " + bluetoothGattService.getUuid();
        if (this.d == null || this.f == 0 || this.g.contains(bluetoothGattService)) {
            return false;
        }
        for (BluetoothGattService bluetoothGattService2 : this.g) {
            if (bluetoothGattService2.getUuid() == bluetoothGattService.getUuid() && bluetoothGattService2.getInstanceId() == bluetoothGattService.getInstanceId()) {
                return false;
            }
        }
        this.g.add(bluetoothGattService);
        try {
            this.d.beginServiceDeclaration(this.f, bluetoothGattService.getType(), bluetoothGattService.getInstanceId(), bluetoothGattService.b(), new ParcelUuid(bluetoothGattService.getUuid()));
            for (BluetoothGattService bluetoothGattService3 : bluetoothGattService.getIncludedServices()) {
                this.d.addIncludedService(this.f, bluetoothGattService3.getType(), bluetoothGattService3.getInstanceId(), new ParcelUuid(bluetoothGattService3.getUuid()));
            }
            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                this.d.addCharacteristic(this.f, new ParcelUuid(bluetoothGattCharacteristic.getUuid()), bluetoothGattCharacteristic.getProperties(), ((bluetoothGattCharacteristic.a() - 7) << 12) + bluetoothGattCharacteristic.getPermissions());
                for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                    this.d.addDescriptor(this.f, new ParcelUuid(bluetoothGattDescriptor.getUuid()), ((bluetoothGattCharacteristic.a() - 7) << 12) + bluetoothGattDescriptor.getPermissions());
                }
            }
            this.d.endServiceDeclaration(this.f);
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }

    public final void cancelConnection(BluetoothDevice bluetoothDevice) {
        byte b;
        if (bluetoothDevice == null) {
            return;
        }
        String str = "cancelConnection() - device: " + bluetoothDevice.getAddress();
        IBluetoothGatt iBluetoothGatt = this.d;
        if (iBluetoothGatt == null || (b = this.f) == 0) {
            return;
        }
        try {
            iBluetoothGatt.serverDisconnect(b, bluetoothDevice.getAddress());
        } catch (RemoteException unused) {
        }
    }

    public final void clearServices() {
        byte b;
        IBluetoothGatt iBluetoothGatt = this.d;
        if (iBluetoothGatt == null || (b = this.f) == 0) {
            return;
        }
        try {
            iBluetoothGatt.clearServices(b);
            this.g.clear();
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
                this.d.serverConnect(this.f, bluetoothDevice.getAddress(), !z);
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

    public final BluetoothGattService getService(UUID uuid) {
        for (BluetoothGattService bluetoothGattService : this.g) {
            if (bluetoothGattService.getUuid().equals(uuid)) {
                return bluetoothGattService;
            }
        }
        return null;
    }

    public final List getServices() {
        return this.g;
    }

    public final boolean isBLEDevice(BluetoothDevice bluetoothDevice) {
        return bluetoothDevice != null && bluetoothDevice.getDeviceType() == 2;
    }

    public final boolean notifyCharacteristicChanged(BluetoothDevice bluetoothDevice, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        BluetoothGattService service;
        if (bluetoothDevice == null) {
            return false;
        }
        String str = "notifyCharacteristicChanged() - device: " + bluetoothDevice.getAddress();
        if (bluetoothGattCharacteristic == null || this.d == null || this.f == 0 || (service = bluetoothGattCharacteristic.getService()) == null || bluetoothGattCharacteristic.getValue() == null) {
            return false;
        }
        try {
            this.d.sendNotification(this.f, bluetoothDevice.getAddress(), service.getType(), service.getInstanceId(), new ParcelUuid(service.getUuid()), bluetoothGattCharacteristic.getInstanceId(), new ParcelUuid(bluetoothGattCharacteristic.getUuid()), z, bluetoothGattCharacteristic.getValue());
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }

    public final boolean registerApp(BluetoothGattServerCallback bluetoothGattServerCallback) {
        if (bluetoothGattServerCallback == null || this.d == null) {
            return false;
        }
        this.e = bluetoothGattServerCallback;
        UUID uuidRandomUUID = UUID.randomUUID();
        String str = "registerApp() - UUID=" + uuidRandomUUID;
        try {
            this.d.registerServer(new ParcelUuid(uuidRandomUUID), this.j);
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }

    public final boolean removeBond(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice != null) {
            return bluetoothDevice.removeBond();
        }
        return false;
    }

    public final boolean removeService(BluetoothGattService bluetoothGattService) {
        BluetoothGattService bluetoothGattServiceA;
        if (bluetoothGattService == null) {
            return false;
        }
        String str = "removeService() - service: " + bluetoothGattService.getUuid();
        if (this.d == null || this.f == 0 || (bluetoothGattServiceA = a(bluetoothGattService.getUuid(), bluetoothGattService.getInstanceId(), bluetoothGattService.getType())) == null) {
            return false;
        }
        try {
            this.d.removeService(this.f, bluetoothGattService.getType(), bluetoothGattService.getInstanceId(), new ParcelUuid(bluetoothGattService.getUuid()));
            this.g.remove(bluetoothGattServiceA);
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }

    public final boolean sendResponse(BluetoothDevice bluetoothDevice, int i, int i2, int i3, byte[] bArr) {
        byte b;
        if (bluetoothDevice == null) {
            return false;
        }
        String str = "sendResponse() - device: " + bluetoothDevice.getAddress();
        IBluetoothGatt iBluetoothGatt = this.d;
        if (iBluetoothGatt != null && (b = this.f) != 0) {
            try {
                iBluetoothGatt.sendResponse(b, bluetoothDevice.getAddress(), i, i2, i3, bArr);
                return true;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    public final boolean startScan() {
        byte b;
        IBluetoothGatt iBluetoothGatt = this.d;
        if (iBluetoothGatt != null && (b = this.f) != 0) {
            try {
                return iBluetoothGatt.startScan(b, true);
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
                return this.d.startScanWithUuids(this.f, true, parcelUuidArr);
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
            iBluetoothGatt.stopScan(b, true);
        } catch (RemoteException unused) {
        }
    }

    public final void unregisterApp() {
        byte b;
        String str = "unregisterApp() - mServerIf=" + ((int) this.f);
        IBluetoothGatt iBluetoothGatt = this.d;
        if (iBluetoothGatt == null || (b = this.f) == 0) {
            return;
        }
        try {
            this.e = null;
            iBluetoothGatt.unregisterServer(b);
            this.f = (byte) 0;
        } catch (RemoteException unused) {
        }
    }
}
