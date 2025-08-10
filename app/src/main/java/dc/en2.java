package dc;

import com.wear.network.presenter.bean.BaseResponseBean;
import java.util.Map;

/* compiled from: PatternFragmentPresenterImpl.java */
/* loaded from: classes3.dex */
public class en2 extends tl2<gp2, Object> implements wn2<Object> {
    public dn2 c;

    public en2(dn2 dn2Var) {
        this.c = dn2Var;
    }

    @Override // dc.tl2, dc.wn2
    public void a(boolean z, Object obj) {
        if (obj instanceof BaseResponseBean) {
            BaseResponseBean baseResponseBean = (BaseResponseBean) obj;
            if (g()) {
                ((gp2) this.b.get()).o0(z, baseResponseBean);
            }
        }
    }

    public void h(boolean z, Map<String, Object> map) {
        this.a = this.c.a(z, map, this);
    }
}
