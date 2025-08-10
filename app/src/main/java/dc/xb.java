package dc;

import android.graphics.Path;
import dc.xc;
import java.io.IOException;
import java.util.Collections;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: GradientFillParser.java */
/* loaded from: classes.dex */
public class xb {
    public static final xc.a a = xc.a.a("nm", "g", "o", "t", "s", "e", StreamManagement.AckRequest.ELEMENT, "hd");
    public static final xc.a b = xc.a.a("p", "k");

    public static ha a(xc xcVar, f7 f7Var) throws IOException {
        t9 t9VarH = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String strC = null;
        ja jaVar = null;
        s9 s9VarG = null;
        v9 v9VarI = null;
        v9 v9VarI2 = null;
        boolean zQ = false;
        while (xcVar.p()) {
            switch (xcVar.O(a)) {
                case 0:
                    strC = xcVar.C();
                    break;
                case 1:
                    int iY = -1;
                    xcVar.f();
                    while (xcVar.p()) {
                        int iO = xcVar.O(b);
                        if (iO == 0) {
                            iY = xcVar.y();
                        } else if (iO != 1) {
                            xcVar.V();
                            xcVar.X();
                        } else {
                            s9VarG = ob.g(xcVar, f7Var, iY);
                        }
                    }
                    xcVar.m();
                    break;
                case 2:
                    t9VarH = ob.h(xcVar, f7Var);
                    break;
                case 3:
                    jaVar = xcVar.y() == 1 ? ja.LINEAR : ja.RADIAL;
                    break;
                case 4:
                    v9VarI = ob.i(xcVar, f7Var);
                    break;
                case 5:
                    v9VarI2 = ob.i(xcVar, f7Var);
                    break;
                case 6:
                    fillType = xcVar.y() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    zQ = xcVar.q();
                    break;
                default:
                    xcVar.V();
                    xcVar.X();
                    break;
            }
        }
        return new ha(strC, jaVar, fillType, s9VarG, t9VarH == null ? new t9(Collections.singletonList(new id(100))) : t9VarH, v9VarI, v9VarI2, null, null, zQ);
    }
}
