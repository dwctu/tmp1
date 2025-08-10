package dc;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.wear.bean.AvatarReportStatusBean;
import com.wear.bean.ColdReportBean;
import com.wear.bean.InviteRequestInfo;
import com.wear.bean.OpenAppBean;
import com.wear.bean.PolicyListBean;
import com.wear.bean.request.NtokenRequestBean;
import com.wear.bean.response.NtokenResponseBean;
import com.wear.network.presenter.bean.AccountConfigBean;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.presenter.bean.GenTokenBean;
import com.wear.network.presenter.bean.LoginUserBean;
import com.wear.network.presenter.bean.PrivacyPolicyStatusBean;
import com.wear.network.presenter.bean.QueryRemoteAccountInfoBean;
import com.wear.network.presenter.bean.RemoteVibemateEventConfigBean;
import com.wear.network.presenter.bean.UserInfoBean;
import com.wear.network.presenter.bean.VibemateBetrayOneselfBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: MainPresenterImpl.java */
/* loaded from: classes3.dex */
public class um2 extends tl2<ep2, Object> implements wn2<Object> {
    public static long j = 604800000;
    public String c;
    public String d;
    public tm2 e;
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;
    public String i = null;

    public um2(tm2 tm2Var) {
        this.e = tm2Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Unit u(String str) {
        if (MyApplication.O) {
            p(str);
            return null;
        }
        this.i = str;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Unit w(String str, InviteRequestInfo inviteRequestInfo) {
        this.i = null;
        if (inviteRequestInfo == null) {
            return null;
        }
        ((ep2) this.b.get()).j1(str, inviteRequestInfo);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Unit y(BaseResponseBean baseResponseBean) {
        ((ep2) this.b.get()).t3(baseResponseBean);
        return null;
    }

    public void A(String[] strArr) {
        HashMap map = new HashMap();
        map.put("emails", strArr);
        this.a = this.e.l(false, map, this);
    }

    public void B(String str) {
        this.i = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        p(str);
    }

    public void C() {
        new HashMap();
        String strI = nd3.i(eg3.h(WearUtils.x, "gen_token_Key", ""));
        String strI2 = nd3.i(WearUtils.t);
        eg3.i(MyApplication.N(), "check_app_version", ye3.s());
        if (!WearUtils.e1(strI) && !WearUtils.e1(strI2)) {
            this.a = this.e.o(this);
        } else {
            eg3.m(MyApplication.N(), "xmpp_password");
            ch3.n().e();
        }
    }

    public void D() {
        this.e.p(this);
    }

    @Override // dc.tl2, dc.wn2
    public void a(boolean z, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (obj instanceof LoginUserBean) {
            LoginUserBean loginUserBean = (LoginUserBean) obj;
            if (g()) {
                ((ep2) this.b.get()).Q3(z, loginUserBean, this.c, this.d);
            }
        }
        if (obj instanceof UserInfoBean) {
            UserInfoBean userInfoBean = (UserInfoBean) obj;
            if (g()) {
                ((ep2) this.b.get()).y2(z, userInfoBean);
            }
        }
        if (obj instanceof BaseResponseBean) {
            BaseResponseBean baseResponseBean = (BaseResponseBean) obj;
            if (g()) {
                ((ep2) this.b.get()).L0(z, baseResponseBean);
            }
        }
        if (obj instanceof PrivacyPolicyStatusBean) {
            PrivacyPolicyStatusBean privacyPolicyStatusBean = (PrivacyPolicyStatusBean) obj;
            if (g()) {
                ((ep2) this.b.get()).Z0(z, privacyPolicyStatusBean);
            }
        }
        if (obj instanceof NtokenResponseBean) {
            NtokenResponseBean ntokenResponseBean = (NtokenResponseBean) obj;
            if (g()) {
                ((ep2) this.b.get()).U(z, ntokenResponseBean);
            }
        }
        if (obj instanceof GenTokenBean) {
            GenTokenBean genTokenBean = (GenTokenBean) obj;
            ye3.K(2);
            eg3.i(MyApplication.N(), "gen_token_Key", nd3.u(genTokenBean.getData().getGtoken()));
            eg3.i(MyApplication.N(), "r_token_Key", nd3.u(genTokenBean.getData().getRtoken()));
            WearUtils.s = nd3.u(genTokenBean.getData().getGtoken());
            WearUtils.t = nd3.u(genTokenBean.getData().getRtoken());
            WearUtils.w2(genTokenBean.getData().getX(), genTokenBean.getData().getY());
        }
        if (obj instanceof RemoteVibemateEventConfigBean) {
            RemoteVibemateEventConfigBean remoteVibemateEventConfigBean = (RemoteVibemateEventConfigBean) WearUtils.A.fromJson(eg3.h(MyApplication.N(), "remote_vibemate_event_config_bean", ""), RemoteVibemateEventConfigBean.class);
            if (remoteVibemateEventConfigBean != null && remoteVibemateEventConfigBean.isResult()) {
                ((RemoteVibemateEventConfigBean) obj).setResult(true);
            }
            if (obj != null) {
                eg3.i(MyApplication.N(), "remote_vibemate_event_config_bean", WearUtils.A.toJson(obj));
                eg3.l(MyApplication.N(), "limit_the_duration", System.currentTimeMillis());
            }
        }
        if (obj instanceof AccountConfigBean) {
            AccountConfigBean accountConfigBean = (AccountConfigBean) obj;
            if (g()) {
                ((ep2) this.b.get()).N(accountConfigBean);
            }
        }
        if ((obj instanceof VibemateBetrayOneselfBean) && ((VibemateBetrayOneselfBean) obj).getData() != null) {
            eg3.i(MyApplication.N(), "vibemate_betray_oneself", WearUtils.A.toJson(obj));
        }
        if (obj instanceof AvatarReportStatusBean) {
            AvatarReportStatusBean avatarReportStatusBean = (AvatarReportStatusBean) obj;
            eg3.i(MyApplication.N(), "avatar_report_status", new Gson().toJson(avatarReportStatusBean));
            String str = "isRestrict=====" + avatarReportStatusBean.isRestrict();
        }
        if (obj instanceof PolicyListBean) {
            String json = new Gson().toJson((PolicyListBean) obj);
            eg3.i(MyApplication.N(), "new_argement_list", json);
            String str2 = "保存协议成功" + json;
        }
        if (obj instanceof QueryRemoteAccountInfoBean) {
            QueryRemoteAccountInfoBean queryRemoteAccountInfoBean = (QueryRemoteAccountInfoBean) obj;
            if (g()) {
                ((ep2) this.b.get()).h(z, queryRemoteAccountInfoBean);
            }
        }
        if ((obj instanceof ColdReportBean) && g()) {
            ((ep2) this.b.get()).O0();
        }
    }

    @Override // dc.tl2, dc.wn2
    public void b(String str, boolean z) {
        super.b(str, z);
        if ("upgradeGtoken".equals(str)) {
            eg3.m(MyApplication.N(), "xmpp_password");
            ch3.n().e();
        }
    }

    @Override // dc.tl2, dc.wn2
    public void d(NetException netException, boolean z) {
        if (g()) {
            ((ep2) this.b.get()).f(z, netException.getMessage(), netException.getCode());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h(java.lang.String r7, boolean r8, java.lang.String r9) {
        /*
            r6 = this;
            com.wear.widget.dialog.VerifyDialog.h = r8
            r0 = 0
            r6.f = r0
            boolean r1 = com.wear.util.WearUtils.e1(r7)
            java.lang.String r2 = "1"
            r3 = 1
            if (r1 != 0) goto L16
            boolean r1 = r7.startsWith(r2)
            if (r1 == 0) goto L16
            r6.f = r3
        L16:
            r6.g = r0
            boolean r1 = com.wear.util.WearUtils.e1(r7)
            if (r1 != 0) goto L35
            int r1 = r7.length()
            r4 = 2
            if (r1 < r4) goto L35
            char r7 = r7.charAt(r3)
            java.lang.Character r7 = java.lang.Character.valueOf(r7)
            boolean r7 = r2.equals(r7)
            if (r7 == 0) goto L35
            r6.g = r3
        L35:
            r6.h = r8
            boolean r7 = r6.f
            if (r7 == 0) goto L6a
            boolean r7 = com.wear.util.WearUtils.e1(r9)
            if (r7 != 0) goto L6a
            com.wear.dao.TestValueDao r7 = com.wear.dao.DaoUtils.getTestValueDao()
            java.lang.String r8 = "show_weak_psw_dialog_type"
            java.lang.String r7 = r7.getValue(r9, r8)
            boolean r8 = com.wear.util.WearUtils.e1(r7)
            if (r8 != 0) goto L6a
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Exception -> L66
            long r7 = r7.longValue()     // Catch: java.lang.Exception -> L66
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L66
            long r1 = r1 - r7
            long r7 = dc.um2.j     // Catch: java.lang.Exception -> L66
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 >= 0) goto L6a
            r7 = 0
            goto L6b
        L66:
            r7 = move-exception
            r7.printStackTrace()
        L6a:
            r7 = 1
        L6b:
            boolean r8 = r6.g
            if (r8 == 0) goto L9d
            boolean r8 = com.wear.util.WearUtils.e1(r9)
            if (r8 != 0) goto L9d
            com.wear.dao.TestValueDao r8 = com.wear.dao.DaoUtils.getTestValueDao()
            java.lang.String r1 = "show_common_psw_dialog_type"
            java.lang.String r8 = r8.getValue(r9, r1)
            boolean r1 = com.wear.util.WearUtils.e1(r8)
            if (r1 != 0) goto L9d
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Exception -> L99
            long r1 = r8.longValue()     // Catch: java.lang.Exception -> L99
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L99
            long r4 = r4 - r1
            long r1 = dc.um2.j     // Catch: java.lang.Exception -> L99
            int r8 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r8 >= 0) goto L9d
            goto L9e
        L99:
            r8 = move-exception
            r8.printStackTrace()
        L9d:
            r0 = 1
        L9e:
            boolean r8 = r6.f
            if (r8 != 0) goto La6
            boolean r8 = r6.g
            if (r8 == 0) goto Lb8
        La6:
            if (r7 == 0) goto Lb8
            if (r0 == 0) goto Lb8
            java.lang.ref.WeakReference<V extends dc.ul2> r7 = r6.b
            java.lang.Object r7 = r7.get()
            dc.ep2 r7 = (dc.ep2) r7
            boolean r8 = r6.h
            r8 = r8 ^ r3
            r7.k1(r8, r9)
        Lb8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.um2.h(java.lang.String, boolean, java.lang.String):void");
    }

    public void i() {
        this.e.c(this);
    }

    public void j(boolean z) {
        NtokenRequestBean ntokenRequestBean = new NtokenRequestBean();
        String strC = zd3.c("userName");
        ntokenRequestBean.uid = nd3.w(strC);
        String str = "getNtoken: " + strC + " uid: " + ntokenRequestBean.uid;
        this.a = this.e.k(z, ntokenRequestBean, this);
    }

    public void k() {
        this.e.d(this);
    }

    public void l() {
        this.e.m(this);
    }

    public void m(boolean z) {
        this.e.n(this, z);
    }

    public void n() {
        this.e.q(this);
    }

    public void o() {
        OpenAppBean openAppBean = MyApplication.U;
        if (openAppBean == null || openAppBean.type != 10) {
            this.e.f(new Function1() { // from class: dc.qm2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return this.a.u((String) obj);
                }
            });
        }
    }

    public final void p(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.e.g(str, new Function1() { // from class: dc.pm2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.a.w(str, (InviteRequestInfo) obj);
            }
        });
    }

    public void q() {
        OpenAppBean openAppBean = MyApplication.U;
        if (openAppBean == null || openAppBean.type != 10) {
            p(this.i);
        }
    }

    public void r(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.e.h(str, new Function1() { // from class: dc.rm2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.a.y((BaseResponseBean) obj);
            }
        });
    }

    public boolean s() {
        return this.f || this.g;
    }

    public void z(boolean z, String str, String str2) {
        this.c = str;
        this.d = str2;
        ye3.m();
        ye3.f("A0010");
        HashMap map = new HashMap();
        ye3.c0(4, true);
        this.a = this.e.j(z, map, this);
    }
}
