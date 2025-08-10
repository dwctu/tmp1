package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: BleDataDeviceExt.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0001¨\u0006\n"}, d2 = {"getConecctedDevice", "Lcom/component/dxbluetooth/lib/manager/BleDevice;", "Lcom/component/dxbluetooth/lib/data/BleData;", "getDevice", "mac", "", "removeDevice", "", "setDevice", "bleDevice", "hytto-apps.android.components.core:dxbluetooth"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ot {
    @NotNull
    public static final synchronized lu a(@NotNull kt ktVar, @NotNull String mac) {
        lu luVar;
        Intrinsics.checkNotNullParameter(ktVar, "<this>");
        Intrinsics.checkNotNullParameter(mac, "mac");
        luVar = ktVar.b().get(mac);
        if (luVar == null) {
            luVar = new lu(mac);
            ktVar.b().put(mac, luVar);
        }
        return luVar;
    }
}
