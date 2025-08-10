package com.xtremeprog.sdk.ble;

/* loaded from: classes4.dex */
public class BleRequest {
    public String address;
    public BleGattCharacteristic characteristic;
    public String remark;
    public RequestType type;

    public enum FailReason {
        START_FAILED,
        TIMEOUT,
        RESULT_FAILED
    }

    public enum RequestType {
        CONNECT_GATT,
        DISCOVER_SERVICE,
        CHARACTERISTIC_NOTIFICATION,
        CHARACTERISTIC_INDICATION,
        READ_CHARACTERISTIC,
        READ_DESCRIPTOR,
        READ_RSSI,
        WRITE_CHARACTERISTIC,
        WRITE_DESCRIPTOR,
        CHARACTERISTIC_STOP_NOTIFICATION
    }

    public BleRequest(RequestType requestType, String str) {
        this.type = requestType;
        this.address = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BleRequest)) {
            return false;
        }
        BleRequest bleRequest = (BleRequest) obj;
        return this.type == bleRequest.type && this.address.equals(bleRequest.address);
    }

    public BleRequest(RequestType requestType, String str, BleGattCharacteristic bleGattCharacteristic) {
        this.type = requestType;
        this.address = str;
        this.characteristic = bleGattCharacteristic;
    }

    public BleRequest(RequestType requestType, String str, BleGattCharacteristic bleGattCharacteristic, String str2) {
        this.type = requestType;
        this.address = str;
        this.characteristic = bleGattCharacteristic;
        this.remark = str2;
    }
}
