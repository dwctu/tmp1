package dc;

import com.wear.network.presenter.bean.UserGuidesBean;
import java.util.Map;

/* compiled from: UserGuidesPresenterImpl.java */
/* loaded from: classes3.dex */
public class pn2 extends tl2<qp2, Object> implements wn2<Object> {
    public on2 c;

    public pn2(on2 on2Var) {
        this.c = on2Var;
    }

    @Override // dc.tl2, dc.wn2
    public void a(boolean z, Object obj) {
        if (obj instanceof UserGuidesBean) {
            UserGuidesBean userGuidesBean = (UserGuidesBean) obj;
            if (g()) {
                ((qp2) this.b.get()).X0(z, userGuidesBean);
            }
        }
    }

    public void h(boolean z, Map<String, Object> map) {
        this.a = this.c.a(z, map, this);
    }
}
