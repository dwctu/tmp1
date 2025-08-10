package dc;

import com.wear.network.presenter.bean.UserGuidesBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.util.Map;
import rx.Subscription;

/* compiled from: UserGuidesInterceptorImpl.java */
/* loaded from: classes3.dex */
public class on2 {

    /* compiled from: UserGuidesInterceptorImpl.java */
    public class a implements yn2<UserGuidesBean> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;

        public a(on2 on2Var, wn2 wn2Var, boolean z) {
            this.a = wn2Var;
            this.b = z;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(UserGuidesBean userGuidesBean) {
            this.a.a(this.b, userGuidesBean);
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
        return tn2.x(WearUtils.x).i("/wear/userGuides", map, new a(this, wn2Var, z));
    }
}
