package dc;

import android.bluetooth.BluetoothDevice;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.database.DatabaseError;
import com.wear.bean.Toy;
import com.wear.bean.event.NinjaLockTimeEvent;
import com.wear.dao.DaoUtils;
import com.wear.main.ninja.NinjaLockActivity;
import com.wear.main.toy.ToyDfuActivity;
import com.wear.main.toy.pin.ToyPinTipActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.xtremeprog.sdk.ble.BleRequest;
import dc.rb1;
import dc.sb1;
import dc.xb1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.EventBus;

/* compiled from: BtLinked.java */
/* loaded from: classes3.dex */
public class mc1 {
    public static Timer m = new Timer();
    public wb1 c;
    public qc1 d;
    public Handler h;
    public long i;
    public long j;
    public volatile int k;
    public volatile boolean l;
    public final Object a = new Object();
    public final ConcurrentHashMap<String, Toy> b = new ConcurrentHashMap<>();
    public int e = 0;
    public boolean f = true;
    public int g = 0;

    /* compiled from: BtLinked.java */
    public class a extends TimerTask {
        public final /* synthetic */ qc1 a;

        public a(qc1 qc1Var) {
            this.a = qc1Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            FragmentActivity fragmentActivity = MyApplication.K;
            boolean zI4 = fragmentActivity instanceof ToyDfuActivity ? ((ToyDfuActivity) fragmentActivity).I4() : false;
            if (pc1.a.o().size() > 0 && !zI4) {
                if (WearUtils.x == null || this.a.getA().g == null) {
                    return;
                }
                if (MyApplication.O || MyApplication.Z) {
                    mc1.this.q();
                }
            }
            if (MyApplication.K instanceof NinjaLockActivity) {
                EventBus.getDefault().post(new NinjaLockTimeEvent());
            }
        }
    }

    /* compiled from: BtLinked.java */
    public class b implements sb1.c {
        public b() {
        }

        @Override // dc.sb1.c
        public void a(BluetoothDevice bluetoothDevice, int i, byte[] bArr, xb1.a aVar) {
            String str;
            String strC;
            if (mc1.this.j() != 1) {
                return;
            }
            Toy toy = (Toy) mc1.this.b.get(bluetoothDevice.getAddress());
            if (bluetoothDevice.getAddress() != null && toy != null) {
                xe3.a("connectScan", "bltFoundDevice 扫描到相应玩具: " + bluetoothDevice.getName() + "  Address:" + bluetoothDevice.getAddress());
                mc1.this.d.b(bluetoothDevice.getAddress(), bluetoothDevice);
                toy.addConnectTryNumb();
                toy.setConnectType(1);
                mc1.this.x(false);
                rp1.j(bluetoothDevice.getAddress());
                if (toy.getDeviceName() == null || (bluetoothDevice.getName() != null && toy.getDeviceName().equals(bluetoothDevice.getName()))) {
                    toy.setDeviceName(bluetoothDevice.getName());
                }
                if (aVar != null) {
                    if (toy.getUuid() != null && !toy.getUuid().equals(aVar.c())) {
                        toy.setUuid(aVar.c());
                        DaoUtils.getToyDao().updateOrAdd(toy);
                    }
                    if (pp1.e(toy.getAddress(), toy.getUuid())) {
                        toy.setIsSelect(0);
                        DaoUtils.getToyDao().updateOrAdd(toy);
                        mc1.this.v(toy.getAddress(), BleRequest.RequestType.CONNECT_GATT, -995);
                        return;
                    }
                }
                mc1.this.f(bluetoothDevice.getAddress());
                return;
            }
            if (mc1.this.l()) {
                String name = bluetoothDevice.getName();
                String strA = "";
                if (aVar != null) {
                    if (!WearUtils.e1(aVar.b())) {
                        name = aVar.b();
                    }
                    strA = aVar.a();
                    strC = aVar.c();
                    str = name;
                } else {
                    str = name;
                    strC = "";
                }
                String address = bluetoothDevice.getAddress();
                if (pc1.a.z(address)) {
                    return;
                }
                String type = (aVar == null && DaoUtils.getToyTypeDao() != null && DaoUtils.getToyTypeDao().isExistToyType(address) && Toy.isOurType(DaoUtils.getToyTypeDao().findToyType(address).getType())) ? DaoUtils.getToyTypeDao().findToyType(address).getType() : strA;
                if (!WearUtils.e1(type)) {
                    mc1.this.d.c(address, type, false, str, i, strC);
                    return;
                }
                xe3.a("connectScan", "bltFoundDevice:" + bluetoothDevice.getName() + "  Address:" + bluetoothDevice.getAddress() + "uuid不符合规则 也没连接过，需要连接判断");
                mc1.this.x(false);
                rp1.x(address, str, Integer.valueOf(i), strC);
                mc1.this.c.b(new vb1(bluetoothDevice, i, type, str, strC));
                mc1.this.f(bluetoothDevice.getAddress());
            }
        }

        @Override // dc.sb1.c
        public boolean b(BluetoothDevice bluetoothDevice, byte[] bArr, xb1.a aVar) {
            String name = bluetoothDevice.getName();
            if (aVar != null) {
                return true;
            }
            return name != null && name.length() > 0 && name.toLowerCase().startsWith("lvs");
        }

        @Override // dc.sb1.c
        public void c() {
            String str = pc1.b;
            rp1.b();
        }

        @Override // dc.sb1.c
        public void d() {
            String str = pc1.b;
            rp1.c();
        }

        @Override // dc.sb1.c
        public void e() {
            mc1.this.e();
        }
    }

    /* compiled from: BtLinked.java */
    public class c implements rb1.b {
        public c() {
        }

        @Override // dc.rb1.b
        public void a(String str, int i) {
            mc1.this.d.s(str, -1, i);
            mc1.this.d.o(str);
        }

        @Override // dc.rb1.b
        public void b(String str) {
            BluetoothDevice bluetoothDeviceJ = mc1.this.d.j(str);
            if (bluetoothDeviceJ != null) {
                mc1.this.d.a(str, bluetoothDeviceJ);
                vi2.a.e(str, true);
            }
        }
    }

    /* compiled from: BtLinked.java */
    public class d implements rb1.c {
        public d() {
        }

        @Override // dc.rb1.c
        public void a(String str) {
            mc1.this.u(str, DatabaseError.UNKNOWN_ERROR);
        }

        @Override // dc.rb1.c
        public void b(String str) {
            mc1 mc1Var = mc1.this;
            mc1Var.e = 0;
            final qb1 qb1VarE = mc1Var.d.getA().e(str);
            if (qb1VarE != null) {
                mc1.this.d.getA().a.postDelayed(new Runnable() { // from class: dc.bc1
                    @Override // java.lang.Runnable
                    public final void run() {
                        qb1VarE.g("DeviceType;");
                    }
                }, 500L);
            }
        }

        @Override // dc.rb1.c
        public boolean c(final qb1 qb1Var) {
            if (qb1Var.d()) {
                return true;
            }
            if (!qb1Var.c()) {
                return false;
            }
            if (tb1.d().b) {
                String str = tb1.i;
                String str2 = "filterService->requestNotification.ON - > " + qb1Var.a();
            }
            Handler handler = mc1.this.d.getA().a;
            Runnable runnable = new Runnable() { // from class: dc.ac1
                @Override // java.lang.Runnable
                public final void run() {
                    qb1Var.f();
                }
            };
            mc1 mc1Var = mc1.this;
            mc1Var.e = mc1Var.e + 1;
            handler.postDelayed(runnable, r2 * 50);
            return false;
        }
    }

    /* compiled from: BtLinked.java */
    public class e implements Runnable {
        public final /* synthetic */ String a;

        public e(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int iN;
            if (WearUtils.x != null) {
                xe3.a("reconnectOneLoopFlag", "mHandler== == time = " + be3.n());
                iN = WearUtils.x.G().y(WearUtils.x, false) ? mc1.this.d.getA().n(this.a) : -995;
            } else {
                iN = -994;
            }
            if (iN != 1) {
                mc1.this.u(this.a, iN);
            }
        }
    }

    public mc1(qc1 qc1Var) {
        new ArrayList();
        this.k = 0;
        this.l = false;
        this.d = qc1Var;
        this.h = new Handler(Looper.getMainLooper());
        this.c = new wb1();
        m.schedule(new a(qc1Var), 1000L, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n() {
        if (l()) {
            x(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p() {
        if (Build.VERSION.SDK_INT < 31) {
            x(true);
            return;
        }
        if (WearUtils.x.getPackageManager().checkPermission("android.permission.BLUETOOTH_SCAN", WearUtils.x.getPackageName()) == 0) {
            x(true);
        }
    }

    public final void e() {
        xe3.a("connectScan", "finishScanAction 停止扫描时未连接玩具数量: " + this.b.size());
        y(0);
        this.b.clear();
        this.f = true;
        this.h.postDelayed(new Runnable() { // from class: dc.cc1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.n();
            }
        }, 500L);
    }

    public void f(String str) {
        Toy toy = this.b.get(str);
        if (toy != null) {
            toy.setConnectType(2);
            xe3.a("connectScan", "foundToyRequestConnect : 前往连接玩具 address=" + str);
            t(str);
        }
        if (this.c.e(str)) {
            this.c.a(str);
            xe3.a("connectScan", "foundToyRequestConnect scanDevices: 前往连接扫描玩具玩具 address=" + str);
            t(str);
        }
    }

    public final void g() {
        this.d.getA().r(new c());
        this.d.getA().t(new d());
        this.d.getA().l();
    }

    public void h() {
        i();
        g();
    }

    public final void i() {
        this.d.getA().s(new b());
        this.d.getA().m();
    }

    public int j() {
        return this.k;
    }

    public boolean k(String str) {
        wb1 wb1Var = this.c;
        if (wb1Var != null) {
            return wb1Var.d(str);
        }
        return false;
    }

    public boolean l() {
        return this.l;
    }

    public final void q() {
        boolean z;
        boolean z2;
        ToyPinTipActivity toyPinTipActivity;
        Toy toyU4;
        if (!this.f) {
            if (System.currentTimeMillis() - this.i > SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US) {
                xe3.a("reconnectOneLoopFlag", " 超过20秒啦== time = " + be3.n());
                this.f = true;
                this.b.clear();
                return;
            }
            return;
        }
        this.i = System.currentTimeMillis();
        this.b.clear();
        ArrayList<Toy> arrayListO = pc1.a.o();
        int i = this.g + 1;
        this.g = i;
        if (i % 5 == 0) {
            this.g = 0;
            z = true;
        } else {
            z = false;
        }
        try {
            synchronized (this.a) {
                FragmentActivity fragmentActivity = MyApplication.K;
                if (!(fragmentActivity instanceof ToyPinTipActivity) || (toyU4 = (toyPinTipActivity = (ToyPinTipActivity) fragmentActivity).u4()) == null || toyU4.isConnected() || !toyPinTipActivity.v4()) {
                    z2 = false;
                } else {
                    if (toyU4.getConnectScanTime() != 0) {
                        long time = be3.I().getTime() - toyU4.getConnectScanTime();
                        xe3.a("connectScan", "reconnectAndQueryBatter: 玩具" + toyU4.getAddress() + "距离上次断连扫描时间：" + time + "毫秒  重试次数:" + toyU4.getConnectTryNumb());
                        if (toyU4.getConnectTryNumb() * 1000 < time) {
                            toyU4.addConnectTryNumb();
                            toyU4.setConnectType(2);
                            toyU4.setConnectScanTime(be3.I().getTime());
                            toyU4.getName();
                            this.b.put(toyU4.getAddress(), toyU4);
                        }
                    } else {
                        toyU4.addConnectTryNumb();
                        toyU4.setConnectType(2);
                        toyU4.setConnectScanTime(be3.I().getTime());
                        toyU4.getName();
                        this.b.put(toyU4.getAddress(), toyU4);
                    }
                    z2 = true;
                }
                if (!z2) {
                    Iterator<Toy> it = arrayListO.iterator();
                    while (it.hasNext()) {
                        Toy next = it.next();
                        if (next.isSelect()) {
                            if (this.d.l(next.getAddress())) {
                                if (z) {
                                    next.setCanRssi(true);
                                    if (!next.isRealDeviceType()) {
                                        lr1.c(next.getAddress());
                                    }
                                    dq1.a(next.getAddress());
                                }
                                pc1.a.readRssi(next.getAddress());
                                next.setConnectType(-1);
                            } else if (next.getConnectTryNumb() <= 15 && next.getConnectType() != 3) {
                                next.setConnectType(0);
                                if (next.getConnectScanTime() != 0) {
                                    long time2 = be3.I().getTime() - next.getConnectScanTime();
                                    xe3.a("connectScan", "reconnectAndQueryBatter: 玩具" + next.getAddress() + "距离上次断连扫描时间：" + time2 + "毫秒  重试次数:" + next.getConnectTryNumb());
                                    if (next.getConnectTryNumb() * 1000 > time2) {
                                    }
                                }
                                next.addConnectTryNumb();
                                next.setConnectType(2);
                                next.setConnectScanTime(be3.I().getTime());
                                next.getName();
                                this.b.put(next.getAddress(), next);
                                if (next.getReconnectOvertime()) {
                                    EventBus.getDefault().post(new zj2());
                                }
                            }
                        } else if (this.d.l(next.getAddress())) {
                            this.d.d(next.getAddress());
                        }
                    }
                }
            }
            if (this.b.size() <= 0) {
                this.f = true;
            } else {
                this.f = false;
                this.h.post(new Runnable() { // from class: dc.dc1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.p();
                    }
                });
            }
        } catch (Exception e2) {
            FirebaseCrashlytics.getInstance().recordException(e2);
            this.f = true;
        }
    }

    public void r(String str) {
        wb1 wb1Var = this.c;
        if (wb1Var != null) {
            wb1Var.f(str);
        }
    }

    public void s(String str) {
        if (this.b.get(str) != null) {
            this.b.remove(str);
            if (this.b.size() <= 0) {
                this.f = true;
            }
        }
    }

    public void t(String str) {
        se0.f(new e(str));
    }

    public void u(String str, int i) {
        v(str, BleRequest.RequestType.CONNECT_GATT, i);
    }

    public void v(String str, BleRequest.RequestType requestType, int i) {
        try {
            Toy toy = this.b.get(str);
            if (toy == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("requestConnectActionAndroidQ :");
            sb.append(this.d.l(str) ? "连接成功" : "连接失败");
            sb.append("   type=");
            sb.append(requestType);
            sb.append(" ordinal=");
            sb.append(i);
            xe3.a("connectScan", sb.toString());
            if (requestType == BleRequest.RequestType.CONNECT_GATT || requestType == BleRequest.RequestType.CHARACTERISTIC_NOTIFICATION || requestType == BleRequest.RequestType.DISCOVER_SERVICE) {
                if (this.d.l(str)) {
                    toy.setConnectType(-1);
                } else if (i == -999) {
                    toy.setConnectType(3);
                } else {
                    toy.setConnectType(0);
                }
                this.b.clear();
                this.f = true;
                y(0);
                xe3.a("connectScan", "requestConnectResult : 本次连接结束");
                if (l()) {
                    x(true);
                }
            }
        } catch (Exception e2) {
            this.f = true;
            y(0);
            if (l()) {
                x(true);
            }
            FirebaseCrashlytics.getInstance().recordException(e2);
            String str2 = "requestConnectResult 异常: " + e2.getLocalizedMessage();
        }
    }

    public void w(boolean z) {
        if (Build.VERSION.SDK_INT >= 31) {
            if (!(WearUtils.x.getPackageManager().checkPermission("android.permission.BLUETOOTH_SCAN", WearUtils.x.getPackageName()) == 0)) {
                return;
            }
        }
        if (!z) {
            z(false);
            return;
        }
        z(true);
        if (j() != 0) {
            if (System.currentTimeMillis() - this.j <= 30000) {
                return;
            } else {
                y(0);
            }
        }
        this.j = System.currentTimeMillis();
        y(1);
        this.d.getA().p(true);
    }

    public final void x(boolean z) {
        if (!z) {
            y(2);
        } else if (j() != 0) {
            return;
        } else {
            y(1);
        }
        String str = "scanDeviceChange: btWork.getScanAction = " + j();
        this.j = System.currentTimeMillis();
        this.d.getA().p(z);
    }

    public void y(int i) {
        this.k = i;
    }

    public void z(boolean z) {
        this.l = z;
    }
}
