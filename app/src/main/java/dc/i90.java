package dc;

import com.component.dxbluetooth.lib.bean.BleResultBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyConnectEvent.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/component/dxtoy/core/api/event/ToyConnectEvent;", "", "mac", "", "connect", "Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$ToyConnectState;", "failResult", "Lcom/component/dxbluetooth/lib/bean/BleResultBean;", "(Ljava/lang/String;Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$ToyConnectState;Lcom/component/dxbluetooth/lib/bean/BleResultBean;)V", "getConnect", "()Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$ToyConnectState;", "getFailResult", "()Lcom/component/dxbluetooth/lib/bean/BleResultBean;", "getMac", "()Ljava/lang/String;", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class i90 {

    @NotNull
    public final String a;

    @NotNull
    public final sb0 b;

    @Nullable
    public final BleResultBean c;

    public i90(@NotNull String mac, @NotNull sb0 connect, @Nullable BleResultBean bleResultBean) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(connect, "connect");
        this.a = mac;
        this.b = connect;
        this.c = bleResultBean;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final sb0 getB() {
        return this.b;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final BleResultBean getC() {
        return this.c;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getA() {
        return this.a;
    }
}
