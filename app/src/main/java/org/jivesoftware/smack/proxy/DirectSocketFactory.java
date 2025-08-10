package org.jivesoftware.smack.proxy;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import javax.net.SocketFactory;

/* loaded from: classes5.dex */
public class DirectSocketFactory extends SocketFactory {
    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        Socket socket = new Socket(Proxy.NO_PROXY);
        socket.connect(new InetSocketAddress(str, i));
        return socket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return new Socket(str, i, inetAddress, i2);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Socket socket = new Socket(Proxy.NO_PROXY);
        socket.connect(new InetSocketAddress(inetAddress, i));
        return socket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return new Socket(inetAddress, i, inetAddress2, i2);
    }
}
