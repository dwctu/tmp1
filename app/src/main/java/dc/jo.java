package dc;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import dc.jo;
import java.util.Map;

/* compiled from: BaseRequestOptions.java */
/* loaded from: classes.dex */
public abstract class jo<T extends jo<T>> implements Cloneable {
    public int a;

    @Nullable
    public Drawable e;
    public int f;

    @Nullable
    public Drawable g;
    public int h;
    public boolean m;

    @Nullable
    public Drawable o;
    public int p;
    public boolean t;

    @Nullable
    public Resources.Theme u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean z;
    public float b = 1.0f;

    @NonNull
    public ii c = ii.e;

    @NonNull
    public of d = of.NORMAL;
    public boolean i = true;
    public int j = -1;
    public int k = -1;

    @NonNull
    public xg l = lp.c();
    public boolean n = true;

    @NonNull
    public ah q = new ah();

    @NonNull
    public Map<Class<?>, eh<?>> r = new CachedHashCodeArrayMap();

    @NonNull
    public Class<?> s = Object.class;
    public boolean y = true;

    public static boolean K(int i, int i2) {
        return (i & i2) != 0;
    }

    @NonNull
    public final xg A() {
        return this.l;
    }

    public final float B() {
        return this.b;
    }

    @Nullable
    public final Resources.Theme C() {
        return this.u;
    }

    @NonNull
    public final Map<Class<?>, eh<?>> D() {
        return this.r;
    }

    public final boolean E() {
        return this.z;
    }

    public final boolean F() {
        return this.w;
    }

    public final boolean G() {
        return this.i;
    }

    public final boolean H() {
        return J(8);
    }

    public boolean I() {
        return this.y;
    }

    public final boolean J(int i) {
        return K(this.a, i);
    }

    public final boolean L() {
        return this.n;
    }

    public final boolean M() {
        return this.m;
    }

    public final boolean N() {
        return J(2048);
    }

    public final boolean O() {
        return wp.t(this.k, this.j);
    }

    @NonNull
    public T P() {
        this.t = true;
        c0();
        return this;
    }

    @NonNull
    @CheckResult
    public T Q() {
        return (T) U(ql.c, new nl());
    }

    @NonNull
    @CheckResult
    public T R() {
        return (T) T(ql.b, new ol());
    }

    @NonNull
    @CheckResult
    public T S() {
        return (T) T(ql.a, new vl());
    }

    @NonNull
    public final T T(@NonNull ql qlVar, @NonNull eh<Bitmap> ehVar) {
        return (T) b0(qlVar, ehVar, false);
    }

    @NonNull
    public final T U(@NonNull ql qlVar, @NonNull eh<Bitmap> ehVar) {
        if (this.v) {
            return (T) clone().U(qlVar, ehVar);
        }
        g(qlVar);
        return (T) k0(ehVar, false);
    }

    @NonNull
    @CheckResult
    public T V(int i) {
        return (T) W(i, i);
    }

    @NonNull
    @CheckResult
    public T W(int i, int i2) {
        if (this.v) {
            return (T) clone().W(i, i2);
        }
        this.k = i;
        this.j = i2;
        this.a |= 512;
        d0();
        return this;
    }

    @NonNull
    @CheckResult
    public T X(@DrawableRes int i) {
        if (this.v) {
            return (T) clone().X(i);
        }
        this.h = i;
        int i2 = this.a | 128;
        this.a = i2;
        this.g = null;
        this.a = i2 & (-65);
        d0();
        return this;
    }

    @NonNull
    @CheckResult
    public T Y(@Nullable Drawable drawable) {
        if (this.v) {
            return (T) clone().Y(drawable);
        }
        this.g = drawable;
        int i = this.a | 64;
        this.a = i;
        this.h = 0;
        this.a = i & (-129);
        d0();
        return this;
    }

    @NonNull
    @CheckResult
    public T Z(@NonNull of ofVar) {
        if (this.v) {
            return (T) clone().Z(ofVar);
        }
        vp.d(ofVar);
        this.d = ofVar;
        this.a |= 8;
        d0();
        return this;
    }

    @NonNull
    @CheckResult
    public T a(@NonNull jo<?> joVar) {
        if (this.v) {
            return (T) clone().a(joVar);
        }
        if (K(joVar.a, 2)) {
            this.b = joVar.b;
        }
        if (K(joVar.a, 262144)) {
            this.w = joVar.w;
        }
        if (K(joVar.a, 1048576)) {
            this.z = joVar.z;
        }
        if (K(joVar.a, 4)) {
            this.c = joVar.c;
        }
        if (K(joVar.a, 8)) {
            this.d = joVar.d;
        }
        if (K(joVar.a, 16)) {
            this.e = joVar.e;
            this.f = 0;
            this.a &= -33;
        }
        if (K(joVar.a, 32)) {
            this.f = joVar.f;
            this.e = null;
            this.a &= -17;
        }
        if (K(joVar.a, 64)) {
            this.g = joVar.g;
            this.h = 0;
            this.a &= -129;
        }
        if (K(joVar.a, 128)) {
            this.h = joVar.h;
            this.g = null;
            this.a &= -65;
        }
        if (K(joVar.a, 256)) {
            this.i = joVar.i;
        }
        if (K(joVar.a, 512)) {
            this.k = joVar.k;
            this.j = joVar.j;
        }
        if (K(joVar.a, 1024)) {
            this.l = joVar.l;
        }
        if (K(joVar.a, 4096)) {
            this.s = joVar.s;
        }
        if (K(joVar.a, 8192)) {
            this.o = joVar.o;
            this.p = 0;
            this.a &= -16385;
        }
        if (K(joVar.a, 16384)) {
            this.p = joVar.p;
            this.o = null;
            this.a &= -8193;
        }
        if (K(joVar.a, 32768)) {
            this.u = joVar.u;
        }
        if (K(joVar.a, 65536)) {
            this.n = joVar.n;
        }
        if (K(joVar.a, 131072)) {
            this.m = joVar.m;
        }
        if (K(joVar.a, 2048)) {
            this.r.putAll(joVar.r);
            this.y = joVar.y;
        }
        if (K(joVar.a, 524288)) {
            this.x = joVar.x;
        }
        if (!this.n) {
            this.r.clear();
            int i = this.a & (-2049);
            this.a = i;
            this.m = false;
            this.a = i & (-131073);
            this.y = true;
        }
        this.a |= joVar.a;
        this.q.d(joVar.q);
        d0();
        return this;
    }

    @NonNull
    public final T a0(@NonNull ql qlVar, @NonNull eh<Bitmap> ehVar) {
        return (T) b0(qlVar, ehVar, true);
    }

    @NonNull
    public T b() {
        if (this.t && !this.v) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.v = true;
        return (T) P();
    }

    @NonNull
    public final T b0(@NonNull ql qlVar, @NonNull eh<Bitmap> ehVar, boolean z) {
        T t = z ? (T) l0(qlVar, ehVar) : (T) U(qlVar, ehVar);
        t.y = true;
        return t;
    }

    @NonNull
    @CheckResult
    public T c() {
        return (T) l0(ql.c, new nl());
    }

    public final T c0() {
        return this;
    }

    @Override // 
    @CheckResult
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public T clone() {
        try {
            T t = (T) super.clone();
            ah ahVar = new ah();
            t.q = ahVar;
            ahVar.d(this.q);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            t.r = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.r);
            t.t = false;
            t.v = false;
            return t;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    public final T d0() {
        if (this.t) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        c0();
        return this;
    }

    @NonNull
    @CheckResult
    public T e(@NonNull Class<?> cls) {
        if (this.v) {
            return (T) clone().e(cls);
        }
        vp.d(cls);
        this.s = cls;
        this.a |= 4096;
        d0();
        return this;
    }

    @NonNull
    @CheckResult
    public <Y> T e0(@NonNull zg<Y> zgVar, @NonNull Y y) {
        if (this.v) {
            return (T) clone().e0(zgVar, y);
        }
        vp.d(zgVar);
        vp.d(y);
        this.q.e(zgVar, y);
        d0();
        return this;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof jo)) {
            return false;
        }
        jo joVar = (jo) obj;
        return Float.compare(joVar.b, this.b) == 0 && this.f == joVar.f && wp.d(this.e, joVar.e) && this.h == joVar.h && wp.d(this.g, joVar.g) && this.p == joVar.p && wp.d(this.o, joVar.o) && this.i == joVar.i && this.j == joVar.j && this.k == joVar.k && this.m == joVar.m && this.n == joVar.n && this.w == joVar.w && this.x == joVar.x && this.c.equals(joVar.c) && this.d == joVar.d && this.q.equals(joVar.q) && this.r.equals(joVar.r) && this.s.equals(joVar.s) && wp.d(this.l, joVar.l) && wp.d(this.u, joVar.u);
    }

    @NonNull
    @CheckResult
    public T f(@NonNull ii iiVar) {
        if (this.v) {
            return (T) clone().f(iiVar);
        }
        vp.d(iiVar);
        this.c = iiVar;
        this.a |= 4;
        d0();
        return this;
    }

    @NonNull
    @CheckResult
    public T f0(@NonNull xg xgVar) {
        if (this.v) {
            return (T) clone().f0(xgVar);
        }
        vp.d(xgVar);
        this.l = xgVar;
        this.a |= 1024;
        d0();
        return this;
    }

    @NonNull
    @CheckResult
    public T g(@NonNull ql qlVar) {
        zg zgVar = ql.f;
        vp.d(qlVar);
        return (T) e0(zgVar, qlVar);
    }

    @NonNull
    @CheckResult
    public T g0(@FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f) {
        if (this.v) {
            return (T) clone().g0(f);
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.b = f;
        this.a |= 2;
        d0();
        return this;
    }

    @NonNull
    @CheckResult
    public T h(@DrawableRes int i) {
        if (this.v) {
            return (T) clone().h(i);
        }
        this.f = i;
        int i2 = this.a | 32;
        this.a = i2;
        this.e = null;
        this.a = i2 & (-17);
        d0();
        return this;
    }

    @NonNull
    @CheckResult
    public T h0(boolean z) {
        if (this.v) {
            return (T) clone().h0(true);
        }
        this.i = !z;
        this.a |= 256;
        d0();
        return this;
    }

    public int hashCode() {
        return wp.o(this.u, wp.o(this.l, wp.o(this.s, wp.o(this.r, wp.o(this.q, wp.o(this.d, wp.o(this.c, wp.p(this.x, wp.p(this.w, wp.p(this.n, wp.p(this.m, wp.n(this.k, wp.n(this.j, wp.p(this.i, wp.o(this.o, wp.n(this.p, wp.o(this.g, wp.n(this.h, wp.o(this.e, wp.n(this.f, wp.k(this.b)))))))))))))))))))));
    }

    @NonNull
    @CheckResult
    public T i(@Nullable Drawable drawable) {
        if (this.v) {
            return (T) clone().i(drawable);
        }
        this.e = drawable;
        int i = this.a | 16;
        this.a = i;
        this.f = 0;
        this.a = i & (-33);
        d0();
        return this;
    }

    @NonNull
    @CheckResult
    public T i0(@IntRange(from = 0) int i) {
        return (T) e0(wk.b, Integer.valueOf(i));
    }

    @NonNull
    @CheckResult
    public T j0(@NonNull eh<Bitmap> ehVar) {
        return (T) k0(ehVar, true);
    }

    @NonNull
    @CheckResult
    public T k(@DrawableRes int i) {
        if (this.v) {
            return (T) clone().k(i);
        }
        this.p = i;
        int i2 = this.a | 16384;
        this.a = i2;
        this.o = null;
        this.a = i2 & (-8193);
        d0();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public T k0(@NonNull eh<Bitmap> ehVar, boolean z) {
        if (this.v) {
            return (T) clone().k0(ehVar, z);
        }
        tl tlVar = new tl(ehVar, z);
        m0(Bitmap.class, ehVar, z);
        m0(Drawable.class, tlVar, z);
        tlVar.c();
        m0(BitmapDrawable.class, tlVar, z);
        m0(GifDrawable.class, new wm(ehVar), z);
        d0();
        return this;
    }

    @NonNull
    @CheckResult
    public T l() {
        return (T) a0(ql.a, new vl());
    }

    @NonNull
    @CheckResult
    public final T l0(@NonNull ql qlVar, @NonNull eh<Bitmap> ehVar) {
        if (this.v) {
            return (T) clone().l0(qlVar, ehVar);
        }
        g(qlVar);
        return (T) j0(ehVar);
    }

    @NonNull
    @CheckResult
    public T m(@NonNull tg tgVar) {
        vp.d(tgVar);
        return (T) e0(rl.f, tgVar).e0(zm.a, tgVar);
    }

    @NonNull
    public <Y> T m0(@NonNull Class<Y> cls, @NonNull eh<Y> ehVar, boolean z) {
        if (this.v) {
            return (T) clone().m0(cls, ehVar, z);
        }
        vp.d(cls);
        vp.d(ehVar);
        this.r.put(cls, ehVar);
        int i = this.a | 2048;
        this.a = i;
        this.n = true;
        int i2 = i | 65536;
        this.a = i2;
        this.y = false;
        if (z) {
            this.a = i2 | 131072;
            this.m = true;
        }
        d0();
        return this;
    }

    @NonNull
    public final ii n() {
        return this.c;
    }

    @NonNull
    @CheckResult
    public T n0(@NonNull eh<Bitmap>... ehVarArr) {
        if (ehVarArr.length > 1) {
            return (T) k0(new yg(ehVarArr), true);
        }
        if (ehVarArr.length == 1) {
            return (T) j0(ehVarArr[0]);
        }
        d0();
        return this;
    }

    public final int o() {
        return this.f;
    }

    @NonNull
    @CheckResult
    public T o0(boolean z) {
        if (this.v) {
            return (T) clone().o0(z);
        }
        this.z = z;
        this.a |= 1048576;
        d0();
        return this;
    }

    @Nullable
    public final Drawable p() {
        return this.e;
    }

    @Nullable
    public final Drawable q() {
        return this.o;
    }

    public final int r() {
        return this.p;
    }

    public final boolean s() {
        return this.x;
    }

    @NonNull
    public final ah t() {
        return this.q;
    }

    public final int u() {
        return this.j;
    }

    public final int v() {
        return this.k;
    }

    @Nullable
    public final Drawable w() {
        return this.g;
    }

    public final int x() {
        return this.h;
    }

    @NonNull
    public final of y() {
        return this.d;
    }

    @NonNull
    public final Class<?> z() {
        return this.s;
    }
}
