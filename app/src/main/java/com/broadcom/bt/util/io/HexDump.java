package com.broadcom.bt.util.io;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class HexDump {
    public static final String EOL = System.getProperty("line.separator");
    private static final char[] _hexcodes = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final int[] _shifts = {28, 24, 20, 16, 12, 8, 4, 0};

    public static void dump(byte[] bArr, long j, OutputStream outputStream, int i) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (i < 0 || i >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException("illegal index: " + i + " into array of length " + bArr.length);
        }
        if (outputStream == null) {
            throw new IllegalArgumentException("cannot write to nullstream");
        }
        long j2 = j + i;
        StringBuffer stringBuffer = new StringBuffer(74);
        while (i < bArr.length) {
            int length = bArr.length - i;
            if (length > 16) {
                length = 16;
            }
            dump(stringBuffer, j2).append(' ');
            for (int i2 = 0; i2 < 16; i2++) {
                if (i2 < length) {
                    dump(stringBuffer, bArr[i2 + i]);
                } else {
                    stringBuffer.append("  ");
                }
                stringBuffer.append(' ');
            }
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = i3 + i;
                if (bArr[i4] < 32 || bArr[i4] >= Byte.MAX_VALUE) {
                    stringBuffer.append(FilenameUtils.EXTENSION_SEPARATOR);
                } else {
                    stringBuffer.append((char) bArr[i4]);
                }
            }
            stringBuffer.append(EOL);
            outputStream.write(stringBuffer.toString().getBytes());
            outputStream.flush();
            stringBuffer.setLength(0);
            j2 += length;
            i += 16;
        }
    }

    private static StringBuffer dump(StringBuffer stringBuffer, long j) {
        for (int i = 0; i < 8; i++) {
            stringBuffer.append(_hexcodes[((int) (j >> _shifts[i])) & 15]);
        }
        return stringBuffer;
    }

    private static StringBuffer dump(StringBuffer stringBuffer, byte b) {
        for (int i = 0; i < 2; i++) {
            stringBuffer.append(_hexcodes[(b >> _shifts[i + 6]) & 15]);
        }
        return stringBuffer;
    }
}
