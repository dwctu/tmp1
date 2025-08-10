package dc;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Calendar;
import net.lingala.zip4j.exception.ZipException;

/* compiled from: Zip4jUtil.java */
/* loaded from: classes5.dex */
public class ja4 {
    public static byte[] a(char[] cArr, boolean z) {
        return z ? c(cArr) : b(cArr);
    }

    public static byte[] b(char[] cArr) {
        byte[] bArr = new byte[cArr.length];
        for (int i = 0; i < cArr.length; i++) {
            bArr[i] = (byte) cArr[i];
        }
        return bArr;
    }

    public static byte[] c(char[] cArr) {
        try {
            ByteBuffer byteBufferEncode = fa4.b.encode(CharBuffer.wrap(cArr));
            byte[] bArr = new byte[byteBufferEncode.limit()];
            byteBufferEncode.get(bArr);
            return bArr;
        } catch (Exception unused) {
            return b(cArr);
        }
    }

    public static boolean d(File file) throws ZipException {
        if (file == null) {
            throw new ZipException("output path is null");
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                return true;
            }
            throw new ZipException("output directory is not valid");
        }
        if (file.mkdirs()) {
            return true;
        }
        throw new ZipException("Cannot create output directories");
    }

    public static long e(long j) {
        int i = (int) ((j << 1) & 62);
        int i2 = (int) ((j >> 5) & 63);
        int i3 = (int) ((j >> 11) & 31);
        int i4 = (int) ((j >> 16) & 31);
        int i5 = (int) (((j >> 21) & 15) - 1);
        int i6 = (int) (((j >> 25) & 127) + 1980);
        Calendar calendar = Calendar.getInstance();
        calendar.set(i6, i5, i4, i3, i2, i);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    public static long f(long j) {
        return e(j) + (j >> 32);
    }

    public static v94 g(e94 e94Var) throws ZipException {
        if (e94Var.d() != v94.AES_INTERNAL_ONLY) {
            return e94Var.d();
        }
        if (e94Var.b() != null) {
            return e94Var.b().d();
        }
        throw new ZipException("AesExtraDataRecord not present in local header for aes encrypted data");
    }

    public static boolean h(String str) {
        return str != null && str.trim().length() > 0;
    }

    public static int i(InputStream inputStream, byte[] bArr) throws IOException {
        int iK = inputStream.read(bArr);
        if (iK == -1) {
            throw new IOException("Unexpected EOF reached when trying to read stream");
        }
        if (iK == bArr.length || (iK = k(inputStream, bArr, iK)) == bArr.length) {
            return iK;
        }
        throw new IOException("Cannot read fully into byte buffer");
    }

    public static int j(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        if (i < 0) {
            throw new IllegalArgumentException("Negative offset");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        if (i + i2 > bArr.length) {
            throw new IllegalArgumentException("Length greater than buffer size");
        }
        while (i3 != i2) {
            int i4 = inputStream.read(bArr, i + i3, i2 - i3);
            if (i4 == -1) {
                if (i3 == 0) {
                    return -1;
                }
                return i3;
            }
            i3 += i4;
        }
        return i3;
    }

    public static int k(InputStream inputStream, byte[] bArr, int i) throws IOException {
        if (i < 0) {
            throw new IOException("Invalid readLength");
        }
        int i2 = 0;
        if (i == 0) {
            return 0;
        }
        int length = bArr.length - i;
        for (int i3 = 1; i < bArr.length && i2 != -1 && i3 < 15; i3++) {
            i2 = inputStream.read(bArr, i, length);
            if (i2 > 0) {
                i += i2;
                length -= i2;
            }
        }
        return i;
    }
}
