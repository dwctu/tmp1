package dagger.internal;

import dc.ox3;

/* loaded from: classes4.dex */
public final class SingleCheck<T> implements ox3<T> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile ox3<T> provider;

    private SingleCheck(ox3<T> ox3Var) {
        this.provider = ox3Var;
    }

    public static <P extends ox3<T>, T> ox3<T> provider(P p) {
        return ((p instanceof SingleCheck) || (p instanceof DoubleCheck)) ? p : new SingleCheck((ox3) Preconditions.checkNotNull(p));
    }

    @Override // dc.ox3
    public T get() {
        T t = (T) this.instance;
        if (t != UNINITIALIZED) {
            return t;
        }
        ox3<T> ox3Var = this.provider;
        if (ox3Var == null) {
            return (T) this.instance;
        }
        T t2 = ox3Var.get();
        this.instance = t2;
        this.provider = null;
        return t2;
    }
}
