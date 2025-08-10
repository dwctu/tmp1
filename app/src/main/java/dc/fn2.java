package dc;

import com.google.gson.Gson;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.presenter.bean.ReportUserJsonBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.util.HashMap;
import rx.Subscription;

/* compiled from: ReportFriendInterceptor.java */
/* loaded from: classes3.dex */
public class fn2 {

    /* compiled from: ReportFriendInterceptor.java */
    public class a implements yn2<String> {
        public final /* synthetic */ wn2 a;

        public a(fn2 fn2Var, wn2 wn2Var) {
            this.a = wn2Var;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            BaseResponseBean baseResponseBean = (BaseResponseBean) new Gson().fromJson(str, BaseResponseBean.class);
            if (baseResponseBean.isResult()) {
                this.a.a(false, baseResponseBean);
            } else {
                this.a.b(baseResponseBean.getMessage(), false);
            }
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

    /* compiled from: ReportFriendInterceptor.java */
    public class b implements yn2<BaseResponseBeanNew<String>> {
        public final /* synthetic */ wn2 a;

        public b(fn2 fn2Var, wn2 wn2Var) {
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

    public Subscription a(String str, String str2, String str3, String str4, String str5, String str6, wn2<Object> wn2Var) {
        ReportUserJsonBean reportUserJsonBean = new ReportUserJsonBean();
        reportUserJsonBean.setAppType("remote");
        reportUserJsonBean.setReported(nd3.w(str));
        reportUserJsonBean.setReportType(str2);
        reportUserJsonBean.setOthersReason(str3);
        reportUserJsonBean.setImgs(str4);
        reportUserJsonBean.setChats(str5);
        reportUserJsonBean.setDesc(str6);
        return tn2.x(WearUtils.x).m("/remote/report-user/reportUser", new Gson().toJson(reportUserJsonBean), new a(this, wn2Var));
    }

    public Subscription b(String[] strArr, wn2<Object> wn2Var) {
        HashMap map = new HashMap();
        map.put("files", Integer.valueOf(strArr.length));
        return tn2.x(WearUtils.x).r("/remote/report-user/uploadMultipicture", map, strArr, new b(this, wn2Var));
    }
}
