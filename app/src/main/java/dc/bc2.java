package dc;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.fastjson.JSON;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.wear.bean.LocalSocketIoConnectBean;
import com.wear.bean.Toy;
import com.wear.bean.event.PlayerCloseEvent;
import com.wear.bean.event.PlayerQuitEvent;
import com.wear.bean.event.PlayerToySelectEvent;
import com.wear.bean.server.base.MessageType;
import com.wear.bean.server.bean.P012ToyBean;
import com.wear.bean.server.bean.P013Bean;
import com.wear.bean.server.bean.PRetBean;
import com.wear.bean.server.bean.PT011ToyBean;
import com.wear.bean.server.bean.PlayerToyBean;
import com.wear.bean.server.bean.ToyCommandBean;
import com.wear.util.WearUtils;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: PlayerManagerImpl.java */
/* loaded from: classes3.dex */
public class bc2 implements tz1, wf2 {
    public static String i = "SocketIoLocalClient";
    public static bc2 j;
    public pc1 a;
    public Handler b;
    public Toy c;
    public boolean d;
    public int e;
    public b f;
    public Timer g;
    public int h;

    /* compiled from: PlayerManagerImpl.java */
    public class a extends TimerTask {

        /* compiled from: PlayerManagerImpl.java */
        /* renamed from: dc.bc2$a$a, reason: collision with other inner class name */
        public class RunnableC0165a implements Runnable {
            public RunnableC0165a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (bc2.this.h < 2) {
                    bc2.d(bc2.this);
                    HashMap map = new HashMap();
                    map.put("type", MessageType.H010);
                    vf2.o().c("heartbeat", map);
                    bc2.v("发送心跳包，心跳计数器加1:" + bc2.this.h);
                    return;
                }
                bc2.v("发送心跳包两次没有回应，发送退出消息，关闭服务:" + bc2.this.h);
                HashMap map2 = new HashMap();
                map2.put("a", "remote");
                vf2.o().c("quit", map2);
                EventBus.getDefault().post(new PlayerQuitEvent(102));
                bc2.this.l("发送心跳包两次没有回应，发送退出消息，关闭服务: 心跳包无回应次数 = " + bc2.this.h);
                bc2.this.z();
            }
        }

        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            bc2.this.b.post(new RunnableC0165a());
        }
    }

    /* compiled from: PlayerManagerImpl.java */
    public interface b {
        void p();

        void q();
    }

    /* compiled from: PlayerManagerImpl.java */
    public class c extends sf2 {
        public c() {
        }

        @Override // dc.of2
        public void a(String str) {
            bc2.v("收到心跳:" + str + "  把心跳计数器重置为0");
            bc2.this.h = 0;
        }

        @Override // dc.of2
        public void b(String str) {
        }

        public /* synthetic */ c(bc2 bc2Var, a aVar) {
            this();
        }
    }

    /* compiled from: PlayerManagerImpl.java */
    public class d extends sf2 {
        public d() {
        }

        @Override // dc.of2
        public void a(String str) {
            bc2.v("登录数据返回=" + str);
            bc2.this.m(FirebaseAnalytics.Event.LOGIN, 1, str);
            String string = JSON.parseObject(str).getString("ret");
            if (WearUtils.e1(string)) {
                EventBus.getDefault().post(new PlayerCloseEvent(404));
                bc2.this.l("登录返回数据错误：msg = " + str);
                bc2.this.z();
                return;
            }
            if (string.equals("200")) {
                bc2.v("登录回调=" + bc2.this.f);
                bc2.this.u();
                sz1.d().q(512);
                ob2.o().H(0);
                if (bc2.this.f != null) {
                    bc2.this.f.p();
                }
                bc2.this.y();
                return;
            }
            if (string.equals("400")) {
                bc2.this.l("数据解析异常 ：ret = 400, msg = " + str);
                EventBus.getDefault().post(new PlayerCloseEvent(400));
                bc2.this.z();
                return;
            }
            if (string.equals("403")) {
                bc2.this.l("QR码已被扫描。 ：ret = 403, msg = " + str);
                EventBus.getDefault().post(new PlayerCloseEvent(403));
                bc2.this.z();
                return;
            }
            if (string.equals("500")) {
                bc2.this.l("无法识别QR码。 ：ret = 500, msg = " + str);
                EventBus.getDefault().post(new PlayerCloseEvent(500));
                bc2.this.z();
            }
        }

        @Override // dc.of2
        public void b(String str) {
        }

        public /* synthetic */ d(bc2 bc2Var, a aVar) {
            this();
        }
    }

    /* compiled from: PlayerManagerImpl.java */
    public class e extends sf2 {
        public e() {
        }

        @Override // dc.of2
        public void a(String str) {
            String str2 = bc2.i;
            String str3 = "PlayerCancelListener app主动关闭回调: " + str;
            if (WearUtils.e1(JSON.parseObject(str).getString("ret"))) {
                bc2.this.l("播放器主动关闭");
                bc2.this.z();
                EventBus.getDefault().post(new PlayerQuitEvent(101));
            }
        }

        @Override // dc.of2
        public void b(String str) {
        }

        public /* synthetic */ e(bc2 bc2Var, a aVar) {
            this();
        }
    }

    /* compiled from: PlayerManagerImpl.java */
    public class f extends sf2 {
        public f() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.of2
        public void a(String str) {
            T t;
            try {
                P012ToyBean p012ToyBean = (P012ToyBean) JSON.parseObject(str, P012ToyBean.class);
                if (p012ToyBean != null && (t = p012ToyBean.data) != 0) {
                    ToyCommandBean toyCommandBean = (ToyCommandBean) t;
                    Toy toyR = bc2.this.a.R(toyCommandBean.getT());
                    if (toyR == null) {
                        vf2.o().c("toyOpt", new PRetBean(401));
                        return;
                    }
                    if (!toyR.isConnected()) {
                        vf2.o().c("toyOpt", new PRetBean(TypedValues.CycleType.TYPE_VISIBILITY));
                        return;
                    }
                    if (mp1.h()) {
                        HashMap map = new HashMap();
                        map.put(PSOProgramService.VS_Key, Integer.valueOf(toyCommandBean.getV()));
                        map.put("v1", Integer.valueOf(toyCommandBean.getV1()));
                        map.put("v2", Integer.valueOf(toyCommandBean.getV2()));
                        map.put("v3", Integer.valueOf(toyCommandBean.getV3()));
                        map.put(StreamManagement.AckRequest.ELEMENT, Integer.valueOf(toyCommandBean.getR()));
                        map.put("p", Integer.valueOf(toyCommandBean.getP()));
                        rq1.d.p(toyR.getAddress(), map);
                        if (bc2.this.c == null || !bc2.this.c.getAddress().equals(toyR.getAddress())) {
                            bc2.this.c = toyR;
                            EventBus.getDefault().post(new PlayerToySelectEvent(bc2.this.c.getAndUpdateDeviceId(), bc2.this.c.getSimpleName(), bc2.this.c.isConnected()));
                            return;
                        }
                        return;
                    }
                    if (toyCommandBean.getV() != -1) {
                        bc2.this.a.e0(toyR, PSOProgramService.VS_Key, toyCommandBean.getV());
                    }
                    if (toyCommandBean.getR() != -1) {
                        bc2.this.a.e0(toyR, StreamManagement.AckRequest.ELEMENT, toyCommandBean.getR());
                    }
                    if (toyCommandBean.getV1() != -1) {
                        bc2.this.a.e0(toyR, "v1", toyCommandBean.getV1());
                    }
                    if (toyCommandBean.getV2() != -1) {
                        bc2.this.a.e0(toyR, "v2", toyCommandBean.getV2());
                    }
                    if (toyCommandBean.getV3() != -1) {
                        bc2.this.a.e0(toyR, "v3", toyCommandBean.getV3());
                    }
                    if (toyCommandBean.getP() != -1) {
                        bc2.this.a.e0(toyR, "p", toyCommandBean.getP());
                    }
                    if (bc2.this.c == null || !bc2.this.c.getAddress().equals(toyR.getAddress())) {
                        bc2.this.c = toyR;
                        EventBus.getDefault().post(new PlayerToySelectEvent(bc2.this.c.getAndUpdateDeviceId(), bc2.this.c.getSimpleName(), bc2.this.c.isConnected()));
                        return;
                    }
                    return;
                }
                vf2.o().c("toyOpt", new PRetBean(400));
            } catch (Exception e) {
                e.printStackTrace();
                vf2.o().c("toySelect", new PRetBean(400));
            }
        }

        @Override // dc.of2
        public void b(String str) {
        }

        public /* synthetic */ f(bc2 bc2Var, a aVar) {
            this();
        }
    }

    /* compiled from: PlayerManagerImpl.java */
    public class g extends sf2 {
        public g() {
        }

        @Override // dc.of2
        public void a(String str) {
            String str2 = bc2.i;
            String str3 = "ToyMessageListener 发送玩具信息回调: " + str;
            bc2.this.m("toysInfo", 1, str);
            String string = JSON.parseObject(str).getString("type");
            if (WearUtils.e1(string) || !string.equals("P014")) {
                return;
            }
            vf2.o().q(bc2.this.s());
        }

        @Override // dc.of2
        public void b(String str) {
        }

        public /* synthetic */ g(bc2 bc2Var, a aVar) {
            this();
        }
    }

    /* compiled from: PlayerManagerImpl.java */
    public class h extends sf2 {
        public h() {
        }

        @Override // dc.of2
        public void a(String str) {
            try {
                P013Bean p013Bean = (P013Bean) JSON.parseObject(str, P013Bean.class);
                if (p013Bean != null && p013Bean.getData() != null) {
                    if (WearUtils.e1(p013Bean.getData().getToyId())) {
                        bc2.this.c = null;
                        EventBus.getDefault().post(new PlayerToySelectEvent(true));
                        return;
                    }
                    Toy toyR = bc2.this.a.R(p013Bean.getData().getToyId());
                    if (toyR == null) {
                        vf2.o().c("toySelect", new PRetBean(401));
                        return;
                    } else {
                        bc2.this.c = toyR;
                        EventBus.getDefault().post(new PlayerToySelectEvent(p013Bean.getData().getToyId(), toyR.getSimpleName(), toyR.isConnected()));
                        return;
                    }
                }
                vf2.o().c("toySelect", new PRetBean(400));
            } catch (Exception e) {
                e.printStackTrace();
                vf2.o().c("toySelect", new PRetBean(400));
            }
        }

        @Override // dc.of2
        public void b(String str) {
        }

        public /* synthetic */ h(bc2 bc2Var, a aVar) {
            this();
        }
    }

    public bc2() {
        new HashMap();
        this.b = new Handler(Looper.getMainLooper());
        this.d = false;
        this.e = -1;
        this.h = 0;
        sz1.d().n(this);
        EventBus.getDefault().register(this);
        this.a = pc1.a;
    }

    public static /* synthetic */ int d(bc2 bc2Var) {
        int i2 = bc2Var.h;
        bc2Var.h = i2 + 1;
        return i2;
    }

    public static bc2 r() {
        if (j == null) {
            synchronized (bc2.class) {
                if (j == null) {
                    j = new bc2();
                }
            }
        }
        return j;
    }

    public static void v(String str) {
        xe3.a(vf2.e, str);
    }

    @Override // dc.wf2
    public void a(String str) {
        if (this.e == -1) {
            y();
        } else {
            this.e = -1;
            x(str);
        }
    }

    @Override // dc.wf2
    public void disConnect() {
        this.e = -1;
    }

    @Override // dc.tz1
    public int getPriority() {
        return 32;
    }

    public void l(String str) {
        HashMap map = new HashMap();
        map.put("reason", str);
        map.put("type", 1);
        ye3.d("F0028", WearUtils.A.toJson(map));
    }

    public void m(String str, int i2, String str2) {
        HashMap map = new HashMap();
        map.put(Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE, str);
        map.put("type", Integer.valueOf(i2));
        map.put("message", str2);
        ye3.d("F0029", WearUtils.A.toJson(map));
    }

    public void n() {
        this.c = null;
        HashMap map = new HashMap();
        map.put("a", "remote");
        vf2.o().c("quit", map);
        sz1.d().b(32);
        ob2.o().H(0);
        o();
        this.a.u0();
        vf2.o().n();
        disConnect();
    }

    public final void o() {
        this.h = 0;
        Timer timer = this.g;
        if (timer != null) {
            timer.cancel();
            this.g = null;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(xc1 xc1Var) {
        if (TextUtils.isEmpty(xc1Var.a())) {
            return;
        }
        Toy toy = this.c;
        if (toy != null && toy.getAddress().equals(xc1Var.a())) {
            EventBus.getDefault().post(new PlayerToySelectEvent(this.c.getAndUpdateDeviceId(), this.c.getSimpleName(), this.c.isConnected()));
        }
        y();
    }

    public void p(LocalSocketIoConnectBean localSocketIoConnectBean, b bVar) {
        this.e = 0;
        this.c = null;
        this.f = bVar;
        this.d = false;
        vf2.o().i(localSocketIoConnectBean);
    }

    @Override // dc.tz1
    public void pauseConnon(int i2) {
    }

    @Override // dc.wf2
    public void q() {
        int i2 = this.e;
        if (i2 == -1) {
            return;
        }
        int i3 = i2 + 1;
        this.e = i3;
        if (i3 <= 2 || this.f == null) {
            return;
        }
        l("两次以上连接失败: 连接次数次数 = " + this.e);
        z();
        this.f.q();
    }

    @Override // dc.tz1
    public void recovery() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object, java.util.HashMap] */
    public final PT011ToyBean s() {
        PT011ToyBean pT011ToyBean = new PT011ToyBean();
        ?? map = new HashMap();
        Iterator<Map.Entry<String, Toy>> it = this.a.g().entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Toy value = it.next().getValue();
            if (value.isSelect()) {
                PlayerToyBean playerToyBean = new PlayerToyBean();
                playerToyBean.setId(value.getAndUpdateDeviceId());
                playerToyBean.setFVersion(value.getToyVersion() + "");
                playerToyBean.setBattery(value.getBattery());
                playerToyBean.setName(value.getRealType());
                playerToyBean.setVersion(value.getGenerationVersion());
                playerToyBean.setStatus(value.getStatus() == 1 ? 1 : 0);
                playerToyBean.setNickName(value.getDefineRename() != null ? value.getDefineRename() : "");
                map.put(value.getAndUpdateDeviceId(), playerToyBean);
            }
        }
        pT011ToyBean.data = map;
        if (!this.d) {
            this.d = true;
            m("toysInfo", 0, WearUtils.A.toJson((Object) map));
        }
        return pT011ToyBean;
    }

    @Override // dc.tz1
    public void stop(int i2) {
    }

    public void t() {
        Hashtable<String, sf2> hashtable = new Hashtable<>();
        a aVar = null;
        hashtable.put(FirebaseAnalytics.Event.LOGIN, new d(this, aVar));
        hashtable.put("toysInfo", new g(this, aVar));
        hashtable.put("quit", new e(this, aVar));
        hashtable.put("toyOpt", new f(this, aVar));
        hashtable.put("toySelect", new h(this, aVar));
        hashtable.put("heartbeat", new c(this, aVar));
        vf2.o().g(hashtable);
    }

    public final void u() {
        Timer timer = this.g;
        if (timer != null) {
            timer.cancel();
            this.g = null;
        }
        this.h = 0;
        Timer timer2 = new Timer();
        this.g = timer2;
        timer2.schedule(new a(), 1000L, 5000L);
    }

    public void w() {
        this.b.removeCallbacksAndMessages(null);
    }

    public void x(String str) {
        HashMap map = new HashMap();
        map.put("a", StreamManagement.AckRequest.ELEMENT);
        map.put("f", Boolean.TRUE);
        map.put("c", str);
        m(FirebaseAnalytics.Event.LOGIN, 0, WearUtils.A.toJson(map));
        vf2.o().c(FirebaseAnalytics.Event.LOGIN, map);
    }

    public void y() {
        vf2.o().q(s());
    }

    public void z() {
        o();
        this.c = null;
        sz1.d().b(32);
        ob2.o().H(0);
        this.a.u0();
        vf2.o().n();
        disConnect();
    }
}
