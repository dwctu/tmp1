package dc;

import dc.xc;
import java.io.IOException;

/* compiled from: AnimatableTextPropertiesParser.java */
/* loaded from: classes.dex */
public class mb {
    public static xc.a a = xc.a.a("a");
    public static xc.a b = xc.a.a("fc", "sc", "sw", "t");

    public static aa a(xc xcVar, f7 f7Var) throws IOException {
        xcVar.f();
        aa aaVarB = null;
        while (xcVar.p()) {
            if (xcVar.O(a) != 0) {
                xcVar.V();
                xcVar.X();
            } else {
                aaVarB = b(xcVar, f7Var);
            }
        }
        xcVar.m();
        return aaVarB == null ? new aa(null, null, null, null) : aaVarB;
    }

    public static aa b(xc xcVar, f7 f7Var) throws IOException {
        xcVar.f();
        q9 q9VarC = null;
        q9 q9VarC2 = null;
        r9 r9VarE = null;
        r9 r9VarE2 = null;
        while (xcVar.p()) {
            int iO = xcVar.O(b);
            if (iO == 0) {
                q9VarC = ob.c(xcVar, f7Var);
            } else if (iO == 1) {
                q9VarC2 = ob.c(xcVar, f7Var);
            } else if (iO == 2) {
                r9VarE = ob.e(xcVar, f7Var);
            } else if (iO != 3) {
                xcVar.V();
                xcVar.X();
            } else {
                r9VarE2 = ob.e(xcVar, f7Var);
            }
        }
        xcVar.m();
        return new aa(q9VarC, q9VarC2, r9VarE, r9VarE2);
    }
}
