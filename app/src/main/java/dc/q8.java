package dc;

import java.util.List;

/* compiled from: ColorKeyframeAnimation.java */
/* loaded from: classes.dex */
public class q8 extends u8<Integer> {
    public q8(List<id<Integer>> list) {
        super(list);
    }

    public int p() {
        return q(b(), d());
    }

    public int q(id<Integer> idVar, float f) {
        Integer num;
        Integer num2 = idVar.b;
        if (num2 == null || idVar.c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int iIntValue = num2.intValue();
        int iIntValue2 = idVar.c.intValue();
        kd<A> kdVar = this.e;
        return (kdVar == 0 || (num = (Integer) kdVar.b(idVar.g, idVar.h.floatValue(), Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2), f, e(), f())) == null) ? bd.c(gd.c(f, 0.0f, 1.0f), iIntValue, iIntValue2) : num.intValue();
    }

    @Override // dc.p8
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public Integer i(id<Integer> idVar, float f) {
        return Integer.valueOf(q(idVar, f));
    }
}
