package dc;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.xtremeprog.sdk.ble.BleService;
import dc.xb1;

/* compiled from: DxBtScan.java */
/* loaded from: classes3.dex */
public class sb1 {
    public tb1 a;
    public Handler b = new Handler(Looper.getMainLooper());
    public long c = 10000;
    public final BroadcastReceiver d = new a();
    public c e;

    /* compiled from: DxBtScan.java */
    public class a extends BroadcastReceiver {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(Intent intent) {
            Bundle extras = intent.getExtras();
            BluetoothDevice bluetoothDevice = (BluetoothDevice) extras.getParcelable(BleService.EXTRA_DEVICE);
            if (bluetoothDevice == null) {
                return;
            }
            int i = extras.getInt(BleService.EXTRA_RSSI, -1);
            byte[] byteArray = extras.getByteArray(BleService.EXTRA_SCAN_RECORD);
            xb1.a aVarC = xb1.c(bluetoothDevice.getAddress(), byteArray, bluetoothDevice.getName());
            if (sb1.this.e == null || !sb1.this.e.b(bluetoothDevice, byteArray, aVarC)) {
                return;
            }
            sb1.this.e.a(bluetoothDevice, i, byteArray, aVarC);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            String action = intent.getAction();
            if (BleService.BLE_NOT_SUPPORTED.equals(action)) {
                if (sb1.this.a.b) {
                    String str = tb1.i;
                }
                if (sb1.this.e != null) {
                    sb1.this.e.c();
                    return;
                }
                return;
            }
            if (BleService.BLE_DEVICE_FOUND.equals(action)) {
                vg3.b().a(new Runnable() { // from class: dc.nb1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b(intent);
                    }
                });
                return;
            }
            if (BleService.BLE_NO_BT_ADAPTER.equals(action)) {
                if (sb1.this.a.b) {
                    String str2 = tb1.i;
                }
                if (sb1.this.e != null) {
                    sb1.this.e.d();
                }
            }
        }
    }

    /* compiled from: DxBtScan.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = tb1.i + "12";
            tb1 tb1Var = sb1.this.a;
            if (tb1Var.g != null) {
                boolean z = tb1Var.b;
                sb1.this.a.g.stopScan();
            }
            if (sb1.this.e != null) {
                boolean z2 = sb1.this.a.b;
                sb1.this.e.e();
            }
        }
    }

    /* compiled from: DxBtScan.java */
    public interface c {
        void a(BluetoothDevice bluetoothDevice, int i, byte[] bArr, xb1.a aVar);

        boolean b(BluetoothDevice bluetoothDevice, byte[] bArr, xb1.a aVar);

        void c();

        void d();

        void e();
    }

    public sb1(tb1 tb1Var) {
        this.a = tb1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c() {
        this.a.g.resetBleParams();
    }

    public void d() {
        LocalBroadcastManager.getInstance(ve0.a()).registerReceiver(this.d, BleService.getIntentScanFilter());
    }

    public void e(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("scanDevice: ");
        sb.append(z ? "开启扫描" : "关闭扫描");
        sb.toString();
        if (this.a.g == null) {
            return;
        }
        if (!z) {
            this.b.removeCallbacksAndMessages(null);
            if (this.a.b) {
                String str = tb1.i;
            }
            this.a.g.stopScan();
            se0.b().execute(new Runnable() { // from class: dc.ob1
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.c();
                }
            });
            return;
        }
        this.b.removeCallbacksAndMessages(null);
        this.b.postDelayed(new b(), this.c);
        tb1 tb1Var = this.a;
        if (tb1Var.g != null) {
            if (tb1Var.b) {
                String str2 = tb1.i;
            }
            this.a.g.startScan();
        }
    }

    public void f(c cVar) {
        this.e = cVar;
    }
}
