package dc;

import java.util.Arrays;
import net.lingala.zip4j.exception.ZipException;

/* compiled from: AESDecrypter.java */
/* loaded from: classes5.dex */
public class d84 implements f84 {
    public l84 a;
    public g84 b;
    public int c = 1;
    public byte[] d = new byte[16];
    public byte[] e = new byte[16];

    public d84(d94 d94Var, char[] cArr, byte[] bArr, byte[] bArr2, boolean z) throws ZipException {
        c(bArr, bArr2, cArr, d94Var, z);
    }

    @Override // dc.f84
    public int a(byte[] bArr, int i, int i2) throws ZipException {
        int i3 = i;
        while (true) {
            int i4 = i + i2;
            if (i3 >= i4) {
                return i2;
            }
            int i5 = i3 + 16;
            int i6 = i5 <= i4 ? 16 : i4 - i3;
            this.b.e(bArr, i3, i6);
            e84.e(this.d, this.c);
            this.a.e(this.d, this.e);
            for (int i7 = 0; i7 < i6; i7++) {
                int i8 = i3 + i7;
                bArr[i8] = (byte) (bArr[i8] ^ this.e[i7]);
            }
            this.c++;
            i3 = i5;
        }
    }

    public byte[] b(int i) {
        return this.b.c(i);
    }

    public final void c(byte[] bArr, byte[] bArr2, char[] cArr, d94 d94Var, boolean z) throws ZipException {
        if (cArr == null || cArr.length <= 0) {
            throw new ZipException("empty or null password provided for AES decryption", ZipException.a.WRONG_PASSWORD);
        }
        t94 t94VarB = d94Var.b();
        byte[] bArrA = e84.a(bArr, cArr, t94VarB, z);
        if (!Arrays.equals(bArr2, e84.b(bArrA, t94VarB))) {
            throw new ZipException("Wrong Password", ZipException.a.WRONG_PASSWORD);
        }
        this.a = e84.c(bArrA, t94VarB);
        this.b = e84.d(bArrA, t94VarB);
    }
}
