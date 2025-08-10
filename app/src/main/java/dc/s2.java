package dc;

import android.annotation.SuppressLint;
import androidx.core.util.Predicate;
import java.util.Objects;

/* compiled from: Predicate.java */
/* loaded from: classes.dex */
public final /* synthetic */ class s2 {
    @SuppressLint({"MissingNullability"})
    public static Predicate $default$and(@SuppressLint({"MissingNullability"}) final Predicate _this, final Predicate predicate) {
        Objects.requireNonNull(predicate);
        return new Predicate() { // from class: dc.q2
            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate and(Predicate predicate2) {
                return s2.$default$and(this, predicate2);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate negate() {
                return s2.$default$negate(this);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate or(Predicate predicate2) {
                return s2.$default$or(this, predicate2);
            }

            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return s2.a(_this, predicate, obj);
            }
        };
    }

    @SuppressLint({"MissingNullability"})
    public static Predicate $default$negate(final Predicate _this) {
        return new Predicate() { // from class: dc.p2
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
                return s2.b(_this, obj);
            }
        };
    }

    @SuppressLint({"MissingNullability"})
    public static Predicate $default$or(@SuppressLint({"MissingNullability"}) final Predicate _this, final Predicate predicate) {
        Objects.requireNonNull(predicate);
        return new Predicate() { // from class: dc.r2
            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate and(Predicate predicate2) {
                return s2.$default$and(this, predicate2);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate negate() {
                return s2.$default$negate(this);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate or(Predicate predicate2) {
                return s2.$default$or(this, predicate2);
            }

            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return s2.c(_this, predicate, obj);
            }
        };
    }

    public static /* synthetic */ boolean a(Predicate predicate, Predicate predicate2, Object obj) {
        return predicate.test(obj) && predicate2.test(obj);
    }

    public static /* synthetic */ boolean b(Predicate predicate, Object obj) {
        return !predicate.test(obj);
    }

    public static /* synthetic */ boolean c(Predicate predicate, Predicate predicate2, Object obj) {
        return predicate.test(obj) || predicate2.test(obj);
    }
}
