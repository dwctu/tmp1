package no.nordicsemi.android.dfu;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import androidx.annotation.NonNull;
import com.google.android.exoplayer2.ExoPlayer;
import java.io.IOException;
import java.util.UUID;
import java.util.zip.CRC32;
import no.nordicsemi.android.dfu.BaseDfuImpl;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.HexFileValidationException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

@SuppressLint({"MissingPermission"})
/* loaded from: classes5.dex */
public abstract class BaseCustomDfuImpl extends BaseDfuImpl {
    public boolean mFirmwareUploadInProgress;
    private boolean mInitPacketInProgress;
    public int mPacketsBeforeNotification;
    private int mPacketsSentSinceNotification;
    public boolean mRemoteErrorOccurred;

    public class BaseCustomBluetoothCallback extends BaseDfuImpl.BaseBluetoothGattCallback {
        public BaseCustomBluetoothCallback() {
            super();
        }

        public void handleNotification(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
            BaseCustomDfuImpl.this.mService.sendLogBroadcast(5, "Notification received from " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bArr));
            BaseCustomDfuImpl baseCustomDfuImpl = BaseCustomDfuImpl.this;
            baseCustomDfuImpl.mReceivedData = bArr;
            baseCustomDfuImpl.mFirmwareUploadInProgress = false;
        }

        public void handlePacketReceiptNotification(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) throws IOException {
            BaseCustomDfuImpl baseCustomDfuImpl = BaseCustomDfuImpl.this;
            if (!baseCustomDfuImpl.mFirmwareUploadInProgress) {
                handleNotification(bluetoothGatt, bluetoothGattCharacteristic, bArr);
                return;
            }
            BluetoothGattCharacteristic characteristic = bluetoothGatt.getService(baseCustomDfuImpl.getDfuServiceUUID()).getCharacteristic(BaseCustomDfuImpl.this.getPacketCharacteristicUUID());
            try {
                BaseCustomDfuImpl.this.mPacketsSentSinceNotification = 0;
                BaseCustomDfuImpl.this.waitIfPaused();
                BaseCustomDfuImpl baseCustomDfuImpl2 = BaseCustomDfuImpl.this;
                if (!baseCustomDfuImpl2.mAborted && baseCustomDfuImpl2.mError == 0 && !baseCustomDfuImpl2.mRemoteErrorOccurred && !baseCustomDfuImpl2.mResetRequestSent) {
                    boolean zIsComplete = baseCustomDfuImpl2.mProgressInfo.isComplete();
                    boolean zIsObjectComplete = BaseCustomDfuImpl.this.mProgressInfo.isObjectComplete();
                    if (!zIsComplete && !zIsObjectComplete) {
                        int availableObjectSizeIsBytes = BaseCustomDfuImpl.this.mProgressInfo.getAvailableObjectSizeIsBytes();
                        BaseCustomDfuImpl baseCustomDfuImpl3 = BaseCustomDfuImpl.this;
                        byte[] bArr2 = baseCustomDfuImpl3.mBuffer;
                        if (availableObjectSizeIsBytes < bArr2.length) {
                            bArr2 = new byte[availableObjectSizeIsBytes];
                        }
                        BaseCustomDfuImpl.this.writePacket(bluetoothGatt, characteristic, bArr2, baseCustomDfuImpl3.mFirmwareStream.read(bArr2));
                        return;
                    }
                    BaseCustomDfuImpl baseCustomDfuImpl4 = BaseCustomDfuImpl.this;
                    baseCustomDfuImpl4.mFirmwareUploadInProgress = false;
                    baseCustomDfuImpl4.notifyLock();
                    return;
                }
                baseCustomDfuImpl2.mFirmwareUploadInProgress = false;
                baseCustomDfuImpl2.mService.sendLogBroadcast(15, "Upload terminated");
            } catch (HexFileValidationException unused) {
                BaseCustomDfuImpl.this.loge("Invalid HEX file");
                BaseCustomDfuImpl.this.mError = 4099;
            } catch (IOException e) {
                BaseCustomDfuImpl.this.loge("Error while reading the input stream", e);
                BaseCustomDfuImpl.this.mError = 4100;
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (i == 0) {
                UUID uuid = bluetoothGattCharacteristic.getUuid();
                if (!uuid.equals(BaseCustomDfuImpl.this.getPacketCharacteristicUUID())) {
                    BaseCustomDfuImpl.this.mService.sendLogBroadcast(5, "Data written to " + uuid);
                    BaseCustomDfuImpl.this.mRequestCompleted = true;
                } else if (BaseCustomDfuImpl.this.mInitPacketInProgress) {
                    BaseCustomDfuImpl.this.mService.sendLogBroadcast(5, "Data written to " + uuid);
                    BaseCustomDfuImpl.this.mInitPacketInProgress = false;
                } else {
                    BaseCustomDfuImpl baseCustomDfuImpl = BaseCustomDfuImpl.this;
                    if (baseCustomDfuImpl.mFirmwareUploadInProgress) {
                        baseCustomDfuImpl.mPacketsSentSinceNotification++;
                        BaseCustomDfuImpl baseCustomDfuImpl2 = BaseCustomDfuImpl.this;
                        boolean z = baseCustomDfuImpl2.mPacketsBeforeNotification > 0 && baseCustomDfuImpl2.mPacketsSentSinceNotification >= BaseCustomDfuImpl.this.mPacketsBeforeNotification;
                        boolean zIsComplete = BaseCustomDfuImpl.this.mProgressInfo.isComplete();
                        boolean zIsObjectComplete = BaseCustomDfuImpl.this.mProgressInfo.isObjectComplete();
                        if (z) {
                            return;
                        }
                        if (zIsComplete || zIsObjectComplete) {
                            BaseCustomDfuImpl baseCustomDfuImpl3 = BaseCustomDfuImpl.this;
                            baseCustomDfuImpl3.mFirmwareUploadInProgress = false;
                            baseCustomDfuImpl3.notifyLock();
                            return;
                        }
                        try {
                            BaseCustomDfuImpl.this.waitIfPaused();
                            BaseCustomDfuImpl baseCustomDfuImpl4 = BaseCustomDfuImpl.this;
                            if (!baseCustomDfuImpl4.mAborted && baseCustomDfuImpl4.mError == 0 && !baseCustomDfuImpl4.mRemoteErrorOccurred && !baseCustomDfuImpl4.mResetRequestSent) {
                                int availableObjectSizeIsBytes = baseCustomDfuImpl4.mProgressInfo.getAvailableObjectSizeIsBytes();
                                BaseCustomDfuImpl baseCustomDfuImpl5 = BaseCustomDfuImpl.this;
                                byte[] bArr = baseCustomDfuImpl5.mBuffer;
                                if (availableObjectSizeIsBytes < bArr.length) {
                                    bArr = new byte[availableObjectSizeIsBytes];
                                }
                                BaseCustomDfuImpl.this.writePacket(bluetoothGatt, bluetoothGattCharacteristic, bArr, baseCustomDfuImpl5.mFirmwareStream.read(bArr));
                                return;
                            }
                            baseCustomDfuImpl4.mFirmwareUploadInProgress = false;
                            baseCustomDfuImpl4.mService.sendLogBroadcast(15, "Upload terminated");
                            BaseCustomDfuImpl.this.notifyLock();
                            return;
                        } catch (HexFileValidationException unused) {
                            BaseCustomDfuImpl.this.loge("Invalid HEX file");
                            BaseCustomDfuImpl.this.mError = 4099;
                        } catch (IOException e) {
                            BaseCustomDfuImpl.this.loge("Error while reading the input stream", e);
                            BaseCustomDfuImpl.this.mError = 4100;
                        }
                    } else {
                        baseCustomDfuImpl.mService.sendLogBroadcast(5, "Data written to " + uuid);
                        onPacketCharacteristicWrite();
                    }
                }
            } else {
                BaseCustomDfuImpl baseCustomDfuImpl6 = BaseCustomDfuImpl.this;
                if (baseCustomDfuImpl6.mResetRequestSent) {
                    baseCustomDfuImpl6.mRequestCompleted = true;
                } else {
                    baseCustomDfuImpl6.loge("Characteristic write error: " + i);
                    BaseCustomDfuImpl.this.mError = i | 16384;
                }
            }
            BaseCustomDfuImpl.this.notifyLock();
        }

        public void onPacketCharacteristicWrite() {
        }
    }

    public BaseCustomDfuImpl(@NonNull Intent intent, DfuBaseService dfuBaseService) throws NumberFormatException {
        super(intent, dfuBaseService);
        int i = 12;
        if (intent.hasExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_ENABLED)) {
            boolean booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_ENABLED, Build.VERSION.SDK_INT < 23);
            int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_VALUE, 12);
            if (intExtra >= 0 && intExtra <= 65535) {
                i = intExtra;
            }
            this.mPacketsBeforeNotification = booleanExtra ? i : 0;
            return;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(dfuBaseService);
        boolean z = defaultSharedPreferences.getBoolean(DfuSettingsConstants.SETTINGS_PACKET_RECEIPT_NOTIFICATION_ENABLED, Build.VERSION.SDK_INT < 23);
        try {
            int i2 = Integer.parseInt(defaultSharedPreferences.getString(DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS, String.valueOf(12)));
            if (i2 >= 0 && i2 <= 65535) {
                i = i2;
            }
        } catch (NumberFormatException unused) {
        }
        this.mPacketsBeforeNotification = z ? i : 0;
    }

    private void writeInitPacket(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        if (bArr.length != i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            bArr = bArr2;
        }
        this.mReceivedData = null;
        this.mError = 0;
        this.mInitPacketInProgress = true;
        logi("Sending init packet (size: " + bArr.length + ", value: 0x" + parse(bArr) + ")");
        this.mService.sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid() + " value (0x): " + parse(bArr));
        if (Build.VERSION.SDK_INT >= 33) {
            this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ", value=0x" + parse(bArr) + ", WRITE_TYPE_NO_RESPONSE)");
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
                    if ((!this.mInitPacketInProgress || !this.mConnected || this.mError != 0) && !this.mPaused) {
                        break;
                    } else {
                        this.mLock.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to write Init DFU Parameters: device disconnected");
        }
        if (this.mError != 0) {
            throw new DfuException("Unable to write Init DFU Parameters", this.mError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writePacket(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
        if (i <= 0) {
            return;
        }
        if (bArr.length != i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            bArr = bArr2;
        }
        this.mProgressInfo.addBytesSent(i);
        if (Build.VERSION.SDK_INT >= 33) {
            bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic, bArr, 1);
            return;
        }
        bluetoothGattCharacteristic.setWriteType(1);
        bluetoothGattCharacteristic.setValue(bArr);
        bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
    }

    public void finalize(Intent intent, boolean z) throws NoSuchMethodException, SecurityException {
        boolean booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_KEEP_BOND, false);
        this.mService.refreshDeviceCache(this.mGatt, z || !booleanExtra);
        this.mService.close(this.mGatt);
        if (this.mGatt.getDevice().getBondState() == 12) {
            boolean booleanExtra2 = intent.getBooleanExtra(DfuBaseService.EXTRA_RESTORE_BOND, false);
            if (booleanExtra2 || !booleanExtra) {
                removeBond();
                this.mService.waitFor(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            }
            if (booleanExtra2 && (this.mFileType & 4) > 0 && !createBond()) {
                logw("Creating bond failed");
            }
        }
        if (this.mProgressInfo.isLastPart()) {
            this.mProgressInfo.setProgress(-6);
            return;
        }
        logi("Starting service that will upload application");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        intent2.putExtra(DfuBaseService.EXTRA_FILE_MIME_TYPE, DfuBaseService.MIME_TYPE_ZIP);
        intent2.putExtra(DfuBaseService.EXTRA_FILE_TYPE, 4);
        intent2.putExtra(DfuBaseService.EXTRA_PART_CURRENT, this.mProgressInfo.getCurrentPart() + 1);
        intent2.putExtra(DfuBaseService.EXTRA_PARTS_TOTAL, this.mProgressInfo.getTotalParts());
        restartService(intent2, true);
    }

    public abstract UUID getControlPointCharacteristicUUID();

    public abstract UUID getDfuServiceUUID();

    public abstract UUID getPacketCharacteristicUUID();

    public void uploadFirmwareImage(BluetoothGattCharacteristic bluetoothGattCharacteristic) throws UploadAbortedException, DfuException, IOException, DeviceDisconnectedException {
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        this.mReceivedData = null;
        this.mError = 0;
        this.mFirmwareUploadInProgress = true;
        this.mPacketsSentSinceNotification = 0;
        try {
            int availableObjectSizeIsBytes = this.mProgressInfo.getAvailableObjectSizeIsBytes();
            byte[] bArr = this.mBuffer;
            if (availableObjectSizeIsBytes < bArr.length) {
                bArr = new byte[availableObjectSizeIsBytes];
            }
            int i = this.mFirmwareStream.read(bArr);
            this.mService.sendLogBroadcast(1, "Sending firmware to characteristic " + bluetoothGattCharacteristic.getUuid() + "...");
            writePacket(this.mGatt, bluetoothGattCharacteristic, bArr, i);
            try {
                synchronized (this.mLock) {
                    while (true) {
                        if ((!this.mFirmwareUploadInProgress || this.mReceivedData != null || !this.mConnected || this.mError != 0) && !this.mPaused) {
                            break;
                        } else {
                            this.mLock.wait();
                        }
                    }
                }
            } catch (InterruptedException e) {
                loge("Sleeping interrupted", e);
            }
            if (!this.mConnected) {
                throw new DeviceDisconnectedException("Uploading Firmware Image failed: device disconnected");
            }
            if (this.mError != 0) {
                throw new DfuException("Uploading Firmware Image failed", this.mError);
            }
        } catch (HexFileValidationException unused) {
            throw new DfuException("HEX file not valid", 4099);
        } catch (IOException unused2) {
            throw new DfuException("Error while reading file", 4100);
        }
    }

    public void writeInitData(BluetoothGattCharacteristic bluetoothGattCharacteristic, CRC32 crc32) throws UploadAbortedException, DfuException, IOException, DeviceDisconnectedException {
        try {
            byte[] bArr = this.mBuffer;
            while (true) {
                int i = this.mInitPacketStream.read(bArr, 0, bArr.length);
                if (i == -1) {
                    return;
                }
                writeInitPacket(bluetoothGattCharacteristic, bArr, i);
                if (crc32 != null) {
                    crc32.update(bArr, 0, i);
                }
            }
        } catch (IOException e) {
            loge("Error while reading Init packet file", e);
            throw new DfuException("Error while reading Init packet file", 4098);
        }
    }
}
