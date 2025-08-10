package dc;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: BasicContainer.java */
/* loaded from: classes2.dex */
public class h41 implements jf0, Iterator<hf0>, Closeable {
    public static final hf0 g = new a("eof ");
    public af0 a;
    public i41 b;
    public hf0 c = null;
    public long d = 0;
    public long e = 0;
    public List<hf0> f = new ArrayList();

    /* compiled from: BasicContainer.java */
    public class a extends e41 {
        public a(String str) {
            super(str);
        }

        @Override // dc.e41
        public void a(ByteBuffer byteBuffer) {
        }

        @Override // dc.e41
        public void c(ByteBuffer byteBuffer) {
        }

        @Override // dc.e41
        public long d() {
            return 0L;
        }
    }

    static {
        g51.a(h41.class);
    }

    public void close() throws IOException {
        this.b.close();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        hf0 hf0Var = this.c;
        if (hf0Var == g) {
            return false;
        }
        if (hf0Var != null) {
            return true;
        }
        try {
            this.c = next();
            return true;
        } catch (NoSuchElementException unused) {
            this.c = g;
            return false;
        }
    }

    public void j(hf0 hf0Var) {
        if (hf0Var != null) {
            this.f = new ArrayList(m());
            hf0Var.f(this);
            this.f.add(hf0Var);
        }
    }

    public List<hf0> m() {
        return (this.b == null || this.c == g) ? this.f : new f51(this.f, this);
    }

    public long p() {
        long jB = 0;
        for (int i = 0; i < m().size(); i++) {
            jB += this.f.get(i).b();
        }
        return jB;
    }

    @Override // java.util.Iterator
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public hf0 next() {
        hf0 hf0VarA;
        hf0 hf0Var = this.c;
        if (hf0Var != null && hf0Var != g) {
            this.c = null;
            return hf0Var;
        }
        i41 i41Var = this.b;
        if (i41Var == null || this.d >= this.e) {
            this.c = g;
            throw new NoSuchElementException();
        }
        try {
            synchronized (i41Var) {
                this.b.G(this.d);
                hf0VarA = this.a.a(this.b, this);
                this.d = this.b.o();
            }
            return hf0VarA;
        } catch (EOFException unused) {
            throw new NoSuchElementException();
        } catch (IOException unused2) {
            throw new NoSuchElementException();
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.f.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(this.f.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public final void x(WritableByteChannel writableByteChannel) throws IOException {
        Iterator<hf0> it = m().iterator();
        while (it.hasNext()) {
            it.next().e(writableByteChannel);
        }
    }
}
