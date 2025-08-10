package dc;

/* compiled from: ScaleXY.java */
/* loaded from: classes.dex */
public class ld {
    public float a;
    public float b;

    public ld(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public boolean a(float f, float f2) {
        return this.a == f && this.b == f2;
    }

    public float b() {
        return this.a;
    }

    public float c() {
        return this.b;
    }

    public void d(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public String toString() {
        return b() + "x" + c();
    }

    public ld() {
        this(1.0f, 1.0f);
    }
}
