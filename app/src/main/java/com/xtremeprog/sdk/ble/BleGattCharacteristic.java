package com.xtremeprog.sdk.ble;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGattCharacteristic;
import com.xtremeprog.sdk.ble.BleService;
import java.util.UUID;

@SuppressLint({"NewApi"})
/* loaded from: classes4.dex */
public class BleGattCharacteristic {
    public static final int FORMAT_FLOAT = 52;
    public static final int FORMAT_SFLOAT = 50;
    public static final int FORMAT_SINT16 = 34;
    public static final int FORMAT_SINT32 = 36;
    public static final int FORMAT_SINT8 = 33;
    public static final int FORMAT_UINT16 = 18;
    public static final int FORMAT_UINT24 = 19;
    public static final int FORMAT_UINT32 = 20;
    public static final int FORMAT_UINT8 = 17;
    public static final int PROPERTY_INDICATE = 32;
    public static final int PROPERTY_NOTIFY = 16;
    public static final int PROPERTY_READ = 2;
    public static final int PROPERTY_WRITE = 8;
    private BleService.BLESDK mBleSDK;
    private BluetoothGattCharacteristic mGattCharacteristicA;
    private com.broadcom.bt.gatt.BluetoothGattCharacteristic mGattCharacteristicB;
    private com.samsung.android.sdk.bt.gatt.BluetoothGattCharacteristic mGattCharacteristicS;
    private String name;

    public BleGattCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.mBleSDK = BleService.BLESDK.ANDROID;
        setGattCharacteristicA(bluetoothGattCharacteristic);
        initInfo();
    }

    private Integer byte2uint24(int i, byte[] bArr) {
        if (i + 3 > bArr.length) {
            return null;
        }
        return Integer.valueOf(((bArr[i + 2] & 255) << 16) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8));
    }

    private void initInfo() {
        this.name = "Unknown characteristic";
    }

    public Float getFloatValue(int i, int i2) {
        BleService.BLESDK blesdk = this.mBleSDK;
        if (blesdk == BleService.BLESDK.ANDROID) {
            return getGattCharacteristicA().getFloatValue(i, i2);
        }
        if (blesdk == BleService.BLESDK.SAMSUNG) {
            return this.mGattCharacteristicS.getFloatValue(i, i2);
        }
        if (blesdk == BleService.BLESDK.BROADCOM) {
            return this.mGattCharacteristicB.getFloatValue(i, i2);
        }
        return null;
    }

    public BluetoothGattCharacteristic getGattCharacteristicA() {
        return this.mGattCharacteristicA;
    }

    public com.broadcom.bt.gatt.BluetoothGattCharacteristic getGattCharacteristicB() {
        return this.mGattCharacteristicB;
    }

    public com.samsung.android.sdk.bt.gatt.BluetoothGattCharacteristic getGattCharacteristicS() {
        return this.mGattCharacteristicS;
    }

    public Integer getIntValue(int i, int i2) {
        BleService.BLESDK blesdk = this.mBleSDK;
        if (blesdk == BleService.BLESDK.ANDROID) {
            return i == 19 ? byte2uint24(i2, getGattCharacteristicA().getValue()) : getGattCharacteristicA().getIntValue(i, i2);
        }
        if (blesdk == BleService.BLESDK.SAMSUNG) {
            return i == 19 ? byte2uint24(i2, this.mGattCharacteristicS.getValue()) : this.mGattCharacteristicS.getIntValue(i, i2);
        }
        if (blesdk == BleService.BLESDK.BROADCOM) {
            return i == 19 ? byte2uint24(i2, this.mGattCharacteristicB.getValue()) : this.mGattCharacteristicB.getIntValue(i, i2);
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public int getProperties() {
        BleService.BLESDK blesdk = this.mBleSDK;
        if (blesdk == BleService.BLESDK.ANDROID) {
            return getGattCharacteristicA().getProperties();
        }
        if (blesdk == BleService.BLESDK.BROADCOM) {
            return getGattCharacteristicB().getProperties();
        }
        if (blesdk == BleService.BLESDK.SAMSUNG) {
            return getGattCharacteristicS().getProperties();
        }
        return 0;
    }

    public String getStringValue(int i) {
        BleService.BLESDK blesdk = this.mBleSDK;
        if (blesdk == BleService.BLESDK.ANDROID) {
            return getGattCharacteristicA().getStringValue(i);
        }
        if (blesdk == BleService.BLESDK.SAMSUNG) {
            return this.mGattCharacteristicS.getStringValue(i);
        }
        if (blesdk == BleService.BLESDK.BROADCOM) {
            return this.mGattCharacteristicB.getStringValue(i);
        }
        return null;
    }

    public UUID getUuid() {
        BleService.BLESDK blesdk = this.mBleSDK;
        if (blesdk == BleService.BLESDK.ANDROID) {
            return getGattCharacteristicA().getUuid();
        }
        if (blesdk == BleService.BLESDK.BROADCOM) {
            return getGattCharacteristicB().getUuid();
        }
        if (blesdk == BleService.BLESDK.SAMSUNG) {
            return getGattCharacteristicS().getUuid();
        }
        return null;
    }

    public byte[] getValue() {
        BleService.BLESDK blesdk = this.mBleSDK;
        if (blesdk == BleService.BLESDK.ANDROID) {
            return getGattCharacteristicA().getValue();
        }
        if (blesdk == BleService.BLESDK.SAMSUNG) {
            return this.mGattCharacteristicS.getValue();
        }
        if (blesdk == BleService.BLESDK.BROADCOM) {
            return this.mGattCharacteristicB.getValue();
        }
        return null;
    }

    public void setGattCharacteristicA(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.mGattCharacteristicA = bluetoothGattCharacteristic;
    }

    public void setGattCharacteristicB(com.broadcom.bt.gatt.BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.mGattCharacteristicB = bluetoothGattCharacteristic;
    }

    public void setGattCharacteristicS(com.samsung.android.sdk.bt.gatt.BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.mGattCharacteristicS = bluetoothGattCharacteristic;
    }

    public void setName(String str) {
        this.name = str;
    }

    public boolean setValue(byte[] bArr) {
        BleService.BLESDK blesdk = this.mBleSDK;
        if (blesdk == BleService.BLESDK.ANDROID) {
            return getGattCharacteristicA().setValue(bArr);
        }
        if (blesdk == BleService.BLESDK.SAMSUNG) {
            return this.mGattCharacteristicS.setValue(bArr);
        }
        if (blesdk == BleService.BLESDK.BROADCOM) {
            return this.mGattCharacteristicB.setValue(bArr);
        }
        return false;
    }

    public BleGattCharacteristic(com.broadcom.bt.gatt.BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.mBleSDK = BleService.BLESDK.BROADCOM;
        setGattCharacteristicB(bluetoothGattCharacteristic);
    }

    public boolean setValue(int i, int i2, int i3) {
        BleService.BLESDK blesdk = this.mBleSDK;
        if (blesdk == BleService.BLESDK.ANDROID) {
            return getGattCharacteristicA().setValue(i, i2, i3);
        }
        if (blesdk == BleService.BLESDK.SAMSUNG) {
            return this.mGattCharacteristicS.setValue(i, i2, i3);
        }
        if (blesdk == BleService.BLESDK.BROADCOM) {
            return this.mGattCharacteristicB.setValue(i, i2, i3);
        }
        return false;
    }

    public BleGattCharacteristic(com.samsung.android.sdk.bt.gatt.BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.mBleSDK = BleService.BLESDK.SAMSUNG;
        setGattCharacteristicS(bluetoothGattCharacteristic);
    }

    public boolean setValue(int i, int i2, int i3, int i4) {
        BleService.BLESDK blesdk = this.mBleSDK;
        if (blesdk == BleService.BLESDK.ANDROID) {
            return getGattCharacteristicA().setValue(i, i2, i3, i4);
        }
        if (blesdk == BleService.BLESDK.SAMSUNG) {
            return this.mGattCharacteristicS.setValue(i, i2, i3, i4);
        }
        if (blesdk == BleService.BLESDK.BROADCOM) {
            return this.mGattCharacteristicB.setValue(i, i2, i3, i4);
        }
        return false;
    }

    public boolean setValue(String str) {
        return setValue(str.getBytes());
    }
}
