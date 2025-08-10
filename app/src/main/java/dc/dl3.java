package dc;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* compiled from: VibeMateWebViewControlCallBack.java */
/* loaded from: classes4.dex */
public interface dl3 {
    void F1(WebView webView, int i);

    void G2(WebView webView, String str);

    boolean K0(WebView webView, String str);

    void K1(String str);

    void W(String str);

    void hideCustomView();

    void onScrollChange(View view, int i, int i2, int i3, int i4);

    void showCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback);

    void z0(WebView webView, String str, Bitmap bitmap);
}
