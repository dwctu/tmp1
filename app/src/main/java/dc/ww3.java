package dc;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.koushikdutta.async.http.AsyncHttpRequest;
import dc.ac4;
import dc.pw3;
import dc.uw3;
import dc.yc4;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import no.nordicsemi.android.dfu.DfuBaseService;
import org.greenrobot.eventbus.EventBus;

/* compiled from: PollingXHR.java */
/* loaded from: classes4.dex */
public class ww3 extends vw3 {
    public static final Logger p;
    public static boolean q;

    /* compiled from: PollingXHR.java */
    public class a extends Handler {
        public a(ww3 ww3Var) {
        }

        @Override // java.util.logging.Handler
        public void close() throws SecurityException {
        }

        @Override // java.util.logging.Handler
        public void flush() {
        }

        @Override // java.util.logging.Handler
        public void publish(LogRecord logRecord) {
        }
    }

    /* compiled from: PollingXHR.java */
    public class b implements pw3.a {
        public final /* synthetic */ ww3 a;

        /* compiled from: PollingXHR.java */
        public class a implements Runnable {
            public final /* synthetic */ Object[] a;

            public a(Object[] objArr) {
                this.a = objArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.a.a("responseHeaders", this.a[0]);
            }
        }

        public b(ww3 ww3Var, ww3 ww3Var2) {
            this.a = ww3Var2;
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            jx3.h(new a(objArr));
        }
    }

    /* compiled from: PollingXHR.java */
    public class c implements pw3.a {
        public final /* synthetic */ ww3 a;

        public c(ww3 ww3Var, ww3 ww3Var2) {
            this.a = ww3Var2;
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            this.a.a("requestHeaders", objArr[0]);
        }
    }

    /* compiled from: PollingXHR.java */
    public class d implements pw3.a {
        public final /* synthetic */ Runnable a;

        /* compiled from: PollingXHR.java */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.a.run();
            }
        }

        public d(ww3 ww3Var, Runnable runnable) {
            this.a = runnable;
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            jx3.h(new a());
        }
    }

    /* compiled from: PollingXHR.java */
    public class e implements pw3.a {
        public final /* synthetic */ ww3 a;

        /* compiled from: PollingXHR.java */
        public class a implements Runnable {
            public final /* synthetic */ Object[] a;

            public a(Object[] objArr) {
                this.a = objArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Object[] objArr = this.a;
                ww3.K(e.this.a, "xhr post error", (objArr.length <= 0 || !(objArr[0] instanceof Exception)) ? null : (Exception) objArr[0]);
            }
        }

        public e(ww3 ww3Var, ww3 ww3Var2) {
            this.a = ww3Var2;
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            jx3.h(new a(objArr));
        }
    }

    /* compiled from: PollingXHR.java */
    public class f implements pw3.a {
        public final /* synthetic */ ww3 a;

        /* compiled from: PollingXHR.java */
        public class a implements Runnable {
            public final /* synthetic */ Object[] a;

            public a(Object[] objArr) {
                this.a = objArr;
            }

            @Override // java.lang.Runnable
            public void run() throws NumberFormatException {
                Object[] objArr = this.a;
                Object obj = objArr.length > 0 ? objArr[0] : null;
                if (!(obj instanceof String)) {
                    if (obj instanceof byte[]) {
                        f.this.a.n((byte[]) obj);
                    }
                } else {
                    ej4.a("doPoll() String:" + obj.toString());
                    f.this.a.m((String) obj);
                }
            }
        }

        public f(ww3 ww3Var, ww3 ww3Var2) {
            this.a = ww3Var2;
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            jx3.h(new a(objArr));
        }
    }

    /* compiled from: PollingXHR.java */
    public class g implements pw3.a {
        public final /* synthetic */ ww3 a;

        /* compiled from: PollingXHR.java */
        public class a implements Runnable {
            public final /* synthetic */ Object[] a;

            public a(Object[] objArr) {
                this.a = objArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Object[] objArr = this.a;
                ww3.L(g.this.a, "xhr poll error", (objArr.length <= 0 || !(objArr[0] instanceof Exception)) ? null : (Exception) objArr[0]);
            }
        }

        public g(ww3 ww3Var, ww3 ww3Var2) {
            this.a = ww3Var2;
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            jx3.h(new a(objArr));
        }
    }

    /* compiled from: PollingXHR.java */
    public static class h extends pw3 {
        public static final tc4 h = tc4.d(DfuBaseService.MIME_TYPE_OCTET_STREAM);
        public static final tc4 i = tc4.d("text/plain;charset=UTF-8");
        public String b;
        public String c;
        public Object d;
        public ac4.a e;
        public ad4 f;
        public ac4 g;

        /* compiled from: PollingXHR.java */
        public class a implements bc4 {
            public final /* synthetic */ h a;

            /* compiled from: PollingXHR.java */
            /* renamed from: dc.ww3$h$a$a, reason: collision with other inner class name */
            public class RunnableC0226a implements Runnable {
                public RunnableC0226a(a aVar) {
                }

                @Override // java.lang.Runnable
                public void run() {
                    EventBus.getDefault().post(new bx3());
                }
            }

            public a(h hVar, h hVar2) {
                this.a = hVar2;
            }

            @Override // dc.bc4
            public void onFailure(ac4 ac4Var, IOException iOException) {
                this.a.p(iOException);
            }

            @Override // dc.bc4
            public void onResponse(@NonNull ac4 ac4Var, @NonNull ad4 ad4Var) throws IOException {
                this.a.f = ad4Var;
                this.a.s(ad4Var.q().i());
                try {
                    if (ad4Var.isSuccessful()) {
                        ej4.a("请求成功：okhttp3");
                        this.a.q();
                    } else if (ad4Var.f() != 401 || ad4Var.b() == null) {
                        this.a.p(new IOException(Integer.toString(ad4Var.f())));
                    } else {
                        JSONObject object = JSON.parseObject(ad4Var.b().string());
                        Boolean bool = object.getBoolean("clientTerminate");
                        Integer integer = object.getInteger("clientSleepSeconds");
                        if (!bool.booleanValue()) {
                            new android.os.Handler(Looper.getMainLooper()).postDelayed(new RunnableC0226a(this), integer.intValue() * 1000);
                        }
                    }
                } finally {
                    ej4.a("请求完成：okhttp3");
                    ad4Var.close();
                }
            }
        }

        /* compiled from: PollingXHR.java */
        public static class b {
            public String a;
            public String b;
            public Object c;
            public ac4.a d;
        }

        public h(b bVar) {
            String str = bVar.b;
            this.b = str == null ? "GET" : str;
            this.c = bVar.a;
            this.d = bVar.c;
            ac4.a aVar = bVar.d;
            this.e = aVar == null ? new vc4() : aVar;
        }

        public void m() {
            if (ww3.q) {
                ww3.p.fine(String.format("xhr open %s: %s", this.b, this.c));
            }
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            if ("POST".equals(this.b)) {
                if (this.d instanceof byte[]) {
                    treeMap.put("Content-type", new LinkedList(Collections.singletonList(DfuBaseService.MIME_TYPE_OCTET_STREAM)));
                } else {
                    treeMap.put("Content-type", new LinkedList(Collections.singletonList("text/plain;charset=UTF-8")));
                }
            }
            treeMap.put("Accept", new LinkedList(Collections.singletonList(AsyncHttpRequest.HEADER_ACCEPT_ALL)));
            r(treeMap);
            if (ww3.q) {
                Logger logger = ww3.p;
                Object[] objArr = new Object[2];
                objArr[0] = this.c;
                Object string = this.d;
                if (string instanceof byte[]) {
                    string = Arrays.toString((byte[]) string);
                }
                objArr[1] = string;
                logger.fine(String.format("sending xhr with url %s | data %s", objArr));
            }
            yc4.a aVar = new yc4.a();
            for (Map.Entry<String, List<String>> entry : treeMap.entrySet()) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    aVar.a(entry.getKey(), it.next());
                }
            }
            zc4 zc4VarCreate = null;
            Object obj = this.d;
            if (obj instanceof byte[]) {
                ej4.a("data == byte[]");
                zc4VarCreate = zc4.create(h, (byte[]) this.d);
            } else if (obj instanceof String) {
                ej4.a("data == String");
                zc4VarCreate = zc4.create(i, (String) this.d);
            }
            aVar.l(rc4.s(this.c));
            aVar.g(this.b, zc4VarCreate);
            yc4 yc4VarB = aVar.b();
            StringBuilder sb = new StringBuilder();
            sb.append("开始请求：okhttp3 ");
            sb.append(this.b);
            sb.append(" this.data=");
            Object obj2 = this.d;
            sb.append(obj2 == null ? "null" : obj2.getClass().getSimpleName());
            ej4.a(sb.toString());
            ac4 ac4VarA = this.e.a(yc4VarB);
            this.g = ac4VarA;
            ac4VarA.j(new a(this, this));
        }

        public final void n(String str) {
            a("data", str);
            t();
        }

        public final void o(byte[] bArr) {
            a("data", bArr);
            t();
        }

        public final void p(Exception exc) {
            a("error", exc);
        }

        public final void q() throws Exception {
            bd4 bd4VarB = this.f.b();
            String string = bd4VarB.contentType().toString();
            try {
                ej4.a("onLoad " + string);
                if (DfuBaseService.MIME_TYPE_OCTET_STREAM.equalsIgnoreCase(string)) {
                    o(bd4VarB.bytes());
                } else {
                    String strString = bd4VarB.string();
                    ej4.a("onLoad body:" + strString);
                    n(strString);
                }
            } catch (IOException e) {
                p(e);
            }
        }

        public final void r(Map<String, List<String>> map) {
            a("requestHeaders", map);
        }

        public final void s(Map<String, List<String>> map) {
            a("responseHeaders", map);
        }

        public final void t() {
            a("success", new Object[0]);
        }
    }

    static {
        Logger logger = Logger.getLogger(ww3.class.getName());
        p = logger;
        q = logger.isLoggable(Level.FINE);
    }

    public ww3(uw3.d dVar) throws SecurityException {
        super(dVar);
        Logger logger = p;
        logger.setLevel(Level.FINEST);
        logger.addHandler(new a(this));
    }

    public static /* synthetic */ uw3 K(ww3 ww3Var, String str, Exception exc) {
        ww3Var.o(str, exc);
        return ww3Var;
    }

    public static /* synthetic */ uw3 L(ww3 ww3Var, String str, Exception exc) {
        ww3Var.o(str, exc);
        return ww3Var;
    }

    @Override // dc.vw3
    public void E() {
        p.fine("xhr poll");
        h hVarP = P();
        ej4.a("doPoll() xhr poll:" + hVarP.hashCode());
        hVarP.f("data", new f(this, this));
        hVarP.f("error", new g(this, this));
        hVarP.m();
    }

    @Override // dc.vw3
    public void F(String str, Runnable runnable) {
        O(str, runnable);
    }

    @Override // dc.vw3
    public void G(byte[] bArr, Runnable runnable) {
        O(bArr, runnable);
    }

    public final void O(Object obj, Runnable runnable) {
        h.b bVar = new h.b();
        bVar.b = "POST";
        bVar.c = obj;
        h hVarQ = Q(bVar);
        hVarQ.f("success", new d(this, runnable));
        hVarQ.f("error", new e(this, this));
        hVarQ.m();
    }

    public h P() {
        return Q(null);
    }

    public h Q(h.b bVar) {
        if (bVar == null) {
            bVar = new h.b();
        }
        bVar.a = J();
        bVar.d = this.m;
        h hVar = new h(bVar);
        hVar.f("requestHeaders", new c(this, this));
        hVar.f("responseHeaders", new b(this, this));
        return hVar;
    }
}
