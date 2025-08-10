package dc;

import dc.xc;
import java.io.IOException;

/* compiled from: ScaleXYParser.java */
/* loaded from: classes.dex */
public class nc implements uc<ld> {
    public static final nc a = new nc();

    @Override // dc.uc
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ld a(xc xcVar, float f) throws IOException {
        boolean z = xcVar.K() == xc.b.BEGIN_ARRAY;
        if (z) {
            xcVar.e();
        }
        float fX = (float) xcVar.x();
        float fX2 = (float) xcVar.x();
        while (xcVar.p()) {
            xcVar.X();
        }
        if (z) {
            xcVar.j();
        }
        return new ld((fX / 100.0f) * f, (fX2 / 100.0f) * f);
    }
}
