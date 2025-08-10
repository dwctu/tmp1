package com.amazonaws.http;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.http.AsyncHttpHead;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jivesoftware.smack.util.TLSUtils;

/* loaded from: classes.dex */
public class UrlHttpClient implements HttpClient {
    public static final Log e = LogFactory.b(UrlHttpClient.class);
    public final ClientConfiguration a;
    public TLS12SocketFactory d;
    public SSLContext c = null;
    public final TLS12SocketFactory b = TLS12SocketFactory.a();

    public final class CurlBuilder {
        public final URL a;
        public String b = null;
        public final HashMap<String, String> c = new HashMap<>();
        public String d = null;
        public boolean e = false;

        public CurlBuilder(UrlHttpClient urlHttpClient, URL url) {
            if (url == null) {
                throw new IllegalArgumentException("Must have a valid url");
            }
            this.a = url;
        }

        public String a() {
            if (!b()) {
                throw new IllegalStateException("Invalid state, cannot create curl command");
            }
            StringBuilder sb = new StringBuilder("curl");
            if (this.b != null) {
                sb.append(" -X ");
                sb.append(this.b);
            }
            for (Map.Entry<String, String> entry : this.c.entrySet()) {
                sb.append(" -H \"");
                sb.append(entry.getKey());
                sb.append(SignatureImpl.INNER_SEP);
                sb.append(entry.getValue());
                sb.append("\"");
            }
            if (this.d != null) {
                sb.append(" -d '");
                sb.append(this.d);
                sb.append("'");
            }
            sb.append(" ");
            sb.append(this.a.toString());
            return sb.toString();
        }

        public boolean b() {
            return !this.e;
        }

        public CurlBuilder c(String str) {
            this.d = str;
            return this;
        }

        public CurlBuilder d(boolean z) {
            this.e = z;
            return this;
        }

        public CurlBuilder e(Map<String, String> map) {
            this.c.clear();
            this.c.putAll(map);
            return this;
        }

        public CurlBuilder f(String str) {
            this.b = str;
            return this;
        }
    }

    public UrlHttpClient(ClientConfiguration clientConfiguration) {
        this.a = clientConfiguration;
    }

    @Override // com.amazonaws.http.HttpClient
    public HttpResponse a(HttpRequest httpRequest) throws NoSuchAlgorithmException, IOException, KeyManagementException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpRequest.e().toURL().openConnection();
        CurlBuilder curlBuilder = this.a.j() ? new CurlBuilder(this, httpRequest.e().toURL()) : null;
        c(httpRequest, httpURLConnection);
        b(httpRequest, httpURLConnection, curlBuilder);
        h(httpRequest, httpURLConnection, curlBuilder);
        if (curlBuilder != null) {
            if (curlBuilder.b()) {
                f(curlBuilder.a());
            } else {
                f("Failed to create curl, content too long");
            }
        }
        return d(httpRequest, httpURLConnection);
    }

    public HttpURLConnection b(HttpRequest httpRequest, HttpURLConnection httpURLConnection, CurlBuilder curlBuilder) throws ProtocolException {
        if (httpRequest.c() != null && !httpRequest.c().isEmpty()) {
            if (curlBuilder != null) {
                curlBuilder.e(httpRequest.c());
            }
            for (Map.Entry<String, String> entry : httpRequest.c().entrySet()) {
                String key = entry.getKey();
                if (!key.equals(HttpHeaders.CONTENT_LENGTH) && !key.equals(HttpHeaders.HOST)) {
                    key.equals(HttpHeaders.EXPECT);
                    httpURLConnection.setRequestProperty(key, entry.getValue());
                }
            }
        }
        String strD = httpRequest.d();
        httpURLConnection.setRequestMethod(strD);
        if (curlBuilder != null) {
            curlBuilder.f(strD);
        }
        return httpURLConnection;
    }

    public void c(HttpRequest httpRequest, HttpURLConnection httpURLConnection) throws NoSuchAlgorithmException, KeyManagementException {
        httpURLConnection.setConnectTimeout(this.a.a());
        httpURLConnection.setReadTimeout(this.a.f());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setUseCaches(false);
        if (httpRequest.f()) {
            httpURLConnection.setChunkedStreamingMode(0);
        }
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            if (this.a.g() != null) {
                e(httpsURLConnection);
                return;
            }
            TLS12SocketFactory tLS12SocketFactory = this.b;
            if (tLS12SocketFactory != null) {
                TLS12SocketFactory.c(httpsURLConnection, tLS12SocketFactory);
            }
        }
    }

    public HttpResponse d(HttpRequest httpRequest, HttpURLConnection httpURLConnection) throws IOException {
        String responseMessage = httpURLConnection.getResponseMessage();
        int responseCode = httpURLConnection.getResponseCode();
        InputStream errorStream = httpURLConnection.getErrorStream();
        if (errorStream == null && !AsyncHttpHead.METHOD.equals(httpRequest.d())) {
            try {
                errorStream = httpURLConnection.getInputStream();
            } catch (IOException unused) {
            }
        }
        HttpResponse.Builder builderA = HttpResponse.a();
        builderA.d(responseCode);
        builderA.e(responseMessage);
        builderA.b(errorStream);
        for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                builderA.c(entry.getKey(), entry.getValue().get(0));
            }
        }
        return builderA.a();
    }

    public final void e(HttpsURLConnection httpsURLConnection) throws NoSuchAlgorithmException, KeyManagementException {
        if (this.c == null) {
            TrustManager[] trustManagerArr = {this.a.g()};
            try {
                SSLContext sSLContext = SSLContext.getInstance(TLSUtils.TLS);
                this.c = sSLContext;
                sSLContext.init(null, trustManagerArr, null);
                if (this.d == null) {
                    this.d = TLS12SocketFactory.b(this.c);
                }
            } catch (GeneralSecurityException e2) {
                throw new RuntimeException(e2);
            }
        }
        TLS12SocketFactory tLS12SocketFactory = this.d;
        if (tLS12SocketFactory != null) {
            httpsURLConnection.setSSLSocketFactory(tLS12SocketFactory);
        } else {
            httpsURLConnection.setSSLSocketFactory(this.c.getSocketFactory());
        }
    }

    public void f(String str) {
        e.a(str);
    }

    public final void g(InputStream inputStream, OutputStream outputStream, CurlBuilder curlBuilder, ByteBuffer byteBuffer) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            }
            if (byteBuffer != null) {
                try {
                    byteBuffer.put(bArr, 0, i);
                } catch (BufferOverflowException unused) {
                    curlBuilder.d(true);
                }
            }
            outputStream.write(bArr, 0, i);
        }
    }

    public void h(HttpRequest httpRequest, HttpURLConnection httpURLConnection, CurlBuilder curlBuilder) throws IOException {
        if (httpRequest.a() == null || httpRequest.b() < 0) {
            return;
        }
        httpURLConnection.setDoOutput(true);
        if (!httpRequest.f()) {
            httpURLConnection.setFixedLengthStreamingMode((int) httpRequest.b());
        }
        OutputStream outputStream = httpURLConnection.getOutputStream();
        ByteBuffer byteBufferAllocate = null;
        if (curlBuilder != null) {
            if (httpRequest.b() < 2147483647L) {
                byteBufferAllocate = ByteBuffer.allocate((int) httpRequest.b());
            } else {
                curlBuilder.d(true);
            }
        }
        g(httpRequest.a(), outputStream, curlBuilder, byteBufferAllocate);
        if (curlBuilder != null && byteBufferAllocate != null && byteBufferAllocate.position() != 0) {
            curlBuilder.c(new String(byteBufferAllocate.array(), "UTF-8"));
        }
        outputStream.flush();
        outputStream.close();
    }

    @Override // com.amazonaws.http.HttpClient
    public void shutdown() {
    }
}
