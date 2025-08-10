package com.samsung.android.sdk.bt.gatt;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.samsung.android.sdk.bt.gatt.IBluetoothGatt;

/* loaded from: classes3.dex */
public final class e implements ServiceConnection {
    private /* synthetic */ BluetoothGattServer a;

    public e(BluetoothGattServer bluetoothGattServer) {
        this.a = bluetoothGattServer;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.a.d = IBluetoothGatt.Stub.asInterface(iBinder);
        if (this.a.b != null) {
            this.a.b.onServiceConnected(8, this.a);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.a.clearServices();
        this.a.d = null;
        if (this.a.b != null) {
            this.a.b.onServiceDisconnected(8);
        }
    }
}
