package dc;

import com.wear.bean.data.ChatGPTConfigBean;
import com.wear.bean.data.ChatGPTConfigData;
import com.wear.bean.request.ChatGPTConfigRequest;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.presenter.bean.GenTokenBean;
import com.wear.network.presenter.bean.LoginUserBean;
import com.wear.network.presenter.bean.QueryRemoteAccountInfoBean;
import com.wear.network.presenter.bean.SignUpCodeBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import rx.Subscription;

/* compiled from: SignUpInterceptorImpl.java */
/* loaded from: classes3.dex */
public class in2 {

    /* compiled from: SignUpInterceptorImpl.java */
    public class a implements yn2<SignUpCodeBean> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;

        public a(in2 in2Var, wn2 wn2Var, boolean z) {
            this.a = wn2Var;
            this.b = z;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(SignUpCodeBean signUpCodeBean) {
            this.a.a(this.b, signUpCodeBean);
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            this.a.b(netException.getMessage(), this.b);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: SignUpInterceptorImpl.java */
    public class b implements yn2<BaseResponseBean> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;

        public b(in2 in2Var, wn2 wn2Var, boolean z) {
            this.a = wn2Var;
            this.b = z;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBean baseResponseBean) {
            this.a.a(this.b, baseResponseBean);
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

    /* compiled from: SignUpInterceptorImpl.java */
    public class c implements zn2<String> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;

        public c(in2 in2Var, wn2 wn2Var, boolean z) {
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

    /* compiled from: SignUpInterceptorImpl.java */
    public class d implements yn2<LoginUserBean> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;

        public d(wn2 wn2Var, boolean z) {
            this.a = wn2Var;
            this.b = z;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(LoginUserBean loginUserBean) {
            ch3.n().U(loginUserBean);
            in2.this.b();
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

    /* compiled from: SignUpInterceptorImpl.java */
    public class e implements zn2<String> {
        public e(in2 in2Var) {
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

    /* compiled from: SignUpInterceptorImpl.java */
    public class f implements yn2<GenTokenBean> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;

        public f(in2 in2Var, wn2 wn2Var, boolean z) {
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

    public final void b() {
        tn2.x(WearUtils.x).m("/api/chatgpt_function_config", ro2.c(new ChatGPTConfigRequest(ye3.x(), tz.i())), new e(this));
    }

    public Subscription c(boolean z, Map<String, Object> map, wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).i("/api/wear/genGtoken", map, new f(this, wn2Var, z));
    }

    public Subscription d(boolean z, Map<String, Object> map, wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).i("/ajaxSignup", map, new b(this, wn2Var, z));
    }

    public Subscription e(boolean z, wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).d("/ajaxSignup", new a(this, wn2Var, z));
    }

    public Subscription f(boolean z, Map<String, Object> map, wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).o("/app/checkOutAccountInfo", map, new d(wn2Var, z));
    }

    public Subscription g(boolean z, Map<String, Object> map, wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).m("/api/queryRemoteAccountInfo", WearUtils.A.toJson(map), new c(this, wn2Var, z));
    }
}
