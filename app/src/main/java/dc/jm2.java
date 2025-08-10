package dc;

import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.network.presenter.bean.ReportStatusBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.util.Map;
import rx.Subscription;

/* compiled from: FriendProfileInterceptorImpl.java */
/* loaded from: classes3.dex */
public class jm2 {

    /* compiled from: FriendProfileInterceptorImpl.java */
    public class a implements yn2<BaseResponseBeanNew<ReportStatusBean>> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;

        public a(jm2 jm2Var, wn2 wn2Var, boolean z) {
            this.a = wn2Var;
            this.b = z;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBeanNew<ReportStatusBean> baseResponseBeanNew) {
            this.a.a(this.b, baseResponseBeanNew.data);
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            this.a.d(netException, this.b);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public Subscription a(boolean z, Map<String, Object> map, wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).i("/remote/report-user/getReportUserStatus", map, new a(this, wn2Var, z));
    }
}
