package dc;

import dc.cd2;
import java.util.HashMap;
import java.util.Map;
import org.java_websocket.WebSocket;

/* compiled from: ServerManager.java */
/* loaded from: classes3.dex */
public class id2 {
    public cd2 a;
    public Map<WebSocket, String> b;

    /* compiled from: ServerManager.java */
    public static class b {
        public static id2 a = new id2();
    }

    public static id2 a() {
        id2 id2Var;
        synchronized (id2.class) {
            id2Var = b.a;
        }
        return id2Var;
    }

    public void b(cd2.a aVar) {
        cd2 cd2Var = this.a;
        if (cd2Var != null) {
            cd2Var.a(aVar);
        }
    }

    public boolean c(int i) {
        if (i < 0) {
            return false;
        }
        try {
            cd2 cd2Var = new cd2(this, i);
            this.a = cd2Var;
            cd2Var.start();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void d(WebSocket webSocket) {
        if (this.b.containsKey(webSocket)) {
            this.b.get(webSocket);
            this.b.remove(webSocket);
        }
    }

    public void e(String str, WebSocket webSocket) {
        if (str == null && webSocket == null) {
            return;
        }
        this.b.put(webSocket, str);
    }

    public id2() {
        this.a = null;
        this.b = new HashMap();
    }
}
