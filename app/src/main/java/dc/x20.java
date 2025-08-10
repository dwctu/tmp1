package dc;

import dc.q90;
import dc.sa0;
import dc.x20;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyCmdGetBatteryHandler.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0002J\b\u0010\u001a\u001a\u00020\u0003H\u0002J\u000e\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\tJ5\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\u0004\b\u0000\u0010\u001d2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\"J \u0010#\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&H\u0007J\u000e\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R'\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/component/dxtoy/business/toyinfo/battery/handler/ToyCmdGetBatteryHandler;", "Lcom/component/dxtoy/command/base/BaseToyCmd;", "Lcom/component/dxtoy/core/commandcore/dispatcher/base/IToyCommandHandler;", "", "()V", "TIME_INTERVAL_SHORT", "", "batteryRequestTimeMap", "", "", "getBatteryRequestTimeMap", "()Ljava/util/Map;", "batteryRequestTimeMap$delegate", "Lkotlin/Lazy;", "curTimeInterval", "task", "Lcom/component/dxtoy/core/api/schedule/ToySchedule$Task;", "getTask", "()Lcom/component/dxtoy/core/api/schedule/ToySchedule$Task;", "task$delegate", "timeIntervalLong", "canGetBattery", "", "battery", "", "mac", "checkTimeInterval", "getBattery", "handleCommand", "Unit", "value", "bytes", "", "sendCommand", "(Ljava/lang/String;Ljava/lang/String;[BLjava/lang/String;)Ljava/lang/Object;", "isHandle", "onMessageEvent", "event", "Lcom/component/dxtoy/core/api/event/ToyConnectEvent;", "setIntervalTime", "intervalTime", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class x20 extends m40 implements sa0<Unit> {

    @NotNull
    public static final x20 b;
    public static long c = 10000;
    public static long d = 10000;

    @NotNull
    public static final Lazy e;

    @NotNull
    public static final Lazy f;

    /* compiled from: ToyCmdGetBatteryHandler.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<Map<String, Long>> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Map<String, Long> invoke() {
            return new LinkedHashMap();
        }
    }

    /* compiled from: ToyCmdGetBatteryHandler.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/api/schedule/ToySchedule$Task;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<q90.b> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        public static final void b() {
            for (Map.Entry<String, nb0> entry : yb0.f().entrySet()) {
                if (entry.getValue().getF() == sb0.CONNECT_SUC) {
                    x20.b.f(entry.getKey());
                }
            }
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final q90.b invoke() {
            return new q90.b() { // from class: dc.w20
                @Override // dc.q90.b
                public final void execute() {
                    x20.b.b();
                }
            };
        }
    }

    static {
        x20 x20Var = new x20();
        b = x20Var;
        e = LazyKt__LazyJVMKt.lazy(a.a);
        f = LazyKt__LazyJVMKt.lazy(b.a);
        wb0.a.b(x20Var);
        x20Var.i(c);
    }

    @Override // dc.sa0
    public boolean a(@NotNull String mac, @NotNull String value, @NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return ga0.f(value);
    }

    @Override // dc.sa0
    public boolean b(@NotNull String str, @NotNull String str2, @NotNull byte[] bArr, @NotNull String str3) {
        return sa0.b.b(this, str, str2, bArr, str3);
    }

    @Override // dc.sa0
    @Nullable
    public <Unit> Unit c(@NotNull String mac, @NotNull String value, @NotNull byte[] bytes, @NotNull String sendCommand) {
        nb0 nb0VarE;
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(sendCommand, "sendCommand");
        int iC = ga0.c(value);
        if (iC == -1 || (nb0VarE = yb0.e(mac)) == null) {
            return null;
        }
        nb0VarE.R(iC);
        if (iC == 2) {
            return null;
        }
        b.e();
        wb0.a.a(new v20(mac, iC));
        return null;
    }

    public final boolean d(int i, String str) {
        Long l = g().get(str);
        long jLongValue = l != null ? l.longValue() : 0L;
        if (jLongValue == 0) {
            return true;
        }
        long jCurrentTimeMillis = (System.currentTimeMillis() - jLongValue) / 1000;
        if (i > 0 || jCurrentTimeMillis <= 3) {
            return i < 30 ? jCurrentTimeMillis >= 10 : jCurrentTimeMillis >= 30;
        }
        return true;
    }

    public final void e() {
        boolean z;
        ConcurrentHashMap<String, nb0> concurrentHashMapF = yb0.f();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<String, nb0>> it = concurrentHashMapF.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, nb0> next = it.next();
            if (next.getValue().getF() == sb0.CONNECT_SUC) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        if (linkedHashMap.isEmpty()) {
            z = false;
        } else {
            Iterator it2 = linkedHashMap.entrySet().iterator();
            while (it2.hasNext()) {
                if (((nb0) ((Map.Entry) it2.next()).getValue()).getC() == 0) {
                    break;
                }
            }
            z = false;
        }
        long j = z ? 3000L : c;
        String str = "checkTimeInterval___checkTime: " + j;
        if (d != j) {
            d = j;
            String str2 = "checkTimeInterval___change: " + d;
            q90.c.e(h(), d);
        }
    }

    public final void f(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        nb0 nb0VarE = yb0.e(mac);
        if (nb0VarE != null && d(nb0VarE.getC(), mac)) {
            g().put(mac, Long.valueOf(System.currentTimeMillis()));
            new d50(mac).e();
        }
    }

    public final Map<String, Long> g() {
        return (Map) e.getValue();
    }

    @Override // dc.sa0
    @Nullable
    public ta0<Unit> getCallback() {
        return sa0.b.a(this);
    }

    public final q90.b h() {
        return (q90.b) f.getValue();
    }

    public final void i(long j) {
        c = j;
        e();
    }

    @Subscribe
    public final void onMessageEvent(@NotNull i90 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getB() == sb0.CONNECT_SUC) {
            e();
            f(event.getA());
        }
    }
}
