package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ParticleProperties.java */
/* loaded from: classes3.dex */
public class Wc implements Vc {
    private List<Vc> a = new ArrayList();

    @Override // com.huawei.hms.scankit.p.Vc
    public void a(Pc pc) {
        Iterator<Vc> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(pc);
        }
    }

    public void a(Vc vc) {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.add(vc);
    }
}
