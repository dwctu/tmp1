package com.broadcom.bt.util.mime4j.decoder;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.codec.net.URLCodec;

/* loaded from: classes.dex */
public class Base64InputStream extends InputStream {
    private static byte[] TRANSLATION = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, Ascii.SI, 16, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, -1, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, URLCodec.ESCAPE_CHAR, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private final InputStream s;
    private int outCount = 0;
    private int outIndex = 0;
    private final int[] outputBuffer = new int[3];
    private final byte[] inputBuffer = new byte[4];
    private boolean done = false;

    public Base64InputStream(InputStream inputStream) {
        this.s = inputStream;
    }

    private void decodeAndEnqueue(int i) {
        byte[] bArr = this.inputBuffer;
        int i2 = bArr[3] | (bArr[0] << Ascii.DC2) | 0 | (bArr[1] << 12) | (bArr[2] << 6);
        if (i == 4) {
            int[] iArr = this.outputBuffer;
            iArr[0] = (i2 >> 16) & 255;
            iArr[1] = (i2 >> 8) & 255;
            iArr[2] = i2 & 255;
            this.outCount = 3;
            return;
        }
        if (i != 3) {
            this.outputBuffer[0] = (i2 >> 16) & 255;
            this.outCount = 1;
        } else {
            int[] iArr2 = this.outputBuffer;
            iArr2[0] = (i2 >> 16) & 255;
            iArr2[1] = (i2 >> 8) & 255;
            this.outCount = 2;
        }
    }

    private void fillBuffer() throws IOException {
        int i;
        int i2 = 0;
        this.outCount = 0;
        this.outIndex = 0;
        while (!this.done && (i = this.s.read()) != -1) {
            if (i == 61) {
                this.done = true;
                decodeAndEnqueue(i2);
                return;
            }
            byte b = TRANSLATION[i];
            if (b >= 0) {
                int i3 = i2 + 1;
                this.inputBuffer[i2] = b;
                if (i3 == 4) {
                    decodeAndEnqueue(i3);
                    return;
                }
                i2 = i3;
            }
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.s.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.outIndex == this.outCount) {
            fillBuffer();
            if (this.outIndex == this.outCount) {
                return -1;
            }
        }
        int[] iArr = this.outputBuffer;
        int i = this.outIndex;
        this.outIndex = i + 1;
        return iArr[i];
    }
}
