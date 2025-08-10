package dc;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.collect.LinkedHashMultimap;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: LottieDrawable.java */
/* loaded from: classes.dex */
public class h7 extends Drawable implements Drawable.Callback, Animatable {
    public final Matrix a = new Matrix();
    public f7 b;
    public final ed c;
    public float d;
    public boolean e;
    public boolean f;
    public boolean g;
    public final ArrayList<q> h;
    public final ValueAnimator.AnimatorUpdateListener i;

    @Nullable
    public g9 j;

    @Nullable
    public g9 k;

    @Nullable
    public String l;

    @Nullable
    public d7 m;

    @Nullable
    public f9 n;

    @Nullable
    public c7 o;

    @Nullable
    public u7 p;
    public boolean q;

    @Nullable
    public wa r;
    public int s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;

    /* compiled from: LottieDrawable.java */
    public class a implements q {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // dc.h7.q
        public void a(f7 f7Var) {
            h7.this.Z(this.a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class b implements q {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;

        public b(String str, String str2, boolean z) {
            this.a = str;
            this.b = str2;
            this.c = z;
        }

        @Override // dc.h7.q
        public void a(f7 f7Var) {
            h7.this.a0(this.a, this.b, this.c);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class c implements q {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public c(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // dc.h7.q
        public void a(f7 f7Var) {
            h7.this.Y(this.a, this.b);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class d implements q {
        public final /* synthetic */ float a;
        public final /* synthetic */ float b;

        public d(float f, float f2) {
            this.a = f;
            this.b = f2;
        }

        @Override // dc.h7.q
        public void a(f7 f7Var) {
            h7.this.b0(this.a, this.b);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class e implements q {
        public final /* synthetic */ int a;

        public e(int i) {
            this.a = i;
        }

        @Override // dc.h7.q
        public void a(f7 f7Var) {
            h7.this.R(this.a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class f implements q {
        public final /* synthetic */ float a;

        public f(float f) {
            this.a = f;
        }

        @Override // dc.h7.q
        public void a(f7 f7Var) {
            h7.this.h0(this.a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class g implements q {
        public final /* synthetic */ l9 a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ kd c;

        public g(l9 l9Var, Object obj, kd kdVar) {
            this.a = l9Var;
            this.b = obj;
            this.c = kdVar;
        }

        @Override // dc.h7.q
        public void a(f7 f7Var) {
            h7.this.d(this.a, this.b, this.c);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        public h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (h7.this.r != null) {
                h7.this.r.H(h7.this.c.h());
            }
        }
    }

    /* compiled from: LottieDrawable.java */
    public class i implements q {
        public i() {
        }

        @Override // dc.h7.q
        public void a(f7 f7Var) {
            h7.this.L();
        }
    }

    /* compiled from: LottieDrawable.java */
    public class j implements q {
        public j() {
        }

        @Override // dc.h7.q
        public void a(f7 f7Var) {
            h7.this.N();
        }
    }

    /* compiled from: LottieDrawable.java */
    public class k implements q {
        public final /* synthetic */ int a;

        public k(int i) {
            this.a = i;
        }

        @Override // dc.h7.q
        public void a(f7 f7Var) {
            h7.this.c0(this.a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class l implements q {
        public final /* synthetic */ float a;

        public l(float f) {
            this.a = f;
        }

        @Override // dc.h7.q
        public void a(f7 f7Var) {
            h7.this.e0(this.a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class m implements q {
        public final /* synthetic */ int a;

        public m(int i) {
            this.a = i;
        }

        @Override // dc.h7.q
        public void a(f7 f7Var) {
            h7.this.V(this.a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class n implements q {
        public final /* synthetic */ float a;

        public n(float f) {
            this.a = f;
        }

        @Override // dc.h7.q
        public void a(f7 f7Var) {
            h7.this.X(this.a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class o implements q {
        public final /* synthetic */ String a;

        public o(String str) {
            this.a = str;
        }

        @Override // dc.h7.q
        public void a(f7 f7Var) {
            h7.this.d0(this.a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class p implements q {
        public final /* synthetic */ String a;

        public p(String str) {
            this.a = str;
        }

        @Override // dc.h7.q
        public void a(f7 f7Var) {
            h7.this.W(this.a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public interface q {
        void a(f7 f7Var);
    }

    public h7() {
        ed edVar = new ed();
        this.c = edVar;
        this.d = 1.0f;
        this.e = true;
        this.f = false;
        this.g = false;
        this.h = new ArrayList<>();
        h hVar = new h();
        this.i = hVar;
        this.s = 255;
        this.w = true;
        this.x = false;
        edVar.addUpdateListener(hVar);
    }

    @Nullable
    public p7 A() {
        f7 f7Var = this.b;
        if (f7Var != null) {
            return f7Var.m();
        }
        return null;
    }

    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
    public float B() {
        return this.c.h();
    }

    public int C() {
        return this.c.getRepeatCount();
    }

    public int D() {
        return this.c.getRepeatMode();
    }

    public float E() {
        return this.d;
    }

    public float F() {
        return this.c.n();
    }

    @Nullable
    public u7 G() {
        return this.p;
    }

    @Nullable
    public Typeface H(String str, String str2) {
        f9 f9VarS = s();
        if (f9VarS != null) {
            return f9VarS.b(str, str2);
        }
        return null;
    }

    public boolean I() {
        ed edVar = this.c;
        if (edVar == null) {
            return false;
        }
        return edVar.isRunning();
    }

    public boolean J() {
        return this.v;
    }

    public void K() {
        this.h.clear();
        this.c.p();
    }

    @MainThread
    public void L() {
        if (this.r == null) {
            this.h.add(new i());
            return;
        }
        if (e() || C() == 0) {
            this.c.q();
        }
        if (e()) {
            return;
        }
        R((int) (F() < 0.0f ? z() : x()));
        this.c.g();
    }

    public List<l9> M(l9 l9Var) {
        if (this.r == null) {
            dd.c("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.r.d(l9Var, 0, arrayList, new l9(new String[0]));
        return arrayList;
    }

    @MainThread
    public void N() {
        if (this.r == null) {
            this.h.add(new j());
            return;
        }
        if (e() || C() == 0) {
            this.c.u();
        }
        if (e()) {
            return;
        }
        R((int) (F() < 0.0f ? z() : x()));
        this.c.g();
    }

    public void O(boolean z) {
        this.v = z;
    }

    public boolean P(f7 f7Var) {
        if (this.b == f7Var) {
            return false;
        }
        this.x = false;
        j();
        this.b = f7Var;
        h();
        this.c.w(f7Var);
        h0(this.c.getAnimatedFraction());
        l0(this.d);
        Iterator it = new ArrayList(this.h).iterator();
        while (it.hasNext()) {
            q qVar = (q) it.next();
            if (qVar != null) {
                qVar.a(f7Var);
            }
            it.remove();
        }
        this.h.clear();
        f7Var.u(this.t);
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof ImageView)) {
            return true;
        }
        ImageView imageView = (ImageView) callback;
        imageView.setImageDrawable(null);
        imageView.setImageDrawable(this);
        return true;
    }

    public void Q(c7 c7Var) {
        f9 f9Var = this.n;
        if (f9Var != null) {
            f9Var.c(c7Var);
        }
    }

    public void R(int i2) {
        if (this.b == null) {
            this.h.add(new e(i2));
        } else {
            this.c.x(i2);
        }
    }

    public void S(boolean z) {
        this.f = z;
    }

    public void T(d7 d7Var) {
        this.m = d7Var;
        g9 g9Var = this.k;
        if (g9Var != null) {
            g9Var.d(d7Var);
        }
    }

    public void U(@Nullable String str) {
        this.l = str;
    }

    public void V(int i2) {
        if (this.b == null) {
            this.h.add(new m(i2));
        } else {
            this.c.y(i2 + 0.99f);
        }
    }

    public void W(String str) {
        f7 f7Var = this.b;
        if (f7Var == null) {
            this.h.add(new p(str));
            return;
        }
        o9 o9VarK = f7Var.k(str);
        if (o9VarK != null) {
            V((int) (o9VarK.b + o9VarK.c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void X(@FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f2) {
        f7 f7Var = this.b;
        if (f7Var == null) {
            this.h.add(new n(f2));
        } else {
            V((int) gd.k(f7Var.o(), this.b.f(), f2));
        }
    }

    public void Y(int i2, int i3) {
        if (this.b == null) {
            this.h.add(new c(i2, i3));
        } else {
            this.c.z(i2, i3 + 0.99f);
        }
    }

    public void Z(String str) {
        f7 f7Var = this.b;
        if (f7Var == null) {
            this.h.add(new a(str));
            return;
        }
        o9 o9VarK = f7Var.k(str);
        if (o9VarK != null) {
            int i2 = (int) o9VarK.b;
            Y(i2, ((int) o9VarK.c) + i2);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
    }

    public void a0(String str, String str2, boolean z) {
        f7 f7Var = this.b;
        if (f7Var == null) {
            this.h.add(new b(str, str2, z));
            return;
        }
        o9 o9VarK = f7Var.k(str);
        if (o9VarK == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        int i2 = (int) o9VarK.b;
        o9 o9VarK2 = this.b.k(str2);
        if (o9VarK2 != null) {
            Y(i2, (int) (o9VarK2.b + (z ? 1.0f : 0.0f)));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
    }

    public void b0(@FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f2, @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f3) {
        f7 f7Var = this.b;
        if (f7Var == null) {
            this.h.add(new d(f2, f3));
        } else {
            Y((int) gd.k(f7Var.o(), this.b.f(), f2), (int) gd.k(this.b.o(), this.b.f(), f3));
        }
    }

    public void c(Animator.AnimatorListener animatorListener) {
        this.c.addListener(animatorListener);
    }

    public void c0(int i2) {
        if (this.b == null) {
            this.h.add(new k(i2));
        } else {
            this.c.A(i2);
        }
    }

    public <T> void d(l9 l9Var, T t, kd<T> kdVar) {
        wa waVar = this.r;
        if (waVar == null) {
            this.h.add(new g(l9Var, t, kdVar));
            return;
        }
        boolean zIsEmpty = true;
        if (l9Var == l9.c) {
            waVar.c(t, kdVar);
        } else if (l9Var.d() != null) {
            l9Var.d().c(t, kdVar);
        } else {
            List<l9> listM = M(l9Var);
            for (int i2 = 0; i2 < listM.size(); i2++) {
                listM.get(i2).d().c(t, kdVar);
            }
            zIsEmpty = true ^ listM.isEmpty();
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (t == m7.C) {
                h0(B());
            }
        }
    }

    public void d0(String str) {
        f7 f7Var = this.b;
        if (f7Var == null) {
            this.h.add(new o(str));
            return;
        }
        o9 o9VarK = f7Var.k(str);
        if (o9VarK != null) {
            c0((int) o9VarK.b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.x = false;
        e7.a("Drawable#draw");
        if (this.g) {
            try {
                k(canvas);
            } catch (Throwable th) {
                dd.b("Lottie crashed in draw!", th);
            }
        } else {
            k(canvas);
        }
        e7.b("Drawable#draw");
    }

    public final boolean e() {
        return this.e || this.f;
    }

    public void e0(float f2) {
        f7 f7Var = this.b;
        if (f7Var == null) {
            this.h.add(new l(f2));
        } else {
            c0((int) gd.k(f7Var.o(), this.b.f(), f2));
        }
    }

    public final float f(Rect rect) {
        return rect.width() / rect.height();
    }

    public void f0(boolean z) {
        if (this.u == z) {
            return;
        }
        this.u = z;
        wa waVar = this.r;
        if (waVar != null) {
            waVar.F(z);
        }
    }

    public final boolean g() {
        f7 f7Var = this.b;
        return f7Var == null || getBounds().isEmpty() || f(getBounds()) == f(f7Var.b());
    }

    public void g0(boolean z) {
        this.t = z;
        f7 f7Var = this.b;
        if (f7Var != null) {
            f7Var.u(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.s;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.b == null) {
            return -1;
        }
        return (int) (r0.b().height() * E());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.b == null) {
            return -1;
        }
        return (int) (r0.b().width() * E());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final void h() {
        wa waVar = new wa(this, dc.a(this.b), this.b.j(), this.b);
        this.r = waVar;
        if (this.u) {
            waVar.F(true);
        }
    }

    public void h0(@FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f2) {
        if (this.b == null) {
            this.h.add(new f(f2));
            return;
        }
        e7.a("Drawable#setProgress");
        this.c.x(gd.k(this.b.o(), this.b.f(), f2));
        e7.b("Drawable#setProgress");
    }

    public void i() {
        this.h.clear();
        this.c.cancel();
    }

    public void i0(int i2) {
        this.c.setRepeatCount(i2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.x) {
            return;
        }
        this.x = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return I();
    }

    public void j() {
        if (this.c.isRunning()) {
            this.c.cancel();
        }
        this.b = null;
        this.r = null;
        this.k = null;
        this.c.f();
        invalidateSelf();
    }

    public void j0(int i2) {
        this.c.setRepeatMode(i2);
    }

    public final void k(@NonNull Canvas canvas) {
        if (g()) {
            m(canvas);
        } else {
            l(canvas);
        }
    }

    public void k0(boolean z) {
        this.g = z;
    }

    public final void l(Canvas canvas) {
        float f2;
        if (this.r == null) {
            return;
        }
        int iSave = -1;
        Rect bounds = getBounds();
        float fWidth = bounds.width() / this.b.b().width();
        float fHeight = bounds.height() / this.b.b().height();
        if (this.w) {
            float fMin = Math.min(fWidth, fHeight);
            if (fMin < 1.0f) {
                f2 = 1.0f / fMin;
                fWidth /= f2;
                fHeight /= f2;
            } else {
                f2 = 1.0f;
            }
            if (f2 > 1.0f) {
                iSave = canvas.save();
                float fWidth2 = bounds.width() / 2.0f;
                float fHeight2 = bounds.height() / 2.0f;
                float f3 = fWidth2 * fMin;
                float f4 = fMin * fHeight2;
                canvas.translate(fWidth2 - f3, fHeight2 - f4);
                canvas.scale(f2, f2, f3, f4);
            }
        }
        this.a.reset();
        this.a.preScale(fWidth, fHeight);
        this.r.g(canvas, this.a, this.s);
        if (iSave > 0) {
            canvas.restoreToCount(iSave);
        }
    }

    public void l0(float f2) {
        this.d = f2;
    }

    public final void m(Canvas canvas) {
        float f2;
        if (this.r == null) {
            return;
        }
        float f3 = this.d;
        float fY = y(canvas);
        if (f3 > fY) {
            f2 = this.d / fY;
        } else {
            fY = f3;
            f2 = 1.0f;
        }
        int iSave = -1;
        if (f2 > 1.0f) {
            iSave = canvas.save();
            float fWidth = this.b.b().width() / 2.0f;
            float fHeight = this.b.b().height() / 2.0f;
            float f4 = fWidth * fY;
            float f5 = fHeight * fY;
            canvas.translate((E() * fWidth) - f4, (E() * fHeight) - f5);
            canvas.scale(f2, f2, f4, f5);
        }
        this.a.reset();
        this.a.preScale(fY, fY);
        this.r.g(canvas, this.a, this.s);
        if (iSave > 0) {
            canvas.restoreToCount(iSave);
        }
    }

    public void m0(float f2) {
        this.c.B(f2);
    }

    public void n(boolean z) {
        if (this.q == z) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            dd.c("Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.q = z;
        if (this.b != null) {
            h();
        }
    }

    public void n0(Boolean bool) {
        this.e = bool.booleanValue();
    }

    public boolean o() {
        return this.q;
    }

    public void o0(u7 u7Var) {
    }

    @MainThread
    public void p() {
        this.h.clear();
        this.c.g();
    }

    public boolean p0() {
        return this.p == null && this.b.c().size() > 0;
    }

    public f7 q() {
        return this.b;
    }

    @Nullable
    public final Context r() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    public final f9 s() {
        if (getCallback() == null) {
            return null;
        }
        if (this.n == null) {
            this.n = new f9(getCallback(), this.o);
        }
        return this.n;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        this.s = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        dd.c("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View) || ((View) callback).isInEditMode()) {
            return;
        }
        L();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        p();
    }

    public int t() {
        return (int) this.c.i();
    }

    @Nullable
    public Bitmap u(String str) {
        g9 g9VarV = v();
        if (g9VarV != null) {
            return g9VarV.a(str);
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public final g9 v() {
        g9 g9Var = this.j;
        if (g9Var != null) {
            return g9Var;
        }
        if (getCallback() == null) {
            return null;
        }
        g9 g9Var2 = this.k;
        if (g9Var2 != null && !g9Var2.b(r())) {
            this.k = null;
        }
        if (this.k == null) {
            this.k = new g9(getCallback(), this.l, this.m, this.b.i());
        }
        return this.k;
    }

    @Nullable
    public String w() {
        return this.l;
    }

    public float x() {
        return this.c.l();
    }

    public final float y(@NonNull Canvas canvas) {
        return Math.min(canvas.getWidth() / this.b.b().width(), canvas.getHeight() / this.b.b().height());
    }

    public float z() {
        return this.c.m();
    }
}
