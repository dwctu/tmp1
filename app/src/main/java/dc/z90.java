package dc;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyBtManager.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0015H\u0016J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0015H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\""}, d2 = {"Lcom/component/dxtoy/core/bluetooth/ToyBtManager;", "Lcom/component/dxtoy/core/bluetooth/listenter/IToyBtApi;", "()V", "btConnect", "Lcom/component/dxtoy/core/bluetooth/ToyBtConnect;", "getBtConnect", "()Lcom/component/dxtoy/core/bluetooth/ToyBtConnect;", "btConnect$delegate", "Lkotlin/Lazy;", "btScan", "Lcom/component/dxtoy/core/bluetooth/ToyBtScan;", "getBtScan", "()Lcom/component/dxtoy/core/bluetooth/ToyBtScan;", "btScan$delegate", "btState", "Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$ScanOrConnectStatus;", "getBtState", "()Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$ScanOrConnectStatus;", "setBtState", "(Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$ScanOrConnectStatus;)V", "isCheckConnect", "", "()Z", "setCheckConnect", "(Z)V", "connectAtOnce", "", "mac", "", "deviceScan", "isStart", "disconnect", "setScanAllDeviceSwitch", "isOn", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class z90 {

    @NotNull
    public static final z90 a;
    public static boolean b = true;

    @NotNull
    public static rb0 c;

    @NotNull
    public static final Lazy d;

    @NotNull
    public static final Lazy e;

    /* compiled from: ToyBtManager.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/bluetooth/ToyBtConnect;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<y90> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final y90 invoke() {
            return new y90();
        }
    }

    /* compiled from: ToyBtManager.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/bluetooth/ToyBtScan;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<aa0> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final aa0 invoke() {
            return new aa0();
        }
    }

    static {
        z90 z90Var = new z90();
        a = z90Var;
        c = rb0.DEFAULT;
        d = LazyKt__LazyJVMKt.lazy(b.a);
        e = LazyKt__LazyJVMKt.lazy(a.a);
        z90Var.c();
    }

    public void a(boolean z) {
        d().g(z);
    }

    public void b(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        c().e(mac);
    }

    @NotNull
    public final y90 c() {
        return (y90) e.getValue();
    }

    @NotNull
    public final aa0 d() {
        return (aa0) d.getValue();
    }

    @NotNull
    public final rb0 e() {
        return c;
    }

    public final boolean f() {
        return b;
    }

    public final void g(@NotNull rb0 rb0Var) {
        Intrinsics.checkNotNullParameter(rb0Var, "<set-?>");
        c = rb0Var;
    }

    public void h(boolean z) {
        d().v(z);
    }
}
