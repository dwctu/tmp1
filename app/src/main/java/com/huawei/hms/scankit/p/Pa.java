package com.huawei.hms.scankit.p;

/* compiled from: ErrorCorrectionLevel.java */
/* loaded from: classes3.dex */
public enum Pa {
    L(1),
    M(0),
    Q(3),
    H(2);

    private static final Pa[] e;
    private final int g;

    static {
        Pa pa = L;
        Pa pa2 = M;
        Pa pa3 = Q;
        e = new Pa[]{pa2, pa, H, pa3};
    }

    Pa(int i) {
        this.g = i;
    }

    public int a() {
        return this.g;
    }

    public static Pa a(int i) throws Exception {
        if (i >= 0) {
            Pa[] paArr = e;
            if (i < paArr.length) {
                return paArr[i];
            }
        }
        try {
            throw new IllegalArgumentException();
        } catch (Exception e2) {
            throw e2;
        }
    }
}
