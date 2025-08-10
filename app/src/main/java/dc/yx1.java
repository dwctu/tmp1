package dc;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/* compiled from: JavaInterface.java */
/* loaded from: classes3.dex */
public class yx1 {
    public WebView a;

    public yx1(WebView webView) {
        this.a = webView;
    }

    @JavascriptInterface
    public void loadUrl(String str) {
        this.a.loadUrl(str);
    }
}
