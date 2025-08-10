package dc;

import java.io.IOException;
import java.util.Objects;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: JsonUtf8Writer.java */
/* loaded from: classes3.dex */
public final class tf1 extends vf1 {
    public static final String[] m = new String[128];
    public final od4 j;
    public String k = SignatureImpl.INNER_SEP;
    public String l;

    static {
        for (int i = 0; i <= 31; i++) {
            m[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = m;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public tf1(od4 od4Var) {
        Objects.requireNonNull(od4Var, "sink == null");
        this.j = od4Var;
        K(6);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void l0(dc.od4 r7, java.lang.String r8) throws java.io.IOException {
        /*
            java.lang.String[] r0 = dc.tf1.m
            r1 = 34
            r7.writeByte(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = 0
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r7.v(r8, r4, r3)
        L2e:
            r7.s(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r7.v(r8, r4, r2)
        L3b:
            r7.writeByte(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.tf1.l0(dc.od4, java.lang.String):void");
    }

    @Override // dc.vf1
    public vf1 X(double d) throws IOException {
        if (!this.f && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
        }
        if (this.h) {
            x(Double.toString(d));
            return this;
        }
        m0();
        h0();
        this.j.s(Double.toString(d));
        int[] iArr = this.d;
        int i = this.a - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }

    @Override // dc.vf1
    public vf1 b() throws IOException {
        if (!this.h) {
            m0();
            k0(1, 2, '[');
            return this;
        }
        throw new IllegalStateException("Array cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // dc.vf1
    public vf1 b0(long j) throws IOException {
        if (this.h) {
            x(Long.toString(j));
            return this;
        }
        m0();
        h0();
        this.j.s(Long.toString(j));
        int[] iArr = this.d;
        int i = this.a - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.j.close();
        int i = this.a;
        if (i > 1 || (i == 1 && this.b[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.a = 0;
    }

    @Override // dc.vf1
    public vf1 d0(Number number) throws IOException {
        if (number == null) {
            y();
            return this;
        }
        String string = number.toString();
        if (!this.f && (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        if (this.h) {
            x(string);
            return this;
        }
        m0();
        h0();
        this.j.s(string);
        int[] iArr = this.d;
        int i = this.a - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }

    @Override // dc.vf1
    public vf1 e() throws IOException {
        if (!this.h) {
            m0();
            k0(3, 5, MessageFormatter.DELIM_START);
            return this;
        }
        throw new IllegalStateException("Object cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // dc.vf1
    public vf1 e0(String str) throws IOException {
        if (str == null) {
            y();
            return this;
        }
        if (this.h) {
            x(str);
            return this;
        }
        m0();
        h0();
        l0(this.j, str);
        int[] iArr = this.d;
        int i = this.a - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }

    @Override // dc.vf1
    public vf1 f0(boolean z) throws IOException {
        if (this.h) {
            throw new IllegalStateException("Boolean cannot be used as a map key in JSON at path " + getPath());
        }
        m0();
        h0();
        this.j.s(z ? "true" : "false");
        int[] iArr = this.d;
        int i = this.a - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.a == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.j.flush();
    }

    public final void g0() throws IOException {
        int iC = C();
        if (iC == 5) {
            this.j.writeByte(44);
        } else if (iC != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        j0();
        L(4);
    }

    public final void h0() throws IOException {
        int iC = C();
        int i = 7;
        if (iC == 1) {
            j0();
            i = 2;
        } else if (iC == 2) {
            this.j.writeByte(44);
            j0();
            i = 2;
        } else if (iC == 4) {
            i = 5;
            this.j.s(this.k);
        } else {
            if (iC == 9) {
                throw new IllegalStateException("Sink from valueSink() was not closed");
            }
            if (iC != 6) {
                if (iC != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
        }
        L(i);
    }

    public final vf1 i0(int i, int i2, char c) throws IOException {
        int iC = C();
        if (iC != i2 && iC != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.l != null) {
            throw new IllegalStateException("Dangling name: " + this.l);
        }
        int i3 = this.a;
        int i4 = this.i;
        if (i3 == (~i4)) {
            this.i = ~i4;
            return this;
        }
        int i5 = i3 - 1;
        this.a = i5;
        this.c[i5] = null;
        int[] iArr = this.d;
        int i6 = i5 - 1;
        iArr[i6] = iArr[i6] + 1;
        if (iC == i2) {
            j0();
        }
        this.j.writeByte(c);
        return this;
    }

    @Override // dc.vf1
    public vf1 j() throws IOException {
        i0(1, 2, ']');
        return this;
    }

    public final void j0() throws IOException {
        if (this.e == null) {
            return;
        }
        this.j.writeByte(10);
        int i = this.a;
        for (int i2 = 1; i2 < i; i2++) {
            this.j.s(this.e);
        }
    }

    public final vf1 k0(int i, int i2, char c) throws IOException {
        int i3 = this.a;
        int i4 = this.i;
        if (i3 == i4) {
            int[] iArr = this.b;
            if (iArr[i3 - 1] == i || iArr[i3 - 1] == i2) {
                this.i = ~i4;
                return this;
            }
        }
        h0();
        f();
        K(i);
        this.d[this.a - 1] = 0;
        this.j.writeByte(c);
        return this;
    }

    @Override // dc.vf1
    public vf1 m() throws IOException {
        this.h = false;
        i0(3, 5, MessageFormatter.DELIM_STOP);
        return this;
    }

    public final void m0() throws IOException {
        if (this.l != null) {
            g0();
            l0(this.j, this.l);
            this.l = null;
        }
    }

    @Override // dc.vf1
    public vf1 x(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.a == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        int iC = C();
        if ((iC != 3 && iC != 5) || this.l != null) {
            throw new IllegalStateException("Nesting problem.");
        }
        this.l = str;
        this.c[this.a - 1] = str;
        this.h = false;
        return this;
    }

    @Override // dc.vf1
    public vf1 y() throws IOException {
        if (this.h) {
            throw new IllegalStateException("null cannot be used as a map key in JSON at path " + getPath());
        }
        if (this.l != null) {
            if (!this.g) {
                this.l = null;
                return this;
            }
            m0();
        }
        h0();
        this.j.s("null");
        int[] iArr = this.d;
        int i = this.a - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }
}
