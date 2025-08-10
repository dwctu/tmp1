package com.xtremeprog.sdk.ble;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.os.Build;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.wear.bean.SyncWsProtocol;
import com.xtremeprog.sdk.ble.BleRequest;
import dc.vt;
import dc.xe3;
import dc.ye3;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.codec.binary.Hex;

@SuppressLint({"NewApi"})
/* loaded from: classes4.dex */
public class AndroidBle implements IBle, IBleRequestHandler {
    private Map<String, BluetoothGatt> mBluetoothGatts;
    private BluetoothAdapter mBtAdapter;
    private Map<String, vt> mPhyListenCallBack;
    private BleService mService;
    private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback() { // from class: com.xtremeprog.sdk.ble.AndroidBle.1
        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            AndroidBle.this.mService.bleDeviceFound(bluetoothDevice, i, bArr, 0);
        }
    };
    private Map<String, Boolean> objectAddress = new HashMap();
    private BluetoothGattCallback mGattCallback = new BluetoothGattCallback() { // from class: com.xtremeprog.sdk.ble.AndroidBle.2
        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            String address = bluetoothGatt.getDevice().getAddress();
            String str = "onCharacteristicChanged " + address;
            new String(Hex.encodeHex(bluetoothGattCharacteristic.getValue()));
            AndroidBle.this.mService.bleCharacteristicChanged(address, bluetoothGattCharacteristic.getUuid().toString(), bluetoothGattCharacteristic.getValue());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) throws InterruptedException {
            String address = bluetoothGatt.getDevice().getAddress();
            String str = "onCharacteristicRead " + address + " status " + i;
            if (i != 0) {
                AndroidBle.this.mService.requestProcessed(address, BleRequest.RequestType.READ_CHARACTERISTIC, false);
            } else {
                AndroidBle.this.mService.bleCharacteristicRead(bluetoothGatt.getDevice().getAddress(), bluetoothGattCharacteristic.getUuid().toString(), i, bluetoothGattCharacteristic.getValue());
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) throws InterruptedException {
            String address = bluetoothGatt.getDevice().getAddress();
            String str = "onCharacteristicWrite " + address + " status " + i;
            if (i != 0) {
                AndroidBle.this.mService.requestProcessed(address, BleRequest.RequestType.WRITE_CHARACTERISTIC, false);
            } else {
                AndroidBle.this.mService.bleCharacteristicWrite(bluetoothGatt.getDevice().getAddress(), bluetoothGattCharacteristic.getUuid().toString(), i);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) throws InterruptedException {
            String address = bluetoothGatt.getDevice().getAddress();
            xe3.a(IBle.TAG, "onConnectionStateChange " + address + " status " + i + " newState " + i2);
            AndroidBle.this.mService.bleConnectState(address, i, i2);
            if (i == 133) {
                ye3.d("S0003", SyncWsProtocol.CONTROL_133_TYPE_CODE_WEB_TRAN_HTTP + address);
            }
            if (i != 0) {
                if (!AndroidBle.this.mBluetoothGatts.containsKey(address)) {
                    AndroidBle.this.objectAddress.put(bluetoothGatt.toString(), Boolean.FALSE);
                }
                AndroidBle.this.disconnect(address);
                AndroidBle.this.mService.bleGattDisConnected(address, i);
                return;
            }
            if (i2 == 2) {
                AndroidBle.this.mService.bleGattConnected(bluetoothGatt.getDevice());
                AndroidBle.this.mService.addBleRequest(new BleRequest(BleRequest.RequestType.DISCOVER_SERVICE, address));
            } else if (i2 == 0) {
                AndroidBle.this.mService.bleGattDisConnected(address, i);
                AndroidBle.this.disconnect(address);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) throws InterruptedException {
            String address = bluetoothGatt.getDevice().getAddress();
            String str = "onDescriptorWrite " + address + " status " + i;
            BleRequest.RequestType requestType = AndroidBle.this.mService.getCurrentRequest().type;
            BleRequest.RequestType requestType2 = BleRequest.RequestType.CHARACTERISTIC_NOTIFICATION;
            if (requestType == requestType2 || requestType == BleRequest.RequestType.CHARACTERISTIC_INDICATION || requestType == BleRequest.RequestType.CHARACTERISTIC_STOP_NOTIFICATION) {
                if (i != 0) {
                    AndroidBle.this.mService.requestProcessed(address, requestType2, false);
                    return;
                }
                if (requestType == requestType2) {
                    AndroidBle.this.mService.bleCharacteristicNotification(address, bluetoothGattDescriptor.getCharacteristic().getUuid().toString(), true, i);
                } else if (requestType == BleRequest.RequestType.CHARACTERISTIC_INDICATION) {
                    AndroidBle.this.mService.bleCharacteristicIndication(address, bluetoothGattDescriptor.getCharacteristic().getUuid().toString(), i);
                } else {
                    AndroidBle.this.mService.bleCharacteristicNotification(address, bluetoothGattDescriptor.getCharacteristic().getUuid().toString(), false, i);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyRead(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
            if (bluetoothGatt.getDevice() != null) {
                vt vtVar = (vt) AndroidBle.this.mPhyListenCallBack.get(bluetoothGatt.getDevice().getAddress());
                if (vtVar != null) {
                    vtVar.b(i3, i, i2);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
            if (bluetoothGatt.getDevice() != null) {
                vt vtVar = (vt) AndroidBle.this.mPhyListenCallBack.get(bluetoothGatt.getDevice().getAddress());
                if (vtVar != null) {
                    vtVar.a(i3, i, i2);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onReadRemoteRssi(bluetoothGatt, i, i2);
            AndroidBle.this.mService.bleOnReadRssi(bluetoothGatt.getDevice().getAddress(), i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) throws InterruptedException {
            String address = bluetoothGatt.getDevice().getAddress();
            String str = "onServicesDiscovered " + address + " status " + i;
            if (i != 0) {
                AndroidBle.this.mService.requestProcessed(address, BleRequest.RequestType.DISCOVER_SERVICE, false);
            } else {
                AndroidBle.this.mService.bleServiceDiscovered(bluetoothGatt.getDevice().getAddress());
            }
        }
    };

    public AndroidBle(BleService bleService) {
        this.mService = bleService;
        if (!bleService.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            this.mService.bleNotSupported();
            return;
        }
        BluetoothAdapter adapter = ((BluetoothManager) this.mService.getSystemService("bluetooth")).getAdapter();
        this.mBtAdapter = adapter;
        if (adapter == null) {
            this.mService.bleNoBtAdapter();
        }
        this.mBluetoothGatts = new HashMap();
        this.mPhyListenCallBack = new HashMap();
    }

    private synchronized void refreshDeviceCache(BluetoothGatt bluetoothGatt) {
        try {
            Method method = BluetoothGatt.class.getMethod("refresh", new Class[0]);
            if (method != null && bluetoothGatt != null) {
                String str = "refreshDeviceCache, is success:  " + ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
            }
        } catch (Exception e) {
            String str2 = "exception occur while refreshing device: " + e.getMessage();
            e.printStackTrace();
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
        BluetoothGatt bluetoothGatt = this.mBluetoothGatts.get(str);
        if (bluetoothGatt == null || bleGattCharacteristic == null) {
            return false;
        }
        boolean z = currentRequest.type != BleRequest.RequestType.CHARACTERISTIC_STOP_NOTIFICATION;
        BluetoothGattCharacteristic gattCharacteristicA = bleGattCharacteristic.getGattCharacteristicA();
        if ((bluetoothGatt != null && !bluetoothGatt.setCharacteristicNotification(gattCharacteristicA, z)) || (descriptor = gattCharacteristicA.getDescriptor(BleService.DESC_CCC)) == null) {
            return false;
        }
        BleRequest.RequestType requestType = currentRequest.type;
        if (descriptor.setValue(requestType == BleRequest.RequestType.CHARACTERISTIC_NOTIFICATION ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : requestType == BleRequest.RequestType.CHARACTERISTIC_INDICATION ? BluetoothGattDescriptor.ENABLE_INDICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)) {
            return bluetoothGatt.writeDescriptor(descriptor);
        }
        return false;
    }

    @Override // com.xtremeprog.sdk.ble.IBleRequestHandler
    public boolean connect(String str) {
        BluetoothDevice remoteDevice = this.mBtAdapter.getRemoteDevice(str);
        xe3.a(IBle.TAG, "connect: " + this.mBluetoothGatts.size());
        BluetoothGatt bluetoothGattConnectGatt = Build.VERSION.SDK_INT >= 23 ? remoteDevice.connectGatt(this.mService, false, this.mGattCallback, 2) : remoteDevice.connectGatt(this.mService, false, this.mGattCallback);
        refreshDeviceCache(bluetoothGattConnectGatt);
        if (bluetoothGattConnectGatt == null) {
            this.mBluetoothGatts.remove(str);
            xe3.a(IBle.TAG, "connect: false");
            return false;
        }
        xe3.a(IBle.TAG, "connect: true");
        this.mBluetoothGatts.put(str, bluetoothGattConnectGatt);
        return true;
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public void disconnect(String str) {
        BluetoothGatt bluetoothGattRemove;
        xe3.b(getClass().getSimpleName(), "disconnect", str);
        if (!this.mBluetoothGatts.containsKey(str) || (bluetoothGattRemove = this.mBluetoothGatts.remove(str)) == null) {
            return;
        }
        try {
            bluetoothGattRemove.disconnect();
            refreshDeviceCache(bluetoothGattRemove);
            bluetoothGattRemove.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public boolean discoverServices(String str) {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatts.get(str);
        if (bluetoothGatt == null) {
            return false;
        }
        boolean zDiscoverServices = bluetoothGatt.discoverServices();
        if (!zDiscoverServices) {
            disconnect(str);
        }
        return zDiscoverServices;
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
        return this.mPhyListenCallBack.get(str);
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public BleGattService getService(String str, UUID uuid) {
        BluetoothGattService service;
        BluetoothGatt bluetoothGatt = this.mBluetoothGatts.get(str);
        if (bluetoothGatt == null || (service = bluetoothGatt.getService(uuid)) == null) {
            return null;
        }
        return new BleGattService(service);
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public ArrayList<BleGattService> getServices(String str) {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatts.get(str);
        if (bluetoothGatt == null) {
            return null;
        }
        ArrayList<BleGattService> arrayList = new ArrayList<>();
        Iterator<BluetoothGattService> it = bluetoothGatt.getServices().iterator();
        while (it.hasNext()) {
            arrayList.add(new BleGattService(it.next()));
        }
        return arrayList;
    }

    @Override // com.xtremeprog.sdk.ble.IBleRequestHandler
    public boolean readCharacteristic(String str, BleGattCharacteristic bleGattCharacteristic) {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatts.get(str);
        if (bluetoothGatt == null) {
            return false;
        }
        return bluetoothGatt.readCharacteristic(bleGattCharacteristic.getGattCharacteristicA());
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public void readPhy(String str) {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatts.get(str);
        if (bluetoothGatt != null) {
            bluetoothGatt.readPhy();
            return;
        }
        vt vtVar = this.mPhyListenCallBack.get(str);
        if (vtVar != null) {
            vtVar.a(-996, 0, 0);
        }
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public boolean readRssi(String str) {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatts.get(str);
        if (bluetoothGatt != null) {
            return bluetoothGatt.readRemoteRssi();
        }
        return false;
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public boolean requestCharacteristicNotification(String str, BleGattCharacteristic bleGattCharacteristic) {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatts.get(str);
        if (bluetoothGatt == null || bleGattCharacteristic == null) {
            return false;
        }
        this.mService.addBleRequest(new BleRequest(BleRequest.RequestType.CHARACTERISTIC_NOTIFICATION, bluetoothGatt.getDevice().getAddress(), bleGattCharacteristic));
        return true;
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public boolean requestConnect(String str) {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatts.get(str);
        if (bluetoothGatt == null || bluetoothGatt.getServices().size() != 0) {
            this.mService.addBleRequest(new BleRequest(BleRequest.RequestType.CONNECT_GATT, str));
            return true;
        }
        if (!this.objectAddress.containsKey(bluetoothGatt.toString())) {
            return false;
        }
        refreshDeviceCache(bluetoothGatt);
        bluetoothGatt.close();
        this.mBluetoothGatts.remove(str);
        this.objectAddress.remove(bluetoothGatt.toString());
        return false;
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public boolean requestIndication(String str, BleGattCharacteristic bleGattCharacteristic) {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatts.get(str);
        if (bluetoothGatt == null || bleGattCharacteristic == null) {
            return false;
        }
        this.mService.addBleRequest(new BleRequest(BleRequest.RequestType.CHARACTERISTIC_INDICATION, bluetoothGatt.getDevice().getAddress(), bleGattCharacteristic));
        return true;
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public boolean requestReadCharacteristic(String str, BleGattCharacteristic bleGattCharacteristic) {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatts.get(str);
        if (bluetoothGatt == null || bleGattCharacteristic == null) {
            return false;
        }
        this.mService.addBleRequest(new BleRequest(BleRequest.RequestType.READ_CHARACTERISTIC, bluetoothGatt.getDevice().getAddress(), bleGattCharacteristic));
        return true;
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public boolean requestStopNotification(String str, BleGattCharacteristic bleGattCharacteristic) {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatts.get(str);
        if (bluetoothGatt == null || bleGattCharacteristic == null) {
            return false;
        }
        this.mService.addBleRequest(new BleRequest(BleRequest.RequestType.CHARACTERISTIC_NOTIFICATION, bluetoothGatt.getDevice().getAddress(), bleGattCharacteristic));
        return true;
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public boolean requestWriteCharacteristic(String str, BleGattCharacteristic bleGattCharacteristic, String str2) {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatts.get(str);
        if (bluetoothGatt == null || bleGattCharacteristic == null) {
            return false;
        }
        this.mService.addBleRequest(new BleRequest(BleRequest.RequestType.WRITE_CHARACTERISTIC, bluetoothGatt.getDevice().getAddress(), bleGattCharacteristic, str2));
        return true;
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public void resetBleParams() throws InterruptedException {
        this.mService.resetBleParams();
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public void setPhyListenCallBack(String str, vt vtVar) {
        this.mPhyListenCallBack.put(str, vtVar);
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public void setPreferredPhy(String str, int i, int i2, int i3) {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatts.get(str);
        if (bluetoothGatt != null) {
            bluetoothGatt.setPreferredPhy(i, i2, i3);
            return;
        }
        vt vtVar = this.mPhyListenCallBack.get(str);
        if (vtVar != null) {
            vtVar.a(-997, 0, 0);
        }
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public void startScan() {
        this.mBtAdapter.startLeScan(this.mLeScanCallback);
    }

    @Override // com.xtremeprog.sdk.ble.IBle
    public void stopScan() {
        try {
            this.mBtAdapter.stopLeScan(this.mLeScanCallback);
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }

    @Override // com.xtremeprog.sdk.ble.IBleRequestHandler
    public boolean writeCharacteristic(String str, BleGattCharacteristic bleGattCharacteristic, String str2) {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatts.get(str);
        if (bluetoothGatt == null) {
            return false;
        }
        if (str2 == null || !(str2.startsWith("AP") || str2.startsWith("aa"))) {
            if (bleGattCharacteristic.getGattCharacteristicA().getWriteType() != 1) {
                bleGattCharacteristic.getGattCharacteristicA().setWriteType(1);
            }
        } else if (bleGattCharacteristic.getGattCharacteristicA().getWriteType() != 2) {
            bleGattCharacteristic.getGattCharacteristicA().setWriteType(2);
        }
        xe3.a(IBle.TAG, new String(Hex.encodeHex(bleGattCharacteristic.getGattCharacteristicA().getValue())));
        return bluetoothGatt.writeCharacteristic(bleGattCharacteristic.getGattCharacteristicA());
    }
}
