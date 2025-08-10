package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGattCallback;

/* loaded from: classes5.dex */
public interface DfuCallback extends DfuController {

    public static class DfuGattCallback extends BluetoothGattCallback {
        public void onDisconnected() {
        }
    }

    DfuGattCallback getGattCallback();

    void onBondStateChanged(int i);
}
