package org.bouncycastle.crypto.tls;

import java.security.SecureRandom;

/* loaded from: classes5.dex */
public abstract class AbstractTlsContext implements TlsContext {
    private SecureRandom secureRandom;
    private SecurityParameters securityParameters;
    private ProtocolVersion clientVersion = null;
    private ProtocolVersion serverVersion = null;
    private TlsSession session = null;
    private Object userObject = null;

    public AbstractTlsContext(SecureRandom secureRandom, SecurityParameters securityParameters) {
        this.secureRandom = secureRandom;
        this.securityParameters = securityParameters;
    }

    @Override // org.bouncycastle.crypto.tls.TlsContext
    public byte[] exportKeyingMaterial(String str, byte[] bArr, int i) {
        if (bArr != null && !TlsUtils.isValidUint16(bArr.length)) {
            throw new IllegalArgumentException("'context_value' must have length less than 2^16 (or be null)");
        }
        SecurityParameters securityParameters = getSecurityParameters();
        byte[] clientRandom = securityParameters.getClientRandom();
        byte[] serverRandom = securityParameters.getServerRandom();
        int length = clientRandom.length + serverRandom.length;
        if (bArr != null) {
            length += bArr.length + 2;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(clientRandom, 0, bArr2, 0, clientRandom.length);
        int length2 = clientRandom.length + 0;
        System.arraycopy(serverRandom, 0, bArr2, length2, serverRandom.length);
        int length3 = length2 + serverRandom.length;
        if (bArr != null) {
            TlsUtils.writeUint16(bArr.length, bArr2, length3);
            int i2 = length3 + 2;
            System.arraycopy(bArr, 0, bArr2, i2, bArr.length);
            length3 = i2 + bArr.length;
        }
        if (length3 == length) {
            return TlsUtils.PRF(this, securityParameters.getMasterSecret(), str, bArr2, i);
        }
        throw new IllegalStateException("error in calculation of seed for export");
    }

    @Override // org.bouncycastle.crypto.tls.TlsContext
    public ProtocolVersion getClientVersion() {
        return this.clientVersion;
    }

    @Override // org.bouncycastle.crypto.tls.TlsContext
    public TlsSession getResumableSession() {
        return this.session;
    }

    @Override // org.bouncycastle.crypto.tls.TlsContext
    public SecureRandom getSecureRandom() {
        return this.secureRandom;
    }

    @Override // org.bouncycastle.crypto.tls.TlsContext
    public SecurityParameters getSecurityParameters() {
        return this.securityParameters;
    }

    @Override // org.bouncycastle.crypto.tls.TlsContext
    public ProtocolVersion getServerVersion() {
        return this.serverVersion;
    }

    @Override // org.bouncycastle.crypto.tls.TlsContext
    public Object getUserObject() {
        return this.userObject;
    }

    public void setClientVersion(ProtocolVersion protocolVersion) {
        this.clientVersion = protocolVersion;
    }

    public void setResumableSession(TlsSession tlsSession) {
        this.session = tlsSession;
    }

    public void setServerVersion(ProtocolVersion protocolVersion) {
        this.serverVersion = protocolVersion;
    }

    @Override // org.bouncycastle.crypto.tls.TlsContext
    public void setUserObject(Object obj) {
        this.userObject = obj;
    }
}
