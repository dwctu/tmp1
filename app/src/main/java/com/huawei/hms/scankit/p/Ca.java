package com.huawei.hms.scankit.p;

/* compiled from: DataMask.java */
/* loaded from: classes3.dex */
public enum Ca extends Ka {
    public Ca(String str, int i) {
        super(str, i, null);
    }

    @Override // com.huawei.hms.scankit.p.Ka
    public boolean a(int i, int i2) {
        return ((i + i2) & 1) == 0;
    }
}
