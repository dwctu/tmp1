package dc;

import android.opengl.GLES20;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskRender.kt */
/* loaded from: classes3.dex */
public final class ih1 {

    @Nullable
    public jh1 a;

    @NotNull
    public zh1 b;
    public zh1 c;
    public final gh1 d;

    public ih1(@NotNull gh1 maskAnimPlugin) {
        Intrinsics.checkParameterIsNotNull(maskAnimPlugin, "maskAnimPlugin");
        this.d = maskAnimPlugin;
        this.b = new zh1();
        this.c = new zh1();
    }

    public final void a(boolean z) {
        this.a = new jh1(z);
        GLES20.glDisable(2929);
    }

    public final void b(@NotNull ng1 config) {
        xg1 xg1VarL;
        hh1 hh1VarF;
        Intrinsics.checkParameterIsNotNull(config, "config");
        sg1 sg1VarE = this.d.h().e();
        if (sg1VarE == null || (xg1VarL = sg1VarE.l()) == null || xg1VarL.e() <= 0 || this.a == null || (hh1VarF = config.f()) == null) {
            return;
        }
        hh1VarF.a();
        throw null;
    }
}
