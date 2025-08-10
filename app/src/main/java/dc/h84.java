package dc;

import java.util.Objects;

/* compiled from: PBKDF2Engine.java */
/* loaded from: classes5.dex */
public class h84 {
    public i84 a;
    public j84 b;

    public h84(i84 i84Var) {
        this(i84Var, null);
    }

    public void a(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 / 16777216);
        bArr[i + 1] = (byte) (i2 / 65536);
        bArr[i + 2] = (byte) (i2 / 256);
        bArr[i + 3] = (byte) i2;
    }

    public final byte[] b(j84 j84Var, byte[] bArr, int i, int i2) {
        byte[] bArr2 = bArr == null ? new byte[0] : bArr;
        int iA = j84Var.a();
        int iE = e(i2, iA);
        int i3 = i2 - ((iE - 1) * iA);
        byte[] bArr3 = new byte[iE * iA];
        int i4 = 0;
        for (int i5 = 1; i5 <= iE; i5++) {
            c(bArr3, i4, j84Var, bArr2, i, i5);
            i4 += iA;
        }
        if (i3 >= iA) {
            return bArr3;
        }
        byte[] bArr4 = new byte[i2];
        System.arraycopy(bArr3, 0, bArr4, 0, i2);
        return bArr4;
    }

    public final void c(byte[] bArr, int i, j84 j84Var, byte[] bArr2, int i2, int i3) {
        int iA = j84Var.a();
        byte[] bArr3 = new byte[iA];
        byte[] bArrB = new byte[bArr2.length + 4];
        System.arraycopy(bArr2, 0, bArrB, 0, bArr2.length);
        a(bArrB, bArr2.length, i3);
        for (int i4 = 0; i4 < i2; i4++) {
            bArrB = j84Var.b(bArrB);
            g(bArr3, bArrB);
        }
        System.arraycopy(bArr3, 0, bArr, i, iA);
    }

    public final void d(byte[] bArr) {
        if (this.b == null) {
            this.b = new g84(this.a.a());
        }
        this.b.init(bArr);
    }

    public final int e(int i, int i2) {
        return (i / i2) + (i % i2 > 0 ? 1 : 0);
    }

    public byte[] f(char[] cArr, int i, boolean z) {
        Objects.requireNonNull(cArr);
        d(ja4.a(cArr, z));
        if (i == 0) {
            i = this.b.a();
        }
        return b(this.b, this.a.c(), this.a.b(), i);
    }

    public final void g(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
    }

    public h84(i84 i84Var, j84 j84Var) {
        this.a = i84Var;
        this.b = j84Var;
    }
}
