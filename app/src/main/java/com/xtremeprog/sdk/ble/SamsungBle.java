package com.xtremeprog.sdk.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import com.google.firebase.database.DatabaseError;
import com.samsung.android.sdk.bt.gatt.BluetoothGatt;
import com.samsung.android.sdk.bt.gatt.BluetoothGattAdapter;
import com.samsung.android.sdk.bt.gatt.BluetoothGattCallback;
import com.samsung.android.sdk.bt.gatt.BluetoothGattCharacteristic;
import com.samsung.android.sdk.bt.gatt.BluetoothGattDescriptor;
import com.samsung.android.sdk.bt.gatt.BluetoothGattService;
import com.wear.util.WearUtils;
import com.xtremeprog.sdk.ble.BleRequest;
import dc.vt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.UUID;

/* loaded from: classes4.dex */
public class SamsungBle implements IBle, IBleRequestHandler {
    private BluetoothGatt mBluetoothGatt;
    private BluetoothAdapter mBtAdapter;
    private final BluetoothGattCallback mGattCallbacks = new BluetoothGattCallback() { // from class: com.xtremeprog.sdk.ble.SamsungBle.1
        @Override // com.samsung.android.sdk.bt.gatt.BluetoothGattCallback
        public void onAppRegistered(int i) {
        }

        @Override // com.samsung.android.sdk.bt.gatt.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            SamsungBle.this.mService.bleCharacteristicChanged(SamsungBle.this.mService.getNotificationAddress(), bluetoothGattCharacteristic.getUuid().toString(), bluetoothGattCharacteristic.getValue());
        }

        @Override // com.samsung.android.sdk.bt.gatt.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) throws InterruptedException {
            String str = SamsungBle.this.mService.getCurrentRequest().address;
            if (i != 0) {
                SamsungBle.this.mService.requestProcessed(str, BleRequest.RequestType.READ_CHARACTERISTIC, false);
            } else {
                SamsungBle.this.mService.bleCharacteristicRead(str, bluetoothGattCharacteristic.getUuid().toString(), i, bluetoothGattCharacteristic.getValue());
            }
        }

        @Override // com.samsung.android.sdk.bt.gatt.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) throws InterruptedException {
            String str = SamsungBle.this.mService.getCurrentRequest().address;
            if (i != 0) {
                SamsungBle.this.mService.requestProcessed(str, BleRequest.RequestType.WRITE_CHARACTERISTIC, false);
            } else {
                SamsungBle.this.mService.bleCharacteristicWrite(str, bluetoothGattCharacteristic.getUuid().toString(), i);
            }
        }

        @Override // com.samsung.android.sdk.bt.gatt.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothDevice bluetoothDevice, int i, int i2) throws InterruptedException {
            if (SamsungBle.this.mBluetoothGatt == null) {
                return;
            }
            SamsungBle.this.mService.bleConnectState(bluetoothDevice.getAddress(), i, i2);
            if (i != 0) {
                SamsungBle.this.disconnect(bluetoothDevice.getAddress());
                SamsungBle.this.mService.bleGattDisConnected(bluetoothDevice.getAddress(), i);
            } else if (i2 == 2) {
                SamsungBle.this.mService.bleGattConnected(bluetoothDevice);
                SamsungBle.this.mService.addBleRequest(new BleRequest(BleRequest.RequestType.DISCOVER_SERVICE, bluetoothDevice.getAddress()));
            } else if (i2 == 0) {
                SamsungBle.this.mService.bleGattDisConnected(bluetoothDevice.getAddress(), i);
                SamsungBle.this.disconnect(bluetoothDevice.getAddress());
            }
        }

        @Override // com.samsung.android.sdk.bt.gatt.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGattDescriptor bluetoothGattDescriptor, int i) throws InterruptedException {
            BleRequest currentRequest = SamsungBle.this.mService.getCurrentRequest();
            String str = currentRequest.address;
            byte[] value = bluetoothGattDescriptor.getValue();
            BleRequest.RequestType requestType = currentRequest.type;
            BleRequest.RequestType requestType2 = BleRequest.RequestType.CHARACTERISTIC_NOTIFICATION;
            byte[] bArr = requestType == requestType2 ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : requestType == BleRequest.RequestType.CHARACTERISTIC_INDICATION ? BluetoothGattDescriptor.ENABLE_INDICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
            if (!Arrays.equals(value, bArr)) {
                if (!bluetoothGattDescriptor.setValue(bArr)) {
                    SamsungBle.this.mService.requestProcessed(str, currentRequest.type, false);
                }
                SamsungBle.this.mBluetoothGatt.writeDescriptor(bluetoothGattDescriptor);
                return;
            }
            BleRequest.RequestType requestType3 = currentRequest.type;
            if (requestType3 == requestType2) {
                SamsungBle.this.mService.bleCharacteristicNotification(str, bluetoothGattDescriptor.getCharacteristic().getUuid().toString(), true, i);
            } else if (requestType3 == BleRequest.RequestType.CHARACTERISTIC_INDICATION) {
                SamsungBle.this.mService.bleCharacteristicIndication(str, bluetoothGattDescriptor.getCharacteristic().getUuid().toString(), i);
            } else {
                SamsungBle.this.mService.bleCharacteristicNotification(str, bluetoothGattDescriptor.getCharacteristic().getUuid().toString(), false, i);
            }
        }

        @Override // com.samsung.android.sdk.bt.gatt.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGattDescriptor bluetoothGattDescriptor, int i) throws InterruptedException {
            BleRequest currentRequest = SamsungBle.this.mService.getCurrentRequest();
            String str = currentRequest.address;
            BleRequest.RequestType requestType = currentRequest.type;
            BleRequest.RequestType requestType2 = BleRequest.RequestType.CHARACTERISTIC_NOTIFICATION;
            if (requestType == requestType2 || requestType == BleRequest.RequestType.CHARACTERISTIC_INDICATION || requestType == BleRequest.RequestType.CHARACTERISTIC_STOP_NOTIFICATION) {
                if (i != 0) {
                    SamsungBle.this.mService.requestProcessed(str, currentRequest.type, false);
                    return;
                }
                if (requestType == requestType2) {
                    SamsungBle.this.mService.bleCharacteristicNotification(str, bluetoothGattDescriptor.getCharacteristic().getUuid().toString(), true, i);
                } else if (requestType == BleRequest.RequestType.CHARACTERISTIC_INDICATION) {
                    SamsungBle.this.mService.bleCharacteristicIndication(str, bluetoothGattDescriptor.getCharacteristic().getUuid().toString(), i);
                } else {
                    SamsungBle.this.mService.bleCharacteristicNotification(str, bluetoothGattDescriptor.getCharacteristic().getUuid().toString(), false, i);
                }
            }
        }

        @Override // com.samsung.android.sdk.bt.gatt.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothDevice bluetoothDevice, int i, int i2) {
            super.onReadRemoteRssi(bluetoothDevice, i, i2);
            SamsungBle.this.mService.bleOnReadRssi(bluetoothDevice.getAddress(), i);
        }

        @Override // com.samsung.android.sdk.bt.gatt.BluetoothGattCallback
        public void onScanResult(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            SamsungBle.this.mService.bleDeviceFound(bluetoothDevice, i, bArr, 0);
        }

        @Override // com.samsung.android.sdk.bt.gatt.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothDevice bluetoothDevice, int i) throws InterruptedException {
            String address = bluetoothDevice.getAddress();
            if (i == 0) {
                SamsungBle.this.mService.bleServiceDiscovered(bluetoothDevice.getAddress());
                return;
            }
            SamsungBle.this.disconnect(address);
            SamsungBle.this.mService.bleGattDisConnected(address, i);
            SamsungBle.this.mService.requestProcessed(address, BleRequest.RequestType.DISCOVER_SERVICE, false);
        }
    };
    private final BluetoothProfile.ServiceListener mProfileServiceListener;
    private boolean mScanning;
    private BleService mService;

    public SamsungBle(BleService bleService) {
        BluetoothProfile.ServiceListener serviceListener = new BluetoothProfile.ServiceListener() { // from class: com.xtremeprog.sdk.ble.SamsungBle.2
            @Override // android.bluetooth.BluetoothProfile.ServiceListener
            public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
                SamsungBle.this.mBluetoothGatt = (BluetoothGatt) bluetoothProfile;
                SamsungBle.this.mBluetoothGatt.registerApp(SamsungBle.this.mGattCallbacks);
            }

            @Override // android.bluetooth.BluetoothProfile.ServiceListener
            public void onServiceDisconnected(int i) {
                SamsungBle.this.mBluetoothGatt = null;
            }
        };
        this.mProfileServiceListener = serviceListener;
        this.mService = bleService;
        BluetoothAdapter adapter = ((BluetoothManager) WearUtils.x.getSystemService("bluetooth")).getAdapter();
        this.mBtAdapter = adapter;
        if (adapter == null) {
            this.mService.bleNoBtAdapter();
        } else {
            BluetoothGattAdapter.getProfileProxy(this.mService, serviceListener, 7);
        }
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public boolean adapterEnabled() {
        BluetoothAdapter bluetoothAdapter = this.mBtAdapter;
        if (bluetoothAdapter != null) {
            return bluetoothAdapter.isEnabled();
        }
        return false;
    }

    @Override // com.xtremeprog.sdk.ble.IBleRequestHandler
    public boolean characteristicNotification(String str, BleGattCharacteristic bleGattCharacteristic) {
        BluetoothGattDescriptor descriptor;
        BluetoothGattCharacteristic gattCharacteristicS = bleGattCharacteristic.getGattCharacteristicS();
        if (this.mBluetoothGatt.setCharacteristicNotification(gattCharacteristicS, true) && (descriptor = gattCharacteristicS.getDescriptor(BleService.DESC_CCC)) != null) {
            return this.mBluetoothGatt.readDescriptor(descriptor);
        }
        return false;
    }

    @Override // com.xtremeprog.sdk.ble.IBleRequestHandler
    public boolean connect(String str) {
        return this.mBluetoothGatt.connect(this.mBtAdapter.getRemoteDevice(str), false);
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public void disconnect(String str) {
        this.mBluetoothGatt.cancelConnection(this.mBtAdapter.getRemoteDevice(str));
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public boolean discoverServices(String str) {
        return this.mBluetoothGatt.discoverServices(this.mBtAdapter.getRemoteDevice(str));
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public String getBTAdapterMacAddr() {
        BluetoothAdapter bluetoothAdapter = this.mBtAdapter;
        if (bluetoothAdapter != null) {
            return bluetoothAdapter.getAddress();
        }
        return null;
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public vt getPhyListenCallBack(String str) {
        return null;
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public BleGattService getService(String str, UUID uuid) {
        BluetoothGattService service = this.mBluetoothGatt.getService(this.mBtAdapter.getRemoteDevice(str), uuid);
        if (service == null) {
            return null;
        }
        return new BleGattService(service);
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public ArrayList<BleGattService> getServices(String str) {
        ArrayList<BleGattService> arrayList = new ArrayList<>();
        Iterator it = this.mBluetoothGatt.getServices(this.mBtAdapter.getRemoteDevice(str)).iterator();
        while (it.hasNext()) {
            arrayList.add(new BleGattService((BluetoothGattService) it.next()));
        }
        return arrayList;
    }

    @Override // com.xtremeprog.sdk.ble.IBleRequestHandler
    public boolean readCharacteristic(String str, BleGattCharacteristic bleGattCharacteristic) {
        return this.mBluetoothGatt.readCharacteristic(bleGattCharacteristic.getGattCharacteristicS());
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public void readPhy(String str) {
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public boolean readRssi(String str) {
        BluetoothAdapter bluetoothAdapter = this.mBtAdapter;
        if (bluetoothAdapter != null) {
            BluetoothDevice remoteDevice = bluetoothAdapter.getRemoteDevice(str);
            BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
            if (bluetoothGatt != null && remoteDevice != null) {
                return bluetoothGatt.readRemoteRssi(remoteDevice);
            }
        }
        return false;
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public boolean requestCharacteristicNotification(String str, BleGattCharacteristic bleGattCharacteristic) {
        this.mService.addBleRequest(new BleRequest(BleRequest.RequestType.CHARACTERISTIC_NOTIFICATION, str, bleGattCharacteristic));
        return true;
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public boolean requestConnect(String str) {
        this.mService.addBleRequest(new BleRequest(BleRequest.RequestType.CONNECT_GATT, str));
        return true;
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public boolean requestIndication(String str, BleGattCharacteristic bleGattCharacteristic) {
        this.mService.addBleRequest(new BleRequest(BleRequest.RequestType.CHARACTERISTIC_INDICATION, str, bleGattCharacteristic));
        return true;
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public boolean requestReadCharacteristic(String str, BleGattCharacteristic bleGattCharacteristic) {
        this.mService.addBleRequest(new BleRequest(BleRequest.RequestType.READ_CHARACTERISTIC, str, bleGattCharacteristic));
        return true;
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public boolean requestStopNotification(String str, BleGattCharacteristic bleGattCharacteristic) {
        this.mService.addBleRequest(new BleRequest(BleRequest.RequestType.CHARACTERISTIC_STOP_NOTIFICATION, str, bleGattCharacteristic));
        return true;
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public boolean requestWriteCharacteristic(String str, BleGattCharacteristic bleGattCharacteristic, String str2) {
        this.mService.addBleRequest(new BleRequest(BleRequest.RequestType.WRITE_CHARACTERISTIC, str, bleGattCharacteristic));
        return true;
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public void resetBleParams() throws InterruptedException {
        this.mService.resetBleParams();
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public void setPhyListenCallBack(String str, vt vtVar) {
        if (vtVar != null) {
            vtVar.a(DatabaseError.UNKNOWN_ERROR, 0, 0);
            vtVar.b(DatabaseError.UNKNOWN_ERROR, 0, 0);
        }
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public void setPreferredPhy(String str, int i, int i2, int i3) {
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public void startScan() {
        if (this.mScanning) {
            return;
        }
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt == null) {
            this.mScanning = false;
        } else {
            this.mScanning = true;
            bluetoothGatt.startScan();
        }
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public void stopScan() {
        BluetoothGatt bluetoothGatt;
        if (!this.mScanning || (bluetoothGatt = this.mBluetoothGatt) == null) {
            return;
        }
        this.mScanning = false;
        bluetoothGatt.stopScan();
    }

    @Override // com.xtremeprog.sdk.ble.IBleRequestHandler
    public boolean writeCharacteristic(String str, BleGattCharacteristic bleGattCharacteristic, String str2) {
        if (this.mBluetoothGatt == null) {
            return false;
        }
        if (str2 == null || !(str2.startsWith("AP") || str2.startsWith("aa"))) {
            if (bleGattCharacteristic.getGattCharacteristicS().getWriteType() != 1) {
                bleGattCharacteristic.getGattCharacteristicS().setWriteType(1);
            }
        } else if (bleGattCharacteristic.getGattCharacteristicS().getWriteType() != 2) {
            bleGattCharacteristic.getGattCharacteristicS().setWriteType(2);
        }
        return this.mBluetoothGatt.writeCharacteristic(bleGattCharacteristic.getGattCharacteristicS());
    }
}
