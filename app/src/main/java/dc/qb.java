package dc;

import android.graphics.Color;
import dc.xc;
import java.io.IOException;

/* compiled from: ColorParser.java */
/* loaded from: classes.dex */
public class qb implements uc<Integer> {
    public static final qb a = new qb();

    @Override // dc.uc
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(xc xcVar, float f) throws IOException {
        boolean z = xcVar.K() == xc.b.BEGIN_ARRAY;
        if (z) {
            xcVar.e();
        }
        double dX = xcVar.x();
        double dX2 = xcVar.x();
        double dX3 = xcVar.x();
        double dX4 = xcVar.K() == xc.b.NUMBER ? xcVar.x() : 1.0d;
        if (z) {
            xcVar.j();
        }
        if (dX <= 1.0d && dX2 <= 1.0d && dX3 <= 1.0d) {
            dX *= 255.0d;
            dX2 *= 255.0d;
            dX3 *= 255.0d;
            if (dX4 <= 1.0d) {
                dX4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) dX4, (int) dX, (int) dX2, (int) dX3));
    }
}
