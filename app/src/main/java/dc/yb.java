package dc;

import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import dc.ta;
import dc.xc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: GradientStrokeParser.java */
/* loaded from: classes.dex */
public class yb {
    public static xc.a a = xc.a.a("nm", "g", "o", "t", "s", "e", "w", "lc", "lj", "ml", "hd", GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG);
    public static final xc.a b = xc.a.a("p", "k");
    public static final xc.a c = xc.a.a(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, PSOProgramService.VS_Key);

    public static ia a(xc xcVar, f7 f7Var) throws IOException {
        s9 s9Var;
        ArrayList arrayList = new ArrayList();
        String strC = null;
        ja jaVar = null;
        s9 s9VarG = null;
        v9 v9VarI = null;
        v9 v9VarI2 = null;
        r9 r9VarE = null;
        ta.b bVar = null;
        ta.c cVar = null;
        float fX = 0.0f;
        r9 r9Var = null;
        boolean zQ = false;
        t9 t9Var = null;
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
                        if (iO != 0) {
                            s9Var = s9VarG;
                            if (iO != 1) {
                                xcVar.V();
                                xcVar.X();
                            } else {
                                s9VarG = ob.g(xcVar, f7Var, iY);
                            }
                        } else {
                            s9Var = s9VarG;
                            iY = xcVar.y();
                        }
                        s9VarG = s9Var;
                    }
                    xcVar.m();
                    break;
                case 2:
                    t9Var = ob.h(xcVar, f7Var);
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
                    r9VarE = ob.e(xcVar, f7Var);
                    break;
                case 7:
                    bVar = ta.b.values()[xcVar.y() - 1];
                    break;
                case 8:
                    cVar = ta.c.values()[xcVar.y() - 1];
                    break;
                case 9:
                    fX = (float) xcVar.x();
                    break;
                case 10:
                    zQ = xcVar.q();
                    break;
                case 11:
                    xcVar.e();
                    while (xcVar.p()) {
                        xcVar.f();
                        String strC2 = null;
                        r9 r9VarE2 = null;
                        while (xcVar.p()) {
                            int iO2 = xcVar.O(c);
                            if (iO2 != 0) {
                                r9 r9Var2 = r9Var;
                                if (iO2 != 1) {
                                    xcVar.V();
                                    xcVar.X();
                                } else {
                                    r9VarE2 = ob.e(xcVar, f7Var);
                                }
                                r9Var = r9Var2;
                            } else {
                                strC2 = xcVar.C();
                            }
                        }
                        r9 r9Var3 = r9Var;
                        xcVar.m();
                        if (strC2.equals("o")) {
                            r9Var = r9VarE2;
                        } else {
                            if (strC2.equals(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG) || strC2.equals("g")) {
                                f7Var.t(true);
                                arrayList.add(r9VarE2);
                            }
                            r9Var = r9Var3;
                        }
                    }
                    r9 r9Var4 = r9Var;
                    xcVar.j();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    r9Var = r9Var4;
                    break;
                default:
                    xcVar.V();
                    xcVar.X();
                    break;
            }
        }
        if (t9Var == null) {
            t9Var = new t9(Collections.singletonList(new id(100)));
        }
        return new ia(strC, jaVar, s9VarG, t9Var, v9VarI, v9VarI2, r9VarE, bVar, cVar, fX, arrayList, r9Var, zQ);
    }
}
