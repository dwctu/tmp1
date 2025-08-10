package dc;

import com.wear.bean.WishListContribution;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.util.HashMap;
import rx.Subscription;

/* compiled from: DiscoverInterceptorImpl.java */
/* loaded from: classes3.dex */
public class bm2 {

    /* compiled from: DiscoverInterceptorImpl.java */
    public class a implements yn2<BaseResponseBeanNew<WishListContribution>> {
        public final /* synthetic */ wn2 a;

        public a(bm2 bm2Var, wn2 wn2Var) {
            this.a = wn2Var;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [T, com.wear.bean.WishListContribution] */
        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBeanNew<WishListContribution> baseResponseBeanNew) {
            if (baseResponseBeanNew.data == null) {
                baseResponseBeanNew.data = new WishListContribution();
            }
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

    public Subscription a(wn2<WishListContribution> wn2Var) {
        return tn2.x(WearUtils.x).i("/remote/wish-list/getNewContributionsCount", new HashMap(), new a(this, wn2Var));
    }
}
