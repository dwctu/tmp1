package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.util.Hashtable;
import org.bouncycastle.util.Arrays;

/* loaded from: classes5.dex */
public abstract class SRPTlsClient extends AbstractTlsClient {
    public static final Integer EXT_SRP = TlsSRPUtils.EXT_SRP;
    public byte[] identity;
    public byte[] password;

    public SRPTlsClient(TlsCipherFactory tlsCipherFactory, byte[] bArr, byte[] bArr2) {
        super(tlsCipherFactory);
        this.identity = Arrays.clone(bArr);
        this.password = Arrays.clone(bArr2);
    }

    public SRPTlsClient(byte[] bArr, byte[] bArr2) {
        this.identity = Arrays.clone(bArr);
        this.password = Arrays.clone(bArr2);
    }

    public TlsKeyExchange createSRPKeyExchange(int i) {
        return new TlsSRPKeyExchange(i, this.supportedSignatureAlgorithms, this.identity, this.password);
    }

    @Override // org.bouncycastle.crypto.tls.TlsPeer
    public TlsCipher getCipher() throws IOException {
        TlsCipherFactory tlsCipherFactory;
        TlsClientContext tlsClientContext;
        int i;
        switch (this.selectedCipherSuite) {
            case CipherSuite.TLS_SRP_SHA_WITH_3DES_EDE_CBC_SHA /* 49178 */:
            case CipherSuite.TLS_SRP_SHA_RSA_WITH_3DES_EDE_CBC_SHA /* 49179 */:
            case CipherSuite.TLS_SRP_SHA_DSS_WITH_3DES_EDE_CBC_SHA /* 49180 */:
                tlsCipherFactory = this.cipherFactory;
                tlsClientContext = this.context;
                i = 7;
                break;
            case CipherSuite.TLS_SRP_SHA_WITH_AES_128_CBC_SHA /* 49181 */:
            case CipherSuite.TLS_SRP_SHA_RSA_WITH_AES_128_CBC_SHA /* 49182 */:
            case CipherSuite.TLS_SRP_SHA_DSS_WITH_AES_128_CBC_SHA /* 49183 */:
                tlsCipherFactory = this.cipherFactory;
                tlsClientContext = this.context;
                i = 8;
                break;
            case CipherSuite.TLS_SRP_SHA_WITH_AES_256_CBC_SHA /* 49184 */:
            case CipherSuite.TLS_SRP_SHA_RSA_WITH_AES_256_CBC_SHA /* 49185 */:
            case CipherSuite.TLS_SRP_SHA_DSS_WITH_AES_256_CBC_SHA /* 49186 */:
                tlsCipherFactory = this.cipherFactory;
                tlsClientContext = this.context;
                i = 9;
                break;
            default:
                throw new TlsFatalAlert((short) 80);
        }
        return tlsCipherFactory.createCipher(tlsClientContext, i, 2);
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public int[] getCipherSuites() {
        return new int[]{CipherSuite.TLS_SRP_SHA_RSA_WITH_AES_128_CBC_SHA};
    }

    @Override // org.bouncycastle.crypto.tls.AbstractTlsClient, org.bouncycastle.crypto.tls.TlsClient
    public Hashtable getClientExtensions() throws IOException {
        Hashtable hashtableEnsureExtensionsInitialised = TlsExtensionsUtils.ensureExtensionsInitialised(super.getClientExtensions());
        TlsSRPUtils.addSRPExtension(hashtableEnsureExtensionsInitialised, this.identity);
        return hashtableEnsureExtensionsInitialised;
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public TlsKeyExchange getKeyExchange() throws IOException {
        int i;
        switch (this.selectedCipherSuite) {
            case CipherSuite.TLS_SRP_SHA_WITH_3DES_EDE_CBC_SHA /* 49178 */:
            case CipherSuite.TLS_SRP_SHA_WITH_AES_128_CBC_SHA /* 49181 */:
            case CipherSuite.TLS_SRP_SHA_WITH_AES_256_CBC_SHA /* 49184 */:
                i = 21;
                break;
            case CipherSuite.TLS_SRP_SHA_RSA_WITH_3DES_EDE_CBC_SHA /* 49179 */:
            case CipherSuite.TLS_SRP_SHA_RSA_WITH_AES_128_CBC_SHA /* 49182 */:
            case CipherSuite.TLS_SRP_SHA_RSA_WITH_AES_256_CBC_SHA /* 49185 */:
                i = 23;
                break;
            case CipherSuite.TLS_SRP_SHA_DSS_WITH_3DES_EDE_CBC_SHA /* 49180 */:
            case CipherSuite.TLS_SRP_SHA_DSS_WITH_AES_128_CBC_SHA /* 49183 */:
            case CipherSuite.TLS_SRP_SHA_DSS_WITH_AES_256_CBC_SHA /* 49186 */:
                i = 22;
                break;
            default:
                throw new TlsFatalAlert((short) 80);
        }
        return createSRPKeyExchange(i);
    }

    @Override // org.bouncycastle.crypto.tls.AbstractTlsClient, org.bouncycastle.crypto.tls.TlsClient
    public void processServerExtensions(Hashtable hashtable) throws IOException {
        TlsUtils.hasExpectedEmptyExtensionData(hashtable, TlsSRPUtils.EXT_SRP, (short) 47);
    }
}
