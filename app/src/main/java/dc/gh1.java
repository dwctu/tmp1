package dc;

import android.view.MotionEvent;
import dc.wh1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: MaskAnimPlugin.kt */
/* loaded from: classes3.dex */
public final class gh1 implements wh1 {
    public ih1 a;
    public ng1 b;

    @NotNull
    public final pg1 c;

    public gh1(@NotNull pg1 player) {
        Intrinsics.checkParameterIsNotNull(player, "player");
        this.c = player;
    }

    @Override // dc.wh1
    public void a(int i) {
        ih1 ih1Var;
        if (this.c.k() && (this.c.d().b() instanceof ng1)) {
            ng1 ng1VarB = this.c.d().b();
            this.b = ng1VarB;
            if (ng1VarB == null || (ih1Var = this.a) == null) {
                return;
            }
            ih1Var.b(ng1VarB);
        }
    }

    @Override // dc.wh1
    public boolean b(@NotNull MotionEvent ev) {
        Intrinsics.checkParameterIsNotNull(ev, "ev");
        return wh1.a.b(this, ev);
    }

    @Override // dc.wh1
    public void c() {
        g();
    }

    @Override // dc.wh1
    public void d(int i) {
        wh1.a.a(this, i);
    }

    @Override // dc.wh1
    public void e() {
        xh1.c.d("AnimPlayer.MaskAnimPlugin", "mask render init");
        if (this.c.k()) {
            ih1 ih1Var = new ih1(this);
            this.a = ih1Var;
            if (ih1Var != null) {
                ih1Var.a(this.c.h());
            }
        }
    }

    @Override // dc.wh1
    public int f(@NotNull ng1 config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        return 0;
    }

    public final void g() {
        hh1 hh1VarF;
        ng1 ng1Var = this.b;
        if (ng1Var == null || (hh1VarF = ng1Var.f()) == null) {
            return;
        }
        hh1VarF.b();
        throw null;
    }

    @NotNull
    public final pg1 h() {
        return this.c;
    }

    @Override // dc.wh1
    public void onDestroy() {
        g();
    }
}
