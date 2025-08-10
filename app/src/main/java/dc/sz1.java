package dc;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ControlCenterMs.java */
/* loaded from: classes3.dex */
public class sz1 {
    public static sz1 d;
    public Handler a = new Handler(Looper.getMainLooper());
    public int b = 0;
    public ArrayList<tz1> c = new ArrayList<>();

    public static sz1 d() {
        if (d == null) {
            synchronized (sz1.class) {
                if (d == null) {
                    d = new sz1();
                }
            }
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i() {
        synchronized (this.c) {
            d.b = 0;
            Iterator<tz1> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().recovery();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(int i) {
        synchronized (this.c) {
            Iterator<tz1> it = this.c.iterator();
            while (it.hasNext()) {
                tz1 next = it.next();
                next.pauseConnon(i);
                if (i >= next.getPriority()) {
                    next.stop(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(int i) {
        synchronized (this.c) {
            Iterator<tz1> it = this.c.iterator();
            while (it.hasNext()) {
                tz1 next = it.next();
                next.pauseConnon(i);
                if (i > next.getPriority()) {
                    next.stop(i);
                }
            }
        }
    }

    public boolean a(int i) {
        return this.b <= i;
    }

    public void b(int i) {
        this.b = (~i) & this.b;
    }

    public boolean c() {
        return g(0);
    }

    public int e() {
        return this.b;
    }

    public boolean f(int i) {
        return (this.b & i) == i;
    }

    public boolean g(int i) {
        return this.b == i;
    }

    public void n(tz1 tz1Var) {
        synchronized (this.c) {
            if (!this.c.contains(tz1Var)) {
                this.c.add(tz1Var);
            }
        }
    }

    public void o() {
        this.a.post(new Runnable() { // from class: dc.oz1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.i();
            }
        });
    }

    public final void p(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.a.post(runnable);
        } else {
            runnable.run();
        }
    }

    public boolean q(final int i) {
        if (!a(i)) {
            return false;
        }
        this.b = i;
        p(new Runnable() { // from class: dc.pz1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.k(i);
            }
        });
        return true;
    }

    public void r(final int i) {
        p(new Runnable() { // from class: dc.qz1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.m(i);
            }
        });
    }

    public void s(tz1 tz1Var) {
        synchronized (this.c) {
            tz1Var.recovery();
            this.c.remove(tz1Var);
        }
    }
}
