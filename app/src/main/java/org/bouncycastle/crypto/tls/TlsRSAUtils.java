package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.RSABlindedEngine;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSAKeyParameters;

/* loaded from: classes5.dex */
public class TlsRSAUtils {
    public static byte[] generateEncryptedPreMasterSecret(TlsContext tlsContext, RSAKeyParameters rSAKeyParameters, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[48];
        tlsContext.getSecureRandom().nextBytes(bArr);
        TlsUtils.writeVersion(tlsContext.getClientVersion(), bArr, 0);
        PKCS1Encoding pKCS1Encoding = new PKCS1Encoding(new RSABlindedEngine());
        pKCS1Encoding.init(true, new ParametersWithRandom(rSAKeyParameters, tlsContext.getSecureRandom()));
        try {
            byte[] bArrProcessBlock = pKCS1Encoding.processBlock(bArr, 0, 48);
            if (TlsUtils.isSSL(tlsContext)) {
                outputStream.write(bArrProcessBlock);
            } else {
                TlsUtils.writeOpaque16(bArrProcessBlock, outputStream);
            }
            return bArr;
        } catch (InvalidCipherTextException unused) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    public static byte[] safeDecryptPreMasterSecret(TlsContext tlsContext, TlsEncryptionCredentials tlsEncryptionCredentials, byte[] bArr) {
        ProtocolVersion clientVersion = tlsContext.getClientVersion();
        byte[] bArr2 = new byte[48];
        tlsContext.getSecureRandom().nextBytes(bArr2);
        byte[] bArrDecryptPreMasterSecret = TlsUtils.EMPTY_BYTES;
        try {
            bArrDecryptPreMasterSecret = tlsEncryptionCredentials.decryptPreMasterSecret(bArr);
        } catch (Exception unused) {
        }
        if (bArrDecryptPreMasterSecret.length != 48) {
            TlsUtils.writeVersion(clientVersion, bArr2, 0);
            return bArr2;
        }
        TlsUtils.writeVersion(clientVersion, bArrDecryptPreMasterSecret, 0);
        return bArrDecryptPreMasterSecret;
    }
}
