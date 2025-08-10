package dc;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.MediaPeriodQueue;
import com.google.android.exoplayer2.extractor.mp3.IndexSeeker;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedInts;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.text.Typography;
import org.apache.commons.codec.net.RFC1522Codec;

/* compiled from: Buffer.java */
/* loaded from: classes5.dex */
public final class nd4 implements pd4, od4, Cloneable, ByteChannel {
    public static final byte[] c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    public be4 a;
    public long b;

    /* compiled from: Buffer.java */
    public class a extends OutputStream {
        public a() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return nd4.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            nd4.this.m0((byte) i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            nd4.this.l0(bArr, i, i2);
        }
    }

    /* compiled from: Buffer.java */
    public class b extends InputStream {
        public b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(nd4.this.b, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            nd4 nd4Var = nd4.this;
            if (nd4Var.b > 0) {
                return nd4Var.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return nd4.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            return nd4.this.read(bArr, i, i2);
        }
    }

    /* compiled from: Buffer.java */
    public static final class c implements Closeable {
        public nd4 a;
        public boolean b;
        public be4 c;
        public byte[] e;
        public long d = -1;
        public int f = -1;
        public int g = -1;

        public final int b() {
            long j = this.d;
            if (j != this.a.b) {
                return j == -1 ? e(0L) : e(j + (this.g - this.f));
            }
            throw new IllegalStateException();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.a == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.a = null;
            this.c = null;
            this.d = -1L;
            this.e = null;
            this.f = -1;
            this.g = -1;
        }

        public final int e(long j) {
            if (j >= -1) {
                nd4 nd4Var = this.a;
                long j2 = nd4Var.b;
                if (j <= j2) {
                    if (j == -1 || j == j2) {
                        this.c = null;
                        this.d = j;
                        this.e = null;
                        this.f = -1;
                        this.g = -1;
                        return -1;
                    }
                    long j3 = 0;
                    be4 be4Var = nd4Var.a;
                    be4 be4Var2 = this.c;
                    if (be4Var2 != null) {
                        long j4 = this.d - (this.f - be4Var2.b);
                        if (j4 > j) {
                            j2 = j4;
                            be4Var2 = be4Var;
                            be4Var = be4Var2;
                        } else {
                            j3 = j4;
                        }
                    } else {
                        be4Var2 = be4Var;
                    }
                    if (j2 - j > j - j3) {
                        while (true) {
                            int i = be4Var2.c;
                            int i2 = be4Var2.b;
                            if (j < (i - i2) + j3) {
                                break;
                            }
                            j3 += i - i2;
                            be4Var2 = be4Var2.f;
                        }
                    } else {
                        while (j2 > j) {
                            be4Var = be4Var.g;
                            j2 -= be4Var.c - be4Var.b;
                        }
                        be4Var2 = be4Var;
                        j3 = j2;
                    }
                    if (this.b && be4Var2.d) {
                        be4 be4VarF = be4Var2.f();
                        nd4 nd4Var2 = this.a;
                        if (nd4Var2.a == be4Var2) {
                            nd4Var2.a = be4VarF;
                        }
                        be4Var2.c(be4VarF);
                        be4VarF.g.b();
                        be4Var2 = be4VarF;
                    }
                    this.c = be4Var2;
                    this.d = j;
                    this.e = be4Var2.a;
                    int i3 = be4Var2.b + ((int) (j - j3));
                    this.f = i3;
                    int i4 = be4Var2.c;
                    this.g = i4;
                    return i4 - i3;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(j), Long.valueOf(this.a.b)));
        }
    }

    public long A(qd4 qd4Var, long j) {
        int i;
        int i2;
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        be4 be4Var = this.a;
        if (be4Var == null) {
            return -1L;
        }
        long j3 = this.b;
        if (j3 - j < j) {
            while (j3 > j) {
                be4Var = be4Var.g;
                j3 -= be4Var.c - be4Var.b;
            }
        } else {
            while (true) {
                long j4 = (be4Var.c - be4Var.b) + j2;
                if (j4 >= j) {
                    break;
                }
                be4Var = be4Var.f;
                j2 = j4;
            }
            j3 = j2;
        }
        if (qd4Var.s() == 2) {
            byte bI = qd4Var.i(0);
            byte bI2 = qd4Var.i(1);
            while (j3 < this.b) {
                byte[] bArr = be4Var.a;
                i = (int) ((be4Var.b + j) - j3);
                int i3 = be4Var.c;
                while (i < i3) {
                    byte b2 = bArr[i];
                    if (b2 == bI || b2 == bI2) {
                        i2 = be4Var.b;
                        return (i - i2) + j3;
                    }
                    i++;
                }
                j3 += be4Var.c - be4Var.b;
                be4Var = be4Var.f;
                j = j3;
            }
            return -1L;
        }
        byte[] bArrK = qd4Var.k();
        while (j3 < this.b) {
            byte[] bArr2 = be4Var.a;
            i = (int) ((be4Var.b + j) - j3);
            int i4 = be4Var.c;
            while (i < i4) {
                byte b3 = bArr2[i];
                for (byte b4 : bArrK) {
                    if (b3 == b4) {
                        i2 = be4Var.b;
                        return (i - i2) + j3;
                    }
                }
                i++;
            }
            j3 += be4Var.c - be4Var.b;
            be4Var = be4Var.f;
            j = j3;
        }
        return -1L;
    }

    @Override // dc.pd4
    public byte[] B(long j) throws EOFException {
        he4.b(this.b, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    public boolean C(long j, qd4 qd4Var, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.b - j < i2 || qd4Var.s() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (q(i3 + j) != qd4Var.i(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // dc.pd4
    public short D() {
        return he4.d(readShort());
    }

    @Override // dc.pd4
    public void E(long j) throws EOFException {
        if (this.b < j) {
            throw new EOFException();
        }
    }

    @Override // dc.od4
    public /* bridge */ /* synthetic */ od4 F(long j) throws IOException {
        n0(j);
        return this;
    }

    @Override // dc.pd4
    public long H(byte b2) {
        return x(b2, 0L, Long.MAX_VALUE);
    }

    public final boolean I(be4 be4Var, int i, qd4 qd4Var, int i2, int i3) {
        int i4 = be4Var.c;
        byte[] bArr = be4Var.a;
        while (i2 < i3) {
            if (i == i4) {
                be4Var = be4Var.f;
                byte[] bArr2 = be4Var.a;
                bArr = bArr2;
                i = be4Var.b;
                i4 = be4Var.c;
            }
            if (bArr[i] != qd4Var.i(i2)) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // dc.pd4
    public qd4 J(long j) throws EOFException {
        return new qd4(B(j));
    }

    public final c K(c cVar) {
        if (cVar.a != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        cVar.a = this;
        cVar.b = true;
        return cVar;
    }

    public qd4 L() {
        return new qd4(M());
    }

    @Override // dc.pd4
    public byte[] M() {
        try {
            return B(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // dc.pd4
    public boolean N() {
        return this.b == 0;
    }

    public String O(long j, Charset charset) throws EOFException {
        he4.b(this.b, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        be4 be4Var = this.a;
        if (be4Var.b + j > be4Var.c) {
            return new String(B(j), charset);
        }
        String str = new String(be4Var.a, be4Var.b, (int) j, charset);
        int i = (int) (be4Var.b + j);
        be4Var.b = i;
        this.b -= j;
        if (i == be4Var.c) {
            this.a = be4Var.b();
            ce4.a(be4Var);
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
    
        r1 = new dc.nd4();
        r1.n0(r3);
        r1.m0(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
    
        if (r8 != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004a, code lost:
    
        r1.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0067, code lost:
    
        throw new java.lang.NumberFormatException("Number too large: " + r1.V());
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a7  */
    @Override // dc.pd4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long P() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.b
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto Lc2
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            r5 = -7
            r7 = 0
            r8 = 0
            r9 = 0
        L14:
            dc.be4 r10 = r0.a
            byte[] r11 = r10.a
            int r12 = r10.b
            int r13 = r10.c
        L1c:
            if (r12 >= r13) goto L9b
            r15 = r11[r12]
            r14 = 48
            if (r15 < r14) goto L68
            r14 = 57
            if (r15 > r14) goto L68
            int r14 = 48 - r15
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 < 0) goto L3d
            if (r16 != 0) goto L36
            long r1 = (long) r14
            int r16 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r16 >= 0) goto L36
            goto L3d
        L36:
            r1 = 10
            long r3 = r3 * r1
            long r1 = (long) r14
            long r3 = r3 + r1
            goto L72
        L3d:
            dc.nd4 r1 = new dc.nd4
            r1.<init>()
            r1.n0(r3)
            r1.m0(r15)
            if (r8 != 0) goto L4d
            r1.readByte()
        L4d:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            r3.append(r4)
            java.lang.String r1 = r1.V()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L68:
            r1 = 45
            if (r15 != r1) goto L7c
            if (r7 != 0) goto L7c
            r1 = 1
            long r5 = r5 - r1
            r8 = 1
        L72:
            int r12 = r12 + 1
            int r7 = r7 + 1
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            goto L1c
        L7c:
            if (r7 == 0) goto L80
            r9 = 1
            goto L9b
        L80:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r15)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L9b:
            if (r12 != r13) goto La7
            dc.be4 r1 = r10.b()
            r0.a = r1
            dc.ce4.a(r10)
            goto La9
        La7:
            r10.b = r12
        La9:
            if (r9 != 0) goto Lb7
            dc.be4 r1 = r0.a
            if (r1 != 0) goto Lb0
            goto Lb7
        Lb0:
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            goto L14
        Lb7:
            long r1 = r0.b
            long r5 = (long) r7
            long r1 = r1 - r5
            r0.b = r1
            if (r8 == 0) goto Lc0
            goto Lc1
        Lc0:
            long r3 = -r3
        Lc1:
            return r3
        Lc2:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.nd4.P():long");
    }

    @Override // dc.pd4
    public String Q(Charset charset) {
        try {
            return O(this.b, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // dc.od4
    public /* bridge */ /* synthetic */ od4 R(long j) throws IOException {
        o0(j);
        return this;
    }

    @Override // dc.pd4
    public int T() {
        return he4.c(readInt());
    }

    @Override // dc.od4
    public /* bridge */ /* synthetic */ od4 U(qd4 qd4Var) throws IOException {
        j0(qd4Var);
        return this;
    }

    public String V() {
        try {
            return O(this.b, he4.a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // dc.pd4
    public long W(ee4 ee4Var) throws IOException {
        long j = this.b;
        if (j > 0) {
            ee4Var.write(this, j);
        }
        return j;
    }

    public String X(long j) throws EOFException {
        return O(j, he4.a);
    }

    @Override // dc.od4
    public OutputStream Y() {
        return new a();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a3 A[EDGE_INSN: B:44:0x00a3->B:38:0x00a3 BREAK  A[LOOP:0: B:5:0x000b->B:46:?], SYNTHETIC] */
    @Override // dc.pd4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long Z() {
        /*
            r15 = this;
            long r0 = r15.b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Laa
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            dc.be4 r6 = r15.a
            byte[] r7 = r6.a
            int r8 = r6.b
            int r9 = r6.c
        L13:
            if (r8 >= r9) goto L8f
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L3a
        L22:
            r11 = 97
            if (r10 < r11) goto L2f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2f
            int r11 = r10 + (-97)
        L2c:
            int r11 = r11 + 10
            goto L3a
        L2f:
            r11 = 65
            if (r10 < r11) goto L70
            r11 = 70
            if (r10 > r11) goto L70
            int r11 = r10 + (-65)
            goto L2c
        L3a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L4a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L4a:
            dc.nd4 r0 = new dc.nd4
            r0.<init>()
            r0.o0(r4)
            r0.m0(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.V()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L70:
            if (r0 == 0) goto L74
            r1 = 1
            goto L8f
        L74:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L8f:
            if (r8 != r9) goto L9b
            dc.be4 r7 = r6.b()
            r15.a = r7
            dc.ce4.a(r6)
            goto L9d
        L9b:
            r6.b = r8
        L9d:
            if (r1 != 0) goto La3
            dc.be4 r6 = r15.a
            if (r6 != 0) goto Lb
        La3:
            long r1 = r15.b
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.b = r1
            return r4
        Laa:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.nd4.Z():long");
    }

    @Override // dc.pd4
    public nd4 a() {
        return this;
    }

    @Override // dc.pd4
    public InputStream a0() {
        return new b();
    }

    public final void b() {
        try {
            skip(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public int b0() throws EOFException {
        int i;
        int i2;
        int i3;
        if (this.b == 0) {
            throw new EOFException();
        }
        byte bQ = q(0L);
        if ((bQ & 128) == 0) {
            i = bQ & Byte.MAX_VALUE;
            i2 = 1;
            i3 = 0;
        } else if ((bQ & 224) == 192) {
            i = bQ & Ascii.US;
            i2 = 2;
            i3 = 128;
        } else if ((bQ & 240) == 224) {
            i = bQ & Ascii.SI;
            i2 = 3;
            i3 = 2048;
        } else {
            if ((bQ & 248) != 240) {
                skip(1L);
                return 65533;
            }
            i = bQ & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (this.b < j) {
            throw new EOFException("size < " + i2 + ": " + this.b + " (to read code point prefixed 0x" + Integer.toHexString(bQ) + ")");
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte bQ2 = q(j2);
            if ((bQ2 & 192) != 128) {
                skip(j2);
                return 65533;
            }
            i = (i << 6) | (bQ2 & 63);
        }
        skip(j);
        if (i > 1114111) {
            return 65533;
        }
        if ((i < 55296 || i > 57343) && i >= i3) {
            return i;
        }
        return 65533;
    }

    @Override // dc.pd4
    public int c0(xd4 xd4Var) {
        int iE0 = e0(xd4Var, false);
        if (iE0 == -1) {
            return -1;
        }
        try {
            skip(xd4Var.a[iE0].s());
            return iE0;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    @Override // dc.fe4, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    @Override // dc.od4
    public od4 d() {
        return this;
    }

    public String d0(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (q(j2) == 13) {
                String strX = X(j2);
                skip(2L);
                return strX;
            }
        }
        String strX2 = X(j);
        skip(1L);
        return strX2;
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public nd4 clone() {
        nd4 nd4Var = new nd4();
        if (this.b == 0) {
            return nd4Var;
        }
        be4 be4VarD = this.a.d();
        nd4Var.a = be4VarD;
        be4VarD.g = be4VarD;
        be4VarD.f = be4VarD;
        be4 be4Var = this.a;
        while (true) {
            be4Var = be4Var.f;
            if (be4Var == this.a) {
                nd4Var.b = this.b;
                return nd4Var;
            }
            nd4Var.a.g.c(be4Var.d());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0055, code lost:
    
        if (r19 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0058, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int e0(dc.xd4 r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 161
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.nd4.e0(dc.xd4, boolean):int");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof nd4)) {
            return false;
        }
        nd4 nd4Var = (nd4) obj;
        long j = this.b;
        if (j != nd4Var.b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        be4 be4Var = this.a;
        be4 be4Var2 = nd4Var.a;
        int i = be4Var.b;
        int i2 = be4Var2.b;
        while (j2 < this.b) {
            long jMin = Math.min(be4Var.c - i, be4Var2.c - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (be4Var.a[i] != be4Var2.a[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == be4Var.c) {
                be4Var = be4Var.f;
                i = be4Var.b;
            }
            if (i2 == be4Var2.c) {
                be4Var2 = be4Var2.f;
                i2 = be4Var2.b;
            }
            j2 += jMin;
        }
        return true;
    }

    public final long f() {
        long j = this.b;
        if (j == 0) {
            return 0L;
        }
        be4 be4Var = this.a.g;
        return (be4Var.c >= 8192 || !be4Var.e) ? j : j - (r3 - be4Var.b);
    }

    public final long f0() {
        return this.b;
    }

    @Override // dc.od4, dc.ee4, java.io.Flushable
    public void flush() {
    }

    @Override // dc.pd4
    public long g(qd4 qd4Var) throws IOException {
        return y(qd4Var, 0L);
    }

    public final qd4 g0() {
        long j = this.b;
        if (j <= 2147483647L) {
            return h0((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.b);
    }

    @Override // dc.pd4
    public nd4 h() {
        return this;
    }

    public final qd4 h0(int i) {
        return i == 0 ? qd4.d : new de4(this, i);
    }

    public int hashCode() {
        be4 be4Var = this.a;
        if (be4Var == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = be4Var.c;
            for (int i3 = be4Var.b; i3 < i2; i3++) {
                i = (i * 31) + be4Var.a[i3];
            }
            be4Var = be4Var.f;
        } while (be4Var != this.a);
        return i;
    }

    @Override // dc.pd4
    public void i(nd4 nd4Var, long j) throws EOFException {
        long j2 = this.b;
        if (j2 >= j) {
            nd4Var.write(this, j);
        } else {
            nd4Var.write(this, j2);
            throw new EOFException();
        }
    }

    public be4 i0(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        be4 be4Var = this.a;
        if (be4Var == null) {
            be4 be4VarB = ce4.b();
            this.a = be4VarB;
            be4VarB.g = be4VarB;
            be4VarB.f = be4VarB;
            return be4VarB;
        }
        be4 be4Var2 = be4Var.g;
        if (be4Var2.c + i <= 8192 && be4Var2.e) {
            return be4Var2;
        }
        be4 be4VarB2 = ce4.b();
        be4Var2.c(be4VarB2);
        return be4VarB2;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public nd4 j0(qd4 qd4Var) {
        if (qd4Var == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        qd4Var.z(this);
        return this;
    }

    @Override // dc.pd4
    public long k(qd4 qd4Var) {
        return A(qd4Var, 0L);
    }

    public nd4 k0(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        l0(bArr, 0, bArr.length);
        return this;
    }

    @Override // dc.od4
    public /* bridge */ /* synthetic */ od4 l() throws IOException {
        p();
        return this;
    }

    public nd4 l0(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        he4.b(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            be4 be4VarI0 = i0(1);
            int iMin = Math.min(i3 - i, 8192 - be4VarI0.c);
            System.arraycopy(bArr, i, be4VarI0.a, be4VarI0.c, iMin);
            i += iMin;
            be4VarI0.c += iMin;
        }
        this.b += j;
        return this;
    }

    public final nd4 m(nd4 nd4Var, long j, long j2) {
        if (nd4Var == null) {
            throw new IllegalArgumentException("out == null");
        }
        he4.b(this.b, j, j2);
        if (j2 == 0) {
            return this;
        }
        nd4Var.b += j2;
        be4 be4Var = this.a;
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
            be4 be4VarD = be4Var.d();
            int i3 = (int) (be4VarD.b + j);
            be4VarD.b = i3;
            be4VarD.c = Math.min(i3 + ((int) j2), be4VarD.c);
            be4 be4Var2 = nd4Var.a;
            if (be4Var2 == null) {
                be4VarD.g = be4VarD;
                be4VarD.f = be4VarD;
                nd4Var.a = be4VarD;
            } else {
                be4Var2.g.c(be4VarD);
            }
            j2 -= be4VarD.c - be4VarD.b;
            be4Var = be4Var.f;
            j = 0;
        }
        return this;
    }

    public nd4 m0(int i) {
        be4 be4VarI0 = i0(1);
        byte[] bArr = be4VarI0.a;
        int i2 = be4VarI0.c;
        be4VarI0.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
        return this;
    }

    @Override // dc.pd4
    public String n(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long jX = x((byte) 10, 0L, j2);
        if (jX != -1) {
            return d0(jX);
        }
        if (j2 < f0() && q(j2 - 1) == 13 && q(j2) == 10) {
            return d0(j2);
        }
        nd4 nd4Var = new nd4();
        m(nd4Var, 0L, Math.min(32L, f0()));
        throw new EOFException("\\n not found: limit=" + Math.min(f0(), j) + " content=" + nd4Var.L().j() + Typography.ellipsis);
    }

    public nd4 n0(long j) {
        if (j == 0) {
            m0(48);
            return this;
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                u0("-9223372036854775808");
                return this;
            }
            z = true;
        }
        if (j >= 100000000) {
            i = j < MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < IndexSeeker.MIN_TIME_BETWEEN_POINTS_US ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        be4 be4VarI0 = i0(i);
        byte[] bArr = be4VarI0.a;
        int i2 = be4VarI0.c + i;
        while (j != 0) {
            i2--;
            bArr[i2] = c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        be4VarI0.c += i;
        this.b += i;
        return this;
    }

    public nd4 o0(long j) {
        if (j == 0) {
            m0(48);
            return this;
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        be4 be4VarI0 = i0(iNumberOfTrailingZeros);
        byte[] bArr = be4VarI0.a;
        int i = be4VarI0.c;
        for (int i2 = (i + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = c[(int) (15 & j)];
            j >>>= 4;
        }
        be4VarI0.c += iNumberOfTrailingZeros;
        this.b += iNumberOfTrailingZeros;
        return this;
    }

    public nd4 p() {
        return this;
    }

    public nd4 p0(int i) {
        be4 be4VarI0 = i0(4);
        byte[] bArr = be4VarI0.a;
        int i2 = be4VarI0.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        be4VarI0.c = i5 + 1;
        this.b += 4;
        return this;
    }

    @Override // dc.pd4
    public pd4 peek() {
        return wd4.d(new yd4(this));
    }

    public final byte q(long j) {
        int i;
        he4.b(this.b, j, 1L);
        long j2 = this.b;
        if (j2 - j <= j) {
            long j3 = j - j2;
            be4 be4Var = this.a;
            do {
                be4Var = be4Var.g;
                int i2 = be4Var.c;
                i = be4Var.b;
                j3 += i2 - i;
            } while (j3 < 0);
            return be4Var.a[i + ((int) j3)];
        }
        be4 be4Var2 = this.a;
        while (true) {
            int i3 = be4Var2.c;
            int i4 = be4Var2.b;
            long j4 = i3 - i4;
            if (j < j4) {
                return be4Var2.a[i4 + ((int) j)];
            }
            j -= j4;
            be4Var2 = be4Var2.f;
        }
    }

    public nd4 q0(long j) {
        be4 be4VarI0 = i0(8);
        byte[] bArr = be4VarI0.a;
        int i = be4VarI0.c;
        int i2 = i + 1;
        bArr[i] = (byte) ((j >>> 56) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 48) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 40) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 32) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j >>> 8) & 255);
        bArr[i8] = (byte) (j & 255);
        be4VarI0.c = i8 + 1;
        this.b += 8;
        return this;
    }

    public nd4 r0(int i) {
        be4 be4VarI0 = i0(2);
        byte[] bArr = be4VarI0.a;
        int i2 = be4VarI0.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        be4VarI0.c = i3 + 1;
        this.b += 2;
        return this;
    }

    public int read(byte[] bArr, int i, int i2) {
        he4.b(bArr.length, i, i2);
        be4 be4Var = this.a;
        if (be4Var == null) {
            return -1;
        }
        int iMin = Math.min(i2, be4Var.c - be4Var.b);
        System.arraycopy(be4Var.a, be4Var.b, bArr, i, iMin);
        int i3 = be4Var.b + iMin;
        be4Var.b = i3;
        this.b -= iMin;
        if (i3 == be4Var.c) {
            this.a = be4Var.b();
            ce4.a(be4Var);
        }
        return iMin;
    }

    @Override // dc.pd4
    public byte readByte() {
        long j = this.b;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        be4 be4Var = this.a;
        int i = be4Var.b;
        int i2 = be4Var.c;
        int i3 = i + 1;
        byte b2 = be4Var.a[i];
        this.b = j - 1;
        if (i3 == i2) {
            this.a = be4Var.b();
            ce4.a(be4Var);
        } else {
            be4Var.b = i3;
        }
        return b2;
    }

    @Override // dc.pd4
    public void readFully(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int i2 = read(bArr, i, bArr.length - i);
            if (i2 == -1) {
                throw new EOFException();
            }
            i += i2;
        }
    }

    @Override // dc.pd4
    public int readInt() {
        long j = this.b;
        if (j < 4) {
            throw new IllegalStateException("size < 4: " + this.b);
        }
        be4 be4Var = this.a;
        int i = be4Var.b;
        int i2 = be4Var.c;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = be4Var.a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.b = j - 4;
        if (i8 == i2) {
            this.a = be4Var.b();
            ce4.a(be4Var);
        } else {
            be4Var.b = i8;
        }
        return i9;
    }

    @Override // dc.pd4
    public long readLong() {
        long j = this.b;
        if (j < 8) {
            throw new IllegalStateException("size < 8: " + this.b);
        }
        be4 be4Var = this.a;
        int i = be4Var.b;
        int i2 = be4Var.c;
        if (i2 - i < 8) {
            return ((readInt() & UnsignedInts.INT_MASK) << 32) | (UnsignedInts.INT_MASK & readInt());
        }
        byte[] bArr = be4Var.a;
        long j2 = (bArr[i] & 255) << 56;
        long j3 = ((bArr[r11] & 255) << 48) | j2;
        long j4 = j3 | ((bArr[r6] & 255) << 40);
        long j5 = j4 | ((bArr[r11] & 255) << 32) | ((bArr[r6] & 255) << 24);
        long j6 = j5 | ((bArr[r9] & 255) << 16);
        long j7 = j6 | ((bArr[r6] & 255) << 8);
        int i3 = i + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1;
        long j8 = j7 | (bArr[r9] & 255);
        this.b = j - 8;
        if (i3 == i2) {
            this.a = be4Var.b();
            ce4.a(be4Var);
        } else {
            be4Var.b = i3;
        }
        return j8;
    }

    @Override // dc.pd4
    public short readShort() {
        long j = this.b;
        if (j < 2) {
            throw new IllegalStateException("size < 2: " + this.b);
        }
        be4 be4Var = this.a;
        int i = be4Var.b;
        int i2 = be4Var.c;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = be4Var.a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.b = j - 2;
        if (i4 == i2) {
            this.a = be4Var.b();
            ce4.a(be4Var);
        } else {
            be4Var.b = i4;
        }
        return (short) i5;
    }

    @Override // dc.pd4
    public boolean request(long j) {
        return this.b >= j;
    }

    @Override // dc.od4
    public /* bridge */ /* synthetic */ od4 s(String str) throws IOException {
        u0(str);
        return this;
    }

    public nd4 s0(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (charset.equals(he4.a)) {
            v0(str, i, i2);
            return this;
        }
        byte[] bytes = str.substring(i, i2).getBytes(charset);
        l0(bytes, 0, bytes.length);
        return this;
    }

    @Override // dc.pd4
    public void skip(long j) throws EOFException {
        while (j > 0) {
            if (this.a == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, r0.c - r0.b);
            long j2 = iMin;
            this.b -= j2;
            j -= j2;
            be4 be4Var = this.a;
            int i = be4Var.b + iMin;
            be4Var.b = i;
            if (i == be4Var.c) {
                this.a = be4Var.b();
                ce4.a(be4Var);
            }
        }
    }

    @Override // dc.pd4
    public boolean t(long j, qd4 qd4Var) {
        return C(j, qd4Var, 0, qd4Var.s());
    }

    public nd4 t0(String str, Charset charset) {
        s0(str, 0, str.length(), charset);
        return this;
    }

    @Override // dc.fe4
    public ge4 timeout() {
        return ge4.NONE;
    }

    public String toString() {
        return g0().toString();
    }

    public nd4 u0(String str) {
        v0(str, 0, str.length());
        return this;
    }

    @Override // dc.od4
    public /* bridge */ /* synthetic */ od4 v(String str, int i, int i2) throws IOException {
        v0(str, i, i2);
        return this;
    }

    public nd4 v0(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                be4 be4VarI0 = i0(1);
                byte[] bArr = be4VarI0.a;
                int i3 = be4VarI0.c - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt;
                while (i4 < iMin) {
                    char cCharAt2 = str.charAt(i4);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i4 + i3] = (byte) cCharAt2;
                    i4++;
                }
                int i5 = be4VarI0.c;
                int i6 = (i3 + i4) - i5;
                be4VarI0.c = i5 + i6;
                this.b += i6;
                i = i4;
            } else {
                if (cCharAt < 2048) {
                    m0((cCharAt >> 6) | 192);
                    m0((cCharAt & RFC1522Codec.SEP) | 128);
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    m0((cCharAt >> '\f') | 224);
                    m0(((cCharAt >> 6) & 63) | 128);
                    m0((cCharAt & RFC1522Codec.SEP) | 128);
                } else {
                    int i7 = i + 1;
                    char cCharAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                    if (cCharAt > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        m0(63);
                        i = i7;
                    } else {
                        int i8 = (((cCharAt & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                        m0((i8 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                        m0(((i8 >> 12) & 63) | 128);
                        m0(((i8 >> 6) & 63) | 128);
                        m0((i8 & 63) | 128);
                        i += 2;
                    }
                }
                i++;
            }
        }
        return this;
    }

    @Override // dc.od4
    public long w(fe4 fe4Var) throws IOException {
        if (fe4Var == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long j2 = fe4Var.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (j2 == -1) {
                return j;
            }
            j += j2;
        }
    }

    public nd4 w0(int i) {
        if (i < 128) {
            m0(i);
        } else if (i < 2048) {
            m0((i >> 6) | 192);
            m0((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                m0((i >> 12) | 224);
                m0(((i >> 6) & 63) | 128);
                m0((i & 63) | 128);
            } else {
                m0(63);
            }
        } else {
            if (i > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
            m0((i >> 18) | PsExtractor.VIDEO_STREAM_MASK);
            m0(((i >> 12) & 63) | 128);
            m0(((i >> 6) & 63) | 128);
            m0((i & 63) | 128);
        }
        return this;
    }

    @Override // dc.od4
    public /* bridge */ /* synthetic */ od4 write(byte[] bArr) throws IOException {
        k0(bArr);
        return this;
    }

    @Override // dc.od4
    public /* bridge */ /* synthetic */ od4 writeByte(int i) throws IOException {
        m0(i);
        return this;
    }

    @Override // dc.od4
    public /* bridge */ /* synthetic */ od4 writeInt(int i) throws IOException {
        p0(i);
        return this;
    }

    @Override // dc.od4
    public /* bridge */ /* synthetic */ od4 writeShort(int i) throws IOException {
        r0(i);
        return this;
    }

    public long x(byte b2, long j, long j2) {
        be4 be4Var;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.b), Long.valueOf(j), Long.valueOf(j2)));
        }
        long j4 = this.b;
        long j5 = j2 > j4 ? j4 : j2;
        if (j == j5 || (be4Var = this.a) == null) {
            return -1L;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                be4Var = be4Var.g;
                j4 -= be4Var.c - be4Var.b;
            }
        } else {
            while (true) {
                long j6 = (be4Var.c - be4Var.b) + j3;
                if (j6 >= j) {
                    break;
                }
                be4Var = be4Var.f;
                j3 = j6;
            }
            j4 = j3;
        }
        long j7 = j;
        while (j4 < j5) {
            byte[] bArr = be4Var.a;
            int iMin = (int) Math.min(be4Var.c, (be4Var.b + j5) - j4);
            for (int i = (int) ((be4Var.b + j7) - j4); i < iMin; i++) {
                if (bArr[i] == b2) {
                    return (i - be4Var.b) + j4;
                }
            }
            j4 += be4Var.c - be4Var.b;
            be4Var = be4Var.f;
            j7 = j4;
        }
        return -1L;
    }

    public long y(qd4 qd4Var, long j) throws IOException {
        byte[] bArr;
        if (qd4Var.s() == 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        be4 be4Var = this.a;
        long j3 = -1;
        if (be4Var == null) {
            return -1L;
        }
        long j4 = this.b;
        if (j4 - j < j) {
            while (j4 > j) {
                be4Var = be4Var.g;
                j4 -= be4Var.c - be4Var.b;
            }
        } else {
            while (true) {
                long j5 = (be4Var.c - be4Var.b) + j2;
                if (j5 >= j) {
                    break;
                }
                be4Var = be4Var.f;
                j2 = j5;
            }
            j4 = j2;
        }
        byte bI = qd4Var.i(0);
        int iS = qd4Var.s();
        long j6 = 1 + (this.b - iS);
        long j7 = j;
        be4 be4Var2 = be4Var;
        long j8 = j4;
        while (j8 < j6) {
            byte[] bArr2 = be4Var2.a;
            int iMin = (int) Math.min(be4Var2.c, (be4Var2.b + j6) - j8);
            int i = (int) ((be4Var2.b + j7) - j8);
            while (i < iMin) {
                if (bArr2[i] == bI) {
                    bArr = bArr2;
                    if (I(be4Var2, i + 1, qd4Var, 1, iS)) {
                        return (i - be4Var2.b) + j8;
                    }
                } else {
                    bArr = bArr2;
                }
                i++;
                bArr2 = bArr;
            }
            j8 += be4Var2.c - be4Var2.b;
            be4Var2 = be4Var2.f;
            j7 = j8;
            j3 = -1;
        }
        return j3;
    }

    @Override // dc.pd4
    public String z() throws EOFException {
        return n(Long.MAX_VALUE);
    }

    @Override // dc.od4
    public /* bridge */ /* synthetic */ od4 write(byte[] bArr, int i, int i2) throws IOException {
        l0(bArr, i, i2);
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int iRemaining = byteBuffer.remaining();
            int i = iRemaining;
            while (i > 0) {
                be4 be4VarI0 = i0(1);
                int iMin = Math.min(i, 8192 - be4VarI0.c);
                byteBuffer.get(be4VarI0.a, be4VarI0.c, iMin);
                i -= iMin;
                be4VarI0.c += iMin;
            }
            this.b += iRemaining;
            return iRemaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        be4 be4Var = this.a;
        if (be4Var == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), be4Var.c - be4Var.b);
        byteBuffer.put(be4Var.a, be4Var.b, iMin);
        int i = be4Var.b + iMin;
        be4Var.b = i;
        this.b -= iMin;
        if (i == be4Var.c) {
            this.a = be4Var.b();
            ce4.a(be4Var);
        }
        return iMin;
    }

    @Override // dc.ee4
    public void write(nd4 nd4Var, long j) {
        if (nd4Var == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (nd4Var != this) {
            he4.b(nd4Var.b, 0L, j);
            while (j > 0) {
                be4 be4Var = nd4Var.a;
                if (j < be4Var.c - be4Var.b) {
                    be4 be4Var2 = this.a;
                    be4 be4Var3 = be4Var2 != null ? be4Var2.g : null;
                    if (be4Var3 != null && be4Var3.e) {
                        if ((be4Var3.c + j) - (be4Var3.d ? 0 : be4Var3.b) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            be4Var.g(be4Var3, (int) j);
                            nd4Var.b -= j;
                            this.b += j;
                            return;
                        }
                    }
                    nd4Var.a = be4Var.e((int) j);
                }
                be4 be4Var4 = nd4Var.a;
                long j2 = be4Var4.c - be4Var4.b;
                nd4Var.a = be4Var4.b();
                be4 be4Var5 = this.a;
                if (be4Var5 == null) {
                    this.a = be4Var4;
                    be4Var4.g = be4Var4;
                    be4Var4.f = be4Var4;
                } else {
                    be4Var5.g.c(be4Var4);
                    be4Var4.a();
                }
                nd4Var.b -= j2;
                this.b += j2;
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    @Override // dc.fe4
    public long read(nd4 nd4Var, long j) {
        if (nd4Var == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j >= 0) {
            long j2 = this.b;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            nd4Var.write(this, j);
            return j;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }
}
