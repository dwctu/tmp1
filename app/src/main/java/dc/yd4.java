package dc;

import java.io.IOException;

/* compiled from: PeekSource.java */
/* loaded from: classes5.dex */
public final class yd4 implements fe4 {
    public final pd4 a;
    public final nd4 b;
    public be4 c;
    public int d;
    public boolean e;
    public long f;

    public yd4(pd4 pd4Var) {
        this.a = pd4Var;
        nd4 nd4VarA = pd4Var.a();
        this.b = nd4VarA;
        be4 be4Var = nd4VarA.a;
        this.c = be4Var;
        this.d = be4Var != null ? be4Var.b : -1;
    }

    @Override // dc.fe4, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        this.e = true;
    }

    @Override // dc.fe4
    public long read(nd4 nd4Var, long j) throws IOException {
        be4 be4Var;
        be4 be4Var2;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.e) {
            throw new IllegalStateException("closed");
        }
        be4 be4Var3 = this.c;
        if (be4Var3 != null && (be4Var3 != (be4Var2 = this.b.a) || this.d != be4Var2.b)) {
            throw new IllegalStateException("Peek source is invalid because upstream source was used");
        }
        if (j == 0) {
            return 0L;
        }
        if (!this.a.request(this.f + 1)) {
            return -1L;
        }
        if (this.c == null && (be4Var = this.b.a) != null) {
            this.c = be4Var;
            this.d = be4Var.b;
        }
        long jMin = Math.min(j, this.b.b - this.f);
        this.b.m(nd4Var, this.f, jMin);
        this.f += jMin;
        return jMin;
    }

    @Override // dc.fe4
    public ge4 timeout() {
        return this.a.timeout();
    }
}
