package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;

/* loaded from: classes5.dex */
public class TlsStreamCipher implements TlsCipher {
    private static boolean encryptThenMAC = false;
    public TlsContext context;
    public StreamCipher decryptCipher;
    public StreamCipher encryptCipher;
    public TlsMac readMac;
    public TlsMac writeMac;

    public TlsStreamCipher(TlsContext tlsContext, StreamCipher streamCipher, StreamCipher streamCipher2, Digest digest, Digest digest2, int i) throws IOException, IllegalArgumentException {
        boolean zIsServer = tlsContext.isServer();
        this.context = tlsContext;
        this.encryptCipher = streamCipher;
        this.decryptCipher = streamCipher2;
        int digestSize = (i * 2) + digest.getDigestSize() + digest2.getDigestSize();
        byte[] bArrCalculateKeyBlock = TlsUtils.calculateKeyBlock(tlsContext, digestSize);
        TlsMac tlsMac = new TlsMac(tlsContext, digest, bArrCalculateKeyBlock, 0, digest.getDigestSize());
        int digestSize2 = digest.getDigestSize() + 0;
        TlsMac tlsMac2 = new TlsMac(tlsContext, digest2, bArrCalculateKeyBlock, digestSize2, digest2.getDigestSize());
        int digestSize3 = digestSize2 + digest2.getDigestSize();
        KeyParameter keyParameter = new KeyParameter(bArrCalculateKeyBlock, digestSize3, i);
        int i2 = digestSize3 + i;
        KeyParameter keyParameter2 = new KeyParameter(bArrCalculateKeyBlock, i2, i);
        if (i2 + i != digestSize) {
            throw new TlsFatalAlert((short) 80);
        }
        if (zIsServer) {
            this.writeMac = tlsMac2;
            this.readMac = tlsMac;
            this.encryptCipher = streamCipher2;
            this.decryptCipher = streamCipher;
            keyParameter2 = keyParameter;
            keyParameter = keyParameter2;
        } else {
            this.writeMac = tlsMac;
            this.readMac = tlsMac2;
            this.encryptCipher = streamCipher;
            this.decryptCipher = streamCipher2;
        }
        this.encryptCipher.init(true, keyParameter);
        this.decryptCipher.init(false, keyParameter2);
    }

    private void checkMAC(long j, short s, byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) throws IOException {
        if (!Arrays.constantTimeAreEqual(Arrays.copyOfRange(bArr, i, i2), this.readMac.calculateMac(j, s, bArr2, i3, i4))) {
            throw new TlsFatalAlert((short) 20);
        }
    }

    @Override // org.bouncycastle.crypto.tls.TlsCipher
    public byte[] decodeCiphertext(long j, short s, byte[] bArr, int i, int i2) throws DataLengthException, IOException {
        int size = this.readMac.getSize();
        if (i2 < size) {
            throw new TlsFatalAlert((short) 50);
        }
        int i3 = i2 - size;
        if (!encryptThenMAC) {
            byte[] bArr2 = new byte[i2];
            this.decryptCipher.processBytes(bArr, i, i2, bArr2, 0);
            checkMAC(j, s, bArr2, i3, i2, bArr2, 0, i3);
            return Arrays.copyOfRange(bArr2, 0, i3);
        }
        int i4 = i + i2;
        checkMAC(j, s, bArr, i4 - size, i4, bArr, i, i3);
        byte[] bArr3 = new byte[i3];
        this.decryptCipher.processBytes(bArr, i, i3, bArr3, 0);
        return bArr3;
    }

    @Override // org.bouncycastle.crypto.tls.TlsCipher
    public byte[] encodePlaintext(long j, short s, byte[] bArr, int i, int i2) throws DataLengthException {
        byte[] bArr2 = new byte[this.writeMac.getSize() + i2];
        this.encryptCipher.processBytes(bArr, i, i2, bArr2, 0);
        if (encryptThenMAC) {
            byte[] bArrCalculateMac = this.writeMac.calculateMac(j, s, bArr2, 0, i2);
            System.arraycopy(bArrCalculateMac, 0, bArr2, i2, bArrCalculateMac.length);
        } else {
            byte[] bArrCalculateMac2 = this.writeMac.calculateMac(j, s, bArr, i, i2);
            this.encryptCipher.processBytes(bArrCalculateMac2, 0, bArrCalculateMac2.length, bArr2, i2);
        }
        return bArr2;
    }

    @Override // org.bouncycastle.crypto.tls.TlsCipher
    public int getPlaintextLimit(int i) {
        return i - this.writeMac.getSize();
    }
}
