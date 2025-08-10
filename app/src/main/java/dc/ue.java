package dc;

/* compiled from: NumericWheelAdapter.java */
/* loaded from: classes.dex */
public class ue implements ve {
    public int a;
    public int b;

    public ue(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // dc.ve
    public int a() {
        return (this.b - this.a) + 1;
    }

    @Override // dc.ve
    public Object getItem(int i) {
        if (i < 0 || i >= a()) {
            return 0;
        }
        return Integer.valueOf(this.a + i);
    }

    @Override // dc.ve
    public int indexOf(Object obj) {
        try {
            return ((Integer) obj).intValue() - this.a;
        } catch (Exception unused) {
            return -1;
        }
    }
}
