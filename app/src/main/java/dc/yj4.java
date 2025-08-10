package dc;

/* compiled from: VideoViewConfig.java */
/* loaded from: classes5.dex */
public class yj4 {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final xj4 e;
    public final wj4 f;
    public final int g;
    public final ck4 h;
    public final boolean i;

    /* compiled from: VideoViewConfig.java */
    public static final class b {
        public boolean a;
        public boolean c;
        public xj4 e;
        public wj4 f;
        public int g;
        public ck4 h;
        public boolean b = true;
        public boolean d = true;
        public boolean i = true;

        public yj4 j() {
            return new yj4(this);
        }
    }

    public static b a() {
        return new b();
    }

    public yj4(b bVar) {
        this.d = bVar.a;
        this.b = bVar.c;
        this.a = bVar.b;
        this.c = bVar.d;
        xj4 unused = bVar.e;
        this.g = bVar.g;
        if (bVar.f == null) {
            this.f = uj4.b();
        } else {
            this.f = bVar.f;
        }
        if (bVar.h == null) {
            this.h = dk4.b();
        } else {
            this.h = bVar.h;
        }
        this.i = bVar.i;
    }
}
