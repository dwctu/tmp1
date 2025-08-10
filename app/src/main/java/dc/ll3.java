package dc;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ImagesContract;
import com.huawei.hms.framework.common.ContainerUtils;
import com.lovense.wear.R;
import com.wear.bean.vb.DownloadVbBean;
import com.wear.bean.vb.PatternEditControlVideoEvent;
import com.wear.bean.vb.PatternEditVideoInfo;
import com.wear.bean.vb.PatternEditVideoStatusBean;
import com.wear.bean.vb.PatternMediaStopEvent;
import com.wear.bean.vb.VibMateMediaPattern;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import dc.y12;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: PatternMediaPlayController.java */
/* loaded from: classes4.dex */
public class ll3 extends kl3 implements x12 {
    public static String t;
    public Random c;
    public VibMateMediaPattern d;
    public e22 f;
    public f22 g;
    public h22 h;
    public g22 i;
    public Disposable j;
    public Disposable k;
    public String n;
    public HashMap<String, SoftReference<VibMateMediaPattern>> r;
    public PatternEditVideoStatusBean s;
    public int e = 0;
    public boolean l = false;
    public boolean m = false;
    public int o = 100;
    public HashMap<String, Boolean> p = new HashMap<>();
    public boolean q = false;

    /* compiled from: PatternMediaPlayController.java */
    public class a extends h22 {
        public a(ll3 ll3Var) {
        }

        @Override // dc.f22
        public void b(Map map) {
        }

        @Override // dc.f22
        public void c(Map map) {
        }
    }

    /* compiled from: PatternMediaPlayController.java */
    public class b extends g22 {
        public b() {
        }

        @Override // dc.g22, dc.f22
        public void b(Map map) {
            super.b(map);
            ll3.this.g0();
        }

        @Override // dc.f22
        public void c(Map map) {
            ll3.this.h0();
        }
    }

    /* compiled from: PatternMediaPlayController.java */
    public class c extends ff3 {
        public final /* synthetic */ VibMateMediaPattern a;
        public final /* synthetic */ String[] b;

        /* compiled from: PatternMediaPlayController.java */
        public class a implements Runnable {
            public a(c cVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                sg3.i(WearUtils.x, R.string.file_notfound);
            }
        }

        public c(VibMateMediaPattern vibMateMediaPattern, String[] strArr) {
            this.a = vibMateMediaPattern;
            this.b = strArr;
        }

        @Override // dc.ff3
        public void b(boolean z, Object obj) throws IOException {
            this.a.setDownload(false);
            if (!z) {
                se0.f(new a(this));
                return;
            }
            this.b[0] = WearUtils.N1(((File) obj).getPath());
            if (rf3.o(this.b[0])) {
                String[] strArr = this.b;
                strArr[0] = rf3.r(strArr[0]);
                WearUtils.m2(this.b[0], "" + this.a.getId());
            }
            this.a.setDataNoCheckFormat(this.b[0]);
            ll3.this.r.put(this.a.getPatternUrl(), new SoftReference(this.a));
            ll3.this.y();
        }
    }

    /* compiled from: PatternMediaPlayController.java */
    public class d implements zn2<String> {
        public d(ll3 ll3Var) {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            String str = "reportedShare onError e: " + netException;
        }
    }

    public ll3(e22 e22Var) {
        this.f = e22Var;
        this.a = new HashMap<>();
        J();
    }

    public static ll3 E() {
        return (ll3) y12.c.a().i(y12.c.TYPE_MEDIA_PATTERN);
    }

    public static String H() {
        if (t == null) {
            t = nd3.e("NlhWdT05m99djQKCmziLmA==");
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(Long l) throws Exception {
        if (this.c == null) {
            this.c = new Random();
        }
        rq1.d.j(this.c.nextInt(3) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String R(Long l) throws Exception {
        if (!WearUtils.e1(F())) {
            return "";
        }
        pc1.a.u0();
        return "";
    }

    public static /* synthetic */ void S(String str) throws Exception {
    }

    public static boolean v(String str) {
        PackageManager packageManager = WearUtils.x.getPackageManager();
        try {
            String str2 = (String) packageManager.getPackageInfo(str, 1).applicationInfo.loadLabel(packageManager);
            if (str2 != null) {
                return !str2.equals("Market");
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean x(String str) {
        String host;
        return (str == null || (host = Uri.parse(str).getHost()) == null || !host.contains(H())) ? false : true;
    }

    public boolean A(String str, String str2) {
        String strReplace = str.replace("http://", "").replace("https://", "");
        String strReplace2 = str2.replace("http://", "").replace("https://", "");
        return strReplace.contains("/") && strReplace2.contains("/") && TextUtils.equals(strReplace.substring(strReplace.indexOf("/")), strReplace2.substring(strReplace2.indexOf("/")));
    }

    public final boolean B(String str) {
        String str2 = this.n;
        if (str2 == null || str == null) {
            return false;
        }
        if (str2.equals(str)) {
            return true;
        }
        return A(this.n, str);
    }

    public boolean C(String str) {
        PatternEditVideoInfo patternEditVideoInfo;
        HashMap<String, PatternEditVideoInfo> map = this.a;
        if (map == null || str == null || !map.containsKey(str) || (patternEditVideoInfo = this.a.get(str)) == null) {
            return false;
        }
        return patternEditVideoInfo.isPlaying();
    }

    public final void D() {
        HashMap<String, Boolean> map = this.p;
        if (map != null) {
            map.clear();
        }
    }

    public final String F() {
        VibMateMediaPattern vibMateMediaPattern;
        PatternEditVideoStatusBean patternEditVideoStatusBean = this.s;
        if (patternEditVideoStatusBean == null) {
            return "";
        }
        int currentTime = (this.e * 100) - patternEditVideoStatusBean.getCurrentTime();
        if (currentTime > 0) {
            if (currentTime <= 1000) {
                return "";
            }
            int currentTime2 = (this.s.getCurrentTime() / 100) - 2;
            this.e = currentTime2;
            if (currentTime2 < 0) {
                this.e = 0;
            }
        } else if (currentTime < -1000) {
            int currentTime3 = (this.s.getCurrentTime() / 100) - 2;
            this.e = currentTime3;
            if (currentTime3 < 0) {
                this.e = 0;
            }
        }
        if (this.e * 100 >= this.s.getDuration() || (vibMateMediaPattern = this.d) == null || vibMateMediaPattern.getArr() == null || this.e >= this.d.getArr().length || this.s.getVideoStatus() != 1) {
            return "";
        }
        String str = this.d.getArr()[this.e];
        String str2 = "getPatternGroups arrIndex: " + this.e + "    groups:" + str;
        if (WearUtils.e1(str)) {
            return str;
        }
        if (this.d.getHead() == null) {
            WearUtils.x.G().W((int) (WearUtils.q1(str) ? Float.parseFloat(str) : 0.0f));
        } else if (this.d.getHead() == null || this.d.getHead().getFunction() == null) {
            ye3.d("S0003", this.d.getTitle() + "   " + this.d.getAccountId() + "  ");
        } else if (this.d.getHead().isAllFunc()) {
            try {
                rq1.d.j(Integer.parseInt(str.split(",")[0]));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } else {
            rq1.d.k(Arrays.asList(this.d.getHead().getFunction().split(",")), Arrays.asList(str.split(",")));
        }
        String[] arr = this.d.getArr();
        int i = this.e;
        String str3 = arr[i];
        this.e = i + 1;
        return str3;
    }

    public void G(PatternEditVideoInfo patternEditVideoInfo) {
        if (patternEditVideoInfo != null) {
            String url = patternEditVideoInfo.getUrl();
            if (WearUtils.e1(url)) {
                return;
            }
            this.a.put(url, patternEditVideoInfo);
            if (TextUtils.equals(this.b, url) && patternEditVideoInfo.isDetail()) {
                L(url);
                y();
            }
        }
    }

    public boolean I() {
        return this.l;
    }

    public final void J() {
        a aVar = new a(this);
        this.h = aVar;
        this.i = new b();
        this.g = aVar;
    }

    public boolean K() {
        return this.g == this.i;
    }

    public void L(String str) {
        EventBus.getDefault().post(new PatternEditControlVideoEvent(8, str));
    }

    public void M(String str) {
        EventBus.getDefault().post(new PatternEditControlVideoEvent(4, str));
    }

    public void N(String str, boolean z) {
        PatternEditControlVideoEvent patternEditControlVideoEvent = new PatternEditControlVideoEvent(3, str);
        patternEditControlVideoEvent.setOptType(z ? 1 : 2);
        EventBus.getDefault().post(patternEditControlVideoEvent);
    }

    public final void T(Activity activity, String str, String str2) {
        String str3;
        if (str2 == null) {
            str2 = "id=" + str;
        }
        try {
            if (if3.h() || if3.g() || ke0.i()) {
                str3 = "https://play.google.com/store/apps/details?" + str2;
            } else if (v("com.android.vending")) {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?" + str2)));
                str3 = null;
            } else {
                str3 = "https://play.google.com/store/apps/details?" + str2;
            }
        } catch (Exception unused) {
            str3 = "https://play.google.com/store/apps/details?" + str2;
        }
        if (str3 != null) {
            pj3.w(activity, str3);
        }
    }

    public void U(Activity activity, DownloadVbBean downloadVbBean, String str, int i) {
        if (downloadVbBean.getDownload().booleanValue()) {
            boolean zC0 = c0(activity, "com.lovense.vibemate", str);
            String str2 = "navigateToDownloadVb hasInstallVb: " + zC0;
            if (zC0) {
                return;
            }
            T(activity, "com.lovense.vibemate", downloadVbBean.getSuffix());
            if (downloadVbBean.getParams() != null) {
                i0(WearUtils.A.toJson(downloadVbBean.getParams()));
            }
        }
    }

    public void V() {
        W();
        EventBus.getDefault().post(new PatternMediaStopEvent());
    }

    public void W() {
        n0();
        o0();
        D();
        this.q = false;
        this.l = false;
        this.d = null;
        h(new Event(c22.EVENT_STOP, null));
    }

    public void X(String str, String str2) {
        this.b = str2;
        if (B(str2)) {
            PatternEditVideoInfo patternEditVideoInfo = this.a.get(str2);
            if (patternEditVideoInfo != null && patternEditVideoInfo.isDetail()) {
                y();
                L(this.b);
            } else if (patternEditVideoInfo == null) {
                M(str2);
            }
        }
    }

    public void Y(String str, String str2) {
        this.n = str2;
        u();
        h(new Event(c22.EVENT_START, null));
    }

    public void Z(String str, String str2) {
        k0(str, str2);
    }

    @Override // dc.x12
    public boolean a() {
        return false;
    }

    public void a0(String str, String str2) {
        this.l = true;
        z(str, str2);
    }

    @Override // dc.x12
    public /* synthetic */ boolean b(f22 f22Var, Map map) {
        return w12.a(this, f22Var, map);
    }

    public void b0(String str, String str2) {
        this.q = true;
        this.b = str2;
        n0();
        u();
        this.s = null;
    }

    @Override // dc.x12
    public void c(@Nullable f22 f22Var) {
        this.g = f22Var;
    }

    public final boolean c0(Activity activity, String str, String str2) throws PackageManager.NameNotFoundException {
        try {
            PackageManager packageManager = activity.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo next = packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (next == null) {
                return false;
            }
            String str3 = next.activityInfo.name;
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setComponent(new ComponentName(str, str3));
            intent2.addFlags(268435456);
            if (!TextUtils.isEmpty(str2)) {
                Uri uriBuild = Uri.parse("vibemate://openUrl").buildUpon().appendQueryParameter(XHTMLText.CODE, "remoteDiversion").appendQueryParameter(ImagesContract.URL, Base64.encodeToString(str2.getBytes(), 0)).build();
                String str4 = "openApp: " + uriBuild.toString();
                intent2.setData(uriBuild);
            }
            activity.startActivity(intent2);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // dc.x12
    @Nullable
    public String d() {
        return "";
    }

    public void d0(String str, String str2, String str3, String str4) {
        HashMap map = new HashMap();
        if (str3 != null) {
            map.put("video_duration", str3);
        }
        if (str != null) {
            map.put("trigger", str);
        }
        if (str4 != null) {
            map.put("content_detail", str4);
        }
        if (str2 != null) {
            map.put("nums", str2);
        }
        ye3.d("U0092", WearUtils.A.toJson(map));
    }

    @Override // dc.x12
    @Nullable
    /* renamed from: e */
    public f22 getF() {
        return this.g;
    }

    public void e0(String str, String str2, String str3, String str4, String str5) {
        HashMap map = new HashMap();
        if (str != null) {
            map.put("page_type", str);
        }
        if (str2 != null) {
            map.put("trigger", str2);
        }
        if (str3 != null) {
            map.put("button_type", str3);
        }
        if (str4 != null) {
            map.put("content_detail", str4);
        }
        if (str5 != null) {
            map.put("nums", str5);
        }
        ye3.d("U0092", WearUtils.A.toJson(map));
    }

    @Override // dc.x12
    public boolean f() {
        return false;
    }

    public void f0(String str, String str2, String str3, String str4, String str5) {
        HashMap map = new HashMap();
        if (str != null) {
            map.put("page_type", str);
        }
        if (str2 != null) {
            map.put("trigger", str2);
        }
        if (str3 != null) {
            map.put("button_type", str3);
        }
        if (str4 != null) {
            map.put("use_toy", str4);
        }
        if (str5 != null) {
            map.put("nums", str5);
        }
        ye3.d("U0092", WearUtils.A.toJson(map));
    }

    @Override // dc.x12
    public void g() {
    }

    public void g0() {
        this.q = true;
    }

    @Override // dc.x12
    @NonNull
    public a22 getPriority() {
        return a22.PRIORITY_1;
    }

    @Override // dc.x12
    public /* synthetic */ boolean h(Event event) {
        return w12.b(this, event);
    }

    public void h0() {
        if (this.q) {
            V();
        }
        this.q = false;
    }

    @Override // dc.x12
    @Nullable
    /* renamed from: i */
    public h22 getG() {
        return this.h;
    }

    public final void i0(String str) {
        String str2 = "reportedShare params: " + str;
        tn2.x(WearUtils.x).m("/surfease/anon/common/reported/v3/share/download", str, new d(this));
    }

    @Override // dc.x12
    public void j(boolean z, int i, int i2) {
    }

    public void j0(VibMateMediaPattern vibMateMediaPattern) {
        String str = "saveAndPlay PatternUrl: " + vibMateMediaPattern.getPatternUrl();
        WearUtils.E0(false, vibMateMediaPattern.getPatternUrl(), new c(vibMateMediaPattern, new String[1]));
    }

    @Override // dc.x12
    @Nullable
    public e22 k() {
        return this.f;
    }

    public final void k0(String str, String str2) {
        if (x(str2)) {
            boolean zC = C(str2);
            this.p.put(str + ContainerUtils.FIELD_DELIMITER + str2, Boolean.valueOf(zC));
        }
    }

    @Override // dc.x12
    @Nullable
    /* renamed from: l */
    public g22 getH() {
        return this.i;
    }

    public void l0(String str) {
        this.n = str;
    }

    @Override // dc.x12
    public void m(@Nullable Activity activity) {
    }

    public final void m0() {
        n0();
        VibMateMediaPattern vibMateMediaPattern = this.d;
        if (vibMateMediaPattern == null || vibMateMediaPattern.getData() == null || this.a.get(this.b) == null || !B(this.b)) {
            return;
        }
        this.e = 0;
        PatternEditVideoStatusBean patternEditVideoStatusBean = this.s;
        if (patternEditVideoStatusBean != null) {
            this.e = patternEditVideoStatusBean.getCurrentTime() / 100;
        }
        if (this.e >= this.d.getArr().length) {
            return;
        }
        this.j = Observable.interval(10000 / this.o, TimeUnit.MILLISECONDS).map(new Function() { // from class: dc.il3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.a.R((Long) obj);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: dc.hl3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                ll3.S((String) obj);
            }
        }, jl3.a);
        this.m = true;
    }

    @Override // dc.x12
    @Nullable
    public List<Class<? extends Activity>> n() {
        return null;
    }

    public final void n0() {
        Disposable disposable = this.j;
        if (disposable != null && !disposable.isDisposed()) {
            this.j.dispose();
        }
        this.m = false;
        pc1.a.u0();
    }

    @Override // dc.x12
    @Nullable
    public String o() {
        return null;
    }

    public final void o0() {
        Disposable disposable = this.k;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        this.k.dispose();
        this.k = null;
    }

    public final void p0(PatternEditVideoStatusBean patternEditVideoStatusBean) {
        this.s = patternEditVideoStatusBean;
        patternEditVideoStatusBean.getVideoStatus();
        if (patternEditVideoStatusBean.getVideoStatus() == 99 || this.o == patternEditVideoStatusBean.getPlaybackRate()) {
            return;
        }
        this.o = patternEditVideoStatusBean.getPlaybackRate();
        m0();
    }

    @Override // dc.kl3
    public void q(PatternEditVideoStatusBean patternEditVideoStatusBean) {
        if (pc1.a.P().size() == 0) {
            return;
        }
        p0(patternEditVideoStatusBean);
    }

    public final void u() {
        if (this.k == null) {
            this.k = Observable.interval(100L, TimeUnit.MILLISECONDS).observeOn(Schedulers.io()).subscribe(new Consumer() { // from class: dc.gl3
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    this.a.P((Long) obj);
                }
            }, jl3.a);
        }
    }

    public void w(String str) {
        this.d = null;
        if (WearUtils.e1(str)) {
            o0();
            return;
        }
        HashMap<String, SoftReference<VibMateMediaPattern>> map = this.r;
        if (map == null) {
            this.r = new HashMap<>();
        } else if (map.containsKey(str)) {
            this.d = this.r.get(str).get();
        }
        if (this.d == null) {
            VibMateMediaPattern vibMateMediaPattern = new VibMateMediaPattern();
            this.d = vibMateMediaPattern;
            vibMateMediaPattern.setPatternUrl(str);
        }
        if (WearUtils.e1(this.d.getData())) {
            this.d.setLoading(true);
            j0(this.d);
        } else {
            this.d.setDownload(false);
            y();
        }
    }

    public final void y() {
        n0();
        if (this.m) {
            return;
        }
        m0();
    }

    public final void z(String str, String str2) {
        if (x(str2)) {
            if (this.p.containsKey(str + ContainerUtils.FIELD_DELIMITER + str2)) {
                if (this.p.get(str + ContainerUtils.FIELD_DELIMITER + str2).booleanValue()) {
                    E().N(str2, true);
                }
            }
        }
    }
}
