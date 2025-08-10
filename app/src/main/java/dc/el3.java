package dc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.vibematevideo.NestedScrollWebView;
import wendu.dsbridge.DWebView;

/* compiled from: VibeMateWebViewControlImpl.java */
/* loaded from: classes4.dex */
public class el3 implements DWebView.c {
    public NestedScrollWebView a;
    public cl3 b;
    public bl3 c;
    public dl3 d;
    public String e;
    public String f;
    public xk3 g;

    /* compiled from: VibeMateWebViewControlImpl.java */
    public class a implements View.OnScrollChangeListener {
        public final /* synthetic */ dl3 a;

        public a(el3 el3Var, dl3 dl3Var) {
            this.a = dl3Var;
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(View view, int i, int i2, int i3, int i4) {
            dl3 dl3Var = this.a;
            if (dl3Var != null) {
                dl3Var.onScrollChange(view, i, i2, i3, i4);
            }
        }
    }

    /* compiled from: VibeMateWebViewControlImpl.java */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1) {
                return false;
            }
            el3.this.h();
            return false;
        }
    }

    public static String d() {
        String property;
        try {
            property = WebSettings.getDefaultUserAgent(MyApplication.N());
        } catch (Exception unused) {
            property = System.getProperty("http.agent");
        }
        boolean z = WearUtils.e1(property) || property.contains("Mobile");
        StringBuffer stringBuffer = new StringBuffer();
        int length = property.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = property.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127) {
                stringBuffer.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                stringBuffer.append(cCharAt);
            }
        }
        stringBuffer.append(" VibeMate");
        if (!z) {
            stringBuffer.append(" Mobile");
        }
        return stringBuffer.toString();
    }

    public void a() {
        NestedScrollWebView nestedScrollWebView = this.a;
        if (nestedScrollWebView != null) {
            nestedScrollWebView.destroy();
            this.a = null;
        }
        this.b = null;
        this.d = null;
    }

    public String b() {
        return this.e;
    }

    public xk3 c() {
        if (this.g == null) {
            this.g = new xk3(this.f, this.a, this, this.d);
        }
        return this.g;
    }

    @SuppressLint({"ClickableViewAccessibility", "JavascriptInterface"})
    public void e(Context context, NestedScrollWebView nestedScrollWebView, String str, dl3 dl3Var) {
        if (nestedScrollWebView == null) {
            return;
        }
        this.a = nestedScrollWebView;
        this.f = str;
        f(nestedScrollWebView);
        this.d = dl3Var;
        if (this.b == null) {
            this.b = new cl3(str, dl3Var);
        }
        nestedScrollWebView.setWebViewClient(this.b);
        if (this.c == null) {
            this.c = new bl3(str, dl3Var);
        }
        nestedScrollWebView.setWebChromeClient(this.c);
        this.g = new xk3(str, nestedScrollWebView, this, dl3Var);
        if (Build.VERSION.SDK_INT >= 23) {
            nestedScrollWebView.setOnScrollChangeListener(new a(this, dl3Var));
            nestedScrollWebView.setOnTouchListener(new b());
        }
        nestedScrollWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        nestedScrollWebView.addJavascriptInterface(new wk3(dl3Var), "java_obj");
        nestedScrollWebView.setLayerType(2, null);
        nestedScrollWebView.setJavascriptCloseWindowListener(this);
        nestedScrollWebView.m(new al3(), null);
    }

    public final void f(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBlockNetworkImage(false);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setUseWideViewPort(true);
        settings.setUserAgentString(d().replace("; wv", ""));
        settings.setCacheMode(-1);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setAllowFileAccess(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setDefaultTextEncodingName("utf-8");
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        WebView.setWebContentsDebuggingEnabled(WearUtils.v);
    }

    public void g(String str) {
        this.e = str;
    }

    public void h() {
        NestedScrollWebView nestedScrollWebView = this.a;
        if (nestedScrollWebView == null || nestedScrollWebView.getScrollY() != 0) {
            return;
        }
        this.a.scrollBy(0, 1);
    }

    @Override // wendu.dsbridge.DWebView.c
    public boolean onClose() {
        return false;
    }
}
