package com.samsung.android.sdk.bt.gatt;

import android.bluetooth.IBluetoothStateChangeCallback;
import android.content.Intent;

/* loaded from: classes3.dex */
public final class d extends IBluetoothStateChangeCallback.Stub {
    private /* synthetic */ BluetoothGattServer a;

    public d(BluetoothGattServer bluetoothGattServer) {
        this.a = bluetoothGattServer;
    }

    public final void onBluetoothStateChange(boolean z) {
        String str = "onBluetoothStateChange: up=" + z;
        if (z) {
            synchronized (this.a.i) {
                try {
                    if (this.a.d == null) {
                        this.a.a.bindService(new Intent(IBluetoothGatt.class.getName()), this.a.i, 0);
                    }
                } catch (Exception unused) {
                }
            }
            return;
        }
        synchronized (this.a.i) {
            try {
                this.a.d = null;
                this.a.a.unbindService(this.a.i);
            } catch (Exception unused2) {
            }
        }
    }
}
