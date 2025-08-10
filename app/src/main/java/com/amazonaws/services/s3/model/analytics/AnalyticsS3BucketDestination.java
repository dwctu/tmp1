package com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

/* loaded from: classes.dex */
public class AnalyticsS3BucketDestination implements Serializable {
    private String bucketAccountId;
    private String bucketArn;
    private String format;
    private String prefix;

    public void a(String str) {
        this.bucketAccountId = str;
    }

    public void b(String str) {
        this.bucketArn = str;
    }

    public void c(String str) {
        this.format = str;
    }

    public void d(String str) {
        this.prefix = str;
    }
}
