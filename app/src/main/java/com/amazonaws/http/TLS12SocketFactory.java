package com.amazonaws.http;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.jivesoftware.smack.util.TLSUtils;

/* loaded from: classes.dex */
public class TLS12SocketFactory extends SSLSocketFactory {
    public static final Object c = new Object();
    public static final String[] d = {TLSUtils.PROTO_TLSV1, TLSUtils.PROTO_TLSV1_1, TLSUtils.PROTO_TLSV1_2};
    public static SSLContext e;
    public final SSLSocketFactory a;
    public LoggingHandshakeCompletedListener b;

    public TLS12SocketFactory(@Nullable SSLContext sSLContext) throws NoSuchAlgorithmException, KeyManagementException {
        if (sSLContext != null) {
            this.a = sSLContext.getSocketFactory();
        } else {
            synchronized (c) {
                if (e == null) {
                    SSLContext sSLContext2 = SSLContext.getInstance(TLSUtils.TLS);
                    e = sSLContext2;
                    sSLContext2.init(null, null, null);
                }
            }
            this.a = e.getSocketFactory();
        }
        this.b = new LoggingHandshakeCompletedListener();
    }

    @Nullable
    public static TLS12SocketFactory a() {
        return b(null);
    }

    @Nullable
    public static TLS12SocketFactory b(@Nullable SSLContext sSLContext) {
        if (Build.VERSION.SDK_INT >= 21) {
            return null;
        }
        try {
            return new TLS12SocketFactory(sSLContext);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void c(@NonNull HttpsURLConnection httpsURLConnection, @Nullable TLS12SocketFactory tLS12SocketFactory) {
        if (Build.VERSION.SDK_INT >= 21 || tLS12SocketFactory == null) {
            return;
        }
        try {
            httpsURLConnection.setSSLSocketFactory(tLS12SocketFactory);
        } catch (Exception unused) {
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.a.createSocket();
        sSLSocket.addHandshakeCompletedListener(this.b);
        d(sSLSocket);
        return sSLSocket;
    }

    public final Socket d(Socket socket) {
        if (socket instanceof SSLSocket) {
            try {
                ((SSLSocket) socket).setEnabledProtocols(d);
            } catch (Exception unused) {
            }
        }
        return socket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.a.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.a.createSocket(socket, str, i, z);
        sSLSocket.addHandshakeCompletedListener(this.b);
        d(sSLSocket);
        return sSLSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.a.createSocket(str, i);
        sSLSocket.addHandshakeCompletedListener(this.b);
        d(sSLSocket);
        return sSLSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.a.createSocket(str, i, inetAddress, i2);
        sSLSocket.addHandshakeCompletedListener(this.b);
        d(sSLSocket);
        return sSLSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.a.createSocket(inetAddress, i);
        sSLSocket.addHandshakeCompletedListener(this.b);
        d(sSLSocket);
        return sSLSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.a.createSocket(inetAddress, i, inetAddress2, i2);
        sSLSocket.addHandshakeCompletedListener(this.b);
        d(sSLSocket);
        return sSLSocket;
    }
}
