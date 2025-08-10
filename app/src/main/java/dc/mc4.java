package dc;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* compiled from: Dns.java */
/* loaded from: classes5.dex */
public interface mc4 {
    public static final mc4 a = new mc4() { // from class: dc.tb4
        @Override // dc.mc4
        public final List lookup(String str) {
            return lc4.a(str);
        }
    };

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
