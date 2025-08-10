package org.bouncycastle.crypto.tls;

import org.bouncycastle.util.Arrays;

/* loaded from: classes5.dex */
public class SecurityParameters {
    public int entity = -1;
    public int cipherSuite = -1;
    public short compressionAlgorithm = -1;
    public int prfAlgorithm = -1;
    public int verifyDataLength = -1;
    public byte[] masterSecret = null;
    public byte[] clientRandom = null;
    public byte[] serverRandom = null;
    public short maxFragmentLength = -1;
    public boolean truncatedHMac = false;

    public void clear() {
        byte[] bArr = this.masterSecret;
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
            this.masterSecret = null;
        }
    }

    public void copySessionParametersFrom(SecurityParameters securityParameters) {
        this.entity = securityParameters.entity;
        this.cipherSuite = securityParameters.cipherSuite;
        this.compressionAlgorithm = securityParameters.compressionAlgorithm;
        this.prfAlgorithm = securityParameters.prfAlgorithm;
        this.verifyDataLength = securityParameters.verifyDataLength;
        this.masterSecret = Arrays.clone(securityParameters.masterSecret);
    }

    public int getCipherSuite() {
        return this.cipherSuite;
    }

    public byte[] getClientRandom() {
        return this.clientRandom;
    }

    public short getCompressionAlgorithm() {
        return this.compressionAlgorithm;
    }

    public int getEntity() {
        return this.entity;
    }

    public byte[] getMasterSecret() {
        return this.masterSecret;
    }

    public int getPrfAlgorithm() {
        return this.prfAlgorithm;
    }

    public byte[] getServerRandom() {
        return this.serverRandom;
    }

    public int getVerifyDataLength() {
        return this.verifyDataLength;
    }
}
