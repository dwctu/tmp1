package dc;

import dc.xc;
import java.io.IOException;

/* compiled from: FontParser.java */
/* loaded from: classes.dex */
public class vb {
    public static final xc.a a = xc.a.a("fFamily", "fName", "fStyle", "ascent");

    public static j9 a(xc xcVar) throws IOException {
        xcVar.f();
        String strC = null;
        String strC2 = null;
        String strC3 = null;
        float fX = 0.0f;
        while (xcVar.p()) {
            int iO = xcVar.O(a);
            if (iO == 0) {
                strC = xcVar.C();
            } else if (iO == 1) {
                strC2 = xcVar.C();
            } else if (iO == 2) {
                strC3 = xcVar.C();
            } else if (iO != 3) {
                xcVar.V();
                xcVar.X();
            } else {
                fX = (float) xcVar.x();
            }
        }
        xcVar.m();
        return new j9(strC, strC2, strC3, fX);
    }
}
