package okhttp3.internal.platform;

import dc.nd4;
import dc.vc4;
import dc.wc4;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.Util;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import org.jivesoftware.smack.util.TLSUtils;

/* loaded from: classes5.dex */
public class Platform {
    public static final int INFO = 4;
    public static final int WARN = 5;
    private static final Platform PLATFORM = findPlatform();
    private static final Logger logger = Logger.getLogger(vc4.class.getName());

    public static List<String> alpnProtocolNames(List<wc4> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            wc4 wc4Var = list.get(i);
            if (wc4Var != wc4.HTTP_1_0) {
                arrayList.add(wc4Var.toString());
            }
        }
        return arrayList;
    }

    public static byte[] concatLengthPrefixed(List<wc4> list) {
        nd4 nd4Var = new nd4();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            wc4 wc4Var = list.get(i);
            if (wc4Var != wc4.HTTP_1_0) {
                nd4Var.m0(wc4Var.toString().length());
                nd4Var.u0(wc4Var.toString());
            }
        }
        return nd4Var.M();
    }

    private static Platform findAndroidPlatform() {
        Platform platformBuildIfSupported = Android10Platform.buildIfSupported();
        if (platformBuildIfSupported != null) {
            return platformBuildIfSupported;
        }
        Platform platformBuildIfSupported2 = AndroidPlatform.buildIfSupported();
        Objects.requireNonNull(platformBuildIfSupported2, "No platform found on Android");
        return platformBuildIfSupported2;
    }

    private static Platform findJvmPlatform() {
        ConscryptPlatform conscryptPlatformBuildIfSupported;
        if (isConscryptPreferred() && (conscryptPlatformBuildIfSupported = ConscryptPlatform.buildIfSupported()) != null) {
            return conscryptPlatformBuildIfSupported;
        }
        Jdk9Platform jdk9PlatformBuildIfSupported = Jdk9Platform.buildIfSupported();
        if (jdk9PlatformBuildIfSupported != null) {
            return jdk9PlatformBuildIfSupported;
        }
        Platform platformBuildIfSupported = Jdk8WithJettyBootPlatform.buildIfSupported();
        return platformBuildIfSupported != null ? platformBuildIfSupported : new Platform();
    }

    private static Platform findPlatform() {
        return isAndroid() ? findAndroidPlatform() : findJvmPlatform();
    }

    public static Platform get() {
        return PLATFORM;
    }

    public static boolean isAndroid() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    public static boolean isConscryptPreferred() {
        if ("conscrypt".equals(Util.getSystemProperty("okhttp.platform", null))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    public static <T> T readFieldOrNull(Object obj, Class<T> cls, String str) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        Object fieldOrNull;
        for (Class<?> superclass = obj.getClass(); superclass != Object.class; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (cls.isInstance(obj2)) {
                    return cls.cast(obj2);
                }
                return null;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (NoSuchFieldException unused2) {
            }
        }
        if (str.equals("delegate") || (fieldOrNull = readFieldOrNull(obj, Object.class, "delegate")) == null) {
            return null;
        }
        return (T) readFieldOrNull(fieldOrNull, cls, str);
    }

    public void afterHandshake(SSLSocket sSLSocket) {
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        return new BasicCertificateChainCleaner(buildTrustRootIndex(x509TrustManager));
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        return new BasicTrustRootIndex(x509TrustManager.getAcceptedIssuers());
    }

    public void configureSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<wc4> list) throws IOException {
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public String getPrefix() {
        return "OkHttp";
    }

    public SSLContext getSSLContext() {
        try {
            return SSLContext.getInstance(TLSUtils.TLS);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        return null;
    }

    public Object getStackTraceForCloseable(String str) {
        if (logger.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean isCleartextTrafficPermitted(String str) {
        return true;
    }

    public void log(int i, String str, Throwable th) {
        logger.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void logCloseableLeak(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        log(5, str, (Throwable) obj);
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Object fieldOrNull = readFieldOrNull(sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (fieldOrNull == null) {
                return null;
            }
            return (X509TrustManager) readFieldOrNull(fieldOrNull, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public CertificateChainCleaner buildCertificateChainCleaner(SSLSocketFactory sSLSocketFactory) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        X509TrustManager x509TrustManagerTrustManager = trustManager(sSLSocketFactory);
        if (x509TrustManagerTrustManager != null) {
            return buildCertificateChainCleaner(x509TrustManagerTrustManager);
        }
        throw new IllegalStateException("Unable to extract the trust manager on " + get() + ", sslSocketFactory is " + sSLSocketFactory.getClass());
    }
}
