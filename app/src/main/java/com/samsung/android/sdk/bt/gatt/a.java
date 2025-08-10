package com.samsung.android.sdk.bt.gatt;

import android.bluetooth.IBluetoothStateChangeCallback;
import android.content.Intent;

/* loaded from: classes3.dex */
public final class a extends IBluetoothStateChangeCallback.Stub {
    private /* synthetic */ BluetoothGatt a;

    public a(BluetoothGatt bluetoothGatt) {
        this.a = bluetoothGatt;
    }

    public final void onBluetoothStateChange(boolean z) {
        String str = "onBluetoothStateChange: up=" + z;
        if (z) {
            synchronized (this.a.j) {
                try {
                    if (this.a.d == null) {
                        this.a.a.bindService(new Intent(IBluetoothGatt.class.getName()), this.a.j, 0);
                    }
                } catch (Exception unused) {
                }
            }
            return;
        }
        synchronized (this.a.j) {
            try {
                this.a.d = null;
                this.a.a.unbindService(this.a.j);
            } catch (Exception unused2) {
            }
        }
    }
}
