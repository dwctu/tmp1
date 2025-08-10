package dc;

import dc.la;
import dc.xc;
import java.io.IOException;

/* compiled from: MergePathsParser.java */
/* loaded from: classes.dex */
public class gc {
    public static final xc.a a = xc.a.a("nm", "mm", "hd");

    public static la a(xc xcVar) throws IOException {
        String strC = null;
        la.a aVarForId = null;
        boolean zQ = false;
        while (xcVar.p()) {
            int iO = xcVar.O(a);
            if (iO == 0) {
                strC = xcVar.C();
            } else if (iO == 1) {
                aVarForId = la.a.forId(xcVar.y());
            } else if (iO != 2) {
                xcVar.V();
                xcVar.X();
            } else {
                zQ = xcVar.q();
            }
        }
        return new la(strC, aVarForId, zQ);
    }
}
