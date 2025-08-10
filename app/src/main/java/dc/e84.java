package dc;

import java.security.InvalidKeyException;
import net.lingala.zip4j.exception.ZipException;
import org.jivesoftware.smack.util.MAC;

/* compiled from: AesCipherUtil.java */
/* loaded from: classes5.dex */
public class e84 {
    public static byte[] a(byte[] bArr, char[] cArr, t94 t94Var, boolean z) throws ZipException {
        h84 h84Var = new h84(new i84(MAC.HMACSHA1, "ISO-8859-1", bArr, 1000));
        int keyLength = t94Var.getKeyLength();
        int macLength = t94Var.getMacLength();
        int i = keyLength + macLength + 2;
        byte[] bArrF = h84Var.f(cArr, i, z);
        if (bArrF == null || bArrF.length != i) {
            throw new ZipException(String.format("Derived Key invalid for Key Length [%d] MAC Length [%d]", Integer.valueOf(keyLength), Integer.valueOf(macLength)));
        }
        return bArrF;
    }

    public static byte[] b(byte[] bArr, t94 t94Var) {
        byte[] bArr2 = new byte[2];
        System.arraycopy(bArr, t94Var.getKeyLength() + t94Var.getMacLength(), bArr2, 0, 2);
        return bArr2;
    }

    public static l84 c(byte[] bArr, t94 t94Var) throws ZipException {
        int keyLength = t94Var.getKeyLength();
        byte[] bArr2 = new byte[keyLength];
        System.arraycopy(bArr, 0, bArr2, 0, keyLength);
        return new l84(bArr2);
    }

    public static g84 d(byte[] bArr, t94 t94Var) throws InvalidKeyException {
        int macLength = t94Var.getMacLength();
        byte[] bArr2 = new byte[macLength];
        System.arraycopy(bArr, t94Var.getKeyLength(), bArr2, 0, macLength);
        g84 g84Var = new g84(MAC.HMACSHA1);
        g84Var.init(bArr2);
        return g84Var;
    }

    public static void e(byte[] bArr, int i) {
        bArr[0] = (byte) i;
        bArr[1] = (byte) (i >> 8);
        bArr[2] = (byte) (i >> 16);
        bArr[3] = (byte) (i >> 24);
        for (int i2 = 4; i2 <= 15; i2++) {
            bArr[i2] = 0;
        }
    }
}
