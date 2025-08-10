package dc;

import android.text.TextUtils;
import com.lovense.wear.R;
import com.wear.bean.CheckEmailCodeBean;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.util.Map;
import rx.Subscription;

/* compiled from: ForgetPassInterceptorImpl.java */
/* loaded from: classes3.dex */
public class fm2 {

    /* compiled from: ForgetPassInterceptorImpl.java */
    public class a implements yn2<BaseResponseBean> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;

        public a(fm2 fm2Var, wn2 wn2Var, boolean z) {
            this.a = wn2Var;
            this.b = z;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBean baseResponseBean) {
            this.a.a(this.b, baseResponseBean);
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            String message = netException.getMessage();
            if (TextUtils.equals("50010", netException.getCode())) {
                message = ah4.e(R.string.error_verify_reach_limit);
            }
            this.a.b(message, this.b);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: ForgetPassInterceptorImpl.java */
    public class b implements yn2<CheckEmailCodeBean> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;

        public b(fm2 fm2Var, wn2 wn2Var, boolean z) {
            this.a = wn2Var;
            this.b = z;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(CheckEmailCodeBean checkEmailCodeBean) {
            this.a.a(this.b, checkEmailCodeBean);
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            String message = netException.getMessage();
            if (TextUtils.equals("2", netException.getCode())) {
                message = ah4.e(R.string.wrong_email_verification);
            } else if (TextUtils.equals("5", netException.getCode())) {
                message = ah4.e(R.string.signup_password_notice);
            }
            this.a.b(message, this.b);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public Subscription a(boolean z, Map<String, Object> map, wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).i("/check_email_code", map, new b(this, wn2Var, z));
    }

    public Subscription b(boolean z, Map<String, Object> map, wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).i("/ajaxMailPassword", map, new a(this, wn2Var, z));
    }
}
