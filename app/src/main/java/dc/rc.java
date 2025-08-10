package dc;

import dc.xc;
import java.io.IOException;

/* compiled from: ShapePathParser.java */
/* loaded from: classes.dex */
public class rc {
    public static xc.a a = xc.a.a("nm", "ind", "ks", "hd");

    public static sa a(xc xcVar, f7 f7Var) throws IOException {
        int iY = 0;
        String strC = null;
        x9 x9VarK = null;
        boolean zQ = false;
        while (xcVar.p()) {
            int iO = xcVar.O(a);
            if (iO == 0) {
                strC = xcVar.C();
            } else if (iO == 1) {
                iY = xcVar.y();
            } else if (iO == 2) {
                x9VarK = ob.k(xcVar, f7Var);
            } else if (iO != 3) {
                xcVar.X();
            } else {
                zQ = xcVar.q();
            }
        }
        return new sa(strC, iY, x9VarK, zQ);
    }
}
