package com.koushikdutta.async.http.server;

import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.Multimap;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;
import java.util.Map;
import java.util.regex.Matcher;

/* loaded from: classes3.dex */
public interface AsyncHttpServerRequest extends DataEmitter {
    String get(String str);

    <T extends AsyncHttpRequestBody> T getBody();

    Headers getHeaders();

    Matcher getMatcher();

    String getMethod();

    String getPath();

    Multimap getQuery();

    AsyncSocket getSocket();

    Map<String, Object> getState();

    String getUrl();

    void setMatcher(Matcher matcher);
}
