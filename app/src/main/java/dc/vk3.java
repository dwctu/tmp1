package dc;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import androidx.core.app.NotificationCompat;
import com.wear.util.WearUtils;
import com.wear.vibematevideo.NestedScrollWebView;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CheckInjectFileUtil.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0007J\u0010\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\u0013\u001a\u00020\u000bJ\b\u0010\u0014\u001a\u00020\u000bH\u0002R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/wear/vibematevideo/inject/CheckInjectFileUtil;", "", "webView", "Lcom/wear/vibematevideo/NestedScrollWebView;", "(Lcom/wear/vibematevideo/NestedScrollWebView;)V", "commonJsSet", "", "", "isCheckCommonjsInjecting", "", "androidCheckStmJsAlreadyInject", "", NotificationCompat.CATEGORY_MESSAGE, "cacheStmJsInjectStr", "injectStr", "checkStmJsAlreadyInject", "str", "checkStmJsInjectCallback", "result", "init", "injectCacheStmJsStr", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class vk3 {

    @NotNull
    public final NestedScrollWebView a;
    public boolean b;

    @Nullable
    public Set<String> c;

    public vk3(@NotNull NestedScrollWebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.a = webView;
    }

    public static final void d(String str, vk3 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!Intrinsics.areEqual("1", str)) {
            this$0.a.evaluateJavascript(yk3.c().j(), new ValueCallback() { // from class: dc.uk3
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    vk3.e((String) obj);
                }
            });
        }
        this$0.g();
        this$0.b = false;
    }

    public static final void e(String str) {
        String str2 = "checkStmJsAlreadyInject result: " + str;
    }

    public final synchronized void a(String str) {
        String str2 = "putStmJs injectStr: " + str;
        if (this.c == null) {
            this.c = Collections.synchronizedSet(new HashSet());
        }
        Set<String> set = this.c;
        Intrinsics.checkNotNull(set);
        set.add(str);
    }

    @JavascriptInterface
    public final void androidCheckStmJsAlreadyInject(@Nullable String msg) {
        c(msg);
    }

    public final void b(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        a(str);
        if (this.b) {
            return;
        }
        this.b = true;
        this.a.q("javascript:(function(){       window.checkStmjsInject.androidCheckStmJsAlreadyInject(window.StmJsInject);}())");
    }

    public final void c(@Nullable final String str) {
        String str2 = "checkStmJsAlreadyInject result: " + str;
        WearUtils.x.l.post(new Runnable() { // from class: dc.tk3
            @Override // java.lang.Runnable
            public final void run() {
                vk3.d(str, this);
            }
        });
    }

    public final void f() {
        this.a.addJavascriptInterface(this, "checkStmjsInject");
    }

    public final synchronized void g() {
        Set<String> set = this.c;
        if (set != null) {
            Intrinsics.checkNotNull(set);
            for (String str : set) {
                String str2 = "getStmJs str: " + str;
                this.a.evaluateJavascript(str, null);
            }
            Set<String> set2 = this.c;
            Intrinsics.checkNotNull(set2);
            set2.clear();
        }
    }
}
