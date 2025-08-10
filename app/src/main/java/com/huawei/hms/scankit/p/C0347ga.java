package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BarcodeValue.java */
/* renamed from: com.huawei.hms.scankit.p.ga, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0347ga {
    private final Map<Integer, Integer> a = new HashMap();

    public void a(int i) {
        Integer num = this.a.get(Integer.valueOf(i));
        if (num == null) {
            num = 0;
        }
        this.a.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
    }

    public int[] a() {
        ArrayList arrayList = new ArrayList();
        int iIntValue = -1;
        for (Map.Entry<Integer, Integer> entry : this.a.entrySet()) {
            if (entry.getValue().intValue() > iIntValue) {
                iIntValue = entry.getValue().intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (entry.getValue().intValue() == iIntValue) {
                arrayList.add(entry.getKey());
            }
        }
        return C0398ta.a(arrayList);
    }
}
