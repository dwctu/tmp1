package dc;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.spotify.sdk.android.auth.AuthorizationRequest;
import com.spotify.sdk.android.auth.AuthorizationResponse;
import dc.af1;
import java.util.Locale;

/* compiled from: LoginDialog.java */
/* loaded from: classes3.dex */
public class gf1 extends Dialog {
    public static final String f = gf1.class.getName();
    public final Uri a;
    public af1.a b;
    public ProgressDialog c;
    public boolean d;
    public boolean e;

    /* compiled from: LoginDialog.java */
    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            gf1.this.dismiss();
        }
    }

    /* compiled from: LoginDialog.java */
    public class b extends WebViewClient {
        public final /* synthetic */ WebView a;
        public final /* synthetic */ LinearLayout b;
        public final /* synthetic */ String c;

        public b(WebView webView, LinearLayout linearLayout, String str) {
            this.a = webView;
            this.b = linearLayout;
            this.c = str;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (gf1.this.d) {
                gf1.this.c.dismiss();
            }
            this.a.setVisibility(0);
            this.b.setVisibility(0);
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (gf1.this.d) {
                gf1.this.c.show();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            gf1.this.j(new Error(String.format("%s, code: %s, failing url: %s", str, Integer.valueOf(i), str2)));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String str2 = this.c;
            Locale locale = Locale.ENGLISH;
            String lowerCase = str2.toLowerCase(locale);
            String lowerCase2 = str.toLowerCase(locale);
            Uri uri = Uri.parse(str);
            if (lowerCase2.startsWith(lowerCase)) {
                gf1.this.i(uri);
                return true;
            }
            if (uri.getAuthority().matches("^(.+\\.facebook\\.com)|(accounts\\.spotify\\.com)|(.+\\.apple\\.com)$")) {
                return false;
            }
            String str3 = String.format("Can't redirect due to mismatch. \nRequest redirect-uri: %s\nResponse redirect-uri: %s", this.c, uri);
            String unused = gf1.f;
            gf1.this.j(new RuntimeException(str3));
            return true;
        }
    }

    public gf1(Activity activity, AuthorizationRequest authorizationRequest) {
        super(activity, R.style.Theme.Translucent.NoTitleBar);
        this.a = authorizationRequest.h();
    }

    public void f() {
        if (this.d) {
            dismiss();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void g(Uri uri) {
        h();
        WebView webView = (WebView) findViewById(bf1.com_spotify_sdk_login_webview);
        LinearLayout linearLayout = (LinearLayout) findViewById(bf1.com_spotify_sdk_login_webview_container);
        String queryParameter = uri.getQueryParameter("redirect_uri");
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSaveFormData(false);
        settings.setSavePassword(false);
        webView.setWebViewClient(new b(webView, linearLayout, queryParameter));
        webView.loadUrl(uri.toString());
    }

    public final boolean h() {
        return getContext().getPackageManager().checkPermission("android.permission.INTERNET", getContext().getPackageName()) == 0;
    }

    public final void i(Uri uri) {
        this.e = true;
        af1.a aVar = this.b;
        if (aVar != null) {
            aVar.a(AuthorizationResponse.a(uri));
        }
        f();
    }

    public final void j(Throwable th) {
        this.e = true;
        af1.a aVar = this.b;
        if (aVar != null) {
            aVar.onError(th);
        }
        f();
    }

    public final void k() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        float f2 = displayMetrics.widthPixels;
        float f3 = displayMetrics.density;
        ((LinearLayout) findViewById(bf1.com_spotify_sdk_login_webview_container)).setLayoutParams(new FrameLayout.LayoutParams(f2 / f3 > 400.0f ? (int) (400.0f * f3) : -1, ((float) displayMetrics.heightPixels) / f3 > 640.0f ? (int) (f3 * 640.0f) : -1, 17));
    }

    public void l(af1.a aVar) {
        this.b = aVar;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        this.d = true;
        super.onAttachedToWindow();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = false;
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        this.c = progressDialog;
        progressDialog.setMessage(getContext().getString(df1.com_spotify_sdk_login_progress));
        this.c.requestWindowFeature(1);
        this.c.setOnCancelListener(new a());
        requestWindowFeature(1);
        getWindow().setSoftInputMode(16);
        getWindow().setBackgroundDrawableResource(R.drawable.screen_background_dark_transparent);
        setContentView(cf1.com_spotify_sdk_login_dialog);
        k();
        g(this.a);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.d = false;
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog
    public void onStop() {
        af1.a aVar;
        if (!this.e && (aVar = this.b) != null) {
            aVar.onCancel();
        }
        this.e = true;
        this.c.dismiss();
        super.onStop();
    }
}
