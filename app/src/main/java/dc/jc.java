package dc;

import android.graphics.PointF;
import dc.xc;
import java.io.IOException;

/* compiled from: PointFParser.java */
/* loaded from: classes.dex */
public class jc implements uc<PointF> {
    public static final jc a = new jc();

    @Override // dc.uc
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointF a(xc xcVar, float f) throws IOException {
        xc.b bVarK = xcVar.K();
        if (bVarK == xc.b.BEGIN_ARRAY) {
            return ac.e(xcVar, f);
        }
        if (bVarK == xc.b.BEGIN_OBJECT) {
            return ac.e(xcVar, f);
        }
        if (bVarK == xc.b.NUMBER) {
            PointF pointF = new PointF(((float) xcVar.x()) * f, ((float) xcVar.x()) * f);
            while (xcVar.p()) {
                xcVar.X();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + bVarK);
    }
}
