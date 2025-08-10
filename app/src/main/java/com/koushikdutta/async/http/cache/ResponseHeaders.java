package com.koushikdutta.async.http.cache;

import android.net.Uri;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.http.HttpDate;
import com.koushikdutta.async.http.cache.HeaderParser;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;

/* loaded from: classes3.dex */
public final class ResponseHeaders {
    private static final String RECEIVED_MILLIS = "X-Android-Received-Millis";
    private static final String SENT_MILLIS = "X-Android-Sent-Millis";
    private int ageSeconds;
    private String connection;
    private String contentEncoding;
    private long contentLength;
    private String etag;
    private Date expires;
    private final RawHeaders headers;
    private boolean isPublic;
    private Date lastModified;
    private boolean mustRevalidate;
    private boolean noCache;
    private boolean noStore;
    private String proxyAuthenticate;
    private long receivedResponseMillis;
    private long sentRequestMillis;
    private Date servedDate;
    private String transferEncoding;
    private final Uri uri;
    private Set<String> varyFields;
    private String wwwAuthenticate;
    private int maxAgeSeconds = -1;
    private int sMaxAgeSeconds = -1;

    public ResponseHeaders(Uri uri, RawHeaders rawHeaders) {
        this.ageSeconds = -1;
        this.varyFields = Collections.emptySet();
        this.contentLength = -1L;
        this.uri = uri;
        this.headers = rawHeaders;
        HeaderParser.CacheControlHandler cacheControlHandler = new HeaderParser.CacheControlHandler() { // from class: com.koushikdutta.async.http.cache.ResponseHeaders.1
            @Override // com.koushikdutta.async.http.cache.HeaderParser.CacheControlHandler
            public void handle(String str, String str2) {
                if (str.equalsIgnoreCase("no-cache")) {
                    ResponseHeaders.this.noCache = true;
                    return;
                }
                if (str.equalsIgnoreCase("no-store")) {
                    ResponseHeaders.this.noStore = true;
                    return;
                }
                if (str.equalsIgnoreCase("max-age")) {
                    ResponseHeaders.this.maxAgeSeconds = HeaderParser.parseSeconds(str2);
                } else if (str.equalsIgnoreCase("s-maxage")) {
                    ResponseHeaders.this.sMaxAgeSeconds = HeaderParser.parseSeconds(str2);
                } else if (str.equalsIgnoreCase("public")) {
                    ResponseHeaders.this.isPublic = true;
                } else if (str.equalsIgnoreCase("must-revalidate")) {
                    ResponseHeaders.this.mustRevalidate = true;
                }
            }
        };
        for (int i = 0; i < rawHeaders.length(); i++) {
            String fieldName = rawHeaders.getFieldName(i);
            String value = rawHeaders.getValue(i);
            if (HttpHeaders.CACHE_CONTROL.equalsIgnoreCase(fieldName)) {
                HeaderParser.parseCacheControl(value, cacheControlHandler);
            } else if ("Date".equalsIgnoreCase(fieldName)) {
                this.servedDate = HttpDate.parse(value);
            } else if (HttpHeaders.EXPIRES.equalsIgnoreCase(fieldName)) {
                this.expires = HttpDate.parse(value);
            } else if (HttpHeaders.LAST_MODIFIED.equalsIgnoreCase(fieldName)) {
                this.lastModified = HttpDate.parse(value);
            } else if (HttpHeaders.ETAG.equalsIgnoreCase(fieldName)) {
                this.etag = value;
            } else if (HttpHeaders.PRAGMA.equalsIgnoreCase(fieldName)) {
                if (value.equalsIgnoreCase("no-cache")) {
                    this.noCache = true;
                }
            } else if (HttpHeaders.AGE.equalsIgnoreCase(fieldName)) {
                this.ageSeconds = HeaderParser.parseSeconds(value);
            } else if (HttpHeaders.VARY.equalsIgnoreCase(fieldName)) {
                if (this.varyFields.isEmpty()) {
                    this.varyFields = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : value.split(",")) {
                    this.varyFields.add(str.trim().toLowerCase(Locale.US));
                }
            } else if (HttpHeaders.CONTENT_ENCODING.equalsIgnoreCase(fieldName)) {
                this.contentEncoding = value;
            } else if (HttpHeaders.TRANSFER_ENCODING.equalsIgnoreCase(fieldName)) {
                this.transferEncoding = value;
            } else if (HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(fieldName)) {
                try {
                    this.contentLength = Long.parseLong(value);
                } catch (NumberFormatException unused) {
                }
            } else if (HttpHeaders.CONNECTION.equalsIgnoreCase(fieldName)) {
                this.connection = value;
            } else if (HttpHeaders.PROXY_AUTHENTICATE.equalsIgnoreCase(fieldName)) {
                this.proxyAuthenticate = value;
            } else if (HttpHeaders.WWW_AUTHENTICATE.equalsIgnoreCase(fieldName)) {
                this.wwwAuthenticate = value;
            } else if (SENT_MILLIS.equalsIgnoreCase(fieldName)) {
                this.sentRequestMillis = Long.parseLong(value);
            } else if (RECEIVED_MILLIS.equalsIgnoreCase(fieldName)) {
                this.receivedResponseMillis = Long.parseLong(value);
            }
        }
    }

    private long computeAge(long j) {
        Date date = this.servedDate;
        long jMax = date != null ? Math.max(0L, this.receivedResponseMillis - date.getTime()) : 0L;
        int i = this.ageSeconds;
        if (i != -1) {
            jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i));
        }
        long j2 = this.receivedResponseMillis;
        return jMax + (j2 - this.sentRequestMillis) + (j - j2);
    }

    private long computeFreshnessLifetime() {
        int i = this.maxAgeSeconds;
        if (i != -1) {
            return TimeUnit.SECONDS.toMillis(i);
        }
        if (this.expires != null) {
            Date date = this.servedDate;
            long time = this.expires.getTime() - (date != null ? date.getTime() : this.receivedResponseMillis);
            if (time > 0) {
                return time;
            }
            return 0L;
        }
        if (this.lastModified == null || this.uri.getEncodedQuery() != null) {
            return 0L;
        }
        Date date2 = this.servedDate;
        long time2 = (date2 != null ? date2.getTime() : this.sentRequestMillis) - this.lastModified.getTime();
        if (time2 > 0) {
            return time2 / 10;
        }
        return 0L;
    }

    private static boolean isEndToEnd(String str) {
        return (str.equalsIgnoreCase(HttpHeaders.CONNECTION) || str.equalsIgnoreCase("Keep-Alive") || str.equalsIgnoreCase(HttpHeaders.PROXY_AUTHENTICATE) || str.equalsIgnoreCase(HttpHeaders.PROXY_AUTHORIZATION) || str.equalsIgnoreCase(HttpHeaders.TE) || str.equalsIgnoreCase("Trailers") || str.equalsIgnoreCase(HttpHeaders.TRANSFER_ENCODING) || str.equalsIgnoreCase(HttpHeaders.UPGRADE)) ? false : true;
    }

    private boolean isFreshnessLifetimeHeuristic() {
        return this.maxAgeSeconds == -1 && this.expires == null;
    }

    public ResponseSource chooseResponseSource(long j, RequestHeaders requestHeaders) {
        if (!isCacheable(requestHeaders)) {
            return ResponseSource.NETWORK;
        }
        if (requestHeaders.isNoCache() || requestHeaders.hasConditions()) {
            return ResponseSource.NETWORK;
        }
        long jComputeAge = computeAge(j);
        long jComputeFreshnessLifetime = computeFreshnessLifetime();
        if (requestHeaders.getMaxAgeSeconds() != -1) {
            jComputeFreshnessLifetime = Math.min(jComputeFreshnessLifetime, TimeUnit.SECONDS.toMillis(requestHeaders.getMaxAgeSeconds()));
        }
        long millis = 0;
        long millis2 = requestHeaders.getMinFreshSeconds() != -1 ? TimeUnit.SECONDS.toMillis(requestHeaders.getMinFreshSeconds()) : 0L;
        if (!this.mustRevalidate && requestHeaders.getMaxStaleSeconds() != -1) {
            millis = TimeUnit.SECONDS.toMillis(requestHeaders.getMaxStaleSeconds());
        }
        if (!this.noCache) {
            long j2 = millis2 + jComputeAge;
            if (j2 < millis + jComputeFreshnessLifetime) {
                if (j2 >= jComputeFreshnessLifetime) {
                    this.headers.add(HttpHeaders.WARNING, "110 HttpURLConnection \"Response is stale\"");
                }
                if (jComputeAge > 86400000 && isFreshnessLifetimeHeuristic()) {
                    this.headers.add(HttpHeaders.WARNING, "113 HttpURLConnection \"Heuristic expiration\"");
                }
                return ResponseSource.CACHE;
            }
        }
        String str = this.etag;
        if (str != null) {
            requestHeaders.setIfNoneMatch(str);
        } else {
            Date date = this.lastModified;
            if (date != null) {
                requestHeaders.setIfModifiedSince(date);
            } else {
                Date date2 = this.servedDate;
                if (date2 != null) {
                    requestHeaders.setIfModifiedSince(date2);
                }
            }
        }
        return requestHeaders.hasConditions() ? ResponseSource.CONDITIONAL_CACHE : ResponseSource.NETWORK;
    }

    public ResponseHeaders combine(ResponseHeaders responseHeaders) {
        RawHeaders rawHeaders = new RawHeaders();
        for (int i = 0; i < this.headers.length(); i++) {
            String fieldName = this.headers.getFieldName(i);
            String value = this.headers.getValue(i);
            if ((!fieldName.equals(HttpHeaders.WARNING) || !value.startsWith("1")) && (!isEndToEnd(fieldName) || responseHeaders.headers.get(fieldName) == null)) {
                rawHeaders.add(fieldName, value);
            }
        }
        for (int i2 = 0; i2 < responseHeaders.headers.length(); i2++) {
            String fieldName2 = responseHeaders.headers.getFieldName(i2);
            if (isEndToEnd(fieldName2)) {
                rawHeaders.add(fieldName2, responseHeaders.headers.getValue(i2));
            }
        }
        return new ResponseHeaders(this.uri, rawHeaders);
    }

    public String getConnection() {
        return this.connection;
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public String getEtag() {
        return this.etag;
    }

    public Date getExpires() {
        return this.expires;
    }

    public RawHeaders getHeaders() {
        return this.headers;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public int getMaxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public String getProxyAuthenticate() {
        return this.proxyAuthenticate;
    }

    public int getSMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public Date getServedDate() {
        return this.servedDate;
    }

    public Uri getUri() {
        return this.uri;
    }

    public Set<String> getVaryFields() {
        return this.varyFields;
    }

    public String getWwwAuthenticate() {
        return this.wwwAuthenticate;
    }

    public boolean hasConnectionClose() {
        return Close.ELEMENT.equalsIgnoreCase(this.connection);
    }

    public boolean hasVaryAll() {
        return this.varyFields.contains("*");
    }

    public boolean isCacheable(RequestHeaders requestHeaders) {
        int responseCode = this.headers.getResponseCode();
        if (responseCode == 200 || responseCode == 203 || responseCode == 300 || responseCode == 301 || responseCode == 410) {
            return (!requestHeaders.hasAuthorization() || this.isPublic || this.mustRevalidate || this.sMaxAgeSeconds != -1) && !this.noStore;
        }
        return false;
    }

    public boolean isChunked() {
        return "chunked".equalsIgnoreCase(this.transferEncoding);
    }

    public boolean isContentEncodingGzip() {
        return "gzip".equalsIgnoreCase(this.contentEncoding);
    }

    public boolean isMustRevalidate() {
        return this.mustRevalidate;
    }

    public boolean isNoCache() {
        return this.noCache;
    }

    public boolean isNoStore() {
        return this.noStore;
    }

    public boolean isPublic() {
        return this.isPublic;
    }

    public void setLocalTimestamps(long j, long j2) {
        this.sentRequestMillis = j;
        this.headers.add(SENT_MILLIS, Long.toString(j));
        this.receivedResponseMillis = j2;
        this.headers.add(RECEIVED_MILLIS, Long.toString(j2));
    }

    public void stripContentEncoding() {
        this.contentEncoding = null;
        this.headers.removeAll(HttpHeaders.CONTENT_ENCODING);
    }

    public boolean validate(ResponseHeaders responseHeaders) {
        Date date;
        if (responseHeaders.headers.getResponseCode() == 304) {
            return true;
        }
        return (this.lastModified == null || (date = responseHeaders.lastModified) == null || date.getTime() >= this.lastModified.getTime()) ? false : true;
    }

    public boolean varyMatches(Map<String, List<String>> map, Map<String, List<String>> map2) {
        for (String str : this.varyFields) {
            if (!Objects.equal(map.get(str), map2.get(str))) {
                return false;
            }
        }
        return true;
    }
}
