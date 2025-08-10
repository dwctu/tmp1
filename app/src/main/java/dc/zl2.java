package dc;

import com.epicgames.unreal.psoservices.PSOProgramService;
import com.wear.bean.SurveyInfoBean;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.network.presenter.bean.ReportStatusBean;
import com.wear.network.protocol.exception.NetException;
import java.util.HashMap;

/* compiled from: ChatRoomPresenter.java */
/* loaded from: classes3.dex */
public class zl2 extends tl2<wo2, Object> {
    public jm2 c;
    public el2 d;

    /* compiled from: ChatRoomPresenter.java */
    public class a implements wn2<Object> {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // dc.wn2
        public void a(boolean z, Object obj) {
            if (obj instanceof ReportStatusBean) {
                ReportStatusBean reportStatusBean = (ReportStatusBean) obj;
                if (zl2.this.g()) {
                    ((wo2) zl2.this.b.get()).z(true, reportStatusBean.getStatus(), this.a);
                }
            }
        }

        @Override // dc.wn2
        public void b(String str, boolean z) {
            if (zl2.this.g()) {
                ((wo2) zl2.this.b.get()).showErrorMsg(str, z);
            }
        }

        @Override // dc.wn2
        public void d(NetException netException, boolean z) {
            if (zl2.this.g()) {
                ((wo2) zl2.this.b.get()).showErrorMsg(netException.message, z);
            }
        }
    }

    /* compiled from: ChatRoomPresenter.java */
    public class b implements wn2<Object> {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.wn2
        public void a(boolean z, Object obj) {
            BaseResponseBeanNew baseResponseBeanNew;
            if ((obj instanceof BaseResponseBeanNew) && (baseResponseBeanNew = (BaseResponseBeanNew) obj) != null && baseResponseBeanNew.code == 0 && zl2.this.g()) {
                ((wo2) zl2.this.b.get()).m((SurveyInfoBean) baseResponseBeanNew.data);
            }
        }

        @Override // dc.wn2
        public void b(String str, boolean z) {
        }

        @Override // dc.wn2
        public void d(NetException netException, boolean z) {
        }
    }

    public zl2(jm2 jm2Var, el2 el2Var) {
        this.c = jm2Var;
        this.d = el2Var;
    }

    public void l(String str) {
        this.d.a(str, new b());
    }

    public void m(String str) {
        HashMap map = new HashMap();
        map.put(PSOProgramService.JobID_Key, nd3.w(str));
        this.c.a(false, map, new a(str));
    }
}
