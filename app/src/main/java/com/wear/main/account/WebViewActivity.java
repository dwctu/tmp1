package com.wear.main.account;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.event.SystemChangeEvent;
import com.wear.main.FlashActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.kn3;
import dc.pj3;
import dc.we3;
import dc.xe3;
import dc.yx1;
import dc.zx1;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.i18n.MessageBundle;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class WebViewActivity extends BaseActivity {
    public WebView a;
    public MyActionBar b;
    public FrameLayout c;
    public List<String> d = new ArrayList();

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            if (WebViewActivity.this.d.size() <= 1) {
                WebViewActivity.this.finish();
                return;
            }
            WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.loadUrl((String) webViewActivity.d.get(WebViewActivity.this.d.size() - 2));
            WebViewActivity.this.d.remove(WebViewActivity.this.d.size() - 1);
        }
    }

    public class b extends WebViewClient {
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            String str2 = "onPageFinished: " + str;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            try {
                URL url = new URL(str);
                String string = new URI(url.getProtocol(), url.getAuthority(), url.getPath(), null, null).toString();
                String str2 = "urlWithoutParams: " + string;
                if (!WebViewActivity.this.d.contains(string) && !WebViewActivity.this.d.contains(string.replace(".html", ""))) {
                    WebViewActivity.this.d.add(string.replace(".html", ""));
                }
                System.out.println("URL without parameters: " + string);
            } catch (MalformedURLException | URISyntaxException e) {
                e.printStackTrace();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String str2 = "shouldOverrideUrlLoading: " + str;
            if (str.startsWith("http://") || str.startsWith("https://")) {
                webView.loadUrl(str);
                return true;
            }
            try {
                we3.q(WebViewActivity.this, str, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    public class c implements kn3.d {
        public c() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            Intent intent = new Intent(WebViewActivity.this, (Class<?>) FlashActivity.class);
            pj3.d(intent);
            intent.addFlags(268468224);
            WebViewActivity.this.startActivity(intent);
            MyApplication.D();
        }
    }

    public class d extends WebChromeClient {
        public d() {
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (WearUtils.e1(WebViewActivity.this.getIntent().getStringExtra(MessageBundle.TITLE_ENTRY))) {
                WebViewActivity.this.b.setTitle(str.replace("\"", ""));
                String str2 = "onReceivedTitle: " + str;
            }
        }

        public /* synthetic */ d(WebViewActivity webViewActivity, a aVar) {
            this();
        }
    }

    public WebViewActivity() {
        new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w4() {
        loadUrl(this.a.getUrl());
    }

    public final void loadUrl(String str) {
        String str2 = "isDark: " + MyApplication.l0;
        if (WearUtils.Y0()) {
            if (str.contains("?")) {
                str = str + "&dark=1";
            } else {
                str = str + "?dark=1";
            }
        } else if (str.contains("?dark=1")) {
            str = str.replace("?dark=1", "");
        } else if (str.contains("&dark=1")) {
            str = str.replace("&dark=1", "");
        }
        if (!WearUtils.e1(str) && !str.toLowerCase().startsWith("http")) {
            str = WearUtils.e + str;
        }
        this.a.loadUrl(str);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_help_frequent);
        this.b = (MyActionBar) findViewById(R.id.actionbar);
        EventBus.getDefault().register(this);
        Intent intent = getIntent();
        this.b.setTitle(intent.getStringExtra(MessageBundle.TITLE_ENTRY));
        intent.getStringExtra("tag");
        try {
            this.c = (FrameLayout) findViewById(R.id.frame_layout);
            WebView webView = new WebView(this);
            this.a = webView;
            this.c.addView(webView);
            this.a.clearCache(true);
            this.a.clearHistory();
            this.a.requestFocus();
            WebSettings settings = this.a.getSettings();
            settings.setDatabaseEnabled(true);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(2);
            }
            settings.setJavaScriptEnabled(true);
            loadUrl(intent.getStringExtra(ImagesContract.URL));
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            WebView webView2 = this.a;
            webView2.addJavascriptInterface(new zx1(this, webView2), "lovenseWeb");
            WebView webView3 = this.a;
            webView3.addJavascriptInterface(new yx1(webView3), "javaInterface");
            this.b.setBackAction(new a());
            this.a.setWebChromeClient(new d(this, null));
            this.a.setWebViewClient(new b());
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().recordException(e);
            kn3 kn3Var = new kn3((Context) this, "Page cannot be displayed. Please try again.", ah4.e(R.string.common_ok), false, false, (kn3.d) new c(), true);
            kn3Var.show();
            kn3Var.n();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        WebView webView = this.a;
        if (webView != null) {
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.a);
            }
            this.a.clearCache(true);
            this.a.removeAllViews();
            this.a.clearHistory();
            this.a.destroy();
        }
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(SystemChangeEvent systemChangeEvent) {
        this.a.post(new Runnable() { // from class: dc.ux1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.w4();
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        WebView webView = this.a;
        if (webView == null) {
            return super.onKeyDown(i, keyEvent);
        }
        xe3.a("FrequentActivity", webView.getOriginalUrl());
        if (i != 4 || !this.a.canGoBack()) {
            finish();
            return super.onKeyDown(i, keyEvent);
        }
        if (this.d.size() > 1) {
            loadUrl(this.d.get(r3.size() - 2));
            List<String> list = this.d;
            list.remove(list.size() - 1);
        } else {
            finish();
        }
        return true;
    }
}
