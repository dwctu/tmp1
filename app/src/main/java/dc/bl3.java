package dc;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.greenrobot.eventbus.EventBus;

/* compiled from: VibeMateWebChromeClient.java */
/* loaded from: classes4.dex */
public class bl3 extends WebChromeClient {
    public dl3 a;

    /* compiled from: VibeMateWebChromeClient.java */
    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (bl3.this.a == null) {
                return true;
            }
            bl3.this.a.W(str);
            return true;
        }
    }

    public bl3(String str, dl3 dl3Var) {
        this.a = dl3Var;
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        Bitmap defaultVideoPoster = super.getDefaultVideoPoster();
        if (defaultVideoPoster != null) {
            return defaultVideoPoster;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(2, 2, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.eraseColor(0);
        return bitmapCreateBitmap;
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        try {
            WebView webView2 = new WebView(webView.getContext());
            webView2.setWebViewClient(new a());
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        dl3 dl3Var = this.a;
        if (dl3Var != null) {
            dl3Var.hideCustomView();
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (str2 == null) {
            return true;
        }
        String str3 = " onJsAlert message = " + str2;
        String str4 = " onJsAlert message = " + str2;
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        String str3 = " onJsConfirm message = " + str2;
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        String str4 = " onJsPrompt message = " + str2;
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        for (String str : permissionRequest.getResources()) {
            String str2 = "onPermissionRequest: " + str;
        }
        EventBus.getDefault().post(permissionRequest);
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        dl3 dl3Var = this.a;
        if (dl3Var != null) {
            dl3Var.F1(webView, i);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        super.onReceivedIcon(webView, bitmap);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        super.onReceivedTouchIconUrl(webView, str, z);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        dl3 dl3Var = this.a;
        if (dl3Var != null) {
            dl3Var.showCustomView(view, customViewCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        return true;
    }
}
