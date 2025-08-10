package dc;

import androidx.annotation.NonNull;
import dc.ei;
import dc.ih;
import dc.lk;
import java.io.File;
import java.util.List;

/* compiled from: DataCacheGenerator.java */
/* loaded from: classes.dex */
public class bi implements ei, ih.a<Object> {
    public final List<xg> a;
    public final fi<?> b;
    public final ei.a c;
    public int d;
    public xg e;
    public List<lk<File, ?>> f;
    public int g;
    public volatile lk.a<?> h;
    public File i;

    public bi(fi<?> fiVar, ei.a aVar) {
        this(fiVar.c(), fiVar, aVar);
    }

    public final boolean a() {
        return this.g < this.f.size();
    }

    @Override // dc.ih.a
    public void b(@NonNull Exception exc) {
        this.c.a(this.e, exc, this.h.c, sg.DATA_DISK_CACHE);
    }

    @Override // dc.ei
    public boolean c() {
        while (true) {
            boolean z = false;
            if (this.f != null && a()) {
                this.h = null;
                while (!z && a()) {
                    List<lk<File, ?>> list = this.f;
                    int i = this.g;
                    this.g = i + 1;
                    this.h = list.get(i).b(this.i, this.b.s(), this.b.f(), this.b.k());
                    if (this.h != null && this.b.t(this.h.c.getDataClass())) {
                        this.h.c.d(this.b.l(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i2 = this.d + 1;
            this.d = i2;
            if (i2 >= this.a.size()) {
                return false;
            }
            xg xgVar = this.a.get(this.d);
            File fileB = this.b.d().b(new ci(xgVar, this.b.o()));
            this.i = fileB;
            if (fileB != null) {
                this.e = xgVar;
                this.f = this.b.j(fileB);
                this.g = 0;
            }
        }
    }

    @Override // dc.ei
    public void cancel() {
        lk.a<?> aVar = this.h;
        if (aVar != null) {
            aVar.c.cancel();
        }
    }

    @Override // dc.ih.a
    public void e(Object obj) {
        this.c.e(this.e, obj, this.h.c, sg.DATA_DISK_CACHE, this.e);
    }

    public bi(List<xg> list, fi<?> fiVar, ei.a aVar) {
        this.d = -1;
        this.a = list;
        this.b = fiVar;
        this.c = aVar;
    }
}
