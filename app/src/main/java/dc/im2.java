package dc;

import com.wear.network.presenter.bean.BaseResponseBean;
import java.util.Map;

/* compiled from: ResetPassPresenterImpl.java */
/* loaded from: classes3.dex */
public class im2 extends tl2<mp2, Object> implements wn2<Object> {
    public hm2 c;

    public im2(hm2 hm2Var) {
        this.c = hm2Var;
    }

    @Override // dc.tl2, dc.wn2
    public void a(boolean z, Object obj) {
        super.a(z, obj);
        if (obj instanceof BaseResponseBean) {
            BaseResponseBean baseResponseBean = (BaseResponseBean) obj;
            if (g()) {
                ((mp2) this.b.get()).F0(baseResponseBean);
            }
        }
    }

    public void h(boolean z, Map<String, Object> map) {
        this.a = this.c.a(z, map, this);
    }
}
