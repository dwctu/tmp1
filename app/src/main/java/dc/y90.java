package dc;

import com.component.dxbluetooth.lib.bean.BleDeviceBean;
import com.component.dxbluetooth.lib.bean.BleResultBean;
import com.component.dxbluetooth.lib.bean.config.BleConnectConfigBean;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.vending.expansion.downloader.Constants;
import dc.q90;
import dc.wb0;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: ToyBtConnect.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u000f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0006\u0010\u0011\u001a\u00020\u000bJ\n\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u000e\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u001e\u001a\u00020\u000bH\u0002J\u0010\u0010\u001f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\b\u0010 \u001a\u00020\u000bH\u0002J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#H\u0002J$\u0010$\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/component/dxtoy/core/bluetooth/ToyBtConnect;", "Lcom/component/dxtoy/core/bluetooth/listenter/IToyBtConnect;", "()V", "checkConnectEnable", "", "lastCheckConnectTime", "", "canReconnectToy", "toy", "Lcom/component/dxtoy/core/toy/ToyInfo;", "checkConnect", "", "connect", "mac", "", "connectEnd", "disconnect", "disconnectCurrentConnecting", "findConnectToy", "initListener", "onBluetoothOff", "onConnectFail", "failResult", "Lcom/component/dxbluetooth/lib/bean/BleResultBean;", "onConnectSuccess", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", "data", "Lcom/component/dxbluetooth/lib/bean/BleDeviceBean;", "onNotifySuccess", "resetConnectState", "resetState", "scheduleConnect", "setBtState", "state", "Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$ScanOrConnectStatus;", "updateConnectState", "connectState", "Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$ToyConnectState;", "Companion", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class y90 {
    public boolean a = true;
    public long b;

    /* compiled from: ToyBtConnect.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[rb0.values().length];
            iArr[rb0.CONNECT.ordinal()] = 1;
            iArr[rb0.DEFAULT.ordinal()] = 2;
            a = iArr;
            int[] iArr2 = new int[sb0.values().length];
            iArr2[sb0.CONNECT_SUC.ordinal()] = 1;
            iArr2[sb0.NOT_CONNECT.ordinal()] = 2;
            b = iArr2;
        }
    }

    public y90() {
        u();
        g();
    }

    public static final void h(y90 this$0, String mac, int i, BleResultBean bleResultBean) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mac, "mac");
        de0.i("ble__onConnectStatusChanged " + mac + ' ' + i + ' ' + xd0.j(bleResultBean));
        if (i == lt.CONNECTED.getStatus() || i != lt.DISCONNECTED.getStatus()) {
            return;
        }
        this$0.p(mac, bleResultBean);
    }

    public static final void i(y90 this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        de0.i("ble__onBluetoothStateChanged " + z);
        if (z) {
            return;
        }
        this$0.o();
    }

    public static final void j(String str, int i) {
        de0.l("ble__onBondStateChanged " + str + ' ' + i);
    }

    public static final void v(y90 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        hb0 hb0Var = hb0.a;
        if ((!hb0Var.e().isEmpty()) && z90.a.f() && !hb0Var.h()) {
            this$0.b();
        }
    }

    public static /* synthetic */ void y(y90 y90Var, String str, sb0 sb0Var, BleResultBean bleResultBean, int i, Object obj) {
        if ((i & 4) != 0) {
            bleResultBean = null;
        }
        y90Var.x(str, sb0Var, bleResultBean);
    }

    public final boolean a(nb0 nb0Var) {
        if (nb0Var.getG() > 10) {
            return false;
        }
        if (nb0Var.getH() != 0) {
            return ((long) (nb0Var.getG() + 4)) * 1000 <= System.currentTimeMillis() - nb0Var.getH();
        }
        return true;
    }

    public final synchronized void b() {
        if (this.a) {
            this.b = System.currentTimeMillis();
            nb0 nb0VarF = f();
            if (nb0VarF != null) {
                de0.i("ble__checkConnect connectToy: " + nb0VarF.getMac() + " reconnectCount: " + nb0VarF.getG());
                this.a = false;
                nb0VarF.b0(nb0VarF.getG() + 1);
                nb0VarF.c0(System.currentTimeMillis());
                nb0VarF.T(sb0.CONNECTING);
                hb0.a.f().put(nb0VarF.getMac(), nb0VarF);
                wb0.a aVar = wb0.a;
                aVar.a(new i90(nb0VarF.getMac(), nb0VarF.getF(), null));
                z90.a.d().w();
                aVar.a(new h90(nb0VarF));
            }
        } else if (System.currentTimeMillis() - this.b > C.DEFAULT_SEEK_FORWARD_INCREMENT_MS) {
            Iterator<nb0> it = hb0.a.f().values().iterator();
            while (it.hasNext()) {
                p(it.next().getMac(), new BleResultBean(Constants.STATUS_LENGTH_REQUIRED, "checkConnect_timeout", null, 4, null));
            }
        }
    }

    public final void c(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        w(rb0.CONNECT);
        BleConnectConfigBean bleConnectConfigBean = new BleConnectConfigBean(0, 0, 0L, 0L, 15, null);
        bleConnectConfigBean.setConnectTimeout(10000L);
        bleConnectConfigBean.setConnectRetryCount(0);
        bleConnectConfigBean.setServiceDiscoverTimeout(5000L);
        bleConnectConfigBean.setServiceDiscoverRetryCount(0);
        ba0.a.b(mac, bleConnectConfigBean, da0.a.a(mac));
    }

    public final void d(String str) {
        t(str);
    }

    public void e(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        ba0.a.c(mac);
    }

    public final nb0 f() {
        nb0 nb0Var = null;
        for (nb0 toy : hb0.a.e().values()) {
            if (!toy.getIsVirtualToy()) {
                if (!toy.getIsSelect() && toy.getF() == sb0.CONNECT_SUC) {
                    e(toy.getMac());
                } else if (toy.getIsSelect() && toy.getF() == sb0.NOT_CONNECT) {
                    Intrinsics.checkNotNullExpressionValue(toy, "toy");
                    if (a(toy) && (nb0Var == null || toy.getI().getCode() > nb0Var.getI().getCode() || (toy.getI().getCode() == nb0Var.getI().getCode() && toy.getH() < nb0Var.getH()))) {
                        nb0Var = toy;
                    }
                }
            }
        }
        return nb0Var;
    }

    public final void g() {
        ba0 ba0Var = ba0.a;
        ba0Var.k(new rt() { // from class: dc.u90
            @Override // dc.rt
            public final void a(String str, int i, BleResultBean bleResultBean) {
                y90.h(this.a, str, i, bleResultBean);
            }
        });
        ba0Var.j(new wt() { // from class: dc.s90
            @Override // dc.wt
            public final void a(boolean z) {
                y90.i(this.a, z);
            }
        });
        ba0Var.h(new ut() { // from class: dc.v90
            @Override // dc.ut
            public final void b(String str, int i) {
                y90.j(str, i);
            }
        });
    }

    public final void o() {
        for (Map.Entry<String, nb0> entry : hb0.a.e().entrySet()) {
            String key = entry.getKey();
            entry.getValue();
            p(key, new BleResultBean(Constants.STATUS_PRECONDITION_FAILED, "bluetooth_off", null, 4, null));
            e(key);
        }
    }

    public final void p(@NotNull String mac, @Nullable BleResultBean bleResultBean) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        x(mac, sb0.NOT_CONNECT, bleResultBean);
    }

    public final void q(@NotNull mt code, @Nullable BleDeviceBean bleDeviceBean) {
        Intrinsics.checkNotNullParameter(code, "code");
        if (bleDeviceBean == null) {
            return;
        }
        ca0.a.a(code, bleDeviceBean);
        if (hb0.a.c().get(bleDeviceBean.getMac()) == null) {
            wb0.a.a(new l90(bleDeviceBean.getMac(), 3, null, null, null, 28, null));
            e(bleDeviceBean.getMac());
        }
    }

    public final void r(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        y(this, mac, sb0.CONNECT_SUC, null, 4, null);
    }

    public final void s() {
        this.a = true;
        w(rb0.DEFAULT);
        z90.a.d().l();
    }

    public final void t(@Nullable String str) {
        if (str != null) {
            hb0 hb0Var = hb0.a;
            nb0 nb0Var = hb0Var.f().get(str);
            if (nb0Var != null) {
                hb0Var.f().clear();
                if (nb0Var.getF() != sb0.CONNECT_SUC) {
                    nb0Var.T(sb0.NOT_CONNECT);
                }
                s();
            }
        }
    }

    public final void u() {
        q90.c.e(new q90.b() { // from class: dc.t90
            @Override // dc.q90.b
            public final void execute() {
                y90.v(this.a);
            }
        }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    public final void w(rb0 rb0Var) {
        int i = a.a[rb0Var.ordinal()];
        boolean z = true;
        if (i != 1 && (i != 2 || z90.a.e() != rb0.CONNECT)) {
            z = false;
        }
        if (z) {
            z90.a.g(rb0Var);
        }
    }

    public final void x(String str, sb0 sb0Var, BleResultBean bleResultBean) {
        de0.i("ble__updateConnectState " + str + ":  " + sb0Var + ' ' + bleResultBean);
        nb0 nb0Var = hb0.a.e().get(str);
        if (nb0Var != null) {
            if (a.b[sb0Var.ordinal()] == 2) {
                nb0Var.X(false);
                nb0Var.Y(pb0.NOT_INIT);
            }
            nb0Var.T(sb0Var);
            ib0.a.h(str, nb0Var);
            wb0.a.a(new i90(str, sb0Var, bleResultBean));
            d(str);
        }
    }
}
