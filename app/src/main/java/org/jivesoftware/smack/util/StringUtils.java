package org.jivesoftware.smack.util;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

/* loaded from: classes5.dex */
public class StringUtils {
    public static final String AMP_ENCODE = "&amp;";
    public static final String APOS_ENCODE = "&apos;";
    public static final String GT_ENCODE = "&gt;";
    public static final String LT_ENCODE = "&lt;";
    public static final String MD5 = "MD5";
    public static final String QUOTE_ENCODE = "&quot;";
    public static final String SHA1 = "SHA-1";
    public static final String USASCII = "US-ASCII";
    public static final String UTF8 = "UTF-8";
    public static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();
    private static Random randGen = new Random();
    private static char[] numbersAndLetters = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static String collectionToString(Collection<String> collection) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(" ");
        }
        return sb.toString().substring(0, r2.length() - 1);
    }

    public static String encodeHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = HEX_CHARS;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    public static CharSequence escapeForXML(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        StringBuilder sb = new StringBuilder((int) (length * 1.3d));
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char c = charArray[i];
            String str2 = c != '\"' ? c != '<' ? c != '>' ? c != '&' ? c != '\'' ? null : APOS_ENCODE : AMP_ENCODE : GT_ENCODE : LT_ENCODE : QUOTE_ENCODE;
            if (str2 != null) {
                if (i > i2) {
                    sb.append(charArray, i2, i - i2);
                }
                sb.append((CharSequence) str2);
                i2 = i + 1;
                i = i2;
            } else {
                i++;
            }
        }
        if (i2 == 0) {
            return str;
        }
        if (i > i2) {
            sb.append(charArray, i2, i - i2);
        }
        return sb;
    }

    @Deprecated
    public static synchronized String hash(String str) {
        return SHA1.hex(str);
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence charSequence) {
        return !isNullOrEmpty(charSequence);
    }

    public static boolean isNullOrEmpty(CharSequence charSequence) {
        return charSequence == null || isEmpty(charSequence);
    }

    public static String maybeToString(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        return charSequence.toString();
    }

    public static int nullSafeCharSequenceComperator(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence == null) ^ (charSequence2 == null)) {
            return charSequence == null ? -1 : 1;
        }
        if (charSequence == null && charSequence2 == null) {
            return 0;
        }
        return charSequence.toString().compareTo(charSequence2.toString());
    }

    public static boolean nullSafeCharSequenceEquals(CharSequence charSequence, CharSequence charSequence2) {
        return nullSafeCharSequenceComperator(charSequence, charSequence2) == 0;
    }

    public static String randomString(int i) {
        if (i < 1) {
            return null;
        }
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            char[] cArr2 = numbersAndLetters;
            cArr[i2] = cArr2[randGen.nextInt(cArr2.length)];
        }
        return new String(cArr);
    }

    public static <CS extends CharSequence> CS requireNotNullOrEmpty(CS cs, String str) {
        if (isNullOrEmpty(cs)) {
            throw new IllegalArgumentException(str);
        }
        return cs;
    }

    public static String returnIfNotEmptyTrimmed(String str) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.length() > 0) {
            return strTrim;
        }
        return null;
    }

    public static byte[] toBytes(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8 encoding not supported by platform", e);
        }
    }
}
