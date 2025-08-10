package com.amazonaws.metrics;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ByteThroughputHelper extends ByteThroughputProvider {
    public ByteThroughputHelper(ThroughputMetricType throughputMetricType) {
        super(throughputMetricType);
    }

    @Override // com.amazonaws.metrics.ByteThroughputProvider
    public void d(int i, long j) {
        super.d(i, j);
    }

    public void f() {
        if (a() > 0) {
            AwsSdkMetrics.getServiceMetricCollector().a(this);
            e();
        }
    }

    public long g() {
        if (TimeUnit.NANOSECONDS.toSeconds(b()) > 10) {
            f();
        }
        return System.nanoTime();
    }
}
