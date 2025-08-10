package dc;

/* compiled from: ByteArrayAdapter.java */
/* loaded from: classes.dex */
public final class ej implements yi<byte[]> {
    @Override // dc.yi
    public int a() {
        return 1;
    }

    @Override // dc.yi
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int b(byte[] bArr) {
        return bArr.length;
    }

    @Override // dc.yi
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public byte[] newArray(int i) {
        return new byte[i];
    }

    @Override // dc.yi
    public String getTag() {
        return "ByteArrayPool";
    }
}
