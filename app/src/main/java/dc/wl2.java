package dc;

import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.presenter.bean.SignUpCodeBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.util.Map;
import rx.Subscription;

/* compiled from: ChangePasswordInterceptorImpl.java */
/* loaded from: classes3.dex */
public class wl2 {

    /* compiled from: ChangePasswordInterceptorImpl.java */
    public class a implements yn2<SignUpCodeBean> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;

        public a(wl2 wl2Var, wn2 wn2Var, boolean z) {
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

    /* compiled from: ChangePasswordInterceptorImpl.java */
    public class b implements yn2<BaseResponseBean> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;

        public b(wl2 wl2Var, wn2 wn2Var, boolean z) {
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
            this.a.b(netException.getMessage(), this.b);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public Subscription a(boolean z, Map<String, Object> map, wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).i("/ajaxResetPassword", map, new b(this, wn2Var, z));
    }

    public Subscription b(boolean z, wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).d("/ajaxSignup", new a(this, wn2Var, z));
    }
}
