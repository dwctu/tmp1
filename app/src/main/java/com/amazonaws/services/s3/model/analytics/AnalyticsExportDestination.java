package com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

/* loaded from: classes.dex */
public class AnalyticsExportDestination implements Serializable {
    private AnalyticsS3BucketDestination s3BucketDestination;

    public void a(AnalyticsS3BucketDestination analyticsS3BucketDestination) {
        this.s3BucketDestination = analyticsS3BucketDestination;
    }
}
