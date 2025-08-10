package dc;

import com.epicgames.unreal.psoservices.PSOProgramService;
import com.wear.network.presenter.bean.GroupReportState;
import com.wear.network.presenter.bean.ReportStatusBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.util.HashMap;

/* compiled from: ChatRoomInfPresenterImpl.java */
/* loaded from: classes3.dex */
public class yl2 extends tl2<vo2, Object> implements wn2<Object> {
    public jm2 c;
    public hn2 d;

    /* compiled from: ChatRoomInfPresenterImpl.java */
    public class a implements wn2<Object> {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // dc.wn2
        public void a(boolean z, Object obj) {
            if (obj instanceof ReportStatusBean) {
                ReportStatusBean reportStatusBean = (ReportStatusBean) obj;
                if (yl2.this.g()) {
                    ((vo2) yl2.this.b.get()).z(true, reportStatusBean.getStatus(), this.a);
                }
            }
        }

        @Override // dc.wn2
        public void b(String str, boolean z) {
            if (yl2.this.g()) {
                ((vo2) yl2.this.b.get()).showErrorMsg(str, z);
            }
        }

        @Override // dc.wn2
        public void d(NetException netException, boolean z) {
            if (yl2.this.g()) {
                ((vo2) yl2.this.b.get()).showErrorMsg(netException.message, z);
            }
        }
    }

    /* compiled from: ChatRoomInfPresenterImpl.java */
    public class b implements wn2<GroupReportState> {
        public b() {
        }

        @Override // dc.wn2
        public void b(String str, boolean z) {
            if (yl2.this.g()) {
                ((vo2) yl2.this.b.get()).showErrorMsg(str, false);
            }
        }

        @Override // dc.wn2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(boolean z, GroupReportState groupReportState) {
            if (yl2.this.g()) {
                ((vo2) yl2.this.b.get()).Y0(true, groupReportState.getStatus());
            }
        }

        @Override // dc.wn2
        public void d(NetException netException, boolean z) {
            if (yl2.this.g()) {
                ((vo2) yl2.this.b.get()).showErrorMsg(netException.getMessage(), false);
            }
        }
    }

    public yl2(jm2 jm2Var, hn2 hn2Var) {
        this.d = hn2Var;
        this.c = jm2Var;
    }

    @Override // dc.tl2, dc.wn2
    public void a(boolean z, Object obj) {
        super.a(z, obj);
    }

    @Override // dc.tl2, dc.wn2
    public void b(String str, boolean z) {
        super.b(str, z);
    }

    @Override // dc.tl2, dc.wn2
    public void d(NetException netException, boolean z) {
        super.d(netException, z);
    }

    public void n(String str) {
        HashMap map = new HashMap();
        map.put(PSOProgramService.JobID_Key, nd3.w(str));
        this.c.a(false, map, new a(str));
    }

    public void o(String str) {
        HashMap map = new HashMap();
        map.put("groupId", nd3.w(WearUtils.g0(str)));
        this.a = this.d.a(map, new b());
    }
}
