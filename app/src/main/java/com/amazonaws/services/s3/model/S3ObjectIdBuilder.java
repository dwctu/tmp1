package com.amazonaws.services.s3.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class S3ObjectIdBuilder implements Serializable {
    private String bucket;
    private String key;
    private String versionId;

    public String a() {
        return this.bucket;
    }

    public String b() {
        return this.key;
    }

    public String c() {
        return this.versionId;
    }

    public void d(String str) {
        this.bucket = str;
    }

    public void e(String str) {
        this.key = str;
    }

    public void f(String str) {
        this.versionId = str;
    }
}
