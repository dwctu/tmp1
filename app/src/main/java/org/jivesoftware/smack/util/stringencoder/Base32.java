package org.jivesoftware.smack.util.stringencoder;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes5.dex */
public class Base32 {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ2345678";
    private static final StringEncoder base32Stringencoder = new StringEncoder() { // from class: org.jivesoftware.smack.util.stringencoder.Base32.1
        @Override // org.jivesoftware.smack.util.stringencoder.StringEncoder
        public String decode(String str) {
            return Base32.decode(str);
        }

        @Override // org.jivesoftware.smack.util.stringencoder.StringEncoder
        public String encode(String str) {
            return Base32.encode(str);
        }
    };

    public static String decode(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (byte b : str.getBytes()) {
            char c = (char) b;
            if (!Character.isWhitespace(c)) {
                byteArrayOutputStream.write((byte) Character.toUpperCase(c));
            }
        }
        while (byteArrayOutputStream.size() % 8 != 0) {
            byteArrayOutputStream.write(56);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.reset();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        for (int i = 0; i < byteArray.length / 8; i++) {
            short[] sArr = new short[8];
            int[] iArr = new int[5];
            int i2 = 8;
            for (int i3 = 0; i3 < 8; i3++) {
                int i4 = (i * 8) + i3;
                if (((char) byteArray[i4]) == '8') {
                    break;
                }
                sArr[i3] = (short) ALPHABET.indexOf(byteArray[i4]);
                if (sArr[i3] < 0) {
                    return null;
                }
                i2--;
            }
            int iPaddingToLen = paddingToLen(i2);
            if (iPaddingToLen < 0) {
                return null;
            }
            iArr[0] = (sArr[0] << 3) | (sArr[1] >> 2);
            iArr[1] = ((sArr[1] & 3) << 6) | (sArr[2] << 1) | (sArr[3] >> 4);
            iArr[2] = ((sArr[3] & 15) << 4) | ((sArr[4] >> 1) & 15);
            iArr[3] = (sArr[4] << 7) | (sArr[5] << 2) | (sArr[6] >> 3);
            iArr[4] = sArr[7] | ((sArr[6] & 7) << 5);
            for (int i5 = 0; i5 < iPaddingToLen; i5++) {
                try {
                    dataOutputStream.writeByte((byte) (iArr[i5] & 255));
                } catch (IOException unused) {
                }
            }
        }
        return new String(byteArrayOutputStream.toByteArray());
    }

    public static String encode(String str) {
        byte[] bytes = str.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < (bytes.length + 4) / 5; i++) {
            short[] sArr = new short[5];
            int[] iArr = new int[8];
            int i2 = 5;
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = (i * 5) + i3;
                if (i4 < bytes.length) {
                    sArr[i3] = (short) (bytes[i4] & 255);
                } else {
                    sArr[i3] = 0;
                    i2--;
                }
            }
            int iLenToPadding = lenToPadding(i2);
            iArr[0] = (byte) ((sArr[0] >> 3) & 31);
            iArr[1] = (byte) (((sArr[0] & 7) << 2) | ((sArr[1] >> 6) & 3));
            iArr[2] = (byte) ((sArr[1] >> 1) & 31);
            iArr[3] = (byte) (((sArr[1] & 1) << 4) | ((sArr[2] >> 4) & 15));
            iArr[4] = (byte) (((sArr[2] & 15) << 1) | (1 & (sArr[3] >> 7)));
            iArr[5] = (byte) ((sArr[3] >> 2) & 31);
            iArr[6] = (byte) (((sArr[4] >> 5) & 7) | ((sArr[3] & 3) << 3));
            iArr[7] = (byte) (sArr[4] & 31);
            for (int i5 = 0; i5 < 8 - iLenToPadding; i5++) {
                byteArrayOutputStream.write(ALPHABET.charAt(iArr[i5]));
            }
        }
        return new String(byteArrayOutputStream.toByteArray());
    }

    public static StringEncoder getStringEncoder() {
        return base32Stringencoder;
    }

    private static int lenToPadding(int i) {
        if (i == 1) {
            return 6;
        }
        if (i == 2) {
            return 4;
        }
        if (i == 3) {
            return 3;
        }
        if (i != 4) {
            return i != 5 ? -1 : 0;
        }
        return 1;
    }

    private static int paddingToLen(int i) {
        if (i == 0) {
            return 5;
        }
        if (i == 1) {
            return 4;
        }
        if (i == 3) {
            return 3;
        }
        if (i != 4) {
            return i != 6 ? -1 : 1;
        }
        return 2;
    }
}
