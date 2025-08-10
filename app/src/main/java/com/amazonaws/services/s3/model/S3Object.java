package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;

/* loaded from: classes.dex */
public class S3Object implements Closeable, Serializable, S3RequesterChargedResult {
    public transient S3ObjectInputStream a;
    private boolean isRequesterCharged;
    private String redirectLocation;
    private Integer taggingCount;
    private String key = null;
    private String bucketName = null;
    private ObjectMetadata metadata = new ObjectMetadata();

    public void A(Integer num) {
        this.taggingCount = num;
    }

    public String b() {
        return this.key;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (f() != null) {
            f().close();
        }
    }

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public void e(boolean z) {
        this.isRequesterCharged = z;
    }

    public S3ObjectInputStream f() {
        return this.a;
    }

    public ObjectMetadata j() {
        return this.metadata;
    }

    public void m(String str) {
        this.bucketName = str;
    }

    public void p(String str) {
        this.key = str;
    }

    public void q(S3ObjectInputStream s3ObjectInputStream) {
        this.a = s3ObjectInputStream;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("S3Object [key=");
        sb.append(b());
        sb.append(",bucket=");
        String str = this.bucketName;
        if (str == null) {
            str = "<Unknown>";
        }
        sb.append(str);
        sb.append("]");
        return sb.toString();
    }

    public void x(String str) {
        this.redirectLocation = str;
    }
}
