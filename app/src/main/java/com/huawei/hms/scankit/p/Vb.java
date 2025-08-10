package com.huawei.hms.scankit.p;

import kotlin.text.Typography;

/* compiled from: SimpleToken.java */
/* loaded from: classes3.dex */
public final class Vb extends Xb {
    private final short c;
    private final short d;

    public Vb(Xb xb, int i, int i2) {
        super(xb);
        this.c = (short) i;
        this.d = (short) i2;
    }

    @Override // com.huawei.hms.scankit.p.Xb
    public void a(C0413x c0413x, byte[] bArr) throws Exception {
        c0413x.a(this.c, this.d);
    }

    public String toString() {
        short s = this.c;
        int i = 1 << this.d;
        return Typography.less + Integer.toBinaryString((s & (i - 1)) | i | (1 << this.d)).substring(1) + Typography.greater;
    }
}
