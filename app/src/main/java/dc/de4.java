package dc;

import java.util.Arrays;

/* compiled from: SegmentedByteString.java */
/* loaded from: classes5.dex */
public final class de4 extends qd4 {
    public final transient byte[][] e;
    public final transient int[] f;

    public de4(nd4 nd4Var, int i) {
        super(null);
        he4.b(nd4Var.b, 0L, i);
        be4 be4Var = nd4Var.a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = be4Var.c;
            int i6 = be4Var.b;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            be4Var = be4Var.f;
        }
        this.e = new byte[i4][];
        this.f = new int[i4 * 2];
        be4 be4Var2 = nd4Var.a;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.e;
            bArr[i7] = be4Var2.a;
            int i8 = be4Var2.c;
            int i9 = be4Var2.b;
            i2 += i8 - i9;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.f;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            be4Var2.d = true;
            i7++;
            be4Var2 = be4Var2.f;
        }
    }

    private Object writeReplace() {
        return B();
    }

    public final int A(int i) {
        int iBinarySearch = Arrays.binarySearch(this.f, 0, this.e.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    public final qd4 B() {
        return new qd4(w());
    }

    @Override // dc.qd4
    public String a() {
        return B().a();
    }

    @Override // dc.qd4
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof qd4) {
            qd4 qd4Var = (qd4) obj;
            if (qd4Var.s() == s() && n(0, qd4Var, 0, s())) {
                return true;
            }
        }
        return false;
    }

    @Override // dc.qd4
    public int hashCode() {
        int i = this.a;
        if (i != 0) {
            return i;
        }
        int length = this.e.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.e[i2];
            int[] iArr = this.f;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.a = i4;
        return i4;
    }

    @Override // dc.qd4
    public byte i(int i) {
        he4.b(this.f[this.e.length - 1], i, 1L);
        int iA = A(i);
        int i2 = iA == 0 ? 0 : this.f[iA - 1];
        int[] iArr = this.f;
        byte[][] bArr = this.e;
        return bArr[iA][(i - i2) + iArr[bArr.length + iA]];
    }

    @Override // dc.qd4
    public String j() {
        return B().j();
    }

    @Override // dc.qd4
    public byte[] k() {
        return w();
    }

    @Override // dc.qd4
    public qd4 l() {
        return B().l();
    }

    @Override // dc.qd4
    public boolean n(int i, qd4 qd4Var, int i2, int i3) {
        if (i < 0 || i > s() - i3) {
            return false;
        }
        int iA = A(i);
        while (i3 > 0) {
            int i4 = iA == 0 ? 0 : this.f[iA - 1];
            int iMin = Math.min(i3, ((this.f[iA] - i4) + i4) - i);
            int[] iArr = this.f;
            byte[][] bArr = this.e;
            if (!qd4Var.o(i2, bArr[iA], (i - i4) + iArr[bArr.length + iA], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iA++;
        }
        return true;
    }

    @Override // dc.qd4
    public boolean o(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > s() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iA = A(i);
        while (i3 > 0) {
            int i4 = iA == 0 ? 0 : this.f[iA - 1];
            int iMin = Math.min(i3, ((this.f[iA] - i4) + i4) - i);
            int[] iArr = this.f;
            byte[][] bArr2 = this.e;
            if (!he4.a(bArr2[iA], (i - i4) + iArr[bArr2.length + iA], bArr, i2, iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iA++;
        }
        return true;
    }

    @Override // dc.qd4
    public qd4 q() {
        return B().q();
    }

    @Override // dc.qd4
    public qd4 r() {
        return B().r();
    }

    @Override // dc.qd4
    public int s() {
        return this.f[this.e.length - 1];
    }

    @Override // dc.qd4
    public String toString() {
        return B().toString();
    }

    @Override // dc.qd4
    public qd4 u(int i, int i2) {
        return B().u(i, i2);
    }

    @Override // dc.qd4
    public qd4 v() {
        return B().v();
    }

    @Override // dc.qd4
    public byte[] w() {
        int[] iArr = this.f;
        byte[][] bArr = this.e;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.f;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.e[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // dc.qd4
    public String x() {
        return B().x();
    }

    @Override // dc.qd4
    public void z(nd4 nd4Var) {
        int length = this.e.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.f;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            be4 be4Var = new be4(this.e[i], i3, (i3 + i4) - i2, true, false);
            be4 be4Var2 = nd4Var.a;
            if (be4Var2 == null) {
                be4Var.g = be4Var;
                be4Var.f = be4Var;
                nd4Var.a = be4Var;
            } else {
                be4Var2.g.c(be4Var);
            }
            i++;
            i2 = i4;
        }
        nd4Var.b += i2;
    }
}
