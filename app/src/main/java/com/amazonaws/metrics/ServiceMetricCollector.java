package com.amazonaws.metrics;

/* loaded from: classes.dex */
public abstract class ServiceMetricCollector {
    public static final ServiceMetricCollector a = new ServiceMetricCollector() { // from class: com.amazonaws.metrics.ServiceMetricCollector.1
        @Override // com.amazonaws.metrics.ServiceMetricCollector
        public void a(ByteThroughputProvider byteThroughputProvider) {
        }
    };

    public abstract void a(ByteThroughputProvider byteThroughputProvider);
}
