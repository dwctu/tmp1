package dc;

import android.app.Application;
import android.bluetooth.BluetoothDevice;
import com.wear.bean.Toy;
import dc.f90;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: NewBtWoreCore.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0012\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0012\u0010\u001d\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u001c\u0010\u001f\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0011H\u0016J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0018H\u0016J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0004H\u0016J\u0018\u0010%\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004H\u0016J\u0018\u0010(\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004H\u0016J\u0012\u0010)\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J*\u0010*\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006/"}, d2 = {"Lcom/wear/component/dxtoy/bluetooth/workcore/NewBtWoreCore;", "Lcom/wear/component/dxtoy/bluetooth/workcore/IBtWorkCore;", "()V", "elementId", "", "toyCmdBridgeReceive", "Lcom/wear/component/dxtoy/command/common/bridge/ToyCmdBridgeReceive;", "getToyCmdBridgeReceive", "()Lcom/wear/component/dxtoy/command/common/bridge/ToyCmdBridgeReceive;", "toyCmdBridgeReceive$delegate", "Lkotlin/Lazy;", "toyCmdBridgeSend", "Lcom/wear/component/dxtoy/command/common/bridge/ToyCmdBridgeSend;", "getToyCmdBridgeSend", "()Lcom/wear/component/dxtoy/command/common/bridge/ToyCmdBridgeSend;", "toyCmdBridgeSend$delegate", "clearCommand", "", MultipleAddresses.Address.ELEMENT, "disconnect", "getConnectDevice", "Landroid/bluetooth/BluetoothDevice;", "getElementId", "isConnected", "", "logUUid", "toy", "Lcom/wear/bean/Toy;", "maybeResetRequestConnectToyState", "readPhy", "readRssi", "registerPhyCallback", "phyCallback", "Lcom/component/dxbluetooth/lib/listener/IBluetoothPhyCallback;", "resetBleParams", "scanDevice", StreamManagement.Enable.ELEMENT, "sendCommand", "message", "cmd", "sendCommandToBle", "setElementId", "setPreferredPhy", "tx", "", "rx", "phyOptions", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class bq1 implements aq1 {

    @NotNull
    public final Lazy a = LazyKt__LazyJVMKt.lazy(b.a);

    @NotNull
    public final Lazy b = LazyKt__LazyJVMKt.lazy(a.a);

    /* compiled from: NewBtWoreCore.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/component/dxtoy/command/common/bridge/ToyCmdBridgeReceive;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<lq1> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final lq1 invoke() {
            return new lq1();
        }
    }

    /* compiled from: NewBtWoreCore.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/component/dxtoy/command/common/bridge/ToyCmdBridgeSend;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<mq1> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final mq1 invoke() {
            return new mq1(null, 1, 0 == true ? 1 : 0);
        }
    }

    public bq1() {
        as1 as1Var = as1.a;
        pp1 pp1Var = pp1.a;
        lr1 lr1Var = lr1.a;
        d();
    }

    @Override // dc.aq1
    public boolean a(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        pc1 pc1Var = pc1.a;
        Toy toyQ = pc1Var.Q(address);
        if (toyQ == null) {
            return false;
        }
        if (toyQ.isSelect() && toyQ.isVirtualToy()) {
            return true;
        }
        if (hb0.a.c().get(address) == null) {
            return false;
        }
        nb0 nb0VarI3 = toyQ.toyProxy.I3();
        if ((nb0VarI3 != null ? nb0VarI3.getF() : null) != sb0.CONNECT_SUC) {
            return false;
        }
        Application applicationA = ve0.a();
        Intrinsics.checkNotNullExpressionValue(applicationA, "getApp()");
        return pc1Var.y(applicationA, false);
    }

    @Override // dc.aq1
    public void b(@Nullable String str, @Nullable vt vtVar) {
        f90.a.h(str, vtVar);
    }

    @Override // dc.aq1
    public void c(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        z90.a.c().t(address);
    }

    public final lq1 d() {
        return (lq1) this.b.getValue();
    }

    @Override // dc.aq1
    public void disconnect(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        b00.a.c(address);
    }

    @Override // dc.aq1
    public void e(@NotNull String address, @NotNull String cmd) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        g().l(address, cmd);
    }

    @Override // dc.aq1
    public void f(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Iterator<T> it = pc1.a.P().iterator();
        while (it.hasNext()) {
            String address = ((Toy) it.next()).getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "it.address");
            e(address, message);
        }
    }

    public final mq1 g() {
        return (mq1) this.a.getValue();
    }

    @Override // dc.aq1
    public void i(boolean z) {
        b00.a.b(z);
    }

    @Override // dc.aq1
    public void j(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        b00.a.a(address);
    }

    @Override // dc.aq1
    public void k(@Nullable String str) {
    }

    @Override // dc.aq1
    public void l(@NotNull String address, @NotNull String message) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(message, "message");
        f90.a.m(f90.a, address, message, null, false, 12, null);
    }

    @Override // dc.aq1
    @Nullable
    public BluetoothDevice r(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return sw.a.d(address);
    }

    @Override // dc.aq1
    public void readPhy(@Nullable String address) {
        f90.a.f(address, null);
    }

    @Override // dc.aq1
    public void readRssi(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        g30.a.b(address);
    }

    @Override // dc.aq1
    public void resetBleParams() {
        Iterator<T> it = pc1.a.P().iterator();
        while (it.hasNext()) {
            String address = ((Toy) it.next()).getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "it.address");
            j(address);
        }
    }

    @Override // dc.aq1
    public void setPreferredPhy(@Nullable String address, int tx, int rx2, int phyOptions) {
        f90.a.p(address, Integer.valueOf(tx), Integer.valueOf(rx2), Integer.valueOf(phyOptions), null);
    }
}
