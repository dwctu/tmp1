package wendu.dsbridge;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.appcompat.app.AlertDialog;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import dc.fj4;
import dc.gj4;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class DWebView extends WebView {
    public static boolean j = false;
    public Map<String, Object> a;
    public String b;
    public WebChromeClient c;
    public d d;
    public volatile boolean e;
    public c f;
    public ArrayList<b> g;
    public Map<Integer, gj4> h;
    public WebChromeClient i;

    public class b {
        public String a;
        public int b;
        public String c;

        public String toString() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(FirebaseAnalytics.Param.METHOD, this.c);
                jSONObject.put("callbackId", this.b);
                jSONObject.put("data", this.a);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
    }

    public interface c {
        boolean onClose();
    }

    public class d extends Handler {
        public WeakReference<Activity> a;

        public d(Activity activity) {
            this.a = new WeakReference<>(activity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.a.get() != null) {
                int i = message.what;
                if (i == 1) {
                    DWebView.this.a((String) message.obj);
                    return;
                }
                if (i == 2) {
                    DWebView.super.loadUrl((String) message.obj);
                    return;
                }
                if (i == 3) {
                    e eVar = (e) message.obj;
                    DWebView.super.loadUrl(eVar.a, eVar.b);
                    return;
                }
                if (i == 4) {
                    if (DWebView.this.f == null || DWebView.this.f.onClose()) {
                        ((Activity) DWebView.this.getContext()).onBackPressed();
                        return;
                    }
                    return;
                }
                if (i != 5) {
                    return;
                }
                int i2 = message.arg1;
                gj4 gj4Var = DWebView.this.h.get(Integer.valueOf(i2));
                if (gj4Var != null) {
                    if (DWebView.j) {
                        gj4Var.a(message.obj);
                    } else {
                        try {
                            gj4Var.a(message.obj);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (message.arg2 == 1) {
                        DWebView.this.h.remove(Integer.valueOf(i2));
                    }
                }
            }
        }
    }

    public class e {
        public String a;
        public Map<String, String> b;

        public e(DWebView dWebView, String str, Map<String, String> map) {
            this.a = str;
            this.b = map;
        }
    }

    public DWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new HashMap();
        this.d = null;
        this.e = true;
        this.f = null;
        this.g = new ArrayList<>();
        this.h = new HashMap();
        this.i = new a();
        init();
    }

    @Keep
    private void addInternalJavascriptObject() {
        m(new Object() { // from class: wendu.dsbridge.DWebView.2
            @JavascriptInterface
            @Keep
            public String closePage(Object obj) throws JSONException {
                Message message = new Message();
                message.what = 4;
                DWebView.this.d.sendMessage(message);
                return null;
            }

            @JavascriptInterface
            @Keep
            public void disableJavascriptDialogBlock(Object obj) throws JSONException {
                DWebView.this.e = !((JSONObject) obj).getBoolean("disable");
            }

            @JavascriptInterface
            @Keep
            public void dsinit(Object obj) {
                DWebView.this.p();
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0051  */
            @android.webkit.JavascriptInterface
            @androidx.annotation.Keep
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean hasNativeMethod(java.lang.Object r10) throws org.json.JSONException, java.lang.NoSuchMethodException, java.lang.SecurityException {
                /*
                    r9 = this;
                    java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
                    org.json.JSONObject r10 = (org.json.JSONObject) r10
                    java.lang.String r1 = "name"
                    java.lang.String r1 = r10.getString(r1)
                    java.lang.String r1 = r1.trim()
                    java.lang.String r2 = "type"
                    java.lang.String r10 = r10.getString(r2)
                    java.lang.String r10 = r10.trim()
                    wendu.dsbridge.DWebView r2 = wendu.dsbridge.DWebView.this
                    java.lang.String[] r1 = wendu.dsbridge.DWebView.g(r2, r1)
                    wendu.dsbridge.DWebView r2 = wendu.dsbridge.DWebView.this
                    java.util.Map r2 = wendu.dsbridge.DWebView.h(r2)
                    r3 = 0
                    r4 = r1[r3]
                    java.lang.Object r2 = r2.get(r4)
                    if (r2 == 0) goto L78
                    java.lang.Class r2 = r2.getClass()
                    r4 = 0
                    r5 = 1
                    r6 = r1[r5]     // Catch: java.lang.Exception -> L44
                    r7 = 2
                    java.lang.Class[] r7 = new java.lang.Class[r7]     // Catch: java.lang.Exception -> L44
                    r7[r3] = r0     // Catch: java.lang.Exception -> L44
                    java.lang.Class<dc.fj4> r8 = dc.fj4.class
                    r7[r5] = r8     // Catch: java.lang.Exception -> L44
                    java.lang.reflect.Method r4 = r2.getDeclaredMethod(r6, r7)     // Catch: java.lang.Exception -> L44
                    r0 = 1
                    goto L4f
                L44:
                    r1 = r1[r5]     // Catch: java.lang.Exception -> L4e
                    java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch: java.lang.Exception -> L4e
                    r6[r3] = r0     // Catch: java.lang.Exception -> L4e
                    java.lang.reflect.Method r4 = r2.getDeclaredMethod(r1, r6)     // Catch: java.lang.Exception -> L4e
                L4e:
                    r0 = 0
                L4f:
                    if (r4 == 0) goto L78
                    java.lang.Class<android.webkit.JavascriptInterface> r1 = android.webkit.JavascriptInterface.class
                    java.lang.annotation.Annotation r1 = r4.getAnnotation(r1)
                    android.webkit.JavascriptInterface r1 = (android.webkit.JavascriptInterface) r1
                    if (r1 == 0) goto L78
                    java.lang.String r1 = "all"
                    boolean r1 = r1.equals(r10)
                    if (r1 != 0) goto L77
                    if (r0 == 0) goto L6d
                    java.lang.String r1 = "asyn"
                    boolean r1 = r1.equals(r10)
                    if (r1 != 0) goto L77
                L6d:
                    if (r0 != 0) goto L78
                    java.lang.String r0 = "syn"
                    boolean r10 = r0.equals(r10)
                    if (r10 == 0) goto L78
                L77:
                    return r5
                L78:
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: wendu.dsbridge.DWebView.AnonymousClass2.hasNativeMethod(java.lang.Object):boolean");
            }

            @JavascriptInterface
            @Keep
            public void returnValue(Object obj) throws JSONException {
                JSONObject jSONObject = (JSONObject) obj;
                Message message = new Message();
                message.what = 5;
                message.arg1 = jSONObject.getInt(TtmlNode.ATTR_ID);
                message.arg2 = jSONObject.getBoolean("complete") ? 1 : 0;
                if (jSONObject.has("data")) {
                    message.obj = jSONObject.get("data");
                }
                DWebView.this.d.sendMessage(message);
            }
        }, "_dsb");
    }

    public static void setWebContentsDebuggingEnabled(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(z);
        }
        j = z;
    }

    public final void a(String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            super.evaluateJavascript(str, null);
            return;
        }
        loadUrl("javascript:" + str);
    }

    @Override // android.webkit.WebView
    public void clearCache(boolean z) {
        super.clearCache(z);
        CookieManager.getInstance().removeAllCookie();
        Context context = getContext();
        try {
            context.deleteDatabase("webview.db");
            context.deleteDatabase("webviewCache.db");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        File file = new File(this.b);
        File file2 = new File(context.getCacheDir().getAbsolutePath() + "/webviewCache");
        if (file2.exists()) {
            n(file2);
        }
        if (file.exists()) {
            n(file);
        }
    }

    @Keep
    public void init() {
        this.d = new d((Activity) getContext());
        this.b = getContext().getFilesDir().getAbsolutePath() + "/webcache";
        WebSettings settings = getSettings();
        settings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
            settings.setMixedContentMode(0);
        }
        settings.setAllowFileAccess(false);
        settings.setAppCacheEnabled(false);
        settings.setCacheMode(2);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportMultipleWindows(true);
        settings.setAppCachePath(this.b);
        settings.setUseWideViewPort(true);
        super.setWebChromeClient(this.i);
        addInternalJavascriptObject();
        super.addJavascriptInterface(new Object() { // from class: wendu.dsbridge.DWebView.1

            /* renamed from: wendu.dsbridge.DWebView$1$a */
            public class a implements fj4 {
                public a(AnonymousClass1 anonymousClass1, String str) {
                }
            }

            public final void a(String str) {
                if (DWebView.j) {
                    DWebView.this.q(String.format("alert('%s')", "DEBUG ERR MSG:\\n" + str.replaceAll("\\'", "\\\\'")));
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x006b  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x0089  */
            @android.webkit.JavascriptInterface
            @androidx.annotation.Keep
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.lang.String call(java.lang.String r14, java.lang.String r15) throws org.json.JSONException, java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
                /*
                    Method dump skipped, instructions count: 264
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: wendu.dsbridge.DWebView.AnonymousClass1.call(java.lang.String, java.lang.String):java.lang.String");
            }
        }, "_dsbridge");
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        Message message = new Message();
        message.what = 2;
        message.obj = str;
        this.d.sendMessage(message);
    }

    public void m(Object obj, String str) {
        if (str == null) {
            str = "";
        }
        if (obj != null) {
            this.a.put(str, obj);
        }
    }

    public void n(File file) {
        if (!file.exists()) {
            String str = "delete file no exists " + file.getAbsolutePath();
            return;
        }
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                n(file2);
            }
        }
        file.delete();
    }

    public final void o(b bVar) {
        q(String.format("window._handleMessageFromNative(%s)", bVar.toString()));
    }

    public final synchronized void p() {
        Iterator<b> it = this.g.iterator();
        while (it.hasNext()) {
            o(it.next());
        }
        this.g = null;
    }

    public void q(String str) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            a(str);
            return;
        }
        Message message = new Message();
        message.what = 1;
        message.obj = str;
        this.d.sendMessage(message);
    }

    public final String[] r(String str) {
        String strSubstring;
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf != -1) {
            strSubstring = str.substring(0, iLastIndexOf);
            str = str.substring(iLastIndexOf + 1);
        } else {
            strSubstring = "";
        }
        return new String[]{strSubstring, str};
    }

    public void setJavascriptCloseWindowListener(c cVar) {
        this.f = cVar;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.c = webChromeClient;
    }

    public class a extends WebChromeClient {

        /* renamed from: wendu.dsbridge.DWebView$a$a, reason: collision with other inner class name */
        public class DialogInterfaceOnClickListenerC0274a implements DialogInterface.OnClickListener {
            public final /* synthetic */ JsResult a;

            public DialogInterfaceOnClickListenerC0274a(JsResult jsResult) {
                this.a = jsResult;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                if (DWebView.this.e) {
                    this.a.confirm();
                }
            }
        }

        public class b implements DialogInterface.OnClickListener {
            public final /* synthetic */ JsResult a;

            public b(JsResult jsResult) {
                this.a = jsResult;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (DWebView.this.e) {
                    if (i == -1) {
                        this.a.confirm();
                    } else {
                        this.a.cancel();
                    }
                }
            }
        }

        public class c implements DialogInterface.OnClickListener {
            public final /* synthetic */ JsPromptResult a;
            public final /* synthetic */ EditText b;

            public c(JsPromptResult jsPromptResult, EditText editText) {
                this.a = jsPromptResult;
                this.b = editText;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (DWebView.this.e) {
                    if (i == -1) {
                        this.a.confirm(this.b.getText().toString());
                    } else {
                        this.a.cancel();
                    }
                }
            }
        }

        public a() {
        }

        @Override // android.webkit.WebChromeClient
        public Bitmap getDefaultVideoPoster() {
            WebChromeClient webChromeClient = DWebView.this.c;
            return webChromeClient != null ? webChromeClient.getDefaultVideoPoster() : super.getDefaultVideoPoster();
        }

        @Override // android.webkit.WebChromeClient
        public View getVideoLoadingProgressView() {
            WebChromeClient webChromeClient = DWebView.this.c;
            return webChromeClient != null ? webChromeClient.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
        }

        @Override // android.webkit.WebChromeClient
        public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
            WebChromeClient webChromeClient = DWebView.this.c;
            if (webChromeClient != null) {
                webChromeClient.getVisitedHistory(valueCallback);
            } else {
                super.getVisitedHistory(valueCallback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onCloseWindow(WebView webView) {
            WebChromeClient webChromeClient = DWebView.this.c;
            if (webChromeClient != null) {
                webChromeClient.onCloseWindow(webView);
            } else {
                super.onCloseWindow(webView);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onConsoleMessage(String str, int i, String str2) {
            WebChromeClient webChromeClient = DWebView.this.c;
            if (webChromeClient != null) {
                webChromeClient.onConsoleMessage(str, i, str2);
            } else {
                super.onConsoleMessage(str, i, str2);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            WebChromeClient webChromeClient = DWebView.this.c;
            return webChromeClient != null ? webChromeClient.onCreateWindow(webView, z, z2, message) : super.onCreateWindow(webView, z, z2, message);
        }

        @Override // android.webkit.WebChromeClient
        public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            WebChromeClient webChromeClient = DWebView.this.c;
            if (webChromeClient != null) {
                webChromeClient.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
            } else {
                super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsHidePrompt() {
            WebChromeClient webChromeClient = DWebView.this.c;
            if (webChromeClient != null) {
                webChromeClient.onGeolocationPermissionsHidePrompt();
            } else {
                super.onGeolocationPermissionsHidePrompt();
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            WebChromeClient webChromeClient = DWebView.this.c;
            if (webChromeClient != null) {
                webChromeClient.onGeolocationPermissionsShowPrompt(str, callback);
            } else {
                super.onGeolocationPermissionsShowPrompt(str, callback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            WebChromeClient webChromeClient = DWebView.this.c;
            if (webChromeClient != null) {
                webChromeClient.onHideCustomView();
            } else {
                super.onHideCustomView();
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            if (!DWebView.this.e) {
                jsResult.confirm();
            }
            WebChromeClient webChromeClient = DWebView.this.c;
            if (webChromeClient != null && webChromeClient.onJsAlert(webView, str, str2, jsResult)) {
                return true;
            }
            new AlertDialog.Builder(DWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(R.string.ok, new DialogInterfaceOnClickListenerC0274a(jsResult)).create().show();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            WebChromeClient webChromeClient = DWebView.this.c;
            return webChromeClient != null ? webChromeClient.onJsBeforeUnload(webView, str, str2, jsResult) : super.onJsBeforeUnload(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            if (!DWebView.this.e) {
                jsResult.confirm();
            }
            WebChromeClient webChromeClient = DWebView.this.c;
            if (webChromeClient != null && webChromeClient.onJsConfirm(webView, str, str2, jsResult)) {
                return true;
            }
            b bVar = new b(jsResult);
            new AlertDialog.Builder(DWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(R.string.ok, bVar).setNegativeButton(R.string.cancel, bVar).show();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (!DWebView.this.e) {
                jsPromptResult.confirm();
            }
            WebChromeClient webChromeClient = DWebView.this.c;
            if (webChromeClient != null && webChromeClient.onJsPrompt(webView, str, str2, str3, jsPromptResult)) {
                return true;
            }
            EditText editText = new EditText(DWebView.this.getContext());
            editText.setText(str3);
            if (str3 != null) {
                editText.setSelection(str3.length());
            }
            float f = DWebView.this.getContext().getResources().getDisplayMetrics().density;
            c cVar = new c(jsPromptResult, editText);
            new AlertDialog.Builder(DWebView.this.getContext()).setTitle(str2).setView(editText).setCancelable(false).setPositiveButton(R.string.ok, cVar).setNegativeButton(R.string.cancel, cVar).show();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            int i = (int) (16.0f * f);
            layoutParams.setMargins(i, 0, i, 0);
            layoutParams.gravity = 1;
            editText.setLayoutParams(layoutParams);
            int i2 = (int) (15.0f * f);
            editText.setPadding(i2 - ((int) (f * 5.0f)), i2, i2, i2);
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsTimeout() {
            WebChromeClient webChromeClient = DWebView.this.c;
            return webChromeClient != null ? webChromeClient.onJsTimeout() : super.onJsTimeout();
        }

        @Override // android.webkit.WebChromeClient
        @TargetApi(21)
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            WebChromeClient webChromeClient = DWebView.this.c;
            if (webChromeClient != null) {
                webChromeClient.onPermissionRequest(permissionRequest);
            } else {
                super.onPermissionRequest(permissionRequest);
            }
        }

        @Override // android.webkit.WebChromeClient
        @TargetApi(21)
        public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
            WebChromeClient webChromeClient = DWebView.this.c;
            if (webChromeClient != null) {
                webChromeClient.onPermissionRequestCanceled(permissionRequest);
            } else {
                super.onPermissionRequestCanceled(permissionRequest);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            WebChromeClient webChromeClient = DWebView.this.c;
            if (webChromeClient != null) {
                webChromeClient.onProgressChanged(webView, i);
            } else {
                super.onProgressChanged(webView, i);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            WebChromeClient webChromeClient = DWebView.this.c;
            if (webChromeClient != null) {
                webChromeClient.onReceivedIcon(webView, bitmap);
            } else {
                super.onReceivedIcon(webView, bitmap);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            WebChromeClient webChromeClient = DWebView.this.c;
            if (webChromeClient != null) {
                webChromeClient.onReceivedTitle(webView, str);
            } else {
                super.onReceivedTitle(webView, str);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
            WebChromeClient webChromeClient = DWebView.this.c;
            if (webChromeClient != null) {
                webChromeClient.onReceivedTouchIconUrl(webView, str, z);
            } else {
                super.onReceivedTouchIconUrl(webView, str, z);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onRequestFocus(WebView webView) {
            WebChromeClient webChromeClient = DWebView.this.c;
            if (webChromeClient != null) {
                webChromeClient.onRequestFocus(webView);
            } else {
                super.onRequestFocus(webView);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            WebChromeClient webChromeClient = DWebView.this.c;
            if (webChromeClient != null) {
                webChromeClient.onShowCustomView(view, customViewCallback);
            } else {
                super.onShowCustomView(view, customViewCallback);
            }
        }

        @Override // android.webkit.WebChromeClient
        @TargetApi(21)
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            WebChromeClient webChromeClient = DWebView.this.c;
            return webChromeClient != null ? webChromeClient.onShowFileChooser(webView, valueCallback, fileChooserParams) : super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            WebChromeClient webChromeClient = DWebView.this.c;
            if (webChromeClient != null) {
                return webChromeClient.onConsoleMessage(consoleMessage);
            }
            return super.onConsoleMessage(consoleMessage);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
            WebChromeClient webChromeClient = DWebView.this.c;
            if (webChromeClient != null) {
                webChromeClient.onShowCustomView(view, i, customViewCallback);
            } else {
                super.onShowCustomView(view, i, customViewCallback);
            }
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        Message message = new Message();
        message.what = 3;
        message.obj = new e(this, str, map);
        this.d.sendMessage(message);
    }

    public DWebView(Context context) {
        super(context);
        this.a = new HashMap();
        this.d = null;
        this.e = true;
        this.f = null;
        this.g = new ArrayList<>();
        this.h = new HashMap();
        this.i = new a();
        init();
    }
}
