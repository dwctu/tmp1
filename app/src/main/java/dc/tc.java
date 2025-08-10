package dc;

import dc.ua;
import dc.xc;
import java.io.IOException;

/* compiled from: ShapeTrimPathParser.java */
/* loaded from: classes.dex */
public class tc {
    public static xc.a a = xc.a.a("s", "e", "o", "nm", "m", "hd");

    public static ua a(xc xcVar, f7 f7Var) throws IOException {
        String strC = null;
        ua.a aVarForId = null;
        r9 r9VarF = null;
        r9 r9VarF2 = null;
        r9 r9VarF3 = null;
        boolean zQ = false;
        while (xcVar.p()) {
            int iO = xcVar.O(a);
            if (iO == 0) {
                r9VarF = ob.f(xcVar, f7Var, false);
            } else if (iO == 1) {
                r9VarF2 = ob.f(xcVar, f7Var, false);
            } else if (iO == 2) {
                r9VarF3 = ob.f(xcVar, f7Var, false);
            } else if (iO == 3) {
                strC = xcVar.C();
            } else if (iO == 4) {
                aVarForId = ua.a.forId(xcVar.y());
            } else if (iO != 5) {
                xcVar.X();
            } else {
                zQ = xcVar.q();
            }
        }
        return new ua(strC, aVarForId, r9VarF, r9VarF2, r9VarF3, zQ);
    }
}
