package dc;

/* compiled from: IntegerArrayAdapter.java */
/* loaded from: classes.dex */
public final class gj implements yi<int[]> {
    @Override // dc.yi
    public int a() {
        return 4;
    }

    @Override // dc.yi
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int b(int[] iArr) {
        return iArr.length;
    }

    @Override // dc.yi
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int[] newArray(int i) {
        return new int[i];
    }

    @Override // dc.yi
    public String getTag() {
        return "IntegerArrayPool";
    }
}
