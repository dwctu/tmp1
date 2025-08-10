package dc;

import com.wear.bean.StrengthBean;
import com.wear.bean.Toy;
import com.wear.bean.ToyConfigInfoBean;
import dc.b00;
import dc.qb0;
import dc.xq1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: CommonCmdMapStrategy.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0003\b\u0016\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J*\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012H\u0002J\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0014J\u001c\u0010\u0015\u001a\u00020\f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0002J'\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010\u0019J\u001c\u0010\u001a\u001a\u00020\f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0002J\u001c\u0010\u001b\u001a\u00020\f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0016J\u001c\u0010\u001c\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0002J \u0010\u001d\u001a\u0004\u0018\u00010\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$H\u0002J\u001a\u0010%\u001a\u00020\u00102\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0002JR\u0010,\u001a\u00020\f2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0012\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00120/H\u0002J\u0018\u00100\u001a\u00020\u00102\u0006\u0010(\u001a\u00020)2\u0006\u00101\u001a\u00020\u0010H\u0002J0\u00102\u001a\u00020\u00102\u0006\u00101\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u0010H\u0002J\u001c\u00107\u001a\u00020\f2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001009H\u0016J \u0010:\u001a\u00020\u00102\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u00101\u001a\u00020\u0010H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006<"}, d2 = {"Lcom/wear/component/dxtoy/command/control/strategy/CommonCmdMapStrategy;", "Lcom/wear/component/dxtoy/command/control/listener/ICmdMapStrategy;", "toy", "Lcom/wear/bean/Toy;", "builder", "Lcom/wear/component/dxtoy/command/control/bean/ToyControlBuilder;", "(Lcom/wear/bean/Toy;Lcom/wear/component/dxtoy/command/control/bean/ToyControlBuilder;)V", "getBuilder", "()Lcom/wear/component/dxtoy/command/control/bean/ToyControlBuilder;", "getToy", "()Lcom/wear/bean/Toy;", "cacheLastMotorValueByCmdMap", "", "handleCmdMap", "", "", "", "motorFunctionList", "", "calculateMotor", "cmdMap", "calculateRotate", "calculateRotateValue", "motorF", "motorV", "(Lcom/wear/bean/Toy;Ljava/lang/String;I)Ljava/lang/Integer;", "calculateStrength", "cmdMapHandleByToy", "compensateCmdMap", "getLastSupportFunction", "motor", "functions", "Lcom/wear/bean/ToyConfigInfoBean$FuncBean;", "getRotateValue", "it", "isDirection", "", "getStrength", "motorFunction", "Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$MotorFunction;", "strengthData", "Lcom/wear/bean/StrengthBean$Data;", "isFunctionKey", "key", "maybeAddLVSFunctions", "newMap", "motors", "", "posStrokeChange", "value", "rangeChange", "rangeMinValue", "rangeMaxValue", "settingMinValue", "settingMaxValue", "sendCommand", "valueMap", "", "strengthChange", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public class dr1 implements xq1 {

    @NotNull
    public static final a c = new a(null);

    @NotNull
    public static final ConcurrentHashMap<String, Map<String, Integer>> d = new ConcurrentHashMap<>();

    @NotNull
    public final Toy a;

    @NotNull
    public final ToyControlBuilder b;

    /* compiled from: CommonCmdMapStrategy.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0006J&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0006R,\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/wear/component/dxtoy/command/control/strategy/CommonCmdMapStrategy$Companion;", "", "()V", "lastMotorValueMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "", "getLastMotorValueMap$app_marketRelease", "()Ljava/util/concurrent/ConcurrentHashMap;", "calculateTranslate", "", "cmdMap", "filterCmdMap", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Map<String, Integer> cmdMap) {
            Intrinsics.checkNotNullParameter(cmdMap, "cmdMap");
            for (Map.Entry<String, Integer> entry : cmdMap.entrySet()) {
                String key = entry.getKey();
                int iIntValue = entry.getValue().intValue();
                boolean z = false;
                if (-2 <= iIntValue && iIntValue < 1) {
                    z = true;
                }
                if (!z) {
                    qb0.Companion companion = qb0.INSTANCE;
                    String lowerCase = key.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    qb0 qb0VarA = companion.a(lowerCase);
                    if (qb0VarA != null) {
                        int last = qb0VarA.getValueRange().getLast();
                        cmdMap.put(key, Integer.valueOf(RangesKt___RangesKt.coerceAtMost(RangesKt___RangesKt.coerceAtLeast((iIntValue * last) / 100, 1), last)));
                    }
                }
            }
        }

        @NotNull
        public final Map<String, Integer> b(@NotNull Map<String, Integer> cmdMap) {
            Intrinsics.checkNotNullParameter(cmdMap, "cmdMap");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, Integer> entry : cmdMap.entrySet()) {
                String key = entry.getKey();
                int iIntValue = entry.getValue().intValue();
                qb0.Companion companion = qb0.INSTANCE;
                String lowerCase = key.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                if ((companion.a(lowerCase) == null || iIntValue == -1) ? false : true) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                String str = (String) entry2.getKey();
                Integer numValueOf = Integer.valueOf(((Number) entry2.getValue()).intValue());
                String lowerCase2 = str.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                linkedHashMap2.put(lowerCase2, numValueOf);
            }
            return linkedHashMap2;
        }
    }

    /* compiled from: CommonCmdMapStrategy.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[qb0.values().length];
            iArr[qb0.VIBRATE.ordinal()] = 1;
            iArr[qb0.VIBRATE1.ordinal()] = 2;
            iArr[qb0.VIBRATE2.ordinal()] = 3;
            iArr[qb0.VIBRATE3.ordinal()] = 4;
            iArr[qb0.ROTATE.ordinal()] = 5;
            iArr[qb0.SUCK.ordinal()] = 6;
            iArr[qb0.PUMP.ordinal()] = 7;
            iArr[qb0.THRUSTING.ordinal()] = 8;
            iArr[qb0.FINGERING.ordinal()] = 9;
            iArr[qb0.DEPTH.ordinal()] = 10;
            iArr[qb0.POSITION.ordinal()] = 11;
            a = iArr;
        }
    }

    public dr1(@NotNull Toy toy, @NotNull ToyControlBuilder builder) {
        Intrinsics.checkNotNullParameter(toy, "toy");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.a = toy;
        this.b = builder;
    }

    @Override // dc.xq1
    public void a(@NotNull Map<String, Integer> valueMap) {
        Intrinsics.checkNotNullParameter(valueMap, "valueMap");
        b00.a aVar = b00.a;
        String address = this.a.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "toy.address");
        aVar.g(address, valueMap);
    }

    @Override // dc.xq1
    public void b(@NotNull Map<String, Integer> cmdMap) {
        Intrinsics.checkNotNullParameter(cmdMap, "cmdMap");
        if (n(cmdMap, this.a, this.b)) {
            return;
        }
        List<String> listD = d(cmdMap);
        g(cmdMap);
        e(cmdMap);
        if (cmdMap.isEmpty()) {
            return;
        }
        c(cmdMap, listD);
        h(cmdMap);
    }

    public final void c(Map<String, Integer> map, List<String> list) {
        ConcurrentHashMap<String, Map<String, Integer>> concurrentHashMap = d;
        String address = this.a.getAddress();
        Map<String, Integer> linkedHashMap = concurrentHashMap.get(address);
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>();
            for (String str : list) {
                if (!Intrinsics.areEqual(qb0.ROTATE.getRawValue(), str)) {
                    linkedHashMap.put(str, 0);
                }
            }
            Map<String, Integer> mapPutIfAbsent = concurrentHashMap.putIfAbsent(address, linkedHashMap);
            if (mapPutIfAbsent != null) {
                linkedHashMap = mapPutIfAbsent;
            }
        }
        Map<String, Integer> it = linkedHashMap;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().intValue() >= 0) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            String str2 = (String) entry2.getKey();
            Integer numValueOf = Integer.valueOf(((Number) entry2.getValue()).intValue());
            Intrinsics.checkNotNullExpressionValue(it, "it");
            it.put(str2, numValueOf);
        }
    }

    @NotNull
    public List<String> d(@NotNull Map<String, Integer> cmdMap) {
        Intrinsics.checkNotNullParameter(cmdMap, "cmdMap");
        de0.i("calculateMotor " + this.a.getAddress() + " : " + xd0.j(cmdMap));
        List<List<String>> motors = this.a.getMotors();
        ToyConfigInfoBean.FuncBean func = this.a.getFunc();
        if ((motors == null || motors.isEmpty()) || func == null) {
            cmdMap.clear();
            return new ArrayList();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(motors, "motors");
        for (List<String> motor : motors) {
            Intrinsics.checkNotNullExpressionValue(motor, "motor");
            int i = Integer.MIN_VALUE;
            for (String key : motor) {
                Integer num = cmdMap.get(key);
                if (num != null) {
                    int iIntValue = num.intValue();
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    boolean zO = o(key, func);
                    if (this.b.getIsMotorIgnoreFunction() || zO) {
                        i = iIntValue;
                    }
                }
            }
            String strJ = j(motor, func);
            if (strJ != null) {
                if (i != Integer.MIN_VALUE) {
                    linkedHashMap.put(strJ, Integer.valueOf(i));
                }
                arrayList.add(strJ);
            }
        }
        p(linkedHashMap, arrayList, cmdMap, motors);
        cmdMap.clear();
        cmdMap.putAll(linkedHashMap);
        de0.i("calculateMotor " + this.a.getAddress() + " : " + xd0.j(cmdMap) + " \n" + xd0.j(linkedHashMap));
        return arrayList;
    }

    public final void e(Map<String, Integer> map) {
        if (map.isEmpty() || !map.containsKey(qb0.ROTATE.getRawValue())) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int iIntValue = entry.getValue().intValue();
            Integer numF = f(this.a, key, iIntValue);
            if (numF != null && numF.intValue() != iIntValue) {
                map.put(key, numF);
            }
            if (numF == null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            map.remove((String) ((Map.Entry) it.next()).getKey());
        }
    }

    public final Integer f(Toy toy, String str, int i) {
        qb0 qb0Var = qb0.ROTATE;
        if (!Intrinsics.areEqual(qb0Var.getRawValue(), str)) {
            return Integer.valueOf(i);
        }
        if (toy.isSupportLVS()) {
            if (i == -2) {
                toy.setDirection(!toy.isDirection());
                Map<String, Integer> map = d.get(toy.getAddress());
                Integer num = map != null ? map.get(qb0Var.getRawValue()) : null;
                if (num != null) {
                    return Integer.valueOf(k(num.intValue(), toy.isDirection()));
                }
                String address = toy.getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "toy.address");
                new h70(address).e();
                return null;
            }
            if (i != -1 && i != 0) {
                return Integer.valueOf(k(i, toy.isDirection()));
            }
        } else if (i == -2) {
            String address2 = toy.getAddress();
            Intrinsics.checkNotNullExpressionValue(address2, "toy.address");
            new h70(address2).e();
            return null;
        }
        return Integer.valueOf(i);
    }

    public final void g(Map<String, Integer> map) {
        String deviceId = this.a.getDeviceId();
        if (deviceId == null || deviceId.length() == 0) {
            return;
        }
        StrengthBean strengthBeanC = vu1.a.c(deviceId);
        StrengthBean.Data data = strengthBeanC != null ? strengthBeanC.getData() : null;
        if (data == null) {
            return;
        }
        if (this.b.getIsStrength()) {
            de0.w("ble_business_ble_log", "Strength : " + xd0.j(data) + " \noldMap : " + map);
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                int iIntValue = entry.getValue().intValue();
                if (!(-2 <= iIntValue && iIntValue < 1)) {
                    qb0.Companion companion = qb0.INSTANCE;
                    String lowerCase = key.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    qb0 qb0VarA = companion.a(lowerCase);
                    if (qb0VarA != null) {
                        map.put(key, Integer.valueOf(s(qb0VarA, data, iIntValue)));
                    }
                }
            }
            de0.w("ble_business_ble_log", "Strength : " + xd0.j(data) + " \nnewMap : " + map);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("posStrokeChange111 : POSITION ");
        qb0 qb0Var = qb0.POSITION;
        sb.append(map.get(qb0Var.getRawValue()));
        de0.l(sb.toString());
        Integer num = map.get(qb0Var.getRawValue());
        if (num != null) {
            map.put(qb0Var.getRawValue(), Integer.valueOf(q(data, num.intValue())));
        }
    }

    public final void h(Map<String, Integer> map) {
        Map<String, Integer> map2;
        if (!this.a.isCmdCompensation() || (map2 = d.get(this.a.getAddress())) == null) {
            return;
        }
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            int iIntValue = entry.getValue().intValue();
            if (map.get(key) == null) {
                map.put(key, Integer.valueOf(iIntValue));
            }
        }
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final ToyControlBuilder getB() {
        return this.b;
    }

    public final String j(List<String> list, ToyConfigInfoBean.FuncBean funcBean) {
        String str = null;
        for (String str2 : list) {
            if (o(str2, funcBean)) {
                str = str2;
            }
        }
        return str;
    }

    public final int k(int i, boolean z) {
        int i2 = i & 127;
        return z ? i2 : i2 ^ 128;
    }

    public final int l(qb0 qb0Var, StrengthBean.Data data) {
        switch (qb0Var == null ? -1 : b.a[qb0Var.ordinal()]) {
            case 1:
                Integer v = data.getV();
                if (v == null) {
                    return 100;
                }
                return v.intValue();
            case 2:
                Integer v1 = data.getV1();
                if (v1 == null) {
                    return 100;
                }
                return v1.intValue();
            case 3:
                Integer v2 = data.getV2();
                if (v2 == null) {
                    return 100;
                }
                return v2.intValue();
            case 4:
                Integer v3 = data.getV3();
                if (v3 == null) {
                    return 100;
                }
                return v3.intValue();
            case 5:
                Integer r = data.getR();
                if (r == null) {
                    return 100;
                }
                return r.intValue();
            case 6:
                Integer s = data.getS();
                if (s == null) {
                    return 100;
                }
                return s.intValue();
            case 7:
                Integer p = data.getP();
                if (p == null) {
                    return 100;
                }
                return p.intValue();
            case 8:
                Integer t = data.getT();
                if (t == null) {
                    return 100;
                }
                return t.intValue();
            case 9:
                Integer f = data.getF();
                if (f == null) {
                    return 100;
                }
                return f.intValue();
            case 10:
                Integer d2 = data.getD();
                if (d2 == null) {
                    return 100;
                }
                return d2.intValue();
            case 11:
                Integer pos = data.getPos();
                if (pos == null) {
                    return 100;
                }
                return pos.intValue();
            default:
                return 100;
        }
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final Toy getA() {
        return this.a;
    }

    public boolean n(@NotNull Map<String, Integer> map, @NotNull Toy toy, @NotNull ToyControlBuilder toyControlBuilder) {
        return xq1.a.a(this, map, toy, toyControlBuilder);
    }

    public final boolean o(String str, ToyConfigInfoBean.FuncBean funcBean) {
        if (Intrinsics.areEqual(str, qb0.VIBRATE.getRawValue())) {
            return funcBean.isV();
        }
        if (Intrinsics.areEqual(str, qb0.VIBRATE1.getRawValue())) {
            return funcBean.isV1();
        }
        if (Intrinsics.areEqual(str, qb0.VIBRATE2.getRawValue())) {
            return funcBean.isV2();
        }
        if (Intrinsics.areEqual(str, qb0.VIBRATE3.getRawValue())) {
            return funcBean.isV3();
        }
        if (Intrinsics.areEqual(str, qb0.ROTATE.getRawValue())) {
            return funcBean.isR();
        }
        if (Intrinsics.areEqual(str, qb0.SUCK.getRawValue())) {
            return funcBean.isS();
        }
        if (Intrinsics.areEqual(str, qb0.PUMP.getRawValue())) {
            return funcBean.isP();
        }
        if (Intrinsics.areEqual(str, qb0.THRUSTING.getRawValue())) {
            return funcBean.isT();
        }
        if (Intrinsics.areEqual(str, qb0.FINGERING.getRawValue())) {
            return funcBean.isF();
        }
        if (Intrinsics.areEqual(str, qb0.DEPTH.getRawValue())) {
            return funcBean.isD();
        }
        if (Intrinsics.areEqual(str, qb0.POSITION.getRawValue())) {
            return funcBean.isPos();
        }
        return false;
    }

    public final void p(Map<String, Integer> map, List<String> list, Map<String, Integer> map2, List<? extends List<String>> list2) {
        Integer num;
        de0.i("calculateMotor___maybeAddLVSFunctions 111 " + this.a.getAddress() + " : " + xd0.j(map));
        List<qb0> it = this.a.getLvsMotorsFuncList();
        if ((it == null || it.isEmpty()) || it.size() == list2.size()) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        for (qb0 qb0Var : it) {
            if (!map.containsKey(qb0Var.getRawValue()) && (num = map2.get(qb0Var.getRawValue())) != null) {
                map.put(qb0Var.getRawValue(), Integer.valueOf(num.intValue()));
                list.add(qb0Var.getRawValue());
            }
        }
        de0.i("calculateMotor___maybeAddLVSFunctions 222 " + this.a.getAddress() + " : " + xd0.j(map));
    }

    public final int q(StrengthBean.Data data, int i) {
        if (-2 <= i && i < 0) {
            return i;
        }
        Integer strokeMin = data.getStrokeMin();
        int iIntValue = strokeMin == null ? 0 : strokeMin.intValue();
        Integer strokeMax = data.getStrokeMax();
        int iIntValue2 = strokeMax == null ? 100 : strokeMax.intValue();
        int iR = r(i, 0, 100, iIntValue, iIntValue2);
        de0.l("posStrokeChange222 : changeValue " + iR + " value " + i + " posMin " + iIntValue + "  posMax " + iIntValue2);
        return RangesKt___RangesKt.coerceAtMost(RangesKt___RangesKt.coerceAtLeast(iR, iIntValue), iIntValue2);
    }

    public final int r(int i, int i2, int i3, int i4, int i5) {
        if ((i2 == i4 && i3 == i5) || i2 >= i3 || i4 >= i5) {
            return i;
        }
        if (i <= 0) {
            return i4;
        }
        return ((i * (i5 - i4)) / (i3 - i2)) + i4;
    }

    public final int s(qb0 qb0Var, StrengthBean.Data data, int i) {
        int iL = l(qb0Var, data);
        if (iL == 100) {
            return i;
        }
        if (iL == 0) {
            return 0;
        }
        return RangesKt___RangesKt.coerceAtMost(RangesKt___RangesKt.coerceAtLeast((iL * i) / 100, 1), qb0Var.getValueRange().getLast());
    }
}
