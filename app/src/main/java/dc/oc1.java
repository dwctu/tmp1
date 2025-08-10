package dc;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.wear.bean.Toy;
import com.wear.main.longDistance.control.ChatGroupControl;
import com.wear.main.longDistance.control.ChatSyncControl;
import com.wear.main.longDistance.control.ChatVideoControl;
import com.wear.ui.home.remote.RemoteControl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: BtWaggle.java */
/* loaded from: classes3.dex */
public class oc1 {
    public pc1 a;
    public int d;
    public int e;
    public int f;
    public int g;
    public final Set<yc1> c = new CopyOnWriteArraySet();
    public int h = 0;
    public a i = new a(this, null);
    public Handler b = new Handler();

    /* compiled from: BtWaggle.java */
    public class a implements Runnable {
        public String a;

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(List list) {
            oc1.this.t(this.a, list);
        }

        @Override // java.lang.Runnable
        public void run() {
            final ArrayList arrayList = new ArrayList();
            arrayList.add(0);
            oc1.this.t(this.a, arrayList);
            oc1.this.b.postDelayed(new Runnable() { // from class: dc.ec1
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b(arrayList);
                }
            }, 100L);
        }

        public /* synthetic */ a(oc1 oc1Var, nc1 nc1Var) {
            this();
        }
    }

    public oc1(pc1 pc1Var) {
        this.a = pc1Var;
    }

    public void a(yc1 yc1Var) {
        this.c.add(yc1Var);
    }

    public boolean b(int i) {
        boolean z = (i == 0 && this.h == 0 && this.g == 0 && this.f == 0 && this.e == 0 && this.d == 0) ? false : i != 0 || (this.h == 0 && this.g == 0);
        this.d = this.e;
        this.e = this.f;
        this.f = this.g;
        this.g = this.h;
        this.h = i;
        return z;
    }

    public void c(String str, String str2) {
        if (!tb1.h(str2) && str2.startsWith("G") && str2.length() == 14) {
            o(str, str2);
            return;
        }
        if (str2.startsWith("M:S")) {
            m(str, str2);
            return;
        }
        if (str2.startsWith("CurVib:")) {
            r(str, str2);
            return;
        }
        if (str2.startsWith("V01:D")) {
            p(str, str2);
            return;
        }
        if (str2.startsWith("BT") || str2.startsWith("MirLife")) {
            n(str, str2);
        } else {
            if (tb1.h(str2) || !str2.startsWith("H:")) {
                return;
            }
            q(str, str2);
        }
    }

    public void d(Toy toy) {
        if (toy == null) {
            return;
        }
        xe3.a("send", "endGame:" + toy.getAddress());
        ms1.g(toy);
    }

    public void e(Toy toy) {
        if (toy == null) {
            return;
        }
        xe3.a("send", "endMirr:" + toy.getAddress());
        ms1.h(toy);
    }

    public void f(Toy toy) {
        if (toy == null) {
            return;
        }
        xe3.a("send", "endMoveWaggle:" + toy.getAddress());
        if (toy.isV01Toy() || toy.isT01Toy() || toy.isH01Toy() || toy.isBAToy()) {
            ms1.i(toy.getAddress());
            return;
        }
        if (toy.isF01Toy()) {
            ms1.i(toy.getAddress());
            return;
        }
        if (toy.getVersion() == null) {
            ms1.i(toy.getAddress());
            ms1.j(toy.getAddress());
        } else if (toy.getVersion().intValue() >= 100) {
            ms1.i(toy.getAddress());
        } else {
            ms1.j(toy.getAddress());
        }
    }

    public final int g(String str) {
        int iRound = (int) Math.round(Math.abs(Math.sqrt((Math.pow(j(str.substring(1, 3)) * 0.0625f, 2.0d) + Math.pow(j(str.substring(5, 7)) * 0.0625f, 2.0d)) + Math.pow(j(str.substring(9, 11)) * 0.0625f, 2.0d)) - 4.0d));
        if (iRound < 0) {
            iRound = 0;
        }
        if (iRound > 4) {
            return 4;
        }
        return iRound;
    }

    public int h(String str) throws NumberFormatException {
        String[] strArrSplit = str.replace(";", "").split(",");
        int i = 0;
        if (strArrSplit != null && strArrSplit.length > 0) {
            try {
                i = Integer.parseInt(strArrSplit[0].substring(strArrSplit[0].indexOf(ExifInterface.LATITUDE_SOUTH) + 1));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        System.out.println("rsi:" + str + " speed:" + i);
        return i;
    }

    public int i(String str) {
        String[] strArrSplit = str.replace("V01:D", "").split(";");
        if (strArrSplit.length > 0) {
            return Integer.valueOf(strArrSplit[0]).intValue();
        }
        return 0;
    }

    public final int j(String str) {
        int iIntValue = Integer.valueOf(str, 16).intValue();
        return iIntValue > 127 ? iIntValue + InputDeviceCompat.SOURCE_ANY : iIntValue;
    }

    public int k(String str) {
        String[] strArrSplit = str.replace("CurVib:", "").split(";");
        if (strArrSplit.length > 0) {
            return Integer.valueOf(strArrSplit[0]).intValue();
        }
        return 0;
    }

    public void l(Toy toy) {
        if (toy == null) {
            return;
        }
        xe3.a("send", "openMirr:" + toy.getAddress());
        ms1.d(toy);
    }

    public void m(String str, String str2) {
        int iH = h(str2);
        String str3 = "checkWaggle: M:Slevel值=" + iH;
        if (b(iH)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(iH));
            t(str, arrayList);
            this.b.removeCallbacks(this.i);
            return;
        }
        if (iH == 0) {
            a aVar = this.i;
            aVar.a = str;
            this.b.removeCallbacks(aVar);
            this.b.postDelayed(this.i, 500L);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Integer.valueOf(iH));
        t(str, arrayList2);
        this.b.removeCallbacks(this.i);
    }

    public void n(String str, String str2) {
        r32.l().r(str, str2);
    }

    public void o(String str, String str2) {
        int iG = g(str2);
        String str3 = "checkWaggle: getLevel=" + iG;
        if (b(iG)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(iG));
            t(str, arrayList);
        }
    }

    public void p(String str, String str2) {
        int i = i(str2);
        if (b(i)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(i));
            t(str, arrayList);
            this.b.removeCallbacks(this.i);
            return;
        }
        if (i == 0) {
            a aVar = this.i;
            aVar.a = str;
            this.b.removeCallbacks(aVar);
            this.b.postDelayed(this.i, 500L);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Integer.valueOf(i));
        t(str, arrayList2);
        this.b.removeCallbacks(this.i);
    }

    public void q(String str, String str2) {
        String[] strArrSplit = str2.replace(";", "").split(SignatureImpl.INNER_SEP);
        if (strArrSplit.length == 3) {
            LinkedList linkedList = new LinkedList();
            Toy toyQ = pc1.a.Q(str);
            if (toyQ != null && (toyQ.isH01Toy() || toyQ.isBAToy())) {
                int i = Integer.parseInt(strArrSplit[1]);
                for (int i2 = 1; i2 < strArrSplit.length; i2++) {
                    linkedList.add(Integer.valueOf(i));
                }
            }
            if (ChatSyncControl.N0().p.e || RemoteControl.j().a || ChatGroupControl.o1().z() || ChatVideoControl.a1().o.e) {
                t(str, linkedList);
            }
        }
    }

    public void r(String str, String str2) {
        int iK = k(str2);
        if (b(iK)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(iK));
            t(str, arrayList);
            this.b.removeCallbacks(this.i);
            return;
        }
        if (iK == 0) {
            a aVar = this.i;
            aVar.a = str;
            this.b.removeCallbacks(aVar);
            this.b.postDelayed(this.i, 500L);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Integer.valueOf(iK));
        t(str, arrayList2);
        this.b.removeCallbacks(this.i);
    }

    public void s(yc1 yc1Var) {
        this.c.remove(yc1Var);
    }

    public void t(String str, List<Integer> list) {
        xe3.a("Toylevel", str + " " + list);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list == null) {
            return;
        }
        if (list.size() == 1) {
            int i = 0;
            int iIntValue = list.get(0).intValue();
            int iIntValue2 = list.get(0).intValue();
            Toy toyQ = this.a.Q(str);
            if (toyQ == null) {
                String str2 = "address:" + str + " == null";
                return;
            }
            if (toyQ.isT01Toy()) {
                if (iIntValue != 0) {
                    if (iIntValue == 1) {
                        i = 6;
                        iIntValue = 2;
                    } else if (iIntValue != 2) {
                        i = 20;
                        iIntValue = 4;
                    } else {
                        i = 13;
                        iIntValue = 3;
                    }
                }
            } else if (toyQ.isF01Toy()) {
                iIntValue /= 5;
                i = iIntValue2;
            } else {
                i = iIntValue2 * 5;
            }
            arrayList.add(Integer.valueOf(i));
            arrayList2.add(Integer.valueOf(iIntValue));
        } else {
            for (Integer num : list) {
                int iCeil = (int) Math.ceil(num.intValue() / 5.0f);
                arrayList.add(num);
                arrayList2.add(Integer.valueOf(iCeil));
            }
        }
        Iterator<yc1> it = this.c.iterator();
        while (it.hasNext()) {
            try {
                it.next().j(str, arrayList, arrayList2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void u(Toy toy) {
        if (toy == null) {
            return;
        }
        xe3.a("send", "startGame:" + toy.getAddress());
        ms1.c(toy);
    }

    public void v(Toy toy) {
        if (toy == null) {
            return;
        }
        toy.getType().toLowerCase();
        if (toy.isF01Toy()) {
            ms1.l(toy.getAddress());
            ms1.k(toy.getAddress(), true);
        } else if (toy.getVersion().intValue() >= 100) {
            ms1.i(toy.getAddress());
        } else {
            ms1.j(toy.getAddress());
        }
    }

    public void w(Toy toy) {
        if (toy == null) {
            return;
        }
        xe3.a("send", "startMoveWaggle:" + toy.getAddress());
        if (toy.isV01Toy() || toy.isT01Toy() || toy.isH01Toy() || toy.isBAToy()) {
            ms1.e(toy.getAddress());
            return;
        }
        if (toy.isF01Toy()) {
            ms1.e(toy.getAddress());
            ms1.k(toy.getAddress(), true);
        } else if (toy.getVersion() != null && toy.getVersion().intValue() >= 100) {
            ms1.e(toy.getAddress());
        } else {
            ms1.a(toy.getAddress());
            ms1.f(toy.getAddress());
        }
    }
}
