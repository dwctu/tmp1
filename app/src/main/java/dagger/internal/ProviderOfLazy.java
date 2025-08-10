package dagger.internal;

import dagger.Lazy;
import dc.ox3;

/* loaded from: classes4.dex */
public final class ProviderOfLazy<T> implements ox3<Lazy<T>> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ox3<T> provider;

    private ProviderOfLazy(ox3<T> ox3Var) {
        this.provider = ox3Var;
    }

    public static <T> ox3<Lazy<T>> create(ox3<T> ox3Var) {
        return new ProviderOfLazy((ox3) Preconditions.checkNotNull(ox3Var));
    }

    @Override // dc.ox3
    public Lazy<T> get() {
        return DoubleCheck.lazy(this.provider);
    }
}
