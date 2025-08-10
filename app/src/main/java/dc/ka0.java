package dc;

import com.component.dxtoy.core.commandcore.bean.ToyCommandBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: ToyCommandSend.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J,\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ,\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ,\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ,\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f¨\u0006\u0011"}, d2 = {"Lcom/component/dxtoy/core/commandcore/ToyCommandSend;", "", "()V", "sendCommand", "", "commandBean", "Lcom/component/dxtoy/core/commandcore/bean/ToyCommandBean;", "sendCommandToBle", "mac", "", "value", "", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleWriteResponse;", "isWaitCallback", "", "sendCommandToBleWrite", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ka0 {
    public final void a(@NotNull ToyCommandBean commandBean) {
        Intrinsics.checkNotNullParameter(commandBean, "commandBean");
        ia0 ia0Var = ia0.a;
        if (ia0Var.c().b(commandBean)) {
            return;
        }
        ia0Var.d().b(commandBean);
    }

    public final void b(@NotNull String mac, @NotNull String value, @Nullable fw fwVar, boolean z) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        ca0.a.l(mac, value, fwVar, z);
    }

    public final void c(@NotNull String mac, @NotNull byte[] value, @Nullable fw fwVar, boolean z) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        ca0.a.n(mac, value, fwVar, z);
    }

    public final void d(@NotNull String mac, @NotNull String value, @Nullable fw fwVar, boolean z) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        ca0.a.h(mac, value, fwVar, z);
    }
}
