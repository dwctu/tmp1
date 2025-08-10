package dc;

import com.bumptech.glide.Registry;
import dc.gi;
import dc.lk;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: DecodeHelper.java */
/* loaded from: classes.dex */
public final class fi<Transcode> {
    public final List<lk.a<?>> a = new ArrayList();
    public final List<xg> b = new ArrayList();
    public mf c;
    public Object d;
    public int e;
    public int f;
    public Class<?> g;
    public gi.e h;
    public ah i;
    public Map<Class<?>, eh<?>> j;
    public Class<Transcode> k;
    public boolean l;
    public boolean m;
    public xg n;
    public of o;
    public ii p;
    public boolean q;
    public boolean r;

    public void a() {
        this.c = null;
        this.d = null;
        this.n = null;
        this.g = null;
        this.k = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.p = null;
        this.a.clear();
        this.l = false;
        this.b.clear();
        this.m = false;
    }

    public zi b() {
        return this.c.b();
    }

    public List<xg> c() {
        if (!this.m) {
            this.m = true;
            this.b.clear();
            List<lk.a<?>> listG = g();
            int size = listG.size();
            for (int i = 0; i < size; i++) {
                lk.a<?> aVar = listG.get(i);
                if (!this.b.contains(aVar.a)) {
                    this.b.add(aVar.a);
                }
                for (int i2 = 0; i2 < aVar.b.size(); i2++) {
                    if (!this.b.contains(aVar.b.get(i2))) {
                        this.b.add(aVar.b.get(i2));
                    }
                }
            }
        }
        return this.b;
    }

    public mj d() {
        return this.h.a();
    }

    public ii e() {
        return this.p;
    }

    public int f() {
        return this.f;
    }

    public List<lk.a<?>> g() {
        if (!this.l) {
            this.l = true;
            this.a.clear();
            List listI = this.c.h().i(this.d);
            int size = listI.size();
            for (int i = 0; i < size; i++) {
                lk.a<?> aVarB = ((lk) listI.get(i)).b(this.d, this.e, this.f, this.i);
                if (aVarB != null) {
                    this.a.add(aVarB);
                }
            }
        }
        return this.a;
    }

    public <Data> ri<Data, ?, Transcode> h(Class<Data> cls) {
        return this.c.h().h(cls, this.g, this.k);
    }

    public Class<?> i() {
        return this.d.getClass();
    }

    public List<lk<File, ?>> j(File file) throws Registry.NoModelLoaderAvailableException {
        return this.c.h().i(file);
    }

    public ah k() {
        return this.i;
    }

    public of l() {
        return this.o;
    }

    public List<Class<?>> m() {
        return this.c.h().j(this.d.getClass(), this.g, this.k);
    }

    public <Z> dh<Z> n(ti<Z> tiVar) {
        return this.c.h().k(tiVar);
    }

    public xg o() {
        return this.n;
    }

    public <X> vg<X> p(X x) throws Registry.NoSourceEncoderAvailableException {
        return this.c.h().m(x);
    }

    public Class<?> q() {
        return this.k;
    }

    public <Z> eh<Z> r(Class<Z> cls) {
        eh<Z> ehVar = (eh) this.j.get(cls);
        if (ehVar == null) {
            Iterator<Map.Entry<Class<?>, eh<?>>> it = this.j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, eh<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    ehVar = (eh) next.getValue();
                    break;
                }
            }
        }
        if (ehVar != null) {
            return ehVar;
        }
        if (!this.j.isEmpty() || !this.q) {
            return el.c();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    public int s() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean t(Class<?> cls) {
        return h(cls) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <R> void u(mf mfVar, Object obj, xg xgVar, int i, int i2, ii iiVar, Class<?> cls, Class<R> cls2, of ofVar, ah ahVar, Map<Class<?>, eh<?>> map, boolean z, boolean z2, gi.e eVar) {
        this.c = mfVar;
        this.d = obj;
        this.n = xgVar;
        this.e = i;
        this.f = i2;
        this.p = iiVar;
        this.g = cls;
        this.h = eVar;
        this.k = cls2;
        this.o = ofVar;
        this.i = ahVar;
        this.j = map;
        this.q = z;
        this.r = z2;
    }

    public boolean v(ti<?> tiVar) {
        return this.c.h().n(tiVar);
    }

    public boolean w() {
        return this.r;
    }

    public boolean x(xg xgVar) {
        List<lk.a<?>> listG = g();
        int size = listG.size();
        for (int i = 0; i < size; i++) {
            if (listG.get(i).a.equals(xgVar)) {
                return true;
            }
        }
        return false;
    }
}
