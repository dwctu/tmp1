package dc;

/* compiled from: GradientColor.java */
/* loaded from: classes.dex */
public class ga {
    public final float[] a;
    public final int[] b;

    public ga(float[] fArr, int[] iArr) {
        this.a = fArr;
        this.b = iArr;
    }

    public int[] a() {
        return this.b;
    }

    public float[] b() {
        return this.a;
    }

    public int c() {
        return this.b.length;
    }

    public void d(ga gaVar, ga gaVar2, float f) {
        if (gaVar.b.length == gaVar2.b.length) {
            for (int i = 0; i < gaVar.b.length; i++) {
                this.a[i] = gd.k(gaVar.a[i], gaVar2.a[i], f);
                this.b[i] = bd.c(f, gaVar.b[i], gaVar2.b[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + gaVar.b.length + " vs " + gaVar2.b.length + ")");
    }
}
