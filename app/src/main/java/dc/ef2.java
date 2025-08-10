package dc;

import com.koushikdutta.async.http.WebSocket;
import com.koushikdutta.async.http.server.AsyncHttpServerRequest;

/* compiled from: ILocalServerManager.java */
/* loaded from: classes3.dex */
public interface ef2 {

    /* compiled from: ILocalServerManager.java */
    public static class a {
        public WebSocket a;
        public boolean b;
    }

    a a(WebSocket webSocket, AsyncHttpServerRequest asyncHttpServerRequest);

    void b(Exception exc);

    void c(String str, int i);
}
