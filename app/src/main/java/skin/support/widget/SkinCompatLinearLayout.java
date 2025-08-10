package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import dc.aj4;
import dc.si4;
import dc.ui4;

/* loaded from: classes5.dex */
public class SkinCompatLinearLayout extends LinearLayout implements aj4 {
    public si4 a;
    public ui4 b;

    public SkinCompatLinearLayout(Context context) {
        this(context, null);
    }

    @Override // dc.aj4
    public void P1() {
        si4 si4Var = this.a;
        if (si4Var != null) {
            si4Var.b();
        }
        ui4 ui4Var = this.b;
        if (ui4Var != null) {
            ui4Var.b();
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

    public SkinCompatLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinCompatLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        si4 si4Var = new si4(this);
        this.a = si4Var;
        si4Var.c(attributeSet, i);
        ui4 ui4Var = new ui4(this);
        this.b = ui4Var;
        ui4Var.c(attributeSet, i);
    }
}
