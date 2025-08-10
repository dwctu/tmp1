package dc;

import android.bluetooth.BluetoothDevice;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: IBtWorkCore.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\t\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\b\u0010\u0015\u001a\u00020\u0003H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000bH&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0005H&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H&J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H&J\u0012\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H&J*\u0010\u001d\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH&¨\u0006\""}, d2 = {"Lcom/wear/component/dxtoy/bluetooth/workcore/IBtWorkCore;", "", "clearCommand", "", MultipleAddresses.Address.ELEMENT, "", "disconnect", "getConnectDevice", "Landroid/bluetooth/BluetoothDevice;", "getElementId", "isConnected", "", "logUUid", "toy", "Lcom/wear/bean/Toy;", "maybeResetRequestConnectToyState", "readPhy", "readRssi", "registerPhyCallback", "phyCallback", "Lcom/component/dxbluetooth/lib/listener/IBluetoothPhyCallback;", "resetBleParams", "scanDevice", StreamManagement.Enable.ELEMENT, "sendCommand", "message", "sendCommandToBle", "setElementId", "elementId", "setPreferredPhy", "tx", "", "rx", "phyOptions", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface aq1 {
    boolean a(@NotNull String str);

    void b(@Nullable String str, @Nullable vt vtVar);

    void c(@NotNull String str);

    void disconnect(@NotNull String address);

    void e(@NotNull String str, @NotNull String str2);

    void f(@NotNull String str);

    void i(boolean z);

    void j(@NotNull String str);

    void k(@Nullable String str);

    void l(@NotNull String str, @NotNull String str2);

    @Nullable
    BluetoothDevice r(@NotNull String str);

    void readPhy(@Nullable String address);

    void readRssi(@NotNull String address);

    void resetBleParams();

    void setPreferredPhy(@Nullable String address, int tx, int rx2, int phyOptions);
}
