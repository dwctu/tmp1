package no.nordicsemi.android.support.v18.scanner;

import android.os.ParcelUuid;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public final class ScanRecord {
    private static final int DATA_TYPE_FLAGS = 1;
    private static final int DATA_TYPE_LOCAL_NAME_COMPLETE = 9;
    private static final int DATA_TYPE_LOCAL_NAME_SHORT = 8;
    private static final int DATA_TYPE_MANUFACTURER_SPECIFIC_DATA = 255;
    private static final int DATA_TYPE_SERVICE_DATA_128_BIT = 33;
    private static final int DATA_TYPE_SERVICE_DATA_16_BIT = 22;
    private static final int DATA_TYPE_SERVICE_DATA_32_BIT = 32;
    private static final int DATA_TYPE_SERVICE_UUIDS_128_BIT_COMPLETE = 7;
    private static final int DATA_TYPE_SERVICE_UUIDS_128_BIT_PARTIAL = 6;
    private static final int DATA_TYPE_SERVICE_UUIDS_16_BIT_COMPLETE = 3;
    private static final int DATA_TYPE_SERVICE_UUIDS_16_BIT_PARTIAL = 2;
    private static final int DATA_TYPE_SERVICE_UUIDS_32_BIT_COMPLETE = 5;
    private static final int DATA_TYPE_SERVICE_UUIDS_32_BIT_PARTIAL = 4;
    private static final int DATA_TYPE_TX_POWER_LEVEL = 10;
    private static final String TAG = "ScanRecord";
    private final int advertiseFlags;
    private final byte[] bytes;
    private final String deviceName;

    @Nullable
    private final SparseArray<byte[]> manufacturerSpecificData;

    @Nullable
    private final Map<ParcelUuid, byte[]> serviceData;

    @Nullable
    private final List<ParcelUuid> serviceUuids;
    private final int txPowerLevel;

    private ScanRecord(@Nullable List<ParcelUuid> list, @Nullable SparseArray<byte[]> sparseArray, @Nullable Map<ParcelUuid, byte[]> map, int i, int i2, String str, byte[] bArr) {
        this.serviceUuids = list;
        this.manufacturerSpecificData = sparseArray;
        this.serviceData = map;
        this.deviceName = str;
        this.advertiseFlags = i;
        this.txPowerLevel = i2;
        this.bytes = bArr;
    }

    private static byte[] extractBytes(@NonNull byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0072  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static no.nordicsemi.android.support.v18.scanner.ScanRecord parseFromBytes(@androidx.annotation.Nullable byte[] r16) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.support.v18.scanner.ScanRecord.parseFromBytes(byte[]):no.nordicsemi.android.support.v18.scanner.ScanRecord");
    }

    private static int parseServiceUuid(@NonNull byte[] bArr, int i, int i2, int i3, @NonNull List<ParcelUuid> list) {
        while (i2 > 0) {
            list.add(BluetoothUuid.parseUuidFrom(extractBytes(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ScanRecord.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.bytes, ((ScanRecord) obj).bytes);
    }

    public int getAdvertiseFlags() {
        return this.advertiseFlags;
    }

    @Nullable
    public byte[] getBytes() {
        return this.bytes;
    }

    @Nullable
    public String getDeviceName() {
        return this.deviceName;
    }

    @Nullable
    public SparseArray<byte[]> getManufacturerSpecificData() {
        return this.manufacturerSpecificData;
    }

    @Nullable
    public Map<ParcelUuid, byte[]> getServiceData() {
        return this.serviceData;
    }

    @Nullable
    public List<ParcelUuid> getServiceUuids() {
        return this.serviceUuids;
    }

    public int getTxPowerLevel() {
        return this.txPowerLevel;
    }

    public String toString() {
        return "ScanRecord [advertiseFlags=" + this.advertiseFlags + ", serviceUuids=" + this.serviceUuids + ", manufacturerSpecificData=" + BluetoothLeUtils.toString(this.manufacturerSpecificData) + ", serviceData=" + BluetoothLeUtils.toString(this.serviceData) + ", txPowerLevel=" + this.txPowerLevel + ", deviceName=" + this.deviceName + "]";
    }

    @Nullable
    public byte[] getManufacturerSpecificData(int i) {
        SparseArray<byte[]> sparseArray = this.manufacturerSpecificData;
        if (sparseArray == null) {
            return null;
        }
        return sparseArray.get(i);
    }

    @Nullable
    public byte[] getServiceData(@NonNull ParcelUuid parcelUuid) {
        Map<ParcelUuid, byte[]> map;
        if (parcelUuid == null || (map = this.serviceData) == null) {
            return null;
        }
        return map.get(parcelUuid);
    }
}
