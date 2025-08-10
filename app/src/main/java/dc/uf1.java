package dc;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: JsonValueWriter.java */
/* loaded from: classes3.dex */
public final class uf1 extends vf1 {
    public Object[] j = new Object[32];
    public String k;

    public uf1() {
        K(6);
    }

    @Override // dc.vf1
    public vf1 X(double d) throws IOException {
        if (!this.f && (Double.isNaN(d) || d == Double.NEGATIVE_INFINITY || d == Double.POSITIVE_INFINITY)) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
        }
        if (this.h) {
            x(Double.toString(d));
            return this;
        }
        g0(Double.valueOf(d));
        int[] iArr = this.d;
        int i = this.a - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }

    @Override // dc.vf1
    public vf1 b() throws IOException {
        if (this.h) {
            throw new IllegalStateException("Array cannot be used as a map key in JSON at path " + getPath());
        }
        int i = this.a;
        int i2 = this.i;
        if (i == i2 && this.b[i - 1] == 1) {
            this.i = ~i2;
            return this;
        }
        f();
        ArrayList arrayList = new ArrayList();
        g0(arrayList);
        Object[] objArr = this.j;
        int i3 = this.a;
        objArr[i3] = arrayList;
        this.d[i3] = 0;
        K(1);
        return this;
    }

    @Override // dc.vf1
    public vf1 b0(long j) throws IOException {
        if (this.h) {
            x(Long.toString(j));
            return this;
        }
        g0(Long.valueOf(j));
        int[] iArr = this.d;
        int i = this.a - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        int i = this.a;
        if (i > 1 || (i == 1 && this.b[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.a = 0;
    }

    @Override // dc.vf1
    public vf1 d0(Number number) throws IOException {
        if ((number instanceof Byte) || (number instanceof Short) || (number instanceof Integer) || (number instanceof Long)) {
            b0(number.longValue());
            return this;
        }
        if ((number instanceof Float) || (number instanceof Double)) {
            X(number.doubleValue());
            return this;
        }
        if (number == null) {
            y();
            return this;
        }
        BigDecimal bigDecimal = number instanceof BigDecimal ? (BigDecimal) number : new BigDecimal(number.toString());
        if (this.h) {
            x(bigDecimal.toString());
            return this;
        }
        g0(bigDecimal);
        int[] iArr = this.d;
        int i = this.a - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }

    @Override // dc.vf1
    public vf1 e() throws IOException {
        if (this.h) {
            throw new IllegalStateException("Object cannot be used as a map key in JSON at path " + getPath());
        }
        int i = this.a;
        int i2 = this.i;
        if (i == i2 && this.b[i - 1] == 3) {
            this.i = ~i2;
            return this;
        }
        f();
        wf1 wf1Var = new wf1();
        g0(wf1Var);
        this.j[this.a] = wf1Var;
        K(3);
        return this;
    }

    @Override // dc.vf1
    public vf1 e0(String str) throws IOException {
        if (this.h) {
            x(str);
            return this;
        }
        g0(str);
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
        g0(Boolean.valueOf(z));
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
    }

    public final uf1 g0(Object obj) {
        String str;
        Object objPut;
        int iC = C();
        int i = this.a;
        if (i == 1) {
            if (iC != 6) {
                throw new IllegalStateException("JSON must have only one top-level value.");
            }
            this.b[i - 1] = 7;
            this.j[i - 1] = obj;
        } else if (iC != 3 || (str = this.k) == null) {
            if (iC != 1) {
                if (iC == 9) {
                    throw new IllegalStateException("Sink from valueSink() was not closed");
                }
                throw new IllegalStateException("Nesting problem.");
            }
            ((List) this.j[i - 1]).add(obj);
        } else {
            if ((obj != null || this.g) && (objPut = ((Map) this.j[i - 1]).put(str, obj)) != null) {
                throw new IllegalArgumentException("Map key '" + this.k + "' has multiple values at path " + getPath() + ": " + objPut + " and " + obj);
            }
            this.k = null;
        }
        return this;
    }

    @Override // dc.vf1
    public vf1 j() throws IOException {
        if (C() != 1) {
            throw new IllegalStateException("Nesting problem.");
        }
        int i = this.a;
        int i2 = this.i;
        if (i == (~i2)) {
            this.i = ~i2;
            return this;
        }
        int i3 = i - 1;
        this.a = i3;
        this.j[i3] = null;
        int[] iArr = this.d;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        return this;
    }

    @Override // dc.vf1
    public vf1 m() throws IOException {
        if (C() != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.k != null) {
            throw new IllegalStateException("Dangling name: " + this.k);
        }
        int i = this.a;
        int i2 = this.i;
        if (i == (~i2)) {
            this.i = ~i2;
            return this;
        }
        this.h = false;
        int i3 = i - 1;
        this.a = i3;
        this.j[i3] = null;
        this.c[i3] = null;
        int[] iArr = this.d;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        return this;
    }

    @Override // dc.vf1
    public vf1 x(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.a == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        if (C() != 3 || this.k != null) {
            throw new IllegalStateException("Nesting problem.");
        }
        this.k = str;
        this.c[this.a - 1] = str;
        this.h = false;
        return this;
    }

    @Override // dc.vf1
    public vf1 y() throws IOException {
        if (this.h) {
            throw new IllegalStateException("null cannot be used as a map key in JSON at path " + getPath());
        }
        g0(null);
        int[] iArr = this.d;
        int i = this.a - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }
}
