package dc;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TaskQueue.java */
/* loaded from: classes4.dex */
public class ek3 {
    public PriorityBlockingQueue<ck3> a;
    public dk3[] b;

    public ek3(int i) {
        new AtomicInteger();
        this.a = new PriorityBlockingQueue<>();
        this.b = new dk3[i];
    }

    public void a() {
        b();
        int i = 0;
        while (true) {
            dk3[] dk3VarArr = this.b;
            if (i >= dk3VarArr.length) {
                return;
            }
            dk3VarArr[i] = new dk3(this.a);
            this.b[i].start();
            i++;
        }
    }

    public void b() {
        dk3[] dk3VarArr = this.b;
        if (dk3VarArr != null) {
            for (dk3 dk3Var : dk3VarArr) {
                if (dk3Var != null) {
                    dk3Var.a();
                }
            }
        }
    }
}
