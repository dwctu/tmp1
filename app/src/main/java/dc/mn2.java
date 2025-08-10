package dc;

import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import rx.Subscription;

/* compiled from: ToyStrengthInterceptorImpl.java */
/* loaded from: classes3.dex */
public class mn2 {

    /* compiled from: ToyStrengthInterceptorImpl.java */
    public class a implements yn2<BaseResponseBean> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;

        public a(mn2 mn2Var, wn2 wn2Var, boolean z) {
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

    public Subscription a(boolean z, String str, wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).h("/api/user/saveToyStrength", str, new a(this, wn2Var, z));
    }
}
