package com.koushikdutta.async.http;

import android.net.Uri;

/* loaded from: classes3.dex */
public class AsyncHttpDelete extends AsyncHttpRequest {
    public static final String METHOD = "DELETE";

    public AsyncHttpDelete(String str) {
        this(Uri.parse(str));
    }

    public AsyncHttpDelete(Uri uri) {
        super(uri, METHOD);
    }
}
