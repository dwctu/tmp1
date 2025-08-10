package dc;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import dc.kf;
import dc.mj;
import dc.tn;
import dc.uj;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: GlideBuilder.java */
/* loaded from: classes.dex */
public final class lf {
    public ji b;
    public cj c;
    public zi d;
    public tj e;
    public wj f;
    public wj g;
    public mj.a h;
    public uj i;
    public ln j;

    @Nullable
    public tn.b m;
    public wj n;
    public boolean o;

    @Nullable
    public List<po<Object>> p;
    public boolean q;
    public boolean r;
    public final Map<Class<?>, sf<?, ?>> a = new ArrayMap();
    public int k = 4;
    public kf.a l = new a(this);

    /* compiled from: GlideBuilder.java */
    public class a implements kf.a {
        public a(lf lfVar) {
        }

        @Override // dc.kf.a
        @NonNull
        public qo build() {
            return new qo();
        }
    }

    @NonNull
    public kf a(@NonNull Context context) {
        if (this.f == null) {
            this.f = wj.g();
        }
        if (this.g == null) {
            this.g = wj.e();
        }
        if (this.n == null) {
            this.n = wj.c();
        }
        if (this.i == null) {
            this.i = new uj.a(context).a();
        }
        if (this.j == null) {
            this.j = new nn();
        }
        if (this.c == null) {
            int iB = this.i.b();
            if (iB > 0) {
                this.c = new ij(iB);
            } else {
                this.c = new dj();
            }
        }
        if (this.d == null) {
            this.d = new hj(this.i.a());
        }
        if (this.e == null) {
            this.e = new sj(this.i.d());
        }
        if (this.h == null) {
            this.h = new rj(context);
        }
        if (this.b == null) {
            this.b = new ji(this.e, this.h, this.g, this.f, wj.h(), this.n, this.o);
        }
        List<po<Object>> list = this.p;
        if (list == null) {
            this.p = Collections.emptyList();
        } else {
            this.p = Collections.unmodifiableList(list);
        }
        return new kf(context, this.b, this.e, this.c, this.d, new tn(this.m), this.j, this.k, this.l, this.a, this.p, this.q, this.r);
    }

    public void b(@Nullable tn.b bVar) {
        this.m = bVar;
    }
}
