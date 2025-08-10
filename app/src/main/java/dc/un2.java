package dc;

import android.text.TextUtils;
import android.view.View;
import com.google.common.net.HttpHeaders;
import com.lovense.wear.R;
import com.wear.main.account.login.LoginActivity;
import com.wear.network.presenter.bean.GTokenRefreshBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.rc4;
import dc.sc4;
import dc.yc4;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.jivesoftware.smack.roster.packet.RosterVer;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import org.json.JSONObject;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/* compiled from: RequestInterceptor.java */
/* loaded from: classes3.dex */
public class un2 implements sc4 {
    public static volatile un2 b;
    public Subscription a;

    /* compiled from: RequestInterceptor.java */
    public class a implements Action1<Long> {
        public final /* synthetic */ String a;

        public a(un2 un2Var, String str) {
            this.a = str;
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Long l) {
            sg3.f(WearUtils.x.getApplicationContext(), this.a);
        }
    }

    public static un2 a() {
        if (b == null) {
            synchronized (un2.class) {
                if (b == null) {
                    b = new un2();
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(String str, String str2, View view) throws RuntimeException {
        f(WearUtils.Z1(R.string.common_serverError), str, 7, str2);
    }

    public final GTokenRefreshBean b() {
        try {
            Retrofit retrofitBuild = new Retrofit.Builder().baseUrl(WearUtils.e).build();
            HashMap map = new HashMap();
            String strI = nd3.i(WearUtils.s);
            String strI2 = nd3.i(WearUtils.t);
            if (strI == null) {
                strI = "";
            }
            map.put("gtoken", strI);
            if (strI2 == null) {
                strI2 = "";
            }
            map.put("rtoken", strI2);
            map.put("pf", wg3.a());
            return (GTokenRefreshBean) WearUtils.A.fromJson(new String(((sn2) retrofitBuild.create(sn2.class)).b("/gfw/gtoken/refresh", kf3.a(WearUtils.x), map).execute().body().bytes()), GTokenRefreshBean.class);
        } catch (Exception e) {
            ye3.d("Z10086", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public final ad4 c(sc4.a aVar, String str) throws IOException, RuntimeException {
        yc4 yc4VarRequest = aVar.request();
        yc4.a aVarH = yc4VarRequest.h();
        String strI = nd3.i(str);
        String str2 = "gToken111=====" + strI;
        aVarH.a("BODY-X-TYPE", "2");
        aVarH.a("BODY-X-VERSION", "1.0");
        if (strI == null) {
            strI = "";
        }
        aVarH.a("gtoken", strI);
        aVarH.a(RosterVer.ELEMENT, WearUtils.q);
        String str3 = WearUtils.H;
        aVarH.a("x", str3 != null ? str3 : "");
        aVarH.b();
        rc4 rc4VarJ = yc4VarRequest.j();
        if (rc4VarJ.toString().contains("/statisticsLog") || rc4VarJ.toString().contains("/wear/logsNewV3")) {
            aVarH.a(HttpHeaders.CONTENT_ENCODING, "gzip");
        }
        rc4 rc4VarS = rc4.s(tn2.w(rc4VarJ.toString()));
        rc4.a aVarQ = rc4VarJ.q();
        aVarQ.w(rc4VarS.G());
        aVarQ.j(rc4VarS.n());
        aVarQ.q(rc4VarS.B());
        aVarH.l(aVarQ.d());
        return aVar.proceed(aVarH.b());
    }

    public final void f(String str, String str2, int i, String str3) throws RuntimeException {
        ye3.I("invalidRToken", str + " # " + str2);
        ye3.d("Z10085", "错误类型==" + i + ",错误码==" + str2 + ",错误信息==" + str + ",url==" + str3);
        if (MyApplication.H() == null) {
            pj3.v(WearUtils.x.getApplicationContext(), LoginActivity.class);
        } else if (!(MyApplication.H() instanceof LoginActivity)) {
            pj3.v(MyApplication.H(), LoginActivity.class);
            MyApplication.H().finish();
        }
        g(str, str2);
    }

    public final void g(String str, String str2) {
        Subscription subscription = this.a;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.a.unsubscribe();
        }
        this.a = Observable.timer(1L, TimeUnit.SECONDS).subscribe(new a(this, str));
    }

    @Override // dc.sc4
    public ad4 intercept(sc4.a aVar) throws IOException, RuntimeException {
        final String string;
        final String strOptString;
        String strI;
        yc4 yc4VarRequest = aVar.request();
        yc4.a aVarH = yc4VarRequest.h();
        String strI2 = nd3.i(WearUtils.s);
        String strA = kf3.a(WearUtils.x);
        String str = "userAgent===" + strA;
        aVarH.a("BODY-X-TYPE", "2");
        aVarH.a("BODY-X-VERSION", "1.0");
        aVarH.a("gtoken", strI2 == null ? "" : strI2);
        aVarH.a(RosterVer.ELEMENT, WearUtils.q);
        String str2 = WearUtils.H;
        if (str2 == null) {
            str2 = "";
        }
        aVarH.a("x", str2);
        aVarH.a("User-Agent", strA);
        aVarH.a(HttpHeaders.CONNECTION, Close.ELEMENT);
        aVarH.b();
        rc4 rc4VarJ = yc4VarRequest.j();
        if (rc4VarJ.toString().contains("/statisticsLog") || rc4VarJ.toString().contains("/wear/logsNewV3")) {
            aVarH.a(HttpHeaders.CONTENT_ENCODING, "gzip");
        }
        if (rc4VarJ.toString().contains("api/user/third_login") && !WearUtils.e1(eg3.h(WearUtils.x, "binding_token", ""))) {
            aVarH.a("bindingToken", eg3.h(WearUtils.x, "binding_token", ""));
            eg3.i(WearUtils.x, "binding_token", "");
        }
        rc4 rc4VarS = rc4.s(tn2.w(rc4VarJ.toString()));
        rc4.a aVarQ = rc4VarJ.q();
        aVarQ.w(rc4VarS.G());
        aVarQ.j(rc4VarS.n());
        aVarQ.q(rc4VarS.B());
        rc4 rc4VarD = aVarQ.d();
        aVarH.l(rc4VarD);
        yc4 yc4VarB = aVarH.b();
        String str3 = "HEADER====" + rc4VarD + "   HEADER=====" + yc4VarB.e();
        ad4 ad4VarProceed = aVar.proceed(yc4VarB);
        synchronized (a()) {
            try {
                try {
                    string = ad4VarProceed.L().j().toString();
                    pd4 pd4VarSource = ad4VarProceed.b().source();
                    pd4VarSource.request(Long.MAX_VALUE);
                    JSONObject jSONObject = new JSONObject(new String(pd4VarSource.a().clone().Q(Charset.forName("UTF-8"))));
                    strOptString = jSONObject.optString(XHTMLText.CODE);
                    jSONObject.optString("message");
                    strI = nd3.i(WearUtils.s);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (strI2 != null && strI != null && !strI2.equals(strI)) {
                    return c(aVar, WearUtils.s);
                }
                if (strOptString.equals("5003") && strI == null) {
                    return null;
                }
                if (strOptString.equals("5003") && !WearUtils.e1(strI)) {
                    ye3.d("Z10089", "旧的Token过期,gtoken=" + WearUtils.s + ",rtoken=" + WearUtils.t + ",url=" + string);
                    GTokenRefreshBean gTokenRefreshBeanB = b();
                    if (gTokenRefreshBeanB == null) {
                        ye3.d("Z10089", "刷新token失败,url=" + string);
                        f(WearUtils.a2(), NetException.TOKEN_REFLASH_ERROR, 2, string);
                        return null;
                    }
                    if (!gTokenRefreshBeanB.isResult() || gTokenRefreshBeanB.getData() == null) {
                        ye3.d("Z10089", "拿到新的Token失败");
                        String message = gTokenRefreshBeanB.getMessage();
                        if (gTokenRefreshBeanB.getCode().equals("5004")) {
                            message = WearUtils.Z1(R.string.refresh_token_expired);
                        }
                        ye3.d("Z10086", "错误码==" + gTokenRefreshBeanB.getCode());
                        f(message, gTokenRefreshBeanB.getCode(), 1, string);
                        return null;
                    }
                    ye3.d("Z10089", "拿到新的Token,gtoken=" + gTokenRefreshBeanB.getData().getGtoken_new() + ",rtoken=" + gTokenRefreshBeanB.getData().getRtoken_new() + ",url=" + string);
                    eg3.i(WearUtils.x, "gen_token_Key", nd3.u(gTokenRefreshBeanB.getData().getGtoken_new()));
                    eg3.i(WearUtils.x, "r_token_Key", nd3.u(gTokenRefreshBeanB.getData().getRtoken_new()));
                    WearUtils.s = nd3.u(gTokenRefreshBeanB.getData().getGtoken_new());
                    WearUtils.t = nd3.u(gTokenRefreshBeanB.getData().getRtoken_new());
                    String str4 = WearUtils.s;
                    ye3.d("Z10088", "刷新token成功,gtoken=" + WearUtils.s + ",rtoken=" + WearUtils.t + ",url=" + string);
                    ad4VarProceed = c(aVar, str4);
                }
                if (strOptString.equals("5004")) {
                    f(WearUtils.Z1(R.string.refresh_token_expired), strOptString, 3, string);
                }
                if (!strOptString.equals("5002") && !strOptString.equals("5005") && !strOptString.equals("5006") && (string.contains("/api/wear/genGtoken") || !strOptString.equals("5007"))) {
                    if (strOptString.equals("50401") || strOptString.equals("50402") || strOptString.equals("50406") || strOptString.equals("50408") || strOptString.equals("50500") || strOptString.equals("50501") || strOptString.equals("50504")) {
                        f(WearUtils.Z1(R.string.common_serverError), strOptString, 5, string);
                    }
                    if (strOptString.equals("500409")) {
                        f(WearUtils.Z1(R.string.system_account_single), strOptString, 6, string);
                    }
                    if (strOptString.equals("10022")) {
                        vc2.b(MyApplication.K, new View.OnClickListener() { // from class: dc.qn2
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) throws RuntimeException {
                                this.a.e(strOptString, string, view);
                            }
                        });
                    }
                    return ad4VarProceed;
                }
                ye3.d("Z10087", "错误码==" + strOptString + "token==" + strI2);
                if (!TextUtils.isEmpty(strI2)) {
                    f(WearUtils.Z1(R.string.common_serverError), strOptString, 4, string);
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
