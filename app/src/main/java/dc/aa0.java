package dc;

import androidx.core.app.NotificationCompat;
import com.component.dxbluetooth.lib.bean.BleSearchDeviceBean;
import com.component.dxbluetooth.lib.bean.config.BleSearchConfigBean;
import dc.ea0;
import dc.ha0;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: ToyBtScan.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 32\u00020\u0001:\u00013B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J.\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012J\b\u0010\u0018\u001a\u00020\u0004H\u0002J,\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J0\u0010\u001f\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0004J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020 H\u0002J\u0006\u0010&\u001a\u00020\u0010J\u0010\u0010'\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u001a\u0010(\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\"\u0010)\u001a\u00020\u00102\u0006\u0010%\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0018\u0010*\u001a\u00020\u00102\u0006\u0010%\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010,\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020/H\u0002J\u0006\u00100\u001a\u00020\u0010J\u0006\u00101\u001a\u00020\u0010J0\u00102\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u00064"}, d2 = {"Lcom/component/dxtoy/core/bluetooth/ToyBtScan;", "", "()V", "isDoScan", "", "isScanAllDeviceEvent", "()Z", "setScanAllDeviceEvent", "(Z)V", "searchResponse", "Lcom/component/dxbluetooth/lib/response/BleSearchResponse;", "getSearchResponse", "()Lcom/component/dxbluetooth/lib/response/BleSearchResponse;", "searchResponse$delegate", "Lkotlin/Lazy;", "addSearchToy", "", "mac", "", "deviceType", "deviceName", "rssi", "", "uuid", "checkScanEnable", "countOnScanData", "Lkotlin/Triple;", "data", "Lcom/component/dxbluetooth/lib/bean/BleSearchDeviceBean;", "uuidDevice", "Lcom/component/dxtoy/core/bluetooth/utils/UuidDeviceUtils$Device;", "createToy", "Lcom/component/dxtoy/core/toy/ToyInfo;", "deviceScan", "isStart", "isEnableUnknownConnect", "isNotToyConfigType", "toy", "maybeRestartScan", "onScanDeviceFound", "onScanToNewToy", "onScanToRequestConnect", "saveAndEvent", "scanDeviceFound", "sendScanAllDeviceEvent", "setBtState", "state", "Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$ScanOrConnectStatus;", "startScan", "stopScan", "unknownDeviceHandle", "Companion", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class aa0 {
    public boolean a;
    public boolean b;

    @NotNull
    public final Lazy c = LazyKt__LazyJVMKt.lazy(new b());

    /* compiled from: ToyBtScan.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[rb0.values().length];
            iArr[rb0.SCAN.ordinal()] = 1;
            iArr[rb0.DEFAULT.ordinal()] = 2;
            a = iArr;
        }
    }

    /* compiled from: ToyBtScan.kt */
    @Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/component/dxtoy/core/bluetooth/ToyBtScan$searchResponse$2$1", "invoke", "()Lcom/component/dxtoy/core/bluetooth/ToyBtScan$searchResponse$2$1;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<a> {

        /* compiled from: ToyBtScan.kt */
        @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"com/component/dxtoy/core/bluetooth/ToyBtScan$searchResponse$2$1", "Lcom/component/dxbluetooth/lib/response/BleSearchResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "Lcom/component/dxbluetooth/lib/bean/BleSearchDeviceBean;", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a implements ew {
            public final /* synthetic */ aa0 a;

            /* compiled from: ToyBtScan.kt */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* renamed from: dc.aa0$b$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0162a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[mt.values().length];
                    iArr[mt.SEARCH_START.ordinal()] = 1;
                    iArr[mt.SEARCH_DEVICE_FOUND.ordinal()] = 2;
                    iArr[mt.SEARCH_STOP.ordinal()] = 3;
                    iArr[mt.SEARCH_CANCEL.ordinal()] = 4;
                    iArr[mt.SEARCHING.ordinal()] = 5;
                    a = iArr;
                }
            }

            public a(aa0 aa0Var) {
                this.a = aa0Var;
            }

            @Override // dc.qt
            public void b(@NotNull mt code, @Nullable String str) {
                Intrinsics.checkNotNullParameter(code, "code");
                de0.M("onSearchFailed - " + code + ", " + str);
                this.a.u(rb0.DEFAULT);
                wb0.a.a(new o90(code, str));
            }

            @Override // dc.qt
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(@NotNull mt code, @Nullable BleSearchDeviceBean bleSearchDeviceBean) {
                Intrinsics.checkNotNullParameter(code, "code");
                int i = C0162a.a[code.ordinal()];
                if (i == 1) {
                    this.a.u(rb0.SCAN);
                    de0.M("onSearchStarted");
                    return;
                }
                if (i == 2) {
                    this.a.n(bleSearchDeviceBean);
                    return;
                }
                if (i == 3) {
                    de0.M("onSearchStopped");
                    this.a.u(rb0.DEFAULT);
                    this.a.l();
                } else if (i == 4) {
                    de0.M("onSearchCanceled");
                    this.a.u(rb0.DEFAULT);
                } else {
                    if (i != 5) {
                        return;
                    }
                    de0.M("onSearching");
                }
            }
        }

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a invoke() {
            return new a(aa0.this);
        }
    }

    public static final void m(aa0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w();
    }

    public static final void o(aa0 this$0, BleSearchDeviceBean bleSearchDeviceBean) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s(bleSearchDeviceBean);
    }

    public final void b(@NotNull String mac, @NotNull String deviceType) {
        nb0 nb0Var;
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        hb0 hb0Var = hb0.a;
        if (hb0Var.g().containsKey(mac) || hb0Var.e().containsKey(mac) || (nb0Var = hb0Var.d().get(mac)) == null) {
            return;
        }
        nb0Var.p(deviceType);
        nb0Var.q(mac);
        r(nb0Var, mac);
    }

    public final void c(@NotNull String mac, @NotNull String deviceType, @NotNull String deviceName, int i, @NotNull String uuid) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (ha0.a(deviceType)) {
            hb0 hb0Var = hb0.a;
            if (hb0Var.g().containsKey(mac) || hb0Var.e().containsKey(mac)) {
                return;
            }
            r(f(deviceType, deviceName, uuid, i, mac), mac);
        }
    }

    public final boolean d() {
        if (fa0.a.b()) {
            return false;
        }
        de0.i("checkScanEnable__no__permission");
        wb0.a.a(new o90(mt.ILLEGAL_ARGUMENT, "no__permission"));
        return true;
    }

    public final Triple<String, String, String> e(BleSearchDeviceBean bleSearchDeviceBean, ha0.a aVar) {
        String strC;
        String strA;
        String deviceType;
        String name = bleSearchDeviceBean.getName();
        String str = "";
        if (aVar != null) {
            String strB = aVar.b();
            Intrinsics.checkNotNullExpressionValue(strB, "it.name");
            if (strB.length() > 0) {
                name = aVar.b();
                Intrinsics.checkNotNullExpressionValue(name, "it.name");
            }
            strA = aVar.a();
            Intrinsics.checkNotNullExpressionValue(strA, "it.deviceType");
            strC = aVar.c();
            Intrinsics.checkNotNullExpressionValue(strC, "it.uuid");
        } else {
            strC = "";
            strA = strC;
        }
        if (strA.length() == 0) {
            hb0 hb0Var = hb0.a;
            if (hb0Var.d().containsKey(bleSearchDeviceBean.getMac())) {
                nb0 nb0Var = hb0Var.d().get(bleSearchDeviceBean.getMac());
                if (nb0Var != null && (deviceType = nb0Var.getDeviceType()) != null) {
                    str = deviceType;
                }
                strA = str;
            }
        }
        return new Triple<>(name, strA, strC);
    }

    public final nb0 f(String str, String str2, String str3, int i, String str4) {
        nb0 nb0Var = new nb0();
        nb0Var.p(str);
        nb0Var.o(str2);
        nb0Var.w(str3);
        nb0Var.f0(i);
        nb0Var.q(str4);
        return nb0Var;
    }

    public final void g(boolean z) {
        if (d()) {
            return;
        }
        this.a = z;
        if (z) {
            w();
        } else {
            x();
        }
    }

    public final ew h() {
        return (ew) this.c.getValue();
    }

    public final boolean i(String str) {
        nb0 nb0Var = hb0.a.d().get(str);
        return nb0Var == null || nb0Var.getG() <= 5;
    }

    public final void l() {
        if (this.a) {
            se0.g(new Runnable() { // from class: dc.x90
                @Override // java.lang.Runnable
                public final void run() {
                    aa0.m(this.a);
                }
            }, 500L);
        }
    }

    public final void n(@Nullable final BleSearchDeviceBean bleSearchDeviceBean) {
        if (bleSearchDeviceBean != null) {
            if (bleSearchDeviceBean.getMac().length() == 0) {
                return;
            }
            se0.b().execute(new Runnable() { // from class: dc.w90
                @Override // java.lang.Runnable
                public final void run() {
                    aa0.o(this.a, bleSearchDeviceBean);
                }
            });
        }
    }

    public final void p(BleSearchDeviceBean bleSearchDeviceBean, ha0.a aVar) {
        Triple<String, String, String> tripleE = e(bleSearchDeviceBean, aVar);
        String strComponent1 = tripleE.component1();
        String strComponent2 = tripleE.component2();
        String strComponent3 = tripleE.component3();
        if (strComponent2.length() == 0) {
            y(bleSearchDeviceBean, strComponent2, strComponent1, bleSearchDeviceBean.getRssi(), strComponent3);
        } else {
            c(bleSearchDeviceBean.getMac(), strComponent2, strComponent1, bleSearchDeviceBean.getRssi(), strComponent3);
        }
    }

    public final void q(nb0 nb0Var, BleSearchDeviceBean bleSearchDeviceBean, ha0.a aVar) {
        wb0.a.a(new l90(nb0Var.getMac(), 1, null, null, null, 28, null));
        if (nb0Var.getDeviceName() == null) {
            nb0Var.o(bleSearchDeviceBean.getName());
        }
        x();
        if (aVar != null) {
            if (nb0Var.getUuid() != null && !StringsKt__StringsJVMKt.equals$default(nb0Var.getUuid(), aVar.c(), false, 2, null)) {
                nb0Var.w(aVar.c());
                ib0.a.h(bleSearchDeviceBean.getMac(), nb0Var);
            }
            g90 g90VarB = hb0.a.b();
            if (g90VarB != null && g90VarB.a(nb0Var.getMac(), nb0Var.getUuid())) {
                nb0Var.r(false);
                ib0.a.h(bleSearchDeviceBean.getMac(), nb0Var);
                u(rb0.DEFAULT);
                return;
            }
        }
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("onScanToRequestConnect - ");
        sb.append(bleSearchDeviceBean.getMac());
        sb.append(", ");
        sb.append(bleSearchDeviceBean.getName());
        sb.append(" , ");
        sb.append(aVar != null ? aVar.a() : null);
        objArr[0] = sb.toString();
        de0.i(objArr);
        z90.a.c().c(bleSearchDeviceBean.getMac());
    }

    public final void r(nb0 nb0Var, String str) {
        hb0.a.g().put(str, nb0Var);
        ib0.a.h(str, nb0Var);
        wb0.a.a(new n90(str));
    }

    public final synchronized void s(BleSearchDeviceBean bleSearchDeviceBean) {
        if (z90.a.e() == rb0.SCAN) {
            t(bleSearchDeviceBean);
            ea0.a aVar = ea0.a;
            Pair<Boolean, ha0.a> pairB = aVar.b(bleSearchDeviceBean);
            boolean zBooleanValue = pairB.component1().booleanValue();
            ha0.a aVarComponent2 = pairB.component2();
            if (zBooleanValue) {
                hb0 hb0Var = hb0.a;
                nb0 nb0Var = hb0Var.f().get(bleSearchDeviceBean.getMac());
                if (nb0Var != null) {
                    q(nb0Var, bleSearchDeviceBean, aVarComponent2);
                } else if (!hb0Var.e().containsKey(bleSearchDeviceBean.getMac())) {
                    p(bleSearchDeviceBean, aVarComponent2);
                }
            } else if (aVar.a(bleSearchDeviceBean)) {
                wb0.a.a(new m90(bleSearchDeviceBean));
            }
        }
    }

    public final void t(BleSearchDeviceBean bleSearchDeviceBean) {
        if (this.b) {
            wb0.a.a(new k90(bleSearchDeviceBean));
        }
    }

    public final void u(rb0 rb0Var) {
        int i = a.a[rb0Var.ordinal()];
        boolean z = true;
        if (i == 1 ? z90.a.e() != rb0.DEFAULT : i != 2 || z90.a.e() != rb0.SCAN) {
            z = false;
        }
        if (z) {
            z90.a.g(rb0Var);
        }
    }

    public final void v(boolean z) {
        this.b = z;
    }

    public final void w() {
        if (!d() && z90.a.e() == rb0.DEFAULT) {
            BleSearchConfigBean bleSearchConfigBean = new BleSearchConfigBean(null, 1, null);
            bleSearchConfigBean.setTimeout(10000L);
            ba0.a.m(bleSearchConfigBean, h());
        }
    }

    public final void x() {
        if (d()) {
            return;
        }
        ba0.a.o();
    }

    public final void y(BleSearchDeviceBean bleSearchDeviceBean, String str, String str2, int i, String str3) {
        if (i(bleSearchDeviceBean.getMac())) {
            wb0.a.a(new l90(bleSearchDeviceBean.getMac(), 2, str2, Integer.valueOf(i), str3));
            nb0 nb0VarF = hb0.a.d().get(bleSearchDeviceBean.getMac());
            if (nb0VarF == null) {
                nb0VarF = f(str, str2, str3, i, bleSearchDeviceBean.getMac());
            }
            nb0VarF.b0(nb0VarF.getG() + 1);
            ib0.a.h(bleSearchDeviceBean.getMac(), nb0VarF);
            x();
            de0.l("unknownDevcieHandle - " + bleSearchDeviceBean.getMac() + ", " + bleSearchDeviceBean.getName());
            z90.a.c().c(bleSearchDeviceBean.getMac());
        }
    }
}
