package dc;

import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.presenter.bean.PatternDeleteBean;

/* compiled from: PatternPresenterImpl.java */
/* loaded from: classes3.dex */
public class ym2 extends tl2<ip2, Object> implements wn2<Object> {
    public ym2(xm2 xm2Var) {
    }

    @Override // dc.tl2, dc.wn2
    public void a(boolean z, Object obj) {
        if (obj instanceof BaseResponseBean) {
            BaseResponseBean baseResponseBean = (BaseResponseBean) obj;
            if (g()) {
                ((ip2) this.b.get()).J3(z, baseResponseBean);
            }
        }
        if (obj instanceof PatternDeleteBean) {
            PatternDeleteBean patternDeleteBean = (PatternDeleteBean) obj;
            if (g()) {
                ((ip2) this.b.get()).f2(z, patternDeleteBean);
            }
        }
    }
}
