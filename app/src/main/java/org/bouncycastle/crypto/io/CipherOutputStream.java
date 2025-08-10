package org.bouncycastle.crypto.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.modes.AEADBlockCipher;

/* loaded from: classes5.dex */
public class CipherOutputStream extends FilterOutputStream {
    private AEADBlockCipher aeadBlockCipher;
    private byte[] buf;
    private BufferedBlockCipher bufferedBlockCipher;
    private final byte[] oneByte;
    private StreamCipher streamCipher;

    public CipherOutputStream(OutputStream outputStream, BufferedBlockCipher bufferedBlockCipher) {
        super(outputStream);
        this.oneByte = new byte[1];
        this.bufferedBlockCipher = bufferedBlockCipher;
    }

    public CipherOutputStream(OutputStream outputStream, StreamCipher streamCipher) {
        super(outputStream);
        this.oneByte = new byte[1];
        this.streamCipher = streamCipher;
    }

    public CipherOutputStream(OutputStream outputStream, AEADBlockCipher aEADBlockCipher) {
        super(outputStream);
        this.oneByte = new byte[1];
        this.aeadBlockCipher = aEADBlockCipher;
    }

    private void ensureCapacity(int i) {
        BufferedBlockCipher bufferedBlockCipher = this.bufferedBlockCipher;
        if (bufferedBlockCipher != null) {
            i = bufferedBlockCipher.getOutputSize(i);
        } else {
            AEADBlockCipher aEADBlockCipher = this.aeadBlockCipher;
            if (aEADBlockCipher != null) {
                i = aEADBlockCipher.getOutputSize(i);
            }
        }
        byte[] bArr = this.buf;
        if (bArr == null || bArr.length < i) {
            this.buf = new byte[i];
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void close() throws java.io.IOException {
        /*
            r4 = this;
            r0 = 0
            r4.ensureCapacity(r0)
            org.bouncycastle.crypto.BufferedBlockCipher r1 = r4.bufferedBlockCipher     // Catch: java.lang.Exception -> L2d org.bouncycastle.crypto.InvalidCipherTextException -> L45
            if (r1 == 0) goto L18
            byte[] r2 = r4.buf     // Catch: java.lang.Exception -> L2d org.bouncycastle.crypto.InvalidCipherTextException -> L45
            int r1 = r1.doFinal(r2, r0)     // Catch: java.lang.Exception -> L2d org.bouncycastle.crypto.InvalidCipherTextException -> L45
            if (r1 == 0) goto L2b
            java.io.OutputStream r2 = r4.out     // Catch: java.lang.Exception -> L2d org.bouncycastle.crypto.InvalidCipherTextException -> L45
            byte[] r3 = r4.buf     // Catch: java.lang.Exception -> L2d org.bouncycastle.crypto.InvalidCipherTextException -> L45
            r2.write(r3, r0, r1)     // Catch: java.lang.Exception -> L2d org.bouncycastle.crypto.InvalidCipherTextException -> L45
            goto L2b
        L18:
            org.bouncycastle.crypto.modes.AEADBlockCipher r1 = r4.aeadBlockCipher     // Catch: java.lang.Exception -> L2d org.bouncycastle.crypto.InvalidCipherTextException -> L45
            if (r1 == 0) goto L2b
            byte[] r2 = r4.buf     // Catch: java.lang.Exception -> L2d org.bouncycastle.crypto.InvalidCipherTextException -> L45
            int r1 = r1.doFinal(r2, r0)     // Catch: java.lang.Exception -> L2d org.bouncycastle.crypto.InvalidCipherTextException -> L45
            if (r1 == 0) goto L2b
            java.io.OutputStream r2 = r4.out     // Catch: java.lang.Exception -> L2d org.bouncycastle.crypto.InvalidCipherTextException -> L45
            byte[] r3 = r4.buf     // Catch: java.lang.Exception -> L2d org.bouncycastle.crypto.InvalidCipherTextException -> L45
            r2.write(r3, r0, r1)     // Catch: java.lang.Exception -> L2d org.bouncycastle.crypto.InvalidCipherTextException -> L45
        L2b:
            r0 = 0
            goto L4e
        L2d:
            r0 = move-exception
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error closing stream: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            goto L4d
        L45:
            r0 = move-exception
            org.bouncycastle.crypto.io.InvalidCipherTextIOException r1 = new org.bouncycastle.crypto.io.InvalidCipherTextIOException
            java.lang.String r2 = "Error finalising cipher data"
            r1.<init>(r2, r0)
        L4d:
            r0 = r1
        L4e:
            r4.flush()     // Catch: java.io.IOException -> L57
            java.io.OutputStream r1 = r4.out     // Catch: java.io.IOException -> L57
            r1.close()     // Catch: java.io.IOException -> L57
            goto L5b
        L57:
            r1 = move-exception
            if (r0 != 0) goto L5b
            r0 = r1
        L5b:
            if (r0 != 0) goto L5e
            return
        L5e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.io.CipherOutputStream.close():void");
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        ((FilterOutputStream) this).out.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IllegalStateException, DataLengthException, IOException {
        byte[] bArr = this.oneByte;
        byte b = (byte) i;
        bArr[0] = b;
        StreamCipher streamCipher = this.streamCipher;
        if (streamCipher != null) {
            ((FilterOutputStream) this).out.write(streamCipher.returnByte(b));
        } else {
            write(bArr, 0, 1);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IllegalStateException, DataLengthException, IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IllegalStateException, DataLengthException, IOException {
        ensureCapacity(i2);
        BufferedBlockCipher bufferedBlockCipher = this.bufferedBlockCipher;
        if (bufferedBlockCipher != null) {
            int iProcessBytes = bufferedBlockCipher.processBytes(bArr, i, i2, this.buf, 0);
            if (iProcessBytes != 0) {
                ((FilterOutputStream) this).out.write(this.buf, 0, iProcessBytes);
                return;
            }
            return;
        }
        AEADBlockCipher aEADBlockCipher = this.aeadBlockCipher;
        if (aEADBlockCipher == null) {
            this.streamCipher.processBytes(bArr, i, i2, this.buf, 0);
            ((FilterOutputStream) this).out.write(this.buf, 0, i2);
        } else {
            int iProcessBytes2 = aEADBlockCipher.processBytes(bArr, i, i2, this.buf, 0);
            if (iProcessBytes2 != 0) {
                ((FilterOutputStream) this).out.write(this.buf, 0, iProcessBytes2);
            }
        }
    }
}
