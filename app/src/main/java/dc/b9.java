package dc;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import java.util.Collections;

/* compiled from: SplitDimensionPathKeyframeAnimation.java */
/* loaded from: classes.dex */
public class b9 extends p8<PointF, PointF> {
    public final PointF i;
    public final PointF j;
    public final p8<Float, Float> k;
    public final p8<Float, Float> l;

    @Nullable
    public kd<Float> m;

    @Nullable
    public kd<Float> n;

    public b9(p8<Float, Float> p8Var, p8<Float, Float> p8Var2) {
        super(Collections.emptyList());
        this.i = new PointF();
        this.j = new PointF();
        this.k = p8Var;
        this.l = p8Var2;
        m(f());
    }

    @Override // dc.p8
    public void m(float f) {
        this.k.m(f);
        this.l.m(f);
        this.i.set(this.k.h().floatValue(), this.l.h().floatValue());
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).a();
        }
    }

    @Override // dc.p8
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public PointF h() {
        return i(null, 0.0f);
    }

    @Override // dc.p8
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public PointF i(id<PointF> idVar, float f) {
        Float fB;
        id<Float> idVarB;
        id<Float> idVarB2;
        Float fB2 = null;
        if (this.m == null || (idVarB2 = this.k.b()) == null) {
            fB = null;
        } else {
            float fD = this.k.d();
            Float f2 = idVarB2.h;
            kd<Float> kdVar = this.m;
            float f3 = idVarB2.g;
            fB = kdVar.b(f3, f2 == null ? f3 : f2.floatValue(), idVarB2.b, idVarB2.c, f, f, fD);
        }
        if (this.n != null && (idVarB = this.l.b()) != null) {
            float fD2 = this.l.d();
            Float f4 = idVarB.h;
            kd<Float> kdVar2 = this.n;
            float f5 = idVarB.g;
            fB2 = kdVar2.b(f5, f4 == null ? f5 : f4.floatValue(), idVarB.b, idVarB.c, f, f, fD2);
        }
        if (fB == null) {
            this.j.set(this.i.x, 0.0f);
        } else {
            this.j.set(fB.floatValue(), 0.0f);
        }
        if (fB2 == null) {
            PointF pointF = this.j;
            pointF.set(pointF.x, this.i.y);
        } else {
            PointF pointF2 = this.j;
            pointF2.set(pointF2.x, fB2.floatValue());
        }
        return this.j;
    }

    public void r(@Nullable kd<Float> kdVar) {
        kd<Float> kdVar2 = this.m;
        if (kdVar2 != null) {
            kdVar2.c(null);
        }
        this.m = kdVar;
        if (kdVar != null) {
            kdVar.c(this);
        }
    }

    public void s(@Nullable kd<Float> kdVar) {
        kd<Float> kdVar2 = this.n;
        if (kdVar2 != null) {
            kdVar2.c(null);
        }
        this.n = kdVar;
        if (kdVar != null) {
            kdVar.c(this);
        }
    }
}
