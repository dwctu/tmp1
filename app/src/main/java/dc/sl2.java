package dc;

import android.os.Looper;
import com.wear.network.presenter.bean.BaseResponseBean;
import java.util.Map;

/* compiled from: AddFriendPresenterImpl.java */
/* loaded from: classes3.dex */
public class sl2 extends tl2<to2, Object> implements wn2<Object> {
    public rl2 c;

    public sl2(rl2 rl2Var) {
        this.c = rl2Var;
    }

    @Override // dc.tl2, dc.wn2
    public void a(boolean z, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("onSuccess: ");
        sb.append(Looper.getMainLooper() == Looper.myLooper());
        sb.toString();
        if (obj instanceof BaseResponseBean) {
            BaseResponseBean baseResponseBean = (BaseResponseBean) obj;
            if (g()) {
                ((to2) this.b.get()).x1(z, baseResponseBean);
            }
        }
    }

    public void h(boolean z, Map<String, Object> map) {
        this.a = this.c.a(z, map, this);
    }
}
