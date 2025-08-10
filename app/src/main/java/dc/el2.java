package dc;

import com.wear.bean.SurveyInfoBean;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.bean.socketio.controlLink.request.ReactivateControlLinkRequest;
import com.wear.bean.socketio.controlLink.response.ReactivateControlLinkResponse;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import rx.Subscription;

/* compiled from: SurveyInterceptorImpl.java */
/* loaded from: classes3.dex */
public class el2 {

    /* compiled from: SurveyInterceptorImpl.java */
    public class a implements yn2<BaseResponseBeanNew<SurveyInfoBean>> {
        public final /* synthetic */ wn2 a;

        public a(el2 el2Var, wn2 wn2Var) {
            this.a = wn2Var;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBeanNew<SurveyInfoBean> baseResponseBeanNew) {
            this.a.a(false, baseResponseBeanNew);
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            this.a.b(netException.getMessage(), false);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: SurveyInterceptorImpl.java */
    public class b implements yn2<ReactivateControlLinkResponse> {
        public final /* synthetic */ wn2 a;

        public b(el2 el2Var, wn2 wn2Var) {
            this.a = wn2Var;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(ReactivateControlLinkResponse reactivateControlLinkResponse) {
            this.a.a(false, reactivateControlLinkResponse);
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            this.a.b(netException.getMessage(), false);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public Subscription a(String str, wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).d("/app/survey/get?module=" + str, new a(this, wn2Var));
    }

    public Subscription b(String str, wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).h("/app/long_time_control_link/reactive", ro2.c(new ReactivateControlLinkRequest(str)), new b(this, wn2Var));
    }
}
