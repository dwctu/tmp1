package dc;

import androidx.core.util.Predicate;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class l1 implements Predicate {
    public final /* synthetic */ String a;

    @Override // androidx.core.util.Predicate
    public /* synthetic */ Predicate and(Predicate predicate) {
        return s2.$default$and(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public /* synthetic */ Predicate negate() {
        return s2.$default$negate(this);
    }

    @Override // androidx.core.util.Predicate
    public /* synthetic */ Predicate or(Predicate predicate) {
        return s2.$default$or(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        return this.a.equals((String) obj);
    }
}
