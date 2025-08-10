package dc;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: HyttoApi.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/component/dxhyttoutils/lib/api/HyttoApi;", "", "()V", "appActionEngine", "Lcom/component/dxhyttoutils/lib/listener/IHyttoAppActionEngine;", "getAppActionEngine", "()Lcom/component/dxhyttoutils/lib/listener/IHyttoAppActionEngine;", "setAppActionEngine", "(Lcom/component/dxhyttoutils/lib/listener/IHyttoAppActionEngine;)V", "appDataEngine", "Lcom/component/dxhyttoutils/lib/listener/IHyttoAppDataEngine;", "getAppDataEngine", "()Lcom/component/dxhyttoutils/lib/listener/IHyttoAppDataEngine;", "setAppDataEngine", "(Lcom/component/dxhyttoutils/lib/listener/IHyttoAppDataEngine;)V", "checkInit", "", "init", "hytto-apps.android.components.base:dxhyttoutils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class gz {

    @NotNull
    public static final gz a = new gz();
    public static mz b;
    public static nz c;

    @JvmStatic
    public static final void d(@NotNull mz appActionEngine, @NotNull nz appDataEngine) {
        Intrinsics.checkNotNullParameter(appActionEngine, "appActionEngine");
        Intrinsics.checkNotNullParameter(appDataEngine, "appDataEngine");
        gz gzVar = a;
        gzVar.e(appActionEngine);
        gzVar.f(appDataEngine);
    }

    public final void a() throws Exception {
        if (b == null || c == null) {
            throw new Exception("HyttoApi is not initialized");
        }
    }

    @NotNull
    public final mz b() {
        mz mzVar = b;
        if (mzVar != null) {
            return mzVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appActionEngine");
        return null;
    }

    @NotNull
    public final nz c() {
        nz nzVar = c;
        if (nzVar != null) {
            return nzVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appDataEngine");
        return null;
    }

    public final void e(@NotNull mz mzVar) {
        Intrinsics.checkNotNullParameter(mzVar, "<set-?>");
        b = mzVar;
    }

    public final void f(@NotNull nz nzVar) {
        Intrinsics.checkNotNullParameter(nzVar, "<set-?>");
        c = nzVar;
    }
}
