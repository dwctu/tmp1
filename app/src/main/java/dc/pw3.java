package dc;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

/* compiled from: Emitter.java */
/* loaded from: classes4.dex */
public class pw3 {
    public ConcurrentMap<String, ConcurrentLinkedQueue<a>> a = new ConcurrentHashMap();

    /* compiled from: Emitter.java */
    public interface a {
        void call(Object... objArr);
    }

    /* compiled from: Emitter.java */
    public class b implements a {
        public final String a;
        public final a b;

        public b(String str, a aVar) {
            this.a = str;
            this.b = aVar;
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            pw3.this.e(this.a, this);
            this.b.call(objArr);
        }
    }

    public static boolean h(a aVar, a aVar2) {
        if (aVar.equals(aVar2)) {
            return true;
        }
        if (aVar2 instanceof b) {
            return aVar.equals(((b) aVar2).b);
        }
        return false;
    }

    public pw3 a(String str, Object... objArr) {
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = this.a.get(str);
        if (concurrentLinkedQueue != null) {
            Iterator<a> it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                a next = it.next();
                ej4.a("event:" + str + " " + next.getClass().getSimpleName());
                next.call(objArr);
            }
        }
        return this;
    }

    public boolean b(String str) {
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = this.a.get(str);
        return (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) ? false : true;
    }

    public pw3 c() {
        this.a.clear();
        return this;
    }

    public pw3 d(String str) {
        this.a.remove(str);
        return this;
    }

    public pw3 e(String str, a aVar) {
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = this.a.get(str);
        if (concurrentLinkedQueue != null) {
            Iterator<a> it = concurrentLinkedQueue.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (h(aVar, it.next())) {
                    it.remove();
                    break;
                }
            }
        }
        return this;
    }

    public pw3 f(String str, a aVar) {
        ConcurrentLinkedQueue<a> concurrentLinkedQueuePutIfAbsent;
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = this.a.get(str);
        if (concurrentLinkedQueue == null && (concurrentLinkedQueuePutIfAbsent = this.a.putIfAbsent(str, (concurrentLinkedQueue = new ConcurrentLinkedQueue<>()))) != null) {
            concurrentLinkedQueue = concurrentLinkedQueuePutIfAbsent;
        }
        concurrentLinkedQueue.add(aVar);
        return this;
    }

    public pw3 g(String str, a aVar) {
        f(str, new b(str, aVar));
        return this;
    }
}
