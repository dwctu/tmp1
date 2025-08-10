package dc;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;
import kotlin.text.Typography;

/* compiled from: RealBufferedSource.java */
/* loaded from: classes5.dex */
public final class ae4 implements pd4 {
    public final nd4 a = new nd4();
    public final fe4 b;
    public boolean c;

    public ae4(fe4 fe4Var) {
        Objects.requireNonNull(fe4Var, "source == null");
        this.b = fe4Var;
    }

    @Override // dc.pd4
    public byte[] B(long j) throws IOException {
        E(j);
        return this.a.B(j);
    }

    @Override // dc.pd4
    public short D() throws IOException {
        E(2L);
        return this.a.D();
    }

    @Override // dc.pd4
    public void E(long j) throws IOException {
        if (!request(j)) {
            throw new EOFException();
        }
    }

    @Override // dc.pd4
    public long H(byte b) throws IOException {
        return b(b, 0L, Long.MAX_VALUE);
    }

    @Override // dc.pd4
    public qd4 J(long j) throws IOException {
        E(j);
        return this.a.J(j);
    }

    @Override // dc.pd4
    public byte[] M() throws IOException {
        this.a.w(this.b);
        return this.a.M();
    }

    @Override // dc.pd4
    public boolean N() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        return this.a.N() && this.b.read(this.a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
    }

    @Override // dc.pd4
    public long P() throws IOException {
        byte bQ;
        E(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!request(i2)) {
                break;
            }
            bQ = this.a.q(i);
            if ((bQ < 48 || bQ > 57) && !(i == 0 && bQ == 45)) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(bQ)));
        }
        return this.a.P();
    }

    @Override // dc.pd4
    public String Q(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.a.w(this.b);
        return this.a.Q(charset);
    }

    @Override // dc.pd4
    public int T() throws IOException {
        E(4L);
        return this.a.T();
    }

    @Override // dc.pd4
    public long W(ee4 ee4Var) throws IOException {
        if (ee4Var == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j = 0;
        while (this.b.read(this.a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
            long jF = this.a.f();
            if (jF > 0) {
                j += jF;
                ee4Var.write(this.a, jF);
            }
        }
        if (this.a.f0() <= 0) {
            return j;
        }
        long jF0 = j + this.a.f0();
        nd4 nd4Var = this.a;
        ee4Var.write(nd4Var, nd4Var.f0());
        return jF0;
    }

    @Override // dc.pd4
    public long Z() throws IOException {
        byte bQ;
        E(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!request(i2)) {
                break;
            }
            bQ = this.a.q(i);
            if ((bQ < 48 || bQ > 57) && ((bQ < 97 || bQ > 102) && (bQ < 65 || bQ > 70))) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(bQ)));
        }
        return this.a.Z();
    }

    @Override // dc.pd4
    public nd4 a() {
        return this.a;
    }

    @Override // dc.pd4
    public InputStream a0() {
        return new a();
    }

    public long b(byte b, long j, long j2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long jX = this.a.x(b, j, j2);
            if (jX != -1) {
                return jX;
            }
            nd4 nd4Var = this.a;
            long j3 = nd4Var.b;
            if (j3 >= j2 || this.b.read(nd4Var, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                break;
            }
            j = Math.max(j, j3);
        }
        return -1L;
    }

    @Override // dc.pd4
    public int c0(xd4 xd4Var) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        do {
            int iE0 = this.a.e0(xd4Var, true);
            if (iE0 == -1) {
                return -1;
            }
            if (iE0 != -2) {
                this.a.skip(xd4Var.a[iE0].s());
                return iE0;
            }
        } while (this.b.read(this.a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return -1;
    }

    @Override // dc.fe4, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.close();
        this.a.b();
    }

    public long e(qd4 qd4Var, long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jY = this.a.y(qd4Var, j);
            if (jY != -1) {
                return jY;
            }
            nd4 nd4Var = this.a;
            long j2 = nd4Var.b;
            if (this.b.read(nd4Var, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j = Math.max(j, (j2 - qd4Var.s()) + 1);
        }
    }

    public long f(qd4 qd4Var, long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jA = this.a.A(qd4Var, j);
            if (jA != -1) {
                return jA;
            }
            nd4 nd4Var = this.a;
            long j2 = nd4Var.b;
            if (this.b.read(nd4Var, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j = Math.max(j, j2);
        }
    }

    @Override // dc.pd4
    public long g(qd4 qd4Var) throws IOException {
        return e(qd4Var, 0L);
    }

    @Override // dc.pd4
    public nd4 h() {
        return this.a;
    }

    @Override // dc.pd4
    public void i(nd4 nd4Var, long j) throws IOException {
        try {
            E(j);
            this.a.i(nd4Var, j);
        } catch (EOFException e) {
            nd4Var.w(this.a);
            throw e;
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    public boolean j(long j, qd4 qd4Var, int i, int i2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || i < 0 || i2 < 0 || qd4Var.s() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = i3 + j;
            if (!request(1 + j2) || this.a.q(j2) != qd4Var.i(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // dc.pd4
    public long k(qd4 qd4Var) throws IOException {
        return f(qd4Var, 0L);
    }

    @Override // dc.pd4
    public String n(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long jB = b((byte) 10, 0L, j2);
        if (jB != -1) {
            return this.a.d0(jB);
        }
        if (j2 < Long.MAX_VALUE && request(j2) && this.a.q(j2 - 1) == 13 && request(1 + j2) && this.a.q(j2) == 10) {
            return this.a.d0(j2);
        }
        nd4 nd4Var = new nd4();
        nd4 nd4Var2 = this.a;
        nd4Var2.m(nd4Var, 0L, Math.min(32L, nd4Var2.f0()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.a.f0(), j) + " content=" + nd4Var.L().j() + Typography.ellipsis);
    }

    @Override // dc.pd4
    public pd4 peek() {
        return wd4.d(new yd4(this));
    }

    @Override // dc.fe4
    public long read(nd4 nd4Var, long j) throws IOException {
        if (nd4Var == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        nd4 nd4Var2 = this.a;
        if (nd4Var2.b == 0 && this.b.read(nd4Var2, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1L;
        }
        return this.a.read(nd4Var, Math.min(j, this.a.b));
    }

    @Override // dc.pd4
    public byte readByte() throws IOException {
        E(1L);
        return this.a.readByte();
    }

    @Override // dc.pd4
    public void readFully(byte[] bArr) throws IOException {
        try {
            E(bArr.length);
            this.a.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                nd4 nd4Var = this.a;
                long j = nd4Var.b;
                if (j <= 0) {
                    throw e;
                }
                int i2 = nd4Var.read(bArr, i, (int) j);
                if (i2 == -1) {
                    throw new AssertionError();
                }
                i += i2;
            }
        }
    }

    @Override // dc.pd4
    public int readInt() throws IOException {
        E(4L);
        return this.a.readInt();
    }

    @Override // dc.pd4
    public long readLong() throws IOException {
        E(8L);
        return this.a.readLong();
    }

    @Override // dc.pd4
    public short readShort() throws IOException {
        E(2L);
        return this.a.readShort();
    }

    @Override // dc.pd4
    public boolean request(long j) throws IOException {
        nd4 nd4Var;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        do {
            nd4Var = this.a;
            if (nd4Var.b >= j) {
                return true;
            }
        } while (this.b.read(nd4Var, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return false;
    }

    @Override // dc.pd4
    public void skip(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            nd4 nd4Var = this.a;
            if (nd4Var.b == 0 && this.b.read(nd4Var, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.a.f0());
            this.a.skip(jMin);
            j -= jMin;
        }
    }

    @Override // dc.pd4
    public boolean t(long j, qd4 qd4Var) throws IOException {
        return j(j, qd4Var, 0, qd4Var.s());
    }

    @Override // dc.fe4
    public ge4 timeout() {
        return this.b.timeout();
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }

    @Override // dc.pd4
    public String z() throws IOException {
        return n(Long.MAX_VALUE);
    }

    /* compiled from: RealBufferedSource.java */
    public class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            ae4 ae4Var = ae4.this;
            if (ae4Var.c) {
                throw new IOException("closed");
            }
            return (int) Math.min(ae4Var.a.b, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            ae4.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            ae4 ae4Var = ae4.this;
            if (ae4Var.c) {
                throw new IOException("closed");
            }
            nd4 nd4Var = ae4Var.a;
            if (nd4Var.b == 0 && ae4Var.b.read(nd4Var, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1;
            }
            return ae4.this.a.readByte() & 255;
        }

        public String toString() {
            return ae4.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (!ae4.this.c) {
                he4.b(bArr.length, i, i2);
                ae4 ae4Var = ae4.this;
                nd4 nd4Var = ae4Var.a;
                if (nd4Var.b == 0 && ae4Var.b.read(nd4Var, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return ae4.this.a.read(bArr, i, i2);
            }
            throw new IOException("closed");
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        nd4 nd4Var = this.a;
        if (nd4Var.b == 0 && this.b.read(nd4Var, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.a.read(byteBuffer);
    }
}
