package dc;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* compiled from: PathKeyframeAnimation.java */
/* loaded from: classes.dex */
public class x8 extends u8<PointF> {
    public final PointF i;
    public final float[] j;
    public final PathMeasure k;
    public w8 l;

    public x8(List<? extends id<PointF>> list) {
        super(list);
        this.i = new PointF();
        this.j = new float[2];
        this.k = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // dc.p8
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public PointF i(id<PointF> idVar, float f) {
        PointF pointF;
        w8 w8Var = (w8) idVar;
        Path pathJ = w8Var.j();
        if (pathJ == null) {
            return idVar.b;
        }
        kd<A> kdVar = this.e;
        if (kdVar != 0 && (pointF = (PointF) kdVar.b(w8Var.g, w8Var.h.floatValue(), w8Var.b, w8Var.c, e(), f, f())) != null) {
            return pointF;
        }
        if (this.l != w8Var) {
            this.k.setPath(pathJ, false);
            this.l = w8Var;
        }
        PathMeasure pathMeasure = this.k;
        pathMeasure.getPosTan(f * pathMeasure.getLength(), this.j, null);
        PointF pointF2 = this.i;
        float[] fArr = this.j;
        pointF2.set(fArr[0], fArr[1]);
        return this.i;
    }
}
