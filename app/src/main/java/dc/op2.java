package dc;

import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.presenter.bean.GenTokenBean;
import com.wear.network.presenter.bean.LoginUserBean;
import com.wear.network.presenter.bean.QueryRemoteAccountInfoBean;
import com.wear.network.presenter.bean.SignUpCodeBean;

/* compiled from: SignUpView.java */
/* loaded from: classes3.dex */
public interface op2 extends ul2 {
    void H(boolean z, GenTokenBean genTokenBean);

    void H0(boolean z, BaseResponseBean baseResponseBean);

    void f(boolean z, String str, String str2);

    void h(boolean z, QueryRemoteAccountInfoBean queryRemoteAccountInfoBean);

    void w(boolean z, LoginUserBean loginUserBean);

    void x(boolean z, SignUpCodeBean signUpCodeBean);
}
