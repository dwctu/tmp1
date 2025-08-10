package dc;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.WebSocket;
import com.koushikdutta.async.http.server.AsyncHttpServerRequest;
import com.wear.bean.Toy;
import com.wear.bean.event.NetWorkLocalEvent;
import com.wear.bean.server.base.MessageType;
import com.wear.bean.server.bean.G010Bean;
import com.wear.bean.server.bean.G020Bean;
import com.wear.bean.server.bean.G030Bean;
import com.wear.bean.server.bean.G040Bean;
import com.wear.bean.server.bean.G050Bean;
import com.wear.bean.server.bean.T011ToyBean;
import com.wear.bean.server.bean.ToyBean;
import com.wear.bean.socketio.date.response.CreateSocketServerBean;
import com.wear.bean.socketio.game.CreateServerResultBean;
import com.wear.main.game.ui.GameActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ef2;
import dc.r32;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: GameManagerImpl.java */
/* loaded from: classes3.dex */
public class r32 implements tz1, tf2 {
    public static r32 k = null;
    public static String l = "r32";
    public kf2 a;
    public Toy b;
    public pc1 d;
    public String f;
    public s32 h;
    public ef2 i;
    public int c = 0;
    public Handler e = new Handler(Looper.getMainLooper());
    public HashMap<String, qf2> g = new HashMap<>();
    public String j = "";

    /* compiled from: GameManagerImpl.java */
    public class a implements ef2 {

        /* compiled from: GameManagerImpl.java */
        /* renamed from: dc.r32$a$a, reason: collision with other inner class name */
        public class C0211a implements WebSocket.StringCallback {
            public final /* synthetic */ String a;
            public final /* synthetic */ g b;

            public C0211a(String str, g gVar) {
                this.a = str;
                this.b = gVar;
            }

            @Override // com.koushikdutta.async.http.WebSocket.StringCallback
            public void onStringAvailable(String str) {
                r32.this.q(this.a, this.b, str);
            }
        }

        public a() {
        }

        public static /* synthetic */ void d(Exception exc) {
            if (exc != null) {
                r32.p(r32.l, "WebSocket Error");
            }
        }

        @Override // dc.ef2
        public ef2.a a(WebSocket webSocket, AsyncHttpServerRequest asyncHttpServerRequest) {
            ef2.a aVar = new ef2.a();
            aVar.b = false;
            aVar.a = webSocket;
            String string = asyncHttpServerRequest.getQuery().getString("usercode");
            String string2 = asyncHttpServerRequest.getQuery().getString("type");
            String path = asyncHttpServerRequest.getPath();
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && "/game".equals(path) && r32.this.f.equals(string) && "mirlift".equals(string2)) {
                aVar.b = true;
                g gVar = new g(webSocket);
                r32.p(r32.l, "WebSocket address:" + webSocket.toString());
                webSocket.setClosedCallback(new CompletedCallback() { // from class: dc.n32
                    @Override // com.koushikdutta.async.callback.CompletedCallback
                    public final void onCompleted(Exception exc) {
                        r32.a.d(exc);
                    }
                });
                webSocket.setStringCallback(new C0211a(string, gVar));
                r32.this.g.put(string, gVar);
                WearUtils.x.q("vrgame_sockect_connected", null);
            }
            return aVar;
        }

        @Override // dc.ef2
        public void b(Exception exc) {
            r32.p(r32.l, exc.getMessage());
        }

        @Override // dc.ef2
        public void c(String str, int i) {
            CreateServerResultBean createServerResultBean = new CreateServerResultBean();
            createServerResultBean.ip = str;
            createServerResultBean.wsport = i + "";
            createServerResultBean.wsurl = "ws://" + str + SignatureImpl.INNER_SEP + i + "/game";
            r32.this.h(createServerResultBean);
            r32.p(r32.l, createServerResultBean.wsurl + "?type=mirlift&usercode=" + r32.this.f);
        }
    }

    /* compiled from: GameManagerImpl.java */
    public class b implements Runnable {
        public final /* synthetic */ G010Bean a;

        /* compiled from: GameManagerImpl.java */
        public class a implements Runnable {
            public final /* synthetic */ Toy a;

            public a(Toy toy) {
                this.a = toy;
            }

            @Override // java.lang.Runnable
            public void run() {
                r32.this.d.V(this.a);
            }
        }

        /* compiled from: GameManagerImpl.java */
        /* renamed from: dc.r32$b$b, reason: collision with other inner class name */
        public class RunnableC0212b implements Runnable {
            public final /* synthetic */ Toy a;

            public RunnableC0212b(Toy toy) {
                this.a = toy;
            }

            @Override // java.lang.Runnable
            public void run() {
                r32.this.d.V(this.a);
            }
        }

        public b(G010Bean g010Bean) {
            this.a = g010Bean;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            T t;
            if (!r32.this.n() && sz1.d().q(512)) {
                WearUtils.x.q("vrgame_start", null);
                r32.this.c = 1;
                ob2.o().H(0);
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() { // from class: dc.o32
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameActivity.w4(MyApplication.H());
                    }
                });
                Iterator<Map.Entry<String, Toy>> it = r32.this.d.g().entrySet().iterator();
                while (it.hasNext()) {
                    Toy value = it.next().getValue();
                    if (value.isSupportGame()) {
                        G010Bean g010Bean = this.a;
                        if (g010Bean == null || (t = g010Bean.data) == 0 || ((G010Bean.G010Data) t).getT() == null) {
                            r32.this.d.q0(value);
                            handler.postDelayed(new a(value), 500L);
                        } else if (value.getAndUpdateDeviceId().toLowerCase().equals(((G010Bean.G010Data) this.a.data).getT().toLowerCase())) {
                            r32.this.b = value;
                            r32.this.d.q0(value);
                            handler.postDelayed(new RunnableC0212b(value), 500L);
                            return;
                        }
                    }
                }
            }
        }
    }

    /* compiled from: GameManagerImpl.java */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r32.this.h != null) {
                r32.this.h.W0();
            }
        }
    }

    /* compiled from: GameManagerImpl.java */
    public class d implements Runnable {
        public final /* synthetic */ Toy a;

        public d(Toy toy) {
            this.a = toy;
        }

        @Override // java.lang.Runnable
        public void run() {
            r32.this.d.D(this.a);
        }
    }

    /* compiled from: GameManagerImpl.java */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r32.this.d.V(r32.this.b);
        }
    }

    /* compiled from: GameManagerImpl.java */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WearUtils.x.q("vrgame_networkChanged_cellular", null);
            r32.this.j();
        }
    }

    /* compiled from: GameManagerImpl.java */
    public static class g implements qf2 {
        public WebSocket a;

        public g(WebSocket webSocket) {
            this.a = webSocket;
        }

        @Override // dc.qf2
        public boolean c(String str, Object obj) {
            try {
                WebSocket webSocket = this.a;
                if (webSocket != null && webSocket.isOpen()) {
                    WebSocket webSocket2 = this.a;
                    SerializerFeature serializerFeature = SerializerFeature.WriteMapNullValue;
                    webSocket2.send(JSON.toJSONString(obj, serializerFeature));
                    String jSONString = JSON.toJSONString(obj, serializerFeature);
                    if (!jSONString.contains(MessageType.H011) && !jSONString.contains(MessageType.T011)) {
                        r32.p(r32.l, "发送websocket消息：" + jSONString);
                    }
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public r32() {
        sz1.d().n(this);
        EventBus.getDefault().register(this);
        this.d = pc1.a;
    }

    public static r32 l() {
        if (k == null) {
            synchronized (r32.class) {
                if (k == null) {
                    k = new r32();
                }
            }
        }
        return k;
    }

    public static void p(String str, String str2) {
        xe3.a(str, str2);
    }

    public void A(String str) {
        q(null, uf2.v(), str);
    }

    public void B(CreateSocketServerBean createSocketServerBean) {
        l().g(createSocketServerBean);
    }

    public void C(String str) {
        q(null, uf2.v(), str);
    }

    public void D() {
        z();
    }

    public void E() {
        kf2 kf2Var = this.a;
        if (kf2Var != null) {
            kf2Var.E();
            this.a = null;
        }
    }

    @Override // dc.tf2
    public void connectSuc() {
    }

    @Override // dc.tf2
    public void disConnect() {
    }

    public void g(CreateSocketServerBean createSocketServerBean) {
        this.f = createSocketServerBean.getVrGameCode();
        p(l, "vrGameCode：" + this.f);
        j();
        x();
    }

    @Override // dc.tz1
    public int getPriority() {
        return 512;
    }

    public void h(pf2 pf2Var) {
        xe3.a("GameManagerImpl", "attemptSendGame:" + pf2Var.getAction());
        Object json = JSON.toJSON(pf2Var);
        String str = "oldMessage===" + this.j + "newMessage==" + json.toString();
        if (this.j.equals(json.toString())) {
            return;
        }
        String str2 = "msg===" + json.toString();
        if (uf2.v().E(pf2Var)) {
            this.j = json.toString();
        }
    }

    public void i(G010Bean g010Bean) {
        u(new b(g010Bean));
    }

    public void j() {
        kf2 kf2VarM = kf2.m();
        this.a = kf2VarM;
        if (this.i == null) {
            this.i = new a();
        }
        kf2VarM.b(this.i, "/game", true);
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [T, com.wear.bean.server.bean.G020Bean$G020Data] */
    public void k(boolean z) {
        u(new c());
        WearUtils.x.q("vrgame_end", null);
        sz1.d().b(512);
        for (Map.Entry<String, Toy> entry : this.d.g().entrySet()) {
            Toy value = entry.getValue();
            if (value.isConnected() && value.isSupportGame()) {
                this.d.C(entry.getValue());
                this.e.postDelayed(new d(value), 500L);
            }
        }
        if (z) {
            G020Bean g020Bean = new G020Bean();
            ?? g020Data = new G020Bean.G020Data();
            Toy toy = this.b;
            if (toy != null) {
                g020Data.setT(toy.getDeviceId());
            }
            g020Bean.data = g020Data;
            w(g020Bean);
        }
        this.b = null;
        this.c = 0;
        ob2.o().H(0);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.HashMap] */
    public final T011ToyBean m() {
        T011ToyBean t011ToyBean = new T011ToyBean();
        ?? map = new HashMap();
        Iterator<Map.Entry<String, Toy>> it = this.d.g().entrySet().iterator();
        while (it.hasNext()) {
            Toy value = it.next().getValue();
            if (value.isSelect() && value.isSupportGame()) {
                ToyBean toyBean = new ToyBean();
                toyBean.setId(value.getAndUpdateDeviceId());
                toyBean.setFVersion(value.getToyVersion() + "");
                toyBean.setBattery(value.getBattery());
                toyBean.setName(value.getRealType());
                toyBean.setVersion(value.getGenerationVersion());
                toyBean.setStatus(value.getStatus());
                toyBean.setNickName(value.getDefineRename() != null ? value.getDefineRename() : "");
                map.put(value.getAndUpdateDeviceId(), toyBean);
            }
        }
        t011ToyBean.data = map;
        return t011ToyBean;
    }

    public boolean n() {
        return this.c == 1;
    }

    public boolean o(String str, String str2) {
        xe3.a(l, str + " " + str2);
        return false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(xc1 xc1Var) {
        Toy toy;
        if (!n() || TextUtils.isEmpty(xc1Var.a()) || TextUtils.isEmpty(this.f) || (toy = this.b) == null || !toy.getAddress().equals(xc1Var.a()) || !this.b.isConnected()) {
            return;
        }
        this.d.q0(this.b);
        this.e.postDelayed(new e(), 500L);
    }

    @Override // dc.tz1
    public void pauseConnon(int i) {
    }

    public void q(String str, qf2 qf2Var, Object obj) {
        if (!(qf2Var instanceof g)) {
            p(l, "收到SocketIo消息：" + str + " " + obj.toString());
        } else if (!obj.toString().contains(MessageType.H010) && !obj.toString().contains(MessageType.T010)) {
            p(l, "收到WebSocket消息：" + str + " " + obj.toString());
        }
        try {
            df2.a(obj.toString()).handler(str, qf2Var, obj);
        } catch (Exception unused) {
            p(l, "异常");
        }
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [T, com.wear.bean.server.bean.G030Bean$G030Data] */
    public void r(String str, String str2) {
        if (n()) {
            p(l, "玩具信息：" + str + "  ：" + str2);
            pf2 g050Bean = null;
            if (str2.startsWith("BT")) {
                G030Bean g030Bean = new G030Bean();
                ?? g030Data = new G030Bean.G030Data();
                g030Data.setMotion(str2);
                g030Bean.data = g030Data;
                g050Bean = g030Bean;
            } else if (str2.startsWith("MirLife:1")) {
                g050Bean = new G040Bean();
            } else if (str2.startsWith("MirLife:2")) {
                g050Bean = new G050Bean();
            }
            if (g050Bean != null) {
                w(g050Bean);
            }
        }
    }

    @Override // dc.tz1
    public void recovery() {
    }

    public void s() {
        this.f = null;
    }

    @Override // dc.tz1
    public void stop(int i) {
        k(true);
    }

    public void t(String str, qf2 qf2Var) {
        qf2Var.c(str, m());
    }

    public final void u(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            this.e.post(runnable);
        }
    }

    public void v(String str, Object obj) {
        for (Map.Entry<String, qf2> entry : this.g.entrySet()) {
            entry.getValue().c(entry.getKey(), obj);
        }
    }

    public final void w(pf2 pf2Var) {
        if (this.g.size() == 0) {
            h(pf2Var);
            return;
        }
        for (Map.Entry<String, qf2> entry : this.g.entrySet()) {
            if (!entry.getValue().c(entry.getKey(), pf2Var)) {
                h(pf2Var);
            }
        }
    }

    public void x() {
        T011ToyBean t011ToyBeanM = m();
        v(null, t011ToyBeanM);
        h(t011ToyBeanM);
    }

    public void y(s32 s32Var) {
        this.h = s32Var;
    }

    public void z() {
        s();
        k(false);
        E();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NetWorkLocalEvent netWorkLocalEvent) {
        if (TextUtils.isEmpty(this.f)) {
            return;
        }
        if (netWorkLocalEvent.isWifi) {
            this.e.postDelayed(new f(), 1000L);
        } else {
            WearUtils.x.q("vrgame_networkChanged_wifi", null);
        }
    }
}
