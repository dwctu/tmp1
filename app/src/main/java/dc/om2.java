package dc;

import android.os.Build;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.wear.bean.request.OverEngagementRequestBean;
import com.wear.dao.DaoUtils;
import com.wear.network.presenter.bean.AccountConfigBean;
import com.wear.network.presenter.bean.GenTokenBean;
import com.wear.network.presenter.bean.LoginUserBean;
import com.wear.network.presenter.bean.QueryRemoteAccountInfoBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.me3;
import java.util.HashMap;
import org.jivesoftware.smack.roster.packet.RosterVer;
import rx.Subscription;

/* compiled from: LoginPresenterImpl.java */
/* loaded from: classes3.dex */
public class om2 extends tl2<dp2, Object> implements wn2<Object> {
    public nm2 c;

    public om2(nm2 nm2Var) {
        this.c = nm2Var;
    }

    @Override // dc.tl2, dc.wn2
    public void a(boolean z, Object obj) {
        if (obj instanceof LoginUserBean) {
            LoginUserBean loginUserBean = (LoginUserBean) obj;
            if (g()) {
                ((dp2) this.b.get()).w(z, loginUserBean);
            }
        }
        if (obj instanceof GenTokenBean) {
            DaoUtils.getGiftCardDao().clear();
            MyApplication.N().L(2, null);
            GenTokenBean genTokenBean = (GenTokenBean) obj;
            if (g()) {
                ((dp2) this.b.get()).H(z, genTokenBean);
            }
        }
        if (obj instanceof QueryRemoteAccountInfoBean) {
            QueryRemoteAccountInfoBean queryRemoteAccountInfoBean = (QueryRemoteAccountInfoBean) obj;
            if (g()) {
                ((dp2) this.b.get()).h(z, queryRemoteAccountInfoBean);
            }
        }
        if (obj instanceof AccountConfigBean) {
            AccountConfigBean accountConfigBean = (AccountConfigBean) obj;
            if (g()) {
                ((dp2) this.b.get()).N(accountConfigBean);
            }
        }
        me3.c(me3.c.LOGIN_SUCCESS);
    }

    @Override // dc.tl2, dc.wn2
    public void d(NetException netException, boolean z) {
        try {
            ((dp2) this.b.get()).f(z, netException.getMessage(), netException.code);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void h() {
        this.c.g(this);
    }

    public void i(boolean z, String str, String str2) {
        String strA = xf3.a(str2, "009b72ee52c67697ee4290955ad91aa52172cf7494ce6cbfd711c4ce76efe9efad4a151174e774165944ba97b6d72934d6f04c53c1aef30b736c7cae8fb2638670efb89cdb4eb40d4ea6264fa3157e711c6d2779ce2cc4146d0cc7af7a2d7e5dec470862efb81bc541348cbb0176f3b75b0d842b36ffeec46070a6517f4330f883", "010001");
        HashMap map = new HashMap();
        String strI = WearUtils.i(str);
        map.put("email", strI.toLowerCase());
        map.put("password", strA);
        map.put("pf", wg3.a());
        map.put(RosterVer.ELEMENT, WearUtils.q);
        map.put("signature", wg3.b(strI.toLowerCase() + "##" + strA));
        map.put("tag", FirebaseAnalytics.Event.LOGIN);
        map.put("sessionId", ye3.x());
        map.put("deviceId", tz.i());
        map.put("deviceName", Build.MODEL);
        ye3.c0(1, false);
        zd3.f("userName", strI.toLowerCase());
        this.a = this.c.c(z, map, this);
    }

    public void j(boolean z) {
        ye3.m();
        ye3.f("A0010");
        this.a = this.c.d(z, new HashMap(), this);
    }

    public void k(String str, String str2) {
        OverEngagementRequestBean overEngagementRequestBean = new OverEngagementRequestBean();
        overEngagementRequestBean.datingId = str;
        overEngagementRequestBean.userName = str2;
        this.a = this.c.e(overEngagementRequestBean);
    }

    public void l(String[] strArr) {
        HashMap map = new HashMap();
        map.put("emails", strArr);
        this.a = this.c.f(false, map, this);
    }

    public void m() {
        Subscription subscription = this.a;
        if (subscription == null || subscription.isUnsubscribed()) {
            return;
        }
        this.a.unsubscribe();
        this.a = null;
    }
}
