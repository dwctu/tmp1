package dc;

import com.component.dxtoy.core.toy.bean.FuncBean;
import com.component.dxtoy.core.toy.bean.ToyConfigInfoBean;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: ToyCommandCtrlConvert.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tJ0\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tH\u0002J&\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tH\u0002J'\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¢\u0006\u0002\u0010\u0016J'\u0010\u0017\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0018H\u0002¢\u0006\u0002\u0010\u0019J&\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tH\u0002J&\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tH\u0002J8\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u001e2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tH\u0002J.\u0010\u001f\u001a\u0004\u0018\u00010\u00182\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010 \u001a\u00020\nH\u0002¨\u0006!"}, d2 = {"Lcom/component/dxtoy/command/ctrl/ToyCommandCtrlConvert;", "", "()V", "convertToCommandList", "", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "mac", "", "valueMap", "", "", "filterVibrate", "toy", "Lcom/component/dxtoy/core/toy/ToyInfo;", "motorMap", "handleLVS", "handleMotorFuncToLVS", "", "value", FirebaseAnalytics.Param.INDEX, "lvsValue", "", "(Ljava/lang/Integer;I[B)V", "handleMotorFuncToMply", "", "(Ljava/lang/Integer;I[I)V", "handleMply", "handleMultiply", "handleNormalOrder", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "processMplyCommand", "maxValueSize", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class c90 {

    @NotNull
    public static final c90 a = new c90();

    @NotNull
    public final List<b90> a(@NotNull String mac, @NotNull Map<String, Integer> valueMap) {
        ArrayList<b90> arrayListG;
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(valueMap, "valueMap");
        ArrayList arrayList = new ArrayList();
        nb0 nb0Var = hb0.a.e().get(mac);
        if (nb0Var == null) {
            de0.m("ble_toy", "Can not find the toy of the mac = " + mac);
            return arrayList;
        }
        b90 b90VarB = b(nb0Var, valueMap);
        if (b90VarB != null) {
            arrayList.add(b90VarB);
        } else {
            b90 b90VarE = e(nb0Var, valueMap);
            if (b90VarE != null) {
                arrayList.add(b90VarE);
            } else {
                b90 b90VarF = f(nb0Var, valueMap);
                if ((b90VarF != null ? Boolean.valueOf(arrayList.add(b90VarF)) : null) == null && (arrayListG = g(nb0Var, valueMap)) != null) {
                    if (!arrayListG.isEmpty()) {
                        arrayList.addAll(arrayListG);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        return arrayList;
    }

    public final b90 b(nb0 nb0Var, Map<String, Integer> map) {
        int iD = tb0.d(nb0Var);
        List<qb0> listC = tb0.c(nb0Var);
        if (tb0.l(nb0Var) && iD > 0) {
            boolean z = false;
            if (!(listC == null || listC.isEmpty())) {
                byte[] bArr = new byte[iD];
                for (int i = 0; i < iD; i++) {
                    bArr[i] = -1;
                }
                int i2 = 0;
                int i3 = 0;
                for (qb0 qb0Var : listC) {
                    int i4 = i2 + 1;
                    if (qb0Var == qb0.VIBRATE) {
                        c(map.get(PSOProgramService.VS_Key), i2, bArr);
                        if (i3 == 0) {
                            c(map.get("v1"), i2, bArr);
                        } else if (i3 == 1) {
                            c(map.get("v2"), i2, bArr);
                        } else if (i3 == 2) {
                            c(map.get("v3"), i2, bArr);
                        }
                        i3++;
                    } else {
                        c(map.get(qb0Var.getRawValue()), i2, bArr);
                    }
                    i2 = i4;
                }
                if (!(iD == 0)) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= iD) {
                            z = true;
                            break;
                        }
                        if (!(bArr[i5] == -1)) {
                            break;
                        }
                        i5++;
                    }
                    if (!z) {
                        return new p60(nb0Var.getMac(), bArr);
                    }
                }
            }
        }
        return null;
    }

    public final void c(Integer num, int i, byte[] bArr) {
        if (num == null || i >= bArr.length) {
            return;
        }
        bArr[i] = (byte) num.intValue();
    }

    public final void d(Integer num, int i, int[] iArr) {
        if (num == null || i >= iArr.length) {
            return;
        }
        iArr[i] = num.intValue();
    }

    public final b90 e(nb0 nb0Var, Map<String, Integer> map) {
        if (!tb0.p(nb0Var)) {
            return null;
        }
        int[] iArrH = h(nb0Var, map, 5);
        if (iArrH != null) {
            z = !(iArrH.length == 0);
        }
        if (!z) {
            iArrH = null;
        }
        if (iArrH != null) {
            return new r60(nb0Var.getMac(), Arrays.copyOf(iArrH, iArrH.length));
        }
        return null;
    }

    public final b90 f(nb0 nb0Var, Map<String, Integer> map) {
        if (!tb0.q(nb0Var)) {
            return null;
        }
        int[] iArrH = h(nb0Var, map, 3);
        if (iArrH != null) {
            z = !(iArrH.length == 0);
        }
        if (!z) {
            iArrH = null;
        }
        if (iArrH != null) {
            return new s60(nb0Var.getMac(), Arrays.copyOf(iArrH, iArrH.length));
        }
        return null;
    }

    public final ArrayList<b90> g(nb0 nb0Var, Map<String, Integer> map) {
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        Integer num5;
        Integer num6;
        Integer num7;
        Integer num8;
        Integer num9;
        Integer num10;
        Integer num11;
        String mac = nb0Var.getMac();
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        FuncBean func = toyConfigInfoBeanG != null ? toyConfigInfoBeanG.getFunc() : null;
        ArrayList<b90> arrayList = new ArrayList<>();
        if (func == null) {
            return null;
        }
        if (func.getV() && (num11 = map.get(PSOProgramService.VS_Key)) != null) {
            arrayList.add(new w80(mac, num11.intValue()));
        }
        if (func.getV1() && (num10 = map.get("v1")) != null) {
            arrayList.add(new t80(mac, num10.intValue()));
        }
        if (func.getV2() && (num9 = map.get("v2")) != null) {
            arrayList.add(new u80(mac, num9.intValue()));
        }
        if (func.getV3() && (num8 = map.get("v3")) != null) {
            arrayList.add(new v80(mac, num8.intValue()));
        }
        if (func.getR()) {
            Integer num12 = map.get(StreamManagement.AckRequest.ELEMENT);
            if (num12 != null) {
                arrayList.add(new g70(mac, num12.intValue()));
            }
            Integer num13 = map.get("rl");
            if (num13 != null) {
                arrayList.add(new j70(mac, num13.intValue()));
            }
            Integer num14 = map.get("rr");
            if (num14 != null) {
                arrayList.add(new i70(mac, num14.intValue()));
            }
        }
        if (func.getP() && (num7 = map.get("p")) != null) {
            arrayList.add(new x40(mac, num7.intValue()));
        }
        if (func.getT() && (num6 = map.get("t")) != null) {
            arrayList.add(new p80(mac, num6.intValue()));
        }
        if (func.getS() && (num5 = map.get("s")) != null) {
            arrayList.add(new o80(mac, num5.intValue()));
        }
        if (func.getF() && (num4 = map.get("f")) != null) {
            arrayList.add(new n50(mac, num4.intValue()));
        }
        if (func.getD() && (num3 = map.get(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG)) != null) {
            arrayList.add(new h50(mac, num3.intValue()));
        }
        if (func.getA() && (num2 = map.get("a")) != null) {
            arrayList.add(new t60(mac, num2.intValue()));
        }
        if (func.getPos() && (num = map.get("pos")) != null) {
            arrayList.add(new m50(mac, num.intValue()));
        }
        return arrayList;
    }

    public final int[] h(nb0 nb0Var, Map<String, Integer> map, int i) {
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        List<List<String>> motors = toyConfigInfoBeanG != null ? toyConfigInfoBeanG.getMotors() : null;
        boolean z = false;
        if (motors == null || motors.isEmpty()) {
            return null;
        }
        int size = motors.size();
        if (size <= i) {
            i = size;
        }
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = -1;
        }
        Iterator<List<String>> it = motors.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int i4 = i3 + 1;
            Iterator<T> it2 = it.next().iterator();
            while (it2.hasNext()) {
                a.d(map.get((String) it2.next()), i3, iArr);
            }
            i3 = i4;
        }
        if (!(i == 0)) {
            int i5 = 0;
            while (true) {
                if (i5 >= i) {
                    z = true;
                    break;
                }
                if (!(iArr[i5] == -1)) {
                    break;
                }
                i5++;
            }
            if (!z) {
                return iArr;
            }
        }
        return null;
    }
}
