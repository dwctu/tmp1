package dc;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* compiled from: GzipSource.java */
/* loaded from: classes5.dex */
public final class ud4 implements fe4 {
    public final pd4 b;
    public final Inflater c;
    public final vd4 d;
    public int a = 0;
    public final CRC32 e = new CRC32();

    public ud4(fe4 fe4Var) {
        if (fe4Var == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.c = inflater;
        pd4 pd4VarD = wd4.d(fe4Var);
        this.b = pd4VarD;
        this.d = new vd4(pd4VarD, inflater);
    }

    public final void b(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    @Override // dc.fe4, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        this.d.close();
    }

    public final void e() throws IOException {
        this.b.E(10L);
        byte bQ = this.b.a().q(3L);
        boolean z = ((bQ >> 1) & 1) == 1;
        if (z) {
            j(this.b.a(), 0L, 10L);
        }
        b("ID1ID2", 8075, this.b.readShort());
        this.b.skip(8L);
        if (((bQ >> 2) & 1) == 1) {
            this.b.E(2L);
            if (z) {
                j(this.b.a(), 0L, 2L);
            }
            long jD = this.b.a().D();
            this.b.E(jD);
            if (z) {
                j(this.b.a(), 0L, jD);
            }
            this.b.skip(jD);
        }
        if (((bQ >> 3) & 1) == 1) {
            long jH = this.b.H((byte) 0);
            if (jH == -1) {
                throw new EOFException();
            }
            if (z) {
                j(this.b.a(), 0L, jH + 1);
            }
            this.b.skip(jH + 1);
        }
        if (((bQ >> 4) & 1) == 1) {
            long jH2 = this.b.H((byte) 0);
            if (jH2 == -1) {
                throw new EOFException();
            }
            if (z) {
                j(this.b.a(), 0L, jH2 + 1);
            }
            this.b.skip(jH2 + 1);
        }
        if (z) {
            b("FHCRC", this.b.D(), (short) this.e.getValue());
            this.e.reset();
        }
    }

    public final void f() throws IOException {
        b("CRC", this.b.T(), (int) this.e.getValue());
        b("ISIZE", this.b.T(), (int) this.c.getBytesWritten());
    }

    public final void j(nd4 nd4Var, long j, long j2) {
        be4 be4Var = nd4Var.a;
        while (true) {
            int i = be4Var.c;
            int i2 = be4Var.b;
            if (j < i - i2) {
                break;
            }
            j -= i - i2;
            be4Var = be4Var.f;
        }
        while (j2 > 0) {
            int iMin = (int) Math.min(be4Var.c - r7, j2);
            this.e.update(be4Var.a, (int) (be4Var.b + j), iMin);
            j2 -= iMin;
            be4Var = be4Var.f;
            j = 0;
        }
    }

    @Override // dc.fe4
    public long read(nd4 nd4Var, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return 0L;
        }
        if (this.a == 0) {
            e();
            this.a = 1;
        }
        if (this.a == 1) {
            long j2 = nd4Var.b;
            long j3 = this.d.read(nd4Var, j);
            if (j3 != -1) {
                j(nd4Var, j2, j3);
                return j3;
            }
            this.a = 2;
        }
        if (this.a == 2) {
            f();
            this.a = 3;
            if (!this.b.N()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // dc.fe4
    public ge4 timeout() {
        return this.b.timeout();
    }
}
