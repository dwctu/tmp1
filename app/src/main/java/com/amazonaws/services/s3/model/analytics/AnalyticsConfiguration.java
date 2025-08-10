package com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

/* loaded from: classes.dex */
public class AnalyticsConfiguration implements Serializable {
    private AnalyticsFilter filter;
    private String id;
    private StorageClassAnalysis storageClassAnalysis;

    public void a(AnalyticsFilter analyticsFilter) {
        this.filter = analyticsFilter;
    }

    public void b(String str) {
        this.id = str;
    }

    public void c(StorageClassAnalysis storageClassAnalysis) {
        this.storageClassAnalysis = storageClassAnalysis;
    }
}
