package dc;

import android.text.TextUtils;
import com.lovense.wear.R;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.util.Map;
import rx.Subscription;

/* compiled from: ResetPassInterceptorImpl.java */
/* loaded from: classes3.dex */
public class hm2 {

    /* compiled from: ResetPassInterceptorImpl.java */
    public class a implements yn2<BaseResponseBean> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;

        public a(hm2 hm2Var, wn2 wn2Var, boolean z) {
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
            if (TextUtils.equals("2", netException.getCode())) {
                message = ah4.e(R.string.wrong_email_verification);
            } else if (TextUtils.equals("5", netException.getCode())) {
                message = ah4.e(R.string.signup_password_notice);
            } else if (TextUtils.equals("10", netException.getCode())) {
                message = ah4.e(R.string.delete_account_notice2);
            } else if (TextUtils.equals("11", netException.getCode())) {
                message = ah4.e(R.string.password_is_weak1);
            } else if (TextUtils.equals("12", netException.getCode())) {
                message = ah4.e(R.string.password_is_weak2);
            }
            this.a.b(message, this.b);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public Subscription a(boolean z, Map<String, Object> map, wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).i("/reset_pass_submit", map, new a(this, wn2Var, z));
    }
}
