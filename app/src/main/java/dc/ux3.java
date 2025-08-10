package dc;

/* compiled from: TestDecorator.java */
/* loaded from: classes4.dex */
public class ux3 extends vx3 implements yx3 {
    public yx3 a;

    @Override // dc.yx3
    public int a() {
        return this.a.a();
    }

    @Override // dc.yx3
    public void b(cy3 cy3Var) {
        f(cy3Var);
    }

    public void f(cy3 cy3Var) {
        this.a.b(cy3Var);
    }

    public yx3 g() {
        return this.a;
    }

    public String toString() {
        return this.a.toString();
    }
}
