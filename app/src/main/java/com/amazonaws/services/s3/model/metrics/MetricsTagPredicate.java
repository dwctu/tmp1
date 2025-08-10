package com.amazonaws.services.s3.model.metrics;

import com.amazonaws.services.s3.model.Tag;

/* loaded from: classes.dex */
public final class MetricsTagPredicate extends MetricsFilterPredicate {
    private final Tag tag;

    public MetricsTagPredicate(Tag tag) {
        this.tag = tag;
    }
}
