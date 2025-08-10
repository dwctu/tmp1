package no.nordicsemi.android.dfu;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.UUID;
import no.nordicsemi.android.dfu.DfuCallback;
import no.nordicsemi.android.dfu.internal.ArchiveInputStream;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
import no.nordicsemi.android.dfu.internal.scanner.BootloaderScannerFactory;
import org.aspectj.runtime.reflect.SignatureImpl;

@SuppressLint({"MissingPermission"})
/* loaded from: classes5.dex */
public abstract class BaseDfuImpl implements DfuService {
    public static final int INDICATIONS = 2;
    private static final int MAX_PACKET_SIZE_DEFAULT = 20;
    public static final int NOTIFICATIONS = 1;
    private static final String TAG = "DfuImpl";
    public boolean mAborted;
    private int mCurrentMtu;
    public int mError;
    public int mFileType;
    public InputStream mFirmwareStream;
    public BluetoothGatt mGatt;
    public int mImageSizeInBytes;
    public int mInitPacketSizeInBytes;
    public InputStream mInitPacketStream;
    public boolean mPaused;
    public DfuProgressInfo mProgressInfo;
    public boolean mRequestCompleted;
    public boolean mResetRequestSent;
    public DfuBaseService mService;
    public static final UUID GENERIC_ATTRIBUTE_SERVICE_UUID = new UUID(26392574038016L, -9223371485494954757L);
    public static final UUID SERVICE_CHANGED_UUID = new UUID(46200963207168L, -9223371485494954757L);
    public static final UUID CLIENT_CHARACTERISTIC_CONFIG = new UUID(45088566677504L, -9223371485494954757L);
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    public final Object mLock = new Object();
    public byte[] mReceivedData = null;
    public byte[] mBuffer = new byte[20];
    public boolean mConnected = true;

    public BaseDfuImpl(@NonNull Intent intent, @NonNull DfuBaseService dfuBaseService) {
        this.mService = dfuBaseService;
        this.mProgressInfo = dfuBaseService.mProgressInfo;
    }

    private boolean createBondApi18(@NonNull BluetoothDevice bluetoothDevice) throws NoSuchMethodException, SecurityException {
        try {
            Method method = bluetoothDevice.getClass().getMethod("createBond", new Class[0]);
            this.mService.sendLogBroadcast(0, "gatt.getDevice().createBond() (hidden)");
            return ((Boolean) method.invoke(bluetoothDevice, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean isServiceChangedCCCDEnabled() throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattDescriptor descriptor;
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read Service Changed CCCD: device disconnected");
        }
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        BluetoothGatt bluetoothGatt = this.mGatt;
        BluetoothGattService service = bluetoothGatt.getService(GENERIC_ATTRIBUTE_SERVICE_UUID);
        if (service == null || (characteristic = service.getCharacteristic(SERVICE_CHANGED_UUID)) == null || (descriptor = characteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG)) == null) {
            return false;
        }
        this.mRequestCompleted = false;
        this.mReceivedData = null;
        this.mError = 0;
        logi("Reading Service Changed CCCD value...");
        this.mService.sendLogBroadcast(1, "Reading Service Changed CCCD value...");
        this.mService.sendLogBroadcast(0, "gatt.readDescriptor(" + descriptor.getUuid() + ")");
        bluetoothGatt.readDescriptor(descriptor);
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((this.mRequestCompleted || !this.mConnected || this.mError != 0) && !this.mPaused) {
                        break;
                    }
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read Service Changed CCCD: device disconnected");
        }
        if (this.mError != 0) {
            throw new DfuException("Unable to read Service Changed CCCD", this.mError);
        }
        byte[] bArr = this.mReceivedData;
        if (bArr == null || bArr.length != 2) {
            return false;
        }
        byte b = bArr[0];
        byte[] bArr2 = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        return b == bArr2[0] && bArr[1] == bArr2[1];
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void abort() {
        this.mPaused = false;
        this.mAborted = true;
        notifyLock();
    }

    public boolean createBond() throws NoSuchMethodException, SecurityException {
        boolean zCreateBondApi18;
        BluetoothDevice device = this.mGatt.getDevice();
        this.mRequestCompleted = false;
        this.mService.sendLogBroadcast(1, "Starting pairing...");
        if (Build.VERSION.SDK_INT >= 19) {
            this.mService.sendLogBroadcast(0, "gatt.getDevice().createBond()");
            zCreateBondApi18 = device.createBond();
        } else {
            zCreateBondApi18 = createBondApi18(device);
        }
        try {
            synchronized (this.mLock) {
                while (zCreateBondApi18) {
                    if (this.mRequestCompleted || this.mAborted) {
                        break;
                    }
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        return zCreateBondApi18;
    }

    public void enableCCCD(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        BluetoothGatt bluetoothGatt = this.mGatt;
        String str = i == 1 ? "notifications" : "indications";
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to set " + str + " state: device disconnected");
        }
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        this.mRequestCompleted = false;
        this.mReceivedData = null;
        this.mError = 0;
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG);
        logi("Enabling " + str + "...");
        this.mService.sendLogBroadcast(1, "Enabling " + str + " for " + bluetoothGattCharacteristic.getUuid());
        this.mService.sendLogBroadcast(0, "gatt.setCharacteristicNotification(" + bluetoothGattCharacteristic.getUuid() + ", true)");
        bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, true);
        DfuBaseService dfuBaseService = this.mService;
        StringBuilder sb = new StringBuilder();
        sb.append("gatt.writeDescriptor(");
        sb.append(descriptor.getUuid());
        sb.append(i == 1 ? ", value=0x01-00)" : ", value=0x02-00)");
        dfuBaseService.sendLogBroadcast(0, sb.toString());
        if (Build.VERSION.SDK_INT >= 33) {
            bluetoothGatt.writeDescriptor(descriptor, i == 1 ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
        } else {
            descriptor.setValue(i == 1 ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
            bluetoothGatt.writeDescriptor(descriptor);
        }
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((this.mRequestCompleted || !this.mConnected || this.mError != 0) && !this.mPaused) {
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
            throw new DeviceDisconnectedException("Unable to set " + str + " state: device disconnected");
        }
        if (this.mError == 0) {
            return;
        }
        throw new DfuException("Unable to set " + str + " state", this.mError);
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public boolean initialize(@NonNull Intent intent, @NonNull BluetoothGatt bluetoothGatt, int i, @NonNull InputStream inputStream, @Nullable InputStream inputStream2) throws UploadAbortedException, DfuException, IOException, DeviceDisconnectedException {
        int iAvailable;
        BluetoothGattService service;
        BluetoothGattCharacteristic characteristic;
        this.mGatt = bluetoothGatt;
        this.mFileType = i;
        this.mFirmwareStream = inputStream;
        this.mInitPacketStream = inputStream2;
        int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_PART_CURRENT, 1);
        int intExtra2 = intent.getIntExtra(DfuBaseService.EXTRA_PARTS_TOTAL, 1);
        this.mCurrentMtu = intent.getIntExtra(DfuBaseService.EXTRA_CURRENT_MTU, 23);
        if (i > 4) {
            logw("DFU target does not support (SD/BL)+App update, splitting into 2 parts");
            this.mService.sendLogBroadcast(15, "Sending system components");
            int i2 = this.mFileType & (-5);
            this.mFileType = i2;
            ((ArchiveInputStream) this.mFirmwareStream).setContentType(i2);
            intExtra2 = 2;
        }
        if (intExtra == 2) {
            this.mService.sendLogBroadcast(15, "Sending application");
        }
        int iAvailable2 = 0;
        if (inputStream2 != null) {
            try {
                if (inputStream2.markSupported()) {
                    inputStream2.reset();
                }
                iAvailable = inputStream2.available();
            } catch (Exception unused) {
            }
        } else {
            iAvailable = 0;
        }
        this.mInitPacketSizeInBytes = iAvailable;
        try {
            if (inputStream.markSupported()) {
                if (inputStream instanceof ArchiveInputStream) {
                    ((ArchiveInputStream) inputStream).fullReset();
                } else {
                    inputStream.reset();
                }
            }
            iAvailable2 = inputStream.available();
        } catch (Exception unused2) {
        }
        this.mImageSizeInBytes = iAvailable2;
        this.mProgressInfo.init(iAvailable2, intExtra, intExtra2);
        if (bluetoothGatt.getDevice().getBondState() == 12 && (service = bluetoothGatt.getService(GENERIC_ATTRIBUTE_SERVICE_UUID)) != null && (characteristic = service.getCharacteristic(SERVICE_CHANGED_UUID)) != null) {
            if (!isServiceChangedCCCDEnabled()) {
                enableCCCD(characteristic, 2);
            }
            logi("Service Changed indications enabled");
            this.mService.sendLogBroadcast(10, "Service Changed indications enabled");
        }
        return true;
    }

    public boolean isBonded() {
        return this.mGatt.getDevice().getBondState() == 12;
    }

    public void loge(String str) {
    }

    public void loge(String str, Throwable th) {
    }

    public void logi(String str) {
        boolean z = DfuBaseService.DEBUG;
    }

    public void logw(String str) {
        boolean z = DfuBaseService.DEBUG;
    }

    public void notifyLock() {
        synchronized (this.mLock) {
            this.mLock.notifyAll();
        }
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public void onBondStateChanged(int i) {
        this.mRequestCompleted = true;
        notifyLock();
    }

    public String parse(@Nullable byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) == 0) {
            return "";
        }
        char[] cArr = new char[(length * 3) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 3;
            char[] cArr2 = HEX_ARRAY;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
            if (i != length - 1) {
                cArr[i3 + 2] = SignatureImpl.SEP;
            }
        }
        return new String(cArr);
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void pause() {
        this.mPaused = true;
    }

    public byte[] readNotificationResponse() throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((this.mReceivedData != null || !this.mConnected || this.mError != 0 || this.mAborted) && !this.mPaused) {
                        break;
                    }
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to write Op Code: device disconnected");
        }
        if (this.mError == 0) {
            return this.mReceivedData;
        }
        throw new DfuException("Unable to write Op Code", this.mError);
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public void release() {
        this.mService = null;
    }

    public boolean removeBond() throws NoSuchMethodException, SecurityException {
        BluetoothDevice device = this.mGatt.getDevice();
        if (device.getBondState() == 10) {
            return true;
        }
        this.mService.sendLogBroadcast(1, "Removing bond information...");
        boolean zBooleanValue = false;
        try {
            Method method = device.getClass().getMethod("removeBond", new Class[0]);
            this.mRequestCompleted = false;
            this.mService.sendLogBroadcast(0, "gatt.getDevice().removeBond() (hidden)");
            zBooleanValue = ((Boolean) method.invoke(device, new Object[0])).booleanValue();
            try {
                synchronized (this.mLock) {
                    while (!this.mRequestCompleted && !this.mAborted) {
                        this.mLock.wait();
                    }
                }
            } catch (InterruptedException e) {
                loge("Sleeping interrupted", e);
            }
        } catch (Exception unused) {
        }
        return zBooleanValue;
    }

    @RequiresApi(api = 21)
    public void requestMtu(@IntRange(from = 0, to = 517) int i) throws UploadAbortedException, DeviceDisconnectedException {
        if (Build.HARDWARE.equals("ums512_25c10")) {
            if (i != 516) {
                logw("MTU request disabled for this device. See https://github.com/NordicSemiconductor/Android-DFU-Library/issues/339");
                return;
            }
            logw("MTU request forced");
        }
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        this.mRequestCompleted = false;
        this.mService.sendLogBroadcast(1, "Requesting new MTU...");
        this.mService.sendLogBroadcast(0, "gatt.requestMtu(" + i + ")");
        if (this.mGatt.requestMtu(i)) {
            try {
                synchronized (this.mLock) {
                    while (true) {
                        if ((this.mRequestCompleted || !this.mConnected || this.mError != 0) && !this.mPaused) {
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
                throw new DeviceDisconnectedException("Unable to read Service Changed CCCD: device disconnected");
            }
        }
    }

    public void restartService(@NonNull Intent intent, boolean z) {
        String strSearchUsing;
        if (z) {
            long longExtra = intent.getLongExtra(DfuBaseService.EXTRA_SCAN_DELAY, 0L);
            long longExtra2 = intent.getLongExtra(DfuBaseService.EXTRA_SCAN_TIMEOUT, 5000L);
            this.mService.sendLogBroadcast(1, "Scanning for the DFU Bootloader... (timeout " + longExtra2 + " ms)");
            if (longExtra > 0) {
                this.mService.waitFor(longExtra);
            }
            strSearchUsing = BootloaderScannerFactory.getScanner(this.mGatt.getDevice().getAddress()).searchUsing(this.mService.getDeviceSelector(), longExtra2);
            logi("Scanning for new address finished with: " + strSearchUsing);
            if (strSearchUsing != null) {
                this.mService.sendLogBroadcast(5, "DFU Bootloader found with address " + strSearchUsing);
            } else {
                this.mService.sendLogBroadcast(5, "DFU Bootloader not found. Trying the same address...");
            }
        } else {
            strSearchUsing = null;
        }
        if (strSearchUsing != null) {
            intent.putExtra(DfuBaseService.EXTRA_DEVICE_ADDRESS, strSearchUsing);
        }
        intent.putExtra(DfuBaseService.EXTRA_DFU_ATTEMPT, 0);
        this.mService.startService(intent);
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void resume() {
        this.mPaused = false;
        notifyLock();
    }

    public void waitIfPaused() {
        try {
            synchronized (this.mLock) {
                while (this.mPaused) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
    }

    public void writeOpCode(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull byte[] bArr, boolean z) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        this.mReceivedData = null;
        this.mError = 0;
        this.mRequestCompleted = false;
        this.mResetRequestSent = z;
        this.mService.sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bArr));
        if (Build.VERSION.SDK_INT >= 33) {
            this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ", value=0x" + parse(bArr) + ", WRITE_TYPE_DEFAULT)");
            this.mGatt.writeCharacteristic(bluetoothGattCharacteristic, bArr, 2);
        } else {
            bluetoothGattCharacteristic.setWriteType(2);
            bluetoothGattCharacteristic.setValue(bArr);
            this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
            this.mGatt.writeCharacteristic(bluetoothGattCharacteristic);
        }
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((this.mRequestCompleted || !this.mConnected || this.mError != 0) && !this.mPaused) {
                        break;
                    } else {
                        this.mLock.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        boolean z2 = this.mResetRequestSent;
        if (!z2 && !this.mConnected) {
            throw new DeviceDisconnectedException("Unable to write Op Code " + ((int) bArr[0]) + ": device disconnected");
        }
        if (z2 || this.mError == 0) {
            return;
        }
        throw new DfuException("Unable to write Op Code " + ((int) bArr[0]), this.mError);
    }

    public class BaseBluetoothGattCallback extends DfuCallback.DfuGattCallback {
        public BaseBluetoothGattCallback() {
        }

        private String phyToString(int i) {
            if (i == 1) {
                return "LE 1M";
            }
            if (i == 2) {
                return "LE 2M";
            }
            if (i == 3) {
                return "LE Coded";
            }
            return "UNKNOWN (" + i + ")";
        }

        public int getInt(@NonNull byte[] bArr, int i) {
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(@NonNull BluetoothGatt bluetoothGatt, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull byte[] bArr) {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(@NonNull BluetoothGatt bluetoothGatt, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull byte[] bArr, int i) {
            if (i == 0) {
                BaseDfuImpl.this.mService.sendLogBroadcast(5, "Read Response received from " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bArr));
                BaseDfuImpl baseDfuImpl = BaseDfuImpl.this;
                baseDfuImpl.mReceivedData = bArr;
                baseDfuImpl.mRequestCompleted = true;
            } else {
                BaseDfuImpl.this.loge("Characteristic read error: " + i);
                BaseDfuImpl.this.mError = i | 16384;
            }
            BaseDfuImpl.this.notifyLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(@NonNull BluetoothGatt bluetoothGatt, @NonNull BluetoothGattDescriptor bluetoothGattDescriptor, int i, @NonNull byte[] bArr) {
            if (i == 0) {
                UUID uuid = bluetoothGattDescriptor.getUuid();
                UUID uuid2 = bluetoothGattDescriptor.getCharacteristic().getUuid();
                BaseDfuImpl.this.mReceivedData = bArr;
                if (BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG.equals(uuid)) {
                    BaseDfuImpl.this.mService.sendLogBroadcast(5, "Read Response received from descr." + uuid2 + ", value (0x): " + parse(bArr));
                    if (BaseDfuImpl.SERVICE_CHANGED_UUID.equals(uuid2)) {
                        BaseDfuImpl.this.mRequestCompleted = true;
                    } else {
                        BaseDfuImpl.this.loge("Unknown descriptor read");
                    }
                }
            } else {
                BaseDfuImpl.this.loge("Descriptor read error: " + i);
                BaseDfuImpl.this.mError = i | 16384;
            }
            BaseDfuImpl.this.notifyLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            if (i == 0) {
                UUID uuid = bluetoothGattDescriptor.getUuid();
                UUID uuid2 = bluetoothGattDescriptor.getCharacteristic().getUuid();
                if (BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG.equals(uuid)) {
                    BaseDfuImpl.this.mService.sendLogBroadcast(5, "Data written to descr." + uuid2);
                    if (BaseDfuImpl.SERVICE_CHANGED_UUID.equals(uuid2)) {
                        BaseDfuImpl.this.mService.sendLogBroadcast(1, "Indications enabled for " + uuid2);
                    } else {
                        BaseDfuImpl.this.mService.sendLogBroadcast(1, "Notifications enabled for " + uuid2);
                    }
                }
                BaseDfuImpl.this.mRequestCompleted = true;
            } else {
                BaseDfuImpl.this.loge("Descriptor write error: " + i);
                BaseDfuImpl.this.mError = i | 16384;
            }
            BaseDfuImpl.this.notifyLock();
        }

        @Override // no.nordicsemi.android.dfu.DfuCallback.DfuGattCallback
        public void onDisconnected() {
            BaseDfuImpl baseDfuImpl = BaseDfuImpl.this;
            baseDfuImpl.mConnected = false;
            baseDfuImpl.notifyLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i2 == 0) {
                BaseDfuImpl.this.mService.sendLogBroadcast(5, "MTU changed to: " + i);
                int i3 = i + (-3);
                BaseDfuImpl baseDfuImpl = BaseDfuImpl.this;
                if (i3 > baseDfuImpl.mBuffer.length) {
                    baseDfuImpl.mBuffer = new byte[i3];
                }
                baseDfuImpl.logi("MTU changed to: " + i);
            } else {
                BaseDfuImpl.this.logw("Changing MTU failed: " + i2 + " (mtu: " + i + ")");
                if (i2 == 4 && BaseDfuImpl.this.mCurrentMtu > 23) {
                    int i4 = BaseDfuImpl.this.mCurrentMtu - 3;
                    BaseDfuImpl baseDfuImpl2 = BaseDfuImpl.this;
                    if (i4 > baseDfuImpl2.mBuffer.length) {
                        baseDfuImpl2.mBuffer = new byte[baseDfuImpl2.mCurrentMtu - 3];
                        BaseDfuImpl.this.logi("MTU restored to: " + BaseDfuImpl.this.mCurrentMtu);
                    }
                }
            }
            BaseDfuImpl baseDfuImpl3 = BaseDfuImpl.this;
            baseDfuImpl3.mRequestCompleted = true;
            baseDfuImpl3.notifyLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
            if (i3 != 0) {
                BaseDfuImpl.this.logw("Updating PHY failed: " + i3 + " (txPhy: " + i + ", rxPhy: " + i2 + ")");
                return;
            }
            BaseDfuImpl.this.mService.sendLogBroadcast(5, "PHY updated (TX: " + phyToString(i) + ", RX: " + phyToString(i2) + ")");
            BaseDfuImpl.this.logi("PHY updated (TX: " + phyToString(i) + ", RX: " + phyToString(i2) + ")");
        }

        public String parse(byte[] bArr) {
            int length;
            if (bArr == null || (length = bArr.length) == 0) {
                return "";
            }
            char[] cArr = new char[(length * 3) - 1];
            for (int i = 0; i < length; i++) {
                int i2 = bArr[i] & 255;
                int i3 = i * 3;
                cArr[i3] = BaseDfuImpl.HEX_ARRAY[i2 >>> 4];
                cArr[i3 + 1] = BaseDfuImpl.HEX_ARRAY[i2 & 15];
                if (i != length - 1) {
                    cArr[i3 + 2] = SignatureImpl.SEP;
                }
            }
            return new String(cArr);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue(), i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i, bluetoothGattDescriptor.getValue());
        }
    }
}
