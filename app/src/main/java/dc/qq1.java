package dc;

import com.wear.bean.controlmutlitoys.Ball2CurveEventBean;
import dc.qb0;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyControlConvert.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/component/dxtoy/command/control/ToyControlConvert;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class qq1 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyControlConvert.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/wear/component/dxtoy/command/control/ToyControlConvert$Companion;", "", "()V", "getCmdValueFromPattern", "", "funList", "", "Lcom/wear/bean/controlmutlitoys/Ball2CurveEventBean;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final String a(@Nullable List<? extends Ball2CurveEventBean> list) {
            String lowerCase;
            Integer intOrNull;
            if (list == null || list.isEmpty()) {
                return "";
            }
            ArrayList<Pair> arrayList = new ArrayList();
            for (Ball2CurveEventBean ball2CurveEventBean : list) {
                qb0.Companion companion = qb0.INSTANCE;
                String function = ball2CurveEventBean.getFunction();
                Pair pair = null;
                if (function != null) {
                    Intrinsics.checkNotNullExpressionValue(function, "function");
                    lowerCase = function.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                } else {
                    lowerCase = null;
                }
                qb0 qb0VarA = companion.a(lowerCase);
                String groups = ball2CurveEventBean.getGroups();
                if (groups != null) {
                    Intrinsics.checkNotNullExpressionValue(groups, "groups");
                    intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(groups);
                } else {
                    intOrNull = null;
                }
                if (qb0VarA != null && intOrNull != null) {
                    pair = TuplesKt.to(qb0VarA, intOrNull);
                }
                if (pair != null) {
                    arrayList.add(pair);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            for (Pair pair2 : arrayList) {
                qb0 qb0Var = (qb0) pair2.component1();
                int iIntValue = ((Number) pair2.component2()).intValue();
                int last = qb0Var.getValueRange().getLast();
                if (iIntValue > 0) {
                    iIntValue = RangesKt___RangesKt.coerceAtMost(RangesKt___RangesKt.coerceAtLeast((iIntValue * last) / 100, 1), last);
                }
                arrayList2.add(Integer.valueOf(iIntValue));
            }
            return CollectionsKt___CollectionsKt.joinToString$default(arrayList2, ",", null, null, 0, null, null, 62, null);
        }
    }

    @JvmStatic
    @NotNull
    public static final String a(@Nullable List<? extends Ball2CurveEventBean> list) {
        return a.a(list);
    }
}
