package com.xtremeprog.sdk.ble;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGattService;
import com.broadcom.bt.gatt.BluetoothGattCharacteristic;
import com.xtremeprog.sdk.ble.BleService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
/* loaded from: classes4.dex */
public class BleGattService {
    private BleService.BLESDK mBleSDK;
    private BluetoothGattService mGattServiceA;
    private com.broadcom.bt.gatt.BluetoothGattService mGattServiceB;
    private com.samsung.android.sdk.bt.gatt.BluetoothGattService mGattServiceS;
    private String mName;

    public BleGattService(com.samsung.android.sdk.bt.gatt.BluetoothGattService bluetoothGattService) {
        this.mBleSDK = BleService.BLESDK.SAMSUNG;
        this.mGattServiceS = bluetoothGattService;
        initInfo();
    }

    private void initInfo() {
        this.mName = "Unknown Service";
    }

    public BleGattCharacteristic getCharacteristic(UUID uuid) {
        BluetoothGattCharacteristic characteristic;
        BleService.BLESDK blesdk = this.mBleSDK;
        if (blesdk == BleService.BLESDK.ANDROID) {
            android.bluetooth.BluetoothGattCharacteristic characteristic2 = this.mGattServiceA.getCharacteristic(uuid);
            if (characteristic2 != null) {
                return new BleGattCharacteristic(characteristic2);
            }
            return null;
        }
        if (blesdk == BleService.BLESDK.SAMSUNG) {
            com.samsung.android.sdk.bt.gatt.BluetoothGattCharacteristic characteristic3 = this.mGattServiceS.getCharacteristic(uuid);
            if (characteristic3 != null) {
                return new BleGattCharacteristic(characteristic3);
            }
            return null;
        }
        if (blesdk != BleService.BLESDK.BROADCOM || (characteristic = this.mGattServiceB.getCharacteristic(uuid)) == null) {
            return null;
        }
        return new BleGattCharacteristic(characteristic);
    }

    public List<BleGattCharacteristic> getCharacteristics() {
        ArrayList arrayList = new ArrayList();
        BleService.BLESDK blesdk = this.mBleSDK;
        if (blesdk == BleService.BLESDK.BROADCOM) {
            Iterator<BluetoothGattCharacteristic> it = this.mGattServiceB.getCharacteristics().iterator();
            while (it.hasNext()) {
                arrayList.add(new BleGattCharacteristic(it.next()));
            }
        } else if (blesdk == BleService.BLESDK.SAMSUNG) {
            Iterator it2 = this.mGattServiceS.getCharacteristics().iterator();
            while (it2.hasNext()) {
                arrayList.add(new BleGattCharacteristic((com.samsung.android.sdk.bt.gatt.BluetoothGattCharacteristic) it2.next()));
            }
        } else if (blesdk == BleService.BLESDK.ANDROID) {
            Iterator<android.bluetooth.BluetoothGattCharacteristic> it3 = this.mGattServiceA.getCharacteristics().iterator();
            while (it3.hasNext()) {
                arrayList.add(new BleGattCharacteristic(it3.next()));
            }
        }
        return arrayList;
    }

    public String getName() {
        return this.mName;
    }

    public UUID getUuid() {
        BleService.BLESDK blesdk = this.mBleSDK;
        if (blesdk == BleService.BLESDK.BROADCOM) {
            return this.mGattServiceB.getUuid();
        }
        if (blesdk == BleService.BLESDK.SAMSUNG) {
            return this.mGattServiceS.getUuid();
        }
        if (blesdk == BleService.BLESDK.ANDROID) {
            return this.mGattServiceA.getUuid();
        }
        return null;
    }

    public void setInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            setName(jSONObject.getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setName(String str) {
        this.mName = str;
    }

    public BleGattService(com.broadcom.bt.gatt.BluetoothGattService bluetoothGattService) {
        this.mBleSDK = BleService.BLESDK.BROADCOM;
        this.mGattServiceB = bluetoothGattService;
        initInfo();
    }

    public BleGattService(BluetoothGattService bluetoothGattService) {
        this.mBleSDK = BleService.BLESDK.ANDROID;
        this.mGattServiceA = bluetoothGattService;
        initInfo();
    }
}
