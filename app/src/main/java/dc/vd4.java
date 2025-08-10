package dc;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: InflaterSource.java */
/* loaded from: classes5.dex */
public final class vd4 implements fe4 {
    public final pd4 a;
    public final Inflater b;
    public int c;
    public boolean d;

    public vd4(pd4 pd4Var, Inflater inflater) {
        if (pd4Var == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.a = pd4Var;
        this.b = inflater;
    }

    public final boolean b() throws IOException {
        if (!this.b.needsInput()) {
            return false;
        }
        e();
        if (this.b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.a.N()) {
            return true;
        }
        be4 be4Var = this.a.a().a;
        int i = be4Var.c;
        int i2 = be4Var.b;
        int i3 = i - i2;
        this.c = i3;
        this.b.setInput(be4Var.a, i2, i3);
        return false;
    }

    @Override // dc.fe4, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        if (this.d) {
            return;
        }
        this.b.end();
        this.d = true;
        this.a.close();
    }

    public final void e() throws IOException {
        int i = this.c;
        if (i == 0) {
            return;
        }
        int remaining = i - this.b.getRemaining();
        this.c -= remaining;
        this.a.skip(remaining);
    }

    @Override // dc.fe4
    public long read(nd4 nd4Var, long j) throws IOException {
        boolean zB;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            zB = b();
            try {
                be4 be4VarI0 = nd4Var.i0(1);
                int iInflate = this.b.inflate(be4VarI0.a, be4VarI0.c, (int) Math.min(j, 8192 - be4VarI0.c));
                if (iInflate > 0) {
                    be4VarI0.c += iInflate;
                    long j2 = iInflate;
                    nd4Var.b += j2;
                    return j2;
                }
                if (!this.b.finished() && !this.b.needsDictionary()) {
                }
                e();
                if (be4VarI0.b != be4VarI0.c) {
                    return -1L;
                }
                nd4Var.a = be4VarI0.b();
                ce4.a(be4VarI0);
                return -1L;
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        } while (!zB);
        throw new EOFException("source exhausted prematurely");
    }

    @Override // dc.fe4
    public ge4 timeout() {
        return this.a.timeout();
    }
}
