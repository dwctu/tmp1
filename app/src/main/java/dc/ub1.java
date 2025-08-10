package dc;

import com.wear.util.WearUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: GetCharAscii.java */
/* loaded from: classes3.dex */
public class ub1 {
    public static char a(int i) {
        return (char) i;
    }

    public static byte b(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static int c(String str) {
        Matcher matcher = Pattern.compile("^(\\d+)(.*)").matcher(str);
        if (matcher.matches() && str.indexOf(";") == str.length() - 1) {
            return Integer.parseInt(matcher.group(1));
        }
        return -1;
    }

    public static String d(String str) {
        if (tb1.h(str) || !g(str)) {
            return "";
        }
        String strSubstring = str.substring(0, 1);
        String strSubstring2 = str.substring(1, 3);
        String strSubstring3 = str.substring(3, 5);
        String strSubstring4 = str.substring(5, 7);
        String strSubstring5 = str.substring(7, 9);
        String strSubstring6 = str.substring(9, 11);
        String strSubstring7 = str.substring(11);
        int iH = h(e(strSubstring3));
        int iH2 = h(e(strSubstring4));
        int iH3 = h(e(strSubstring5));
        int iH4 = h(e(strSubstring6));
        byte b = (byte) ((((byte) iH3) ^ (((byte) (iH3 * iH4)) ^ ((byte) (iH3 + iH4)))) ^ ((byte) iH4));
        return (strSubstring + strSubstring2 + Integer.toHexString(((byte) iH) ^ b) + Integer.toHexString(((byte) iH2) ^ b) + "0000" + strSubstring7).toUpperCase();
    }

    public static byte[] e(String str) {
        if (str == null || str.equals("") || str.length() % 2 != 0) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        char[] charArray = upperCase.toCharArray();
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (b(charArray[i2 + 1]) | (b(charArray[i2]) << 4));
        }
        return bArr;
    }

    public static boolean f(String str) {
        return !WearUtils.e1(str) && str.split(",").length == 1 && Pattern.compile("^(\\d+)(.*)").matcher(str).matches() && str.indexOf(";") == str.length() - 1 && str.indexOf("b,") == -1;
    }

    public static boolean g(String str) {
        return str.startsWith("$01") && str.endsWith(";") && str.length() == 20;
    }

    public static int h(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            i += (bArr[i2] & 255) << (i2 * 8);
        }
        return i;
    }
}
