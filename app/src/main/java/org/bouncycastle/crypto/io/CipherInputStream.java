package org.bouncycastle.crypto.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.modes.AEADBlockCipher;

/* loaded from: classes5.dex */
public class CipherInputStream extends FilterInputStream {
    private static final int INPUT_BUF_SIZE = 2048;
    private AEADBlockCipher aeadBlockCipher;
    private final byte[] buf;
    private int bufOff;
    private BufferedBlockCipher bufferedBlockCipher;
    private boolean finalized;
    private final byte[] inBuf;
    private int maxBuf;
    private StreamCipher streamCipher;

    public CipherInputStream(InputStream inputStream, BufferedBlockCipher bufferedBlockCipher) {
        super(inputStream);
        this.bufferedBlockCipher = bufferedBlockCipher;
        this.buf = new byte[bufferedBlockCipher.getOutputSize(2048)];
        this.inBuf = new byte[2048];
    }

    public CipherInputStream(InputStream inputStream, StreamCipher streamCipher) {
        super(inputStream);
        this.streamCipher = streamCipher;
        this.buf = new byte[2048];
        this.inBuf = new byte[2048];
    }

    public CipherInputStream(InputStream inputStream, AEADBlockCipher aEADBlockCipher) {
        super(inputStream);
        this.aeadBlockCipher = aEADBlockCipher;
        this.buf = new byte[aEADBlockCipher.getOutputSize(2048)];
        this.inBuf = new byte[2048];
    }

    private void finaliseCipher() throws IOException {
        int iDoFinal;
        try {
            this.finalized = true;
            BufferedBlockCipher bufferedBlockCipher = this.bufferedBlockCipher;
            if (bufferedBlockCipher != null) {
                iDoFinal = bufferedBlockCipher.doFinal(this.buf, 0);
            } else {
                AEADBlockCipher aEADBlockCipher = this.aeadBlockCipher;
                if (aEADBlockCipher == null) {
                    this.maxBuf = 0;
                    return;
                }
                iDoFinal = aEADBlockCipher.doFinal(this.buf, 0);
            }
            this.maxBuf = iDoFinal;
        } catch (InvalidCipherTextException e) {
            throw new InvalidCipherTextIOException("Error finalising cipher", e);
        } catch (Exception e2) {
            throw new IOException("Error finalising cipher " + e2);
        }
    }

    private int nextChunk() throws IOException {
        if (this.finalized) {
            return -1;
        }
        this.bufOff = 0;
        this.maxBuf = 0;
        while (true) {
            int i = this.maxBuf;
            if (i != 0) {
                return i;
            }
            int iProcessBytes = ((FilterInputStream) this).in.read(this.inBuf);
            if (iProcessBytes == -1) {
                finaliseCipher();
                int i2 = this.maxBuf;
                if (i2 == 0) {
                    return -1;
                }
                return i2;
            }
            try {
                BufferedBlockCipher bufferedBlockCipher = this.bufferedBlockCipher;
                if (bufferedBlockCipher != null) {
                    iProcessBytes = bufferedBlockCipher.processBytes(this.inBuf, 0, iProcessBytes, this.buf, 0);
                } else {
                    AEADBlockCipher aEADBlockCipher = this.aeadBlockCipher;
                    if (aEADBlockCipher != null) {
                        iProcessBytes = aEADBlockCipher.processBytes(this.inBuf, 0, iProcessBytes, this.buf, 0);
                    } else {
                        this.streamCipher.processBytes(this.inBuf, 0, iProcessBytes, this.buf, 0);
                    }
                }
                this.maxBuf = iProcessBytes;
            } catch (Exception e) {
                throw new IOException("Error processing stream " + e);
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return this.maxBuf - this.bufOff;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            ((FilterInputStream) this).in.close();
            this.bufOff = 0;
            this.maxBuf = 0;
        } finally {
            if (!this.finalized) {
                finaliseCipher();
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.bufOff >= this.maxBuf && nextChunk() < 0) {
            return -1;
        }
        byte[] bArr = this.buf;
        int i = this.bufOff;
        this.bufOff = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.bufOff >= this.maxBuf && nextChunk() < 0) {
            return -1;
        }
        int iMin = Math.min(i2, available());
        System.arraycopy(this.buf, this.bufOff, bArr, i, iMin);
        this.bufOff += iMin;
        return iMin;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        if (j <= 0) {
            return 0L;
        }
        int iMin = (int) Math.min(j, available());
        this.bufOff += iMin;
        return iMin;
    }
}
