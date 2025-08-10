package org.jivesoftware.smack.proxy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.SocketFactory;
import org.jivesoftware.smack.proxy.ProxyInfo;

/* loaded from: classes5.dex */
public class Socks4ProxySocketFactory extends SocketFactory {
    private ProxyInfo proxy;

    public Socks4ProxySocketFactory(ProxyInfo proxyInfo) {
        this.proxy = proxyInfo;
    }

    private Socket socks4ProxifiedSocket(String str, int i) throws IOException {
        String proxyAddress = this.proxy.getProxyAddress();
        int proxyPort = this.proxy.getProxyPort();
        String proxyUsername = this.proxy.getProxyUsername();
        Socket socket = null;
        try {
            try {
                Socket socket2 = new Socket(proxyAddress, proxyPort);
                try {
                    InputStream inputStream = socket2.getInputStream();
                    OutputStream outputStream = socket2.getOutputStream();
                    socket2.setTcpNoDelay(true);
                    byte[] bArr = new byte[1024];
                    int length = 4;
                    bArr[0] = 4;
                    bArr[1] = 1;
                    bArr[2] = (byte) (i >>> 8);
                    bArr[3] = (byte) (i & 255);
                    try {
                        byte[] address = InetAddress.getByName(str).getAddress();
                        int i2 = 0;
                        while (i2 < address.length) {
                            int i3 = length + 1;
                            bArr[length] = address[i2];
                            i2++;
                            length = i3;
                        }
                        if (proxyUsername != null) {
                            System.arraycopy(proxyUsername.getBytes(), 0, bArr, length, proxyUsername.length());
                            length += proxyUsername.length();
                        }
                        bArr[length] = 0;
                        outputStream.write(bArr, 0, length + 1);
                        int i4 = 0;
                        while (i4 < 6) {
                            int i5 = inputStream.read(bArr, i4, 6 - i4);
                            if (i5 <= 0) {
                                throw new ProxyException(ProxyInfo.ProxyType.SOCKS4, "stream is closed");
                            }
                            i4 += i5;
                        }
                        if (bArr[0] != 0) {
                            throw new ProxyException(ProxyInfo.ProxyType.SOCKS4, "server returns VN " + ((int) bArr[0]));
                        }
                        if (bArr[1] == 90) {
                            inputStream.read(new byte[2], 0, 2);
                            return socket2;
                        }
                        try {
                            socket2.close();
                        } catch (Exception unused) {
                        }
                        throw new ProxyException(ProxyInfo.ProxyType.SOCKS4, "ProxySOCKS4: server returns CD " + ((int) bArr[1]));
                    } catch (UnknownHostException e) {
                        throw new ProxyException(ProxyInfo.ProxyType.SOCKS4, e.toString(), e);
                    }
                } catch (Exception e2) {
                    e = e2;
                    socket = socket2;
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw new ProxyException(ProxyInfo.ProxyType.SOCKS4, e.toString());
                }
            } catch (RuntimeException e3) {
                throw e3;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        return socks4ProxifiedSocket(str, i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return socks4ProxifiedSocket(str, i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return socks4ProxifiedSocket(inetAddress.getHostAddress(), i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return socks4ProxifiedSocket(inetAddress.getHostAddress(), i);
    }
}
