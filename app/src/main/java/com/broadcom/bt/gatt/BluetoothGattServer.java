package com.broadcom.bt.gatt;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.IBluetoothManager;
import android.bluetooth.IBluetoothStateChangeCallback;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.ParcelUuid;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.broadcom.bt.gatt.IBluetoothGatt;
import com.broadcom.bt.gatt.IBluetoothGattServerCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public final class BluetoothGattServer implements BluetoothProfile {
    private static final boolean DBG = true;
    private static final String TAG = "BluetoothGattServer";
    private BluetoothAdapter mAdapter;
    private final IBluetoothGattServerCallback mBluetoothGattServerCallback;
    private final IBluetoothStateChangeCallback mBluetoothStateChangeCallback;
    private BluetoothGattServerCallback mCallback;
    private ServiceConnection mConnection;
    private Context mContext;
    private byte mServerIf;
    private IBluetoothGatt mService;
    private BluetoothProfile.ServiceListener mServiceListener;
    private List<BluetoothGattService> mServices;

    public BluetoothGattServer(Context context, BluetoothProfile.ServiceListener serviceListener) {
        IBluetoothStateChangeCallback.Stub stub = new IBluetoothStateChangeCallback.Stub() { // from class: com.broadcom.bt.gatt.BluetoothGattServer.1
            public void onBluetoothStateChange(boolean z) {
                String str = "onBluetoothStateChange: up=" + z;
                if (z) {
                    synchronized (BluetoothGattServer.this.mConnection) {
                        try {
                            if (BluetoothGattServer.this.mService == null) {
                                BluetoothGattServer.this.mContext.bindService(new Intent(IBluetoothGatt.class.getName()), BluetoothGattServer.this.mConnection, 0);
                            }
                        } catch (Exception unused) {
                        }
                    }
                    return;
                }
                synchronized (BluetoothGattServer.this.mConnection) {
                    try {
                        BluetoothGattServer.this.mService = null;
                        BluetoothGattServer.this.mContext.unbindService(BluetoothGattServer.this.mConnection);
                    } catch (Exception unused2) {
                    }
                }
            }
        };
        this.mBluetoothStateChangeCallback = stub;
        this.mConnection = new ServiceConnection() { // from class: com.broadcom.bt.gatt.BluetoothGattServer.2
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                BluetoothGattServer.this.mService = IBluetoothGatt.Stub.asInterface(iBinder);
                if (BluetoothGattServer.this.mServiceListener != null) {
                    BluetoothGattServer.this.mServiceListener.onServiceConnected(8, BluetoothGattServer.this);
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                BluetoothGattServer.this.mService = null;
                if (BluetoothGattServer.this.mServiceListener != null) {
                    BluetoothGattServer.this.mServiceListener.onServiceDisconnected(8);
                }
            }
        };
        this.mBluetoothGattServerCallback = new IBluetoothGattServerCallback.Stub() { // from class: com.broadcom.bt.gatt.BluetoothGattServer.3
            @Override // com.broadcom.bt.gatt.IBluetoothGattServerCallback
            public void onCharacteristicReadRequest(String str, int i, int i2, boolean z, int i3, int i4, ParcelUuid parcelUuid, int i5, ParcelUuid parcelUuid2) {
                BluetoothGattCharacteristic characteristic;
                UUID uuid = parcelUuid.getUuid();
                UUID uuid2 = parcelUuid2.getUuid();
                String str2 = "onCharacteristicReadRequest() - service=" + uuid + ", characteristic=" + uuid2;
                BluetoothDevice remoteDevice = BluetoothGattServer.this.mAdapter.getRemoteDevice(str);
                BluetoothGattService service = BluetoothGattServer.this.getService(uuid, i4, i3);
                if (service == null || (characteristic = service.getCharacteristic(uuid2)) == null || BluetoothGattServer.this.mCallback == null) {
                    return;
                }
                BluetoothGattServer.this.mCallback.onCharacteristicReadRequest(remoteDevice, i, i2, characteristic);
            }

            @Override // com.broadcom.bt.gatt.IBluetoothGattServerCallback
            public void onCharacteristicWriteRequest(String str, int i, int i2, int i3, boolean z, boolean z2, int i4, int i5, ParcelUuid parcelUuid, int i6, ParcelUuid parcelUuid2, byte[] bArr) {
                BluetoothGattCharacteristic characteristic;
                UUID uuid = parcelUuid.getUuid();
                UUID uuid2 = parcelUuid2.getUuid();
                String str2 = "onCharacteristicWriteRequest() - service=" + uuid + ", characteristic=" + uuid2;
                BluetoothDevice remoteDevice = BluetoothGattServer.this.mAdapter.getRemoteDevice(str);
                BluetoothGattService service = BluetoothGattServer.this.getService(uuid, i5, i4);
                if (service == null || (characteristic = service.getCharacteristic(uuid2)) == null || BluetoothGattServer.this.mCallback == null) {
                    return;
                }
                BluetoothGattServer.this.mCallback.onCharacteristicWriteRequest(remoteDevice, i, characteristic, z, z2, i2, bArr);
            }

            @Override // com.broadcom.bt.gatt.IBluetoothGattServerCallback
            public void onDescriptorReadRequest(String str, int i, int i2, boolean z, int i3, int i4, ParcelUuid parcelUuid, int i5, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3) {
                BluetoothGattCharacteristic characteristic;
                BluetoothGattDescriptor descriptor;
                UUID uuid = parcelUuid.getUuid();
                UUID uuid2 = parcelUuid2.getUuid();
                UUID uuid3 = parcelUuid3.getUuid();
                String str2 = "onCharacteristicReadRequest() - service=" + uuid + ", characteristic=" + uuid2 + "descriptor=" + uuid3;
                BluetoothDevice remoteDevice = BluetoothGattServer.this.mAdapter.getRemoteDevice(str);
                BluetoothGattService service = BluetoothGattServer.this.getService(uuid, i4, i3);
                if (service == null || (characteristic = service.getCharacteristic(uuid2)) == null || (descriptor = characteristic.getDescriptor(uuid3)) == null || BluetoothGattServer.this.mCallback == null) {
                    return;
                }
                BluetoothGattServer.this.mCallback.onDescriptorReadRequest(remoteDevice, i, i2, descriptor);
            }

            @Override // com.broadcom.bt.gatt.IBluetoothGattServerCallback
            public void onDescriptorWriteRequest(String str, int i, int i2, int i3, boolean z, boolean z2, int i4, int i5, ParcelUuid parcelUuid, int i6, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr) {
                BluetoothGattCharacteristic characteristic;
                BluetoothGattDescriptor descriptor;
                UUID uuid = parcelUuid.getUuid();
                UUID uuid2 = parcelUuid2.getUuid();
                UUID uuid3 = parcelUuid3.getUuid();
                String str2 = "onDescriptorWriteRequest() - service=" + uuid + ", characteristic=" + uuid2 + "descriptor=" + uuid3;
                BluetoothDevice remoteDevice = BluetoothGattServer.this.mAdapter.getRemoteDevice(str);
                BluetoothGattService service = BluetoothGattServer.this.getService(uuid, i5, i4);
                if (service == null || (characteristic = service.getCharacteristic(uuid2)) == null || (descriptor = characteristic.getDescriptor(uuid3)) == null || BluetoothGattServer.this.mCallback == null) {
                    return;
                }
                BluetoothGattServer.this.mCallback.onDescriptorWriteRequest(remoteDevice, i, descriptor, z, z2, i2, bArr);
            }

            @Override // com.broadcom.bt.gatt.IBluetoothGattServerCallback
            public void onExecuteWrite(String str, int i, boolean z) {
                String str2 = "onExecuteWrite() - device=" + str + ", transId=" + i + "execWrite=" + z;
                BluetoothDevice remoteDevice = BluetoothGattServer.this.mAdapter.getRemoteDevice(str);
                if (remoteDevice == null || BluetoothGattServer.this.mCallback == null) {
                    return;
                }
                BluetoothGattServer.this.mCallback.onExecuteWrite(remoteDevice, i, z);
            }

            @Override // com.broadcom.bt.gatt.IBluetoothGattServerCallback
            public void onScanResult(String str, int i, byte[] bArr) {
                String str2 = "onScanResult() - Device=" + str + " RSSI=" + i;
                if (BluetoothGattServer.this.mCallback != null) {
                    BluetoothGattServer.this.mCallback.onScanResult(BluetoothGattServer.this.mAdapter.getRemoteDevice(str), i, bArr);
                }
            }

            @Override // com.broadcom.bt.gatt.IBluetoothGattServerCallback
            public void onServerConnectionState(byte b, byte b2, boolean z, String str) {
                String str2 = "onServerConnectionState() - status=" + ((int) b) + " serverIf=" + ((int) b2) + " device=" + str;
                if (BluetoothGattServer.this.mCallback != null) {
                    BluetoothGattServer.this.mCallback.onConnectionStateChange(BluetoothGattServer.this.mAdapter.getRemoteDevice(str), b, z ? 2 : 0);
                }
            }

            @Override // com.broadcom.bt.gatt.IBluetoothGattServerCallback
            public void onServerRegistered(byte b, byte b2) {
                String str = "onServerRegistered() - status=" + ((int) b) + " serverIf=" + ((int) b2);
                BluetoothGattServer.this.mServerIf = b2;
                if (BluetoothGattServer.this.mCallback != null) {
                    BluetoothGattServer.this.mCallback.onAppRegistered(b);
                }
            }

            @Override // com.broadcom.bt.gatt.IBluetoothGattServerCallback
            public void onServiceAdded(byte b, int i, int i2, ParcelUuid parcelUuid) {
                UUID uuid = parcelUuid.getUuid();
                String str = "onServiceAdded() - service=" + uuid + "status=" + ((int) b);
                BluetoothGattService service = BluetoothGattServer.this.getService(uuid, i2, i);
                if (service == null || BluetoothGattServer.this.mCallback == null) {
                    return;
                }
                BluetoothGattServer.this.mCallback.onServiceAdded(b, service);
            }
        };
        this.mContext = context;
        this.mServiceListener = serviceListener;
        this.mAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mServices = new ArrayList();
        IBinder service = ServiceManager.getService("bluetooth_manager");
        if (service != null) {
            try {
                IBluetoothManager.Stub.asInterface(service).registerStateChangeCallback(stub);
            } catch (RemoteException unused) {
            }
        }
        if (this.mAdapter.isEnabled()) {
            context.bindService(new Intent(IBluetoothGatt.class.getName()), this.mConnection, 0);
        }
    }

    public boolean addService(BluetoothGattService bluetoothGattService) {
        String str = "addService() - service: " + bluetoothGattService.getUuid();
        if (this.mService != null && this.mServerIf != 0) {
            this.mServices.add(bluetoothGattService);
            try {
                this.mService.beginServiceDeclaration(this.mServerIf, bluetoothGattService.getType(), bluetoothGattService.getInstanceId(), bluetoothGattService.getHandles(), new ParcelUuid(bluetoothGattService.getUuid()));
                for (BluetoothGattService bluetoothGattService2 : bluetoothGattService.getIncludedServices()) {
                    this.mService.addIncludedService(this.mServerIf, bluetoothGattService2.getType(), bluetoothGattService2.getInstanceId(), new ParcelUuid(bluetoothGattService2.getUuid()));
                }
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                    this.mService.addCharacteristic(this.mServerIf, new ParcelUuid(bluetoothGattCharacteristic.getUuid()), bluetoothGattCharacteristic.getProperties(), ((bluetoothGattCharacteristic.getKeySize() - 7) << 12) + bluetoothGattCharacteristic.getPermissions());
                    for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                        this.mService.addDescriptor(this.mServerIf, new ParcelUuid(bluetoothGattDescriptor.getUuid()), bluetoothGattDescriptor.getPermissions());
                    }
                }
                this.mService.endServiceDeclaration(this.mServerIf);
                return true;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    public void cancelConnection(BluetoothDevice bluetoothDevice) {
        byte b;
        String str = "cancelConnection() - device: " + bluetoothDevice.getAddress();
        IBluetoothGatt iBluetoothGatt = this.mService;
        if (iBluetoothGatt == null || (b = this.mServerIf) == 0) {
            return;
        }
        try {
            iBluetoothGatt.serverDisconnect(b, bluetoothDevice.getAddress());
        } catch (RemoteException unused) {
        }
    }

    public void clearServices() {
        byte b;
        IBluetoothGatt iBluetoothGatt = this.mService;
        if (iBluetoothGatt == null || (b = this.mServerIf) == 0) {
            return;
        }
        try {
            iBluetoothGatt.clearServices(b);
            this.mServices.clear();
        } catch (RemoteException unused) {
        }
    }

    public void close() {
        unregisterApp();
        this.mServiceListener = null;
        IBinder service = ServiceManager.getService("bluetooth_manager");
        if (service != null) {
            try {
                IBluetoothManager.Stub.asInterface(service).unregisterStateChangeCallback(this.mBluetoothStateChangeCallback);
            } catch (RemoteException unused) {
            }
        }
        synchronized (this.mConnection) {
            if (this.mService != null) {
                try {
                    this.mService = null;
                    this.mContext.unbindService(this.mConnection);
                } catch (Exception unused2) {
                }
            }
        }
    }

    public boolean connect(BluetoothDevice bluetoothDevice, boolean z) {
        byte b;
        String str = "connect() - device: " + bluetoothDevice.getAddress() + ", auto: " + z;
        IBluetoothGatt iBluetoothGatt = this.mService;
        if (iBluetoothGatt != null && (b = this.mServerIf) != 0) {
            try {
                iBluetoothGatt.serverConnect(b, bluetoothDevice.getAddress(), !z);
                return true;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    @Override // android.bluetooth.BluetoothProfile
    public List<BluetoothDevice> getConnectedDevices() {
        ArrayList arrayList = new ArrayList();
        IBluetoothGatt iBluetoothGatt = this.mService;
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
    public int getConnectionState(BluetoothDevice bluetoothDevice) {
        if (this.mService == null) {
            return 0;
        }
        Iterator<BluetoothDevice> it = getConnectedDevices().iterator();
        while (it.hasNext()) {
            if (bluetoothDevice.equals(it.next())) {
                return 2;
            }
        }
        return 0;
    }

    @Override // android.bluetooth.BluetoothProfile
    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        IBluetoothGatt iBluetoothGatt = this.mService;
        if (iBluetoothGatt == null) {
            return arrayList;
        }
        try {
            return iBluetoothGatt.getDevicesMatchingConnectionStates(iArr);
        } catch (RemoteException unused) {
            return arrayList;
        }
    }

    public BluetoothGattService getService(UUID uuid, int i, int i2) {
        for (BluetoothGattService bluetoothGattService : this.mServices) {
            if (bluetoothGattService.getType() == i2 && bluetoothGattService.getInstanceId() == i && bluetoothGattService.getUuid().equals(uuid)) {
                return bluetoothGattService;
            }
        }
        return null;
    }

    public List<BluetoothGattService> getServices() {
        return this.mServices;
    }

    public boolean notifyCharacteristicChanged(BluetoothDevice bluetoothDevice, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        BluetoothGattService service;
        String str = "notifyCharacteristicChanged() - device: " + bluetoothDevice.getAddress();
        if (this.mService == null || this.mServerIf == 0 || (service = bluetoothGattCharacteristic.getService()) == null) {
            return false;
        }
        try {
            this.mService.sendNotification(this.mServerIf, bluetoothDevice.getAddress(), service.getType(), service.getInstanceId(), new ParcelUuid(service.getUuid()), bluetoothGattCharacteristic.getInstanceId(), new ParcelUuid(bluetoothGattCharacteristic.getUuid()), z, bluetoothGattCharacteristic.getValue());
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }

    public boolean registerApp(BluetoothGattServerCallback bluetoothGattServerCallback) {
        if (this.mService == null) {
            return false;
        }
        this.mCallback = bluetoothGattServerCallback;
        UUID uuidRandomUUID = UUID.randomUUID();
        String str = "registerApp() - UUID=" + uuidRandomUUID;
        try {
            this.mService.registerServer(new ParcelUuid(uuidRandomUUID), this.mBluetoothGattServerCallback);
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }

    public boolean removeService(BluetoothGattService bluetoothGattService) {
        BluetoothGattService service;
        String str = "removeService() - service: " + bluetoothGattService.getUuid();
        if (this.mService == null || this.mServerIf == 0 || (service = getService(bluetoothGattService.getUuid(), bluetoothGattService.getInstanceId(), bluetoothGattService.getType())) == null) {
            return false;
        }
        try {
            this.mService.removeService(this.mServerIf, bluetoothGattService.getType(), bluetoothGattService.getInstanceId(), new ParcelUuid(bluetoothGattService.getUuid()));
            this.mServices.remove(service);
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }

    public boolean sendResponse(BluetoothDevice bluetoothDevice, int i, int i2, int i3, byte[] bArr) {
        byte b;
        String str = "sendResponse() - device: " + bluetoothDevice.getAddress();
        IBluetoothGatt iBluetoothGatt = this.mService;
        if (iBluetoothGatt != null && (b = this.mServerIf) != 0) {
            try {
                iBluetoothGatt.sendResponse(b, bluetoothDevice.getAddress(), i, i2, i3, bArr);
                return true;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    public boolean startScan() {
        byte b;
        IBluetoothGatt iBluetoothGatt = this.mService;
        if (iBluetoothGatt != null && (b = this.mServerIf) != 0) {
            try {
                iBluetoothGatt.startScan(b, true);
                return true;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    public void stopScan() {
        byte b;
        IBluetoothGatt iBluetoothGatt = this.mService;
        if (iBluetoothGatt == null || (b = this.mServerIf) == 0) {
            return;
        }
        try {
            iBluetoothGatt.stopScan(b, true);
        } catch (RemoteException unused) {
        }
    }

    public void unregisterApp() {
        byte b;
        String str = "unregisterApp() - mServerIf=" + ((int) this.mServerIf);
        IBluetoothGatt iBluetoothGatt = this.mService;
        if (iBluetoothGatt == null || (b = this.mServerIf) == 0) {
            return;
        }
        try {
            this.mCallback = null;
            iBluetoothGatt.unregisterServer(b);
            this.mServerIf = (byte) 0;
        } catch (RemoteException unused) {
        }
    }

    public BluetoothGattService getService(UUID uuid) {
        for (BluetoothGattService bluetoothGattService : this.mServices) {
            if (bluetoothGattService.getUuid().equals(uuid)) {
                return bluetoothGattService;
            }
        }
        return null;
    }

    public boolean startScan(UUID[] uuidArr) {
        if (this.mService != null && this.mServerIf != 0) {
            try {
                int length = uuidArr.length;
                ParcelUuid[] parcelUuidArr = new ParcelUuid[length];
                for (int i = 0; i != length; i++) {
                    parcelUuidArr[i] = new ParcelUuid(uuidArr[i]);
                }
                this.mService.startScanWithUuids(this.mServerIf, true, parcelUuidArr);
                return true;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }
}
