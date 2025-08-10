package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.services.s3.internal.ServerSideEncryptionResult;

/* loaded from: classes.dex */
public class ServerSideEncryptionHeaderHandler<T extends ServerSideEncryptionResult> implements HeaderHandler<T> {
    @Override // com.amazonaws.services.s3.internal.HeaderHandler
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(T t, HttpResponse httpResponse) {
        t.f(httpResponse.c().get("x-amz-server-side-encryption"));
        t.b(httpResponse.c().get("x-amz-server-side-encryption-customer-algorithm"));
        t.g(httpResponse.c().get("x-amz-server-side-encryption-customer-key-MD5"));
    }
}
