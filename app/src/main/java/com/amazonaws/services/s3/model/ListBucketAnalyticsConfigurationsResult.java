package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.model.analytics.AnalyticsConfiguration;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class ListBucketAnalyticsConfigurationsResult implements Serializable {
    private List<AnalyticsConfiguration> analyticsConfigurationList;
    private String continuationToken;
    private boolean isTruncated;
    private String nextContinuationToken;

    public List<AnalyticsConfiguration> a() {
        return this.analyticsConfigurationList;
    }

    public void b(List<AnalyticsConfiguration> list) {
        this.analyticsConfigurationList = list;
    }

    public void c(String str) {
        this.continuationToken = str;
    }

    public void d(String str) {
        this.nextContinuationToken = str;
    }

    public void e(boolean z) {
        this.isTruncated = z;
    }
}
