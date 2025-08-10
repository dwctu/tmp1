package dc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.load.engine.GlideException;
import dc.ih;
import dc.lk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: MultiModelLoader.java */
/* loaded from: classes.dex */
public class ok<Model, Data> implements lk<Model, Data> {
    public final List<lk<Model, Data>> a;
    public final Pools.Pool<List<Throwable>> b;

    /* compiled from: MultiModelLoader.java */
    public static class a<Data> implements ih<Data>, ih.a<Data> {
        public final List<ih<Data>> a;
        public final Pools.Pool<List<Throwable>> b;
        public int c;
        public of d;
        public ih.a<? super Data> e;

        @Nullable
        public List<Throwable> f;
        public boolean g;

        public a(@NonNull List<ih<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.b = pool;
            vp.c(list);
            this.a = list;
            this.c = 0;
        }

        @Override // dc.ih
        public void a() {
            List<Throwable> list = this.f;
            if (list != null) {
                this.b.release(list);
            }
            this.f = null;
            Iterator<ih<Data>> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }

        @Override // dc.ih.a
        public void b(@NonNull Exception exc) {
            List<Throwable> list = this.f;
            vp.d(list);
            list.add(exc);
            f();
        }

        @Override // dc.ih
        @NonNull
        public sg c() {
            return this.a.get(0).c();
        }

        @Override // dc.ih
        public void cancel() {
            this.g = true;
            Iterator<ih<Data>> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }

        @Override // dc.ih
        public void d(@NonNull of ofVar, @NonNull ih.a<? super Data> aVar) {
            this.d = ofVar;
            this.e = aVar;
            this.f = this.b.acquire();
            this.a.get(this.c).d(ofVar, this);
            if (this.g) {
                cancel();
            }
        }

        @Override // dc.ih.a
        public void e(@Nullable Data data) {
            if (data != null) {
                this.e.e(data);
            } else {
                f();
            }
        }

        public final void f() {
            if (this.g) {
                return;
            }
            if (this.c < this.a.size() - 1) {
                this.c++;
                d(this.d, this.e);
            } else {
                vp.d(this.f);
                this.e.b(new GlideException("Fetch failed", new ArrayList(this.f)));
            }
        }

        @Override // dc.ih
        @NonNull
        public Class<Data> getDataClass() {
            return this.a.get(0).getDataClass();
        }
    }

    public ok(@NonNull List<lk<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.a = list;
        this.b = pool;
    }

    @Override // dc.lk
    public boolean a(@NonNull Model model) {
        Iterator<lk<Model, Data>> it = this.a.iterator();
        while (it.hasNext()) {
            if (it.next().a(model)) {
                return true;
            }
        }
        return false;
    }

    @Override // dc.lk
    public lk.a<Data> b(@NonNull Model model, int i, int i2, @NonNull ah ahVar) {
        lk.a<Data> aVarB;
        int size = this.a.size();
        ArrayList arrayList = new ArrayList(size);
        xg xgVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            lk<Model, Data> lkVar = this.a.get(i3);
            if (lkVar.a(model) && (aVarB = lkVar.b(model, i, i2, ahVar)) != null) {
                xgVar = aVarB.a;
                arrayList.add(aVarB.c);
            }
        }
        if (arrayList.isEmpty() || xgVar == null) {
            return null;
        }
        return new lk.a<>(xgVar, new a(arrayList, this.b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.a.toArray()) + MessageFormatter.DELIM_STOP;
    }
}
