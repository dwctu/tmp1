package dc;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: DiskCacheWriteLocker.java */
/* loaded from: classes.dex */
public final class oj {
    public final Map<String, a> a = new HashMap();
    public final b b = new b();

    /* compiled from: DiskCacheWriteLocker.java */
    public static class a {
        public final Lock a = new ReentrantLock();
        public int b;
    }

    /* compiled from: DiskCacheWriteLocker.java */
    public static class b {
        public final Queue<a> a = new ArrayDeque();

        public a a() {
            a aVarPoll;
            synchronized (this.a) {
                aVarPoll = this.a.poll();
            }
            return aVarPoll == null ? new a() : aVarPoll;
        }

        public void b(a aVar) {
            synchronized (this.a) {
                if (this.a.size() < 10) {
                    this.a.offer(aVar);
                }
            }
        }
    }

    public void a(String str) {
        a aVarA;
        synchronized (this) {
            aVarA = this.a.get(str);
            if (aVarA == null) {
                aVarA = this.b.a();
                this.a.put(str, aVarA);
            }
            aVarA.b++;
        }
        aVarA.a.lock();
    }

    public void b(String str) {
        a aVar;
        synchronized (this) {
            a aVar2 = this.a.get(str);
            vp.d(aVar2);
            aVar = aVar2;
            int i = aVar.b;
            if (i < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.b);
            }
            int i2 = i - 1;
            aVar.b = i2;
            if (i2 == 0) {
                a aVarRemove = this.a.remove(str);
                if (!aVarRemove.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + aVarRemove + ", safeKey: " + str);
                }
                this.b.b(aVarRemove);
            }
        }
        aVar.a.unlock();
    }
}
