package org.jivesoftware.smack.proxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.SocketFactory;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jivesoftware.smack.proxy.ProxyInfo;
import org.jivesoftware.smack.util.stringencoder.Base64;

/* loaded from: classes5.dex */
public class HTTPProxySocketFactory extends SocketFactory {
    private static final Pattern RESPONSE_PATTERN = Pattern.compile("HTTP/\\S+\\s(\\d+)\\s(.*)\\s*");
    private ProxyInfo proxy;

    public HTTPProxySocketFactory(ProxyInfo proxyInfo) {
        this.proxy = proxyInfo;
    }

    private Socket httpProxifiedSocket(String str, int i) throws IOException {
        String string;
        String proxyAddress = this.proxy.getProxyAddress();
        Socket socket = new Socket(proxyAddress, this.proxy.getProxyPort());
        String str2 = "CONNECT " + str + SignatureImpl.INNER_SEP + i;
        String proxyUsername = this.proxy.getProxyUsername();
        if (proxyUsername == null) {
            string = "";
        } else {
            String proxyPassword = this.proxy.getProxyPassword();
            StringBuilder sb = new StringBuilder();
            sb.append("\r\nProxy-Authorization: Basic ");
            sb.append(Base64.encode(proxyUsername + SignatureImpl.INNER_SEP + proxyPassword));
            string = sb.toString();
        }
        socket.getOutputStream().write((str2 + " HTTP/1.1\r\nHost: " + str2 + string + "\r\n\r\n").getBytes("UTF-8"));
        InputStream inputStream = socket.getInputStream();
        StringBuilder sb2 = new StringBuilder(100);
        int i2 = 0;
        do {
            char c = (char) inputStream.read();
            sb2.append(c);
            if (sb2.length() > 1024) {
                throw new ProxyException(ProxyInfo.ProxyType.HTTP, "Recieved header of >1024 characters from " + proxyAddress + ", cancelling connection");
            }
            if (c == 65535) {
                throw new ProxyException(ProxyInfo.ProxyType.HTTP);
            }
            i2 = (((i2 == 0 || i2 == 2) && c == '\r') || ((i2 == 1 || i2 == 3) && c == '\n')) ? i2 + 1 : 0;
        } while (i2 != 4);
        if (i2 != 4) {
            throw new ProxyException(ProxyInfo.ProxyType.HTTP, "Never received blank line from " + proxyAddress + ", cancelling connection");
        }
        String line = new BufferedReader(new StringReader(sb2.toString())).readLine();
        if (line == null) {
            throw new ProxyException(ProxyInfo.ProxyType.HTTP, "Empty proxy response from " + proxyAddress + ", cancelling");
        }
        Matcher matcher = RESPONSE_PATTERN.matcher(line);
        if (matcher.matches()) {
            if (Integer.parseInt(matcher.group(1)) == 200) {
                return socket;
            }
            throw new ProxyException(ProxyInfo.ProxyType.HTTP);
        }
        throw new ProxyException(ProxyInfo.ProxyType.HTTP, "Unexpected proxy response from " + proxyAddress + ": " + line);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        return httpProxifiedSocket(str, i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return httpProxifiedSocket(str, i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return httpProxifiedSocket(inetAddress.getHostAddress(), i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return httpProxifiedSocket(inetAddress.getHostAddress(), i);
    }
}
