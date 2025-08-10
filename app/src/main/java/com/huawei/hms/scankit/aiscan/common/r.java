package com.huawei.hms.scankit.aiscan.common;

/* compiled from: PlanarYUVLuminanceSource.java */
/* loaded from: classes3.dex */
public final class r extends m {
    private final byte[] c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    public r(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z) throws Exception {
        super(i5, i6);
        if (i3 + i5 > i || i4 + i6 > i2) {
            try {
                throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
            } catch (Exception e) {
                throw e;
            }
        }
        this.c = bArr;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        if (z) {
            a(i5, i6);
        }
    }

    @Override // com.huawei.hms.scankit.aiscan.common.m
    public byte[] a(int i, byte[] bArr) throws Exception {
        if (i < 0 || i >= a()) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("Requested row is outside the image: ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
            } catch (Exception e) {
                throw e;
            }
        }
        int iC = c();
        if (bArr == null || bArr.length < iC) {
            bArr = new byte[iC];
        }
        System.arraycopy(this.c, ((i + this.g) * this.d) + this.f, bArr, 0, iC);
        return bArr;
    }

    @Override // com.huawei.hms.scankit.aiscan.common.m
    public byte[] b() {
        int iC = c();
        int iA = a();
        int i = this.d;
        if (iC == i && iA == this.e) {
            return this.c;
        }
        int i2 = iC * iA;
        byte[] bArr = new byte[i2];
        int i3 = (this.g * i) + this.f;
        if (iC == i) {
            try {
                System.arraycopy(this.c, i3, bArr, 0, i2);
                return bArr;
            } catch (ArrayIndexOutOfBoundsException | Exception unused) {
                return null;
            }
        }
        for (int i4 = 0; i4 < iA; i4++) {
            try {
                System.arraycopy(this.c, i3, bArr, i4 * iC, iC);
                i3 += this.d;
            } catch (ArrayIndexOutOfBoundsException | Exception unused2) {
                return null;
            }
        }
        return bArr;
    }

    @Override // com.huawei.hms.scankit.aiscan.common.m
    public m a(int i, int i2, int i3, int i4) {
        return new r(this.c, this.d, this.e, this.f + i, this.g + i2, i3, i4, false);
    }

    private void a(int i, int i2) {
        byte[] bArr = this.c;
        int i3 = (this.g * this.d) + this.f;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = (i / 2) + i3;
            int i6 = (i3 + i) - 1;
            int i7 = i3;
            while (i7 < i5) {
                if (com.huawei.hms.scankit.util.b.a(bArr, i7) && com.huawei.hms.scankit.util.b.a(bArr, i6)) {
                    byte b = bArr[i7];
                    bArr[i7] = bArr[i6];
                    bArr[i6] = b;
                }
                i7++;
                i6--;
            }
            i4++;
            i3 += this.d;
        }
    }

    @Override // com.huawei.hms.scankit.aiscan.common.m
    public m b(int i, int i2, int i3, int i4) {
        int i5 = this.e;
        int i6 = this.d;
        if (i5 > i6) {
            byte[] bArr = new byte[i * i2];
            for (int i7 = 0; i7 < this.e; i7++) {
                byte[] bArr2 = this.c;
                int i8 = this.d;
                System.arraycopy(bArr2, i7 * i8, bArr, (i7 * i) + i3, i8);
            }
            return new r(bArr, i, i2, this.f, this.g, i, i2, false);
        }
        byte[] bArr3 = new byte[i * i2];
        System.arraycopy(this.c, 0, bArr3, i4 * i, i5 * i6);
        int i9 = this.d;
        return new r(bArr3, i9, i2, this.f, this.g, i9, i2, false);
    }
}
