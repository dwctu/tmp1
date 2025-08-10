package com.amazonaws;

import com.amazonaws.http.HttpMethodName;
import com.amazonaws.util.AWSRequestMetrics;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;

/* loaded from: classes.dex */
public interface Request<T> {
    void a(InputStream inputStream);

    AWSRequestMetrics b();

    @Deprecated
    void c(String str);

    String d();

    long e();

    void f(long j);

    void g(String str, String str2);

    InputStream getContent();

    Map<String, String> getHeaders();

    Map<String, String> getParameters();

    String getServiceName();

    void h(AWSRequestMetrics aWSRequestMetrics);

    void i(String str, String str2);

    void j(Map<String, String> map);

    String k();

    boolean l();

    AmazonWebServiceRequest m();

    HttpMethodName n();

    void o(boolean z);

    void p(HttpMethodName httpMethodName);

    @Deprecated
    String q();

    void r(Map<String, String> map);

    URI s();

    void t(URI uri);
}
