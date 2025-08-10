package dc;

import android.bluetooth.BluetoothDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: OldBtWorkCore.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\u0015\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0012\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\bH\u0016J*\u0010 \u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/wear/component/dxtoy/bluetooth/workcore/OldBtWorkCore;", "Lcom/wear/component/dxtoy/bluetooth/workcore/IBtWorkCore;", "()V", "btWorkCore", "Lcom/lovense/btservice/work/BtWorkCore;", "clearCommand", "", MultipleAddresses.Address.ELEMENT, "", "disconnect", "getConnectDevice", "Landroid/bluetooth/BluetoothDevice;", "getElementId", "isConnected", "", "logUUid", "toy", "Lcom/wear/bean/Toy;", "maybeResetRequestConnectToyState", "readPhy", "readRssi", "registerPhyCallback", "phyCallback", "Lcom/component/dxbluetooth/lib/listener/IBluetoothPhyCallback;", "resetBleParams", "scanDevice", StreamManagement.Enable.ELEMENT, "sendCommand", "message", "sendCommandToBle", "setElementId", "elementId", "setPreferredPhy", "tx", "", "rx", "phyOptions", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class cq1 implements aq1 {

    @NotNull
    public final qc1 a = new qc1();

    @Override // dc.aq1
    public boolean a(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return this.a.l(address);
    }

    @Override // dc.aq1
    public void b(@Nullable String str, @Nullable vt vtVar) {
        this.a.getA().v(str, vtVar);
    }

    @Override // dc.aq1
    public void c(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        this.a.getB().s(address);
    }

    @Override // dc.aq1
    public void disconnect(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        this.a.d(address);
    }

    @Override // dc.aq1
    public void e(@NotNull String address, @NotNull String message) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(message, "message");
        this.a.getC().h(address, message);
    }

    @Override // dc.aq1
    public void f(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.a.getC().g(message);
    }

    @Override // dc.aq1
    public void i(boolean z) {
        this.a.q(z);
    }

    @Override // dc.aq1
    public void j(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        this.a.getC().a(address);
    }

    @Override // dc.aq1
    public void k(@Nullable String str) {
        this.a.r(str);
    }

    @Override // dc.aq1
    public void l(@NotNull String address, @NotNull String message) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(message, "message");
        String str = "sendCommandToBle: " + message;
        this.a.getC().i(address, message);
    }

    @Override // dc.aq1
    @Nullable
    public BluetoothDevice r(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return this.a.g(address);
    }

    @Override // dc.aq1
    public void readPhy(@Nullable String address) {
        this.a.getA().j(address);
    }

    @Override // dc.aq1
    public void readRssi(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        this.a.getC().e(address);
    }

    @Override // dc.aq1
    public void resetBleParams() {
        this.a.p();
    }

    @Override // dc.aq1
    public void setPreferredPhy(@Nullable String address, int tx, int rx2, int phyOptions) {
        this.a.getA().w(address, tx, rx2, phyOptions);
    }
}
