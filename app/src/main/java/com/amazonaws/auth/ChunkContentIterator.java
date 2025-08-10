package com.amazonaws.auth;

/* loaded from: classes.dex */
public class ChunkContentIterator {
    public final byte[] a;
    public int b;

    public ChunkContentIterator(byte[] bArr) {
        this.a = bArr;
    }

    public boolean a() {
        return this.b < this.a.length;
    }

    public int b(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (!a()) {
            return -1;
        }
        int iMin = Math.min(this.a.length - this.b, i2);
        System.arraycopy(this.a, this.b, bArr, i, iMin);
        this.b += iMin;
        return iMin;
    }
}
