package dc;

import android.bluetooth.BluetoothDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: BtWorkCoreProxy.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\u0014\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\u000e\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\rJ\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\rH\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0007H\u0016J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0016J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0016J\u0012\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0007H\u0016J*\u0010!\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#H\u0016R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/wear/component/dxtoy/bluetooth/workcore/BtWorkCoreProxy;", "Lcom/wear/component/dxtoy/bluetooth/workcore/IBtWorkCore;", "()V", "btWorkCore", "clearCommand", "", MultipleAddresses.Address.ELEMENT, "", "disconnect", "getConnectDevice", "Landroid/bluetooth/BluetoothDevice;", "getElementId", "isConnected", "", "logUUid", "toy", "Lcom/wear/bean/Toy;", "maybeResetRequestConnectToyState", "readPhy", "readRssi", "registerPhyCallback", "phyCallback", "Lcom/component/dxbluetooth/lib/listener/IBluetoothPhyCallback;", "resetBleParams", "resetUseNew", "isUseNew", "scanDevice", StreamManagement.Enable.ELEMENT, "sendCommand", "message", "sendCommandToBle", "setElementId", "elementId", "setPreferredPhy", "tx", "", "rx", "phyOptions", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class zp1 implements aq1 {

    @NotNull
    public aq1 a = d(mp1.a.b());

    @Override // dc.aq1
    public boolean a(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return this.a.a(address);
    }

    @Override // dc.aq1
    public void b(@Nullable String str, @Nullable vt vtVar) {
        this.a.b(str, vtVar);
    }

    @Override // dc.aq1
    public void c(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        this.a.c(address);
    }

    @NotNull
    public final aq1 d(boolean z) {
        aq1 bq1Var = z ? new bq1() : new cq1();
        this.a = bq1Var;
        return bq1Var;
    }

    @Override // dc.aq1
    public void disconnect(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        this.a.disconnect(address);
    }

    @Override // dc.aq1
    public void e(@NotNull String address, @NotNull String message) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(message, "message");
        this.a.e(address, message);
    }

    @Override // dc.aq1
    public void f(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.a.f(message);
    }

    @Override // dc.aq1
    public void i(boolean z) {
        this.a.i(z);
    }

    @Override // dc.aq1
    public void j(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        this.a.j(address);
    }

    @Override // dc.aq1
    public void k(@Nullable String str) {
        this.a.k(str);
    }

    @Override // dc.aq1
    public void l(@NotNull String address, @NotNull String message) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(message, "message");
        this.a.l(address, message);
    }

    @Override // dc.aq1
    @Nullable
    public BluetoothDevice r(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return this.a.r(address);
    }

    @Override // dc.aq1
    public void readPhy(@Nullable String address) {
        this.a.readPhy(address);
    }

    @Override // dc.aq1
    public void readRssi(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        this.a.readRssi(address);
    }

    @Override // dc.aq1
    public void resetBleParams() {
        this.a.resetBleParams();
    }

    @Override // dc.aq1
    public void setPreferredPhy(@Nullable String address, int tx, int rx2, int phyOptions) {
        this.a.setPreferredPhy(address, tx, rx2, phyOptions);
    }
}
