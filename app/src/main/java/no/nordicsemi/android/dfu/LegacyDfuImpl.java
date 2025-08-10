package no.nordicsemi.android.dfu;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.UUID;
import no.nordicsemi.android.dfu.BaseCustomDfuImpl;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

@SuppressLint({"MissingPermission"})
/* loaded from: classes5.dex */
public class LegacyDfuImpl extends BaseCustomDfuImpl {
    public static final UUID DEFAULT_DFU_CONTROL_POINT_UUID;
    public static final UUID DEFAULT_DFU_PACKET_UUID;
    public static final UUID DEFAULT_DFU_SERVICE_UUID;
    public static final UUID DEFAULT_DFU_VERSION_UUID;
    public static UUID DFU_CONTROL_POINT_UUID = null;
    public static UUID DFU_PACKET_UUID = null;
    public static UUID DFU_SERVICE_UUID = null;
    private static final int DFU_STATUS_SUCCESS = 1;
    public static UUID DFU_VERSION_UUID = null;
    private static final byte[] OP_CODE_ACTIVATE_AND_RESET;
    private static final int OP_CODE_ACTIVATE_AND_RESET_KEY = 5;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS_COMPLETE;
    private static final int OP_CODE_INIT_DFU_PARAMS_KEY = 2;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS_START;
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_KEY = 17;
    private static final byte[] OP_CODE_PACKET_RECEIPT_NOTIF_REQ;
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_REQ_KEY = 8;
    private static final byte[] OP_CODE_RECEIVE_FIRMWARE_IMAGE;
    private static final int OP_CODE_RECEIVE_FIRMWARE_IMAGE_KEY = 3;
    private static final byte[] OP_CODE_RESET;
    private static final int OP_CODE_RESET_KEY = 6;
    private static final int OP_CODE_RESPONSE_CODE_KEY = 16;
    private static final byte[] OP_CODE_START_DFU;
    private static final int OP_CODE_START_DFU_KEY = 1;
    private static final byte[] OP_CODE_START_DFU_V1;
    private static final byte[] OP_CODE_VALIDATE;
    private static final int OP_CODE_VALIDATE_KEY = 4;
    private final LegacyBluetoothCallback mBluetoothCallback;
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    private boolean mImageSizeInProgress;
    private BluetoothGattCharacteristic mPacketCharacteristic;

    public class LegacyBluetoothCallback extends BaseCustomDfuImpl.BaseCustomBluetoothCallback {
        public LegacyBluetoothCallback() {
            super();
        }

        @Override // no.nordicsemi.android.dfu.BaseDfuImpl.BaseBluetoothGattCallback, android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(@NonNull BluetoothGatt bluetoothGatt, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull byte[] bArr) throws IOException {
            if ((bArr[0] & 255) == 17) {
                LegacyDfuImpl.this.mProgressInfo.setBytesReceived(getInt(bArr, 1));
                handlePacketReceiptNotification(bluetoothGatt, bluetoothGattCharacteristic, bArr);
            } else {
                LegacyDfuImpl legacyDfuImpl = LegacyDfuImpl.this;
                if (!legacyDfuImpl.mRemoteErrorOccurred) {
                    if ((bArr[2] & 255) != 1) {
                        legacyDfuImpl.mRemoteErrorOccurred = true;
                    }
                    handleNotification(bluetoothGatt, bluetoothGattCharacteristic, bArr);
                }
            }
            LegacyDfuImpl.this.notifyLock();
        }

        @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl.BaseCustomBluetoothCallback
        public void onPacketCharacteristicWrite() {
            if (LegacyDfuImpl.this.mImageSizeInProgress) {
                LegacyDfuImpl.this.mImageSizeInProgress = false;
            }
        }
    }

    static {
        UUID uuid = new UUID(23296205844446L, 1523193452336828707L);
        DEFAULT_DFU_SERVICE_UUID = uuid;
        UUID uuid2 = new UUID(23300500811742L, 1523193452336828707L);
        DEFAULT_DFU_CONTROL_POINT_UUID = uuid2;
        UUID uuid3 = new UUID(23304795779038L, 1523193452336828707L);
        DEFAULT_DFU_PACKET_UUID = uuid3;
        UUID uuid4 = new UUID(23313385713630L, 1523193452336828707L);
        DEFAULT_DFU_VERSION_UUID = uuid4;
        DFU_SERVICE_UUID = uuid;
        DFU_CONTROL_POINT_UUID = uuid2;
        DFU_PACKET_UUID = uuid3;
        DFU_VERSION_UUID = uuid4;
        OP_CODE_START_DFU = new byte[]{1, 0};
        OP_CODE_START_DFU_V1 = new byte[]{1};
        OP_CODE_INIT_DFU_PARAMS = new byte[]{2};
        OP_CODE_INIT_DFU_PARAMS_START = new byte[]{2, 0};
        OP_CODE_INIT_DFU_PARAMS_COMPLETE = new byte[]{2, 1};
        OP_CODE_RECEIVE_FIRMWARE_IMAGE = new byte[]{3};
        OP_CODE_VALIDATE = new byte[]{4};
        OP_CODE_ACTIVATE_AND_RESET = new byte[]{5};
        OP_CODE_RESET = new byte[]{6};
        OP_CODE_PACKET_RECEIPT_NOTIF_REQ = new byte[]{8, 0, 0};
    }

    public LegacyDfuImpl(@NonNull Intent intent, @NonNull DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
        this.mBluetoothCallback = new LegacyBluetoothCallback();
    }

    private int getStatusCode(@Nullable byte[] bArr, int i) throws UnknownResponseException {
        if (bArr == null || bArr.length != 3 || bArr[0] != 16 || bArr[1] != i || bArr[2] < 1 || bArr[2] > 6) {
            throw new UnknownResponseException("Invalid response received", bArr, 16, i);
        }
        return bArr[2];
    }

    private int readVersion(@Nullable BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGattCharacteristic != null) {
            return bluetoothGattCharacteristic.getIntValue(18, 0).intValue();
        }
        return 0;
    }

    private void resetAndRestart(@NonNull BluetoothGatt bluetoothGatt, @NonNull Intent intent) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        this.mService.sendLogBroadcast(15, "Last upload interrupted. Restarting device...");
        this.mProgressInfo.setProgress(-5);
        logi("Sending Reset command (Op Code = 6)");
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_RESET);
        this.mService.sendLogBroadcast(10, "Reset request sent");
        this.mService.waitUntilDisconnected();
        this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
        BluetoothGattService service = bluetoothGatt.getService(BaseDfuImpl.GENERIC_ATTRIBUTE_SERVICE_UUID);
        this.mService.refreshDeviceCache(bluetoothGatt, !((service == null || service.getCharacteristic(BaseDfuImpl.SERVICE_CHANGED_UUID) == null) ? false : true));
        this.mService.close(bluetoothGatt);
        logi("Restarting the service");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        restartService(intent2, false);
    }

    private void setImageSize(@NonNull byte[] bArr, int i, int i2) {
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >> 8) & 255);
        bArr[i2 + 2] = (byte) ((i >> 16) & 255);
        bArr[i2 + 3] = (byte) ((i >> 24) & 255);
    }

    private void setNumberOfPackets(@NonNull byte[] bArr, int i) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
    }

    private void writeImageSize(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        this.mReceivedData = null;
        this.mError = 0;
        this.mImageSizeInProgress = true;
        byte[] bArr = new byte[4];
        setImageSize(bArr, i, 0);
        this.mService.sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bArr));
        if (Build.VERSION.SDK_INT >= 33) {
            this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ", value=" + parse(bArr) + ", WRITE_TYPE_NO_RESPONSE)");
            this.mGatt.writeCharacteristic(bluetoothGattCharacteristic, bArr, 1);
        } else {
            bluetoothGattCharacteristic.setWriteType(1);
            bluetoothGattCharacteristic.setValue(bArr);
            this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
            this.mGatt.writeCharacteristic(bluetoothGattCharacteristic);
        }
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((!this.mImageSizeInProgress || !this.mConnected || this.mError != 0 || this.mAborted) && !this.mPaused) {
                        break;
                    } else {
                        this.mLock.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to write Image Size: device disconnected");
        }
        if (this.mError != 0) {
            throw new DfuException("Unable to write Image Size", this.mError);
        }
    }

    private void writeOpCode(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull byte[] bArr) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        writeOpCode(bluetoothGattCharacteristic, bArr, bArr[0] == 6 || bArr[0] == 5);
    }

    @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl
    public UUID getControlPointCharacteristicUUID() {
        return DFU_CONTROL_POINT_UUID;
    }

    @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl
    public UUID getDfuServiceUUID() {
        return DFU_SERVICE_UUID;
    }

    @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl
    public UUID getPacketCharacteristicUUID() {
        return DFU_PACKET_UUID;
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public boolean isClientCompatible(@NonNull Intent intent, @NonNull BluetoothGatt bluetoothGatt) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattService service = bluetoothGatt.getService(DFU_SERVICE_UUID);
        if (service == null || (characteristic = service.getCharacteristic(DFU_CONTROL_POINT_UUID)) == null || characteristic.getDescriptor(BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG) == null) {
            return false;
        }
        this.mControlPointCharacteristic = characteristic;
        BluetoothGattCharacteristic characteristic2 = service.getCharacteristic(DFU_PACKET_UUID);
        this.mPacketCharacteristic = characteristic2;
        return characteristic2 != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x03d6 A[Catch: UnknownResponseException -> 0x0204, UploadAbortedException -> 0x020c, RemoteDfuException -> 0x0670, TryCatch #3 {RemoteDfuException -> 0x0670, blocks: (B:93:0x0324, B:97:0x032e, B:99:0x03ca, B:104:0x03d2, B:106:0x03d6, B:108:0x03e1, B:110:0x0451, B:113:0x0480, B:114:0x0487, B:109:0x0424, B:116:0x048a, B:124:0x049a, B:125:0x04d8, B:126:0x04f7, B:127:0x050a, B:129:0x0568, B:131:0x061c, B:135:0x064b, B:136:0x0650, B:137:0x0657, B:138:0x0658, B:139:0x065f, B:141:0x0661, B:142:0x0667, B:122:0x0496, B:143:0x0668, B:144:0x066d, B:145:0x066e, B:146:0x066f), top: B:167:0x0324 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0496 A[Catch: UnknownResponseException -> 0x0204, UploadAbortedException -> 0x020c, RemoteDfuException -> 0x0670, TryCatch #3 {RemoteDfuException -> 0x0670, blocks: (B:93:0x0324, B:97:0x032e, B:99:0x03ca, B:104:0x03d2, B:106:0x03d6, B:108:0x03e1, B:110:0x0451, B:113:0x0480, B:114:0x0487, B:109:0x0424, B:116:0x048a, B:124:0x049a, B:125:0x04d8, B:126:0x04f7, B:127:0x050a, B:129:0x0568, B:131:0x061c, B:135:0x064b, B:136:0x0650, B:137:0x0657, B:138:0x0658, B:139:0x065f, B:141:0x0661, B:142:0x0667, B:122:0x0496, B:143:0x0668, B:144:0x066d, B:145:0x066e, B:146:0x066f), top: B:167:0x0324 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x049a A[Catch: UnknownResponseException -> 0x0204, UploadAbortedException -> 0x020c, RemoteDfuException -> 0x0670, TryCatch #3 {RemoteDfuException -> 0x0670, blocks: (B:93:0x0324, B:97:0x032e, B:99:0x03ca, B:104:0x03d2, B:106:0x03d6, B:108:0x03e1, B:110:0x0451, B:113:0x0480, B:114:0x0487, B:109:0x0424, B:116:0x048a, B:124:0x049a, B:125:0x04d8, B:126:0x04f7, B:127:0x050a, B:129:0x0568, B:131:0x061c, B:135:0x064b, B:136:0x0650, B:137:0x0657, B:138:0x0658, B:139:0x065f, B:141:0x0661, B:142:0x0667, B:122:0x0496, B:143:0x0668, B:144:0x066d, B:145:0x066e, B:146:0x066f), top: B:167:0x0324 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0568 A[Catch: UnknownResponseException -> 0x0204, UploadAbortedException -> 0x020c, RemoteDfuException -> 0x0670, TryCatch #3 {RemoteDfuException -> 0x0670, blocks: (B:93:0x0324, B:97:0x032e, B:99:0x03ca, B:104:0x03d2, B:106:0x03d6, B:108:0x03e1, B:110:0x0451, B:113:0x0480, B:114:0x0487, B:109:0x0424, B:116:0x048a, B:124:0x049a, B:125:0x04d8, B:126:0x04f7, B:127:0x050a, B:129:0x0568, B:131:0x061c, B:135:0x064b, B:136:0x0650, B:137:0x0657, B:138:0x0658, B:139:0x065f, B:141:0x0661, B:142:0x0667, B:122:0x0496, B:143:0x0668, B:144:0x066d, B:145:0x066e, B:146:0x066f), top: B:167:0x0324 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0658 A[Catch: UnknownResponseException -> 0x0204, UploadAbortedException -> 0x020c, RemoteDfuException -> 0x0670, TryCatch #3 {RemoteDfuException -> 0x0670, blocks: (B:93:0x0324, B:97:0x032e, B:99:0x03ca, B:104:0x03d2, B:106:0x03d6, B:108:0x03e1, B:110:0x0451, B:113:0x0480, B:114:0x0487, B:109:0x0424, B:116:0x048a, B:124:0x049a, B:125:0x04d8, B:126:0x04f7, B:127:0x050a, B:129:0x0568, B:131:0x061c, B:135:0x064b, B:136:0x0650, B:137:0x0657, B:138:0x0658, B:139:0x065f, B:141:0x0661, B:142:0x0667, B:122:0x0496, B:143:0x0668, B:144:0x066d, B:145:0x066e, B:146:0x066f), top: B:167:0x0324 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0222 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0321 A[ADDED_TO_REGION, Catch: UnknownResponseException -> 0x0204, UploadAbortedException -> 0x020c, RemoteDfuException -> 0x0322, REMOVE, TRY_LEAVE, TryCatch #10 {RemoteDfuException -> 0x0322, blocks: (B:75:0x021b, B:78:0x0224, B:80:0x0228, B:82:0x030e, B:87:0x031a, B:88:0x031f, B:89:0x0320, B:90:0x0321), top: B:174:0x021b }] */
    @Override // no.nordicsemi.android.dfu.DfuService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void performDfu(@androidx.annotation.NonNull android.content.Intent r29) throws no.nordicsemi.android.dfu.internal.exception.UploadAbortedException, no.nordicsemi.android.dfu.internal.exception.RemoteDfuException, java.lang.NoSuchMethodException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, java.io.IOException, java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 1831
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.LegacyDfuImpl.performDfu(android.content.Intent):void");
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public BaseCustomDfuImpl.BaseCustomBluetoothCallback getGattCallback() {
        return this.mBluetoothCallback;
    }

    private void writeImageSize(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, int i2, int i3) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        this.mReceivedData = null;
        this.mError = 0;
        this.mImageSizeInProgress = true;
        byte[] bArr = new byte[12];
        setImageSize(bArr, i, 0);
        setImageSize(bArr, i2, 4);
        setImageSize(bArr, i3, 8);
        this.mService.sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bArr));
        if (Build.VERSION.SDK_INT >= 33) {
            this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ", value=" + parse(bArr) + ", WRITE_TYPE_NO_RESPONSE)");
            this.mGatt.writeCharacteristic(bluetoothGattCharacteristic, bArr, 1);
        } else {
            bluetoothGattCharacteristic.setWriteType(1);
            bluetoothGattCharacteristic.setValue(bArr);
            this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
            this.mGatt.writeCharacteristic(bluetoothGattCharacteristic);
        }
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((!this.mImageSizeInProgress || !this.mConnected || this.mError != 0 || this.mAborted) && !this.mPaused) {
                        break;
                    } else {
                        this.mLock.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        if (!this.mAborted) {
            if (this.mConnected) {
                if (this.mError != 0) {
                    throw new DfuException("Unable to write Image Sizes", this.mError);
                }
                return;
            }
            throw new DeviceDisconnectedException("Unable to write Image Sizes: device disconnected");
        }
        throw new UploadAbortedException();
    }
}
