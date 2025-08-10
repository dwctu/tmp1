package dc;

import android.graphics.PointF;
import com.wear.widget.control.FingImageLayout;
import dc.xc;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: AnimatablePathValueParser.java */
/* loaded from: classes.dex */
public class lb {
    public static final xc.a a = xc.a.a("k", "x", FingImageLayout.ObjectAnimatorY);

    public static u9 a(xc xcVar, f7 f7Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (xcVar.K() == xc.b.BEGIN_ARRAY) {
            xcVar.e();
            while (xcVar.p()) {
                arrayList.add(hc.a(xcVar, f7Var));
            }
            xcVar.j();
            cc.b(arrayList);
        } else {
            arrayList.add(new id(ac.e(xcVar, hd.e())));
        }
        return new u9(arrayList);
    }

    public static ca<PointF, PointF> b(xc xcVar, f7 f7Var) throws IOException {
        xcVar.f();
        u9 u9VarA = null;
        r9 r9VarE = null;
        r9 r9VarE2 = null;
        boolean z = false;
        while (xcVar.K() != xc.b.END_OBJECT) {
            int iO = xcVar.O(a);
            if (iO == 0) {
                u9VarA = a(xcVar, f7Var);
            } else if (iO != 1) {
                if (iO != 2) {
                    xcVar.V();
                    xcVar.X();
                } else if (xcVar.K() == xc.b.STRING) {
                    xcVar.X();
                    z = true;
                } else {
                    r9VarE2 = ob.e(xcVar, f7Var);
                }
            } else if (xcVar.K() == xc.b.STRING) {
                xcVar.X();
                z = true;
            } else {
                r9VarE = ob.e(xcVar, f7Var);
            }
        }
        xcVar.m();
        if (z) {
            f7Var.a("Lottie doesn't support expressions.");
        }
        return u9VarA != null ? u9VarA : new y9(r9VarE, r9VarE2);
    }
}
