package dc;

import android.content.Context;
import com.wear.bean.CheckProtocolBean;
import com.wear.bean.GalleryDetailsV2Bean;
import com.wear.bean.XRemoteAgreeBean;
import com.wear.bean.XRemoteAppUserBean;
import com.wear.bean.XRemoteAuthCodeBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import rx.Subscription;

/* compiled from: XRemoteInterceptorImpl.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bJ,\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bJ6\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bJJ\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bJ6\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bJ6\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¨\u0006\u0014"}, d2 = {"Lcom/wear/ui/discover/xremote/model/XRemoteInterceptorImpl;", "", "()V", "agreeProtocol", "Lrx/Subscription;", "applicationId", "", "applicationVersion", "context", "Landroid/content/Context;", "callBack", "Lcom/wear/network/protocol/callback/XRemoteRequestCallBack;", "getAppAccountInfo", "getAppAccountInfoV2", "version", "getAuthCode", "scope", "userId", "getUserCheckProtocol", "getWhiteList", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class q23 {

    /* compiled from: XRemoteInterceptorImpl.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/wear/ui/discover/xremote/model/XRemoteInterceptorImpl$agreeProtocol$1", "Lcom/wear/network/protocol/callback/ResponseCallBack;", "Lcom/wear/bean/XRemoteAgreeBean;", "onCompleted", "", "onError", "e", "Lcom/wear/network/protocol/exception/NetException;", "onStart", "onSuccess", "data", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements yn2<XRemoteAgreeBean> {
        public final /* synthetic */ ao2<Object> a;

        public a(ao2<Object> ao2Var) {
            this.a = ao2Var;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable XRemoteAgreeBean xRemoteAgreeBean) {
            if (xRemoteAgreeBean != null) {
                ao2<Object> ao2Var = this.a;
                if (Intrinsics.areEqual(xRemoteAgreeBean.getResult(), Boolean.TRUE)) {
                    if (ao2Var != null) {
                        ao2Var.a(false, xRemoteAgreeBean);
                    }
                } else if (ao2Var != null) {
                    ao2Var.b(xRemoteAgreeBean.getMessage(), Boolean.FALSE);
                }
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(@Nullable NetException e) {
            ao2<Object> ao2Var = this.a;
            if (ao2Var != null) {
                ao2Var.c(e, 4);
            }
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: XRemoteInterceptorImpl.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/wear/ui/discover/xremote/model/XRemoteInterceptorImpl$getAppAccountInfo$1", "Lcom/wear/network/protocol/callback/ResponseCallBack;", "Lcom/wear/bean/XRemoteAppUserBean;", "onCompleted", "", "onError", "e", "Lcom/wear/network/protocol/exception/NetException;", "onStart", "onSuccess", "data", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements yn2<XRemoteAppUserBean> {
        public final /* synthetic */ ao2<Object> a;

        public b(ao2<Object> ao2Var) {
            this.a = ao2Var;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable XRemoteAppUserBean xRemoteAppUserBean) {
            if (xRemoteAppUserBean != null) {
                ao2<Object> ao2Var = this.a;
                if (!Intrinsics.areEqual(xRemoteAppUserBean.getResult(), Boolean.TRUE)) {
                    if (ao2Var != null) {
                        ao2Var.b(xRemoteAppUserBean.getMessage(), Boolean.FALSE);
                    }
                } else {
                    XRemoteAppUserBean.DataBean data = xRemoteAppUserBean.getData();
                    if (data != null) {
                        data.setVersion("1.0");
                    }
                    if (ao2Var != null) {
                        ao2Var.a(false, xRemoteAppUserBean.getData());
                    }
                }
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(@Nullable NetException e) {
            ao2<Object> ao2Var = this.a;
            if (ao2Var != null) {
                ao2Var.c(e, 4);
            }
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: XRemoteInterceptorImpl.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/wear/ui/discover/xremote/model/XRemoteInterceptorImpl$getAppAccountInfoV2$1", "Lcom/wear/network/protocol/callback/ResponseCallBack;", "Lcom/wear/bean/XRemoteAppUserBean;", "onCompleted", "", "onError", "e", "Lcom/wear/network/protocol/exception/NetException;", "onStart", "onSuccess", "data", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements yn2<XRemoteAppUserBean> {
        public final /* synthetic */ ao2<Object> a;

        public c(ao2<Object> ao2Var) {
            this.a = ao2Var;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable XRemoteAppUserBean xRemoteAppUserBean) {
            if ((xRemoteAppUserBean != null ? xRemoteAppUserBean.getData() : null) == null) {
                ao2<Object> ao2Var = this.a;
                if (ao2Var != null) {
                    ao2Var.b(xRemoteAppUserBean != null ? xRemoteAppUserBean.getMessage() : null, Boolean.FALSE);
                    return;
                }
                return;
            }
            if (!Intrinsics.areEqual(xRemoteAppUserBean.getResult(), Boolean.TRUE)) {
                ao2<Object> ao2Var2 = this.a;
                if (ao2Var2 != null) {
                    ao2Var2.b(xRemoteAppUserBean.getMessage(), Boolean.FALSE);
                    return;
                }
                return;
            }
            xRemoteAppUserBean.getData().setVersion("2.0");
            if (xRemoteAppUserBean.getData().getApplication() != null) {
                String applicationId = xRemoteAppUserBean.getData().getApplication().getApplicationId();
                boolean z = true;
                if (!(applicationId == null || applicationId.length() == 0)) {
                    String applicationName = xRemoteAppUserBean.getData().getApplication().getApplicationName();
                    if (applicationName != null && applicationName.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        ao2<Object> ao2Var3 = this.a;
                        if (ao2Var3 != null) {
                            ao2Var3.a(false, xRemoteAppUserBean.getData());
                            return;
                        }
                        return;
                    }
                }
            }
            ao2<Object> ao2Var4 = this.a;
            if (ao2Var4 != null) {
                ao2Var4.b(xRemoteAppUserBean.getMessage(), xRemoteAppUserBean.getData());
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(@Nullable NetException e) {
            ao2<Object> ao2Var = this.a;
            if (ao2Var != null) {
                ao2Var.c(e, 2);
            }
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: XRemoteInterceptorImpl.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/wear/ui/discover/xremote/model/XRemoteInterceptorImpl$getAuthCode$1", "Lcom/wear/network/protocol/callback/ResponseCallBack;", "Lcom/wear/bean/XRemoteAuthCodeBean;", "onCompleted", "", "onError", "e", "Lcom/wear/network/protocol/exception/NetException;", "onStart", "onSuccess", "data", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d implements yn2<XRemoteAuthCodeBean> {
        public final /* synthetic */ ao2<Object> a;

        public d(ao2<Object> ao2Var) {
            this.a = ao2Var;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable XRemoteAuthCodeBean xRemoteAuthCodeBean) {
            if (xRemoteAuthCodeBean != null) {
                ao2<Object> ao2Var = this.a;
                if (Intrinsics.areEqual(xRemoteAuthCodeBean.getResult(), Boolean.TRUE)) {
                    if (ao2Var != null) {
                        ao2Var.a(false, xRemoteAuthCodeBean);
                    }
                } else if (ao2Var != null) {
                    ao2Var.b(xRemoteAuthCodeBean.getMessage(), Boolean.FALSE);
                }
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(@Nullable NetException e) {
            ao2<Object> ao2Var = this.a;
            if (ao2Var != null) {
                ao2Var.c(e, 5);
            }
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: XRemoteInterceptorImpl.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/wear/ui/discover/xremote/model/XRemoteInterceptorImpl$getUserCheckProtocol$1", "Lcom/wear/network/protocol/callback/ResponseCallBack;", "Lcom/wear/bean/CheckProtocolBean;", "onCompleted", "", "onError", "e", "Lcom/wear/network/protocol/exception/NetException;", "onStart", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class e implements yn2<CheckProtocolBean> {
        public final /* synthetic */ ao2<Object> a;

        public e(ao2<Object> ao2Var) {
            this.a = ao2Var;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull CheckProtocolBean response) {
            Intrinsics.checkNotNullParameter(response, "response");
            String str = "response = " + response;
            if (Intrinsics.areEqual(response.getResult(), Boolean.TRUE)) {
                ao2<Object> ao2Var = this.a;
                if (ao2Var != null) {
                    ao2Var.a(false, response);
                    return;
                }
                return;
            }
            ao2<Object> ao2Var2 = this.a;
            if (ao2Var2 != null) {
                ao2Var2.b(response.getMessage(), response);
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(@NotNull NetException e) {
            Intrinsics.checkNotNullParameter(e, "e");
            ao2<Object> ao2Var = this.a;
            if (ao2Var != null) {
                ao2Var.c(e, 3);
            }
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: XRemoteInterceptorImpl.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/wear/ui/discover/xremote/model/XRemoteInterceptorImpl$getWhiteList$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", "data", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class f implements zn2<String> {
        public final /* synthetic */ ao2<Object> a;

        public f(ao2<Object> ao2Var) {
            this.a = ao2Var;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable String str) {
            GalleryDetailsV2Bean galleryDetailsV2Bean = (GalleryDetailsV2Bean) WearUtils.A.fromJson(str, GalleryDetailsV2Bean.class);
            if (galleryDetailsV2Bean != null) {
                ao2<Object> ao2Var = this.a;
                if (Intrinsics.areEqual(galleryDetailsV2Bean.getResult(), Boolean.TRUE)) {
                    if (ao2Var != null) {
                        ao2Var.a(false, galleryDetailsV2Bean);
                    }
                } else if (ao2Var != null) {
                    ao2Var.b(galleryDetailsV2Bean.getMessage(), galleryDetailsV2Bean);
                }
            }
        }

        @Override // dc.zn2
        public void onError(@Nullable NetException e) {
            ao2<Object> ao2Var = this.a;
            if (ao2Var != null) {
                ao2Var.c(e, 1);
            }
        }
    }

    @Nullable
    public final Subscription a(@NotNull String applicationId, @NotNull String applicationVersion, @NotNull Context context, @Nullable ao2<Object> ao2Var) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(applicationVersion, "applicationVersion");
        Intrinsics.checkNotNullParameter(context, "context");
        HashMap map = new HashMap();
        map.put("applicationId", applicationId);
        map.put("applicationVersion", applicationVersion);
        return tn2.x(context).h("/api/remote/application/user/agree-protocol", WearUtils.A.toJson(map), new a(ao2Var));
    }

    @Nullable
    public final Subscription b(@Nullable String str, @Nullable Context context, @Nullable ao2<Object> ao2Var) {
        if ((str == null || str.length() == 0) || context == null) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("applicationId", str);
        return tn2.x(context).h("/api/remote/application/get_application_account_list", WearUtils.A.toJson(map), new b(ao2Var));
    }

    @Nullable
    public final Subscription c(@Nullable String str, @Nullable String str2, @Nullable Context context, @Nullable ao2<Object> ao2Var) {
        if ((str == null || str.length() == 0) || context == null) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("applicationId", str);
        if (str2 == null) {
            str2 = "";
        }
        map.put("applicationVersion", str2);
        return tn2.x(context).h("/api/remote/application/get_application_account_list_v2", WearUtils.A.toJson(map), new c(ao2Var));
    }

    @Nullable
    public final Subscription d(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Context context, @Nullable ao2<Object> ao2Var) {
        if ((str == null || str.length() == 0) || context == null) {
            return null;
        }
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("applicationId", str2);
        map.put("scopes", new String[]{str});
        if (str3 == null) {
            str3 = "";
        }
        map.put("userId", str3);
        if (str4 == null) {
            str4 = "";
        }
        map.put("applicationVersion", str4);
        return tn2.x(context).h("/api/remote/application/auth_code_v2", WearUtils.A.toJson(map), new d(ao2Var));
    }

    @Nullable
    public final Subscription e(@Nullable String str, @Nullable String str2, @Nullable Context context, @Nullable ao2<Object> ao2Var) {
        if ((str == null || str.length() == 0) || context == null) {
            return null;
        }
        return tn2.x(WearUtils.x).d("/api/remote/application/user/check-protocol?applicationId=" + str + "&applicationVersion=" + str2, new e(ao2Var));
    }

    @Nullable
    public final Subscription f(@Nullable String str, @Nullable String str2, @Nullable Context context, @Nullable ao2<Object> ao2Var) {
        if ((str == null || str.length() == 0) || context == null) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("applicationId", str);
        if (str2 == null) {
            str2 = "";
        }
        map.put("applicationVersion", str2);
        return tn2.x(context).m("/api/remote/app_gallery/v3/detail", WearUtils.A.toJson(map), new f(ao2Var));
    }
}
