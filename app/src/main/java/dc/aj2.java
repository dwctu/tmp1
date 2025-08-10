package dc;

import androidx.core.app.NotificationCompat;
import com.sun.jna.Callback;
import com.wear.bean.request.ReportToyInfoSocketReqBean;
import com.wear.bean.response.BaseResponseStringBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ec0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: ToyProviderComponent.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\u000e"}, d2 = {"Lcom/wear/main/toy/manager/ToyProviderComponent;", "Lcom/wear/main/socketio/SocketConnectListener;", "()V", "connectSuc", "", "disConnect", "initToyProviderComponent", "reportToyInfo", MultipleAddresses.Address.ELEMENT, "", "status", "Lcom/component/dxtoy/turnover/data/ToyTurnoverEum$ConnectState;", "socketIoAckCheckToyInfoTc", NotificationCompat.CATEGORY_MESSAGE, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class aj2 implements tf2 {

    /* compiled from: ToyProviderComponent.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/wear/main/toy/manager/ToyProviderComponent$initToyProviderComponent$appDataEngine$1", "Lcom/component/dxtoy/turnover/listener/IAppDataEngine;", "getAppCode", "Lcom/component/dxhttp/AppCode;", "getAppVersion", "", "isForbiddenUseApp", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements dc0 {
        @Override // dc.dc0
        @NotNull
        public String a() {
            String APP_VERSION = WearUtils.q;
            Intrinsics.checkNotNullExpressionValue(APP_VERSION, "APP_VERSION");
            return APP_VERSION;
        }

        @Override // dc.dc0
        @NotNull
        public dy b() {
            return dy.REMOTE;
        }

        @Override // dc.dc0
        public boolean c() {
            return false;
        }
    }

    /* compiled from: ToyProviderComponent.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/wear/main/toy/manager/ToyProviderComponent$initToyProviderComponent$networkEngine$1", "Lcom/component/dxtoy/turnover/listener/INetworkEngine;", "networkReportToyInfo", "", "data", "", "httpUrl", Callback.METHOD_NAME, "Lcom/component/dxtoy/turnover/listener/INetworkEngine$ICallback;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements ec0 {

        /* compiled from: ToyProviderComponent.kt */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/wear/main/toy/manager/ToyProviderComponent$initToyProviderComponent$networkEngine$1$networkReportToyInfo$1$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a implements zn2<String> {
            public final /* synthetic */ ec0.a a;

            public a(ec0.a aVar) {
                this.a = aVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // dc.zn2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@Nullable String str) {
                int i;
                de0.l("networkReportToyInfo___Http___onSuccess", xd0.j(str));
                try {
                    BaseResponseStringBean baseResponseStringBean = (BaseResponseStringBean) xd0.d(str, BaseResponseStringBean.class);
                    if (baseResponseStringBean != null && baseResponseStringBean.result && (i = baseResponseStringBean.code) == 0) {
                        ec0.a aVar = this.a;
                        if (aVar != null) {
                            aVar.a(String.valueOf(i), (String) baseResponseStringBean.data);
                            return;
                        }
                        return;
                    }
                    ec0.a aVar2 = this.a;
                    if (aVar2 != null) {
                        String strValueOf = String.valueOf(baseResponseStringBean != null ? Integer.valueOf(baseResponseStringBean.code) : null);
                        String str2 = baseResponseStringBean != null ? baseResponseStringBean.message : null;
                        if (str2 == null) {
                            str2 = "http fail";
                        }
                        aVar2.b(strValueOf, str2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    ec0.a aVar3 = this.a;
                    if (aVar3 != null) {
                        aVar3.b("-1", e.getMessage());
                    }
                }
            }

            @Override // dc.zn2
            public void onError(@Nullable NetException e) {
                de0.l("networkReportToyInfo___Http___onError", xd0.j(e));
                ec0.a aVar = this.a;
                if (aVar != null) {
                    String str = e != null ? e.code : null;
                    if (str == null) {
                        str = "-1";
                    }
                    String str2 = e != null ? e.message : null;
                    if (str2 == null) {
                        str2 = "http fail";
                    }
                    aVar.b(str, str2);
                }
            }
        }

        @Override // dc.ec0
        public void a(@NotNull String data, @Nullable String str, @Nullable ec0.a aVar) {
            Intrinsics.checkNotNullParameter(data, "data");
            de0.l("networkReportToyInfo", qx.a(data), str, data);
            if (MyApplication.Z) {
                if (str != null) {
                    Map mapMapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("data", data));
                    de0.l("networkReportToyInfo___Http", xd0.j(mapMapOf));
                    tn2.x(WearUtils.x).m(str, xd0.j(mapMapOf), new a(aVar));
                    return;
                }
                return;
            }
            de0.l("networkReportToyInfo___SocketIo", xd0.j(new ReportToyInfoSocketReqBean(data)));
            if (uf2.v().E(new ReportToyInfoSocketReqBean(data))) {
                if (aVar != null) {
                    aVar.a("0", "socket success");
                }
            } else if (aVar != null) {
                aVar.b("-1", "socket fail");
            }
        }
    }

    /* compiled from: ToyProviderComponent.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/wear/main/toy/manager/ToyProviderComponent$reportToyInfo$1", "Lcom/component/dxtoy/turnover/listener/INetworkEngine$ICallback;", "onError", "", XHTMLText.CODE, "", "error", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements ec0.a {
        @Override // dc.ec0.a
        public void a(@Nullable String str, @Nullable String str2) {
        }

        @Override // dc.ec0.a
        public void b(@Nullable String str, @Nullable String str2) {
        }
    }

    @JvmStatic
    public static final void a() {
        ac0.a.a(new b(), new a());
    }

    @JvmStatic
    public static final void b(@NotNull String address, @NotNull cc0 status) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(status, "status");
        de0.l("reportToyInfo", address, status);
        ac0.a.b(StringsKt__StringsJVMKt.replace$default(address, SignatureImpl.INNER_SEP, "", false, 4, (Object) null), status, new c());
    }
}
