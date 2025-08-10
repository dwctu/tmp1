package com.amazonaws.services.s3.model.metrics;

import java.io.Serializable;

/* loaded from: classes.dex */
public class MetricsFilter implements Serializable {
    private MetricsFilterPredicate predicate;

    public void a(MetricsFilterPredicate metricsFilterPredicate) {
        this.predicate = metricsFilterPredicate;
    }
}
