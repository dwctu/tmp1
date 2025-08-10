package dc;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dc.p8;
import java.util.Collections;

/* compiled from: TransformKeyframeAnimation.java */
/* loaded from: classes.dex */
public class d9 {
    public final Matrix a = new Matrix();
    public final Matrix b;
    public final Matrix c;
    public final Matrix d;
    public final float[] e;

    @NonNull
    public p8<PointF, PointF> f;

    @NonNull
    public p8<?, PointF> g;

    @NonNull
    public p8<ld, ld> h;

    @NonNull
    public p8<Float, Float> i;

    @NonNull
    public p8<Integer, Integer> j;

    @Nullable
    public r8 k;

    @Nullable
    public r8 l;

    @Nullable
    public p8<?, Float> m;

    @Nullable
    public p8<?, Float> n;

    public d9(ba baVar) {
        this.f = baVar.c() == null ? null : baVar.c().a();
        this.g = baVar.f() == null ? null : baVar.f().a();
        this.h = baVar.h() == null ? null : baVar.h().a();
        this.i = baVar.g() == null ? null : baVar.g().a();
        r8 r8Var = baVar.i() == null ? null : (r8) baVar.i().a();
        this.k = r8Var;
        if (r8Var != null) {
            this.b = new Matrix();
            this.c = new Matrix();
            this.d = new Matrix();
            this.e = new float[9];
        } else {
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }
        this.l = baVar.j() == null ? null : (r8) baVar.j().a();
        if (baVar.e() != null) {
            this.j = baVar.e().a();
        }
        if (baVar.k() != null) {
            this.m = baVar.k().a();
        } else {
            this.m = null;
        }
        if (baVar.d() != null) {
            this.n = baVar.d().a();
        } else {
            this.n = null;
        }
    }

    public void a(va vaVar) {
        vaVar.i(this.j);
        vaVar.i(this.m);
        vaVar.i(this.n);
        vaVar.i(this.f);
        vaVar.i(this.g);
        vaVar.i(this.h);
        vaVar.i(this.i);
        vaVar.i(this.k);
        vaVar.i(this.l);
    }

    public void b(p8.b bVar) {
        p8<Integer, Integer> p8Var = this.j;
        if (p8Var != null) {
            p8Var.a(bVar);
        }
        p8<?, Float> p8Var2 = this.m;
        if (p8Var2 != null) {
            p8Var2.a(bVar);
        }
        p8<?, Float> p8Var3 = this.n;
        if (p8Var3 != null) {
            p8Var3.a(bVar);
        }
        p8<PointF, PointF> p8Var4 = this.f;
        if (p8Var4 != null) {
            p8Var4.a(bVar);
        }
        p8<?, PointF> p8Var5 = this.g;
        if (p8Var5 != null) {
            p8Var5.a(bVar);
        }
        p8<ld, ld> p8Var6 = this.h;
        if (p8Var6 != null) {
            p8Var6.a(bVar);
        }
        p8<Float, Float> p8Var7 = this.i;
        if (p8Var7 != null) {
            p8Var7.a(bVar);
        }
        r8 r8Var = this.k;
        if (r8Var != null) {
            r8Var.a(bVar);
        }
        r8 r8Var2 = this.l;
        if (r8Var2 != null) {
            r8Var2.a(bVar);
        }
    }

    public <T> boolean c(T t, @Nullable kd<T> kdVar) {
        r8 r8Var;
        r8 r8Var2;
        p8<?, Float> p8Var;
        p8<?, Float> p8Var2;
        if (t == m7.e) {
            p8<PointF, PointF> p8Var3 = this.f;
            if (p8Var3 == null) {
                this.f = new e9(kdVar, new PointF());
                return true;
            }
            p8Var3.n(kdVar);
            return true;
        }
        if (t == m7.f) {
            p8<?, PointF> p8Var4 = this.g;
            if (p8Var4 == null) {
                this.g = new e9(kdVar, new PointF());
                return true;
            }
            p8Var4.n(kdVar);
            return true;
        }
        if (t == m7.g) {
            p8<?, PointF> p8Var5 = this.g;
            if (p8Var5 instanceof b9) {
                ((b9) p8Var5).r(kdVar);
                return true;
            }
        }
        if (t == m7.h) {
            p8<?, PointF> p8Var6 = this.g;
            if (p8Var6 instanceof b9) {
                ((b9) p8Var6).s(kdVar);
                return true;
            }
        }
        if (t == m7.m) {
            p8<ld, ld> p8Var7 = this.h;
            if (p8Var7 == null) {
                this.h = new e9(kdVar, new ld());
                return true;
            }
            p8Var7.n(kdVar);
            return true;
        }
        if (t == m7.n) {
            p8<Float, Float> p8Var8 = this.i;
            if (p8Var8 == null) {
                this.i = new e9(kdVar, Float.valueOf(0.0f));
                return true;
            }
            p8Var8.n(kdVar);
            return true;
        }
        if (t == m7.c) {
            p8<Integer, Integer> p8Var9 = this.j;
            if (p8Var9 == null) {
                this.j = new e9(kdVar, 100);
                return true;
            }
            p8Var9.n(kdVar);
            return true;
        }
        if (t == m7.A && (p8Var2 = this.m) != null) {
            if (p8Var2 == null) {
                this.m = new e9(kdVar, 100);
                return true;
            }
            p8Var2.n(kdVar);
            return true;
        }
        if (t == m7.B && (p8Var = this.n) != null) {
            if (p8Var == null) {
                this.n = new e9(kdVar, 100);
                return true;
            }
            p8Var.n(kdVar);
            return true;
        }
        if (t == m7.o && (r8Var2 = this.k) != null) {
            if (r8Var2 == null) {
                this.k = new r8(Collections.singletonList(new id(Float.valueOf(0.0f))));
            }
            this.k.n(kdVar);
            return true;
        }
        if (t != m7.p || (r8Var = this.l) == null) {
            return false;
        }
        if (r8Var == null) {
            this.l = new r8(Collections.singletonList(new id(Float.valueOf(0.0f))));
        }
        this.l.n(kdVar);
        return true;
    }

    public final void d() {
        for (int i = 0; i < 9; i++) {
            this.e[i] = 0.0f;
        }
    }

    @Nullable
    public p8<?, Float> e() {
        return this.n;
    }

    public Matrix f() {
        this.a.reset();
        p8<?, PointF> p8Var = this.g;
        if (p8Var != null) {
            PointF pointFH = p8Var.h();
            float f = pointFH.x;
            if (f != 0.0f || pointFH.y != 0.0f) {
                this.a.preTranslate(f, pointFH.y);
            }
        }
        p8<Float, Float> p8Var2 = this.i;
        if (p8Var2 != null) {
            float fFloatValue = p8Var2 instanceof e9 ? p8Var2.h().floatValue() : ((r8) p8Var2).p();
            if (fFloatValue != 0.0f) {
                this.a.preRotate(fFloatValue);
            }
        }
        if (this.k != null) {
            float fCos = this.l == null ? 0.0f : (float) Math.cos(Math.toRadians((-r0.p()) + 90.0f));
            float fSin = this.l == null ? 1.0f : (float) Math.sin(Math.toRadians((-r4.p()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(this.k.p()));
            d();
            float[] fArr = this.e;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f2 = -fSin;
            fArr[3] = f2;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.b.setValues(fArr);
            d();
            float[] fArr2 = this.e;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.c.setValues(fArr2);
            d();
            float[] fArr3 = this.e;
            fArr3[0] = fCos;
            fArr3[1] = f2;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.d.setValues(fArr3);
            this.c.preConcat(this.b);
            this.d.preConcat(this.c);
            this.a.preConcat(this.d);
        }
        p8<ld, ld> p8Var3 = this.h;
        if (p8Var3 != null) {
            ld ldVarH = p8Var3.h();
            if (ldVarH.b() != 1.0f || ldVarH.c() != 1.0f) {
                this.a.preScale(ldVarH.b(), ldVarH.c());
            }
        }
        p8<PointF, PointF> p8Var4 = this.f;
        if (p8Var4 != null) {
            PointF pointFH2 = p8Var4.h();
            float f3 = pointFH2.x;
            if (f3 != 0.0f || pointFH2.y != 0.0f) {
                this.a.preTranslate(-f3, -pointFH2.y);
            }
        }
        return this.a;
    }

    public Matrix g(float f) {
        p8<?, PointF> p8Var = this.g;
        PointF pointFH = p8Var == null ? null : p8Var.h();
        p8<ld, ld> p8Var2 = this.h;
        ld ldVarH = p8Var2 == null ? null : p8Var2.h();
        this.a.reset();
        if (pointFH != null) {
            this.a.preTranslate(pointFH.x * f, pointFH.y * f);
        }
        if (ldVarH != null) {
            double d = f;
            this.a.preScale((float) Math.pow(ldVarH.b(), d), (float) Math.pow(ldVarH.c(), d));
        }
        p8<Float, Float> p8Var3 = this.i;
        if (p8Var3 != null) {
            float fFloatValue = p8Var3.h().floatValue();
            p8<PointF, PointF> p8Var4 = this.f;
            PointF pointFH2 = p8Var4 != null ? p8Var4.h() : null;
            this.a.preRotate(fFloatValue * f, pointFH2 == null ? 0.0f : pointFH2.x, pointFH2 != null ? pointFH2.y : 0.0f);
        }
        return this.a;
    }

    @Nullable
    public p8<?, Integer> h() {
        return this.j;
    }

    @Nullable
    public p8<?, Float> i() {
        return this.m;
    }

    public void j(float f) {
        p8<Integer, Integer> p8Var = this.j;
        if (p8Var != null) {
            p8Var.m(f);
        }
        p8<?, Float> p8Var2 = this.m;
        if (p8Var2 != null) {
            p8Var2.m(f);
        }
        p8<?, Float> p8Var3 = this.n;
        if (p8Var3 != null) {
            p8Var3.m(f);
        }
        p8<PointF, PointF> p8Var4 = this.f;
        if (p8Var4 != null) {
            p8Var4.m(f);
        }
        p8<?, PointF> p8Var5 = this.g;
        if (p8Var5 != null) {
            p8Var5.m(f);
        }
        p8<ld, ld> p8Var6 = this.h;
        if (p8Var6 != null) {
            p8Var6.m(f);
        }
        p8<Float, Float> p8Var7 = this.i;
        if (p8Var7 != null) {
            p8Var7.m(f);
        }
        r8 r8Var = this.k;
        if (r8Var != null) {
            r8Var.m(f);
        }
        r8 r8Var2 = this.l;
        if (r8Var2 != null) {
            r8Var2.m(f);
        }
    }
}
