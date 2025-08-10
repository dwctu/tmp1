package no.nordicsemi.android.dfu;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.Build;
import android.preference.PreferenceManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.UUID;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

@SuppressLint({"MissingPermission"})
/* loaded from: classes5.dex */
public class LegacyButtonlessDfuImpl extends BaseButtonlessDfuImpl {
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    private int mVersion;
    public static UUID DFU_SERVICE_UUID = LegacyDfuImpl.DEFAULT_DFU_SERVICE_UUID;
    public static UUID DFU_CONTROL_POINT_UUID = LegacyDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
    public static UUID DFU_VERSION_UUID = LegacyDfuImpl.DEFAULT_DFU_VERSION_UUID;
    private static final byte[] OP_CODE_ENTER_BOOTLOADER = {1, 4};

    public LegacyButtonlessDfuImpl(@NonNull Intent intent, @NonNull DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
    }

    private String getVersionFeatures(int i) {
        return i != 0 ? i != 1 ? i != 5 ? i != 6 ? i != 7 ? i != 8 ? "Unknown version" : "Bootloader from SDK 9.0 or newer. Signature supported" : "Bootloader from SDK 8.0 or newer. SHA-256 used instead of CRC-16 in the Init Packet" : "Bootloader from SDK 8.0 or newer. Bond sharing supported" : "Bootloader from SDK 7.0 or newer. No bond sharing" : "Application with Legacy buttonless update from SDK 7.0 or newer" : "Bootloader from SDK 6.1 or older";
    }

    private int readVersion(@NonNull BluetoothGatt bluetoothGatt, @Nullable BluetoothGattCharacteristic bluetoothGattCharacteristic) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read version number: device disconnected");
        }
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        if (bluetoothGattCharacteristic == null) {
            return 0;
        }
        this.mReceivedData = null;
        this.mError = 0;
        logi("Reading DFU version number...");
        this.mService.sendLogBroadcast(1, "Reading DFU version number...");
        this.mService.sendLogBroadcast(0, "gatt.readCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
        bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
        try {
            synchronized (this.mLock) {
                while (true) {
                    if (((this.mRequestCompleted && this.mReceivedData != null) || !this.mConnected || this.mError != 0 || this.mAborted) && !this.mPaused) {
                        break;
                    }
                    this.mRequestCompleted = false;
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read version number: device disconnected");
        }
        if (this.mError != 0) {
            throw new DfuException("Unable to read version number", this.mError);
        }
        byte[] bArr = this.mReceivedData;
        if (bArr == null || bArr.length < 2) {
            return 0;
        }
        return getShort(bArr, 0);
    }

    public int getShort(@NonNull byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public boolean isClientCompatible(@NonNull Intent intent, @NonNull BluetoothGatt bluetoothGatt) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        BluetoothGattCharacteristic characteristic;
        int version;
        BluetoothGattService service = bluetoothGatt.getService(DFU_SERVICE_UUID);
        if (service == null || (characteristic = service.getCharacteristic(DFU_CONTROL_POINT_UUID)) == null || characteristic.getDescriptor(BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG) == null) {
            return false;
        }
        this.mControlPointCharacteristic = characteristic;
        this.mProgressInfo.setProgress(-2);
        BluetoothGattCharacteristic characteristic2 = service.getCharacteristic(DFU_VERSION_UUID);
        if (characteristic2 != null) {
            version = readVersion(bluetoothGatt, characteristic2);
            this.mVersion = version;
            int i = version & 15;
            int i2 = version >> 8;
            logi("Version number read: " + i2 + "." + i + " -> " + getVersionFeatures(version));
            DfuBaseService dfuBaseService = this.mService;
            StringBuilder sb = new StringBuilder();
            sb.append("Version number read: ");
            sb.append(i2);
            sb.append(".");
            sb.append(i);
            dfuBaseService.sendLogBroadcast(10, sb.toString());
        } else {
            logi("No DFU Version characteristic found -> " + getVersionFeatures(0));
            this.mService.sendLogBroadcast(10, "DFU Version characteristic not found");
            version = 0;
        }
        boolean booleanExtra = PreferenceManager.getDefaultSharedPreferences(this.mService).getBoolean(DfuSettingsConstants.SETTINGS_ASSUME_DFU_NODE, false);
        if (intent.hasExtra(DfuBaseService.EXTRA_FORCE_DFU)) {
            booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_FORCE_DFU, false);
        }
        boolean z = bluetoothGatt.getServices().size() > 3;
        if (version == 0 && z) {
            logi("Additional services found -> Bootloader from SDK 6.1. Updating SD and BL supported, extended init packet not supported");
        }
        return version == 1 || (!booleanExtra && version == 0 && z);
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public void performDfu(@NonNull Intent intent) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        logw("Application with legacy buttonless update found");
        this.mService.sendLogBroadcast(15, "Application with buttonless update found");
        boolean z = true;
        this.mService.sendLogBroadcast(1, "Jumping to the DFU Bootloader...");
        if (intent.hasExtra(DfuBaseService.EXTRA_MTU) && Build.VERSION.SDK_INT >= 21) {
            int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_MTU, 517);
            logi("Requesting MTU = " + intExtra);
            requestMtu(intExtra);
        }
        enableCCCD(this.mControlPointCharacteristic, 1);
        this.mService.sendLogBroadcast(10, "Notifications enabled");
        this.mProgressInfo.setProgress(-3);
        logi("Sending Start DFU command (Op Code = 1, Upload Mode = 4)");
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_ENTER_BOOTLOADER, true);
        this.mService.sendLogBroadcast(10, "Jump to bootloader sent (Op Code = 1, Upload Mode = 4)");
        BluetoothGatt bluetoothGatt = this.mGatt;
        boolean booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_FORCE_SCANNING_FOR_BOOTLOADER_IN_LEGACY_DFU, false);
        if (booleanExtra || this.mVersion == 0) {
            this.mService.disconnect(bluetoothGatt);
        } else {
            this.mService.waitUntilDisconnected();
            this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
        }
        logi("Device disconnected");
        if (!booleanExtra && this.mVersion != 0) {
            z = false;
        }
        finalize(intent, false, z);
    }
}
