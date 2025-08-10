package com.wear.vibematevideo.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.JsonSyntaxException;
import com.lovense.wear.R;
import com.sun.jna.Callback;
import com.wear.BaseActivity;
import com.wear.bean.vb.DownloadVbBean;
import com.wear.bean.vb.JsPatternUrlBean;
import com.wear.bean.vb.PatternEditControlVideoEvent;
import com.wear.bean.vb.PatternMediaStopEvent;
import com.wear.bean.vb.VideoCancelMuteBean;
import com.wear.bean.vb.VideoItemBean;
import com.wear.main.toy.ToyActivity;
import com.wear.util.WearUtils;
import com.wear.vibematevideo.NestedScrollWebView;
import com.wear.vibematevideo.ui.HtmlVideoActivity;
import com.wear.widget.MyActionBar;
import dc.ce3;
import dc.cs3;
import dc.dl3;
import dc.el3;
import dc.is3;
import dc.jk3;
import dc.lk3;
import dc.ll3;
import dc.mk3;
import dc.pc1;
import dc.pj3;
import dc.qk3;
import dc.se0;
import dc.vl2;
import dc.xc1;
import dc.xk3;
import dc.zk3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HtmlVideoActivity.kt */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0007J\u0012\u00101\u001a\u00020.2\b\u00102\u001a\u0004\u0018\u000103H\u0007J\u0010\u00104\u001a\u00020.2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00105\u001a\u00020.2\u0006\u00106\u001a\u00020\u000eH\u0002J\u0012\u00107\u001a\u00020.2\b\u00108\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u00109\u001a\u00020.2\b\u0010:\u001a\u0004\u0018\u00010\u000eH\u0007J\u0010\u0010;\u001a\u00020.2\u0006\u0010/\u001a\u00020<H\u0007J\u0010\u0010=\u001a\u00020.2\u0006\u0010/\u001a\u00020>H\u0007J\u0010\u0010=\u001a\u00020.2\u0006\u0010?\u001a\u00020\u000eH\u0007J\b\u0010@\u001a\u00020.H\u0016J\b\u0010A\u001a\u00020.H\u0016J\b\u0010B\u001a\u00020.H\u0002J\b\u0010C\u001a\u00020.H\u0002J\b\u0010D\u001a\u00020.H\u0002J\u0010\u0010E\u001a\u00020.2\u0006\u0010F\u001a\u00020GH\u0002J\b\u0010H\u001a\u00020.H\u0002J\u0012\u0010I\u001a\u00020.2\b\u0010?\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010J\u001a\u00020.2\u0006\u0010K\u001a\u00020LH\u0002J\u0012\u0010M\u001a\u00020.2\b\u0010:\u001a\u0004\u0018\u00010\u000eH\u0007J\u0012\u0010N\u001a\u00020.2\b\u0010O\u001a\u0004\u0018\u00010PH\u0014J\b\u0010Q\u001a\u00020.H\u0014J\b\u0010R\u001a\u00020.H\u0014J\b\u0010S\u001a\u00020.H\u0014J2\u0010T\u001a\u00020.2\b\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010W\u001a\u00020\f2\u0006\u0010X\u001a\u00020\f2\u0006\u0010Y\u001a\u00020\f2\u0006\u0010Z\u001a\u00020\fH\u0016J\u001c\u0010[\u001a\u00020.2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u00108\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010^\u001a\u00020.2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u00108\u001a\u0004\u0018\u00010\u000e2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\u0010\u0010a\u001a\u00020.2\u0006\u0010/\u001a\u00020bH\u0007J\u0010\u0010c\u001a\u00020.2\u0006\u0010/\u001a\u00020dH\u0007J\u001a\u0010e\u001a\u00020.2\b\u0010\\\u001a\u0004\u0018\u00010]2\u0006\u0010f\u001a\u00020\fH\u0016J\u001c\u0010g\u001a\u00020h2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u00108\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010i\u001a\u00020.2\b\u0010\\\u001a\u0004\u0018\u00010V2\b\u0010j\u001a\u0004\u0018\u00010kH\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n \u001e*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001e\u0010'\u001a\u00020(8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006l"}, d2 = {"Lcom/wear/vibematevideo/ui/HtmlVideoActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "Lcom/wear/vibematevideo/js/VibeMateWebViewControlCallBack;", "()V", "actionbar", "Lcom/wear/widget/MyActionBar;", "getActionbar", "()Lcom/wear/widget/MyActionBar;", "setActionbar", "(Lcom/wear/widget/MyActionBar;)V", "curProgress", "", "currentUrl", "", "mFullscreenPlayPresenter", "Lcom/wear/vibematevideo/js/FullscreenPlayPresenter;", "getMFullscreenPlayPresenter", "()Lcom/wear/vibematevideo/js/FullscreenPlayPresenter;", "setMFullscreenPlayPresenter", "(Lcom/wear/vibematevideo/js/FullscreenPlayPresenter;)V", "patternUrl", "videoFullView", "Landroid/widget/FrameLayout;", "getVideoFullView", "()Landroid/widget/FrameLayout;", "setVideoFullView", "(Landroid/widget/FrameLayout;)V", "videoUrl", "webFragmentId", "kotlin.jvm.PlatformType", "webView", "Lcom/wear/vibematevideo/NestedScrollWebView;", "getWebView", "()Lcom/wear/vibematevideo/NestedScrollWebView;", "setWebView", "(Lcom/wear/vibematevideo/NestedScrollWebView;)V", "webViewControl", "Lcom/wear/vibematevideo/js/VibeMateWebViewControlImpl;", "webviewLayout", "Landroid/widget/RelativeLayout;", "getWebviewLayout", "()Landroid/widget/RelativeLayout;", "setWebviewLayout", "(Landroid/widget/RelativeLayout;)V", "androidConnectToyClickEvent", "", "event", "Lcom/wear/vibematevideo/event/AndroidConnectToyClickEvent;", "androidMediaClickMedia", "videoCancelMuteBean", "Lcom/wear/bean/vb/VideoCancelMuteBean;", "cancelMute", "checkUrlEquals", "tempUrl", "createWindow", ImagesContract.URL, "downloadEvent", NotificationCompat.CATEGORY_MESSAGE, "eventBusToyConnectEvent", "Lcom/lovense/btservice/work/EventBusToyConnectEvent;", "getMediaPatternCallback", "Lcom/wear/bean/vb/JsPatternUrlBean;", "result", "hideCustomView", "initInject", "initView", "initWebView", "jsGetMediaPattern", "jsToNextVideo", "videoItemBean", "Lcom/wear/bean/vb/VideoItemBean;", "loadWebUrl", "mediaStatus", "navigateToDownloadVb", "downloadVbBean", "Lcom/wear/bean/vb/DownloadVbBean;", "nextVideoEvent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onScrollChange", PSOProgramService.VS_Key, "Landroid/view/View;", "scrollX", "scrollY", "oldScrollX", "oldScrollY", "pageFinished", "view", "Landroid/webkit/WebView;", "pageStarted", "favicon", "Landroid/graphics/Bitmap;", "patternEditControlVideo", "Lcom/wear/bean/vb/PatternEditControlVideoEvent;", "patternMediaStopEvent", "Lcom/wear/bean/vb/PatternMediaStopEvent;", "progressChanged", "newProgress", "shouldOverrideUrlLoading", "", "showCustomView", Callback.METHOD_NAME, "Landroid/webkit/WebChromeClient$CustomViewCallback;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class HtmlVideoActivity extends BaseActivity<vl2> implements dl3 {

    @Nullable
    public NestedScrollWebView a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public final String b = WearUtils.E();

    @Nullable
    public String c;

    @Nullable
    public String d;

    @Nullable
    public String e;
    public zk3 f;

    @androidx.annotation.Nullable
    @Nullable
    public el3 g;
    public int h;

    @BindView(R.id.ac_htmlvideo_fullView)
    public FrameLayout videoFullView;

    @BindView(R.id.ac_htmlvideo_webView_layout)
    public RelativeLayout webviewLayout;

    public static final void A4(HtmlVideoActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
        this$0.overridePendingTransition(0, R.anim.from_top_to_bottom);
    }

    public static final void C4(HtmlVideoActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    public static final void D4() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void N4(HtmlVideoActivity this$0, Ref.ObjectRef videoItemBean) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(videoItemBean, "$videoItemBean");
        T videoItemBean2 = videoItemBean.element;
        Intrinsics.checkNotNullExpressionValue(videoItemBean2, "videoItemBean");
        this$0.F4((VideoItemBean) videoItemBean2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void u4(HtmlVideoActivity this$0, Ref.ObjectRef downloadVbBean) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(downloadVbBean, "$downloadVbBean");
        T downloadVbBean2 = downloadVbBean.element;
        Intrinsics.checkNotNullExpressionValue(downloadVbBean2, "downloadVbBean");
        this$0.M4((DownloadVbBean) downloadVbBean2);
    }

    public final void B4() {
        try {
            this.a = new NestedScrollWebView(this);
            y4().addView(this.a, -1, -1);
            this.g = new el3();
            NestedScrollWebView nestedScrollWebView = this.a;
            if (nestedScrollWebView != null) {
                nestedScrollWebView.addJavascriptInterface(this, "joinSelf");
            }
            el3 el3Var = this.g;
            Intrinsics.checkNotNull(el3Var);
            el3Var.e(this, this.a, this.b, this);
            el3 el3Var2 = this.g;
            Intrinsics.checkNotNull(el3Var2);
            el3Var2.g(this.d);
            L4();
            this.progressDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
            is3.b bVar = new is3.b(this);
            bVar.p("Page cannot be displayed. Please try again.");
            bVar.d(new is3.d() { // from class: dc.nl3
                @Override // dc.is3.d
                public final void doConfirm() {
                    HtmlVideoActivity.C4(this.a);
                }
            });
            bVar.c(new is3.c() { // from class: dc.pl3
                @Override // dc.is3.c
                public final void doCancel() {
                    HtmlVideoActivity.D4();
                }
            });
            cs3.h(bVar).show();
        }
    }

    public final void E4() {
        xk3 xk3VarC;
        el3 el3Var = this.g;
        if (el3Var == null || (xk3VarC = el3Var.c()) == null) {
            return;
        }
        xk3VarC.g(this.d);
    }

    @Override // dc.dl3
    public void F1(@Nullable WebView webView, int i) {
        if (i == 10 && this.h != 10) {
            ll3.E().b0(this.b, this.d);
        } else if (i == 100 && this.h != 100) {
            this.h = i;
            lk3.a aVar = lk3.a;
            Intrinsics.checkNotNull(webView);
            t4(aVar.a(webView));
            ll3.E().X(this.b, this.d);
            if (this.progressDialog.isShowing()) {
                this.progressDialog.dismiss();
            }
        }
        this.h = i;
    }

    public final void F4(VideoItemBean videoItemBean) {
        this.c = videoItemBean.getVideoUrl();
        this.e = videoItemBean.getPatternUrl();
        if (this.c == null) {
            finish();
        }
        String str = this.c;
        this.d = str;
        el3 el3Var = this.g;
        if (el3Var != null) {
            el3Var.g(str);
        }
        ll3.E().l0(this.c);
        ll3.E().w(this.e);
        L4();
    }

    @Override // dc.dl3
    public void G2(@Nullable WebView webView, @Nullable String str) {
        if (this.progressDialog.isShowing()) {
            this.progressDialog.dismiss();
        }
    }

    @Override // dc.dl3
    public boolean K0(@Nullable WebView webView, @Nullable String str) {
        return false;
    }

    @Override // dc.dl3
    public void K1(@Nullable String str) {
    }

    public final void L4() {
        NestedScrollWebView nestedScrollWebView = this.a;
        if (nestedScrollWebView != null) {
            String str = this.d;
            Intrinsics.checkNotNull(str);
            nestedScrollWebView.loadUrl(str);
        }
    }

    public final void M4(DownloadVbBean downloadVbBean) {
        ll3.E().e0("video", "click", "first area", null, null);
        ll3.E().U(this, downloadVbBean, this.d, 53);
    }

    @Override // dc.dl3
    public void W(@Nullable String str) {
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void androidConnectToyClickEvent(@NotNull qk3 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        pj3.f(this, ToyActivity.class);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void androidMediaClickMedia(@Nullable VideoCancelMuteBean videoCancelMuteBean) {
        Intrinsics.checkNotNull(videoCancelMuteBean);
        s4(videoCancelMuteBean);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.Object] */
    @JavascriptInterface
    public final void downloadEvent(@Nullable String msg) throws JsonSyntaxException {
        if (msg != null) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? FromJson = WearUtils.A.fromJson(msg, (Class<??>) DownloadVbBean.class);
            objectRef.element = FromJson;
            if (FromJson != 0) {
                se0.f(new Runnable() { // from class: dc.ql3
                    @Override // java.lang.Runnable
                    public final void run() {
                        HtmlVideoActivity.u4(this.a, objectRef);
                    }
                });
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void eventBusToyConnectEvent(@NotNull xc1 event) {
        xk3 xk3VarC;
        Intrinsics.checkNotNullParameter(event, "event");
        el3 el3Var = this.g;
        if (el3Var == null || (xk3VarC = el3Var.c()) == null) {
            return;
        }
        xk3VarC.j(this.d);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void getMediaPatternCallback(@NotNull JsPatternUrlBean event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ll3.E().w(event.getPatternUrl());
    }

    @Override // dc.dl3
    public void hideCustomView() {
        try {
            w4().a(this, x4());
        } catch (Exception e) {
            String str = "onHideCustomView e: " + e;
            e.printStackTrace();
        }
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        super.initInject();
        this.mActivityComponent.a(this);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.Object] */
    @JavascriptInterface
    public final void nextVideoEvent(@Nullable String msg) throws JsonSyntaxException {
        if (msg != null) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? FromJson = WearUtils.A.fromJson(msg, (Class<??>) VideoItemBean.class);
            objectRef.element = FromJson;
            if (FromJson == 0 || !((VideoItemBean) FromJson).noEmpty()) {
                return;
            }
            se0.f(new Runnable() { // from class: dc.ml3
                @Override // java.lang.Runnable
                public final void run() {
                    HtmlVideoActivity.N4(this.a, objectRef);
                }
            });
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_htmlvideo);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        this.c = getIntent().getStringExtra("videoUrl");
        this.e = getIntent().getStringExtra("patternUrl");
        if (this.c == null) {
            finish();
        }
        this.d = this.c;
        z4();
        B4();
        ll3.E().Y(this.b, this.c);
        ll3.E().w(this.e);
        ll3.E().e0("video", "open", null, null, null);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ll3.E().W();
        el3 el3Var = this.g;
        if (el3Var != null) {
            el3Var.a();
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ll3.E().Z(this.b, this.d);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ll3.E().a0(this.b, this.d);
    }

    @Override // dc.dl3
    public void onScrollChange(@Nullable View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void patternEditControlVideo(@NotNull PatternEditControlVideoEvent event) {
        xk3 xk3VarC;
        Intrinsics.checkNotNullParameter(event, "event");
        el3 el3Var = this.g;
        if (el3Var == null || (xk3VarC = el3Var.c()) == null) {
            return;
        }
        xk3VarC.i(event);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void patternMediaStopEvent(@NotNull PatternMediaStopEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        finish();
    }

    public final void s4(VideoCancelMuteBean videoCancelMuteBean) {
        Integer left = videoCancelMuteBean.getLeft();
        int iIntValue = left != null ? left.intValue() : 0;
        Integer top = videoCancelMuteBean.getTop();
        int iIntValue2 = top != null ? top.intValue() : 0;
        int iA = ce3.a(this, iIntValue);
        int iA2 = ce3.a(this, iIntValue2);
        if (iA <= 0 || iA2 <= 0) {
            return;
        }
        jk3.a(this.a, iA, iA2);
    }

    @Override // dc.dl3
    public void showCustomView(@Nullable View view, @Nullable WebChromeClient.CustomViewCallback callback) {
        try {
            w4().b(this, x4(), view, callback);
        } catch (Exception e) {
            String str = "showCustomView e: " + e;
            e.printStackTrace();
        }
    }

    public final void t4(String str) {
        xk3 xk3VarC;
        if (TextUtils.equals(str, this.d)) {
            return;
        }
        boolean zA = ll3.E().A(str, this.d);
        this.d = str;
        el3 el3Var = this.g;
        if (el3Var != null) {
            el3Var.g(str);
        }
        el3 el3Var2 = this.g;
        if (el3Var2 != null && (xk3VarC = el3Var2.c()) != null) {
            xk3VarC.j(this.d);
        }
        ll3 ll3VarE = ll3.E();
        String str2 = pc1.a.P().isEmpty() ? "0" : "1";
        mk3 mk3Var = mk3.a;
        String str3 = this.d;
        Intrinsics.checkNotNull(str3);
        ll3VarE.f0("video", "open", "sync_bar", str2, mk3Var.o(str3) ? "1" : "0");
        ll3.E().l0(this.d);
        if (zA) {
            return;
        }
        E4();
    }

    @NotNull
    public final MyActionBar v4() {
        MyActionBar myActionBar = this.actionbar;
        if (myActionBar != null) {
            return myActionBar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("actionbar");
        return null;
    }

    @NotNull
    public final zk3 w4() {
        zk3 zk3Var = this.f;
        if (zk3Var != null) {
            return zk3Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mFullscreenPlayPresenter");
        return null;
    }

    @NotNull
    public final FrameLayout x4() {
        FrameLayout frameLayout = this.videoFullView;
        if (frameLayout != null) {
            return frameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("videoFullView");
        return null;
    }

    @NotNull
    public final RelativeLayout y4() {
        RelativeLayout relativeLayout = this.webviewLayout;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("webviewLayout");
        return null;
    }

    @Override // dc.dl3
    public void z0(@Nullable WebView webView, @Nullable String str, @Nullable Bitmap bitmap) {
    }

    public final void z4() {
        v4().setImageBackAction(Integer.valueOf(R.drawable.nav_migrate_close), new MyActionBar.f() { // from class: dc.ol3
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                HtmlVideoActivity.A4(this.a, view);
            }
        }, 8);
        v4().setTitle("");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void getMediaPatternCallback(@NotNull String result) {
        Intrinsics.checkNotNullParameter(result, "result");
        String str = "" + result;
    }
}
