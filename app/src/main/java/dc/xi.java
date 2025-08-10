package dc;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dc.ei;
import dc.ih;
import dc.lk;
import java.util.Collections;
import java.util.List;

/* compiled from: SourceGenerator.java */
/* loaded from: classes.dex */
public class xi implements ei, ei.a {
    public final fi<?> a;
    public final ei.a b;
    public int c;
    public bi d;
    public Object e;
    public volatile lk.a<?> f;
    public ci g;

    /* compiled from: SourceGenerator.java */
    public class a implements ih.a<Object> {
        public final /* synthetic */ lk.a a;

        public a(lk.a aVar) {
            this.a = aVar;
        }

        @Override // dc.ih.a
        public void b(@NonNull Exception exc) {
            if (xi.this.g(this.a)) {
                xi.this.i(this.a, exc);
            }
        }

        @Override // dc.ih.a
        public void e(@Nullable Object obj) {
            if (xi.this.g(this.a)) {
                xi.this.h(this.a, obj);
            }
        }
    }

    public xi(fi<?> fiVar, ei.a aVar) {
        this.a = fiVar;
        this.b = aVar;
    }

    @Override // dc.ei.a
    public void a(xg xgVar, Exception exc, ih<?> ihVar, sg sgVar) {
        this.b.a(xgVar, exc, ihVar, this.f.c.c());
    }

    @Override // dc.ei.a
    public void b() {
        throw new UnsupportedOperationException();
    }

    @Override // dc.ei
    public boolean c() {
        Object obj = this.e;
        if (obj != null) {
            this.e = null;
            d(obj);
        }
        bi biVar = this.d;
        if (biVar != null && biVar.c()) {
            return true;
        }
        this.d = null;
        this.f = null;
        boolean z = false;
        while (!z && f()) {
            List<lk.a<?>> listG = this.a.g();
            int i = this.c;
            this.c = i + 1;
            this.f = listG.get(i);
            if (this.f != null && (this.a.e().c(this.f.c.c()) || this.a.t(this.f.c.getDataClass()))) {
                j(this.f);
                z = true;
            }
        }
        return z;
    }

    @Override // dc.ei
    public void cancel() {
        lk.a<?> aVar = this.f;
        if (aVar != null) {
            aVar.c.cancel();
        }
    }

    public final void d(Object obj) {
        long jB = rp.b();
        try {
            vg<X> vgVarP = this.a.p(obj);
            di diVar = new di(vgVarP, obj, this.a.k());
            this.g = new ci(this.f.a, this.a.o());
            this.a.d().a(this.g, diVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                String str = "Finished encoding source to cache, key: " + this.g + ", data: " + obj + ", encoder: " + vgVarP + ", duration: " + rp.a(jB);
            }
            this.f.c.a();
            this.d = new bi(Collections.singletonList(this.f.a), this.a, this);
        } catch (Throwable th) {
            this.f.c.a();
            throw th;
        }
    }

    @Override // dc.ei.a
    public void e(xg xgVar, Object obj, ih<?> ihVar, sg sgVar, xg xgVar2) {
        this.b.e(xgVar, obj, ihVar, this.f.c.c(), xgVar);
    }

    public final boolean f() {
        return this.c < this.a.g().size();
    }

    public boolean g(lk.a<?> aVar) {
        lk.a<?> aVar2 = this.f;
        return aVar2 != null && aVar2 == aVar;
    }

    public void h(lk.a<?> aVar, Object obj) {
        ii iiVarE = this.a.e();
        if (obj != null && iiVarE.c(aVar.c.c())) {
            this.e = obj;
            this.b.b();
        } else {
            ei.a aVar2 = this.b;
            xg xgVar = aVar.a;
            ih<?> ihVar = aVar.c;
            aVar2.e(xgVar, obj, ihVar, ihVar.c(), this.g);
        }
    }

    public void i(lk.a<?> aVar, @NonNull Exception exc) {
        ei.a aVar2 = this.b;
        ci ciVar = this.g;
        ih<?> ihVar = aVar.c;
        aVar2.a(ciVar, exc, ihVar, ihVar.c());
    }

    public final void j(lk.a<?> aVar) {
        this.f.c.d(this.a.l(), new a(aVar));
    }
}
