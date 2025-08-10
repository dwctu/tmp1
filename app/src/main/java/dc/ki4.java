package dc;

import java.util.ArrayList;

/* compiled from: SkinObservable.java */
/* loaded from: classes5.dex */
public class ki4 {
    public final ArrayList<li4> a = new ArrayList<>();

    public synchronized void a(li4 li4Var) {
        if (li4Var == null) {
            throw new NullPointerException();
        }
        if (!this.a.contains(li4Var)) {
            this.a.add(li4Var);
        }
    }

    public synchronized void b(li4 li4Var) {
        this.a.remove(li4Var);
    }

    public void c() {
        d(null);
    }

    public void d(Object obj) {
        li4[] li4VarArr;
        synchronized (this) {
            ArrayList<li4> arrayList = this.a;
            li4VarArr = (li4[]) arrayList.toArray(new li4[arrayList.size()]);
        }
        for (int length = li4VarArr.length - 1; length >= 0; length--) {
            li4VarArr[length].a(this, obj);
        }
    }
}
