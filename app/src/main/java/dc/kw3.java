package dc;

import dc.lw3;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: IO.java */
/* loaded from: classes4.dex */
public class kw3 {
    public static final Logger a = Logger.getLogger(kw3.class.getName());
    public static final ConcurrentHashMap<String, lw3> b = new ConcurrentHashMap<>();

    /* compiled from: IO.java */
    public static class a extends lw3.o {
        public boolean A = true;
        public boolean z;
    }

    public static nw3 a(String str) throws URISyntaxException {
        return b(str, null);
    }

    public static nw3 b(String str, a aVar) throws URISyntaxException {
        return c(new URI(str), aVar);
    }

    public static nw3 c(URI uri, a aVar) throws URISyntaxException {
        lw3 lw3Var;
        String str;
        if (aVar == null) {
            aVar = new a();
        }
        URL urlB = ow3.b(uri);
        try {
            URI uri2 = urlB.toURI();
            String strA = ow3.a(urlB);
            String path = urlB.getPath();
            ConcurrentHashMap<String, lw3> concurrentHashMap = b;
            if (aVar.z || !aVar.A || (concurrentHashMap.containsKey(strA) && concurrentHashMap.get(strA).v.containsKey(path))) {
                Logger logger = a;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(String.format("ignoring socket cache for %s", uri2));
                }
                lw3Var = new lw3(uri2, aVar);
            } else {
                if (!concurrentHashMap.containsKey(strA)) {
                    Logger logger2 = a;
                    if (logger2.isLoggable(Level.FINE)) {
                        logger2.fine(String.format("new io instance for %s", uri2));
                    }
                    concurrentHashMap.putIfAbsent(strA, new lw3(uri2, aVar));
                }
                lw3Var = concurrentHashMap.get(strA);
            }
            String query = urlB.getQuery();
            if (query != null && ((str = aVar.p) == null || str.isEmpty())) {
                aVar.p = query;
            }
            return lw3Var.k0(urlB.getPath(), aVar);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
