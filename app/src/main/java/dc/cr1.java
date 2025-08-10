package dc;

import dc.ToyControlBuilder;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyControlStop.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/component/dxtoy/command/control/proxyimpl/ToyControlStop;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class cr1 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyControlStop.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0017J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0017¨\u0006\u0007"}, d2 = {"Lcom/wear/component/dxtoy/command/control/proxyimpl/ToyControlStop$Companion;", "Lcom/wear/component/dxtoy/command/control/listener/IToyControlStop;", "()V", "stopToysAction", "", "mac", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public void a() {
            if (!mp1.a.b()) {
                lc1.a.u();
                return;
            }
            qb0[] qb0VarArrValues = qb0.values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(qb0VarArrValues.length), 16));
            for (qb0 qb0Var : qb0VarArrValues) {
                Pair pair = TuplesKt.to(qb0Var.getRawValue(), 0);
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            ar1.a.c(MapsKt__MapsKt.toMutableMap(linkedHashMap), new ToyControlBuilder(ToyControlBuilder.a.SPEED));
        }

        @JvmStatic
        public void b(@Nullable String str) {
            if (str == null || str.length() == 0) {
                return;
            }
            if (!mp1.a.b()) {
                lc1.a.v(str);
                return;
            }
            qb0[] qb0VarArrValues = qb0.values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(qb0VarArrValues.length), 16));
            for (qb0 qb0Var : qb0VarArrValues) {
                Pair pair = TuplesKt.to(qb0Var.getRawValue(), 0);
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            ar1.a.b(str, MapsKt__MapsKt.toMutableMap(linkedHashMap), new ToyControlBuilder(ToyControlBuilder.a.SPEED));
        }
    }
}
