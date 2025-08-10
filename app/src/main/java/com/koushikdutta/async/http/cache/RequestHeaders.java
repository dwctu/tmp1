package com.koushikdutta.async.http.cache;

import android.net.Uri;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.http.HttpDate;
import com.koushikdutta.async.http.cache.HeaderParser;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;

/* loaded from: classes3.dex */
public final class RequestHeaders {
    private String acceptEncoding;
    private String connection;
    private int contentLength;
    private String contentType;
    private boolean hasAuthorization;
    private final RawHeaders headers;
    private String host;
    private String ifModifiedSince;
    private String ifNoneMatch;
    private int maxAgeSeconds = -1;
    private int maxStaleSeconds = -1;
    private int minFreshSeconds = -1;
    private boolean noCache;
    private boolean onlyIfCached;
    private String proxyAuthorization;
    private String transferEncoding;
    private final Uri uri;
    private String userAgent;

    public RequestHeaders(Uri uri, RawHeaders rawHeaders) {
        this.contentLength = -1;
        this.uri = uri;
        this.headers = rawHeaders;
        HeaderParser.CacheControlHandler cacheControlHandler = new HeaderParser.CacheControlHandler() { // from class: com.koushikdutta.async.http.cache.RequestHeaders.1
            @Override // com.koushikdutta.async.http.cache.HeaderParser.CacheControlHandler
            public void handle(String str, String str2) {
                if (str.equalsIgnoreCase("no-cache")) {
                    RequestHeaders.this.noCache = true;
                    return;
                }
                if (str.equalsIgnoreCase("max-age")) {
                    RequestHeaders.this.maxAgeSeconds = HeaderParser.parseSeconds(str2);
                    return;
                }
                if (str.equalsIgnoreCase("max-stale")) {
                    RequestHeaders.this.maxStaleSeconds = HeaderParser.parseSeconds(str2);
                } else if (str.equalsIgnoreCase("min-fresh")) {
                    RequestHeaders.this.minFreshSeconds = HeaderParser.parseSeconds(str2);
                } else if (str.equalsIgnoreCase("only-if-cached")) {
                    RequestHeaders.this.onlyIfCached = true;
                }
            }
        };
        for (int i = 0; i < rawHeaders.length(); i++) {
            String fieldName = rawHeaders.getFieldName(i);
            String value = rawHeaders.getValue(i);
            if (HttpHeaders.CACHE_CONTROL.equalsIgnoreCase(fieldName)) {
                HeaderParser.parseCacheControl(value, cacheControlHandler);
            } else if (HttpHeaders.PRAGMA.equalsIgnoreCase(fieldName)) {
                if (value.equalsIgnoreCase("no-cache")) {
                    this.noCache = true;
                }
            } else if (HttpHeaders.IF_NONE_MATCH.equalsIgnoreCase(fieldName)) {
                this.ifNoneMatch = value;
            } else if (HttpHeaders.IF_MODIFIED_SINCE.equalsIgnoreCase(fieldName)) {
                this.ifModifiedSince = value;
            } else if (HttpHeaders.AUTHORIZATION.equalsIgnoreCase(fieldName)) {
                this.hasAuthorization = true;
            } else if (HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(fieldName)) {
                try {
                    this.contentLength = Integer.parseInt(value);
                } catch (NumberFormatException unused) {
                }
            } else if (HttpHeaders.TRANSFER_ENCODING.equalsIgnoreCase(fieldName)) {
                this.transferEncoding = value;
            } else if ("User-Agent".equalsIgnoreCase(fieldName)) {
                this.userAgent = value;
            } else if (HttpHeaders.HOST.equalsIgnoreCase(fieldName)) {
                this.host = value;
            } else if (HttpHeaders.CONNECTION.equalsIgnoreCase(fieldName)) {
                this.connection = value;
            } else if (HttpHeaders.ACCEPT_ENCODING.equalsIgnoreCase(fieldName)) {
                this.acceptEncoding = value;
            } else if ("Content-Type".equalsIgnoreCase(fieldName)) {
                this.contentType = value;
            } else if (HttpHeaders.PROXY_AUTHORIZATION.equalsIgnoreCase(fieldName)) {
                this.proxyAuthorization = value;
            }
        }
    }

    public void addCookies(Map<String, List<String>> map) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            if (HttpHeaders.COOKIE.equalsIgnoreCase(key) || "Cookie2".equalsIgnoreCase(key)) {
                this.headers.addAll(key, entry.getValue());
            }
        }
    }

    public String getAcceptEncoding() {
        return this.acceptEncoding;
    }

    public String getConnection() {
        return this.connection;
    }

    public int getContentLength() {
        return this.contentLength;
    }

    public String getContentType() {
        return this.contentType;
    }

    public RawHeaders getHeaders() {
        return this.headers;
    }

    public String getHost() {
        return this.host;
    }

    public String getIfModifiedSince() {
        return this.ifModifiedSince;
    }

    public String getIfNoneMatch() {
        return this.ifNoneMatch;
    }

    public int getMaxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public int getMaxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public int getMinFreshSeconds() {
        return this.minFreshSeconds;
    }

    public String getProxyAuthorization() {
        return this.proxyAuthorization;
    }

    public String getTransferEncoding() {
        return this.transferEncoding;
    }

    public Uri getUri() {
        return this.uri;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public boolean hasAuthorization() {
        return this.hasAuthorization;
    }

    public boolean hasConditions() {
        return (this.ifModifiedSince == null && this.ifNoneMatch == null) ? false : true;
    }

    public boolean hasConnectionClose() {
        return Close.ELEMENT.equalsIgnoreCase(this.connection);
    }

    public boolean isChunked() {
        return "chunked".equalsIgnoreCase(this.transferEncoding);
    }

    public boolean isNoCache() {
        return this.noCache;
    }

    public boolean isOnlyIfCached() {
        return this.onlyIfCached;
    }

    public void setAcceptEncoding(String str) {
        if (this.acceptEncoding != null) {
            this.headers.removeAll(HttpHeaders.ACCEPT_ENCODING);
        }
        this.headers.add(HttpHeaders.ACCEPT_ENCODING, str);
        this.acceptEncoding = str;
    }

    public void setChunked() {
        if (this.transferEncoding != null) {
            this.headers.removeAll(HttpHeaders.TRANSFER_ENCODING);
        }
        this.headers.add(HttpHeaders.TRANSFER_ENCODING, "chunked");
        this.transferEncoding = "chunked";
    }

    public void setConnection(String str) {
        if (this.connection != null) {
            this.headers.removeAll(HttpHeaders.CONNECTION);
        }
        this.headers.add(HttpHeaders.CONNECTION, str);
        this.connection = str;
    }

    public void setContentLength(int i) {
        if (this.contentLength != -1) {
            this.headers.removeAll(HttpHeaders.CONTENT_LENGTH);
        }
        if (i != -1) {
            this.headers.add(HttpHeaders.CONTENT_LENGTH, Integer.toString(i));
        }
        this.contentLength = i;
    }

    public void setContentType(String str) {
        if (this.contentType != null) {
            this.headers.removeAll("Content-Type");
        }
        this.headers.add("Content-Type", str);
        this.contentType = str;
    }

    public void setHost(String str) {
        if (this.host != null) {
            this.headers.removeAll(HttpHeaders.HOST);
        }
        this.headers.add(HttpHeaders.HOST, str);
        this.host = str;
    }

    public void setIfModifiedSince(Date date) {
        if (this.ifModifiedSince != null) {
            this.headers.removeAll(HttpHeaders.IF_MODIFIED_SINCE);
        }
        String str = HttpDate.format(date);
        this.headers.add(HttpHeaders.IF_MODIFIED_SINCE, str);
        this.ifModifiedSince = str;
    }

    public void setIfNoneMatch(String str) {
        if (this.ifNoneMatch != null) {
            this.headers.removeAll(HttpHeaders.IF_NONE_MATCH);
        }
        this.headers.add(HttpHeaders.IF_NONE_MATCH, str);
        this.ifNoneMatch = str;
    }

    public void setUserAgent(String str) {
        if (this.userAgent != null) {
            this.headers.removeAll("User-Agent");
        }
        this.headers.add("User-Agent", str);
        this.userAgent = str;
    }
}
