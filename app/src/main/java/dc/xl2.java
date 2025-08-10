package dc;

import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.presenter.bean.SignUpCodeBean;
import java.util.Map;

/* compiled from: ChangePasswordPresenterImpl.java */
/* loaded from: classes3.dex */
public class xl2 extends tl2<uo2, Object> implements wn2<Object> {
    public wl2 c;

    public xl2(wl2 wl2Var) {
        this.c = wl2Var;
    }

    @Override // dc.tl2, dc.wn2
    public void a(boolean z, Object obj) {
        if (obj instanceof SignUpCodeBean) {
            SignUpCodeBean signUpCodeBean = (SignUpCodeBean) obj;
            if (g()) {
                ((uo2) this.b.get()).x(z, signUpCodeBean);
            }
        }
        if (obj instanceof BaseResponseBean) {
            BaseResponseBean baseResponseBean = (BaseResponseBean) obj;
            if (g()) {
                ((uo2) this.b.get()).P2(z, baseResponseBean);
            }
        }
    }

    public void h(boolean z, Map<String, Object> map) {
        this.a = this.c.a(z, map, this);
    }

    public void i(boolean z) {
        this.a = this.c.b(z, this);
    }
}
