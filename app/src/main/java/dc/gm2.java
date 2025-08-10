package dc;

import com.wear.bean.CheckEmailCodeBean;
import com.wear.network.presenter.bean.BaseResponseBean;
import java.util.Map;

/* compiled from: ForgetPassPresenterImpl.java */
/* loaded from: classes3.dex */
public class gm2 extends tl2<ap2, Object> implements wn2<Object> {
    public fm2 c;

    public gm2(fm2 fm2Var) {
        this.c = fm2Var;
    }

    @Override // dc.tl2, dc.wn2
    public void a(boolean z, Object obj) {
        if (obj instanceof BaseResponseBean) {
            BaseResponseBean baseResponseBean = (BaseResponseBean) obj;
            if (g()) {
                ((ap2) this.b.get()).s1(z, baseResponseBean);
                return;
            }
            return;
        }
        if (obj instanceof CheckEmailCodeBean) {
            CheckEmailCodeBean checkEmailCodeBean = (CheckEmailCodeBean) obj;
            if (g()) {
                ((ap2) this.b.get()).T2(z, checkEmailCodeBean);
            }
        }
    }

    public void h(boolean z, Map<String, Object> map) {
        this.a = this.c.a(z, map, this);
    }

    public void i(boolean z, Map<String, Object> map) {
        this.a = this.c.b(z, map, this);
    }
}
