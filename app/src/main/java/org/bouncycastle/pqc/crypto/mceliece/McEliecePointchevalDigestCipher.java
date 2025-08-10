package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.pqc.crypto.MessageEncryptor;

/* loaded from: classes5.dex */
public class McEliecePointchevalDigestCipher {
    private boolean forEncrypting;
    private final MessageEncryptor mcElieceCCA2Cipher;
    private final Digest messDigest;

    public McEliecePointchevalDigestCipher(MessageEncryptor messageEncryptor, Digest digest) {
        this.mcElieceCCA2Cipher = messageEncryptor;
        this.messDigest = digest;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        this.forEncrypting = z;
        AsymmetricKeyParameter asymmetricKeyParameter = cipherParameters instanceof ParametersWithRandom ? (AsymmetricKeyParameter) ((ParametersWithRandom) cipherParameters).getParameters() : (AsymmetricKeyParameter) cipherParameters;
        if (z && asymmetricKeyParameter.isPrivate()) {
            throw new IllegalArgumentException("Encrypting Requires Public Key.");
        }
        if (!z && !asymmetricKeyParameter.isPrivate()) {
            throw new IllegalArgumentException("Decrypting Requires Private Key.");
        }
        reset();
        this.mcElieceCCA2Cipher.init(z, cipherParameters);
    }

    public byte[] messageDecrypt(byte[] bArr) {
        if (this.forEncrypting) {
            throw new IllegalStateException("McEliecePointchevalDigestCipher not initialised for decrypting.");
        }
        try {
            return this.mcElieceCCA2Cipher.messageDecrypt(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] messageEncrypt() {
        if (!this.forEncrypting) {
            throw new IllegalStateException("McEliecePointchevalDigestCipher not initialised for encrypting.");
        }
        byte[] bArr = new byte[this.messDigest.getDigestSize()];
        this.messDigest.doFinal(bArr, 0);
        try {
            return this.mcElieceCCA2Cipher.messageEncrypt(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void reset() {
        this.messDigest.reset();
    }

    public void update(byte b) {
        this.messDigest.update(b);
    }

    public void update(byte[] bArr, int i, int i2) {
        this.messDigest.update(bArr, i, i2);
    }
}
