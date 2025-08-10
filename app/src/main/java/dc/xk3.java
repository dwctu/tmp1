package dc;

import android.annotation.SuppressLint;
import com.wear.bean.vb.PatternEditControlVideoEvent;
import com.wear.util.WearUtils;
import com.wear.vibematevideo.NestedScrollWebView;

/* compiled from: JsInjectWebUtil.java */
/* loaded from: classes4.dex */
public class xk3 {
    public final NestedScrollWebView a;
    public final el3 b;
    public final String c;
    public final dl3 d;
    public String e;
    public String f;
    public String g;
    public vk3 h;
    public String i;
    public Runnable j = new a();

    /* compiled from: JsInjectWebUtil.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            xk3 xk3Var = xk3.this;
            xk3Var.f(xk3Var.i);
        }
    }

    public xk3(String str, NestedScrollWebView nestedScrollWebView, el3 el3Var, dl3 dl3Var) {
        this.c = str;
        this.a = nestedScrollWebView;
        this.b = el3Var;
        this.d = dl3Var;
        vk3 vk3Var = new vk3(nestedScrollWebView);
        this.h = vk3Var;
        vk3Var.f();
    }

    public void b(String str) {
        e(str);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void c(String str, int i) {
        this.g = WearUtils.E();
        String str2 = " changeSTMMediaStatus sTMMediaChangePlay_ID:" + this.g + "    url:" + str + "    optType:" + i;
        d(yk3.c().a(this.g, str, i));
    }

    public final void d(String str) {
        this.h.b(str);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void e(String str) {
        this.f = WearUtils.E();
        String str2 = " addSTMMediaStatusListener sTMMediaStatus_ID:" + this.f + ",url:" + str;
        d(yk3.c().e(this.f, str));
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void f(String str) {
        this.e = WearUtils.E();
        String str2 = " getAsyncSTMMediaInfo sTMMediaInfo_ID:" + this.e + ",url:" + str;
        d(yk3.c().b(this.e, str));
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void g(String str) {
        String str2 = " getMediaPattern url:" + str;
        d(yk3.c().d(this.c, str));
    }

    public void h(String str) {
        String str2 = "evaluateJsGetUserInfo: " + str;
        if (WearUtils.e1(str)) {
            return;
        }
        this.i = str;
        this.a.removeCallbacks(this.j);
        this.a.postDelayed(this.j, 1500L);
    }

    public void i(PatternEditControlVideoEvent patternEditControlVideoEvent) {
        if (patternEditControlVideoEvent.getFlag() == 3) {
            c(patternEditControlVideoEvent.getUrl(), patternEditControlVideoEvent.getOptType());
            return;
        }
        if (patternEditControlVideoEvent.getFlag() == 4) {
            h(patternEditControlVideoEvent.getUrl());
            return;
        }
        if (patternEditControlVideoEvent.getFlag() == 8) {
            String str = " addSTMMediaStatusListener sTMMediaInfo_ID:" + this.e + ",event.getWebPageId():" + patternEditControlVideoEvent.getWebPageId();
            if (WearUtils.e1(this.b.b()) || !this.b.b().equals(patternEditControlVideoEvent.getUrl())) {
                return;
            }
            b(patternEditControlVideoEvent.getUrl());
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void j(String str) {
        d(yk3.c().l(this.c, str));
    }
}
