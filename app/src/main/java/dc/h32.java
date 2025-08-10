package dc;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.alibaba.fastjson.JSON;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.JsonSyntaxException;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.WebSocket;
import com.koushikdutta.async.http.server.AsyncHttpServerRequest;
import com.wear.bean.DomainBean;
import com.wear.bean.GameModeToyLogBean;
import com.wear.bean.IpBean;
import com.wear.bean.LanApiControlEvent;
import com.wear.bean.SetLanInfoEvent;
import com.wear.bean.SyncWsProtocol;
import com.wear.bean.Toy;
import com.wear.bean.ToyCtrlGameReceiveBean;
import com.wear.bean.ToyFeedbackBean;
import com.wear.bean.event.GameModeAcceptConnectEvent;
import com.wear.bean.event.ToyCtrlGameEvent;
import com.wear.bean.event.ToyGserEvent;
import com.wear.broadcast.GameModeService;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ef2;
import dc.or1;
import dc.t32;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smack.util.SystemUtil;
import org.jivesoftware.smackx.ping.packet.Ping;

/* compiled from: GameModeControl.java */
/* loaded from: classes3.dex */
public class h32 {
    public static final String i = "dc.h32";
    public static h32 j;
    public kf2 a;
    public Timer c;
    public String d;
    public e f;
    public boolean b = false;
    public String e = "Unknown";
    public String g = "";
    public CopyOnWriteArrayList<t32.c> h = new CopyOnWriteArrayList<>();

    /* compiled from: GameModeControl.java */
    public class a implements zn2<BaseResponseBean> {
        public a(h32 h32Var) {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBean baseResponseBean) {
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
        }
    }

    /* compiled from: GameModeControl.java */
    public class b implements zn2<String> {
        public b(h32 h32Var) {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            String unused = h32.i;
            String str2 = "setLocalToy success: " + str;
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            String unused = h32.i;
            String str = "setLocalToy error: " + netException.getMessage();
        }
    }

    /* compiled from: GameModeControl.java */
    public class c implements ef2 {
        public c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void e(WebSocket webSocket, Exception exc) {
            String unused = h32.i;
            String str = "WebSocket setClosedCallback: " + exc;
            h32.this.E(webSocket);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void g(WebSocket webSocket, String str) {
            String unused = h32.i;
            String str2 = "WebSocket onStringAvailable: " + str;
            h32.this.w(webSocket, str);
        }

        @Override // dc.ef2
        public ef2.a a(final WebSocket webSocket, AsyncHttpServerRequest asyncHttpServerRequest) {
            ef2.a aVar = new ef2.a();
            aVar.b = false;
            if (!"/v1".equals(asyncHttpServerRequest.getPath())) {
                return aVar;
            }
            String unused = h32.i;
            String str = "WebSocket address:" + webSocket.toString();
            aVar.b = true;
            t32.c cVar = new t32.c();
            cVar.b = webSocket;
            cVar.b();
            h32.this.h.add(cVar);
            EventBus.getDefault().post(new GameModeAcceptConnectEvent());
            webSocket.setClosedCallback(new CompletedCallback() { // from class: dc.b32
                @Override // com.koushikdutta.async.callback.CompletedCallback
                public final void onCompleted(Exception exc) {
                    this.a.e(webSocket, exc);
                }
            });
            webSocket.setStringCallback(new WebSocket.StringCallback() { // from class: dc.c32
                @Override // com.koushikdutta.async.http.WebSocket.StringCallback
                public final void onStringAvailable(String str2) {
                    this.a.g(webSocket, str2);
                }
            });
            return aVar;
        }

        @Override // dc.ef2
        public void b(Exception exc) {
            xe3.a(h32.i, "createFail ip=" + exc.getMessage());
        }

        @Override // dc.ef2
        public void c(String str, int i) {
            xe3.a(h32.i, "createSuccess ip=" + str + "   port=" + i);
            h32.this.z();
        }
    }

    /* compiled from: GameModeControl.java */
    public class d extends TimerTask {
        public d() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            ArrayList arrayList = new ArrayList();
            Iterator it = h32.this.h.iterator();
            while (it.hasNext()) {
                t32.c cVar = (t32.c) it.next();
                if (cVar.a()) {
                    arrayList.add(cVar);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                h32.this.E(((t32.c) it2.next()).b);
            }
        }
    }

    /* compiled from: GameModeControl.java */
    public interface e {
        void a(String str);
    }

    public static h32 i() {
        if (j == null) {
            synchronized (h32.class) {
                if (j == null) {
                    j = new h32();
                }
            }
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Unit n(ToyFeedbackBean toyFeedbackBean) {
        y(toyFeedbackBean);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Unit p(ToyFeedbackBean toyFeedbackBean) {
        y(toyFeedbackBean);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Unit r(ToyFeedbackBean toyFeedbackBean) {
        y(toyFeedbackBean);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Unit t(ToyFeedbackBean toyFeedbackBean) {
        y(toyFeedbackBean);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Unit v(ToyFeedbackBean toyFeedbackBean) {
        y(toyFeedbackBean);
        return null;
    }

    public void A(e eVar) {
        this.f = eVar;
    }

    public final void B() {
        Timer timer = this.c;
        if (timer != null) {
            timer.cancel();
            this.c = null;
        }
        Timer timer2 = new Timer();
        this.c = timer2;
        timer2.schedule(new d(), 1000L, 5000L);
    }

    public final void C() {
        String str = "stopAllWebSocket: " + this.h.size();
        Iterator<t32.c> it = this.h.iterator();
        while (it.hasNext()) {
            t32.c next = it.next();
            String str2 = "stopAllWebSocket: " + this.h.size();
            next.b.close();
        }
        this.h.clear();
    }

    public void D() {
        if (this.a != null) {
            this.a.E();
            this.a = null;
        }
        C();
        if (!TextUtils.isEmpty(this.g)) {
            or1.f();
            or1.e(0);
        }
        ff2.n().C();
        ff2.d = false;
        ff2.e = false;
        EventBus.getDefault().post(new LanApiControlEvent(false));
        if (!MyApplication.Z) {
            db2.A().s();
        }
        this.b = false;
        if (GameModeService.f) {
            WearUtils.x.stopService(new Intent(WearUtils.x, (Class<?>) GameModeService.class));
        }
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    public final void E(WebSocket webSocket) {
        webSocket.close();
        t32.c cVarG = g(webSocket);
        if (cVarG != null) {
            this.h.remove(cVarG);
            EventBus.getDefault().post(new ToyCtrlGameEvent(20));
        }
        if (j()) {
            return;
        }
        or1.a aVar = or1.a;
        aVar.h();
        aVar.b(0);
    }

    public void F(int i2) {
        HashMap map = new HashMap();
        map.put("gameAppId", ye3.x().replaceAll(Constants.FILENAME_SEQUENCE_SEPARATOR, ""));
        map.put("status", Integer.valueOf(i2));
        tn2.x(WearUtils.x).k("/api/remote/uploadGameMode", map, new a(this));
        if (i2 == 1) {
            this.b = true;
            f();
            i().e("C0014", null, null);
        } else {
            D();
            i().e("C0015", null, null);
            this.d = "";
            this.e = "Unknown";
        }
    }

    public void e(String str, String str2, String str3) {
        HashMap map = new HashMap();
        String json = "";
        if (TextUtils.equals("C0014", str)) {
            ArrayList<Toy> arrayListP = pc1.a.P();
            if (!arrayListP.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                Iterator<Toy> it = arrayListP.iterator();
                while (it.hasNext()) {
                    Toy next = it.next();
                    GameModeToyLogBean gameModeToyLogBean = new GameModeToyLogBean();
                    gameModeToyLogBean.setId(next.getDeviceTypeMac(next.getDeviceType()).toLowerCase());
                    gameModeToyLogBean.setToytype(next.getType());
                    gameModeToyLogBean.setfVersion(next.getToyVersion());
                    arrayList.add(WearUtils.A.toJson(gameModeToyLogBean));
                }
                map.put("toys", arrayList);
                json = WearUtils.A.toJson(map);
            }
        } else if (TextUtils.equals("C0016", str)) {
            if (!this.b) {
                return;
            }
            if (!TextUtils.equals(str3, this.e)) {
                this.d = "";
                this.e = str3;
                e eVar = this.f;
                if (eVar != null) {
                    eVar.a(str3);
                }
            }
            if (!TextUtils.isEmpty(this.d)) {
                return;
            }
            this.d = str2;
            map.put(SyncWsProtocol.CONTROL_ORDER_TOY_TYPE_KEY, str2);
            map.put("X-platform", str3);
            json = WearUtils.A.toJson(map);
        }
        ye3.d(str, json);
    }

    public void f() {
        if (this.b || this.a == null) {
            kf2 kf2VarM = kf2.m();
            this.a = kf2VarM;
            kf2VarM.b(new c(), "/v1", true);
            ff2.d = true;
            ff2.e = true;
            EventBus.getDefault().post(new LanApiControlEvent(true));
            if (!MyApplication.Z && db2.A().b != null) {
                db2.A().b.j(false);
            }
            if (!GameModeService.f) {
                Intent intent = new Intent(WearUtils.x, (Class<?>) GameModeService.class);
                if (Build.VERSION.SDK_INT >= 26) {
                    WearUtils.x.startForegroundService(intent);
                } else {
                    WearUtils.x.startService(intent);
                }
            }
            B();
            if (EventBus.getDefault().isRegistered(this)) {
                return;
            }
            EventBus.getDefault().register(this);
        }
    }

    public final t32.c g(WebSocket webSocket) {
        if (webSocket == null) {
            return null;
        }
        Iterator<t32.c> it = this.h.iterator();
        while (it.hasNext()) {
            t32.c next = it.next();
            if (webSocket == next.b) {
                return next;
            }
        }
        return null;
    }

    public ArrayList<t32.c> h() {
        WebSocket webSocket;
        ArrayList<t32.c> arrayList = new ArrayList<>();
        Iterator<t32.c> it = this.h.iterator();
        while (it.hasNext()) {
            t32.c next = it.next();
            if (!TextUtils.isEmpty(next.a) && (webSocket = next.b) != null && webSocket.isOpen()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public boolean j() {
        boolean z;
        Iterator<t32.c> it = this.h.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            t32.c next = it.next();
            if (!TextUtils.isEmpty(next.a) && next.b != null) {
                z = true;
                break;
            }
        }
        String str = "isFeedbackEnable:  " + z + ", gameBeanList: " + this.h.size();
        return z;
    }

    public final boolean k(WebSocket webSocket) {
        return webSocket != null && webSocket.isOpen();
    }

    public boolean l() {
        return this.b;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(ToyCtrlGameEvent toyCtrlGameEvent) {
        lf2.a.a().b(toyCtrlGameEvent, new Function1() { // from class: dc.d32
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.a.n((ToyFeedbackBean) obj);
            }
        });
    }

    public final void w(WebSocket webSocket, String str) {
        t32.c cVarG;
        t32.c cVarG2;
        if (TextUtils.isEmpty(str) || !k(webSocket)) {
            return;
        }
        ToyCtrlGameReceiveBean toyCtrlGameReceiveBean = null;
        try {
            toyCtrlGameReceiveBean = (ToyCtrlGameReceiveBean) WearUtils.A.fromJson(str, ToyCtrlGameReceiveBean.class);
        } catch (JsonSyntaxException e2) {
            e2.printStackTrace();
        }
        if (toyCtrlGameReceiveBean == null || TextUtils.isEmpty(toyCtrlGameReceiveBean.type)) {
            return;
        }
        String str2 = toyCtrlGameReceiveBean.type;
        str2.hashCode();
        if (!str2.equals("access")) {
            if (str2.equals(Ping.ELEMENT) && (cVarG2 = g(webSocket)) != null) {
                cVarG2.b();
                x(webSocket, new ToyFeedbackBean("pong"));
                return;
            }
            return;
        }
        ToyCtrlGameReceiveBean.DataDTO dataDTO = toyCtrlGameReceiveBean.data;
        if (dataDTO == null || TextUtils.isEmpty(dataDTO.appName) || (cVarG = g(webSocket)) == null) {
            return;
        }
        cVarG.a = toyCtrlGameReceiveBean.data.appName;
        cVarG.b();
        x(webSocket, new ToyFeedbackBean("access-granted"));
        EventBus.getDefault().post(new ToyCtrlGameEvent(20));
        or1.a aVar = or1.a;
        aVar.f();
        aVar.b(3);
        lf2.a.a().h(new Function1() { // from class: dc.g32
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.a.v((ToyFeedbackBean) obj);
            }
        });
        String strE = WearUtils.E();
        this.g = strE;
        ye3.j("Game Mode", "game_mode_control_third_party_success", "connect", strE, "", cVarG.a, "", -1L);
    }

    public final boolean x(WebSocket webSocket, ToyFeedbackBean toyFeedbackBean) {
        try {
            if (!k(webSocket)) {
                return false;
            }
            String jSONString = JSON.toJSONString(toyFeedbackBean);
            String str = "sendMsg__str: " + jSONString;
            webSocket.send(jSONString);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final boolean y(ToyFeedbackBean toyFeedbackBean) {
        boolean z = false;
        try {
            String jSONString = JSON.toJSONString(toyFeedbackBean);
            String str = "gameBeanList: " + this.h.size() + "\nsendMsg__str: " + jSONString;
            Iterator<t32.c> it = this.h.iterator();
            while (it.hasNext()) {
                t32.c next = it.next();
                if (k(next.b)) {
                    next.b.send(jSONString);
                    z = true;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return z;
    }

    public void z() {
        String str;
        String lowerCase;
        if (this.b) {
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            try {
                Iterator<Toy> it = pc1.a.o().iterator();
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
                        map3.put("battery", Integer.valueOf(next.getBattery()));
                        if (!WearUtils.e1(next.getDefineRename())) {
                            defineRename = next.getDefineRename();
                        }
                        map3.put("nickname", defineRename);
                        map3.put("version", next.getGenerationVersion());
                        map3.put("hVersion", next.getGenerationVersion());
                        map3.put("fVersion", next.getVersion());
                        if (next.isBAToy()) {
                            map3.put("workMode", fk2.a.c(next.getAddress()).name().toLowerCase());
                        }
                        map.put(lowerCase, map3);
                    }
                }
                map2.put("toys", map);
                DomainBean domainBeanV = WearUtils.V();
                if (domainBeanV != null) {
                    String ip = domainBeanV.getIp();
                    if (domainBeanV.isIpv6()) {
                        str = "v6-" + ip.replace(SignatureImpl.INNER_SEP, Constants.FILENAME_SEQUENCE_SEPARATOR) + WearUtils.q0();
                        if (WearUtils.e1(WearUtils.u) || !WearUtils.u.equals(domainBeanV.getIp())) {
                            List<IpBean> ipBeanList = domainBeanV.getIpBeanList();
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(str);
                            if (ipBeanList != null) {
                                Iterator<IpBean> it2 = ipBeanList.iterator();
                                while (it2.hasNext()) {
                                    arrayList.add(it2.next().getIpAddress());
                                }
                            }
                            String json = WearUtils.A.toJson(arrayList);
                            String str2 = "setLocalToy: " + json;
                            ye3.d("E0015", nd3.r(json));
                            WearUtils.u = domainBeanV.getIp();
                        }
                    } else {
                        str = ip.replace(".", Constants.FILENAME_SEQUENCE_SEPARATOR) + WearUtils.q0();
                    }
                } else {
                    str = "";
                }
                String str3 = "setLocalToy: domain=" + str;
                map2.put("domain", str);
                map2.put("platform", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
                map2.put("version", SyncWsProtocol.CONTROL_SYNC_TYPE_KEY);
                map2.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, WearUtils.q);
                map2.put("httpPort", "" + kf2.m().o());
                map2.put("wsPort", "" + kf2.m().o());
                map2.put("httpsPort", "" + kf2.m().p());
                map2.put("wssPort", "" + kf2.m().p());
                map2.put(NotificationCompat.CATEGORY_SYSTEM, "" + SystemUtil.getSystemVersion());
                map2.put("gameAppId", ye3.x().replaceAll(Constants.FILENAME_SEQUENCE_SEPARATOR, ""));
                map2.put("appType", "remote");
                if (ch3.n().u() != null) {
                    map2.put("suid", ch3.n().u().getUid());
                }
                map2.put("deviceCode", ye3.x().substring(ye3.x().length() - 6));
                String json2 = WearUtils.A.toJson(map2);
                String str4 = "setInfo:" + json2;
                EventBus.getDefault().post(new SetLanInfoEvent(str.replace(WearUtils.q0(), "").replace(Constants.FILENAME_SEQUENCE_SEPARATOR, "."), String.valueOf(kf2.m().o()), String.valueOf(kf2.m().p())));
                if (!uf2.v().y()) {
                    tn2.x(WearUtils.x).m("/app/lan/setInfo", json2, new b(this));
                    return;
                }
                i32 i32Var = new i32();
                i32Var.k(WearUtils.A.toJson(map));
                i32Var.d(str);
                i32Var.h(DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
                i32Var.l(SyncWsProtocol.CONTROL_SYNC_TYPE_KEY);
                i32Var.b(WearUtils.q);
                i32Var.f("" + kf2.m().o());
                i32Var.m("" + kf2.m().o());
                i32Var.g("" + kf2.m().p());
                i32Var.n("" + kf2.m().p());
                i32Var.j("" + SystemUtil.getSystemVersion());
                i32Var.e(ye3.x().replaceAll(Constants.FILENAME_SEQUENCE_SEPARATOR, ""));
                i32Var.a("remote");
                i32Var.c(ye3.x().substring(ye3.x().length() + (-6)));
                if (ch3.n().u() != null) {
                    i32Var.i(ch3.n().u().getUid());
                }
                uf2.v().E(i32Var);
                String str5 = "setLocalToy: " + i32Var.toString();
            } catch (Exception e2) {
                e2.printStackTrace();
                FirebaseCrashlytics.getInstance().recordException(e2);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(ToyGserEvent toyGserEvent) {
        String str = "ToyGserEvent__value: " + toyGserEvent.toString();
        lf2.a.a().c(toyGserEvent, new Function1() { // from class: dc.f32
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.a.p((ToyFeedbackBean) obj);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(xc1 xc1Var) {
        String str = "EventBusToyConnectEvent_____: " + xc1Var.b();
        int iB = xc1Var.b();
        if ((iB == -1 || iB == 1) && j()) {
            Toy toyI = lf2.a.a().i(xc1Var.a(), new Function1() { // from class: dc.e32
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return this.a.r((ToyFeedbackBean) obj);
                }
            });
            StringBuilder sb = new StringBuilder();
            sb.append("EventBusToyConnectEvent_____isConnected: ");
            sb.append(toyI != null ? Boolean.valueOf(toyI.isConnected()) : null);
            sb.toString();
            if (toyI == null || !toyI.isConnected()) {
                return;
            }
            String str2 = "startFeedbackMode____getAddress: " + xc1Var.a();
            or1.a aVar = or1.a;
            aVar.g(toyI);
            aVar.c(toyI, 3);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(uc1 uc1Var) {
        String str = "EventBusToyAddOrDeleteEvent_____: " + uc1Var.a();
        int iA = uc1Var.a();
        if ((iA == -10 || iA == 10) && j()) {
            lf2.a.a().h(new Function1() { // from class: dc.a32
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return this.a.t((ToyFeedbackBean) obj);
                }
            });
        }
    }
}
