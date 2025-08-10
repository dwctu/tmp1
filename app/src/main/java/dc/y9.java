package dc;

import android.graphics.PointF;
import java.util.List;

/* compiled from: AnimatableSplitDimensionPathValue.java */
/* loaded from: classes.dex */
public class y9 implements ca<PointF, PointF> {
    public final r9 a;
    public final r9 b;

    public y9(r9 r9Var, r9 r9Var2) {
        this.a = r9Var;
        this.b = r9Var2;
    }

    @Override // dc.ca
    public p8<PointF, PointF> a() {
        return new b9(this.a.a(), this.b.a());
    }

    @Override // dc.ca
    public List<id<PointF>> b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // dc.ca
    public boolean isStatic() {
        return this.a.isStatic() && this.b.isStatic();
    }
}
