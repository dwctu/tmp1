package dc;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lovense.wear.R;
import com.wear.bean.Pattern;
import com.wear.bean.PatternHead;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import dc.kn3;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: PatternUtils.java */
/* loaded from: classes4.dex */
public class rf3 {
    public static final List<String> a = new a();
    public static final List<String> b = new b();
    public static final List<String> c = new c();
    public static final Map<String, String> d = new d();
    public static kn3 e;

    /* compiled from: PatternUtils.java */
    public class a extends ArrayList<String> {
        public a() {
            add("Pulse");
            add("Wave");
            add("Fireworks");
            add("Earthquake");
        }
    }

    /* compiled from: PatternUtils.java */
    public class b extends ArrayList<String> {
        public b() {
            add("Pulse_500");
            add("Wave_500");
            add("Fireworks_500");
            add("Earthquake_500");
        }
    }

    /* compiled from: PatternUtils.java */
    public class c extends ArrayList<String> {
        public c() {
            add("activity_pattern_1");
            add("activity_pattern_2");
            add("activity_pattern_3");
            add("activity_pattern_4");
            add("activity_pattern_5");
        }
    }

    /* compiled from: PatternUtils.java */
    public class d extends HashMap {
        public d() {
            put("Pulse", "pattern_pulse");
            put("Wave", "pattern_wave");
            put("Fireworks", "pattern_fireworks");
            put("Earthquake", "pattern_earthquake");
            put("Pulse_500", "pulse_500");
            put("Wave_500", "wave_500");
            put("Fireworks_500", "fireworks_500");
            put("Earthquake_500", "earthquake_500");
            put("activity_pattern_1", "activity_pattern_1");
            put("activity_pattern_2", "activity_pattern_2");
            put("activity_pattern_3", "activity_pattern_3");
            put("activity_pattern_4", "activity_pattern_4");
            put("activity_pattern_5", "activity_pattern_5");
            put("new_year_count_down", "new_year_count_down");
            put("new_year_pattern", "new_year_pattern");
        }
    }

    /* compiled from: PatternUtils.java */
    public class e implements zn2<String> {
        public final /* synthetic */ h a;

        public e(h hVar) {
            this.a = hVar;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            boolean z = false;
            if (WearUtils.e1(str)) {
                sg3.h(R.string.patterns_result_update_name_failed);
                h hVar = this.a;
                if (hVar != null) {
                    hVar.a(false, "0");
                    return;
                }
                return;
            }
            NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class);
            if (normalResponse == null) {
                sg3.h(R.string.patterns_result_update_name_failed);
                h hVar2 = this.a;
                if (hVar2 != null) {
                    hVar2.a(false, "0");
                    return;
                }
                return;
            }
            if (normalResponse.isResult()) {
                z = true;
            } else {
                MyApplication myApplication = WearUtils.x;
                rf3.q(MyApplication.H(), normalResponse.getMessage());
            }
            h hVar3 = this.a;
            if (hVar3 != null) {
                hVar3.a(z, normalResponse.getCode());
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            sg3.l(netException.getMessage());
            h hVar = this.a;
            if (hVar != null) {
                hVar.a(false, "0");
            }
        }
    }

    /* compiled from: PatternUtils.java */
    public class f implements Runnable {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;

        public f(Activity activity, String str) {
            this.a = activity;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            rf3.e();
            kn3 unused = rf3.e = new kn3((Context) this.a, this.b, ah4.e(R.string.common_ok), false, false, (kn3.d) null);
            rf3.e.show();
            rf3.e.n();
        }
    }

    /* compiled from: PatternUtils.java */
    public class g implements zn2<String> {
        public final /* synthetic */ i a;

        public g(i iVar) {
            this.a = iVar;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            this.a.onSuccess(str);
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            this.a.onError(netException);
        }
    }

    /* compiled from: PatternUtils.java */
    public interface h {
        void a(boolean z, String str);
    }

    /* compiled from: PatternUtils.java */
    public interface i {
        void onError(NetException netException);

        void onSuccess(String str);
    }

    public static boolean c(String str) {
        xe2.L0().g(xe2.r, "选择模式：" + str);
        Pattern patternK = xe2.L0().K(str);
        if (patternK == null) {
            return false;
        }
        patternK.setData(WearUtils.N1(patternK.getFile().getPath()));
        return patternK.isCheckMd5();
    }

    public static Pattern d(String str) {
        Pattern pattern = new Pattern(g(str));
        pattern.setName(str);
        pattern.setAuthor("system");
        pattern.setCreator("system");
        pattern.setEmail(zt3.k);
        pattern.setFavorite(false);
        pattern.setTimer("01:30");
        pattern.setData(WearUtils.N1(pattern.getFile().getPath()));
        pattern.setCreated(be3.I());
        pattern.setToyFunc(PSOProgramService.VS_Key);
        pattern.setEncrypt(true);
        return pattern;
    }

    public static void e() {
        kn3 kn3Var = e;
        if (kn3Var != null) {
            kn3Var.dismiss();
            e = null;
        }
    }

    public static List<Pattern> f() {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = c.iterator();
        while (it.hasNext()) {
            arrayList.add(d(it.next()));
        }
        return arrayList;
    }

    public static String g(String str) {
        return !WearUtils.e1(str) ? WearUtils.B(d.get(str)) : "";
    }

    public static Pattern h(String str, List<Pattern> list) {
        if (!WearUtils.e1(str)) {
            for (Pattern pattern : list) {
                if (!WearUtils.e1(pattern.getId()) && g(str).equals(pattern.getId())) {
                    return pattern;
                }
            }
        }
        return null;
    }

    public static String i(String str) {
        if (WearUtils.e1(d.get(str))) {
            return "";
        }
        return WearUtils.T("pattern") + File.separator + g(str);
    }

    public static ArrayList<Pattern> j() {
        ArrayList<Pattern> arrayList = new ArrayList<>();
        Iterator<String> it = a.iterator();
        while (it.hasNext()) {
            arrayList.add(d(it.next()));
        }
        return arrayList;
    }

    public static ArrayList<Pattern> k() {
        ArrayList<Pattern> arrayList = new ArrayList<>();
        Iterator<String> it = b.iterator();
        while (it.hasNext()) {
            arrayList.add(d(it.next()));
        }
        return arrayList;
    }

    public static void l(boolean z) {
        try {
            AssetManager assets = WearUtils.x.getAssets();
            for (Map.Entry<String, String> entry : d.entrySet()) {
                if (!WearUtils.e1(i(entry.getKey()))) {
                    WearUtils.r(assets.open(entry.getValue()), new File(i(entry.getKey())));
                    xe2.L0().e(d(entry.getKey()));
                }
            }
            if (WearUtils.y.u() != null && z) {
                xe2.L0().x(ch3.n().r());
            } else if (MyApplication.Z) {
                xe2.L0().x(null);
            }
        } catch (Exception unused) {
            System.out.println("");
        }
    }

    public static List<Pattern> m(List<Pattern> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            HashMap map = new HashMap();
            Iterator<Map.Entry<String, String>> it = d.entrySet().iterator();
            while (it.hasNext()) {
                String strG = g(it.next().getKey());
                map.put(strG, strG);
            }
            for (Pattern pattern : list) {
                if (!map.containsKey(pattern.getId())) {
                    arrayList.add(pattern);
                }
            }
        }
        return arrayList;
    }

    public static void n(String str, String str2, String str3, String str4, h hVar) {
        if (WearUtils.y.u() == null) {
            sg3.h(R.string.common_login_first);
            return;
        }
        HashMap map = new HashMap();
        map.put(TtmlNode.ATTR_ID, str);
        map.put("name", WearUtils.B(str2));
        if (!WearUtils.e1(str3) || !WearUtils.e1(str4)) {
            map.put("text", WearUtils.B(str3));
            map.put("mark", str4);
        }
        tn2.x(WearUtils.x).l("/wear/pattern/updatePatterInfo", map, new e(hVar));
    }

    public static boolean o(String str) {
        if (!WearUtils.e1(str)) {
            Pattern pattern = new Pattern();
            pattern.setDataNoCheckFormat(str);
            if (pattern.getHead() != null && ((!WearUtils.e1(pattern.getHead().getVersion()) || WearUtils.q1(pattern.getHead().getVersion())) && WearUtils.e1(pattern.getHead().getMd()))) {
                return true;
            }
        }
        return false;
    }

    public static void p(Context context, kn3.d dVar) {
        try {
            e();
            kn3 kn3Var = new kn3(context, ah4.e(R.string.pattern_share_alart_message), ah4.e(R.string.common_ok), false, false, dVar);
            e = kn3Var;
            kn3Var.show();
            e.n();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void q(Activity activity, String str) {
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        activity.runOnUiThread(new f(activity, str));
    }

    public static String r(String str) {
        String str2;
        if (WearUtils.e1(str)) {
            return str;
        }
        Pattern pattern = new Pattern();
        pattern.setDataNoCheckFormat(str);
        if (pattern.getHead() == null) {
            return str;
        }
        if ((WearUtils.e1(pattern.getHead().getVersion()) && !WearUtils.q1(pattern.getHead().getVersion())) || !WearUtils.e1(pattern.getHead().getMd())) {
            return str;
        }
        PatternHead head = pattern.getHead();
        if (head.isAllFunc()) {
            str2 = "V:" + head.getVersion() + ";T" + head.getToys() + ";F:" + head.getFunction() + ";S:100;A:y;M:" + PatternHead.P_M_DEF + ";#" + System.getProperty("line.separator");
        } else {
            str2 = "V:" + head.getVersion() + ";T" + head.getToys() + ";F:" + head.getFunction() + ";S:100;A:n;M:" + PatternHead.P_M_DEF + ";#" + System.getProperty("line.separator");
        }
        String str3 = str2 + pattern.getData();
        return str3.replace(PatternHead.P_M_DEF, WearUtils.r0(str3.replace(PatternHead.P_M_DEF, PatternHead.P_M)));
    }

    public static void s(File file, i iVar) {
        tn2.x(WearUtils.x).A("/wear/chat/saveFile/pattern", file, new HashMap(), new g(iVar));
    }
}
