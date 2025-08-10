package dc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: TestResult.java */
/* loaded from: classes4.dex */
public class cy3 {
    public List<ay3> a = new ArrayList();
    public List<ay3> b = new ArrayList();
    public List<by3> c = new ArrayList();
    public int d = 0;
    public boolean e = false;

    /* compiled from: TestResult.java */
    public class a implements xx3 {
        public final /* synthetic */ zx3 a;

        public a(cy3 cy3Var, zx3 zx3Var) throws Throwable {
            this.a = zx3Var;
        }

        @Override // dc.xx3
        public void a() throws Throwable {
            this.a.g();
        }
    }

    public synchronized void a(yx3 yx3Var, Throwable th) {
        this.b.add(new ay3(yx3Var, th));
        Iterator<by3> it = d().iterator();
        while (it.hasNext()) {
            it.next().addError(yx3Var, th);
        }
    }

    public synchronized void b(yx3 yx3Var, wx3 wx3Var) {
        this.a.add(new ay3(yx3Var, wx3Var));
        Iterator<by3> it = d().iterator();
        while (it.hasNext()) {
            it.next().addFailure(yx3Var, wx3Var);
        }
    }

    public synchronized void c(by3 by3Var) {
        this.c.add(by3Var);
    }

    public final synchronized List<by3> d() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.c);
        return arrayList;
    }

    public void e(yx3 yx3Var) {
        Iterator<by3> it = d().iterator();
        while (it.hasNext()) {
            it.next().endTest(yx3Var);
        }
    }

    public void f(zx3 zx3Var) {
        i(zx3Var);
        g(zx3Var, new a(this, zx3Var));
        e(zx3Var);
    }

    public void g(yx3 yx3Var, xx3 xx3Var) {
        try {
            xx3Var.a();
        } catch (wx3 e) {
            b(yx3Var, e);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable th) {
            a(yx3Var, th);
        }
    }

    public synchronized boolean h() {
        return this.e;
    }

    public void i(yx3 yx3Var) {
        int iA = yx3Var.a();
        synchronized (this) {
            this.d += iA;
        }
        Iterator<by3> it = d().iterator();
        while (it.hasNext()) {
            it.next().startTest(yx3Var);
        }
    }
}
