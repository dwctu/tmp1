package dc;

import com.wear.bean.data.ChatGPTConfigBean;
import com.wear.bean.data.ChatGPTConfigData;
import com.wear.bean.request.ChatGPTConfigRequest;
import com.wear.network.presenter.bean.AccountConfigBean;
import com.wear.network.presenter.bean.GenTokenBean;
import com.wear.network.presenter.bean.LoginUserBean;
import com.wear.network.presenter.bean.QueryRemoteAccountInfoBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import rx.Subscription;

/* compiled from: LoginInterceptorImpl.java */
/* loaded from: classes3.dex */
public class nm2 {

    /* compiled from: LoginInterceptorImpl.java */
    public class a implements yn2<LoginUserBean> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;

        public a(wn2 wn2Var, boolean z) {
            this.a = wn2Var;
            this.b = z;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(LoginUserBean loginUserBean) {
            ch3.n().U(loginUserBean);
            nm2.this.b();
            this.a.a(this.b, loginUserBean);
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            this.a.d(netException, this.b);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: LoginInterceptorImpl.java */
    public class b implements zn2<String> {
        public b(nm2 nm2Var) {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            ChatGPTConfigBean chatGPTConfigBean = (ChatGPTConfigBean) ro2.a(str, ChatGPTConfigBean.class);
            if (chatGPTConfigBean == null || !chatGPTConfigBean.getResult()) {
                return;
            }
            ChatGPTConfigData data = chatGPTConfigBean.getData();
            EventBus.getDefault().post(chatGPTConfigBean.getData());
            eg3.j(WearUtils.x, "chatGPTConfig", data.getEnableShow());
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
        }
    }

    /* compiled from: LoginInterceptorImpl.java */
    public class c implements zn2<String> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;

        public c(nm2 nm2Var, wn2 wn2Var, boolean z) {
            this.a = wn2Var;
            this.b = z;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            this.a.a(this.b, (QueryRemoteAccountInfoBean) WearUtils.A.fromJson(str, QueryRemoteAccountInfoBean.class));
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            this.a.d(netException, this.b);
        }
    }

    /* compiled from: LoginInterceptorImpl.java */
    public class d implements yn2<AccountConfigBean> {
        public final /* synthetic */ wn2 a;

        public d(nm2 nm2Var, wn2 wn2Var) {
            this.a = wn2Var;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(AccountConfigBean accountConfigBean) {
            if (accountConfigBean == null || !accountConfigBean.isResult()) {
                this.a.b(String.valueOf(accountConfigBean), false);
            } else {
                this.a.a(false, accountConfigBean);
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: LoginInterceptorImpl.java */
    public class e implements yn2<GenTokenBean> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;

        public e(nm2 nm2Var, wn2 wn2Var, boolean z) {
            this.a = wn2Var;
            this.b = z;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(GenTokenBean genTokenBean) {
            this.a.a(this.b, genTokenBean);
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            this.a.d(netException, this.b);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: LoginInterceptorImpl.java */
    public class f implements yn2<String> {
        public f(nm2 nm2Var) {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public final void b() {
        tn2.x(WearUtils.x).m("/api/chatgpt_function_config", ro2.c(new ChatGPTConfigRequest(ye3.x(), tz.i())), new b(this));
    }

    public Subscription c(boolean z, Map<String, Object> map, wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).i("/api/wear/genGtoken", map, new e(this, wn2Var, z));
    }

    public Subscription d(boolean z, Map<String, Object> map, wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).o("/app/checkOutAccountInfo", map, new a(wn2Var, z));
    }

    public Subscription e(Object obj) {
        return tn2.x(WearUtils.x).m("/date-web-api/api/remote/overEngagement", WearUtils.A.toJson(obj), new f(this));
    }

    public Subscription f(boolean z, Map<String, Object> map, wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).m("/api/queryRemoteAccountInfo", WearUtils.A.toJson(map), new c(this, wn2Var, z));
    }

    public Subscription g(wn2<Object> wn2Var) {
        new HashMap();
        return tn2.x(WearUtils.x).d("/api/remote_account_config", new d(this, wn2Var));
    }
}
