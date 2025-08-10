package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ParticleAnimators.java */
/* loaded from: classes3.dex */
public class Uc implements Sc {
    private List<Sc> a = new ArrayList();

    @Override // com.huawei.hms.scankit.p.Sc
    public void a(Pc pc, long j) {
        Iterator<Sc> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(pc, j);
        }
    }

    public void a(Sc sc) {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.add(sc);
    }
}
