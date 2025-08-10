package org.apache.cordova.engine;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewEngine;

/* loaded from: classes5.dex */
public class SystemWebView extends WebView implements CordovaWebViewEngine.EngineView {
    public SystemWebChromeClient chromeClient;
    public CordovaInterface cordova;
    public SystemWebViewEngine parentEngine;
    public SystemWebViewClient viewClient;

    public SystemWebView(Context context) {
        this(context, null);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Boolean boolOnDispatchKeyEvent = this.parentEngine.client.onDispatchKeyEvent(keyEvent);
        return boolOnDispatchKeyEvent != null ? boolOnDispatchKeyEvent.booleanValue() : super.dispatchKeyEvent(keyEvent);
    }

    @Override // org.apache.cordova.CordovaWebViewEngine.EngineView
    public CordovaWebView getCordovaWebView() {
        SystemWebViewEngine systemWebViewEngine = this.parentEngine;
        if (systemWebViewEngine != null) {
            return systemWebViewEngine.getCordovaWebView();
        }
        return null;
    }

    public void init(SystemWebViewEngine systemWebViewEngine, CordovaInterface cordovaInterface) {
        this.cordova = cordovaInterface;
        this.parentEngine = systemWebViewEngine;
        if (this.viewClient == null) {
            setWebViewClient(new SystemWebViewClient(systemWebViewEngine));
        }
        if (this.chromeClient == null) {
            setWebChromeClient(new SystemWebChromeClient(systemWebViewEngine));
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.chromeClient = (SystemWebChromeClient) webChromeClient;
        super.setWebChromeClient(webChromeClient);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        this.viewClient = (SystemWebViewClient) webViewClient;
        super.setWebViewClient(webViewClient);
    }

    public SystemWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
