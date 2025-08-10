package com.koushikdutta.async.http;

import android.net.Uri;

/* loaded from: classes3.dex */
public class AsyncHttpHead extends AsyncHttpRequest {
    public static final String METHOD = "HEAD";

    public AsyncHttpHead(Uri uri) {
        super(uri, METHOD);
    }

    @Override // com.koushikdutta.async.http.AsyncHttpRequest
    public boolean hasBody() {
        return false;
    }
}
