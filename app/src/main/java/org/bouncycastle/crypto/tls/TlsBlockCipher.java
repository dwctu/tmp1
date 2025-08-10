package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.security.SecureRandom;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

/* loaded from: classes5.dex */
public class TlsBlockCipher implements TlsCipher {
    private static boolean encryptThenMAC = false;
    public TlsContext context;
    public BlockCipher decryptCipher;
    public BlockCipher encryptCipher;
    public byte[] randomData = new byte[256];
    public TlsMac readMac;
    public boolean useExplicitIV;
    public TlsMac writeMac;

    public TlsBlockCipher(TlsContext tlsContext, BlockCipher blockCipher, BlockCipher blockCipher2, Digest digest, Digest digest2, int i) throws IOException, IllegalArgumentException {
        byte[] bArrCopyOfRange;
        byte[] bArrCopyOfRange2;
        ParametersWithIV parametersWithIV;
        ParametersWithIV parametersWithIV2;
        this.context = tlsContext;
        tlsContext.getSecureRandom().nextBytes(this.randomData);
        this.useExplicitIV = TlsUtils.isTLSv11(tlsContext);
        int digestSize = (i * 2) + digest.getDigestSize() + digest2.getDigestSize();
        int blockSize = this.useExplicitIV ? digestSize : digestSize + blockCipher.getBlockSize() + blockCipher2.getBlockSize();
        byte[] bArrCalculateKeyBlock = TlsUtils.calculateKeyBlock(tlsContext, blockSize);
        TlsMac tlsMac = new TlsMac(tlsContext, digest, bArrCalculateKeyBlock, 0, digest.getDigestSize());
        int digestSize2 = digest.getDigestSize() + 0;
        TlsMac tlsMac2 = new TlsMac(tlsContext, digest2, bArrCalculateKeyBlock, digestSize2, digest2.getDigestSize());
        int digestSize3 = digestSize2 + digest2.getDigestSize();
        KeyParameter keyParameter = new KeyParameter(bArrCalculateKeyBlock, digestSize3, i);
        int i2 = digestSize3 + i;
        KeyParameter keyParameter2 = new KeyParameter(bArrCalculateKeyBlock, i2, i);
        int blockSize2 = i2 + i;
        if (this.useExplicitIV) {
            bArrCopyOfRange = new byte[blockCipher.getBlockSize()];
            bArrCopyOfRange2 = new byte[blockCipher2.getBlockSize()];
        } else {
            bArrCopyOfRange = Arrays.copyOfRange(bArrCalculateKeyBlock, blockSize2, blockCipher.getBlockSize() + blockSize2);
            int blockSize3 = blockSize2 + blockCipher.getBlockSize();
            bArrCopyOfRange2 = Arrays.copyOfRange(bArrCalculateKeyBlock, blockSize3, blockCipher2.getBlockSize() + blockSize3);
            blockSize2 = blockSize3 + blockCipher2.getBlockSize();
        }
        if (blockSize2 != blockSize) {
            throw new TlsFatalAlert((short) 80);
        }
        if (tlsContext.isServer()) {
            this.writeMac = tlsMac2;
            this.readMac = tlsMac;
            this.encryptCipher = blockCipher2;
            this.decryptCipher = blockCipher;
            parametersWithIV = new ParametersWithIV(keyParameter2, bArrCopyOfRange2);
            parametersWithIV2 = new ParametersWithIV(keyParameter, bArrCopyOfRange);
        } else {
            this.writeMac = tlsMac;
            this.readMac = tlsMac2;
            this.encryptCipher = blockCipher;
            this.decryptCipher = blockCipher2;
            parametersWithIV = new ParametersWithIV(keyParameter, bArrCopyOfRange);
            parametersWithIV2 = new ParametersWithIV(keyParameter2, bArrCopyOfRange2);
        }
        this.encryptCipher.init(true, parametersWithIV);
        this.decryptCipher.init(false, parametersWithIV2);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0031 A[LOOP:0: B:16:0x002d->B:18:0x0031, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int checkPaddingConstantTime(byte[] r5, int r6, int r7, int r8, int r9) {
        /*
            r4 = this;
            int r6 = r6 + r7
            int r0 = r6 + (-1)
            r0 = r5[r0]
            r1 = r0 & 255(0xff, float:3.57E-43)
            int r1 = r1 + 1
            org.bouncycastle.crypto.tls.TlsContext r2 = r4.context
            boolean r2 = org.bouncycastle.crypto.tls.TlsUtils.isSSL(r2)
            r3 = 0
            if (r2 == 0) goto L14
            if (r1 > r8) goto L17
        L14:
            int r9 = r9 + r1
            if (r9 <= r7) goto L1b
        L17:
            r5 = 0
            r8 = 0
        L19:
            r1 = 0
            goto L2b
        L1b:
            int r7 = r6 - r1
            r8 = 0
        L1e:
            int r9 = r7 + 1
            r7 = r5[r7]
            r7 = r7 ^ r0
            r7 = r7 | r8
            byte r8 = (byte) r7
            if (r9 < r6) goto L41
            r5 = r1
            if (r8 == 0) goto L2b
            goto L19
        L2b:
            byte[] r6 = r4.randomData
        L2d:
            r7 = 256(0x100, float:3.59E-43)
            if (r5 >= r7) goto L3a
            int r7 = r5 + 1
            r5 = r6[r5]
            r5 = r5 ^ r0
            r5 = r5 | r8
            byte r8 = (byte) r5
            r5 = r7
            goto L2d
        L3a:
            r5 = r6[r3]
            r5 = r5 ^ r8
            byte r5 = (byte) r5
            r6[r3] = r5
            return r1
        L41:
            r7 = r9
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.tls.TlsBlockCipher.checkPaddingConstantTime(byte[], int, int, int, int):int");
    }

    public int chooseExtraPadBlocks(SecureRandom secureRandom, int i) {
        return Math.min(lowestBitSet(secureRandom.nextInt()), i);
    }

    @Override // org.bouncycastle.crypto.tls.TlsCipher
    public byte[] decodeCiphertext(long j, short s, byte[] bArr, int i, int i2) throws IllegalStateException, DataLengthException, IOException, IllegalArgumentException {
        int i3;
        int i4 = i;
        int blockSize = this.decryptCipher.getBlockSize();
        int size = this.readMac.getSize();
        int iMax = encryptThenMAC ? blockSize + size : Math.max(blockSize, size + 1);
        if (this.useExplicitIV) {
            iMax += blockSize;
        }
        if (i2 < iMax) {
            throw new TlsFatalAlert((short) 50);
        }
        boolean z = encryptThenMAC;
        int i5 = z ? i2 - size : i2;
        if (i5 % blockSize != 0) {
            throw new TlsFatalAlert((short) 21);
        }
        if (z) {
            int i6 = i4 + i2;
            if (!Arrays.constantTimeAreEqual(this.readMac.calculateMac(j, s, bArr, i, i2 - size), Arrays.copyOfRange(bArr, i6 - size, i6))) {
                throw new TlsFatalAlert((short) 20);
            }
        }
        if (this.useExplicitIV) {
            this.decryptCipher.init(false, new ParametersWithIV(null, bArr, i4, blockSize));
            i4 += blockSize;
            i5 -= blockSize;
        }
        int i7 = i4;
        int i8 = i5;
        for (int i9 = 0; i9 < i8; i9 += blockSize) {
            int i10 = i7 + i9;
            this.decryptCipher.processBlock(bArr, i10, bArr, i10);
        }
        int iCheckPaddingConstantTime = checkPaddingConstantTime(bArr, i7, i8, blockSize, encryptThenMAC ? 0 : size);
        int i11 = i8 - iCheckPaddingConstantTime;
        if (encryptThenMAC) {
            i3 = i7;
        } else {
            i11 -= size;
            int i12 = i7 + i11;
            i3 = i7;
            if ((!Arrays.constantTimeAreEqual(this.readMac.calculateMacConstantTime(j, s, bArr, i7, i11, i8 - size, this.randomData), Arrays.copyOfRange(bArr, i12, i12 + size))) || iCheckPaddingConstantTime == 0) {
                throw new TlsFatalAlert((short) 20);
            }
        }
        return Arrays.copyOfRange(bArr, i3, i3 + i11);
    }

    @Override // org.bouncycastle.crypto.tls.TlsCipher
    public byte[] encodePlaintext(long j, short s, byte[] bArr, int i, int i2) throws IllegalStateException, DataLengthException, IllegalArgumentException {
        byte[] bArr2;
        int i3;
        int i4;
        int blockSize = this.encryptCipher.getBlockSize();
        int size = this.writeMac.getSize();
        ProtocolVersion serverVersion = this.context.getServerVersion();
        int iChooseExtraPadBlocks = (blockSize - 1) - ((!encryptThenMAC ? i2 + size : i2) % blockSize);
        if (!serverVersion.isDTLS() && !serverVersion.isSSL()) {
            iChooseExtraPadBlocks += chooseExtraPadBlocks(this.context.getSecureRandom(), (255 - iChooseExtraPadBlocks) / blockSize) * blockSize;
        }
        int i5 = iChooseExtraPadBlocks;
        int i6 = size + i2 + i5 + 1;
        boolean z = this.useExplicitIV;
        if (z) {
            i6 += blockSize;
        }
        byte[] bArr3 = new byte[i6];
        if (z) {
            byte[] bArr4 = new byte[blockSize];
            this.context.getSecureRandom().nextBytes(bArr4);
            this.encryptCipher.init(true, new ParametersWithIV(null, bArr4));
            System.arraycopy(bArr4, 0, bArr3, 0, blockSize);
            bArr2 = bArr;
            i3 = i;
            i4 = blockSize + 0;
        } else {
            bArr2 = bArr;
            i3 = i;
            i4 = 0;
        }
        System.arraycopy(bArr2, i3, bArr3, i4, i2);
        int length = i4 + i2;
        if (!encryptThenMAC) {
            byte[] bArrCalculateMac = this.writeMac.calculateMac(j, s, bArr, i, i2);
            System.arraycopy(bArrCalculateMac, 0, bArr3, length, bArrCalculateMac.length);
            length += bArrCalculateMac.length;
        }
        int i7 = length;
        int i8 = 0;
        while (i8 <= i5) {
            bArr3[i7] = (byte) i5;
            i8++;
            i7++;
        }
        while (i4 < i7) {
            this.encryptCipher.processBlock(bArr3, i4, bArr3, i4);
            i4 += blockSize;
        }
        if (!encryptThenMAC) {
            return bArr3;
        }
        byte[] bArrCalculateMac2 = this.writeMac.calculateMac(j, s, bArr3, 0, i7);
        System.arraycopy(bArrCalculateMac2, 0, bArr3, i7, bArrCalculateMac2.length);
        int length2 = bArrCalculateMac2.length;
        return bArr3;
    }

    @Override // org.bouncycastle.crypto.tls.TlsCipher
    public int getPlaintextLimit(int i) {
        int i2;
        int blockSize = this.encryptCipher.getBlockSize();
        int size = this.writeMac.getSize();
        if (this.useExplicitIV) {
            i -= blockSize;
        }
        if (encryptThenMAC) {
            int i3 = i - size;
            i2 = i3 - (i3 % blockSize);
        } else {
            i2 = (i - (i % blockSize)) - size;
        }
        return i2 - 1;
    }

    public TlsMac getReadMac() {
        return this.readMac;
    }

    public TlsMac getWriteMac() {
        return this.writeMac;
    }

    public int lowestBitSet(int i) {
        if (i == 0) {
            return 32;
        }
        int i2 = 0;
        while ((i & 1) == 0) {
            i2++;
            i >>= 1;
        }
        return i2;
    }
}
