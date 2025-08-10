package com.amazonaws.services.s3.model.lifecycle;

import java.util.List;

/* loaded from: classes.dex */
public abstract class LifecycleNAryOperator extends LifecycleFilterPredicate {
    private final List<LifecycleFilterPredicate> operands;

    public LifecycleNAryOperator(List<LifecycleFilterPredicate> list) {
        this.operands = list;
    }
}
