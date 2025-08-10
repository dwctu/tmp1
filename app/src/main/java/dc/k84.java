package dc;

import net.lingala.zip4j.exception.ZipException;

/* compiled from: StandardDecrypter.java */
/* loaded from: classes5.dex */
public class k84 implements f84 {
    public m84 a = new m84();

    public k84(char[] cArr, long j, long j2, byte[] bArr, boolean z) throws ZipException {
        b(bArr, cArr, j2, j, z);
    }

    @Override // dc.f84
    public int a(byte[] bArr, int i, int i2) throws ZipException {
        if (i < 0 || i2 < 0) {
            throw new ZipException("one of the input parameters were null in standard decrypt data");
        }
        for (int i3 = i; i3 < i + i2; i3++) {
            byte b = (byte) (((bArr[i3] & 255) ^ this.a.b()) & 255);
            this.a.d(b);
            bArr[i3] = b;
        }
        return i2;
    }

    public final void b(byte[] bArr, char[] cArr, long j, long j2, boolean z) throws ZipException {
        byte b;
        if (cArr == null || cArr.length <= 0) {
            throw new ZipException("Wrong password!", ZipException.a.WRONG_PASSWORD);
        }
        this.a.c(cArr, z);
        int i = 0;
        byte b2 = bArr[0];
        while (i < 12) {
            i++;
            if (i == 12 && (b = (byte) (this.a.b() ^ b2)) != ((byte) (j2 >> 24)) && b != ((byte) (j >> 8))) {
                throw new ZipException("Wrong password!", ZipException.a.WRONG_PASSWORD);
            }
            m84 m84Var = this.a;
            m84Var.d((byte) (m84Var.b() ^ b2));
            if (i != 12) {
                b2 = bArr[i];
            }
        }
    }
}
