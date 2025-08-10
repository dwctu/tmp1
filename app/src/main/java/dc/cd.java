package dc;

import java.util.HashSet;
import java.util.Set;

/* compiled from: LogcatLogger.java */
/* loaded from: classes.dex */
public class cd implements k7 {
    public static final Set<String> a = new HashSet();

    @Override // dc.k7
    public void a(String str) {
        b(str, null);
    }

    @Override // dc.k7
    public void b(String str, Throwable th) {
        Set<String> set = a;
        if (set.contains(str)) {
            return;
        }
        set.add(str);
    }

    public void c(String str, Throwable th) {
        boolean z = e7.a;
    }

    @Override // dc.k7
    public void debug(String str) {
        c(str, null);
    }

    @Override // dc.k7
    public void error(String str, Throwable th) {
        boolean z = e7.a;
    }
}
