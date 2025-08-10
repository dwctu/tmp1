package com.samsung.android.sdk.bt.gatt;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.samsung.android.sdk.bt.gatt.IBluetoothGatt;

/* loaded from: classes3.dex */
public final class b implements ServiceConnection {
    private /* synthetic */ BluetoothGatt a;

    public b(BluetoothGatt bluetoothGatt) {
        this.a = bluetoothGatt;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.a.d = IBluetoothGatt.Stub.asInterface(iBinder);
        if (this.a.b != null) {
            this.a.b.onServiceConnected(7, this.a);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.a.d = null;
        if (this.a.b != null) {
            this.a.b.onServiceDisconnected(7);
        }
    }
}
