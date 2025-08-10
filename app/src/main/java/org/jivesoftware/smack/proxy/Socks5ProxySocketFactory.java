package org.jivesoftware.smack.proxy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import org.jivesoftware.smack.proxy.ProxyInfo;

/* loaded from: classes5.dex */
public class Socks5ProxySocketFactory extends SocketFactory {
    private ProxyInfo proxy;

    public Socks5ProxySocketFactory(ProxyInfo proxyInfo) {
        this.proxy = proxyInfo;
    }

    private void fill(InputStream inputStream, byte[] bArr, int i) throws IOException {
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, i2, i - i2);
            if (i3 <= 0) {
                throw new ProxyException(ProxyInfo.ProxyType.SOCKS5, "stream is closed");
            }
            i2 += i3;
        }
    }

    private Socket socks5ProxifiedSocket(String str, int i) throws IOException {
        Socket socket;
        boolean z;
        String proxyAddress = this.proxy.getProxyAddress();
        int proxyPort = this.proxy.getProxyPort();
        String proxyUsername = this.proxy.getProxyUsername();
        String proxyPassword = this.proxy.getProxyPassword();
        Socket socket2 = null;
        try {
            try {
                socket = new Socket(proxyAddress, proxyPort);
            } catch (Exception e) {
                e = e;
            }
            try {
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                socket.setTcpNoDelay(true);
                byte[] bArr = new byte[1024];
                bArr[0] = 5;
                bArr[1] = 2;
                bArr[2] = 0;
                bArr[3] = 2;
                outputStream.write(bArr, 0, 4);
                fill(inputStream, bArr, 2);
                int i2 = bArr[1] & 255;
                if (i2 != 0) {
                    if (i2 == 2 && proxyUsername != null && proxyPassword != null) {
                        bArr[0] = 1;
                        bArr[1] = (byte) proxyUsername.length();
                        System.arraycopy(proxyUsername.getBytes(), 0, bArr, 2, proxyUsername.length());
                        int length = proxyUsername.length() + 2;
                        int i3 = length + 1;
                        bArr[length] = (byte) proxyPassword.length();
                        System.arraycopy(proxyPassword.getBytes(), 0, bArr, i3, proxyPassword.length());
                        outputStream.write(bArr, 0, i3 + proxyPassword.length());
                        fill(inputStream, bArr, 2);
                        z = bArr[1] == 0;
                    }
                }
                if (!z) {
                    try {
                        socket.close();
                    } catch (Exception unused) {
                    }
                    throw new ProxyException(ProxyInfo.ProxyType.SOCKS5, "fail in SOCKS5 proxy");
                }
                bArr[0] = 5;
                bArr[1] = 1;
                bArr[2] = 0;
                byte[] bytes = str.getBytes();
                int length2 = bytes.length;
                bArr[3] = 3;
                bArr[4] = (byte) length2;
                System.arraycopy(bytes, 0, bArr, 5, length2);
                int i4 = 5 + length2;
                int i5 = i4 + 1;
                bArr[i4] = (byte) (i >>> 8);
                bArr[i5] = (byte) (i & 255);
                outputStream.write(bArr, 0, i5 + 1);
                fill(inputStream, bArr, 4);
                if (bArr[1] != 0) {
                    try {
                        socket.close();
                    } catch (Exception unused2) {
                    }
                    throw new ProxyException(ProxyInfo.ProxyType.SOCKS5, "server returns " + ((int) bArr[1]));
                }
                int i6 = bArr[3] & 255;
                if (i6 == 1) {
                    fill(inputStream, bArr, 6);
                } else if (i6 == 3) {
                    fill(inputStream, bArr, 1);
                    fill(inputStream, bArr, (bArr[0] & 255) + 2);
                } else if (i6 == 4) {
                    fill(inputStream, bArr, 18);
                }
                return socket;
            } catch (Exception e2) {
                e = e2;
                socket2 = socket;
                if (socket2 != null) {
                    try {
                        socket2.close();
                    } catch (Exception unused3) {
                    }
                }
                throw new ProxyException(ProxyInfo.ProxyType.SOCKS5, "ProxySOCKS5: " + e.toString(), e);
            }
        } catch (RuntimeException e3) {
            throw e3;
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        return socks5ProxifiedSocket(str, i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return socks5ProxifiedSocket(str, i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return socks5ProxifiedSocket(inetAddress.getHostAddress(), i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return socks5ProxifiedSocket(inetAddress.getHostAddress(), i);
    }
}
