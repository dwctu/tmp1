package dc;

import android.graphics.PointF;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import dc.xc;
import java.io.IOException;

/* compiled from: CircleShapeParser.java */
/* loaded from: classes.dex */
public class pb {
    public static xc.a a = xc.a.a("nm", "p", "s", "hd", GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG);

    public static ea a(xc xcVar, f7 f7Var, int i) throws IOException {
        boolean z = i == 3;
        String strC = null;
        ca<PointF, PointF> caVarB = null;
        v9 v9VarI = null;
        boolean zQ = false;
        while (xcVar.p()) {
            int iO = xcVar.O(a);
            if (iO == 0) {
                strC = xcVar.C();
            } else if (iO == 1) {
                caVarB = lb.b(xcVar, f7Var);
            } else if (iO == 2) {
                v9VarI = ob.i(xcVar, f7Var);
            } else if (iO == 3) {
                zQ = xcVar.q();
            } else if (iO != 4) {
                xcVar.V();
                xcVar.X();
            } else {
                z = xcVar.y() == 3;
            }
        }
        return new ea(strC, caVarB, v9VarI, z, zQ);
    }
}
