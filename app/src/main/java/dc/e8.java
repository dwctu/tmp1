package dc;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;

/* compiled from: GradientStrokeContent.java */
/* loaded from: classes.dex */
public class e8 extends w7 {
    public final String o;
    public final boolean p;
    public final LongSparseArray<LinearGradient> q;
    public final LongSparseArray<RadialGradient> r;
    public final RectF s;
    public final ja t;
    public final int u;
    public final p8<ga, ga> v;
    public final p8<PointF, PointF> w;
    public final p8<PointF, PointF> x;

    @Nullable
    public e9 y;

    public e8(h7 h7Var, va vaVar, ia iaVar) {
        super(h7Var, vaVar, iaVar.b().toPaintCap(), iaVar.g().toPaintJoin(), iaVar.i(), iaVar.k(), iaVar.m(), iaVar.h(), iaVar.c());
        this.q = new LongSparseArray<>();
        this.r = new LongSparseArray<>();
        this.s = new RectF();
        this.o = iaVar.j();
        this.t = iaVar.f();
        this.p = iaVar.n();
        this.u = (int) (h7Var.q().d() / 32.0f);
        p8<ga, ga> p8VarA = iaVar.e().a();
        this.v = p8VarA;
        p8VarA.a(this);
        vaVar.i(p8VarA);
        p8<PointF, PointF> p8VarA2 = iaVar.l().a();
        this.w = p8VarA2;
        p8VarA2.a(this);
        vaVar.i(p8VarA2);
        p8<PointF, PointF> p8VarA3 = iaVar.d().a();
        this.x = p8VarA3;
        p8VarA3.a(this);
        vaVar.i(p8VarA3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // dc.w7, dc.m9
    public <T> void c(T t, @Nullable kd<T> kdVar) {
        super.c(t, kdVar);
        if (t == m7.F) {
            e9 e9Var = this.y;
            if (e9Var != null) {
                this.f.C(e9Var);
            }
            if (kdVar == null) {
                this.y = null;
                return;
            }
            e9 e9Var2 = new e9(kdVar);
            this.y = e9Var2;
            e9Var2.a(this);
            this.f.i(this.y);
        }
    }

    @Override // dc.w7, dc.a8
    public void g(Canvas canvas, Matrix matrix, int i) {
        if (this.p) {
            return;
        }
        e(this.s, matrix, false);
        Shader shaderK = this.t == ja.LINEAR ? k() : l();
        shaderK.setLocalMatrix(matrix);
        this.i.setShader(shaderK);
        super.g(canvas, matrix, i);
    }

    @Override // dc.y7
    public String getName() {
        return this.o;
    }

    public final int[] i(int[] iArr) {
        e9 e9Var = this.y;
        if (e9Var != null) {
            Integer[] numArr = (Integer[]) e9Var.h();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }

    public final int j() {
        int iRound = Math.round(this.w.f() * this.u);
        int iRound2 = Math.round(this.x.f() * this.u);
        int iRound3 = Math.round(this.v.f() * this.u);
        int i = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    public final LinearGradient k() {
        long j = j();
        LinearGradient linearGradient = this.q.get(j);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFH = this.w.h();
        PointF pointFH2 = this.x.h();
        ga gaVarH = this.v.h();
        LinearGradient linearGradient2 = new LinearGradient(pointFH.x, pointFH.y, pointFH2.x, pointFH2.y, i(gaVarH.a()), gaVarH.b(), Shader.TileMode.CLAMP);
        this.q.put(j, linearGradient2);
        return linearGradient2;
    }

    public final RadialGradient l() {
        long j = j();
        RadialGradient radialGradient = this.r.get(j);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFH = this.w.h();
        PointF pointFH2 = this.x.h();
        ga gaVarH = this.v.h();
        int[] iArrI = i(gaVarH.a());
        float[] fArrB = gaVarH.b();
        RadialGradient radialGradient2 = new RadialGradient(pointFH.x, pointFH.y, (float) Math.hypot(pointFH2.x - r7, pointFH2.y - r8), iArrI, fArrB, Shader.TileMode.CLAMP);
        this.r.put(j, radialGradient2);
        return radialGradient2;
    }
}
