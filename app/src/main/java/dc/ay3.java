package dc;

/* compiled from: TestFailure.java */
/* loaded from: classes4.dex */
public class ay3 {
    public yx3 a;
    public Throwable b;

    public ay3(yx3 yx3Var, Throwable th) {
        this.a = yx3Var;
        this.b = th;
    }

    public String toString() {
        return this.a + ": " + this.b.getMessage();
    }
}
