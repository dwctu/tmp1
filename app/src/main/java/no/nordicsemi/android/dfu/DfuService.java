package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.InputStream;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* loaded from: classes5.dex */
public interface DfuService extends DfuCallback {
    boolean initialize(@NonNull Intent intent, @NonNull BluetoothGatt bluetoothGatt, int i, @NonNull InputStream inputStream, @Nullable InputStream inputStream2) throws UploadAbortedException, DfuException, DeviceDisconnectedException;

    boolean isClientCompatible(@NonNull Intent intent, @NonNull BluetoothGatt bluetoothGatt) throws UploadAbortedException, DfuException, DeviceDisconnectedException;

    void performDfu(@NonNull Intent intent) throws UploadAbortedException, DfuException, DeviceDisconnectedException;

    void release();
}
