package dc;

import dc.mj;
import java.io.File;

/* compiled from: DiskLruCacheFactory.java */
/* loaded from: classes.dex */
public class pj implements mj.a {
    public final long a;
    public final a b;

    /* compiled from: DiskLruCacheFactory.java */
    public interface a {
        File a();
    }

    public pj(a aVar, long j) {
        this.a = j;
        this.b = aVar;
    }

    @Override // dc.mj.a
    public mj build() {
        File fileA = this.b.a();
        if (fileA == null) {
            return null;
        }
        if (fileA.mkdirs() || (fileA.exists() && fileA.isDirectory())) {
            return qj.c(fileA, this.a);
        }
        return null;
    }
}
