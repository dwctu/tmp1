package com.koushikdutta.async.http;

import android.net.Uri;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.AsyncSSLException;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;
import java.util.Locale;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes3.dex */
public class AsyncHttpRequest {
    public static final int DEFAULT_TIMEOUT = 30000;
    public static final String HEADER_ACCEPT_ALL = "*/*";
    public String LOGTAG;
    public long executionTime;
    public int logLevel;
    private AsyncHttpRequestBody mBody;
    private boolean mFollowRedirect;
    private String mMethod;
    private Headers mRawHeaders;
    public int mTimeout;
    public String proxyHost;
    public int proxyPort;
    private String requestLineProtocol;
    public Uri uri;

    public AsyncHttpRequest(Uri uri, String str) {
        this(uri, str, null);
    }

    public static String getDefaultUserAgent() {
        String property = System.getProperty("http.agent");
        if (property != null) {
            return property;
        }
        return "Java" + System.getProperty("java.version");
    }

    private String getLogMessage(String str) {
        return String.format(Locale.ENGLISH, "(%d ms) %s: %s", Long.valueOf(this.executionTime != 0 ? System.currentTimeMillis() - this.executionTime : 0L), getUri(), str);
    }

    public static void setDefaultHeaders(Headers headers, Uri uri) {
        if (uri != null) {
            String host = uri.getHost();
            if (uri.getPort() != -1) {
                host = host + SignatureImpl.INNER_SEP + uri.getPort();
            }
            if (host != null) {
                headers.set(HttpHeaders.HOST, host);
            }
        }
        headers.set("User-Agent", getDefaultUserAgent());
        headers.set(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate");
        headers.set(HttpHeaders.CONNECTION, "keep-alive");
        headers.set("Accept", HEADER_ACCEPT_ALL);
    }

    public AsyncHttpRequest addHeader(String str, String str2) {
        getHeaders().add(str, str2);
        return this;
    }

    public void disableProxy() {
        this.proxyHost = null;
        this.proxyPort = -1;
    }

    public void enableProxy(String str, int i) {
        this.proxyHost = str;
        this.proxyPort = i;
    }

    public AsyncHttpRequestBody getBody() {
        return this.mBody;
    }

    public boolean getFollowRedirect() {
        return this.mFollowRedirect;
    }

    public Headers getHeaders() {
        return this.mRawHeaders;
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    public String getLogTag() {
        return this.LOGTAG;
    }

    public String getMethod() {
        return this.mMethod;
    }

    public String getPath() {
        return getUri().getEncodedPath();
    }

    public String getProxyHost() {
        return this.proxyHost;
    }

    public int getProxyPort() {
        return this.proxyPort;
    }

    public RequestLine getRequestLine() {
        return new RequestLine() { // from class: com.koushikdutta.async.http.AsyncHttpRequest.1
            @Override // com.koushikdutta.async.http.RequestLine
            public String getMethod() {
                return AsyncHttpRequest.this.mMethod;
            }

            @Override // com.koushikdutta.async.http.RequestLine
            public ProtocolVersion getProtocolVersion() {
                return new ProtocolVersion("HTTP", 1, 1);
            }

            @Override // com.koushikdutta.async.http.RequestLine
            public String getUri() {
                return AsyncHttpRequest.this.getUri().toString();
            }

            public String toString() {
                AsyncHttpRequest asyncHttpRequest = AsyncHttpRequest.this;
                if (asyncHttpRequest.proxyHost != null) {
                    return String.format(Locale.ENGLISH, "%s %s %s", asyncHttpRequest.mMethod, AsyncHttpRequest.this.getUri(), AsyncHttpRequest.this.requestLineProtocol);
                }
                String path = asyncHttpRequest.getPath();
                if (path == null || path.length() == 0) {
                    path = "/";
                }
                String encodedQuery = AsyncHttpRequest.this.getUri().getEncodedQuery();
                if (encodedQuery != null && encodedQuery.length() != 0) {
                    path = path + "?" + encodedQuery;
                }
                return String.format(Locale.ENGLISH, "%s %s %s", AsyncHttpRequest.this.mMethod, path, AsyncHttpRequest.this.requestLineProtocol);
            }
        };
    }

    public String getRequestLineProtocol() {
        return this.requestLineProtocol;
    }

    public int getTimeout() {
        return this.mTimeout;
    }

    public Uri getUri() {
        return this.uri;
    }

    public boolean hasBody() {
        return true;
    }

    public void logd(String str) {
        if (this.LOGTAG != null && this.logLevel <= 3) {
            getLogMessage(str);
        }
    }

    public void loge(String str) {
        if (this.LOGTAG != null && this.logLevel <= 6) {
            getLogMessage(str);
        }
    }

    public void logi(String str) {
        if (this.LOGTAG != null && this.logLevel <= 4) {
            getLogMessage(str);
        }
    }

    public void logv(String str) {
        if (this.LOGTAG != null && this.logLevel <= 2) {
            getLogMessage(str);
        }
    }

    public void logw(String str) {
        if (this.LOGTAG != null && this.logLevel <= 5) {
            getLogMessage(str);
        }
    }

    public void onHandshakeException(AsyncSSLException asyncSSLException) {
    }

    public void setBody(AsyncHttpRequestBody asyncHttpRequestBody) {
        this.mBody = asyncHttpRequestBody;
    }

    public AsyncHttpRequest setFollowRedirect(boolean z) {
        this.mFollowRedirect = z;
        return this;
    }

    public AsyncHttpRequest setHeader(String str, String str2) {
        getHeaders().set(str, str2);
        return this;
    }

    public void setLogging(String str, int i) {
        this.LOGTAG = str;
        this.logLevel = i;
    }

    public AsyncHttpRequest setMethod(String str) {
        if (getClass() != AsyncHttpRequest.class) {
            throw new UnsupportedOperationException("can't change method on a subclass of AsyncHttpRequest");
        }
        this.mMethod = str;
        return this;
    }

    public void setRequestLineProtocol(String str) {
        this.requestLineProtocol = str;
    }

    public AsyncHttpRequest setTimeout(int i) {
        this.mTimeout = i;
        return this;
    }

    public String toString() {
        Headers headers = this.mRawHeaders;
        return headers == null ? super.toString() : headers.toPrefixString(this.uri.toString());
    }

    public AsyncHttpRequest(Uri uri, String str, Headers headers) {
        this.requestLineProtocol = "HTTP/1.1";
        this.mRawHeaders = new Headers();
        this.mFollowRedirect = true;
        this.mTimeout = DEFAULT_TIMEOUT;
        this.proxyPort = -1;
        this.mMethod = str;
        this.uri = uri;
        if (headers == null) {
            this.mRawHeaders = new Headers();
        } else {
            this.mRawHeaders = headers;
        }
        if (headers == null) {
            setDefaultHeaders(this.mRawHeaders, uri);
        }
    }

    public void logd(String str, Exception exc) {
        if (this.LOGTAG != null && this.logLevel <= 3) {
            getLogMessage(str);
            exc.getMessage();
        }
    }

    public void loge(String str, Exception exc) {
        if (this.LOGTAG != null && this.logLevel <= 6) {
            getLogMessage(str);
            exc.getMessage();
        }
    }
}
