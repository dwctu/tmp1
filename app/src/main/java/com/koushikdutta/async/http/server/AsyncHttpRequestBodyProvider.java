package com.koushikdutta.async.http.server;

import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;

/* loaded from: classes3.dex */
public interface AsyncHttpRequestBodyProvider {
    AsyncHttpRequestBody getBody(Headers headers);
}
