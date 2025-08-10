package com.samsung.android.sdk.bt.gatt;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes3.dex */
public class BluetoothGattCharacteristic {
    public static final int FORMAT_FLOAT = 52;
    public static final int FORMAT_SFLOAT = 50;
    public static final int FORMAT_SINT16 = 34;
    public static final int FORMAT_SINT32 = 36;
    public static final int FORMAT_SINT8 = 33;
    public static final int FORMAT_UINT16 = 18;
    public static final int FORMAT_UINT32 = 20;
    public static final int FORMAT_UINT8 = 17;
    public static final int PERMISSION_NOT_DETERMINED = 0;
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
    public List mDescriptors = new ArrayList();

    public BluetoothGattCharacteristic(BluetoothGattService bluetoothGattService, UUID uuid, int i, int i2, int i3) {
        this.mUuid = uuid;
        this.mInstance = i;
        this.mProperties = i2;
        this.mPermissions = i3;
        this.mService = bluetoothGattService;
        this.mWriteType = (this.mProperties & 4) != 0 ? 1 : 2;
    }

    private int a(byte b, byte b2) {
        return (b & 255) + ((b2 & 255) << 8);
    }

    private int a(byte b, byte b2, byte b3, byte b4) {
        return (b & 255) + ((b2 & 255) << 8) + ((b3 & 255) << 16) + ((b4 & 255) << 24);
    }

    private static int a(int i, int i2) {
        int i3 = 1 << (i2 - 1);
        return (i & i3) != 0 ? (i3 - (i & (i3 - 1))) * (-1) : i;
    }

    private static int b(int i, int i2) {
        if (i >= 0) {
            return i;
        }
        int i3 = 1 << (i2 - 1);
        return (i & (i3 - 1)) + i3;
    }

    public final int a() {
        return this.mKeySize;
    }

    public final void a(BluetoothGattDescriptor bluetoothGattDescriptor) {
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

    public List getDescriptors() {
        return this.mDescriptors;
    }

    public Float getFloatValue(int i, int i2) {
        int iA;
        int iA2;
        byte[] bArr = this.mValue;
        if (bArr == null || (i & 15) + i2 > bArr.length) {
            return null;
        }
        if (i == 50) {
            byte b = bArr[i2];
            int i3 = bArr[i2 + 1] & 255;
            iA = a((b & 255) + ((i3 & 15) << 8), 12);
            iA2 = a(i3 >> 4, 4);
        } else {
            if (i != 52) {
                return null;
            }
            byte b2 = bArr[i2];
            byte b3 = bArr[i2 + 1];
            byte b4 = bArr[i2 + 2];
            iA2 = bArr[i2 + 3];
            iA = a((b2 & 255) + ((b3 & 255) << 8) + ((b4 & 255) << 16), 24);
        }
        return Float.valueOf((float) (iA * Math.pow(10.0d, iA2)));
    }

    public int getInstanceId() {
        return this.mInstance;
    }

    public Integer getIntValue(int i, int i2) {
        int iA;
        int iA2;
        int i3;
        byte[] bArr = this.mValue;
        if (bArr == null || (i & 15) + i2 > bArr.length) {
            return null;
        }
        if (i == 17) {
            iA = bArr[i2] & 255;
        } else if (i == 18) {
            iA = a(bArr[i2], bArr[i2 + 1]);
        } else if (i != 20) {
            if (i == 36) {
                iA2 = a(bArr[i2], bArr[i2 + 1], bArr[i2 + 2], bArr[i2 + 3]);
                i3 = 32;
            } else if (i == 33) {
                iA2 = bArr[i2] & 255;
                i3 = 8;
            } else {
                if (i != 34) {
                    return null;
                }
                iA2 = a(bArr[i2], bArr[i2 + 1]);
                i3 = 16;
            }
            iA = a(iA2, i3);
        } else {
            iA = a(bArr[i2], bArr[i2 + 1], bArr[i2 + 2], bArr[i2 + 3]);
        }
        return Integer.valueOf(iA);
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
        if (bArr == null || i > bArr.length) {
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

    public boolean setValue(int i, int i2, int i3) {
        int i4 = (i2 & 15) + i3;
        if (this.mValue == null) {
            this.mValue = new byte[i4];
        }
        if (i4 > this.mValue.length) {
            return false;
        }
        if (i2 != 17) {
            if (i2 != 18) {
                if (i2 != 20) {
                    if (i2 == 36) {
                        i = b(i, 32);
                    } else if (i2 == 33) {
                        i = b(i, 8);
                    } else {
                        if (i2 != 34) {
                            return false;
                        }
                        i = b(i, 16);
                    }
                }
                byte[] bArr = this.mValue;
                int i5 = i3 + 1;
                bArr[i3] = (byte) i;
                bArr[i5] = (byte) (i >> 8);
                bArr[i5 + 1] = (byte) (i >> 16);
                return true;
            }
            byte[] bArr2 = this.mValue;
            bArr2[i3] = (byte) i;
            bArr2[i3 + 1] = (byte) (i >> 8);
            return true;
        }
        this.mValue[i3] = (byte) i;
        return true;
    }

    public boolean setValue(int i, int i2, int i3, int i4) {
        int i5 = (i3 & 15) + i4;
        if (this.mValue == null) {
            this.mValue = new byte[i5];
        }
        if (i5 > this.mValue.length) {
            return false;
        }
        if (i3 == 50) {
            int iB = b(i, 12);
            int iB2 = b(i2, 4);
            byte[] bArr = this.mValue;
            int i6 = i4 + 1;
            bArr[i4] = (byte) iB;
            bArr[i6] = (byte) ((iB >> 8) & 15);
            bArr[i6] = (byte) (bArr[i6] + ((byte) ((iB2 & 15) << 4)));
            return true;
        }
        if (i3 != 52) {
            return false;
        }
        int iB3 = b(i, 24);
        int iB4 = b(i2, 8);
        byte[] bArr2 = this.mValue;
        int i7 = i4 + 1;
        bArr2[i4] = (byte) iB3;
        int i8 = i7 + 1;
        bArr2[i7] = (byte) (iB3 >> 8);
        int i9 = i8 + 1;
        bArr2[i8] = (byte) (iB3 >> 16);
        bArr2[i9] = (byte) (bArr2[i9] + ((byte) iB4));
        return true;
    }

    public boolean setValue(String str) {
        this.mValue = str.getBytes();
        return true;
    }

    public boolean setValue(byte[] bArr) {
        this.mValue = bArr;
        return true;
    }

    public void setWriteType(int i) {
        this.mWriteType = i;
    }
}
