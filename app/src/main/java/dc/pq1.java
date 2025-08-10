package dc;

import com.wear.bean.Toy;
import dc.dr1;
import dc.qb0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyCmdControl.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/component/dxtoy/command/control/ToyCmdControl;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class pq1 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyCmdControl.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tJ6\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00132\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0013J,\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\t2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010\u000b\u001a\u00020\fJ$\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010\u000b\u001a\u00020\f¨\u0006\u0019"}, d2 = {"Lcom/wear/component/dxtoy/command/control/ToyCmdControl$Companion;", "", "()V", "cmdMapStrategyProcessor", "", "toy", "Lcom/wear/bean/Toy;", "handleCmdMap", "", "", "", "builder", "Lcom/wear/component/dxtoy/command/control/bean/ToyControlBuilder;", "createCmdMapStrategy", "Lcom/wear/component/dxtoy/command/control/listener/ICmdMapStrategy;", "getCmdMap", "motorF", "motorV", "motorFs", "", "motorVs", "send", "mac", "cmdMap", "sendAll", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Toy toy, Map<String, Integer> map, ToyControlBuilder toyControlBuilder) {
            xq1 xq1VarB = b(toy, toyControlBuilder);
            xq1VarB.b(map);
            if (!map.isEmpty()) {
                de0.M("sendCmdByToy " + toy.getAddress() + ": " + xd0.j(map));
                xq1VarB.a(map);
            }
        }

        public final xq1 b(Toy toy, ToyControlBuilder toyControlBuilder) {
            return toy.isBAToy() ? new er1(toy, toyControlBuilder) : new dr1(toy, toyControlBuilder);
        }

        @NotNull
        public final Map<String, Integer> c(@Nullable List<String> list, @Nullable List<String> list2) {
            String lowerCase;
            if (!(list == null || list.isEmpty())) {
                if (!(list2 == null || list2.isEmpty()) && list.size() == list2.size()) {
                    List<Pair> listZip = CollectionsKt___CollectionsKt.zip(list, list2);
                    ArrayList<Pair> arrayList = new ArrayList();
                    for (Pair pair : listZip) {
                        String str = (String) pair.component1();
                        String str2 = (String) pair.component2();
                        qb0.Companion companion = qb0.INSTANCE;
                        Pair pair2 = null;
                        if (str != null) {
                            lowerCase = str.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                        } else {
                            lowerCase = null;
                        }
                        qb0 qb0VarA = companion.a(lowerCase);
                        Integer intOrNull = str2 != null ? StringsKt__StringNumberConversionsKt.toIntOrNull(str2) : null;
                        if (qb0VarA != null && intOrNull != null) {
                            pair2 = TuplesKt.to(qb0VarA, intOrNull);
                        }
                        if (pair2 != null) {
                            arrayList.add(pair2);
                        }
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10)), 16));
                    for (Pair pair3 : arrayList) {
                        Pair pair4 = TuplesKt.to(((qb0) pair3.component1()).getRawValue(), Integer.valueOf(((Number) pair3.component2()).intValue()));
                        linkedHashMap.put(pair4.getFirst(), pair4.getSecond());
                    }
                    return MapsKt__MapsKt.toMutableMap(linkedHashMap);
                }
            }
            return new LinkedHashMap();
        }

        public final void d(@NotNull String mac, @NotNull Map<String, Integer> cmdMap, @NotNull ToyControlBuilder builder) {
            Toy toyO;
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(cmdMap, "cmdMap");
            Intrinsics.checkNotNullParameter(builder, "builder");
            if (cmdMap.isEmpty() || (toyO = pc1.a.O(mac)) == null) {
                return;
            }
            de0.l("sendCmdByToy__send__map: " + xd0.j(cmdMap) + " builder: " + xd0.j(builder));
            dr1.a aVar = dr1.c;
            Map<String, Integer> mapB = aVar.b(cmdMap);
            if (builder.getIsRange100()) {
                aVar.a(mapB);
            }
            a(toyO, mapB, builder);
        }

        public final void e(@NotNull Map<String, Integer> cmdMap, @NotNull ToyControlBuilder builder) {
            Intrinsics.checkNotNullParameter(cmdMap, "cmdMap");
            Intrinsics.checkNotNullParameter(builder, "builder");
            if (cmdMap.isEmpty()) {
                return;
            }
            dr1.a aVar = dr1.c;
            Map<String, Integer> mapB = aVar.b(cmdMap);
            if (builder.getIsRange100()) {
                aVar.a(mapB);
            }
            Iterator<T> it = pc1.a.P().iterator();
            while (it.hasNext()) {
                pq1.a.a((Toy) it.next(), MapsKt__MapsKt.toMutableMap(mapB), builder);
            }
        }
    }
}
