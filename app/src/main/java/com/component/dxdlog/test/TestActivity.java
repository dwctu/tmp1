package com.component.dxdlog.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.core.app.NotificationCompat;
import com.component.dxdlog.test.TestActivity;
import com.component.dxhttp.R;
import com.component.dxutilcode.lib.utils.ToastUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import dc.de0;
import dc.dy;
import dc.fy;
import dc.gz;
import dc.hx;
import dc.iz;
import dc.jx;
import dc.ky;
import dc.ly;
import dc.mz;
import dc.nx;
import dc.nz;
import dc.qx;
import dc.ve0;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: TestActivity.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/component/dxdlog/test/TestActivity;", "Landroidx/activity/ComponentActivity;", "()V", "isCreatingLog", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isUploadingLog", "initSDK", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TestActivity extends ComponentActivity {

    @NotNull
    public final AtomicBoolean a = new AtomicBoolean(false);

    @NotNull
    public final AtomicBoolean b = new AtomicBoolean(false);

    /* compiled from: TestActivity.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\r"}, d2 = {"com/component/dxdlog/test/TestActivity$initSDK$1", "Lcom/component/dxhttp/IAppConfig;", "getAppCode", "Lcom/component/dxhttp/AppCode;", "getGtoken", "", "getX", "onGetNewToken", "", "onLoginOut", XHTMLText.CODE, NotificationCompat.CATEGORY_MESSAGE, "exitType", "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements fy {
        @Override // dc.fy
        @NotNull
        public dy b() {
            return dy.UNKNOW;
        }

        @Override // dc.fy
        public void c() {
            de0.l("onGetNewToken");
        }

        @Override // dc.fy
        @NotNull
        public String d() {
            return "";
        }

        @Override // dc.fy
        public void e(@NotNull String code, @NotNull String msg, @NotNull String exitType) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(exitType, "exitType");
            de0.l("onLoginOut");
        }

        @Override // dc.fy
        @NotNull
        public String getX() {
            return "";
        }
    }

    /* compiled from: TestActivity.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/component/dxdlog/test/TestActivity$initSDK$2", "Lcom/component/dxhyttoutils/lib/listener/IHyttoAppActionEngine;", "addLog", "", "logNo", "", FirebaseAnalytics.Param.CONTENT, "", "sendLog", "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements mz {
        @Override // dc.mz
        public void a(@NotNull String logNo, @NotNull Object content) {
            Intrinsics.checkNotNullParameter(logNo, "logNo");
            Intrinsics.checkNotNullParameter(content, "content");
            de0.l("sendLog");
        }

        @Override // dc.mz
        public void b(@NotNull String logNo, @NotNull Object content) {
            Intrinsics.checkNotNullParameter(logNo, "logNo");
            Intrinsics.checkNotNullParameter(content, "content");
            de0.l("addLog");
        }
    }

    /* compiled from: TestActivity.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\n"}, d2 = {"com/component/dxdlog/test/TestActivity$initSDK$3", "Lcom/component/dxhyttoutils/lib/listener/IHyttoAppDataEngine;", "getAppAccountCode", "", "getAppName", "getAppVersion", "getHyttoAppCode", "Lcom/component/dxhyttoutils/lib/data/HyttoEum$AppCode;", "getX", "getY", "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c implements nz {
        @Override // dc.nz
        @NotNull
        public String a() {
            return "1.0.1";
        }

        @Override // dc.nz
        @NotNull
        public iz b() {
            return iz.REMOTE;
        }

        @Override // dc.nz
        @NotNull
        public List<String> c() {
            return nz.a.a(this);
        }

        @Override // dc.nz
        @Nullable
        public String getX() {
            return "";
        }

        @Override // dc.nz
        @Nullable
        public String getY() {
            return "";
        }
    }

    /* compiled from: TestActivity.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/component/dxdlog/test/TestActivity$onCreate$2$1", "Lcom/component/dxdlog/UploadLogListener;", "onComplete", "", "isSuccess", "", "errorMsg", "", "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d implements nx {
        public d() {
        }

        @Override // dc.nx
        public void a(boolean z, @Nullable String str) {
            if (z) {
                ToastUtils.z("上传成功，result = " + str, new Object[0]);
            } else if (!z) {
                ToastUtils.w("上传失败，errorMsg = " + str, new Object[0]);
            }
            TestActivity.this.getB().set(false);
        }
    }

    public static final void m4(TestActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.a.compareAndSet(false, true)) {
            ToastUtils.z("日志正在创建中，请勿重复点击", new Object[0]);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 10001; i++) {
            hx.i("test v", jCurrentTimeMillis + " test 添加日志，好久好难，测试测试DXDLog.v；test 添加日志，好久好难，测试测试DXDLog.v；test 添加日志，好久好难，测试测试DXDLog.v；test 添加日志，好久好难，测试测试DXDLog.v；", new Object[0]);
            hx.f("test i", jCurrentTimeMillis + " test 添加日志，好久好难，测试测试DXDLog.i；对于那些更喜欢拦截器来处理重试的问题 - 在Sinan的答案的基础上，这里是我提出的拦截器", new Object[0]);
            hx.c("test d", jCurrentTimeMillis + " test 添加日志，好久好难，测试测试DXDLog.d；我遇到了和你一样的问题，这实际上是我的解决方案 . RxJava是一个非常好的库，可与Retrofit结合使用 . 除了重试之外，你甚至可以做很多很酷的事情", new Object[0]);
            hx.d("test e", jCurrentTimeMillis + " test 添加日志，好久好难，测试测试DXDLog.e；注意：为简单起见，我只是将HTTP代码> 404代码视为重试，请自行修改 。此外，如果http响应为200，那么上面的 rx.retryWhen 将不会被调用，如果你坚持检查这样的响应", new Object[0]);
            hx.j("test w", jCurrentTimeMillis + " test 添加日志，好久好难，测试测试DXDLog.w；我没有找到内置于其中任何一个的任何请求重试机制 . 在搜索更多时，我看到OkHttp似乎有沉默重试 . 我没有看到我的任何连接（HTTP或HTTPS）发生这种情况 . 如何使用okclient配置重试？", new Object[0]);
        }
        this$0.a.set(false);
        de0.l("log all time == " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public static final void n4(TestActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.b.compareAndSet(false, true)) {
            hx.h("测试上传日志文件", this$0.new d());
        } else {
            ToastUtils.z("日志正在上传中，请勿重复点击", new Object[0]);
        }
    }

    public final void i4() {
        ve0.b(getApplication());
        ky.o("https://test10.lovense-api.com/surfease");
        ky.n(new a());
        gz.d(new b(), new c());
        hx.g("1000", new jx());
        hx.b("test_dx_accountCode");
    }

    @NotNull
    /* renamed from: j4, reason: from getter */
    public final AtomicBoolean getB() {
        return this.b;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ly.activity_test);
        i4();
        Button button = (Button) findViewById(R.id.btnGetRequest);
        button.setText("添加日志");
        button.setOnClickListener(new View.OnClickListener() { // from class: dc.ox
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestActivity.m4(this.a, view);
            }
        });
        de0.l("测试日志打印");
        qx.b("XXXXX@gmail.com");
        Button button2 = (Button) findViewById(R.id.btnGoToJavaActivity);
        button2.setText("上传日志文件");
        button2.setOnClickListener(new View.OnClickListener() { // from class: dc.px
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestActivity.n4(this.a, view);
            }
        });
    }
}
