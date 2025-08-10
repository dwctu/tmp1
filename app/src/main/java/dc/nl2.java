package dc;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* compiled from: AppModule_ProvideApplicationContextFactory.java */
/* loaded from: classes3.dex */
public final class nl2 implements Factory<Context> {
    public static Context a(ml2 ml2Var) {
        return (Context) Preconditions.checkNotNull(ml2Var.a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
