package com.amazonaws;

import com.amazonaws.http.HttpMethodName;
import com.amazonaws.util.AWSRequestMetrics;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class DefaultRequest<T> implements Request<T> {
    public String a;
    public boolean b;
    public final Map<String, String> c;
    public final Map<String, String> d;
    public URI e;
    public String f;
    public final AmazonWebServiceRequest g;
    public HttpMethodName h;
    public InputStream i;
    public long j;
    public AWSRequestMetrics k;
    public String l;
    public String m;

    public DefaultRequest(AmazonWebServiceRequest amazonWebServiceRequest, String str) {
        this.b = false;
        this.c = new LinkedHashMap();
        this.d = new HashMap();
        this.h = HttpMethodName.POST;
        this.f = str;
        this.g = amazonWebServiceRequest;
    }

    @Override // com.amazonaws.Request
    public void a(InputStream inputStream) {
        this.i = inputStream;
    }

    @Override // com.amazonaws.Request
    @Deprecated
    public AWSRequestMetrics b() {
        return this.k;
    }

    @Override // com.amazonaws.Request
    public void c(String str) {
        this.a = str;
    }

    @Override // com.amazonaws.Request
    public String d() {
        return this.m;
    }

    @Override // com.amazonaws.Request
    public long e() {
        return this.j;
    }

    @Override // com.amazonaws.Request
    public void f(long j) {
        this.j = j;
    }

    @Override // com.amazonaws.Request
    public void g(String str, String str2) {
        this.c.put(str, str2);
    }

    @Override // com.amazonaws.Request
    public InputStream getContent() {
        return this.i;
    }

    @Override // com.amazonaws.Request
    public Map<String, String> getHeaders() {
        return this.d;
    }

    @Override // com.amazonaws.Request
    public Map<String, String> getParameters() {
        return this.c;
    }

    @Override // com.amazonaws.Request
    public String getServiceName() {
        return this.f;
    }

    @Override // com.amazonaws.Request
    @Deprecated
    public void h(AWSRequestMetrics aWSRequestMetrics) {
        if (this.k != null) {
            throw new IllegalStateException("AWSRequestMetrics has already been set on this request");
        }
        this.k = aWSRequestMetrics;
    }

    @Override // com.amazonaws.Request
    public void i(String str, String str2) {
        this.d.put(str, str2);
    }

    @Override // com.amazonaws.Request
    public void j(Map<String, String> map) {
        this.d.clear();
        this.d.putAll(map);
    }

    @Override // com.amazonaws.Request
    public String k() {
        return this.l;
    }

    @Override // com.amazonaws.Request
    public boolean l() {
        return this.b;
    }

    @Override // com.amazonaws.Request
    public AmazonWebServiceRequest m() {
        return this.g;
    }

    @Override // com.amazonaws.Request
    public HttpMethodName n() {
        return this.h;
    }

    @Override // com.amazonaws.Request
    public void o(boolean z) {
        this.b = z;
    }

    @Override // com.amazonaws.Request
    public void p(HttpMethodName httpMethodName) {
        this.h = httpMethodName;
    }

    @Override // com.amazonaws.Request
    public String q() {
        return this.a;
    }

    @Override // com.amazonaws.Request
    public void r(Map<String, String> map) {
        this.c.clear();
        this.c.putAll(map);
    }

    @Override // com.amazonaws.Request
    public URI s() {
        return this.e;
    }

    @Override // com.amazonaws.Request
    public void t(URI uri) {
        this.e = uri;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(n());
        sb.append(" ");
        sb.append(s());
        sb.append(" ");
        String strQ = q();
        if (strQ == null) {
            sb.append("/");
        } else {
            if (!strQ.startsWith("/")) {
                sb.append("/");
            }
            sb.append(strQ);
        }
        sb.append(" ");
        if (!getParameters().isEmpty()) {
            sb.append("Parameters: (");
            for (String str : getParameters().keySet()) {
                String str2 = getParameters().get(str);
                sb.append(str);
                sb.append(": ");
                sb.append(str2);
                sb.append(", ");
            }
            sb.append(") ");
        }
        if (!getHeaders().isEmpty()) {
            sb.append("Headers: (");
            for (String str3 : getHeaders().keySet()) {
                String str4 = getHeaders().get(str3);
                sb.append(str3);
                sb.append(": ");
                sb.append(str4);
                sb.append(", ");
            }
            sb.append(") ");
        }
        return sb.toString();
    }

    public DefaultRequest(String str) {
        this(null, str);
    }
}
