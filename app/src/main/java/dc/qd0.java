package dc;

import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: ConvertUtils.java */
/* loaded from: classes.dex */
public final class qd0 {
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        return b(bArr, false);
    }

    public static String b(byte[] bArr, boolean z) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = z ? a : b;
        int length = bArr.length;
        if (length <= 0) {
            return "";
        }
        char[] cArr2 = new char[length << 1];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr2[i] = cArr[(bArr[i2] >> 4) & 15];
            i = i3 + 1;
            cArr2[i3] = cArr[bArr[i2] & Ascii.SI];
        }
        return new String(cArr2);
    }

    public static String c(byte[] bArr) {
        return d(bArr, "");
    }

    public static String d(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, e(str));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new String(bArr);
        }
    }

    public static String e(String str) {
        return (xe0.K(str) || !Charset.isSupported(str)) ? "UTF-8" : str;
    }

    public static int f(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c < 'A' || c > 'F') {
            throw new IllegalArgumentException();
        }
        return (c - 'A') + 10;
    }

    public static byte[] g(String str) {
        if (xe0.K(str)) {
            return new byte[0];
        }
        int length = str.length();
        if (length % 2 != 0) {
            str = "0" + str;
            length++;
        }
        char[] charArray = str.toUpperCase().toCharArray();
        byte[] bArr = new byte[length >> 1];
        for (int i = 0; i < length; i += 2) {
            bArr[i >> 1] = (byte) ((f(charArray[i]) << 4) | f(charArray[i + 1]));
        }
        return bArr;
    }

    public static ByteArrayOutputStream h(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[8192];
                while (true) {
                    int i = inputStream.read(bArr, 0, 8192);
                    if (i == -1) {
                        xe0.d(inputStream);
                        return byteArrayOutputStream;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                }
            } catch (IOException e) {
                e.printStackTrace();
                xe0.d(inputStream);
                return null;
            }
        } catch (Throwable th) {
            xe0.d(inputStream);
            throw th;
        }
    }

    public static byte[] i(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        return h(inputStream).toByteArray();
    }

    public static byte[] j(String str) {
        return k(str, "");
    }

    public static byte[] k(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(e(str2));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str.getBytes();
        }
    }
}
