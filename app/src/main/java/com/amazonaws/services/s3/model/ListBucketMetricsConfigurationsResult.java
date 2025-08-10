package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.model.metrics.MetricsConfiguration;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class ListBucketMetricsConfigurationsResult implements Serializable {
    private String continuationToken;
    private boolean isTruncated;
    private List<MetricsConfiguration> metricsConfigurationList;
    private String nextContinuationToken;

    public List<MetricsConfiguration> a() {
        return this.metricsConfigurationList;
    }

    public void b(String str) {
        this.continuationToken = str;
    }

    public void c(List<MetricsConfiguration> list) {
        this.metricsConfigurationList = list;
    }

    public void d(String str) {
        this.nextContinuationToken = str;
    }

    public void e(boolean z) {
        this.isTruncated = z;
    }
}
