package com.amazonaws;

/* loaded from: classes.dex */
public class AmazonWebServiceResponse<T> {
    public T a;
    public ResponseMetadata b;

    public String a() {
        ResponseMetadata responseMetadata = this.b;
        if (responseMetadata == null) {
            return null;
        }
        return responseMetadata.a();
    }

    public T b() {
        return this.a;
    }

    public void c(ResponseMetadata responseMetadata) {
        this.b = responseMetadata;
    }

    public void d(T t) {
        this.a = t;
    }
}
