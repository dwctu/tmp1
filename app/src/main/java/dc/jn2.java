package dc;

import android.os.Build;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.presenter.bean.GenTokenBean;
import com.wear.network.presenter.bean.LoginUserBean;
import com.wear.network.presenter.bean.QueryRemoteAccountInfoBean;
import com.wear.network.presenter.bean.SignUpCodeBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.NoSuchPaddingException;
import org.jivesoftware.smack.roster.packet.RosterVer;

/* compiled from: SignUpPresenterImpl.java */
/* loaded from: classes3.dex */
public class jn2 extends tl2<op2, Object> implements wn2<Object> {
    public in2 c;

    public jn2(in2 in2Var) {
        this.c = in2Var;
    }

    @Override // dc.tl2, dc.wn2
    public void a(boolean z, Object obj) {
        if (obj instanceof SignUpCodeBean) {
            SignUpCodeBean signUpCodeBean = (SignUpCodeBean) obj;
            if (g()) {
                ((op2) this.b.get()).x(z, signUpCodeBean);
            }
        }
        if (obj instanceof BaseResponseBean) {
            BaseResponseBean baseResponseBean = (BaseResponseBean) obj;
            if (g()) {
                ((op2) this.b.get()).H0(z, baseResponseBean);
            }
        }
        if (obj instanceof LoginUserBean) {
            LoginUserBean loginUserBean = (LoginUserBean) obj;
            if (g()) {
                ((op2) this.b.get()).w(z, loginUserBean);
            }
        }
        if (obj instanceof GenTokenBean) {
            GenTokenBean genTokenBean = (GenTokenBean) obj;
            if (g()) {
                ((op2) this.b.get()).H(z, genTokenBean);
            }
        }
        if (obj instanceof QueryRemoteAccountInfoBean) {
            QueryRemoteAccountInfoBean queryRemoteAccountInfoBean = (QueryRemoteAccountInfoBean) obj;
            if (g()) {
                ((op2) this.b.get()).h(z, queryRemoteAccountInfoBean);
            }
        }
    }

    @Override // dc.tl2, dc.wn2
    public void d(NetException netException, boolean z) {
        try {
            ((op2) this.b.get()).f(z, netException.getMessage(), netException.getCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void h(boolean z, String str, String str2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        String strA = xf3.a(str2, "009b72ee52c67697ee4290955ad91aa52172cf7494ce6cbfd711c4ce76efe9efad4a151174e774165944ba97b6d72934d6f04c53c1aef30b736c7cae8fb2638670efb89cdb4eb40d4ea6264fa3157e711c6d2779ce2cc4146d0cc7af7a2d7e5dec470862efb81bc541348cbb0176f3b75b0d842b36ffeec46070a6517f4330f883", "010001");
        HashMap map = new HashMap();
        map.put("email", str.toLowerCase());
        map.put("password", strA);
        map.put("pf", wg3.a());
        map.put(RosterVer.ELEMENT, WearUtils.q);
        map.put("signature", wg3.b(str.toLowerCase() + "##" + strA));
        map.put("sessionId", ye3.x());
        map.put("deviceId", tz.i());
        map.put("deviceName", Build.MODEL);
        ye3.c0(1, false);
        zd3.f("userName", str.toLowerCase());
        this.a = this.c.c(z, map, this);
    }

    public void i(boolean z, Map<String, Object> map) {
        this.a = this.c.d(z, map, this);
    }

    public void j(boolean z) {
        this.a = this.c.e(z, this);
    }

    public void k(boolean z) {
        ye3.m();
        ye3.f("A0010");
        this.a = this.c.f(z, new HashMap(), this);
    }

    public void l(String[] strArr) {
        HashMap map = new HashMap();
        map.put("emails", strArr);
        this.a = this.c.g(false, map, this);
    }
}
