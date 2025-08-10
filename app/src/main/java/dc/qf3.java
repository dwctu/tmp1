package dc;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.LruCache;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.lovense.wear.R;
import com.wear.bean.Pattern;
import com.wear.bean.Toy;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.ui.discover.speedMode.SpeedModeControl;
import com.wear.ui.home.pattern.control.PatternPlayManagerImpl;
import com.wear.ui.home.sound.SoundPlayControl;
import com.wear.util.WearUtils;
import com.wear.widget.control.TouchControlView;
import dc.ToyControlBuilder;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function2;
import org.greenrobot.eventbus.EventBus;

/* compiled from: PatternPlayUtil.java */
/* loaded from: classes4.dex */
public class qf3 {
    public static boolean a;
    public static String b;
    public static String c;
    public static ff3 d;
    public static d e;
    public static Timer f;
    public static String g;
    public static int h;
    public static Object i;
    public static int j;
    public static Pattern k;
    public static String[] l;
    public static String m = WearUtils.I0(0);

    /* compiled from: PatternPlayUtil.java */
    public class a extends ff3 {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // dc.ff3
        public void b(boolean z, Object obj) {
            if (z) {
                qf3.r(((File) obj).getPath(), this.a);
            }
        }
    }

    /* compiled from: PatternPlayUtil.java */
    public class b extends TimerTask {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() throws NumberFormatException {
            if (!qf3.a) {
                if (qf3.f != null) {
                    qf3.s();
                    qf3.f.cancel();
                    return;
                }
                return;
            }
            if (qf3.l == null || qf3.j + 1 >= qf3.l.length) {
                int unused = qf3.j = 0;
                qf3.C();
                if (qf3.d != null) {
                    qf3.d.c(false, 0, PSOProgramService.VS_Key);
                    return;
                }
                return;
            }
            if (qf3.a) {
                String str = qf3.l[qf3.j];
                if (!WearUtils.e1(str) && qf3.a) {
                    xe3.a("PatternPlayUtil", "pattern 数据：" + str);
                    if (qf3.k.getHead() == null) {
                        try {
                            float f = Float.parseFloat(str);
                            if (qf3.h == 0 || qf3.h == 2) {
                                rq1.d.e((int) f, new ToyControlBuilder(true, true, false));
                            }
                            if ((qf3.h == 1 || qf3.h == 2) && qf3.d != null) {
                                qf3.d.c(true, Integer.valueOf(((int) f) / 5), PSOProgramService.VS_Key);
                            }
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    } else {
                        if ((qf3.h == 0 || qf3.h == 2) && !TextUtils.isEmpty(str) && qf3.a) {
                            if (mp1.h()) {
                                String function = qf3.k.getHead().getFunction();
                                if (TextUtils.equals(PSOProgramService.VS_Key, function) || TextUtils.equals("t", function) || TextUtils.equals("s", function)) {
                                    qf3.k.getHead().setFunction("v,t,s");
                                    function = "v,t,s";
                                }
                                if (TextUtils.equals("v,t,s", function) && str.split(",").length == 1) {
                                    str = str + "," + str + "," + str;
                                }
                                ToyControlBuilder toyControlBuilder = new ToyControlBuilder(false, true, true, ToyControlBuilder.a.SPEED);
                                final String str2 = this.a;
                                toyControlBuilder.f(new Function2() { // from class: dc.tc3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return Boolean.valueOf(((Toy) obj).isBAToy() && str2.contains("pos"));
                                    }
                                });
                                wq1.a(str, qf3.k, toyControlBuilder);
                                if ((qf3.h == 1 || qf3.h == 2) && qf3.d != null) {
                                    qf3.d.c(true, str, qf3.k.getHead().getFunction());
                                }
                                qf3.g();
                                if (qf3.j % 10 == 0) {
                                    qf3.l();
                                    return;
                                }
                                return;
                            }
                            for (Toy toy : WearUtils.x.G().P()) {
                                if (!toy.isBAToy() || !this.a.contains("pos")) {
                                    List<String> listCreateCommands = qf3.k.getHead().createCommands(str);
                                    if (qf3.h == 0) {
                                        pc1.a.m0(toy, qf3.k.isSystemPattern(), listCreateCommands, false, true, false, true);
                                    } else {
                                        pc1.a.m0(toy, qf3.k.isSystemPattern(), listCreateCommands, false, true, true, true);
                                    }
                                }
                            }
                        }
                        if ((qf3.h == 1 || qf3.h == 2) && qf3.d != null) {
                            qf3.d.c(true, str, qf3.k.getHead().getFunction());
                        }
                    }
                }
                qf3.g();
                if (qf3.j % 10 == 0) {
                    qf3.l();
                }
            }
        }
    }

    /* compiled from: PatternPlayUtil.java */
    public class c implements Consumer<Long> {
        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Long l) throws Exception {
            WearUtils.x.G().u0();
        }
    }

    /* compiled from: PatternPlayUtil.java */
    public interface d {
        void a();
    }

    public static void A(String str, boolean z, String str2, String str3, ff3 ff3Var) {
        y(str, z, 0, str2, str3, null, ff3Var);
    }

    public static void B(Pattern pattern, int i2, ff3 ff3Var) {
        if (pattern == null) {
            return;
        }
        Pattern.CACHE.put(pattern.getId(), pattern);
        y(pattern.getFile().getPath(), true, i2, null, pattern.getId(), null, ff3Var);
    }

    @SuppressLint({"CheckResult"})
    public static void C() {
        if (a) {
            Observable.timer(200L, TimeUnit.MILLISECONDS).subscribe(new c());
        }
        s();
        a = false;
        l();
        m();
        if (WearUtils.e1(c) || !db2.A().F()) {
            return;
        }
        qk2.q(c, 0);
    }

    public static /* synthetic */ int g() {
        int i2 = j;
        j = i2 + 1;
        return i2;
    }

    public static void l() {
        if (d != null) {
            String strI0 = WearUtils.I0((int) (j * 0.1d));
            m = strI0;
            ff3 ff3Var = d;
            boolean z = a;
            Object obj = i;
            String[] strArr = l;
            long length = 0;
            if (strArr != null && strArr.length != 0) {
                length = strArr.length / 10;
            }
            ff3Var.d(z, obj, null, strI0, length);
        }
    }

    public static synchronized void m() {
        if (f != null) {
            a = false;
            h12.D.playPatternPause = false;
            f.cancel();
        }
    }

    public static boolean n(String str, String str2) {
        if (!a || WearUtils.e1(b) || WearUtils.e1(str) || !b.equals(str)) {
            return false;
        }
        if (WearUtils.e1(g)) {
            return WearUtils.e1(str2);
        }
        if (WearUtils.e1(str2)) {
            return false;
        }
        return g.equals(str2);
    }

    public static String o() {
        return g;
    }

    public static String p() {
        return m;
    }

    public static synchronized void r(String str, String str2) {
        final String strN1 = WearUtils.N1(str);
        if (!TextUtils.isEmpty(strN1) && !strN1.contains("result")) {
            a = true;
            h12.D.playPatternPause = true;
            if (MusicControl.h0().O()) {
                EventBus.getDefault().post(h12.D);
            }
            if (!PatternPlayManagerImpl.O().d0()) {
                PatternPlayManagerImpl.O().D0();
            }
            if (SpeedModeControl.C().K()) {
                SpeedModeControl.C().N();
            }
            if (SoundPlayControl.M().a && !SoundPlayControl.M().b) {
                SoundPlayControl.M().U();
            }
            if (ll3.E().I()) {
                ll3.E().V();
            }
            l();
            try {
                Timer timer = f;
                if (timer != null) {
                    timer.cancel();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            f = new Timer();
            j = 0;
            LruCache<String, Pattern> lruCache = Pattern.CACHE;
            Pattern pattern = lruCache.get(str2);
            k = pattern;
            if (pattern == null) {
                Pattern patternK = xe2.L0().K(str2);
                k = patternK;
                if (patternK != null) {
                    lruCache.put(str2, patternK);
                }
            }
            if (k == null) {
                k = new Pattern();
            }
            k.setData(strN1);
            String str3 = "data数据====" + strN1;
            if (k.getHead() == null) {
                l = k.getData().split(",");
            } else {
                l = k.getData().split(TouchControlView.P);
                Toy.TOY_XMACHINE.equalsIgnoreCase(k.getHead().getToys());
                k.getHead().getFunction();
            }
            d dVar = e;
            if (dVar != null) {
                dVar.a();
            }
            gk2.e().i(k, strN1, h);
            if (strN1.contains("pos")) {
                se0.g(new Runnable() { // from class: dc.uc3
                    @Override // java.lang.Runnable
                    public final void run() {
                        gk2.e().h(qf3.k, strN1, 100, qf3.j, qf3.h == 0);
                    }
                }, 200L);
            }
            f.schedule(new b(strN1), 100L, 100L);
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        sg3.h(R.string.file_notfound);
    }

    public static void s() {
        m = WearUtils.I0(0);
    }

    public static void t(Object obj) {
        i = obj;
    }

    public static void u(int i2) {
        j = i2;
    }

    public static void v(Object obj, ff3 ff3Var) {
        i = obj;
        d = ff3Var;
    }

    public static void w(String str) {
        g = str;
    }

    public static void x(d dVar) {
        e = dVar;
    }

    public static void y(String str, boolean z, int i2, String str2, String str3, Object obj, ff3 ff3Var) {
        xe3.a("PatternPlayUtil", "startPlay: isPlaying-" + a + "  path:" + str + "  lastPath:" + b);
        if (WearUtils.e1(str)) {
            j = 0;
            C();
        }
        if (a || !str.equals(b) || (!WearUtils.e1(g) && !WearUtils.e1(str2) && !g.equals(str2))) {
            j = 0;
            C();
        }
        b = str;
        h = i2;
        g = str2;
        i = obj;
        d = ff3Var;
        if (z) {
            r(str, str3);
        } else {
            WearUtils.E0(true, str, new a(str3));
        }
    }

    public static void z(String str, boolean z, String str2, ff3 ff3Var) {
        y(str, z, 0, str2, "", null, ff3Var);
    }
}
