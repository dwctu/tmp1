package dc;

import java.util.List;

/* compiled from: FloatKeyframeAnimation.java */
/* loaded from: classes.dex */
public class r8 extends u8<Float> {
    public r8(List<id<Float>> list) {
        super(list);
    }

    public float p() {
        return q(b(), d());
    }

    public float q(id<Float> idVar, float f) {
        Float f2;
        if (idVar.b == null || idVar.c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        kd<A> kdVar = this.e;
        return (kdVar == 0 || (f2 = (Float) kdVar.b(idVar.g, idVar.h.floatValue(), idVar.b, idVar.c, f, e(), f())) == null) ? gd.k(idVar.f(), idVar.c(), f) : f2.floatValue();
    }

    @Override // dc.p8
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public Float i(id<Float> idVar, float f) {
        return Float.valueOf(q(idVar, f));
    }
}
