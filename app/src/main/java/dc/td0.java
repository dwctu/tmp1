package dc;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: EncryptUtils.java */
/* loaded from: classes.dex */
public final class td0 {
    public static byte[] a(byte[] bArr) {
        return e(bArr, "MD5");
    }

    public static String b(String str) {
        return (str == null || str.length() == 0) ? "" : d(str.getBytes());
    }

    public static String c(String str, String str2) {
        if (str == null && str2 == null) {
            return "";
        }
        if (str2 == null) {
            return xe0.c(a(str.getBytes()));
        }
        if (str == null) {
            return xe0.c(a(str2.getBytes()));
        }
        return xe0.c(a((str + str2).getBytes()));
    }

    public static String d(byte[] bArr) {
        return xe0.c(a(bArr));
    }

    public static byte[] e(byte[] bArr, String str) throws NoSuchAlgorithmException {
        if (bArr != null && bArr.length > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                messageDigest.update(bArr);
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
