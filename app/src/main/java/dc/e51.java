package dc;

import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: JuliLogger.java */
/* loaded from: classes2.dex */
public class e51 extends g51 {
    public Logger a;

    public e51(String str) {
        this.a = Logger.getLogger(str);
    }

    @Override // dc.g51
    public void b(String str) {
        this.a.log(Level.FINE, str);
    }
}
