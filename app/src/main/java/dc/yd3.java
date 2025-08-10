package dc;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.mp1;
import dc.nz;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: DXComponent.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0003J\b\u0010\b\u001a\u00020\u0006H\u0007J\b\u0010\t\u001a\u00020\u0006H\u0007J\b\u0010\n\u001a\u00020\u0006H\u0007J\b\u0010\u000b\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/wear/util/DXComponent;", "", "()V", "isInitToyConfigEnv", "", "init", "", "initDXHytto", "initDXToy", "initFeatureConfig", "initNetwork", "updateToyConfig", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class yd3 {

    @NotNull
    public static final yd3 a = new yd3();
    public static boolean b;

    /* compiled from: DXComponent.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/wear/util/DXComponent$initDXHytto$actionEngine$1", "Lcom/component/dxhyttoutils/lib/listener/IHyttoAppActionEngine;", "addLog", "", "logNo", "", FirebaseAnalytics.Param.CONTENT, "", "sendLog", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements mz {
        @Override // dc.mz
        public void a(@NotNull String logNo, @NotNull Object content) {
            Intrinsics.checkNotNullParameter(logNo, "logNo");
            Intrinsics.checkNotNullParameter(content, "content");
            de0.l("sendLog: " + logNo + ", " + content);
            ye3.R(logNo, xd0.j(content));
        }

        @Override // dc.mz
        public void b(@NotNull String logNo, @NotNull Object content) {
            Intrinsics.checkNotNullParameter(logNo, "logNo");
            Intrinsics.checkNotNullParameter(content, "content");
            de0.l("addLog: " + logNo + ", " + content);
            ye3.d(logNo, xd0.j(content));
        }
    }

    /* compiled from: DXComponent.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u000b"}, d2 = {"com/wear/util/DXComponent$initDXHytto$dataEngine$1", "Lcom/component/dxhyttoutils/lib/listener/IHyttoAppDataEngine;", "getAppAccountCode", "", "getAppVersion", "getAppVersionCode", "", "getHyttoAppCode", "Lcom/component/dxhyttoutils/lib/data/HyttoEum$AppCode;", "getX", "getY", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements nz {
        @Override // dc.nz
        @NotNull
        public String a() {
            String APP_VERSION = WearUtils.q;
            Intrinsics.checkNotNullExpressionValue(APP_VERSION, "APP_VERSION");
            return APP_VERSION;
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
            return WearUtils.Q0().x;
        }

        @Override // dc.nz
        @Nullable
        public String getY() {
            return WearUtils.Q0().y;
        }
    }

    /* compiled from: DXComponent.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\r"}, d2 = {"com/wear/util/DXComponent$initNetwork$1", "Lcom/component/dxhttp/IAppConfig;", "getAppCode", "Lcom/component/dxhttp/AppCode;", "getGtoken", "", "getX", "onGetNewToken", "", "onLoginOut", XHTMLText.CODE, NotificationCompat.CATEGORY_MESSAGE, "exitType", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements fy {
        @Override // dc.fy
        @NotNull
        public dy b() {
            return dy.REMOTE;
        }

        @Override // dc.fy
        public void c() {
        }

        @Override // dc.fy
        @NotNull
        public String d() {
            String strI = nd3.i(eg3.h(WearUtils.x, "gen_token_Key", ""));
            return strI == null ? "" : strI;
        }

        @Override // dc.fy
        public void e(@NotNull String code, @NotNull String msg, @NotNull String exitType) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(exitType, "exitType");
        }

        @Override // dc.fy
        @NotNull
        public String getX() {
            String str = WearUtils.Q0().x;
            return str == null ? "" : str;
        }
    }

    @JvmStatic
    public static final void a() {
        b();
        pz.a.c();
        ve0.b(WearUtils.x);
        zz.a(false);
        aj2.a();
    }

    @JvmStatic
    public static final void b() {
        gz.d(new a(), new b());
    }

    @JvmStatic
    public static final void c() {
        StringBuilder sb = new StringBuilder();
        sb.append("ToyInit isUseNew =");
        mp1.b bVar = mp1.a;
        sb.append(bVar.b());
        de0.l(sb.toString());
        if (bVar.b()) {
            new mp1().f();
        } else {
            new mp1().d();
            MyApplication.N().P();
        }
        b = WearUtils.v;
    }

    @JvmStatic
    public static final void d() {
        sx.j(true, null);
    }

    @JvmStatic
    public static final void e() {
        String APP_SERVER_HTTPS = WearUtils.e;
        Intrinsics.checkNotNullExpressionValue(APP_SERVER_HTTPS, "APP_SERVER_HTTPS");
        ky.o(APP_SERVER_HTTPS);
        ky.n(new c());
    }

    @JvmStatic
    public static final void f() {
        if (b != WearUtils.v) {
            if (mp1.a.b()) {
                new mp1().g();
            } else {
                MyApplication.N().P();
            }
            b = WearUtils.v;
        }
    }
}
