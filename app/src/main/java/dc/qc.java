package dc;

import dc.xc;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: ShapeGroupParser.java */
/* loaded from: classes.dex */
public class qc {
    public static xc.a a = xc.a.a("nm", "hd", "it");

    public static ra a(xc xcVar, f7 f7Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strC = null;
        boolean zQ = false;
        while (xcVar.p()) {
            int iO = xcVar.O(a);
            if (iO == 0) {
                strC = xcVar.C();
            } else if (iO == 1) {
                zQ = xcVar.q();
            } else if (iO != 2) {
                xcVar.X();
            } else {
                xcVar.e();
                while (xcVar.p()) {
                    fa faVarA = rb.a(xcVar, f7Var);
                    if (faVarA != null) {
                        arrayList.add(faVarA);
                    }
                }
                xcVar.j();
            }
        }
        return new ra(strC, arrayList, zQ);
    }
}
