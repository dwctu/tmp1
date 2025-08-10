package dc;

import android.graphics.PointF;
import java.util.List;

/* compiled from: PointKeyframeAnimation.java */
/* loaded from: classes.dex */
public class y8 extends u8<PointF> {
    public final PointF i;

    public y8(List<id<PointF>> list) {
        super(list);
        this.i = new PointF();
    }

    @Override // dc.p8
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public PointF i(id<PointF> idVar, float f) {
        return j(idVar, f, f, f);
    }

    @Override // dc.p8
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public PointF j(id<PointF> idVar, float f, float f2, float f3) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = idVar.b;
        if (pointF3 == null || (pointF = idVar.c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF4 = pointF3;
        PointF pointF5 = pointF;
        kd<A> kdVar = this.e;
        if (kdVar != 0 && (pointF2 = (PointF) kdVar.b(idVar.g, idVar.h.floatValue(), pointF4, pointF5, f, e(), f())) != null) {
            return pointF2;
        }
        PointF pointF6 = this.i;
        float f4 = pointF4.x;
        float f5 = f4 + (f2 * (pointF5.x - f4));
        float f6 = pointF4.y;
        pointF6.set(f5, f6 + (f3 * (pointF5.y - f6)));
        return this.i;
    }
}
