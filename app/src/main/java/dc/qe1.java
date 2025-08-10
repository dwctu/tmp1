package dc;

import android.graphics.PointF;
import android.view.View;

/* compiled from: SimpleBoundaryDecider.java */
/* loaded from: classes3.dex */
public class qe1 implements pe1 {
    public PointF a;
    public pe1 b;
    public boolean c = true;

    @Override // dc.pe1
    public boolean a(View view) {
        pe1 pe1Var = this.b;
        return pe1Var != null ? pe1Var.a(view) : se1.b(view, this.a);
    }

    @Override // dc.pe1
    public boolean b(View view) {
        pe1 pe1Var = this.b;
        return pe1Var != null ? pe1Var.b(view) : se1.a(view, this.a, this.c);
    }
}
