package dc;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.wear.bean.event.NetworkInfoEvent;
import dc.vc4;
import dc.yc4;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: WsManager.java */
/* loaded from: classes3.dex */
public class rk2 {
    public Context a;
    public String b;
    public ed4 c;
    public vc4 d;
    public yc4 e;
    public boolean g;
    public sk2 i;
    public long m;
    public yc4.a p;
    public int f = -1;
    public boolean h = false;
    public Handler k = new Handler(Looper.getMainLooper());
    public int l = 5;
    public Runnable n = new a();
    public fd4 o = new b();
    public Lock j = new ReentrantLock();

    /* compiled from: WsManager.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (rk2.this.i != null) {
                rk2.this.i.g();
            }
            rk2.this.g();
        }
    }

    /* compiled from: WsManager.java */
    public class b extends fd4 {

        /* compiled from: WsManager.java */
        public class a implements Runnable {
            public final /* synthetic */ ad4 a;

            public a(ad4 ad4Var) {
                this.a = ad4Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                rk2.this.i.f(this.a);
            }
        }

        /* compiled from: WsManager.java */
        /* renamed from: dc.rk2$b$b, reason: collision with other inner class name */
        public class RunnableC0213b implements Runnable {
            public final /* synthetic */ qd4 a;

            public RunnableC0213b(qd4 qd4Var) {
                this.a = qd4Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                rk2.this.i.e(this.a);
            }
        }

        /* compiled from: WsManager.java */
        public class c implements Runnable {
            public final /* synthetic */ String a;

            public c(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                rk2.this.i.d(this.a);
            }
        }

        /* compiled from: WsManager.java */
        public class d implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ String b;

            public d(int i, String str) {
                this.a = i;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                rk2.this.i.b(this.a, this.b);
            }
        }

        /* compiled from: WsManager.java */
        public class e implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ String b;

            public e(int i, String str) {
                this.a = i;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                rk2.this.i.a(this.a, this.b);
            }
        }

        /* compiled from: WsManager.java */
        public class f implements Runnable {
            public final /* synthetic */ Throwable a;
            public final /* synthetic */ ad4 b;

            public f(Throwable th, ad4 ad4Var) {
                this.a = th;
                this.b = ad4Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                rk2.this.i.c(this.a, this.b);
            }
        }

        public b() {
        }

        @Override // dc.fd4
        public void a(ed4 ed4Var, int i, String str) {
            rk2.this.r(-2);
            if (rk2.this.i != null) {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    rk2.this.k.post(new e(i, str));
                } else {
                    rk2.this.i.a(i, str);
                }
            }
        }

        @Override // dc.fd4
        public void b(ed4 ed4Var, int i, String str) {
            if (rk2.this.i != null) {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    rk2.this.k.post(new d(i, str));
                } else {
                    rk2.this.i.b(i, str);
                }
            }
        }

        @Override // dc.fd4
        public void c(ed4 ed4Var, Throwable th, ad4 ad4Var) {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("onFailure: ");
            sb.append(th.getMessage());
            if (ad4Var != null) {
                str = "   response:" + ad4Var.f() + " --- " + ad4Var.x();
            } else {
                str = "";
            }
            sb.append(str);
            sb.toString();
            rk2.this.j();
            rk2.this.w();
            if (rk2.this.i != null) {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    rk2.this.k.post(new f(th, ad4Var));
                } else {
                    rk2.this.i.c(th, ad4Var);
                }
            }
        }

        @Override // dc.fd4
        public void d(ed4 ed4Var, String str) {
            if (rk2.this.i != null) {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    rk2.this.k.post(new c(str));
                } else {
                    rk2.this.i.d(str);
                }
            }
        }

        @Override // dc.fd4
        public void e(ed4 ed4Var, qd4 qd4Var) {
            if (rk2.this.i != null) {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    rk2.this.k.post(new RunnableC0213b(qd4Var));
                } else {
                    rk2.this.i.e(qd4Var);
                }
            }
        }

        @Override // dc.fd4
        public void f(ed4 ed4Var, ad4 ad4Var) {
            rk2.this.c = ed4Var;
            rk2.this.r(1);
            rk2.this.i();
            if (rk2.this.i != null) {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    rk2.this.k.post(new a(ad4Var));
                } else {
                    rk2.this.i.f(ad4Var);
                }
            }
        }
    }

    /* compiled from: WsManager.java */
    public static final class c {
        public Context a;
        public String b;
        public boolean c = true;
        public vc4 d;

        public c(Context context) {
            this.a = context;
        }

        public rk2 e() {
            return new rk2(this);
        }

        public c f(vc4 vc4Var) {
            this.d = vc4Var;
            return this;
        }

        public c g(boolean z) {
            this.c = z;
            return this;
        }

        public c h(String str) {
            this.b = str;
            return this;
        }
    }

    public rk2(c cVar) {
        this.a = cVar.a;
        this.b = cVar.b;
        this.g = cVar.c;
        this.d = cVar.d;
    }

    public final synchronized void g() {
        if (!m(this.a)) {
            r(-1);
            return;
        }
        int iK = k();
        if (iK != 0 && iK != 1) {
            r(0);
            l();
        }
    }

    public final void h() {
        this.k.removeCallbacks(this.n);
        this.l = 5;
    }

    public final void i() {
        h();
    }

    public final void j() {
        sk2 sk2Var;
        if (this.f == -1) {
            return;
        }
        String str = "disconnect: \n" + Log.getStackTraceString(new Throwable());
        h();
        vc4 vc4Var = this.d;
        if (vc4Var != null) {
            vc4Var.k().a();
        }
        ed4 ed4Var = this.c;
        if (ed4Var != null && !ed4Var.close(1000, "normal close") && (sk2Var = this.i) != null) {
            sk2Var.a(1001, "abnormal close");
        }
        r(-1);
    }

    public synchronized int k() {
        return this.f;
    }

    public final void l() throws InterruptedException {
        String str = "initWebSocket: \n" + Log.getStackTraceString(new Throwable());
        if (this.d == null) {
            vc4.b bVar = new vc4.b();
            bVar.l(true);
            this.d = bVar.b();
        }
        if (this.e == null) {
            yc4.a aVar = new yc4.a();
            this.p = aVar;
            aVar.k(this.b);
            this.e = aVar.b();
        }
        this.d.k().a();
        try {
            this.j.lockInterruptibly();
            try {
                this.d.b(this.e, this.o);
                this.j.unlock();
            } catch (Throwable th) {
                this.j.unlock();
                throw th;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public final boolean m(Context context) {
        return true;
    }

    public synchronized boolean n() {
        return this.f == 1;
    }

    public void o(String str) {
        String str2 = this.b;
        if (str2 == null || str2.equals(str)) {
            return;
        }
        this.b = str;
        yc4.a aVar = this.p;
        if (aVar != null) {
            aVar.k(str);
        }
        yc4.a aVar2 = this.p;
        aVar2.k(this.b);
        this.e = aVar2.b();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NetworkInfoEvent networkInfoEvent) {
        boolean z = networkInfoEvent.isAvailable;
    }

    public final boolean p(Object obj) {
        ed4 ed4Var = this.c;
        if (ed4Var != null && this.f == 1) {
            if (obj instanceof String) {
                return ed4Var.send((String) obj);
            }
            if (obj instanceof qd4) {
                return ed4Var.send((qd4) obj);
            }
        }
        return false;
    }

    public boolean q(String str) {
        return p(str);
    }

    public synchronized void r(int i) {
        System.out.println("WsManager-----currentStatus的状态-----(" + i + ")");
        this.f = i;
    }

    public void s(sk2 sk2Var) {
        this.i = sk2Var;
    }

    public void t() {
        this.h = false;
        g();
    }

    public void u() {
        sk2 sk2Var;
        String str = "stopAllConnect: \n" + Log.getStackTraceString(new Throwable());
        this.h = true;
        this.l = 5;
        h();
        vc4 vc4Var = this.d;
        if (vc4Var != null) {
            vc4Var.k().a();
        }
        int i = this.f;
        if (i == -1 || i == -2) {
            r(-2);
            return;
        }
        ed4 ed4Var = this.c;
        if (ed4Var != null) {
            boolean zClose = ed4Var.close(1000, "normal close");
            String str2 = "stopAllConnect: isClosed " + zClose;
            if (!zClose && (sk2Var = this.i) != null) {
                sk2Var.a(1001, "abnormal close");
            }
            this.c = null;
        }
        r(-2);
    }

    public void v() {
        this.h = true;
        j();
    }

    public void w() {
        Log.getStackTraceString(new Throwable());
        if ((!this.g) || this.h) {
            return;
        }
        if (!m(this.a)) {
            r(-1);
            return;
        }
        int i = this.f;
        if (i == 1 || i == 0) {
            return;
        }
        r(2);
        if (this.l > 30) {
            this.l = 5;
        }
        if (this.l < 5) {
            this.l = 5;
        }
        long j = this.l * 1000;
        this.k.removeCallbacks(this.n);
        this.k.postDelayed(this.n, Math.min(j, 30000L));
        this.l++;
    }
}
