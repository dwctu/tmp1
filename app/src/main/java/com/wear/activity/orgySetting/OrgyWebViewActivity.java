package com.wear.activity.orgySetting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.main.FlashActivity;
import com.wear.main.MainActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.be3;
import dc.cs3;
import dc.fg3;
import dc.is3;
import dc.pj3;
import dc.q61;
import dc.sg3;
import dc.tq2;
import dc.u51;
import dc.xe3;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import org.bouncycastle.i18n.MessageBundle;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* loaded from: classes3.dex */
public class OrgyWebViewActivity extends BaseActivity {
    private static final int FILECHOOSER_RESULTCODE = 2;
    private static final String TAG = "OrgyWebViewActivity";
    private MyActionBar actionBar;
    private WebView browser;
    private OrgyWebChromeClient chromeClient;
    private FrameLayout frameLayout;
    private int from = 0;
    private Handler handler;
    private OrgyJsInterface orgyJsInterface;
    private String title;
    private TextView tvDebug;

    public class OrgyWebChromeClient extends WebChromeClient {
        public String cameraPhotoPath;
        private Activity context;
        public ValueCallback<Uri[]> mFilePathCallback;

        public OrgyWebChromeClient(Activity activity) {
            this.context = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(ValueCallback valueCallback, List list, boolean z) throws IOException {
            if (z) {
                openFileChooser(valueCallback, "image/*");
            } else {
                sg3.k(this.context, "Permission denied");
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (!TextUtils.isEmpty(OrgyWebViewActivity.this.title) || TextUtils.isEmpty(str)) {
                return;
            }
            OrgyWebViewActivity.this.title = str;
            OrgyWebViewActivity.this.actionBar.setTitle(OrgyWebViewActivity.this.title);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, final ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            q61 q61VarM = q61.m(this.context);
            q61VarM.h("android.permission.READ_MEDIA_IMAGES", "android.permission.CAMERA");
            q61VarM.j(new u51() { // from class: dc.ej1
                @Override // dc.u51
                public /* synthetic */ void a(List list, boolean z) {
                    t51.a(this, list, z);
                }

                @Override // dc.u51
                public final void b(List list, boolean z) throws IOException {
                    this.a.b(valueCallback, list, z);
                }
            });
            return true;
        }

        public void openFileChooser(ValueCallback<Uri[]> valueCallback, String str) throws IOException {
            Intent[] intentArr;
            this.mFilePathCallback = valueCallback;
            try {
                try {
                    File file = new File(WearUtils.T("picture"), "pic_" + be3.r() + ".jpg");
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    Uri uriForFile = Build.VERSION.SDK_INT >= 24 ? FileProvider.getUriForFile(OrgyWebViewActivity.this.activity, "com.lovense.wear.fileprovider", file) : Uri.fromFile(file);
                    this.cameraPhotoPath = "file:" + file.getAbsolutePath();
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("PhotoPath", this.cameraPhotoPath);
                    intent.putExtra("output", uriForFile);
                    intentArr = new Intent[]{intent};
                } catch (IOException unused) {
                    intentArr = new Intent[0];
                }
                Intent intent2 = new Intent("android.intent.action.CHOOSER");
                Intent intent3 = new Intent("android.intent.action.GET_CONTENT");
                intent3.addCategory("android.intent.category.OPENABLE");
                intent3.setType(str);
                intent2.putExtra("android.intent.extra.INTENT", intent3);
                intent2.putExtra("android.intent.extra.TITLE", "Image Chooser");
                intent2.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
                try {
                    OrgyWebViewActivity.this.activity.startActivityForResult(intent2, 2);
                } catch (Exception e) {
                    FirebaseCrashlytics.getInstance().recordException(new Throwable("显示系统选择照片和文件出错 showFileChooser: ", e));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void initWebView(Intent intent) {
        WebView webView = this.browser;
        if (webView == null) {
            finish();
            return;
        }
        this.frameLayout.addView(webView);
        this.browser.clearCache(true);
        this.browser.clearHistory();
        this.browser.requestFocus();
        WebSettings settings = this.browser.getSettings();
        settings.setDatabaseEnabled(true);
        settings.setMixedContentMode(2);
        settings.setJavaScriptEnabled(true);
        String stringExtra = intent.getStringExtra(ImagesContract.URL);
        if (!WearUtils.e1(stringExtra) && !stringExtra.toLowerCase().startsWith("http")) {
            stringExtra = WearUtils.e + intent.getStringExtra(ImagesContract.URL);
        }
        if (stringExtra == null) {
            return;
        }
        String str = "init urlString: " + stringExtra;
        this.browser.loadUrl(stringExtra);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        OrgyJsInterface orgyJsInterface = new OrgyJsInterface(this, this.browser);
        this.orgyJsInterface = orgyJsInterface;
        this.browser.addJavascriptInterface(orgyJsInterface, "joinSelf");
        OrgySetting.getInstance().addJavascriptInterface(this.orgyJsInterface);
        OrgyWebChromeClient orgyWebChromeClient = new OrgyWebChromeClient(this);
        this.chromeClient = orgyWebChromeClient;
        this.browser.setWebChromeClient(orgyWebChromeClient);
        this.actionBar.setBackAction(new MyActionBar.f() { // from class: com.wear.activity.orgySetting.OrgyWebViewActivity.4
            @Override // com.wear.widget.MyActionBar.f
            public void performAction(View view) {
                if (OrgyWebViewActivity.this.browser == null) {
                    if (OrgyWebViewActivity.this.from != 0) {
                        pj3.f(OrgyWebViewActivity.this, MainActivity.class);
                    }
                    OrgyWebViewActivity.this.finish();
                    return;
                }
                xe3.a(OrgyWebViewActivity.TAG, OrgyWebViewActivity.this.browser.getOriginalUrl());
                if (!OrgyWebViewActivity.this.browser.canGoBack()) {
                    if (OrgyWebViewActivity.this.from != 0) {
                        pj3.f(OrgyWebViewActivity.this, MainActivity.class);
                    }
                    OrgyWebViewActivity.this.finish();
                } else {
                    OrgyWebViewActivity.this.browser.goBack();
                    if (OrgyWebViewActivity.this.from != 0) {
                        pj3.f(OrgyWebViewActivity.this, MainActivity.class);
                    }
                    OrgyWebViewActivity.this.finish();
                }
            }
        });
        this.browser.setWebViewClient(new WebViewClient() { // from class: com.wear.activity.orgySetting.OrgyWebViewActivity.5
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str2) {
                super.onPageFinished(webView2, str2);
                if (OrgyWebViewActivity.this.isFinishing() || OrgyWebViewActivity.this.isDestroyed()) {
                    return;
                }
                xe3.a(OrgyWebViewActivity.TAG, "onPageFinished: " + str2);
                if (OrgyWebViewActivity.this.isLoadingProgressShowing()) {
                    OrgyWebViewActivity.this.delayHandler.postDelayed(new Runnable() { // from class: com.wear.activity.orgySetting.OrgyWebViewActivity.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (OrgyWebViewActivity.this.isFinishing() || OrgyWebViewActivity.this.isDestroyed()) {
                                return;
                            }
                            OrgyWebViewActivity.this.dismissLoadingProgress();
                        }
                    }, 100L);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView2, webResourceRequest, webResourceError);
                if (OrgyWebViewActivity.this.isFinishing() || OrgyWebViewActivity.this.isDestroyed()) {
                    return;
                }
                OrgyWebViewActivity.this.dismissLoadingProgress();
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str2) {
                if (!str2.startsWith("http://") && !str2.startsWith("https://")) {
                    return true;
                }
                webView2.loadUrl(str2);
                return true;
            }
        });
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.wear.activity.orgySetting.OrgyWebViewActivity.6
            @Override // android.os.Handler
            public void handleMessage(@NonNull Message message) {
                WebView.HitTestResult hitTestResult = OrgyWebViewActivity.this.browser.getHitTestResult();
                if (hitTestResult.getType() != 5) {
                    return;
                }
                String extra = hitTestResult.getExtra();
                if (TextUtils.isEmpty(extra)) {
                    return;
                }
                OrgyWebViewActivity.this.savePhoto(extra);
            }
        };
        this.browser.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.wear.activity.orgySetting.OrgyWebViewActivity.7
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                OrgyWebViewActivity.this.browser.requestFocusNodeHref(OrgyWebViewActivity.this.handler.obtainMessage());
                return false;
            }
        });
    }

    @RequiresApi(api = 26)
    private static boolean isInternalFile(Context context, ParcelFileDescriptor parcelFileDescriptor) throws Exception {
        Path symbolicLink = Files.readSymbolicLink(Paths.get("/proc/self/fd/" + parcelFileDescriptor.getFd(), new String[0]));
        Path path = Paths.get(context.getApplicationInfo().dataDir, new String[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("/data/data/");
        sb.append(context.getPackageName());
        return symbolicLink.startsWith(path) || symbolicLink.startsWith(Paths.get(sb.toString(), new String[0]));
    }

    @RequiresApi(api = 26)
    private static boolean isInternalUri(Context context, Uri uri) throws Exception {
        return isInternalFile(context, context.getContentResolver().openFileDescriptor(uri, StreamManagement.AckRequest.ELEMENT));
    }

    private void performInitWebView(Intent intent, String str, int i) {
        try {
            if (!TextUtils.isEmpty(str) && Build.VERSION.SDK_INT >= 28) {
                WebView.setDataDirectorySuffix(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.browser = new WebView(this);
            initWebView(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e2);
            is3.b bVar = new is3.b(this);
            bVar.p("Page cannot be displayed. Please try again.");
            bVar.d(new is3.d() { // from class: com.wear.activity.orgySetting.OrgyWebViewActivity.3
                @Override // dc.is3.d
                public void doConfirm() {
                    Intent intent2 = new Intent(OrgyWebViewActivity.this.activity, (Class<?>) FlashActivity.class);
                    pj3.d(intent2);
                    intent2.addFlags(268468224);
                    OrgyWebViewActivity.this.startActivity(intent2);
                    MyApplication.D();
                }
            });
            bVar.c(new is3.c() { // from class: com.wear.activity.orgySetting.OrgyWebViewActivity.2
                @Override // dc.is3.c
                public void doCancel() {
                }
            });
            cs3.h(bVar).show();
        }
    }

    @RequiresApi(api = 26)
    private boolean processPickedUri(Uri uri) {
        try {
            return isInternalUri(this, uri);
        } catch (Exception unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void savePhoto(String str) {
        fg3.f(str, fg3.d(str));
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            tq2.a().e(i, i2, intent);
        } else {
            if (i != 2) {
                return;
            }
            showFileChooserResult(intent, i2);
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_help_frequent);
        EventBus.getDefault().register(this);
        this.actionBar = (MyActionBar) findViewById(R.id.actionbar);
        final Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(MessageBundle.TITLE_ENTRY);
        this.title = stringExtra;
        this.actionBar.setTitle(stringExtra);
        if (WearUtils.B) {
            this.actionBar.getLabelStatus().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.wear.activity.orgySetting.OrgyWebViewActivity.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (OrgyWebViewActivity.this.tvDebug.getVisibility() == 0) {
                        OrgyWebViewActivity.this.tvDebug.setVisibility(8);
                    } else {
                        OrgyWebViewActivity.this.tvDebug.setVisibility(0);
                    }
                    OrgyWebViewActivity.this.tvDebug.setText(String.format(Locale.getDefault(), "url: %s\n", intent.getStringExtra(ImagesContract.URL)));
                    return false;
                }
            });
        }
        this.from = intent.getIntExtra("from", 0);
        this.frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
        this.tvDebug = (TextView) findViewById(R.id.tv_debug);
        performInitWebView(intent, null, 0);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        dismissLoadingProgress();
        WebView webView = this.browser;
        if (webView != null) {
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.browser);
            }
            this.browser.clearCache(true);
            this.browser.removeAllViews();
            this.browser.clearHistory();
            this.browser.destroy();
        }
        OrgyJsInterface orgyJsInterface = this.orgyJsInterface;
        if (orgyJsInterface != null) {
            orgyJsInterface.onDestroy();
            OrgySetting.getInstance().removeOrgyJsInterface(this.orgyJsInterface);
            this.orgyJsInterface = null;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        WebView webView = this.browser;
        if (webView == null) {
            return super.onKeyDown(i, keyEvent);
        }
        xe3.a(TAG, webView.getOriginalUrl());
        if (i != 4 || !this.browser.canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.browser.goBack();
        if (this.from != 0) {
            pj3.f(this, MainActivity.class);
        }
        finish();
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(OrgyReloadUrlEvent orgyReloadUrlEvent) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        if (orgyReloadUrlEvent.getShowLoading() == 0) {
            dismissLoadingProgress();
            return;
        }
        if (orgyReloadUrlEvent.getShowLoading() == 1) {
            showLoadingProgress();
            return;
        }
        if (this.browser == null || WearUtils.e1(orgyReloadUrlEvent.getUrl())) {
            return;
        }
        showLoadingProgress();
        xe3.a(TAG, "onMessageEvent urlString: " + orgyReloadUrlEvent.getUrl());
        this.browser.loadUrl(orgyReloadUrlEvent.getUrl());
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void showFileChooserResult(android.content.Intent r5, int r6) {
        /*
            r4 = this;
            r0 = 0
            r1 = -1
            if (r6 != r1) goto L3c
            r6 = 0
            r1 = 1
            if (r5 != 0) goto L17
            com.wear.activity.orgySetting.OrgyWebViewActivity$OrgyWebChromeClient r5 = r4.chromeClient
            java.lang.String r5 = r5.cameraPhotoPath
            if (r5 == 0) goto L3c
            android.net.Uri[] r1 = new android.net.Uri[r1]
            android.net.Uri r5 = android.net.Uri.parse(r5)
            r1[r6] = r5
            goto L3d
        L17:
            android.net.Uri r5 = r5.getData()
            if (r5 == 0) goto L3c
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            if (r2 < r3) goto L37
            boolean r2 = r4.processPickedUri(r5)
            if (r2 == 0) goto L37
            com.wear.activity.orgySetting.OrgyWebViewActivity$OrgyWebChromeClient r5 = r4.chromeClient
            android.webkit.ValueCallback<android.net.Uri[]> r5 = r5.mFilePathCallback
            if (r5 == 0) goto L32
            r5.onReceiveValue(r0)
        L32:
            com.wear.activity.orgySetting.OrgyWebViewActivity$OrgyWebChromeClient r5 = r4.chromeClient
            r5.mFilePathCallback = r0
            return
        L37:
            android.net.Uri[] r1 = new android.net.Uri[r1]
            r1[r6] = r5
            goto L3d
        L3c:
            r1 = r0
        L3d:
            com.wear.activity.orgySetting.OrgyWebViewActivity$OrgyWebChromeClient r5 = r4.chromeClient
            android.webkit.ValueCallback<android.net.Uri[]> r5 = r5.mFilePathCallback
            if (r5 == 0) goto L46
            r5.onReceiveValue(r1)
        L46:
            com.wear.activity.orgySetting.OrgyWebViewActivity$OrgyWebChromeClient r5 = r4.chromeClient
            r5.mFilePathCallback = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.activity.orgySetting.OrgyWebViewActivity.showFileChooserResult(android.content.Intent, int):void");
    }
}
