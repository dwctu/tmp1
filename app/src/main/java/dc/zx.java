package dc;

import android.content.Intent;
import android.net.Uri;
import android.telephony.TelephonyManager;
import androidx.core.app.NotificationCompat;
import com.component.dxfunctionkits.forbidden.bean.ForbiddenReason;
import com.component.dxfunctionkits.forbidden.bean.ForbiddenRequest;
import com.component.dxfunctionkits.forbidden.bean.ForbiddenResponse;
import com.component.dxhttp.NetException;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dc.zx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: ForbiddenUseApp.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001e\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010 H\u0007J\b\u0010!\u001a\u00020\u0014H\u0002J\b\u0010\"\u001a\u00020\u0014H\u0002J\b\u0010#\u001a\u00020\u0014H\u0002J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u0014H\u0007J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u001a\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010 H\u0002J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0016j\b\u0012\u0004\u0012\u00020\u0004`\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/component/dxfunctionkits/forbidden/ForbiddenUseApp;", "", "()V", "CHECK_URL", "", "INTENT_FILTER_DATA_PATH", "SERVER_URL", "SIM_CODE", "", "[Ljava/lang/String;", "TEST_SERVER_URL", "TIME_OUT_MILLIS", "", "WHITE_UPDATE_URL", "forbiddenReason", "Lcom/component/dxfunctionkits/forbidden/bean/ForbiddenReason;", "isCheckWhitelistRetry", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isUpdateWhitelistRetry", "openDebug", "", "serverErrorCode", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "serverUrl", "checkLocalForbidden", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/component/dxfunctionkits/forbidden/listener/IForbiddenListener;", "handleLink", "intent", "Landroid/content/Intent;", "Lcom/component/dxfunctionkits/forbidden/listener/HandleLinkListener;", "isCountryForbidden", "isLanguageForbidden", "isSIMForbidden", "log", NotificationCompat.CATEGORY_MESSAGE, "isDebug", TtmlNode.START, "updateWhiteList", "pswd", "verifyRemoteWhite", "forbidden_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class zx {
    public static boolean d;

    @Nullable
    public static ForbiddenReason h;

    @NotNull
    public static final zx a = new zx();

    @NotNull
    public static final ArrayList<String> b = CollectionsKt__CollectionsKt.arrayListOf("400", "4010");

    @NotNull
    public static final String[] c = {"46000", "46002", "46004", "46007", "46008", "46001", "46006", "46009", "46003", "46005", "46011", "46015", "46020"};

    @NotNull
    public static AtomicBoolean e = new AtomicBoolean(false);

    @NotNull
    public static AtomicBoolean f = new AtomicBoolean(false);

    @NotNull
    public static String g = "https://apps2.lovense-api.com";

    /* compiled from: ForbiddenUseApp.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/component/dxfunctionkits/forbidden/ForbiddenUseApp$updateWhiteList$1", "Lcom/component/dxhttp/callback/ResponseCallback;", "Lcom/component/dxfunctionkits/forbidden/bean/ForbiddenResponse;", "onError", "", "e", "Lcom/component/dxhttp/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "forbidden_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends ny<ForbiddenResponse> {
        public final /* synthetic */ ay a;
        public final /* synthetic */ String b;

        public a(ay ayVar, String str) {
            this.a = ayVar;
            this.b = str;
        }

        @Override // dc.ny
        public void b(@Nullable NetException netException) {
            String str;
            ArrayList arrayList = zx.b;
            if (netException == null || (str = netException.code) == null) {
                str = "0";
            }
            if (!arrayList.contains(str) && zx.f.compareAndSet(false, true)) {
                zx.a.u(this.b, this.a);
                return;
            }
            zx.f.set(false);
            ay ayVar = this.a;
            if (ayVar != null) {
                ayVar.a(false);
            }
        }

        @Override // dc.ny
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void d(@Nullable ForbiddenResponse forbiddenResponse) {
            zx.f.set(false);
            ay ayVar = this.a;
            if (ayVar != null) {
                ayVar.a(true);
            }
        }
    }

    /* compiled from: ForbiddenUseApp.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/component/dxfunctionkits/forbidden/ForbiddenUseApp$verifyRemoteWhite$1", "Lcom/component/dxhttp/callback/ResponseCallback;", "Lcom/component/dxfunctionkits/forbidden/bean/ForbiddenResponse;", "onError", "", "e", "Lcom/component/dxhttp/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "forbidden_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends ny<ForbiddenResponse> {
        public final /* synthetic */ by a;

        public b(by byVar) {
            this.a = byVar;
        }

        public static final void g(by listener, boolean z) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            listener.a(true, zx.h, z);
        }

        public static final void i(by listener) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            listener.a(false, null, true);
        }

        @Override // dc.ny
        public void b(@Nullable NetException netException) {
            String str;
            zx zxVar = zx.a;
            StringBuilder sb = new StringBuilder();
            sb.append("checkWhitelist onError == ");
            sb.append(netException != null ? netException.message : null);
            zxVar.q(sb.toString());
            ArrayList arrayList = zx.b;
            if (netException == null || (str = netException.code) == null) {
                str = "0";
            }
            final boolean zContains = arrayList.contains(str);
            if (!zContains && zx.e.compareAndSet(false, true)) {
                zx.v(this.a);
                return;
            }
            zx.e.set(false);
            final by byVar = this.a;
            se0.f(new Runnable() { // from class: dc.xx
                @Override // java.lang.Runnable
                public final void run() {
                    zx.b.g(byVar, zContains);
                }
            });
        }

        @Override // dc.ny
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(@Nullable ForbiddenResponse forbiddenResponse) {
            zx.e.set(false);
            final by byVar = this.a;
            se0.f(new Runnable() { // from class: dc.yx
                @Override // java.lang.Runnable
                public final void run() {
                    zx.b.i(byVar);
                }
            });
        }
    }

    public static final void h(by listener) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.a(false, null, true);
    }

    @JvmStatic
    public static final void i(@Nullable Intent intent, @Nullable final ay ayVar) {
        String dataString;
        gz.a.a();
        tz.a.c();
        zx zxVar = a;
        if (intent == null || (dataString = intent.getDataString()) == null) {
            dataString = "intent data is null";
        }
        zxVar.q(dataString);
        if ((intent != null ? intent.getData() : null) == null) {
            if (ayVar != null) {
                ayVar.a(false);
                return;
            }
            return;
        }
        Uri data = intent.getData();
        if (data != null) {
            if (!Intrinsics.areEqual("/forbidden", data.getPath())) {
                if (ayVar != null) {
                    ayVar.a(false);
                    return;
                }
                return;
            }
            final String queryParameter = data.getQueryParameter("pswd");
            if (queryParameter == null || StringsKt__StringsJVMKt.isBlank(queryParameter)) {
                if (ayVar != null) {
                    ayVar.a(false);
                }
            } else {
                zxVar.q("handleLink pswd == " + queryParameter);
                se0.b().execute(new Runnable() { // from class: dc.vx
                    @Override // java.lang.Runnable
                    public final void run() {
                        zx.j(queryParameter, ayVar);
                    }
                });
            }
        }
    }

    public static final void j(String str, ay ayVar) {
        a.u(str, ayVar);
    }

    @JvmStatic
    public static final void r(boolean z) {
        d = z;
        g = (z && gd0.i()) ? "https://test2.lovense.com" : "https://apps2.lovense-api.com";
        gz.a.a();
        tz.a.c();
    }

    @JvmStatic
    public static final void s(@NotNull final by listener) throws Exception {
        Intrinsics.checkNotNullParameter(listener, "listener");
        gz.a.a();
        tz.a.c();
        se0.b().execute(new Runnable() { // from class: dc.ux
            @Override // java.lang.Runnable
            public final void run() {
                zx.t(listener);
            }
        });
    }

    public static final void t(by listener) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        a.g(listener);
    }

    @JvmStatic
    public static final void v(@NotNull by listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        String str = g + "/api/device/check";
        ForbiddenRequest forbiddenRequest = new ForbiddenRequest(tz.a.c(), null, 2, null);
        HashMap map = new HashMap();
        map.put("connect_timeout", String.valueOf(5000));
        map.put("read_timeout", String.valueOf(5000));
        map.put("write_timeout", String.valueOf(5000));
        ky.e(str, forbiddenRequest, map, new b(listener));
    }

    public final void g(final by byVar) {
        if (l()) {
            h = ForbiddenReason.LANGUAGE;
            v(byVar);
        } else if (k()) {
            h = ForbiddenReason.REGION;
            v(byVar);
        } else if (!m()) {
            se0.f(new Runnable() { // from class: dc.wx
                @Override // java.lang.Runnable
                public final void run() {
                    zx.h(byVar);
                }
            });
        } else {
            h = ForbiddenReason.MOBILE_NETWORK;
            v(byVar);
        }
    }

    public final boolean k() {
        String country = ce0.c().getCountry();
        boolean zEquals = StringsKt__StringsJVMKt.equals(country, "CN", true);
        q("isCountryForbidden == " + zEquals + "  ; country == " + country);
        return zEquals;
    }

    public final boolean l() {
        String language = ce0.c().toLanguageTag();
        Intrinsics.checkNotNullExpressionValue(language, "language");
        boolean z = true;
        if (!StringsKt__StringsJVMKt.startsWith(language, "zh-Hans", true) && !StringsKt__StringsJVMKt.equals(language, "zh-CN", true)) {
            z = false;
        }
        q("isLanguageForbidden == " + z + "  ; language == " + language);
        return z;
    }

    public final boolean m() {
        Object systemService = ve0.a().getSystemService("phone");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        TelephonyManager telephonyManager = (TelephonyManager) systemService;
        String[] strArr = c;
        boolean z = ArraysKt___ArraysKt.contains(strArr, telephonyManager.getSimOperator()) || ArraysKt___ArraysKt.contains(strArr, telephonyManager.getNetworkOperator());
        q("isSIMForbidden == " + z + "  ; simOperator == " + telephonyManager.getSimOperator() + " ; networkOperator == " + telephonyManager.getNetworkOperator() + " ; ");
        return z;
    }

    public final void q(String str) {
        if (d && gd0.i()) {
            de0.i(str);
        }
    }

    public final void u(String str, ay ayVar) {
        String str2 = g + "/api/device/whiteUpd";
        ForbiddenRequest forbiddenRequest = new ForbiddenRequest(tz.a.c(), str);
        HashMap map = new HashMap();
        map.put("connect_timeout", "5000");
        map.put("read_timeout", "5000");
        map.put("write_timeout", "5000");
        ky.e(str2, forbiddenRequest, map, new a(ayVar, str));
    }
}
