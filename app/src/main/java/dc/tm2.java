package dc;

import android.os.Build;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.component.dxutilcode.lib.utils.ToastUtils;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.lovense.wear.R;
import com.wear.bean.AvatarReportStatusBean;
import com.wear.bean.ColdReportBean;
import com.wear.bean.InviteRequestCode;
import com.wear.bean.InviteRequestInfo;
import com.wear.bean.PolicyListBean;
import com.wear.bean.data.ChatGPTConfigBean;
import com.wear.bean.data.ChatGPTConfigData;
import com.wear.bean.event.ReadProfileRedDotEvent;
import com.wear.bean.request.ChatGPTConfigRequest;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.bean.response.NtokenResponseBean;
import com.wear.network.presenter.bean.AccountConfigBean;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.presenter.bean.GenTokenBean;
import com.wear.network.presenter.bean.LoginUserBean;
import com.wear.network.presenter.bean.QueryRemoteAccountInfoBean;
import com.wear.network.presenter.bean.RemoteVibemateEventConfigBean;
import com.wear.network.presenter.bean.VibemateBetrayOneselfBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smack.roster.packet.RosterVer;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import rx.Subscription;

/* compiled from: MainInterceptorImpl.java */
/* loaded from: classes3.dex */
public class tm2 {

    /* compiled from: MainInterceptorImpl.java */
    public class a implements yn2<AccountConfigBean> {
        public final /* synthetic */ wn2 a;

        public a(tm2 tm2Var, wn2 wn2Var) {
            this.a = wn2Var;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(AccountConfigBean accountConfigBean) {
            if (accountConfigBean == null || !accountConfigBean.isResult()) {
                this.a.b(String.valueOf(accountConfigBean), false);
            } else {
                this.a.a(false, accountConfigBean);
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: MainInterceptorImpl.java */
    public class b implements yn2<PolicyListBean> {
        public final /* synthetic */ wn2 a;

        public b(tm2 tm2Var, wn2 wn2Var) {
            this.a = wn2Var;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(PolicyListBean policyListBean) {
            if (policyListBean != null) {
                this.a.a(false, policyListBean);
            } else {
                this.a.b("getPolicyList", false);
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            this.a.b("getPolicyList", false);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: MainInterceptorImpl.java */
    public class c implements yn2<VibemateBetrayOneselfBean> {
        public final /* synthetic */ wn2 a;

        public c(tm2 tm2Var, wn2 wn2Var) {
            this.a = wn2Var;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(VibemateBetrayOneselfBean vibemateBetrayOneselfBean) {
            if (vibemateBetrayOneselfBean != null) {
                this.a.a(false, vibemateBetrayOneselfBean);
            } else {
                this.a.b("remoteVibemateEventConfig", false);
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            this.a.b("vibemate_betray_oneself", false);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: MainInterceptorImpl.java */
    public class d implements yn2<String> {
        public final /* synthetic */ wn2 a;

        /* compiled from: MainInterceptorImpl.java */
        public class a extends TypeReference<BaseResponseBeanNew<AvatarReportStatusBean>> {
            public a(d dVar) {
            }
        }

        public d(tm2 tm2Var, wn2 wn2Var) {
            this.a = wn2Var;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) JSON.parseObject(str, new a(this), new Feature[0]);
            if (baseResponseBeanNew.result) {
                this.a.a(false, baseResponseBeanNew.data);
            } else {
                this.a.b("AVATAR_REPORT_STATUS", false);
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            this.a.b("avatar_report_status", false);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: MainInterceptorImpl.java */
    public class e implements yn2<BaseResponseBeanNew<InviteRequestCode>> {
        public final /* synthetic */ Function1 a;

        public e(tm2 tm2Var, Function1 function1) {
            this.a = function1;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBeanNew<InviteRequestCode> baseResponseBeanNew) {
            InviteRequestCode inviteRequestCode = baseResponseBeanNew.data;
            if (inviteRequestCode == null) {
                return;
            }
            String code = inviteRequestCode.getCode();
            if (TextUtils.isEmpty(code)) {
                return;
            }
            this.a.invoke(code);
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            ToastUtils.y(netException.message);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: MainInterceptorImpl.java */
    public class f implements yn2<BaseResponseBeanNew<InviteRequestInfo>> {
        public final /* synthetic */ Function1 a;

        public f(Function1 function1) {
            this.a = function1;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBeanNew<InviteRequestInfo> baseResponseBeanNew) {
            int i = baseResponseBeanNew.code;
            if (i != 0) {
                tm2.this.e(String.valueOf(i), baseResponseBeanNew.message);
                return;
            }
            InviteRequestInfo inviteRequestInfo = baseResponseBeanNew.data;
            if (inviteRequestInfo == null) {
                return;
            }
            this.a.invoke(inviteRequestInfo);
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            ToastUtils.y(netException.message);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: MainInterceptorImpl.java */
    public class g implements zn2<String> {
        public final /* synthetic */ Function1 a;

        public g(Function1 function1) {
            this.a = function1;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            BaseResponseBean baseResponseBean = (BaseResponseBean) WearUtils.A.fromJson(str, BaseResponseBean.class);
            if (baseResponseBean == null) {
                return;
            }
            if (baseResponseBean.isResult()) {
                this.a.invoke(baseResponseBean);
            } else {
                tm2.this.e(baseResponseBean.getCode(), baseResponseBean.getMessage());
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            ToastUtils.y(netException.message);
        }
    }

    /* compiled from: MainInterceptorImpl.java */
    public class h implements yn2<LoginUserBean> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;

        public h(wn2 wn2Var, boolean z) {
            this.a = wn2Var;
            this.b = z;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(LoginUserBean loginUserBean) {
            ch3.n().U(loginUserBean);
            tm2.this.i();
            this.a.a(this.b, loginUserBean);
            EventBus.getDefault().post(new ReadProfileRedDotEvent());
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            this.a.d(netException, this.b);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: MainInterceptorImpl.java */
    public class i implements zn2<String> {
        public i(tm2 tm2Var) {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            ChatGPTConfigBean chatGPTConfigBean = (ChatGPTConfigBean) ro2.a(str, ChatGPTConfigBean.class);
            if (chatGPTConfigBean == null || !chatGPTConfigBean.getResult()) {
                return;
            }
            ChatGPTConfigData data = chatGPTConfigBean.getData();
            EventBus.getDefault().post(chatGPTConfigBean.getData());
            eg3.j(WearUtils.x, "chatGPTConfig", data.getEnableShow());
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
        }
    }

    /* compiled from: MainInterceptorImpl.java */
    public class j implements yn2<String> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;

        /* compiled from: MainInterceptorImpl.java */
        public class a extends TypeReference<BaseResponseBeanNew<NtokenResponseBean>> {
            public a(j jVar) {
            }
        }

        public j(tm2 tm2Var, wn2 wn2Var, boolean z) {
            this.a = wn2Var;
            this.b = z;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) JSON.parseObject(str, new a(this), new Feature[0]);
            if (baseResponseBeanNew.code == 0) {
                this.a.a(this.b, baseResponseBeanNew.data);
            } else {
                this.a.b(String.valueOf(baseResponseBeanNew.result), this.b);
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            this.a.b(netException.getMessage(), this.b);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: MainInterceptorImpl.java */
    public class k implements yn2<String> {
        public final /* synthetic */ wn2 a;

        public k(tm2 tm2Var, wn2 wn2Var) {
            this.a = wn2Var;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            if (WearUtils.e1(str)) {
                this.a.b("upgradeGtoken", false);
                return;
            }
            GenTokenBean genTokenBean = (GenTokenBean) WearUtils.A.fromJson(str, GenTokenBean.class);
            if (genTokenBean != null) {
                this.a.a(false, genTokenBean);
            } else {
                this.a.b("upgradeGtoken", false);
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            this.a.b("upgradeGtoken", false);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: MainInterceptorImpl.java */
    public class l implements yn2<RemoteVibemateEventConfigBean> {
        public final /* synthetic */ wn2 a;

        public l(tm2 tm2Var, wn2 wn2Var) {
            this.a = wn2Var;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(RemoteVibemateEventConfigBean remoteVibemateEventConfigBean) {
            if (remoteVibemateEventConfigBean != null) {
                this.a.a(false, remoteVibemateEventConfigBean);
            } else {
                this.a.b("remoteVibemateEventConfig", false);
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            this.a.b("remoteVibemateEventConfig", false);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: MainInterceptorImpl.java */
    public class m implements zn2<String> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;

        public m(tm2 tm2Var, wn2 wn2Var, boolean z) {
            this.a = wn2Var;
            this.b = z;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            this.a.a(this.b, (QueryRemoteAccountInfoBean) WearUtils.A.fromJson(str, QueryRemoteAccountInfoBean.class));
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            this.a.d(netException, this.b);
        }
    }

    /* compiled from: MainInterceptorImpl.java */
    public class n implements yn2<ColdReportBean> {
        public final /* synthetic */ wn2 a;

        public n(tm2 tm2Var, wn2 wn2Var) {
            this.a = wn2Var;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(ColdReportBean coldReportBean) {
            if (coldReportBean == null || !coldReportBean.isResult()) {
                this.a.b(String.valueOf(coldReportBean), false);
            } else {
                this.a.a(false, coldReportBean);
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public Subscription c(wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).l("/remote/report-user/avatarReportStatus", new HashMap(), new d(this, wn2Var));
    }

    public Subscription d(wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).g("/api/remote/policy/list", new HashMap(), new b(this, wn2Var));
    }

    public final void e(String str, String str2) {
        if (Objects.equals(str, "50072")) {
            ku1.f("Invite Link", "add_people_invite_link_send_request_fail", "add_people_invite_link_send_request", 2, null, null);
            ToastUtils.y(str2);
        } else if (Objects.equals(str, "5")) {
            ToastUtils.y(ah4.e(R.string.invite_reminder_expired));
        } else {
            if (Objects.equals(str, "4")) {
                return;
            }
            ku1.f("Invite Link", "add_people_invite_link_send_request_fail", "add_people_invite_link_send_request", 3, null, null);
            ToastUtils.y(str2);
        }
    }

    public void f(Function1<String, Unit> function1) {
        tn2.x(WearUtils.x).d("/invite_link/query_invite_code", new e(this, function1));
    }

    public void g(String str, Function1<InviteRequestInfo, Unit> function1) {
        HashMap map = new HashMap();
        map.put(XHTMLText.CODE, str);
        tn2.x(WearUtils.x).g("/invite_link/info", map, new f(function1));
    }

    public void h(String str, Function1<BaseResponseBean, Unit> function1) {
        HashMap map = new HashMap();
        map.put(XHTMLText.CODE, str);
        tn2.x(WearUtils.x).m("/invite_link/send_request", WearUtils.A.toJson(map), new g(function1));
    }

    public final void i() {
        tn2.x(WearUtils.x).m("/api/chatgpt_function_config", ro2.c(new ChatGPTConfigRequest(ye3.x(), tz.i())), new i(this));
    }

    public Subscription j(boolean z, Map<String, Object> map, wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).o("/app/checkOutAccountInfo", map, new h(wn2Var, z));
    }

    public Subscription k(boolean z, Object obj, wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).m("/date-web-api/api/remote/getNtoken", WearUtils.A.toJson(obj), new j(this, wn2Var, z));
    }

    public Subscription l(boolean z, Map<String, Object> map, wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).m("/api/queryRemoteAccountInfo", WearUtils.A.toJson(map), new m(this, wn2Var, z));
    }

    public Subscription m(wn2<Object> wn2Var) {
        new HashMap();
        return tn2.x(WearUtils.x).d("/api/remote_account_config", new a(this, wn2Var));
    }

    public Subscription n(wn2<Object> wn2Var, boolean z) {
        HashMap map = new HashMap();
        map.put("sessionId", ye3.x());
        map.put("pf", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        map.put("deviceId", tz.i());
        map.put("needShowEvent", Boolean.valueOf(z));
        return tn2.x(WearUtils.x).g("/remote_vibemate_event_config_v2", map, new l(this, wn2Var));
    }

    public Subscription o(wn2<Object> wn2Var) {
        HashMap map = new HashMap();
        String strI = nd3.i(eg3.h(WearUtils.x, "gen_token_Key", ""));
        String strI2 = nd3.i(WearUtils.t);
        if (strI == null) {
            strI = "";
        }
        map.put("gtoken", strI);
        map.put("rtoken", strI2 != null ? strI2 : "");
        map.put(RosterVer.ELEMENT, WearUtils.q);
        map.put("sessionId", ye3.x());
        map.put("deviceId", tz.i());
        map.put("deviceName", Build.MODEL);
        return tn2.x(WearUtils.x).l("/api/wear/upgradeGtoken", map, new k(this, wn2Var));
    }

    public Subscription p(wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).d("/api/cold_restart_report", new n(this, wn2Var));
    }

    public Subscription q(wn2<Object> wn2Var) {
        HashMap map = new HashMap();
        map.put("sessionId", ye3.x());
        map.put("pf", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        return tn2.x(WearUtils.x).g("/vibemate_betray_oneself", map, new c(this, wn2Var));
    }
}
