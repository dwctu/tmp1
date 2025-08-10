package dc;

import android.graphics.PointF;
import java.util.List;

/* compiled from: AnimatablePathValue.java */
/* loaded from: classes.dex */
public class u9 implements ca<PointF, PointF> {
    public final List<id<PointF>> a;

    public u9(List<id<PointF>> list) {
        this.a = list;
    }

    @Override // dc.ca
    public p8<PointF, PointF> a() {
        return this.a.get(0).h() ? new y8(this.a) : new x8(this.a);
    }

    @Override // dc.ca
    public List<id<PointF>> b() {
        return this.a;
    }

    @Override // dc.ca
    public boolean isStatic() {
        return this.a.size() == 1 && this.a.get(0).h();
    }
}
