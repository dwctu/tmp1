package dc;

import java.util.List;

/* compiled from: ScaleKeyframeAnimation.java */
/* loaded from: classes.dex */
public class z8 extends u8<ld> {
    public final ld i;

    public z8(List<id<ld>> list) {
        super(list);
        this.i = new ld();
    }

    @Override // dc.p8
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public ld i(id<ld> idVar, float f) {
        ld ldVar;
        ld ldVar2;
        ld ldVar3 = idVar.b;
        if (ldVar3 == null || (ldVar = idVar.c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        ld ldVar4 = ldVar3;
        ld ldVar5 = ldVar;
        kd<A> kdVar = this.e;
        if (kdVar != 0 && (ldVar2 = (ld) kdVar.b(idVar.g, idVar.h.floatValue(), ldVar4, ldVar5, f, e(), f())) != null) {
            return ldVar2;
        }
        this.i.d(gd.k(ldVar4.b(), ldVar5.b(), f), gd.k(ldVar4.c(), ldVar5.c(), f));
        return this.i;
    }
}
