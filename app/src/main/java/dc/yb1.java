package dc;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.google.android.exoplayer2.ExoPlayer;
import com.wear.util.WearUtils;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.greenrobot.eventbus.EventBus;

/* compiled from: BtOTAUtils.java */
/* loaded from: classes3.dex */
public class yb1 {
    public static boolean A = false;
    public static boolean B = false;
    public BluetoothDevice a;
    public BluetoothGatt b;
    public BluetoothGattCharacteristic c;
    public Runnable l;
    public Disposable m;
    public Handler n;
    public byte[] t;
    public k z;
    public UUID d = UUID.fromString("1d14d6ee-fd63-4fa1-bfa4-8f47b42119f0");
    public UUID e = UUID.fromString("f7bf3564-fb6d-4e53-88a4-5e37e0326063");
    public UUID f = UUID.fromString("984227f3-34fc-4045-a5d0-2c581f81a153");
    public String g = "";
    public int h = 247;
    public boolean i = true;
    public int j = 25;
    public int k = 0;
    public Runnable o = new a();
    public Runnable p = new b();
    public Runnable q = new c();
    public Runnable r = new d();
    public BluetoothGattCallback s = new g();
    public int u = 0;
    public int v = 0;
    public int w = 0;
    public int x = 0;
    public int y = 0;

    /* compiled from: BtOTAUtils.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            yb1.this.M(0);
        }
    }

    /* compiled from: BtOTAUtils.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            yb1.this.M(3);
        }
    }

    /* compiled from: BtOTAUtils.java */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            yb1.this.C("OTAUPLOAD");
        }
    }

    /* compiled from: BtOTAUtils.java */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            yb1.this.D();
        }
    }

    /* compiled from: BtOTAUtils.java */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            yb1.this.b.discoverServices();
        }
    }

    /* compiled from: BtOTAUtils.java */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (yb1.this.k == 1 || yb1.this.z == null) {
                return;
            }
            yb1.this.z.A1(135, 3, "STATE_DISCONNECTED");
        }
    }

    /* compiled from: BtOTAUtils.java */
    public class g extends BluetoothGattCallback {

        /* compiled from: BtOTAUtils.java */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                yb1 yb1Var = yb1.this;
                BluetoothGatt bluetoothGatt = yb1Var.b;
                if (bluetoothGatt == null || Build.VERSION.SDK_INT < 21) {
                    return;
                }
                bluetoothGatt.requestMtu(yb1Var.h);
                ye3.d("Z0004", "requestMtu: MTU = " + yb1.this.h);
            }
        }

        public g() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
            yb1 yb1Var = yb1.this;
            if (yb1Var.b.getService(yb1Var.d) != null) {
                yb1 yb1Var2 = yb1.this;
                if (bluetoothGattCharacteristic == yb1Var2.b.getService(yb1Var2.d).getCharacteristic(yb1.this.e)) {
                    byte[] value = bluetoothGattCharacteristic.getValue();
                    if (value[2] == 5 || value[2] == 4 || value[2] == 0) {
                        return;
                    }
                    byte b = value[2];
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) throws IOException {
            super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
            yb1 yb1Var = yb1.this;
            if (yb1Var.b.getService(yb1Var.d) != null) {
                if (i != 0) {
                    String str = "onCharacteristicWrite fail: status = " + i;
                    ye3.d("Z0008", "onCharacteristicWrite fail: status = " + i);
                    return;
                }
                yb1 yb1Var2 = yb1.this;
                if (bluetoothGattCharacteristic == yb1Var2.b.getService(yb1Var2.d).getCharacteristic(yb1.this.e)) {
                    byte[] value = bluetoothGattCharacteristic.getValue();
                    if (value[0] == 0 && yb1.this.k == 0) {
                        yb1.this.k = 1;
                        yb1.this.K();
                        yb1.this.n.removeCallbacks(yb1.this.q);
                        yb1.this.n.postDelayed(yb1.this.q, 500L);
                        if (yb1.this.z != null) {
                            yb1.this.z.V3();
                        }
                    } else if (value[0] == 3) {
                        yb1.this.k = 3;
                        yb1.this.C("DISCONNECTION");
                    }
                }
                if (bluetoothGattCharacteristic.getUuid().equals(yb1.this.f) && yb1.this.i) {
                    yb1 yb1Var3 = yb1.this;
                    yb1.h(yb1Var3, yb1Var3.x);
                    if (yb1.this.w <= yb1.this.y - 1) {
                        yb1.this.H();
                    } else if (yb1.this.w > yb1.this.y - 1) {
                        yb1.this.C("OTAEND");
                        if (yb1.this.z != null) {
                            yb1.this.z.C3();
                        }
                    }
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onConnectionStateChange(bluetoothGatt, i, i2);
            String str = "onConnectionStateChange status: " + i + ", newState:" + i2;
            ye3.d("Z0002", "onConnectionStateChange status: " + i + ", newState:" + i2);
            yb1 yb1Var = yb1.this;
            yb1Var.b = bluetoothGatt;
            if (i2 == 2) {
                if (bluetoothGatt.getServices().isEmpty()) {
                    yb1.this.I();
                } else if (yb1.this.z != null) {
                    yb1.this.z.d2();
                }
            } else if (i2 == 0 && yb1Var.k != 3 && yb1.this.z != null) {
                yb1.this.z.L1();
                yb1.this.z.A1(CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA, 3, "STATE_DISCONNECTED");
            }
            yb1.this.n.postDelayed(new a(), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onMtuChanged(bluetoothGatt, i, i2);
            yb1.this.G(bluetoothGatt, i, i2);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            super.onServicesDiscovered(bluetoothGatt, i);
            ye3.d("Z0003", "onServicesDiscovered: status = " + i);
        }
    }

    /* compiled from: BtOTAUtils.java */
    public class h implements Consumer<Long> {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ BluetoothGatt c;

        public h(int i, int i2, BluetoothGatt bluetoothGatt) {
            this.a = i;
            this.b = i2;
            this.c = bluetoothGatt;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Long l) throws Exception {
            yb1.this.h = this.a;
            ye3.d("Z0005", "onMtuChanged: MTU = " + yb1.this.h + ", status = " + this.b + ", gatt.getServices = " + this.c.getServices().isEmpty());
            if (this.b == 0 && !this.c.getServices().isEmpty()) {
                yb1.this.C("OTABEGIN");
            } else if (yb1.this.z != null) {
                yb1.this.z.A1(0, 0, "services empty");
            }
            yb1.this.m.dispose();
        }
    }

    /* compiled from: BtOTAUtils.java */
    public class i implements Runnable {
        public final /* synthetic */ byte[] a;

        public i(byte[] bArr) {
            this.a = bArr;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            try {
                byte[] bArr = new byte[yb1.this.h - 3];
                int length = this.a.length;
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    bArr[i] = this.a[i2];
                    i++;
                    if (i >= yb1.this.h - 3 || i2 >= length - 1) {
                        System.nanoTime();
                        yb1 yb1Var = yb1.this;
                        BluetoothGattCharacteristic characteristic = yb1Var.b.getService(yb1Var.d).getCharacteristic(yb1.this.f);
                        characteristic.setWriteType(1);
                        if (i < yb1.this.h - 3) {
                            byte[] bArr2 = new byte[i];
                            System.arraycopy(bArr, 0, bArr2, 0, i);
                            characteristic.setValue(bArr2);
                        } else {
                            characteristic.setValue(bArr);
                            i = 0;
                        }
                        if (yb1.this.b.writeCharacteristic(characteristic)) {
                            Thread.sleep(yb1.this.j);
                        } else {
                            do {
                                Thread.sleep(yb1.this.j);
                            } while (!yb1.this.b.writeCharacteristic(characteristic));
                        }
                        yb1.this.u = (i2 * 100) / length;
                        if (yb1.this.u > yb1.this.v && yb1.this.z != null) {
                            yb1 yb1Var2 = yb1.this;
                            yb1Var2.v = yb1Var2.u;
                            EventBus.getDefault().post(new zb1(1, yb1.this.v));
                        }
                    }
                }
                yb1.this.C("OTAEND");
                if (yb1.this.z != null) {
                    yb1.this.z.C3();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: BtOTAUtils.java */
    public static class j {
        public static yb1 a = new yb1();
    }

    /* compiled from: BtOTAUtils.java */
    public interface k {
        void A1(int i, int i2, String str);

        void C3();

        void J1(int i);

        void L1();

        void V3();

        void d2();
    }

    public static yb1 E() {
        return j.a;
    }

    public static /* synthetic */ int h(yb1 yb1Var, int i2) {
        int i3 = yb1Var.w + i2;
        yb1Var.w = i3;
        return i3;
    }

    public final void C(String str) throws IOException {
        ye3.d("Z0006", "dfuMode: step = " + str);
        str.hashCode();
        switch (str) {
            case "OTAEND":
                this.n.postDelayed(this.p, 500L);
                break;
            case "DISCONNECTION":
                this.n.postDelayed(this.r, 200L);
                break;
            case "OTAUPLOAD":
                L();
                break;
            case "OTABEGIN":
                this.n.postDelayed(this.o, 200L);
                break;
            case "INIT":
                C("OTABEGIN");
                break;
        }
    }

    public final void D() {
        BluetoothGatt bluetoothGatt = this.b;
        if (bluetoothGatt == null || bluetoothGatt.getDevice() == null) {
            return;
        }
        this.b.disconnect();
        this.b.close();
        WearUtils.x.G().disconnect(this.a.getAddress());
    }

    public void F(Context context, BluetoothDevice bluetoothDevice, String str, k kVar) {
        this.g = str;
        this.z = kVar;
        this.a = bluetoothDevice;
        this.n = new Handler();
        if (A) {
            this.g = WearUtils.T("").getAbsoluteFile().getAbsolutePath() + "/C12_v161_OTA.gbl";
        }
        if (!new File(this.g).exists()) {
            if (kVar != null) {
                kVar.A1(-1, 0, "FileNotFound");
                return;
            }
            return;
        }
        this.k = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("bluetoothDevice:");
        sb.append(bluetoothDevice.getAddress());
        sb.append(", Build.VERSION.SDK_INT:");
        int i2 = Build.VERSION.SDK_INT;
        sb.append(i2);
        ye3.d("Z0001", sb.toString());
        if (i2 >= 23) {
            this.b = this.a.connectGatt(context, false, this.s, 2);
        } else {
            this.b = this.a.connectGatt(context, false, this.s);
        }
    }

    public final void G(BluetoothGatt bluetoothGatt, int i2, int i3) {
        Disposable disposable = this.m;
        if (disposable != null && !disposable.isDisposed()) {
            this.m.dispose();
        }
        this.m = Observable.timer(1000L, TimeUnit.MILLISECONDS).subscribe(new h(i2, i3, bluetoothGatt));
    }

    public final void H() {
        byte[] bArr;
        int i2;
        int i3 = 0;
        if (this.w == 0) {
            int i4 = 0;
            do {
                i2 = (this.h - 3) - i4;
                this.x = i2;
                i4++;
            } while (i2 % 4 != 0);
        }
        int i5 = this.w;
        int i6 = this.x;
        int i7 = i5 + i6;
        int i8 = this.y;
        if (i7 > i8 - 1) {
            int i9 = i8 - i5;
            int i10 = 0;
            do {
                i9 += i10;
                i10++;
            } while (i9 % 4 != 0);
            bArr = new byte[i9];
            for (int i11 = this.w; i11 < this.w + i9; i11++) {
                if (this.y - 1 < i11) {
                    bArr[i3] = -1;
                } else {
                    bArr[i3] = this.t[i11];
                }
                i3++;
            }
        } else {
            byte[] bArr2 = new byte[i6];
            while (i5 < this.w + this.x) {
                bArr2[i3] = this.t[i5];
                i3++;
                i5++;
            }
            bArr = bArr2;
        }
        BluetoothGattCharacteristic characteristic = this.b.getService(this.d).getCharacteristic(this.f);
        characteristic.setWriteType(2);
        characteristic.setValue(bArr);
        this.b.writeCharacteristic(characteristic);
        int i12 = (this.w * 100) / this.y;
        this.u = i12;
        k kVar = this.z;
        if (kVar == null || i12 <= this.v) {
            return;
        }
        this.v = i12;
        kVar.J1(i12);
    }

    public final void I() {
        this.n.postDelayed(new e(), 1000L);
        J();
    }

    public final void J() {
        K();
        if (this.n == null) {
            this.n = new Handler();
        }
        if (this.l == null) {
            this.l = new f();
        }
        this.n.postDelayed(this.l, 60000L);
    }

    public final void K() {
        Runnable runnable;
        Handler handler = this.n;
        if (handler == null || (runnable = this.l) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    public final void L() throws IOException {
        if (this.b.getService(this.d) != null) {
            BluetoothGattCharacteristic characteristic = this.b.getService(this.d).getCharacteristic(this.e);
            this.c = characteristic;
            if (characteristic != null) {
                characteristic.setWriteType(1);
                try {
                    FileInputStream fileInputStream = new FileInputStream(new File(this.g));
                    int iAvailable = fileInputStream.available();
                    byte[] bArr = new byte[iAvailable];
                    fileInputStream.read(bArr);
                    fileInputStream.close();
                    this.k = 2;
                    if (this.i) {
                        this.t = new byte[iAvailable];
                        this.t = bArr;
                        this.y = iAvailable;
                        H();
                    } else {
                        N(bArr);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    k kVar = this.z;
                    if (kVar != null) {
                        kVar.A1(-1, 0, "FileNotFound");
                    }
                }
            }
        }
    }

    public final boolean M(int i2) {
        if (this.b.getService(this.d) != null) {
            this.b.getService(this.d);
            BluetoothGattCharacteristic characteristic = this.b.getService(this.d).getCharacteristic(this.e);
            this.c = characteristic;
            if (characteristic != null) {
                characteristic.setWriteType(2);
                this.c.setValue(new byte[]{(byte) i2});
                boolean zWriteCharacteristic = this.b.writeCharacteristic(this.c);
                ye3.d("Z0007", "writeOtaControl:ctrl=" + i2 + ", isSuc=" + zWriteCharacteristic);
                return zWriteCharacteristic;
            }
        }
        return false;
    }

    public final void N(byte[] bArr) {
        Executors.newSingleThreadExecutor().execute(new Thread(new i(bArr)));
    }
}
