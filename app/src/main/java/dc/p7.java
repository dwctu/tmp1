package dc;

import androidx.collection.ArraySet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: PerformanceTracker.java */
/* loaded from: classes.dex */
public class p7 {
    public boolean a = false;
    public final Set<a> b = new ArraySet();
    public final Map<String, fd> c = new HashMap();

    /* compiled from: PerformanceTracker.java */
    public interface a {
        void a(float f);
    }

    public void a(String str, float f) {
        if (this.a) {
            fd fdVar = this.c.get(str);
            if (fdVar == null) {
                fdVar = new fd();
                this.c.put(str, fdVar);
            }
            fdVar.a(f);
            if (str.equals("__container")) {
                Iterator<a> it = this.b.iterator();
                while (it.hasNext()) {
                    it.next().a(f);
                }
            }
        }
    }

    public void b(boolean z) {
        this.a = z;
    }
}
