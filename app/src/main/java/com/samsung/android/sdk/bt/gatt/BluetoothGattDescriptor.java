package com.samsung.android.sdk.bt.gatt;

import java.util.UUID;

/* loaded from: classes3.dex */
public class BluetoothGattDescriptor {
    public static final int PERMISSION_NOT_DETERMINED = 0;
    public static final int PERMISSION_READ = 1;
    public static final int PERMISSION_READ_ENCRYPTED = 2;
    public static final int PERMISSION_READ_ENCRYPTED_MITM = 4;
    public static final int PERMISSION_WRITE = 16;
    public static final int PERMISSION_WRITE_ENCRYPTED = 32;
    public static final int PERMISSION_WRITE_ENCRYPTED_MITM = 64;
    public static final int PERMISSION_WRITE_SIGNED = 128;
    public static final int PERMISSION_WRITE_SIGNED_MITM = 256;
    public BluetoothGattCharacteristic mCharacteristic;
    public int mPermissions;
    public UUID mUuid;
    public byte[] mValue;
    public static final byte[] ENABLE_NOTIFICATION_VALUE = {1, 0};
    public static final byte[] ENABLE_INDICATION_VALUE = {2, 0};
    public static final byte[] DISABLE_NOTIFICATION_VALUE = {0, 0};

    public BluetoothGattDescriptor(BluetoothGattCharacteristic bluetoothGattCharacteristic, UUID uuid, int i) {
        this.mCharacteristic = bluetoothGattCharacteristic;
        this.mUuid = uuid;
        this.mPermissions = i;
    }

    public BluetoothGattCharacteristic getCharacteristic() {
        return this.mCharacteristic;
    }

    public int getPermissions() {
        return this.mPermissions;
    }

    public UUID getUuid() {
        return this.mUuid;
    }

    public byte[] getValue() {
        return this.mValue;
    }

    public boolean setValue(byte[] bArr) {
        this.mValue = bArr;
        return true;
    }
}
