package dc;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: EncodeUtils.java */
/* loaded from: classes.dex */
public final class sd0 {
    public static byte[] a(String str) {
        return (str == null || str.length() == 0) ? new byte[0] : Base64.decode(str, 2);
    }

    public static String b(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? "" : Base64.encodeToString(bArr, 2);
    }

    public static String c(String str) {
        return d(str, "UTF-8");
    }

    public static String d(String str, String str2) {
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
