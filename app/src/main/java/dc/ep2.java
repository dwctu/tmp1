package dc;

import com.wear.bean.InviteRequestInfo;
import com.wear.bean.response.NtokenResponseBean;
import com.wear.network.presenter.bean.AccountConfigBean;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.presenter.bean.LoginUserBean;
import com.wear.network.presenter.bean.PrivacyPolicyStatusBean;
import com.wear.network.presenter.bean.QueryRemoteAccountInfoBean;
import com.wear.network.presenter.bean.UserInfoBean;

/* compiled from: MainView.java */
/* loaded from: classes3.dex */
public interface ep2 extends ul2 {
    void L0(boolean z, BaseResponseBean baseResponseBean);

    void N(AccountConfigBean accountConfigBean);

    void O0();

    void Q3(boolean z, LoginUserBean loginUserBean, String str, String str2);

    void U(boolean z, NtokenResponseBean ntokenResponseBean);

    void Z0(boolean z, PrivacyPolicyStatusBean privacyPolicyStatusBean);

    void f(boolean z, String str, String str2);

    void h(boolean z, QueryRemoteAccountInfoBean queryRemoteAccountInfoBean);

    void j1(String str, InviteRequestInfo inviteRequestInfo);

    void k1(boolean z, String str);

    void t3(BaseResponseBean baseResponseBean);

    void y2(boolean z, UserInfoBean userInfoBean);
}
