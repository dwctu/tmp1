package dc;

import com.wear.network.presenter.bean.BaseResponseBean;

/* compiled from: ToyStrengthPresenterImpl.java */
/* loaded from: classes3.dex */
public class nn2 extends tl2<pp2, Object> implements wn2<Object> {
    public mn2 c;

    public nn2(mn2 mn2Var) {
        this.c = mn2Var;
    }

    @Override // dc.tl2, dc.wn2
    public void a(boolean z, Object obj) {
        if (obj instanceof BaseResponseBean) {
            BaseResponseBean baseResponseBean = (BaseResponseBean) obj;
            if (g()) {
                ((pp2) this.b.get()).w3(z, baseResponseBean);
            }
        }
    }

    public void h(boolean z, String str) {
        this.a = this.c.a(z, str, this);
    }
}
