package dc;

import com.epicgames.unreal.psoservices.PSOProgramService;
import com.wear.bean.Pattern;
import com.wear.bean.Toy;
import com.wear.bean.controlmutlitoys.Ball2CurveEventBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyControlPattern.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/component/dxtoy/command/control/business/ToyControlPattern;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class wq1 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyControlPattern.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007J$\u0010\u000b\u001a\u00020\u00042\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007J\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u000eH\u0002¨\u0006\u0013"}, d2 = {"Lcom/wear/component/dxtoy/command/control/business/ToyControlPattern$Companion;", "", "()V", "sendAllByPatternHead", "", "motorsValueStr", "", "pattern", "Lcom/wear/bean/Pattern;", "builder", "Lcom/wear/component/dxtoy/command/control/bean/ToyControlBuilder;", "sendByBall2CurveEventBean", "motorList", "", "Lcom/wear/bean/controlmutlitoys/Ball2CurveEventBean;", "transformEventBeanToCommand", "Lkotlin/Pair;", "", "bean", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @JvmOverloads
        public final void a(@Nullable String str, @Nullable Pattern pattern, @NotNull ToyControlBuilder builder) {
            Integer intOrNull;
            Intrinsics.checkNotNullParameter(builder, "builder");
            if ((pattern != null ? pattern.getHead() : null) == null) {
                return;
            }
            String function = pattern.getHead().getFunction();
            List<String> listSplit$default = function != null ? StringsKt__StringsKt.split$default((CharSequence) function, new String[]{","}, false, 0, 6, (Object) null) : null;
            List<String> listSplit$default2 = str != null ? StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null) : null;
            boolean z = true;
            if (listSplit$default == null || listSplit$default.isEmpty()) {
                return;
            }
            if (listSplit$default2 != null && !listSplit$default2.isEmpty()) {
                z = false;
            }
            if (z || listSplit$default2.size() < listSplit$default.size()) {
                return;
            }
            if (listSplit$default2.size() > listSplit$default.size()) {
                listSplit$default2 = listSplit$default2.subList(0, listSplit$default.size());
            }
            if (!pattern.isSystemPattern() && !pattern.getHead().isAllFunc()) {
                rq1.d.d(listSplit$default, listSplit$default2, builder);
                return;
            }
            String str2 = (String) CollectionsKt___CollectionsKt.getOrNull(listSplit$default2, listSplit$default.indexOf(PSOProgramService.VS_Key));
            if (str2 == null || (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str2)) == null) {
                return;
            }
            rq1.d.e(intOrNull.intValue(), builder);
        }

        @JvmStatic
        public final void b(@Nullable List<? extends Ball2CurveEventBean> list, @NotNull ToyControlBuilder builder) {
            ArrayList arrayList;
            Map mapPlus;
            Intrinsics.checkNotNullParameter(builder, "builder");
            if (list != null) {
                arrayList = new ArrayList();
                for (Ball2CurveEventBean ball2CurveEventBean : list) {
                    if (ball2CurveEventBean != null) {
                        arrayList.add(ball2CurveEventBean);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList == null || arrayList.isEmpty()) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                Ball2CurveEventBean ball2CurveEventBean2 = (Ball2CurveEventBean) obj;
                String toyAddress = ball2CurveEventBean2.getToyAddress();
                if ((!(toyAddress == null || toyAddress.length() == 0) || ball2CurveEventBean2.getFunction() == null || ball2CurveEventBean2.getGroups() == null) ? false : true) {
                    arrayList2.add(obj);
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10)), 16));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Pair<String, Integer> pairC = wq1.a.c((Ball2CurveEventBean) it.next());
                linkedHashMap.put(pairC.getFirst(), pairC.getSecond());
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : arrayList) {
                Ball2CurveEventBean ball2CurveEventBean3 = (Ball2CurveEventBean) obj2;
                String toyAddress2 = ball2CurveEventBean3.getToyAddress();
                if (((toyAddress2 == null || toyAddress2.length() == 0) || ball2CurveEventBean3.getFunction() == null || ball2CurveEventBean3.getGroups() == null) ? false : true) {
                    arrayList3.add(obj2);
                }
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj3 : arrayList3) {
                String toyAddress3 = ((Ball2CurveEventBean) obj3).getToyAddress();
                Object arrayList4 = linkedHashMap2.get(toyAddress3);
                if (arrayList4 == null) {
                    arrayList4 = new ArrayList();
                    linkedHashMap2.put(toyAddress3, arrayList4);
                }
                ((List) arrayList4).add(obj3);
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(linkedHashMap2.size()));
            for (Map.Entry entry : linkedHashMap2.entrySet()) {
                Object key = entry.getKey();
                Iterable iterable = (Iterable) entry.getValue();
                LinkedHashMap linkedHashMap4 = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10)), 16));
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    Pair<String, Integer> pairC2 = wq1.a.c((Ball2CurveEventBean) it2.next());
                    linkedHashMap4.put(pairC2.getFirst(), pairC2.getSecond());
                }
                linkedHashMap3.put(key, linkedHashMap4);
            }
            Iterator<T> it3 = pc1.a.P().iterator();
            while (it3.hasNext()) {
                String mac = ((Toy) it3.next()).getAddress();
                Map map = (Map) linkedHashMap3.get(mac);
                if (map == null || (mapPlus = MapsKt__MapsKt.plus(map, linkedHashMap)) == null) {
                    mapPlus = linkedHashMap;
                }
                rq1 rq1Var = rq1.d;
                Intrinsics.checkNotNullExpressionValue(mac, "mac");
                rq1Var.b(mac, MapsKt__MapsKt.toMutableMap(mapPlus), builder);
            }
        }

        public final Pair<String, Integer> c(Ball2CurveEventBean ball2CurveEventBean) {
            if (ball2CurveEventBean.isRotateChange()) {
                return TuplesKt.to(qb0.ROTATE.getRawValue(), -2);
            }
            String function = ball2CurveEventBean.getFunction();
            String groups = ball2CurveEventBean.getGroups();
            Intrinsics.checkNotNullExpressionValue(groups, "bean.groups");
            return TuplesKt.to(function, Integer.valueOf(Integer.parseInt(groups)));
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void a(@Nullable String str, @Nullable Pattern pattern, @NotNull ToyControlBuilder toyControlBuilder) {
        a.a(str, pattern, toyControlBuilder);
    }

    @JvmStatic
    public static final void b(@Nullable List<? extends Ball2CurveEventBean> list, @NotNull ToyControlBuilder toyControlBuilder) {
        a.b(list, toyControlBuilder);
    }
}
