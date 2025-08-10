package dc;

import android.os.Handler;
import android.os.HandlerThread;
import com.alibaba.fastjson.JSON;
import com.koushikdutta.async.AsyncNetworkSocket;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.WebSocket;
import com.koushikdutta.async.http.server.AsyncHttpServer;
import com.koushikdutta.async.http.server.AsyncHttpServerRequest;
import com.koushikdutta.async.http.server.AsyncHttpServerResponse;
import com.koushikdutta.async.http.server.HttpServerRequestCallback;
import com.wear.bean.server.bean.LogBean;
import com.wear.util.WearUtils;
import dc.ef2;
import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: LogManagerImpl.java */
/* loaded from: classes3.dex */
public class h42 {
    public static h42 g;
    public kf2 a;
    public HashMap<String, qf2> b = new HashMap<>();
    public HandlerThread c;
    public Handler d;
    public ef2 e;
    public int f;

    /* compiled from: LogManagerImpl.java */
    public class a implements ef2 {

        /* compiled from: LogManagerImpl.java */
        /* renamed from: dc.h42$a$a, reason: collision with other inner class name */
        public class C0182a implements HttpServerRequestCallback {
            public C0182a(a aVar) {
            }

            @Override // com.koushikdutta.async.http.server.HttpServerRequestCallback
            public void onRequest(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
                try {
                    asyncHttpServerResponse.sendStream(new BufferedInputStream(WearUtils.x.getAssets().open("test.html")), r3.available());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /* compiled from: LogManagerImpl.java */
        public class b implements WebSocket.StringCallback {
            public b(a aVar) {
            }

            @Override // com.koushikdutta.async.http.WebSocket.StringCallback
            public void onStringAvailable(String str) {
            }
        }

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void e(c cVar, Exception exc) {
            h42.this.b.remove(cVar);
        }

        @Override // dc.ef2
        public ef2.a a(WebSocket webSocket, AsyncHttpServerRequest asyncHttpServerRequest) {
            ef2.a aVar = new ef2.a();
            aVar.a = webSocket;
            if (!"/log".equals(asyncHttpServerRequest.getPath())) {
                aVar.b = false;
                return aVar;
            }
            aVar.b = true;
            String hostAddress = ((AsyncNetworkSocket) webSocket.getSocket()).getRemoteAddress().getAddress().getHostAddress();
            qf2 qf2Var = h42.this.b.get(hostAddress);
            if (qf2Var != null) {
                c cVar = (c) qf2Var;
                cVar.a.close();
                h42.this.b.remove(cVar);
            }
            final c cVar2 = new c(webSocket);
            cVar2.c("init", "连上啦");
            webSocket.setClosedCallback(new CompletedCallback() { // from class: dc.g42
                @Override // com.koushikdutta.async.callback.CompletedCallback
                public final void onCompleted(Exception exc) {
                    this.a.e(cVar2, exc);
                }
            });
            webSocket.setStringCallback(new b(this));
            h42.this.b.put(hostAddress, cVar2);
            return aVar;
        }

        @Override // dc.ef2
        public void b(Exception exc) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.ef2
        public void c(String str, int i) {
            h42.this.f = i;
            ((AsyncHttpServer) h42.this.a.f).get("/test/log", new C0182a(this));
        }
    }

    /* compiled from: LogManagerImpl.java */
    public class b implements Runnable {
        public final /* synthetic */ LogBean a;

        public b(LogBean logBean) {
            this.a = logBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Iterator<String> it = h42.this.b.keySet().iterator();
                while (it.hasNext()) {
                    qf2 qf2Var = h42.this.b.get(it.next());
                    LogBean logBean = this.a;
                    qf2Var.c(logBean.tag, logBean);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: LogManagerImpl.java */
    public static class c implements qf2 {
        public WebSocket a;

        public c(WebSocket webSocket) {
            this.a = webSocket;
        }

        @Override // dc.qf2
        public boolean c(String str, Object obj) {
            try {
                WebSocket webSocket = this.a;
                if (webSocket == null || !webSocket.isOpen()) {
                    return false;
                }
                this.a.send(JSON.toJSONString(obj));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public h42() {
        HandlerThread handlerThread = new HandlerThread("下载模式线程");
        this.c = handlerThread;
        handlerThread.start();
        this.d = new Handler(this.c.getLooper());
        kf2 kf2VarM = kf2.m();
        this.a = kf2VarM;
        if (this.e == null) {
            this.e = new a();
        }
        kf2VarM.b(this.e, "/log", true);
    }

    public static h42 c() {
        if (g == null) {
            synchronized (h42.class) {
                if (g == null) {
                    g = new h42();
                }
            }
        }
        return g;
    }

    public final void d(LogBean logBean) {
        this.d.post(new b(logBean));
    }

    public void e(CharSequence charSequence, Object obj) {
        LogBean logBean = new LogBean();
        logBean.context = obj.toString();
        logBean.tag = charSequence.toString();
        d(logBean);
    }
}
