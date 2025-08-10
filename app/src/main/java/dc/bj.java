package dc;

import dc.kj;
import java.util.Queue;

/* compiled from: BaseKeyPool.java */
/* loaded from: classes.dex */
public abstract class bj<T extends kj> {
    public final Queue<T> a = wp.f(20);

    public abstract T a();

    public T b() {
        T tPoll = this.a.poll();
        return tPoll == null ? (T) a() : tPoll;
    }

    public void c(T t) {
        if (this.a.size() < 20) {
            this.a.offer(t);
        }
    }
}
