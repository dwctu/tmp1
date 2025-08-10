package dc;

import com.google.gson.Gson;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import rx.Subscription;

/* compiled from: SeriaNumberInterceptorImpl.java */
/* loaded from: classes3.dex */
public class kn2 {

    /* compiled from: SeriaNumberInterceptorImpl.java */
    public class a implements yn2<String> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;

        public a(kn2 kn2Var, wn2 wn2Var, boolean z) {
            this.a = wn2Var;
            this.b = z;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            this.a.a(this.b, (BaseResponseBean) new Gson().fromJson(str, BaseResponseBean.class));
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
        return tn2.x(WearUtils.x).m("/app/toy/serialNo", str, new a(this, wn2Var, z));
    }
}
