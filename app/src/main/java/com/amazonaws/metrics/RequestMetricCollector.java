package com.amazonaws.metrics;

import com.amazonaws.Request;
import com.amazonaws.Response;

/* loaded from: classes.dex */
public abstract class RequestMetricCollector {
    public static final RequestMetricCollector a = new RequestMetricCollector() { // from class: com.amazonaws.metrics.RequestMetricCollector.1
        @Override // com.amazonaws.metrics.RequestMetricCollector
        public void a(Request<?> request, Response<?> response) {
        }

        @Override // com.amazonaws.metrics.RequestMetricCollector
        public boolean b() {
            return false;
        }
    };

    public abstract void a(Request<?> request, Response<?> response);

    public abstract boolean b();
}
