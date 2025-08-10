package dc;

import com.component.dxtoy.core.bluetooth.bean.ToyBtDeviceBean;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyDataManager.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000bJ\r\u0010$\u001a\u00020\"H\u0000¢\u0006\u0002\b%J\u0016\u0010&\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR'\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR'\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0015\u0010\u000eR\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR'\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\n8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001d\u0010\u000eR\u001d\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000e¨\u0006("}, d2 = {"Lcom/component/dxtoy/core/datacenter/ToyDataManager;", "", "()V", "appEngine", "Lcom/component/dxtoy/core/api/engine/IToyAppEngine;", "getAppEngine", "()Lcom/component/dxtoy/core/api/engine/IToyAppEngine;", "setAppEngine", "(Lcom/component/dxtoy/core/api/engine/IToyAppEngine;)V", "btDeviceMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/component/dxtoy/core/bluetooth/bean/ToyBtDeviceBean;", "getBtDeviceMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "btDeviceMap$delegate", "Lkotlin/Lazy;", "cacheToyMap", "Lcom/component/dxtoy/core/toy/ToyInfo;", "getCacheToyMap", "connectToyMap", "getConnectToyMap", "connectToyMap$delegate", "isUpdating", "", "()Z", "setUpdating", "(Z)V", "requestConnectToyMap", "getRequestConnectToyMap$core_release", "requestConnectToyMap$delegate", "scanToyMap", "getScanToyMap", "deleteToy", "", "mac", "updateConnectToyData", "updateConnectToyData$core_release", "updateOrAddToy", "toy", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class hb0 {

    @NotNull
    public static final hb0 a = new hb0();

    @NotNull
    public static final ConcurrentHashMap<String, nb0> b = ib0.a.c();

    @NotNull
    public static final ConcurrentHashMap<String, nb0> c = new ConcurrentHashMap<>();

    @NotNull
    public static final Lazy d = LazyKt__LazyJVMKt.lazy(b.a);

    @NotNull
    public static final Lazy e = LazyKt__LazyJVMKt.lazy(c.a);

    @NotNull
    public static final Lazy f = LazyKt__LazyJVMKt.lazy(a.a);

    @Nullable
    public static g90 g;
    public static boolean h;

    /* compiled from: ToyDataManager.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/component/dxtoy/core/bluetooth/bean/ToyBtDeviceBean;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<ConcurrentHashMap<String, ToyBtDeviceBean>> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ConcurrentHashMap<String, ToyBtDeviceBean> invoke() {
            return new ConcurrentHashMap<>();
        }
    }

    /* compiled from: ToyDataManager.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/component/dxtoy/core/toy/ToyInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<ConcurrentHashMap<String, nb0>> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ConcurrentHashMap<String, nb0> invoke() {
            ConcurrentHashMap<String, nb0> concurrentHashMapD = hb0.a.d();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, nb0> entry : concurrentHashMapD.entrySet()) {
                if (entry.getValue().getIsUIInMyToyList()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            ConcurrentHashMap<String, nb0> concurrentHashMap = new ConcurrentHashMap<>();
            concurrentHashMap.putAll(linkedHashMap);
            de0.i("init connectToyMap: " + concurrentHashMap.size());
            return concurrentHashMap;
        }
    }

    /* compiled from: ToyDataManager.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/component/dxtoy/core/toy/ToyInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<ConcurrentHashMap<String, nb0>> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ConcurrentHashMap<String, nb0> invoke() {
            return new ConcurrentHashMap<>();
        }
    }

    public final void a(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        e().remove(mac);
        de0.i("deleteToy connectToyMap size : " + e().size());
        ib0.a.b(mac);
    }

    @Nullable
    public final g90 b() {
        return g;
    }

    @NotNull
    public final ConcurrentHashMap<String, ToyBtDeviceBean> c() {
        return (ConcurrentHashMap) f.getValue();
    }

    @NotNull
    public final ConcurrentHashMap<String, nb0> d() {
        return b;
    }

    @NotNull
    public final ConcurrentHashMap<String, nb0> e() {
        return (ConcurrentHashMap) d.getValue();
    }

    @NotNull
    public final ConcurrentHashMap<String, nb0> f() {
        return (ConcurrentHashMap) e.getValue();
    }

    @NotNull
    public final ConcurrentHashMap<String, nb0> g() {
        return c;
    }

    public final boolean h() {
        return h;
    }

    public final void i(@Nullable g90 g90Var) {
        g = g90Var;
    }

    public final void j(boolean z) {
        h = z;
    }

    public final void k() {
        e().clear();
        ConcurrentHashMap<String, nb0> concurrentHashMap = b;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, nb0> entry : concurrentHashMap.entrySet()) {
            if (entry.getValue().getIsUIInMyToyList()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        e().putAll(linkedHashMap);
        de0.i("update  connectToyMap: " + e().size());
    }

    public final void l(@NotNull String mac, @NotNull nb0 toy) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(toy, "toy");
        if (mac.length() == 0) {
            return;
        }
        if (toy.getIsUIInMyToyList()) {
            e().put(mac, toy);
        } else {
            e().remove(mac);
        }
        de0.i("updateOrAddToy connectToyMap size : " + e().size());
        ib0.a.h(mac, toy);
    }
}
