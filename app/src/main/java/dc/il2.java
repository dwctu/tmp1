package dc;

import android.content.Context;
import dagger.internal.Preconditions;

/* compiled from: DaggerAppComponent.java */
/* loaded from: classes3.dex */
public final class il2 implements gl2 {
    public final ml2 a;

    /* compiled from: DaggerAppComponent.java */
    public static final class b {
        public ml2 a;

        public b a(ml2 ml2Var) {
            this.a = (ml2) Preconditions.checkNotNull(ml2Var);
            return this;
        }

        public gl2 b() {
            Preconditions.checkBuilderRequirement(this.a, ml2.class);
            return new il2(this.a);
        }

        public b() {
        }
    }

    public static b b() {
        return new b();
    }

    @Override // dc.gl2
    public Context a() {
        return nl2.a(this.a);
    }

    public il2(ml2 ml2Var) {
        this.a = ml2Var;
    }
}
