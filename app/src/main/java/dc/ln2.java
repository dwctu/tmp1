package dc;

import com.wear.network.presenter.bean.BaseResponseBean;

/* compiled from: SerialNumberPresenterImpl.java */
/* loaded from: classes3.dex */
public class ln2 extends tl2<np2, Object> implements wn2<Object> {
    public kn2 c;

    public ln2(kn2 kn2Var) {
        this.c = kn2Var;
    }

    @Override // dc.tl2, dc.wn2
    public void a(boolean z, Object obj) {
        if (obj instanceof BaseResponseBean) {
            BaseResponseBean baseResponseBean = (BaseResponseBean) obj;
            if (g()) {
                ((np2) this.b.get()).U2(z, baseResponseBean);
            }
        }
    }

    @Override // dc.tl2, dc.wn2
    public void b(String str, boolean z) {
        super.b(str, z);
        if (g()) {
            ((np2) this.b.get()).showErrorMsg(str, z);
        }
    }

    public void h(boolean z, String str) {
        this.a = this.c.a(z, str, this);
    }
}
