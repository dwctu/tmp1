package com.xtremeprog.sdk.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import com.broadcom.bt.gatt.BluetoothGatt;
import com.broadcom.bt.gatt.BluetoothGattAdapter;
import com.broadcom.bt.gatt.BluetoothGattCallback;
import com.broadcom.bt.gatt.BluetoothGattCharacteristic;
import com.broadcom.bt.gatt.BluetoothGattDescriptor;
import com.broadcom.bt.gatt.BluetoothGattService;
import com.wear.util.WearUtils;
import com.xtremeprog.sdk.ble.BleRequest;
import dc.vt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.UUID;

/* loaded from: classes4.dex */
public class BroadcomBle implements IBle, IBleRequestHandler {
    private String mAddress;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothAdapter mBtAdapter;
    private final BluetoothGattCallback mGattCallbacks = new BluetoothGattCallback() { // from class: com.xtremeprog.sdk.ble.BroadcomBle.1
        @Override // com.broadcom.bt.gatt.BluetoothGattCallback
        public void onAppRegistered(int i) {
        }

        @Override // com.broadcom.bt.gatt.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            BroadcomBle.this.mService.bleCharacteristicChanged(BroadcomBle.this.mService.getNotificationAddress(), bluetoothGattCharacteristic.getUuid().toString(), bluetoothGattCharacteristic.getValue());
        }

        @Override // com.broadcom.bt.gatt.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) throws InterruptedException {
            if (i == 0) {
                BroadcomBle.this.mService.bleCharacteristicRead(BroadcomBle.this.mAddress, bluetoothGattCharacteristic.getUuid().toString(), i, bluetoothGattCharacteristic.getValue());
            }
        }

        @Override // com.broadcom.bt.gatt.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothDevice bluetoothDevice, int i, int i2) throws InterruptedException {
            if (BroadcomBle.this.mBluetoothGatt == null) {
                return;
            }
            BroadcomBle.this.mService.bleConnectState(bluetoothDevice.getAddress(), i, i2);
            if (i2 == 2) {
                BroadcomBle.this.mService.bleGattConnected(bluetoothDevice);
                BroadcomBle.this.mBluetoothGatt.discoverServices(bluetoothDevice);
                BroadcomBle.this.mAddress = bluetoothDevice.getAddress();
                return;
            }
            if (i2 == 0) {
                BroadcomBle.this.mService.bleGattDisConnected(bluetoothDevice.getAddress(), i);
                BroadcomBle.this.mAddress = null;
            }
        }

        @Override // com.broadcom.bt.gatt.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGattDescriptor bluetoothGattDescriptor, int i) throws InterruptedException {
            BleRequest currentRequest = BroadcomBle.this.mService.getCurrentRequest();
            String str = currentRequest.address;
            byte[] value = bluetoothGattDescriptor.getValue();
            BleRequest.RequestType requestType = currentRequest.type;
            BleRequest.RequestType requestType2 = BleRequest.RequestType.CHARACTERISTIC_NOTIFICATION;
            byte[] bArr = requestType == requestType2 ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : requestType == BleRequest.RequestType.CHARACTERISTIC_INDICATION ? BluetoothGattDescriptor.ENABLE_INDICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
            if (!Arrays.equals(value, bArr)) {
                if (!bluetoothGattDescriptor.setValue(bArr)) {
                    BroadcomBle.this.mService.requestProcessed(str, currentRequest.type, false);
                }
                BroadcomBle.this.mBluetoothGatt.writeDescriptor(bluetoothGattDescriptor);
                return;
            }
            BleRequest.RequestType requestType3 = currentRequest.type;
            if (requestType3 == requestType2) {
                BroadcomBle.this.mService.bleCharacteristicNotification(str, bluetoothGattDescriptor.getCharacteristic().getUuid().toString(), true, i);
            } else if (requestType3 == BleRequest.RequestType.CHARACTERISTIC_INDICATION) {
                BroadcomBle.this.mService.bleCharacteristicIndication(str, bluetoothGattDescriptor.getCharacteristic().getUuid().toString(), i);
            } else {
                BroadcomBle.this.mService.bleCharacteristicNotification(str, bluetoothGattDescriptor.getCharacteristic().getUuid().toString(), false, i);
            }
        }

        @Override // com.broadcom.bt.gatt.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGattDescriptor bluetoothGattDescriptor, int i) throws InterruptedException {
            BleRequest currentRequest = BroadcomBle.this.mService.getCurrentRequest();
            String str = currentRequest.address;
            BleRequest.RequestType requestType = currentRequest.type;
            BleRequest.RequestType requestType2 = BleRequest.RequestType.CHARACTERISTIC_NOTIFICATION;
            if (requestType == requestType2 || requestType == BleRequest.RequestType.CHARACTERISTIC_INDICATION || requestType == BleRequest.RequestType.CHARACTERISTIC_STOP_NOTIFICATION) {
                if (i != 0) {
                    BroadcomBle.this.mService.requestProcessed(str, currentRequest.type, false);
                    return;
                }
                if (requestType == requestType2) {
                    BroadcomBle.this.mService.bleCharacteristicNotification(str, bluetoothGattDescriptor.getCharacteristic().getUuid().toString(), true, i);
                } else if (requestType == BleRequest.RequestType.CHARACTERISTIC_INDICATION) {
                    BroadcomBle.this.mService.bleCharacteristicIndication(str, bluetoothGattDescriptor.getCharacteristic().getUuid().toString(), i);
                } else {
                    BroadcomBle.this.mService.bleCharacteristicNotification(str, bluetoothGattDescriptor.getCharacteristic().getUuid().toString(), false, i);
                }
            }
        }

        @Override // com.broadcom.bt.gatt.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothDevice bluetoothDevice, int i, int i2) {
            super.onReadRemoteRssi(bluetoothDevice, i, i2);
            BroadcomBle.this.mService.bleOnReadRssi(bluetoothDevice.getAddress(), i);
        }

        @Override // com.broadcom.bt.gatt.BluetoothGattCallback
        public void onScanResult(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            BroadcomBle.this.mService.bleDeviceFound(bluetoothDevice, i, bArr, 0);
        }

        @Override // com.broadcom.bt.gatt.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothDevice bluetoothDevice, int i) throws InterruptedException {
            BroadcomBle.this.mService.bleServiceDiscovered(bluetoothDevice.getAddress());
        }
    };
    private final BluetoothProfile.ServiceListener mProfileServiceListener;
    private boolean mScanning;
    private BleService mService;

    public BroadcomBle(BleService bleService) {
        BluetoothProfile.ServiceListener serviceListener = new BluetoothProfile.ServiceListener() { // from class: com.xtremeprog.sdk.ble.BroadcomBle.2
            @Override // android.bluetooth.BluetoothProfile.ServiceListener
            public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
                if (bluetoothProfile == null || !bluetoothProfile.getClass().getSimpleName().equals("BluetoothGatt")) {
                    return;
                }
                BroadcomBle.this.mBluetoothGatt = (BluetoothGatt) bluetoothProfile;
                BroadcomBle.this.mBluetoothGatt.registerApp(BroadcomBle.this.mGattCallbacks);
            }

            @Override // android.bluetooth.BluetoothProfile.ServiceListener
            public void onServiceDisconnected(int i) {
                Iterator<BluetoothDevice> it = BroadcomBle.this.mBluetoothGatt.getConnectedDevices().iterator();
                while (it.hasNext()) {
                    BroadcomBle.this.mBluetoothGatt.cancelConnection(it.next());
                }
                BroadcomBle.this.mBluetoothGatt = null;
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
        BleRequest currentRequest = this.mService.getCurrentRequest();
        BluetoothGattCharacteristic gattCharacteristicB = bleGattCharacteristic.getGattCharacteristicB();
        if (this.mBluetoothGatt.setCharacteristicNotification(gattCharacteristicB, currentRequest.type != BleRequest.RequestType.CHARACTERISTIC_STOP_NOTIFICATION) && (descriptor = gattCharacteristicB.getDescriptor(BleService.DESC_CCC)) != null) {
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
        return true;
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
        Iterator<BluetoothGattService> it = this.mBluetoothGatt.getServices(this.mBtAdapter.getRemoteDevice(str)).iterator();
        while (it.hasNext()) {
            arrayList.add(new BleGattService(it.next()));
        }
        return arrayList;
    }

    @Override // com.xtremeprog.sdk.ble.IBleRequestHandler
    public boolean readCharacteristic(String str, BleGattCharacteristic bleGattCharacteristic) {
        if (bleGattCharacteristic.getGattCharacteristicB() != null) {
            return this.mBluetoothGatt.readCharacteristic(bleGattCharacteristic.getGattCharacteristicB());
        }
        return false;
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
        if (this.mAddress != null) {
            return false;
        }
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
            vtVar.a(-998, 0, 0);
            vtVar.b(-998, 0, 0);
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
            if (bleGattCharacteristic.getGattCharacteristicB().getWriteType() != 1) {
                bleGattCharacteristic.getGattCharacteristicB().setWriteType(1);
            }
        } else if (bleGattCharacteristic.getGattCharacteristicB().getWriteType() != 2) {
            bleGattCharacteristic.getGattCharacteristicB().setWriteType(2);
        }
        return this.mBluetoothGatt.writeCharacteristic(bleGattCharacteristic.getGattCharacteristicB());
    }
}
