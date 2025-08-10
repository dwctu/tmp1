package dc;

import androidx.annotation.NonNull;

/* compiled from: BytesResource.java */
/* loaded from: classes.dex */
public class jm implements ti<byte[]> {
    public final byte[] a;

    public jm(byte[] bArr) {
        vp.d(bArr);
        this.a = bArr;
    }

    @Override // dc.ti
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public byte[] get() {
        return this.a;
    }

    @Override // dc.ti
    public int b() {
        return this.a.length;
    }

    @Override // dc.ti
    @NonNull
    public Class<byte[]> c() {
        return byte[].class;
    }

    @Override // dc.ti
    public void recycle() {
    }
}
