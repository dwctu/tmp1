package dc;

import dc.jb0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyDataStorage.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004J\u0018\u0010\u000e\u001a\u00020\u000b2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\u0016\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/component/dxtoy/core/datacenter/ToyDataStorage;", "", "()V", "MMKV_KEY_HAS_IMPORTED_TOY_DATA", "", "cacheToyMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/component/dxtoy/core/toy/ToyInfo;", "getCacheToyMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "clearImportToyDataLabel", "", "deleteToy", "mac", "importData", "toyDataList", "", "isHasImportToyData", "", "loadToyDataFromLocal", "saveImportToyDataLabel", "saveToy", "toy", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ib0 {

    @NotNull
    public static final ib0 a;

    @NotNull
    public static final ConcurrentHashMap<String, nb0> b;

    static {
        ib0 ib0Var = new ib0();
        a = ib0Var;
        b = new ConcurrentHashMap<>();
        xb0 xb0Var = xb0.d;
        ib0Var.f();
    }

    public final void a() {
        xb0.d.l("mmkv_key_has_imported_toy_data");
    }

    public final void b(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        nb0 nb0VarRemove = b.remove(mac);
        if (nb0VarRemove != null) {
            jb0.e.a(nb0VarRemove);
        }
    }

    @NotNull
    public final ConcurrentHashMap<String, nb0> c() {
        return b;
    }

    public final void d(@Nullable List<nb0> list) {
        ConcurrentHashMap<String, nb0> concurrentHashMap = b;
        concurrentHashMap.clear();
        jb0.a aVar = jb0.e;
        aVar.b();
        g();
        if (!(list == null || list.isEmpty())) {
            de0.i("importData size: " + list.size() + " \r saveToyData str: \r " + list);
            List<nb0> listFilterNotNull = CollectionsKt___CollectionsKt.filterNotNull(list);
            aVar.e(listFilterNotNull);
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(listFilterNotNull, 10)), 16));
            for (Object obj : listFilterNotNull) {
                linkedHashMap.put(((nb0) obj).getMac(), obj);
            }
            concurrentHashMap.putAll(linkedHashMap);
            de0.i("importData cacheToyMap: " + b.size());
        }
        hb0.a.k();
    }

    public final boolean e() {
        return xb0.d.d("mmkv_key_has_imported_toy_data", false);
    }

    public final void f() {
        List<nb0> listC = jb0.e.c();
        if (listC != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(listC, 10)), 16));
            for (Object obj : listC) {
                linkedHashMap.put(((nb0) obj).getMac(), obj);
            }
            ConcurrentHashMap<String, nb0> concurrentHashMap = b;
            concurrentHashMap.clear();
            concurrentHashMap.putAll(linkedHashMap);
        }
        de0.i("loadToyDataFromLocal cacheToyMap size: " + b.size());
    }

    public final void g() {
        xb0.d.k("mmkv_key_has_imported_toy_data", true);
    }

    public final void h(@NotNull String mac, @NotNull nb0 toy) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(toy, "toy");
        if (mac.length() == 0) {
            return;
        }
        b.put(mac, toy);
        if (toy.getIsVirtualToy()) {
            return;
        }
        jb0.e.f(toy);
    }
}
