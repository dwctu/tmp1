package com.huawei.hms.scankit.p;

/* compiled from: BarcodeRow.java */
/* loaded from: classes3.dex */
public final class zc {
    private final byte[] a;
    private int b = 0;

    public zc(int i) {
        this.a = new byte[i];
    }

    private void a(int i, boolean z) {
        try {
            if (!com.huawei.hms.scankit.util.b.a(this.a, i)) {
                throw new ArrayIndexOutOfBoundsException();
            }
            this.a[i] = z ? (byte) 1 : (byte) 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        }
    }

    public void a(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.b;
            this.b = i3 + 1;
            a(i3, z);
        }
    }

    public byte[] a(int i) {
        int length = this.a.length * i;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = this.a[i2 / i];
        }
        return bArr;
    }
}
