package com.koushikdutta.async.http.callback;

import com.koushikdutta.async.http.AsyncHttpResponse;

/* loaded from: classes3.dex */
public interface HttpConnectCallback {
    void onConnectCompleted(Exception exc, AsyncHttpResponse asyncHttpResponse);
}
