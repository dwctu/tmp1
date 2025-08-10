package dc;

import android.content.Context;
import com.wear.bean.CheckProtocolBean;
import com.wear.bean.GalleryDetailsV2Bean;
import com.wear.bean.XRemoteAgreeBean;
import com.wear.bean.XRemoteAppUserBean;
import com.wear.bean.XRemoteAuthCodeBean;
import com.wear.network.protocol.exception.NetException;
import dc.u23;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.Subscription;

/* compiled from: XRemotePresenterImpl.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J&\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J:\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J&\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J&\u0010\u0019\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u001c\u0010\u001c\u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\u000e2\b\u0010\"\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010#\u001a\u00020\u001bH\u0016J\u001a\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&2\b\u0010\"\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0005¨\u0006'"}, d2 = {"Lcom/wear/ui/discover/xremote/model/XRemotePresenter;", "Lcom/wear/network/protocol/callback/XRemoteRequestCallBack;", "", "view", "Lcom/wear/ui/discover/xremote/view/XRemoteView;", "(Lcom/wear/ui/discover/xremote/view/XRemoteView;)V", "mXRemoteInterceptorImpl", "Lcom/wear/ui/discover/xremote/model/XRemoteInterceptorImpl;", "getView", "()Lcom/wear/ui/discover/xremote/view/XRemoteView;", "setView", "agreeProtocol", "Lrx/Subscription;", "applicationId", "", "applicationVersion", "context", "Landroid/content/Context;", "getAppAccountInfo", "getAppAccountInfoV2", "version", "getAuthCode", "scope", "userId", "getUserCheckProtocol", "getWhiteList", "onCompleted", "", "onError", "e", "Lcom/wear/network/protocol/exception/NetException;", "type", "", "errorMsg", "data", "onStart", "onSuccess", "pullToRefresh", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class r23 implements ao2<Object> {

    @NotNull
    public u23 a;

    @NotNull
    public q23 b;

    public r23(@NotNull u23 view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = view;
        this.b = new q23();
    }

    @Override // dc.ao2
    public void a(boolean z, @Nullable Object obj) {
        if (obj != null) {
            if (obj instanceof XRemoteAppUserBean.DataBean) {
                XRemoteAppUserBean.DataBean dataBean = (XRemoteAppUserBean.DataBean) obj;
                if (Intrinsics.areEqual(dataBean.getVersion(), "2.0")) {
                    this.a.i3(dataBean);
                    return;
                } else {
                    this.a.Q2(dataBean);
                    return;
                }
            }
            if (obj instanceof XRemoteAuthCodeBean) {
                this.a.b2(((XRemoteAuthCodeBean) obj).getData());
                return;
            }
            if (obj instanceof GalleryDetailsV2Bean) {
                this.a.s0((GalleryDetailsV2Bean) obj);
            } else if (obj instanceof CheckProtocolBean) {
                this.a.b1((CheckProtocolBean) obj);
            } else if (obj instanceof XRemoteAgreeBean) {
                this.a.f3();
            }
        }
    }

    @Override // dc.ao2
    public void b(@Nullable String str, @Nullable Object obj) {
        if (Intrinsics.areEqual(obj, Boolean.FALSE)) {
            this.a.h1();
            return;
        }
        if (obj != null) {
            if (!(obj instanceof XRemoteAppUserBean.DataBean)) {
                if (obj instanceof XRemoteAuthCodeBean) {
                    this.a.N0();
                    return;
                }
                if (obj instanceof GalleryDetailsV2Bean) {
                    this.a.T((GalleryDetailsV2Bean) obj);
                    return;
                } else if (obj instanceof CheckProtocolBean) {
                    this.a.V0();
                    return;
                } else {
                    if (obj instanceof XRemoteAgreeBean) {
                        this.a.S1();
                        return;
                    }
                    return;
                }
            }
            XRemoteAppUserBean.DataBean dataBean = (XRemoteAppUserBean.DataBean) obj;
            if (!Intrinsics.areEqual(dataBean.getVersion(), "2.0")) {
                this.a.h1();
                return;
            }
            if (dataBean.getApplication() != null) {
                String applicationId = dataBean.getApplication().getApplicationId();
                if (!(applicationId == null || applicationId.length() == 0)) {
                    String applicationName = dataBean.getApplication().getApplicationName();
                    if (!(applicationName == null || applicationName.length() == 0)) {
                        List<XRemoteAppUserBean.DataBean.ApplicationAccount> applicationAccountList = dataBean.getApplicationAccountList();
                        if (applicationAccountList == null || applicationAccountList.isEmpty()) {
                            this.a.m3();
                            return;
                        } else {
                            this.a.Z();
                            return;
                        }
                    }
                }
            }
            this.a.D0();
        }
    }

    @Override // dc.ao2
    public void c(@Nullable NetException netException, int i) {
        this.a.showErrorMsg(netException != null ? netException.message : null, false);
        if (i == 1) {
            u23.a.a(this.a, null, 1, null);
            return;
        }
        if (i == 3) {
            this.a.V0();
            return;
        }
        if (i == 4) {
            this.a.S1();
        } else if (i != 5) {
            this.a.h1();
        } else {
            this.a.N0();
        }
    }

    @Nullable
    public final Subscription d(@NotNull String applicationId, @NotNull String applicationVersion, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(applicationVersion, "applicationVersion");
        Intrinsics.checkNotNullParameter(context, "context");
        return this.b.a(applicationId, applicationVersion, context, this);
    }

    @Nullable
    public final Subscription e(@Nullable String str, @Nullable Context context) {
        return this.b.b(str, context, this);
    }

    @Nullable
    public final Subscription f(@Nullable String str, @Nullable String str2, @Nullable Context context) {
        return this.b.c(str, str2, context, this);
    }

    @Nullable
    public final Subscription g(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Context context) {
        return this.b.d(str, str2, str3, str4, context, this);
    }

    @Nullable
    public final Subscription h(@Nullable String str, @Nullable String str2, @Nullable Context context) {
        return this.b.e(str, str2, context, this);
    }

    @Nullable
    public final Subscription i(@Nullable String str, @Nullable String str2, @Nullable Context context) {
        return this.b.f(str, str2, context, this);
    }
}
