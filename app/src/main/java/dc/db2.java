package dc;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.wear.activity.discord.DiscordControl;
import com.wear.activity.orgySetting.OrgySetting;
import com.wear.bean.ControlByUid;
import com.wear.bean.ControlSession;
import com.wear.bean.SyncWsProtocol;
import com.wear.bean.Toy;
import com.wear.main.account.FrequentActivity;
import com.wear.main.account.HelpActivity;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.longDistance.controllink.ControlLinkActivity;
import com.wear.main.toy.ToyDepthControlActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import com.wear.widget.dialog.ControlLinkBanDialog;
import dc.is3;
import dc.kn3;
import dc.qk2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.bouncycastle.i18n.MessageBundle;
import org.greenrobot.eventbus.EventBus;

/* compiled from: ControlInstance.java */
/* loaded from: classes3.dex */
public class db2 implements tz1 {
    public static boolean F = false;
    public static boolean G = false;
    public static db2 K;
    public String A;
    public boolean C;
    public ProgressDialog D;
    public qk2 b;
    public String e;
    public String f;
    public String g;
    public String h;
    public ControlLinkActivity k;
    public LinearLayout m;
    public Timer n;
    public String r;
    public boolean s;
    public int t;
    public String u;
    public final Object a = new Object();
    public String c = "";
    public String d = "";
    public boolean i = false;
    public HashMap<String, String> j = new HashMap<>();
    public boolean l = true;
    public Timer o = null;
    public Map<String, View> p = new HashMap();
    public Map<String, View> q = new HashMap();
    public boolean v = false;
    public String w = "";
    public String x = "";
    public boolean y = true;
    public boolean z = false;
    public boolean B = true;
    public qk2.h E = new a();

    /* compiled from: ControlInstance.java */
    public class a implements qk2.h {

        /* compiled from: ControlInstance.java */
        /* renamed from: dc.db2$a$a, reason: collision with other inner class name */
        public class C0168a implements zn2<String> {

            /* compiled from: ControlInstance.java */
            /* renamed from: dc.db2$a$a$a, reason: collision with other inner class name */
            public class RunnableC0169a implements Runnable {

                /* compiled from: ControlInstance.java */
                /* renamed from: dc.db2$a$a$a$a, reason: collision with other inner class name */
                public class C0170a implements ControlLinkBanDialog.c {
                    public C0170a() {
                    }

                    @Override // com.wear.widget.dialog.ControlLinkBanDialog.c
                    public void a() {
                        pj3.f(db2.this.k, HelpActivity.class);
                    }

                    @Override // com.wear.widget.dialog.ControlLinkBanDialog.c
                    public void b() {
                        Bundle bundle = new Bundle();
                        bundle.putString(MessageBundle.TITLE_ENTRY, ah4.e(R.string.terms_and_conditions));
                        bundle.putString(ImagesContract.URL, "/app/terms-conditions?app=wearables&lang=" + lg3.b(db2.this.k));
                        pj3.g(db2.this.k, FrequentActivity.class, bundle);
                    }
                }

                public RunnableC0169a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    ControlLinkBanDialog controlLinkBanDialog = (ControlLinkBanDialog) cs3.i(new is3.b(db2.this.k), ControlLinkBanDialog.class);
                    controlLinkBanDialog.show();
                    controlLinkBanDialog.setListener(new C0170a());
                }
            }

            public C0168a() {
            }

            @Override // dc.zn2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onSuccess(String str) {
                if (db2.this.D != null) {
                    db2.this.D.dismiss();
                }
                try {
                    db2.this.w = db2.this.t + "#" + db2.this.x;
                    ControlSession controlSession = (ControlSession) new Gson().fromJson(str, ControlSession.class);
                    if (controlSession != null && controlSession.isResult() && controlSession.getData() != null) {
                        db2 db2Var = db2.this;
                        db2Var.z = true;
                        db2Var.O(false);
                        db2.this.J();
                        return;
                    }
                    if (controlSession.getCode().equals("50090")) {
                        ControlLinkActivity controlLinkActivity = db2.this.k;
                        if (controlLinkActivity != null) {
                            controlLinkActivity.runOnUiThread(new RunnableC0169a());
                        }
                    } else {
                        if (controlSession.getCode().equals("502")) {
                            db2.A().b.j(false);
                        }
                        db2.this.a(controlSession == null ? ah4.e(R.string.common_internet_error) : controlSession.getMessage());
                    }
                    ye3.d("F0002", "");
                } catch (Exception unused) {
                    db2.this.a(ah4.e(R.string.common_internet_error));
                    ye3.d("F0002", "");
                }
            }

            @Override // dc.zn2
            public void onError(NetException netException) {
                if (db2.this.D != null) {
                    db2.this.D.dismiss();
                }
                if (netException.getCode().equals("50043")) {
                    qk2 qk2Var = db2.this.b;
                    if (qk2Var != null) {
                        qk2Var.y();
                    }
                    db2.A().b.j(false);
                }
                db2.this.a(netException.getMessage());
                ye3.d("F0002", "");
            }
        }

        /* compiled from: ControlInstance.java */
        public class b implements kn3.d {
            public b(a aVar) {
            }

            @Override // dc.kn3.d
            public void doCancel() {
            }

            @Override // dc.kn3.d
            public void doConfirm() {
            }
        }

        public a() {
        }

        @Override // dc.qk2.h
        public void a() {
            db2 db2Var = db2.this;
            if (db2Var.v) {
                db2Var.v = false;
                try {
                    if (db2Var.D != null) {
                        db2.this.D.dismiss();
                    }
                    if (db2.this.k != null) {
                        kn3 kn3Var = new kn3((Context) db2.this.k, ah4.e(R.string.common_settingTip), ah4.e(R.string.common_ok), false, true, (kn3.d) new b(this));
                        kn3Var.n();
                        kn3Var.show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // dc.qk2.h
        public void b() {
            if (!db2.this.v || WearUtils.y.u() == null) {
                return;
            }
            db2.this.v = false;
            HashMap map = new HashMap();
            map.put("uid", db2.A().c);
            map.put("from", "remote");
            map.put("tid", db2.this.r);
            map.put("allow2way", Boolean.valueOf(db2.this.s));
            map.put("expires", Integer.valueOf(db2.this.t));
            map.put("toyType", db2.this.u);
            tn2.x(WearUtils.x).l("/app/ws/v2/createSession", map, new C0168a());
        }
    }

    /* compiled from: ControlInstance.java */
    public class b implements Runnable {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            db2.A().b.i(this.a, db2.this.E);
        }
    }

    /* compiled from: ControlInstance.java */
    public class c implements Runnable {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;

        public c(db2 db2Var, Activity activity, String str) {
            this.a = activity;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            sg3.k(this.a, this.b);
        }
    }

    /* compiled from: ControlInstance.java */
    public class d extends TimerTask {

        /* compiled from: ControlInstance.java */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (db2.this.i) {
                    db2.A().b.t(new SyncWsProtocol(SyncWsProtocol.CONTROL_TIME_LEFT_TYPE_KEY));
                }
            }
        }

        public d() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (db2.A().b.l()) {
                vg3.b().a(new a());
            }
        }
    }

    /* compiled from: ControlInstance.java */
    public class e implements Runnable {
        public final /* synthetic */ String a;

        public e(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = db2.this.p.get(this.a);
            if (view == null) {
                db2.this.q.clear();
                return;
            }
            TextView textView = (TextView) view.findViewById(R.id.url_copy);
            TextView textView2 = (TextView) view.findViewById(R.id.tv_control_state);
            TextView textView3 = (TextView) view.findViewById(R.id.tv_controling_times);
            textView.setVisibility(8);
            textView2.setText(ah4.e(R.string.link_generate_control_notice));
            textView3.setText(WearUtils.Q(Integer.valueOf(textView3.getTag().toString()).intValue()));
            textView3.setVisibility(0);
        }
    }

    /* compiled from: ControlInstance.java */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            db2.this.J();
        }
    }

    /* compiled from: ControlInstance.java */
    public class g implements kn3.d {
        public final /* synthetic */ String a;

        public g(String str) {
            this.a = str;
        }

        @Override // dc.kn3.d
        public void doCancel() {
            db2.this.x(this.a, true, false);
        }

        @Override // dc.kn3.d
        public void doConfirm() {
        }
    }

    /* compiled from: ControlInstance.java */
    public class h implements zn2<String> {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;

        /* compiled from: ControlInstance.java */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LinearLayout linearLayout;
                h hVar = h.this;
                View view = db2.this.p.get(hVar.a);
                if (view != null && (linearLayout = db2.this.m) != null) {
                    linearLayout.removeView(view);
                    db2.this.m.invalidate();
                }
                h hVar2 = h.this;
                db2.this.p.remove(hVar2.a);
                h hVar3 = h.this;
                db2.this.q.remove(hVar3.a);
                db2.this.s();
            }
        }

        public h(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            String strE;
            try {
                db2.A().g = null;
                db2.A();
                db2.F = false;
                db2.A().l = false;
                eg3.m(WearUtils.x, "choose_control_toy_id");
                NormalResponse normalResponse = (NormalResponse) new Gson().fromJson(str, NormalResponse.class);
                if (normalResponse == null || !normalResponse.isResult()) {
                    db2 db2Var = db2.this;
                    if (normalResponse == null) {
                        strE = ah4.e(R.string.common_internet_error);
                    } else {
                        strE = normalResponse.getMessage() + " [" + normalResponse.getCode() + "]";
                    }
                    db2Var.a(strE);
                    return;
                }
                db2.this.r();
                MyApplication myApplication = WearUtils.x;
                FragmentActivity fragmentActivityH = MyApplication.H();
                if (fragmentActivityH != null) {
                    fragmentActivityH.runOnUiThread(new a());
                }
                ob2.o().H(2);
                sz1.d().s(db2.A());
                WearUtils.x.G().u0();
                if (this.b) {
                    db2.A().J();
                }
            } catch (Exception unused) {
                db2.this.a(ah4.e(R.string.common_internet_error));
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            db2.this.a(netException.getMessage());
        }
    }

    /* compiled from: ControlInstance.java */
    public class i implements Runnable {
        public final /* synthetic */ SyncWsProtocol a;

        public i(SyncWsProtocol syncWsProtocol) {
            this.a = syncWsProtocol;
        }

        @Override // java.lang.Runnable
        public void run() {
            SyncWsProtocol.DataBean data = this.a.getData();
            View view = db2.this.p.get(this.a.getSid());
            if (view != null) {
                String string = (data == null || data.getTimeLeft() == null) ? "" : data.getTimeLeft().toString();
                if (!WearUtils.e1(string)) {
                    string = string.replace(".0", "");
                }
                if (WearUtils.e1(string)) {
                    string = "0";
                }
                if (WearUtils.e1(data.getStatus())) {
                    data.setStatus(SyncWsProtocol.DataBean.CONTROL_STATUS_CONTROLLING_TYPE_KEY);
                }
                int iIntValue = (!WearUtils.q1(string) || Integer.valueOf(string).intValue() < 0) ? 0 : Integer.valueOf(string).intValue();
                if (this.a.getType().equals(SyncWsProtocol.CONTROL_BEGIN_TYPE_KEY)) {
                    ye3.d("F0005", "");
                    db2.this.k.z4();
                    db2.this.U(this.a.getSid(), view, iIntValue, data.getStatus(), this.a.getType().equals(SyncWsProtocol.CONTROL_BEGIN_TYPE_KEY));
                } else if (this.a.getType().equals(SyncWsProtocol.CONTROL_TIME_LEFT_TYPE_KEY) && iIntValue > 0) {
                    db2.this.V(this.a.getSid(), view, iIntValue);
                }
                if (this.a.getType().equals(SyncWsProtocol.CONTROL_TIME_LEFT_TYPE_KEY) && data.getTimeLeft() == null) {
                    db2.this.T();
                }
            }
        }
    }

    /* compiled from: ControlInstance.java */
    public class j implements kn3.d {
        public final /* synthetic */ s a;

        public j(s sVar) {
            this.a = sVar;
        }

        @Override // dc.kn3.d
        public void doCancel() {
            HashMap<String, String> map = db2.this.j;
            if (map != null && map.size() > 0) {
                try {
                    synchronized (db2.this.j) {
                        Iterator<String> it = db2.this.j.keySet().iterator();
                        while (it.hasNext()) {
                            db2.this.x(it.next(), false, false);
                        }
                        db2.this.j.clear();
                    }
                } catch (Exception unused) {
                }
            }
            s sVar = this.a;
            if (sVar != null) {
                sVar.a();
            }
        }

        @Override // dc.kn3.d
        public void doConfirm() {
        }
    }

    /* compiled from: ControlInstance.java */
    public class k extends TimerTask {
        public k() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (WearUtils.e1(db2.this.c) || WearUtils.y.u() == null) {
                return;
            }
            if (!WearUtils.h1(dq2.w().v()) || db2.this.D() || db2.this.B) {
                db2.this.P();
            }
        }
    }

    /* compiled from: ControlInstance.java */
    public class l extends TimerTask {

        /* compiled from: ControlInstance.java */
        public class a implements Runnable {
            public final /* synthetic */ Map.Entry a;

            public a(Map.Entry entry) {
                this.a = entry;
            }

            @Override // java.lang.Runnable
            public void run() {
                db2 db2Var = db2.this;
                if (db2Var.i) {
                    db2Var.U((String) this.a.getKey(), (View) this.a.getValue(), -1, SyncWsProtocol.DataBean.CONTROL_STATUS_CONTROLLING_TYPE_KEY, false);
                }
            }
        }

        public l() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            LinearLayout linearLayout;
            db2 db2Var = db2.this;
            if (db2Var.k == null || (linearLayout = db2Var.m) == null || linearLayout.getChildCount() <= 0) {
                return;
            }
            for (Map.Entry<String, View> entry : db2.this.q.entrySet()) {
                if (db2.this.m.getChildCount() <= 0) {
                    return;
                } else {
                    db2.this.k.runOnUiThread(new a(entry));
                }
            }
        }
    }

    /* compiled from: ControlInstance.java */
    public class m implements zn2<String> {
        public m() {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            if (WearUtils.e1(str)) {
                db2.this.B = true;
                return;
            }
            try {
                NormalResponse normalResponse = (NormalResponse) new Gson().fromJson(str, NormalResponse.class);
                if (normalResponse != null && normalResponse.isResult()) {
                    normalResponse.getData();
                }
                db2.this.B = false;
            } catch (Exception unused) {
                db2.this.B = true;
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            db2.this.B = true;
        }
    }

    /* compiled from: ControlInstance.java */
    public class n implements View.OnClickListener {
        public final /* synthetic */ String a;

        public n(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            db2.this.y(this.a);
        }
    }

    /* compiled from: ControlInstance.java */
    public class o implements View.OnClickListener {
        public final /* synthetic */ String a;

        public o(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            db2.this.y(this.a);
        }
    }

    /* compiled from: ControlInstance.java */
    public class p implements zn2<String> {

        /* compiled from: ControlInstance.java */
        public class a implements Runnable {
            public a(p pVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                db2.G = true;
                sz1.d().n(db2.A());
            }
        }

        public p() {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            Toy toyR;
            synchronized (db2.this.a) {
                try {
                    try {
                    } catch (Exception unused) {
                        db2.A();
                        db2.F = false;
                        db2.A().l = false;
                        db2.this.C = false;
                        db2.this.M();
                    }
                    if (!WearUtils.e1(str) && db2.A() != null) {
                        ControlByUid controlByUid = (ControlByUid) new Gson().fromJson(str, ControlByUid.class);
                        if (controlByUid == null || !controlByUid.isResult() || controlByUid.getData() == null) {
                            db2.A();
                            db2.F = false;
                            db2.A().l = false;
                            db2.this.C = false;
                            db2.this.M();
                            boolean z = db2.this.y;
                            if (controlByUid != null) {
                                controlByUid.getCode().equals("400");
                            }
                        } else {
                            if (controlByUid.getData().size() > 0) {
                                for (ControlByUid.DataBean dataBean : controlByUid.getData()) {
                                    synchronized (db2.this.j) {
                                        db2.this.j.put(dataBean.getId(), dataBean.getId());
                                    }
                                }
                                if (!db2.G) {
                                    ob2.o().H(1);
                                    sz1.d().q(4);
                                    new Handler(Looper.getMainLooper()).post(new a(this));
                                }
                                db2.A();
                                db2.F = controlByUid.getData().get(0).isSync();
                                db2.this.C = controlByUid.getData().get(0).isLoaded();
                                db2.this.M();
                                db2.A().l = true;
                                db2.A().b.j(false);
                            } else {
                                synchronized (db2.this.j) {
                                    db2.this.j.clear();
                                }
                                db2.this.O(false);
                                db2.G = false;
                                db2.this.C = false;
                                db2.this.M();
                            }
                            db2.this.S(controlByUid.getData());
                            if (WearUtils.e1(db2.A().g) && controlByUid.getData().size() > 0 && WearUtils.e1(controlByUid.getData().get(0).getTid()) && (toyR = WearUtils.x.G().R(controlByUid.getData().get(0).getTid())) != null && ((toyR.getType().equals("nora") || toyR.getType().equals("max")) && (toyR.isSelect() || WearUtils.x.G().a(toyR.getAddress())))) {
                                db2.A().g = controlByUid.getData().get(0).getTid();
                                WearUtils.x.G().B();
                                WearUtils.x.G().s0(toyR);
                            }
                        }
                        return;
                    }
                    db2.this.C = false;
                    db2.this.M();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
        }
    }

    /* compiled from: ControlInstance.java */
    public class q implements Runnable {
        public final /* synthetic */ List a;

        /* compiled from: ControlInstance.java */
        public class a implements View.OnClickListener {
            public final /* synthetic */ ControlByUid.DataBean a;

            public a(ControlByUid.DataBean dataBean) {
                this.a = dataBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                db2 db2Var = db2.this;
                db2Var.z = true;
                db2Var.t(this.a.getShortUrl(), true);
            }
        }

        /* compiled from: ControlInstance.java */
        public class b implements View.OnClickListener {
            public final /* synthetic */ ControlByUid.DataBean a;

            public b(ControlByUid.DataBean dataBean) {
                this.a = dataBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                db2.this.y(this.a.getId());
            }
        }

        /* compiled from: ControlInstance.java */
        public class c implements Runnable {
            public final /* synthetic */ ControlByUid.DataBean a;
            public final /* synthetic */ View b;

            public c(ControlByUid.DataBean dataBean, View view) {
                this.a = dataBean;
                this.b = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                db2.this.q.put(this.a.getId(), this.b);
                db2.this.o(this.a.getId());
            }
        }

        public q(List list) {
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            db2 db2Var = db2.this;
            LinearLayout linearLayout = db2Var.m;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
                if (db2.this.m.getChildCount() > 0) {
                    db2.this.p.clear();
                    db2.this.q.clear();
                    db2.this.m.removeAllViews();
                }
            } else {
                db2Var.p.clear();
                db2.this.q.clear();
            }
            List list = this.a;
            ViewGroup viewGroup = null;
            if (list != null && list.size() == 0) {
                db2.A().g = null;
                db2.A();
                db2.F = false;
                eg3.m(WearUtils.x, "choose_control_toy_id");
                WearUtils.x.G().B();
            }
            String strSubstring = "";
            for (ControlByUid.DataBean dataBean : this.a) {
                ControlLinkActivity controlLinkActivity = db2.this.k;
                if (controlLinkActivity == null) {
                    break;
                }
                View viewInflate = controlLinkActivity.getLayoutInflater().inflate(R.layout.control_link_item, viewGroup);
                TextView textView = (TextView) viewInflate.findViewById(R.id.tv_link_times);
                EditText editText = (EditText) viewInflate.findViewById(R.id.tv_control_line_url);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.url_copy);
                TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_control_state);
                TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_controling_times);
                ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_link_infinity);
                if (dataBean.getExpire() % 60 == 0) {
                    textView.setText((dataBean.getExpire() / 60) + "m");
                } else {
                    textView.setText(dataBean.getExpire() + "s");
                }
                imageView.setVisibility(8);
                imageView.setTag(8);
                textView4.setTag("" + dataBean.getLeftControlTime());
                editText.setText(dataBean.getShortUrl());
                String shortUrl = dataBean.getShortUrl();
                textView2.setOnClickListener(new a(dataBean));
                db2.this.t(shortUrl, false);
                textView2.setVisibility(0);
                textView3.setText(ah4.e(R.string.link_generate_notice));
                textView4.setVisibility(8);
                viewInflate.setTag(dataBean.getId());
                editText.setTag(dataBean.getTid());
                strSubstring = strSubstring + dataBean.getTid() + ",";
                if (dataBean.getLeftControlTime() > 0 || dataBean.getExpire() == 0) {
                    if (dataBean.getExpire() == 0) {
                        textView.setText("");
                        imageView.setTag(0);
                    }
                    db2.this.p.put(dataBean.getId(), viewInflate);
                    db2.this.m.addView(viewInflate);
                }
                textView.setText(ah4.e(R.string.link_end_control));
                textView.setOnClickListener(new b(dataBean));
                if (WearUtils.e1(db2.A().d)) {
                    db2.A().d = ((ControlByUid.DataBean) this.a.get(0)).getId();
                }
                if (dataBean.isLoaded()) {
                    if (dataBean.isStartTimer()) {
                        db2.this.O(true);
                    }
                    if (db2.A().b.l()) {
                        vg3.b().a(new c(dataBean, viewInflate));
                    }
                }
                if (!WearUtils.e1(db2.this.w)) {
                    ye3.d("F0001", dataBean.getShortUrl() + "#" + db2.this.w);
                    db2.this.w = "";
                }
                viewGroup = null;
            }
            if (strSubstring.endsWith(",")) {
                strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
            }
            db2.A().f = strSubstring;
        }
    }

    /* compiled from: ControlInstance.java */
    public class r implements Runnable {
        public final /* synthetic */ boolean a;

        public r(db2 db2Var, boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            MyApplication myApplication = WearUtils.x;
            sg3.i(MyApplication.H(), this.a ? R.string.chat_message_item_copy_notice : R.string.link_create_success);
        }
    }

    /* compiled from: ControlInstance.java */
    public interface s {
        void a();
    }

    public db2() {
        this.e = "";
        this.n = null;
        this.e = "";
        new Timer().schedule(new k(), 30000L, 360000L);
        Timer timer = new Timer();
        this.n = timer;
        timer.schedule(new l(), 1000L, 1000L);
    }

    public static db2 A() {
        if (K == null) {
            K = new db2();
        }
        return K;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I() {
        qk2 qk2Var = this.b;
        if (qk2Var != null) {
            qk2Var.y();
        }
    }

    public String B() {
        String str = this.A;
        return str == null ? "" : str.replace("https", "wss");
    }

    public boolean C() {
        boolean z = false;
        for (String str : A().e.split(",")) {
            Toy toyR = WearUtils.x.G().R(str);
            if (toyR != null) {
                if (toyR.getType().toLowerCase().equals("nora".toLowerCase()) || toyR.getType().toLowerCase().equals("max".toLowerCase())) {
                    this.s = true;
                }
                if (WearUtils.x.G().a(toyR.getAddress())) {
                    z = true;
                }
            }
        }
        return z;
    }

    public boolean D() {
        boolean z;
        synchronized (this.j) {
            z = this.j.size() > 0;
        }
        return z;
    }

    public void E() {
        ArrayList<Toy> arrayListP;
        String strSubstring = "";
        if (!WearUtils.e1(this.e)) {
            String[] strArrSplit = this.e.split(",");
            if (strArrSplit == null || strArrSplit.length <= 0) {
                this.e = "";
            } else {
                String strSubstring2 = "";
                for (String str : strArrSplit) {
                    Toy toyR = WearUtils.x.G().R(str);
                    if (toyR != null && WearUtils.x.G().a(toyR.getAddress())) {
                        strSubstring2 = strSubstring2 + toyR.getAndUpdateDeviceId() + ",";
                    }
                }
                if (!WearUtils.e1(strSubstring2)) {
                    strSubstring2 = strSubstring2.substring(0, strSubstring2.length() - 1);
                }
                this.e = strSubstring2;
            }
        }
        if (!WearUtils.e1(this.e) || (arrayListP = WearUtils.x.G().P()) == null || arrayListP.size() <= 0) {
            return;
        }
        Iterator<Toy> it = arrayListP.iterator();
        while (it.hasNext()) {
            Toy next = it.next();
            if (next != null && WearUtils.x.G().a(next.getAddress())) {
                strSubstring = strSubstring + next.getAndUpdateDeviceId() + ",";
            }
        }
        if (!WearUtils.e1(strSubstring)) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
        this.e = strSubstring;
    }

    public boolean F() {
        return this.i;
    }

    public boolean G() {
        return this.C;
    }

    public void J() {
        if (WearUtils.e1(A().c)) {
            A().c = String.valueOf(eg3.b(WearUtils.x, "control_uid_simple_key", ""));
        }
        HashMap map = new HashMap();
        map.put("uid", A().c);
        tn2.x(WearUtils.x).l("/app/ws/v2/loadCLinkByUid", map, new p());
    }

    public void K() {
        qk2 qk2Var = this.b;
        if (qk2Var != null) {
            qk2Var.p();
            this.b = null;
        }
        z();
    }

    public void L(SyncWsProtocol syncWsProtocol) {
        if (syncWsProtocol == null || WearUtils.e1(A().d)) {
            return;
        }
        if (syncWsProtocol.getType().equals(SyncWsProtocol.CONTROL_106_TYPE_KEY)) {
            o(syncWsProtocol.getSid());
            O(true);
        } else if (syncWsProtocol.getType().equals(SyncWsProtocol.CONTROL_TIME_LEFT_TYPE_KEY) || syncWsProtocol.getType().equals(SyncWsProtocol.CONTROL_BEGIN_TYPE_KEY)) {
            if (syncWsProtocol.getType().equals(SyncWsProtocol.CONTROL_BEGIN_TYPE_KEY)) {
                this.C = true;
                M();
            }
            ControlLinkActivity controlLinkActivity = this.k;
            if (controlLinkActivity != null) {
                controlLinkActivity.runOnUiThread(new i(syncWsProtocol));
            }
        }
    }

    public final void M() {
        if (MyApplication.H() instanceof ToyDepthControlActivity) {
            if (this.C) {
                return;
            }
            pc1.a.H();
        } else if (this.C) {
            pc1.a.F();
        } else {
            pc1.a.I();
        }
    }

    public void N(String str) {
        qk2 qk2Var;
        HashMap map = new HashMap();
        try {
            HashMap map2 = new HashMap();
            Iterator<Toy> it = WearUtils.x.G().o().iterator();
            while (it.hasNext()) {
                Toy next = it.next();
                if (next.isSelect()) {
                    HashMap map3 = new HashMap();
                    String deviceType = next.getDeviceType();
                    String lowerCase = "";
                    int i2 = 0;
                    if (!WearUtils.e1(deviceType) && deviceType.split(SignatureImpl.INNER_SEP).length == 3) {
                        lowerCase = next.getDeviceType().split(SignatureImpl.INNER_SEP)[2].toLowerCase();
                        if (lowerCase.endsWith(";")) {
                            lowerCase = lowerCase.substring(0, lowerCase.length() - 1);
                        }
                    }
                    map3.put(TtmlNode.ATTR_ID, lowerCase);
                    map3.put("name", next.getRealType().toLowerCase());
                    int i3 = next.isSelect() ? 1 : -1;
                    if (i3 != -1) {
                        i2 = i3;
                    } else if (WearUtils.x.G().a(next.getAddress())) {
                        i2 = 1;
                    }
                    map3.put("status", Integer.valueOf(i2));
                    map3.put("nickName", next.getDefineRename());
                    map3.put("version", next.getGenerationVersion());
                    map3.put("fVersion", next.getVersion() == null ? "10" : String.valueOf(next.getVersion()));
                    map2.put(lowerCase, map3);
                }
            }
            map.put("type", "132");
            map.put("to", str);
            HashMap map4 = new HashMap();
            map4.put("type", "gtd");
            map4.put("data", map2);
            map.put("data", map4);
            if (WearUtils.x == null || (qk2Var = this.b) == null) {
                return;
            }
            qk2Var.u(WearUtils.A.toJson(map));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final synchronized void O(boolean z) {
        this.i = z;
        MusicControl.h0();
        h12.D.ControlisPause = z;
        EventBus eventBus = EventBus.getDefault();
        MusicControl.h0();
        eventBus.post(h12.D);
        System.out.println("控制状态！！！！！！" + z);
    }

    public void P() {
        String lowerCase;
        if (WearUtils.e1(this.c)) {
            return;
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        try {
            Iterator<Toy> it = WearUtils.x.G().o().iterator();
            while (true) {
                String defineRename = "";
                if (!it.hasNext()) {
                    break;
                }
                Toy next = it.next();
                if (next.isSelect()) {
                    HashMap map3 = new HashMap();
                    String deviceType = next.getDeviceType();
                    int i2 = 1;
                    if (WearUtils.e1(deviceType) || deviceType.split(SignatureImpl.INNER_SEP).length != 3) {
                        lowerCase = "";
                    } else {
                        lowerCase = next.getDeviceType().split(SignatureImpl.INNER_SEP)[2].toLowerCase();
                        if (lowerCase.endsWith(";")) {
                            lowerCase = lowerCase.substring(0, lowerCase.length() - 1);
                        }
                    }
                    map3.put(TtmlNode.ATTR_ID, lowerCase);
                    map3.put("name", next.getRealType().toLowerCase());
                    if (!WearUtils.x.G().a(next.getAddress())) {
                        i2 = 0;
                    }
                    map3.put("status", Integer.valueOf(i2));
                    map3.put("battery", "" + next.getBattery());
                    map3.put("version ", next.getGenerationVersion());
                    map3.put("hVersion", next.getGenerationVersion());
                    map3.put("fVersion", next.getVersion());
                    if (!WearUtils.e1(next.getDefineRename())) {
                        defineRename = next.getDefineRename();
                    }
                    map3.put("nickname", defineRename);
                    if (next.isBAToy()) {
                        map3.put("workMode", fk2.a.c(next.getAddress()).name().toLowerCase());
                    }
                    map.put(lowerCase, map3);
                }
            }
            map2.put("uid", this.c);
            map2.put("platform", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
            map2.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, WearUtils.q);
            map2.put("toys", map);
            map2.put("appType", "remote");
            map2.put("appType", "remote");
            map2.put("domain", kf2.m().n().replace(".", Constants.FILENAME_SEQUENCE_SEPARATOR) + WearUtils.q0());
            map2.put("httpsPort", "" + kf2.m().p());
            map2.put("wssPort", "" + kf2.m().p());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.B = false;
        tn2.x(WearUtils.x).m("/app/remote/setInfo", WearUtils.A.toJson(map2), new m());
    }

    public void Q(ControlLinkActivity controlLinkActivity, LinearLayout linearLayout) {
        this.k = controlLinkActivity;
        this.m = linearLayout;
    }

    public void R(String str) {
        this.A = str;
    }

    public final void S(List<ControlByUid.DataBean> list) {
        if (list == null || list.size() <= 0) {
            O(false);
            A().d = null;
        } else {
            for (ControlByUid.DataBean dataBean : list) {
                A().d = dataBean.getId();
                if (dataBean.isLoaded() && dataBean.isStartTimer()) {
                    O(true);
                }
            }
        }
        ControlLinkActivity controlLinkActivity = this.k;
        if (controlLinkActivity == null) {
            return;
        }
        controlLinkActivity.runOnUiThread(new q(list));
    }

    public void T() {
        try {
            A().g = null;
            A();
            eg3.m(WearUtils.x, "choose_control_toy_id");
            r();
            this.p.clear();
            LinearLayout linearLayout = this.m;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            WearUtils.x.G().u0();
            WearUtils.x.l.postDelayed(new f(), 1500L);
            s();
            ob2.o().H(2);
            sz1.d().s(A());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final synchronized void U(String str, View view, int i2, String str2, boolean z) {
        TextView textView = (TextView) view.findViewById(R.id.tv_link_times);
        TextView textView2 = (TextView) view.findViewById(R.id.url_copy);
        TextView textView3 = (TextView) view.findViewById(R.id.tv_control_state);
        TextView textView4 = (TextView) view.findViewById(R.id.tv_controling_times);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_link_infinity);
        textView2.setVisibility(8);
        textView3.setText(ah4.e(R.string.link_generate_control_notice));
        if (str2.equals(SyncWsProtocol.DataBean.CONTROL_STATUS_CONTROLLING_TYPE_KEY)) {
            this.q.put(str, view);
            if (i2 >= 0) {
                textView4.setText(WearUtils.Q(i2));
                textView4.setTag(R.id.tv_controling_times, Integer.valueOf(i2));
                textView4.setVisibility(0);
                if (((Integer) imageView.getTag()).intValue() == 0) {
                    if (z) {
                        Timer timer = this.o;
                        if (timer != null) {
                            timer.cancel();
                            this.o = null;
                        }
                        textView4.setTag(R.id.tv_controling_times, 0);
                    }
                    textView4.setVisibility(8);
                }
            } else if (this.o != null) {
                if (((Integer) imageView.getTag()).intValue() == 0) {
                    int iIntValue = (textView4.getTag() == null || textView4.getTag(R.id.tv_controling_times) == null) ? 0 : Integer.valueOf(textView4.getTag(R.id.tv_controling_times).toString()).intValue();
                    if (this.o != null) {
                        iIntValue++;
                    }
                    textView4.setTag(R.id.tv_controling_times, Integer.valueOf(iIntValue));
                    textView4.setText(WearUtils.Q(iIntValue));
                    textView4.setVisibility(0);
                } else {
                    String strReplace = ("" + ((textView4.getTag() == null || textView4.getTag(R.id.tv_controling_times) == null) ? 0 : Integer.valueOf(textView4.getTag(R.id.tv_controling_times).toString()).intValue())).replace("s", "");
                    if (!WearUtils.e1(strReplace) && WearUtils.q1(strReplace) && Integer.valueOf(strReplace).intValue() > 0) {
                        String str3 = "" + (Integer.valueOf(strReplace).intValue() - 1);
                        textView4.setText(WearUtils.Q(Integer.valueOf(str3).intValue()));
                        textView4.setTag(R.id.tv_controling_times, str3);
                        textView4.setVisibility(0);
                        if (Integer.valueOf(str3).intValue() <= 0) {
                            T();
                            ye3.d("F0003", "");
                        }
                    } else if (WearUtils.e1(strReplace) || strReplace.indexOf(SignatureImpl.INNER_SEP) <= 0 || strReplace.length() != 5) {
                        textView4.setVisibility(8);
                    } else {
                        int iC0 = WearUtils.C0(strReplace) - 1;
                        textView4.setText(WearUtils.Q(iC0));
                        textView4.setTag(R.id.tv_controling_times, "" + iC0);
                        textView4.setVisibility(0);
                        if (iC0 > -1 && iC0 <= 0) {
                            T();
                        }
                    }
                }
            }
            textView.setText(ah4.e(R.string.link_end_control));
            if (((Integer) imageView.getTag()).intValue() == 0) {
                imageView.setVisibility(8);
            }
            textView.setOnClickListener(new n(str));
        } else {
            this.q.remove(str);
            if (((Integer) imageView.getTag()).intValue() == 8) {
                textView.setText(ah4.e(R.string.link_end_control));
            }
            textView.setOnClickListener(new o(str));
            textView2.setVisibility(0);
            textView3.setText(ah4.e(R.string.link_generate_notice));
            textView4.setVisibility(8);
        }
    }

    public final synchronized void V(String str, View view, int i2) {
        TextView textView = (TextView) view.findViewById(R.id.url_copy);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_control_state);
        TextView textView3 = (TextView) view.findViewById(R.id.tv_controling_times);
        textView.setVisibility(8);
        textView2.setText(ah4.e(R.string.link_generate_control_notice));
        textView3.setVisibility(0);
        textView3.setTag(R.id.tv_controling_times, Integer.valueOf(i2));
        textView3.setText(WearUtils.Q(i2));
        textView3.setVisibility(0);
    }

    public void a(String str) {
        MyApplication myApplication = WearUtils.x;
        FragmentActivity fragmentActivityH = MyApplication.H();
        if (fragmentActivityH != null) {
            fragmentActivityH.runOnUiThread(new c(this, fragmentActivityH, str));
        }
    }

    @Override // dc.tz1
    public int getPriority() {
        return 4;
    }

    public final synchronized void o(String str) {
        r();
        Timer timer = new Timer();
        this.o = timer;
        timer.schedule(new d(), 1000L, 5000L);
        ControlLinkActivity controlLinkActivity = this.k;
        if (controlLinkActivity != null) {
            controlLinkActivity.runOnUiThread(new e(str));
        }
    }

    public void p(s sVar) {
        if (na2.m().i()) {
            na2.m().t();
        } else if (sVar != null) {
            sVar.a();
        }
    }

    @Override // dc.tz1
    public void pauseConnon(int i2) {
    }

    public void q(s sVar) {
        MyApplication myApplication = WearUtils.x;
        FragmentActivity fragmentActivityH = MyApplication.H();
        if (!D() || fragmentActivityH == null) {
            if (sVar != null) {
                sVar.a();
            }
        } else {
            kn3 kn3Var = new kn3((Context) fragmentActivityH, ah4.e(R.string.has_linked_2_create_live_notice), ah4.e(R.string.common_cancel), ah4.e(R.string.link_end_control), true, (kn3.d) new j(sVar));
            kn3Var.show();
            kn3Var.k();
            kn3Var.r();
        }
    }

    public void r() {
        Timer timer = this.o;
        if (timer != null) {
            timer.cancel();
            this.o = null;
        }
    }

    @Override // dc.tz1
    public void recovery() {
    }

    public void s() {
        String str = "closeWebSocket: hasOrgys: " + OrgySetting.getInstance().hasOrgys();
        String str2 = "closeWebSocket: discord is join: " + DiscordControl.getInstance().isJoin();
        if (OrgySetting.getInstance().hasOrgys() || DiscordControl.getInstance().isJoin() || ff2.d) {
            return;
        }
        new Handler().postDelayed(new Runnable() { // from class: dc.wa2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.I();
            }
        }, 100L);
    }

    @Override // dc.tz1
    public void stop(int i2) {
        if (D()) {
            A().w(true);
        }
    }

    public final void t(String str, boolean z) {
        if (this.z && !WearUtils.e1(str)) {
            WearUtils.p(str, WearUtils.x);
            MyApplication myApplication = WearUtils.x;
            if (MyApplication.H() != null) {
                MyApplication myApplication2 = WearUtils.x;
                if (MyApplication.H().getClass().getSimpleName().equals("ControlLinkActivity")) {
                    MyApplication myApplication3 = WearUtils.x;
                    MyApplication.H().runOnUiThread(new r(this, z));
                }
            }
        }
        this.z = false;
    }

    public void u(String str, boolean z, int i2, String str2) {
        if (A().b == null) {
            return;
        }
        this.r = str;
        this.s = z;
        this.t = i2;
        this.u = str2;
        this.v = true;
        ControlLinkActivity controlLinkActivity = this.k;
        if (controlLinkActivity != null) {
            this.D = ProgressDialog.show(controlLinkActivity, "", ah4.e(R.string.common_loading), true, true);
        }
        String strB = B();
        if (!TextUtils.isEmpty(strB)) {
            this.k.parentHandler.postDelayed(new b(strB), 1000L);
            return;
        }
        pj3.v(MyApplication.H(), LoginActivity.class);
        MyApplication.H().finish();
        this.D.dismiss();
    }

    public void v() {
        this.b = new qk2(WearUtils.x);
        J();
    }

    public void w(boolean z) {
        HashMap<String, String> map = this.j;
        if (map == null || map.size() <= 0) {
            return;
        }
        try {
            synchronized (this.j) {
                Iterator<String> it = this.j.keySet().iterator();
                while (it.hasNext()) {
                    x(it.next(), false, z);
                }
                this.j.clear();
            }
        } catch (Exception unused) {
        }
    }

    public final void x(String str, boolean z, boolean z2) {
        if (z) {
            ye3.d("F0004", "");
        }
        WearUtils.x.G().u0();
        if (z) {
            synchronized (this.j) {
                this.j.clear();
            }
        }
        HashMap map = new HashMap();
        map.put("uid", A().c);
        map.put(PSOProgramService.ServiceID_Key, str);
        tn2.x(WearUtils.x).l("/app/ws/closeSession", map, new h(str, z2));
    }

    public final void y(String str) {
        MyApplication myApplication = WearUtils.x;
        FragmentActivity fragmentActivityH = MyApplication.H();
        if (fragmentActivityH == null) {
            return;
        }
        kn3 kn3Var = new kn3((Context) fragmentActivityH, ah4.e(R.string.link_delete_notice), ah4.e(R.string.common_cancel), ah4.e(R.string.link_end_control), true, (kn3.d) new g(str));
        kn3Var.show();
        kn3Var.k();
        kn3Var.q();
    }

    public void z() {
        r();
        Timer timer = this.n;
        if (timer != null) {
            timer.cancel();
            this.n = null;
        }
    }
}
