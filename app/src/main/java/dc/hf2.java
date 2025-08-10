package dc;

import com.google.android.vending.expansion.downloader.Constants;
import com.wear.bean.Toy;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LanApiOfSolacePro.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/main/server/LanApiOfSolacePro;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class hf2 {

    @NotNull
    public static final a a = new a(null);

    @NotNull
    public static final ConcurrentHashMap<String, Integer> b = new ConcurrentHashMap<>();

    /* compiled from: LanApiOfSolacePro.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0002J.\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J&\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/wear/main/server/LanApiOfSolacePro$Companion;", "", "()V", "timeIndexHash", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "calculatePosRange", "Lkotlin/Pair;", "deviceId", "stroke", "sendFunction", "", "toy", "Lcom/wear/bean/Toy;", "motorsValue", "", "sendSpeedCmd", "motorVS", "", "isTranslate", "", "strListToIntList", "cmdList", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Pair<Integer, Integer> a(String str, String str2) {
            List listSplit$default;
            List listSorted;
            fk2 fk2Var = fk2.a;
            int iE = fk2Var.e(str);
            int iD = fk2Var.d(str);
            int i = iD - iE;
            if (i == 20) {
                return new Pair<>(Integer.valueOf(iE), Integer.valueOf(iD));
            }
            if (str2 != null && (listSplit$default = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{Constants.FILENAME_SEQUENCE_SEPARATOR}, false, 0, 6, (Object) null)) != null) {
                ArrayList arrayList = new ArrayList();
                Iterator it = listSplit$default.iterator();
                while (it.hasNext()) {
                    Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull((String) it.next());
                    if (intOrNull != null) {
                        arrayList.add(intOrNull);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next = it2.next();
                    int iIntValue = ((Number) next).intValue();
                    if (iIntValue >= 0 && iIntValue < 101) {
                        arrayList2.add(next);
                    }
                }
                if (!(arrayList2.size() == 2)) {
                    arrayList2 = null;
                }
                if (arrayList2 != null && (listSorted = CollectionsKt___CollectionsKt.sorted(arrayList2)) != null) {
                    int iIntValue2 = ((Number) listSorted.get(0)).intValue();
                    int iIntValue3 = ((Number) listSorted.get(1)).intValue();
                    if (iIntValue3 - iIntValue2 < 20) {
                        return new Pair<>(Integer.valueOf(iE), Integer.valueOf(iD));
                    }
                    int i2 = ((i * iIntValue2) / 100) + iE;
                    int i3 = ((i * iIntValue3) / 100) + iE;
                    de0.v("zbf", "minPos = " + iE + " , maxPos = " + iD + ", devMin = " + iIntValue2 + " ,devMax = " + iIntValue3);
                    while (i3 - i2 < 20) {
                        if (i2 > iE) {
                            i2--;
                        }
                        if (i3 < iD && i3 - i2 < 20) {
                            i3++;
                        }
                    }
                    de0.v("zbf", "result: tempMax = " + i3 + ", tempMin = " + i2);
                    return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3));
                }
            }
            return new Pair<>(Integer.valueOf(iE), Integer.valueOf(iD));
        }

        @JvmStatic
        public final void b(@NotNull Toy toy, @NotNull Map<String, Integer> motorsValue, @Nullable String str) {
            Intrinsics.checkNotNullParameter(toy, "toy");
            Intrinsics.checkNotNullParameter(motorsValue, "motorsValue");
            if (motorsValue.isEmpty()) {
                return;
            }
            List<List<String>> motors = toy.getMotors();
            Intrinsics.checkNotNullExpressionValue(motors, "toy.motors");
            Iterator<T> it = motors.iterator();
            int iIntValue = -1;
            while (it.hasNext()) {
                List<String> motorList = (List) it.next();
                Intrinsics.checkNotNullExpressionValue(motorList, "motorList");
                for (String motor : motorList) {
                    if (motorsValue.containsKey(motor)) {
                        Intrinsics.checkNotNullExpressionValue(motor, "motor");
                        iIntValue = ((Number) MapsKt__MapsKt.getValue(motorsValue, motor)).intValue();
                    }
                }
            }
            if (iIntValue <= 0) {
                if (iIntValue == 0) {
                    WearUtils.x.G().v0(toy.getAddress());
                }
            } else {
                String deviceId = toy.getDeviceId();
                Intrinsics.checkNotNullExpressionValue(deviceId, "toy.deviceId");
                Pair<Integer, Integer> pairA = a(deviceId, str);
                dk2.a.h(toy.getAddress(), iIntValue, pairA.component1().intValue() / 5, pairA.component2().intValue() / 5, (16 & 16) != 0 ? false : false, (16 & 32) != 0 ? false : true);
            }
        }

        @JvmStatic
        public final void c(@NotNull Toy toy, @NotNull List<String> motorVS, boolean z) {
            Intrinsics.checkNotNullParameter(toy, "toy");
            Intrinsics.checkNotNullParameter(motorVS, "motorVS");
            Integer num = (Integer) hf2.b.get(toy.getAddress());
            if (num == null) {
                num = 0;
            }
            int iIntValue = num.intValue();
            Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(motorVS.get(iIntValue % motorVS.size()));
            if (intOrNull == null || intOrNull.intValue() < 0) {
                return;
            }
            ConcurrentHashMap concurrentHashMap = hf2.b;
            String address = toy.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "toy.address");
            concurrentHashMap.put(address, Integer.valueOf(iIntValue + 1));
            WearUtils.x.G().d0(toy, intOrNull.intValue(), z, true);
        }

        @JvmStatic
        @NotNull
        public final List<Integer> d(@NotNull List<String> cmdList, boolean z) {
            Intrinsics.checkNotNullParameter(cmdList, "cmdList");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = cmdList.iterator();
            while (it.hasNext()) {
                Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull((String) it.next());
                if (intOrNull != null) {
                    arrayList.add(intOrNull);
                }
            }
            if (!z) {
                return arrayList;
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                int iIntValue = ((Number) it2.next()).intValue();
                if (iIntValue != 0) {
                    iIntValue = RangesKt___RangesKt.coerceAtLeast(iIntValue / 5, 1);
                }
                arrayList2.add(Integer.valueOf(iIntValue));
            }
            return arrayList2;
        }
    }

    @JvmStatic
    public static final void b(@NotNull Toy toy, @NotNull Map<String, Integer> map, @Nullable String str) {
        a.b(toy, map, str);
    }

    @JvmStatic
    public static final void c(@NotNull Toy toy, @NotNull List<String> list, boolean z) {
        a.c(toy, list, z);
    }

    @JvmStatic
    @NotNull
    public static final List<Integer> d(@NotNull List<String> list, boolean z) {
        return a.d(list, z);
    }
}
