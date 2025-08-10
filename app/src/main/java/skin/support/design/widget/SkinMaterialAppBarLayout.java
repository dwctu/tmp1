package skin.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.appbar.AppBarLayout;
import dc.aj4;
import dc.si4;

/* loaded from: classes5.dex */
public class SkinMaterialAppBarLayout extends AppBarLayout implements aj4 {
    public si4 a;

    public SkinMaterialAppBarLayout(Context context) {
        this(context, null);
    }

    @Override // dc.aj4
    public void P1() {
        si4 si4Var = this.a;
        if (si4Var != null) {
            si4Var.b();
        }
    }

    public SkinMaterialAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        si4 si4Var = new si4(this);
        this.a = si4Var;
        si4Var.c(attributeSet, 0);
    }
}
