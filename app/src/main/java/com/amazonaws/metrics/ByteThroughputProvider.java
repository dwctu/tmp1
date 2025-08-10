package com.amazonaws.metrics;

/* loaded from: classes.dex */
public abstract class ByteThroughputProvider {
    public long a;
    public int b;
    public final ThroughputMetricType c;

    public ByteThroughputProvider(ThroughputMetricType throughputMetricType) {
        this.c = throughputMetricType;
    }

    public int a() {
        return this.b;
    }

    public long b() {
        return this.a;
    }

    public String c() {
        return super.toString();
    }

    public void d(int i, long j) {
        this.b += i;
        this.a += System.nanoTime() - j;
    }

    public void e() {
        this.b = 0;
        this.a = 0L;
    }

    public String toString() {
        return String.format("providerId=%s, throughputType=%s, byteCount=%d, duration=%d", c(), this.c, Integer.valueOf(this.b), Long.valueOf(this.a));
    }
}
