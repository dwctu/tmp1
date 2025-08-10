package dc;

import com.wear.bean.WishListLinkBean;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.bean.response.WishListBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.util.HashMap;

/* compiled from: WishListViewPresenter.java */
/* loaded from: classes3.dex */
public class u13 extends tl2<t13, Object> {

    /* compiled from: WishListViewPresenter.java */
    public class a implements yn2<BaseResponseBeanNew<WishListLinkBean>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBeanNew<WishListLinkBean> baseResponseBeanNew) {
            if (u13.this.g()) {
                ((t13) u13.this.b.get()).W1(baseResponseBeanNew.data.getLink(), this.a, this.b);
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            if (u13.this.g()) {
                ((t13) u13.this.b.get()).showErrorMsg(netException.message, false);
            }
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: WishListViewPresenter.java */
    public class b implements yn2<WishListBean> {
        public b() {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(WishListBean wishListBean) {
            if (u13.this.g()) {
                ((t13) u13.this.b.get()).S(wishListBean.getData());
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            if (u13.this.g()) {
                ((t13) u13.this.b.get()).showErrorMsg(netException.getMessage(), false);
            }
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: WishListViewPresenter.java */
    public class c implements yn2<BaseResponseBeanNew<Object>> {
        public c(u13 u13Var) {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBeanNew<Object> baseResponseBeanNew) {
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

    public void l(String str, String str2) {
        this.a = tn2.x(WearUtils.x).i("/nh-order/wishList/loginLink", new HashMap(), new a(str, str2));
    }

    public void m(String str) {
        HashMap map = new HashMap();
        map.put("lang", str);
        this.a = tn2.x(WearUtils.x).i("/remote/wish-list/getWishList", map, new b());
    }

    public void n() {
        this.a = tn2.x(WearUtils.x).i("/remote/wish-list/readNewContributions", new HashMap(), new c(this));
    }
}
