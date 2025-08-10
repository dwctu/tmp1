package com.amazonaws.services.s3.model.analytics;

import java.util.List;

/* loaded from: classes.dex */
public abstract class AnalyticsNAryOperator extends AnalyticsFilterPredicate {
    private final List<AnalyticsFilterPredicate> operands;

    public AnalyticsNAryOperator(List<AnalyticsFilterPredicate> list) {
        this.operands = list;
    }
}
