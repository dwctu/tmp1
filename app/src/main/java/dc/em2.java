package dc;

import com.wear.network.presenter.bean.BaseResponseBean;
import java.util.Map;

/* compiled from: FAQPresenterImpl.java */
/* loaded from: classes3.dex */
public class em2 extends tl2<zo2, Object> implements wn2<Object> {
    public dm2 c;

    public em2(dm2 dm2Var) {
        this.c = dm2Var;
    }

    @Override // dc.tl2, dc.wn2
    public void a(boolean z, Object obj) {
        if (obj instanceof BaseResponseBean) {
            BaseResponseBean baseResponseBean = (BaseResponseBean) obj;
            if (g()) {
                ((zo2) this.b.get()).g2(z, baseResponseBean);
            }
        }
    }

    public void h(boolean z, Map<String, Object> map) {
        this.a = this.c.a(z, map, this);
    }
}
