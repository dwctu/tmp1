package dc;

import android.bluetooth.BluetoothDevice;
import no.nordicsemi.android.support.v18.scanner.ScanResult;

/* compiled from: ExtendedBluetoothDevice.java */
/* loaded from: classes3.dex */
public class yi2 {
    public final BluetoothDevice a;

    public yi2(ScanResult scanResult) {
        this.a = scanResult.getDevice();
        if (scanResult.getScanRecord() != null) {
            scanResult.getScanRecord().getDeviceName();
        }
        scanResult.getRssi();
    }
}
