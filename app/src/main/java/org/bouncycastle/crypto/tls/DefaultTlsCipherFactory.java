package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.engines.AESFastEngine;
import org.bouncycastle.crypto.engines.CamelliaEngine;
import org.bouncycastle.crypto.engines.DESedeEngine;
import org.bouncycastle.crypto.engines.RC4Engine;
import org.bouncycastle.crypto.engines.SEEDEngine;
import org.bouncycastle.crypto.engines.Salsa20Engine;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.modes.AEADBlockCipher;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.CCMBlockCipher;
import org.bouncycastle.crypto.modes.GCMBlockCipher;

/* loaded from: classes5.dex */
public class DefaultTlsCipherFactory extends AbstractTlsCipherFactory {
    public AEADBlockCipher createAEADBlockCipher_AES_CCM() {
        return new CCMBlockCipher(new AESFastEngine());
    }

    public AEADBlockCipher createAEADBlockCipher_AES_GCM() {
        return new GCMBlockCipher(new AESFastEngine());
    }

    public BlockCipher createAESBlockCipher() {
        return new CBCBlockCipher(new AESFastEngine());
    }

    public TlsBlockCipher createAESCipher(TlsContext tlsContext, int i, int i2) throws IOException {
        return new TlsBlockCipher(tlsContext, createAESBlockCipher(), createAESBlockCipher(), createHMACDigest(i2), createHMACDigest(i2), i);
    }

    public BlockCipher createCamelliaBlockCipher() {
        return new CBCBlockCipher(new CamelliaEngine());
    }

    public TlsBlockCipher createCamelliaCipher(TlsContext tlsContext, int i, int i2) throws IOException {
        return new TlsBlockCipher(tlsContext, createCamelliaBlockCipher(), createCamelliaBlockCipher(), createHMACDigest(i2), createHMACDigest(i2), i);
    }

    @Override // org.bouncycastle.crypto.tls.AbstractTlsCipherFactory, org.bouncycastle.crypto.tls.TlsCipherFactory
    public TlsCipher createCipher(TlsContext tlsContext, int i, int i2) throws IOException {
        int i3;
        if (i == 0) {
            return createNullCipher(tlsContext, i2);
        }
        if (i == 2) {
            return createRC4Cipher(tlsContext, 16, i2);
        }
        if (i == 100) {
            i3 = 12;
        } else {
            if (i != 101) {
                switch (i) {
                    case 7:
                        return createDESedeCipher(tlsContext, i2);
                    case 8:
                        return createAESCipher(tlsContext, 16, i2);
                    case 9:
                        return createAESCipher(tlsContext, 32, i2);
                    case 10:
                        return createCipher_AES_GCM(tlsContext, 16, 16);
                    case 11:
                        return createCipher_AES_GCM(tlsContext, 32, 16);
                    case 12:
                        return createCamelliaCipher(tlsContext, 16, i2);
                    case 13:
                        return createCamelliaCipher(tlsContext, 32, i2);
                    case 14:
                        return createSEEDCipher(tlsContext, i2);
                    case 15:
                        return createCipher_AES_CCM(tlsContext, 16, 16);
                    case 16:
                        return createCipher_AES_CCM(tlsContext, 16, 8);
                    case 17:
                        return createCipher_AES_CCM(tlsContext, 32, 16);
                    case 18:
                        return createCipher_AES_CCM(tlsContext, 32, 8);
                    default:
                        throw new TlsFatalAlert((short) 80);
                }
            }
            i3 = 20;
        }
        return createSalsa20Cipher(tlsContext, i3, 32, i2);
    }

    public TlsAEADCipher createCipher_AES_CCM(TlsContext tlsContext, int i, int i2) throws IOException {
        return new TlsAEADCipher(tlsContext, createAEADBlockCipher_AES_CCM(), createAEADBlockCipher_AES_CCM(), i, i2);
    }

    public TlsAEADCipher createCipher_AES_GCM(TlsContext tlsContext, int i, int i2) throws IOException {
        return new TlsAEADCipher(tlsContext, createAEADBlockCipher_AES_GCM(), createAEADBlockCipher_AES_GCM(), i, i2);
    }

    public BlockCipher createDESedeBlockCipher() {
        return new CBCBlockCipher(new DESedeEngine());
    }

    public TlsBlockCipher createDESedeCipher(TlsContext tlsContext, int i) throws IOException {
        return new TlsBlockCipher(tlsContext, createDESedeBlockCipher(), createDESedeBlockCipher(), createHMACDigest(i), createHMACDigest(i), 24);
    }

    public Digest createHMACDigest(int i) throws IOException {
        if (i == 0) {
            return null;
        }
        if (i == 1) {
            return new MD5Digest();
        }
        if (i == 2) {
            return new SHA1Digest();
        }
        if (i == 3) {
            return new SHA256Digest();
        }
        if (i == 4) {
            return new SHA384Digest();
        }
        if (i == 5) {
            return new SHA512Digest();
        }
        throw new TlsFatalAlert((short) 80);
    }

    public Mac createMac(int i) throws IOException {
        return new HMac(createHMACDigest(i));
    }

    public TlsNullCipher createNullCipher(TlsContext tlsContext, int i) throws IOException {
        return new TlsNullCipher(tlsContext, createHMACDigest(i), createHMACDigest(i));
    }

    public TlsStreamCipher createRC4Cipher(TlsContext tlsContext, int i, int i2) throws IOException {
        return new TlsStreamCipher(tlsContext, createRC4StreamCipher(), createRC4StreamCipher(), createHMACDigest(i2), createHMACDigest(i2), i);
    }

    public StreamCipher createRC4StreamCipher() {
        return new RC4Engine();
    }

    public BlockCipher createSEEDBlockCipher() {
        return new CBCBlockCipher(new SEEDEngine());
    }

    public TlsBlockCipher createSEEDCipher(TlsContext tlsContext, int i) throws IOException {
        return new TlsBlockCipher(tlsContext, createSEEDBlockCipher(), createSEEDBlockCipher(), createHMACDigest(i), createHMACDigest(i), 16);
    }

    public TlsStreamCipher createSalsa20Cipher(TlsContext tlsContext, int i, int i2, int i3) throws IOException {
        return new TlsStreamCipher(tlsContext, createSalsa20StreamCipher(i), createSalsa20StreamCipher(i), createHMACDigest(i3), createHMACDigest(i3), i2);
    }

    public StreamCipher createSalsa20StreamCipher(int i) {
        return new Salsa20Engine(i);
    }
}
