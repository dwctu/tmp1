package dc;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* compiled from: VisualSampleEntry.java */
/* loaded from: classes.dex */
public final class hg0 extends fg0 implements jf0 {
    public int k;
    public int l;
    public double m;
    public double n;
    public int o;
    public String p;
    public int q;
    public long[] r;

    public hg0() {
        super("avc1");
        this.m = 72.0d;
        this.n = 72.0d;
        this.o = 1;
        this.p = "";
        this.q = 24;
        this.r = new long[3];
    }

    public String C() {
        return this.p;
    }

    public int I() {
        return this.q;
    }

    public int K() {
        return this.o;
    }

    public int L() {
        return this.l;
    }

    public double O() {
        return this.m;
    }

    public double V() {
        return this.n;
    }

    public int X() {
        return this.k;
    }

    @Override // dc.f41, dc.hf0
    public long b() {
        long jP = p() + 78;
        return jP + ((this.i || 8 + jP >= 4294967296L) ? 16 : 8);
    }

    public void b0(int i) {
        this.q = i;
    }

    public void d0(int i) {
        this.o = i;
    }

    @Override // dc.f41, dc.hf0
    public void e(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(y());
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(78);
        byteBufferAllocate.position(6);
        ef0.e(byteBufferAllocate, this.j);
        ef0.e(byteBufferAllocate, 0);
        ef0.e(byteBufferAllocate, 0);
        ef0.g(byteBufferAllocate, this.r[0]);
        ef0.g(byteBufferAllocate, this.r[1]);
        ef0.g(byteBufferAllocate, this.r[2]);
        ef0.e(byteBufferAllocate, X());
        ef0.e(byteBufferAllocate, L());
        ef0.b(byteBufferAllocate, O());
        ef0.b(byteBufferAllocate, V());
        ef0.g(byteBufferAllocate, 0L);
        ef0.e(byteBufferAllocate, K());
        ef0.i(byteBufferAllocate, ff0.c(C()));
        byteBufferAllocate.put(ff0.b(C()));
        int iC = ff0.c(C());
        while (iC < 31) {
            iC++;
            byteBufferAllocate.put((byte) 0);
        }
        ef0.e(byteBufferAllocate, I());
        ef0.e(byteBufferAllocate, 65535);
        writableByteChannel.write((ByteBuffer) byteBufferAllocate.rewind());
        x(writableByteChannel);
    }

    public void e0(int i) {
        this.l = i;
    }

    public void f0(double d) {
        this.m = d;
    }

    public void g0(double d) {
        this.n = d;
    }

    public void h0(int i) {
        this.k = i;
    }

    public hg0(String str) {
        super(str);
        this.m = 72.0d;
        this.n = 72.0d;
        this.o = 1;
        this.p = "";
        this.q = 24;
        this.r = new long[3];
    }
}
