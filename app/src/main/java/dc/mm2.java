package dc;

import com.wear.network.presenter.bean.BaseResponseBean;
import java.util.Map;

/* compiled from: HelpPresenterImpl.java */
/* loaded from: classes3.dex */
public class mm2 extends tl2<cp2, Object> implements wn2<Object> {
    public lm2 c;
    public String d;

    public mm2(lm2 lm2Var) {
        this.c = lm2Var;
    }

    @Override // dc.tl2, dc.wn2
    public void a(boolean z, Object obj) {
        if (obj instanceof BaseResponseBean) {
            BaseResponseBean baseResponseBean = (BaseResponseBean) obj;
            if (g()) {
                ((cp2) this.b.get()).F3(z, baseResponseBean, this.d);
            }
        }
    }

    public void h(boolean z, String str, Map<String, Object> map, String str2) {
        this.d = str2;
        this.a = this.c.a(z, str, map, this);
    }
}
