package dc;

import com.wear.bean.Toy;
import dc.yq1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyControlSend.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/component/dxtoy/command/control/proxyimpl/ToyControlSend;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ar1 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyControlSend.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J,\u0010\u000b\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J$\u0010\u0010\u001a\u00020\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J \u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J(\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J4\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J,\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\n2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0017¨\u0006\u0016"}, d2 = {"Lcom/wear/component/dxtoy/command/control/proxyimpl/ToyControlSend$Companion;", "Lcom/wear/component/dxtoy/command/control/listener/IToyControlSend;", "()V", "changeFunctionMotorV20To100", "", "builder", "Lcom/wear/component/dxtoy/command/control/bean/ToyControlBuilder;", "motorV", "getAllFunctionList", "", "", "sendAllFunction", "", "motorF", "motorFs", "motorVs", "sendAllMap", "cmdMap", "", "sendFunction", "mac", "sendMap", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements yq1 {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // dc.yq1
        @JvmStatic
        public void a(@NotNull String mac, int i, @NotNull ToyControlBuilder builder) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(builder, "builder");
            Toy toyO = pc1.a.O(mac);
            if (toyO == null) {
                return;
            }
            int iF = f(builder, i);
            if (!mp1.a.b()) {
                lc1.a.p(toyO, iF, builder.getIsRange100(), builder.getIsStrength());
                return;
            }
            List<String> listG = g();
            int size = listG.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(String.valueOf(iF));
            }
            m(mac, listG, arrayList, builder);
        }

        @Override // dc.yq1
        @JvmStatic
        public void b(@NotNull String mac, @NotNull Map<String, Integer> cmdMap, @NotNull ToyControlBuilder builder) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(cmdMap, "cmdMap");
            Intrinsics.checkNotNullParameter(builder, "builder");
            pq1.a.d(mac, cmdMap, builder);
        }

        @Override // dc.yq1
        @JvmStatic
        public void c(@NotNull Map<String, Integer> cmdMap, @NotNull ToyControlBuilder builder) {
            Intrinsics.checkNotNullParameter(cmdMap, "cmdMap");
            Intrinsics.checkNotNullParameter(builder, "builder");
            pq1.a.e(cmdMap, builder);
        }

        @Override // dc.yq1
        @JvmStatic
        public void d(@NotNull List<String> motorFs, @NotNull List<String> motorVs, @NotNull ToyControlBuilder builder) {
            Intrinsics.checkNotNullParameter(motorFs, "motorFs");
            Intrinsics.checkNotNullParameter(motorVs, "motorVs");
            Intrinsics.checkNotNullParameter(builder, "builder");
            if (mp1.a.b()) {
                c(pq1.a.c(motorFs, motorVs), builder);
                return;
            }
            Iterator<T> it = pc1.a.P().iterator();
            while (it.hasNext()) {
                lc1.a.r((Toy) it.next(), (String[]) motorFs.toArray(new String[0]), (String[]) motorVs.toArray(new String[0]), builder.getIsRange100(), builder.getIsStrength(), (32 & 32) != 0 ? false : false);
            }
        }

        @Override // dc.yq1
        @JvmStatic
        public void e(int i, @NotNull ToyControlBuilder builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            int iF = f(builder, i);
            if (!mp1.a.b()) {
                lc1.a.c(iF, builder.getIsRange100(), builder.getIsStrength());
                return;
            }
            List<String> listG = g();
            int size = listG.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(String.valueOf(iF));
            }
            d(listG, arrayList, builder);
        }

        public final int f(ToyControlBuilder toyControlBuilder, int i) {
            if (toyControlBuilder.getIsRange100()) {
                return i;
            }
            toyControlBuilder.g(true);
            return i * 5;
        }

        public final List<String> g() {
            qb0[] qb0VarArrValues = qb0.values();
            ArrayList arrayList = new ArrayList();
            int length = qb0VarArrValues.length;
            for (int i = 0; i < length; i++) {
                qb0 qb0Var = qb0VarArrValues[i];
                if (!(qb0Var == qb0.STROKE_START || qb0Var == qb0.STROKE_END)) {
                    arrayList.add(qb0Var);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((qb0) it.next()).getRawValue());
            }
            return arrayList2;
        }

        public void h(int i) {
            yq1.a.a(this, i);
        }

        public void i(@NotNull List<String> list, @NotNull List<String> list2) {
            yq1.a.b(this, list, list2);
        }

        public void j(@NotNull Map<String, Integer> map) {
            yq1.a.c(this, map);
        }

        public void k(@NotNull String str, int i) {
            yq1.a.d(this, str, i);
        }

        @JvmStatic
        public void l(@NotNull String mac, @NotNull String motorF, @NotNull String motorV, @NotNull ToyControlBuilder builder) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(motorF, "motorF");
            Intrinsics.checkNotNullParameter(motorV, "motorV");
            Intrinsics.checkNotNullParameter(builder, "builder");
            ArrayList arrayList = new ArrayList(1);
            for (int i = 0; i < 1; i++) {
                arrayList.add(motorF);
            }
            ArrayList arrayList2 = new ArrayList(1);
            for (int i2 = 0; i2 < 1; i2++) {
                arrayList2.add(motorV);
            }
            m(mac, arrayList, arrayList2, builder);
        }

        @JvmStatic
        public void m(@NotNull String mac, @NotNull List<String> motorFs, @NotNull List<String> motorVs, @NotNull ToyControlBuilder builder) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(motorFs, "motorFs");
            Intrinsics.checkNotNullParameter(motorVs, "motorVs");
            Intrinsics.checkNotNullParameter(builder, "builder");
            Toy toyO = pc1.a.O(mac);
            if (toyO == null) {
                return;
            }
            if (mp1.a.b()) {
                b(mac, pq1.a.c(motorFs, motorVs), builder);
            } else {
                lc1.a.r(toyO, (String[]) motorFs.toArray(new String[0]), (String[]) motorVs.toArray(new String[0]), builder.getIsRange100(), builder.getIsStrength(), (32 & 32) != 0 ? false : false);
            }
        }

        public void n(@NotNull String str, @NotNull Map<String, Integer> map) {
            yq1.a.e(this, str, map);
        }
    }
}
