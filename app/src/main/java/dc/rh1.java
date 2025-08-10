package dc;

import android.util.SparseArray;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MixTouch.kt */
/* loaded from: classes3.dex */
public final class rh1 {
    public final oh1 a;

    public rh1(@NotNull oh1 mixAnimPlugin) {
        Intrinsics.checkParameterIsNotNull(mixAnimPlugin, "mixAnimPlugin");
        this.a = mixAnimPlugin;
    }

    public final boolean a(int i, int i2, yg1 yg1Var) {
        return i >= yg1Var.c() && i <= yg1Var.c() + yg1Var.b() && i2 >= yg1Var.d() && i2 <= yg1Var.d() + yg1Var.a();
    }

    @Nullable
    public final sh1 b(@NotNull MotionEvent ev) {
        HashMap<String, th1> mapA;
        th1 th1Var;
        SparseArray<mh1> sparseArrayA;
        mh1 mh1Var;
        Intrinsics.checkParameterIsNotNull(ev, "ev");
        Pair<Integer, Integer> realSize = this.a.p().c().getRealSize();
        int iIntValue = realSize.component1().intValue();
        int iIntValue2 = realSize.component2().intValue();
        ng1 ng1VarB = this.a.p().d().b();
        if (ng1VarB != null) {
            int iJ = ng1VarB.j();
            ng1 ng1VarB2 = this.a.p().d().b();
            if (ng1VarB2 != null) {
                int iD = ng1VarB2.d();
                if (iIntValue != 0 && iIntValue2 != 0 && ev.getAction() == 1) {
                    float x = (ev.getX() * iJ) / iIntValue;
                    float y = (ev.getY() * iD) / iIntValue2;
                    lh1 lh1VarN = this.a.n();
                    ArrayList<kh1> arrayListB = (lh1VarN == null || (sparseArrayA = lh1VarN.a()) == null || (mh1Var = sparseArrayA.get(this.a.m())) == null) ? null : mh1Var.b();
                    if (arrayListB != null) {
                        for (kh1 kh1Var : arrayListB) {
                            uh1 uh1VarR = this.a.r();
                            if (uh1VarR != null && (mapA = uh1VarR.a()) != null && (th1Var = mapA.get(kh1Var.d())) != null) {
                                Intrinsics.checkExpressionValueIsNotNull(th1Var, "mixAnimPlugin.srcMap?.ma….srcId) ?: return@forEach");
                                if (a((int) x, (int) y, kh1Var.a())) {
                                    sh1 sh1Var = new sh1(th1Var);
                                    sh1Var.a(kh1Var.a());
                                    return sh1Var;
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
