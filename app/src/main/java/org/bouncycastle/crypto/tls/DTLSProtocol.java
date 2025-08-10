package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.util.Arrays;

/* loaded from: classes5.dex */
public abstract class DTLSProtocol {
    public final SecureRandom secureRandom;

    public DTLSProtocol(SecureRandom secureRandom) {
        if (secureRandom == null) {
            throw new IllegalArgumentException("'secureRandom' cannot be null");
        }
        this.secureRandom = secureRandom;
    }

    public static short evaluateMaxFragmentLengthExtension(Hashtable hashtable, Hashtable hashtable2, short s) throws IOException {
        short maxFragmentLengthExtension = TlsExtensionsUtils.getMaxFragmentLengthExtension(hashtable2);
        if (maxFragmentLengthExtension < 0 || maxFragmentLengthExtension == TlsExtensionsUtils.getMaxFragmentLengthExtension(hashtable)) {
            return maxFragmentLengthExtension;
        }
        throw new TlsFatalAlert(s);
    }

    public static byte[] generateCertificate(Certificate certificate) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        certificate.encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] generateSupplementalData(Vector vector) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        TlsProtocol.writeSupplementalData(byteArrayOutputStream, vector);
        return byteArrayOutputStream.toByteArray();
    }

    public static void validateSelectedCipherSuite(int i, short s) throws IOException {
        if (i != 3 && i != 4 && i != 5 && i != 23 && i != 24) {
            switch (i) {
                case 138:
                case 142:
                case CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA /* 146 */:
                case CipherSuite.TLS_ECDH_ECDSA_WITH_RC4_128_SHA /* 49154 */:
                case CipherSuite.TLS_ECDHE_ECDSA_WITH_RC4_128_SHA /* 49159 */:
                case CipherSuite.TLS_ECDH_RSA_WITH_RC4_128_SHA /* 49164 */:
                case CipherSuite.TLS_ECDHE_RSA_WITH_RC4_128_SHA /* 49169 */:
                case CipherSuite.TLS_ECDH_anon_WITH_RC4_128_SHA /* 49174 */:
                    break;
                default:
                    return;
            }
        }
        throw new IllegalStateException("RC4 MUST NOT be used with DTLS");
    }

    public void processFinished(byte[] bArr, byte[] bArr2) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        byte[] fully = TlsUtils.readFully(bArr2.length, byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        if (!Arrays.constantTimeAreEqual(bArr2, fully)) {
            throw new TlsFatalAlert((short) 40);
        }
    }
}
