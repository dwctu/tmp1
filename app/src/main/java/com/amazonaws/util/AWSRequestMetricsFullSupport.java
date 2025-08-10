package com.amazonaws.util;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.MetricType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: classes.dex */
public class AWSRequestMetricsFullSupport extends AWSRequestMetrics {
    public static final Log d = LogFactory.c("com.amazonaws.latency");
    public static final Object e = "=";
    public static final Object f = ", ";
    public final Map<String, List<Object>> b;
    public final Map<String, TimingInfo> c;

    public AWSRequestMetricsFullSupport() {
        super(TimingInfo.n());
        this.b = new HashMap();
        this.c = new HashMap();
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void a(MetricType metricType, Object obj) {
        h(metricType.name(), obj);
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void b(MetricType metricType) {
        i(metricType.name());
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void d(MetricType metricType) {
        j(metricType.name());
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void e() {
        if (d.isInfoEnabled()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, List<Object>> entry : this.b.entrySet()) {
                k(entry.getKey(), entry.getValue(), sb);
            }
            for (Map.Entry<String, Number> entry2 : this.a.d().entrySet()) {
                k(entry2.getKey(), entry2.getValue(), sb);
            }
            for (Map.Entry<String, List<TimingInfo>> entry3 : this.a.g().entrySet()) {
                k(entry3.getKey(), entry3.getValue(), sb);
            }
            d.b(sb.toString());
        }
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void f(MetricType metricType, long j) {
        l(metricType.name(), j);
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void g(MetricType metricType) {
        m(metricType.name());
    }

    public void h(String str, Object obj) {
        List<Object> arrayList = this.b.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.b.put(str, arrayList);
        }
        arrayList.add(obj);
    }

    public void i(String str) {
        TimingInfo timingInfo = this.c.get(str);
        if (timingInfo != null) {
            timingInfo.c();
            this.a.a(str, TimingInfo.p(timingInfo.f(), Long.valueOf(timingInfo.e())));
            return;
        }
        LogFactory.b(AWSRequestMetricsFullSupport.class).g("Trying to end an event which was never started: " + str);
    }

    public void j(String str) {
        this.a.j(str);
    }

    public final void k(Object obj, Object obj2, StringBuilder sb) {
        sb.append(obj);
        sb.append(e);
        sb.append(obj2);
        sb.append(f);
    }

    public void l(String str, long j) {
        this.a.l(str, j);
    }

    public void m(String str) {
        this.c.put(str, TimingInfo.o(System.nanoTime()));
    }
}
