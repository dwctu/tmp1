package dc;

import com.sun.jna.Callback;
import dc.ec0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyTurnoverManager.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\"\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/component/dxtoy/turnover/ToyTurnoverManager;", "Lcom/component/dxtoy/turnover/listener/IToyTurnoverManager;", "()V", "appDataEngine", "Lcom/component/dxtoy/turnover/listener/IAppDataEngine;", "getAppDataEngine", "()Lcom/component/dxtoy/turnover/listener/IAppDataEngine;", "setAppDataEngine", "(Lcom/component/dxtoy/turnover/listener/IAppDataEngine;)V", "networkEngine", "Lcom/component/dxtoy/turnover/listener/INetworkEngine;", "getNetworkEngine", "()Lcom/component/dxtoy/turnover/listener/INetworkEngine;", "setNetworkEngine", "(Lcom/component/dxtoy/turnover/listener/INetworkEngine;)V", "checkInit", "", "init", "reportToyInfo", "macId", "", "status", "Lcom/component/dxtoy/turnover/data/ToyTurnoverEum$ConnectState;", Callback.METHOD_NAME, "Lcom/component/dxtoy/turnover/listener/INetworkEngine$ICallback;", "turnover_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class bc0 {

    @NotNull
    public static final bc0 a = new bc0();
    public static ec0 b;
    public static dc0 c;

    public final void a() {
        if (b == null || c == null) {
            throw new RuntimeException("ToyTurnoverManager not init");
        }
    }

    @NotNull
    public final dc0 b() {
        dc0 dc0Var = c;
        if (dc0Var != null) {
            return dc0Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appDataEngine");
        return null;
    }

    @NotNull
    public final ec0 c() {
        ec0 ec0Var = b;
        if (ec0Var != null) {
            return ec0Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("networkEngine");
        return null;
    }

    public void d(@NotNull ec0 networkEngine, @NotNull dc0 appDataEngine) {
        Intrinsics.checkNotNullParameter(networkEngine, "networkEngine");
        Intrinsics.checkNotNullParameter(appDataEngine, "appDataEngine");
        f(appDataEngine);
        g(networkEngine);
    }

    public void e(@NotNull String macId, @NotNull cc0 status, @Nullable ec0.a aVar) {
        Intrinsics.checkNotNullParameter(macId, "macId");
        Intrinsics.checkNotNullParameter(status, "status");
        a();
        if (!b().c()) {
            fc0.a.b(StringsKt__StringsJVMKt.replace$default(macId, SignatureImpl.INNER_SEP, "", false, 4, (Object) null), status, aVar);
        } else {
            if (aVar == null) {
                return;
            }
            aVar.b("forbidden_use_app", "is forbidden use app");
        }
    }

    public final void f(@NotNull dc0 dc0Var) {
        Intrinsics.checkNotNullParameter(dc0Var, "<set-?>");
        c = dc0Var;
    }

    public final void g(@NotNull ec0 ec0Var) {
        Intrinsics.checkNotNullParameter(ec0Var, "<set-?>");
        b = ec0Var;
    }
}
