package dc;

import dc.i9;
import dc.xc;
import java.io.IOException;

/* compiled from: DocumentDataParser.java */
/* loaded from: classes.dex */
public class sb implements uc<i9> {
    public static final sb a = new sb();
    public static final xc.a b = xc.a.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    @Override // dc.uc
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i9 a(xc xcVar, float f) throws IOException {
        i9.a aVar = i9.a.CENTER;
        xcVar.f();
        i9.a aVar2 = aVar;
        String strC = null;
        String strC2 = null;
        float fX = 0.0f;
        int iY = 0;
        float fX2 = 0.0f;
        float fX3 = 0.0f;
        int iD = 0;
        int iD2 = 0;
        float fX4 = 0.0f;
        boolean zQ = true;
        while (xcVar.p()) {
            switch (xcVar.O(b)) {
                case 0:
                    strC = xcVar.C();
                    break;
                case 1:
                    strC2 = xcVar.C();
                    break;
                case 2:
                    fX = (float) xcVar.x();
                    break;
                case 3:
                    int iY2 = xcVar.y();
                    aVar2 = i9.a.CENTER;
                    if (iY2 <= aVar2.ordinal() && iY2 >= 0) {
                        aVar2 = i9.a.values()[iY2];
                        break;
                    } else {
                        break;
                    }
                    break;
                case 4:
                    iY = xcVar.y();
                    break;
                case 5:
                    fX2 = (float) xcVar.x();
                    break;
                case 6:
                    fX3 = (float) xcVar.x();
                    break;
                case 7:
                    iD = ac.d(xcVar);
                    break;
                case 8:
                    iD2 = ac.d(xcVar);
                    break;
                case 9:
                    fX4 = (float) xcVar.x();
                    break;
                case 10:
                    zQ = xcVar.q();
                    break;
                default:
                    xcVar.V();
                    xcVar.X();
                    break;
            }
        }
        xcVar.m();
        return new i9(strC, strC2, fX, aVar2, iY, fX2, fX3, iD, iD2, fX4, zQ);
    }
}
