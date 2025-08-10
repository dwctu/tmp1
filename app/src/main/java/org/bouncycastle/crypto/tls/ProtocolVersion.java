package org.bouncycastle.crypto.tls;

import com.google.firebase.database.core.ValidationPath;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class ProtocolVersion {
    private String name;
    private int version;
    public static final ProtocolVersion SSLv3 = new ProtocolVersion(ValidationPath.MAX_PATH_LENGTH_BYTES, "SSL 3.0");
    public static final ProtocolVersion TLSv10 = new ProtocolVersion(769, "TLS 1.0");
    public static final ProtocolVersion TLSv11 = new ProtocolVersion(770, "TLS 1.1");
    public static final ProtocolVersion TLSv12 = new ProtocolVersion(771, "TLS 1.2");
    public static final ProtocolVersion DTLSv10 = new ProtocolVersion(65279, "DTLS 1.0");
    public static final ProtocolVersion DTLSv12 = new ProtocolVersion(65277, "DTLS 1.2");

    private ProtocolVersion(int i, String str) {
        this.version = i & 65535;
        this.name = str;
    }

    public static ProtocolVersion get(int i, int i2) throws IOException {
        if (i != 3) {
            if (i == 254) {
            }
            throw new TlsFatalAlert((short) 47);
        }
        if (i2 == 0) {
            return SSLv3;
        }
        if (i2 == 1) {
            return TLSv10;
        }
        if (i2 == 2) {
            return TLSv11;
        }
        if (i2 == 3) {
            return TLSv12;
        }
        if (i2 == 253) {
            return DTLSv12;
        }
        if (i2 == 255) {
            return DTLSv10;
        }
        throw new TlsFatalAlert((short) 47);
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public ProtocolVersion getEquivalentTLSVersion() {
        return !isDTLS() ? this : this == DTLSv10 ? TLSv11 : TLSv12;
    }

    public int getFullVersion() {
        return this.version;
    }

    public int getMajorVersion() {
        return this.version >> 8;
    }

    public int getMinorVersion() {
        return this.version & 255;
    }

    public int hashCode() {
        return this.version;
    }

    public boolean isDTLS() {
        return getMajorVersion() == 254;
    }

    public boolean isEqualOrEarlierVersionOf(ProtocolVersion protocolVersion) {
        if (getMajorVersion() != protocolVersion.getMajorVersion()) {
            return false;
        }
        int minorVersion = protocolVersion.getMinorVersion() - getMinorVersion();
        if (isDTLS()) {
            if (minorVersion > 0) {
                return false;
            }
        } else if (minorVersion < 0) {
            return false;
        }
        return true;
    }

    public boolean isLaterVersionOf(ProtocolVersion protocolVersion) {
        if (getMajorVersion() != protocolVersion.getMajorVersion()) {
            return false;
        }
        int minorVersion = protocolVersion.getMinorVersion() - getMinorVersion();
        if (isDTLS()) {
            if (minorVersion <= 0) {
                return false;
            }
        } else if (minorVersion >= 0) {
            return false;
        }
        return true;
    }

    public boolean isSSL() {
        return this == SSLv3;
    }

    public String toString() {
        return this.name;
    }
}
