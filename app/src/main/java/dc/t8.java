package dc;

import java.util.List;

/* compiled from: IntegerKeyframeAnimation.java */
/* loaded from: classes.dex */
public class t8 extends u8<Integer> {
    public t8(List<id<Integer>> list) {
        super(list);
    }

    public int p() {
        return q(b(), d());
    }

    public int q(id<Integer> idVar, float f) {
        Integer num;
        if (idVar.b == null || idVar.c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        kd<A> kdVar = this.e;
        return (kdVar == 0 || (num = (Integer) kdVar.b(idVar.g, idVar.h.floatValue(), idVar.b, idVar.c, f, e(), f())) == null) ? gd.l(idVar.g(), idVar.d(), f) : num.intValue();
    }

    @Override // dc.p8
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public Integer i(id<Integer> idVar, float f) {
        return Integer.valueOf(q(idVar, f));
    }
}
