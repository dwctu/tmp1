package com.amazonaws.util;

import com.amazonaws.logging.LogFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class TimingInfoFullSupport extends TimingInfo {
    public final Map<String, List<TimingInfo>> c;
    public final Map<String, Number> d;

    public TimingInfoFullSupport(Long l, long j, Long l2) {
        super(l, j, l2);
        this.c = new HashMap();
        this.d = new HashMap();
    }

    @Override // com.amazonaws.util.TimingInfo
    public void a(String str, TimingInfo timingInfo) {
        List<TimingInfo> arrayList = this.c.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.c.put(str, arrayList);
        }
        if (timingInfo.k()) {
            arrayList.add(timingInfo);
            return;
        }
        LogFactory.b(TimingInfoFullSupport.class).a("Skip submeasurement timing info with no end time for " + str);
    }

    @Override // com.amazonaws.util.TimingInfo
    public Map<String, Number> d() {
        return this.d;
    }

    @Override // com.amazonaws.util.TimingInfo
    public Map<String, List<TimingInfo>> g() {
        return this.c;
    }

    @Override // com.amazonaws.util.TimingInfo
    public void j(String str) {
        l(str, (q(str) != null ? r0.intValue() : 0) + 1);
    }

    @Override // com.amazonaws.util.TimingInfo
    public void l(String str, long j) {
        this.d.put(str, Long.valueOf(j));
    }

    public Number q(String str) {
        return this.d.get(str);
    }
}
