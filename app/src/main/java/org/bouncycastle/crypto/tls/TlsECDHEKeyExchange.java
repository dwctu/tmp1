package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.TeeInputStream;

/* loaded from: classes5.dex */
public class TlsECDHEKeyExchange extends TlsECDHKeyExchange {
    public TlsSignerCredentials serverCredentials;

    public TlsECDHEKeyExchange(int i, Vector vector, int[] iArr, short[] sArr, short[] sArr2) {
        super(i, vector, iArr, sArr, sArr2);
        this.serverCredentials = null;
    }

    @Override // org.bouncycastle.crypto.tls.AbstractTlsKeyExchange, org.bouncycastle.crypto.tls.TlsKeyExchange
    public byte[] generateServerKeyExchange() throws IOException {
        int i;
        ECDomainParameters parametersForNamedCurve;
        Digest combinedHash;
        int i2 = 23;
        if (this.namedCurves != null) {
            int i3 = 0;
            while (true) {
                int[] iArr = this.namedCurves;
                if (i3 >= iArr.length) {
                    i = -1;
                    break;
                }
                i = iArr[i3];
                if (TlsECCUtils.isSupportedNamedCurve(i)) {
                    break;
                }
                i3++;
            }
        } else {
            i = 23;
        }
        SignatureAndHashAlgorithm signatureAndHashAlgorithm = null;
        if (i >= 0) {
            parametersForNamedCurve = TlsECCUtils.getParametersForNamedCurve(i);
        } else if (Arrays.contains(this.namedCurves, 65281)) {
            parametersForNamedCurve = TlsECCUtils.getParametersForNamedCurve(i2);
        } else if (Arrays.contains(this.namedCurves, 65282)) {
            i2 = 10;
            parametersForNamedCurve = TlsECCUtils.getParametersForNamedCurve(i2);
        } else {
            parametersForNamedCurve = null;
        }
        if (parametersForNamedCurve == null) {
            throw new TlsFatalAlert((short) 80);
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateECKeyPair = TlsECCUtils.generateECKeyPair(this.context.getSecureRandom(), parametersForNamedCurve);
        this.ecAgreePrivateKey = (ECPrivateKeyParameters) asymmetricCipherKeyPairGenerateECKeyPair.getPrivate();
        DigestInputBuffer digestInputBuffer = new DigestInputBuffer();
        if (i < 0) {
            TlsECCUtils.writeExplicitECParameters(this.clientECPointFormats, parametersForNamedCurve, digestInputBuffer);
        } else {
            TlsECCUtils.writeNamedECParameters(i, digestInputBuffer);
        }
        TlsECCUtils.writeECPoint(this.clientECPointFormats, ((ECPublicKeyParameters) asymmetricCipherKeyPairGenerateECKeyPair.getPublic()).getQ(), digestInputBuffer);
        if (TlsUtils.isTLSv12(this.context)) {
            signatureAndHashAlgorithm = this.serverCredentials.getSignatureAndHashAlgorithm();
            if (signatureAndHashAlgorithm == null) {
                throw new TlsFatalAlert((short) 80);
            }
            combinedHash = TlsUtils.createHash(signatureAndHashAlgorithm.getHash());
        } else {
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

    @Override // org.bouncycastle.crypto.tls.TlsECDHKeyExchange, org.bouncycastle.crypto.tls.TlsKeyExchange
    public void processClientCredentials(TlsCredentials tlsCredentials) throws IOException {
        if (!(tlsCredentials instanceof TlsSignerCredentials)) {
            throw new TlsFatalAlert((short) 80);
        }
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
        TeeInputStream teeInputStream = new TeeInputStream(inputStream, signerInputBuffer);
        ECDomainParameters eCParameters = TlsECCUtils.readECParameters(this.namedCurves, this.clientECPointFormats, teeInputStream);
        byte[] opaque8 = TlsUtils.readOpaque8(teeInputStream);
        DigitallySigned digitallySigned = DigitallySigned.parse(this.context, inputStream);
        Signer signerInitVerifyer = initVerifyer(this.tlsSigner, digitallySigned.getAlgorithm(), securityParameters);
        signerInputBuffer.updateSigner(signerInitVerifyer);
        if (!signerInitVerifyer.verifySignature(digitallySigned.getSignature())) {
            throw new TlsFatalAlert((short) 51);
        }
        this.ecAgreePublicKey = TlsECCUtils.validateECPublicKey(TlsECCUtils.deserializeECPublicKey(this.clientECPointFormats, eCParameters, opaque8));
    }

    @Override // org.bouncycastle.crypto.tls.TlsECDHKeyExchange, org.bouncycastle.crypto.tls.TlsKeyExchange
    public void validateCertificateRequest(CertificateRequest certificateRequest) throws IOException {
        for (short s : certificateRequest.getCertificateTypes()) {
            if (s != 1 && s != 2 && s != 64) {
                throw new TlsFatalAlert((short) 47);
            }
        }
    }
}
