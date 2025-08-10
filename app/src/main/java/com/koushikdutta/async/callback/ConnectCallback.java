package com.koushikdutta.async.callback;

import com.koushikdutta.async.AsyncSocket;

/* loaded from: classes3.dex */
public interface ConnectCallback {
    void onConnectCompleted(Exception exc, AsyncSocket asyncSocket);
}
