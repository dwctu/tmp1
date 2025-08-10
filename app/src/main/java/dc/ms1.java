package dc;

import androidx.fragment.app.FragmentActivity;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import com.wear.bean.event.EventBusToyF01ModeEvent;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.is3;
import dc.ms1;
import dc.q30;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: ToyWaggle.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/component/dxtoy/command/waggle/ToyWaggle;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ms1 {

    @NotNull
    public static final a a;

    /* compiled from: ToyWaggle.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0003J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0018\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0017H\u0007J \u0010!\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u001eH\u0007¨\u0006$"}, d2 = {"Lcom/wear/component/dxtoy/command/waggle/ToyWaggle$Companion;", "", "()V", "initHandlerListenerFeedback", "", "initHandlerListenerXMachine", "setGsensor", "mac", "", "showBlockedDialog", "startBt", "t", "Lcom/wear/bean/Toy;", "startMirr", "startMoveBMS", "startMoveOld", "stopBt", "stopMirr", "stopMoveBMS", "stopMoveOld", "updateToyModel", MultipleAddresses.Address.ELEMENT, "mode", "", "xMachineEnterSingleCtrlModel", "xMachineGetDly", "xMachineGetMode", "xMachineGetRotateBtnState", "xMachineGetThreshold", "value", "", "xMachineSetDly", "turnOn", "xMachineSetThreshold", "value1", "value2", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final void B(String mac) {
            Intrinsics.checkNotNullParameter(mac, "$mac");
            is3.b bVar = new is3.b(MyApplication.H());
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String strE = ah4.e(R.string.Resistence_noti);
            Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.Resistence_noti)");
            Object[] objArr = new Object[1];
            Toy toyQ = pc1.a.Q(mac);
            String name = toyQ != null ? toyQ.getName() : null;
            if (name == null) {
                name = "";
            }
            objArr[0] = name;
            String str = String.format(strE, Arrays.copyOf(objArr, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            bVar.p(str);
            bVar.o(ah4.e(R.string.Resistence_button));
            bVar.b(false);
            cs3.h(bVar).show();
        }

        public static final void d(String str, String mac, String value, byte[] bytes, String sendCommand) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            Intrinsics.checkNotNullParameter(sendCommand, "sendCommand");
            pc1.a.M().o(mac, value);
        }

        public static final void e(String str, String mac, String value, byte[] bytes, String sendCommand) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            Intrinsics.checkNotNullParameter(sendCommand, "sendCommand");
            pc1.a.M().m(mac, value);
        }

        public static final void f(String str, String mac, String value, byte[] bytes, String sendCommand) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            Intrinsics.checkNotNullParameter(sendCommand, "sendCommand");
            pc1.a.M().r(mac, value);
        }

        public static final void g(String str, String mac, String value, byte[] bytes, String sendCommand) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            Intrinsics.checkNotNullParameter(sendCommand, "sendCommand");
            pc1.a.M().p(mac, value);
        }

        public static final void h(String str, String mac, String value, byte[] bytes, String sendCommand) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            Intrinsics.checkNotNullParameter(sendCommand, "sendCommand");
            pc1.a.M().n(mac, value);
        }

        public static final void i(String str, String mac, String value, byte[] bytes, String sendCommand) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            Intrinsics.checkNotNullParameter(sendCommand, "sendCommand");
            pc1.a.M().q(mac, value);
        }

        public static final void k(String str, String mac, String value, byte[] bytes, String sendCommand) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            Intrinsics.checkNotNullParameter(sendCommand, "sendCommand");
            ms1.a.A(mac);
        }

        public static final void l(String str, String mac, String value, byte[] bytes, String sendCommand) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            Intrinsics.checkNotNullParameter(sendCommand, "sendCommand");
            if (str == null) {
                return;
            }
            if (Intrinsics.areEqual(str, "1")) {
                ms1.a.K(mac, false);
            } else if (Intrinsics.areEqual(str, "2")) {
                ms1.a.K(mac, true);
            }
        }

        public static final void m(String str, String mac, String value, byte[] bytes, String sendCommand) {
            final Toy toyQ;
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            Intrinsics.checkNotNullParameter(sendCommand, "sendCommand");
            if (str == null || (toyQ = pc1.a.Q(mac)) == null) {
                return;
            }
            toyQ.setF01IsOff(Intrinsics.areEqual("0", str));
            FragmentActivity fragmentActivityH = MyApplication.H();
            if (fragmentActivityH != null) {
                fragmentActivityH.runOnUiThread(new Runnable() { // from class: dc.js1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ms1.a.n(toyQ);
                    }
                });
            }
        }

        public static final void n(Toy toy) {
            Intrinsics.checkNotNullParameter(toy, "$toy");
            if (!toy.isF01IsNotice() || toy.isF01Off()) {
                return;
            }
            toy.setF01IsNotice(false);
            if (eg3.e(WearUtils.x, eg3.a) == 0) {
                new ds3(MyApplication.H(), toy).d(toy.getSimpleName(), true);
            }
        }

        @JvmStatic
        public final void A(@NotNull final String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (MyApplication.H() != null) {
                MyApplication.H().runOnUiThread(new Runnable() { // from class: dc.gs1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ms1.a.B(mac);
                    }
                });
            }
        }

        @JvmStatic
        public final void C(@Nullable Toy toy) {
            if (toy != null && toy.isSupportBt()) {
                if (mp1.a.b()) {
                    q30.a aVar = q30.a;
                    String address = toy.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address, "t.address");
                    aVar.d(address, true);
                    return;
                }
                pc1 pc1Var = pc1.a;
                String address2 = toy.getAddress();
                Intrinsics.checkNotNullExpressionValue(address2, "t.address");
                pc1Var.e(address2, "BT:On;");
            }
        }

        @JvmStatic
        public final void D(@Nullable Toy toy) {
            if (toy != null && toy.isSupportBt()) {
                if (mp1.a.b()) {
                    q30.a aVar = q30.a;
                    String address = toy.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address, "t.address");
                    aVar.e(address, true);
                    return;
                }
                pc1 pc1Var = pc1.a;
                String address2 = toy.getAddress();
                Intrinsics.checkNotNullExpressionValue(address2, "t.address");
                pc1Var.e(address2, "Mirr:1;");
            }
        }

        @JvmStatic
        public final void E(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                q30.a.f(mac);
            } else {
                pc1.a.e(mac, "BM;");
            }
        }

        @JvmStatic
        public final void F(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                z30.a.b(mac);
            } else {
                pc1.a.e(mac, "StartMove:30;");
            }
        }

        @JvmStatic
        public final void G(@Nullable Toy toy) {
            if (toy != null && toy.isSupportBt()) {
                if (mp1.a.b()) {
                    q30.a aVar = q30.a;
                    String address = toy.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address, "t.address");
                    aVar.d(address, false);
                    return;
                }
                pc1 pc1Var = pc1.a;
                String address2 = toy.getAddress();
                Intrinsics.checkNotNullExpressionValue(address2, "t.address");
                pc1Var.e(address2, "BT:Off;");
            }
        }

        @JvmStatic
        public final void H(@Nullable Toy toy) {
            if (toy != null && toy.isSupportBt()) {
                if (mp1.a.b()) {
                    q30.a aVar = q30.a;
                    String address = toy.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address, "t.address");
                    aVar.e(address, false);
                    return;
                }
                pc1 pc1Var = pc1.a;
                String address2 = toy.getAddress();
                Intrinsics.checkNotNullExpressionValue(address2, "t.address");
                pc1Var.e(address2, "Mirr:0;");
            }
        }

        @JvmStatic
        public final void I(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                q30.a.g(mac);
            } else {
                pc1.a.e(mac, "EM;");
            }
        }

        @JvmStatic
        public final void J(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                z30.a.c(mac);
            } else {
                pc1.a.e(mac, "StopMove;");
            }
        }

        @JvmStatic
        public final void K(@NotNull String address, boolean z) {
            Intrinsics.checkNotNullParameter(address, "address");
            Toy toy = pc1.a.g().get(address);
            if (toy != null) {
                toy.setF01IsReady(z);
                EventBus.getDefault().post(new EventBusToyF01ModeEvent(address));
            }
        }

        @JvmStatic
        public final void L(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                a40.a.a(mac);
            } else {
                pc1.a.e(mac, "SGM;");
            }
        }

        @JvmStatic
        public final void M(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                a40.a.b(mac);
            } else {
                pc1.a.e(mac, "getdly;");
            }
        }

        @JvmStatic
        public final void N(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                a40.a.c(mac);
            } else {
                pc1.a.e(mac, "GetMode;");
            }
        }

        @JvmStatic
        public final void O(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                a40.a.d(mac);
            } else {
                pc1.a.e(mac, "GetRBut;");
            }
        }

        @JvmStatic
        public final void P(@NotNull String mac, int i) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                a40.a.e(mac, i);
                return;
            }
            pc1.a.e(mac, "GetBkV:" + i + ';');
        }

        @JvmStatic
        public final void Q(@NotNull String mac, boolean z) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                a40.a.f(mac, z);
                return;
            }
            pc1.a.e(mac, "setdly:" + (z ? 1 : 0) + ';');
        }

        @JvmStatic
        public final void R(@NotNull String mac, int i, int i2) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                a40.a.g(mac, i, i2);
                return;
            }
            pc1.a.e(mac, "SetBkV:" + i + ':' + i2 + ",F01th;");
        }

        public final void c() {
            v30.b.d(new ta0() { // from class: dc.ds1
                @Override // dc.ta0
                public final void a(Object obj, String str, String str2, byte[] bArr, String str3) {
                    ms1.a.d((String) obj, str, str2, bArr, str3);
                }
            });
            t30.b.d(new ta0() { // from class: dc.fs1
                @Override // dc.ta0
                public final void a(Object obj, String str, String str2, byte[] bArr, String str3) {
                    ms1.a.e((String) obj, str, str2, bArr, str3);
                }
            });
            y30.b.d(new ta0() { // from class: dc.hs1
                @Override // dc.ta0
                public final void a(Object obj, String str, String str2, byte[] bArr, String str3) {
                    ms1.a.f((String) obj, str, str2, bArr, str3);
                }
            });
            w30.b.d(new ta0() { // from class: dc.cs1
                @Override // dc.ta0
                public final void a(Object obj, String str, String str2, byte[] bArr, String str3) {
                    ms1.a.g((String) obj, str, str2, bArr, str3);
                }
            });
            u30.b.d(new ta0() { // from class: dc.es1
                @Override // dc.ta0
                public final void a(Object obj, String str, String str2, byte[] bArr, String str3) {
                    ms1.a.h((String) obj, str, str2, bArr, str3);
                }
            });
            x30.b.d(new ta0() { // from class: dc.bs1
                @Override // dc.ta0
                public final void a(Object obj, String str, String str2, byte[] bArr, String str3) {
                    ms1.a.i((String) obj, str, str2, bArr, str3);
                }
            });
        }

        @JvmStatic
        public final void j() {
            h40.b.e(new ta0() { // from class: dc.ks1
                @Override // dc.ta0
                public final void a(Object obj, String str, String str2, byte[] bArr, String str3) {
                    ms1.a.l((String) obj, str, str2, bArr, str3);
                }
            });
            i40.b.e(new ta0() { // from class: dc.is1
                @Override // dc.ta0
                public final void a(Object obj, String str, String str2, byte[] bArr, String str3) {
                    ms1.a.m((String) obj, str, str2, bArr, str3);
                }
            });
            e40.b.d(new ta0() { // from class: dc.ls1
                @Override // dc.ta0
                public final void a(Object obj, String str, String str2, byte[] bArr, String str3) {
                    ms1.a.k((String) obj, str, str2, bArr, str3);
                }
            });
        }

        @JvmStatic
        public final void z(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                z30.a.a(mac);
            } else {
                pc1.a.e(mac, "Gsensor:0e02;");
            }
        }
    }

    static {
        a aVar = new a(null);
        a = aVar;
        aVar.j();
        aVar.c();
    }

    @JvmStatic
    public static final void a(@NotNull String str) {
        a.z(str);
    }

    @JvmStatic
    public static final void b(@NotNull String str) {
        a.A(str);
    }

    @JvmStatic
    public static final void c(@Nullable Toy toy) {
        a.C(toy);
    }

    @JvmStatic
    public static final void d(@Nullable Toy toy) {
        a.D(toy);
    }

    @JvmStatic
    public static final void e(@NotNull String str) {
        a.E(str);
    }

    @JvmStatic
    public static final void f(@NotNull String str) {
        a.F(str);
    }

    @JvmStatic
    public static final void g(@Nullable Toy toy) {
        a.G(toy);
    }

    @JvmStatic
    public static final void h(@Nullable Toy toy) {
        a.H(toy);
    }

    @JvmStatic
    public static final void i(@NotNull String str) {
        a.I(str);
    }

    @JvmStatic
    public static final void j(@NotNull String str) {
        a.J(str);
    }

    @JvmStatic
    public static final void k(@NotNull String str, boolean z) {
        a.K(str, z);
    }

    @JvmStatic
    public static final void l(@NotNull String str) {
        a.L(str);
    }

    @JvmStatic
    public static final void m(@NotNull String str) {
        a.M(str);
    }

    @JvmStatic
    public static final void n(@NotNull String str, int i) {
        a.P(str, i);
    }

    @JvmStatic
    public static final void o(@NotNull String str, boolean z) {
        a.Q(str, z);
    }

    @JvmStatic
    public static final void p(@NotNull String str, int i, int i2) {
        a.R(str, i, i2);
    }
}
