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
import com.broadcom.bt.gatt.IBluetoothGattCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public final class BluetoothGatt implements BluetoothProfile {
    public static final byte AUTHENTICATION_MITM = 2;
    public static final byte AUTHENTICATION_NONE = 0;
    public static final byte AUTHENTICATION_NO_MITM = 1;
    private static final boolean DBG = true;
    public static final int GATT_INSUFFICIENT_AUTHENTICATION = 5;
    public static final int GATT_INSUFFICIENT_ENCRYPTION = 15;
    public static final int GATT_INVALID_ATTRIBUTE_LENGTH = 13;
    public static final int GATT_INVALID_OFFSET = 7;
    public static final int GATT_READ_NOT_PERMITTED = 2;
    public static final int GATT_REQUEST_NOT_SUPPORTED = 6;
    public static final int GATT_SUCCESS = 0;
    public static final int GATT_WRITE_NOT_PERMITTED = 2;
    private static final String TAG = "BtGatt.BluetoothGatt";
    private BluetoothAdapter mAdapter;
    private boolean mAuthRetry = false;
    private final IBluetoothGattCallback mBluetoothGattCallback;
    private final IBluetoothStateChangeCallback mBluetoothStateChangeCallback;
    private BluetoothGattCallback mCallback;
    private byte mClientIf;
    private ServiceConnection mConnection;
    private Context mContext;
    private IBluetoothGatt mService;
    private BluetoothProfile.ServiceListener mServiceListener;
    private List<BluetoothGattService> mServices;

    public BluetoothGatt(Context context, BluetoothProfile.ServiceListener serviceListener) {
        IBluetoothStateChangeCallback.Stub stub = new IBluetoothStateChangeCallback.Stub() { // from class: com.broadcom.bt.gatt.BluetoothGatt.1
            public void onBluetoothStateChange(boolean z) {
                String str = "onBluetoothStateChange: up=" + z;
                if (z) {
                    synchronized (BluetoothGatt.this.mConnection) {
                        try {
                            if (BluetoothGatt.this.mService == null) {
                                BluetoothGatt.this.mContext.bindService(new Intent(IBluetoothGatt.class.getName()), BluetoothGatt.this.mConnection, 0);
                            }
                        } catch (Exception unused) {
                        }
                    }
                    return;
                }
                synchronized (BluetoothGatt.this.mConnection) {
                    try {
                        BluetoothGatt.this.mService = null;
                        BluetoothGatt.this.mContext.unbindService(BluetoothGatt.this.mConnection);
                    } catch (Exception unused2) {
                    }
                }
            }
        };
        this.mBluetoothStateChangeCallback = stub;
        this.mConnection = new ServiceConnection() { // from class: com.broadcom.bt.gatt.BluetoothGatt.2
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                BluetoothGatt.this.mService = IBluetoothGatt.Stub.asInterface(iBinder);
                if (BluetoothGatt.this.mServiceListener != null) {
                    BluetoothGatt.this.mServiceListener.onServiceConnected(7, BluetoothGatt.this);
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                BluetoothGatt.this.mService = null;
                if (BluetoothGatt.this.mServiceListener != null) {
                    BluetoothGatt.this.mServiceListener.onServiceDisconnected(7);
                }
            }
        };
        this.mBluetoothGattCallback = new IBluetoothGattCallback.Stub() { // from class: com.broadcom.bt.gatt.BluetoothGatt.3
            @Override // com.broadcom.bt.gatt.IBluetoothGattCallback
            public void onCharacteristicRead(String str, int i, int i2, int i3, ParcelUuid parcelUuid, int i4, ParcelUuid parcelUuid2, byte[] bArr) {
                BluetoothGattCharacteristic characteristic;
                String str2 = "onCharacteristicRead() - Device=" + str + " UUID=" + parcelUuid2 + " Status=" + i;
                if ((i == 5 || i == 15) && !BluetoothGatt.this.mAuthRetry) {
                    try {
                        BluetoothGatt.this.mAuthRetry = true;
                        BluetoothGatt.this.mService.readCharacteristic(BluetoothGatt.this.mClientIf, str, i2, i3, parcelUuid, i4, parcelUuid2, (byte) 2);
                        return;
                    } catch (RemoteException unused) {
                    }
                }
                BluetoothGatt.this.mAuthRetry = false;
                BluetoothGattService service = BluetoothGatt.this.getService(BluetoothGatt.this.mAdapter.getRemoteDevice(str), parcelUuid.getUuid(), i3, i2);
                if (service == null || (characteristic = service.getCharacteristic(parcelUuid2.getUuid(), i4)) == null) {
                    return;
                }
                if (i == 0) {
                    characteristic.setValue(bArr);
                }
                if (BluetoothGatt.this.mCallback != null) {
                    BluetoothGatt.this.mCallback.onCharacteristicRead(characteristic, i);
                }
            }

            @Override // com.broadcom.bt.gatt.IBluetoothGattCallback
            public void onCharacteristicWrite(String str, int i, int i2, int i3, ParcelUuid parcelUuid, int i4, ParcelUuid parcelUuid2) {
                BluetoothGattCharacteristic characteristic;
                String str2 = "onCharacteristicWrite() - Device=" + str + " UUID=" + parcelUuid2 + " Status=" + i;
                BluetoothGattService service = BluetoothGatt.this.getService(BluetoothGatt.this.mAdapter.getRemoteDevice(str), parcelUuid.getUuid(), i3, i2);
                if (service == null || (characteristic = service.getCharacteristic(parcelUuid2.getUuid(), i4)) == null) {
                    return;
                }
                if ((i == 5 || i == 15) && !BluetoothGatt.this.mAuthRetry) {
                    try {
                        BluetoothGatt.this.mAuthRetry = true;
                        BluetoothGatt.this.mService.writeCharacteristic(BluetoothGatt.this.mClientIf, str, i2, i3, parcelUuid, i4, parcelUuid2, characteristic.getWriteType(), (byte) 2, characteristic.getValue());
                        return;
                    } catch (RemoteException unused) {
                    }
                }
                BluetoothGatt.this.mAuthRetry = false;
                if (BluetoothGatt.this.mCallback != null) {
                    BluetoothGatt.this.mCallback.onCharacteristicWrite(characteristic, i);
                }
            }

            @Override // com.broadcom.bt.gatt.IBluetoothGattCallback
            public void onClientConnectionState(byte b, byte b2, boolean z, String str) {
                String str2 = "onClientConnectionState() - status=" + ((int) b) + " clientIf=" + ((int) b2) + " device=" + str;
                if (BluetoothGatt.this.mCallback != null) {
                    BluetoothGatt.this.mCallback.onConnectionStateChange(BluetoothGatt.this.mAdapter.getRemoteDevice(str), b, z ? 2 : 0);
                }
            }

            @Override // com.broadcom.bt.gatt.IBluetoothGattCallback
            public void onClientRegistered(byte b, byte b2) {
                String str = "onClientRegistered() - status=" + ((int) b) + " clientIf=" + ((int) b2);
                BluetoothGatt.this.mClientIf = b2;
                if (BluetoothGatt.this.mCallback != null) {
                    BluetoothGatt.this.mCallback.onAppRegistered(b);
                }
            }

            @Override // com.broadcom.bt.gatt.IBluetoothGattCallback
            public void onDescriptorRead(String str, int i, int i2, int i3, ParcelUuid parcelUuid, int i4, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr) {
                BluetoothGattCharacteristic characteristic;
                BluetoothGattDescriptor descriptor;
                String str2 = "onDescriptorRead() - Device=" + str + " UUID=" + parcelUuid2;
                BluetoothGattService service = BluetoothGatt.this.getService(BluetoothGatt.this.mAdapter.getRemoteDevice(str), parcelUuid.getUuid(), i3, i2);
                if (service == null || (characteristic = service.getCharacteristic(parcelUuid2.getUuid(), i4)) == null || (descriptor = characteristic.getDescriptor(parcelUuid3.getUuid())) == null) {
                    return;
                }
                if (i == 0) {
                    descriptor.setValue(bArr);
                }
                if ((i == 5 || i == 15) && !BluetoothGatt.this.mAuthRetry) {
                    try {
                        BluetoothGatt.this.mAuthRetry = true;
                        BluetoothGatt.this.mService.readDescriptor(BluetoothGatt.this.mClientIf, str, i2, i3, parcelUuid, i4, parcelUuid2, parcelUuid3, (byte) 2);
                    } catch (RemoteException unused) {
                    }
                }
                BluetoothGatt.this.mAuthRetry = true;
                if (BluetoothGatt.this.mCallback != null) {
                    BluetoothGatt.this.mCallback.onDescriptorRead(descriptor, i);
                }
            }

            @Override // com.broadcom.bt.gatt.IBluetoothGattCallback
            public void onDescriptorWrite(String str, int i, int i2, int i3, ParcelUuid parcelUuid, int i4, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3) {
                BluetoothGattCharacteristic characteristic;
                BluetoothGattDescriptor descriptor;
                String str2 = "onDescriptorWrite() - Device=" + str + " UUID=" + parcelUuid2;
                BluetoothGattService service = BluetoothGatt.this.getService(BluetoothGatt.this.mAdapter.getRemoteDevice(str), parcelUuid.getUuid(), i3, i2);
                if (service == null || (characteristic = service.getCharacteristic(parcelUuid2.getUuid(), i4)) == null || (descriptor = characteristic.getDescriptor(parcelUuid3.getUuid())) == null) {
                    return;
                }
                if ((i == 5 || i == 15) && !BluetoothGatt.this.mAuthRetry) {
                    try {
                        BluetoothGatt.this.mAuthRetry = true;
                        BluetoothGatt.this.mService.writeDescriptor(BluetoothGatt.this.mClientIf, str, i2, i3, parcelUuid, i4, parcelUuid2, parcelUuid3, characteristic.getWriteType(), (byte) 2, descriptor.getValue());
                    } catch (RemoteException unused) {
                    }
                }
                BluetoothGatt.this.mAuthRetry = false;
                if (BluetoothGatt.this.mCallback != null) {
                    BluetoothGatt.this.mCallback.onDescriptorWrite(descriptor, i);
                }
            }

            @Override // com.broadcom.bt.gatt.IBluetoothGattCallback
            public void onExecuteWrite(String str, int i) {
                String str2 = "onExecuteWrite() - Device=" + str + " status=" + i;
                BluetoothDevice remoteDevice = BluetoothGatt.this.mAdapter.getRemoteDevice(str);
                if (BluetoothGatt.this.mCallback != null) {
                    BluetoothGatt.this.mCallback.onReliableWriteCompleted(remoteDevice, i);
                }
            }

            @Override // com.broadcom.bt.gatt.IBluetoothGattCallback
            public void onGetCharacteristic(String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, int i4) {
                String str2 = "onGetCharacteristic() - Device=" + str + " UUID=" + parcelUuid2;
                BluetoothGattService service = BluetoothGatt.this.getService(BluetoothGatt.this.mAdapter.getRemoteDevice(str), parcelUuid.getUuid(), i2, i);
                if (service != null) {
                    service.addCharacteristic(new BluetoothGattCharacteristic(service, parcelUuid2.getUuid(), i3, i4, 0));
                }
            }

            @Override // com.broadcom.bt.gatt.IBluetoothGattCallback
            public void onGetDescriptor(String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3) {
                BluetoothGattCharacteristic characteristic;
                String str2 = "onGetDescriptor() - Device=" + str + " UUID=" + parcelUuid3;
                BluetoothGattService service = BluetoothGatt.this.getService(BluetoothGatt.this.mAdapter.getRemoteDevice(str), parcelUuid.getUuid(), i2, i);
                if (service == null || (characteristic = service.getCharacteristic(parcelUuid2.getUuid())) == null) {
                    return;
                }
                characteristic.addDescriptor(new BluetoothGattDescriptor(characteristic, parcelUuid3.getUuid(), 0));
            }

            @Override // com.broadcom.bt.gatt.IBluetoothGattCallback
            public void onGetIncludedService(String str, int i, int i2, ParcelUuid parcelUuid, int i3, int i4, ParcelUuid parcelUuid2) {
                String str2 = "onGetIncludedService() - Device=" + str + " UUID=" + parcelUuid + " Included=" + parcelUuid2;
                BluetoothDevice remoteDevice = BluetoothGatt.this.mAdapter.getRemoteDevice(str);
                BluetoothGattService service = BluetoothGatt.this.getService(remoteDevice, parcelUuid.getUuid(), i2, i);
                BluetoothGattService service2 = BluetoothGatt.this.getService(remoteDevice, parcelUuid2.getUuid(), i4, i3);
                if (service == null || service2 == null) {
                    return;
                }
                service.addIncludedService(service2);
            }

            @Override // com.broadcom.bt.gatt.IBluetoothGattCallback
            public void onGetService(String str, int i, int i2, ParcelUuid parcelUuid) {
                String str2 = "onGetService() - Device=" + str + " UUID=" + parcelUuid;
                BluetoothGatt.this.mServices.add(new BluetoothGattService(BluetoothGatt.this.mAdapter.getRemoteDevice(str), parcelUuid.getUuid(), i2, i));
            }

            @Override // com.broadcom.bt.gatt.IBluetoothGattCallback
            public void onNotify(String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, byte[] bArr) {
                BluetoothGattCharacteristic characteristic;
                String str2 = "onNotify() - Device=" + str + " UUID=" + parcelUuid2;
                BluetoothGattService service = BluetoothGatt.this.getService(BluetoothGatt.this.mAdapter.getRemoteDevice(str), parcelUuid.getUuid(), i2, i);
                if (service == null || (characteristic = service.getCharacteristic(parcelUuid2.getUuid(), i3)) == null) {
                    return;
                }
                characteristic.setValue(bArr);
                if (BluetoothGatt.this.mCallback != null) {
                    BluetoothGatt.this.mCallback.onCharacteristicChanged(characteristic);
                }
            }

            @Override // com.broadcom.bt.gatt.IBluetoothGattCallback
            public void onReadRemoteRssi(String str, int i, int i2) {
                String str2 = "onReadRemoteRssi() - Device=" + str + " rssi=" + i + " status=" + i2;
                BluetoothDevice remoteDevice = BluetoothGatt.this.mAdapter.getRemoteDevice(str);
                if (BluetoothGatt.this.mCallback != null) {
                    BluetoothGatt.this.mCallback.onReadRemoteRssi(remoteDevice, i, i2);
                }
            }

            @Override // com.broadcom.bt.gatt.IBluetoothGattCallback
            public void onScanResult(String str, int i, byte[] bArr) {
                String str2 = "onScanResult() - Device=" + str + " RSSI=" + i;
                if (BluetoothGatt.this.mCallback != null) {
                    BluetoothGatt.this.mCallback.onScanResult(BluetoothGatt.this.mAdapter.getRemoteDevice(str), i, bArr);
                }
            }

            @Override // com.broadcom.bt.gatt.IBluetoothGattCallback
            public void onSearchComplete(String str, int i) {
                String str2 = "onSearchComplete() = Device=" + str + " Status=" + i;
                if (BluetoothGatt.this.mCallback != null) {
                    BluetoothGatt.this.mCallback.onServicesDiscovered(BluetoothGatt.this.mAdapter.getRemoteDevice(str), i);
                }
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

    public void abortReliableWrite(BluetoothDevice bluetoothDevice) {
        byte b;
        String str = "abortReliableWrite() - device: " + bluetoothDevice.getAddress();
        IBluetoothGatt iBluetoothGatt = this.mService;
        if (iBluetoothGatt == null || (b = this.mClientIf) == 0) {
            return;
        }
        try {
            iBluetoothGatt.endReliableWrite(b, bluetoothDevice.getAddress(), false);
        } catch (RemoteException unused) {
        }
    }

    public boolean beginReliableWrite(BluetoothDevice bluetoothDevice) {
        byte b;
        String str = "beginReliableWrite() - device: " + bluetoothDevice.getAddress();
        IBluetoothGatt iBluetoothGatt = this.mService;
        if (iBluetoothGatt != null && (b = this.mClientIf) != 0) {
            try {
                iBluetoothGatt.beginReliableWrite(b, bluetoothDevice.getAddress());
                return true;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    public void cancelConnection(BluetoothDevice bluetoothDevice) {
        byte b;
        String str = "cancelOpen() - device: " + bluetoothDevice.getAddress();
        IBluetoothGatt iBluetoothGatt = this.mService;
        if (iBluetoothGatt == null || (b = this.mClientIf) == 0) {
            return;
        }
        try {
            iBluetoothGatt.clientDisconnect(b, bluetoothDevice.getAddress());
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
        if (iBluetoothGatt != null && (b = this.mClientIf) != 0) {
            try {
                iBluetoothGatt.clientConnect(b, bluetoothDevice.getAddress(), !z);
                return true;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    public boolean discoverServices(BluetoothDevice bluetoothDevice) {
        String str = "discoverServices() - device: " + bluetoothDevice.getAddress();
        if (this.mService != null && this.mClientIf != 0) {
            this.mServices.clear();
            try {
                this.mService.discoverServices(this.mClientIf, bluetoothDevice.getAddress());
                return true;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    public boolean executeReliableWrite(BluetoothDevice bluetoothDevice) {
        byte b;
        String str = "executeReliableWrite() - device: " + bluetoothDevice.getAddress();
        IBluetoothGatt iBluetoothGatt = this.mService;
        if (iBluetoothGatt != null && (b = this.mClientIf) != 0) {
            try {
                iBluetoothGatt.endReliableWrite(b, bluetoothDevice.getAddress(), true);
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

    public BluetoothGattService getService(BluetoothDevice bluetoothDevice, UUID uuid, int i, int i2) {
        for (BluetoothGattService bluetoothGattService : this.mServices) {
            if (bluetoothGattService.getDevice().equals(bluetoothDevice) && bluetoothGattService.getType() == i2 && bluetoothGattService.getInstanceId() == i && bluetoothGattService.getUuid().equals(uuid)) {
                return bluetoothGattService;
            }
        }
        return null;
    }

    public List<BluetoothGattService> getServices(BluetoothDevice bluetoothDevice) {
        ArrayList arrayList = new ArrayList();
        for (BluetoothGattService bluetoothGattService : this.mServices) {
            if (bluetoothGattService.getDevice().equals(bluetoothDevice)) {
                arrayList.add(bluetoothGattService);
            }
        }
        return arrayList;
    }

    public boolean readCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGattService service;
        BluetoothDevice device;
        if ((bluetoothGattCharacteristic.getProperties() & 2) == 0) {
            return false;
        }
        String str = "readCharacteristic() - uuid: " + bluetoothGattCharacteristic.getUuid();
        if (this.mService == null || this.mClientIf == 0 || (service = bluetoothGattCharacteristic.getService()) == null || (device = service.getDevice()) == null) {
            return false;
        }
        try {
            this.mService.readCharacteristic(this.mClientIf, device.getAddress(), service.getType(), service.getInstanceId(), new ParcelUuid(service.getUuid()), bluetoothGattCharacteristic.getInstanceId(), new ParcelUuid(bluetoothGattCharacteristic.getUuid()), (byte) 0);
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }

    public boolean readDescriptor(BluetoothGattDescriptor bluetoothGattDescriptor) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattService service;
        BluetoothDevice device;
        String str = "readDescriptor() - uuid: " + bluetoothGattDescriptor.getUuid();
        if (this.mService == null || this.mClientIf == 0 || (characteristic = bluetoothGattDescriptor.getCharacteristic()) == null || (service = characteristic.getService()) == null || (device = service.getDevice()) == null) {
            return false;
        }
        try {
            this.mService.readDescriptor(this.mClientIf, device.getAddress(), service.getType(), service.getInstanceId(), new ParcelUuid(service.getUuid()), characteristic.getInstanceId(), new ParcelUuid(characteristic.getUuid()), new ParcelUuid(bluetoothGattDescriptor.getUuid()), (byte) 0);
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }

    public boolean readRemoteRssi(BluetoothDevice bluetoothDevice) {
        byte b;
        String str = "readRssi() - device: " + bluetoothDevice.getAddress();
        IBluetoothGatt iBluetoothGatt = this.mService;
        if (iBluetoothGatt != null && (b = this.mClientIf) != 0) {
            try {
                iBluetoothGatt.readRemoteRssi(b, bluetoothDevice.getAddress());
                return true;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    public boolean refresh(BluetoothDevice bluetoothDevice) {
        byte b;
        String str = "refresh() - device: " + bluetoothDevice.getAddress();
        IBluetoothGatt iBluetoothGatt = this.mService;
        if (iBluetoothGatt != null && (b = this.mClientIf) != 0) {
            try {
                iBluetoothGatt.refreshDevice(b, bluetoothDevice.getAddress());
                return true;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    public boolean registerApp(BluetoothGattCallback bluetoothGattCallback) {
        if (this.mService == null) {
            return false;
        }
        this.mCallback = bluetoothGattCallback;
        UUID uuidRandomUUID = UUID.randomUUID();
        String str = "registerApp() - UUID=" + uuidRandomUUID;
        try {
            this.mService.registerClient(new ParcelUuid(uuidRandomUUID), this.mBluetoothGattCallback);
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }

    public boolean setCharacteristicNotification(BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        BluetoothGattService service;
        BluetoothDevice device;
        String str = "setCharacteristicNotification() - uuid: " + bluetoothGattCharacteristic.getUuid() + " enable: " + z;
        if (this.mService == null || this.mClientIf == 0 || (service = bluetoothGattCharacteristic.getService()) == null || (device = service.getDevice()) == null) {
            return false;
        }
        try {
            this.mService.registerForNotification(this.mClientIf, device.getAddress(), service.getType(), service.getInstanceId(), new ParcelUuid(service.getUuid()), bluetoothGattCharacteristic.getInstanceId(), new ParcelUuid(bluetoothGattCharacteristic.getUuid()), z);
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }

    public boolean startScan() {
        byte b;
        IBluetoothGatt iBluetoothGatt = this.mService;
        if (iBluetoothGatt != null && (b = this.mClientIf) != 0) {
            try {
                iBluetoothGatt.startScan(b, false);
                return true;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    public void stopScan() {
        byte b;
        IBluetoothGatt iBluetoothGatt = this.mService;
        if (iBluetoothGatt == null || (b = this.mClientIf) == 0) {
            return;
        }
        try {
            iBluetoothGatt.stopScan(b, false);
        } catch (RemoteException unused) {
        }
    }

    public void unregisterApp() {
        byte b;
        String str = "unregisterApp() - mClientIf=" + ((int) this.mClientIf);
        IBluetoothGatt iBluetoothGatt = this.mService;
        if (iBluetoothGatt == null || (b = this.mClientIf) == 0) {
            return;
        }
        try {
            this.mCallback = null;
            iBluetoothGatt.unregisterClient(b);
            this.mClientIf = (byte) 0;
        } catch (RemoteException unused) {
        }
    }

    public boolean writeCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGattService service;
        BluetoothDevice device;
        if ((bluetoothGattCharacteristic.getProperties() & 8) == 0 && (bluetoothGattCharacteristic.getProperties() & 4) == 0) {
            return false;
        }
        String str = "writeCharacteristic() - uuid: " + bluetoothGattCharacteristic.getUuid();
        if (this.mService == null || this.mClientIf == 0 || (service = bluetoothGattCharacteristic.getService()) == null || (device = service.getDevice()) == null) {
            return false;
        }
        try {
            this.mService.writeCharacteristic(this.mClientIf, device.getAddress(), service.getType(), service.getInstanceId(), new ParcelUuid(service.getUuid()), bluetoothGattCharacteristic.getInstanceId(), new ParcelUuid(bluetoothGattCharacteristic.getUuid()), bluetoothGattCharacteristic.getWriteType(), (byte) 0, bluetoothGattCharacteristic.getValue());
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }

    public boolean writeDescriptor(BluetoothGattDescriptor bluetoothGattDescriptor) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattService service;
        BluetoothDevice device;
        String str = "writeDescriptor() - uuid: " + bluetoothGattDescriptor.getUuid();
        if (this.mService == null || this.mClientIf == 0 || (characteristic = bluetoothGattDescriptor.getCharacteristic()) == null || (service = characteristic.getService()) == null || (device = service.getDevice()) == null) {
            return false;
        }
        try {
            this.mService.writeDescriptor(this.mClientIf, device.getAddress(), service.getType(), service.getInstanceId(), new ParcelUuid(service.getUuid()), characteristic.getInstanceId(), new ParcelUuid(characteristic.getUuid()), new ParcelUuid(bluetoothGattDescriptor.getUuid()), characteristic.getWriteType(), (byte) 0, bluetoothGattDescriptor.getValue());
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }

    public BluetoothGattService getService(BluetoothDevice bluetoothDevice, UUID uuid) {
        for (BluetoothGattService bluetoothGattService : this.mServices) {
            if (bluetoothGattService.getDevice().equals(bluetoothDevice) && bluetoothGattService.getUuid().equals(uuid)) {
                return bluetoothGattService;
            }
        }
        return null;
    }

    public boolean startScan(UUID[] uuidArr) {
        if (this.mService != null && this.mClientIf != 0) {
            try {
                int length = uuidArr.length;
                ParcelUuid[] parcelUuidArr = new ParcelUuid[length];
                for (int i = 0; i != length; i++) {
                    parcelUuidArr[i] = new ParcelUuid(uuidArr[i]);
                }
                this.mService.startScanWithUuids(this.mClientIf, false, parcelUuidArr);
                return true;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }
}
