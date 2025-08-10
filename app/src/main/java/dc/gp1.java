package dc;

/* compiled from: RunablePoxy.java */
/* loaded from: classes3.dex */
public class gp1 implements Runnable {
    public Runnable a;
    public boolean b;
    public ip1 c;

    public gp1(Runnable runnable, ip1 ip1Var) {
        this.a = runnable;
        this.b = false;
        this.c = ip1Var;
    }

    public boolean a() {
        return this.b;
    }

    @Override // java.lang.Runnable
    public void run() {
        ip1 ip1Var = this.c;
        if (ip1Var != null) {
            ip1Var.d();
        }
        this.a.run();
    }

    public gp1(Runnable runnable, boolean z) {
        this.a = runnable;
        this.b = z;
    }
}
