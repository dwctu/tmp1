package com.amazonaws.http;

import com.amazonaws.util.StringUtils;
import com.google.common.net.HttpHeaders;
import java.io.InputStream;
import java.net.URI;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public class HttpRequest {
    public final String a;
    public URI b;
    public final Map<String, String> c;
    public final InputStream d;
    public boolean e;

    public HttpRequest(String str, URI uri, Map<String, String> map, InputStream inputStream) {
        this.a = StringUtils.c(str);
        this.b = uri;
        this.c = map == null ? Collections.EMPTY_MAP : Collections.unmodifiableMap(map);
        this.d = inputStream;
    }

    public InputStream a() {
        return this.d;
    }

    public long b() {
        String str;
        Map<String, String> map = this.c;
        if (map == null || (str = map.get(HttpHeaders.CONTENT_LENGTH)) == null || str.isEmpty()) {
            return 0L;
        }
        return Long.valueOf(str).longValue();
    }

    public Map<String, String> c() {
        return this.c;
    }

    public String d() {
        return this.a;
    }

    public URI e() {
        return this.b;
    }

    public boolean f() {
        return this.e;
    }

    public void g(boolean z) {
        this.e = z;
    }
}
