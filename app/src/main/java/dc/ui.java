package dc;

import androidx.annotation.NonNull;
import dc.ei;
import dc.ih;
import dc.lk;
import java.io.File;
import java.util.List;

/* compiled from: ResourceCacheGenerator.java */
/* loaded from: classes.dex */
public class ui implements ei, ih.a<Object> {
    public final ei.a a;
    public final fi<?> b;
    public int c;
    public int d = -1;
    public xg e;
    public List<lk<File, ?>> f;
    public int g;
    public volatile lk.a<?> h;
    public File i;
    public vi j;

    public ui(fi<?> fiVar, ei.a aVar) {
        this.b = fiVar;
        this.a = aVar;
    }

    public final boolean a() {
        return this.g < this.f.size();
    }

    @Override // dc.ih.a
    public void b(@NonNull Exception exc) {
        this.a.a(this.j, exc, this.h.c, sg.RESOURCE_DISK_CACHE);
    }

    @Override // dc.ei
    public boolean c() {
        List<xg> listC = this.b.c();
        boolean z = false;
        if (listC.isEmpty()) {
            return false;
        }
        List<Class<?>> listM = this.b.m();
        if (listM.isEmpty()) {
            if (File.class.equals(this.b.q())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.b.i() + " to " + this.b.q());
        }
        while (true) {
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
            if (i2 >= listM.size()) {
                int i3 = this.c + 1;
                this.c = i3;
                if (i3 >= listC.size()) {
                    return false;
                }
                this.d = 0;
            }
            xg xgVar = listC.get(this.c);
            Class<?> cls = listM.get(this.d);
            this.j = new vi(this.b.b(), xgVar, this.b.o(), this.b.s(), this.b.f(), this.b.r(cls), cls, this.b.k());
            File fileB = this.b.d().b(this.j);
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
        this.a.e(this.e, obj, this.h.c, sg.RESOURCE_DISK_CACHE, this.j);
    }
}
