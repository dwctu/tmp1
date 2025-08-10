package dc;

import dc.xc;
import java.io.IOException;

/* compiled from: RepeaterParser.java */
/* loaded from: classes.dex */
public class mc {
    public static xc.a a = xc.a.a("nm", "c", "o", "tr", "hd");

    public static oa a(xc xcVar, f7 f7Var) throws IOException {
        String strC = null;
        r9 r9VarF = null;
        r9 r9VarF2 = null;
        ba baVarG = null;
        boolean zQ = false;
        while (xcVar.p()) {
            int iO = xcVar.O(a);
            if (iO == 0) {
                strC = xcVar.C();
            } else if (iO == 1) {
                r9VarF = ob.f(xcVar, f7Var, false);
            } else if (iO == 2) {
                r9VarF2 = ob.f(xcVar, f7Var, false);
            } else if (iO == 3) {
                baVarG = nb.g(xcVar, f7Var);
            } else if (iO != 4) {
                xcVar.X();
            } else {
                zQ = xcVar.q();
            }
        }
        return new oa(strC, r9VarF, r9VarF2, baVarG, zQ);
    }
}
