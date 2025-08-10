package dc;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import dc.p8;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GradientFillContent.java */
/* loaded from: classes.dex */
public class d8 implements a8, p8.b, g8 {

    @NonNull
    public final String a;
    public final boolean b;
    public final va c;
    public final LongSparseArray<LinearGradient> d = new LongSparseArray<>();
    public final LongSparseArray<RadialGradient> e = new LongSparseArray<>();
    public final Path f;
    public final Paint g;
    public final RectF h;
    public final List<i8> i;
    public final ja j;
    public final p8<ga, ga> k;
    public final p8<Integer, Integer> l;
    public final p8<PointF, PointF> m;
    public final p8<PointF, PointF> n;

    @Nullable
    public p8<ColorFilter, ColorFilter> o;

    @Nullable
    public e9 p;
    public final h7 q;
    public final int r;

    public d8(h7 h7Var, va vaVar, ha haVar) {
        Path path = new Path();
        this.f = path;
        this.g = new v7(1);
        this.h = new RectF();
        this.i = new ArrayList();
        this.c = vaVar;
        this.a = haVar.f();
        this.b = haVar.i();
        this.q = h7Var;
        this.j = haVar.e();
        path.setFillType(haVar.c());
        this.r = (int) (h7Var.q().d() / 32.0f);
        p8<ga, ga> p8VarA = haVar.d().a();
        this.k = p8VarA;
        p8VarA.a(this);
        vaVar.i(p8VarA);
        p8<Integer, Integer> p8VarA2 = haVar.g().a();
        this.l = p8VarA2;
        p8VarA2.a(this);
        vaVar.i(p8VarA2);
        p8<PointF, PointF> p8VarA3 = haVar.h().a();
        this.m = p8VarA3;
        p8VarA3.a(this);
        vaVar.i(p8VarA3);
        p8<PointF, PointF> p8VarA4 = haVar.b().a();
        this.n = p8VarA4;
        p8VarA4.a(this);
        vaVar.i(p8VarA4);
    }

    @Override // dc.p8.b
    public void a() {
        this.q.invalidateSelf();
    }

    @Override // dc.y7
    public void b(List<y7> list, List<y7> list2) {
        for (int i = 0; i < list2.size(); i++) {
            y7 y7Var = list2.get(i);
            if (y7Var instanceof i8) {
                this.i.add((i8) y7Var);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // dc.m9
    public <T> void c(T t, @Nullable kd<T> kdVar) {
        if (t == m7.d) {
            this.l.n(kdVar);
            return;
        }
        if (t == m7.E) {
            p8<ColorFilter, ColorFilter> p8Var = this.o;
            if (p8Var != null) {
                this.c.C(p8Var);
            }
            if (kdVar == null) {
                this.o = null;
                return;
            }
            e9 e9Var = new e9(kdVar);
            this.o = e9Var;
            e9Var.a(this);
            this.c.i(this.o);
            return;
        }
        if (t == m7.F) {
            e9 e9Var2 = this.p;
            if (e9Var2 != null) {
                this.c.C(e9Var2);
            }
            if (kdVar == null) {
                this.p = null;
                return;
            }
            this.d.clear();
            this.e.clear();
            e9 e9Var3 = new e9(kdVar);
            this.p = e9Var3;
            e9Var3.a(this);
            this.c.i(this.p);
        }
    }

    @Override // dc.m9
    public void d(l9 l9Var, int i, List<l9> list, l9 l9Var2) {
        gd.m(l9Var, i, list, l9Var2, this);
    }

    @Override // dc.a8
    public void e(RectF rectF, Matrix matrix, boolean z) {
        this.f.reset();
        for (int i = 0; i < this.i.size(); i++) {
            this.f.addPath(this.i.get(i).getPath(), matrix);
        }
        this.f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public final int[] f(int[] iArr) {
        e9 e9Var = this.p;
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

    @Override // dc.a8
    public void g(Canvas canvas, Matrix matrix, int i) {
        if (this.b) {
            return;
        }
        e7.a("GradientFillContent#draw");
        this.f.reset();
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            this.f.addPath(this.i.get(i2).getPath(), matrix);
        }
        this.f.computeBounds(this.h, false);
        Shader shaderI = this.j == ja.LINEAR ? i() : j();
        shaderI.setLocalMatrix(matrix);
        this.g.setShader(shaderI);
        p8<ColorFilter, ColorFilter> p8Var = this.o;
        if (p8Var != null) {
            this.g.setColorFilter(p8Var.h());
        }
        this.g.setAlpha(gd.d((int) ((((i / 255.0f) * this.l.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f, this.g);
        e7.b("GradientFillContent#draw");
    }

    @Override // dc.y7
    public String getName() {
        return this.a;
    }

    public final int h() {
        int iRound = Math.round(this.m.f() * this.r);
        int iRound2 = Math.round(this.n.f() * this.r);
        int iRound3 = Math.round(this.k.f() * this.r);
        int i = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    public final LinearGradient i() {
        long jH = h();
        LinearGradient linearGradient = this.d.get(jH);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFH = this.m.h();
        PointF pointFH2 = this.n.h();
        ga gaVarH = this.k.h();
        LinearGradient linearGradient2 = new LinearGradient(pointFH.x, pointFH.y, pointFH2.x, pointFH2.y, f(gaVarH.a()), gaVarH.b(), Shader.TileMode.CLAMP);
        this.d.put(jH, linearGradient2);
        return linearGradient2;
    }

    public final RadialGradient j() {
        long jH = h();
        RadialGradient radialGradient = this.e.get(jH);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFH = this.m.h();
        PointF pointFH2 = this.n.h();
        ga gaVarH = this.k.h();
        int[] iArrF = f(gaVarH.a());
        float[] fArrB = gaVarH.b();
        float f = pointFH.x;
        float f2 = pointFH.y;
        float fHypot = (float) Math.hypot(pointFH2.x - f, pointFH2.y - f2);
        RadialGradient radialGradient2 = new RadialGradient(f, f2, fHypot <= 0.0f ? 0.001f : fHypot, iArrF, fArrB, Shader.TileMode.CLAMP);
        this.e.put(jH, radialGradient2);
        return radialGradient2;
    }
}
