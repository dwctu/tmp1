package org.apache.cordova.engine;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.MimeTypeMap;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.webkit.WebViewAssetLoader;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Iterator;
import org.apache.cordova.AuthenticationToken;
import org.apache.cordova.CordovaClientCertRequest;
import org.apache.cordova.CordovaHttpAuthHandler;
import org.apache.cordova.CordovaPluginPathHandler;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginManager;

/* loaded from: classes5.dex */
public class SystemWebViewClient extends WebViewClient {
    private static final String TAG = "SystemWebViewClient";
    private final WebViewAssetLoader assetLoader;
    public boolean isCurrentlyLoading;
    public final SystemWebViewEngine parentEngine;
    private boolean doClearHistory = false;
    private Hashtable<String, AuthenticationToken> authenticationTokens = new Hashtable<>();

    public SystemWebViewClient(final SystemWebViewEngine systemWebViewEngine) {
        this.parentEngine = systemWebViewEngine;
        WebViewAssetLoader.Builder httpAllowed = new WebViewAssetLoader.Builder().setDomain(systemWebViewEngine.preferences.getString("hostname", "localhost").toLowerCase()).setHttpAllowed(true);
        httpAllowed.addPathHandler("/", new WebViewAssetLoader.PathHandler() { // from class: dc.le4
            @Override // androidx.webkit.WebViewAssetLoader.PathHandler
            public final WebResourceResponse handle(String str) {
                return this.a.b(systemWebViewEngine, str);
            }
        });
        this.assetLoader = httpAllowed.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ WebResourceResponse b(SystemWebViewEngine systemWebViewEngine, String str) throws IOException {
        WebResourceResponse webResourceResponseHandle;
        try {
            PluginManager pluginManager = this.parentEngine.pluginManager;
            if (pluginManager != null) {
                Iterator<CordovaPluginPathHandler> it = pluginManager.getPluginPathHandlers().iterator();
                while (it.hasNext()) {
                    CordovaPluginPathHandler next = it.next();
                    if (next.getPathHandler() != null && (webResourceResponseHandle = next.getPathHandler().handle(str)) != null) {
                        return webResourceResponseHandle;
                    }
                }
            }
            if (str.isEmpty()) {
                str = "index.html";
            }
            InputStream inputStreamOpen = systemWebViewEngine.webView.getContext().getAssets().open("www/" + str, 2);
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
            return new WebResourceResponse(fileExtensionFromUrl != null ? (str.endsWith(".js") || str.endsWith(".mjs")) ? FastJsonJsonView.DEFAULT_JSONP_CONTENT_TYPE : str.endsWith(".wasm") ? "application/wasm" : MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl) : "text/html", null, inputStreamOpen);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.e(TAG, e.getMessage());
            return null;
        }
    }

    private static boolean needsContentUrlFix(Uri uri) {
        return FirebaseAnalytics.Param.CONTENT.equals(uri.getScheme());
    }

    private static boolean needsSpecialsInAssetUrlFix(Uri uri) {
        if (CordovaResourceApi.getUriType(uri) != 1) {
            return false;
        }
        if (uri.getQuery() != null || uri.getFragment() != null) {
            return true;
        }
        if (!uri.toString().contains("%")) {
        }
        return false;
    }

    public void clearAuthenticationTokens() {
        this.authenticationTokens.clear();
    }

    public AuthenticationToken getAuthenticationToken(String str, String str2) {
        AuthenticationToken authenticationToken = this.authenticationTokens.get(str.concat(str2));
        if (authenticationToken != null) {
            return authenticationToken;
        }
        AuthenticationToken authenticationToken2 = this.authenticationTokens.get(str);
        if (authenticationToken2 == null) {
            authenticationToken2 = this.authenticationTokens.get(str2);
        }
        AuthenticationToken authenticationToken3 = authenticationToken2;
        return authenticationToken3 == null ? this.authenticationTokens.get("") : authenticationToken3;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.isCurrentlyLoading || str.startsWith("about:")) {
            this.isCurrentlyLoading = false;
            if (this.doClearHistory) {
                webView.clearHistory();
                this.doClearHistory = false;
            }
            this.parentEngine.client.onPageFinishedLoading(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.isCurrentlyLoading = true;
        this.parentEngine.bridge.reset();
        this.parentEngine.client.onPageStarted(str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        PluginManager pluginManager = this.parentEngine.pluginManager;
        if (pluginManager == null || !pluginManager.onReceivedClientCertRequest(null, new CordovaClientCertRequest(clientCertRequest))) {
            super.onReceivedClientCertRequest(webView, clientCertRequest);
        } else {
            this.parentEngine.client.clearLoadTimeoutTimer();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        if (this.isCurrentlyLoading) {
            LOG.d(TAG, "CordovaWebViewClient.onReceivedError: Error code=%s Description=%s URL=%s", Integer.valueOf(i), str, str2);
            if (i == -10) {
                this.parentEngine.client.clearLoadTimeoutTimer();
                if (webView.canGoBack()) {
                    webView.goBack();
                    return;
                }
                super.onReceivedError(webView, i, str, str2);
            }
            this.parentEngine.client.onReceivedError(i, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        AuthenticationToken authenticationToken = getAuthenticationToken(str, str2);
        if (authenticationToken != null) {
            httpAuthHandler.proceed(authenticationToken.getUserName(), authenticationToken.getPassword());
            return;
        }
        PluginManager pluginManager = this.parentEngine.pluginManager;
        if (pluginManager == null || !pluginManager.onReceivedHttpAuthRequest(null, new CordovaHttpAuthHandler(httpAuthHandler), str, str2)) {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        } else {
            this.parentEngine.client.clearLoadTimeoutTimer();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        try {
            if ((this.parentEngine.cordova.getActivity().getPackageManager().getApplicationInfo(this.parentEngine.cordova.getActivity().getPackageName(), 128).flags & 2) != 0) {
                sslErrorHandler.proceed();
            } else {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        } catch (PackageManager.NameNotFoundException unused) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        PluginManager pluginManager = this.parentEngine.pluginManager;
        if (pluginManager == null || !pluginManager.onRenderProcessGone(webView, renderProcessGoneDetail)) {
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        return true;
    }

    public AuthenticationToken removeAuthenticationToken(String str, String str2) {
        return this.authenticationTokens.remove(str.concat(str2));
    }

    public void setAuthenticationToken(AuthenticationToken authenticationToken, String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        this.authenticationTokens.put(str.concat(str2), authenticationToken);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            if (!this.parentEngine.pluginManager.shouldAllowRequest(str)) {
                LOG.w(TAG, "URL blocked by allow list: " + str);
                return new WebResourceResponse("text/plain", "UTF-8", null);
            }
            LOG.w(TAG, "URL allowed by allow list: " + str);
            CordovaResourceApi cordovaResourceApi = this.parentEngine.resourceApi;
            Uri uri = Uri.parse(str);
            Uri uriRemapUri = cordovaResourceApi.remapUri(uri);
            if (uri.equals(uriRemapUri) && !needsSpecialsInAssetUrlFix(uri) && !needsContentUrlFix(uri)) {
                return null;
            }
            CordovaResourceApi.OpenForReadResult openForReadResultOpenForRead = cordovaResourceApi.openForRead(uriRemapUri, true);
            return new WebResourceResponse(openForReadResultOpenForRead.mimeType, "UTF-8", openForReadResultOpenForRead.inputStream);
        } catch (IOException e) {
            if (!(e instanceof FileNotFoundException)) {
                LOG.e(TAG, "Error occurred while loading a file (returning a 404).", e);
            }
            return new WebResourceResponse("text/plain", "UTF-8", null);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2 = "Trying to load URL: " + str;
        return this.parentEngine.client.onNavigationAttempt(str);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return this.assetLoader.shouldInterceptRequest(webResourceRequest.getUrl());
    }
}
