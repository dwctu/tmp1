package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.primitives.UnsignedInts;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.UUID;
import no.nordicsemi.android.dfu.BaseCustomDfuImpl;
import no.nordicsemi.android.dfu.BaseDfuImpl;
import no.nordicsemi.android.dfu.internal.ArchiveInputStream;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuExtendedErrorException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
import no.nordicsemi.android.error.SecureDfuError;

/* loaded from: classes5.dex */
public class SecureDfuImpl extends BaseCustomDfuImpl {
    public static final UUID DEFAULT_DFU_CONTROL_POINT_UUID;
    public static final UUID DEFAULT_DFU_PACKET_UUID;
    public static final UUID DEFAULT_DFU_SERVICE_UUID;
    public static UUID DFU_CONTROL_POINT_UUID = null;
    public static UUID DFU_PACKET_UUID = null;
    public static UUID DFU_SERVICE_UUID = null;
    private static final int DFU_STATUS_SUCCESS = 1;
    private static final int MAX_ATTEMPTS = 3;
    private static final int OBJECT_COMMAND = 1;
    private static final int OBJECT_DATA = 2;
    private static final byte[] OP_CODE_CALCULATE_CHECKSUM;
    private static final int OP_CODE_CALCULATE_CHECKSUM_KEY = 3;
    private static final byte[] OP_CODE_CREATE_COMMAND;
    private static final byte[] OP_CODE_CREATE_DATA;
    private static final int OP_CODE_CREATE_KEY = 1;
    private static final byte[] OP_CODE_EXECUTE;
    private static final int OP_CODE_EXECUTE_KEY = 4;
    private static final byte[] OP_CODE_PACKET_RECEIPT_NOTIF_REQ;
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_REQ_KEY = 2;
    private static final int OP_CODE_RESPONSE_CODE_KEY = 96;
    private static final byte[] OP_CODE_SELECT_OBJECT;
    private static final int OP_CODE_SELECT_OBJECT_KEY = 6;
    private final SecureBluetoothCallback mBluetoothCallback;
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    private BluetoothGattCharacteristic mPacketCharacteristic;
    private long prepareObjectDelay;

    public static class ObjectChecksum {
        public int CRC32;
        public int offset;

        private ObjectChecksum() {
        }

        /* synthetic */ ObjectChecksum(Constructor constructor) {
            this();
        }
    }

    public static class ObjectInfo extends ObjectChecksum {
        public int maxSize;

        private ObjectInfo() {
            super(null);
        }

        /* synthetic */ ObjectInfo(Constructor constructor) {
            this();
        }
    }

    public class SecureBluetoothCallback extends BaseCustomDfuImpl.BaseCustomBluetoothCallback {
        public SecureBluetoothCallback() {
            super();
        }

        @Override // no.nordicsemi.android.dfu.BaseDfuImpl.BaseBluetoothGattCallback, android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(@NonNull BluetoothGatt bluetoothGatt, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull byte[] bArr) throws IOException {
            if (bArr.length < 3) {
                SecureDfuImpl.this.loge("Empty response: " + parse(bArr));
                SecureDfuImpl secureDfuImpl = SecureDfuImpl.this;
                secureDfuImpl.mError = DfuBaseService.ERROR_INVALID_RESPONSE;
                secureDfuImpl.notifyLock();
                return;
            }
            if ((bArr[0] & 255) != 96) {
                SecureDfuImpl.this.loge("Invalid response: " + parse(bArr));
                SecureDfuImpl.this.mError = DfuBaseService.ERROR_INVALID_RESPONSE;
            } else if ((bArr[1] & 255) != 3) {
                SecureDfuImpl secureDfuImpl2 = SecureDfuImpl.this;
                if (!secureDfuImpl2.mRemoteErrorOccurred) {
                    if ((bArr[2] & 255) != 1) {
                        secureDfuImpl2.mRemoteErrorOccurred = true;
                    }
                    handleNotification(bluetoothGatt, bluetoothGattCharacteristic, bArr);
                }
            } else {
                int iIntValue = bluetoothGattCharacteristic.getIntValue(20, 3).intValue();
                if (((int) (((ArchiveInputStream) SecureDfuImpl.this.mFirmwareStream).getCrc32() & UnsignedInts.INT_MASK)) == bluetoothGattCharacteristic.getIntValue(20, 7).intValue()) {
                    SecureDfuImpl.this.mProgressInfo.setBytesReceived(iIntValue);
                } else {
                    SecureDfuImpl secureDfuImpl3 = SecureDfuImpl.this;
                    if (secureDfuImpl3.mFirmwareUploadInProgress) {
                        secureDfuImpl3.mFirmwareUploadInProgress = false;
                        secureDfuImpl3.notifyLock();
                        return;
                    }
                }
                handlePacketReceiptNotification(bluetoothGatt, bluetoothGattCharacteristic, bArr);
            }
            SecureDfuImpl.this.notifyLock();
        }
    }

    static {
        UUID uuid = new UUID(279658205548544L, -9223371485494954757L);
        DEFAULT_DFU_SERVICE_UUID = uuid;
        UUID uuid2 = new UUID(-8157989241631715488L, -6937650605005804976L);
        DEFAULT_DFU_CONTROL_POINT_UUID = uuid2;
        UUID uuid3 = new UUID(-8157989237336748192L, -6937650605005804976L);
        DEFAULT_DFU_PACKET_UUID = uuid3;
        DFU_SERVICE_UUID = uuid;
        DFU_CONTROL_POINT_UUID = uuid2;
        DFU_PACKET_UUID = uuid3;
        OP_CODE_CREATE_COMMAND = new byte[]{1, 1, 0, 0, 0, 0};
        OP_CODE_CREATE_DATA = new byte[]{1, 2, 0, 0, 0, 0};
        OP_CODE_PACKET_RECEIPT_NOTIF_REQ = new byte[]{2, 0, 0};
        OP_CODE_CALCULATE_CHECKSUM = new byte[]{3};
        OP_CODE_EXECUTE = new byte[]{4};
        OP_CODE_SELECT_OBJECT = new byte[]{6, 0};
    }

    public SecureDfuImpl(@NonNull Intent intent, @NonNull DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
        this.mBluetoothCallback = new SecureBluetoothCallback();
    }

    private int getStatusCode(byte[] bArr, int i) throws UnknownResponseException {
        if (bArr != null && bArr.length >= 3 && bArr[0] == 96 && bArr[1] == i && (bArr[2] == 1 || bArr[2] == 2 || bArr[2] == 3 || bArr[2] == 4 || bArr[2] == 5 || bArr[2] == 7 || bArr[2] == 8 || bArr[2] == 10 || bArr[2] == 11)) {
            return bArr[2];
        }
        throw new UnknownResponseException("Invalid response received", bArr, 96, i);
    }

    private ObjectChecksum readChecksum() throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
        }
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_CALCULATE_CHECKSUM);
        byte[] notificationResponse = readNotificationResponse();
        int statusCode = getStatusCode(notificationResponse, 3);
        if (statusCode == 11) {
            throw new RemoteDfuExtendedErrorException("Receiving Checksum failed", notificationResponse[3]);
        }
        if (statusCode != 1) {
            throw new RemoteDfuException("Receiving Checksum failed", statusCode);
        }
        ObjectChecksum objectChecksum = new ObjectChecksum(null);
        objectChecksum.offset = unsignedBytesToInt(notificationResponse, 3);
        objectChecksum.CRC32 = unsignedBytesToInt(notificationResponse, 7);
        return objectChecksum;
    }

    private ObjectInfo selectObject(int i) throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read object info: device disconnected");
        }
        byte[] bArr = OP_CODE_SELECT_OBJECT;
        bArr[1] = (byte) i;
        writeOpCode(this.mControlPointCharacteristic, bArr);
        byte[] notificationResponse = readNotificationResponse();
        int statusCode = getStatusCode(notificationResponse, 6);
        if (statusCode == 11) {
            throw new RemoteDfuExtendedErrorException("Selecting object failed", notificationResponse[3]);
        }
        if (statusCode != 1) {
            throw new RemoteDfuException("Selecting object failed", statusCode);
        }
        ObjectInfo objectInfo = new ObjectInfo(null);
        objectInfo.maxSize = unsignedBytesToInt(notificationResponse, 3);
        objectInfo.offset = unsignedBytesToInt(notificationResponse, 7);
        objectInfo.CRC32 = unsignedBytesToInt(notificationResponse, 11);
        return objectInfo;
    }

    private void sendFirmware(BluetoothGatt bluetoothGatt) throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException, IOException {
        int i;
        boolean z;
        String str;
        boolean z2;
        int i2 = this.mPacketsBeforeNotification;
        String str2 = ")";
        if (i2 > 0) {
            setPacketReceiptNotifications(i2);
            this.mService.sendLogBroadcast(10, "Packet Receipt Notif Req (Op Code = 2) sent (Value = " + i2 + ")");
        }
        logi("Setting object to Data (Op Code = 6, Type = 2)");
        ObjectInfo objectInfoSelectObject = selectObject(2);
        Locale locale = Locale.US;
        logi(String.format(locale, "Data object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(objectInfoSelectObject.maxSize), Integer.valueOf(objectInfoSelectObject.offset), Integer.valueOf(objectInfoSelectObject.CRC32)));
        this.mService.sendLogBroadcast(10, String.format(locale, "Data object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(objectInfoSelectObject.maxSize), Integer.valueOf(objectInfoSelectObject.offset), Integer.valueOf(objectInfoSelectObject.CRC32)));
        this.mProgressInfo.setMaxObjectSizeInBytes(objectInfoSelectObject.maxSize);
        int i3 = this.mImageSizeInBytes;
        int i4 = objectInfoSelectObject.maxSize;
        int i5 = ((i3 + i4) - 1) / i4;
        int i6 = objectInfoSelectObject.offset;
        if (i6 > 0) {
            try {
                i = i6 / i4;
                int i7 = i4 * i;
                int i8 = i6 - i7;
                if (i8 == 0) {
                    i7 -= i4;
                } else {
                    i4 = i8;
                }
                int i9 = i7;
                if (i9 > 0) {
                    this.mFirmwareStream.read(new byte[i9]);
                    this.mFirmwareStream.mark(objectInfoSelectObject.maxSize);
                }
                this.mFirmwareStream.read(new byte[i4]);
                if (((int) (((ArchiveInputStream) this.mFirmwareStream).getCrc32() & UnsignedInts.INT_MASK)) == objectInfoSelectObject.CRC32) {
                    logi(objectInfoSelectObject.offset + " bytes of data sent before, CRC match");
                    this.mService.sendLogBroadcast(10, objectInfoSelectObject.offset + " bytes of data sent before, CRC match");
                    this.mProgressInfo.setBytesSent(objectInfoSelectObject.offset);
                    this.mProgressInfo.setBytesReceived(objectInfoSelectObject.offset);
                    if (i4 != objectInfoSelectObject.maxSize || objectInfoSelectObject.offset >= this.mImageSizeInBytes) {
                        z = true;
                    } else {
                        logi("Executing data object (Op Code = 4)");
                        try {
                            writeExecute();
                            this.mService.sendLogBroadcast(10, "Data object executed");
                        } catch (RemoteDfuException e) {
                            if (e.getErrorNumber() != 8) {
                                throw e;
                            }
                            this.mService.sendLogBroadcast(10, "Data object already executed");
                            this.mRemoteErrorOccurred = false;
                        }
                    }
                } else {
                    logi(objectInfoSelectObject.offset + " bytes sent before, CRC does not match");
                    this.mService.sendLogBroadcast(15, objectInfoSelectObject.offset + " bytes sent before, CRC does not match");
                    this.mProgressInfo.setBytesSent(i9);
                    this.mProgressInfo.setBytesReceived(i9);
                    objectInfoSelectObject.offset = objectInfoSelectObject.offset - i4;
                    objectInfoSelectObject.CRC32 = 0;
                    this.mFirmwareStream.reset();
                    logi("Resuming from byte " + objectInfoSelectObject.offset + "...");
                    this.mService.sendLogBroadcast(10, "Resuming from byte " + objectInfoSelectObject.offset + "...");
                }
                z = false;
            } catch (IOException e2) {
                loge("Error while reading firmware stream", e2);
                this.mService.terminateConnection(bluetoothGatt, 4100);
                return;
            }
        } else {
            this.mProgressInfo.setBytesSent(0);
            z = false;
            i = 0;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (objectInfoSelectObject.offset < this.mImageSizeInBytes) {
            int i10 = 1;
            while (this.mProgressInfo.getAvailableObjectSizeIsBytes() > 0) {
                if (z) {
                    str = str2;
                    this.mService.sendLogBroadcast(10, "Resuming uploading firmware...");
                    z2 = false;
                } else {
                    int availableObjectSizeIsBytes = this.mProgressInfo.getAvailableObjectSizeIsBytes();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Creating Data object (Op Code = 1, Type = 2, Size = ");
                    sb.append(availableObjectSizeIsBytes);
                    sb.append(") (");
                    int i11 = i + 1;
                    sb.append(i11);
                    boolean z3 = z;
                    sb.append("/");
                    sb.append(i5);
                    sb.append(str2);
                    logi(sb.toString());
                    writeCreateRequest(2, availableObjectSizeIsBytes);
                    DfuBaseService dfuBaseService = this.mService;
                    StringBuilder sb2 = new StringBuilder();
                    str = str2;
                    sb2.append("Data object (");
                    sb2.append(i11);
                    sb2.append("/");
                    sb2.append(i5);
                    sb2.append(") created");
                    dfuBaseService.sendLogBroadcast(10, sb2.toString());
                    long j = this.prepareObjectDelay;
                    if (j > 0 || i5 == 0) {
                        DfuBaseService dfuBaseService2 = this.mService;
                        if (j <= 0) {
                            j = 400;
                        }
                        dfuBaseService2.waitFor(j);
                    }
                    this.mService.sendLogBroadcast(10, "Uploading firmware...");
                    z2 = z3;
                }
                try {
                    logi("Uploading firmware...");
                    uploadFirmwareImage(this.mPacketCharacteristic);
                    logi("Sending Calculate Checksum command (Op Code = 3)");
                    ObjectChecksum checksum = readChecksum();
                    Locale locale2 = Locale.US;
                    logi(String.format(locale2, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(checksum.offset), Integer.valueOf(checksum.CRC32)));
                    boolean z4 = z2;
                    this.mService.sendLogBroadcast(10, String.format(locale2, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(checksum.offset), Integer.valueOf(checksum.CRC32)));
                    int bytesSent = this.mProgressInfo.getBytesSent() - checksum.offset;
                    if (bytesSent > 0) {
                        logw(bytesSent + " bytes were lost!");
                        this.mService.sendLogBroadcast(15, bytesSent + " bytes were lost");
                        try {
                            this.mFirmwareStream.reset();
                            this.mFirmwareStream.read(new byte[objectInfoSelectObject.maxSize - bytesSent]);
                            this.mProgressInfo.setBytesSent(checksum.offset);
                            int i12 = this.mPacketsBeforeNotification;
                            if (i12 == 0 || i12 > 1) {
                                this.mPacketsBeforeNotification = 1;
                                setPacketReceiptNotifications(1);
                                this.mService.sendLogBroadcast(10, "Packet Receipt Notif Req (Op Code = 2) sent (Value = 1)");
                            }
                        } catch (IOException e3) {
                            loge("Error while reading firmware stream", e3);
                            this.mService.terminateConnection(bluetoothGatt, 4100);
                            return;
                        } catch (Throwable th) {
                            loge("Progress lost. Bytes sent: " + this.mProgressInfo.getBytesSent(), th);
                            this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_PROGRESS_LOST);
                            return;
                        }
                    }
                    int crc32 = (int) (((ArchiveInputStream) this.mFirmwareStream).getCrc32() & UnsignedInts.INT_MASK);
                    if (crc32 != checksum.CRC32) {
                        String str3 = String.format(locale2, "CRC does not match! Expected %08X but found %08X.", Integer.valueOf(crc32), Integer.valueOf(checksum.CRC32));
                        if (i10 >= 3) {
                            loge(str3);
                            this.mService.sendLogBroadcast(20, str3);
                            this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_CRC_ERROR);
                            return;
                        }
                        i10++;
                        String str4 = str3 + String.format(locale2, " Retrying...(%d/%d)", Integer.valueOf(i10), 3);
                        logi(str4);
                        this.mService.sendLogBroadcast(15, str4);
                        try {
                            this.mFirmwareStream.reset();
                            this.mProgressInfo.setBytesSent(((ArchiveInputStream) this.mFirmwareStream).getBytesRead());
                        } catch (IOException e4) {
                            loge("Error while resetting the firmware stream", e4);
                            this.mService.terminateConnection(bluetoothGatt, 4100);
                            return;
                        }
                    } else if (bytesSent > 0) {
                        str2 = str;
                        z = true;
                    } else {
                        logi("Executing data object (Op Code = 4)");
                        writeExecute(this.mProgressInfo.isComplete());
                        this.mService.sendLogBroadcast(10, "Data object executed");
                        i++;
                        this.mFirmwareStream.mark(0);
                        i10 = 1;
                    }
                    z = z4;
                    str2 = str;
                } catch (DeviceDisconnectedException e5) {
                    loge("Disconnected while sending data");
                    throw e5;
                }
            }
        } else {
            logi("Executing data object (Op Code = 4)");
            writeExecute(true);
            this.mService.sendLogBroadcast(10, "Data object executed");
        }
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Transfer of ");
        sb3.append(this.mProgressInfo.getBytesSent() - objectInfoSelectObject.offset);
        sb3.append(" bytes has taken ");
        long j2 = jElapsedRealtime2 - jElapsedRealtime;
        sb3.append(j2);
        sb3.append(" ms");
        logi(sb3.toString());
        this.mService.sendLogBroadcast(10, "Upload completed in " + j2 + " ms");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void sendInitPacket(@androidx.annotation.NonNull android.bluetooth.BluetoothGatt r18, boolean r19) throws no.nordicsemi.android.dfu.internal.exception.UploadAbortedException, no.nordicsemi.android.dfu.internal.exception.RemoteDfuException, no.nordicsemi.android.dfu.internal.exception.UnknownResponseException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 607
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.SecureDfuImpl.sendInitPacket(android.bluetooth.BluetoothGatt, boolean):void");
    }

    private void setNumberOfPackets(@NonNull byte[] bArr, int i) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
    }

    private void setObjectSize(@NonNull byte[] bArr, int i) {
        bArr[2] = (byte) (i & 255);
        bArr[3] = (byte) ((i >> 8) & 255);
        bArr[4] = (byte) ((i >> 16) & 255);
        bArr[5] = (byte) ((i >> 24) & 255);
    }

    private void setPacketReceiptNotifications(int i) throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
        }
        logi("Sending the number of packets before notifications (Op Code = 2, Value = " + i + ")");
        byte[] bArr = OP_CODE_PACKET_RECEIPT_NOTIF_REQ;
        setNumberOfPackets(bArr, i);
        writeOpCode(this.mControlPointCharacteristic, bArr);
        byte[] notificationResponse = readNotificationResponse();
        int statusCode = getStatusCode(notificationResponse, 2);
        if (statusCode == 11) {
            throw new RemoteDfuExtendedErrorException("Sending the number of packets failed", notificationResponse[3]);
        }
        if (statusCode != 1) {
            throw new RemoteDfuException("Sending the number of packets failed", statusCode);
        }
    }

    private int unsignedBytesToInt(@NonNull byte[] bArr, int i) {
        return (bArr[i] & 255) + ((bArr[i + 1] & 255) << 8) + ((bArr[i + 2] & 255) << 16) + ((bArr[i + 3] & 255) << 24);
    }

    private void writeCreateRequest(int i, int i2) throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to create object: device disconnected");
        }
        byte[] bArr = i == 1 ? OP_CODE_CREATE_COMMAND : OP_CODE_CREATE_DATA;
        setObjectSize(bArr, i2);
        writeOpCode(this.mControlPointCharacteristic, bArr);
        byte[] notificationResponse = readNotificationResponse();
        int statusCode = getStatusCode(notificationResponse, 1);
        if (statusCode == 11) {
            throw new RemoteDfuExtendedErrorException("Creating Command object failed", notificationResponse[3]);
        }
        if (statusCode != 1) {
            throw new RemoteDfuException("Creating Command object failed", statusCode);
        }
    }

    private void writeExecute() throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
        }
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_EXECUTE);
        byte[] notificationResponse = readNotificationResponse();
        int statusCode = getStatusCode(notificationResponse, 4);
        if (statusCode == 11) {
            throw new RemoteDfuExtendedErrorException("Executing object failed", notificationResponse[3]);
        }
        if (statusCode != 1) {
            throw new RemoteDfuException("Executing object failed", statusCode);
        }
    }

    private void writeOpCode(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull byte[] bArr) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        writeOpCode(bluetoothGattCharacteristic, bArr, false);
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

    @Override // no.nordicsemi.android.dfu.BaseDfuImpl, no.nordicsemi.android.dfu.DfuService
    public boolean initialize(@NonNull Intent intent, @NonNull BluetoothGatt bluetoothGatt, int i, @NonNull InputStream inputStream, @Nullable InputStream inputStream2) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        if (inputStream2 != null) {
            return super.initialize(intent, bluetoothGatt, i, inputStream, inputStream2);
        }
        this.mService.sendLogBroadcast(20, "The Init packet is required by this version DFU Bootloader");
        this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_INIT_PACKET_REQUIRED);
        return false;
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

    @Override // no.nordicsemi.android.dfu.DfuService
    public void performDfu(@NonNull Intent intent) throws UploadAbortedException, NoSuchMethodException, RemoteDfuException, DfuException, DeviceDisconnectedException, IOException, SecurityException {
        logw("Secure DFU bootloader found");
        this.mProgressInfo.setProgress(-2);
        BluetoothGatt bluetoothGatt = this.mGatt;
        if (intent.hasExtra(DfuBaseService.EXTRA_MTU) && Build.VERSION.SDK_INT >= 21) {
            int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_MTU, 517);
            logi("Requesting MTU = " + intExtra);
            requestMtu(intExtra);
        }
        this.prepareObjectDelay = intent.getLongExtra(DfuBaseService.EXTRA_DATA_OBJECT_DELAY, 0L);
        try {
            try {
                enableCCCD(this.mControlPointCharacteristic, 1);
                this.mService.sendLogBroadcast(10, "Notifications enabled");
                boolean z = (intent.hasExtra(DfuBaseService.EXTRA_DISABLE_RESUME) && intent.getBooleanExtra(DfuBaseService.EXTRA_DISABLE_RESUME, false)) ? false : true;
                if (!z) {
                    logi("Resume feature disabled. Performing fresh DFU");
                }
                try {
                    sendInitPacket(bluetoothGatt, z);
                } catch (RemoteDfuException e) {
                    if (this.mProgressInfo.isLastPart()) {
                        throw e;
                    }
                    this.mRemoteErrorOccurred = false;
                    logw("Sending SD+BL failed. Trying to send App only");
                    this.mService.sendLogBroadcast(15, "Invalid system components. Trying to send application");
                    this.mFileType = 4;
                    ArchiveInputStream archiveInputStream = (ArchiveInputStream) this.mFirmwareStream;
                    archiveInputStream.setContentType(4);
                    byte[] applicationInit = archiveInputStream.getApplicationInit();
                    this.mInitPacketStream = new ByteArrayInputStream(applicationInit);
                    this.mInitPacketSizeInBytes = applicationInit.length;
                    int iApplicationImageSize = archiveInputStream.applicationImageSize();
                    this.mImageSizeInBytes = iApplicationImageSize;
                    this.mProgressInfo.init(iApplicationImageSize, 2, 2);
                    sendInitPacket(bluetoothGatt, false);
                }
                sendFirmware(bluetoothGatt);
                this.mProgressInfo.setProgress(-5);
                this.mService.waitUntilDisconnected();
                this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
                finalize(intent, false);
            } catch (UnknownResponseException e2) {
                loge(e2.getMessage());
                this.mService.sendLogBroadcast(20, e2.getMessage());
                this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_INVALID_RESPONSE);
            } catch (UploadAbortedException e3) {
                throw e3;
            }
        } catch (RemoteDfuException e4) {
            int errorNumber = e4.getErrorNumber() | 512;
            loge(e4.getMessage() + ": " + SecureDfuError.parse(errorNumber));
            this.mService.sendLogBroadcast(20, String.format(Locale.US, "Remote DFU error: %s", SecureDfuError.parse(errorNumber)));
            if (!(e4 instanceof RemoteDfuExtendedErrorException)) {
                this.mService.terminateConnection(bluetoothGatt, errorNumber | 8192);
                return;
            }
            RemoteDfuExtendedErrorException remoteDfuExtendedErrorException = (RemoteDfuExtendedErrorException) e4;
            int extendedErrorNumber = remoteDfuExtendedErrorException.getExtendedErrorNumber() | 1024;
            loge("Extended Error details: " + SecureDfuError.parseExtendedError(extendedErrorNumber));
            this.mService.sendLogBroadcast(20, "Details: " + SecureDfuError.parseExtendedError(extendedErrorNumber) + " (Code = " + remoteDfuExtendedErrorException.getExtendedErrorNumber() + ")");
            this.mService.terminateConnection(bluetoothGatt, extendedErrorNumber | 8192);
        }
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public BaseDfuImpl.BaseBluetoothGattCallback getGattCallback() {
        return this.mBluetoothCallback;
    }

    private void writeExecute(boolean z) throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        try {
            writeExecute();
        } catch (RemoteDfuException e) {
            if (z && e.getErrorNumber() == 5) {
                logw(e.getMessage() + ": " + SecureDfuError.parse(517));
                if (this.mFileType == 1) {
                    logw("Are you sure your new SoftDevice is API compatible with the updated one? If not, update the bootloader as well");
                }
                this.mService.sendLogBroadcast(15, String.format(Locale.US, "Remote DFU error: %s. SD busy? Retrying...", SecureDfuError.parse(517)));
                logi("SD busy? Retrying...");
                logi("Executing data object (Op Code = 4)");
                writeExecute();
                return;
            }
            throw e;
        }
    }
}
