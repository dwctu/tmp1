package skin.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import dc.aj4;
import dc.si4;

/* loaded from: classes5.dex */
public class SkinMaterialCoordinatorLayout extends CoordinatorLayout implements aj4 {
    public si4 a;

    public SkinMaterialCoordinatorLayout(Context context) {
        this(context, null);
    }

    @Override // dc.aj4
    public void P1() {
        si4 si4Var = this.a;
        if (si4Var != null) {
            si4Var.b();
        }
    }

    public SkinMaterialCoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinMaterialCoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        si4 si4Var = new si4(this);
        this.a = si4Var;
        si4Var.c(attributeSet, 0);
    }
}
