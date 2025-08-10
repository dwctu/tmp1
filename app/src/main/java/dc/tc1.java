package dc;

import com.wear.bean.Toy;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: CommandUtilInstance.java */
/* loaded from: classes3.dex */
public class tc1 implements zc1 {
    public static tc1 h;
    public Timer a = new Timer();
    public final Object b = new Object();
    public HashMap<String, ArrayList<rc1>> c = new HashMap<>();
    public boolean d = true;
    public List<String> e = new ArrayList();
    public String f = "";
    public String g = "";

    /* compiled from: CommandUtilInstance.java */
    public class a extends TimerTask {
        public final /* synthetic */ jc1 a;

        public a(jc1 jc1Var) {
            this.a = jc1Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            synchronized (tc1.this.b) {
                Iterator it = tc1.this.c.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    ArrayList arrayList = (ArrayList) entry.getValue();
                    String str = (String) entry.getKey();
                    int size = arrayList.size();
                    if (size > 0) {
                        rc1 rc1Var = (rc1) arrayList.remove(0);
                        ArrayList arrayList2 = new ArrayList();
                        rc1 rc1Var2 = rc1Var;
                        for (int i = 0; i < arrayList.size(); i++) {
                            rc1 rc1Var3 = (rc1) arrayList.get(i);
                            xe3.a("SendCommandToWrite", "SendToWrite newCommand: " + be3.m.format(Long.valueOf(System.currentTimeMillis())) + "  " + str + "==" + rc1Var.d() + "  " + rc1Var.e());
                            if (rc1Var.b(rc1Var3.e())) {
                                arrayList2.add(rc1Var3);
                                rc1Var2 = rc1Var3;
                            }
                        }
                        arrayList.removeAll(arrayList2);
                        if (WearUtils.B && pc1.a.a(str)) {
                            xe3.a("执行指令队列，发送指令=====", "SendToWrite: " + str + " == 发送的指令：" + rc1Var2.d() + " 原本该发送的指令=" + rc1Var.d() + "  size=" + size + "    list=" + arrayList.size());
                        }
                        if (!WearUtils.C) {
                            this.a.k(rc1Var2, tc1.this);
                        } else if (rc1Var2.b.contains("Rotate") || rc1Var2.b.contains("Vibrate") || rc1Var2.b.contains("Air")) {
                            tc1.this.e.add(rc1Var2.b);
                        }
                    }
                    if (size <= 0) {
                        it.remove();
                    }
                }
                tc1.this.b();
            }
        }
    }

    public tc1(jc1 jc1Var) {
        this.a.schedule(new a(jc1Var), 500L, 100L);
    }

    public static tc1 h(jc1 jc1Var) {
        if (h == null) {
            synchronized (tc1.class) {
                if (h == null) {
                    h = new tc1(jc1Var);
                }
            }
        }
        return h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(List list) throws NumberFormatException {
        String str;
        int i;
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (true) {
            str = "";
            if (!it.hasNext()) {
                break;
            }
            String[] strArrSplit = ((String) it.next()).split(SignatureImpl.INNER_SEP);
            if (strArrSplit.length == 2) {
                int i2 = Integer.parseInt(strArrSplit[1].replace(";", ""));
                if (i2 > 0) {
                    map.put(strArrSplit[0], i2 + "");
                }
            } else if (strArrSplit.length == 3 && (i = Integer.parseInt(strArrSplit[2].replace(";", ""))) > 0) {
                map.put(strArrSplit[0] + SignatureImpl.INNER_SEP + strArrSplit[1], i + "");
            }
        }
        if (!map.isEmpty()) {
            for (String str2 : map.keySet()) {
                str = str + str2 + SignatureImpl.INNER_SEP + ((String) map.get(str2)) + " | ";
            }
            if (!str.isEmpty()) {
                sg3.l(str);
            }
        }
        this.d = true;
    }

    @Override // dc.zc1
    public void a(rc1 rc1Var) {
        int iF;
        if (rc1Var == null || (iF = rc1Var.f()) >= 3) {
            return;
        }
        rc1Var.j(iF + 1);
        xe3.a("SendCommandToWrite", "sendSpecialCommandListen: " + rc1Var.c() + "== 发送的指令：" + rc1Var.d() + "   sendCount=" + rc1Var.f());
        l(rc1Var);
    }

    public final void b() {
        if (this.d && WearUtils.C && !this.e.isEmpty()) {
            this.d = false;
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.e);
            this.e.clear();
            MyApplication.N().l.postDelayed(new Runnable() { // from class: dc.hc1
                @Override // java.lang.Runnable
                public final void run() throws NumberFormatException {
                    this.a.j(arrayList);
                }
            }, 5000L);
        }
    }

    public void g(String str) {
        synchronized (this.b) {
            ArrayList<rc1> arrayList = this.c.get(str);
            if (arrayList != null) {
                Iterator<rc1> it = arrayList.iterator();
                while (it.hasNext()) {
                    rc1 next = it.next();
                    if (next != null && !next.h()) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void k(String str, String str2) {
        synchronized (this.b) {
            ArrayList<rc1> arrayList = this.c.get(str);
            Toy toyQ = pc1.a.Q(str);
            if (toyQ == null) {
                return;
            }
            if (toyQ.supportCommand(str2)) {
                if (toyQ.isQA01Toy()) {
                    if (str2.startsWith("Vibrate1:")) {
                        str2 = str2.replace("Vibrate1", "Vibrate2");
                    } else if (str2.startsWith("Vibrate2:")) {
                        str2 = str2.replace("Vibrate2", "Vibrate1");
                    }
                }
                rc1 rc1Var = new rc1(str2, str, this.f);
                this.f = str2;
                if (rc1Var.g()) {
                    if (!toyQ.canGetBattery()) {
                        return;
                    } else {
                        toyQ.setBatteryRequestTime(System.currentTimeMillis());
                    }
                }
                if (arrayList == null) {
                    ArrayList<rc1> arrayList2 = new ArrayList<>();
                    arrayList2.add(rc1Var);
                    this.c.put(str, arrayList2);
                } else {
                    if (arrayList.size() >= 4) {
                        ArrayList arrayList3 = new ArrayList();
                        for (int i = 0; i < arrayList.size(); i++) {
                            rc1 rc1Var2 = arrayList.get(i);
                            if (rc1Var.b(rc1Var2.e())) {
                                arrayList3.add(rc1Var2);
                            }
                        }
                        arrayList.removeAll(arrayList3);
                    } else if (arrayList.size() > 0) {
                        rc1 rc1Var3 = arrayList.get(arrayList.size() - 1);
                        if (rc1Var3.e() != 0 && rc1Var3.e() == rc1Var.e()) {
                            arrayList.remove(rc1Var3);
                        }
                    }
                    if (arrayList.size() < 10 || m(rc1Var.b) || rc1Var.b.startsWith("aa")) {
                        arrayList.add(rc1Var);
                    }
                }
            }
        }
    }

    public void l(rc1 rc1Var) {
        synchronized (this.b) {
            String strC = rc1Var.c();
            ArrayList<rc1> arrayList = this.c.get(strC);
            if (pc1.a.Q(strC) == null) {
                return;
            }
            if (arrayList == null) {
                ArrayList<rc1> arrayList2 = new ArrayList<>();
                arrayList2.add(rc1Var);
                this.c.put(strC, arrayList2);
            } else {
                if (arrayList.size() > 0) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (rc1Var.a(arrayList.get(i).d())) {
                            return;
                        }
                    }
                }
                arrayList.add(0, rc1Var);
            }
        }
    }

    public boolean m(String str) {
        if (str.equals("Multiply:0:0;") && this.g.equals(str)) {
            this.g = str;
            return true;
        }
        if (str.equals("Mply:0:0:0;") && this.g.equals(str)) {
            this.g = str;
            return true;
        }
        if (str.equals("Rotate:0;") && this.g.equals(str)) {
            this.g = str;
            return true;
        }
        if (str.equals("Air:Level:0;") && this.g.equals(str)) {
            this.g = str;
            return true;
        }
        if (str.equals("Vibrate:0;") && this.g.equals(str)) {
            this.g = str;
            return true;
        }
        if (str.equals("Vibrate1:0;") && this.g.equals(str)) {
            this.g = str;
            return true;
        }
        if (str.equals("Vibrate2:0;") && this.g.equals(str)) {
            this.g = str;
            return true;
        }
        if (str.equals("Vibrate3:0;") && this.g.equals(str)) {
            this.g = str;
            return true;
        }
        if (str.equals("Thrusting:0;") && this.g.equals(str)) {
            this.g = str;
            return true;
        }
        this.g = str;
        return false;
    }
}
