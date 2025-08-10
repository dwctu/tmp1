package dc;

import com.alibaba.fastjson.JSON;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.wear.bean.LocalSocketIoConnectBean;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import javax.net.ssl.X509TrustManager;

/* compiled from: SocketIoLocalClient.java */
/* loaded from: classes3.dex */
public class vf2 implements qf2 {
    public static final String e = "vf2";
    public static String f;
    public LocalSocketIoConnectBean a;
    public volatile nw3 b;
    public Object c;
    public ArrayList<wf2> d;

    /* compiled from: SocketIoLocalClient.java */
    public class a implements X509TrustManager {
    }

    /* compiled from: SocketIoLocalClient.java */
    public class b extends sf2 {
        public b() {
        }

        @Override // dc.of2
        public void a(String str) {
            xe3.b(vf2.e, b.class.getSimpleName(), "ConnectError=" + str);
            HashMap map = new HashMap();
            map.put("error", str);
            map.put(ImagesContract.URL, vf2.f);
            ye3.d("E0019", WearUtils.A.toJson(map));
            vf2.this.j();
        }

        @Override // dc.of2
        public void b(String str) {
        }

        public /* synthetic */ b(vf2 vf2Var, a aVar) {
            this();
        }
    }

    /* compiled from: SocketIoLocalClient.java */
    public class c extends sf2 {
        public c() {
        }

        @Override // dc.of2
        public void a(String str) {
            xe3.b(vf2.e, c.class.getSimpleName(), "连上啦");
            ye3.d("E0017", vf2.f);
            vf2 vf2Var = vf2.this;
            LocalSocketIoConnectBean localSocketIoConnectBean = vf2Var.a;
            vf2Var.k(localSocketIoConnectBean != null ? localSocketIoConnectBean.getC() : "");
        }

        @Override // dc.of2
        public void b(String str) {
        }

        public /* synthetic */ c(vf2 vf2Var, a aVar) {
            this();
        }
    }

    /* compiled from: SocketIoLocalClient.java */
    public class d extends sf2 {
        public d() {
        }

        @Override // dc.of2
        public void a(String str) {
            xe3.b(vf2.e, d.class.getSimpleName(), "断联了" + str);
            HashMap map = new HashMap();
            map.put("error", str);
            map.put(ImagesContract.URL, vf2.f);
            ye3.d("E0018", WearUtils.A.toJson(map));
            vf2.this.m();
        }

        @Override // dc.of2
        public void b(String str) {
        }

        public /* synthetic */ d(vf2 vf2Var, a aVar) {
            this();
        }
    }

    /* compiled from: SocketIoLocalClient.java */
    public class e extends sf2 {
        public e() {
        }

        @Override // dc.of2
        public void a(String str) {
            xe3.b(vf2.e, e.class.getSimpleName(), "Error=" + str);
            vf2.this.m();
        }

        @Override // dc.of2
        public void b(String str) {
        }

        public /* synthetic */ e(vf2 vf2Var, a aVar) {
            this();
        }
    }

    /* compiled from: SocketIoLocalClient.java */
    public static class f {
        public static final vf2 a = new vf2(null);
    }

    public /* synthetic */ vf2(a aVar) {
        this();
    }

    public static vf2 o() {
        return f.a;
    }

    @Override // dc.qf2
    public boolean c(String str, Object obj) {
        synchronized (this.c) {
            if (this.b != null && this.b.A()) {
                Object json = JSON.toJSON(obj);
                xe3.a(e, "发送消息 action=" + str + "   message=" + obj);
                this.b.a(str, json);
                return true;
            }
            if (this.b == null) {
                xe3.a(e, "mSocket=null");
                return false;
            }
            xe3.a(e, "连接断开了");
            return false;
        }
    }

    public void f(String str, sf2 sf2Var) {
        synchronized (this.c) {
            if (this.b != null && !this.b.b(str)) {
                xe3.a(e, str + " " + sf2Var.getClass().getSimpleName());
                this.b.f(str, sf2Var);
            }
        }
    }

    public void g(Hashtable<String, sf2> hashtable) {
        synchronized (this.c) {
            for (String str : hashtable.keySet()) {
                f(str, hashtable.get(str));
            }
        }
    }

    public void h(wf2 wf2Var) {
        synchronized (this.d) {
            if (this.d.contains(wf2Var)) {
                return;
            }
            this.d.add(wf2Var);
        }
    }

    public void i(LocalSocketIoConnectBean localSocketIoConnectBean) {
        synchronized (this.c) {
            if (localSocketIoConnectBean == null) {
                return;
            }
            if (this.b != null && !localSocketIoConnectBean.getU().equals(f)) {
                n();
            }
            if (this.b == null) {
                try {
                    f = localSocketIoConnectBean.getU();
                    this.b = kw3.a(localSocketIoConnectBean.getU());
                    p();
                    xe3.a(e, f + " socketIoPath:" + localSocketIoConnectBean.getU());
                } catch (Exception unused) {
                }
            }
            if (this.b.A()) {
                this.b.C();
            }
            this.a = localSocketIoConnectBean;
            this.b.z();
        }
    }

    public final void j() {
        synchronized (this.d) {
            Iterator<wf2> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().q();
            }
        }
    }

    public final void k(String str) {
        synchronized (this.d) {
            Iterator<wf2> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().a(str);
            }
        }
    }

    public boolean l() {
        synchronized (this.c) {
            if (this.b == null) {
                return false;
            }
            return this.b.A();
        }
    }

    public final void m() {
        synchronized (this.d) {
            Iterator<wf2> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().disConnect();
            }
        }
    }

    public void n() {
        try {
            synchronized (this.c) {
                if (this.b != null) {
                    bc2.r().w();
                    this.b.C();
                    this.b = null;
                }
            }
            bc2.r().w();
        } catch (Exception e2) {
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    public final void p() {
        h(bc2.r());
        a aVar = null;
        this.b.f("connect", new c(this, aVar));
        this.b.f("disconnect", new d(this, aVar));
        this.b.f("connect_error", new b(this, aVar));
        this.b.f("error", new e(this, aVar));
        bc2.r().t();
    }

    public void q(pf2 pf2Var) {
        c(pf2Var.getAction(), pf2Var);
    }

    public vf2() {
        this.c = new Object();
        this.d = new ArrayList<>();
    }
}
