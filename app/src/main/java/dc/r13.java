package dc;

import com.wear.bean.WishListLinkBean;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.util.HashMap;

/* compiled from: WishListCreatGuildPresenter.java */
/* loaded from: classes3.dex */
public class r13 extends tl2<s13, Object> {

    /* compiled from: WishListCreatGuildPresenter.java */
    public class a implements yn2<BaseResponseBeanNew<WishListLinkBean>> {
        public a() {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBeanNew<WishListLinkBean> baseResponseBeanNew) {
            if (r13.this.g()) {
                ((s13) r13.this.b.get()).B2(baseResponseBeanNew.data.getLink());
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            if (r13.this.g()) {
                ((s13) r13.this.b.get()).showErrorMsg(netException.message, false);
            }
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public void j() {
        this.a = tn2.x(WearUtils.x).i("/nh-order/wishList/loginLink", new HashMap(), new a());
    }
}
