package org.bouncycastle.util;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;

/* loaded from: classes5.dex */
public final class Strings {
    public static char[] asCharArray(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i != length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        return cArr;
    }

    public static String fromByteArray(byte[] bArr) {
        return new String(asCharArray(bArr));
    }

    public static String fromUTF8ByteArray(byte[] bArr) {
        char c;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length) {
            i3++;
            if ((bArr[i2] & 240) == 240) {
                i3++;
                i2 += 4;
            } else {
                i2 = (bArr[i2] & 224) == 224 ? i2 + 3 : (bArr[i2] & 192) == 192 ? i2 + 2 : i2 + 1;
            }
        }
        char[] cArr = new char[i3];
        int i4 = 0;
        while (i < bArr.length) {
            if ((bArr[i] & 240) == 240) {
                int i5 = (((((bArr[i] & 3) << 18) | ((bArr[i + 1] & 63) << 12)) | ((bArr[i + 2] & 63) << 6)) | (bArr[i + 3] & 63)) - 65536;
                char c2 = (char) (55296 | (i5 >> 10));
                c = (char) ((i5 & 1023) | 56320);
                cArr[i4] = c2;
                i += 4;
                i4++;
            } else if ((bArr[i] & 224) == 224) {
                c = (char) (((bArr[i] & Ascii.SI) << 12) | ((bArr[i + 1] & 63) << 6) | (bArr[i + 2] & 63));
                i += 3;
            } else if ((bArr[i] & 208) == 208 || (bArr[i] & 192) == 192) {
                int i6 = (bArr[i] & Ascii.US) << 6;
                byte b = bArr[i + 1];
                c = (char) (i6 | (b & 63));
                i += 2;
            } else {
                c = (char) (bArr[i] & 255);
                i++;
            }
            cArr[i4] = c;
            i4++;
        }
        return new String(cArr);
    }

    public static String[] split(String str, char c) {
        int i;
        Vector vector = new Vector();
        boolean z = true;
        while (true) {
            if (!z) {
                break;
            }
            int iIndexOf = str.indexOf(c);
            if (iIndexOf > 0) {
                vector.addElement(str.substring(0, iIndexOf));
                str = str.substring(iIndexOf + 1);
            } else {
                vector.addElement(str);
                z = false;
            }
        }
        int size = vector.size();
        String[] strArr = new String[size];
        for (i = 0; i != size; i++) {
            strArr[i] = (String) vector.elementAt(i);
        }
        return strArr;
    }

    public static byte[] toByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    public static byte[] toByteArray(char[] cArr) {
        int length = cArr.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr[i] = (byte) cArr[i];
        }
        return bArr;
    }

    public static String toLowerCase(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i != charArray.length; i++) {
            char c = charArray[i];
            if ('A' <= c && 'Z' >= c) {
                charArray[i] = (char) ((c - 'A') + 97);
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }

    public static void toUTF8ByteArray(char[] cArr, OutputStream outputStream) throws IOException {
        int i;
        int i2;
        int i3 = 0;
        while (i3 < cArr.length) {
            char c = cArr[i3];
            int i4 = c;
            if (c >= 128) {
                if (c < 2048) {
                    i = (c >> 6) | 192;
                } else if (c < 55296 || c > 57343) {
                    outputStream.write((c >> '\f') | 224);
                    i = ((c >> 6) & 63) | 128;
                } else {
                    i3++;
                    if (i3 >= cArr.length) {
                        throw new IllegalStateException("invalid UTF-16 codepoint");
                    }
                    char c2 = cArr[i3];
                    if (c > 56319) {
                        throw new IllegalStateException("invalid UTF-16 codepoint");
                    }
                    int i5 = (((c & 1023) << 10) | (c2 & 1023)) + 65536;
                    outputStream.write((i5 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                    outputStream.write(((i5 >> 12) & 63) | 128);
                    outputStream.write(((i5 >> 6) & 63) | 128);
                    i2 = i5;
                    i4 = (i2 & 63) | 128;
                }
                outputStream.write(i);
                i2 = c;
                i4 = (i2 & 63) | 128;
            }
            outputStream.write(i4);
            i3++;
        }
    }

    public static byte[] toUTF8ByteArray(String str) {
        return toUTF8ByteArray(str.toCharArray());
    }

    public static byte[] toUTF8ByteArray(char[] cArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            toUTF8ByteArray(cArr, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            throw new IllegalStateException("cannot encode string to byte array!");
        }
    }

    public static String toUpperCase(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i != charArray.length; i++) {
            char c = charArray[i];
            if ('a' <= c && 'z' >= c) {
                charArray[i] = (char) ((c - 'a') + 65);
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }
}
