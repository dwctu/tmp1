package com.amazonaws.http;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringUtils;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes.dex */
public class HttpRequestFactory {
    public final void a(Map<String, String> map, Request<?> request, ExecutionContext executionContext, ClientConfiguration clientConfiguration) {
        URI uriS = request.s();
        String host = uriS.getHost();
        if (HttpUtils.e(uriS)) {
            host = host + SignatureImpl.INNER_SEP + uriS.getPort();
        }
        map.put(HttpHeaders.HOST, host);
        for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        if (map.get("Content-Type") == null || map.get("Content-Type").isEmpty()) {
            map.put("Content-Type", "application/x-www-form-urlencoded; charset=" + StringUtils.b("UTF-8"));
        }
        if (executionContext == null || executionContext.b() == null) {
            return;
        }
        map.put("User-Agent", c(clientConfiguration, executionContext.b()));
    }

    public HttpRequest b(Request<?> request, ClientConfiguration clientConfiguration, ExecutionContext executionContext) throws UnsupportedEncodingException {
        URI uriS = request.s();
        boolean z = true;
        String strC = request.d() != null ? HttpUtils.c(uriS.toString(), request.d()) : HttpUtils.b(uriS.toString(), request.q(), true);
        String strD = HttpUtils.d(request);
        HttpMethodName httpMethodNameN = request.n();
        boolean z2 = request.getContent() != null;
        HttpMethodName httpMethodName = HttpMethodName.POST;
        if ((httpMethodNameN == httpMethodName) && !z2) {
            z = false;
        }
        if (strD != null && z) {
            strC = strC + "?" + strD;
        }
        HashMap map = new HashMap();
        a(map, request, executionContext, clientConfiguration);
        InputStream content = request.getContent();
        HttpMethodName httpMethodName2 = HttpMethodName.PATCH;
        if (httpMethodNameN == httpMethodName2) {
            map.put("X-HTTP-Method-Override", httpMethodName2.toString());
            httpMethodNameN = httpMethodName;
        }
        if (httpMethodNameN == httpMethodName && request.getContent() == null && strD != null) {
            byte[] bytes = strD.getBytes(StringUtils.a);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            map.put(HttpHeaders.CONTENT_LENGTH, String.valueOf(bytes.length));
            content = byteArrayInputStream;
        }
        if (clientConfiguration.k() && map.get(HttpHeaders.ACCEPT_ENCODING) == null) {
            map.put(HttpHeaders.ACCEPT_ENCODING, "gzip");
        } else {
            map.put(HttpHeaders.ACCEPT_ENCODING, "identity");
        }
        HttpRequest httpRequest = new HttpRequest(httpMethodNameN.toString(), URI.create(strC), map, content);
        httpRequest.g(request.l());
        return httpRequest;
    }

    public final String c(ClientConfiguration clientConfiguration, String str) {
        if (clientConfiguration.h().contains(str)) {
            return clientConfiguration.h();
        }
        return clientConfiguration.h() + " " + str;
    }
}
