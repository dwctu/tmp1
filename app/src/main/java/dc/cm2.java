package dc;

import com.wear.bean.WishListContribution;
import com.wear.network.protocol.exception.NetException;

/* compiled from: DiscoverPresenter.java */
/* loaded from: classes3.dex */
public class cm2 extends tl2<yo2, Object> {
    public bm2 c;

    /* compiled from: DiscoverPresenter.java */
    public class a implements wn2<WishListContribution> {
        public a() {
        }

        @Override // dc.wn2
        public void b(String str, boolean z) {
            if (cm2.this.g()) {
                ((yo2) cm2.this.b.get()).showErrorMsg(str, false);
                ((yo2) cm2.this.b.get()).g3();
            }
        }

        @Override // dc.wn2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(boolean z, WishListContribution wishListContribution) {
            if (cm2.this.g()) {
                ((yo2) cm2.this.b.get()).G0(wishListContribution);
            }
        }

        @Override // dc.wn2
        public void d(NetException netException, boolean z) {
            if (cm2.this.g()) {
                ((yo2) cm2.this.b.get()).showErrorMsg(netException.getMessage(), false);
            }
        }
    }

    public cm2(bm2 bm2Var) {
        this.c = bm2Var;
    }

    public void l() {
        this.a = this.c.a(new a());
    }
}
