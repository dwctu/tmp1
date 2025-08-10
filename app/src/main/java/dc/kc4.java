package dc;

import dc.xc4;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;

/* compiled from: Dispatcher.java */
/* loaded from: classes5.dex */
public final class kc4 {
    public Runnable c;
    public ExecutorService d;
    public int a = 64;
    public int b = 5;
    public final Deque<xc4.a> e = new ArrayDeque();
    public final Deque<xc4.a> f = new ArrayDeque();
    public final Deque<xc4> g = new ArrayDeque();

    public synchronized void a() {
        Iterator<xc4.a> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().c().cancel();
        }
        Iterator<xc4.a> it2 = this.f.iterator();
        while (it2.hasNext()) {
            it2.next().c().cancel();
        }
        Iterator<xc4> it3 = this.g.iterator();
        while (it3.hasNext()) {
            it3.next().cancel();
        }
    }

    public void b(xc4.a aVar) {
        xc4.a aVarE;
        synchronized (this) {
            this.e.add(aVar);
            if (!aVar.c().d && (aVarE = e(aVar.d())) != null) {
                aVar.e(aVarE);
            }
        }
        i();
    }

    public synchronized void c(xc4 xc4Var) {
        this.g.add(xc4Var);
    }

    public synchronized ExecutorService d() {
        if (this.d == null) {
            this.d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
        }
        return this.d;
    }

    public final xc4.a e(String str) {
        for (xc4.a aVar : this.f) {
            if (aVar.d().equals(str)) {
                return aVar;
            }
        }
        for (xc4.a aVar2 : this.e) {
            if (aVar2.d().equals(str)) {
                return aVar2;
            }
        }
        return null;
    }

    public final <T> void f(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.c;
        }
        if (i() || runnable == null) {
            return;
        }
        runnable.run();
    }

    public void g(xc4.a aVar) {
        aVar.a().decrementAndGet();
        f(this.f, aVar);
    }

    public void h(xc4 xc4Var) {
        f(this.g, xc4Var);
    }

    public final boolean i() {
        int i;
        boolean z;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<xc4.a> it = this.e.iterator();
            while (it.hasNext()) {
                xc4.a next = it.next();
                if (this.f.size() >= this.a) {
                    break;
                }
                if (next.a().get() < this.b) {
                    it.remove();
                    next.a().incrementAndGet();
                    arrayList.add(next);
                    this.f.add(next);
                }
            }
            z = j() > 0;
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((xc4.a) arrayList.get(i)).b(d());
        }
        return z;
    }

    public synchronized int j() {
        return this.f.size() + this.g.size();
    }
}
