package com.wear.main.account;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
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
import com.wear.main.FlashActivity;
import com.wear.main.closeRange.alexa.AlexaPinActivity;
import com.wear.protocol.EntityAlexa;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.cs3;
import dc.is3;
import dc.pj3;
import dc.xe3;
import org.bouncycastle.i18n.MessageBundle;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class FrequentActivity extends BaseActivity {
    public WebView a;
    public MyActionBar b;
    public ProgressDialog c;
    public String d;
    public FrameLayout e;

    public class a implements is3.c {
        public a(FrequentActivity frequentActivity) {
        }

        @Override // dc.is3.c
        public void doCancel() {
        }
    }

    public class b implements is3.d {
        public b() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            Intent intent = new Intent(FrequentActivity.this, (Class<?>) FlashActivity.class);
            pj3.d(intent);
            intent.addFlags(268468224);
            FrequentActivity.this.startActivity(intent);
            MyApplication.D();
        }
    }

    public class c extends WebViewClient {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (FrequentActivity.this.isFinishing() || FrequentActivity.this.isDestroyed() || !FrequentActivity.this.c.isShowing()) {
                    return;
                }
                FrequentActivity.this.c.dismiss();
            }
        }

        public c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (FrequentActivity.this.isFinishing() || FrequentActivity.this.isDestroyed() || !FrequentActivity.this.c.isShowing()) {
                return;
            }
            WearUtils.x.l.postDelayed(new a(), 100L);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (FrequentActivity.this.isFinishing() || FrequentActivity.this.isDestroyed() || !FrequentActivity.this.c.isShowing()) {
                return;
            }
            FrequentActivity.this.c.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!str.startsWith("http://") && !str.startsWith("https://")) {
                return true;
            }
            webView.loadUrl(str);
            return true;
        }
    }

    public final void initWebView(Intent intent) {
        WebView webView = this.a;
        if (webView == null) {
            finish();
            return;
        }
        this.e.addView(webView);
        this.a.clearCache(true);
        this.a.clearHistory();
        this.a.requestFocus();
        WebSettings settings = this.a.getSettings();
        settings.setDatabaseEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        settings.setJavaScriptEnabled(true);
        String stringExtra = intent.getStringExtra(ImagesContract.URL);
        if (!WearUtils.e1(stringExtra) && !stringExtra.toLowerCase().startsWith("http")) {
            stringExtra = WearUtils.e + intent.getStringExtra(ImagesContract.URL);
        }
        this.a.loadUrl(stringExtra);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        this.c = ProgressDialog.show(this, "", ah4.e(R.string.common_loading), true, true);
        this.a.setWebViewClient(new c());
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_help_frequent);
        this.b = (MyActionBar) findViewById(R.id.actionbar);
        EventBus.getDefault().register(this);
        Intent intent = getIntent();
        this.b.setTitle(intent.getStringExtra(MessageBundle.TITLE_ENTRY));
        this.d = intent.getStringExtra("tag");
        this.e = (FrameLayout) findViewById(R.id.frame_layout);
        performInitWebView(intent, null, 0);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.c;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.c.dismiss();
        }
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

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        WebView webView = this.a;
        if (webView == null) {
            return super.onKeyDown(i, keyEvent);
        }
        xe3.a("FrequentActivity", webView.getOriginalUrl());
        if (i != 4 || !this.a.canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.a.goBack();
        finish();
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EntityAlexa entityAlexa) {
        if (entityAlexa == null || entityAlexa.getAlexaOPTType() != EntityAlexa.AlexaOPTType.unbind) {
            return;
        }
        addAnalyticsEventId("alexa_unbind", null);
        if (WearUtils.e1(this.d)) {
            return;
        }
        if (!this.d.equals("alexa") && this.d.equals("alexa-linked")) {
            pj3.f(this, AlexaPinActivity.class);
        }
        finish();
    }

    public final void performInitWebView(Intent intent, String str, int i) {
        try {
            if (!TextUtils.isEmpty(str) && Build.VERSION.SDK_INT >= 28) {
                WebView.setDataDirectorySuffix(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.a = new WebView(this);
            initWebView(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e2);
            if (isFinishing() || isDestroyed()) {
                return;
            }
            is3.b bVar = new is3.b(this);
            bVar.p("Page cannot be displayed. Please try again.");
            bVar.d(new b());
            bVar.c(new a(this));
            cs3.h(bVar).show();
        }
    }
}
