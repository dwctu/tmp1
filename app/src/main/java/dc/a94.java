package dc;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;
import net.lingala.zip4j.exception.ZipException;

/* compiled from: ZipInputStream.java */
/* loaded from: classes5.dex */
public class a94 extends InputStream {
    public PushbackInputStream a;
    public s84 b;
    public n84 c;
    public char[] d;
    public ga4 e;
    public l94 f;
    public CRC32 g;
    public byte[] h;
    public boolean i;
    public n94 j;
    public boolean k;
    public boolean l;

    public a94(InputStream inputStream, char[] cArr, n94 n94Var) {
        this(inputStream, cArr, null, n94Var);
    }

    public final s84 A(l94 l94Var) throws IOException {
        return y(x(new z84(this.a, m(l94Var)), l94Var), l94Var);
    }

    public final boolean C(l94 l94Var) {
        return l94Var.p() && w94.ZIP_STANDARD.equals(l94Var.f());
    }

    public final boolean I(String str) {
        return str.endsWith("/") || str.endsWith("\\");
    }

    public final void K() throws IOException {
        if (!this.f.n() || this.i) {
            return;
        }
        g94 g94VarJ = this.c.j(this.a, e(this.f.g()));
        this.f.s(g94VarJ.b());
        this.f.G(g94VarJ.d());
        this.f.u(g94VarJ.c());
    }

    public final void L() throws IOException {
        if (this.h == null) {
            this.h = new byte[512];
        }
        while (read(this.h) != -1) {
        }
        this.l = true;
    }

    public final void O() {
        this.f = null;
        this.g.reset();
    }

    public void V(char[] cArr) {
        this.d = cArr;
    }

    public final void X() throws IOException {
        if ((this.f.f() == w94.AES && this.f.b().c().equals(u94.TWO)) || this.f.e() == this.g.getValue()) {
            return;
        }
        ZipException.a aVar = ZipException.a.CHECKSUM_MISMATCH;
        if (C(this.f)) {
            aVar = ZipException.a.WRONG_PASSWORD;
        }
        throw new ZipException("Reached end of entry, but crc verification failed for " + this.f.i(), aVar);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        b();
        return !this.l ? 1 : 0;
    }

    public final void b() throws IOException {
        if (this.k) {
            throw new IOException("Stream closed");
        }
    }

    public final void b0(l94 l94Var) throws IOException {
        if (I(l94Var.i()) || l94Var.d() != v94.STORE || l94Var.l() >= 0) {
            return;
        }
        throw new IOException("Invalid local file header for: " + l94Var.i() + ". Uncompressed size has to be set for entry of compression type store which is not a directory");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.k) {
            return;
        }
        s84 s84Var = this.b;
        if (s84Var != null) {
            s84Var.close();
        }
        this.k = true;
    }

    public final boolean e(List<j94> list) {
        if (list == null) {
            return false;
        }
        Iterator<j94> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == o84.ZIP64_EXTRA_FIELD_SIGNATURE.getValue()) {
                return true;
            }
        }
        return false;
    }

    public final void f() throws IOException {
        this.b.b(this.a, this.b.f(this.a));
        K();
        X();
        O();
        this.l = true;
    }

    public final int j(d94 d94Var) throws ZipException {
        if (d94Var == null || d94Var.b() == null) {
            throw new ZipException("AesExtraDataRecord not found or invalid for Aes encrypted entry");
        }
        return d94Var.b().getSaltLength() + 12;
    }

    public final long m(l94 l94Var) throws ZipException {
        if (ja4.g(l94Var).equals(v94.STORE)) {
            return l94Var.l();
        }
        if (!l94Var.n() || this.i) {
            return l94Var.c() - p(l94Var);
        }
        return -1L;
    }

    public final int p(l94 l94Var) throws ZipException {
        if (l94Var.p()) {
            return l94Var.f().equals(w94.AES) ? j(l94Var.b()) : l94Var.f().equals(w94.ZIP_STANDARD) ? 12 : 0;
        }
        return 0;
    }

    public l94 q(k94 k94Var, boolean z) throws IOException {
        ga4 ga4Var;
        if (this.f != null && z) {
            L();
        }
        l94 l94VarP = this.c.p(this.a, this.j.b());
        this.f = l94VarP;
        if (l94VarP == null) {
            return null;
        }
        if (l94VarP.p() && this.d == null && (ga4Var = this.e) != null) {
            V(ga4Var.getPassword());
        }
        b0(this.f);
        this.g.reset();
        if (k94Var != null) {
            this.f.u(k94Var.e());
            this.f.s(k94Var.c());
            this.f.G(k94Var.l());
            this.f.w(k94Var.o());
            this.i = true;
        } else {
            this.i = false;
        }
        this.b = A(this.f);
        this.l = false;
        return this.f;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        if (read(bArr) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    public final r84<?> x(z84 z84Var, l94 l94Var) throws IOException {
        if (!l94Var.p()) {
            return new u84(z84Var, l94Var, this.d, this.j.a());
        }
        if (l94Var.f() == w94.AES) {
            return new q84(z84Var, l94Var, this.d, this.j.a(), this.j.c());
        }
        if (l94Var.f() == w94.ZIP_STANDARD) {
            return new b94(z84Var, l94Var, this.d, this.j.a(), this.j.c());
        }
        throw new ZipException(String.format("Entry [%s] Strong Encryption not supported", l94Var.i()), ZipException.a.UNSUPPORTED_ENCRYPTION);
    }

    public final s84 y(r84<?> r84Var, l94 l94Var) throws ZipException {
        return ja4.g(l94Var) == v94.DEFLATE ? new t84(r84Var, this.j.a()) : new y84(r84Var);
    }

    public a94(InputStream inputStream, char[] cArr, ga4 ga4Var, n94 n94Var) {
        this.c = new n84();
        this.g = new CRC32();
        this.i = false;
        this.k = false;
        this.l = false;
        if (n94Var.a() < 512) {
            throw new IllegalArgumentException("Buffer size cannot be less than 512 bytes");
        }
        this.a = new PushbackInputStream(inputStream, n94Var.a());
        this.d = cArr;
        this.e = ga4Var;
        this.j = n94Var;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.k) {
            throw new IOException("Stream closed");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Negative read length");
        }
        if (i2 == 0) {
            return 0;
        }
        if (this.f == null) {
            return -1;
        }
        try {
            int i3 = this.b.read(bArr, i, i2);
            if (i3 == -1) {
                f();
            } else {
                this.g.update(bArr, i, i3);
            }
            return i3;
        } catch (IOException e) {
            if (C(this.f)) {
                throw new ZipException(e.getMessage(), e.getCause(), ZipException.a.WRONG_PASSWORD);
            }
            throw e;
        }
    }
}
