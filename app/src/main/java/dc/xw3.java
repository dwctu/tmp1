package dc;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import dc.ax3;
import dc.ed4;
import dc.uw3;
import dc.yc4;
import io.socket.utf8.UTF8Exception;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;

/* compiled from: WebSocket.java */
/* loaded from: classes4.dex */
public class xw3 extends uw3 {
    public static final Logger o = Logger.getLogger(ww3.class.getName());
    public ed4 n;

    /* compiled from: WebSocket.java */
    public class a extends fd4 {
        public final /* synthetic */ xw3 a;

        /* compiled from: WebSocket.java */
        /* renamed from: dc.xw3$a$a, reason: collision with other inner class name */
        public class RunnableC0231a implements Runnable {
            public final /* synthetic */ Map a;

            public RunnableC0231a(Map map) {
                this.a = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                ej4.a("创建成功：webSocket ");
                a.this.a.a("responseHeaders", this.a);
                a.this.a.p();
            }
        }

        /* compiled from: WebSocket.java */
        public class b implements Runnable {
            public final /* synthetic */ String a;

            public b(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                ej4.a("收到：webSocket String数据：" + this.a);
                a.this.a.m(this.a);
            }
        }

        /* compiled from: WebSocket.java */
        public class c implements Runnable {
            public final /* synthetic */ qd4 a;

            public c(qd4 qd4Var) {
                this.a = qd4Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                ej4.a("收到：webSocket bytes数据：");
                a.this.a.n(this.a.w());
            }
        }

        /* compiled from: WebSocket.java */
        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.l();
            }
        }

        /* compiled from: WebSocket.java */
        public class e implements Runnable {
            public e(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                EventBus.getDefault().post(new bx3());
            }
        }

        /* compiled from: WebSocket.java */
        public class f implements Runnable {
            public final /* synthetic */ Throwable a;

            public f(Throwable th) {
                this.a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                xw3.y(a.this.a, "websocket error", (Exception) this.a);
            }
        }

        public a(xw3 xw3Var, xw3 xw3Var2) {
            this.a = xw3Var2;
        }

        @Override // dc.fd4
        public void a(ed4 ed4Var, int i, String str) {
            jx3.h(new d());
        }

        @Override // dc.fd4
        public void c(@NonNull ed4 ed4Var, Throwable th, ad4 ad4Var) {
            if (ad4Var != null && ad4Var.f() == 401 && ad4Var.b() != null) {
                try {
                    JSONObject object = JSON.parseObject(ad4Var.b().string());
                    Boolean bool = object.getBoolean("clientTerminate");
                    Integer integer = object.getInteger("clientSleepSeconds");
                    if (!bool.booleanValue()) {
                        new Handler(Looper.getMainLooper()).postDelayed(new e(this), integer.intValue() * 1000);
                    }
                    ej4.a("onFailure : clientTerminate = " + bool + "& clientSleepSeconds = " + integer);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            if (th instanceof Exception) {
                jx3.h(new f(th));
            }
        }

        @Override // dc.fd4
        public void d(ed4 ed4Var, String str) {
            if (str == null) {
                return;
            }
            jx3.h(new b(str));
        }

        @Override // dc.fd4
        public void e(ed4 ed4Var, qd4 qd4Var) {
            if (qd4Var == null) {
                return;
            }
            jx3.h(new c(qd4Var));
        }

        @Override // dc.fd4
        public void f(ed4 ed4Var, ad4 ad4Var) {
            jx3.h(new RunnableC0231a(ad4Var.q().i()));
        }
    }

    /* compiled from: WebSocket.java */
    public class b implements Runnable {
        public final /* synthetic */ xw3 a;

        /* compiled from: WebSocket.java */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                xw3 xw3Var = b.this.a;
                xw3Var.b = true;
                xw3Var.a("drain", new Object[0]);
            }
        }

        public b(xw3 xw3Var, xw3 xw3Var2) {
            this.a = xw3Var2;
        }

        @Override // java.lang.Runnable
        public void run() {
            jx3.j(new a());
        }
    }

    /* compiled from: WebSocket.java */
    public class c implements ax3.f {
        public final /* synthetic */ xw3 a;
        public final /* synthetic */ int[] b;
        public final /* synthetic */ Runnable c;

        public c(xw3 xw3Var, xw3 xw3Var2, int[] iArr, Runnable runnable) {
            this.a = xw3Var2;
            this.b = iArr;
            this.c = runnable;
        }

        @Override // dc.ax3.f
        public void call(Object obj) {
            try {
                if (obj instanceof String) {
                    this.a.n.send((String) obj);
                } else if (obj instanceof byte[]) {
                    this.a.n.send(qd4.m((byte[]) obj));
                }
            } catch (IllegalStateException unused) {
                xw3.o.fine("websocket closed before we could write");
            }
            int[] iArr = this.b;
            int i = iArr[0] - 1;
            iArr[0] = i;
            if (i == 0) {
                this.c.run();
            }
        }
    }

    public xw3(uw3.d dVar) {
        super(dVar);
        this.c = "websocket";
    }

    public static /* synthetic */ uw3 y(xw3 xw3Var, String str, Exception exc) {
        xw3Var.o(str, exc);
        return xw3Var;
    }

    public String B() {
        String str;
        String str2;
        Map map = this.d;
        if (map == null) {
            map = new HashMap();
        }
        String str3 = this.e ? "wss" : "ws";
        if (this.g <= 0 || ((!"wss".equals(str3) || this.g == 443) && (!"ws".equals(str3) || this.g == 80))) {
            str = "";
        } else {
            str = SignatureImpl.INNER_SEP + this.g;
        }
        if (this.f) {
            map.put(this.j, lx3.b());
        }
        String strB = ex3.b(map);
        if (strB.length() > 0) {
            strB = "?" + strB;
        }
        boolean zContains = this.i.contains(SignatureImpl.INNER_SEP);
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        sb.append("://");
        if (zContains) {
            str2 = "[" + this.i + "]";
        } else {
            str2 = this.i;
        }
        sb.append(str2);
        sb.append(str);
        sb.append(this.h);
        sb.append(strB);
        return sb.toString();
    }

    @Override // dc.uw3
    public void j() {
        ed4 ed4Var = this.n;
        if (ed4Var != null) {
            ed4Var.close(1000, "");
            this.n = null;
        }
    }

    @Override // dc.uw3
    public void k() {
        ej4.a("doOpen websocket");
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        a("requestHeaders", treeMap);
        ed4.a vc4Var = this.l;
        if (vc4Var == null) {
            vc4Var = new vc4();
        }
        yc4.a aVar = new yc4.a();
        aVar.k(B());
        for (Map.Entry entry : treeMap.entrySet()) {
            Iterator it = ((List) entry.getValue()).iterator();
            while (it.hasNext()) {
                aVar.a((String) entry.getKey(), (String) it.next());
            }
        }
        ej4.a("开始创建：webSocket " + B());
        this.n = vc4Var.b(aVar.b(), new a(this, this));
    }

    @Override // dc.uw3
    public void t(zw3[] zw3VarArr) throws UTF8Exception {
        this.b = false;
        b bVar = new b(this, this);
        int[] iArr = {zw3VarArr.length};
        for (zw3 zw3Var : zw3VarArr) {
            uw3.e eVar = this.k;
            if (eVar != uw3.e.OPENING && eVar != uw3.e.OPEN) {
                return;
            }
            ax3.k(zw3Var, new c(this, this, iArr, bVar));
        }
    }
}
