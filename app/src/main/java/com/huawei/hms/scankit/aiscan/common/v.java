package com.huawei.hms.scankit.aiscan.common;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ReedSolomonEncoder.java */
/* loaded from: classes3.dex */
public final class v {
    private final h a;
    private final List<i> b;

    public v(h hVar) {
        this.a = hVar;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(new i(hVar, new int[]{1}));
    }

    private i a(int i) throws Exception {
        if (i >= this.b.size()) {
            List<i> list = this.b;
            i iVarC = list.get(list.size() - 1);
            for (int size = this.b.size(); size <= i; size++) {
                h hVar = this.a;
                iVarC = iVarC.c(new i(hVar, new int[]{1, hVar.a((size - 1) + hVar.a())}));
                this.b.add(iVarC);
            }
        }
        return this.b.get(i);
    }

    public void a(int[] iArr, int i) throws Exception {
        if (i != 0) {
            int length = iArr.length - i;
            if (length > 0) {
                i iVarA = a(i);
                int[] iArr2 = new int[length];
                System.arraycopy(iArr, 0, iArr2, 0, length);
                int[] iArrA = new i(this.a, iArr2).a(i, 1).b(iVarA)[1].a();
                int length2 = i - iArrA.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    iArr[length + i2] = 0;
                }
                System.arraycopy(iArrA, 0, iArr, length + length2, iArrA.length);
                return;
            }
            try {
                throw new IllegalArgumentException("No data bytes provided");
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            throw new IllegalArgumentException("No error correction bytes");
        } catch (Exception e2) {
            throw e2;
        }
    }
}
