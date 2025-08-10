package dc;

import com.wear.network.presenter.bean.BaseResponseBean;
import java.util.Map;

/* compiled from: MessageNotificationPresenterImpl.java */
/* loaded from: classes3.dex */
public class wm2 extends tl2<fp2, Object> implements wn2<Object> {
    public vm2 c;

    public wm2(vm2 vm2Var) {
        this.c = vm2Var;
    }

    @Override // dc.tl2, dc.wn2
    public void a(boolean z, Object obj) {
        if (obj instanceof BaseResponseBean) {
            BaseResponseBean baseResponseBean = (BaseResponseBean) obj;
            if (g()) {
                ((fp2) this.b.get()).D3(z, baseResponseBean);
            }
        }
    }

    public void h(boolean z, Map<String, Object> map) {
        this.a = this.c.a(z, map, this);
    }
}
