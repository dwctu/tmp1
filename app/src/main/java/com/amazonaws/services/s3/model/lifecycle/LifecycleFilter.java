package com.amazonaws.services.s3.model.lifecycle;

import java.io.Serializable;

/* loaded from: classes.dex */
public class LifecycleFilter implements Serializable {
    private LifecycleFilterPredicate predicate;

    public void a(LifecycleFilterPredicate lifecycleFilterPredicate) {
        this.predicate = lifecycleFilterPredicate;
    }
}
