package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.pqc.crypto.MessageEncryptor;

/* loaded from: classes5.dex */
public class McEliecePKCSDigestCipher {
    private boolean forEncrypting;
    private final MessageEncryptor mcElieceCipher;
    private final Digest messDigest;

    public McEliecePKCSDigestCipher(MessageEncryptor messageEncryptor, Digest digest) {
        this.mcElieceCipher = messageEncryptor;
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
        this.mcElieceCipher.init(z, cipherParameters);
    }

    public byte[] messageDecrypt(byte[] bArr) {
        if (this.forEncrypting) {
            throw new IllegalStateException("McEliecePKCSDigestCipher not initialised for decrypting.");
        }
        try {
            return this.mcElieceCipher.messageDecrypt(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] messageEncrypt() {
        if (!this.forEncrypting) {
            throw new IllegalStateException("McEliecePKCSDigestCipher not initialised for encrypting.");
        }
        byte[] bArr = new byte[this.messDigest.getDigestSize()];
        this.messDigest.doFinal(bArr, 0);
        try {
            return this.mcElieceCipher.messageEncrypt(bArr);
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
