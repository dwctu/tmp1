package dc;

import com.wear.bean.StrengthBean;
import com.wear.bean.Toy;
import dc.ToyControlBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: SolaceProCmdMapStrategy.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0002J\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00102\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0014J\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u00102\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u001c\u0010\u0007\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0002J\u001c\u0010\u0014\u001a\u00020\n2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u0016H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/wear/component/dxtoy/command/control/strategy/SolaceProCmdMapStrategy;", "Lcom/wear/component/dxtoy/command/control/strategy/CommonCmdMapStrategy;", "toy", "Lcom/wear/bean/Toy;", "builder", "Lcom/wear/component/dxtoy/command/control/bean/ToyControlBuilder;", "(Lcom/wear/bean/Toy;Lcom/wear/component/dxtoy/command/control/bean/ToyControlBuilder;)V", "isToyPositionMode", "", "addABndCCmdMap", "", "cmdMap", "", "", "", "calculateMotor", "", "calculateMotorPosition", "getToySetMode", "Lcom/wear/main/toy/solacepro/SolaceProModel;", "sendCommand", "valueMap", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class er1 extends dr1 {
    public boolean e;

    /* compiled from: SolaceProCmdMapStrategy.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[ToyControlBuilder.a.values().length];
            iArr[ToyControlBuilder.a.PATTERN_LONG.ordinal()] = 1;
            iArr[ToyControlBuilder.a.SPEED.ordinal()] = 2;
            iArr[ToyControlBuilder.a.POSITION.ordinal()] = 3;
            iArr[ToyControlBuilder.a.SETTING_ONLY.ordinal()] = 4;
            iArr[ToyControlBuilder.a.SETTING_FIRST.ordinal()] = 5;
            a = iArr;
            int[] iArr2 = new int[ek2.values().length];
            iArr2[ek2.POSITION.ordinal()] = 1;
            iArr2[ek2.SPEED.ordinal()] = 2;
            b = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public er1(@NotNull Toy toy, @NotNull ToyControlBuilder builder) {
        super(toy, builder);
        Intrinsics.checkNotNullParameter(toy, "toy");
        Intrinsics.checkNotNullParameter(builder, "builder");
    }

    @Override // dc.dr1, dc.xq1
    public void a(@NotNull Map<String, Integer> valueMap) {
        Intrinsics.checkNotNullParameter(valueMap, "valueMap");
        if (a.a[getB().getSolaceProType().ordinal()] != 1) {
            super.a(valueMap);
        }
    }

    @Override // dc.dr1
    @NotNull
    public List<String> d(@NotNull Map<String, Integer> cmdMap) {
        Intrinsics.checkNotNullParameter(cmdMap, "cmdMap");
        w(cmdMap);
        de0.i("isToyPositionMode: " + this.e + "  getToySetMode: " + v() + "  solaceProType: " + getB().getSolaceProType());
        if (this.e) {
            return u(cmdMap);
        }
        t(cmdMap);
        return super.d(cmdMap);
    }

    public final void t(Map<String, Integer> map) {
        Integer strokeMax;
        Integer strokeMin;
        StrengthBean strengthBeanC = vu1.a.c(getA().getDeviceId());
        StrengthBean.Data data = strengthBeanC != null ? strengthBeanC.getData() : null;
        qb0 qb0Var = qb0.STROKE_START;
        if (!map.containsKey(qb0Var.getRawValue())) {
            map.put(qb0Var.getRawValue(), Integer.valueOf(((data == null || (strokeMin = data.getStrokeMin()) == null) ? 0 : strokeMin.intValue()) / 5));
        }
        qb0 qb0Var2 = qb0.STROKE_END;
        if (map.containsKey(qb0Var2.getRawValue())) {
            return;
        }
        map.put(qb0Var2.getRawValue(), Integer.valueOf(((data == null || (strokeMax = data.getStrokeMax()) == null) ? 100 : strokeMax.intValue()) / 5));
    }

    public final List<String> u(Map<String, Integer> map) {
        ArrayList arrayList = new ArrayList();
        qb0 qb0Var = qb0.POSITION;
        Integer num = map.get(qb0Var.getRawValue());
        if (num != null) {
            int iIntValue = num.intValue();
            map.clear();
            map.put(qb0Var.getRawValue(), Integer.valueOf(iIntValue));
            arrayList.add(qb0Var.getRawValue());
        }
        return arrayList;
    }

    public final ek2 v() {
        return fk2.a.c(getA().getAddress());
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean w(java.util.Map<java.lang.String, java.lang.Integer> r6) {
        /*
            r5 = this;
            dc.tq1 r0 = r5.getB()
            dc.tq1$a r0 = r0.getSolaceProType()
            int[] r1 = dc.er1.a.a
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L5b
            r3 = 2
            if (r0 == r3) goto L5c
            r4 = 3
            if (r0 == r4) goto L5b
            r4 = 4
            if (r0 == r4) goto L53
            r1 = 5
            if (r0 != r1) goto L4d
            dc.ek2 r0 = r5.v()
            int[] r1 = dc.er1.a.b
            int r0 = r0.ordinal()
            r0 = r1[r0]
            if (r0 == r2) goto L42
            if (r0 != r3) goto L3c
            java.util.Map r6 = kotlin.collections.MapsKt__MapsKt.toMutableMap(r6)
            super.d(r6)
            boolean r1 = r6.isEmpty()
            goto L5c
        L3c:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L42:
            dc.qb0 r0 = dc.qb0.POSITION
            java.lang.String r0 = r0.getRawValue()
            boolean r1 = r6.containsKey(r0)
            goto L5c
        L4d:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L53:
            dc.ek2 r6 = r5.v()
            dc.ek2 r0 = dc.ek2.POSITION
            if (r6 != r0) goto L5c
        L5b:
            r1 = 1
        L5c:
            r5.e = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.er1.w(java.util.Map):boolean");
    }
}
