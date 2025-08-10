package dc;

import com.component.dxdlog.bean.LogServerRequestBean;
import com.component.dxdlog.bean.LogServerResponse;
import com.component.dxdlog.bean.SessionToken;
import com.component.dxhttp.NetException;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.sun.jna.Callback;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: DXDLogModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00040\bJz\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00040\bJ\u0088\u0001\u0010\u0012\u001a*\u0012\u0004\u0012\u00020\u0006\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0014j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u00150\u00132\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0002J\u001c\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019JD\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\"\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0014j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u00152\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019H\u0002JB\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\"\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0014j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002¨\u0006\u001f"}, d2 = {"Lcom/component/dxdlog/DXDLogModel;", "", "()V", "bindFileUrlToUser", "", "requestBean", "Lcom/component/dxdlog/bean/LogServerRequestBean;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function3;", "", "", "appCode", "accountCode", "fileUrl", "uploadFileDateStr", "startDateStr", "endDateStr", "uploadReason", "getRequestServerParams", "Lkotlin/Pair;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "apiUrl", "getS3Token", Callback.METHOD_NAME, "Lcom/component/dxhttp/callback/ResponseCallback;", "Lcom/component/dxdlog/bean/SessionToken;", "requestBindFileUrlToUser", "headerMap", "requestS3Token", "Companion", "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class mx {

    @NotNull
    public static final b a = new b(null);

    @NotNull
    public static final Lazy<mx> b = LazyKt__LazyJVMKt.lazy(a.a);

    /* compiled from: DXDLogModel.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxdlog/DXDLogModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function0<mx> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final mx invoke() {
            return new mx();
        }
    }

    /* compiled from: DXDLogModel.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R!\u0010\b\u001a\u00020\t8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/component/dxdlog/DXDLogModel$Companion;", "", "()V", "S3_TOKEN_API_URL", "", "SERVER_URL", "TEST_SERVER_URL", "UPLOAD_FILE_API_URL", DefaultSettingsSpiCall.INSTANCE_PARAM, "Lcom/component/dxdlog/DXDLogModel;", "getInstance$annotations", "getInstance", "()Lcom/component/dxdlog/DXDLogModel;", "instance$delegate", "Lkotlin/Lazy;", "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final mx a() {
            return (mx) mx.b.getValue();
        }
    }

    /* compiled from: DXDLogModel.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/component/dxdlog/DXDLogModel$bindFileUrlToUser$1", "Lcom/component/dxhttp/callback/ResponseCallback;", "", "onError", "", "e", "Lcom/component/dxhttp/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c extends ny<Object> {
        public final /* synthetic */ Function3<Boolean, String, LogServerRequestBean, Unit> a;
        public final /* synthetic */ Ref.IntRef b;
        public final /* synthetic */ mx c;
        public final /* synthetic */ LogServerRequestBean d;
        public final /* synthetic */ HashMap<String, String> e;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function3<? super Boolean, ? super String, ? super LogServerRequestBean, Unit> function3, Ref.IntRef intRef, mx mxVar, LogServerRequestBean logServerRequestBean, HashMap<String, String> map) {
            this.a = function3;
            this.b = intRef;
            this.c = mxVar;
            this.d = logServerRequestBean;
            this.e = map;
        }

        @Override // dc.ny
        public void b(@Nullable NetException netException) {
            StringBuilder sb = new StringBuilder();
            sb.append(netException != null ? netException.code : null);
            sb.append(" == ");
            sb.append(netException != null ? netException.message : null);
            String string = sb.toString();
            de0.i(string);
            Ref.IntRef intRef = this.b;
            int i = intRef.element;
            if (i >= 1) {
                this.a.invoke(Boolean.FALSE, string, this.d);
            } else {
                intRef.element = i + 1;
                this.c.i(this.d, this.e, this);
            }
        }

        @Override // dc.ny
        public void d(@Nullable Object obj) {
            this.a.invoke(Boolean.TRUE, null, null);
        }
    }

    /* compiled from: DXDLogModel.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/component/dxdlog/DXDLogModel$getS3Token$1", "Lcom/component/dxhttp/callback/ResponseCallback;", "Lcom/component/dxdlog/bean/SessionToken;", "onError", "", "e", "Lcom/component/dxhttp/NetException;", "onSuccess", "token", "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d extends ny<SessionToken> {
        public final /* synthetic */ ny<SessionToken> a;
        public final /* synthetic */ Ref.IntRef b;
        public final /* synthetic */ mx c;
        public final /* synthetic */ LogServerRequestBean d;
        public final /* synthetic */ HashMap<String, String> e;

        public d(ny<SessionToken> nyVar, Ref.IntRef intRef, mx mxVar, LogServerRequestBean logServerRequestBean, HashMap<String, String> map) {
            this.a = nyVar;
            this.b = intRef;
            this.c = mxVar;
            this.d = logServerRequestBean;
            this.e = map;
        }

        @Override // dc.ny
        public void b(@Nullable NetException netException) {
            Ref.IntRef intRef = this.b;
            int i = intRef.element;
            if (i >= 1) {
                this.a.b(netException);
            } else {
                intRef.element = i + 1;
                this.c.j(this.d, this.e, this);
            }
        }

        @Override // dc.ny
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void d(@NotNull SessionToken token) {
            Intrinsics.checkNotNullParameter(token, "token");
            this.a.d(token);
            ix.b.a().k(token);
        }
    }

    /* compiled from: DXDLogModel.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/component/dxdlog/DXDLogModel$requestBindFileUrlToUser$1", "Lcom/component/dxhttp/callback/ResponseCallback;", "Lcom/component/dxdlog/bean/LogServerResponse;", "onError", "", "e", "Lcom/component/dxhttp/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class e extends ny<LogServerResponse> {
        public final /* synthetic */ ny<Object> a;

        public e(ny<Object> nyVar) {
            this.a = nyVar;
        }

        @Override // dc.ny
        public void b(@Nullable NetException netException) {
            this.a.b(netException);
        }

        @Override // dc.ny
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void d(@Nullable LogServerResponse logServerResponse) {
            this.a.d(null);
        }
    }

    /* compiled from: DXDLogModel.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/component/dxdlog/DXDLogModel$requestS3Token$1", "Lcom/component/dxhttp/callback/ResponseCallback;", "Lcom/component/dxdlog/bean/LogServerResponse;", "onError", "", "e", "Lcom/component/dxhttp/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class f extends ny<LogServerResponse> {
        public final /* synthetic */ ny<SessionToken> a;

        public f(ny<SessionToken> nyVar) {
            this.a = nyVar;
        }

        @Override // dc.ny
        public void b(@Nullable NetException netException) {
            StringBuilder sb = new StringBuilder();
            sb.append(netException != null ? netException.code : null);
            sb.append(" == ");
            sb.append(netException != null ? netException.message : null);
            de0.i(sb.toString());
            this.a.b(netException);
        }

        @Override // dc.ny
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void d(@Nullable LogServerResponse logServerResponse) {
            if ((logServerResponse != null ? logServerResponse.getData() : null) == null) {
                this.a.b(new NetException("-101", " getS3Token error"));
                return;
            }
            SessionToken data = logServerResponse.getData();
            data.setExpireTime(System.currentTimeMillis() + ((long) (data.getDurationSeconds() * 1000 * 0.7d)));
            this.a.d(data);
        }
    }

    public static /* synthetic */ Pair g(mx mxVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
        return mxVar.f(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8);
    }

    public final void d(@NotNull LogServerRequestBean requestBean, @NotNull Function3<? super Boolean, ? super String, ? super LogServerRequestBean, Unit> listener) {
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        Intrinsics.checkNotNullParameter(listener, "listener");
        e(requestBean.getAppCode(), requestBean.getAccountCode(), requestBean.getFileUrl(), requestBean.getUpdateFileDate(), requestBean.getLogDateStart(), requestBean.getLogDateEnd(), requestBean.getUploadReason(), listener);
    }

    public final void e(@NotNull String appCode, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @NotNull Function3<? super Boolean, ? super String, ? super LogServerRequestBean, Unit> listener) {
        Intrinsics.checkNotNullParameter(appCode, "appCode");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Pair<LogServerRequestBean, HashMap<String, String>> pairF = f(appCode, "/api/common/upfs", str, str2, str3, str4, str5, str6);
        LogServerRequestBean logServerRequestBeanComponent1 = pairF.component1();
        HashMap<String, String> mapComponent2 = pairF.component2();
        i(logServerRequestBeanComponent1, mapComponent2, new c(listener, new Ref.IntRef(), this, logServerRequestBeanComponent1, mapComponent2));
    }

    public final Pair<LogServerRequestBean, HashMap<String, String>> f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        String strG = gd0.g();
        Intrinsics.checkNotNullExpressionValue(strG, "getAppVersionName()");
        String osVersion = rd0.c();
        String strValueOf = String.valueOf(System.currentTimeMillis());
        String strC = tz.a.c();
        String str9 = strValueOf + '|' + DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE + '|' + strG + '|' + osVersion + '|' + strC + '|' + str2;
        String strB = gd0.b();
        Intrinsics.checkNotNullExpressionValue(strB, "getAppName()");
        Intrinsics.checkNotNullExpressionValue(osVersion, "osVersion");
        String strB2 = rd0.b();
        Intrinsics.checkNotNullExpressionValue(strB2, "getModel()");
        LogServerRequestBean logServerRequestBean = new LogServerRequestBean(str, strB, DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE, strG, osVersion, strB2, strC, str3, str4, str5, str6, str7, str8);
        HashMap map = new HashMap();
        String strB3 = td0.b(str9);
        Intrinsics.checkNotNullExpressionValue(strB3, "encryptMD5ToString(parameterData)");
        map.put("x-parameter-date", strB3);
        map.put("x-stamp", strValueOf);
        return new Pair<>(logServerRequestBean, map);
    }

    public final void h(@NotNull String appCode, @NotNull ny<SessionToken> callback) {
        Intrinsics.checkNotNullParameter(appCode, "appCode");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Pair pairG = g(this, appCode, "/api/common/s3tk", null, null, null, null, null, null, 252, null);
        LogServerRequestBean logServerRequestBean = (LogServerRequestBean) pairG.component1();
        HashMap<String, String> map = (HashMap) pairG.component2();
        j(logServerRequestBean, map, new d(callback, new Ref.IntRef(), this, logServerRequestBean, map));
    }

    public final void i(LogServerRequestBean logServerRequestBean, HashMap<String, String> map, ny<Object> nyVar) {
        ky.e("https://log.lovense-api.com/api/common/upfs", logServerRequestBean, map, new e(nyVar));
    }

    public final void j(LogServerRequestBean logServerRequestBean, HashMap<String, String> map, ny<SessionToken> nyVar) {
        ky.e("https://log.lovense-api.com/api/common/s3tk", logServerRequestBean, map, new f(nyVar));
    }
}
