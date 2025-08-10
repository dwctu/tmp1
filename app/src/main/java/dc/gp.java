package dc;

import dc.hp;

/* compiled from: NoTransition.java */
/* loaded from: classes.dex */
public class gp<R> implements hp<R> {
    public static final gp<?> a = new gp<>();
    public static final ip<?> b = new a();

    /* compiled from: NoTransition.java */
    public static class a<R> implements ip<R> {
        @Override // dc.ip
        public hp<R> a(sg sgVar, boolean z) {
            return gp.a;
        }
    }

    public static <R> hp<R> b() {
        return a;
    }

    public static <R> ip<R> c() {
        return (ip<R>) b;
    }

    @Override // dc.hp
    public boolean a(Object obj, hp.a aVar) {
        return false;
    }
}
