package dc;

import android.graphics.Path;
import dc.xc;
import java.io.IOException;
import java.util.Collections;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: ShapeFillParser.java */
/* loaded from: classes.dex */
public class pc {
    public static final xc.a a = xc.a.a("nm", "c", "o", "fillEnabled", StreamManagement.AckRequest.ELEMENT, "hd");

    public static qa a(xc xcVar, f7 f7Var) throws IOException {
        t9 t9VarH = null;
        String strC = null;
        q9 q9VarC = null;
        int iY = 1;
        boolean zQ = false;
        boolean zQ2 = false;
        while (xcVar.p()) {
            int iO = xcVar.O(a);
            if (iO == 0) {
                strC = xcVar.C();
            } else if (iO == 1) {
                q9VarC = ob.c(xcVar, f7Var);
            } else if (iO == 2) {
                t9VarH = ob.h(xcVar, f7Var);
            } else if (iO == 3) {
                zQ = xcVar.q();
            } else if (iO == 4) {
                iY = xcVar.y();
            } else if (iO != 5) {
                xcVar.V();
                xcVar.X();
            } else {
                zQ2 = xcVar.q();
            }
        }
        return new qa(strC, zQ, iY == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, q9VarC, t9VarH == null ? new t9(Collections.singletonList(new id(100))) : t9VarH, zQ2);
    }
}
