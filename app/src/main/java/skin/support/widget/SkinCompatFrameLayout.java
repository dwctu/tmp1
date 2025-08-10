package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import dc.aj4;
import dc.si4;

/* loaded from: classes5.dex */
public class SkinCompatFrameLayout extends FrameLayout implements aj4 {
    public si4 a;

    public SkinCompatFrameLayout(Context context) {
        this(context, null);
    }

    @Override // dc.aj4
    public void P1() {
        si4 si4Var = this.a;
        if (si4Var != null) {
            si4Var.b();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        si4 si4Var = this.a;
        if (si4Var != null) {
            si4Var.d(i);
        }
    }

    public SkinCompatFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinCompatFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        si4 si4Var = new si4(this);
        this.a = si4Var;
        si4Var.c(attributeSet, i);
    }
}
