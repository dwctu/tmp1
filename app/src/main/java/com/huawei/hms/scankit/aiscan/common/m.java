package com.huawei.hms.scankit.aiscan.common;

import com.broadcom.bt.util.io.FilenameUtils;

/* compiled from: LuminanceSource.java */
/* loaded from: classes3.dex */
public abstract class m {
    private final int a;
    private final int b;

    public m(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final int a() {
        return this.b;
    }

    public abstract m a(int i, int i2, int i3, int i4);

    public abstract byte[] a(int i, byte[] bArr);

    public abstract m b(int i, int i2, int i3, int i4);

    public abstract byte[] b();

    public final int c() {
        return this.a;
    }

    public final String toString() {
        int i = this.a;
        byte[] bArrA = new byte[i];
        StringBuilder sb = new StringBuilder(this.b * (i + 1));
        for (int i2 = 0; i2 < this.b; i2++) {
            bArrA = a(i2, bArrA);
            for (int i3 = 0; i3 < this.a; i3++) {
                int i4 = bArrA[i3] & 255;
                sb.append(i4 < 64 ? '#' : i4 < 128 ? '+' : i4 < 192 ? FilenameUtils.EXTENSION_SEPARATOR : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
