package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.modes.AEADBlockCipher;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;

/* loaded from: classes5.dex */
public class TlsAEADCipher implements TlsCipher {
    public TlsContext context;
    public AEADBlockCipher decryptCipher;
    public byte[] decryptImplicitNonce;
    public AEADBlockCipher encryptCipher;
    public byte[] encryptImplicitNonce;
    public int macSize;
    public int nonce_explicit_length;

    public TlsAEADCipher(TlsContext tlsContext, AEADBlockCipher aEADBlockCipher, AEADBlockCipher aEADBlockCipher2, int i, int i2) throws IOException, IllegalArgumentException {
        if (!TlsUtils.isTLSv12(tlsContext)) {
            throw new TlsFatalAlert((short) 80);
        }
        this.context = tlsContext;
        this.macSize = i2;
        this.nonce_explicit_length = 8;
        int i3 = (i * 2) + 8;
        byte[] bArrCalculateKeyBlock = TlsUtils.calculateKeyBlock(tlsContext, i3);
        KeyParameter keyParameter = new KeyParameter(bArrCalculateKeyBlock, 0, i);
        int i4 = i + 0;
        KeyParameter keyParameter2 = new KeyParameter(bArrCalculateKeyBlock, i4, i);
        int i5 = i4 + i;
        int i6 = i5 + 4;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrCalculateKeyBlock, i5, i6);
        int i7 = i6 + 4;
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArrCalculateKeyBlock, i6, i7);
        if (i7 != i3) {
            throw new TlsFatalAlert((short) 80);
        }
        if (tlsContext.isServer()) {
            this.encryptCipher = aEADBlockCipher2;
            this.decryptCipher = aEADBlockCipher;
            this.encryptImplicitNonce = bArrCopyOfRange2;
            this.decryptImplicitNonce = bArrCopyOfRange;
            keyParameter2 = keyParameter;
            keyParameter = keyParameter2;
        } else {
            this.encryptCipher = aEADBlockCipher;
            this.decryptCipher = aEADBlockCipher2;
            this.encryptImplicitNonce = bArrCopyOfRange;
            this.decryptImplicitNonce = bArrCopyOfRange2;
        }
        byte[] bArr = new byte[this.nonce_explicit_length + 4];
        int i8 = i2 * 8;
        this.encryptCipher.init(true, new AEADParameters(keyParameter, i8, bArr));
        this.decryptCipher.init(false, new AEADParameters(keyParameter2, i8, bArr));
    }

    @Override // org.bouncycastle.crypto.tls.TlsCipher
    public byte[] decodeCiphertext(long j, short s, byte[] bArr, int i, int i2) throws IOException {
        if (getPlaintextLimit(i2) < 0) {
            throw new TlsFatalAlert((short) 50);
        }
        byte[] bArr2 = this.decryptImplicitNonce;
        byte[] bArr3 = new byte[bArr2.length + this.nonce_explicit_length];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, this.decryptImplicitNonce.length, this.nonce_explicit_length);
        int i3 = this.nonce_explicit_length;
        int i4 = i + i3;
        int i5 = i2 - i3;
        int outputSize = this.decryptCipher.getOutputSize(i5);
        byte[] bArr4 = new byte[outputSize];
        try {
            this.decryptCipher.init(false, new AEADParameters(null, this.macSize * 8, bArr3, getAdditionalData(j, s, outputSize)));
            int iProcessBytes = this.decryptCipher.processBytes(bArr, i4, i5, bArr4, 0) + 0;
            if (iProcessBytes + this.decryptCipher.doFinal(bArr4, iProcessBytes) == outputSize) {
                return bArr4;
            }
            throw new TlsFatalAlert((short) 80);
        } catch (Exception unused) {
            throw new TlsFatalAlert((short) 20);
        }
    }

    @Override // org.bouncycastle.crypto.tls.TlsCipher
    public byte[] encodePlaintext(long j, short s, byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = this.encryptImplicitNonce;
        byte[] bArr3 = new byte[bArr2.length + this.nonce_explicit_length];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        TlsUtils.writeUint64(j, bArr3, this.encryptImplicitNonce.length);
        int outputSize = this.encryptCipher.getOutputSize(i2);
        int i3 = this.nonce_explicit_length;
        int i4 = i3 + outputSize;
        byte[] bArr4 = new byte[i4];
        System.arraycopy(bArr3, this.encryptImplicitNonce.length, bArr4, 0, i3);
        int i5 = this.nonce_explicit_length;
        try {
            this.encryptCipher.init(true, new AEADParameters(null, this.macSize * 8, bArr3, getAdditionalData(j, s, i2)));
            int iProcessBytes = i5 + this.encryptCipher.processBytes(bArr, i, i2, bArr4, i5);
            if (iProcessBytes + this.encryptCipher.doFinal(bArr4, iProcessBytes) == i4) {
                return bArr4;
            }
            throw new TlsFatalAlert((short) 80);
        } catch (Exception unused) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    public byte[] getAdditionalData(long j, short s, int i) throws IOException {
        byte[] bArr = new byte[13];
        TlsUtils.writeUint64(j, bArr, 0);
        TlsUtils.writeUint8(s, bArr, 8);
        TlsUtils.writeVersion(this.context.getServerVersion(), bArr, 9);
        TlsUtils.writeUint16(i, bArr, 11);
        return bArr;
    }

    @Override // org.bouncycastle.crypto.tls.TlsCipher
    public int getPlaintextLimit(int i) {
        return (i - this.macSize) - this.nonce_explicit_length;
    }
}
