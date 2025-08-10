package com.amazonaws.metrics;

/* loaded from: classes.dex */
public abstract class MetricCollector {
    public static final MetricCollector a = new MetricCollector() { // from class: com.amazonaws.metrics.MetricCollector.1
        @Override // com.amazonaws.metrics.MetricCollector
        public RequestMetricCollector a() {
            return RequestMetricCollector.a;
        }

        @Override // com.amazonaws.metrics.MetricCollector
        public ServiceMetricCollector b() {
            return ServiceMetricCollector.a;
        }

        @Override // com.amazonaws.metrics.MetricCollector
        public boolean c() {
            return false;
        }

        @Override // com.amazonaws.metrics.MetricCollector
        public boolean d() {
            return true;
        }
    };

    public interface Factory {
        MetricCollector getInstance();
    }

    public abstract RequestMetricCollector a();

    public abstract ServiceMetricCollector b();

    public abstract boolean c();

    public abstract boolean d();
}
