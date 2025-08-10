package dc;

import android.graphics.PointF;
import dc.ma;
import dc.xc;
import java.io.IOException;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: PolystarShapeParser.java */
/* loaded from: classes.dex */
public class kc {
    public static final xc.a a = xc.a.a("nm", "sy", "pt", "p", StreamManagement.AckRequest.ELEMENT, "or", "os", "ir", "is", "hd");

    public static ma a(xc xcVar, f7 f7Var) throws IOException {
        String strC = null;
        ma.a aVarForValue = null;
        r9 r9VarF = null;
        ca<PointF, PointF> caVarB = null;
        r9 r9VarF2 = null;
        r9 r9VarE = null;
        r9 r9VarE2 = null;
        r9 r9VarF3 = null;
        r9 r9VarF4 = null;
        boolean zQ = false;
        while (xcVar.p()) {
            switch (xcVar.O(a)) {
                case 0:
                    strC = xcVar.C();
                    break;
                case 1:
                    aVarForValue = ma.a.forValue(xcVar.y());
                    break;
                case 2:
                    r9VarF = ob.f(xcVar, f7Var, false);
                    break;
                case 3:
                    caVarB = lb.b(xcVar, f7Var);
                    break;
                case 4:
                    r9VarF2 = ob.f(xcVar, f7Var, false);
                    break;
                case 5:
                    r9VarE2 = ob.e(xcVar, f7Var);
                    break;
                case 6:
                    r9VarF4 = ob.f(xcVar, f7Var, false);
                    break;
                case 7:
                    r9VarE = ob.e(xcVar, f7Var);
                    break;
                case 8:
                    r9VarF3 = ob.f(xcVar, f7Var, false);
                    break;
                case 9:
                    zQ = xcVar.q();
                    break;
                default:
                    xcVar.V();
                    xcVar.X();
                    break;
            }
        }
        return new ma(strC, aVarForValue, r9VarF, caVarB, r9VarF2, r9VarE, r9VarE2, r9VarF3, r9VarF4, zQ);
    }
}
