package org.apache.cordova.engine;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.koushikdutta.async.http.AsyncHttpRequest;
import java.util.Arrays;
import org.apache.cordova.CordovaDialogsHelper;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;

/* loaded from: classes5.dex */
public class SystemWebChromeClient extends WebChromeClient {
    private static final int FILECHOOSER_RESULTCODE = 5173;
    private static final String LOG_TAG = "SystemWebChromeClient";
    private long MAX_QUOTA = 104857600;
    private Context appContext;
    private CordovaDialogsHelper dialogsHelper;
    private View mCustomView;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    private View mVideoProgressView;
    public final SystemWebViewEngine parentEngine;

    public SystemWebChromeClient(SystemWebViewEngine systemWebViewEngine) {
        this.parentEngine = systemWebViewEngine;
        Context context = systemWebViewEngine.webView.getContext();
        this.appContext = context;
        this.dialogsHelper = new CordovaDialogsHelper(context);
    }

    public void destroyLastDialog() {
        this.dialogsHelper.destroyLastDialog();
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        if (this.mVideoProgressView == null) {
            LinearLayout linearLayout = new LinearLayout(this.parentEngine.getView().getContext());
            linearLayout.setOrientation(1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            linearLayout.setLayoutParams(layoutParams);
            ProgressBar progressBar = new ProgressBar(this.parentEngine.getView().getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            progressBar.setLayoutParams(layoutParams2);
            linearLayout.addView(progressBar);
            this.mVideoProgressView = linearLayout;
        }
        return this.mVideoProgressView;
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        LOG.d(LOG_TAG, "onExceededDatabaseQuota estimatedSize: %d  currentQuota: %d  totalUsedQuota: %d", Long.valueOf(j2), Long.valueOf(j), Long.valueOf(j3));
        quotaUpdater.updateQuota(this.MAX_QUOTA);
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        super.onGeolocationPermissionsShowPrompt(str, callback);
        callback.invoke(str, true, false);
        CordovaPlugin plugin = this.parentEngine.pluginManager.getPlugin("Geolocation");
        if (plugin == null || plugin.hasPermisssion()) {
            return;
        }
        plugin.requestPermissions(0);
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        this.parentEngine.getCordovaWebView().hideCustomView();
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
        this.dialogsHelper.showAlert(str2, new CordovaDialogsHelper.Result() { // from class: org.apache.cordova.engine.SystemWebChromeClient.1
            @Override // org.apache.cordova.CordovaDialogsHelper.Result
            public void gotResult(boolean z, String str3) {
                if (z) {
                    jsResult.confirm();
                } else {
                    jsResult.cancel();
                }
            }
        });
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, final JsResult jsResult) {
        this.dialogsHelper.showConfirm(str2, new CordovaDialogsHelper.Result() { // from class: org.apache.cordova.engine.SystemWebChromeClient.2
            @Override // org.apache.cordova.CordovaDialogsHelper.Result
            public void gotResult(boolean z, String str3) {
                if (z) {
                    jsResult.confirm();
                } else {
                    jsResult.cancel();
                }
            }
        });
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, final JsPromptResult jsPromptResult) {
        String strPromptOnJsPrompt = this.parentEngine.bridge.promptOnJsPrompt(str, str2, str3);
        if (strPromptOnJsPrompt != null) {
            jsPromptResult.confirm(strPromptOnJsPrompt);
            return true;
        }
        this.dialogsHelper.showPrompt(str2, str3, new CordovaDialogsHelper.Result() { // from class: org.apache.cordova.engine.SystemWebChromeClient.3
            @Override // org.apache.cordova.CordovaDialogsHelper.Result
            public void gotResult(boolean z, String str4) {
                if (z) {
                    jsPromptResult.confirm(str4);
                } else {
                    jsPromptResult.cancel();
                }
            }
        });
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        LOG.d(LOG_TAG, "onPermissionRequest: " + Arrays.toString(permissionRequest.getResources()));
        permissionRequest.grant(permissionRequest.getResources());
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.parentEngine.getCordovaWebView().showCustomView(view, customViewCallback);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, final ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        Boolean bool = Boolean.FALSE;
        if (fileChooserParams.getMode() == 1) {
            bool = Boolean.TRUE;
        }
        Intent intentCreateIntent = fileChooserParams.createIntent();
        intentCreateIntent.putExtra("android.intent.extra.ALLOW_MULTIPLE", bool);
        String[] acceptTypes = fileChooserParams.getAcceptTypes();
        if (acceptTypes.length > 1) {
            intentCreateIntent.setType(AsyncHttpRequest.HEADER_ACCEPT_ALL);
            intentCreateIntent.putExtra("android.intent.extra.MIME_TYPES", acceptTypes);
        }
        try {
            this.parentEngine.cordova.startActivityForResult(new CordovaPlugin() { // from class: org.apache.cordova.engine.SystemWebChromeClient.4
                /* JADX WARN: Removed duplicated region for block: B:13:0x005e  */
                @Override // org.apache.cordova.CordovaPlugin
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onActivityResult(int r6, int r7, android.content.Intent r8) {
                    /*
                        r5 = this;
                        r6 = -1
                        if (r7 != r6) goto L5e
                        if (r8 == 0) goto L5e
                        android.content.ClipData r6 = r8.getClipData()
                        java.lang.String r0 = "Receive file chooser URL: "
                        java.lang.String r1 = "SystemWebChromeClient"
                        if (r6 == 0) goto L41
                        android.content.ClipData r6 = r8.getClipData()
                        int r6 = r6.getItemCount()
                        android.net.Uri[] r7 = new android.net.Uri[r6]
                        r2 = 0
                    L1a:
                        if (r2 >= r6) goto L5f
                        android.content.ClipData r3 = r8.getClipData()
                        android.content.ClipData$Item r3 = r3.getItemAt(r2)
                        android.net.Uri r3 = r3.getUri()
                        r7[r2] = r3
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder
                        r3.<init>()
                        r3.append(r0)
                        r4 = r7[r2]
                        r3.append(r4)
                        java.lang.String r3 = r3.toString()
                        org.apache.cordova.LOG.d(r1, r3)
                        int r2 = r2 + 1
                        goto L1a
                    L41:
                        android.net.Uri r6 = r8.getData()
                        if (r6 == 0) goto L5e
                        android.net.Uri[] r7 = android.webkit.WebChromeClient.FileChooserParams.parseResult(r7, r8)
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder
                        r6.<init>()
                        r6.append(r0)
                        r6.append(r7)
                        java.lang.String r6 = r6.toString()
                        org.apache.cordova.LOG.d(r1, r6)
                        goto L5f
                    L5e:
                        r7 = 0
                    L5f:
                        android.webkit.ValueCallback r6 = r2
                        r6.onReceiveValue(r7)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.apache.cordova.engine.SystemWebChromeClient.AnonymousClass4.onActivityResult(int, int, android.content.Intent):void");
                }
            }, intentCreateIntent, FILECHOOSER_RESULTCODE);
        } catch (ActivityNotFoundException e) {
            LOG.w("No activity found to handle file chooser intent.", e);
            valueCallback.onReceiveValue(null);
        }
        return true;
    }
}
