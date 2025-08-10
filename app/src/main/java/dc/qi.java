package dc;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Jobs.java */
/* loaded from: classes.dex */
public final class qi {
    public final Map<xg, ki<?>> a = new HashMap();
    public final Map<xg, ki<?>> b = new HashMap();

    public ki<?> a(xg xgVar, boolean z) {
        return b(z).get(xgVar);
    }

    public final Map<xg, ki<?>> b(boolean z) {
        return z ? this.b : this.a;
    }

    public void c(xg xgVar, ki<?> kiVar) {
        b(kiVar.p()).put(xgVar, kiVar);
    }

    public void d(xg xgVar, ki<?> kiVar) {
        Map<xg, ki<?>> mapB = b(kiVar.p());
        if (kiVar.equals(mapB.get(xgVar))) {
            mapB.remove(xgVar);
        }
    }
}
