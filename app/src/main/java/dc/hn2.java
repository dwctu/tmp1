package dc;

import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.presenter.bean.GroupReportState;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import java.util.HashMap;
import java.util.Map;
import rx.Subscription;

/* compiled from: ReportGroupInterceptor.java */
/* loaded from: classes3.dex */
public class hn2 {

    /* compiled from: ReportGroupInterceptor.java */
    public class a implements yn2<BaseResponseBeanNew<String>> {
        public final /* synthetic */ wn2 a;

        public a(hn2 hn2Var, wn2 wn2Var) {
            this.a = wn2Var;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBeanNew<String> baseResponseBeanNew) {
            this.a.a(false, baseResponseBeanNew);
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            this.a.b(netException.message, false);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: ReportGroupInterceptor.java */
    public class b implements yn2<String> {
        public final /* synthetic */ wn2 a;

        public b(hn2 hn2Var, wn2 wn2Var) {
            this.a = wn2Var;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            this.a.a(false, Boolean.valueOf(((BaseResponseBean) WearUtils.A.fromJson(str, BaseResponseBean.class)).isResult()));
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            this.a.d(netException, false);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: ReportGroupInterceptor.java */
    public class c implements yn2<BaseResponseBeanNew<GroupReportState>> {
        public final /* synthetic */ wn2 a;

        public c(hn2 hn2Var, wn2 wn2Var) {
            this.a = wn2Var;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBeanNew<GroupReportState> baseResponseBeanNew) {
            this.a.a(false, baseResponseBeanNew.data);
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            this.a.d(netException, false);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public Subscription a(Map<String, Object> map, wn2<GroupReportState> wn2Var) {
        return tn2.x(MyApplication.N()).i("/remote/report-group/status", map, new c(this, wn2Var));
    }

    public Subscription b(Map<String, Object> map, wn2<Boolean> wn2Var) {
        return tn2.x(MyApplication.N()).m("/remote/report-group/report", WearUtils.A.toJson(map), new b(this, wn2Var));
    }

    public Subscription c(String[] strArr, wn2<Object> wn2Var) {
        HashMap map = new HashMap();
        map.put("files", Integer.valueOf(strArr.length));
        map.put("type", "group");
        return tn2.x(WearUtils.x).r("/remote/report-user/uploadMultipicture", map, strArr, new a(this, wn2Var));
    }
}
