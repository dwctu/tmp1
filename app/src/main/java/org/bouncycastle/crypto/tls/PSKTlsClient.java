package org.bouncycastle.crypto.tls;

/* loaded from: classes5.dex */
public abstract class PSKTlsClient extends AbstractTlsClient {
    public TlsPSKIdentity pskIdentity;

    public PSKTlsClient(TlsCipherFactory tlsCipherFactory, TlsPSKIdentity tlsPSKIdentity) {
        super(tlsCipherFactory);
        this.pskIdentity = tlsPSKIdentity;
    }

    public PSKTlsClient(TlsPSKIdentity tlsPSKIdentity) {
        this.pskIdentity = tlsPSKIdentity;
    }

    public TlsKeyExchange createPSKKeyExchange(int i) {
        return new TlsPSKKeyExchange(i, this.supportedSignatureAlgorithms, this.pskIdentity, null, this.namedCurves, this.clientECPointFormats, this.serverECPointFormats);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d1  */
    @Override // org.bouncycastle.crypto.tls.TlsPeer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.bouncycastle.crypto.tls.TlsCipher getCipher() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.tls.PSKTlsClient.getCipher():org.bouncycastle.crypto.tls.TlsCipher");
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public int[] getCipherSuites() {
        return new int[]{CipherSuite.TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA256, CipherSuite.TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA, 182, 148};
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    @Override // org.bouncycastle.crypto.tls.TlsClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.bouncycastle.crypto.tls.TlsKeyExchange getKeyExchange() throws java.io.IOException {
        /*
            r2 = this;
            int r0 = r2.selectedCipherSuite
            switch(r0) {
                case 44: goto L2c;
                case 45: goto L29;
                case 46: goto L26;
                default: goto L5;
            }
        L5:
            switch(r0) {
                case 138: goto L2c;
                case 139: goto L2c;
                case 140: goto L2c;
                case 141: goto L2c;
                case 142: goto L29;
                case 143: goto L29;
                case 144: goto L29;
                case 145: goto L29;
                case 146: goto L26;
                case 147: goto L26;
                case 148: goto L26;
                case 149: goto L26;
                default: goto L8;
            }
        L8:
            switch(r0) {
                case 168: goto L2c;
                case 169: goto L2c;
                case 170: goto L29;
                case 171: goto L29;
                case 172: goto L26;
                case 173: goto L26;
                case 174: goto L2c;
                case 175: goto L2c;
                case 176: goto L2c;
                case 177: goto L2c;
                case 178: goto L29;
                case 179: goto L29;
                case 180: goto L29;
                case 181: goto L29;
                case 182: goto L26;
                case 183: goto L26;
                case 184: goto L26;
                case 185: goto L26;
                default: goto Lb;
            }
        Lb:
            switch(r0) {
                case 49203: goto L1f;
                case 49204: goto L1f;
                case 49205: goto L1f;
                case 49206: goto L1f;
                case 49207: goto L1f;
                case 49208: goto L1f;
                case 49209: goto L1f;
                case 49210: goto L1f;
                case 49211: goto L1f;
                default: goto Le;
            }
        Le:
            switch(r0) {
                case 49316: goto L2c;
                case 49317: goto L2c;
                case 49318: goto L29;
                case 49319: goto L29;
                case 49320: goto L2c;
                case 49321: goto L2c;
                case 49322: goto L29;
                case 49323: goto L29;
                default: goto L11;
            }
        L11:
            switch(r0) {
                case 65288: goto L2c;
                case 65289: goto L2c;
                case 65290: goto L29;
                case 65291: goto L29;
                case 65292: goto L26;
                case 65293: goto L26;
                case 65294: goto L1f;
                case 65295: goto L1f;
                default: goto L14;
            }
        L14:
            switch(r0) {
                case 65304: goto L2c;
                case 65305: goto L2c;
                case 65306: goto L29;
                case 65307: goto L29;
                case 65308: goto L26;
                case 65309: goto L26;
                case 65310: goto L1f;
                case 65311: goto L1f;
                default: goto L17;
            }
        L17:
            org.bouncycastle.crypto.tls.TlsFatalAlert r0 = new org.bouncycastle.crypto.tls.TlsFatalAlert
            r1 = 80
            r0.<init>(r1)
            throw r0
        L1f:
            r0 = 24
        L21:
            org.bouncycastle.crypto.tls.TlsKeyExchange r0 = r2.createPSKKeyExchange(r0)
            return r0
        L26:
            r0 = 15
            goto L21
        L29:
            r0 = 14
            goto L21
        L2c:
            r0 = 13
            goto L21
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.tls.PSKTlsClient.getKeyExchange():org.bouncycastle.crypto.tls.TlsKeyExchange");
    }
}
