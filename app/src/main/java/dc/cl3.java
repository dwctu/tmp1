package dc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;

/* compiled from: VibeMateWebViewClient.java */
/* loaded from: classes4.dex */
public class cl3 extends WebViewClient {
    public dl3 a;
    public boolean b;

    /* compiled from: VibeMateWebViewClient.java */
    public class a implements Runnable {
        public final /* synthetic */ WebView a;

        public a(cl3 cl3Var, WebView webView) {
            this.a = webView;
        }

        @Override // java.lang.Runnable
        public void run() {
            WebView webView = this.a;
            if (webView != null) {
                webView.loadUrl(yk3.c().h());
                this.a.loadUrl(yk3.c().i());
            }
        }
    }

    public cl3(String str, dl3 dl3Var) {
        this.a = dl3Var;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void a(@NonNull WebView webView) {
        webView.postDelayed(new a(this, webView), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        super.doUpdateVisitedHistory(webView, str, z);
        if (this.b) {
            webView.clearHistory();
        }
        this.b = false;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        String str2 = "onPageFinished url = " + str;
        a(webView);
        String str3 = "CookieStr= " + CookieManager.getInstance().getCookie(str);
        this.a.G2(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        String str2 = "onPageStarted url = " + str;
        this.a.z0(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        int i = Build.VERSION.SDK_INT;
        if (i < 21 || !webResourceRequest.isForMainFrame() || i < 23) {
            return;
        }
        onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        sslErrorHandler.cancel();
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            if (str.startsWith("http://") || str.startsWith("https://")) {
                return this.a.K0(webView, str);
            }
            webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
    }
}
