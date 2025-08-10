package dc;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: DXRouter.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/component/dxrouter/DXRouter;", "", "()V", "init", "", "openDebug", "", "dxRouter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class zz {
    @JvmStatic
    public static final void a(boolean z) {
        if (gd0.i() && z) {
            de0.v(" ARouter open debug");
            pd.i();
            pd.h();
        }
        if (ve0.a() == null) {
            de0.l(" Utils.getApp is null");
        }
        pd.d(ve0.a());
    }
}
