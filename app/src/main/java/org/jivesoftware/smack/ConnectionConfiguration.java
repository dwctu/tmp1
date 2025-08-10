package org.jivesoftware.smack;

import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.security.auth.callback.CallbackHandler;
import org.jivesoftware.smack.proxy.ProxyInfo;

/* loaded from: classes5.dex */
public abstract class ConnectionConfiguration {
    public final boolean allowNullOrEmptyUsername;
    private final CallbackHandler callbackHandler;
    private final SSLContext customSSLContext;
    private final boolean debuggerEnabled;
    private final String[] enabledSSLCiphers;
    private final String[] enabledSSLProtocols;
    public final String host;
    private final HostnameVerifier hostnameVerifier;
    private final String keystorePath;
    private final String keystoreType;
    private final boolean legacySessionDisabled;
    private final String password;
    private final String pkcs11Library;
    public final int port;
    public final ProxyInfo proxy;
    private final String resource;
    private final SecurityMode securityMode;
    private final boolean sendPresence;
    public final String serviceName;
    private final SocketFactory socketFactory;
    private final CharSequence username;

    public static abstract class Builder<B extends Builder<B, C>, C extends ConnectionConfiguration> {
        private CallbackHandler callbackHandler;
        private SSLContext customSSLContext;
        private String[] enabledSSLCiphers;
        private String[] enabledSSLProtocols;
        private String host;
        private HostnameVerifier hostnameVerifier;
        private String password;
        private ProxyInfo proxy;
        private String serviceName;
        private SocketFactory socketFactory;
        private CharSequence username;
        private SecurityMode securityMode = SecurityMode.ifpossible;
        private String keystorePath = System.getProperty("javax.net.ssl.keyStore");
        private String keystoreType = "jks";
        private String pkcs11Library = "pkcs11.config";
        private String resource = "Smack";
        private boolean sendPresence = true;
        private boolean legacySessionDisabled = false;
        private boolean debuggerEnabled = SmackConfiguration.DEBUG;
        private int port = 5222;
        private boolean allowEmptyOrNullUsername = false;

        public B allowEmptyOrNullUsernames() {
            this.allowEmptyOrNullUsername = true;
            return (B) getThis();
        }

        public abstract C build();

        public abstract B getThis();

        public B setCallbackHandler(CallbackHandler callbackHandler) {
            this.callbackHandler = callbackHandler;
            return (B) getThis();
        }

        public B setCustomSSLContext(SSLContext sSLContext) {
            this.customSSLContext = sSLContext;
            return (B) getThis();
        }

        public B setDebuggerEnabled(boolean z) {
            this.debuggerEnabled = z;
            return (B) getThis();
        }

        public B setEnabledSSLCiphers(String[] strArr) {
            this.enabledSSLCiphers = strArr;
            return (B) getThis();
        }

        public B setEnabledSSLProtocols(String[] strArr) {
            this.enabledSSLProtocols = strArr;
            return (B) getThis();
        }

        public B setHost(String str) {
            this.host = str;
            return (B) getThis();
        }

        public B setHostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.hostnameVerifier = hostnameVerifier;
            return (B) getThis();
        }

        public B setKeystorePath(String str) {
            this.keystorePath = str;
            return (B) getThis();
        }

        public B setKeystoreType(String str) {
            this.keystoreType = str;
            return (B) getThis();
        }

        @Deprecated
        public B setLegacySessionDisabled(boolean z) {
            this.legacySessionDisabled = z;
            return (B) getThis();
        }

        public B setPKCS11Library(String str) {
            this.pkcs11Library = str;
            return (B) getThis();
        }

        public B setPort(int i) {
            this.port = i;
            return (B) getThis();
        }

        public B setProxyInfo(ProxyInfo proxyInfo) {
            this.proxy = proxyInfo;
            return (B) getThis();
        }

        public B setResource(String str) {
            this.resource = str;
            return (B) getThis();
        }

        public B setSecurityMode(SecurityMode securityMode) {
            this.securityMode = securityMode;
            return (B) getThis();
        }

        public B setSendPresence(boolean z) {
            this.sendPresence = z;
            return (B) getThis();
        }

        public B setServiceName(String str) {
            this.serviceName = str;
            return (B) getThis();
        }

        public B setSocketFactory(SocketFactory socketFactory) {
            this.socketFactory = socketFactory;
            return (B) getThis();
        }

        public B setUsernameAndPassword(CharSequence charSequence, String str) {
            this.username = charSequence;
            this.password = str;
            return (B) getThis();
        }
    }

    public enum SecurityMode {
        required,
        ifpossible,
        disabled
    }

    static {
        SmackConfiguration.getVersion();
    }

    public ConnectionConfiguration(Builder<?, ?> builder) {
        this.username = ((Builder) builder).username;
        this.password = ((Builder) builder).password;
        this.callbackHandler = ((Builder) builder).callbackHandler;
        this.resource = ((Builder) builder).resource;
        String str = ((Builder) builder).serviceName;
        this.serviceName = str;
        if (str == null) {
            throw new IllegalArgumentException("Must provide XMPP service name");
        }
        this.host = ((Builder) builder).host;
        this.port = ((Builder) builder).port;
        ProxyInfo proxyInfo = ((Builder) builder).proxy;
        this.proxy = proxyInfo;
        if (proxyInfo == null) {
            this.socketFactory = ((Builder) builder).socketFactory;
        } else {
            if (((Builder) builder).socketFactory != null) {
                throw new IllegalArgumentException("Can not use proxy together with custom socket factory");
            }
            this.socketFactory = proxyInfo.getSocketFactory();
        }
        this.securityMode = ((Builder) builder).securityMode;
        this.keystoreType = ((Builder) builder).keystoreType;
        this.keystorePath = ((Builder) builder).keystorePath;
        this.pkcs11Library = ((Builder) builder).pkcs11Library;
        this.customSSLContext = ((Builder) builder).customSSLContext;
        this.enabledSSLProtocols = ((Builder) builder).enabledSSLProtocols;
        this.enabledSSLCiphers = ((Builder) builder).enabledSSLCiphers;
        this.hostnameVerifier = ((Builder) builder).hostnameVerifier;
        this.sendPresence = ((Builder) builder).sendPresence;
        this.legacySessionDisabled = ((Builder) builder).legacySessionDisabled;
        this.debuggerEnabled = ((Builder) builder).debuggerEnabled;
        this.allowNullOrEmptyUsername = ((Builder) builder).allowEmptyOrNullUsername;
    }

    public CallbackHandler getCallbackHandler() {
        return this.callbackHandler;
    }

    public SSLContext getCustomSSLContext() {
        return this.customSSLContext;
    }

    public String[] getEnabledSSLCiphers() {
        return this.enabledSSLCiphers;
    }

    public String[] getEnabledSSLProtocols() {
        return this.enabledSSLProtocols;
    }

    public HostnameVerifier getHostnameVerifier() {
        HostnameVerifier hostnameVerifier = this.hostnameVerifier;
        return hostnameVerifier != null ? hostnameVerifier : SmackConfiguration.getDefaultHostnameVerifier();
    }

    public String getKeystorePath() {
        return this.keystorePath;
    }

    public String getKeystoreType() {
        return this.keystoreType;
    }

    public String getPKCS11Library() {
        return this.pkcs11Library;
    }

    public String getPassword() {
        return this.password;
    }

    public String getResource() {
        return this.resource;
    }

    public SecurityMode getSecurityMode() {
        return this.securityMode;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    public CharSequence getUsername() {
        return this.username;
    }

    public boolean isCompressionEnabled() {
        return false;
    }

    public boolean isDebuggerEnabled() {
        return this.debuggerEnabled;
    }

    @Deprecated
    public boolean isLegacySessionDisabled() {
        return this.legacySessionDisabled;
    }

    public boolean isSendPresence() {
        return this.sendPresence;
    }
}
