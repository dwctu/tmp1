package dc;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import dc.ma;
import dc.p8;
import dc.ua;
import java.util.List;

/* compiled from: PolystarContent.java */
/* loaded from: classes.dex */
public class j8 implements i8, p8.b, g8 {
    public final String b;
    public final h7 c;
    public final ma.a d;
    public final boolean e;
    public final p8<?, Float> f;
    public final p8<?, PointF> g;
    public final p8<?, Float> h;

    @Nullable
    public final p8<?, Float> i;
    public final p8<?, Float> j;

    @Nullable
    public final p8<?, Float> k;
    public final p8<?, Float> l;
    public boolean n;
    public final Path a = new Path();
    public x7 m = new x7();

    /* compiled from: PolystarContent.java */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ma.a.values().length];
            a = iArr;
            try {
                iArr[ma.a.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ma.a.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public j8(h7 h7Var, va vaVar, ma maVar) {
        this.c = h7Var;
        this.b = maVar.d();
        ma.a aVarJ = maVar.j();
        this.d = aVarJ;
        this.e = maVar.k();
        p8<Float, Float> p8VarA = maVar.g().a();
        this.f = p8VarA;
        p8<PointF, PointF> p8VarA2 = maVar.h().a();
        this.g = p8VarA2;
        p8<Float, Float> p8VarA3 = maVar.i().a();
        this.h = p8VarA3;
        p8<Float, Float> p8VarA4 = maVar.e().a();
        this.j = p8VarA4;
        p8<Float, Float> p8VarA5 = maVar.f().a();
        this.l = p8VarA5;
        ma.a aVar = ma.a.STAR;
        if (aVarJ == aVar) {
            this.i = maVar.b().a();
            this.k = maVar.c().a();
        } else {
            this.i = null;
            this.k = null;
        }
        vaVar.i(p8VarA);
        vaVar.i(p8VarA2);
        vaVar.i(p8VarA3);
        vaVar.i(p8VarA4);
        vaVar.i(p8VarA5);
        if (aVarJ == aVar) {
            vaVar.i(this.i);
            vaVar.i(this.k);
        }
        p8VarA.a(this);
        p8VarA2.a(this);
        p8VarA3.a(this);
        p8VarA4.a(this);
        p8VarA5.a(this);
        if (aVarJ == aVar) {
            this.i.a(this);
            this.k.a(this);
        }
    }

    @Override // dc.p8.b
    public void a() {
        i();
    }

    @Override // dc.y7
    public void b(List<y7> list, List<y7> list2) {
        for (int i = 0; i < list.size(); i++) {
            y7 y7Var = list.get(i);
            if (y7Var instanceof o8) {
                o8 o8Var = (o8) y7Var;
                if (o8Var.i() == ua.a.SIMULTANEOUSLY) {
                    this.m.a(o8Var);
                    o8Var.c(this);
                }
            }
        }
    }

    @Override // dc.m9
    public <T> void c(T t, @Nullable kd<T> kdVar) {
        p8<?, Float> p8Var;
        p8<?, Float> p8Var2;
        if (t == m7.u) {
            this.f.n(kdVar);
            return;
        }
        if (t == m7.v) {
            this.h.n(kdVar);
            return;
        }
        if (t == m7.l) {
            this.g.n(kdVar);
            return;
        }
        if (t == m7.w && (p8Var2 = this.i) != null) {
            p8Var2.n(kdVar);
            return;
        }
        if (t == m7.x) {
            this.j.n(kdVar);
            return;
        }
        if (t == m7.y && (p8Var = this.k) != null) {
            p8Var.n(kdVar);
        } else if (t == m7.z) {
            this.l.n(kdVar);
        }
    }

    @Override // dc.m9
    public void d(l9 l9Var, int i, List<l9> list, l9 l9Var2) {
        gd.m(l9Var, i, list, l9Var2, this);
    }

    public final void f() {
        double d;
        double d2;
        double d3;
        int i;
        int iFloor = (int) Math.floor(this.f.h().floatValue());
        double radians = Math.toRadians((this.h == null ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : r2.h().floatValue()) - 90.0d);
        double d4 = iFloor;
        float fFloatValue = this.l.h().floatValue() / 100.0f;
        float fFloatValue2 = this.j.h().floatValue();
        double d5 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d5);
        float fSin = (float) (Math.sin(radians) * d5);
        this.a.moveTo(fCos, fSin);
        double d6 = (float) (6.283185307179586d / d4);
        double d7 = radians + d6;
        double dCeil = Math.ceil(d4);
        int i2 = 0;
        while (i2 < dCeil) {
            float fCos2 = (float) (Math.cos(d7) * d5);
            double d8 = dCeil;
            float fSin2 = (float) (d5 * Math.sin(d7));
            if (fFloatValue != 0.0f) {
                d2 = d5;
                i = i2;
                d = d7;
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                d3 = d6;
                double dAtan22 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float f = fFloatValue2 * fFloatValue * 0.25f;
                this.a.cubicTo(fCos - (fCos3 * f), fSin - (fSin3 * f), fCos2 + (((float) Math.cos(dAtan22)) * f), fSin2 + (f * ((float) Math.sin(dAtan22))), fCos2, fSin2);
            } else {
                d = d7;
                d2 = d5;
                d3 = d6;
                i = i2;
                this.a.lineTo(fCos2, fSin2);
            }
            d7 = d + d3;
            i2 = i + 1;
            fSin = fSin2;
            fCos = fCos2;
            dCeil = d8;
            d5 = d2;
            d6 = d3;
        }
        PointF pointFH = this.g.h();
        this.a.offset(pointFH.x, pointFH.y);
        this.a.close();
    }

    @Override // dc.y7
    public String getName() {
        return this.b;
    }

    @Override // dc.i8
    public Path getPath() {
        if (this.n) {
            return this.a;
        }
        this.a.reset();
        if (this.e) {
            this.n = true;
            return this.a;
        }
        int i = a.a[this.d.ordinal()];
        if (i == 1) {
            h();
        } else if (i == 2) {
            f();
        }
        this.a.close();
        this.m.b(this.a);
        this.n = true;
        return this.a;
    }

    public final void h() {
        double d;
        int i;
        double d2;
        float fCos;
        float fSin;
        float f;
        float f2;
        float f3;
        float f4;
        double d3;
        float f5;
        float f6;
        float f7;
        float fFloatValue = this.f.h().floatValue();
        double radians = Math.toRadians((this.h == null ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : r2.h().floatValue()) - 90.0d);
        double d4 = fFloatValue;
        float f8 = (float) (6.283185307179586d / d4);
        float f9 = f8 / 2.0f;
        float f10 = fFloatValue - ((int) fFloatValue);
        int i2 = (f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1));
        if (i2 != 0) {
            radians += (1.0f - f10) * f9;
        }
        float fFloatValue2 = this.j.h().floatValue();
        float fFloatValue3 = this.i.h().floatValue();
        p8<?, Float> p8Var = this.k;
        float fFloatValue4 = p8Var != null ? p8Var.h().floatValue() / 100.0f : 0.0f;
        p8<?, Float> p8Var2 = this.l;
        float fFloatValue5 = p8Var2 != null ? p8Var2.h().floatValue() / 100.0f : 0.0f;
        if (i2 != 0) {
            f = ((fFloatValue2 - fFloatValue3) * f10) + fFloatValue3;
            i = i2;
            double d5 = f;
            d = d4;
            fCos = (float) (d5 * Math.cos(radians));
            fSin = (float) (d5 * Math.sin(radians));
            this.a.moveTo(fCos, fSin);
            d2 = radians + ((f8 * f10) / 2.0f);
        } else {
            d = d4;
            i = i2;
            double d6 = fFloatValue2;
            float fCos2 = (float) (Math.cos(radians) * d6);
            float fSin2 = (float) (d6 * Math.sin(radians));
            this.a.moveTo(fCos2, fSin2);
            d2 = radians + f9;
            fCos = fCos2;
            fSin = fSin2;
            f = 0.0f;
        }
        double dCeil = Math.ceil(d) * 2.0d;
        int i3 = 0;
        boolean z = false;
        while (true) {
            double d7 = i3;
            if (d7 >= dCeil) {
                PointF pointFH = this.g.h();
                this.a.offset(pointFH.x, pointFH.y);
                this.a.close();
                return;
            }
            float f11 = z ? fFloatValue2 : fFloatValue3;
            if (f == 0.0f || d7 != dCeil - 2.0d) {
                f2 = f8;
                f3 = f9;
            } else {
                f2 = f8;
                f3 = (f8 * f10) / 2.0f;
            }
            if (f == 0.0f || d7 != dCeil - 1.0d) {
                f4 = f9;
                d3 = d7;
                f5 = f11;
            } else {
                f4 = f9;
                d3 = d7;
                f5 = f;
            }
            double d8 = f5;
            double d9 = dCeil;
            float fCos3 = (float) (d8 * Math.cos(d2));
            float fSin3 = (float) (d8 * Math.sin(d2));
            if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                this.a.lineTo(fCos3, fSin3);
                f6 = fFloatValue4;
                f7 = f;
            } else {
                f6 = fFloatValue4;
                f7 = f;
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos4 = (float) Math.cos(dAtan2);
                float fSin4 = (float) Math.sin(dAtan2);
                double dAtan22 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                float fCos5 = (float) Math.cos(dAtan22);
                float fSin5 = (float) Math.sin(dAtan22);
                float f12 = z ? f6 : fFloatValue5;
                float f13 = z ? fFloatValue5 : f6;
                float f14 = (z ? fFloatValue3 : fFloatValue2) * f12 * 0.47829f;
                float f15 = fCos4 * f14;
                float f16 = f14 * fSin4;
                float f17 = (z ? fFloatValue2 : fFloatValue3) * f13 * 0.47829f;
                float f18 = fCos5 * f17;
                float f19 = f17 * fSin5;
                if (i != 0) {
                    if (i3 == 0) {
                        f15 *= f10;
                        f16 *= f10;
                    } else if (d3 == d9 - 1.0d) {
                        f18 *= f10;
                        f19 *= f10;
                    }
                }
                this.a.cubicTo(fCos - f15, fSin - f16, fCos3 + f18, fSin3 + f19, fCos3, fSin3);
            }
            d2 += f3;
            z = !z;
            i3++;
            fCos = fCos3;
            fSin = fSin3;
            fFloatValue4 = f6;
            f = f7;
            f9 = f4;
            f8 = f2;
            dCeil = d9;
        }
    }

    public final void i() {
        this.n = false;
        this.c.invalidateSelf();
    }
}
