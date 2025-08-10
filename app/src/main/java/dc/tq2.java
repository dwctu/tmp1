package dc;

import android.app.Activity;
import android.content.Intent;

/* compiled from: TLoginMgr.java */
/* loaded from: classes3.dex */
public class tq2 {
    public static tq2 c;
    public rq2 a;
    public a b;

    /* compiled from: TLoginMgr.java */
    public enum a {
        Google
    }

    public static tq2 a() {
        if (c == null) {
            c = new tq2();
        }
        return c;
    }

    public final rq2 b(a aVar) {
        if (aVar == a.Google) {
            return new oq2();
        }
        return null;
    }

    public void c(Activity activity, a aVar, pq2 pq2Var) {
        if (this.a == null || this.b != aVar) {
            f();
            this.b = aVar;
            this.a = b(aVar);
        }
        rq2 rq2Var = this.a;
        if (rq2Var != null) {
            rq2Var.a(activity, pq2Var);
        }
    }

    public void d(Activity activity, qq2 qq2Var) {
        if (this.b == null) {
            this.b = a.Google;
        }
        rq2 rq2VarB = b(this.b);
        this.a = rq2VarB;
        if (rq2VarB != null) {
            rq2VarB.c(activity, qq2Var);
        }
    }

    public void e(int i, int i2, Intent intent) {
        rq2 rq2Var = this.a;
        if (rq2Var != null) {
            rq2Var.b(i, i2, intent);
        }
    }

    public void f() {
        rq2 rq2Var = this.a;
        if (rq2Var != null) {
            rq2Var.release();
            this.a = null;
        }
    }
}
