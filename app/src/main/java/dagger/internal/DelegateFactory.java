package dagger.internal;

import dc.ox3;

/* loaded from: classes4.dex */
public final class DelegateFactory<T> implements Factory<T> {
    private ox3<T> delegate;

    public static <T> void setDelegate(ox3<T> ox3Var, ox3<T> ox3Var2) {
        Preconditions.checkNotNull(ox3Var2);
        DelegateFactory delegateFactory = (DelegateFactory) ox3Var;
        if (delegateFactory.delegate != null) {
            throw new IllegalStateException();
        }
        delegateFactory.delegate = ox3Var2;
    }

    @Override // dagger.internal.Factory, dc.ox3
    public T get() {
        ox3<T> ox3Var = this.delegate;
        if (ox3Var != null) {
            return ox3Var.get();
        }
        throw new IllegalStateException();
    }

    public ox3<T> getDelegate() {
        return (ox3) Preconditions.checkNotNull(this.delegate);
    }

    @Deprecated
    public void setDelegatedProvider(ox3<T> ox3Var) {
        setDelegate(this, ox3Var);
    }
}
