package dc;

import com.component.dxbilog.lib.bean.BILogConfig;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: BILogManager.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u001f\u001a\u00020\u0015J\u0006\u0010 \u001a\u00020\u0015J\u0006\u0010!\u001a\u00020\u0015J\u0006\u0010\"\u001a\u00020\u0015J\u0006\u0010#\u001a\u00020\u0015J\u0006\u0010$\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0014\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006%"}, d2 = {"Lcom/component/dxbilog/lib/manager/BILogManager;", "Lcom/component/dxbilog/lib/auto/listener/IBILogManager;", "()V", "SDK_VERSION", "", "appManager", "Lcom/component/dxbilog/lib/manager/BILogAppManager;", "getAppManager", "()Lcom/component/dxbilog/lib/manager/BILogAppManager;", "autoManager", "Lcom/component/dxbilog/lib/manager/BILogAutoManager;", "getAutoManager", "()Lcom/component/dxbilog/lib/manager/BILogAutoManager;", "value", "Lcom/component/dxbilog/lib/bean/BILogConfig;", "config", "getConfig", "()Lcom/component/dxbilog/lib/bean/BILogConfig;", "setConfig", "(Lcom/component/dxbilog/lib/bean/BILogConfig;)V", "isDebug", "", "()Z", "isDebug$delegate", "Lkotlin/Lazy;", "manualManager", "Lcom/component/dxbilog/lib/manager/BILogManualManager;", "getManualManager", "()Lcom/component/dxbilog/lib/manager/BILogManualManager;", "init", "", "isAutoAppState", "isAutoClick", "isAutoPage", "isManualAll", "isOutputLog", "isTest", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ks {

    @NotNull
    public static final ks a = new ks();

    @NotNull
    public static final hs b = new hs();

    @NotNull
    public static final ls c = new ls();

    @NotNull
    public static final gs d = new gs();

    @NotNull
    public static BILogConfig e = new BILogConfig();

    @NotNull
    public static final Lazy f = LazyKt__LazyJVMKt.lazy(a.a);

    /* compiled from: BILogManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function0<Boolean> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            return Boolean.valueOf(gd0.i());
        }
    }

    @NotNull
    public final gs a() {
        return d;
    }

    @NotNull
    public final ls b() {
        return c;
    }

    public final void c(@NotNull BILogConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        k(config);
        b.a();
        c.e();
        d.c();
    }

    public final boolean d() {
        return e.getIsAutoTrackAll() && e.getIsAppStatusChanged();
    }

    public final boolean e() {
        return e.getIsAutoTrackAll() && e.getIsAutoTrackClick();
    }

    public final boolean f() {
        return e.getIsAutoTrackAll() && e.getIsAutoTrackPage();
    }

    public final boolean g() {
        return ((Boolean) f.getValue()).booleanValue();
    }

    public final boolean h() {
        return e.getIsManualAll();
    }

    public final boolean i() {
        return e.getIsOutputLog() && g();
    }

    public final boolean j() {
        return e.getIsAppTest() && g();
    }

    public final void k(@NotNull BILogConfig value) {
        Intrinsics.checkNotNullParameter(value, "value");
        e = value;
    }
}
