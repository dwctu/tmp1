package okhttp3.internal;

import dc.ac4;
import dc.ad4;
import dc.gc4;
import dc.hc4;
import dc.qc4;
import dc.vb4;
import dc.vc4;
import dc.yc4;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealConnectionPool;

/* loaded from: classes5.dex */
public abstract class Internal {
    public static Internal instance;

    public static void initializeInstanceForTests() {
        new vc4();
    }

    public abstract void addLenient(qc4.a aVar, String str);

    public abstract void addLenient(qc4.a aVar, String str, String str2);

    public abstract void apply(hc4 hc4Var, SSLSocket sSLSocket, boolean z);

    public abstract int code(ad4.a aVar);

    public abstract boolean equalsNonHost(vb4 vb4Var, vb4 vb4Var2);

    public abstract Exchange exchange(ad4 ad4Var);

    public abstract void initExchange(ad4.a aVar, Exchange exchange);

    public abstract ac4 newWebSocketCall(vc4 vc4Var, yc4 yc4Var);

    public abstract RealConnectionPool realConnectionPool(gc4 gc4Var);
}
