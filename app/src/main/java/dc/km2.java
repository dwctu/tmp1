package dc;

import com.epicgames.unreal.psoservices.PSOProgramService;
import com.wear.network.presenter.bean.ReportStatusBean;
import com.wear.network.protocol.exception.NetException;
import java.util.HashMap;

/* compiled from: FriendProfilePresenterImpl.java */
/* loaded from: classes3.dex */
public class km2 extends tl2<bp2, Object> implements wn2<Object> {
    public jm2 c;

    public km2(jm2 jm2Var) {
        this.c = jm2Var;
    }

    @Override // dc.tl2, dc.wn2
    public void a(boolean z, Object obj) {
        super.a(z, obj);
        if (obj instanceof ReportStatusBean) {
            ReportStatusBean reportStatusBean = (ReportStatusBean) obj;
            if (g()) {
                ((bp2) this.b.get()).n3(true, reportStatusBean.getStatus());
            }
        }
    }

    @Override // dc.tl2, dc.wn2
    public void b(String str, boolean z) {
        super.b(str, z);
        if (g()) {
            ((bp2) this.b.get()).showErrorMsg(str, z);
        }
    }

    @Override // dc.tl2, dc.wn2
    public void d(NetException netException, boolean z) {
        super.d(netException, z);
        if (g()) {
            ((bp2) this.b.get()).showErrorMsg(netException.message, z);
        }
    }

    public void h(String str) {
        HashMap map = new HashMap();
        map.put(PSOProgramService.JobID_Key, nd3.w(str));
        this.c.a(false, map, this);
    }
}
