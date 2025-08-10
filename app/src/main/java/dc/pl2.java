package dc;

import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.presenter.bean.LoginUserBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.util.HashMap;
import java.util.Map;
import rx.Subscription;

/* compiled from: ProfileInterceptorImpl.java */
/* loaded from: classes3.dex */
public class pl2 {

    /* compiled from: ProfileInterceptorImpl.java */
    public class a implements yn2<BaseResponseBean> {
        public final /* synthetic */ wn2 a;

        public a(pl2 pl2Var, wn2 wn2Var) {
            this.a = wn2Var;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBean baseResponseBean) {
            this.a.a(false, baseResponseBean);
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            this.a.d(netException, false);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: ProfileInterceptorImpl.java */
    public class b implements yn2<BaseResponseBeanNew<LoginUserBean.Birth>> {
        public final /* synthetic */ wn2 a;

        public b(pl2 pl2Var, wn2 wn2Var) {
            this.a = wn2Var;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBeanNew<LoginUserBean.Birth> baseResponseBeanNew) {
            this.a.a(false, baseResponseBeanNew.data);
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            this.a.d(netException, false);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: ProfileInterceptorImpl.java */
    public class c implements yn2<BaseResponseBean> {
        public final /* synthetic */ wn2 a;

        public c(pl2 pl2Var, wn2 wn2Var) {
            this.a = wn2Var;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBean baseResponseBean) {
            this.a.a(false, baseResponseBean);
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            this.a.d(netException, false);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: ProfileInterceptorImpl.java */
    public class d implements yn2<Object> {
        public final /* synthetic */ wn2 a;

        public d(pl2 pl2Var, wn2 wn2Var) {
            this.a = wn2Var;
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            this.a.d(netException, false);
        }

        @Override // dc.yn2
        public void onStart() {
        }

        @Override // dc.yn2, dc.zn2
        public void onSuccess(Object obj) {
            this.a.a(false, null);
        }
    }

    public Subscription a(wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).i("/remote/birth/read", new HashMap(), new d(this, wn2Var));
    }

    public Subscription b(Map<String, Object> map, wn2<BaseResponseBean> wn2Var) {
        return tn2.x(WearUtils.x).h("/remote/birth/update", WearUtils.A.toJson(map), new c(this, wn2Var));
    }

    public Subscription c(Map<String, Object> map, wn2<BaseResponseBean> wn2Var) {
        map.put("lang", lg3.b(WearUtils.x));
        return tn2.x(WearUtils.x).h("/remote/birth/subscribe", WearUtils.A.toJson(map), new a(this, wn2Var));
    }

    public Subscription d(wn2<LoginUserBean.Birth> wn2Var) {
        return tn2.x(WearUtils.x).i("/remote/birth/info", new HashMap(), new b(this, wn2Var));
    }
}
