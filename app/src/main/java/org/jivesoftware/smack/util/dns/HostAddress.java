package org.jivesoftware.smack.util.dns;

import org.aspectj.runtime.reflect.SignatureImpl;
import org.jivesoftware.smack.util.Objects;

/* loaded from: classes5.dex */
public class HostAddress {
    private Exception exception;
    private final String fqdn;
    private final int port;

    public HostAddress(String str) {
        this(str, 5222);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HostAddress)) {
            return false;
        }
        HostAddress hostAddress = (HostAddress) obj;
        return this.fqdn.equals(hostAddress.fqdn) && this.port == hostAddress.port;
    }

    public String getErrorMessage() {
        if (this.exception == null) {
            return "No error logged";
        }
        return "'" + toString() + "' failed because " + this.exception.toString();
    }

    public Exception getException() {
        return this.exception;
    }

    public String getFQDN() {
        return this.fqdn;
    }

    public int getPort() {
        return this.port;
    }

    public int hashCode() {
        return ((this.fqdn.hashCode() + 37) * 37) + this.port;
    }

    public void setException(Exception exc) {
        this.exception = exc;
    }

    public String toString() {
        return this.fqdn + SignatureImpl.INNER_SEP + this.port;
    }

    public HostAddress(String str, int i) {
        Objects.requireNonNull(str, "FQDN is null");
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("Port must be a 16-bit unsiged integer (i.e. between 0-65535. Port was: " + i);
        }
        if (str.charAt(str.length() - 1) == '.') {
            this.fqdn = str.substring(0, str.length() - 1);
        } else {
            this.fqdn = str;
        }
        this.port = i;
    }
}
