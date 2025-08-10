package dc;

import dc.qc4;
import java.io.Closeable;
import okhttp3.internal.connection.Exchange;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: Response.java */
/* loaded from: classes5.dex */
public final class ad4 implements Closeable {
    public final yc4 a;
    public final wc4 b;
    public final int c;
    public final String d;
    public final pc4 e;
    public final qc4 f;
    public final bd4 g;
    public final ad4 h;
    public final ad4 i;
    public final ad4 j;
    public final long k;
    public final long l;
    public final Exchange m;
    public volatile zb4 n;

    public ad4(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f.f();
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
    }

    public a A() {
        return new a(this);
    }

    public ad4 C() {
        return this.j;
    }

    public wc4 I() {
        return this.b;
    }

    public long K() {
        return this.l;
    }

    public yc4 L() {
        return this.a;
    }

    public long O() {
        return this.k;
    }

    public bd4 b() {
        return this.g;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        bd4 bd4Var = this.g;
        if (bd4Var == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        bd4Var.close();
    }

    public zb4 e() {
        zb4 zb4Var = this.n;
        if (zb4Var != null) {
            return zb4Var;
        }
        zb4 zb4VarK = zb4.k(this.f);
        this.n = zb4VarK;
        return zb4VarK;
    }

    public int f() {
        return this.c;
    }

    public boolean isSuccessful() {
        int i = this.c;
        return i >= 200 && i < 300;
    }

    public pc4 j() {
        return this.e;
    }

    public String m(String str) {
        return p(str, null);
    }

    public String p(String str, String str2) {
        String strC = this.f.c(str);
        return strC != null ? strC : str2;
    }

    public qc4 q() {
        return this.f;
    }

    public String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.a.j() + MessageFormatter.DELIM_STOP;
    }

    public String x() {
        return this.d;
    }

    public ad4 y() {
        return this.h;
    }

    /* compiled from: Response.java */
    public static class a {
        public yc4 a;
        public wc4 b;
        public int c;
        public String d;
        public pc4 e;
        public qc4.a f;
        public bd4 g;
        public ad4 h;
        public ad4 i;
        public ad4 j;
        public long k;
        public long l;
        public Exchange m;

        public a() {
            this.c = -1;
            this.f = new qc4.a();
        }

        public a a(String str, String str2) {
            this.f.a(str, str2);
            return this;
        }

        public a b(bd4 bd4Var) {
            this.g = bd4Var;
            return this;
        }

        public ad4 c() {
            if (this.a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.c >= 0) {
                if (this.d != null) {
                    return new ad4(this);
                }
                throw new IllegalStateException("message == null");
            }
            throw new IllegalStateException("code < 0: " + this.c);
        }

        public a d(ad4 ad4Var) {
            if (ad4Var != null) {
                f("cacheResponse", ad4Var);
            }
            this.i = ad4Var;
            return this;
        }

        public final void e(ad4 ad4Var) {
            if (ad4Var.g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public final void f(String str, ad4 ad4Var) {
            if (ad4Var.g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (ad4Var.h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (ad4Var.i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (ad4Var.j == null) {
                return;
            }
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }

        public a g(int i) {
            this.c = i;
            return this;
        }

        public a h(pc4 pc4Var) {
            this.e = pc4Var;
            return this;
        }

        public a i(String str, String str2) {
            this.f.i(str, str2);
            return this;
        }

        public a j(qc4 qc4Var) {
            this.f = qc4Var.f();
            return this;
        }

        public void k(Exchange exchange) {
            this.m = exchange;
        }

        public a l(String str) {
            this.d = str;
            return this;
        }

        public a m(ad4 ad4Var) {
            if (ad4Var != null) {
                f("networkResponse", ad4Var);
            }
            this.h = ad4Var;
            return this;
        }

        public a n(ad4 ad4Var) {
            if (ad4Var != null) {
                e(ad4Var);
            }
            this.j = ad4Var;
            return this;
        }

        public a o(wc4 wc4Var) {
            this.b = wc4Var;
            return this;
        }

        public a p(long j) {
            this.l = j;
            return this;
        }

        public a q(yc4 yc4Var) {
            this.a = yc4Var;
            return this;
        }

        public a r(long j) {
            this.k = j;
            return this;
        }

        public a(ad4 ad4Var) {
            this.c = -1;
            this.a = ad4Var.a;
            this.b = ad4Var.b;
            this.c = ad4Var.c;
            this.d = ad4Var.d;
            this.e = ad4Var.e;
            this.f = ad4Var.f.f();
            this.g = ad4Var.g;
            this.h = ad4Var.h;
            this.i = ad4Var.i;
            this.j = ad4Var.j;
            this.k = ad4Var.k;
            this.l = ad4Var.l;
            this.m = ad4Var.m;
        }
    }
}
