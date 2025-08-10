package dc;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* compiled from: RealBufferedSink.java */
/* loaded from: classes5.dex */
public final class zd4 implements od4 {
    public final nd4 a = new nd4();
    public final ee4 b;
    public boolean c;

    public zd4(ee4 ee4Var) {
        Objects.requireNonNull(ee4Var, "sink == null");
        this.b = ee4Var;
    }

    @Override // dc.od4
    public od4 F(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.n0(j);
        l();
        return this;
    }

    @Override // dc.od4
    public od4 R(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.o0(j);
        l();
        return this;
    }

    @Override // dc.od4
    public od4 U(qd4 qd4Var) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.j0(qd4Var);
        l();
        return this;
    }

    @Override // dc.od4
    public OutputStream Y() {
        return new a();
    }

    @Override // dc.od4
    public nd4 a() {
        return this.a;
    }

    @Override // dc.ee4, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.c) {
            return;
        }
        try {
            nd4 nd4Var = this.a;
            long j = nd4Var.b;
            if (j > 0) {
                this.b.write(nd4Var, j);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.b.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.c = true;
        if (th == null) {
            return;
        }
        he4.e(th);
        throw null;
    }

    @Override // dc.od4
    public od4 d() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long jF0 = this.a.f0();
        if (jF0 > 0) {
            this.b.write(this.a, jF0);
        }
        return this;
    }

    @Override // dc.od4, dc.ee4, java.io.Flushable
    public void flush() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        nd4 nd4Var = this.a;
        long j = nd4Var.b;
        if (j > 0) {
            this.b.write(nd4Var, j);
        }
        this.b.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    @Override // dc.od4
    public od4 l() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long jF = this.a.f();
        if (jF > 0) {
            this.b.write(this.a, jF);
        }
        return this;
    }

    @Override // dc.od4
    public od4 s(String str) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.u0(str);
        l();
        return this;
    }

    @Override // dc.ee4
    public ge4 timeout() {
        return this.b.timeout();
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }

    @Override // dc.od4
    public od4 v(String str, int i, int i2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.v0(str, i, i2);
        l();
        return this;
    }

    @Override // dc.od4
    public long w(fe4 fe4Var) throws IOException {
        if (fe4Var == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long j2 = fe4Var.read(this.a, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (j2 == -1) {
                return j;
            }
            j += j2;
            l();
        }
    }

    @Override // dc.ee4
    public void write(nd4 nd4Var, long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.write(nd4Var, j);
        l();
    }

    @Override // dc.od4
    public od4 writeByte(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.m0(i);
        l();
        return this;
    }

    @Override // dc.od4
    public od4 writeInt(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.p0(i);
        l();
        return this;
    }

    @Override // dc.od4
    public od4 writeShort(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.r0(i);
        l();
        return this;
    }

    /* compiled from: RealBufferedSink.java */
    public class a extends OutputStream {
        public a() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws Throwable {
            zd4.this.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            zd4 zd4Var = zd4.this;
            if (zd4Var.c) {
                return;
            }
            zd4Var.flush();
        }

        public String toString() {
            return zd4.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            zd4 zd4Var = zd4.this;
            if (zd4Var.c) {
                throw new IOException("closed");
            }
            zd4Var.a.m0((byte) i);
            zd4.this.l();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            zd4 zd4Var = zd4.this;
            if (!zd4Var.c) {
                zd4Var.a.l0(bArr, i, i2);
                zd4.this.l();
                return;
            }
            throw new IOException("closed");
        }
    }

    @Override // dc.od4
    public od4 write(byte[] bArr) throws IOException {
        if (!this.c) {
            this.a.k0(bArr);
            l();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // dc.od4
    public od4 write(byte[] bArr, int i, int i2) throws IOException {
        if (!this.c) {
            this.a.l0(bArr, i, i2);
            return l();
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.c) {
            int iWrite = this.a.write(byteBuffer);
            l();
            return iWrite;
        }
        throw new IllegalStateException("closed");
    }
}
