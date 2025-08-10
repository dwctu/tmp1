package dc;

import com.wear.bean.Toy;
import com.wear.bean.event.ToyCtrlGameEvent;
import com.wear.bean.event.ToyGserEvent;
import com.wear.main.toy.EditToyNameActivity;
import com.wear.main.toy.ToySettingActivity;
import com.wear.main.toy.pin.ToyPinSettingActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.xtremeprog.sdk.ble.BleRequest;
import dc.pb1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;

/* compiled from: BtCommand.java */
/* loaded from: classes3.dex */
public class jc1 {
    public static Map<String, LinkedHashMap<List<String>, int[]>> c = new HashMap();
    public qc1 a;
    public tc1 b;

    /* compiled from: BtCommand.java */
    public class a implements pb1.b {

        /* compiled from: BtCommand.java */
        /* renamed from: dc.jc1$a$a, reason: collision with other inner class name */
        public class RunnableC0190a implements Runnable {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;

            public RunnableC0190a(a aVar, String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                pc1.a.e(this.a, this.b);
            }
        }

        public a() {
        }

        @Override // dc.pb1.b
        public void a(String str, String str2, byte[] bArr) {
            String str3 = "send cmd changeResult: " + str2;
            if (Toy.isDeviceTypeMessage(str2.toLowerCase())) {
                lr1.a.f(str, str2);
                jc1.this.a.c(str, str2, true, null, 0, null);
                ve3.d().i(str);
                af3.c().b(str, str2, WearUtils.x);
                dq1.a(str);
                return;
            }
            if (ub1.g(str2)) {
                String strD = ub1.d(str2);
                if (tb1.h(strD)) {
                    return;
                }
                jc1.this.a.getA().a.postDelayed(new RunnableC0190a(this, str, strD), 200L);
                return;
            }
            if (!ub1.f(str2)) {
                jc1.b(str, str2, bArr);
                return;
            }
            String str4 = "changeResult: " + str2;
            int iC = ub1.c(str2);
            pc1.a.K().c(str, iC);
            wb0.a(new v20(str, iC));
        }

        @Override // dc.pb1.b
        public void b(String str, int i) {
        }

        @Override // dc.pb1.b
        public void c(String str, BleRequest.RequestType requestType, int i) {
            String str2 = "reconnectAndQueryBatter requestFailed: address=" + str + "  type=" + requestType;
            jc1.this.a.getB().v(str, requestType, i);
        }

        @Override // dc.pb1.b
        public void d(String str, String str2) {
        }

        @Override // dc.pb1.b
        public void e(String str, String str2, boolean z) {
            if (z) {
                jc1.this.a.s(str, 1, -1);
                me3.g();
            }
        }

        @Override // dc.pb1.b
        public void f(String str, int i) {
        }

        @Override // dc.pb1.b
        public void g(String str, int i) {
            pc1.a.x(str, i);
            EventBus.getDefault().post(new i30(str, i));
        }

        @Override // dc.pb1.b
        public void onConnectionStateChange(String str, int i, int i2) {
            pc1.a.U(str, i, i2);
        }
    }

    /* compiled from: BtCommand.java */
    public class b implements Runnable {
        public final /* synthetic */ Toy a;

        public b(Toy toy) {
            this.a = toy;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.a.isF01IsNotice() || this.a.isF01Off()) {
                return;
            }
            this.a.setF01IsNotice(false);
            if (eg3.e(WearUtils.x, eg3.a) == 0) {
                new ds3(MyApplication.H(), this.a).d(this.a.getSimpleName(), true);
            }
        }
    }

    public jc1(qc1 qc1Var) {
        new HashMap();
        this.a = qc1Var;
        this.b = tc1.h(this);
        d();
    }

    public static void b(String str, String str2, byte[] bArr) {
        if (WearUtils.e1(str2)) {
            return;
        }
        if (str2.startsWith("Light:")) {
            String strSubstring = str2.substring(str2.indexOf(SignatureImpl.INNER_SEP) + 1, str2.indexOf(";"));
            if (WearUtils.q1(strSubstring)) {
                sr1.f(str, Integer.parseInt(strSubstring), str2);
                return;
            }
            return;
        }
        if (str2.startsWith("Solo:")) {
            jr1.g(str, str2);
            return;
        }
        if (str2.startsWith("TchLvl:")) {
            jr1.h(str, str2);
            return;
        }
        if (str2.startsWith("GetAColor:")) {
            String strSubstring2 = str2.substring(str2.indexOf(SignatureImpl.INNER_SEP) + 1, str2.indexOf(";"));
            if (WearUtils.q1(strSubstring2)) {
                vr1.i(str, Integer.parseInt(strSubstring2), str2);
                return;
            }
            return;
        }
        if (Toy.isAiTypeMessage(str2.toLowerCase())) {
            iq1.h(str, str2);
            return;
        }
        if (Toy.isAgArrayMessage(str2.toLowerCase())) {
            iq1.m(str, str2);
            return;
        }
        if (str2.endsWith(EditToyNameActivity.f + ";")) {
            EventBus.getDefault().post(new ToyChangeNameEvent(str2.toLowerCase().equals("ok," + EditToyNameActivity.f + ";")));
            return;
        }
        if (str2.contains("POWEROFF")) {
            as1.b(str);
            return;
        }
        if (str2.endsWith(ToyPinSettingActivity.c + ";")) {
            if (str2.toLowerCase().startsWith("pinstatus")) {
                EventBus.getDefault().post(new z10(str, str2.toLowerCase().startsWith("pinstatus:1") ? 1 : 0));
                return;
            } else {
                EventBus.getDefault().post(new z10(str, -1));
                return;
            }
        }
        if (str2.endsWith(ToyPinSettingActivity.e + ";") || str2.endsWith(ToyPinSettingActivity.e)) {
            String str3 = "setPinStatusOn Result: " + str2;
            if (str2.toLowerCase().startsWith("ok")) {
                EventBus.getDefault().post(new b20(str, 1));
                return;
            } else {
                EventBus.getDefault().post(new b20(str, -1));
                return;
            }
        }
        if (str2.endsWith(ToyPinSettingActivity.d + ";") || str2.endsWith(ToyPinSettingActivity.d)) {
            String str4 = "SetPinStatusOff Result: " + str2;
            if (str2.toLowerCase().startsWith("ok")) {
                EventBus.getDefault().post(new b20(str, 0));
                return;
            } else {
                EventBus.getDefault().post(new b20(str, -1));
                return;
            }
        }
        if (Toy.isPin(str2)) {
            String[] strArrSplit = str2.replace(";", "").split(SignatureImpl.INNER_SEP);
            if (strArrSplit.length <= 1 || WearUtils.e1(strArrSplit[1])) {
                return;
            }
            EventBus.getDefault().post(new y10(str, strArrSplit[1]));
            return;
        }
        if (str2.endsWith(ToyPinSettingActivity.f + ";") || str2.endsWith(ToyPinSettingActivity.f)) {
            String str5 = "SetPin Result: " + str2;
            if (str2.toLowerCase().startsWith("ok")) {
                EventBus.getDefault().post(new a20(str, 1));
                return;
            } else {
                EventBus.getDefault().post(new a20(str, -1));
                return;
            }
        }
        if (str2.startsWith("AutoSwith")) {
            fq1.e(str, str2);
            return;
        }
        if (str2.startsWith("F01MD:")) {
            String strReplace = str2.trim().replace(";", "");
            String strSubstring3 = strReplace.substring(strReplace.indexOf(SignatureImpl.INNER_SEP) + 1);
            if ("2".equals(strSubstring3)) {
                ms1.k(str, true);
                return;
            } else {
                if ("1".equals(strSubstring3)) {
                    ms1.k(str, false);
                    return;
                }
                return;
            }
        }
        if (str2.startsWith("GetRBut:")) {
            String strReplace2 = str2.trim().replace(";", "");
            String strSubstring4 = strReplace2.substring(strReplace2.indexOf(SignatureImpl.INNER_SEP) + 1);
            Toy toyQ = pc1.a.Q(str);
            if (toyQ != null) {
                toyQ.setF01IsOff("0".equals(strSubstring4));
                if (MyApplication.H() != null) {
                    MyApplication.H().runOnUiThread(new b(toyQ));
                    return;
                }
                return;
            }
            return;
        }
        if (str2.startsWith("CAP")) {
            xr1.b(str, jf3.d(bArr, bArr.length));
            return;
        }
        if (str2.startsWith("unkown,GetCap")) {
            xr1.b(str, jf3.d(bArr, bArr.length));
            return;
        }
        if (str2.contains("F01th")) {
            if (str2.toLowerCase().startsWith("ok")) {
                EventBus.getDefault().post(new d40(str, 1));
                return;
            } else {
                EventBus.getDefault().post(new d40(str, 0));
                return;
            }
        }
        if (str2.startsWith("GetBkV:")) {
            String[] strArrSplit2 = str2.replace("GetBkV:", "").replace(";", "").split(SignatureImpl.INNER_SEP);
            EventBus.getDefault().post(new c40(str, Integer.parseInt(strArrSplit2[0]), Integer.parseInt(strArrSplit2[1])));
            return;
        }
        if ("BLOCKED;".equals(str2)) {
            ms1.b(str);
            return;
        }
        if (str2.startsWith("Evt:")) {
            EventBus.getDefault().post(new ToyCtrlGameEvent(21, str, str2));
            return;
        }
        if (str2.startsWith("Gser:")) {
            EventBus.getDefault().post(new ToyGserEvent(str, str2));
            return;
        }
        if (str2.startsWith(ToySettingActivity.k)) {
            String str6 = "changeResult: 查询炮机抬升状态=" + str2;
            if (str2.length() >= 6) {
                EventBus.getDefault().post(new b40(str, Integer.parseInt(str2.substring(str2.indexOf(SignatureImpl.INNER_SEP) + 1, str2.indexOf(SignatureImpl.INNER_SEP) + 2))));
                return;
            }
            return;
        }
        if (vi2.a.c(bArr)) {
            ArrayList arrayList = new ArrayList();
            for (byte b2 : bArr) {
                arrayList.add(Integer.valueOf(b2 & 255));
            }
            vi2.a.b(str, arrayList);
            return;
        }
        if (qd0.a(bArr).startsWith("aa")) {
            l10 l10VarD = m10.b.d(str, bArr);
            if (l10VarD != null) {
                EventBus.getDefault().post(l10VarD);
                return;
            }
            return;
        }
        if (str2.startsWith("stroke:")) {
            return;
        }
        String str7 = "changeResult: value=" + str2;
        pc1 pc1Var = pc1.a;
        pc1Var.M().c(str, str2);
        pc1Var.T(str, str2);
    }

    public void a(@NotNull String str) {
        this.b.g(str);
    }

    public final void c() {
        this.a.getA().q(new a());
        this.a.getA().k();
    }

    public void d() {
        c();
    }

    public boolean e(String str) {
        try {
            qb1 qb1VarE = this.a.getA().e(str);
            if (qb1VarE == null) {
                return false;
            }
            qb1VarE.e(str);
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void f(String str, String str2) throws NumberFormatException {
        LinkedHashMap<List<String>, int[]> linkedHashMap;
        int i;
        try {
            Toy toyQ = pc1.a.Q(str);
            if (toyQ != null && !WearUtils.e1(toyQ.getDeviceType())) {
                ArrayList arrayList = new ArrayList(Arrays.asList(str2.replace(";", "").split(SignatureImpl.INNER_SEP)));
                int i2 = 0;
                String str3 = arrayList.size() > 0 ? (String) arrayList.get(0) : "";
                if (Toy.TOY_COMMEND.contains(str3)) {
                    String deviceType = toyQ.getDeviceType();
                    String str4 = "deviceType===" + deviceType;
                    String str5 = "message==========" + str2;
                    if (c.containsKey(deviceType)) {
                        linkedHashMap = c.get(deviceType);
                        if (linkedHashMap == null) {
                            linkedHashMap = new LinkedHashMap<>();
                            c.put(deviceType, linkedHashMap);
                        }
                    } else {
                        linkedHashMap = new LinkedHashMap<>();
                        c.put(deviceType, linkedHashMap);
                    }
                    List<List<String>> motors = toyQ.getMotors();
                    int i3 = 0;
                    while (true) {
                        i = 4;
                        if (i3 >= motors.size()) {
                            break;
                        }
                        List<String> list = motors.get(i3);
                        if (!linkedHashMap.containsKey(list)) {
                            linkedHashMap.put(list, new int[4]);
                        } else if (linkedHashMap.get(list) == null) {
                            linkedHashMap.put(list, new int[4]);
                        }
                        i3++;
                    }
                    arrayList.remove(0);
                    ArrayList arrayList2 = new ArrayList(arrayList);
                    String str6 = Toy.TOY_COMPARE.get(str3);
                    if (WearUtils.e1(str6)) {
                        ArrayList arrayList3 = new ArrayList(linkedHashMap.keySet());
                        int i4 = 0;
                        while (i4 < arrayList2.size()) {
                            int i5 = Integer.parseInt((String) arrayList2.get(i4));
                            int[] iArr = linkedHashMap.get(arrayList3.get(i4));
                            if (iArr == null) {
                                iArr = new int[i];
                            }
                            String str7 = "value===" + i5;
                            if (i5 > 0 && i5 < 5) {
                                iArr[0] = iArr[0] + 1;
                            } else if (i5 >= 5 && i5 < 10) {
                                iArr[1] = iArr[1] + 1;
                            } else if (i5 >= 10 && i5 < 15) {
                                iArr[2] = iArr[2] + 1;
                            } else if (i5 < 15 || i5 > 20) {
                                System.out.println("数字不在任何区间内");
                            } else {
                                iArr[3] = iArr[3] + 1;
                            }
                            i4++;
                            i = 4;
                        }
                        return;
                    }
                    int i6 = 0;
                    while (i6 < motors.size()) {
                        if (motors.get(i6).contains(str6)) {
                            if ("p".equals(str6)) {
                                for (Map.Entry<List<String>, int[]> entry : linkedHashMap.entrySet()) {
                                    if (entry.getKey().contains(str6)) {
                                        int[] value = entry.getValue();
                                        if ("Level".equals(arrayList2.get(i2))) {
                                            int i7 = Integer.parseInt((String) arrayList2.get(arrayList2.size() - 1));
                                            if (i7 == 1) {
                                                value[1] = value[1] + 1;
                                            } else if (i7 == 2) {
                                                value[2] = value[2] + 1;
                                            } else if (i7 == 3) {
                                                value[3] = value[3] + 1;
                                            }
                                        }
                                    }
                                }
                            } else {
                                int i8 = Integer.parseInt((String) arrayList2.get(arrayList2.size() - 1));
                                String str8 = "value===" + i8;
                                for (Map.Entry<List<String>, int[]> entry2 : linkedHashMap.entrySet()) {
                                    if (entry2.getKey().contains(str6)) {
                                        int[] value2 = entry2.getValue();
                                        if (i8 > 0 && i8 < 5) {
                                            value2[i2] = value2[i2] + 1;
                                        } else if (i8 >= 5 && i8 < 10) {
                                            value2[1] = value2[1] + 1;
                                        } else if (i8 >= 10 && i8 < 15) {
                                            value2[2] = value2[2] + 1;
                                        } else if (i8 < 15 || i8 > 20) {
                                            System.out.println("数字不在任何区间内");
                                        } else {
                                            value2[3] = value2[3] + 1;
                                        }
                                    }
                                    i2 = 0;
                                }
                            }
                        }
                        i6++;
                        i2 = 0;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void g(String str) {
        for (Toy toy : pc1.a.P()) {
            if (!toy.isSupportV1V2() && str.toLowerCase().contains("vibrate1:")) {
                pc1.a.e(toy.getAddress(), str.toLowerCase().replace("vibrate1:", "Vibrate:"));
            } else if (toy.isSupportAir() || !str.toLowerCase().contains("Air:Level".toLowerCase())) {
                if (toy.isSupportR() || !str.toLowerCase().contains("Rotate".toLowerCase())) {
                    pc1.a.e(toy.getAddress(), str);
                }
            }
        }
    }

    public void h(String str, String str2) throws NumberFormatException {
        if (!tb1.h(str2) && str2.contains("vibrate")) {
            str2 = str2.replace("vibrate", "Vibrate");
        }
        if (!this.a.l(str)) {
            a(str);
            return;
        }
        if (WearUtils.B) {
            String str3 = "mySendToList: " + str + " == " + str2;
        }
        this.b.k(str, str2);
        f(str, str2);
    }

    public void i(String str, String str2) {
        if (!tb1.h(str2) && str2.contains("vibrate")) {
            str2 = str2.replace("vibrate", "Vibrate");
        }
        if (this.a.l(str)) {
            if (WearUtils.B && !str2.equals("Battery;")) {
                xe3.a("sendCommandNotAddToList", "SendToList: " + be3.m.format(Long.valueOf(System.currentTimeMillis())) + "  " + str + "==" + str2);
            }
            j(str, str2);
        }
    }

    public void j(String str, String str2) {
        try {
            qb1 qb1VarE = this.a.getA().e(str);
            if (qb1VarE != null) {
                qb1VarE.g(str2);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void k(rc1 rc1Var, zc1 zc1Var) {
        try {
            qb1 qb1VarE = this.a.getA().e(rc1Var.c());
            if (qb1VarE != null) {
                qb1VarE.h(rc1Var, zc1Var);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
