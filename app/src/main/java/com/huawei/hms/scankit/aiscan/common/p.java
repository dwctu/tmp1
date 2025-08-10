package com.huawei.hms.scankit.aiscan.common;

import com.huawei.hms.scankit.p.L;

/* compiled from: Patch.java */
/* loaded from: classes3.dex */
public class p implements Comparable<p> {
    public L a;
    public int b;

    public p(L l, int i) {
        this.a = l;
        this.b = i;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(p pVar) {
        return Float.compare((-pVar.a.g()) + pVar.a.h(), (-this.a.g()) + this.a.h());
    }
}
