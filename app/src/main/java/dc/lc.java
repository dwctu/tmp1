package dc;

import android.graphics.PointF;
import dc.xc;
import java.io.IOException;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: RectangleShapeParser.java */
/* loaded from: classes.dex */
public class lc {
    public static xc.a a = xc.a.a("nm", "p", "s", StreamManagement.AckRequest.ELEMENT, "hd");

    public static na a(xc xcVar, f7 f7Var) throws IOException {
        String strC = null;
        ca<PointF, PointF> caVarB = null;
        v9 v9VarI = null;
        r9 r9VarE = null;
        boolean zQ = false;
        while (xcVar.p()) {
            int iO = xcVar.O(a);
            if (iO == 0) {
                strC = xcVar.C();
            } else if (iO == 1) {
                caVarB = lb.b(xcVar, f7Var);
            } else if (iO == 2) {
                v9VarI = ob.i(xcVar, f7Var);
            } else if (iO == 3) {
                r9VarE = ob.e(xcVar, f7Var);
            } else if (iO != 4) {
                xcVar.X();
            } else {
                zQ = xcVar.q();
            }
        }
        return new na(strC, caVarB, v9VarI, r9VarE, zQ);
    }
}
