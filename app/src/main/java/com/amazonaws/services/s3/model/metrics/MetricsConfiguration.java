package com.amazonaws.services.s3.model.metrics;

import java.io.Serializable;

/* loaded from: classes.dex */
public class MetricsConfiguration implements Serializable {
    private MetricsFilter filter;
    private String id;

    public void a(MetricsFilter metricsFilter) {
        this.filter = metricsFilter;
    }

    public void b(String str) {
        this.id = str;
    }
}
