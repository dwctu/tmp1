package com.huawei.hms.scankit.p;

import com.j256.ormlite.stmt.query.SimpleComparison;
import kotlin.text.Typography;

/* compiled from: BinaryShiftToken.java */
/* loaded from: classes3.dex */
public final class Sb extends Xb {
    private final short c;
    private final short d;

    public Sb(Xb xb, int i, int i2) {
        super(xb);
        this.c = (short) i;
        this.d = (short) i2;
    }

    @Override // com.huawei.hms.scankit.p.Xb
    public void a(C0413x c0413x, byte[] bArr) throws Exception {
        int i = 0;
        while (true) {
            short s = this.d;
            if (i >= s) {
                return;
            }
            if (i == 0 || (i == 31 && s <= 62)) {
                c0413x.a(31, 5);
                short s2 = this.d;
                if (s2 > 62) {
                    c0413x.a(s2 - 31, 16);
                } else if (i == 0) {
                    c0413x.a(Math.min((int) s2, 31), 5);
                } else {
                    c0413x.a(s2 - 31, 5);
                }
            }
            c0413x.a(bArr[this.c + i], 8);
            i++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SimpleComparison.LESS_THAN_OPERATION);
        sb.append((int) this.c);
        sb.append("::");
        sb.append((this.c + this.d) - 1);
        sb.append(Typography.greater);
        return sb.toString();
    }
}
