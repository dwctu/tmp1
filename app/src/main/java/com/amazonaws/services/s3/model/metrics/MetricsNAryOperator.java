package com.amazonaws.services.s3.model.metrics;

import java.util.List;

/* loaded from: classes.dex */
public abstract class MetricsNAryOperator extends MetricsFilterPredicate {
    private final List<MetricsFilterPredicate> operands;

    public MetricsNAryOperator(List<MetricsFilterPredicate> list) {
        this.operands = list;
    }
}
