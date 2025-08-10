package com.amazonaws.http;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* loaded from: classes.dex */
public class HttpResponse {
    public final String a;
    public final int b;
    public final InputStream c;
    public final Map<String, String> d;
    public InputStream e;

    public static class Builder {
        public String a;
        public int b;
        public InputStream c;
        public final Map<String, String> d = new HashMap();

        public HttpResponse a() {
            return new HttpResponse(this.a, this.b, Collections.unmodifiableMap(this.d), this.c);
        }

        public Builder b(InputStream inputStream) {
            this.c = inputStream;
            return this;
        }

        public Builder c(String str, String str2) {
            this.d.put(str, str2);
            return this;
        }

        public Builder d(int i) {
            this.b = i;
            return this;
        }

        public Builder e(String str) {
            this.a = str;
            return this;
        }
    }

    public static Builder a() {
        return new Builder();
    }

    public InputStream b() throws IOException {
        if (this.e == null) {
            synchronized (this) {
                if (this.c == null || !"gzip".equals(this.d.get(HttpHeaders.CONTENT_ENCODING))) {
                    this.e = this.c;
                } else {
                    this.e = new GZIPInputStream(this.c);
                }
            }
        }
        return this.e;
    }

    public Map<String, String> c() {
        return this.d;
    }

    public InputStream d() throws IOException {
        return this.c;
    }

    public int e() {
        return this.b;
    }

    public String f() {
        return this.a;
    }

    public HttpResponse(String str, int i, Map<String, String> map, InputStream inputStream) {
        this.a = str;
        this.b = i;
        this.d = map;
        this.c = inputStream;
    }
}
