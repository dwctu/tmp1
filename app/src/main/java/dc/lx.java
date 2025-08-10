package dc;

import android.app.Activity;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import com.component.dxdlog.bean.LogServerRequestBean;
import com.component.dxdlog.bean.SessionToken;
import com.component.dxhttp.NetException;
import com.component.dxutilcode.lib.utils.NetworkUtils;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.mars.xlog.Log;
import com.tencent.mars.xlog.Xlog;
import com.wear.activity.orgySetting.OrgySetting;
import dc.ix;
import dc.ve0;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: DXDLogImp.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 .2\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J3\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0016\u0010\u0017\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0018\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0019J3\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0016\u0010\u0017\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0018\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0019J3\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0016\u0010\u0017\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0018\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0007J\u001c\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\"\u001a\u00020\u0011H\u0002J\u0006\u0010#\u001a\u00020\u0011J \u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u00042\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0002J\u001a\u0010)\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010\u00042\b\u0010+\u001a\u0004\u0018\u00010\rJ3\u0010,\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0016\u0010\u0017\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0018\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0019J3\u0010-\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0016\u0010\u0017\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0018\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0019R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/component/dxdlog/DXDLogImp;", "", "()V", "accountCode", "", "appCode", "dxdLogConfig", "Lcom/component/dxdlog/DXDLogConfig;", "s3Token", "Lcom/component/dxdlog/bean/SessionToken;", "uploadEndDate", "Ljava/util/Date;", "uploadListener", "Lcom/component/dxdlog/UploadLogListener;", "uploadReason", "uploadStartDate", "bindFileUrlToUser", "", "fileUrl", "bindUser", GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, "tag", NotificationCompat.CATEGORY_MESSAGE, "formatArgs", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "i", "init", "config", "onResult", "isSuccess", "", "errorMsg", "printDefaultLog", "releaseDXLogInstance", "uploadLogFileToAmazon", "zipPath", "fileList", "", "Ljava/io/File;", "uploadLogWithReason", "reason", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, PSOProgramService.VS_Key, "w", "Companion", "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class lx {
    public static final String i = "lx";
    public static final String j;

    @NotNull
    public static final String k;

    @NotNull
    public static final String l;

    @NotNull
    public static final String m;

    @NotNull
    public static final AtomicBoolean n;

    @NotNull
    public static final AtomicBoolean o;

    @NotNull
    public jx a = new jx();

    @Nullable
    public String b;

    @Nullable
    public String c;

    @Nullable
    public SessionToken d;

    @Nullable
    public nx e;

    @Nullable
    public String f;
    public Date g;
    public Date h;

    /* compiled from: DXDLogImp.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "isSuccess", "", "errMsg", "", "requestBean", "Lcom/component/dxdlog/bean/LogServerRequestBean;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function3<Boolean, String, LogServerRequestBean, Unit> {
        public a() {
            super(3);
        }

        public final void a(boolean z, @Nullable String str, @Nullable LogServerRequestBean logServerRequestBean) {
            if (z) {
                lx.o(lx.this, true, null, 2, null);
                return;
            }
            if (z) {
                return;
            }
            lx.this.n(false, str);
            String requestStr = xd0.j(logServerRequestBean);
            ix ixVarA = ix.b.a();
            Intrinsics.checkNotNullExpressionValue(requestStr, "requestStr");
            ixVarA.l(requestStr);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str, LogServerRequestBean logServerRequestBean) {
            a(bool.booleanValue(), str, logServerRequestBean);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: DXDLogImp.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/component/dxdlog/DXDLogImp$init$1", "Lcom/component/dxutilcode/lib/utils/Utils$OnAppStatusChangedListener;", "onBackground", "", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/app/Activity;", "onForeground", "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements ve0.c {
        @Override // dc.ve0.c
        public void a(@Nullable Activity activity) {
            ix.b.a().c();
        }

        @Override // dc.ve0.c
        public void b(@Nullable Activity activity) {
            Log.appenderFlush();
        }
    }

    /* compiled from: DXDLogImp.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/component/dxdlog/DXDLogImp$uploadLogFileToAmazon$1", "Lcom/component/dxdlog/UploadLogListener;", "onComplete", "", "isSuccess", "", "errorMsg", "", "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c implements nx {
        public final /* synthetic */ String b;
        public final /* synthetic */ List<File> c;

        /* JADX WARN: Multi-variable type inference failed */
        public c(String str, List<? extends File> list) {
            this.b = str;
            this.c = list;
        }

        @Override // dc.nx
        public void a(boolean z, @Nullable String str) {
            if (!z) {
                lx.this.d = null;
                ix.b.a().e();
                kx.b.a().f(this.b);
                lx.this.n(false, str);
                return;
            }
            if (z) {
                if (str != null) {
                    lx.this.f(str);
                }
                kx.b.a().e(lx.m, this.c);
            }
        }
    }

    /* compiled from: DXDLogImp.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/component/dxdlog/DXDLogImp$uploadLogWithReason$1$1", "Lcom/component/dxhttp/callback/ResponseCallback;", "Lcom/component/dxdlog/bean/SessionToken;", "onError", "", "e", "Lcom/component/dxhttp/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d extends ny<SessionToken> {
        public final /* synthetic */ String b;
        public final /* synthetic */ List<File> c;

        /* JADX WARN: Multi-variable type inference failed */
        public d(String str, List<? extends File> list) {
            this.b = str;
            this.c = list;
        }

        @Override // dc.ny
        public void b(@Nullable NetException netException) {
            lx.this.n(false, netException != null ? netException.message : null);
        }

        @Override // dc.ny
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void d(@NotNull SessionToken response) {
            Intrinsics.checkNotNullParameter(response, "response");
            lx.this.d = response;
            lx.this.r(this.b, this.c);
        }
    }

    static {
        String strF = ge0.f();
        j = strF;
        k = strF + "/xLog/Log";
        l = strF + "/xLog/cacheLog";
        m = strF + "/xLog/uploadLog";
        n = new AtomicBoolean(false);
        o = new AtomicBoolean(false);
    }

    public static /* synthetic */ void o(lx lxVar, boolean z, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        lxVar.n(z, str);
    }

    public static final void p(lx this$0, boolean z, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        nx nxVar = this$0.e;
        if (nxVar != null) {
            nxVar.a(z, str);
        }
        this$0.e = null;
        o.set(false);
    }

    public static final void t(lx this$0, String str, nx nxVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f = str;
        this$0.e = nxVar;
        ix.b bVar = ix.b;
        this$0.d = bVar.a().i();
        String str2 = this$0.b;
        if (str2 == null || StringsKt__StringsJVMKt.isBlank(str2)) {
            this$0.n(false, "AppCode is not setting");
            return;
        }
        if (!NetworkUtils.d()) {
            this$0.n(false, "Network is not available");
            return;
        }
        Log.appenderFlushSync(true);
        kx kxVarA = kx.b.a();
        String str3 = k;
        String str4 = m;
        Date date = this$0.g;
        Date date2 = null;
        if (date == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uploadStartDate");
            date = null;
        }
        Date date3 = this$0.h;
        if (date3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uploadEndDate");
        } else {
            date2 = date3;
        }
        Pair<String, List<File>> pairH = kxVarA.h(str3, str4, date, date2);
        String strComponent1 = pairH.component1();
        List<File> listComponent2 = pairH.component2();
        if (strComponent1.length() == 0) {
            de0.i("There are no log files, so zip file is null");
            this$0.n(false, "There are no log files");
            bVar.a().c();
            return;
        }
        SessionToken sessionToken = this$0.d;
        if ((sessionToken != null ? sessionToken.getExpireTime() : 0L) > System.currentTimeMillis()) {
            this$0.r(strComponent1, listComponent2);
            return;
        }
        mx mxVarA = mx.a.a();
        String str5 = this$0.b;
        if (str5 == null) {
            str5 = "";
        }
        mxVarA.h(str5, this$0.new d(strComponent1, listComponent2));
    }

    public final void f(String str) {
        Date date = this.g;
        Date date2 = null;
        if (date == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uploadStartDate");
            date = null;
        }
        String strB = ue0.b(date, ue0.c);
        Date date3 = this.h;
        if (date3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uploadEndDate");
        } else {
            date2 = date3;
        }
        String strB2 = ue0.b(date2, ue0.c);
        String strN = ue0.n(System.currentTimeMillis(), ue0.c);
        mx mxVarA = mx.a.a();
        String str2 = this.b;
        if (str2 == null) {
            str2 = "";
        }
        mxVarA.e(str2, this.c, str, strN, strB, strB2, this.f, new a());
    }

    public final void g(@Nullable String str) {
        String str2 = this.b;
        if (str2 == null || StringsKt__StringsJVMKt.isBlank(str2)) {
            de0.l("Please initSDK at first");
        }
        this.c = str;
    }

    public final void h(@NotNull String tag, @NotNull String msg, @NotNull Object... formatArgs) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        Log.d(tag, msg, formatArgs);
    }

    public final void i(@NotNull String tag, @NotNull String msg, @NotNull Object... formatArgs) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        Log.e(tag, msg, formatArgs);
    }

    public final void j(@NotNull String tag, @NotNull String msg, @NotNull Object... formatArgs) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        Log.i(tag, msg, formatArgs);
    }

    public final void k(@NotNull String appCode, @NotNull jx config) {
        Intrinsics.checkNotNullParameter(appCode, "appCode");
        Intrinsics.checkNotNullParameter(config, "config");
        if (StringsKt__StringsJVMKt.isBlank(appCode)) {
            de0.l("The param of appCode is not empty");
            return;
        }
        if (n.compareAndSet(false, true)) {
            this.b = appCode;
            this.a = config;
            Date dateF = ue0.f();
            Intrinsics.checkNotNullExpressionValue(dateF, "getNowDate()");
            this.h = dateF;
            if (dateF == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uploadEndDate");
                dateF = null;
            }
            Date dateD = ue0.d(dateF, -this.a.getA(), OrgySetting.ONE_HOURE_MSEC);
            Intrinsics.checkNotNullExpressionValue(dateD, "getDate(uploadEndDate, -…ong(), TimeConstants.DAY)");
            this.g = dateD;
            Xlog.open(true, gd0.i() ? 1 : 2, 0, l, k, "dx", "145aa7717bf9745b91e9569b80bbf1eedaa6cc6cd0e26317d810e35710f44cf8");
            Xlog xlog = new Xlog();
            xlog.setMaxAliveTime(0L, 864000L);
            xlog.setMaxFileSize(0L, this.a.getB() * 1024 * 1024);
            Log.setLogImp(xlog);
            if (gd0.i()) {
                Log.setConsoleLogOpen(true);
            } else {
                Log.setConsoleLogOpen(false);
            }
            q();
            gd0.l(new b());
        }
    }

    public final void n(final boolean z, final String str) {
        se0.f(new Runnable() { // from class: dc.fx
            @Override // java.lang.Runnable
            public final void run() {
                lx.p(this.a, z, str);
            }
        });
    }

    public final void q() {
        String strG = ne0.d().g("sp_key_create_log_tag");
        String strB = ue0.b(new Date(), ue0.c);
        if (Intrinsics.areEqual(strB, strG)) {
            return;
        }
        ne0.d().m("sp_key_create_log_tag", strB);
        StringBuilder sb = new StringBuilder();
        sb.append(" App名称:[" + gd0.b() + ']');
        sb.append(" App版本:[" + gd0.g() + ']');
        sb.append(" App包名:[" + gd0.d() + ']');
        sb.append(" 设备厂商:[" + rd0.a() + ']');
        sb.append(" 设备名称:[" + rd0.b() + ']');
        sb.append(" 系统版本:[" + rd0.c() + ']');
        sb.append(" 网络类型:[" + NetworkUtils.c() + ']');
        sb.append(" deviceId:[" + tz.a.c() + ']');
        String TAG = i;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "strBuilder.toString()");
        j(TAG, string, new Object[0]);
    }

    public final void r(String str, List<? extends File> list) {
        kx.b.a().i(str, this.d, new c(str, list));
    }

    public final void s(@Nullable final String str, @Nullable final nx nxVar) {
        if (o.compareAndSet(false, true)) {
            se0.b().execute(new Runnable() { // from class: dc.gx
                @Override // java.lang.Runnable
                public final void run() {
                    lx.t(this.a, str, nxVar);
                }
            });
        }
    }

    public final void u(@NotNull String tag, @NotNull String msg, @NotNull Object... formatArgs) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        Log.v(tag, msg, formatArgs);
    }

    public final void v(@NotNull String tag, @NotNull String msg, @NotNull Object... formatArgs) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        Log.w(tag, msg, formatArgs);
    }
}
