package dc;

import dc.xc;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: FontCharacterParser.java */
/* loaded from: classes.dex */
public class ub {
    public static final xc.a a = xc.a.a("ch", "size", "w", "style", "fFamily", "data");
    public static final xc.a b = xc.a.a("shapes");

    public static k9 a(xc xcVar, f7 f7Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        xcVar.f();
        String strC = null;
        String strC2 = null;
        double dX = 0.0d;
        double dX2 = 0.0d;
        char cCharAt = 0;
        while (xcVar.p()) {
            int iO = xcVar.O(a);
            if (iO == 0) {
                cCharAt = xcVar.C().charAt(0);
            } else if (iO == 1) {
                dX = xcVar.x();
            } else if (iO == 2) {
                dX2 = xcVar.x();
            } else if (iO == 3) {
                strC = xcVar.C();
            } else if (iO == 4) {
                strC2 = xcVar.C();
            } else if (iO != 5) {
                xcVar.V();
                xcVar.X();
            } else {
                xcVar.f();
                while (xcVar.p()) {
                    if (xcVar.O(b) != 0) {
                        xcVar.V();
                        xcVar.X();
                    } else {
                        xcVar.e();
                        while (xcVar.p()) {
                            arrayList.add((ra) rb.a(xcVar, f7Var));
                        }
                        xcVar.j();
                    }
                }
                xcVar.m();
            }
        }
        xcVar.m();
        return new k9(arrayList, cCharAt, dX, dX2, strC, strC2);
    }
}
