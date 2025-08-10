package dc;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.sun.jna.Callback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BleManagerListenerExt.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u001e\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u000b\u001a\u0014\u0010\f\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\r\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u001e\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t\u001a\u0014\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u000b\u001a\u0014\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\r¨\u0006\u0012"}, d2 = {"registerBluetoothBondListener", "", "Lcom/component/dxbluetooth/lib/manager/BleManager;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/component/dxbluetooth/lib/listener/IBluetoothBondListener;", "registerBluetoothPhyCallback", "mac", "", Callback.METHOD_NAME, "Lcom/component/dxbluetooth/lib/listener/IBluetoothPhyCallback;", "registerBluetoothStateListener", "Lcom/component/dxbluetooth/lib/listener/IBluetoothStateListener;", "registerConnectStatusListener", "Lcom/component/dxbluetooth/lib/listener/IBleConnectStatusListener;", "unregisterBluetoothBondListener", "unregisterBluetoothPhyCallback", "unregisterBluetoothStateListener", "unregisterConnectStatusListener", "hytto-apps.android.components.core:dxbluetooth"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ou {
    public static final void a(@NotNull nu nuVar, @Nullable ut utVar) {
        Intrinsics.checkNotNullParameter(nuVar, "<this>");
        mu.a.v(utVar);
    }

    public static final void b(@NotNull nu nuVar, @Nullable String str, @Nullable vt vtVar) {
        Intrinsics.checkNotNullParameter(nuVar, "<this>");
        mu.a.w(str, vtVar);
    }

    public static final void c(@NotNull nu nuVar, @Nullable wt wtVar) {
        Intrinsics.checkNotNullParameter(nuVar, "<this>");
        mu.a.y(wtVar);
    }

    public static final void d(@NotNull nu nuVar, @Nullable rt rtVar) {
        Intrinsics.checkNotNullParameter(nuVar, "<this>");
        mu.a.z(rtVar);
    }
}
