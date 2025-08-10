package dc;

import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.collect.LinkedHashMultimap;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseKeyframeAnimation.java */
/* loaded from: classes.dex */
public abstract class p8<K, A> {
    public final d<K> c;

    @Nullable
    public kd<A> e;
    public final List<b> a = new ArrayList(1);
    public boolean b = false;
    public float d = 0.0f;

    @Nullable
    public A f = null;
    public float g = -1.0f;
    public float h = -1.0f;

    /* compiled from: BaseKeyframeAnimation.java */
    public interface b {
        void a();
    }

    /* compiled from: BaseKeyframeAnimation.java */
    public static final class c<T> implements d<T> {
        public c() {
        }

        @Override // dc.p8.d
        public boolean a(float f) {
            throw new IllegalStateException("not implemented");
        }

        @Override // dc.p8.d
        public id<T> b() {
            throw new IllegalStateException("not implemented");
        }

        @Override // dc.p8.d
        public boolean c(float f) {
            return false;
        }

        @Override // dc.p8.d
        public float d() {
            return 0.0f;
        }

        @Override // dc.p8.d
        public float e() {
            return 1.0f;
        }

        @Override // dc.p8.d
        public boolean isEmpty() {
            return true;
        }
    }

    /* compiled from: BaseKeyframeAnimation.java */
    public interface d<T> {
        boolean a(float f);

        id<T> b();

        boolean c(float f);

        @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
        float d();

        @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
        float e();

        boolean isEmpty();
    }

    /* compiled from: BaseKeyframeAnimation.java */
    public static final class e<T> implements d<T> {
        public final List<? extends id<T>> a;
        public id<T> c = null;
        public float d = -1.0f;

        @NonNull
        public id<T> b = f(0.0f);

        public e(List<? extends id<T>> list) {
            this.a = list;
        }

        @Override // dc.p8.d
        public boolean a(float f) {
            id<T> idVar = this.c;
            id<T> idVar2 = this.b;
            if (idVar == idVar2 && this.d == f) {
                return true;
            }
            this.c = idVar2;
            this.d = f;
            return false;
        }

        @Override // dc.p8.d
        @NonNull
        public id<T> b() {
            return this.b;
        }

        @Override // dc.p8.d
        public boolean c(float f) {
            if (this.b.a(f)) {
                return !this.b.h();
            }
            this.b = f(f);
            return true;
        }

        @Override // dc.p8.d
        public float d() {
            return this.a.get(0).e();
        }

        @Override // dc.p8.d
        public float e() {
            return this.a.get(r0.size() - 1).b();
        }

        public final id<T> f(float f) {
            List<? extends id<T>> list = this.a;
            id<T> idVar = list.get(list.size() - 1);
            if (f >= idVar.e()) {
                return idVar;
            }
            for (int size = this.a.size() - 2; size >= 1; size--) {
                id<T> idVar2 = this.a.get(size);
                if (this.b != idVar2 && idVar2.a(f)) {
                    return idVar2;
                }
            }
            return this.a.get(0);
        }

        @Override // dc.p8.d
        public boolean isEmpty() {
            return false;
        }
    }

    /* compiled from: BaseKeyframeAnimation.java */
    public static final class f<T> implements d<T> {

        @NonNull
        public final id<T> a;
        public float b = -1.0f;

        public f(List<? extends id<T>> list) {
            this.a = list.get(0);
        }

        @Override // dc.p8.d
        public boolean a(float f) {
            if (this.b == f) {
                return true;
            }
            this.b = f;
            return false;
        }

        @Override // dc.p8.d
        public id<T> b() {
            return this.a;
        }

        @Override // dc.p8.d
        public boolean c(float f) {
            return !this.a.h();
        }

        @Override // dc.p8.d
        public float d() {
            return this.a.e();
        }

        @Override // dc.p8.d
        public float e() {
            return this.a.b();
        }

        @Override // dc.p8.d
        public boolean isEmpty() {
            return false;
        }
    }

    public p8(List<? extends id<K>> list) {
        this.c = o(list);
    }

    public static <T> d<T> o(List<? extends id<T>> list) {
        return list.isEmpty() ? new c() : list.size() == 1 ? new f(list) : new e(list);
    }

    public void a(b bVar) {
        this.a.add(bVar);
    }

    public id<K> b() {
        e7.a("BaseKeyframeAnimation#getCurrentKeyframe");
        id<K> idVarB = this.c.b();
        e7.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return idVarB;
    }

    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
    public float c() {
        if (this.h == -1.0f) {
            this.h = this.c.e();
        }
        return this.h;
    }

    public float d() {
        id<K> idVarB = b();
        if (idVarB.h()) {
            return 0.0f;
        }
        return idVarB.d.getInterpolation(e());
    }

    public float e() {
        if (this.b) {
            return 0.0f;
        }
        id<K> idVarB = b();
        if (idVarB.h()) {
            return 0.0f;
        }
        return (this.d - idVarB.e()) / (idVarB.b() - idVarB.e());
    }

    public float f() {
        return this.d;
    }

    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
    public final float g() {
        if (this.g == -1.0f) {
            this.g = this.c.d();
        }
        return this.g;
    }

    public A h() {
        float fE = e();
        if (this.e == null && this.c.a(fE)) {
            return this.f;
        }
        id<K> idVarB = b();
        Interpolator interpolator = idVarB.e;
        A aI = (interpolator == null || idVarB.f == null) ? i(idVarB, d()) : j(idVarB, fE, interpolator.getInterpolation(fE), idVarB.f.getInterpolation(fE));
        this.f = aI;
        return aI;
    }

    public abstract A i(id<K> idVar, float f2);

    public A j(id<K> idVar, float f2, float f3, float f4) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public void k() {
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).a();
        }
    }

    public void l() {
        this.b = true;
    }

    public void m(@FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f2) {
        if (this.c.isEmpty()) {
            return;
        }
        if (f2 < g()) {
            f2 = g();
        } else if (f2 > c()) {
            f2 = c();
        }
        if (f2 == this.d) {
            return;
        }
        this.d = f2;
        if (this.c.c(f2)) {
            k();
        }
    }

    public void n(@Nullable kd<A> kdVar) {
        kd<A> kdVar2 = this.e;
        if (kdVar2 != null) {
            kdVar2.c(null);
        }
        this.e = kdVar;
        if (kdVar != null) {
            kdVar.c(this);
        }
    }
}
