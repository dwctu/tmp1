package dc;

import android.os.Build;
import com.component.dxbilog.lib.manual.bean.BILogHttpConfig;
import com.component.dxbilog.lib.manual.bean.request.BILogHttpConfigReqBean;
import com.component.dxbilog.lib.manual.bean.request.BILogUploadLogReqBean;
import com.component.dxbilog.lib.manual.bean.response.BILogServerCodeResBean;
import com.component.dxbilog.lib.manual.bean.response.BaseResponse;
import com.component.dxdatabase.lib.bean.BILogDbBean;
import com.component.dxhttp.NetException;
import com.component.dxutilcode.lib.utils.NetworkUtils;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.sun.jna.Callback;
import dc.tz;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: BILogManualModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxbilog/lib/manual/model/BILogManualModel;", "", "()V", "Companion", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ss {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: BILogManualModel.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0014\u0010\u0011\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fJ@\u0010\u0013\u001a\u00020\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0014\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a0\u000fJ,\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001dj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u001e2\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016R\u0016\u0010\u0003\u001a\u00020\u00048BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u00048BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0006¨\u0006\""}, d2 = {"Lcom/component/dxbilog/lib/manual/model/BILogManualModel$Companion;", "", "()V", "URL_BILOG_HTTP_CONFIG", "", "getURL_BILOG_HTTP_CONFIG", "()Ljava/lang/String;", "URL_BILOG_UPLOAD", "getURL_BILOG_UPLOAD", "URL_BILOG_UPLOAD_PATH2", "URL_BILOG_USER_CONFIG", "getURL_BILOG_USER_CONFIG", "getHttpConfig", "", Callback.METHOD_NAME, "Lcom/component/dxhttp/callback/ResponseCallback;", "Lcom/component/dxbilog/lib/manual/bean/BILogHttpConfig;", "getUserConfig", "Lcom/component/dxbilog/lib/bean/BILogUserConfig;", "httpUploadLog", "accountCode", FirebaseAnalytics.Param.CONTENT, "", "Lcom/component/dxdatabase/lib/bean/BILogDbBean;", "isSync", "", "Lcom/component/dxbilog/lib/manual/bean/response/BaseResponse;", "Lcom/component/dxbilog/lib/manual/bean/response/BILogServerCodeResBean;", "initHeader", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "reqBeanStr", "initUploadData", "list", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {

        /* compiled from: BILogManualModel.kt */
        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00052\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/component/dxbilog/lib/manual/model/BILogManualModel$Companion$getHttpConfig$1", "Lcom/component/dxhttp/callback/ResponseCallback;", "Lcom/component/dxbilog/lib/manual/bean/response/BaseResponse;", "Lcom/component/dxbilog/lib/manual/bean/BILogHttpConfig;", "onError", "", "e", "Lcom/component/dxhttp/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* renamed from: dc.ss$a$a, reason: collision with other inner class name */
        public static final class C0219a extends ny<BaseResponse<BILogHttpConfig>> {
            public final /* synthetic */ ny<BILogHttpConfig> a;

            public C0219a(ny<BILogHttpConfig> nyVar) {
                this.a = nyVar;
            }

            @Override // dc.ny
            public void b(@Nullable NetException netException) {
                this.a.b(netException);
            }

            @Override // dc.ny
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public void d(@Nullable BaseResponse<BILogHttpConfig> baseResponse) {
                BILogHttpConfig data = baseResponse == null ? null : baseResponse.getData();
                if (data == null) {
                    return;
                }
                this.a.d(data);
            }
        }

        /* compiled from: BILogManualModel.kt */
        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016¨\u0006\n"}, d2 = {"com/component/dxbilog/lib/manual/model/BILogManualModel$Companion$httpUploadLog$httpCallback$1", "Lcom/component/dxhttp/callback/ResponseCallback;", "Lcom/component/dxbilog/lib/manual/bean/response/BaseResponse;", "Lcom/component/dxbilog/lib/manual/bean/response/BILogServerCodeResBean;", "onError", "", "e", "Lcom/component/dxhttp/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class b extends ny<BaseResponse<BILogServerCodeResBean>> {
            public final /* synthetic */ ny<BaseResponse<BILogServerCodeResBean>> a;

            public b(ny<BaseResponse<BILogServerCodeResBean>> nyVar) {
                this.a = nyVar;
            }

            @Override // dc.ny
            public void b(@Nullable NetException netException) {
                ys.a.b();
                this.a.b(netException);
            }

            @Override // dc.ny
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public void d(@NotNull BaseResponse<BILogServerCodeResBean> response) {
                Intrinsics.checkNotNullParameter(response, "response");
                ys ysVar = ys.a;
                String code = response.getCode();
                Intrinsics.checkNotNullExpressionValue(code, "response.code");
                ysVar.c(Integer.valueOf(Integer.parseInt(code)), response.getData());
                this.a.d(response);
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull ny<BILogHttpConfig> callback) {
            String strD;
            Intrinsics.checkNotNullParameter(callback, "callback");
            BILogHttpConfigReqBean bILogHttpConfigReqBean = new BILogHttpConfigReqBean();
            ks ksVar = ks.a;
            BILogHttpConfig bILogHttpConfigB = ksVar.b().b();
            bILogHttpConfigReqBean.setVersion(Integer.valueOf(bILogHttpConfigB == null ? 0 : bILogHttpConfigB.getVersion()));
            bs b2 = ksVar.a().getB();
            String str = "";
            if (b2 != null && (strD = b2.d()) != null) {
                str = strD;
            }
            bILogHttpConfigReqBean.setAppType(str);
            bILogHttpConfigReqBean.setPlatform(DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
            ky.e(b(), bILogHttpConfigReqBean, null, new C0219a(callback));
        }

        public final String b() {
            return ks.a.j() ? "https://test4.lovense-api.com/get/ccp/cf" : "https://log.lovense-api.com/get/ccp/cf ";
        }

        public final String c() {
            return ks.a.j() ? "https://test2.lovense.com/coll-log/app/allLog" : "https://coll.lovense.com/coll-log/app/allLog";
        }

        public final void d(@Nullable String str, @NotNull List<BILogDbBean> content, boolean z, @NotNull ny<BaseResponse<BILogServerCodeResBean>> callback) {
            String strD;
            String strA;
            String strB;
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (content.isEmpty()) {
                callback.b(new NetException("-1", "content is null"));
                return;
            }
            String str2 = str == null ? "" : str;
            ks ksVar = ks.a;
            bs b2 = ksVar.a().getB();
            if (b2 == null || (strD = b2.d()) == null) {
                strD = "";
            }
            bs b3 = ksVar.a().getB();
            if (b3 == null || (strA = b3.a()) == null) {
                strA = "";
            }
            tz.a aVar = tz.a;
            String strC = aVar.c();
            String strF = aVar.f();
            String strE = aVar.e();
            String str3 = Build.MODEL;
            String strK = ue0.k();
            bs b4 = ksVar.a().getB();
            BILogUploadLogReqBean bILogUploadLogReqBean = new BILogUploadLogReqBean(str2, content, DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE, strD, strA, strC, strF, strE, str3, strK, (b4 == null || (strB = b4.b()) == null) ? "" : strB, NetworkUtils.c());
            String reqBeanStr = xd0.h().toJson(bILogUploadLogReqBean);
            b bVar = new b(callback);
            Intrinsics.checkNotNullExpressionValue(reqBeanStr, "reqBeanStr");
            HashMap<String, String> mapE = e(reqBeanStr);
            if (z) {
                ky.g(c(), reqBeanStr, mapE, false, bVar);
            } else {
                ky.f(c(), bILogUploadLogReqBean.toString(), mapE, false, bVar);
            }
        }

        public final HashMap<String, String> e(String str) {
            HashMap<String, String> map = new HashMap<>();
            long jCurrentTimeMillis = System.currentTimeMillis();
            int length = str.length();
            String md5Data = td0.b(jCurrentTimeMillis + '|' + length + "|/coll-log/app/allLog");
            map.put(HttpHeaders.CONTENT_ENCODING, "gzip");
            map.put("x-stamp", String.valueOf(jCurrentTimeMillis));
            map.put("x-text-length", String.valueOf(length));
            Intrinsics.checkNotNullExpressionValue(md5Data, "md5Data");
            map.put("x-parameter-date", md5Data);
            return map;
        }

        @NotNull
        public final List<BILogDbBean> f(@NotNull List<BILogDbBean> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            Object objA = md0.a(list, new cx(BILogDbBean.class));
            Intrinsics.checkNotNullExpressionValue(objA, "deepClone(list, GsonType…:class.java as Class<*>))");
            List<BILogDbBean> list2 = (List) objA;
            for (BILogDbBean bILogDbBean : list2) {
                bILogDbBean.setId(null);
                bILogDbBean.setAccountCode(null);
                bILogDbBean.setByteSize(null);
                bILogDbBean.setFailCount(null);
                bILogDbBean.setNextUploadTime(null);
                bILogDbBean.setUpdated(null);
            }
            return list2;
        }
    }
}
