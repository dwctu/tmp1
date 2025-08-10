package com.xtremeprog.sdk.ble;

import dc.vt;
import java.util.ArrayList;
import java.util.UUID;

/* loaded from: classes4.dex */
public interface IBle {
    public static final String TAG = "blelib";

    boolean adapterEnabled();

    void disconnect(String str);

    boolean discoverServices(String str);

    String getBTAdapterMacAddr();

    vt getPhyListenCallBack(String str);

    BleGattService getService(String str, UUID uuid);

    ArrayList<BleGattService> getServices(String str);

    void readPhy(String str);

    boolean readRssi(String str);

    boolean requestCharacteristicNotification(String str, BleGattCharacteristic bleGattCharacteristic);

    boolean requestConnect(String str);

    boolean requestIndication(String str, BleGattCharacteristic bleGattCharacteristic);

    boolean requestReadCharacteristic(String str, BleGattCharacteristic bleGattCharacteristic);

    boolean requestStopNotification(String str, BleGattCharacteristic bleGattCharacteristic);

    boolean requestWriteCharacteristic(String str, BleGattCharacteristic bleGattCharacteristic, String str2);

    void resetBleParams();

    void setPhyListenCallBack(String str, vt vtVar);

    void setPreferredPhy(String str, int i, int i2, int i3);

    void startScan();

    void stopScan();
}
