package dc;

import android.content.Context;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import com.wear.bean.ToyAlarm;
import com.wear.bean.ToyAlarm10Items;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.kn3;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smackx.offline.packet.OfflineMessageRequest;

/* compiled from: ToyAlarmUtils.java */
/* loaded from: classes4.dex */
public class xg3 {
    public static kn3 g;
    public static xg3 h;
    public boolean a = true;
    public boolean b = false;
    public String c = "";
    public HashMap<String, ToyAlarm> d = new HashMap<>();
    public List<ToyAlarm10Items> e = new ArrayList();
    public Map<String, String> f = new HashMap();

    /* compiled from: ToyAlarmUtils.java */
    public class a implements Runnable {
        public final /* synthetic */ Toy a;

        public a(xg3 xg3Var, Toy toy) {
            this.a = toy;
        }

        @Override // java.lang.Runnable
        public void run() {
            iq1.d(this.a.getAddress());
        }
    }

    /* compiled from: ToyAlarmUtils.java */
    public class b implements Runnable {

        /* compiled from: ToyAlarmUtils.java */
        public class a implements kn3.d {
            public a() {
            }

            @Override // dc.kn3.d
            public void doCancel() {
                xg3.this.q(false);
                xg3.this.f.clear();
            }

            @Override // dc.kn3.d
            public void doConfirm() {
                xg3.this.q(true);
                xg3.this.f.clear();
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (xg3.g == null || !xg3.g.isShowing()) {
                MyApplication myApplication = WearUtils.x;
                kn3 unused = xg3.g = new kn3((Context) MyApplication.H(), ah4.e(R.string.update_alarm_notice), ah4.e(R.string.common_ok), ah4.e(R.string.common_cancel), false, (kn3.d) new a());
                xg3.g.show();
            }
        }
    }

    /* compiled from: ToyAlarmUtils.java */
    public class c implements Runnable {
        public final /* synthetic */ Toy a;

        /* compiled from: ToyAlarmUtils.java */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                iq1.d(c.this.a.getAddress());
            }
        }

        public c(Toy toy) {
            this.a = toy;
        }

        @Override // java.lang.Runnable
        public void run() {
            String agString = this.a.getAgString();
            HashMap map = new HashMap();
            if (!WearUtils.e1(agString)) {
                String strReplace = agString.toLowerCase().replace("ag:", "").toLowerCase().replace(";", "");
                if (strReplace.length() > 0 && !strReplace.toLowerCase().contains("null")) {
                    for (int i = 0; i < strReplace.length(); i++) {
                        if (WearUtils.q1(String.valueOf(strReplace.charAt(i)))) {
                            int iIntValue = Integer.valueOf(String.valueOf(strReplace.charAt(i))).intValue();
                            map.put(Integer.valueOf(iIntValue), Integer.valueOf(iIntValue));
                        }
                    }
                }
            }
            int i2 = 1;
            for (ToyAlarm10Items toyAlarm10Items : xg3.this.e) {
                if (map.size() >= 10) {
                    break;
                }
                ToyAlarm toyAlarm = xg3.this.d.get(toyAlarm10Items.getAlarmId());
                HashMap<Integer, Integer> toyAlarmIndex = toyAlarm.getToyAlarmIndex(this.a.getAddress(), toyAlarm10Items.getAlarmTimes());
                if (toyAlarm10Items.getAlarmTimes() - be3.I().getTime() > 0) {
                    if (toyAlarmIndex.size() > 0) {
                        for (Map.Entry<Integer, Integer> entry : toyAlarmIndex.entrySet()) {
                            map.put(entry.getKey(), entry.getKey());
                            toyAlarm.addToyAlarmIndex(this.a.getAddress(), entry.getKey().intValue(), toyAlarm10Items.getAlarmTimes());
                            xg3.this.s(entry.getKey().intValue(), this.a.getAddress(), toyAlarm10Items, i2 * 160);
                            i2++;
                        }
                    }
                    int i3 = 0;
                    while (true) {
                        if (i3 > 9) {
                            break;
                        }
                        if (map.get(Integer.valueOf(i3)) == null) {
                            map.put(Integer.valueOf(i3), Integer.valueOf(i3));
                            toyAlarm.addToyAlarmIndex(this.a.getAddress(), i3, toyAlarm10Items.getAlarmTimes());
                            xg3.this.s(i3, this.a.getAddress(), toyAlarm10Items, i2 * 160);
                            i2++;
                            break;
                        }
                        i3++;
                    }
                }
            }
            WearUtils.x.l.postDelayed(new a(), 1000L);
        }
    }

    /* compiled from: ToyAlarmUtils.java */
    public class d implements Runnable {
        public final /* synthetic */ Toy a;

        /* compiled from: ToyAlarmUtils.java */
        public class a implements Runnable {

            /* compiled from: ToyAlarmUtils.java */
            /* renamed from: dc.xg3$d$a$a, reason: collision with other inner class name */
            public class RunnableC0229a implements Runnable {

                /* compiled from: ToyAlarmUtils.java */
                /* renamed from: dc.xg3$d$a$a$a, reason: collision with other inner class name */
                public class RunnableC0230a implements Runnable {
                    public RunnableC0230a() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        iq1.d(d.this.a.getAddress());
                    }
                }

                public RunnableC0229a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    d.this.a.setAiString("AI:" + xg3.this.c, false);
                    iq1.k(d.this.a.getAddress(), xg3.this.c);
                    WearUtils.x.l.postDelayed(new RunnableC0230a(), 200L);
                }
            }

            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                for (ToyAlarm10Items toyAlarm10Items : xg3.this.e) {
                    if (i > 9) {
                        break;
                    }
                    xg3.this.d.get(toyAlarm10Items.getAlarmId()).removeToyAlarmIndex(d.this.a.getAddress(), toyAlarm10Items.getAlarmTimes());
                    if (toyAlarm10Items.getAlarmTimes() - be3.I().getTime() > 0) {
                        d dVar = d.this;
                        xg3.this.s(i, dVar.a.getAddress(), toyAlarm10Items, r8 * 160);
                        i++;
                    }
                }
                WearUtils.x.l.postDelayed(new RunnableC0229a(), (i + 1) * 160);
            }
        }

        public d(Toy toy) {
            this.a = toy;
        }

        @Override // java.lang.Runnable
        public void run() {
            iq1.i(this.a.getAddress());
            WearUtils.x.l.postDelayed(new a(), 300L);
        }
    }

    /* compiled from: ToyAlarmUtils.java */
    public class e implements Runnable {
        public final /* synthetic */ ToyAlarm10Items a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public e(ToyAlarm10Items toyAlarm10Items, String str, int i) {
            this.a = toyAlarm10Items;
            this.b = str;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ToyAlarm toyAlarm = xg3.this.d.get(this.a.getAlarmId());
            if (toyAlarm == null || this.a.getAlarmTimes() <= 0 || this.a.getAlarmTimes() - be3.I().getTime() <= 0) {
                return;
            }
            iq1.l(this.b, this.c, 5, ((int) ((this.a.getAlarmTimes() - be3.I().getTime()) / 1000)) + 5, Long.valueOf(this.a.getAlarmTimes()).intValue());
            toyAlarm.addToyAlarmIndex(this.b, this.c, this.a.getAlarmTimes());
        }
    }

    public static xg3 i() {
        if (h == null) {
            h = new xg3();
        }
        return h;
    }

    public void f(String str, Calendar calendar, long j, boolean z) {
        if (WearUtils.e1(str) || calendar.getTimeInMillis() < 0) {
            return;
        }
        ToyAlarm toyAlarm = this.d.get(str);
        if (toyAlarm != null) {
            Iterator<ToyAlarm10Items> it = toyAlarm.getItems().iterator();
            while (it.hasNext()) {
                this.e.remove(it.next());
            }
            toyAlarm.createNext9Times(calendar);
        } else {
            toyAlarm = new ToyAlarm();
            toyAlarm.setAlarmId(str);
            toyAlarm.createNext9Times(calendar);
            toyAlarm.setAlarmLongTime(j);
            toyAlarm.setLocal(z);
            this.d.put(str, toyAlarm);
        }
        this.e.addAll(toyAlarm.getItems());
        Collections.sort(this.e);
        ArrayList<Toy> arrayListO = WearUtils.x.G().o();
        if (arrayListO == null || arrayListO.size() <= 0 || !this.a) {
            return;
        }
        Iterator<Toy> it2 = arrayListO.iterator();
        while (it2.hasNext()) {
            Toy next = it2.next();
            if (next != null && next.isConnected() && !WearUtils.e1(next.getAiString())) {
                if (!next.getAiString().toLowerCase().equals("ai:null")) {
                    if (!next.getAiString().startsWith("AI:" + h())) {
                        if (next.isTransfer()) {
                            p(next);
                        } else {
                            r(next);
                        }
                    }
                }
                p(next);
            }
        }
    }

    public void g() {
        this.d.clear();
        this.e.clear();
    }

    public String h() {
        return this.c;
    }

    public boolean j() {
        return this.a;
    }

    public void k(String str, String str2) {
        if (this.a) {
            if (this.b) {
                this.f.put(str, str2);
                return;
            }
            Toy toyQ = WearUtils.x.G().Q(str);
            if (!str2.toLowerCase().equals("ai:null")) {
                if (!str2.startsWith("AI:" + h())) {
                    this.f.put(str, str2);
                    o(toyQ);
                    return;
                }
            }
            p(toyQ);
        }
    }

    public void l(String str) {
        if (WearUtils.e1(str)) {
            return;
        }
        ToyAlarm toyAlarm = this.d.get(str);
        if (toyAlarm != null) {
            toyAlarm.deleteToyAlarm();
            Iterator<ToyAlarm10Items> it = toyAlarm.getItems().iterator();
            while (it.hasNext()) {
                this.e.remove(it.next());
            }
            ArrayList<Toy> arrayListO = WearUtils.x.G().o();
            if (arrayListO != null && arrayListO.size() > 0 && this.a) {
                Iterator<Toy> it2 = arrayListO.iterator();
                while (it2.hasNext()) {
                    Toy next = it2.next();
                    if (next != null && next.isConnected() && !WearUtils.e1(next.getAiString())) {
                        WearUtils.x.l.postDelayed(new a(this, next), 500L);
                    }
                }
            }
        }
        this.d.remove(str);
    }

    public void m() {
        String str = zt3.k;
        if (WearUtils.e1(str)) {
            str = OfflineMessageRequest.ELEMENT;
        }
        String strR0 = WearUtils.r0("TA" + str);
        String strH = eg3.h(WearUtils.x, strR0, "");
        if (WearUtils.e1(strH)) {
            strH = WearUtils.D(6);
            eg3.i(WearUtils.x, strR0, strH);
        }
        this.c = strH;
    }

    public void n(boolean z) {
        if (this.a) {
            this.b = z;
            if (z || this.f.size() <= 0) {
                return;
            }
            Iterator<Map.Entry<String, String>> it = this.f.entrySet().iterator();
            if (it.hasNext()) {
                o(WearUtils.x.G().Q(it.next().getKey()));
            }
        }
    }

    public final void o(Toy toy) {
        if (toy == null || this.e.size() <= 0 || !this.a) {
            return;
        }
        MyApplication myApplication = WearUtils.x;
        if (MyApplication.H() != null) {
            MyApplication myApplication2 = WearUtils.x;
            MyApplication.H().runOnUiThread(new b());
        }
    }

    public final void p(Toy toy) {
        if (toy == null || !toy.isConnected() || WearUtils.e1(toy.getAiString()) || this.e.size() <= 0) {
            return;
        }
        iq1.i(toy.getAddress());
        WearUtils.x.l.postDelayed(new d(toy), 200L);
    }

    public final void q(boolean z) {
        if (this.f.size() <= 0 || !this.a) {
            return;
        }
        Iterator<Map.Entry<String, String>> it = this.f.entrySet().iterator();
        while (it.hasNext()) {
            Toy toyQ = WearUtils.x.G().Q(it.next().getKey());
            if (toyQ != null) {
                toyQ.setTransfer(z);
                if (z) {
                    p(toyQ);
                } else {
                    r(toyQ);
                }
            }
        }
    }

    public final void r(Toy toy) {
        if (toy == null || !toy.isConnected() || this.e.size() <= 0 || WearUtils.e1(toy.getAiString())) {
            return;
        }
        iq1.d(toy.getAddress());
        WearUtils.x.l.postDelayed(new c(toy), 1000L);
    }

    public final void s(int i, String str, ToyAlarm10Items toyAlarm10Items, long j) {
        WearUtils.x.l.postDelayed(new e(toyAlarm10Items, str, i), j);
    }
}
