package dc;

/* compiled from: WebpFrameCacheStrategy.java */
/* loaded from: classes.dex */
public final class qg {
    public static final qg c;
    public static final qg d;
    public c a;
    public int b;

    /* compiled from: WebpFrameCacheStrategy.java */
    public static final class b {
        public c a;
        public int b;

        public qg c() {
            return new qg(this);
        }

        public b d() {
            this.a = c.CACHE_ALL;
            return this;
        }

        public b e() {
            this.a = c.CACHE_AUTO;
            return this;
        }

        public b f() {
            this.a = c.CACHE_NONE;
            return this;
        }
    }

    /* compiled from: WebpFrameCacheStrategy.java */
    public enum c {
        CACHE_NONE,
        CACHE_LIMITED,
        CACHE_AUTO,
        CACHE_ALL
    }

    static {
        b bVar = new b();
        bVar.f();
        c = bVar.c();
        b bVar2 = new b();
        bVar2.e();
        d = bVar2.c();
        b bVar3 = new b();
        bVar3.d();
        bVar3.c();
    }

    public boolean a() {
        return this.a == c.CACHE_ALL;
    }

    public int b() {
        return this.b;
    }

    public boolean c() {
        return this.a == c.CACHE_NONE;
    }

    public qg(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
    }
}
