package com.amazonaws.util;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class TimingInfo {
    public final long a;
    public Long b;

    public TimingInfo(Long l, long j, Long l2) {
        this.a = j;
        this.b = l2;
    }

    public static double b(long j, long j2) {
        return TimeUnit.NANOSECONDS.toMicros(j2 - j) / 1000.0d;
    }

    public static TimingInfo m() {
        return new TimingInfo(Long.valueOf(System.currentTimeMillis()), System.nanoTime(), null);
    }

    public static TimingInfo n() {
        return new TimingInfoFullSupport(Long.valueOf(System.currentTimeMillis()), System.nanoTime(), null);
    }

    public static TimingInfo o(long j) {
        return new TimingInfoFullSupport(null, j, null);
    }

    public static TimingInfo p(long j, Long l) {
        return new TimingInfoUnmodifiable(null, j, l);
    }

    public void a(String str, TimingInfo timingInfo) {
    }

    public TimingInfo c() {
        this.b = Long.valueOf(System.nanoTime());
        return this;
    }

    public Map<String, Number> d() {
        return Collections.emptyMap();
    }

    public final long e() {
        Long l = this.b;
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public final long f() {
        return this.a;
    }

    public Map<String, List<TimingInfo>> g() {
        return Collections.emptyMap();
    }

    @Deprecated
    public final double h() {
        Double dI = i();
        if (dI == null) {
            return -1.0d;
        }
        return dI.doubleValue();
    }

    public final Double i() {
        if (k()) {
            return Double.valueOf(b(this.a, this.b.longValue()));
        }
        return null;
    }

    public void j(String str) {
    }

    public final boolean k() {
        return this.b != null;
    }

    public void l(String str, long j) {
    }

    public final String toString() {
        return String.valueOf(h());
    }
}
