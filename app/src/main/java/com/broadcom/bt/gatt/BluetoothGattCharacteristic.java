package com.broadcom.bt.gatt;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class BluetoothGattCharacteristic {
    public static final int FORMAT_FLOAT = 52;
    public static final int FORMAT_SFLOAT = 50;
    public static final int FORMAT_SINT16 = 34;
    public static final int FORMAT_SINT32 = 36;
    public static final int FORMAT_SINT8 = 33;
    public static final int FORMAT_UINT16 = 18;
    public static final int FORMAT_UINT32 = 20;
    public static final int FORMAT_UINT8 = 17;
    public static final int PERMISSION_READ = 1;
    public static final int PERMISSION_READ_ENCRYPTED = 2;
    public static final int PERMISSION_READ_ENCRYPTED_MITM = 4;
    public static final int PERMISSION_WRITE = 16;
    public static final int PERMISSION_WRITE_ENCRYPTED = 32;
    public static final int PERMISSION_WRITE_ENCRYPTED_MITM = 64;
    public static final int PERMISSION_WRITE_SIGNED = 128;
    public static final int PERMISSION_WRITE_SIGNED_MITM = 256;
    public static final int PROPERTY_BROADCAST = 1;
    public static final int PROPERTY_EXTENDED_PROPS = 128;
    public static final int PROPERTY_INDICATE = 32;
    public static final int PROPERTY_NOTIFY = 16;
    public static final int PROPERTY_READ = 2;
    public static final int PROPERTY_SIGNED_WRITE = 64;
    public static final int PROPERTY_WRITE = 8;
    public static final int PROPERTY_WRITE_NO_RESPONSE = 4;
    public static final int WRITE_TYPE_DEFAULT = 2;
    public static final int WRITE_TYPE_NO_RESPONSE = 1;
    public static final int WRITE_TYPE_SIGNED = 4;
    public int mInstance;
    public int mPermissions;
    public int mProperties;
    public BluetoothGattService mService;
    public UUID mUuid;
    public int mWriteType;
    public int mKeySize = 16;
    public byte[] mValue = null;
    public List<BluetoothGattDescriptor> mDescriptors = new ArrayList();

    public BluetoothGattCharacteristic(BluetoothGattService bluetoothGattService, UUID uuid, int i, int i2, int i3) {
        this.mUuid = uuid;
        this.mInstance = i;
        this.mProperties = i2;
        this.mPermissions = i3;
        this.mService = bluetoothGattService;
        if ((this.mProperties & 4) != 0) {
            this.mWriteType = 1;
        } else {
            this.mWriteType = 2;
        }
    }

    private float bytesToFloat(byte b, byte b2) {
        return (float) (unsignedToSigned(unsignedByteToInt(b) + ((unsignedByteToInt(b2) & 15) << 8), 12) * Math.pow(10.0d, unsignedToSigned(unsignedByteToInt(b2) >> 4, 4)));
    }

    private int getTypeLen(int i) {
        return i & 15;
    }

    private int intToSignedBits(int i, int i2) {
        if (i >= 0) {
            return i;
        }
        int i3 = 1 << (i2 - 1);
        return (i & (i3 - 1)) + i3;
    }

    private int unsignedByteToInt(byte b) {
        return b & 255;
    }

    private int unsignedBytesToInt(byte b, byte b2) {
        return unsignedByteToInt(b) + (unsignedByteToInt(b2) << 8);
    }

    private int unsignedToSigned(int i, int i2) {
        int i3 = 1 << (i2 - 1);
        return (i & i3) != 0 ? (i3 - (i & (i3 - 1))) * (-1) : i;
    }

    public void addDescriptor(BluetoothGattDescriptor bluetoothGattDescriptor) {
        this.mDescriptors.add(bluetoothGattDescriptor);
    }

    public BluetoothGattDescriptor getDescriptor(UUID uuid) {
        for (BluetoothGattDescriptor bluetoothGattDescriptor : this.mDescriptors) {
            if (bluetoothGattDescriptor.getUuid().equals(uuid)) {
                return bluetoothGattDescriptor;
            }
        }
        return null;
    }

    public List<BluetoothGattDescriptor> getDescriptors() {
        return this.mDescriptors;
    }

    public Float getFloatValue(int i, int i2) {
        int typeLen = getTypeLen(i) + i2;
        byte[] bArr = this.mValue;
        if (typeLen > bArr.length) {
            return null;
        }
        if (i == 50) {
            return Float.valueOf(bytesToFloat(bArr[i2], bArr[i2 + 1]));
        }
        if (i != 52) {
            return null;
        }
        return Float.valueOf(bytesToFloat(bArr[i2], bArr[i2 + 1], bArr[i2 + 2], bArr[i2 + 3]));
    }

    public int getInstanceId() {
        return this.mInstance;
    }

    public Integer getIntValue(int i, int i2) {
        int typeLen = getTypeLen(i) + i2;
        byte[] bArr = this.mValue;
        if (typeLen > bArr.length) {
            return null;
        }
        if (i == 17) {
            return Integer.valueOf(unsignedByteToInt(bArr[i2]));
        }
        if (i == 18) {
            return Integer.valueOf(unsignedBytesToInt(bArr[i2], bArr[i2 + 1]));
        }
        if (i == 20) {
            return Integer.valueOf(unsignedBytesToInt(bArr[i2], bArr[i2 + 1], bArr[i2 + 2], bArr[i2 + 3]));
        }
        if (i == 36) {
            return Integer.valueOf(unsignedToSigned(unsignedBytesToInt(bArr[i2], bArr[i2 + 1], bArr[i2 + 2], bArr[i2 + 3]), 32));
        }
        if (i == 33) {
            return Integer.valueOf(unsignedToSigned(unsignedByteToInt(bArr[i2]), 8));
        }
        if (i != 34) {
            return null;
        }
        return Integer.valueOf(unsignedToSigned(unsignedBytesToInt(bArr[i2], bArr[i2 + 1]), 16));
    }

    public int getKeySize() {
        return this.mKeySize;
    }

    public int getPermissions() {
        return this.mPermissions;
    }

    public int getProperties() {
        return this.mProperties;
    }

    public BluetoothGattService getService() {
        return this.mService;
    }

    public String getStringValue(int i) {
        byte[] bArr = this.mValue;
        if (i > bArr.length) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length - i];
        int i2 = 0;
        while (true) {
            byte[] bArr3 = this.mValue;
            if (i2 == bArr3.length - i) {
                return new String(bArr2);
            }
            bArr2[i2] = bArr3[i + i2];
            i2++;
        }
    }

    public UUID getUuid() {
        return this.mUuid;
    }

    public byte[] getValue() {
        return this.mValue;
    }

    public int getWriteType() {
        return this.mWriteType;
    }

    public boolean setValue(byte[] bArr) {
        this.mValue = bArr;
        return true;
    }

    public void setWriteType(int i) {
        this.mWriteType = i;
    }

    private int unsignedBytesToInt(byte b, byte b2, byte b3, byte b4) {
        return unsignedByteToInt(b) + (unsignedByteToInt(b2) << 8) + (unsignedByteToInt(b3) << 16) + (unsignedByteToInt(b4) << 24);
    }

    public boolean setValue(int i, int i2, int i3) {
        int typeLen = getTypeLen(i2) + i3;
        if (this.mValue == null) {
            this.mValue = new byte[typeLen];
        }
        if (typeLen > this.mValue.length) {
            return false;
        }
        if (i2 != 17) {
            if (i2 != 18) {
                if (i2 != 20) {
                    if (i2 == 36) {
                        i = intToSignedBits(i, 32);
                    } else if (i2 == 33) {
                        i = intToSignedBits(i, 8);
                    } else {
                        if (i2 != 34) {
                            return false;
                        }
                        i = intToSignedBits(i, 16);
                    }
                }
                byte[] bArr = this.mValue;
                int i4 = i3 + 1;
                bArr[i3] = (byte) (i & 255);
                bArr[i4] = (byte) ((i >> 8) & 255);
                bArr[i4 + 1] = (byte) ((i >> 16) & 255);
                return true;
            }
            byte[] bArr2 = this.mValue;
            bArr2[i3] = (byte) (i & 255);
            bArr2[i3 + 1] = (byte) ((i >> 8) & 255);
            return true;
        }
        this.mValue[i3] = (byte) (i & 255);
        return true;
    }

    private float bytesToFloat(byte b, byte b2, byte b3, byte b4) {
        return (float) (unsignedToSigned(unsignedByteToInt(b) + (unsignedByteToInt(b2) << 8) + (unsignedByteToInt(b3) << 16), 24) * Math.pow(10.0d, b4));
    }

    public boolean setValue(int i, int i2, int i3, int i4) {
        int typeLen = getTypeLen(i3) + i4;
        if (this.mValue == null) {
            this.mValue = new byte[typeLen];
        }
        if (typeLen > this.mValue.length) {
            return false;
        }
        if (i3 == 50) {
            int iIntToSignedBits = intToSignedBits(i, 12);
            int iIntToSignedBits2 = intToSignedBits(i2, 4);
            byte[] bArr = this.mValue;
            int i5 = i4 + 1;
            bArr[i4] = (byte) (iIntToSignedBits & 255);
            bArr[i5] = (byte) ((iIntToSignedBits >> 8) & 15);
            bArr[i5] = (byte) (bArr[i5] + ((byte) ((iIntToSignedBits2 & 15) << 4)));
            return true;
        }
        if (i3 != 52) {
            return false;
        }
        int iIntToSignedBits3 = intToSignedBits(i, 24);
        int iIntToSignedBits4 = intToSignedBits(i2, 8);
        byte[] bArr2 = this.mValue;
        int i6 = i4 + 1;
        bArr2[i4] = (byte) (iIntToSignedBits3 & 255);
        int i7 = i6 + 1;
        bArr2[i6] = (byte) ((iIntToSignedBits3 >> 8) & 255);
        int i8 = i7 + 1;
        bArr2[i7] = (byte) ((iIntToSignedBits3 >> 16) & 255);
        bArr2[i8] = (byte) (bArr2[i8] + ((byte) (iIntToSignedBits4 & 255)));
        return true;
    }

    public boolean setValue(String str) {
        this.mValue = str.getBytes();
        return true;
    }
}
