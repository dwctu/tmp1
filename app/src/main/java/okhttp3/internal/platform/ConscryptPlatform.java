package okhttp3.internal.platform;

import dc.wc4;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.Conscrypt;
import org.jivesoftware.smack.util.TLSUtils;

/* loaded from: classes5.dex */
public class ConscryptPlatform extends Platform {
    private ConscryptPlatform() {
    }

    public static ConscryptPlatform buildIfSupported() throws ClassNotFoundException {
        try {
            Class.forName("org.conscrypt.Conscrypt");
            if (Conscrypt.isAvailable()) {
                return new ConscryptPlatform();
            }
            return null;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private Provider getProvider() {
        return Conscrypt.newProviderBuilder().provideTrustManager().build();
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<wc4> list) throws IOException {
        if (!Conscrypt.isConscrypt(sSLSocket)) {
            super.configureTlsExtensions(sSLSocket, str, list);
            return;
        }
        if (str != null) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Conscrypt.setHostname(sSLSocket, str);
        }
        Conscrypt.setApplicationProtocols(sSLSocket, (String[]) Platform.alpnProtocolNames(list).toArray(new String[0]));
    }

    @Override // okhttp3.internal.platform.Platform
    public SSLContext getSSLContext() {
        try {
            return SSLContext.getInstance("TLSv1.3", getProvider());
        } catch (NoSuchAlgorithmException e) {
            try {
                return SSLContext.getInstance(TLSUtils.TLS, getProvider());
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("No TLS provider", e);
            }
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        return Conscrypt.isConscrypt(sSLSocket) ? Conscrypt.getApplicationProtocol(sSLSocket) : super.getSelectedProtocol(sSLSocket);
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        if (!Conscrypt.isConscrypt(sSLSocketFactory)) {
            return super.trustManager(sSLSocketFactory);
        }
        try {
            Object fieldOrNull = Platform.readFieldOrNull(sSLSocketFactory, Object.class, "sslParameters");
            if (fieldOrNull != null) {
                return (X509TrustManager) Platform.readFieldOrNull(fieldOrNull, X509TrustManager.class, "x509TrustManager");
            }
            return null;
        } catch (Exception e) {
            throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on Conscrypt", e);
        }
    }
}
