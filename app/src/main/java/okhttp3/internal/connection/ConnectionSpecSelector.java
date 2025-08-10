package okhttp3.internal.connection;

import dc.hc4;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Internal;

/* loaded from: classes5.dex */
public final class ConnectionSpecSelector {
    private final List<hc4> connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex = 0;

    public ConnectionSpecSelector(List<hc4> list) {
        this.connectionSpecs = list;
    }

    private boolean isFallbackPossible(SSLSocket sSLSocket) {
        for (int i = this.nextModeIndex; i < this.connectionSpecs.size(); i++) {
            if (this.connectionSpecs.get(i).c(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public hc4 configureSecureSocket(SSLSocket sSLSocket) throws IOException {
        hc4 hc4Var;
        int i = this.nextModeIndex;
        int size = this.connectionSpecs.size();
        while (true) {
            if (i >= size) {
                hc4Var = null;
                break;
            }
            hc4Var = this.connectionSpecs.get(i);
            if (hc4Var.c(sSLSocket)) {
                this.nextModeIndex = i + 1;
                break;
            }
            i++;
        }
        if (hc4Var != null) {
            this.isFallbackPossible = isFallbackPossible(sSLSocket);
            Internal.instance.apply(hc4Var, sSLSocket, this.isFallback);
            return hc4Var;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.isFallback + ", modes=" + this.connectionSpecs + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean connectionFailed(IOException iOException) {
        this.isFallback = true;
        if (!this.isFallbackPossible || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return iOException instanceof SSLException;
    }
}
