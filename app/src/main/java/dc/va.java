package dc;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.common.collect.LinkedHashMultimap;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import dc.ka;
import dc.p8;
import dc.ya;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: BaseLayer.java */
/* loaded from: classes.dex */
public abstract class va implements a8, p8.b, m9 {
    public final Path a = new Path();
    public final Matrix b = new Matrix();
    public final Paint c = new v7(1);
    public final Paint d = new v7(1, PorterDuff.Mode.DST_IN);
    public final Paint e = new v7(1, PorterDuff.Mode.DST_OUT);
    public final Paint f;
    public final Paint g;
    public final RectF h;
    public final RectF i;
    public final RectF j;
    public final RectF k;
    public final String l;
    public final Matrix m;
    public final h7 n;
    public final ya o;

    @Nullable
    public v8 p;

    @Nullable
    public r8 q;

    @Nullable
    public va r;

    @Nullable
    public va s;
    public List<va> t;
    public final List<p8<?, ?>> u;
    public final d9 v;
    public boolean w;
    public boolean x;

    @Nullable
    public Paint y;

    /* compiled from: BaseLayer.java */
    public class a implements p8.b {
        public a() {
        }

        @Override // dc.p8.b
        public void a() {
            va vaVar = va.this;
            vaVar.I(vaVar.q.p() == 1.0f);
        }
    }

    /* compiled from: BaseLayer.java */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[ka.a.values().length];
            b = iArr;
            try {
                iArr[ka.a.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[ka.a.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[ka.a.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[ka.a.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ya.a.values().length];
            a = iArr2;
            try {
                iArr2[ya.a.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ya.a.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ya.a.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ya.a.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ya.a.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ya.a.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ya.a.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public va(h7 h7Var, ya yaVar) {
        v7 v7Var = new v7(1);
        this.f = v7Var;
        this.g = new v7(PorterDuff.Mode.CLEAR);
        this.h = new RectF();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new RectF();
        this.m = new Matrix();
        this.u = new ArrayList();
        this.w = true;
        this.n = h7Var;
        this.o = yaVar;
        this.l = yaVar.g() + "#draw";
        if (yaVar.f() == ya.b.INVERT) {
            v7Var.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            v7Var.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        d9 d9VarB = yaVar.u().b();
        this.v = d9VarB;
        d9VarB.b(this);
        if (yaVar.e() != null && !yaVar.e().isEmpty()) {
            v8 v8Var = new v8(yaVar.e());
            this.p = v8Var;
            Iterator<p8<pa, Path>> it = v8Var.a().iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
            for (p8<Integer, Integer> p8Var : this.p.c()) {
                i(p8Var);
                p8Var.a(this);
            }
        }
        J();
    }

    @Nullable
    public static va u(ya yaVar, h7 h7Var, f7 f7Var) {
        switch (b.a[yaVar.d().ordinal()]) {
            case 1:
                return new ab(h7Var, yaVar);
            case 2:
                return new wa(h7Var, yaVar, f7Var.n(yaVar.k()), f7Var);
            case 3:
                return new bb(h7Var, yaVar);
            case 4:
                return new xa(h7Var, yaVar);
            case 5:
                return new za(h7Var, yaVar);
            case 6:
                return new cb(h7Var, yaVar);
            default:
                dd.c("Unknown layer type " + yaVar.d());
                return null;
        }
    }

    public final void A() {
        this.n.invalidateSelf();
    }

    public final void B(float f) {
        this.n.q().m().a(this.o.g(), f);
    }

    public void C(p8<?, ?> p8Var) {
        this.u.remove(p8Var);
    }

    public void D(l9 l9Var, int i, List<l9> list, l9 l9Var2) {
    }

    public void E(@Nullable va vaVar) {
        this.r = vaVar;
    }

    public void F(boolean z) {
        if (z && this.y == null) {
            this.y = new v7();
        }
        this.x = z;
    }

    public void G(@Nullable va vaVar) {
        this.s = vaVar;
    }

    public void H(@FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f) {
        this.v.j(f);
        if (this.p != null) {
            for (int i = 0; i < this.p.a().size(); i++) {
                this.p.a().get(i).m(f);
            }
        }
        if (this.o.t() != 0.0f) {
            f /= this.o.t();
        }
        r8 r8Var = this.q;
        if (r8Var != null) {
            r8Var.m(f / this.o.t());
        }
        va vaVar = this.r;
        if (vaVar != null) {
            this.r.H(vaVar.o.t() * f);
        }
        for (int i2 = 0; i2 < this.u.size(); i2++) {
            this.u.get(i2).m(f);
        }
    }

    public final void I(boolean z) {
        if (z != this.w) {
            this.w = z;
            A();
        }
    }

    public final void J() {
        if (this.o.c().isEmpty()) {
            I(true);
            return;
        }
        r8 r8Var = new r8(this.o.c());
        this.q = r8Var;
        r8Var.l();
        this.q.a(new a());
        I(this.q.h().floatValue() == 1.0f);
        i(this.q);
    }

    @Override // dc.p8.b
    public void a() {
        A();
    }

    @Override // dc.y7
    public void b(List<y7> list, List<y7> list2) {
    }

    @CallSuper
    public <T> void c(T t, @Nullable kd<T> kdVar) {
        this.v.c(t, kdVar);
    }

    @Override // dc.m9
    public void d(l9 l9Var, int i, List<l9> list, l9 l9Var2) {
        va vaVar = this.r;
        if (vaVar != null) {
            l9 l9VarA = l9Var2.a(vaVar.getName());
            if (l9Var.c(this.r.getName(), i)) {
                list.add(l9VarA.i(this.r));
            }
            if (l9Var.h(getName(), i)) {
                this.r.D(l9Var, l9Var.e(this.r.getName(), i) + i, list, l9VarA);
            }
        }
        if (l9Var.g(getName(), i)) {
            if (!"__container".equals(getName())) {
                l9Var2 = l9Var2.a(getName());
                if (l9Var.c(getName(), i)) {
                    list.add(l9Var2.i(this));
                }
            }
            if (l9Var.h(getName(), i)) {
                D(l9Var, i + l9Var.e(getName(), i), list, l9Var2);
            }
        }
    }

    @Override // dc.a8
    @CallSuper
    public void e(RectF rectF, Matrix matrix, boolean z) {
        this.h.set(0.0f, 0.0f, 0.0f, 0.0f);
        r();
        this.m.set(matrix);
        if (z) {
            List<va> list = this.t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.m.preConcat(this.t.get(size).v.f());
                }
            } else {
                va vaVar = this.s;
                if (vaVar != null) {
                    this.m.preConcat(vaVar.v.f());
                }
            }
        }
        this.m.preConcat(this.v.f());
    }

    @Override // dc.a8
    public void g(Canvas canvas, Matrix matrix, int i) {
        Paint paint;
        e7.a(this.l);
        if (!this.w || this.o.v()) {
            e7.b(this.l);
            return;
        }
        r();
        e7.a("Layer#parentMatrix");
        this.b.reset();
        this.b.set(matrix);
        for (int size = this.t.size() - 1; size >= 0; size--) {
            this.b.preConcat(this.t.get(size).v.f());
        }
        e7.b("Layer#parentMatrix");
        int iIntValue = (int) ((((i / 255.0f) * (this.v.h() == null ? 100 : this.v.h().h().intValue())) / 100.0f) * 255.0f);
        if (!x() && !w()) {
            this.b.preConcat(this.v.f());
            e7.a("Layer#drawLayer");
            t(canvas, this.b, iIntValue);
            e7.b("Layer#drawLayer");
            B(e7.b(this.l));
            return;
        }
        e7.a("Layer#computeBounds");
        e(this.h, this.b, false);
        z(this.h, matrix);
        this.b.preConcat(this.v.f());
        y(this.h, this.b);
        if (!this.h.intersect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight())) {
            this.h.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        e7.b("Layer#computeBounds");
        if (this.h.width() >= 1.0f && this.h.height() >= 1.0f) {
            e7.a("Layer#saveLayer");
            this.c.setAlpha(255);
            hd.m(canvas, this.h, this.c);
            e7.b("Layer#saveLayer");
            s(canvas);
            e7.a("Layer#drawLayer");
            t(canvas, this.b, iIntValue);
            e7.b("Layer#drawLayer");
            if (w()) {
                o(canvas, this.b);
            }
            if (x()) {
                e7.a("Layer#drawMatte");
                e7.a("Layer#saveLayer");
                hd.n(canvas, this.h, this.f, 19);
                e7.b("Layer#saveLayer");
                s(canvas);
                this.r.g(canvas, matrix, iIntValue);
                e7.a("Layer#restoreLayer");
                canvas.restore();
                e7.b("Layer#restoreLayer");
                e7.b("Layer#drawMatte");
            }
            e7.a("Layer#restoreLayer");
            canvas.restore();
            e7.b("Layer#restoreLayer");
        }
        if (this.x && (paint = this.y) != null) {
            paint.setStyle(Paint.Style.STROKE);
            this.y.setColor(-251901);
            this.y.setStrokeWidth(4.0f);
            canvas.drawRect(this.h, this.y);
            this.y.setStyle(Paint.Style.FILL);
            this.y.setColor(1357638635);
            canvas.drawRect(this.h, this.y);
        }
        B(e7.b(this.l));
    }

    @Override // dc.y7
    public String getName() {
        return this.o.g();
    }

    public void i(@Nullable p8<?, ?> p8Var) {
        if (p8Var == null) {
            return;
        }
        this.u.add(p8Var);
    }

    public final void j(Canvas canvas, Matrix matrix, ka kaVar, p8<pa, Path> p8Var, p8<Integer, Integer> p8Var2) {
        this.a.set(p8Var.h());
        this.a.transform(matrix);
        this.c.setAlpha((int) (p8Var2.h().intValue() * 2.55f));
        canvas.drawPath(this.a, this.c);
    }

    public final void k(Canvas canvas, Matrix matrix, ka kaVar, p8<pa, Path> p8Var, p8<Integer, Integer> p8Var2) {
        hd.m(canvas, this.h, this.d);
        this.a.set(p8Var.h());
        this.a.transform(matrix);
        this.c.setAlpha((int) (p8Var2.h().intValue() * 2.55f));
        canvas.drawPath(this.a, this.c);
        canvas.restore();
    }

    public final void l(Canvas canvas, Matrix matrix, ka kaVar, p8<pa, Path> p8Var, p8<Integer, Integer> p8Var2) {
        hd.m(canvas, this.h, this.c);
        canvas.drawRect(this.h, this.c);
        this.a.set(p8Var.h());
        this.a.transform(matrix);
        this.c.setAlpha((int) (p8Var2.h().intValue() * 2.55f));
        canvas.drawPath(this.a, this.e);
        canvas.restore();
    }

    public final void m(Canvas canvas, Matrix matrix, ka kaVar, p8<pa, Path> p8Var, p8<Integer, Integer> p8Var2) {
        hd.m(canvas, this.h, this.d);
        canvas.drawRect(this.h, this.c);
        this.e.setAlpha((int) (p8Var2.h().intValue() * 2.55f));
        this.a.set(p8Var.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.e);
        canvas.restore();
    }

    public final void n(Canvas canvas, Matrix matrix, ka kaVar, p8<pa, Path> p8Var, p8<Integer, Integer> p8Var2) {
        hd.m(canvas, this.h, this.e);
        canvas.drawRect(this.h, this.c);
        this.e.setAlpha((int) (p8Var2.h().intValue() * 2.55f));
        this.a.set(p8Var.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.e);
        canvas.restore();
    }

    public final void o(Canvas canvas, Matrix matrix) {
        e7.a("Layer#saveLayer");
        hd.n(canvas, this.h, this.d, 19);
        if (Build.VERSION.SDK_INT < 28) {
            s(canvas);
        }
        e7.b("Layer#saveLayer");
        for (int i = 0; i < this.p.b().size(); i++) {
            ka kaVar = this.p.b().get(i);
            p8<pa, Path> p8Var = this.p.a().get(i);
            p8<Integer, Integer> p8Var2 = this.p.c().get(i);
            int i2 = b.b[kaVar.a().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i == 0) {
                        this.c.setColor(ViewCompat.MEASURED_STATE_MASK);
                        this.c.setAlpha(255);
                        canvas.drawRect(this.h, this.c);
                    }
                    if (kaVar.d()) {
                        n(canvas, matrix, kaVar, p8Var, p8Var2);
                    } else {
                        p(canvas, matrix, kaVar, p8Var, p8Var2);
                    }
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        if (kaVar.d()) {
                            l(canvas, matrix, kaVar, p8Var, p8Var2);
                        } else {
                            j(canvas, matrix, kaVar, p8Var, p8Var2);
                        }
                    }
                } else if (kaVar.d()) {
                    m(canvas, matrix, kaVar, p8Var, p8Var2);
                } else {
                    k(canvas, matrix, kaVar, p8Var, p8Var2);
                }
            } else if (q()) {
                this.c.setAlpha(255);
                canvas.drawRect(this.h, this.c);
            }
        }
        e7.a("Layer#restoreLayer");
        canvas.restore();
        e7.b("Layer#restoreLayer");
    }

    public final void p(Canvas canvas, Matrix matrix, ka kaVar, p8<pa, Path> p8Var, p8<Integer, Integer> p8Var2) {
        this.a.set(p8Var.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.e);
    }

    public final boolean q() {
        if (this.p.a().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.p.b().size(); i++) {
            if (this.p.b().get(i).a() != ka.a.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    public final void r() {
        if (this.t != null) {
            return;
        }
        if (this.s == null) {
            this.t = Collections.emptyList();
            return;
        }
        this.t = new ArrayList();
        for (va vaVar = this.s; vaVar != null; vaVar = vaVar.s) {
            this.t.add(vaVar);
        }
    }

    public final void s(Canvas canvas) {
        e7.a("Layer#clearLayer");
        RectF rectF = this.h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.g);
        e7.b("Layer#clearLayer");
    }

    public abstract void t(Canvas canvas, Matrix matrix, int i);

    public ya v() {
        return this.o;
    }

    public boolean w() {
        v8 v8Var = this.p;
        return (v8Var == null || v8Var.a().isEmpty()) ? false : true;
    }

    public boolean x() {
        return this.r != null;
    }

    public final void y(RectF rectF, Matrix matrix) {
        this.i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (w()) {
            int size = this.p.b().size();
            for (int i = 0; i < size; i++) {
                ka kaVar = this.p.b().get(i);
                this.a.set(this.p.a().get(i).h());
                this.a.transform(matrix);
                int i2 = b.b[kaVar.a().ordinal()];
                if (i2 == 1 || i2 == 2) {
                    return;
                }
                if ((i2 == 3 || i2 == 4) && kaVar.d()) {
                    return;
                }
                this.a.computeBounds(this.k, false);
                if (i == 0) {
                    this.i.set(this.k);
                } else {
                    RectF rectF2 = this.i;
                    rectF2.set(Math.min(rectF2.left, this.k.left), Math.min(this.i.top, this.k.top), Math.max(this.i.right, this.k.right), Math.max(this.i.bottom, this.k.bottom));
                }
            }
            if (rectF.intersect(this.i)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public final void z(RectF rectF, Matrix matrix) {
        if (x() && this.o.f() != ya.b.INVERT) {
            this.j.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.r.e(this.j, matrix, true);
            if (rectF.intersect(this.j)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }
}
