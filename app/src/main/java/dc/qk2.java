package dc;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lovense.wear.R;
import com.wear.activity.discord.DiscordEvent;
import com.wear.bean.ActivityToyProtocol;
import com.wear.bean.B64Common;
import com.wear.bean.ChooseToyByControlHandler;
import com.wear.bean.LanApiControlEvent;
import com.wear.bean.ScanQRDataBean;
import com.wear.bean.SyncWsProtocol;
import com.wear.bean.Toy;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.longDistance.controllink.ControlLinkActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.rk2;
import dc.vc4;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;

/* compiled from: WebSocketClient.java */
/* loaded from: classes3.dex */
public class qk2 {
    public j b;
    public h f;
    public i g;
    public rk2 h;
    public Context k;
    public g m;
    public Handler n;
    public Timer a = null;
    public boolean c = false;
    public boolean d = true;
    public Runnable e = new a(this);
    public boolean i = true;
    public sk2 j = new b();
    public Object l = null;

    /* compiled from: WebSocketClient.java */
    public class a implements Runnable {
        public a(qk2 qk2Var) {
        }

        @Override // java.lang.Runnable
        public void run() {
            db2.A().J();
        }
    }

    /* compiled from: WebSocketClient.java */
    public class b extends sk2 {

        /* compiled from: WebSocketClient.java */
        public class a extends TimerTask {
            public a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (qk2.this.h == null || jCurrentTimeMillis - qk2.this.h.m <= SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US || qk2.this.i) {
                    return;
                }
                qk2.this.h.r(-1);
            }
        }

        /* compiled from: WebSocketClient.java */
        /* renamed from: dc.qk2$b$b, reason: collision with other inner class name */
        public class RunnableC0209b implements Runnable {
            public final /* synthetic */ String a;

            /* compiled from: WebSocketClient.java */
            /* renamed from: dc.qk2$b$b$a */
            public class a implements Runnable {
                public final /* synthetic */ HashMap a;

                public a(RunnableC0209b runnableC0209b, HashMap map) {
                    this.a = map;
                }

                @Override // java.lang.Runnable
                public void run() {
                    MyApplication myApplication = WearUtils.x;
                    sg3.k(MyApplication.H(), this.a.get("reason").toString());
                }
            }

            public RunnableC0209b(b bVar, String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    HashMap map = (HashMap) WearUtils.A.fromJson(this.a, HashMap.class);
                    if (map == null || map.get("reason") == null || WearUtils.e1(map.get("reason").toString())) {
                        return;
                    }
                    MyApplication myApplication = WearUtils.x;
                    if (MyApplication.H() != null) {
                        MyApplication myApplication2 = WearUtils.x;
                        MyApplication.H().runOnUiThread(new a(this, map));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public b() {
        }

        @Override // dc.sk2
        public void a(int i, String str) {
            System.out.println("WsManager-----onClosed 服务器连接已关闭code=" + i + "  reason=" + str);
            if (qk2.this.m != null) {
                qk2.this.m.a();
            }
            if (i == 1000) {
                if (qk2.this.h != null) {
                    qk2.this.h.h = true;
                }
                WearUtils.x.G().W(0);
                WearUtils.x.G().u0();
                WearUtils.x.l.postDelayed(new RunnableC0209b(this, str), 100L);
            }
        }

        @Override // dc.sk2
        public void b(int i, String str) {
            System.out.println("WsManager-----onClosing 服务器连接关闭中...code=" + i + "  reason=" + str);
            if (i != 1000 || qk2.this.h == null) {
                return;
            }
            qk2.this.h.h = true;
            qk2.this.h.v();
        }

        @Override // dc.sk2
        public void c(Throwable th, ad4 ad4Var) {
            String string;
            String string2;
            PrintStream printStream = System.out;
            string = "null";
            if (("WsManager-----onFailure 服务器连接失败t=" + th) == null) {
                string2 = "null";
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(th.getMessage());
                sb.append("  response=");
                sb.append(ad4Var == null ? "null" : ad4Var.x());
                string2 = sb.toString();
            }
            printStream.println(string2);
            if (th != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(th.getMessage());
                sb2.append("  response=");
                sb2.append(ad4Var != null ? ad4Var.x() : "null");
                string = sb2.toString();
            }
            ye3.d("E0010", string);
            h hVar = qk2.this.f;
            if (hVar != null) {
                hVar.a();
                qk2.this.f = null;
            }
        }

        @Override // dc.sk2
        public void d(String str) {
            System.out.println("WsManager-----onMessage.txt=" + str);
            Integer numA = pk2.a(str);
            if (numA != null) {
                pk2.d(numA.intValue(), str);
            } else {
                h(str);
            }
        }

        @Override // dc.sk2
        public void e(qd4 qd4Var) {
            System.out.println("WsManager-----onMessage.bytes=" + qd4Var);
            if (qk2.this.m != null) {
                qk2.this.m.b(qd4Var.w());
            }
        }

        @Override // dc.sk2
        public void f(ad4 ad4Var) {
            i iVar = qk2.this.g;
            if (iVar != null) {
                iVar.b();
            }
            h hVar = qk2.this.f;
            if (hVar != null) {
                hVar.b();
                qk2.this.f = null;
            }
            if (qk2.this.h == null) {
                return;
            }
            qk2.this.h.h = false;
            System.out.println("WsManager-----onOpen 服务器连接成功");
            ye3.d("E0009", db2.A().B());
            qk2.this.k();
            if (qk2.this.l != null) {
                qk2 qk2Var = qk2.this;
                qk2Var.t(new SyncWsProtocol(SyncWsProtocol.CONTROL_118_TYPE_CODE_LAN_API_CREATE_WS, qk2Var.l));
                qk2.this.l = null;
            } else {
                qk2 qk2Var2 = qk2.this;
                if (qk2Var2.c && qk2Var2.d) {
                    qk2Var2.d = false;
                }
            }
            if (ff2.f) {
                ff2.f = false;
                qk2.this.s(SyncWsProtocol.LAN_API_BIND_NOTICE);
            }
            qk2 qk2Var3 = qk2.this;
            if (qk2Var3.c && qk2Var3.d) {
                qk2Var3.d = false;
            }
            WearUtils.x.l.removeCallbacks(qk2Var3.e);
            WearUtils.x.l.postDelayed(qk2.this.e, 6000L);
            j jVar = qk2.this.b;
            if (jVar != null) {
                jVar.open();
                qk2.this.b = null;
            }
            Timer timer = qk2.this.a;
            if (timer != null) {
                timer.cancel();
                qk2.this.a = null;
            }
            qk2.this.a = new Timer();
            qk2.this.a.schedule(new a(), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US);
        }

        @Override // dc.sk2
        public void g() {
            System.out.println("WsManager-----onReconnect 服务器重连接中...");
        }

        public final void h(String str) {
            Toy toyR;
            try {
                SyncWsProtocol syncWsProtocol = (SyncWsProtocol) WearUtils.A.fromJson(str, SyncWsProtocol.class);
                if (syncWsProtocol != null) {
                    if (syncWsProtocol.getType().equals(SyncWsProtocol.CONTROL_106_TYPE_KEY)) {
                        db2.A().L(syncWsProtocol);
                    } else if (syncWsProtocol.getType().equals(SyncWsProtocol.CONTROL_107_TYPE_KEY)) {
                        db2.A().d = syncWsProtocol.getSid();
                    } else if (syncWsProtocol.getType().equals(SyncWsProtocol.CONTROL_116_TYPE_CODE_STATE_CHOOSE_TOY)) {
                        EventBus.getDefault().post(new ChooseToyByControlHandler(null));
                    } else if (!syncWsProtocol.getType().equals(SyncWsProtocol.CONTROL_117_TYPE_CODE_STATE_CANCEL_SYNC)) {
                        if (syncWsProtocol.getType().equals(SyncWsProtocol.CONTROL_108_TYPE_KEY)) {
                            db2.A().g = null;
                            db2.A();
                            db2.F = false;
                            db2.A().d = "";
                            qf3.c = "";
                            eg3.m(WearUtils.x, "choose_control_toy_id");
                            db2.A().J();
                        } else if (syncWsProtocol.getType().equals(SyncWsProtocol.CONTROL_TIME_LEFT_TYPE_KEY) || syncWsProtocol.getType().equals(SyncWsProtocol.CONTROL_BEGIN_TYPE_KEY)) {
                            db2.A().L(syncWsProtocol);
                        } else if (syncWsProtocol.getType().equals(SyncWsProtocol.CONTROL_SYNC_TYPE_KEY)) {
                            SyncWsProtocol.DataBean data = syncWsProtocol.getData();
                            if (!data.getType().equals(SyncWsProtocol.CONTROL_ORDER_TOY_TYPE_KEY) || WearUtils.e1(data.getData())) {
                                if (!data.getType().equals(SyncWsProtocol.CONTROL_SYNC_TOY_TYPE_KEY) || WearUtils.e1(data.getData())) {
                                    if (!data.getType().equals(SyncWsProtocol.CONTROL_ENDSYNC_TOY_TYPE_KEY)) {
                                        if (data.getType().equals(SyncWsProtocol.CONTROL_STARTSYNC_TOY_TYPE_KEY)) {
                                            if (!db2.A().b.l()) {
                                                db2.A().b.j(true);
                                            }
                                            db2.A();
                                            db2.F = true;
                                            qk2.this.t(new SyncWsProtocol(SyncWsProtocol.CONTROL_STARTSYNC_JOIN_TYPE_KEY));
                                            WearUtils.x.G().P().size();
                                            if (!WearUtils.e1(data.getT())) {
                                                WearUtils.x.G().u0();
                                                db2.A().g = data.getT();
                                            }
                                        } else if (data.getType().equals("command") && !WearUtils.e1(data.getData())) {
                                            qf3.c = data.getData();
                                            if (!qf3.a) {
                                                qk2.q(data.getData(), 0);
                                            }
                                        } else if (!data.getType().equals(SyncWsProtocol.CONTROL_ACTIVITY_COMMAND_TYPE_KEY) || WearUtils.e1(data.getData())) {
                                            if (data.getType().equals(SyncWsProtocol.CONTROL_LAN_API_COMMAND) && !WearUtils.e1(data.getData())) {
                                                xe3.a("newCommand", "command 收到服务器转发 101 指令: " + data.getData());
                                                h32.i().e("C0016", data.getData(), "");
                                                int iT = ff2.n().t(data.getData(), null, null);
                                                if (iT != 200) {
                                                    xe3.a("newCommand", "错误：code= " + iT + "  msg=" + ff2.g.get(Integer.valueOf(iT)));
                                                }
                                            } else if (data.getType().equals(SyncWsProtocol.CONTROL_ACTIVITY_STOP_DISCORD)) {
                                                EventBus.getDefault().post(new DiscordEvent(DiscordEvent.TYPE_ACTIVITY_OVER));
                                            }
                                        }
                                    }
                                } else if (WearUtils.e1(db2.A().g)) {
                                    EventBus.getDefault().post(new ControlLinkActivity.l(syncWsProtocol.getSid(), data.getData(), data.getT()));
                                } else {
                                    EventBus.getDefault().post(new ControlLinkActivity.l(syncWsProtocol.getSid(), data.getData(), db2.A().g));
                                }
                            } else if (WearUtils.e1(data.getT()) || WearUtils.e1(syncWsProtocol.getSid())) {
                                Toy toyR2 = WearUtils.x.G().R(data.getT());
                                if (toyR2 != null) {
                                    WearUtils.x.G().e(toyR2.getAddress(), data.getData());
                                } else {
                                    if (!WearUtils.e1(db2.A().g) && (toyR = WearUtils.x.G().R(db2.A().g)) != null) {
                                        WearUtils.x.G().e(toyR.getAddress(), data.getData());
                                        return;
                                    }
                                    Toy toyN = WearUtils.x.G().N();
                                    if (!WearUtils.e1(db2.A().h)) {
                                        toyN = WearUtils.x.G().R(db2.A().h);
                                    }
                                    if (toyN != null) {
                                        WearUtils.x.G().e(toyN.getAddress(), data.getData());
                                    }
                                }
                            } else {
                                EventBus.getDefault().post(new ControlLinkActivity.l(syncWsProtocol.getSid(), data.getData(), data.getT()));
                            }
                        } else if (syncWsProtocol.getType().equals(SyncWsProtocol.CONTROL_ACTIVITY_TOY_NUM_TYPE_KEY)) {
                            ActivityToyProtocol activityToyProtocol = new ActivityToyProtocol();
                            activityToyProtocol.setType(SyncWsProtocol.CONTROL_ACTIVITY_TOY_NUM_TYPE_KEY);
                            activityToyProtocol.setFrom(db2.A().c);
                            activityToyProtocol.setData(new ActivityToyProtocol.DataBean(WearUtils.x.G().P().size()));
                            qk2.this.v(WearUtils.A.toJson(activityToyProtocol));
                        } else if (syncWsProtocol.getType().equals(SyncWsProtocol.CONTROL_JUMP_TYPE_KEY)) {
                            if (qk2.this.h != null) {
                                qk2.this.i = true;
                                qk2.this.h.m = System.currentTimeMillis();
                            }
                        } else if (SyncWsProtocol.CONTROL_LAN_API_OFFLINE.equalsIgnoreCase(syncWsProtocol.getType())) {
                            db2.A().b.s(SyncWsProtocol.LAN_API_UN_BIND_NOTICE);
                            DaoUtils.getTestValueDao().delete(zt3.k, TestValueDao.LAN_API_DATA_TYPE);
                            ff2.d = false;
                            ff2.f = false;
                            ff2.e = false;
                            ff2.n().C();
                            MyApplication.G.send3dxConnectStop();
                            MyApplication.G.onCancelReportToService();
                            MyApplication.G = null;
                            db2.A().s();
                            EventBus.getDefault().post(new LanApiControlEvent(false));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (qk2.this.m != null) {
                qk2.this.m.c(str);
            }
        }
    }

    /* compiled from: WebSocketClient.java */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what == 103) {
                if (!qk2.this.l()) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (qk2.this.h != null && jCurrentTimeMillis - qk2.this.h.m > 10000) {
                        qk2.this.h.m = jCurrentTimeMillis;
                        qk2.this.A();
                    }
                } else if (db2.A().l) {
                    qk2.this.t(new SyncWsProtocol(SyncWsProtocol.CONTROL_JUMP_TYPE_KEY));
                }
                qk2.this.r();
            }
        }
    }

    /* compiled from: WebSocketClient.java */
    public class d implements Runnable {
        public final /* synthetic */ boolean a;

        /* compiled from: WebSocketClient.java */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MyApplication myApplication = WearUtils.x;
                sg3.i(MyApplication.H(), d.this.a ? R.string.control_link_startsuccess : R.string.control_link_nonsupport);
            }
        }

        public d(qk2 qk2Var, boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            MyApplication myApplication = WearUtils.x;
            if (MyApplication.H() != null) {
                MyApplication myApplication2 = WearUtils.x;
                MyApplication.H().runOnUiThread(new a());
            }
        }
    }

    /* compiled from: WebSocketClient.java */
    public class e implements Runnable {
        public final /* synthetic */ SyncWsProtocol a;

        public e(SyncWsProtocol syncWsProtocol) {
            this.a = syncWsProtocol;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (qk2.this.u(WearUtils.A.toJson(this.a)) && SyncWsProtocol.CONTROL_JUMP_TYPE_KEY.equals(this.a.getType())) {
                qk2.this.i = false;
            }
        }
    }

    /* compiled from: WebSocketClient.java */
    public class f implements Runnable {
        public final /* synthetic */ String a;

        public f(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            qk2.this.u(this.a);
        }
    }

    /* compiled from: WebSocketClient.java */
    public interface g {
        void a();

        void b(byte[] bArr);

        void c(String str);
    }

    /* compiled from: WebSocketClient.java */
    public interface h {
        void a();

        void b();
    }

    /* compiled from: WebSocketClient.java */
    public interface i {
        void b();
    }

    /* compiled from: WebSocketClient.java */
    public interface j {
        void open();
    }

    public qk2(Context context) {
        this.k = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n() {
        this.n.sendEmptyMessage(103);
    }

    public static void q(String str, int i2) {
        System.out.println("WsManager-----onMessage.command=" + str);
        B64Common b64Common = (B64Common) WearUtils.A.fromJson(str, B64Common.class);
        if (b64Common == null || WearUtils.e1(b64Common.getCate())) {
            return;
        }
        if (!b64Common.getCate().equals(TtmlNode.ATTR_ID)) {
            if (!b64Common.getCate().equals(TtmlNode.COMBINE_ALL) || b64Common.getAll() == null) {
                return;
            }
            b64Common.getAll().sendCommand(WearUtils.x, i2);
            return;
        }
        HashMap<String, B64Common.IdBean> id = b64Common.getId();
        if (id != null) {
            for (Map.Entry<String, B64Common.IdBean> entry : id.entrySet()) {
                Toy toyR = WearUtils.x.G().R(entry.getKey());
                if (toyR != null) {
                    entry.getValue().sendCommand(WearUtils.x, toyR, i2);
                }
            }
        }
    }

    public void A() {
        rk2 rk2Var = this.h;
        if (rk2Var != null) {
            rk2Var.l = 0;
            rk2Var.w();
        }
    }

    public void i(String str, h hVar) {
        this.f = hVar;
        rk2 rk2Var = this.h;
        if (rk2Var != null) {
            rk2Var.o(str);
        }
        if (this.h == null) {
            rk2.c cVar = new rk2.c(this.k);
            vc4.b bVarT = new vc4().t();
            bVarT.i(15L, TimeUnit.SECONDS);
            bVarT.l(true);
            cVar.f(bVarT.b());
            cVar.g(true);
            cVar.h(str);
            rk2 rk2VarE = cVar.e();
            this.h = rk2VarE;
            rk2VarE.s(this.j);
            this.h.t();
            return;
        }
        if (l()) {
            h hVar2 = this.f;
            if (hVar2 != null) {
                hVar2.b();
                this.f = null;
                return;
            }
            return;
        }
        rk2 rk2Var2 = this.h;
        if (rk2Var2.h) {
            rk2Var2.t();
        } else {
            if (l()) {
                return;
            }
            A();
        }
    }

    public void j(boolean z) {
        String strB = db2.A().B();
        if (TextUtils.isEmpty(strB)) {
            pj3.v(MyApplication.H(), LoginActivity.class);
            MyApplication.H().finish();
            return;
        }
        this.c = z;
        rk2 rk2Var = this.h;
        if (rk2Var != null) {
            rk2Var.o(strB);
        }
        if (z) {
            rk2 rk2Var2 = this.h;
            if (rk2Var2 != null) {
                rk2Var2.v();
                this.h = null;
            }
            if (l()) {
                w();
            } else {
                this.d = true;
            }
        }
        rk2 rk2Var3 = this.h;
        if (rk2Var3 != null) {
            if (rk2Var3.h) {
                rk2Var3.t();
                return;
            } else {
                if (l()) {
                    return;
                }
                A();
                return;
            }
        }
        if (rk2Var3 != null) {
            EventBus.getDefault().unregister(this.h);
        }
        rk2.c cVar = new rk2.c(this.k);
        vc4.b bVarT = new vc4().t();
        bVarT.i(15L, TimeUnit.SECONDS);
        bVarT.l(true);
        cVar.f(bVarT.b());
        cVar.g(true);
        cVar.h(strB);
        rk2 rk2VarE = cVar.e();
        this.h = rk2VarE;
        rk2VarE.s(this.j);
        this.h.t();
        try {
            EventBus.getDefault().register(this.h);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void k() {
        z();
        x();
        r();
    }

    public boolean l() {
        rk2 rk2Var = this.h;
        return rk2Var != null && rk2Var.n();
    }

    public void o() {
        if (this.h == null || l() || this.h.k() == -2) {
            return;
        }
        rk2 rk2Var = this.h;
        rk2Var.l = 5;
        rk2Var.w();
    }

    public void p() {
        if (this.h != null) {
            EventBus.getDefault().unregister(this.h);
            this.h.v();
            this.h = null;
        }
        z();
        Timer timer = this.a;
        if (timer != null) {
            timer.cancel();
            this.a = null;
        }
    }

    public final void r() {
        Handler handler = this.n;
        if (handler == null) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: dc.ok2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.n();
            }
        }, 5000L);
    }

    public void s(String str) {
        HashMap map = new HashMap();
        map.put("type", str);
        HashMap map2 = new HashMap();
        ScanQRDataBean scanQRDataBean = MyApplication.G;
        map2.put("platform", scanQRDataBean == null ? "" : scanQRDataBean.getPlatform());
        ScanQRDataBean scanQRDataBean2 = MyApplication.G;
        map2.put("userId", scanQRDataBean2 != null ? scanQRDataBean2.getUid() : "");
        map.put("data", map2);
        String json = WearUtils.A.toJson(map);
        String str2 = "sendScanLoginMsg: " + json;
        if (l()) {
            u(json);
        }
    }

    public void t(SyncWsProtocol syncWsProtocol) {
        vg3.b().a(new e(syncWsProtocol));
    }

    public boolean u(String str) {
        rk2 rk2Var = this.h;
        if (rk2Var == null || !rk2Var.n()) {
            System.out.println("WsManager-----请先连接服务器 ");
            return false;
        }
        System.out.println("WsManager-----send " + str);
        boolean zQ = this.h.q(str);
        if (zQ) {
            System.out.println("WsManager-----sendSuccess ");
            return zQ;
        }
        System.out.println("WsManager-----sendError ");
        return zQ;
    }

    public void v(String str) {
        vg3.b().a(new f(str));
    }

    public final void w() {
        boolean z;
        t(new SyncWsProtocol(SyncWsProtocol.CONTROL_SCAN_STARTSYNC_JOIN_C_TYPE_KEY));
        t(new SyncWsProtocol((String) null, (String) null).typeStartsync());
        Iterator<Toy> it = WearUtils.x.G().o().iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Toy next = it.next();
            if (next.isConnected() && (next.getType().toLowerCase().equals("nora".toLowerCase()) || next.getType().toLowerCase().equals("max".toLowerCase()))) {
                break;
            }
        }
        WearUtils.x.l.postDelayed(new d(this, z), 30L);
    }

    public final void x() {
        this.n = new c(Looper.getMainLooper());
    }

    public void y() {
        z();
        rk2 rk2Var = this.h;
        if (rk2Var != null) {
            rk2Var.u();
            this.h = null;
        }
    }

    public final void z() {
        Handler handler = this.n;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.n = null;
        }
    }
}
