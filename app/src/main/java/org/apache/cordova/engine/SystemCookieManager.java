package org.apache.cordova.engine;

import android.webkit.CookieManager;
import android.webkit.WebView;
import org.apache.cordova.ICordovaCookieManager;

/* loaded from: classes5.dex */
public class SystemCookieManager implements ICordovaCookieManager {
    private final CookieManager cookieManager;
    public final WebView webView;

    public SystemCookieManager(WebView webView) {
        this.webView = webView;
        CookieManager cookieManager = CookieManager.getInstance();
        this.cookieManager = cookieManager;
        cookieManager.setAcceptThirdPartyCookies(webView, true);
    }

    @Override // org.apache.cordova.ICordovaCookieManager
    public void clearCookies() {
        this.cookieManager.removeAllCookies(null);
    }

    @Override // org.apache.cordova.ICordovaCookieManager
    public void flush() {
        this.cookieManager.flush();
    }

    @Override // org.apache.cordova.ICordovaCookieManager
    public String getCookie(String str) {
        return this.cookieManager.getCookie(str);
    }

    public void setAcceptFileSchemeCookies() {
        CookieManager.setAcceptFileSchemeCookies(true);
    }

    @Override // org.apache.cordova.ICordovaCookieManager
    public void setCookie(String str, String str2) {
        this.cookieManager.setCookie(str, str2);
    }

    @Override // org.apache.cordova.ICordovaCookieManager
    public void setCookiesEnabled(boolean z) {
        this.cookieManager.setAcceptCookie(z);
    }
}
