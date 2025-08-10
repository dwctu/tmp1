package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.util.io.TeeInputStream;

/* loaded from: classes5.dex */
public class TlsDHEKeyExchange extends TlsDHKeyExchange {
    public TlsSignerCredentials serverCredentials;

    public TlsDHEKeyExchange(int i, Vector vector, DHParameters dHParameters) {
        super(i, vector, dHParameters);
        this.serverCredentials = null;
    }

    @Override // org.bouncycastle.crypto.tls.AbstractTlsKeyExchange, org.bouncycastle.crypto.tls.TlsKeyExchange
    public byte[] generateServerKeyExchange() throws IOException {
        SignatureAndHashAlgorithm signatureAndHashAlgorithm;
        Digest combinedHash;
        if (this.dhParameters == null) {
            throw new TlsFatalAlert((short) 80);
        }
        DigestInputBuffer digestInputBuffer = new DigestInputBuffer();
        this.dhAgreeServerPrivateKey = TlsDHUtils.generateEphemeralServerKeyExchange(this.context.getSecureRandom(), this.dhParameters, digestInputBuffer);
        if (TlsUtils.isTLSv12(this.context)) {
            signatureAndHashAlgorithm = this.serverCredentials.getSignatureAndHashAlgorithm();
            if (signatureAndHashAlgorithm == null) {
                throw new TlsFatalAlert((short) 80);
            }
            combinedHash = TlsUtils.createHash(signatureAndHashAlgorithm.getHash());
        } else {
            signatureAndHashAlgorithm = null;
            combinedHash = new CombinedHash();
        }
        SecurityParameters securityParameters = this.context.getSecurityParameters();
        byte[] bArr = securityParameters.clientRandom;
        combinedHash.update(bArr, 0, bArr.length);
        byte[] bArr2 = securityParameters.serverRandom;
        combinedHash.update(bArr2, 0, bArr2.length);
        digestInputBuffer.updateDigest(combinedHash);
        byte[] bArr3 = new byte[combinedHash.getDigestSize()];
        combinedHash.doFinal(bArr3, 0);
        new DigitallySigned(signatureAndHashAlgorithm, this.serverCredentials.generateCertificateSignature(bArr3)).encode(digestInputBuffer);
        return digestInputBuffer.toByteArray();
    }

    public Signer initVerifyer(TlsSigner tlsSigner, SignatureAndHashAlgorithm signatureAndHashAlgorithm, SecurityParameters securityParameters) {
        Signer signerCreateVerifyer = tlsSigner.createVerifyer(signatureAndHashAlgorithm, this.serverPublicKey);
        byte[] bArr = securityParameters.clientRandom;
        signerCreateVerifyer.update(bArr, 0, bArr.length);
        byte[] bArr2 = securityParameters.serverRandom;
        signerCreateVerifyer.update(bArr2, 0, bArr2.length);
        return signerCreateVerifyer;
    }

    @Override // org.bouncycastle.crypto.tls.AbstractTlsKeyExchange, org.bouncycastle.crypto.tls.TlsKeyExchange
    public void processServerCredentials(TlsCredentials tlsCredentials) throws IOException {
        if (!(tlsCredentials instanceof TlsSignerCredentials)) {
            throw new TlsFatalAlert((short) 80);
        }
        processServerCertificate(tlsCredentials.getCertificate());
        this.serverCredentials = (TlsSignerCredentials) tlsCredentials;
    }

    @Override // org.bouncycastle.crypto.tls.AbstractTlsKeyExchange, org.bouncycastle.crypto.tls.TlsKeyExchange
    public void processServerKeyExchange(InputStream inputStream) throws IOException {
        SecurityParameters securityParameters = this.context.getSecurityParameters();
        SignerInputBuffer signerInputBuffer = new SignerInputBuffer();
        ServerDHParams serverDHParams = ServerDHParams.parse(new TeeInputStream(inputStream, signerInputBuffer));
        DigitallySigned digitallySigned = DigitallySigned.parse(this.context, inputStream);
        Signer signerInitVerifyer = initVerifyer(this.tlsSigner, digitallySigned.getAlgorithm(), securityParameters);
        signerInputBuffer.updateSigner(signerInitVerifyer);
        if (!signerInitVerifyer.verifySignature(digitallySigned.getSignature())) {
            throw new TlsFatalAlert((short) 51);
        }
        this.dhAgreeServerPublicKey = TlsDHUtils.validateDHPublicKey(serverDHParams.getPublicKey());
    }
}
