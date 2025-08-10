package com.huawei.hms.scankit.aiscan.common;

/* compiled from: GenericGFPoly.java */
/* loaded from: classes3.dex */
public final class i {
    private final h a;
    private final int[] b;

    public i(h hVar, int[] iArr) throws Exception {
        if (iArr.length == 0) {
            try {
                throw new IllegalArgumentException();
            } catch (Exception e) {
                throw e;
            }
        }
        this.a = hVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.b = iArr;
            return;
        }
        int i = 1;
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i];
        this.b = iArr2;
        System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
    }

    public int[] a() {
        return this.b;
    }

    public int b() {
        return this.b.length - 1;
    }

    public boolean c() {
        return this.b[0] == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(b() * 8);
        for (int iB = b(); iB >= 0; iB--) {
            int iB2 = b(iB);
            if (iB2 != 0) {
                if (iB2 < 0) {
                    sb.append(" - ");
                    iB2 = -iB2;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iB == 0 || iB2 != 1) {
                    int iC = this.a.c(iB2);
                    if (iC == 0) {
                        sb.append('1');
                    } else if (iC == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(iC);
                    }
                }
                if (iB != 0) {
                    if (iB == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iB);
                    }
                }
            }
        }
        return sb.toString();
    }

    public int a(int i) {
        if (i == 0) {
            return b(0);
        }
        if (i == 1) {
            int iA = 0;
            for (int i2 : this.b) {
                iA = h.a(iA, i2);
            }
            return iA;
        }
        int[] iArr = this.b;
        int iA2 = iArr[0];
        int length = iArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            iA2 = h.a(this.a.c(i, iA2), this.b[i3]);
        }
        return iA2;
    }

    public int b(int i) {
        return this.b[(r0.length - 1) - i];
    }

    public i c(i iVar) throws Exception {
        if (!this.a.equals(iVar.a)) {
            try {
                throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
            } catch (Exception e) {
                throw e;
            }
        }
        if (c() || iVar.c()) {
            return this.a.d();
        }
        int[] iArr = this.b;
        int length = iArr.length;
        int[] iArr2 = iVar.b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i + i3;
                iArr3[i4] = h.a(iArr3[i4], this.a.c(i2, iArr2[i3]));
            }
        }
        return new i(this.a, iArr3);
    }

    public i[] b(i iVar) throws Exception {
        if (this.a.equals(iVar.a)) {
            if (!iVar.c()) {
                i iVarD = this.a.d();
                int iB = this.a.b(iVar.b(iVar.b()));
                i iVarA = this;
                while (iVarA.b() >= iVar.b() && !iVarA.c()) {
                    int iB2 = iVarA.b() - iVar.b();
                    int iC = this.a.c(iVarA.b(iVarA.b()), iB);
                    i iVarA2 = iVar.a(iB2, iC);
                    iVarD = iVarD.a(this.a.b(iB2, iC));
                    iVarA = iVarA.a(iVarA2);
                }
                return new i[]{iVarD, iVarA};
            }
            try {
                throw new IllegalArgumentException("Divide by 0");
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } catch (Exception e2) {
            throw e2;
        }
    }

    public i a(i iVar) throws Exception {
        if (this.a.equals(iVar.a)) {
            if (c()) {
                return iVar;
            }
            if (iVar.c()) {
                return this;
            }
            int[] iArr = this.b;
            int[] iArr2 = iVar.b;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i = length; i < iArr.length; i++) {
                iArr3[i] = h.a(iArr2[i - length], iArr[i]);
            }
            return new i(this.a, iArr3);
        }
        try {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } catch (Exception e) {
            throw e;
        }
    }

    public i c(int i) {
        if (i == 0) {
            return this.a.d();
        }
        if (i == 1) {
            return this;
        }
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.a.c(this.b[i2], i);
        }
        return new i(this.a, iArr);
    }

    public i a(int i, int i2) throws Exception {
        if (i < 0) {
            try {
                throw new IllegalArgumentException();
            } catch (Exception e) {
                throw e;
            }
        }
        if (i2 == 0) {
            return this.a.d();
        }
        int length = this.b.length;
        int[] iArr = new int[i + length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.a.c(this.b[i3], i2);
        }
        return new i(this.a, iArr);
    }
}
